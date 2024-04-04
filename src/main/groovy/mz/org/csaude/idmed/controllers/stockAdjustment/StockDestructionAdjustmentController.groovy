package mz.org.csaude.idmed.controllers.stockAdjustment

import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockAdjustment.StockDestructionAdjustment
import mz.org.csaude.idmed.dtos.stockAdjustment.StockDestructionAdjustmentDTO
import mz.org.csaude.idmed.services.stockAdjustment.StockDestructionAdjustmentService

@Controller('/api/stockDestructionAdjustment')
@Transactional
class StockDestructionAdjustmentController {

    @Inject
    StockDestructionAdjustmentService stockDestructionAdjustmentService;
    @Get()
    List<StockDestructionAdjustmentDTO> getAll(){
        List<StockDestructionAdjustmentDTO> stocks =   stockDestructionAdjustmentService.findAllDTO()
        return stocks;
    }
    @Post()
    def save(@Body StockDestructionAdjustment stockDestructionAdjustment){
        return stockDestructionAdjustmentService.save(stockDestructionAdjustment)
    }

    @Patch()
    def update(@Body StockDestructionAdjustment stockDestructionAdjustment){
        return stockDestructionAdjustmentService.update(stockDestructionAdjustment)
    }

    @Delete()
    def delete(@Body String id){
        return stockDestructionAdjustmentService.delete(id)
    }
}
