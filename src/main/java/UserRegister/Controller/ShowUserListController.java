package UserRegister.Controller;

import java.util.List;

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
@RequestMapping("/users/delete")
public class ShowUserListController {
    @Autowired
    UserRepository userRepository;
    @ModelAttribute
    StudentForm setupForm(){
        return new StudentForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String usersShow(Model model){
        List<Student> users = userRepository.findAll();
        model.addAttribute("users",users);
        return "userList";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String register(@Validated StudentForm studentForm,BindingResult result){
        if(result.hasErrors()){
        }
        Student student = new Student();
        student.setId(studentForm.getId());
        student.setName(studentForm.getName());
        student.setPass(studentForm.getPass());
        userRepository.delete(student);
        return "redirect:/users/login";
        
    }
}
