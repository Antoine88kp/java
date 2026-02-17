package Model;

public class Dispositivo {

    // Atributos privados
    private String codigo;
    private String tipo;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;
    private int garantiaMeses;
    private boolean enOferta;

    // Constructor vacío
    public Dispositivo() {
        this.codigo = "";
        this.tipo = "";
        this.marca = "";
        this.modelo = "";
        this.precio = 0.0;
        this.stock = 0;
        this.garantiaMeses = 3;
        this.enOferta = false;
    }

    // Constructor con parámetros esenciales
    public Dispositivo(String codigo, String tipo, String marca, String modelo, double precio) {
        this.codigo = codigo;
        this.tipo = tipo.toUpperCase();
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = 0;
        this.garantiaMeses = 3;
        this.enOferta = precio > 1000;
    }

    // GETTERS
    public String getCodigo() { return codigo; }
    public String getTipo() { return tipo; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public int getGarantiaMeses() { return garantiaMeses; }
    public boolean isEnOferta() { return enOferta; }

    // SETTERS CON VALIDACIÓN

    public void setMarca(String marca) {
        if (marca == null || marca.isEmpty() || marca.length() > 20) {
            System.out.println("[ERROR] Marca inválida. No vacío, máximo 20 caracteres.");
            return;
        }
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.isEmpty() || modelo.length() > 30) {
            System.out.println("[ERROR] Modelo inválido. No vacío, máximo 30 caracteres.");
            return;
        }
        this.modelo = modelo;
    }

    public void setPrecio(double precio) {
        if (precio <= 0 || precio > 100000) {
            System.out.println("[ERROR] Precio inválido. Debe ser mayor a 0 y máximo 100000 .");
            return;
        }
        this.precio = precio;
        this.enOferta = precio > 1000;
    }

    public void setStock(int stock) {
        if (stock < 0 || stock > 1000) {
            System.out.println("[ERROR] El stock no puede ser menor a 0 ni mayor a 1000.");
            return;
        }
        this.stock = stock;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        if (garantiaMeses < 3 || garantiaMeses > 24) {
            System.out.println("[ERROR] Garantía inválida. Debe estar entre 3 y 24 meses.");
            return;
        }
        this.garantiaMeses = garantiaMeses;
    }

    // MÉTODOS ADICIONALES

    public double calcularPrecioOferta(double porcentajeDescuento) {
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            System.out.println("[ERROR] Porcentaje inválido.");
            return precio;
        }
        return precio - (precio * porcentajeDescuento / 100);
    }

    public void mostrarInformacion() {
        System.out.println("Código:          " + codigo);
        System.out.println("Tipo:            " + tipo);
        System.out.println("Marca:           " + marca);
        System.out.println("Modelo:          " + modelo);
        System.out.printf("Precio:          $%,.2f%n", precio);
        System.out.println("Stock:           " + stock + " unidades");
        System.out.println("Garantía:        " + garantiaMeses + " meses");
        System.out.println("En oferta:       " + (enOferta ? "SI" : "NO"));
    }
}
