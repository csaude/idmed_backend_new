package mz.org.csaude.idmed.controllers.stockRefered

import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockRefered.ReferedStockMoviment
import mz.org.csaude.idmed.dtos.stockRefered.ReferedStockMovimentDTO
import mz.org.csaude.idmed.services.stockRefered.ReferedStockMovimentService

@Controller('/api/referedStockMoviment')
@Transactional
class ReferedStockMovimentController {

    @Inject
    ReferedStockMovimentService referedStockMovimentService;

    @Get()
    List<ReferedStockMovimentDTO> getAll(){
        List<ReferedStockMovimentDTO> referedStockMovimentDTOList =   referedStockMovimentService.findAllDTO()
        return referedStockMovimentDTOList;
    }
    @Post()
    def save(@Body ReferedStockMoviment referedStockMoviment){
        return referedStockMovimentService.save(referedStockMoviment)
    }

    @Patch()
    def update(@Body ReferedStockMoviment referedStockMoviment){
        return referedStockMovimentService.update(referedStockMoviment)
    }

    @Delete()
    def delete(@Body String id){
        return referedStockMovimentService.delete(id)
    }
}
