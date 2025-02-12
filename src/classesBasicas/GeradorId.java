package classesBasicas;

import java.util.Random; 

public class GeradorId {
	
	public static String geradorHexId(int tam) {
        Random random = new Random();
        StringBuilder hexBuilder = new StringBuilder();

       
        for (int i = 0; i < tam; i++) {
            int randomInt = random.nextInt(16); 
            hexBuilder.append(Integer.toHexString(randomInt));
        }

        return hexBuilder.toString();
    }
	
}
