package com.exam.se08.pool1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class ConnectionPool {
    private static ConnectionPool instance;
//    private final String DRIVER_NAME; так как у нас новая версия JDBC это действия она выполняет за нас сама
    private ArrayList<Connection> freeConnections = new ArrayList<>();
    private String URL;
    private String user;
    private String password;
    private int maxConn;

    public ConnectionPool(/*String DRIVER_NAME,*/ String URL,
                          String user, String password, int maxConn) {
//        this.DRIVER_NAME = DRIVER_NAME;
        this.URL = URL;
        this.user = user;
        this.password = password;
        this.maxConn = maxConn;
//        loadDrivers();
    }

//    private void loadDrivers() {
//        try {
//            Driver driver = (Driver) Class.forName(DRIVER_NAME).newInstance();
//            DriverManager.registerDriver(driver);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    static synchronized public ConnectionPool getInstance(/*String DRIVER_NAME,*/ String URL, String user, String password, int maxConn) {
        if(instance == null) {
            instance = new ConnectionPool(/*DRIVER_NAME,*/ URL, user, password, maxConn);
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        Connection con;
        if(!freeConnections.isEmpty()) {
            con = freeConnections.remove(freeConnections.size()-1);
            try {
                if (con.isClosed()) {
                    con = getConnection();
                }
            } catch (SQLException throwables) {
                con = getConnection();
            } catch (Exception e) {
                con = getConnection();
            }
        } else {
            con = getConnection();
        }
        return con;
    }

    private Connection newConnection() {
        Connection con;
        try {
            if(user == null) {
                con = DriverManager.getConnection(URL);
            } else {
                con = DriverManager.getConnection(URL, user, password);
            }
            // Created a new connection in pool
        } catch (SQLException throwables) {
            return null;
        }
        return con;
    }

    public synchronized void setFreeConnections(Connection con) {
        // Put the connection at the end of the List
        if((con != null) && (freeConnections.size() <= maxConn)) {
            freeConnections.add(con);
        }
    }

    public synchronized void release() {
        Iterator allConnections = freeConnections.iterator();
        while (allConnections.hasNext()) {
            Connection con = (Connection) allConnections.next();
            try {
                con.close();
                // Closed connection for pool
            } catch (SQLException e) {
                // Can't close connection for pool
            }
        }
        freeConnections.clear();
    }
}
