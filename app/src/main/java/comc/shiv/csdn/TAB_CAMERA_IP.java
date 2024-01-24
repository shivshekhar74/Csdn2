package comc.shiv.csdn;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Shiv on 14-Oct-18.
 */

public class TAB_CAMERA_IP extends Fragment {

    View available_tab;
    Context context;

    String[] harddisk_list = { "1TB", "2TB", "3TB", "4TB","6TB"};
    String[] power_suply_list = {"12V DC Single Adapter", "12V DC 10AM SMPS", "12V DC 20AM SMPS", "POE Single Adapter", "POE Switch 4Port", "POE Switch 8Port", "POE Switch 16Port"};
    String[] cable_list = {"CAT 5E", "CAT 6", "CAT 6E"};
    String[] connecter_list = {"2RJ-45 1DC each", "2RJ-45 each"};
    String[] monitor_list = {"16 Inch  ", "18.5 Inch", "24 Inch", "32 Inch", "42 Inch"};

    String[] looking_for_list = {"Office ", "Building /Apartment", "Corporate", "Other"};

    String[] brand_name_list = {"CP PLUS", "PRIZOR", "DAHUA", " HIKVISION ", "Panasonic", "Active Pixel", "UNV", "ZENITS"};

    String[] cp_pusdata = {"IP Series", "Red Series"};
    String[] prizor_list = {"IP Series","Classic Series", "Royal Series"};
    String[] DAHUA_list = {"IP Series", "Pro - Series", "Lite - Series", "ECO savvy 3.0"};
    String[] HIKVISION_list = {"IP Series","Value Series", "Smart Series"};
    String[] Panasonic_list = {"IP Series",};
    String[] ActivePixel_list = {"IP Series",};
    String[] UNV_list = {"IP Series",};
    String[] ZENITS_list = {"IP Series",};
    Spinner series_series;
    TextView dvr__channel;
    EditText cameraqty, camera_qty_new;
    String[] camera_type_new_list = {"Camera type ","DOME CAMERA", "BULLET CAMERA", "PTZ CAMERA", "BOX CAMERA", "C-MOUNT CAMERA", "VARIFOCAL DOME", "VARIFOCAL BULLET"};

    String[] mega_pixel_list = {"Megapixel","1.0mp", "2.0mp", "4.0mp", "5.0mp"};

    String[] distance_list = {"Distance ","20 meters ", "30 meters", "40 meters", "50 meters", "60 meters", "60 meters to other"};
    Spinner mega_pixel;

    String[] mega_pixel_list_cp = {"1.0mp", "2.0 mp", "2.4mp", "3.0 mp", "5.0 mp"};


    String [] NVR_LIST= {"Yes","NO"};
    ArrayAdapter<String> m_adapter;

    ArrayList<String> ctype;
    ArrayList<String> cqty;
    ArrayList<String> cmega;
    ArrayList<String> cdistance;
    camera_select_adapter adapter;

    ListView listView;

    String CAMERA_TYPE;
    String CAMERA_QTY;
    String CAMERA_MEGA;
    String CAMERA_DISTANCE;
    int camera_count;

    Spinner distance,camera_type_new;

    Spinner looking_for,brand_name,hard_disk,
            power_suply,cable,connecter,monitor,dvrrack;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        available_tab = inflater.inflate(R.layout.ip_camera_tab, container, false);
        context = this.getActivity();
        series_series = (Spinner) available_tab.findViewById(R.id.series);
        mega_pixel = (Spinner) available_tab.findViewById(R.id.mega_pixel);


        ctype = new ArrayList<String>();
        cqty = new ArrayList<String>();
        cmega = new ArrayList<String>();
        cdistance = new ArrayList<String>();

         looking_for = (Spinner) available_tab.findViewById(R.id.looking_for);
        ArrayAdapter looking_for_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, looking_for_list);
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



         brand_name = (Spinner) available_tab.findViewById(R.id.brand_name);
        ArrayAdapter brand_name_adp = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, brand_name_list);
        brand_name_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brand_name.setAdapter(brand_name_adp);
        brand_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String case_name = brand_name_list[position];
                switch (case_name) {
                    case "CP PLUS":
                        ArrayAdapter looking_for_adpt = new ArrayAdapter(context, android.R.layout.simple_spinner_item, cp_pusdata);
                        looking_for_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        series_series.setAdapter(looking_for_adpt);
                        series_series.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });


                        break;
                    case "PRIZOR":
                        ArrayAdapter looking_for_adpt1 = new ArrayAdapter(context, android.R.layout.simple_spinner_item, prizor_list);
                        looking_for_adpt1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        series_series.setAdapter(looking_for_adpt1);
                        series_series.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });

                        break;
                    case "DAHUA":

                        ArrayAdapter looking_for_adpt2 = new ArrayAdapter(context, android.R.layout.simple_spinner_item, DAHUA_list);
                        looking_for_adpt2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        series_series.setAdapter(looking_for_adpt2);
                        series_series.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        break;
                    case "HIKVISION":


                        ArrayAdapter looking_for_adpt3 = new ArrayAdapter(context, android.R.layout.simple_spinner_item, HIKVISION_list);
                        looking_for_adpt3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        series_series.setAdapter(looking_for_adpt3);
                        series_series.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });

                        break;
                    case "Panasonic":

                        ArrayAdapter looking_for_adpt4 = new ArrayAdapter(context, android.R.layout.simple_spinner_item, Panasonic_list);
                        looking_for_adpt4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        series_series.setAdapter(looking_for_adpt4);
                        series_series.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        break;
                    case "Active Pixel":

                        ArrayAdapter looking_for_adpt5 = new ArrayAdapter(context, android.R.layout.simple_spinner_item, ActivePixel_list);
                        looking_for_adpt5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        series_series.setAdapter(looking_for_adpt5);
                        series_series.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        break;
                    case "VIDEOCON":
                        ArrayAdapter looking_for_adpt6 = new ArrayAdapter(context, android.R.layout.simple_spinner_item, UNV_list);
                        looking_for_adpt6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        series_series.setAdapter(looking_for_adpt6);
                        series_series.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        break;
                    case "ZENITS":
                        ArrayAdapter looking_for_adpt7 = new ArrayAdapter(context, android.R.layout.simple_spinner_item, ZENITS_list);
                        looking_for_adpt7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        series_series.setAdapter(looking_for_adpt7);
                        series_series.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        dvr__channel = (TextView) available_tab.findViewById(R.id.dvr_);
        cameraqty = (EditText) available_tab.findViewById(R.id.cameraqty);


        cameraqty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void onTextChanged(final CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(final Editable s) {
                if (!cameraqty.getText().toString().equals("")) {

                    String case_value = cameraqty.getText().toString();
                    int case_check = Integer.parseInt(case_value);

                    if (case_check == 1 || case_check <= 4) {
                        dvr__channel.setText("4 Channal");

                    } else if (case_check == 5 || case_check <= 8) {
                        dvr__channel.setText("8 Channal");
                    } else if (case_check == 9 || case_check <= 16) {
                        dvr__channel.setText("16 Channal");
                    } else if (case_check == 17 || case_check <= 32) {
                        dvr__channel.setText("32 Channal");
                    } else if (case_check == 33 || case_check <= 36) {
                        dvr__channel.setText("32 + 4 Channel");
                    } else if (case_check == 37 || case_check <= 40) {
                        dvr__channel.setText("32 + 8 Channel");
                    } else if (case_check == 41 || case_check <= 48) {
                        dvr__channel.setText("32 + 16 Channel");
                    } else if (case_check == 49 || case_check <= 64) {
                        dvr__channel.setText("32 + 32 Channel");
                    }


                }

            }
        });


         camera_type_new = (Spinner) available_tab.findViewById(R.id.camera_type_new);
        ArrayAdapter camera_type_new_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, camera_type_new_list);
        camera_type_new_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        camera_type_new.setAdapter(camera_type_new_adpt);
        camera_type_new.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                CAMERA_TYPE = camera_type_new_list[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        ArrayAdapter mega_pixel_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, mega_pixel_list);
        mega_pixel_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mega_pixel.setAdapter(mega_pixel_adpt);
        mega_pixel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                CAMERA_MEGA = mega_pixel_list[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        camera_qty_new = (EditText) available_tab.findViewById(R.id.camera_qty_new);
        listView = (ListView) available_tab.findViewById(R.id.listView);
        listView.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

         distance = (Spinner) available_tab.findViewById(R.id.distance);
        ArrayAdapter distance_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, distance_list);
        distance_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distance.setAdapter(distance_adpt);
        distance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CAMERA_QTY = camera_qty_new.getText().toString();
                CAMERA_DISTANCE = distance_list[position];


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        Button button_add = (Button) available_tab.findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(CAMERA_TYPE.equals("Camera type")){
                    show_alert("Kindly select your camera type");
                    return;

                }
                if(CAMERA_QTY.equals("")){
                    show_alert("Kindly enter your number of camera");
                    return;

                }
                if(CAMERA_MEGA.equals("Megapixel")){
                    show_alert("Kindly select your camera mega pixel");
                    return;
                }
                if(CAMERA_DISTANCE.equals("Distance")){
                    show_alert("Kindly select your camera distance");
                    return;
                }

                if (!cameraqty.getText().toString().equals("") && (!camera_qty_new.getText().toString().equals(""))) {
                    camera_type_new.setSelection(0);
                    mega_pixel.setSelection(0);
                    distance.setSelection(0);


                    CAMERA_QTY = camera_qty_new.getText().toString();
                    ctype.add(CAMERA_TYPE);
                    cqty.add(CAMERA_QTY);
                    cmega.add(CAMERA_MEGA);
                    cdistance.add(CAMERA_DISTANCE);


                    int user_qty        =  Integer.parseInt(cameraqty.getText().toString());
                    int user_select_qty =  Integer.parseInt(camera_qty_new.getText().toString());
                    camera_count=0;
                    for (int i = 0; i < cqty.size(); i++) {
                        camera_count = camera_count+Integer.parseInt(cqty.get(i));
                    }

                    if(user_qty >=camera_count){
                        adapter = new camera_select_adapter(getActivity(), ctype, cqty, cmega, cdistance);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        camera_qty_new.setText("");
                    }


                    else {

                        CAMERA_QTY = camera_qty_new.getText().toString();
                        ctype.remove(CAMERA_TYPE);
                        cqty.remove(CAMERA_QTY);
                        cmega.remove(CAMERA_MEGA);
                        cdistance.remove(CAMERA_DISTANCE);

                        show_alert("you have maximum camera select!");
                        return;
                    }



                } else {

                    show_alert("Please enter camera qty !");
                    return;
                }

            }
        });

        ///////////////////// oly capy paist

         hard_disk = (Spinner) available_tab.findViewById(R.id.hard_disk);
        ArrayAdapter hard_disk_apt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, harddisk_list);
        hard_disk_apt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hard_disk.setAdapter(hard_disk_apt);
        hard_disk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


         power_suply = (Spinner) available_tab.findViewById(R.id.power_suply);
        ArrayAdapter power_suply_atp = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, power_suply_list);
        power_suply_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        power_suply.setAdapter(power_suply_atp);
        power_suply.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


       cable = (Spinner) available_tab.findViewById(R.id.cable);
        ArrayAdapter cable_apt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, cable_list);
        cable_apt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cable.setAdapter(cable_apt);
        cable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




         connecter = (Spinner) available_tab.findViewById(R.id.connecter);
        ArrayAdapter connecter_adp = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, connecter_list);
        connecter_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        connecter.setAdapter(connecter_adp);
        connecter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


         monitor = (Spinner) available_tab.findViewById(R.id.monitor);
        ArrayAdapter monitoradpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, monitor_list);
        monitoradpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monitor.setAdapter(monitoradpt);
        monitor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


         dvrrack = (Spinner) available_tab.findViewById(R.id.dvrrack);
        ArrayAdapter dvrrack_adp = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, NVR_LIST);
        dvrrack_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dvrrack.setAdapter(dvrrack_adp);
        dvrrack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        return available_tab;
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
