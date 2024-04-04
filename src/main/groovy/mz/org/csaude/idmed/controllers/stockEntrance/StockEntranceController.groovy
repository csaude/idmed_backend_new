package mz.org.csaude.idmed.controllers.stockEntrance

import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockentrance.StockEntrance
import mz.org.csaude.idmed.dtos.stockentrance.StockEntranceDTO
import mz.org.csaude.idmed.services.stockEntrance.StockEntranceService

@Controller('/api/stockEntrance')
@Transactional
class StockEntranceController {

    @Inject
    StockEntranceService stockEntranceService;

    @Get()
    List<StockEntranceDTO> getAll(){
        List<StockEntranceDTO> entramces =   stockEntranceService.findAllDTO()
        return entramces;
    }
    @Post()
    def save(@Body StockEntrance stockEntrance){
       return stockEntranceService.save(stockEntrance)
    }
    @Patch()
    def update(@Body StockEntrance stockEntrance){
        return stockEntranceService.update(stockEntrance)
    }
    @Delete()
    def delete(@Body String id){
        return stockEntranceService.delete(id)
    }

    def getByClinicId(String clinicId, int offset, int max) {
        return stockEntranceService.getAllByClinicId(clinicId, offset, max)
    }
}
