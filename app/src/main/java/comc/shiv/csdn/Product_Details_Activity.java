package comc.shiv.csdn;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by Shiv on 02-Oct-18.
 */

public class Product_Details_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        ((AppCompatActivity) this).getSupportActionBar().setTitle("Product Details");

        Integer[] computer = {R.drawable.home_computer, R.drawable.lapi,
                R.drawable.cctvcamera, R.drawable.wificamera
        };

        String[] item_list = {"here goes to product description for show", "here goes to product description for show", "here goes to product description for show", "samar bhai please provide description with image"};

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        // Instance of ImageAdapter Class
        gridView.setAdapter(new all_product_list_adapter(this,computer,item_list));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Intent i = new Intent(getApplicationContext(), compter_inquiry.class);

                i.putExtra("id", position);
                startActivity(i);

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

                Intent i = new Intent(Product_Details_Activity.this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.action_edit:
                Intent iI = new Intent(Product_Details_Activity.this, Login_Activity.class);
                startActivity(iI);
                return true;
            case R.id.action_cantact:
                Intent cantact = new Intent(Product_Details_Activity.this, Cantact_Us.class);
                startActivity(cantact);
                return true;
            case R.id.action_help:
                Intent Tab_help_disk_main = new Intent(Product_Details_Activity.this, Tab_help_disk_main.class);
                startActivity(Tab_help_disk_main);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
