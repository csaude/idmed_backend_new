package mz.org.csaude.idmed.dtos.clinicSector

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.dtos.clinic.ClinicDTO

class ClinicSectorDTO {

    String id
    String code
    String description
    String uuid = UUID.randomUUID().toString()
    boolean active
    String syncStatus
    //  ClinicSectorType clinicSectorType
    ClinicDTO clinic
}
