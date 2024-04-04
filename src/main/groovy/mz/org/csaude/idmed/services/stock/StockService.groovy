package mz.org.csaude.idmed.services.stock

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.drug.Drug
import mz.org.csaude.idmed.domains.stock.Stock
import mz.org.csaude.idmed.dtos.stock.StockDTO
import mz.org.csaude.idmed.repositories.stock.StockRepository

import java.time.LocalDate
import java.util.stream.Collectors

@Singleton
class StockService {

   private final StockRepository stockRepository
    //DrugRepository drugRepository
    StockService(StockRepository stockRepository1) {
        this.stockRepository = stockRepository1
    }

    def checkStockStatus(String idPrescribedDrug, LocalDate prescriptionDate, int qtyPrescribed) {
       def list = stockRepository.getValidStocks(idPrescribedDrug,prescriptionDate)
        if (list.size() > 0) {
            int qtyInStock = 0
            for (Stock stock in list) {
                qtyInStock = qtyInStock + stock.stockMoviment;
            }
            if (qtyInStock < qtyPrescribed) {
                return false;
            } else {
                return true;
            }
        } else {
            return false
        }
    }


    def findAllOnceReceivedByDrugDTO(Drug drug) {
        def stocks = stockRepository.findAllOnceReceivedByDrug(drug)
        List<StockDTO> stockDTOs = stocks.stream()
                .map(StockDTO::new) // Assuming ClinicDTO has a constructor that accepts a Clinic object
                .collect(Collectors.toList());
        return stockDTOs
    }

    def getValidStock(String idPrescribedDrug, LocalDate dateToCompare) {
        def list = stockRepository.getValidStocks(idPrescribedDrug, dateToCompare)

        List<StockDTO> stockDTOs = list.stream()
                .map(StockDTO::new)
                .collect(Collectors.toList());

        return stockDTOs

    }
    @Transactional
    List<StockDTO> findAllDTO(){
        List<Stock> stocks = stockRepository.findAll();
        List<StockDTO> stockDTOList = stocks.stream()
                .map(StockDTO::new)
                .collect(Collectors.toList());
        return stockDTOList;
    }

    @Transactional
    Stock save(Stock stock){
        return stockRepository.save(stock);
    }
    @Transactional
    Stock update(Stock stock){
        return stockRepository.update(stock);
    }

    @Transactional
    def delete(String idStock){
        Stock stock =stockRepository.findById(idStock)
        return stockRepository.delete(stock);
    }


}
