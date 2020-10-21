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
import pe.gob.mimp.general.bean.entidades.DepartamentoBean;
import pe.gob.mimp.general.bean.entidades.DepartamentoCoordenadasBean;
import pe.gob.mimp.general.converter.DepartamentoCast;
import pe.gob.mimp.general.converter.DepartamentoCoordenadasCast;
import pe.gob.mimp.general.model.Departamento;
import pe.gob.mimp.general.model.DepartamentoCoordenadas;
import pe.gob.mimp.general.repository.departamentocoordenadas.DepartCoordRepository;
import pe.gob.mimp.general.service.DepartamentoCoordenadasService;
import pe.gob.mimp.general.util.Util;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DepartamentoCoordenadasServiceImpl implements DepartamentoCoordenadasService {

    @Autowired
    private DepartCoordRepository departamentoCoordenadasRepository;

    @Override
    public List<DepartamentoCoordenadasBean> obtenerCoordenadas(DepartamentoBean departamentoBean) throws Exception {

        Departamento departamento = DepartamentoCast.castDepartamentoBeanToDepartamento(departamentoBean);

        List<DepartamentoCoordenadas> departamentoCoordenadasList = departamentoCoordenadasRepository.obtenerCoordenadas(departamento);

        if (Util.esListaVacia(departamentoCoordenadasList)) {
            return null;
        }

        return departamentoCoordenadasList.stream().map(departamentoCoordenadas -> {
            return DepartamentoCoordenadasCast.castDepartamentoCoordenadasToDepartamentoCoordenadasBean(departamentoCoordenadas);
        }).collect(Collectors.toList());
    }

}
