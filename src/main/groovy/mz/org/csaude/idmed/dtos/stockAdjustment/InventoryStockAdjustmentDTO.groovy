package mz.org.csaude.idmed.dtos.stockAdjustment

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.stockAdjustment.InventoryStockAdjustment
import mz.org.csaude.idmed.dtos.clinic.ClinicDTO
import mz.org.csaude.idmed.dtos.inventory.InventoryDTO
import mz.org.csaude.idmed.dtos.stock.StockDTO
import mz.org.csaude.idmed.dtos.stockOperationType.StockOperationTypeDTO

@Serdeable
class InventoryStockAdjustmentDTO  extends  StockAdjustmentDTO{

    InventoryDTO inventoryDTO

    InventoryStockAdjustmentDTO() {
    }

    InventoryStockAdjustmentDTO(InventoryStockAdjustment inventoryStockAdjustment) {
        this.id = inventoryStockAdjustment.id
        this.notes = inventoryStockAdjustment.notes
        this.balance = inventoryStockAdjustment.balance
        this.stockTake = inventoryStockAdjustment.stockTake
        this.adjustedValue = inventoryStockAdjustment.adjustedValue
        this.finalised = inventoryStockAdjustment.finalised
        this.captureDate= inventoryStockAdjustment.captureDate
        this.operation = new StockOperationTypeDTO(inventoryStockAdjustment.operation)
        this.adjustedStock = new StockDTO(inventoryStockAdjustment.adjustedStock)
        this.clinic = new ClinicDTO(inventoryStockAdjustment.clinic)
    }
    InventoryStockAdjustmentDTO(InventoryDTO inventory, StockDTO adjustedStock) {
        super(adjustedStock)
        this.inventoryDTO = inventory
    }

}
