/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.general.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.general.bean.FindAllByFieldBean;
import pe.gob.mimp.general.bean.entidades.DepartamentoBean;

/**
 *
 * @author Omar
 */
public interface DepartamentoService {

    List<DepartamentoBean> obtenerDepartamentos() throws Exception;
    
    List<DepartamentoBean> obtenerActivos() throws Exception;

    DepartamentoBean find(BigDecimal id) throws Exception;
    
    List<DepartamentoBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception;
}
