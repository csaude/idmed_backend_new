package mz.org.csaude.idmed.domains.patientVisit

import com.fasterxml.jackson.annotation.JsonIgnore
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.patient.Patient

import java.time.LocalDateTime

@Entity(name = "PatientVisit")
@Serdeable
class PatientVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "visit_date", nullable = true)
    LocalDateTime visitDate

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "clinic_id")
    Clinic clinic

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = true)
    LocalDateTime creationDate

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    Patient patient
}
