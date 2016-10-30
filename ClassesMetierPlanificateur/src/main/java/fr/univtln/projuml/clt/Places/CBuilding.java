package fr.univtln.projuml.clt.Places;

import javax.persistence.*;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@NamedQueries(
        @NamedQuery(name = CBuilding.FIND_BIULDING_BY_ALL, query =
                "select build from CBuilding build")
)
public class CBuilding {

    @TableGenerator(name = "buildingGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "buildingGenerator")
    @Column(name = "building_id")
    private int id;
    private String name;
    private String adress;

    public static final String FIND_BIULDING_BY_ALL = "findBuildingAll";

    public CBuilding() {}

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

    public CBuilding setName(String name) {
        this.name = name;
        return this;
    }

    public CBuilding setId(int id) {
        this.id = id;
        return this;
    }

    public CBuilding setAdress(String adress) {
        this.adress = adress;
        return this;
    }
}
