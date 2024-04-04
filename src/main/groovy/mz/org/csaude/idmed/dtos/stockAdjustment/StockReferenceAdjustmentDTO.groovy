package mz.org.csaude.idmed.dtos.stockAdjustment

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.stockAdjustment.StockReferenceAdjustment
import mz.org.csaude.idmed.dtos.stock.StockDTO
import mz.org.csaude.idmed.dtos.stockRefered.ReferedStockMovimentDTO

@Serdeable
class StockReferenceAdjustmentDTO extends StockAdjustmentDTO {
 ReferedStockMovimentDTO reference

    StockReferenceAdjustmentDTO(StockReferenceAdjustment stockReferenceAdjustment) {
        this.id = stockReferenceAdjustment.id
        this.notes = stockReferenceAdjustment.notes
    }

    StockReferenceAdjustmentDTO(ReferedStockMovimentDTO reference, StockDTO adjustedStock) {
        super(adjustedStock)
        this.reference = reference
    }


}
