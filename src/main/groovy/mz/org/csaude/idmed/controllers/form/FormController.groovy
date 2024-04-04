package mz.org.csaude.idmed.controllers.form

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.dtos.form.FormDTO
import mz.org.csaude.idmed.services.form.FormService

@Controller('/api/form')
@Transactional
public class FormController {

    @Inject
    FormService formService

    @Get()
    List<FormDTO> getAll() {
        List<FormDTO> list = formService.findAllDTO()
        return list;
    }


}
