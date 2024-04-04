package mz.org.csaude.idmed.controllers.inventory

import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.inventory.Inventory
import mz.org.csaude.idmed.domains.stockAdjustment.InventoryStockAdjustment
import mz.org.csaude.idmed.dtos.inventory.InventoryDTO
import mz.org.csaude.idmed.services.inventory.InventoryService
import mz.org.csaude.idmed.services.stockAdjustment.InventoryStockAdjustmentService

@Controller('/api/inventory')
@Transactional
class InventoryController {

    @Inject
    InventoryService inventoryService;

    @Inject
    InventoryStockAdjustmentService inventoryStockAdjustmentService

    @Get()
    List<InventoryDTO> getAll() {
        List<InventoryDTO> inventoryDTOS = inventoryService.findAllDTO()
        return inventoryDTOS;
    }

    @Post()
    def save(@Body Inventory inventory) {
          return inventoryService.save(inventory)
    }

    @Patch()
    def update(@Body Inventory inventory) {
        return inventoryService.update(inventory)
    }

    @Delete()
    def delete(@Body String id) {
        return inventoryService.delete(id)
    }

    def close(@Body String id) {
        return inventoryService.close(id)
        List<InventoryStockAdjustment> adjustments = inventoryStockAdjustmentService.findAllByInventory(id)

    }

    def getByClinicId(@Body String clinicId, int offset, int max) {
        return inventoryService.getAllByClinicId(clinicId, offset, max)
    }

    def isInventoryPeriod(String clinicId) {
        return inventoryService.isInventoryPeriod(clinicId)
    }
}
