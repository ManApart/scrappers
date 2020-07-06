package org.rak.scrappers

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping
class BaseController {

    @GetMapping
    fun getRoot(response: HttpServletResponse) {
        response.sendRedirect("/swagger-ui.html#/battle-controller")
    }

}