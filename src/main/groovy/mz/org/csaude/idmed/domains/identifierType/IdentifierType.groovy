package mz.org.csaude.idmed.domains.identifierType

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "IdentifierType")
@Serdeable
class IdentifierType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "code", nullable = false, unique = true)
    String code

    @Column(name = "description", nullable = false)
    String description

    @Column(name = "pattern", nullable = true)
    String pattern
}
