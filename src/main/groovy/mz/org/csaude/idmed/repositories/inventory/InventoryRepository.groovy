package mz.org.csaude.idmed.repositories.inventory

import com.github.javaparser.quality.NotNull
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.inventory.Inventory

@Repository
interface InventoryRepository extends CrudRepository<Inventory, String> {

    @Override
    //@Query(" from inventory inv INNER JOIN  inventoryStockAdjustment adjs on inv.id = adjs.inventory.id ")
    List<Inventory> findAll();

    Optional<Inventory> findById(@NotNull String id);

    @Query(value = "select inv from inventory inv where inv.clinic_id =:clinicId  limit :max offset :offset  ",  nativeQuery = true)
    List<Inventory> getAllByClinicId(String clinicId, int offset, int max)

    @Query("select i from inventory i  where  i.clinic =: clinic and i.open = false order by i.endDate desc ")
    List<Inventory> getClosedInventories(Clinic clinic)

}