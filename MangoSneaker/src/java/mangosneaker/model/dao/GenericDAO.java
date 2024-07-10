/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangosneaker.model.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author catlinh
 */

public interface GenericDAO<T> {
    int add(T obj)throws ClassNotFoundException, SQLException;
    int update(T obj)throws ClassNotFoundException, SQLException;
    int delete(T obj)throws ClassNotFoundException, SQLException;
    List<T> getAll()throws ClassNotFoundException, SQLException;
}