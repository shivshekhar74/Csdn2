package comc.shiv.csdn;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class camera_in_main_activity extends AppCompatActivity {
    ViewPager Tab;
    camera_in_pager_adapter TabAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_main_page);


        TabAdapter  = new camera_in_pager_adapter(getSupportFragmentManager());
        tabLayout   = (TabLayout) findViewById(R.id.tabs);
        Tab = (ViewPager)findViewById(R.id.pager);
        Tab.setAdapter(TabAdapter);
        Tab.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                    }
                });
        Tab.setAdapter(TabAdapter);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(Tab);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu, menu );
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_home:

                Intent i = new Intent(camera_in_main_activity.this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.action_edit:
                Intent iI = new Intent(camera_in_main_activity.this, Profile_Page.class);
                startActivity(iI);
                return true;
            case R.id.action_cantact:
                Intent cantact = new Intent(camera_in_main_activity.this, Cantact_Us.class);
                startActivity(cantact);
                return true;
            case R.id.action_help:
                Intent Tab_help_disk_main = new Intent(camera_in_main_activity.this, Tab_help_disk_main.class);
                startActivity(Tab_help_disk_main);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
