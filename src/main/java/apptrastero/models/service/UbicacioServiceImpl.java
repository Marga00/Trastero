package apptrastero.models.service;

import apptrastero.models.entity.Ubicacio;
import apptrastero.models.repository.UbicacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacioServiceImpl implements IUbicacioService {

    @Autowired
    private UbicacioRepository ubicacioRepository;

    @Override
    public List<Ubicacio> listaUbicaciones() {
        return (List<Ubicacio>) ubicacioRepository.findAll();
    }
}
