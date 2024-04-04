package mz.org.csaude.idmed.services.stockOperation

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.stockOperationType.StockOperationType
import mz.org.csaude.idmed.dtos.stockOperationType.StockOperationTypeDTO
import mz.org.csaude.idmed.repositories.stockOperationType.StockOperationTypeRepository

import java.util.stream.Collectors

@Singleton
class StockOperationTypeService {

    private final StockOperationTypeRepository stockOperationTypeRepository

    StockOperationTypeService(StockOperationTypeRepository stockOperationTypeRepository1) {
        this.stockOperationTypeRepository = stockOperationTypeRepository1
    }

    @Transactional
    List<StockOperationTypeDTO> findAllDTO() {
        List<StockOperationType> stockOperationTypeList = stockOperationTypeRepository.findAll();
        List<StockOperationTypeDTO> operations = stockOperationTypeList.stream()
                .map(StockOperationTypeDTO::new)
                .collect(Collectors.toList());
        return operations;
    }


}
