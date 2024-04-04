package mz.org.csaude.idmed.dtos.inventory

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.inventory.Inventory
import mz.org.csaude.idmed.domains.stockAdjustment.InventoryStockAdjustment
import mz.org.csaude.idmed.dtos.stockAdjustment.InventoryStockAdjustmentDTO

import java.time.LocalDateTime

@Serdeable
class InventoryDTO {
    String id
    LocalDateTime startDate
    LocalDateTime endDate
    boolean open
    boolean generic
    int sequence
    List<InventoryStockAdjustmentDTO> adjustments = new ArrayList<>()
    //List<DrugDTO> inventoryDrugs
    //ClinicDTO clinic

    InventoryDTO(Inventory inventory) {
        this.id =inventory.id
        this.startDate=inventory.getStartDate()
        this.endDate = inventory.getEndDate()
        this.open = inventory.open
        this.generic = inventory.generic
        this.sequence = inventory.getSequence()
        for(InventoryStockAdjustment adjustment: inventory.getAdjustments()) {
            adjustments.add(new InventoryStockAdjustmentDTO(adjustment))
        }
       // this.adjustments = inventory.getAdjustments()
    }


    @Override
    public String toString() {
        return "Inventory{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", open=" + open +
                ", sequence=" + sequence +
                '}';
    }


}
