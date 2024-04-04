package mz.org.csaude.idmed.repositories.stockRefered

import com.github.javaparser.quality.NotNull
import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.stockRefered.ReferedStockMoviment

interface ReferedStockMovimentRepository extends CrudRepository<ReferedStockMoviment, String> {

    @Override
    List<ReferedStockMoviment> findAll();

    Optional<ReferedStockMoviment> findById(@NotNull String id);

    List<ReferedStockMoviment> list();
}