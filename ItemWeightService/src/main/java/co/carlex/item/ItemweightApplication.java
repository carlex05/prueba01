package co.carlex.item;

import co.carlex.item.readers.ItemWeightReader;
import co.carlex.item.readers.impls.ItemWeightReaderImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ItemweightApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemweightApplication.class, args);
	}
    
    /**
     * Permite inyectar la implementación de {@link ItemWeightReader}
     * @return 
     */
    @Bean
    public ItemWeightReader getReader(){
        return new ItemWeightReaderImpl();
    }

}
