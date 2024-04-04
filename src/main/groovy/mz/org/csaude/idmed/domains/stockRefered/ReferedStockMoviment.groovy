package mz.org.csaude.idmed.domains.stockRefered

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.stockAdjustment.StockReferenceAdjustment

import java.time.LocalDate

@Entity(name = "refered_stock_moviment")
@Serdeable
class ReferedStockMoviment  {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "date")
    LocalDate date

    @Column(name = "order_number")
    String orderNumber

    @Column(name = "origin")
    String origin

    @Column(name = "quantity")
    int quantity

    @Column(name = "update_status")
    char updateStatus

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "clinic_id")
    Clinic clinic

    @OneToMany(cascade = CascadeType.ALL)
    List<StockReferenceAdjustment> adjustments


    @Override
    public String toString() {
        return "ReferedStockMoviment{" +
                "date=" + date +
                ", orderNumber='" + orderNumber + '\'' +
                ", origin='" + origin + '\'' +
                ", quantity=" + quantity +
                ", updateStatus=" + updateStatus +
                '}';
    }
    
}
