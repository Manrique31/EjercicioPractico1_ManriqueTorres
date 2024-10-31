package EjercicioPractico1.demo.controller;

import EjercicioPractico1.demo.domain.Farmacia;
import EjercicioPractico1.demo.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/farmacia")
public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    @GetMapping("/listado")
    public String listarFarmacias(Model model) {
        var farmacias = farmaciaService.getFarmacias(false);
        model.addAttribute("farmacias", farmacias);
        model.addAttribute("totalFarmacias", farmacias.size());
        return "categoria/listado"; // Asegúrate de que el archivo listado.html esté en templates/farmacia
    }

    @GetMapping("/formulario")
    public String formularioSatisfaccion() {
        return "categoria/formulario"; // Asegúrate de que el archivo formulario.html esté en templates/farmacia
    }

    @GetMapping("/nuevo")
    public String nuevaFarmacia(Farmacia farmacia) {
        return "farmacia/modifica"; // Asegúrate de que el archivo modifica.html esté en templates/farmacia
    }

   @RestController
@RequestMapping("/categoria") // Asegúrate de que el controlador está mapeado a /categoria
public class CategoriaController {

    @Autowired
    private FarmaciaService farmaciaService;

    @PostMapping("/guardar")
    public String guardarFarmacia(Farmacia farmacia,
                                   @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            // Implementa lógica de guardado de la imagen si es necesario
        }
        farmaciaService.save(farmacia);
        return "redirect:/categoria/listado"; // Redirige a la lista de farmacias
    }
}


    @GetMapping("/eliminar/{idFarmacia}")
    public String eliminarFarmacia(Farmacia farmacia) {
        farmaciaService.delete(farmacia);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idFarmacia}")
    public String modificarFarmacia(Farmacia farmacia, Model model) {
        farmacia = (Farmacia) farmaciaService.getFarmacias(farmacia);
        model.addAttribute("farmacia", farmacia);
        return "categoria/modifica"; // Usa el nombre de la vista correspondiente
    }
}
