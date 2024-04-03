package mz.org.csaude.idmed.services.form

import jakarta.inject.Singleton
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.form.Form
import mz.org.csaude.idmed.dtos.form.FormDTO
import mz.org.csaude.idmed.repositories.form.FormRepository

import java.util.stream.Collectors

@Singleton
class FormService {

    private final FormRepository formRepository

    FormService(FormRepository formRepository1) {
        this.formRepository = formRepository1
    }

    @Transactional
    List<FormDTO> findAllDTO(){
        List<Form> formList = formRepository.findAll();
        List<FormDTO> forms =formList.stream()
                .map(FormDTO::new)
                .collect(Collectors.toList());
        return forms;
    }

}
