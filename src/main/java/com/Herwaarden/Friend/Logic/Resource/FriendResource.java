package com.Herwaarden.Friend.Logic.Resource;

import com.Herwaarden.Friend.Logic.FriendLogic;
import com.Herwaarden.Friend.Model.MyFriendsModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class FriendResource {

    @GetMapping("/private/get/{playerId}")
    public MyFriendsModel getFriends(@PathVariable("playerId") int playerId){
        MyFriendsModel returnFriendsModel = new MyFriendsModel();

        FriendLogic friendLogic = new FriendLogic();
        returnFriendsModel = friendLogic.getFriendsByCharacterId(playerId);

        return returnFriendsModel;
    }

    @GetMapping("/public/get/{playerId}")
    public MyFriendsModel getFriendsPublic(@PathVariable("playerId") int playerId){
        MyFriendsModel returnFriendsModel = new MyFriendsModel();

        FriendLogic friendLogic = new FriendLogic();
        returnFriendsModel = friendLogic.getFriendsByCharacterId(playerId);

        return returnFriendsModel;
    }
}
