package mz.org.csaude.idmed.dtos.stockAdjustment

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.dtos.clinic.ClinicDTO
import mz.org.csaude.idmed.dtos.stock.StockDTO
import mz.org.csaude.idmed.dtos.stockOperationType.StockOperationTypeDTO

import java.time.LocalDateTime

@Serdeable
abstract class StockAdjustmentDTO {
    String id
    LocalDateTime captureDate
    String notes
    int stockTake
    int adjustedValue
    int balance
    boolean finalised
    StockDTO adjustedStock
    StockOperationTypeDTO operation
    ClinicDTO clinic

    StockAdjustmentDTO() {
    }

    StockAdjustmentDTO(StockDTO adjustedStock) {
        this.adjustedStock = adjustedStock
    }

    @Override
    String toString() {
        return "StockAdjustment{" +
                "captureDate=" + captureDate +
                ", notes='" + notes + '\'' +
                ", stockTake=" + stockTake +
                ", adjustedValue=" + adjustedValue +
                ", finalised=" + finalised +
                '}'
    }

}
