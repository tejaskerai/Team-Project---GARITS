package Database;

import Database.DBConnectivity.*;

import java.sql.*;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBImplementation implements DBConnectivity {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private String userName;
    private String password;
    private String SQL;

    @Override
    public void read() {

    }

    @Override
    public void write() {

    }

    public  void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\GARITS_system\\src\\Database\\GARITSdb.db";
            // create a connection to the database
            con = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }



    @Override
    public void disconnect() {

        try { rs.close(); } catch (Exception e) { /* ignored */ }
        try { ps.close(); } catch (Exception e) { /* ignored */ }
        try { con.close(); } catch (Exception e) { /* ignored */ }

    }


    /**
     *
     * @param SQL SELECT column or table
     * @param  con !null
     */
    public ResultSet read(String SQL, Connection con) {
        // TODO - implement DBImplementation.read
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param SQL SELECT and UPDATE column or table
     * @param conn !null
     */
    public boolean write(String SQL, Connection conn) {
        // TODO - implement DBImplementation.write
        throw new UnsupportedOperationException();
    }



}