package mz.org.csaude.idmed.repositories.stockEntrance

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import jakarta.validation.constraints.NotNull
import mz.org.csaude.idmed.domains.stockentrance.StockEntrance

@Repository
interface StockEntranceRepository extends CrudRepository<StockEntrance, String> {

   @Override
    List<StockEntrance> findAll();

    @Query(value ="select se from stock_entrance se where se.clinic_id =: clinicId limit :max offset :offset  ", nativeQuery = true)
    List<StockEntrance> findAllByClinic(@NotNull String clinicId, int offset, int max)
}