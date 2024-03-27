package mz.org.csaude.idmed.repositories.patient

import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.clinicSector.ClinicSector
import mz.org.csaude.idmed.domains.patient.Patient
import io.micronaut.data.annotation.Query
import mz.org.csaude.idmed.utils.Utilities

abstract class PatientImpl implements PatientRepository{
    @Override
    List<Patient> findAll() {
        return null
    }

    @Override
    Optional<Patient> findById(@NotNull String id) {
        return null
    }

    @Override
    List<Patient> search(@NotNull Patient patient) {
            boolean hasIdentifier = Utilities.listHasElements(patient.identifiers as ArrayList<?>)
            String mainQuery =  "select p from Patient p " +
                    " where (lower(p.firstNames) like lower(:firstNames) OR" +
                    " lower(p.middleNames) like lower(:middleNames) OR " +
                    " lower(p.lastNames) like lower(:lastNames)) AND " +
                    " p.clinic =:clinic"
            String indentifierCondition = " OR EXISTS (select psi " +
                    "                   from PatientServiceIdentifier psi inner join psi.patient pt " +
                    "                   where pt.id = p.id and lower(psi.value) like lower(:identifiers)) "
            String searchQuery = mainQuery + (hasIdentifier? indentifierCondition : "")

            searchQuery += " order by p.firstNames "

            Clinic clinic = Clinic.findById(patient.clinic.id)

            if(hasIdentifier)

                return Patient.executeQuery(searchQuery,
                        [firstNames: "%${patient.firstNames}%",
                         middleNames: "%${patient.middleNames}%",
                         lastNames: "%${patient.lastNames}%",
                         clinic: clinic,
                         identifiers: (Utilities.listHasElements(patient.identifiers as ArrayList<?>) ? "%${patient.identifiers.getAt(0).value}%" : ""), max: 400]
                )
            else
                return Patient.executeQuery(searchQuery,
                        [firstNames: "%${patient.firstNames}%",
                         middleNames: "%${patient.middleNames}%",
                         lastNames: "%${patient.lastNames}%",
                         clinic: clinic]
                )
    }

    @Override
    List<Patient> search(String searchString, String clinicId) {

    }

    @Override
    Long count(@NotNull Patient patient) {

    }

    @Override
    List<Patient> getAllByClinicId(@NotNull String clinicId, int offset, int max) {

    }

    @Override
    List<Patient> getAllPatientsInClinicSector(@NotNull ClinicSector clinicSector) {

    }
}
