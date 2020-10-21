/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.general.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.general.bean.entidades.ProvinciaBean;
import pe.gob.mimp.general.bean.entidades.ProvinciaCoordenadasBean;
import pe.gob.mimp.general.converter.ProvinciaCast;
import pe.gob.mimp.general.converter.ProvinciaCoordenadasCast;
import pe.gob.mimp.general.model.Provincia;
import pe.gob.mimp.general.model.ProvinciaCoordenadas;
import pe.gob.mimp.general.repository.provinciacoordenadas.ProvinCoordRepository;
import pe.gob.mimp.general.service.ProvinciaCoordenadasService;
import pe.gob.mimp.general.util.Util;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ProvinciaCoordenadasServiceImpl implements ProvinciaCoordenadasService {

    @Autowired
    private ProvinCoordRepository provinciaCoordenadasRepository;

    @Override
    public List<ProvinciaCoordenadasBean> obtenerCoordenadas(ProvinciaBean provinciaBean) throws Exception {

        Provincia provincia = ProvinciaCast.castProvinciaBeanToProvincia(provinciaBean);
        
        List<ProvinciaCoordenadas> provinciaCoordenadasList = provinciaCoordenadasRepository.obtenerCoordenadas(provincia);

        if (Util.esListaVacia(provinciaCoordenadasList)) {
            return null;
        }

        return provinciaCoordenadasList.stream().map(provinciaCoordenadas -> {
            return ProvinciaCoordenadasCast.castProvinciaCoordenadasToProvinciaCoordenadasBean(provinciaCoordenadas);
        }).collect(Collectors.toList());
    }

}
