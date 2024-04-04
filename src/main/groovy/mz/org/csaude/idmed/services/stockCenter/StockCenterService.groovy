package mz.org.csaude.idmed.services.stockCenter

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockCenter.StockCenter
import mz.org.csaude.idmed.dtos.stockCenter.StockCenterDTO
import mz.org.csaude.idmed.repositories.stockCenter.StockCenterRepository

import java.util.stream.Collectors

@Singleton
class StockCenterService {

    private final StockCenterRepository stockCenterRepository

    StockCenterService(StockCenterRepository stockCenterRepository) {
        this.stockCenterRepository = stockCenterRepository
    }

    @Transactional
    List<StockCenterDTO> findAllDTO(){
        List<StockCenter> stockCenterList = stockCenterRepository.findAll();
        List<StockCenterDTO> listStockCenterDto = stockCenterList.stream()
                .map(StockCenterDTO::new)
                .collect(Collectors.toList());
        return listStockCenterDto;
    }


}
