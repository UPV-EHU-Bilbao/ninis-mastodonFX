package eus.ehu.sprint1.dataAccess;

import eus.ehu.sprint1.domain.User;
import eus.ehu.sprint1.configuration.Config;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

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
    private void initializeDB()  {

        this.open();
        this.close();

        System.out.println("The database has been initialized");

    }

    public void storeUser(User user) {
        this.open();
        String command = "INSERT INTO Userlist (username, TOKEN) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getTOKEN());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public User getUser(String username) {
        String command = "SELECT * FROM Userlist WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String TOKEN = rs.getString("TOKEN");
                String Username = rs.getString("username");
                User user = new User(Username, TOKEN);
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.close();
        return null;
    }

    public String getUserString(String username) {
        String command = "SELECT username FROM Userlist WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String Username = rs.getString("username");
                return Username;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.close();
            return "null";
    }

    public ArrayList<String> getAllUsernames() {
        ArrayList<String> usernames = new ArrayList<>();
        String command = "SELECT username FROM Userlist";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                usernames.add(username);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.close();
        return usernames;
    }

    public String getTOKEN(String username) {
        this.open();
        String command = "SELECT TOKEN FROM Userlist WHERE username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(command)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String TOKEN =rs.getString("TOKEN");
                return TOKEN;

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        this.close();
        return null;
    }
    public User login(String username) {

        String sql = "SELECT * FROM userlist WHERE username = ? ";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String username1 = rs.getString("username");
                String TOKEN = rs.getString("TOKEN");
                return new User(username1, TOKEN);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);


        }
        return null;
    }

}





