package com.Herwaarden.Friend.Logic;

import com.Herwaarden.Friend.DAL.Interface.Repository.IFriendRepository;
import com.Herwaarden.Friend.Factory.FriendFactory;
import com.Herwaarden.Friend.Model.FriendModel;
import com.Herwaarden.Friend.Model.FriendsModel;
import com.Herwaarden.Friend.Model.MyFriendModel;
import com.Herwaarden.Friend.Model.MyFriendsModel;

import java.util.List;

public class FriendLogic {
    private IFriendRepository friendRepository;

    public FriendLogic(){
        friendRepository = new FriendFactory().GetFriendSQLRepository();
    }

    public MyFriendsModel getFriendsByCharacterId(int characterId){
        FriendsModel friendsModel = friendRepository.getFriends();
        MyFriendsModel myFriendsModel = new MyFriendsModel();

        List<FriendModel> friendModelList;
        friendModelList = friendsModel.getFriendModelList();

        //Adds the other user ID to the model we're gonna return so we don't return our own ID.
        for(FriendModel friendModel : friendModelList){
            if(friendModel.getFriendOneId() == characterId || friendModel.getFriendTwoId() == characterId){
                MyFriendModel myFriendModel = new MyFriendModel();
                if (characterId == friendModel.getFriendOneId()){
                    myFriendModel.setFriendId(friendModel.getFriendTwoId());
                } else {
                    myFriendModel.setFriendId(friendModel.getFriendOneId());
                }
                myFriendModel.setFriendName(friendModel.getFriendName());
                myFriendModel.setRelationship(friendModel.getRelationship());
                myFriendsModel.addFriendModelListItem(myFriendModel);
            }
        }

        return myFriendsModel;
    }

    public boolean AddFriend(int userId, int friendId){
        return friendRepository.AddFriend(userId, friendId);
    }

    public boolean DeleteFriend(int userId, int friendId){
        return friendRepository.DeleteFriend(userId, friendId);
    }

    public boolean AcceptFriend(int userId, int friendId){
        return friendRepository.AcceptFriend(userId, friendId);
    }

    public boolean DeclineFriend(int userId, int friendId){
        return friendRepository.DeclineFriend(userId, friendId);
    }
}
