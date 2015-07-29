package UserRegister;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import UserRegister.Repository.UserRepository;
import UserRegister.model.Student;

@SpringBootApplication
public class UserRegisterApplication implements CommandLineRunner{
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserRegisterApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Student student = new Student();
        //Create
        student.setId(20511091);
        student.setName("かじわら ゆたか");
        student.setPass("1");
        userRepository.save(student);
        //Select(Read)
        student = userRepository.findOne(20511091);
        System.out.println("User ID = " + student.getId());
        System.out.println("User Name = " + student.getName());
        System.out.println("User pass="+student.getPass());
        //Update
        student.setName("梶原 裕");
        userRepository.save(student);
        //Select
        student = userRepository.findOne(20511091);
        System.out.println("User ID = " + student.getId());
        System.out.println("User Name = " + student.getName());
        System.out.println("User pass="+student.getPass());
        //Delete
        System.out.println("Delete User ? y/N");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if(answer.equals("y")){
            userRepository.delete(student);
        }

    }
}
