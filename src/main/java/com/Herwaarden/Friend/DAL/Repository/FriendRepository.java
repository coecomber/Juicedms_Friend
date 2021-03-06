package com.Herwaarden.Friend.DAL.Repository;

import com.Herwaarden.Friend.DAL.Interface.Context.IFriendContext;
import com.Herwaarden.Friend.DAL.Interface.Repository.IFriendRepository;
import com.Herwaarden.Friend.Model.FriendsModel;

public class FriendRepository implements IFriendRepository {

    // How to make REST at least level 2:
    // https://martinfowler.com/articles/richardsonMaturityModel.html#level0

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
