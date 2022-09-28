package sejong.covid.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sejong.covid.domain.KoreaCovid;
import sejong.covid.service.CovidService;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final CovidService covidService;

    @GetMapping("/")
    public String main(Model model) throws IOException{
        List<KoreaCovid> koreaCovidList = covidService.getCovidData();
        model.addAttribute("koreaCovid", koreaCovidList);

        return "main";
    }
}
