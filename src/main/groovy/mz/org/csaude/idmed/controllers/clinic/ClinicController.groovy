package mz.org.csaude.idmed.controllers.clinic

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import mz.org.csaude.idmed.domains.clinic.Clinic
import mz.org.csaude.idmed.dtos.clinic.ClinicDTO
import mz.org.csaude.idmed.services.clinic.ClinicService


@Controller('/api/clinic')
@Transactional
class ClinicController {

    @Inject
    ClinicService clinicService;

   // @Secured(SecurityRule.IS_ANONYMOUS)
    //@ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON))
    @Get()
    List<ClinicDTO> getAll(){

       // List<ClinicDTO> careers = new ArrayList<>();
        List<ClinicDTO> clinics =   clinicService.findAllDTO()

        /*
        if(limit > 0){
            careers = careerService.findCareerWithLimit(limit, offset);
        }else {
            careers = careerService.findAll();
        }
       */
        return clinics;
    }

    @Post()
    Clinic save(@Body Clinic clinic){
       return clinicService.save(clinic)
    }
}
