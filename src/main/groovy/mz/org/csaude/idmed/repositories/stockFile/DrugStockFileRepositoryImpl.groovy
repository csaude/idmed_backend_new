package mz.org.csaude.idmed.repositories.stockFile


import io.micronaut.data.annotation.Repository
import jakarta.inject.Inject
import jakarta.persistence.EntityManager
import mz.org.csaude.idmed.domains.stockFile.DrugStockFile
import mz.org.csaude.idmed.domains.stockFile.DrugStockFileBatch

@Repository
abstract class DrugStockFileRepositoryImpl implements  DrugStockFileRepository {

    @Inject
    EntityManager entityManager

    @Override
    List<DrugStockFile> getDrugSumaryEvents(String clinicId, String drugId ) {

        List<DrugStockFile> results = entityManager.createQuery("SELECT p FROM drug_stock_summary_vw p " +
                " WHERE clinicId  =:clinicId "+
                " and  drugId  =:drugId  order by year asc, month asc ")
                .setParameter("clinicId", clinicId)
                .setParameter("drugId", drugId)
                .getResultList();

        return results
    }


    def List<DrugStockFileBatch> getDrugBatchSumaryEvents(String clinicId, String stockId) {

        String queryString = "select p  " +
                "from drug_stock_batch_summary_vw  p " +
                "where stockId = :stockId " +
                "   and clinicId = :clinicId " +
                "order by eventDate asc"


        def list = entityManager.createQuery(queryString).setParameter("stockId", stockId)
        .setParameter("clinicId", clinicId)
                .getResultList();

        return list.reverse()
    }

}