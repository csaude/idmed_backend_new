package mz.org.csaude.idmed.controllers.stockAdjustment

import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockAdjustment.StockReferenceAdjustment
import mz.org.csaude.idmed.dtos.stockAdjustment.StockReferenceAdjustmentDTO
import mz.org.csaude.idmed.services.stockAdjustment.StockReferenceAdjustmentService

@Controller('/api/stockReferenceAdjustment')
@Transactional
class StockReferenceAdjustmentController {

    @Inject
    StockReferenceAdjustmentService stockReferenceAdjustmentService;

    @Get()
    List<StockReferenceAdjustmentDTO> getAll(){
        List<StockReferenceAdjustmentDTO> stocks =   stockReferenceAdjustmentService.findAllDTO()
        return stocks;
    }
    @Post()
    def save(@Body StockReferenceAdjustment stockReferenceAdjustment){
        return stockReferenceAdjustmentService.save(stockReferenceAdjustment)
    }

    @Patch()
    def update(@Body StockReferenceAdjustment stockReferenceAdjustment){
        return stockReferenceAdjustmentService.update(stockReferenceAdjustment)
    }

    @Delete()
    def delete(@Body String id){
        return stockReferenceAdjustmentService.delete(id)
    }
}
