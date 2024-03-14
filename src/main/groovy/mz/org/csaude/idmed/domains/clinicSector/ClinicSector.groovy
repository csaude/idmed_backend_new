package mz.org.csaude.idmed.domains.clinicSector

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import mz.org.csaude.idmed.domains.clinic.Clinic


@Entity(name = "clinic_sector")
@Serdeable
class ClinicSector {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @NotEmpty
    @Column(name = "code", nullable = false, unique = true)
    String code

    @Column(name = "description", nullable = false)
    String description


    @Column(name = "uuid", nullable = false)
    String uuid = UUID.randomUUID().toString()

    @Column(name = "active", nullable = true)
    boolean active

    @Column(name = "sync_status", nullable = true)
    String syncStatus


  //  ClinicSectorType clinicSectorType

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "clinic_id")
    Clinic clinic
}
