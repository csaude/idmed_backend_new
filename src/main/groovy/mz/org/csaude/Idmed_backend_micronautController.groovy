package mz.org.csaude

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/idmed_backend_micronaut")
class Idmed_backend_micronautController {

    @Get(uri = "/", produces = "text/plain")
    String index() {
        "Example Response"
    }
}