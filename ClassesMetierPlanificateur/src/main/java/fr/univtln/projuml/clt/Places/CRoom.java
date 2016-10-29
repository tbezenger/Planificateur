package fr.univtln.projuml.clt.Places;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CRoom {
    private int id;
    private int number;
    private int capacity;
    private CBuilding building;

    public CRoom() {}

    public CRoom(int id, int number, int capacity, CBuilding building) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public int getCapacity() {
        return capacity;
    }

    public CBuilding getBuilding() {
        return building;
    }
}
