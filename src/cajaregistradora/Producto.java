
package cajaregistradora;


public class Producto {
    
    private int id;
    private String nombre;
    private int unidades;
    private double precio;
    
    private static int totalProductos;
    
   public Producto(){
       Producto.totalProductos++;
       this.id = Producto.totalProductos;
   }

    public Producto(String nombre,int unidades,double precio) {
        this();
        this.nombre = nombre;
        this.unidades = unidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public int getId() {
        return id;
    }
    
    public static int getTotalProducto(){
        return totalProductos;
    }
   
   public double getStockValorado(){
       double stockValorado = this.unidades * this.precio;
       return stockValorado;
       
   }
    
   public double vender(int unidades){
       this.unidades= this.unidades - unidades;
       double importe = unidades * this.precio;
       return importe;
   }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Producto){
            Producto otro =(Producto) obj;
            if( this.id == otro.id){
                return true;
        }else{
            return false;
         }  
        }else{
            return false;
        }
   
   
    
}
}
