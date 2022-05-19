/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;


import ObjetoNegocio.Cliente;

/**
 *
 * @author Jarol
 */
public class FabricaDatos  {
     private static IDatos datos;

 
    
 
    public static IDatos dameInstancia()

    {
         if(datos== null){
            datos= new FachadaDatos();
        }
      return datos;
    }
    
  
}
