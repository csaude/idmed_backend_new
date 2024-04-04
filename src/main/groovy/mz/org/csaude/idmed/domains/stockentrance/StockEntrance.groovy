package mz.org.csaude.idmed.domains.stockentrance

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.stock.Stock

import java.time.LocalDateTime

@Entity(name = "stockEntrance")
@Serdeable
class StockEntrance  {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "version")
    int version

    @Size(max = 50)
    @NotBlank
    @Column(name = "order_number", unique = true)
    String orderNumber

    @Column(name = "date_received", nullable = false)
   // @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    LocalDateTime dateReceived

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "clinic_id", nullable = false)
    Clinic clinic

    @Column(name = "creation_date")
    LocalDateTime creationDate

    @Column(name = "notes")
    String notes

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stockEntrance")
    Set<Stock> stocks = new HashSet<>();
}
