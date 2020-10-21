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
import pe.gob.mimp.general.bean.entidades.DepartamentoBean;
import pe.gob.mimp.general.bean.entidades.ProvinciaBean;
import pe.gob.mimp.general.converter.DepartamentoCast;
import pe.gob.mimp.general.converter.ProvinciaCast;
import pe.gob.mimp.general.model.Departamento;
import pe.gob.mimp.general.model.Provincia;
import pe.gob.mimp.general.repository.provincia.ProvinciaRepository;
import pe.gob.mimp.general.service.ProvinciaService;
import pe.gob.mimp.general.util.Util;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<ProvinciaBean> obtenerActivos() throws Exception {

        List<Provincia> provinciaList = provinciaRepository.obtenerActivos();
        
        if (Util.esListaVacia(provinciaList)) {
            return null;
        }

        return provinciaList.stream().map(provincia -> {
            return ProvinciaCast.castProvinciaToProvinciaBean(provincia);
        }).collect(Collectors.toList());
        
    }

    @Override
    public ProvinciaBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<Provincia> correoPersonaSiscap = provinciaRepository.findById(id);

        if (!correoPersonaSiscap.isPresent()) {
            return null;
        }

        return ProvinciaCast.castProvinciaToProvinciaBean(correoPersonaSiscap.get());

    }

    @Override
    public List<ProvinciaBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<Provincia> provinciaList = provinciaRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());

        if (Util.esListaVacia(provinciaList)) {
            return null;
        }

        return provinciaList.stream().map(provincia -> {
            return ProvinciaCast.castProvinciaToProvinciaBean(provincia);
        }).collect(Collectors.toList());
    }

    @Override
    public List<ProvinciaBean> obtenerProvincias(DepartamentoBean departamentoBean) throws Exception {

        Departamento departamento = DepartamentoCast.castDepartamentoBeanToDepartamento(departamentoBean);
        
        List<Provincia> provinciaList = provinciaRepository.obtenerProvincias(departamento);
        
        if (Util.esListaVacia(provinciaList)) {
            return null;
        }

        return provinciaList.stream().map(provincia -> {
            return ProvinciaCast.castProvinciaToProvinciaBean(provincia);
        }).collect(Collectors.toList());
    }

}
