package mz.org.csaude.idmed.controllers.stockFile


import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.services.stockFile.DrugStockFileService


@Controller('/api/drugStockFile')
@Transactional
class DrugStockFileController {

    @Inject
    DrugStockFileService drugStockFileService

    @Get("/summary/{clinicId}/{drugId}")
    def getDrugSumaryEvents(@PathVariable ("clinicId")  String clinicId , @PathVariable ("drugId")   String drugId) {
        return drugStockFileService.getDrugSumaryEvents(clinicId, drugId)
    }

    @Get("/batchsummary/{clinicId}/{stockId}")
      def getDrugBatchSumaryEvents(@PathVariable ("clinicId") String clinicId, @PathVariable ("stockId") String stockId) {
          return drugStockFileService.getDrugBatchSumaryEvents(clinicId, stockId)
      }

}
