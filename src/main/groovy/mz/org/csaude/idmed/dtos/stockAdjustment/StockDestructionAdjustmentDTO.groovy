package mz.org.csaude.idmed.dtos.stockAdjustment

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.dtos.stock.StockDTO
import mz.org.csaude.idmed.dtos.stockdestruction.DestroyedStockDTO

@Serdeable
class StockDestructionAdjustmentDTO extends StockAdjustmentDTO {
 DestroyedStockDTO destruction

    StockDestructionAdjustmentDTO() {
    }

    StockDestructionAdjustmentDTO(DestroyedStockDTO destruction, StockDTO adjustedStock) {
        super(adjustedStock)
        this.destruction = destruction
    }

}
