package mz.org.csaude.idmed.services.clinic

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.dtos.clinic.ClinicDTO
import mz.org.csaude.idmed.repositories.clinic.ClinicRepository

import java.util.stream.Collectors;


@Singleton
class ClinicService {

    private final ClinicRepository clinicRepository;

     ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Transactional
     List<Clinic> findAll(){
        return this.clinicRepository.findAll();
    }

    @Transactional
    List<ClinicDTO> findAllDTO(){
        List<Clinic> clinics = this.clinicRepository.findAll();
       // List<ClinicDTO> clinicDTOs = clinics.collect { new ClinicDTO(it) }
        List<ClinicDTO> clinicDTOs = clinics.stream()
                .map(ClinicDTO::new) // Assuming ClinicDTO has a constructor that accepts a Clinic object
                .collect(Collectors.toList());
        return clinicDTOs;
    }

     Optional<Clinic> findById(String id){
        return this.clinicRepository.findById(id);
    }

     List<Clinic> findByCode(String code){
        return this.clinicRepository.findByCode(code);
    }

     Clinic save(Clinic clinic){
        return this.clinicRepository.save(clinic);
    }


}
