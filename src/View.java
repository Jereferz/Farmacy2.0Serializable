import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    //Menu inicial que ve el usuario
    static Scanner read;
    static Scanner num1 ;

    public static int menu() {
        Scanner leer1 = new Scanner(System.in);
        //Excepcion para que no inserte simbolos ni letras
        try {
            int leer = 0;
            System.out.println("Farmacaco S.A");
            System.out.println("1. Agregar Proveedor");
            System.out.println("2. Agregar Medicamento");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Mostrar Proveedores");
            System.out.println("5. Cambiar Precio de Medicamento");
            System.out.println("6. Salir");
            leer = leer1.nextInt();
            return leer;
        }catch (InputMismatchException o) {
            System.out.println("No letras, no simbolos");
            System.out.println("Coloca un numero permitido");
            return 0 ;
        }

    }
    //menu numero 1 para ingresar proveedor
    public static ArrayList registerProvider() {
        ArrayList<String>dates= new ArrayList<>();
        Scanner leer2 = new Scanner(System.in);

        System.out.println("Ingrese el nombre del Proveedor");
        String name = leer2.nextLine();
        dates.add(name);
        System.out.println("Ingrese el Celular");
        String phone = leer2.nextLine();
        dates.add(phone);
        return dates;
    }
    public static ArrayList registerMedicine() {
        ArrayList<String>dates = new ArrayList<>();
        String code;
        String name;
        String amount;
        String unit_price;
        Scanner read = new Scanner(System.in);
        System.out.println("Agregue nueva medicina");
        System.out.println("Codigo: ");
        code = read.nextLine();
        dates.add(code);
        System.out.println("Nombre: ");
        name = read.nextLine();
        dates.add(name);
        System.out.println("Cantidad: ");
        amount= read.nextLine();
        dates.add(amount);
        System.out.println("Precio x unidad: ");
        unit_price = read.nextLine();
        dates.add(unit_price);
        return dates;
    }
    public static void listMedicine(ArrayList<Medicine> medicines) {
        for (int i = 0; i < medicines.size(); i++) {
            System.out.println(i+"==>"+medicines.get(i));
        }
    }

    public static void listProvider(ArrayList<Provider> providers) {
        for (int i = 0; i < providers.size(); i++) {
            System.out.println(i+"==>"+providers.get(i));
        }
    }
    public static void seeValidation (String result){
        System.out.println(result);
    }
    public static int saveCode() {
        System.out.println("Ingrese el codigo del medicamento que quiere cambiar");
        int code = read.nextInt();
        return code;
    }
    public static Double newPrice() {
        System.out.println("Ingrese el nuevo precio");
        double unitPrice = read.nextDouble();
        return unitPrice;
    }

}
