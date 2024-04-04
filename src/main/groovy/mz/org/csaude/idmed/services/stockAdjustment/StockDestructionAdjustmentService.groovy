package mz.org.csaude.idmed.services.stockAdjustment

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockAdjustment.StockDestructionAdjustment
import mz.org.csaude.idmed.dtos.stockAdjustment.StockDestructionAdjustmentDTO
import mz.org.csaude.idmed.repositories.stockAdjustment.StockDestructionAdjustmentRepository

import java.util.stream.Collectors

@Singleton
class StockDestructionAdjustmentService {

    private final StockDestructionAdjustmentRepository stockDestructionAdjustmentRepository

    StockDestructionAdjustmentService(StockDestructionAdjustmentRepository stockDestructionAdjustmentRepository1) {
        this.stockDestructionAdjustmentRepository = stockDestructionAdjustmentRepository1
    }

    @Transactional
    List<StockDestructionAdjustmentDTO> findAllDTO(){
        List<StockDestructionAdjustment> adjs = stockDestructionAdjustmentRepository.findAll();
        List<StockDestructionAdjustmentDTO> list = adjs.stream()
                .map(StockDestructionAdjustmentDTO::new)
                .collect(Collectors.toList());
        return list;
    }

    @Transactional
    def save(StockDestructionAdjustment  stockDestructionAdjustment){
        return stockDestructionAdjustmentRepository.save(stockDestructionAdjustment);
    }
    @Transactional
    def update(StockDestructionAdjustment stockDestructionAdjustment){
        return stockDestructionAdjustmentRepository.update(stockDestructionAdjustment);
    }

    @Transactional
    def delete(String id){
        StockDestructionAdjustment adjust =stockDestructionAdjustmentRepository.findById(id)
        return stockDestructionAdjustmentRepository.delete(adjust);
    }


}
