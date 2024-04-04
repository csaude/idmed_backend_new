package mz.org.csaude.idmed.dtos.stockdestruction

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.stockdestruction.DestroyedStock
import mz.org.csaude.idmed.dtos.clinic.ClinicDTO
import mz.org.csaude.idmed.dtos.stockAdjustment.StockDestructionAdjustmentDTO

import java.time.LocalDateTime

@Serdeable
class DestroyedStockDTO {
    String id
    String notes
    String update_status
    LocalDateTime date
    ClinicDTO clinic
    List<StockDestructionAdjustmentDTO> adjustments

    DestroyedStockDTO(DestroyedStock destroyedStock){
        this.id= destroyedStock.id
        this.notes = destroyedStock.notes
        this.update_status=destroyedStock.updateStatus
        this.date =destroyedStock.date
    }


}
