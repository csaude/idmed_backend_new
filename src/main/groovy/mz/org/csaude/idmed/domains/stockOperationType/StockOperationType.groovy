package mz.org.csaude.idmed.domains.stockOperationType

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity(name ='stock_operation_type')
@Serdeable
class StockOperationType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name ='description')
    String description

    @Size(max = 50)
    @NotBlank
    @Column(name ='code', unique = true,nullable=false)
    String code

    @Override
    public String toString() {
        return "StockOperationType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
