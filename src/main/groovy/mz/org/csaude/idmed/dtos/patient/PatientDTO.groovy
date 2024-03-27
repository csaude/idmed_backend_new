package mz.org.csaude.idmed.dtos.patient

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.patient.Patient
import java.time.LocalDateTime

@Serdeable
class PatientDTO {
    String id
    String first_names
    String middle_names
    String last_names
    String gender
    LocalDateTime date_of_birth
    String cellphone
    String alternative_cellphone
    String address
    String address_reference
    boolean accountstatus
    String his_location
    String his_location_mame
    String his_uuid
    String district_id
    String province_id
    String localidade_id
    String posto_administrativo_id
    String clinic_id
    String his_id
    LocalDateTime creation_date
    Character his_sync_status
    String his_provider
    Long match_id

    PatientDTO (Patient patient){
        id = patient.id
        first_names = patient.firstNames
        middle_names = patient.middleNames
        last_names = patient.lastNames
        gender = patient.gender
        date_of_birth = patient.dateOfBirth
        cellphone = patient.cellphone
        alternative_cellphone = patient.alternativeCellphone
        address = patient.address
        address_reference = patient.addressReference
        accountstatus = patient.accountstatus
        his_location = patient.hisLocation
        his_location_mame = patient.hisLocationName
        his_uuid = patient.hisUuid
        district_id = patient.district.id
        province_id = patient.province.id
        localidade_id = patient.localidade.id
        posto_administrativo_id = patient.postoAdministrativo.id
        clinic_id = patient.clinic.id
        his_id = patient.his.id
        creation_date = patient.creationDate
        his_sync_status = patient.hisSyncStatus
        his_provider = patient.hisProvider
        match_id = patient.matchId

    }
}
