package ventacomida.ProyectoPrograIII.controller;


import ventacomida.ProyectoPrograIII.model.DetalleVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ventacomida.ProyectoPrograIII.services.DetalleVentaService;

import java.util.List;

@RequestMapping("/api/detalles")
@RestController
@CrossOrigin(origins = "*")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public List<DetalleVenta> listarTodos() {
        return detalleVentaService.listarTodos();
    }

    @PostMapping
    public DetalleVenta guardar(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.guardar(detalleVenta);
    }

    @GetMapping("/{id}")
    public DetalleVenta obtenerPorId(@PathVariable Integer id) {
        return detalleVentaService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        detalleVentaService.eliminar(id);
    }
}
