package fr.univtln.projuml.clt.Places;

import fr.univtln.projuml.clt.Events.AEvent;
import fr.univtln.projuml.clt.Events.CMeeting;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@NamedQueries(
        @NamedQuery(name = CRoom.FIND_ROOM_BY_ALL, query =
                "select room from CRoom room")
)
public class CRoom implements Serializable{

    @TableGenerator(name = "roomGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "roomGenerator")
    @Column(name = "room_id")
    private int id;
    private int number;
    private int capacity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "building_id")
    private CBuilding building;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "meetingRooms")
    private List<CMeeting> roomEvents = new ArrayList<CMeeting>();

    public static final String FIND_ROOM_BY_ALL = "findRoomByAll";


    //////// builders ////////


    public CRoom() {}

    public CRoom(int id, int number, int capacity, CBuilding building) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
    }


    //////// methods ////////


    public void addMeeting(CMeeting pMeeting) { roomEvents.add(pMeeting); }

    public void removeMeeting(CMeeting pMeeting) { roomEvents.remove(pMeeting); }

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

    public CRoom setId(int id) {
        this.id = id;
        return this;
    }

    public CRoom setNumber(int number) {
        this.number = number;
        return this;
    }

    public CRoom setCapacity(int capacity) {
        this.capacity = capacity;
        return this; }

    public CRoom setBuilding(CBuilding building) {
        this.building = building;
        return this;
    }
}
