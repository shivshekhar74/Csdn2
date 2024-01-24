package comc.shiv.csdn;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Shiv on 02-Oct-18.
 */

public class Cantact_Us extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] inquiry_list = {"Select product", "Computer", "Laptop", "CCTV Camera", "Wifi Camera", "Bio Metric", "VDP System",
            "Web application", "other Services"};
    String product_name;
    EditText ext_user_name, ext_user_mobile, massege, location;
    Spinner spin;
    String pass_logine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cantact_us);
        ((AppCompatActivity) this).getSupportActionBar().setTitle("Contact us");


        Button btn_submit = (Button) findViewById(R.id.btn_submit);

        ext_user_name = (EditText) findViewById(R.id.ext_user_name);

        ext_user_mobile = (EditText) findViewById(R.id.ext_user_mobile);

        massege = (EditText) findViewById(R.id.locati);
        location = (EditText) findViewById(R.id.massege);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                pass_logine = "Inquiry for" + "\n" +
                        "Product Name = " + spin.getSelectedItem().toString() +"\n"+ "User Name = " + ext_user_name.getText().toString() + "\n" +
                        "\n" + "User Mobile NO = " + ext_user_mobile.getText().toString() + "\n" + "Massage = " + massege.getText().toString() + "\n" + "Location  = " + location.getText().toString();
                try {
                    LongOperation l = new LongOperation();
                    l.DTAT(pass_logine);
                    l.execute();
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
                Toast.makeText(Cantact_Us.this,"Successfully send massage for inquiry!",Toast.LENGTH_SHORT).show();

            }
        });

        Button btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spin.setSelection(0);
                ext_user_name.setText("");
                ext_user_mobile.setText("");
                massege.setText("");
                location.setText("");
            }
        });

        spin = (Spinner) findViewById(R.id.inquiry_type);
        spin.setOnItemSelectedListener(this);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, inquiry_list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        product_name = inquiry_list[position];

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
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

                Intent i = new Intent(Cantact_Us.this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.action_edit:
                Intent iI = new Intent(Cantact_Us.this, Login_Activity.class);
                startActivity(iI);
                return true;
            case R.id.action_cantact:
                Intent cantact = new Intent(Cantact_Us.this, Cantact_Us.class);
                startActivity(cantact);
                return true;
            case R.id.action_help:
                Intent Tab_help_disk_main = new Intent(Cantact_Us.this, Tab_help_disk_main.class);
                startActivity(Tab_help_disk_main);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
