package mz.org.csaude.idmed.dtos.stock

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.stock.Stock

import java.time.LocalDateTime

@Serdeable
class StockDTO {
    String id
    LocalDateTime expireDate
    Boolean modified
    String shelfNumber
    Integer unitsReceived
    Integer stockMoviment
    String manufacture
    String batchNumber
    Boolean hasUnitsRemaining

    StockDTO(Stock stock) {
        this.id = stock.id
        this.expireDate = stock.expireDate
        this.modified = stock.modified
        this.shelfNumber = stock.shelfNumber
        this.unitsReceived = stock.unitsReceived
        this.stockMoviment = stock.stockMoviment
        this.manufacture = stock.manufacture
        this.batchNumber = stock.batchNumber
        this.hasUnitsRemaining = stock.hasUnitsRemaining
       // this.drug = new DrugDTO(stock.drug)
        //this.center = stock.center
      //  this.clinic = stock.clinic
       // this.stockEntranceDTO= new StockEntranceDTO(stock.getStockEntrance())
    }

    StockDTO(String  idStock) {
        this.id = idStock
    }
}
