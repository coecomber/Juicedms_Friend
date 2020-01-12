package com.Herwaarden.Friend.Logic.Resource;

import com.Herwaarden.Friend.Logic.FriendLogic;
import com.Herwaarden.Friend.Model.MyFriendsModel;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/public/add/{playerId}/{friendId}")
    public boolean addFriendPublic(@PathVariable("playerId") int playerId, @PathVariable("friendId") int friendId){
        FriendLogic friendLogic = new FriendLogic();

        try{
            friendLogic.AddFriend(playerId, friendId);
            return true;
        } catch (Exception e){
            System.err.println(e);
            System.err.println("Got an exception in FriendResource.addFriendPublic().");
            return false;
        }
    }

    @PostMapping("/public/delete/{playerId}/{friendId}")
    public boolean deleteFriendPublic(@PathVariable("playerId") int playerId, @PathVariable("friendId") int friendId){
        FriendLogic friendLogic = new FriendLogic();

        try{
            friendLogic.DeleteFriend(playerId, friendId);
            return true;
        } catch (Exception e){
            System.err.println(e);
            System.err.println("Got an exception in FriendResource.deleteFriendPublic().");
            return false;
        }
    }

    @PostMapping("/public/accept/{playerId}/{friendId}")
    public boolean acceptFriendPublic(@PathVariable("playerId") int playerId, @PathVariable("friendId") int friendId){
        FriendLogic friendLogic = new FriendLogic();

        try{
            friendLogic.AcceptFriend(playerId, friendId);
            return true;
        } catch (Exception e){
            System.err.println(e);
            System.err.println("Got an exception in FriendResource.acceptFriendPublic().");
            return false;
        }
    }

    @PostMapping("/public/decline/{playerId}/{friendId}")
    public boolean declineFriendPublic(@PathVariable("playerId") int playerId, @PathVariable("friendId") int friendId){
        FriendLogic friendLogic = new FriendLogic();

        try{
            friendLogic.DeleteFriend(playerId, friendId);
            return true;
        } catch (Exception e){
            System.err.println(e);
            System.err.println("Got an exception in FriendResource.declineFriendPublic().");
            return false;
        }
    }
}
