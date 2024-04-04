package mz.org.csaude.idmed.repositories.stockDestruction

import com.github.javaparser.quality.NotNull
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.stockdestruction.DestroyedStock

@Repository
interface DestroyedStockRepository extends CrudRepository<DestroyedStock, String> {

    @Override
    List<DestroyedStock> findAll();

    Optional<DestroyedStock> findById(@NotNull String id);

    List<DestroyedStock> list();


}