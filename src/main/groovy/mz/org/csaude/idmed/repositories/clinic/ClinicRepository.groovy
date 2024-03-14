package mz.org.csaude.idmed.repositories.clinic

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.clinic.Clinic

@Repository
interface ClinicRepository extends CrudRepository<Clinic, String> {

    List<Clinic> findAll();

    Optional<Clinic> findById(@NotNull String id);

    Clinic findByCode(@NotNull String code)
}