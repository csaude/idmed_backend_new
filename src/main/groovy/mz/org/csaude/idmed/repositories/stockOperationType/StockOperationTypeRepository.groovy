package mz.org.csaude.idmed.repositories.stockOperationType

import com.github.javaparser.quality.NotNull
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.stockOperationType.StockOperationType

@Repository
interface StockOperationTypeRepository extends CrudRepository<StockOperationType, String> {

    @Override
    List<StockOperationType> findAll();

    Optional<StockOperationType> findById(@NotNull String id);

    List<StockOperationType> list();
}