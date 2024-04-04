package mz.org.csaude.idmed.services.inventory

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import jakarta.validation.ValidationException
import mz.org.csaude.idmed.domains.drug.Drug
import mz.org.csaude.idmed.domains.inventory.Inventory
import mz.org.csaude.idmed.domains.stock.Stock
import mz.org.csaude.idmed.domains.stockAdjustment.InventoryStockAdjustment
import mz.org.csaude.idmed.domains.stockAdjustment.StockAdjustment
import mz.org.csaude.idmed.dtos.inventory.InventoryDTO
import mz.org.csaude.idmed.repositories.inventory.InventoryRepository
import mz.org.csaude.idmed.services.clinic.ClinicService
import mz.org.csaude.idmed.services.stock.StockService
import mz.org.csaude.idmed.services.stockAdjustment.InventoryStockAdjustmentService

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.stream.Collectors

@Singleton
class InventoryService {

    private final InventoryRepository inventoryRepository
    private final StockService stockService
    private final ClinicService clinicService
    private final InventoryStockAdjustmentService inventoryStockAdjustmentService

    InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository
    }

    void processInventoryAdjustments(Inventory inventory) {
        for (StockAdjustment adjustment : inventory.getAdjustments()) {
            adjustment.setFinalised(true)
        }
    }

    void initInventory(Inventory inventory) {
        List<Stock> drugStocks = new ArrayList<>()
        for (Drug drug : inventory.getInventoryDrugs()) {
            drugStocks.addAll(stockService.findAllOnceReceivedByDrug(drug))
        }
        initInventoryAdjustments(inventory, drugStocks)
    }


    private static void initInventoryAdjustments(Inventory inventory, List<Stock> stocks) {
        List<InventoryStockAdjustment> adjustments = new ArrayList<>()
        for (Stock stock : stocks) {
            adjustments.add(initAdjustment(inventory, stock))
        }
        inventory.setAdjustments(adjustments as Set<InventoryStockAdjustment>)
    }

    private static InventoryStockAdjustment initAdjustment(Inventory inventory, Stock stock) {
        StockAdjustment adjustment = new InventoryStockAdjustment(inventory, stock)
        return adjustment
    }

    List<Inventory> getAllByClinicId(String clinicId, int offset, int max) {
        // Clinic clinic = clinicService.findById(clinicId)
        return inventoryRepository.getAllByClinicId(clinicId, [offset: offset, max: max])
    }

    Inventory removeInventory(String id) {
        for (InventoryStockAdjustment adj : inventoryStockAdjustmentService.findAllByInventory(id)) {
            0
            inventoryStockAdjustmentService.removeAdjustment(adj)
        }
        Inventory inventory = inventoryRepository.findById(id)
        return inventoryRepository.delete(inventory)
    }

    boolean isInventoryPeriod(String clinicId) {
        List<Inventory> inventories = inventoryRepository.getClosedInventories(clinicId)
        if (inventories.size() > 0) {
            Inventory inventory = inventories.first()
            int differenceInDays = LocalDate.now().minus(inventory.endDate)
            return differenceInDays > 28
        } else {
            return true
        }
    }

    def close(String id) {
        Inventory inventory = inventoryRepository.findById(id)
        List<InventoryStockAdjustment> adjustments = inventoryStockAdjustmentService.findAllByInventory(id)
        if (adjustments.isEmpty()) {
            throw new RuntimeException("Não foram carregados os ajustes deste inventário, impossivel fechar!")
        } else {
            try {
                inventory.close();
                inventory.setEndDate(LocalDateTime.now())
                this.processInventoryAdjustments(inventory)
                this.save(inventory)
            } catch (ValidationException e) {
                return e
            }
        }
    }


    @Transactional
    List<InventoryDTO> findAllDTO() {
        List<Inventory> inventories = inventoryRepository.findAll();
        List<InventoryDTO> inventoryDTOList = inventories.stream()
                .map(InventoryDTO::new)
                .collect(Collectors.toList());
        return inventoryDTOList;
    }

    @Transactional
    Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Transactional
    Inventory update(Inventory inventory) {
        return inventoryRepository.update(inventory);
    }

    @Transactional
    def delete(String idInventory) {
        Inventory inventory = inventoryRepository.findById(idInventory)
        return inventoryRepository.delete(inventory);
    }

    def getByClinicId(String clinicId, int offset, int max) {
        return inventoryRepository.getAllByClinicId(clinicId, offset, max)
    }

    def findById(String idInventory) {
        return inventoryRepository.findById(idInventory)
    }


}
