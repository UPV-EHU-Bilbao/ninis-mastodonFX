package eus.ehu.sprint1.DataAccess;

import eus.ehu.sprint1.configuration.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbAccessManager {
    private Connection conn = null;
    private String dbpath;

    public void open() {
        try {
            String url = "jdbc:sqlite:" + dbpath;
            conn = DriverManager.getConnection(url);

            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server " + e);
        }
    }

    public void close() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        System.out.println("Database connection closed");
    }


    // singleton pattern
    private static final DbAccessManager instance = new DbAccessManager();


    public static DbAccessManager getInstance() {
        return instance;
    }

    private DbAccessManager() {

        dbpath = Config.getInstance().getDatabaseName();
        if (Config.getInstance().getDataBaseOpenMode().equals("initialize")) {
            truncateDB();
            initializeDB();
        }

    }
    private void truncateDB() {
        this.open();

        String[] commands = new String[]{

        };

        for (String command : commands) {
            try (PreparedStatement pstmt = conn.prepareStatement(command)) {
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        this.close();
    }
    private void initializeDB() {

        this.open();



        this.close();

        System.out.println("The database has been initialized");

    }

    public void storeUser(String login, String password, String role) {
        this.open();
        String command = "INSERT INTO users (login, password, role) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.close();
    }

    public void storeToken(String token, String login) {
        this.open();
        String command = "INSERT INTO tokens (token, login) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            pstmt.setString(1, token);
            pstmt.setString(2, login);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.close();
    }
    public void getRole(String login) {
        this.open();
        String command = "SELECT role FROM users WHERE login = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            pstmt.setString(1, login);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.close();
    }
    public void getToken(String token) {
        this.open();
        String command = "SELECT token FROM tokens WHERE token = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            pstmt.setString(1, token);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.close();
    }
    public void getLogin(String login) {
        this.open();
        String command = "SELECT login FROM users WHERE login = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            pstmt.setString(1, login);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.close();
    }
    public void getPassword(String password) {
        this.open();
        String command = "SELECT password FROM users WHERE password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            pstmt.setString(1, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.close();
    }
    public void getRoleToken(String token) {
        this.open();
        String command = "SELECT role FROM users WHERE token = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            pstmt.setString(1, token);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.close();
    }




}
