package by.hotel.controller;

import by.hotel.service.CrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.ReviewServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class AddEntity   {
    private static final Logger logger = LogManager.getLogger(AddEntity.class.getName());

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Object execute(HttpServletRequest req){
        Object result;
        Map<String, String[]> requestParams = req.getParameterMap();
        try {
            if (requestParams.get("tableName")[0].equals("review")) {
                ReviewServiceImpl reviewService = new ReviewServiceImpl();
                result = reviewService.addEntity(reviewService.buildReview(requestParams));
                //resultList = reviewService.getAllEntities();
            } else {
                CrudService service = CrudServiceMapper.getService(requestParams.get("tableName")[0]);
                result = service.addEntity(service.buildEntity(requestParams));
            }
        }catch (ServiceException e){
            logger.error(e);
            result = e.getMessage().substring(e.getMessage().lastIndexOf(":")+1);
        } catch (NumberFormatException e) {
            result = "Incorrect data!";
        }
        return result;
    }
}
