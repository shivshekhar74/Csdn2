package comc.shiv.csdn;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class computer_details extends AppCompatActivity {
    String postion_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_computer);
        ((AppCompatActivity) this).getSupportActionBar().setTitle("Product Details!");
        Bundle extras;
        extras = getIntent().getExtras();
        postion_ = extras.getString("send_position");

        ListView gridView = (ListView) findViewById(R.id.grid_view);
        gridView.setAdapter(new computer_adpater(this, postion_));

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (postion_.equals("0")) {
                    Intent i = new Intent(getApplicationContext(), Tab_main_for_activity.class);
                    startActivity(i);
                }
                if (postion_.equals("1")) {
                    Intent i = new Intent(getApplicationContext(), Laptop_inquiry.class);
                    startActivity(i);
                }
                if (postion_.equals("2")) {
                    Intent i = new Intent(getApplicationContext(), camera_in_main_activity.class);
                    startActivity(i);
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_home:

                Intent i = new Intent(computer_details.this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.action_edit:
                Intent iI = new Intent(computer_details.this, Profile_Page.class);
                startActivity(iI);
                return true;
            case R.id.action_cantact:
                Intent cantact = new Intent(computer_details.this, Cantact_Us.class);
                startActivity(cantact);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}