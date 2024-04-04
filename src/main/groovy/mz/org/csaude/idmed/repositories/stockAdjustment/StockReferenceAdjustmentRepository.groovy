package mz.org.csaude.idmed.repositories.stockAdjustment

import com.github.javaparser.quality.NotNull
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.stockAdjustment.StockReferenceAdjustment

@Repository
interface StockReferenceAdjustmentRepository extends CrudRepository<StockReferenceAdjustment, String> {

    @Override
    List<StockReferenceAdjustment> findAll();

    Optional<StockReferenceAdjustment> findById(@NotNull String id);


}