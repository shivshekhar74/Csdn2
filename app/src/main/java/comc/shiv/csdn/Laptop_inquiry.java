package comc.shiv.csdn;

import android.content.Context;
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
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Kalptech on 03-Oct-18.
 */

public class Laptop_inquiry extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Context context;
    String[] procer_name = { "Intel", "AMD"};
    String[] itel_processer_list = {"intel Core i8", "Core i7", "Core i5", "Core i3", "Pentium ","Celeron","Core 2 Due"};
    String[] amd_list = { "A-Series", "A-Series  Pro","Ryzen", "Ryzen Pro "};
    String[] geraneation_list = { "3rd gen", "4th gen", "5th gen", "6th gen", "7th gen","8th gen","9th gen"};
    String[] harddisk_list = {"250 GB", "500 GB", "1TB", "2TB"};
    String[] ram_list = {"2 GB", "4 GB", "8 GB", "16 GB"};

    String[] dvd_raw_list = {"NA", "NO", "YES"};
    String[] graphics_list = {"NA", "NO", "YES"};
    String[] os_list = {"NA", "DOS","Windows","Linux"};
    ////  EXTA PARAMETER
    String[] Purpose_list = {"Student/Home", "Office","Graphics"};
    String[] brand_name_list = {"HP", "DELL","ACER","LENOVO","THINKPAD","iBALL","Any other"};

    Button  btn_submit;

    Spinner Purpose,brand_name,procer_nam,hard_disk,ramdvd_raw,graphics,os,spin,dvd_raw,ram,generation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laptop_inqueri);
        context = this;


        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Purpose1 = Purpose.getSelectedItem().toString();
                String brand_name1 = brand_name.getSelectedItem().toString();
                String procer_nam1 = procer_nam.getSelectedItem().toString();

                String proceser_type = spin.getSelectedItem().toString();
                String generation1 = generation.getSelectedItem().toString();
                String ram1   = ram.getSelectedItem().toString();
                String hard_disk1   = hard_disk.getSelectedItem().toString();


                String dvd_raw1   = dvd_raw.getSelectedItem().toString();
                String graphics1   = graphics.getSelectedItem().toString();

                String os1 = os.getSelectedItem().toString();


                String TEMP =  "Laptop inquiry"+"\n"+"\n"+"Purpose for = "+ Purpose1+"\n"+"Brand Name = "+brand_name1+"\n"+"Hard Disk = "+hard_disk1+"\n"+
                        "Ram = "+ram1+"\n"+ "DVD = " +dvd_raw1+"\n"+ "Graphic = "+graphics1+"\n"+"Processor Name = "+procer_nam1+"\n"+
                        "Processor Type = "+proceser_type+"\n"+"Generation  = "+generation1
                        +"\n"+"O.S = "+os1;

                try {
                    LongOperation l = new LongOperation();
                    l.DTAT(TEMP);
                    l.execute();
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
                Toast.makeText(context,"Successfully send massage for inquiry!",Toast.LENGTH_SHORT).show();
            }
        });

        /////   Purpose related functionality
        Purpose = (Spinner) findViewById(R.id.Purpose);
        ArrayAdapter Purpose_ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Purpose_list);
        Purpose_ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Purpose.setAdapter(Purpose_ad);
        Purpose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int userSelectedIndex = position;


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        /////   BRAND related functionality
         brand_name = (Spinner) findViewById(R.id.brand_name);
        ArrayAdapter brand_name_ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brand_name_list);
        brand_name_ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brand_name.setAdapter(brand_name_ad);
        brand_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int userSelectedIndex = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });





        ////     proceeser
    procer_nam = (Spinner) findViewById(R.id.processer);
        procer_nam.setOnItemSelectedListener(this);
        ArrayAdapter A = new ArrayAdapter(this, android.R.layout.simple_spinner_item, procer_name);
        A.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        procer_nam.setAdapter(A);

        /////      genration
         generation = (Spinner) findViewById(R.id.generation);
        ArrayAdapter B = new ArrayAdapter(this, android.R.layout.simple_spinner_item, geraneation_list);
        B.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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


        ////  Hard DISK



        hard_disk = (Spinner) findViewById(R.id.hard_disk);
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
        ram = (Spinner) findViewById(R.id.ram);
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
         dvd_raw = (Spinner) findViewById(R.id.dvd_raw);
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



         graphics = (Spinner) findViewById(R.id.graphics);
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








         os = (Spinner) findViewById(R.id.os);
        ArrayAdapter L = new ArrayAdapter(this, android.R.layout.simple_spinner_item, os_list);
        L.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        os.setAdapter(L);
        os.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

        String procceser_name = procer_name[position];



        if (procceser_name.equals("Intel")) {
           spin = (Spinner) findViewById(R.id.proceesor_type);
            ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, itel_processer_list);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin.setAdapter(aa);
        } else if (procceser_name.equals("AMD")) {
            spin = (Spinner) findViewById(R.id.proceesor_type);
            ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, amd_list);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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

                Intent i = new Intent(Laptop_inquiry.this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.action_edit:
                Intent iI = new Intent(Laptop_inquiry.this, Login_Activity.class);
                startActivity(iI);
                return true;
            case R.id.action_cantact:
                Intent cantact = new Intent(Laptop_inquiry.this, Cantact_Us.class);
                startActivity(cantact);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
