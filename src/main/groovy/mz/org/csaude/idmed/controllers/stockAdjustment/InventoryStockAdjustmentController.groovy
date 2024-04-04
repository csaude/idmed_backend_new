package mz.org.csaude.idmed.controllers.stockAdjustment

import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockAdjustment.InventoryStockAdjustment
import mz.org.csaude.idmed.dtos.stockAdjustment.InventoryStockAdjustmentDTO
import mz.org.csaude.idmed.services.stockAdjustment.InventoryStockAdjustmentService

@Controller('/api/inventoryStockAdjustment')
@Transactional
class InventoryStockAdjustmentController {

    @Inject
    InventoryStockAdjustmentService inventoryStockAdjustmentService;


    @Get()
    List<InventoryStockAdjustmentDTO> getAll(){
        List<InventoryStockAdjustmentDTO> stocks =   inventoryStockAdjustmentService.findAllDTO()
        return stocks;
    }
    @Post()
    def save(@Body InventoryStockAdjustment stockAdjustment){
        return inventoryStockAdjustmentService.save(stockAdjustment)
    }

    @Patch()
    def update(@Body InventoryStockAdjustment stockAdjustment){
        return inventoryStockAdjustmentService.update(stockAdjustment)
    }

    @Delete()
    def delete(@Body String id){
        return inventoryStockAdjustmentService.delete(id)
    }
}
