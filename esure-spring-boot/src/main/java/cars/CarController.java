package cars;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONArray; 

/*
* input: receives RESTful URL request in the form /car?colour=red
* calls JsonLoad class with input request info (i.e. colour=red)
* output: JSONArray of data that matches input request
*/

@RestController
public class CarController {

   @RequestMapping("/car")
   public JSONArray car(@RequestParam(value="colour", defaultValue="blue") String colour) {
      JsonLoad jl = new JsonLoad();
      JSONArray jsonArray = jl.getCarData(colour);

      return jsonArray;
   }
}