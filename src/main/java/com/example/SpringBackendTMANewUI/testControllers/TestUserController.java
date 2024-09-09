package com.example.SpringBackendTMANewUI.testControllers;

import com.example.SpringBackendTMANewUI.models.User;
import com.example.SpringBackendTMANewUI.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestUserController {
    private final UserService userService;
    @Autowired
    public TestUserController(UserService userService) {
        this.userService = userService;
    }
    /*

     */
    @RequestMapping("/postUser")
    public String postData() throws JpaSystemException {
        /*
            {
            "name": "Leanne Graham",
            "username": "Bret",
            "email": "Sincere@april.biz",
            "phone": "1-700-736-8031 x56442",
            "company": "Romaguera-Crona",
            "website": "hildegard.org"
          },
         */
        //nap du lieu
        try{
            User user1=new User(1L,
                    "Leanne Graham",
                    "Bret",
                    "Sincere@april.biz",
                    "1-700-736-8031 x56442",
                    "Romaguera-Crona",
                    "hildegard.org");
            User user2=new User(2L,
                    "Ervin Howell",
                    "Antonette",
                    "Shanna@melissa.tv",
                    "010-692-6593 x09125",
                    "Deckow-Crist",
                    "anastasia.net");
            User user3=new User(3L,
                    "Clementine Baunch",
                    "Samantha",
                    "Nathan@yesenia.net",
                    "1-463-123-4447",
                    "Romaguera-Jacobson",
                    "ramior.info");
            User user4=new User(4L,
                    "Patricia Lebsack",
                    "Karianne",
                    "Julianne.OConner@kory.org",
                    "493-170-9623 x156",
                    "Robel-Corkery",
                    "kale.biz");
            userService.saveUser(user1);
            userService.saveUser(user2);
            userService.saveUser(user3);
            userService.saveUser(user4);
            return "Success";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
