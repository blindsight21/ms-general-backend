/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.general.service;

import java.util.List;
import pe.gob.mimp.general.bean.entidades.DepartamentoBean;
import pe.gob.mimp.general.bean.entidades.DepartamentoCoordenadasBean;

/**
 *
 * @author Omar
 */
public interface DepartamentoCoordenadasService {

    List<DepartamentoCoordenadasBean> obtenerCoordenadas(DepartamentoBean departamentoBean) throws Exception;
}
