package com.astontech.dao.mysql;

import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl extends MySQL implements PersonDAO {
    @Override
    public Person getPersonById(int personId) {
        Connect();
        Person person = null;   //not instantiated because if no records returned, we don't want to use memory
        try {
            String sp = "{call GetPerson(?, ?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, personId);
            ResultSet rs = cStmt.executeQuery();

            if (rs.next()) {
                //notes: HYDRATING AN OBJECT
                person = new Person();
                person.setPersonId(rs.getInt(1));
                person.setFirstName(rs.getString(2));
                person.setLastName(rs.getString(3));
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return person;
    }

    @Override
    public List<Person> getPersonList() {
        Connect();
        List<Person> personList = new ArrayList<Person>();  //not instantiated because if no records returned, we don't want to use memory
        try {
            String sp = "{call GetPerson(?, ?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {



                personList.add(HydrateObject(rs));
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return personList;
    }


    @Override
    public int insertPerson(Person person) {
        return 0;
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean deletePerson(int personId) {
        return false;
    }

    private static Person HydrateObject(ResultSet rs) throws SQLException {
        Person person = new Person();
        person.setPersonId(rs.getInt(1));
        person.setFirstName(rs.getString(2));
        person.setLastName(rs.getString(3));

        return person;
    }
}
