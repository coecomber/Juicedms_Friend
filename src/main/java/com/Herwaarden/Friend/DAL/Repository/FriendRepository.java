package com.Herwaarden.Friend.DAL.Repository;

import com.Herwaarden.Friend.DAL.Interface.Context.IFriendContext;
import com.Herwaarden.Friend.DAL.Interface.Repository.IFriendRepository;
import com.Herwaarden.Friend.Model.FriendsModel;

import java.util.List;

public class FriendRepository implements IFriendRepository {

    private IFriendContext friendContext;

    // Constructors
    public FriendRepository(IFriendContext context)
    {
        friendContext = context;
    }


    // Methods from Interface
    @Override
    public FriendsModel getFriends() {
        return friendContext.getFriends();
    }

    @Override
    public boolean AddFriend(int userId, int friendId) {
        return friendContext.AddFriend(userId, friendId);
    }

    @Override
    public boolean DeleteFriend(int userId, int friendId) {
        return friendContext.DeleteFriend(userId, friendId);
    }

    @Override
    public boolean AcceptFriend(int userId, int friendId) {
        return friendContext.AcceptFriend(userId, friendId);
    }

    @Override
    public boolean DeclineFriend(int userId, int friendId) {
        return friendContext.DeleteFriend(userId, friendId);
    }
}
