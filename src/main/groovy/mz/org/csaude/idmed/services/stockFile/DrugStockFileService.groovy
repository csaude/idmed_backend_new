package mz.org.csaude.idmed.services.stockFile

import jakarta.inject.Singleton
import mz.org.csaude.idmed.domains.stockFile.DrugStockFile
import mz.org.csaude.idmed.domains.stockFile.DrugStockFileBatch
import mz.org.csaude.idmed.dtos.stockFile.DrugStockFileBatchDTO
import mz.org.csaude.idmed.dtos.stockFile.DrugStockFileDTO
import mz.org.csaude.idmed.repositories.stockFile.DrugStockFileRepository

import java.text.DateFormatSymbols
import java.util.stream.Collectors

@Singleton
class DrugStockFileService {

    DrugStockFileRepository drugStockFileRepository

    DrugStockFileService(DrugStockFileRepository drugStockFileRepository1) {
        this.drugStockFileRepository = drugStockFileRepository1
    }

    def List<DrugStockFile> getDrugSumaryEvents(String clinicId, String drugId) {

        DateFormatSymbols symbols = new DateFormatSymbols(java.util.Locale.forLanguageTag("pt-BR"));
        String[] monthNames = symbols.getMonths();
        List<DrugStockFile> drugStockFileEventArrayList = drugStockFileRepository.getDrugSumaryEvents(clinicId, drugId)
        List<DrugStockFileDTO> stockDTOList = drugStockFileEventArrayList.stream()
                .map(DrugStockFileDTO::new)
                .collect(Collectors.toList());
        for (int i = 0; i < stockDTOList.size(); i++) {
            DrugStockFileDTO stockFileDTO = stockDTOList[i]
            String monthName = monthNames[Double.parseDouble(stockFileDTO.month).intValue() - 1]
            stockFileDTO.month = monthName
            if (!stockDTOList.isEmpty()) {
                if (i == 0) {
                    stockFileDTO.calculateBalance(stockFileDTO.getBalance())
                } else {
                    stockFileDTO.calculateBalance(stockDTOList.get(i - 1).getBalance())
                }
            } else {
                stockFileDTO.balance = (stockFileDTO.incomes + stockFileDTO.posetiveAdjustment) - (stockFileDTO.outcomes + stockFileDTO.negativeAdjustment + stockFileDTO.loses)
            }
        }
        return stockDTOList

    }

    List<DrugStockFileBatch> getDrugBatchSumaryEvents(String clinicId, String stockId) {
        List<DrugStockFileBatch> recordsBatch = drugStockFileRepository.getDrugBatchSumaryEvents(clinicId, stockId)
        List<DrugStockFileBatchDTO> recordsDTO = recordsBatch.stream()
                .map(DrugStockFileBatchDTO::new)
                .collect(Collectors.toList());
        for (int i = 0; i < recordsDTO.size(); i++) {
            DrugStockFileBatchDTO stockFileDTO = recordsDTO[i]
            if (!recordsDTO.isEmpty()) {
                if (i == 0) {
                    stockFileDTO.calculateBalance(stockFileDTO.getBalance())
                } else {
                    stockFileDTO.calculateBalance(recordsDTO.get(i - 1).getBalance())
                }
            } else {
                stockFileDTO.balance = (stockFileDTO.incomes + stockFileDTO.posetiveAdjustment) - (stockFileDTO.outcomes + stockFileDTO.negativeAdjustment + stockFileDTO.loses)
            }
        }
        return recordsDTO
    }

}
