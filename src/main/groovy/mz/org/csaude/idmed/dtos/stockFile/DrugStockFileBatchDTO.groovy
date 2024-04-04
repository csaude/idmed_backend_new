package mz.org.csaude.idmed.dtos.stockFile

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.stockFile.DrugStockFileBatch

@Serdeable
class DrugStockFileBatchDTO {

    String id = UUID.randomUUID()
    String eventDate
    String month
    String moviment
    // String orderNumber
    long incomes
    long outcomes
    long posetiveAdjustment
    long negativeAdjustment
    long loses
    long balance
    //String notes
    String code
    String stockId

    void calculateBalance(long previousBalance) {
        this.balance =(previousBalance + incomes  + posetiveAdjustment) - ( outcomes + negativeAdjustment + loses )
    }

    DrugStockFileBatchDTO(DrugStockFileBatch  drugStockFile) {
        this.eventDate = drugStockFile.eventDate
        this.moviment =drugStockFile.moviment
        this.incomes = drugStockFile.incomes
        this.outcomes = drugStockFile.outcomes
        this.posetiveAdjustment = drugStockFile.posetiveAdjustment
        this.negativeAdjustment = drugStockFile.negativeAdjustment
        this.loses = drugStockFile.loses
        this.code = drugStockFile.code
        this.stockId = drugStockFile.stockId

    }




}
