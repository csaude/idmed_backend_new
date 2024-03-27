package mz.org.csaude.idmed.services.patient

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.patient.Patient
import mz.org.csaude.idmed.dtos.clinic.ClinicDTO
import mz.org.csaude.idmed.dtos.patient.PatientDTO
import mz.org.csaude.idmed.repositories.clinic.ClinicRepository
import mz.org.csaude.idmed.repositories.patient.PatientRepository

import java.util.stream.Collectors

@Singleton
class PatientService {
    private final PatientRepository patientRepository

    PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository
    }

    @Transactional
    List<Patient> findAll(){
        return this.patientRepository.findAll()
    }

    @Transactional
    List<PatientDTO> findAllDTO(){
        List<Clinic> patients = this.patientRepository.findAll()
        List<PatientDTO> clinicDTOs = patients.stream()
                .map(PatientDTO::new)
                .collect(Collectors.toList());
        return clinicDTOs;
    }
}
