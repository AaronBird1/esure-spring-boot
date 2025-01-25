package cars;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.json.simple.JSONArray; 

@SpringBootTest
class carsApplicationTests {

	//tests that each colour request returns the correct number of cars
	@Test
	void testNumCars() {
		System.out.println("testNumCars running");
		
		JsonLoad jl = new JsonLoad();
		
		JSONArray testJsonArray = jl.getCarData("blue");
		assert(testJsonArray.size() == 4);
		
		testJsonArray = jl.getCarData("red");
		assert(testJsonArray.size() == 1);
		
		testJsonArray = jl.getCarData("black");
		assert(testJsonArray.size() == 3);
		
		testJsonArray = jl.getCarData("silver");
		assert(testJsonArray.size() == 1);
		
		testJsonArray = jl.getCarData("white");
		assert(testJsonArray.size() == 1);
		
		testJsonArray = jl.getCarData("orange");
		assert(testJsonArray.size() == 0);
		
		System.out.println("testNumCars tests passed!");
	}

}
