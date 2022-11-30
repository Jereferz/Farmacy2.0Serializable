import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Provider implements Serializable {
    private String name;
    private int phoneNumber;
    //private ArrayList<Medicine> newmedicine;
    /*public Provider() {
        newmedicine = new ArrayList<Medicine>();
    }*/



    public Provider(String name, int phoneNumber) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /*public boolean validProv(){
        ArrayList<>
    }
    //
    public void addMedicine(Medicine m) {
        newmedicine.add(m);
    }
    public void delMedicine(Medicine m) {
        newmedicine.remove(m);
    }*/
    public boolean validation(){
        ArrayList<Provider> seeProv=DataModel.recoverProvider();
        boolean  ret=false;
        for(int i=0;i<seeProv.size();i++){
            if(equals(seeProv.get(i))){
                ret= true;
            }
        }
        return ret;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Provider)) return false;
        Provider provider = (Provider) o;
        return phoneNumber == provider.phoneNumber && Objects.equals(name, provider.name);
    }
    @Override
    public String toString() {
        return "Provider{" +
                "Nombre =' " + name + '\'' +
                " N° de Cel=' " + phoneNumber +
                '}';
    }
    /*public String toString() {
        String c = "";
        for (int i=0;i<newmedicine.size();i++) {
            c = c + newmedicine.get(i).toString();
        }
        return "Provedor [ Nombre= " + name +" ] "+c;
    }*/
    /*public String toString(String sep) {
        String c = "";
        for (int i=0;i<newmedicine.size();i++) {
            c = c+newmedicine.get(i).toString("#")+sep;
        }
        return c;
    }*/
}
