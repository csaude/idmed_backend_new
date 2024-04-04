package mz.org.csaude.idmed.services.stockRefered

import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockAdjustment.StockDestructionAdjustment
import mz.org.csaude.idmed.domains.stockRefered.ReferedStockMoviment
import mz.org.csaude.idmed.dtos.stockRefered.ReferedStockMovimentDTO
import mz.org.csaude.idmed.repositories.stockRefered.ReferedStockMovimentRepository

import java.util.stream.Collectors


class ReferedStockMovimentService {

    private final ReferedStockMovimentRepository referedStokMovimentRepository

    ReferedStockMovimentService(ReferedStockMovimentRepository referedStokMovimentRepository) {
        this.referedStokMovimentRepository = referedStokMovimentRepository
    }

    @Transactional
    List<ReferedStockMovimentDTO> findAllDTO() {
        List<ReferedStockMoviment> adjs = referedStokMovimentRepository.findAll();
        List<ReferedStockMovimentDTO> list = adjs.stream()
                .map(ReferedStockMovimentDTO::new)
                .collect(Collectors.toList());
        return list;
    }

    @Transactional
    def save(ReferedStockMoviment referedStockMoviment) {
        return referedStokMovimentRepository.save(referedStockMoviment);
    }

    @Transactional
    def update(StockDestructionAdjustment stockDestructionAdjustment) {
        return referedStokMovimentRepository.update(stockDestructionAdjustment);
    }

    @Transactional
    def delete(String id) {
        StockDestructionAdjustment adjust = referedStokMovimentRepository.findById(id)
        return referedStokMovimentRepository.delete(adjust);
    }
}
