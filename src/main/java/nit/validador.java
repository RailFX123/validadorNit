/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

/**
 *
 * @author victorm.gonzalez
 */
public class validador {

    public validador() {
    }
    
 
    public String nit(String nit) {
        String respuesta ="";
        String nit_ok = nit.trim().replace("-", "");
        
        if(nit.trim().replace("-", "").replace("/", "").toUpperCase().equals("CF")){
        respuesta = "correcto";
        } else{

//        Guarda el digito validador, el ultimo
        String dig_validador = nit_ok.charAt(nit_ok.length() - 1) + "";
//        Guarda el resto de numeros para sumar
        String dig_nit = nit_ok.substring(0, nit_ok.length() - 1);
//        Reverse invierte el orden de los digitos del original
//        El array inverso se refleja al original

        if(isValid(revert(dig_nit), dig_validador)){
         respuesta = "correcto";   
        }else respuesta = "incorrecto";
        }
        return respuesta + "--"+ nit;

    }
       
//      funcion para invertir la cadena
    private  String revert(String dig_nit) {
        String new_dig_nit = "";
        int largo = dig_nit.length();
        for (int i = 0; i < largo; i++) {
            new_dig_nit = dig_nit.charAt(i) + new_dig_nit;
        }

        return new_dig_nit;
    }

//    Funcion para comprobar el digito verificador
    private  boolean isValid(String revert, String dig_validador) {

        int suma = 0;
        int base = 1;
        int resultado;
        int comprobacion;
        try {

            for (int i = 0; i < revert.length(); i++) {                
                base += 1;                
                suma += Integer.parseInt(revert.charAt(i) + "") * base;
//                System.out.println("base: "+base+" suma: "+suma+" paso"+ i);                
            }
//            System.out.println("base: "+base+" suma: "+suma);
            
            resultado = suma % 11;
            comprobacion = 11 - resultado;  
//            System.out.println("comprobacion: "+comprobacion+" resultado: "+resultado);

//            if (suma >= 11) {
//                resultado = suma % 11;
//                comprobacion = 11 - resultado; 
//            }
            
            if (comprobacion >= 11) {
                resultado = comprobacion % 11;
                comprobacion =  resultado; 
            }
            

            if (comprobacion == 10) {
                if (dig_validador.toUpperCase().equals("K")) {
                    return true;
                }} 
            else if (comprobacion == Integer.parseInt(dig_validador)) {
                    return true;
                } else {
                    return false;
                }
            
        } catch (NumberFormatException e) {
            return false;
        }

        

        return false;
    }   
     
    
    
}
