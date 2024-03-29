import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DataModel {

    public static void saveProvider(Provider p) {
        ArrayList<Provider> providers = new ArrayList<>();
        providers.addAll(DataModel.recoverProvider());
        providers.add(p);
        //Para Windows
        //C:/dates/Provider.txt
        //Para Linux
        ///home/jere/Desktop/dates/Provider.txt
        try {
            ObjectOutputStream copyDates = new ObjectOutputStream(new FileOutputStream("/home/jere/Desktop/dates/Provider.txt"));
            copyDates.writeObject(providers);
            copyDates.close();
        } catch (Exception e) {

        }
    }

    public static ArrayList recoverProvider() {

        ArrayList<Provider> recoverP = new ArrayList<>();
        //Para Windows
        //C:/dates/Provider.txt
        try {
            ObjectInputStream getDates = new ObjectInputStream(new FileInputStream("/home/jere/Desktop/dates/Provider.txt"));
            recoverP = (ArrayList<Provider>) getDates.readObject();
        } catch (Exception e) {

        }
        return recoverP;
    }

    public static void saveMedicine(Medicine m) {
        //Guarda los datos que seteamos en el txt
        ArrayList<Medicine> medicines = new ArrayList<>();
        medicines.addAll(DataModel.recoverMedicine());
        medicines.add(m);

        try {
            ObjectOutputStream copyDates = new ObjectOutputStream(new FileOutputStream("/home/jere/Desktop/dates/Medicine.txt"));
            copyDates.writeObject(medicines);
            copyDates.close();
        } catch (Exception e) {

        }
    }

    public static List<Medicine> recoverMedicine() {
        //Recupera los datos que estan en el txt
        List<Medicine> recoverM = new ArrayList<>();
        try {
            ObjectInputStream getDates = new ObjectInputStream(new FileInputStream("/home/jere/Desktop/dates/Medicine.txt"));
            recoverM = (ArrayList<Medicine>) getDates.readObject();

        } catch (Exception e) {

        }
        return recoverM;
    }
    public static void sobreescribirMed(List <Medicine> sobreescrito){
        //Este metodo es para Sobreescribir el nuevo precio que le voy a setear
        ArrayList<Medicine> MedicinesTxt = (ArrayList<Medicine>) sobreescrito;
        try {
            ObjectOutputStream setDates= new ObjectOutputStream(new FileOutputStream("/home/jere/Desktop/dates/Medicine.txt"));
            setDates.writeObject(sobreescrito);
            setDates.close();
        }catch (Exception e){
            System.out.println("Fallo la conexion del txt guardar");
        }
    }
    public static void sobreescribirProv(List <Provider> sobreescrito){
        ArrayList<Provider> ProviderTxt = (ArrayList<Provider>) sobreescrito;
        try {
            ObjectOutputStream setDates= new ObjectOutputStream(new FileOutputStream("/home/jere/Desktop/dates/Provider.txt"));
            setDates.writeObject(sobreescrito);
            setDates.close();
        }catch (Exception e){
            System.out.println("Fallo la conexion del txt guardar");
        }
    }
    public static List<Medicine> searchMedicineTxt(int code, String price) {
        //Este metodo esta hecho para buscar la medicina que quiero modificar
        List<Medicine> med = recoverMedicine();
        //Recupero el array donde estan todas las medicinas
        try {
            for (int i = 0; i < med.size(); i++) {
                if (med.get(i).getCode() == code) {
                    med.get(i).setUnitPrice(Integer.parseInt(price));
                    System.out.println("Encontrado");
                    System.out.println(med.get(i));
                    sobreescribirMed(med);
                    break;
                }else {
                    System.out.println("no econtrado");
                }
            }
            return med;
        } catch (Exception e) {
            return med;
        }

    }
    public static void deleteProviderTxt (String cel){
        List<Provider> providers = recoverProvider();
        for (int i = 0; i <providers.size(); i++) {
            if (Integer.parseInt(cel) == providers.get(i).getPhoneNumber()) {
                providers.remove(i);
                System.out.println("Eliminado correctamente");
                sobreescribirProv(providers);
                break;
            }
        }

    }


}
