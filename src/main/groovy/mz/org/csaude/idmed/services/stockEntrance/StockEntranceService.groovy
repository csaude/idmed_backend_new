package mz.org.csaude.idmed.services.stockEntrance

import io.micronaut.http.annotation.Body
import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.domains.stockentrance.StockEntrance
import mz.org.csaude.idmed.dtos.stockentrance.StockEntranceDTO
import mz.org.csaude.idmed.repositories.stockEntrance.StockEntranceRepository
import mz.org.csaude.idmed.services.clinic.ClinicService

import java.util.stream.Collectors

@Singleton
class StockEntranceService {

    private final StockEntranceRepository stockEntranceRepository

    StockEntranceService(StockEntranceRepository stockEntranceRepository) {
        this.stockEntranceRepository = stockEntranceRepository
    }
    @Inject
    ClinicService clinicService;

    List<StockEntranceDTO> getAllByClinicId(String clinicId, int offset, int max) {
        Clinic clinic = clinicService.findById(clinicId)
        def stockEntrances =  stockEntranceRepository.findAllByClinic(clinic, offset, max)
        List<StockEntranceDTO> stockEntranceDTOs = stockEntrances.stream()
                .map(StockEntranceDTO::new)
                .collect(Collectors.toList());
        return stockEntranceDTOs
    }
    @Transactional
    List<StockEntranceDTO> findAllDTO(){
        List<StockEntrance> stockEntrances = stockEntranceRepository.findAll();
        List<StockEntranceDTO> entrancesDTOList = stockEntrances.stream()
                .map(StockEntranceDTO::new)
                .collect(Collectors.toList());
        return entrancesDTOList;
    }
    @Transactional
    def save(@Body StockEntrance stockEntrance){
        return stockEntranceRepository.save(stockEntrance);
    }
    @Transactional
    def update(StockEntrance stockEntrace){
        return stockEntranceRepository.update(stockEntrace);
    }
    @Transactional
    def delete(String idStockEntrance){
        StockEntrance entrance =stockEntranceRepository.findById(idStockEntrance)
        return stockEntranceRepository.delete(entrance);
    }
}
