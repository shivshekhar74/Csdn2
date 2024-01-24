package comc.shiv.csdn;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;
import comc.shiv.csdn.utils.LocaleUtils;
import butterknife.Bind;

public class Login_Activity extends AppCompatActivity {

    Context context;
    Button btn_login;
    EditText ext_user_name, ext_mobile, ext_email;
    SharedPreferenceUtils share_class;
    String request_id;
     String pass_logine;
    private int mLanguageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        context = this;
        ButterKnife.bind(this);
        LocaleUtils.initialize(this, LocaleUtils.ENGLISH);


        ext_user_name = (EditText) findViewById(R.id.ext_user_name);
        ext_mobile = (EditText) findViewById(R.id.ext_mobile);
        ext_email = (EditText) findViewById(R.id.ext_email);

        share_class = new SharedPreferenceUtils(context);


        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (++mLanguageIndex >= LocaleUtils.LocaleDef.SUPPORTED_LOCALES.length) {
                    mLanguageIndex = 0;
                }

               /* LocaleUtils.setLocale(Login_Activity.this, mLanguageIndex);
                Intent myInww = new Intent(Login_Activity.this, Login_Activity.class);
                startActivity(myInww);*/


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
                final EditText emailValidate = (EditText) findViewById(R.id.ext_email);
                final String email = emailValidate.getText().toString().trim();
                final String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.+[a-zA-Z]{2,4}+";
                if (email.matches(emailPattern)) {
                } else {
                    ext_email.setError("Invalid Email Please check");
                    ext_email.requestFocus();
                    return;
                }

                try {
                    DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
                    Date date = new Date();
                    request_id = dateFormat.format(date);

                } catch (Exception e) {

                }
                share_class.setValue("ext_user_name", ext_user_name.getText().toString());
                share_class.setValue("ext_mobile", ext_mobile.getText().toString());
                share_class.setValue("ext_email", ext_email.getText().toString());
                share_class.setValue("request_id", request_id);

                pass_logine=  "User login  successfully"+"\n"+"User Name = "+ext_user_name.getText().toString()+"\n"+
                        "User Email ID = "+ext_email.getText().toString()+"\n"+"User Mobile NO = "+ext_mobile.getText().toString();
                try {
                    LongOperation l = new LongOperation();
                    l.DTAT(pass_logine);
                    l.execute();
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }


                Intent myIn = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(myIn);
                Toast.makeText(context,"Successfully send massage for inquiry!",Toast.LENGTH_SHORT).show();


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

}
