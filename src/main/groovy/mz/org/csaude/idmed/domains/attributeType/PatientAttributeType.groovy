package mz.org.csaude.idmed.domains.attributeType

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*

@Entity(name = "PatientAttributeType")
@Serdeable
class PatientAttributeType {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "code", nullable = false, unique = true)
    String code

    @Column(name = "name", nullable = false, unique = true)
    String name

    @Column(name = "description", nullable = true)
    String description

    @Column(name = "datatype", nullable = true)
    String datatype
}
