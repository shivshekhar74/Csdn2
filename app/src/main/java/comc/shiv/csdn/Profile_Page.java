package comc.shiv.csdn;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Profile_Page extends AppCompatActivity {

    Context context;
    Button btn_update, btn_logut;
    EditText ext_user_name, ext_mobile, ext_email, extx_adress,alternate_no,txt_location,txt_state;
    SharedPreferenceUtils share_class;

    RadioButton male_button, female_button;
    String pass_genmder;
    TextView id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);
        context = this;

        ext_user_name = (EditText) findViewById(R.id.ext_user_name);
        ext_mobile = (EditText) findViewById(R.id.ext_mobile);
        ext_email = (EditText) findViewById(R.id.ext_email);
        share_class = new SharedPreferenceUtils(context);
        extx_adress = (EditText) findViewById(R.id.extx_adress);


        ////////

        alternate_no = (EditText) findViewById(R.id.alternate_no);
        txt_location = (EditText) findViewById(R.id.txt_location);
        txt_state    = (EditText) findViewById(R.id.txt_state);



        btn_logut = (Button) findViewById(R.id.btn_logut);

        id = (TextView) findViewById(R.id.id);


        final RadioGroup rbg = (RadioGroup) findViewById(R.id.radioGroup);
        male_button = (RadioButton) findViewById(R.id.male_button);
        female_button = (RadioButton) findViewById(R.id.female_button);


        String ext_user_name1 = share_class.getStringValue("ext_user_name", null);
        String ext_mobile1 = share_class.getStringValue("ext_mobile", null);
        String ext_email1 = share_class.getStringValue("ext_email", null);
        String extx_adress1 = share_class.getStringValue("extx_adress", null);
        String pass_genmder1 = share_class.getStringValue("pass_genmder", null);

        String request_id = share_class.getStringValue("request_id", null);

        if (request_id != null) {
            id.setText(request_id);

            alternate_no.setText(share_class.getStringValue("alternate_no", null));
            txt_location.setText(share_class.getStringValue("txt_location", null));
            txt_state.setText(share_class.getStringValue("txt_state", null));

        }


        if (ext_user_name1 != null) {
            ext_user_name.setText(ext_user_name1);
        }

        if (ext_mobile1 != null) {
            ext_mobile.setText(ext_mobile1);
        }

        if (ext_email1 != null) {
            ext_email.setText(ext_email1);
        }
        if (extx_adress1 != null) {
            extx_adress.setText(extx_adress1);
        }
        if (pass_genmder1 != null) {

            if (pass_genmder1.equals("0")) {
                pass_genmder = "0";
                male_button.setChecked(true);
                female_button.setChecked(false);

            } else {
                pass_genmder = "1";
                male_button.setChecked(false);
                female_button.setChecked(true);
            }

        }

        btn_logut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                share_class.clear();
                Intent myIntent = new Intent(Profile_Page.this, Login_Activity.class);
                startActivity(myIntent);
                finish();


            }
        });

        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ext_user_name.getText().toString().equals("")) {
                    ext_user_name.setError("Please enter you name");
                    ext_user_name.requestFocus();
                    return;
                }

                if (ext_mobile.getText().toString().equals("")) {
                    ext_mobile.setError("Please enter you mobile number");
                    ext_mobile.requestFocus();
                    return;
                }

                if (ext_email.getText().toString().equals("")) {
                    ext_email.setError("Please enter you email id");
                    ext_email.requestFocus();
                    return;
                }
                if (ext_mobile.getText().length() != 10) {
                    ext_mobile.setError("Kindly enter valid mobile number");
                    ext_mobile.requestFocus();
                    return;
                }

                if (extx_adress.getText().toString().equals("")) {
                    extx_adress.setError("Address cannot be blank");
                    extx_adress.requestFocus();
                    return;
                }

                final EditText emailValidate = (EditText) findViewById(R.id.ext_email);
                final String email = emailValidate.getText().toString().trim();
                final String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.+[a-zA-Z]{2,4}+";
                if (email.matches(emailPattern)) {
                } else {
                    ext_email.setError("Invalid Email Please check");
                    ext_email.requestFocus();
                    return;
                }

                int selected = rbg.getCheckedRadioButtonId();
                RadioButton gender = (RadioButton) findViewById(selected);
                String pass_gender = gender.getText().toString();
                if (pass_gender.trim().toLowerCase().equals("male")) {
                    pass_genmder = "0";
                } else {
                    pass_genmder = "1";
                }


                share_class.setValue("ext_user_name", ext_user_name.getText().toString());
                share_class.setValue("ext_mobile", ext_mobile.getText().toString());
                share_class.setValue("ext_email", ext_email.getText().toString());
                share_class.setValue("extx_adress", extx_adress.getText().toString());
                share_class.setValue("pass_genmder", pass_genmder);

                share_class.setValue("alternate_no", alternate_no.getText().toString());
                share_class.setValue("txt_location", txt_location.getText().toString());
                share_class.setValue("txt_state", txt_state.getText().toString());





                String MGS =  "User update profile "+"\n"+"User Name = "+ext_user_name.getText().toString()+"\n"+
                        "User Email ID = "+ext_email.getText().toString()+"\n"+"User Mobile NO = "+ext_mobile.getText().toString()+"\n"+"User Gender = "+gender.getText().toString()+"\n"
                        +"User Address = "+extx_adress.getText().toString();
                try {
                    LongOperation l = new LongOperation();
                    l.DTAT(MGS);
                    l.execute();
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }

                Intent myIn = new Intent(Profile_Page.this, MainActivity.class);
                startActivity(myIn);
                Toast.makeText(getApplicationContext(),"Successfully send massage for inquiry!",Toast.LENGTH_SHORT).show();


            }
        });

    }

    public void show_alert(String msg) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage(msg);
        builder1.setCancelable(true);
        builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alert11 = builder1.create();
        alert11.show();
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

                Intent i = new Intent(Profile_Page.this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.action_edit:
                Intent iI = new Intent(Profile_Page.this, Profile_Page.class);
                startActivity(iI);
                return true;
            case R.id.action_cantact:
                Intent cantact = new Intent(Profile_Page.this, Cantact_Us.class);
                startActivity(cantact);
                return true;
            case R.id.action_help:
                Intent Tab_help_disk_main = new Intent(Profile_Page.this, Tab_help_disk_main.class);
                startActivity(Tab_help_disk_main);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
