package mz.org.csaude.idmed.repositories.form

import com.github.javaparser.quality.NotNull
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.form.Form

@Repository
interface FormRepository extends CrudRepository<Form, String> {

    @Override
    List<Form> findAll();

    Optional<Form> findById(@NotNull String id);

    List<Form> list();

}