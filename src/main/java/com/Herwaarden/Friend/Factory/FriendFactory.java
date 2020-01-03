package com.Herwaarden.Friend.Factory;

import com.Herwaarden.Friend.DAL.Context.FriendContextSQL;
import com.Herwaarden.Friend.DAL.Interface.Repository.IFriendRepository;
import com.Herwaarden.Friend.DAL.Repository.FriendRepository;

public class FriendFactory {
    private FriendRepository friendRepository;

    public IFriendRepository GetFriendSQLRepository(){
        friendRepository = new FriendRepository(new FriendContextSQL());
        return friendRepository;
    }
}
