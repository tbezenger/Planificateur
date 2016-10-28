package fr.univtln.projuml.clt.Events;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomy- on 18/10/2016.
 */
public class CSurvey extends AEvent {

    private ArrayList<COption> options;

    public ArrayList<COption> getOptions() {
        return options;
    }

    public void addOption(COption pOption){
        options.add(pOption);
    }

    public void addOptions(List<COption> pOptions){
        options.addAll(pOptions);
    }

    public void subOption(COption pOption){
        options.remove(pOption);
    }

    public void subOptions(List<COption> pOptions){
        options.removeAll(pOptions);
    }

    public CSurvey(int id, String title, boolean isPrivate, Date creationDate, int duration, ArrayList<COption> options) {
        super(id, title, isPrivate, creationDate, duration);
        this.options = options;
    }

    public CSurvey(String title, boolean isPrivate, int duration) {
        super(title, isPrivate, duration);
    }
}
