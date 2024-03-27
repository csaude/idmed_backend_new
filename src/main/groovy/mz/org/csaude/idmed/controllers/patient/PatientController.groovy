package mz.org.csaude.idmed.controllers.patient

import io.micronaut.http.annotation.Controller
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.services.patient.PatientService

@Controller('/api/patient')
@Transactional
class PatientController {

    @Inject
    PatientService clinicService
}
