package co.carlex.item.controllers;

import co.carlex.item.services.DataPresentationService;
import co.carlex.item.services.ItemWeightService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author Carlex
 */
@RestController
@RequestMapping(path = "/travel")
public class TravelCalculatorController {
    
    @Autowired
    private ItemWeightService service;
    
    @Autowired
    private DataPresentationService responseService;
    
    /**
     * Con base en un archivo que es cargado en el sistema, genera un archivo de 
     * salida con el formato adecuado para indicar la cantidad máxima de viajes
     * por día
     * @param identification
     * @param file
     * @return Archivo de salida con el formato adecuado
     * @throws IOException 
     */
    @PostMapping(path = "calculate")
    public ResponseEntity<byte[]> calculateMaxTravels(@RequestParam("identification") String identification, 
            @RequestParam("inputFile") MultipartFile file) throws IOException{
        List<Short> travels = service.getMaxTravels(new String(file.getBytes()));
        String response = responseService.getResponse(travels);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"output.txt\"")
                .contentType(MediaType.TEXT_PLAIN)
                .body(response.getBytes());
    }

}
