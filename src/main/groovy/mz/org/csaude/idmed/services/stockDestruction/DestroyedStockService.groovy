package mz.org.csaude.idmed.services.stockDestruction

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockdestruction.DestroyedStock
import mz.org.csaude.idmed.dtos.stockdestruction.DestroyedStockDTO
import mz.org.csaude.idmed.repositories.stockDestruction.DestroyedStockRepository

import java.util.stream.Collectors

@Singleton
class DestroyedStockService {

    private final DestroyedStockRepository destroyedStockRepository
    DestroyedStockService(DestroyedStockRepository  destroyedStockRepository) {
        this.destroyedStockRepository = destroyedStockRepository
    }

    @Transactional
    List<DestroyedStockDTO> findAllDTO(){
        List<DestroyedStock> adjs = destroyedStockRepository.findAll();
        List<DestroyedStockDTO> list = adjs.stream()
                .map(DestroyedStockDTO::new)
                .collect(Collectors.toList());
        return list;
    }
    @Transactional
    def save(DestroyedStock  destroyedStock){
        return destroyedStockRepository.save(destroyedStock);
    }
    @Transactional
    def update(DestroyedStock destroyedStock){
        return destroyedStockRepository.update(destroyedStock);
    }
    @Transactional
    def delete(String id){
        DestroyedStock adjust =destroyedStockRepository.findById(id)
        return destroyedStockRepository.delete(adjust);
    }
}
