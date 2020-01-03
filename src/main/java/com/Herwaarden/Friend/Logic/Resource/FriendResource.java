package com.Herwaarden.Friend.Logic.Resource;

import com.Herwaarden.Friend.Model.FriendModel;
import com.Herwaarden.Friend.Model.FriendsModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendResource {

    @RequestMapping("/get/{playerId}")
    public FriendsModel getFriends(@PathVariable("playerId") String playerId){
        FriendsModel friendsModel = new FriendsModel();

        FriendModel friendModel = new FriendModel(7, "Kees");
        FriendModel friendModel2 = new FriendModel(52, "Jan");

        friendsModel.addFriendModelListItem(friendModel);
        friendsModel.addFriendModelListItem(friendModel2);
        return friendsModel;
    }
}
