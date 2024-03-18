package mz.org.csaude.idmed.domains.transference

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
import mz.org.csaude.idmed.domains.patientIdentifier.PatientServiceIdentifier

import java.time.LocalDateTime

@Entity(name = "PatientTransReference")
@Serdeable
class PatientTransReference {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "origin_id")
    Clinic origin

    @Column(name = "destination")
    String destination

    @ManyToOne(optional = false)
    @JoinColumn(name = "identifier_id")
    PatientServiceIdentifier identifier

    @Column(name = "sync_status")
    String syncStatus

    @ManyToOne(optional = false)
    @JoinColumn(name = "operation_type_id")
    PatientTransReferenceType operationType

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "operation_date", nullable = true)
    LocalDateTime operationDate

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = true)
    LocalDateTime creationDate

    @Column(name = "match_id", nullable = true)
    Long matchId

    @Column(name = "patient_status", nullable = true)
    String patientStatus
}
