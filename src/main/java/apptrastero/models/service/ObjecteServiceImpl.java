package apptrastero.models.service;


import apptrastero.models.entity.Objecte;
import apptrastero.models.repository.ObjecteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjecteServiceImpl implements IObjecteService {

    @Autowired
    private ObjecteRepository objecteRepository;

    @Override
    public List<Objecte> listarTodos() {
        return (List<Objecte>) objecteRepository.findAll();
    }

    @Override
    public void guardar(Objecte objecte) {
        objecteRepository.save(objecte);

    }

    @Override
    public Objecte buscarPorId(Long id) {
        return objecteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        objecteRepository.deleteById(id);

    }

}
