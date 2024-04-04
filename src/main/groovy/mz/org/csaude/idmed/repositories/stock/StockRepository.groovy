package mz.org.csaude.idmed.repositories.stock

import com.github.javaparser.quality.NotNull
import io.micronaut.data.annotation.Query
import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.drug.Drug
import mz.org.csaude.idmed.domains.stock.Stock

import java.time.LocalDateTime

interface StockRepository extends CrudRepository<Stock, String> {

    @Override
    List<Stock> findAll();

    Optional<Stock> findById(@NotNull String id);

    @Query("select s from stock s where s.unitsReceived > 0 and s.drug = :drug")
    List<Stock> findAllOnceReceivedByDrug(Drug drug)

   // @Query("select  s from stock  s  where s.expireDate > :dateToCompare  AND  s.stockMoviment > 0  AND s.drug = :drug order by s.expireDate asc")
    //List<Stock> getValidStockByDrugAndPickUpDate(Drug drug, LocalDate dateToCompare)

    List<Stock>  getValidStocks(String idPrescribedDrug, LocalDateTime dateToCompare)

}