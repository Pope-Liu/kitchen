//Author:刘行
package whu.kitchen.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.kitchen.Repository.CollectionsRepository;

@Service
public class CollectionsService {
    @Autowired
    private CollectionsRepository collectionsRepository;
    
}
