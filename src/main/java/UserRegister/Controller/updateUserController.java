package UserRegister.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import UserRegister.Repository.UserRepository;
import UserRegister.model.Student;
import UserRegister.model.updateForm;

@Controller
@RequestMapping("/users/update")
public class updateUserController {
    @Autowired
    UserRepository userRepository;

    @ModelAttribute
    updateForm setupForm(){
        return new updateForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showPage(){
    	if(loginUserController.User==null)
    		return "redirect:/users/login";
        return "update";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@Validated updateForm studentForm,BindingResult result){
        if(result.hasErrors()){
            return showPage();
        }
        Student student = loginUserController.User;
        student.setName(studentForm.getName());
        student.setPass(studentForm.getPass());
	    userRepository.save(student);
	    return "redirect:/users/toppage";
    }
        
    }
