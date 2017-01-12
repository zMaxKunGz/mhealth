package mhealt.kku.funlhek.activity;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import mhealt.kku.funlhek.R;
import mhealt.kku.funlhek.fragment.SeacrhFragment;

//toolbar ด้านบน


public class SearchActivity extends AppCompatActivity {

    //toolbar ด้านบน
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initInstances();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, SeacrhFragment.newInstance())
                    .commit();
        }

    }

    private void initInstances() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Information");
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                SearchActivity.this,
                drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer
        );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_current, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* if (item.getItemId() == R.id.action_profile) {
            Intent intent = new Intent(ProfileActivity.this,
                    ProfileEditActivity.class);
            startActivity(intent);
            return true;
        }*/
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            finish();
            //return  true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void finish() {
        super.finish();

    }
}
