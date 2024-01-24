package comc.shiv.csdn;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Kalptech on 22-Oct-18.
 */

public class TAB_HELP_REGISTER_PAGE extends Fragment {


    View available_tab;
    Context context;
    String encodedImage;
    ImageView user_pic;
    String[] inquiry_list = {"Select product", "Computer", "Laptop", "CCTV Camera", "Wifi Camera", "Bio Metric", "VDP System",
            "Web application", "other Services"};

    Spinner looking_for, call_type;
    EditText location, tpye_mgas, ext_user_mobile, clint_id;
    LinearLayout show_img_hide;

    String[] call_type_list = {"Service", "Repair", "Network", "Installation ", "Renew AMC Service"};

    String pass_data;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        available_tab = inflater.inflate(R.layout.help_register_page, container, false);
        context = this.getActivity();

        LinearLayout hide = (LinearLayout) available_tab.findViewById(R.id.hide);
        hide.setVisibility(View.VISIBLE);
        show_img_hide = (LinearLayout) available_tab.findViewById(R.id.show_img_hide);
        show_img_hide.setVisibility(View.GONE);

        looking_for = (Spinner) available_tab.findViewById(R.id.inquiry_type);
        call_type = (Spinner) available_tab.findViewById(R.id.call_type);

        location = (EditText) available_tab.findViewById(R.id.location);
        tpye_mgas = (EditText) available_tab.findViewById(R.id.tpye_mgas);
        ext_user_mobile = (EditText) available_tab.findViewById(R.id.ext_user_mobile);
        clint_id = (EditText) available_tab.findViewById(R.id.clint_id);


        ArrayAdapter looking_for_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, inquiry_list);
        looking_for_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        looking_for.setAdapter(looking_for_adpt);
        looking_for.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        ArrayAdapter call_type_adp = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, call_type_list);
        call_type_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        call_type.setAdapter(call_type_adp);
        call_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        user_pic = (ImageView) available_tab.findViewById(R.id.user_pic);
        Button count_photo = (Button) available_tab.findViewById(R.id.btn_select);
        Button btn_submit = (Button) available_tab.findViewById(R.id.btn_submit);
        Button btn_reset = (Button) available_tab.findViewById(R.id.btn_reset);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (ext_user_mobile.getText().toString().equals("")) {
                    ext_user_mobile.setError("Mobile no cannot blank");
                    ext_user_mobile.requestFocus();
                    return;
                }

                if (clint_id.getText().toString().equals("")) {
                    clint_id.setError("Client id cannot be blank");
                    clint_id.requestFocus();
                    return;
                }

                if (location.getText().toString().equals("")) {
                    location.setError("Location cannot be blank");
                    location.requestFocus();
                    return;
                }
                if (tpye_mgas.getText().toString().equals("")) {
                    tpye_mgas.setError("Massage cannot be blank");
                    tpye_mgas.requestFocus();
                    return;
                }



                String looking_for1 = looking_for.getSelectedItem().toString();
                String call_type1 = call_type.getSelectedItem().toString();


                pass_data = "User Register Details " + "\n" + "Service  Name = " + looking_for1 + "\n" +
                        "User Mobile No = " + ext_user_mobile.getText().toString() + "\n" +
                        "Client Email id = " + clint_id.getText().toString()
                        + "\n" + "Location  = " + location.getText().toString()
                        + "\n" + "Client Massage = " + tpye_mgas.getText().toString();


                try {
                    LongOperation l = new LongOperation();
                    l.DTAT(pass_data);
                    l.execute();
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }

                location.setText("");
                tpye_mgas.setText("");
                looking_for.setSelection(0);
                ext_user_mobile.setText("");
                clint_id.setText("");

                Toast.makeText(context, "Data successfully send", Toast.LENGTH_LONG).show();

            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                location.setText("");
                tpye_mgas.setText("");
                looking_for.setSelection(0);
                ext_user_mobile.setText("");
                clint_id.setText("");
                user_pic.setImageResource(R.drawable.ic_launcher_background);


            }
        });

        count_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View promptView = layoutInflater.inflate(R.layout.custom_camera, null);
                final AlertDialog alertD = new AlertDialog.Builder(context).create();
                Button btn_camera = (Button) promptView.findViewById(R.id.btn_camera);
                Button btn_gallery = (Button) promptView.findViewById(R.id.btn_gallery);
                btn_camera.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        alertD.cancel();
                        if (ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                            Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent, 1);
                        } else {
                            checkAndRequestPermissions();
                        }


                    }
                });

                btn_gallery.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        alertD.cancel();
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent, 11);

                    }
                });

                alertD.setView(promptView);
                alertD.show();


            }
        });

        return available_tab;

    }

    private void checkAndRequestPermissions() {
        int permissionSendMessage = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CAMERA);
        if (permissionSendMessage != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.CAMERA}, 1);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1 && resultCode == getActivity().RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            user_pic.setImageBitmap(bitmap);
            show_img_hide.setVisibility(View.VISIBLE);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] imageBytes = baos.toByteArray();
            if (imageBytes.length < 2097152) {
                encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
            } else {
                Toast.makeText(getActivity(), "Please Select the image of lesser than 3mb", Toast.LENGTH_LONG).show();
                user_pic.setImageBitmap(null);

            }

        }
        if (requestCode == 11 && resultCode == getActivity().RESULT_OK && null != data) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));
                user_pic.setImageBitmap(bitmap);
                show_img_hide.setVisibility(View.VISIBLE);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] imageBytes = baos.toByteArray();
                if (imageBytes.length < 2097152) {
                    encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
                } else {
                    Toast.makeText(getActivity(), "Please Select the image of lesser than 3mb", Toast.LENGTH_LONG).show();
                    user_pic.setImageBitmap(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
