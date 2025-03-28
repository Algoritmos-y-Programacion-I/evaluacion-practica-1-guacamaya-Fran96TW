package ui;

import java.util.Scanner;

public class Guacamaya{
    
    // Declaración de variables
    public static double[] price;
    public static int[] units;
    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("<-------------GUACAMAYA------------->");

        System.out.println("Welcome to Guacamaya!");

        // Inicializa la cantidad de productos vendidos
        setQuantitySold();

        boolean exit = false;

        // Menú principal
        do{
            System.out.println("\nMenu:");
            System.out.println("1. Give the price and how much units of the product");
            System.out.println("2. Calculate total of units you sell during the day");
            System.out.println("3. Calculate the average price of the product references sold on the day");
            System.out.println("4. Calculate total sales (money collected) during the day");
            System.out.println("5. Check the number of product references that have exceeded a minimum sales limit during the day.");
            System.out.println("6. Exit");
            System.out.println("\nInput a option: ");
            int option = scanner.nextInt();

            // Menu Options
            switch (option) {
                case 1:
                    givePriceAndUnits();
                    break;
                case 2:
                    System.out.println("\nThe total number of units sold today was: " + calculateTotalUnitsSold());
                    break;
                case 3:
                    System.out.println("\nThe average price of the product references sold today was: " + calculateAveragePrice());
                    break;
                case 4:
                    System.out.println("\nThe total sales (money collected) today were: " + calculateTotalSales());
                    break;
                case 5:
                    System.out.println("\nEnter the minimum sales limit to analyze:");
                    double limit = scanner.nextDouble();
                    System.out.println("\nOut of the " + price.length + " references sold today, " + checkReferencesAboveLimit(limit) + " exceeded the minimum sales limit of " + limit);
                    break;
                case 6:
                    System.out.println("\nThank you for using our services!");
                    exit = true;
                    scanner.close();
                    break;
                default:
                    System.out.println("\nInvalid option, please try again.");
                    break;
            }
        } while (!exit);
    }

    /**
     * Método que solicita al usuario la cantidad de referencias de productos vendidas
     * y inicializa los arreglos correspondientes para almacenar precios y unidades.
     * 
     * Precondición: El programa debe estar inicializado y el usuario debe ingresar un número entero válido.
     * Postcondición: Los arreglos `price` y `units` son inicializados con el tamaño de referencias ingresado por el usuario.
     */
    public static void setQuantitySold() {
        System.out.println("\nEnter the number of different product references sold on the day ");
        int references = scanner.nextInt();

        // Inicializa los arreglos según el número de referencias ingresadas
        price = new double[references];
        units = new int[references];
    }

    /**
     * Método que solicita al usuario el precio y la cantidad de unidades vendidas para cada producto
     * y guarda la información en los arreglos `price` y `units`.
     * 
     * Precondición: El programa debe tener al menos un producto referenciado.
     * Postcondición: Los arreglos `price` y `units` son llenados con los valores introducidos por el usuario.
     */
    public static void givePriceAndUnits() {
        System.out.println("\nEnter the number of product references sold today: ");
        int references = scanner.nextInt();

        // Inicializa los arreglos basados en el número de referencias
        price = new double[references];
        units = new int[references];

        // Solicita al usuario el precio y las unidades de cada producto
        for (int i = 0; i < references; i++) {
            System.out.println("\nEnter the price for product #" + (i + 1) + ": ");
            price[i] = scanner.nextDouble();
            System.out.println("Enter the number of units sold for product #" + (i + 1) + ": ");
            units[i] = scanner.nextInt();
        }
    }

    /**
     * Método que calcula el total de unidades vendidas durante el día.
     * 
     * Precondición: Los arreglos `price` y `units` deben estar correctamente llenados con datos válidos.
     * Postcondición: Retorna el total de unidades vendidas durante el día.
     */
    public static int calculateTotalUnitsSold() {
        int totalUnits = 0;
        
        // Suma el total de unidades vendidas
        for (int i = 0; i < units.length; i++) {
            totalUnits += units[i];
        }
        
        return totalUnits;
    }

    /**
     * Método que calcula el precio promedio de los productos vendidos.
     * 
     * Precondición: Los arreglos `price` y `units` deben estar correctamente llenados con datos válidos.
     * Postcondición: Retorna el precio promedio de los productos vendidos.
     */
    public static double calculateAveragePrice() {
        double totalSales = 0;
        
        // Calcula el total de ventas y luego el precio promedio
        for (int i = 0; i < price.length; i++) {
            totalSales += price[i] * units[i];
        }
        
        return totalSales / price.length;
    }

    /**
     * Método que calcula las ventas totales (dinero recaudado) durante el día.
     * 
     * Precondición: Los arreglos `price` y `units` deben estar correctamente llenados con datos válidos.
     * Postcondición: Retorna la cantidad total de dinero recaudado durante el día.
     */
    public static double calculateTotalSales() {
        double totalSales = 0;
        
        // Calcula el total de ventas multiplicando precio por unidades
        for (int i = 0; i < price.length; i++) {
            totalSales += price[i] * units[i];
        }
        
        return totalSales;
    }

    /**
     * Método que verifica cuántas referencias de productos han superado un límite de ventas.
     * 
     * Precondición: Los arreglos `price` y `units` deben estar correctamente llenados con datos válidos,
     *              y el límite de ventas debe ser un número positivo.
     * Postcondición: Retorna el número de referencias de productos que han superado el límite de ventas especificado.
     */
    public static int checkReferencesAboveLimit(double limit) {
        int count = 0;

        // Recorre las referencias para contar cuántas han superado el límite de ventas
        for (int i = 0; i < price.length; i++) {
            double totalSalesForProduct = price[i] * units[i];
            if (totalSalesForProduct > limit) {
                count++;
            }
        }
        
        return count;
    }
}