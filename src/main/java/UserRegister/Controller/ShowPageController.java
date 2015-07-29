package UserRegister.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import UserRegister.Repository.UserRepository;
import UserRegister.model.Student;
import UserRegister.model.StudentForm;
/**
 * Created by KAJIWARAYutaka on 2015/05/02.
 */
@Controller
@RequestMapping("/users/toppage")
public class ShowPageController {
	@Autowired
    UserRepository userRepository;
    @ModelAttribute
    StudentForm setupForm(){
        return new StudentForm();
    }
	
    @RequestMapping(method = RequestMethod.GET)
    public String pageShow(Model model){
    Student student=loginUserController.User;
    if(student==null)
    	return "redirect:/users/login";
    model.addAttribute("student",student);
       return "index";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String register(@Validated StudentForm studentForm,BindingResult result){
        Student user = new Student();
        user.setId(studentForm.getId());
        user.setName(studentForm.getName());
        user.setPass(studentForm.getPass());
        userRepository.delete(user);
        return "redirect:/users/complete";
        
    }
}
