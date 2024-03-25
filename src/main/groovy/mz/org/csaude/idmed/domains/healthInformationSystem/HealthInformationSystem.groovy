package mz.org.csaude.idmed.domains.healthInformationSystem

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotNull

@Entity(name = "HealthInformationSystem")
@Serdeable
class HealthInformationSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "abbreviation", nullable = false, unique = true)
    String abbreviation

    @Column(name = "description", nullable = false)
    String description

    @Column(name = "active")
    boolean active
}
