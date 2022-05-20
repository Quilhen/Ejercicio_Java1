
package cajaregistradora;

import javax.swing.JOptionPane;


public class cajaRegistradora {

   
    public static void main(String[] args) {
        
        Producto p1 = new Producto("Lavadora",3,500.45);
        Producto p2 = new Producto("Radio",15,340.45);
        Producto p3 = new Producto("Horno",400,100.50);
        Producto p4 = new Producto("Lavadora",20,180.45);
        Producto p5 = new Producto("Lavavajillas",3,140.45);
        
        int totUnidadesP1 = 0;
        int totUnidadesP2 = 0;
        int totUnidadesP3 = 0;
        int totUnidadesP4 = 0;
        int totUnidadesP5 = 0;
    
        
        
        
        
        
        
        do {
            String resp = JOptionPane.showInputDialog(
                    "<html><table border=1>" +
                            "<tr><th>Id</th><th>Producto</th></tr>"
                            + "<tr><td>" +p1.getId() + "</td><td>" + p1.getNombre() + "</td></tr>"
                            + "<tr><td>" +p2.getId() + "</td><td>" + p2.getNombre() + "</td></tr>"
                            + "<tr><td>" +p3.getId() + "</td><td>" + p3.getNombre() + "</td></tr>"
                            + "<tr><td>" +p4.getId() + "</td><td>" + p4.getNombre() + "</td></tr>"
                            + "<tr><td>" +p5.getId() + "</td><td>" + p5.getNombre() + "</td></tr>"
                            + "</table>" +
                            "<h3>Introduza la ID del producto Vendido</h3></html>" );
            
            int id = Integer.parseInt(resp);
            Producto producto;
            
            switch(id){
                case 1:
                    producto = p1;
                break;
                case 2:
                    producto = p2;
                    break;
                case 3:
                    producto = p3;
                break;
                
                case 4:
                    producto = p4;
                break;
                
                default:
                    
                    producto = p5;
                break;
            }
                       
            if(producto.getUnidades()>0){
                String pregunta = "<html><h1>" + producto.getNombre() + "</h1>" + 
                        "<table border = 1" + 
                        "<tr><td>ID: </td> <td>" + producto.getId() + "</td> </tr>" + 
                        "<tr><td>Unidades : </tr><td>" + producto.getUnidades() + "</td></tr>"+
                        "<tr><td>Precio : </td><td>" + producto.getPrecio() + "</td></tr>" +
                        "</table>" + 
                        "<h4>Cuantas Unidades quiere </h4></html>";
                resp=JOptionPane.showInputDialog(pregunta);
                int unidades = Integer.parseInt(resp);
                //Validacion unidades menor que stock
                
                while(unidades > producto.getUnidades()){
                    //No hay suficientes unidades
                    JOptionPane.showMessageDialog(null,
                            "No hay suficientes unidades",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    resp=JOptionPane.showInputDialog(pregunta); 
                    unidades = Integer.parseInt(resp);
                }
                double importe = producto.vender(unidades);
                
                switch (id) {
                    case 1:
                        totUnidadesP1 += unidades;
                        break;
                    case 2:
                        totUnidadesP2 += unidades;
                        break;
                    case 3:
                        totUnidadesP3 += unidades;
                        break;
                    case 4:
                        totUnidadesP4 += unidades;
                        break;
                    case 5:
                        totUnidadesP5 += unidades;
                        break;
                    default:
                        throw new AssertionError();
                }
                
                
                JOptionPane.showMessageDialog(null,
                        "Venta realiza:\n\n" + 
                         "Impote de la venta : " + importe);
            }else{
                JOptionPane.showMessageDialog(
                null,
                "No quedan unidades disponibles",
                "No hay unidades",
                JOptionPane.WARNING_MESSAGE);
            }
            
        } while (JOptionPane.showConfirmDialog(
            null,
            "Vender otro producto",
            "Pregunta",
            JOptionPane.YES_NO_OPTION)
             == JOptionPane.YES_OPTION);
        
    }
    
    
    
    
}
