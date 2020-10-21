/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.general.service;

import java.util.List;
import pe.gob.mimp.general.bean.entidades.ProvinciaBean;
import pe.gob.mimp.general.bean.entidades.ProvinciaCoordenadasBean;

/**
 *
 * @author Omar
 */
public interface ProvinciaCoordenadasService {

    List<ProvinciaCoordenadasBean> obtenerCoordenadas(ProvinciaBean provinciaBean) throws Exception;
}
