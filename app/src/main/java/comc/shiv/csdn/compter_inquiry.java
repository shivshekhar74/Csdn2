package comc.shiv.csdn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Kalptech on 03-Oct-18.
 */

public class compter_inquiry extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Context context;
    String[] procer_name = { "Intel", "AMD"};
    String[] itel_processer_list = {"Core i3", "Core i5", "Core i7", "Pentium", "Celeron"};
    String[] amd_list = {"FX", "A-Series", "ATHLON", "RYZEN ", "RYZEN PRO", "ATHLON PRO", "A-Series  Pro"};
    String[] geraneation_list = { "3rd gen", "4th gen", "5th gen", "6th gen", "7th gen","8th gen","9th gen"};
    String[] mother_board_LIST = {"Gigabyte", "Asus", "Msi", "His", "Zebronics"};
    String[] harddisk_list = {"250 GB", "500 GB", "1TB", "2TB"};
    String[] ram_list = {"2 GB", "4 GB", "8 GB", "16 GB"};

    String[] dvd_raw_list = {"NA", "NO", "YES"};
    String[] graphics_list = {"NA", "NO", "YES"};

    String[] cabinet_list = {"NA", "I BALL", "CIRCLE","COOLER MASTER","ARTICS","ZEBRONICS","Xpro","intex"};

    String[] smps_list = {"NA", "I BALL", "CIRCLE","COOLER MASTER","ARTICS","ZEBRONICS","Xpro","intex"};
    String[] keyboard_list = {"NA", "NO", "YES"};


    String[] os_list = {"NA", "DOS"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dexktop);
        context = this;
        ((AppCompatActivity) this).getSupportActionBar().setTitle("Computer Inquiry ");

         ////     proceeser
        Spinner procer_nam = (Spinner) findViewById(R.id.procer_name);

        procer_nam.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter A = new ArrayAdapter(this, android.R.layout.simple_spinner_item, procer_name);
        A.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        procer_nam.setAdapter(A);

        /////      genration
        Spinner generation = (Spinner) findViewById(R.id.generation);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter B = new ArrayAdapter(this, android.R.layout.simple_spinner_item, geraneation_list);
        B.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        generation.setAdapter(B);
        generation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int userSelectedIndex = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        /////      Mother bord
        Spinner mother_board = (Spinner) findViewById(R.id.mother_board);
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter C = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mother_board_LIST);
        C.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        mother_board.setAdapter(C);
        mother_board.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int userSelectedIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        ////  Hard DISK

        Spinner hard_disk = (Spinner) findViewById(R.id.hard_disk);
        ArrayAdapter D = new ArrayAdapter(this, android.R.layout.simple_spinner_item, harddisk_list);
        D.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hard_disk.setAdapter(D);
        hard_disk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int userSelectedIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        ////  RAM DATA
        Spinner ram = (Spinner) findViewById(R.id.ram);
        ArrayAdapter E = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ram_list);
        E.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        ram.setAdapter(E);
        ram.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int userSelectedIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        ////  dvd_raw DATA
        Spinner dvd_raw = (Spinner) findViewById(R.id.dvd_raw);
        ArrayAdapter F = new ArrayAdapter(this, android.R.layout.simple_spinner_item, dvd_raw_list);
        F.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dvd_raw.setAdapter(F);
        dvd_raw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int userSelectedIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ////  graphic data
        Spinner graphics = (Spinner) findViewById(R.id.graphics);
        ArrayAdapter G = new ArrayAdapter(this, android.R.layout.simple_spinner_item, graphics_list);
        G.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        graphics.setAdapter(G);
        graphics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int userSelectedIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //// CABINET data
        Spinner cabinet = (Spinner) findViewById(R.id.cabinet);
        ArrayAdapter H = new ArrayAdapter(this, android.R.layout.simple_spinner_item, cabinet_list);
        H.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cabinet.setAdapter(H);
        cabinet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int userSelectedIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //// smps data
        Spinner smps = (Spinner) findViewById(R.id.smps);
        ArrayAdapter I = new ArrayAdapter(this, android.R.layout.simple_spinner_item, smps_list);
        I.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        smps.setAdapter(I);
        smps.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String userSelectedIndex = smps_list[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //// keyword data
        Spinner keyboard = (Spinner) findViewById(R.id.keyboard);
        ArrayAdapter J = new ArrayAdapter(this, android.R.layout.simple_spinner_item, keyboard_list);
        J.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        keyboard.setAdapter(J);
        keyboard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String userSelectedIndex = smps_list[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




        //// mouse data
        Spinner os = (Spinner) findViewById(R.id.os);
        ArrayAdapter L = new ArrayAdapter(this, android.R.layout.simple_spinner_item, os_list);
        L.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        os.setAdapter(L);
        os.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String userSelectedIndex = smps_list[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Button btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Inguiry successfully sent on your email id and mobile number !", Toast.LENGTH_LONG).show();



            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    String procceser_name = procer_name[position];

        if (procceser_name.equals("Intel")) {
            Spinner spin = (Spinner) findViewById(R.id.procer_type);
            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, itel_processer_list);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spin.setAdapter(aa);
        } else if (procceser_name.equals("AMD")) {
            Spinner spin = (Spinner) findViewById(R.id.procer_type);
            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, amd_list);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spin.setAdapter(aa);
        }

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

                Intent i = new Intent(compter_inquiry.this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.action_edit:
                Intent iI = new Intent(compter_inquiry.this, Login_Activity.class);
                startActivity(iI);
                return true;
            case R.id.action_cantact:
                Intent cantact = new Intent(compter_inquiry.this, Cantact_Us.class);
                startActivity(cantact);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
