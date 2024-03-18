package mz.org.csaude.idmed.domains.service

import io.micronaut.serde.annotation.Serdeable
import jakarta.annotation.Nullable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import mz.org.csaude.idmed.domains.identifierType.IdentifierType

@Entity(name = "ClinicalService")
@Serdeable
class ClinicalService {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "code", nullable = false, unique = true)
    String code

    @Column(name = "description", nullable = false)
    String description

    boolean active

    @Nullable
    @ManyToOne(optional = false)
    @JoinColumn(name = "identifier_type_id")
    IdentifierType identifierType

    boolean isPrep() {
        return this.code == "PREP"
    }

    boolean isTarv() {
        return this.code == "TARV"
    }

}
