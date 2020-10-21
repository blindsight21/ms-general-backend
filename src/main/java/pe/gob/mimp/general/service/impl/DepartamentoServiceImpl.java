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
import pe.gob.mimp.general.converter.DepartamentoCast;
import pe.gob.mimp.general.model.Departamento;
import pe.gob.mimp.general.repository.departamento.DepartamentoRepository;
import pe.gob.mimp.general.service.DepartamentoService;
import pe.gob.mimp.general.util.Util;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<DepartamentoBean> obtenerDepartamentos() throws Exception {

        List<Departamento> departamentoList = departamentoRepository.obtenerDepartamentos();
        
        if(Util.esListaVacia(departamentoList)){
            return null;
        }
        
        return departamentoList.stream().map(departamento -> {
            return DepartamentoCast.castDepartamentoToDepartamentoBean(departamento);
        }).collect(Collectors.toList());
    }

    @Override
    public List<DepartamentoBean> obtenerActivos() throws Exception {

        List<Departamento> departamentoList = departamentoRepository.obtenerActivos();
        
        if(Util.esListaVacia(departamentoList)){
            return null;
        }
        
        return departamentoList.stream().map(departamento -> {
            return DepartamentoCast.castDepartamentoToDepartamentoBean(departamento);
        }).collect(Collectors.toList());
    }

    @Override
    public DepartamentoBean find(BigDecimal id) throws Exception {

        if (id == null) {
            return null;
        }

        Optional<Departamento> correoPersonaSiscap = departamentoRepository.findById(id);

        if (!correoPersonaSiscap.isPresent()) {
            return null;
        }

        return DepartamentoCast.castDepartamentoToDepartamentoBean(correoPersonaSiscap.get());

    }

    @Override
    public List<DepartamentoBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<Departamento> departamentoList = departamentoRepository.findAllByField(findAllByFieldBean.getField(), findAllByFieldBean.getValue());

        if(Util.esListaVacia(departamentoList)){
            return null;
        }
        
        return departamentoList.stream().map(departamento -> {
            return DepartamentoCast.castDepartamentoToDepartamentoBean(departamento);
        }).collect(Collectors.toList());
    }

}
