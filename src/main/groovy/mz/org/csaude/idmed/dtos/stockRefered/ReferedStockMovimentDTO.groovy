package mz.org.csaude.idmed.dtos.stockRefered

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.stockRefered.ReferedStockMoviment
import mz.org.csaude.idmed.dtos.stockAdjustment.StockReferenceAdjustmentDTO

import java.time.LocalDate

@Serdeable
class ReferedStockMovimentDTO {

    String id
    LocalDate date
    String orderNumber
    String origin
    int quantity
    char updateStatus
    Clinic clinic
    List<StockReferenceAdjustmentDTO> adjustments

    ReferedStockMovimentDTO(ReferedStockMoviment referedStockMoviment) {
        this.id = referedStockMoviment.id
        this.date = referedStockMoviment.date
        this.orderNumber = referedStockMoviment.orderNumber
        this.origin = referedStockMoviment.origin
        this.quantity = referedStockMoviment.quantity
        this.updateStatus = referedStockMoviment.updateStatus

    }

    @Override
    public String toString() {
        return "ReferedStockMoviment{" +
                "date=" + date +
                ", orderNumber='" + orderNumber + '\'' +
                ", origin='" + origin + '\'' +
                ", quantity=" + quantity +
                ", updateStatus=" + updateStatus +
                '}';
    }

}
