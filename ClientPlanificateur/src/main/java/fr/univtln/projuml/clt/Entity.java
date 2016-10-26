package fr.univtln.projuml.clt;

import fr.univtln.projuml.clt.exceptions.PersistanceException;

import java.sql.Connection;

/**
 * Created by tomy- on 21/10/2016.
 */

public interface Entity {
    public void persist(Connection connection) throws PersistanceException;

    public void merge(Connection connection) throws PersistanceException;

    public void update(Connection connection) throws PersistanceException;

    public void remove(Connection connection) throws PersistanceException;
}

