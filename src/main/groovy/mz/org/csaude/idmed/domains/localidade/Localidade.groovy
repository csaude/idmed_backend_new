package mz.org.csaude.idmed.domains.localidade

import io.micronaut.serde.annotation.Serdeable
import jakarta.annotation.Nullable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.distribuicaoAdministrativa.District
import mz.org.csaude.idmed.domains.postoAdministrativo.PostoAdministrativo

@Entity(name = "Localidade")
@Serdeable
class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "code", nullable = false)
    String code

    @Column(name = "description", nullable = false)
    String description

    @Nullable
    @ManyToOne(optional = false)
    @JoinColumn(name = "posto_administrativo_id")
    PostoAdministrativo postoAdministrativo

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "district_id")
    District district
}
