package mz.org.csaude.idmed.domains.transference

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Entity(name = "PatientTransReferenceType")
@Serdeable
class PatientTransReferenceType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @NotBlank
    @Size(min = 1, max = 50)
    @Column(name = "description", nullable = false)
    String description

    @NotBlank
    @Size(min = 1, max = 50)
    @Column(name = "code", nullable = false, unique = true)
    String code
}
