package mz.org.csaude.idmed.domains.patientIdentifier

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.identifierType.IdentifierType
import mz.org.csaude.idmed.domains.patient.Patient
import mz.org.csaude.idmed.domains.service.ClinicalService
import mz.org.csaude.idmed.utils.validatorsAnnotations.dateValidators.IDateInThePast

import java.time.LocalDateTime

@Entity(name = "PatientServiceIdentifier")
@Serdeable
class PatientServiceIdentifier {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @NotBlank
    @IDateInThePast
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = true)
    LocalDateTime startDate

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = true)
    LocalDateTime endDate

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reopen_date", nullable = true)
    LocalDateTime reopenDate

    @Column(name = "value", nullable = false)
    String value

    @Column(name = "state", nullable = false)
    String state

    @Column(name = "prefered")
    boolean prefered

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "identifier_type_id")
    IdentifierType identifierType

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id", nullable = true, unique = true)
    ClinicalService service

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "clinic_id")
    Clinic clinic

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", nullable = true, unique = true)
    Patient patient
}
