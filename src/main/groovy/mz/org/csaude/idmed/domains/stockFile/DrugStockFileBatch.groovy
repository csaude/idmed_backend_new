package mz.org.csaude.idmed.domains.stockFile


import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "drug_stock_batch_summary_vw")
class DrugStockFileBatch {

    @Id

    @Column(name = "eventDate")
    String eventDate


    @Column(name = "drug_id")
    String drugId

    @Column(name = "clinic_id")
    String clinicId

    @Column(name = "moviment")
    String moviment

    @Column(name = "incomes")
    long incomes

    @Column(name = "outcomes")
    long outcomes

    @Column(name = "posetiveadjustment")
    long posetiveAdjustment

    @Column(name = "negativeadjustment")
    long negativeAdjustment

    @Column(name = "loses")
    long loses


    @Column(name = "code")
    String code

    @Column(name = "stock")
    String stockId


}
