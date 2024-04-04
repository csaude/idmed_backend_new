package mz.org.csaude.idmed.dtos.stockFile

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.stockFile.DrugStockFile

@Serdeable
class DrugStockFileDTO {

    String id = UUID.randomUUID()
    String year
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

    DrugStockFileDTO(DrugStockFile  drugStockFile) {
        this.year = drugStockFile.year
        this.month = drugStockFile.month
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
