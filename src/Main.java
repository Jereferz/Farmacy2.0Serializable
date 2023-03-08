import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class Main {

    public static void main(String[] args) {

        boolean flat = true;
        int leer;
        do {
            try {
                ArrayList<Provider> listProvide = DataModel.recoverProvider();
                ArrayList<Medicine> listMedicin = DataModel.recoverMedicine();
                leer = View.menu();
                ArrayList dates;
                if (leer == 1) {
                    dates = View.registerProvider();
                    String name = (String)dates.get(0);
                    int phone = Integer.parseInt((String)dates.get(1));
                    Provider prov = new Provider(name,phone);
                    if (prov.validation()){
                        View.seeValidation("Este Proveedor se encuentra registrado");
                    } else {
                        View.seeValidation("El Proveedor se ha registrado!");
                        DataModel.saveProvider(prov);
                    }
                } else if (leer == 2) {
                    dates = View.registerMedicine();
                    int code = Integer.parseInt((String)dates.get(0));
                    String name = (String)dates.get(1);
                    int amount = Integer.parseInt((String)dates.get(0));
                    double unitPrice = Double.parseDouble((String)dates.get(0));

                    Medicine med = new Medicine(code,name,amount,unitPrice);
                    if (med.validation()){
                        View.seeValidation("Esta Medicina se encuentra registrada");
                    } else {
                        View.seeValidation("La Medicina se ha registrado!");
                        DataModel.saveMedicine(med);
                    }
                } else if (leer == 3) {
                    View.listMedicine(listMedicin);
                } else if (leer == 4){
                    View.listProvider(listProvide);
                } else if (leer == 5){
                    int code = View.saveCode();
                    double unitPrice = View.newPrice();
                    DataModel.searchMedicineTxt(code,unitPrice);
                } else if (leer == 6) {
                    flat = false;
                }
            } catch (InputMismatchException var14) {
                System.out.println("" + var14 + " fallo");
            }


        } while (flat);
    }
}