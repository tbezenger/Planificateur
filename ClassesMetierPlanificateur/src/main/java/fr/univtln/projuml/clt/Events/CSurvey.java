package fr.univtln.projuml.clt.Events;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomy- on 18/10/2016.
 */

@Entity
@NamedQueries(
        @NamedQuery(name = CSurvey.SURVEY_BY_ALL, query =
                "select survey from CSurvey survey")
)
@DiscriminatorValue(value = "survey")
public class CSurvey extends AEvent {


    private List<COption> surveyOptions = new ArrayList<COption>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    public List<COption> getSurveyOptions() {
        return surveyOptions;
    }

    public static final String SURVEY_BY_ALL = "surveyAll";


    //////// builders ////////

    public CSurvey() {}

    public CSurvey(int id, String title, boolean isPrivate, Date creationDate, int duration, ArrayList<COption> options) {
        super(id, title, isPrivate, creationDate, duration);
        this.surveyOptions = options;
    }

    public CSurvey(String title, boolean isPrivate, int duration) {
        super(title, isPrivate, duration);
    }


    //////// methods ////////


    public void addOption(COption pOption){
        surveyOptions.add(pOption);
    }

    public void removeOption(COption pOption) { surveyOptions.remove(pOption); }

    public void addOptions(List<COption> pOptions){
        surveyOptions.addAll(pOptions);
    }

    public void subOptions(List<COption> pOptions){
        surveyOptions.removeAll(pOptions);
    }
}
