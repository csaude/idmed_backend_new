package mz.org.csaude.idmed.dtos.form

import io.micronaut.serde.annotation.Serdeable
import mz.org.csaude.idmed.domains.form.Form

@Serdeable
class FormDTO {
    String id
    String description
    String code

    FormDTO(Form form) {
        this.id = form.id
        this.code = form.code
        this.description= form.description
    }
}
