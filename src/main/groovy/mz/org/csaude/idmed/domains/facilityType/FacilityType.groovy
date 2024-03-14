package mz.org.csaude.idmed.domains.facilityType

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "facility_type")
@Serdeable
class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "code", nullable = false)
    String code

    @Column(name = "description", nullable = false)
    String description
}
