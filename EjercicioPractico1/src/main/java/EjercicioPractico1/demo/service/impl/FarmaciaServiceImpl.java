package EjercicioPractico1.demo.service.impl;

import EjercicioPractico1.demo.dao.FarmaciaDao;
import EjercicioPractico1.demo.domain.Farmacia;
import EjercicioPractico1.demo.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FarmaciaServiceImpl implements FarmaciaService {

    @Autowired
    private FarmaciaDao farmaciaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Farmacia> getFarmacias(boolean activo) {
        var lista = farmaciaDao.findAll();
        return lista; // Devuelve toda la lista 
    }

    @Override
    @Transactional(readOnly = true)
    public Farmacia getFarmacias(Farmacia farmacia) {
        return farmaciaDao.findById(farmacia.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Farmacia farmacia) {
        farmaciaDao.save(farmacia);
    }

    @Override
    @Transactional
    public void delete(Farmacia farmacia) {
        farmaciaDao.delete(farmacia);
    }
}
