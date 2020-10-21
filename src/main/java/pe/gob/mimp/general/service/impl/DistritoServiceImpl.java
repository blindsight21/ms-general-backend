/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.general.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.general.bean.FindAllByFieldBean;
import pe.gob.mimp.general.bean.entidades.DistritoBean;
import pe.gob.mimp.general.bean.entidades.ProvinciaBean;
import pe.gob.mimp.general.converter.DistritoCast;
import pe.gob.mimp.general.converter.ProvinciaCast;
import pe.gob.mimp.general.model.Distrito;
import pe.gob.mimp.general.model.Provincia;
import pe.gob.mimp.general.repository.distrito.DistritoRepository;
import pe.gob.mimp.general.service.DistritoService;
import pe.gob.mimp.general.util.Util;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public List<DistritoBean> obtenerActivos() throws Exception {

        List<Distrito> distritoList = distritoRepository.obtenerActivos();
        
        if(Util.esListaVacia(distritoList)){
            return null;
        }
        
        return distritoList.stream().map(distrito -> {
            return DistritoCast.castDistritoToDistritoBean(distrito);
        }).collect(Collectors.toList());
    }

    @Override
    public DistritoBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<Distrito> distrito = distritoRepository.findById(id);

        if (!distrito.isPresent()) {
            return null;
        }

        return DistritoCast.castDistritoToDistritoBean(distrito.get());

    }

    @Override
    public List<DistritoBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<Distrito> distritoList = distritoRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());

        if(Util.esListaVacia(distritoList)){
            return null;
        }
        
        return distritoList.stream().map(distrito -> {
            return DistritoCast.castDistritoToDistritoBean(distrito);
        }).collect(Collectors.toList());
    }
    
    @Override
    public List<DistritoBean> obtenerDistritos(ProvinciaBean provinciaBean) throws Exception {

        Provincia provincia = ProvinciaCast.castProvinciaBeanToProvincia(provinciaBean);
        
        List<Distrito> distritoList = distritoRepository.obtenerDistritos(provincia);
        
        if(Util.esListaVacia(distritoList)){
            return null;
        }
        
        return distritoList.stream().map(distrito -> {
            return DistritoCast.castDistritoToDistritoBean(distrito);
        }).collect(Collectors.toList());
    }

}
