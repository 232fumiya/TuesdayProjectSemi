package UserRegister.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by KAJIWARAYutaka on 2015/05/02.
 */
@Controller
@RequestMapping("/users/complete")
public class complete {
    @RequestMapping(method = RequestMethod.GET)
    public String pageShow(){
       return "delete";
    }
}
