package mz.org.csaude.idmed.domains.clinic

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import mz.org.csaude.idmed.domains.clinicSector.ClinicSector
import mz.org.csaude.idmed.domains.distribuicaoAdministrativa.District
import mz.org.csaude.idmed.domains.distribuicaoAdministrativa.Province
import mz.org.csaude.idmed.domains.facilityType.FacilityType

@Entity(name = "Clinic")
@Serdeable
class Clinic {

   // final String ID = "ID"
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    String id

    @NotEmpty
    @Column(name = "code", nullable = false, unique = true)
    String code

    @Column(name = "notes", nullable = true)
    String notes

    @Size(min = 9, max = 12)
    @Column(name = "telephone", nullable = true)
    String telephone

    @NotEmpty
    @Column(name = "clinic_name", nullable = false)
    String clinicName

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "province_id")
    Province province

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "district_id")
    District district


    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "facility_type_id")
    FacilityType facilityType


    @Column(name = "national_clinic")
    boolean nationalClinic

    @Column(name = "main_clinic")
    boolean mainClinic

    @Column(name = "active")
    boolean active

    @Column(name = "uuid")
    String uuid

    @OneToMany(cascade = CascadeType.ALL)
    List<ClinicSector> sectors

   // static belongsTo = [NationalClinic, SecUser]
   // static hasMany = [sectors: ClinicSector, mmiaReports: MmiaReport, users: SecUser]



/*
    static constraints = {
        code nullable: false
        notes nullable: true, blank: true
        telephone nullable: true, matches: /\d+/, maxSize: 12, minSize: 9
        clinicName nullable: false, unique: ['province','district']
        sectors nullable: true
        nationalClinic nullable: true
        uuid unique: true
    }
*/
    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Clinic clinic = (Clinic) o

        if (clinicName != clinic.clinicName) return false
        if (code != clinic.code) return false
        if (id != clinic.id) return false

        return true
    }


}
