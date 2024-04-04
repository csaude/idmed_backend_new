package mz.org.csaude.idmed.controllers.stock

import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stock.Stock
import mz.org.csaude.idmed.dtos.stock.StockDTO
import mz.org.csaude.idmed.services.stock.StockService

import java.time.LocalDate
import java.time.LocalDateTime

@Controller('/api/stock')
@Transactional
class StockController {

    @Inject
    StockService stockService;

    @Get('/getValidStockByDrugAndPickUpDate')
   def getValidStockByDrugAndPickUpDate(@PathVariable("idPackagedDrug") String idPackagedDrug,@PathVariable("packageDate") LocalDateTime packageDate){
        List<StockDTO> stocks =   stockService.findAllOnceReceivedByDrugDTO(idPackagedDrug,packageDate)
        return stocks;
    }

    @Get('/checkStockStatus/{idPrescribedDrug}/{prescriptionDate}/{qtyPrescribed}')
    def checkStockStatus(@PathVariable("idPrescribedDrug") String idPrescribedDrug, @PathVariable("prescriptionDate") LocalDate  prescriptionDate,@PathVariable("qtyPrescribed") int qtyPrescribed){
       def isValid =   stockService.checkStockStatus(idPrescribedDrug,prescriptionDate,qtyPrescribed)
        return isValid;
    }


    @Get('/getValidStocks/{idPrescribedDrug}/{dateToCompare}')
    def getValidStockByDrugAndPickUpDate( @PathVariable ("idPrescribedDrug") String idPrescribedDrug, @PathVariable ("dateToCompare")   LocalDate dateToCompare) {
        List<StockDTO> stocks =   stockService.getValidStock(idPrescribedDrug, dateToCompare)
        return stocks;
    }

    @Get()
    List<StockDTO> getAll(){
        List<StockDTO> stocks =   stockService.findAllDTO()
        return stocks;
    }
    @Post()
    def save(@Body Stock stock){
       return stockService.save(stock)
    }

    @Patch()
    def update(@Body Stock stock){
        return stockService.update(stock)
    }

    @Delete()
    def delete(@Body String id){
        return stockService.delete(id)
    }
}
