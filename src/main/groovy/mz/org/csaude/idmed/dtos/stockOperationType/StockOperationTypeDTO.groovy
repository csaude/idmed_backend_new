package mz.org.csaude.idmed.dtos.stockOperationType

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.stockOperationType.StockOperationType

@Serdeable
class StockOperationTypeDTO {
    String id
    String description
    String code

    StockOperationTypeDTO(StockOperationType stockOperationType){
        this.id =stockOperationType.id
        this.description=stockOperationType.id
        this.code= stockOperationType.code
    }

    @Override
    public String toString() {
        return "StockOperationType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
