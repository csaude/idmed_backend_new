package mz.org.csaude.idmed.domains.postoAdministrativo

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.distribuicaoAdministrativa.District

@Entity(name = "PostoAdministrativo")
@Serdeable
class PostoAdministrativo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "code", nullable = false)
    String code

    @Column(name = "description", nullable = false)
    String description

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "district_id")
    District district
}
