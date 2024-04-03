package mz.org.csaude.idmed.repositories.drug

import com.github.javaparser.quality.NotNull
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.drug.Drug

@Repository
interface DrugRepository extends  CrudRepository<Drug, String>{

    @Override
    List<Drug> findAll();

    Optional<Drug> findById(@NotNull String id);

    List<Drug> list();
}