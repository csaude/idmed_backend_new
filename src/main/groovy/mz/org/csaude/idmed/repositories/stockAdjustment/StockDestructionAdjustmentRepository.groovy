package mz.org.csaude.idmed.repositories.stockAdjustment

import com.github.javaparser.quality.NotNull
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.stockAdjustment.StockDestructionAdjustment

@Repository
interface StockDestructionAdjustmentRepository extends CrudRepository<StockDestructionAdjustment, String> {

    @Override
    List<StockDestructionAdjustment> findAll();

    Optional<StockDestructionAdjustment> findById(@NotNull String id);



}