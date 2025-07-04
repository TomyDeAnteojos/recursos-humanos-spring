package tda.rh.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import tda.rh.entidades.Empleado;
import tda.rh.repositorio.EmpleadoRepositorio;

import java.util.List;

public class EmpleadoServicio implements ImplEmpleadoServicio{
    @Autowired
    EmpleadoRepositorio empleadoRepositorio;
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
        return empleadoRepositorio.findById(idEmpleado).orElse(null);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }
}
