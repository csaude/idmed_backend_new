package mz.org.csaude.idmed.dtos.drug

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import mz.org.csaude.idmed.domains.drug.Drug

@Serdeable
class DrugDTO {
    String id
    int packSize
    String name
    double defaultTreatment
    int defaultTimes
    String defaultPeriodTreatment
    String fnmCode
    String uuidOpenmrs
    boolean active

    DrugDTO(Drug drug) {
        this.id = drug.id
        this.packSize = drug.packSize
        this.name = drug.name
        this.defaultTimes = drug.defaultTimes
        this.defaultPeriodTreatment = drug.defaultPeriodTreatment
        this.fnmCode = drug.getFnmCode()
        this.uuidOpenmrs = drug.uuidOpenmrs
        this.active = drug.active
        this.defaultTreatment = drug.defaultTreatment
    }
    //ClinicalService clinicalService
    //Form form
    // static hasMany = [stockList: Stock, therapeuticRegimenList: TherapeuticRegimen]

}
