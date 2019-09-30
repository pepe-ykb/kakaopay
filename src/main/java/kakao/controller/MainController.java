package kakao.controller;

import kakao.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class MainController {

    @Autowired
    private MainService mainService;

    @RequestMapping("/api1")
    public @ResponseBody String get1stAPI(Model model) {
        String result = mainService.get1stAPI();
        return result;
    }

    @RequestMapping("/api2")
    public @ResponseBody String get2ndAPI(Model model) {
        String result = mainService.get2ndAPI();
        return result;
    }

    @RequestMapping("/api3")
    public @ResponseBody String get3thAPI(Model model) {
        String result = mainService.get3thAPI();
        return result;
    }

    @RequestMapping("/api4")
    public @ResponseBody String get4thAPI(Model model, String code) {
        String result = mainService.get4thAPI(code);
        return result;
    }

}
