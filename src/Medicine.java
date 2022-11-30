import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Medicine implements Serializable {

    private int code;
    private String name;
    private int amount;
    private double unitPrice;
    //Contructor de medicinas
    public Medicine(int code, String name, int amount, double unitPrice) {
        super();
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }
    //Getters y Setters de cada atributo
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine)) return false;
        Medicine medicine = (Medicine) o;
        return code == medicine.code || amount == medicine.amount && Double.compare(medicine.unitPrice, unitPrice) == 0 && Objects.equals(name, medicine.name);
    }

    public boolean validation(){
        ArrayList<Medicine> seeMed=DataModel.recoverMedicine();
        boolean  ret=false;
        for(int i=0;i<seeMed.size();i++){
            if(equals(seeMed.get(i))){
                ret= true;
            }
        }
        return ret;
    }
    @Override

    //Metodo toString de medicinas
    public String toString() {
        return "medicine [code=" + code + ", name=" + name + ", amount=" + amount + ", unit_price=" + unitPrice + "]";
    }
    public String toString(String sep) {
        String medic = this.code + sep + this.name + sep + this.amount + sep + this.unitPrice;
        return medic;
    }

}
