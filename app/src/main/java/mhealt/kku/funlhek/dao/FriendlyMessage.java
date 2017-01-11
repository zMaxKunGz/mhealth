package mhealt.kku.funlhek.dao;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by vashi on 11-Jan-17.
 */
@IgnoreExtraProperties
public class FriendlyMessage {
    public String text;
    public String username;

    public FriendlyMessage(){
        // DataSnapshot.getValue(User.class)
    }

    public FriendlyMessage(String text, String username){
        this.text = text;
        this.username = username;
    }
}
