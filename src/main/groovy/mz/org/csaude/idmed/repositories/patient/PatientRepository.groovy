package mz.org.csaude.idmed.repositories.patient

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinicSector.ClinicSector
import mz.org.csaude.idmed.domains.patient.Patient

@Repository
interface PatientRepository extends CrudRepository<Patient, String> {

    List<Patient> findAll()

    Optional<Patient> findById(@NotNull String id)

    List<Patient> search (Patient patient)

    List<Patient> search(String searchString, String clinicId)

    Long count(Patient patient)

    List<Patient> getAllByClinicId(String clinicId, int offset, int max)

    List<Patient> getAllPatientsInClinicSector(ClinicSector clinicSector)
}
