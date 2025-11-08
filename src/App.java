import java.util.Scanner;

public class App {

    static String producto1 = "";
    static double precio1 = 0, cantidad1 = 0;

    static String producto2 = "";
    static double precio2 = 0, cantidad2 = 0;

    static String producto3 = "";
    static double precio3 = 0, cantidad3 = 0;

    static String producto4 = "";
    static double precio4 = 0, cantidad4 = 0;

    static int totalProductos = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
    }

    public static void mostrarMenu() {
        System.out.println("Sistema gestion de tienda");
        System.out.println("1. Registrar producto");
        System.out.println("2. Mostrar producto");
        System.out.println("3. aplicar descuento a producto");
        System.out.println("4. salir");
        System.out.println("Seleccione una opcion: ");
    }

    public static void registrarProducto(Scanner sc) {
        System.out.println(" ==Registrando un producto== ");
        System.out.println("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        System.out.println("Ingrese la cantidad de inventario");
        double cantidad = sc.nextDouble();
        sc.nextLine();

        // guardar segun el nuemro del producto
        if (totalProductos == 0) {
            producto1 = nombre;
            precio1 = precio;
            cantidad1 = cantidad;
            totalProductos++;
        } else if (totalProductos == 1) {
            producto2 = nombre;
            precio2 = precio;
            cantidad2 = cantidad;
            totalProductos++;
        } else if (totalProductos == 2) {
            producto3 = nombre;
            precio3 = precio;
            cantidad3 = cantidad;
            totalProductos++;
        }

        double valorTotal = calcularValorProducto(precio, cantidad);
        mostrarResumenProducto(nombre, precio, cantidad, valorTotal);
    }

    public static void mostrarResumenProducto(String nombre, double precio, double cantidad, double valorTotal) {
        System.out.println("Producto registrado con exito!");
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad en inventario: " + cantidad);
        System.out.println("Valor total del inventario: " + valorTotal);
    }

    public static double calcularValorProducto(double precio, double cantidad) {
        return precio * cantidad;
    }

    public static void mostrarProductos() {
        System.out.println("Inventario Productos");

        for (int i = 1; i <= totalProductos; i++) {
            String nombre = obtenerNombreProducto(i);
            double precio = obtenerPrecioProducto(i);
            double cantidad = obtenerCantidadProducto(i);
            double valorTotal = calcularValorProducto(precio, cantidad);
        }
    }

    public static String obtenerNombreProducto(int posicion) {
        if (posicion == 1) {
            return producto1;
        } else if (posicion == 2) {
            return producto2;
        } else {
            return producto3;
        }
    }

    public static double obtenerPrecioProducto(int posicion) {
        if (posicion == 1) {
            return precio1;
        } else if (posicion == 2) {
            return precio2;
        } else {
            return precio3;
        }
    }

    public static double obtenerCantidadProducto(int posicion) {
        if (posicion == 1) {
            return cantidad1;
        } else if (posicion == 2) {
            return cantidad2;
        } else {
            return cantidad3;
        }
    }

    public static void imprimirDetallesProducto(int numero, String nombre, double precio, double cantidad,
            double valorTotal) {
        System.out.println("Producto #" + numero);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad en inventario: " + cantidad);
        System.out.println("Valor total del inventario: " + valorTotal);
    }

    public static void calcularInventarioTotal() {
        System.out.println("Valor total del inventario de la tienda");

        double sumaTotal = 0;

        for (int i = 1; i <= totalProductos; i++) {
            double precio = obtenerPrecioProducto(i);
            double cantidad = obtenerCantidadProducto(i);
            double valorProducto = calcularValorProducto(precio, cantidad);

            sumaTotal = sumaValores(sumaTotal, valorProducto);
        }

        mostrarValorTotal(sumaTotal);
        calcularPromedioValor(sumaTotal, totalProductos);
    }

    public static double sumaValores(double valor1, double valor2) {
        return valor1 + valor2;
    }

    public static void mostrarValorTotal(double valorTotal) {
        System.out.println("El valor total del inventario es: " + valorTotal);
    }

    public static void calcularPromedioValor(double total, int cantidadProductos) {
        if (cantidadProductos > 0) {
            double promedio = dividirValores(total, cantidadProductos);
            System.out.println("El valor promedio por producto es: " + promedio);
        }
    }

    public static double dividirValores(double dividendo, double divisor) {
        return dividendo / divisor;
    }

    public static void aplicarDescuento(Scanner sc) {
        System.out.println("Aplicar descuento a un producto");
        System.out.println("Ingrese el numero del producto (1- " + totalProductos + "): ");
        int numeroProducto = sc.nextInt();

        System.out.println("Ingrese el porcentaje de descuento: ");
        double porcentajeDescuento = sc.nextDouble();
        sc.nextLine();

        double precioOriginal = obtenerPrecioProducto(numeroProducto);
        double descuento = calularDescuento(precioOriginal, porcentajeDescuento);
        double precioFinal = restarValores(precioOriginal, descuento);

        actualizarPrecioProducto(numeroProducto, precioFinal);

        mostrarResultadoDescuento(precioOriginal, descuento, precioFinal);
    }

    public static double calularDescuento(double precio, double porcentaje) {
        return multiplicarValores(precio, porcentaje) / 100;
    }

    public static double multiplicarValores(double valor1, double valor2) {
        return valor1 * valor2;
    }

    public static double restarValores(double valor1, double valor2) {
        return valor1 - valor2;
    }

    public static void actualizarPrecioProducto(int posicion, double nuevoPrecio) {
        if (posicion == 1) {
            precio1 = nuevoPrecio;
        } else if (posicion == 2) {
            precio2 = nuevoPrecio;
        } else {
            precio3 = nuevoPrecio;
        }
    }

    public static void mostrarResultadoDescuento(double precioOriginal, double descuento, double precioFinal) {
        System.out.println("Descuento aplicado con exito!");
        System.out.println("Precio original: " + precioOriginal);
        System.out.println("Descuento: " + descuento);
        System.out.println("Precio final: " + precioFinal);
    }

}
