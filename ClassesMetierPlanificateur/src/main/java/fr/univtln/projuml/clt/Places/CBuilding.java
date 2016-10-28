package fr.univtln.projuml.clt.Places;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CBuilding {
    private int id;
    private String name;
    private String adress;

    public CBuilding(int id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public void setName(String name) {
        this.name = name;
    }
}
