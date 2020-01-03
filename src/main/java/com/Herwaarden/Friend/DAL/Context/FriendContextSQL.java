package com.Herwaarden.Friend.DAL.Context;

import com.Herwaarden.Friend.DAL.Interface.Context.IFriendContext;
import com.Herwaarden.Friend.Model.FriendModel;
import com.Herwaarden.Friend.Model.FriendsModel;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FriendContextSQL implements IFriendContext {
    private String sqlUrl;
    private String usernameUrl;
    private String passwordUrl;

    // Constructors
    public FriendContextSQL(){
        sqlUrl = "jdbc:mysql://217.101.44.31/friendDB";
        usernameUrl = "root";
        passwordUrl = "usbw";
        System.out.println("url: " + sqlUrl + " username: " + usernameUrl + " password: " + passwordUrl);
    }

    // Methods from Interface
    @Override
    public FriendsModel getFriends() {
        FriendsModel returnFriendsModel = new FriendsModel();

        // create our mysql database connection
        try (Connection conn = DriverManager.getConnection(sqlUrl, usernameUrl, passwordUrl))
        {
            String query = "SELECT * FROM friends";

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
        return false;
    }

    @Override
    public boolean DeleteFriend(int userId, int friendId) {
        return false;
    }

    @Override
    public boolean AcceptFriend(int userId, int friendId) {
        return false;
    }

    @Override
    public boolean DeclineFriend(int userId, int friendId) {
        return false;
    }
}
