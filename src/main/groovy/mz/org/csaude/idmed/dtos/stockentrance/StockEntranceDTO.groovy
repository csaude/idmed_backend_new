package mz.org.csaude.idmed.dtos.stockentrance

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.stock.Stock
import mz.org.csaude.idmed.domains.stockentrance.StockEntrance
import mz.org.csaude.idmed.dtos.stock.StockDTO

import java.time.LocalDateTime

@Serdeable
class StockEntranceDTO {
    String id
    String orderNumber
    LocalDateTime dateReceived
    String  clinic_id
    LocalDateTime creationDate
    String notes
    List<StockDTO> stocks = new ArrayList<>()

    StockEntranceDTO(StockEntrance stockEntrance) {
        this.id = stockEntrance.getId()
        this.orderNumber = stockEntrance.getOrderNumber()
        this.dateReceived =stockEntrance.getDateReceived()
        this.clinic_id = stockEntrance.clinic.id== null?"":stockEntrance.clinic.id
        this.creationDate = stockEntrance.getCreationDate()
        this.notes = stockEntrance.notes ==null? "-": stockEntrance.notes
           for (Stock stock: stockEntrance.getStocks()) {
             stocks.add(new StockDTO(stock.id))
          }

    }
}
