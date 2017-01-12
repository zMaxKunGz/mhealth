package mhealt.kku.funlhek.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import mhealt.kku.funlhek.R;
import mhealt.kku.funlhek.dao.Clinic;

public class DataActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

        // Try
        //DatabaseReference mUsersRef = mRootRef.child("users");
        //DatabaseReference mMessagesRef = mRootRef.child("messages");

        // Push
        // 1.
        // mUsersRef.child("id-12345").setValue("Jirawatee");

        /* 2.
        FriendlyMessage friendlyMessage = new FriendlyMessage("Hello World!", "Jirawatee");
        mMessagesRef.push().setValue(friendlyMessage);
        */

        // 3. push เป็นการ generate $postid ของ object ชื่อ posts ออกมาก่อนเพื่อใช้ใน // /user-posts/$userid/$postid
        //String key = mMessagesRef.push().getKey();
        //HashMap<String, Object> postValues = new HashMap<>();
        //postValues.put("username", "AAAA");
        //postValues.put("text", "BBBB");

        //Map<String, Object> childUpdates = new HashMap<>();
        //childUpdates.put("/messages/" + key, postValues);
        //at Key // childUpdates.put("/messages/" + "-KaCvmd2GHgbgNQ3CF0e", postValues);
        //childUpdates.put("/user-messages/Jirawatee/" + key, postValues);

        //mRootRef.updateChildren(childUpdates);
        // Init

        //Read
       /* mRootRef.child("users").child("id-654321").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if (user == null) {
                    Toast.makeText(DataActivity.this, "Error: could not fetch user.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DataActivity.this, "User : " + user.username , Toast.LENGTH_LONG).show();
                }
                finish();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("TagDatabase", databaseError.getMessage());
            }
        });*/

        mRootRef.child("clinics").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Clinic clinic = dataSnapshot.getValue(Clinic.class);
                if (clinic == null) {
                    Toast.makeText(DataActivity.this, "Error: could not fetch user.", Toast.LENGTH_LONG).show();
                } else {
                    String[] tells  = clinic.tell.split(", ");
                    Toast.makeText(DataActivity.this, "User : " + tells[0], Toast.LENGTH_LONG).show();
                }
                // finish();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("TagDatabase", databaseError.getMessage());
            }
        });

       mTextView = (TextView) findViewById(R.id.mTextView);
    }
}



