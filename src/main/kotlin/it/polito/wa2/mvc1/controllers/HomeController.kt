package it.polito.wa2.mvc1.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDateTime


@Controller
class HomeController {


    @GetMapping("/")
    fun home(m: Model): String {
        m.addAttribute("message", "Hello World!")
        m.addAttribute("date", LocalDateTime.now())
        return "home"
    }

    @GetMapping("/users/{id}")
    fun userDetails(model: Model, @PathVariable id: String, @RequestParam showDetails: Boolean?): String {
        model.addAttribute("userId", id)
        model.addAttribute("name", "User $id")
        model.addAttribute("age", id.length)
        model.addAttribute("showDetails", showDetails?:false)
        return "userDetails"
    }
}