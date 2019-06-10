/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import gestionbd.AsistenteBD;

/**
 *
 * @author RLCR
 */
public class Principal {
    
    /*DESCARGAR https://sqliteadmin.orbmu2k.de/*/
    public static void main(String[] args) {
        AsistenteBD db = new AsistenteBD();
        //db.crearBD();
        //db.crearTabla();
        db.insertarDato();
        //db.actualizarDato();
        //db.eliminarDato();
        db.mostrarDato();
    }
}
