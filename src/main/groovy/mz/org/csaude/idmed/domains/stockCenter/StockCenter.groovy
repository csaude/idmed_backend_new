package mz.org.csaude.idmed.domains.stockCenter

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic

@Entity(name = "stock_center")
@Serdeable
class StockCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "name", nullable = false)
    String name

    @Column(name = "prefered", nullable = false)
    boolean prefered

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "clinic_id", nullable = false)
    Clinic clinic

    @Column(name = "code", nullable = false)
    String code

}
