package fr.univtln.projuml.clt.Events;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fr.univtln.projuml.clt.Users.CUser;

import javax.persistence.*;
import java.awt.peer.SystemTrayPeer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = COption.OPTION_BY_ALL, query =
                "select option from COption option"),
        @NamedQuery(name = COption.FIND_OPTION_BY_ID, query =
                "select option from COption option where option.id = :Pid"),
        @NamedQuery(name = COption.FIND_OPTIONS_BY_SURVEY, query =
                "select option from COption option " +
                        "where option.survey.id = :Pid")
})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope = COption.class)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class COption implements Serializable{

    @TableGenerator(name = "optionGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "optionGenerator")
    @Column(name = "option_id")
    private int id;
    private String title;


    private List<CUser> optionUsers = new ArrayList<CUser>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    public List<CUser> getOptionUsers() {
        return optionUsers;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "event_id")
    private CSurvey survey;

    public static final String OPTION_BY_ALL = "optionAll";
    public static final String FIND_OPTION_BY_ID = "findOptionById";
    public static final String FIND_OPTIONS_BY_SURVEY = "findOptionsBySurvey";


    //////// builders ////////


    public COption() {}

    public COption(String title) {
        this.title = title;
    }


    //////// methods ////////


    public CSurvey getSurvey() { return survey; }

    public COption setSurvey(CSurvey survey) {
        this.survey = survey;
        return this;
    }

    public void setOptionUsers(List<CUser> optionUsers) { this.optionUsers = optionUsers; }

    public void addVoter(CUser pVoter){
        this.optionUsers.add(pVoter);
    }

    public void subVoter(CUser pVoter){
        this.optionUsers.remove(pVoter);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public COption setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "COption{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
