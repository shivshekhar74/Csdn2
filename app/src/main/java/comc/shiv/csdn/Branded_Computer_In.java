package comc.shiv.csdn;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Kalptech on 27-Jan-17.
 */
public class Branded_Computer_In extends Fragment {

    Context context;

    String[] looking_for_list = {"Gernral", "Student", "Graphics", "Gaming", "Editing", "Server"};
    String[] procer_name_s = {"Intel", "AMD"};

    String[] harddisk_list = {"500 GB SATA", "1TB SATA", "2 TB SATA", "SSD 128GB", "SSD 256GB"};
    String[] ram_list = {"2 GB", "4 GB", "8 GB", "16 GB", "32 GB"};

    String[] dvd_raw_list = {"NA", "NO", "YES"};
    String[] keyboard_list = {"NO", "Logitech", "iBall", "HP", "DELL", "Xpro", "Intex", "Gaming", "other"};

    String[] os_list = {"NA", "DOS", "Linux"};

    String[] spekar_list = {"Normal", "2.1 Normal", "5.1 Normal", "2.1 Normal", "2.1 bluetooth", "5.1 bluetooth"};

    String[] graphic_card_list = {"Geforce", "Radeon", "Any one"};

    String[] ups_list = {"600VA", "1000VA"};


    String[] genal_student_amd = {"AMD A-Series", "AMD FX", "AMD ATHLON", "AMD RYZEN ", "AMD A-Series  Pro"};
    String[] genal_student_amd_line = {"AMD FX 8-Core", "7th Gen. A9 Series", "7th Gen. A8 Series ", "AMD RYZEN 7 ", "AMD RYZEN 5", "AMD RYZEN 3", " AMD PRO A6-Series"};

    String[] genal_student_itel = {"Core i7", "Core i5", "Core i3", "Pentium", "Celeron", "Core 2 Due"};
    String[] genal_student_itel_line = {"3th gen.", "4th gen.", "5th gen.", "6th gen. ", "7th gen. ", "8th gen."};


    String[] graphic_and_gaming_amd = {"AMD RYZEN"};
    String[] graphic_and_gaming_itel = {"Core i7", "Core i5", "Core i3"};

    String[] graphic_and_gaming_amd_line = {"RYZEN 3 ", "RYZEN 5 ", "RYZEN 7 ", "Threadripper"};
    String[] graphic_and_gaming_intel_line = {"5th gen ", "6th gen. ", "7th gen. ", "8th gen."};


    String[] Editing_amd = {"AMD RYZEN "};
    String[] Editing__itel = {"Core i7", "Core i5"};


    String[] Editing_amd_line = {"RYZEN 3  ", "RYZEN 5  ", "RYZEN 7 ", "Threadripper"};
    String[] Editing_intel_line = {"6th gen. ", "7th gen. ", "8th gen."};

    String[] Server_amd = {"Opteron "};
    String[] Server_itel = {"Xeon"};

    String pass_looking;

    Spinner procer_type, procer_line;


    String[] monitor_list = {"HP ", "DELL ", "LG", "Samsung ", "Benq", "Acer", "other"};
    String[] monitor_size_list = {"18.5", "20 ", "22", "24 "};
    View available_tab;

    String[] brand_list_ = {"HP", "DELL", "ACER", "LENOVO", "ASUS", "iBALL", "any other brand", "IBM"};


    Spinner ext_looking_for,procer_name,brand_name,hard_disk,ram,dvd_raw,graphics,keyboard;
    Spinner monitor,monitor_size,speakers,ups,os;

    Button btn_submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        available_tab = inflater.inflate(R.layout.dexktop, container, false);
        context = this.getActivity();

        procer_type = (Spinner) available_tab.findViewById(R.id.procer_type);
        procer_line = (Spinner) available_tab.findViewById(R.id.procer_line);

        btn_submit = (Button) available_tab.findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ext_looking_for1 = ext_looking_for.getSelectedItem().toString();
                String procer_name1 = procer_name.getSelectedItem().toString();
                String brand_name1 = brand_name.getSelectedItem().toString();

                String hard_disk1 = hard_disk.getSelectedItem().toString();
                String ram1 = ram.getSelectedItem().toString();
                String dvd_raw1 = dvd_raw.getSelectedItem().toString();
                String graphics1 = graphics.getSelectedItem().toString();
                String keyboard1 = keyboard.getSelectedItem().toString();
                String monitor1 = monitor.getSelectedItem().toString();

                String monitor_size1 = monitor_size.getSelectedItem().toString();
                String speakers1 = speakers.getSelectedItem().toString();

                String ups1 = ups.getSelectedItem().toString();
                String os1 = os.getSelectedItem().toString();

                String TEMP =  "Branded Computer"+"\n"+"\n"+"Looking for = "+ ext_looking_for1+"\n"+"Brand Name = "+brand_name1+"\n"+"Hard Disk = "+hard_disk1+"\n"+
                        "Ram = "+ram1+"\n"+ "DVD = " +dvd_raw1+"\n"+ "Graphic = "+graphics1+"\n"+"Keyboard = "+keyboard1+"\n"+"Monitor = "+monitor1+"\n"+"Monitor Size = "+monitor_size1
                        +"\n"+"Speaker = "+speakers1+"\n"+"UPS = "+ups1+"\n"+"O.S = "+os1;

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



        ext_looking_for = (Spinner) available_tab.findViewById(R.id.ext_looking_for);
        ArrayAdapter ext_looking_for_apt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, looking_for_list);
        ext_looking_for_apt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ext_looking_for.setAdapter(ext_looking_for_apt);
        ext_looking_for.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                pass_looking = looking_for_list[position];


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        procer_name = (Spinner) available_tab.findViewById(R.id.procer_name);
        ArrayAdapter procer_name_apt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, procer_name_s);
        procer_name_apt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        procer_name.setAdapter(procer_name_apt);
        procer_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String case_name = pass_looking;

                switch (case_name) {
                    case "Gernral":
                        if (procer_name_s[position].equals("Intel")) {
                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, genal_student_itel);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });


                            ArrayAdapter procer_line_adt = new ArrayAdapter(context, android.R.layout.simple_spinner_item, genal_student_itel_line);
                            procer_line_adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_line.setAdapter(procer_line_adt);
                            procer_line.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });


                        } else {

                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, genal_student_amd);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });


                            ArrayAdapter procer_line_adt = new ArrayAdapter(context, android.R.layout.simple_spinner_item, genal_student_amd_line);
                            procer_line_adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_line.setAdapter(procer_line_adt);
                            procer_line.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });

                        }


                        break;
                    case "Student":

                        if (procer_name_s[position].equals("Intel")) {
                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, genal_student_itel);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });

                            ArrayAdapter procer_line_adt = new ArrayAdapter(context, android.R.layout.simple_spinner_item, genal_student_itel_line);
                            procer_line_adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_line.setAdapter(procer_line_adt);
                            procer_line.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });

                        } else {

                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, genal_student_amd);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });
                            ArrayAdapter procer_line_adt = new ArrayAdapter(context, android.R.layout.simple_spinner_item, genal_student_amd_line);
                            procer_line_adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_line.setAdapter(procer_line_adt);
                            procer_line.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });
                        }

                        break;
                    case "Graphics":

                        if (procer_name_s[position].equals("Intel")) {
                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, graphic_and_gaming_itel);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });


                            ArrayAdapter procer_line_adt = new ArrayAdapter(context, android.R.layout.simple_spinner_item, graphic_and_gaming_intel_line);
                            procer_line_adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_line.setAdapter(procer_line_adt);
                            procer_line.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });


                        } else {

                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, graphic_and_gaming_amd);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });

                            ArrayAdapter procer_line_adt = new ArrayAdapter(context, android.R.layout.simple_spinner_item, graphic_and_gaming_amd_line);
                            procer_line_adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_line.setAdapter(procer_line_adt);
                            procer_line.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });
                        }

                        break;
                    case "Gaming":

                        if (procer_name_s[position].equals("Intel")) {
                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, graphic_and_gaming_itel);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });
                            ArrayAdapter procer_line_adt = new ArrayAdapter(context, android.R.layout.simple_spinner_item, graphic_and_gaming_intel_line);
                            procer_line_adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_line.setAdapter(procer_line_adt);
                            procer_line.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });


                        } else {

                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, graphic_and_gaming_amd);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });
                            ArrayAdapter procer_line_adt = new ArrayAdapter(context, android.R.layout.simple_spinner_item, graphic_and_gaming_amd_line);
                            procer_line_adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_line.setAdapter(procer_line_adt);
                            procer_line.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });
                        }


                        break;
                    case "Editing":

                        if (procer_name_s[position].equals("Intel")) {
                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, Editing__itel);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });

                            ArrayAdapter procer_line_adt = new ArrayAdapter(context, android.R.layout.simple_spinner_item, Editing_intel_line);
                            procer_line_adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_line.setAdapter(procer_line_adt);
                            procer_line.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });


                        } else {

                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, Editing_amd);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });
                            ArrayAdapter procer_line_adt = new ArrayAdapter(context, android.R.layout.simple_spinner_item, Editing_amd_line);
                            procer_line_adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_line.setAdapter(procer_line_adt);
                            procer_line.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });
                        }

                        break;

                    case "Server":

                        if (procer_name_s[position].equals("Intel")) {
                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, Server_itel);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });


                        } else {

                            ArrayAdapter procer_type_atp = new ArrayAdapter(context, android.R.layout.simple_spinner_item, Server_amd);
                            procer_type_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            procer_type.setAdapter(procer_type_atp);
                            procer_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {
                                }
                            });
                        }


                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        brand_name = (Spinner) available_tab.findViewById(R.id.brand_name);
        ArrayAdapter brand_name_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, brand_list_);
        brand_name_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brand_name.setAdapter(brand_name_adpt);
        brand_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        hard_disk = (Spinner) available_tab.findViewById(R.id.hard_disk);
        ArrayAdapter hard_disk_atp = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, harddisk_list);
        hard_disk_atp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hard_disk.setAdapter(hard_disk_atp);
        hard_disk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        ram = (Spinner) available_tab.findViewById(R.id.ram);
        ArrayAdapter ram_apt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, ram_list);
        ram_apt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ram.setAdapter(ram_apt);
        ram.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        dvd_raw = (Spinner) available_tab.findViewById(R.id.dvd_raw);
        ArrayAdapter dvd_raw_list_adp = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, dvd_raw_list);
        dvd_raw_list_adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dvd_raw.setAdapter(dvd_raw_list_adp);
        dvd_raw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        graphics = (Spinner) available_tab.findViewById(R.id.graphics);
        ArrayAdapter graphics_adt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, graphic_card_list);
        graphics_adt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        graphics.setAdapter(graphics_adt);
        graphics.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        keyboard = (Spinner) available_tab.findViewById(R.id.keyboard);
        ArrayAdapter keyboard_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, keyboard_list);
        keyboard_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        keyboard.setAdapter(keyboard_adpt);
        keyboard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        monitor = (Spinner) available_tab.findViewById(R.id.monitor);
        ArrayAdapter monitor_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, monitor_list);
        monitor_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monitor.setAdapter(monitor_adpt);
        monitor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        monitor_size = (Spinner) available_tab.findViewById(R.id.monitor_size);
        ArrayAdapter monitor_size_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, monitor_size_list);
        monitor_size_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monitor_size.setAdapter(monitor_size_adpt);
        monitor_size.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        speakers = (Spinner) available_tab.findViewById(R.id.speakers);
        ArrayAdapter speakers_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, spekar_list);
        speakers_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speakers.setAdapter(speakers_adpt);
        speakers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        ups = (Spinner) available_tab.findViewById(R.id.ups);
        ArrayAdapter ups_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, ups_list);
        ups_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ups.setAdapter(ups_adpt);
        ups.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        os = (Spinner) available_tab.findViewById(R.id.os);
        ArrayAdapter os_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, os_list);
        os_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        os.setAdapter(os_adpt);
        os.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        return available_tab;
    }

}
