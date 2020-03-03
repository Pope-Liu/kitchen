//Author:刘行
package whu.kitchen.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import whu.kitchen.Service.CollectionsService;
import whu.kitchen.Service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CollectionsService collectionsService;

}
