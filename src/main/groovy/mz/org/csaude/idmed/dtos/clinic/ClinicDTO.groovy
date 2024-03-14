package mz.org.csaude.idmed.dtos.clinic

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.clinicSector.ClinicSector
import mz.org.csaude.idmed.domains.distribuicaoAdministrativa.District
import mz.org.csaude.idmed.domains.distribuicaoAdministrativa.Province
import mz.org.csaude.idmed.domains.facilityType.FacilityType

@Serdeable
class ClinicDTO {


    String id
    String code
    String notes
    String telephone
    String clinic_name
    String province_id
    String district_id
    //Province province
    //District district
    //FacilityType facilityType
    boolean national_clinic
    boolean main_clinic
    boolean active
    String uuid
  //  Set<String> sectorsIds

    public ClinicDTO (Clinic clinic){
        id = clinic.id
        clinic_name = clinic.clinicName
        code = clinic.code
        notes = clinic.notes
        telephone = clinic.telephone
        province_id = clinic.province.id
        district_id = clinic.district.id
        national_clinic = clinic.nationalClinic
        main_clinic = clinic.mainClinic
        active = clinic.active
        uuid = clinic.uuid
    }
}
