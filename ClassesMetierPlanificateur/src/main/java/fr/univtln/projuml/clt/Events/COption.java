package fr.univtln.projuml.clt.Events;

import fr.univtln.projuml.clt.Users.CUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@NamedQueries(
        @NamedQuery(name = COption.OPTION_BY_ALL, query = "select option from COption option")
)
public class COption {

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

    private List<CSurvey> optionSurvey = new ArrayList<CSurvey>();
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "surveyOptions")
    public List<CSurvey> getOptionSurvey() { return optionSurvey; }

    public static final String OPTION_BY_ALL = "optionAll";


    //////// builders ////////


    public COption() {}

    public COption(String title) {
        this.title = title;
    }


    //////// methods ////////


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
}
