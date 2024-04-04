package mz.org.csaude.idmed.domains.stockAdjustment

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.data.annotation.MappedEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.stock.Stock
import mz.org.csaude.idmed.domains.stockOperationType.StockOperationType

import java.time.LocalDateTime

@MappedEntity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "class", discriminatorType = DiscriminatorType.STRING)
@Entity(name ="stock_adjustment")
abstract class StockAdjustment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "capture_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    LocalDateTime captureDate

    @Column(name = "version")
    int version


    @Column(name = "notes")
    String notes

    @Column(name = "stock_take")
    int stockTake

    @Column(name = "adjusted_value")
    int adjustedValue

    @Column(name = "balance")
    int balance

    @Column(name = "finalised")
    boolean finalised

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "adjusted_stock_id")
    Stock adjustedStock

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "operation_id")
    StockOperationType operation

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "clinic_id")
    Clinic clinic

    StockAdjustment() {
    }

    StockAdjustment(Stock adjustedStock) {
        this.adjustedStock = adjustedStock
    }



}
