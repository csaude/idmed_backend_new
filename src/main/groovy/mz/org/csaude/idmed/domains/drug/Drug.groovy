package mz.org.csaude.idmed.domains.drug

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "drug")
@Serdeable
class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "pack_size")
    int packSize

    @Column(name = "name")
    String name

    @Column(name = "active")
    String active

    @Column(name = "default_treatment")
    double defaultTreatment

    @Column(name = "default_times")
    int defaultTimes

    @Column(name = "default_period_treatment")
    String defaultPeriodTreatment

    @Column(name = "fnm_code")
    String fnmCode

    @Column(name = "uuid_openmrs")
    String uuidOpenmrs


}
