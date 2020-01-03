package com.Herwaarden.Friend.DAL.Interface.Repository;

import com.Herwaarden.Friend.Model.FriendsModel;

import java.util.List;

public interface IFriendRepository {
    FriendsModel getFriends();
    boolean AddFriend(int userId, int friendId);
    boolean DeleteFriend(int userId, int friendId);
    boolean AcceptFriend(int userId, int friendId);
    boolean DeclineFriend(int userId, int friendId);
}
