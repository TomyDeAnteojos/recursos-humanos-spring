package tda.rh.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import tda.rh.entidades.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
