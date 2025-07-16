package tda.rh.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.rh.entidades.Empleado;
import tda.rh.excepciones.RecursoNoEncontradoExcepcion;
import tda.rh.servicios.ImplEmpleadoServicio;

import java.util.List;

@RestController
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000") //para recibir peticiones de otro puerto(react)
public class EmpleadoControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private ImplEmpleadoServicio empleadoServicio;

    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        var empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return empleados;
    }
    
    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("Empleado a agregar: " + empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado>
            obtenerEmpleadoPorId(@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if(empleado == null)
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: "+ id);
        return ResponseEntity.ok(empleado);
    }
}
