package mz.org.csaude.idmed.domains.form

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*

@Entity(name = "form")
@Serdeable
class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "code", nullable = false)
    String code

    @Column(name = "description", nullable = false)
    String description
}
