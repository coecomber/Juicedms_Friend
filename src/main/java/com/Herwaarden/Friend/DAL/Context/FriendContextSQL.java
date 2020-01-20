package com.Herwaarden.Friend.DAL.Context;

import com.Herwaarden.Friend.DAL.Interface.Context.IFriendContext;
import com.Herwaarden.Friend.Model.FriendModel;
import com.Herwaarden.Friend.Model.FriendsModel;

import java.sql.*;

public class FriendContextSQL implements IFriendContext {
    private String sqlUrl;
    private String usernameUrl;
    private String passwordUrl;

    // Constructors
    public FriendContextSQL(){
        sqlUrl = "jdbc:mysql://217.101.44.31/friendsDB";
        usernameUrl = "root";
        passwordUrl = "varken";
    }

    // Methods from Interface
    @Override
    public FriendsModel getFriends() {
        FriendsModel returnFriendsModel = new FriendsModel();

        // create our mysql database connection
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "SELECT * FROM friendstable";

            // create the java statement
            try (Statement st = conn.createStatement())
            {
                try (ResultSet rs = st.executeQuery(query))
                {
                    // iterate through the java resultset
                    while (rs.next())
                    {
                        FriendModel friendModel = new FriendModel();
                        friendModel.setFriendOneId(rs.getInt("friendOneId"));
                        friendModel.setFriendTwoId(rs.getInt("friendTwoId"));
                        friendModel.setFriendName(rs.getString("relationship"));

                        returnFriendsModel.addFriendModelListItem(friendModel);
                        System.out.println("Friendmodel: " + friendModel);
                    }
                }
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in FriendContextSQL.getFriends().");
            System.err.println(e.getMessage());
        }

        return returnFriendsModel;
    }

    @Override
    public boolean AddFriend(int userId, int friendId) {
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "INSERT INTO friendstable(friendOneId, friendTwoId) VALUES (?, ?);";

            try(PreparedStatement cst = conn.prepareStatement(query)){
                cst.setInt(1, userId);
                cst.setInt(2, friendId);
                cst.executeUpdate();
                return true;
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in FriendContextSQL.AddFriend().");
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean DeleteFriend(int userId, int friendId) {
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "DELETE FROM friendstable WHERE friendOneId = ? AND friendTwoId = ?;";

            try(PreparedStatement cst = conn.prepareStatement(query)){
                cst.setInt(1, userId);
                cst.setInt(2, friendId);
                cst.executeUpdate();
                return true;
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in FriendContextSQL.DeleteFriend().");
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean AcceptFriend(int userId, int friendId) {
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "UPDATE friendstable SET relationship = 'accepted' WHERE friendOneId = ? AND friendTwoId = ?;";

            try(PreparedStatement cst = conn.prepareStatement(query)){
                //userId is the one that accepts the request. Because the initial person that added
                //the other as a friend is the friendOneId we are now friendTwoId
                cst.setInt(1, friendId);
                cst.setInt(2, userId);
                cst.executeUpdate();
                return true;
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in FriendContextSQL.AcceptFriend().");
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean DeclineFriend(int userId, int friendId) {
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "UPDATE friendstable SET relationship = 'denied' WHERE friendOneId = ? AND friendTwoId = ?;";

            try(PreparedStatement cst = conn.prepareStatement(query)){
                //userId is the one that accepts the request. Because the initial person that added
                //the other as a friend is the friendOneId we are now friendTwoId
                cst.setInt(1, friendId);
                cst.setInt(2, userId);
                cst.executeUpdate();
                return true;
            }
        } catch (Exception e)
        {
            System.err.println(e);
            System.err.println("Got an exception in FriendContextSQL.DeclineFriend().");
            System.err.println(e.getMessage());
        }
        return false;
    }
}
