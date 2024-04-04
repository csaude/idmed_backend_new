package mz.org.csaude.idmed.services.stockAdjustment

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockAdjustment.InventoryStockAdjustment
import mz.org.csaude.idmed.dtos.stockAdjustment.InventoryStockAdjustmentDTO
import mz.org.csaude.idmed.repositories.stockAdjustment.InventoryStockAdjustmentRepository

import java.util.stream.Collectors

@Singleton
class InventoryStockAdjustmentService {

    private final InventoryStockAdjustmentRepository inventoryStockAdjustmentRepository

    InventoryStockAdjustmentService( InventoryStockAdjustmentRepository inventoryStockAdjustmentRepository1) {
        this.inventoryStockAdjustmentRepository = inventoryStockAdjustmentRepository1
    }
    def findAllByInventory(String  inventoryId) {
        return inventoryStockAdjustmentRepository.findByInventory(inventoryId)
    }

    def removeAdjustment(InventoryStockAdjustment adjustment) {
        inventoryStockAdjustmentRepository.delete(adjustment)
    }

    @Transactional
    List<InventoryStockAdjustmentDTO> findAllDTO(){
        List<InventoryStockAdjustment> adjs = inventoryStockAdjustmentRepository.findAll();
        List<InventoryStockAdjustmentDTO> list = adjs.stream()
                .map(InventoryStockAdjustmentDTO::new)
                .collect(Collectors.toList());
        return list;
    }

    @Transactional
    InventoryStockAdjustment save(InventoryStockAdjustment inventoryStockAdjustment){
        return inventoryStockAdjustmentRepository.save(inventoryStockAdjustment);
    }
    @Transactional
    InventoryStockAdjustment update(InventoryStockAdjustment inventoryStockAdjustment){
        return inventoryStockAdjustmentRepository.update(inventoryStockAdjustment);
    }

    @Transactional
    def delete(String id){
        InventoryStockAdjustment  adjust =inventoryStockAdjustmentRepository.findById(id)
        return inventoryStockAdjustmentRepository.delete(adjust);
    }


}
