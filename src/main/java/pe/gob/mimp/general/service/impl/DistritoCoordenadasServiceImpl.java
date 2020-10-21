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
import pe.gob.mimp.general.bean.entidades.DistritoBean;
import pe.gob.mimp.general.bean.entidades.DistritoCoordenadasBean;
import pe.gob.mimp.general.converter.DistritoCast;
import pe.gob.mimp.general.converter.DistritoCoordenadasCast;
import pe.gob.mimp.general.model.Distrito;
import pe.gob.mimp.general.model.DistritoCoordenadas;
import pe.gob.mimp.general.repository.distritocoordenadas.DistritoCoordRepository;
import pe.gob.mimp.general.service.DistritoCoordenadasService;
import pe.gob.mimp.general.util.Util;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DistritoCoordenadasServiceImpl implements DistritoCoordenadasService {

    @Autowired
    private DistritoCoordRepository distritoCoordenadasRepository;

    @Override
    public List<DistritoCoordenadasBean> obtenerCoordenadas(DistritoBean distritoBean) throws Exception {

        Distrito distrito = DistritoCast.castDistritoBeanToDistrito(distritoBean);
        
        List<DistritoCoordenadas> distritoCoordenadasList = distritoCoordenadasRepository.obtenerCoordenadas(distrito);

        if (Util.esListaVacia(distritoCoordenadasList)) {
            return null;
        }

        return distritoCoordenadasList.stream().map(distritoCoordenadas -> {
            return DistritoCoordenadasCast.castDistritoCoordenadasToDistritoCoordenadasBean(distritoCoordenadas);
        }).collect(Collectors.toList());
    }

}
