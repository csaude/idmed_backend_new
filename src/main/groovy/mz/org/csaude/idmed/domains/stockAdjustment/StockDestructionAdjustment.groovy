package mz.org.csaude.idmed.domains.stockAdjustment


import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import mz.org.csaude.idmed.domains.stock.Stock
import mz.org.csaude.idmed.domains.stockdestruction.DestroyedStock

@Serdeable
@Entity
@DiscriminatorValue("mz.org.fgh.sifmoz.backend.stockadjustment.StockDestructionAdjustment")
class StockDestructionAdjustment  extends  StockAdjustment {


    @ManyToOne(optional = false)
    @JoinColumn(name = "destruction_id")
    DestroyedStock destroyedStock

    StockDestructionAdjustment() {
    }

    StockDestructionAdjustment(DestroyedStock destroyedStock, Stock adjustedStock) {
        super(adjustedStock)
        this.destroyedStock = destroyedStock
    }


}
