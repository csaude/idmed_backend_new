package mz.org.csaude.idmed.services.stockAdjustment

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockAdjustment.StockDestructionAdjustment
import mz.org.csaude.idmed.domains.stockAdjustment.StockReferenceAdjustment
import mz.org.csaude.idmed.dtos.stockAdjustment.StockReferenceAdjustmentDTO
import mz.org.csaude.idmed.repositories.stockAdjustment.StockReferenceAdjustmentRepository

import java.util.stream.Collectors

@Singleton
class StockReferenceAdjustmentService {


    private final StockReferenceAdjustmentRepository stockReferenceAdjustmentRepository

    StockReferenceAdjustmentService(StockReferenceAdjustmentRepository stockReferenceAdjustmentRepository1) {
        this.stockReferenceAdjustmentRepository = stockReferenceAdjustmentRepository1
    }
    @Transactional
    List<StockReferenceAdjustmentDTO> findAllDTO(){
        List<StockReferenceAdjustment> adjs = stockReferenceAdjustmentRepository.findAll();
        List<StockReferenceAdjustmentDTO> list = adjs.stream()
                .map(StockReferenceAdjustmentDTO::new)
                .collect(Collectors.toList());
        return list;
    }
    @Transactional
    def save(StockReferenceAdjustment  stockReferenceAdjustment){
        return stockReferenceAdjustmentRepository.save(stockReferenceAdjustment);
    }
    @Transactional
    def update(StockDestructionAdjustment stockDestructionAdjustment){
        return stockReferenceAdjustmentRepository.update(stockDestructionAdjustment);
    }
    @Transactional
    def delete(String id){
        StockDestructionAdjustment adjust =stockReferenceAdjustmentRepository.findById(id)
        return stockReferenceAdjustmentRepository.delete(adjust);
    }
}
