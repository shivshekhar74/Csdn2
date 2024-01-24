package comc.shiv.csdn;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    SharedPreferenceUtils share_class;
    Context context;
    String ext_user_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        context =this;

        share_class = new SharedPreferenceUtils(context);
        ext_user_name = share_class.getStringValue("ext_user_name", null);

        boolean temp_check = isNetworkConnected();
        if (!temp_check) {
            show_alert("Internet connection not available, kindly check and try again.");
            return;
        } else {
            splash_screen();

        }


    }

    public void splash_screen() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                if (ext_user_name == null) {
                    Intent login_intent = new Intent(SplashScreenActivity.this, Login_Activity.class);
                    startActivity(login_intent);
                    finish();
                } else {
                    Intent login_intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(login_intent);
                    finish();
                }



            }
        }, SPLASH_TIME_OUT);
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public void show_alert(String msg) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
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
