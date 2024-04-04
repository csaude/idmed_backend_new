package mz.org.csaude.idmed.repositories.stockCenter

import com.github.javaparser.quality.NotNull
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.stockCenter.StockCenter

@Repository
interface StockCenterRepository extends CrudRepository<StockCenter, String> {

    @Override
    List<StockCenter> findAll();

    Optional<StockCenter> findById(@NotNull String id);

    List<StockCenter> list();


}