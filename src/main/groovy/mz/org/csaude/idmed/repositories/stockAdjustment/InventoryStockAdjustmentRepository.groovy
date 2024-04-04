package mz.org.csaude.idmed.repositories.stockAdjustment

import com.github.javaparser.quality.NotNull
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mz.org.csaude.idmed.domains.stockAdjustment.InventoryStockAdjustment

@Repository
interface InventoryStockAdjustmentRepository extends CrudRepository<InventoryStockAdjustment, String> {


    List<InventoryStockAdjustment> findAll();

    Optional<InventoryStockAdjustment> findById(@NotNull String id);

    @Query(value ="select * from stock_adjustment adjusts where adjusts.inventory_id =:inventoryId", nativeQuery = true)
    List<InventoryStockAdjustment> findByInventory(String inventoryId);



}