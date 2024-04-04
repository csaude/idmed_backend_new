package mz.org.csaude.idmed.controllers.stockCenter

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.dtos.stockCenter.StockCenterDTO
import mz.org.csaude.idmed.services.stockCenter.StockCenterService

@Controller('/api/stockCenter')
@Transactional
class StockCenterController {

    @Inject
    StockCenterService stockCenterService

    @Get()
    List<StockCenterDTO> getAll() {
        List<StockCenterDTO> list = stockCenterService.findAllDTO()
        return list;
    }


}
