package apptrastero.models.service;

import apptrastero.models.entity.Objecte;

import java.util.List;

public interface IObjecteService {

    public List<Objecte> listarTodos();
    public void guardar(Objecte objecte);
    public Objecte buscarPorId(Long id);
    public void eliminar(Long id);
}
