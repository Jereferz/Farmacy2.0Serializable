import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class DataModel {
    public static void saveProvider(Provider p) {
        ArrayList<Provider> providers = new ArrayList<>();
        providers.addAll(DataModel.recoverProvider());
        providers.add(p);
        try {
            ObjectOutputStream copyDates = new ObjectOutputStream(new FileOutputStream("C:/dates/Provider.txt"));
            copyDates.writeObject(providers);
            copyDates.close();
        } catch (Exception e) {

        }
    }

    public static ArrayList recoverProvider() {
        System.out.println("bandera");
        ArrayList<Provider> recoverP = new ArrayList<>();
        try {
            ObjectInputStream getDates = new ObjectInputStream(new FileInputStream("C:/dates/Provider.txt"));
            recoverP = (ArrayList<Provider>) getDates.readObject();
        } catch (Exception e) {

        }
        return recoverP;
    }

    public static void saveMedicine(Medicine m) {
        ArrayList<Medicine> medicines = new ArrayList<>();
        medicines.addAll(DataModel.recoverMedicine());
        medicines.add(m);

        try {
            ObjectOutputStream copyDates = new ObjectOutputStream(new FileOutputStream("C:/dates/Medicine.txt"));
            copyDates.writeObject(medicines);
            copyDates.close();
        } catch (Exception e) {

        }
    }

    public static ArrayList recoverMedicine() {
        ArrayList<Medicine> recoverM = new ArrayList<>();
        try {
            ObjectInputStream getDates = new ObjectInputStream(new FileInputStream("C:/dates/Medicine.txt"));
            recoverM = (ArrayList<Medicine>) getDates.readObject();

        } catch (Exception e) {

        }
        return recoverM;
    }

}
