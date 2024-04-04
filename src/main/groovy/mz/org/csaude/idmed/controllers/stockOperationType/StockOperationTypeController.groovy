package mz.org.csaude.idmed.controllers.stockOperationType


import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.dtos.stockOperationType.StockOperationTypeDTO
import mz.org.csaude.idmed.services.stockOperation.StockOperationTypeService

@Controller('/api/stockOperationType')
@Transactional
class StockOperationTypeController {

    @Inject
    StockOperationTypeService stockOperationTypeService

    @Get()
    List<StockOperationTypeDTO> getAll() {
        List<StockOperationTypeDTO> stockOperationList = stockOperationTypeService.findAllDTO()
        return stockOperationList;
    }

}
