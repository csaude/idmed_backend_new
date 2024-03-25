package mz.org.csaude.idmed.domains.patientAttribute

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.attributeType.PatientAttributeType
import mz.org.csaude.idmed.domains.patient.Patient

@Entity(name = "PatientAttribute")
@Serdeable
class PatientAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @NotBlank
    @Column(name = "value", nullable = false)
    String value

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    Patient patient

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "attribute_type_id")
    PatientAttributeType attributeType
}
