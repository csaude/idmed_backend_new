package mz.org.csaude.idmed.domains.distribuicaoAdministrativa

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table


@Entity(name = "Province")
@Serdeable
class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id
    @Column(name = "code", nullable = false)
    String code
    @Column(name = "description", nullable = false)
    String description

    @OneToMany(cascade = CascadeType.ALL)
    List<District> districts
}
