package mz.org.csaude.idmed.domains.inventory

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.drug.Drug
import mz.org.csaude.idmed.domains.stockAdjustment.InventoryStockAdjustment

import java.time.LocalDateTime

@Entity(name = "inventory")
@Serdeable
class Inventory  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "version")
    int version

    @NotNull
    @Column(name = "start_date")
    LocalDateTime startDate

    @Column(name = "end_date", nullable = false)
    LocalDateTime endDate

    @Column(name = "open")
    boolean open

    @Column(name = "generic")
    boolean generic

    @Column(name = "sequence")
    int sequence

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    List<InventoryStockAdjustment> adjustments

    @OneToMany(cascade = CascadeType.ALL)
    List<Drug> inventoryDrugs

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "clinic_id")
    Clinic clinic

     void close() {
        this.open = false
        this.endDate = new Date()
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
