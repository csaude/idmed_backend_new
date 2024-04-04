package mz.org.csaude.idmed.repositories.stock

import io.micronaut.data.annotation.Repository
import jakarta.inject.Inject
import jakarta.persistence.EntityManager
import mz.org.csaude.idmed.domains.drug.Drug
import mz.org.csaude.idmed.domains.stock.Stock
import mz.org.csaude.idmed.services.drug.DrugService

import java.time.LocalDateTime

@Repository
abstract class StockRepositoryImpl implements  StockRepository  {

    @Inject
    EntityManager entityManager

    @Inject
    DrugService drugService

    @Override
    List<Stock> getValidStocks(String drugId, LocalDateTime dateToCompare){
       Optional<Drug>  optionalDrug = drugService.findById(drugId)
        Drug drug = optionalDrug.get()
        LocalDateTime data = dateToCompare.plusDays(drug.packSize)
        String queryString = "select  s from stock  s " +
                " where s.expireDate > :prescriptionDate  AND " +
                " s.stockMoviment > 0  AND s.drug = :drug "


        def list = entityManager.createQuery(queryString).setParameter("prescriptionDate", data)
                .setParameter("drug", drug)
                .getResultList();

        return list



    }
}