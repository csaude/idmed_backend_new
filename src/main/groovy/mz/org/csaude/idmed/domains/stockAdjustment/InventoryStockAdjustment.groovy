package mz.org.csaude.idmed.domains.stockAdjustment


import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import mz.org.csaude.idmed.domains.inventory.Inventory
import mz.org.csaude.idmed.domains.stock.Stock

@Serdeable
//@MappedEntity
@DiscriminatorValue("mz.org.fgh.sifmoz.backend.stockadjustment.InventoryStockAdjustment")
@Entity
class InventoryStockAdjustment extends StockAdjustment{

    @ManyToOne(optional = false)
    @JoinColumn(name = "inventory_id")
    Inventory inventory

    InventoryStockAdjustment() {
    }

    InventoryStockAdjustment(Inventory inventory, Stock adjustedStock) {
        super(adjustedStock)
        this.inventory = inventory
    }

}
