package mz.org.csaude.idmed.domains.patient
import io.micronaut.serde.annotation.Serdeable
import jakarta.annotation.Nullable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PastOrPresent
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.distribuicaoAdministrativa.District
import mz.org.csaude.idmed.domains.distribuicaoAdministrativa.Province
import mz.org.csaude.idmed.domains.healthInformationSystem.HealthInformationSystem
import mz.org.csaude.idmed.domains.localidade.Localidade
import mz.org.csaude.idmed.domains.patientIdentifier.PatientServiceIdentifier
import mz.org.csaude.idmed.domains.postoAdministrativo.PostoAdministrativo
import java.time.LocalDateTime

@Entity(name = "Patient")
@Serdeable
class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @Column(name = "first_names", nullable = false)
    String firstNames

    @Column(name = "middle_names", nullable = true)
    String middleNames

    @Column(name = "last_names", nullable = false)
    String lastNames

    @Column(name = "gender")
    String gender

    @Temporal(TemporalType.TIMESTAMP)
    @PastOrPresent
    @Column(name = "date_of_birth", nullable = false)
    LocalDateTime dateOfBirth

    @Nullable
    @Pattern(regexp = "\\d{9,12}")
    @Column(name = "cellphone")
    String cellphone

    @Size(max = 12)
    @Column(name = "alternative_cellphone", nullable = true)
    String alternativeCellphone

    @Size(max = 750)
    @Column(name = "address", nullable = true)
    String address

    @Size(max = 750)
    @Column(name = "address_reference", nullable = true)
    String addressReference

    @Column(name = "accountstatus", nullable = true)
    boolean accountstatus

    @Column(name = "his_location", nullable = true)
    String hisLocation

    @Column(name = "his_location_mame", nullable = true)
    String hisLocationName

    @Column(name = "his_uuid", nullable = true)
    String hisUuid

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "district_id")
    District district

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "province_id")
    Province province

    @Nullable
    @ManyToOne(optional = false)
    @JoinColumn(name = "localidade_id")
    Localidade localidade

    @Nullable
    @ManyToOne(optional = false)
    @JoinColumn(name = "posto_administrativo_id")
    PostoAdministrativo postoAdministrativo

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "clinic_id")
    Clinic clinic

    @Nullable
    @ManyToOne(optional = false)
    @JoinColumn(name = "his_id")
    HealthInformationSystem his

    @Column(name = "creation_date", nullable = true)
    LocalDateTime creationDate

    @Column(name = "his_sync_status", nullable = true)
    Character hisSyncStatus

    @Column(name = "his_provider", nullable = true)
    String hisProvider

    @Column(name = "match_id", nullable = false)
    Long matchId

    @NotNull
    @OneToMany(mappedBy="patient", fetch = FetchType.EAGER)
    private Set<PatientServiceIdentifier> identifiers
}
