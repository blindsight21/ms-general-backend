/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.general.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.general.bean.FindAllByFieldBean;
import pe.gob.mimp.general.bean.entidades.DistritoBean;
import pe.gob.mimp.general.bean.entidades.ProvinciaBean;

/**
 *
 * @author Omar
 */
public interface DistritoService {

    List<DistritoBean> obtenerActivos() throws Exception;

    DistritoBean find(BigDecimal id) throws Exception;
    
    List<DistritoBean> findAllByField(FindAllByFieldBean findAllByFieldBean) throws Exception;
    
    List<DistritoBean> obtenerDistritos(ProvinciaBean provinciaBean) throws Exception;
}
