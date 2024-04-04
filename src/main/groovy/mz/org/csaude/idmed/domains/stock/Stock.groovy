package mz.org.csaude.idmed.domains.stock

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.drug.Drug
import mz.org.csaude.idmed.domains.stockCenter.StockCenter
import mz.org.csaude.idmed.domains.stockentrance.StockEntrance

import java.time.LocalDateTime

@Entity(name = "stock")
@Serdeable
class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "version")
    int version

    @Column(name = "expire_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    LocalDateTime expireDate

    @Column(name = "modified", nullable = false)
    boolean modified

    @Column(name = "shelf_number", nullable = false)
    String shelfNumber

    @Column(name = "units_received", nullable = false)
    int unitsReceived

    @Column(name = "stock_moviment", nullable = false)
    int stockMoviment

    @Column(name = "manufacture", nullable = false)
    String manufacture

    @Column(name = "batch_number", nullable = false)
    String batchNumber

    @Column(name = " has_units_remaining", nullable = false)
    boolean hasUnitsRemaining

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "drug_id")
    Drug drug


    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "center_id")
    StockCenter center

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "clinic_id")
    Clinic clinic

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "entrance_id")
    StockEntrance stockEntrance

}
