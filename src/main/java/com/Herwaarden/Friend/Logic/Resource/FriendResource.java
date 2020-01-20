package com.Herwaarden.Friend.Logic.Resource;

import com.Herwaarden.Friend.Logic.FriendLogic;
import com.Herwaarden.Friend.Model.FriendModel;
import com.Herwaarden.Friend.Model.MyFriendsModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class FriendResource {

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @GetMapping("/private/get/{playerId}")
    public MyFriendsModel getFriendsPrivate(@PathVariable("playerId") int playerId){
        MyFriendsModel returnFriendsModel = new MyFriendsModel();

        FriendLogic friendLogic = new FriendLogic();
        returnFriendsModel = friendLogic.getFriendsByCharacterId(playerId);

        return returnFriendsModel;
    }

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @GetMapping("/public/friend/get/{playerId}")
    public MyFriendsModel getFriendsPublic(@PathVariable("playerId") int playerId){
        MyFriendsModel returnFriendsModel = new MyFriendsModel();

        FriendLogic friendLogic = new FriendLogic();
        returnFriendsModel = friendLogic.getFriendsByCharacterId(playerId);

        return returnFriendsModel;
    }

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @PostMapping("/public/friend/add/")
    public boolean addFriend(@RequestBody FriendModel friendModel){
        FriendLogic friendLogic = new FriendLogic();

        try{
            friendLogic.AddFriend(friendModel.getFriendOneId(), friendModel.getFriendTwoId());
            return true;
        } catch (Exception e){
            System.err.println(e);
            System.err.println("Got an exception in FriendResource.addFriendPublic().");
            return false;
        }
    }

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @DeleteMapping("/public/friend/delete")
    public boolean deleteFriend(@RequestBody FriendModel friendModel){
        FriendLogic friendLogic = new FriendLogic();

        try{
            friendLogic.DeleteFriend(friendModel.getFriendOneId(), friendModel.getFriendTwoId());
            return true;
        } catch (Exception e){
            System.err.println(e);
            System.err.println("Got an exception in FriendResource.deleteFriendPublic().");
            return false;
        }
    }

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @PostMapping("/public/accept")
    public boolean acceptFriend(@RequestBody FriendModel friendModel){
        FriendLogic friendLogic = new FriendLogic();

        try{
            friendLogic.AcceptFriend(friendModel.getFriendOneId(), friendModel.getFriendTwoId());
            return true;
        } catch (Exception e){
            System.err.println(e);
            System.err.println("Got an exception in FriendResource.acceptFriendPublic().");
            return false;
        }
    }

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @PostMapping("/public/decline")
    public boolean declineFriend(@RequestBody FriendModel friendModel){
        FriendLogic friendLogic = new FriendLogic();

        try{
            friendLogic.DeleteFriend(friendModel.getFriendOneId(), friendModel.getFriendTwoId());
            return true;
        } catch (Exception e){
            System.err.println(e);
            System.err.println("Got an exception in FriendResource.declineFriendPublic().");
            return false;
        }
    }
}
