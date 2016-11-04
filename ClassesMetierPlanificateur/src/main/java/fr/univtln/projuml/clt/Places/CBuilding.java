package fr.univtln.projuml.clt.Places;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = CBuilding.FIND_BIULDING_BY_ALL, query =
                "select build from CBuilding build"),
        @NamedQuery(name = CBuilding.FIND_BUILDING_BY_ID, query =
                "select building from CBuilding building where building.id = :Pid")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CBuilding implements Serializable{

    @TableGenerator(name = "buildingGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "buildingGenerator")
    @Column(name = "building_id")
    private int id;
    private String name;
    private String adress;

    @OneToMany(mappedBy = "building")
    private List<CRoom> buildingRooms = new ArrayList<CRoom>();

    public static final String FIND_BIULDING_BY_ALL = "findBuildingAll";
    public static final String FIND_BUILDING_BY_ID = "findBuildingById";

    public CBuilding() {}

    public CBuilding(int id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    public void addRoom(CRoom pRoom) { buildingRooms.add(pRoom); }

    public void removeRoom(CRoom pRoom) { buildingRooms.remove(pRoom); }

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

    @Override
    public String toString() {
        return "CBuilding{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
