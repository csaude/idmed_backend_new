package mz.org.csaude.idmed.domains.distribuicaoAdministrativa

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic

@Entity(name = "District")
@Serdeable
class District {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @NotEmpty
    @Column(name = "code", nullable = false, unique = true)
    String code

    @Column(name = "description", nullable = false)
    String description

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "province_id")
    Province province
}
