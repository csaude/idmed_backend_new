package mz.org.csaude.idmed.services.drug

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.drug.Drug
import mz.org.csaude.idmed.domains.form.Form
import mz.org.csaude.idmed.dtos.drug.DrugDTO
import mz.org.csaude.idmed.dtos.form.FormDTO
import mz.org.csaude.idmed.repositories.drug.DrugRepository
import mz.org.csaude.idmed.repositories.form.FormRepository

import java.util.stream.Collectors

@Singleton
class DrugService {

    private final DrugRepository drugRepository

    DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository
    }

    Optional<Drug> findById(String id){
        return this.drugRepository.findById(id);
    }

    @Transactional
    List<DrugDTO> findAllDrugDTO(){
        List<Drug> drugList = drugRepository.findAll();
        List<DrugDTO> drugs =drugList.stream()
                .map(DrugDTO::new)
                .collect(Collectors.toList());
        return drugs;
    }

}
