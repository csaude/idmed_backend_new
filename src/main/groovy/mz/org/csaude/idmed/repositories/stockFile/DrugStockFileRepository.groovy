package mz.org.csaude.idmed.repositories.stockFile


import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.stockFile.DrugStockFile
import mz.org.csaude.idmed.domains.stockFile.DrugStockFileBatch

interface DrugStockFileRepository extends CrudRepository<DrugStockFile, String> {

   // @Query("from drug_stock_summary_vw   where drugId = :drugId   and clinicId = :clinicId  order by year asc, month asc")
    List<DrugStockFile> getDrugSumaryEvents(String clinicId, String drugId )

     List<DrugStockFileBatch> getDrugBatchSumaryEvents(String clinicId, String stockId)

}