package mz.org.csaude.idmed.domains.stockAdjustment


import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import mz.org.csaude.idmed.domains.stock.Stock
import mz.org.csaude.idmed.domains.stockRefered.ReferedStockMoviment

@Serdeable
@Entity
@DiscriminatorValue("mz.org.fgh.sifmoz.backend.stockadjustment.StockReferenceAdjustment")
class StockReferenceAdjustment extends  StockAdjustment {


    @ManyToOne(optional = false)
    @JoinColumn(name = "reference_id")
    ReferedStockMoviment reference

    StockReferenceAdjustment(){
    }
    StockReferenceAdjustment(ReferedStockMoviment reference, Stock adjustedStock) {
        super(adjustedStock)
        this.reference = reference
    }


}
