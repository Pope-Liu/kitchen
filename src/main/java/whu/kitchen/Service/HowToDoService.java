//Author:刘行
package whu.kitchen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.kitchen.Repository.HowToDoRepository;

@Service
public class HowToDoService {
    @Autowired
    private HowToDoRepository howToDoRepository;

}
