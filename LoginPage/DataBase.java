package AWT.LoginPage;

import JDBC.User;

import java.sql.*;

public class DataBase {
    private Connection connection = null;

    public DataBase() {
        try {
            connection = DriverManager.getConnection(User.URL, User.USERNAME, User.PASS);
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public Status verify(String username, String pass) {
        if (username.isEmpty()) {
            return Status.invalidUsername;
        }


        String query = "SELECT userName,pass FROM users WHERE userName = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();


            if (!rs.next()) {
                return Status.invalidUsername;
            }

            if (rs.getString(1).equals(username)) {
                if (rs.getString(2).equals(pass)) {
                    return Status.valid;
                } else {
                    return Status.invalidPassword;
                }
            } else {
                return Status.invalidUsername;
            }
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            return Status.error;
        }
    }

    public String[] getInfo(String username) {
        String query = "SELECT * FROM users WHERE userName = ?;";
        String[] arr = new String[4];

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            rs.next();

            arr[0] = rs.getString("name");
            arr[1] = rs.getString("userName");
            arr[2] = rs.getString("email");
            arr[3] = rs.getString("pass");

            ps.close();
            rs.close();
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }

        return arr;
    }

    public Boolean insertData(String name, String username, String email, String pass) {
        String query = "INSERT INTO users(name, username, email, pass) VALUES(?, ?, ?, ?);";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, email);
            ps.setString(4, pass);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected < 0) {
                return false;
            }
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            return false;
        }

        return true;
    }

    public Boolean isExist(String username) {
        String query = "SELECT userName FROM users WHERE userName = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }

        return false;
    }

    public void close() {
        try {
            connection.close();
            System.out.println("Connection Closed");
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
