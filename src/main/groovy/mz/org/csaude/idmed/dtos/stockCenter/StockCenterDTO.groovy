package mz.org.csaude.idmed.dtos.stockCenter

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.stockCenter.StockCenter
import mz.org.csaude.idmed.dtos.clinic.ClinicDTO

@Serdeable
class StockCenterDTO {
    String id
    String name
    boolean prefered
    ClinicDTO clinicDto
    String code

    StockCenterDTO(StockCenter stockCenter){
        this.id = stockCenter.id
        this.name = stockCenter.name
        this.code = stockCenter.code
        this.clinicDto = new ClinicDTO(stockCenter.getClinic())
        this.prefered = stockCenter.prefered
    }

}
