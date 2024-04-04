package mz.org.csaude.idmed.domains.stockdestruction

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.stockAdjustment.StockDestructionAdjustment

import java.time.LocalDate

@Entity(name = "destroyedStock")
@Serdeable
class DestroyedStock {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "notes")
    String notes

    @Column(name = "update_status")
    String updateStatus

    @Column(name = "date")
    LocalDate date

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "clinic_id")
    Clinic clinic

    @OneToMany(cascade = CascadeType.ALL)
    List<StockDestructionAdjustment> adjustments

    @Override
    String toString() {
        return "DestroyedStock{" +
                "notes='" + notes + '\'' +
                ", updateStatus='" + updateStatus + '\'' +
                '}';
    }


}
