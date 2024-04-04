package mz.org.csaude.idmed.controllers.stockDestrution

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.dtos.stockdestruction.DestroyedStockDTO
import mz.org.csaude.idmed.services.stockDestruction.DestroyedStockService

@Controller('/api/destroyedStock')
@Transactional
class DestroyedStockController {

    @Inject
    DestroyedStockService destroyedStockService

    @Get()
    List<DestroyedStockDTO> getAll() {
        List<DestroyedStockDTO> list =destroyedStockService.findAllDTO()
        return list;
    }


}
