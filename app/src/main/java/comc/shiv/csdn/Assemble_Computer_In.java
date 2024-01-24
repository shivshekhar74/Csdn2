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

import androidx.fragment.app.Fragment;

/**
 * Created by Kalptech on 27-Jan-17.
 */
public class Assemble_Computer_In extends Fragment {

    Context context;

    String[] looking_for_list = {"Gernral", "Student", "Graphics", "Gaming" ,"Editing", "Server"};
    String[] procer_name_s = {"Intel", "AMD"};

    String[] itel_processer_list = {"Core i3", "Core i5", "Core i7", "Pentium", "Celeron", "Core 2 Due"};
    String[] amd_list = {"AMD A-Series", "AMD A-Series", "AMD ATHLON", "AMD RYZEN "};
    String[] geraneation_list = {"3rd gen", "4th gen", "5th gen", "6th gen", "7th gen", "8th gen", "9th gen"};
    String[] mother_board_LIST = {"Gigabyte", "Asus", "Msi", "His", "Zebronics","ZOTAC","Foxconn"};
    String[] harddisk_list = {"250 GB", "500 GB", "1TB", "2TB"};
    String[] ram_list = {"2 GB", "4 GB", "8 GB", "16 GB"};

    String[] dvd_raw_list = {"NA", "NO", "YES"};
    String[] graphics_list = {"NA", "NO", "YES"};

    String[] cabinet_list = {"NA", "I BALL", "CIRCLE", "COOLER MASTER", "ARTICS", "ZEBRONICS", "Xpro", "intex"};

    String[] smps_list = {"NA", "I BALL", "CIRCLE", "COOLER MASTER", "ARTICS", "ZEBRONICS", "Xpro", "intex"};
    String[] keyboard_list = { "NO", "Logitech","iBall","HP","DELL","Xpro","Intex","Gaming","other"};

    String[] os_list = {"NA", "DOS","Linux"};

    String[] spekar_list = {"Normal", "2.1 Normal","5.1 Normal","2.1 Normal","2.1 bluetooth","5.1 bluetooth"};

    String[] graphic_card_list = {"Geforce", "Radeon","Any one"};

    String[] ups_list = {"600VA", "1000VA"};

    View available_tab;
    String TEMP_LOK = "Gernral";

    ArrayAdapter intel_adpater;
    ArrayAdapter amd_adpater;


    String[] genal_student_amd = {"AMD A-Series", "AMD FX", "AMD ATHLON", "AMD RYZEN "};
    String[] genal_student_amd_line = {"A10 ,A9, A8, A6,A4", "7th gen. Athlon", "RYZEN 3 ", "RYZEN 5 ", "RYZEN 7 ", "Threadripper"};

    String[] genal_student_itel = {"Core i7", "Core i5", "Core i3", "Pentium", "Celeron", "Core 2 Due"};
    String[] genal_student_itel_line = {"3th gen.", "4th gen.", "5th gen.", "6th gen. ", "7th gen. ", "8th gen."};


    String[] graphic_and_gaming_amd = {"AMD RYZEN"};
    String[] graphic_and_gaming_itel = {"Core i7", "Core i5", "Core i3"};

    String[] graphic_and_gaming_amd_line = {"RYZEN 3 ","RYZEN 5 ","RYZEN 7 ","Threadripper"};
    String[] graphic_and_gaming_intel_line = {"5th gen ","6th gen. ","7th gen. ","8th gen."};


    String[] Editing_amd = {"AMD RYZEN "};
    String[] Editing__itel = {"Core i7", "Core i5"};


    String[] Editing_amd_line = {"RYZEN 3  ","RYZEN 5  ","RYZEN 7 ","Threadripper"};
    String[] Editing_intel_line = {"6th gen. ","7th gen. ","8th gen."};

    String[] Server_amd = {"Opteron "};
    String[] Server_itel = {"Xeon"};

    String pass_looking;

    Spinner procer_type,procer_line;


    String[] monitor_list = {"HP ","DELL ","LG","Samsung ","Benq","Acer","other"};
    String[] monitor_size_list = {"18.5","20 ","22","24 "};
    Spinner ext_looking_for,procer_name;

    Spinner mother_board,hard_disk,ram,dvd_raw,graphics,cabinet,smps,keyboard,
            monitor, monitor_size,speakers,ups,os;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        available_tab = inflater.inflate(R.layout.assemble_computer, container, false);
        context = this.getActivity();
        procer_type = (Spinner) available_tab.findViewById(R.id.procer_type);
        procer_line = (Spinner) available_tab.findViewById(R.id.procer_line);

        Button  btn_submit = (Button) available_tab.findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Pext_looking_for = ext_looking_for.getSelectedItem().toString();
                String Pprocer_line = procer_line.getSelectedItem().toString();
                String Pprocer_name = procer_name.getSelectedItem().toString();
                String Pmother_board = mother_board.getSelectedItem().toString();
                String Phard_disk = hard_disk.getSelectedItem().toString();
                String Pram = ram.getSelectedItem().toString();
                String Pdvd_raw = dvd_raw.getSelectedItem().toString();
                String Pgraphics = graphics.getSelectedItem().toString();
                String Pcabinet = cabinet.getSelectedItem().toString();
                String Psmps = smps.getSelectedItem().toString();
                String Pkeyboard = keyboard.getSelectedItem().toString();
                String Pmonitor = monitor.getSelectedItem().toString();
                String Pmonitor_size = monitor_size.getSelectedItem().toString();
                String Pspeakers = speakers.getSelectedItem().toString();
                String Pups = ups.getSelectedItem().toString();
                String Pos = os.getSelectedItem().toString();

                String TEMP = "Assemble Computer"+"\n"+"\n"+"Looking for = "+ Pext_looking_for+"\n"+"Processor line = "+Pprocer_line+"\n"+"Processor Name = "+Pprocer_name+"\n"+"Mother board"
                        +Pmother_board+"\n"+"Hard Disk = "+
                        Phard_disk+"\n"+"Ram = "+ Pram+"\n"+"DVD = "+Pdvd_raw+"\n"+ "Graphic = " +Pgraphics+"\n" +"Cabinet  = "+Pcabinet+"\n"
                        +"SMPS = "+Psmps+"\n"+"Key board = "+Pkeyboard
                        +"\n"+"Monitor  = "+Pmonitor+"\n"+"Monitor size = "+Pmonitor_size+"\n"+ "Speaker =  "+Pspeakers+"\n"+"UPS = "+Pups+"\n"+"Operating System = "+Pos;


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


        ArrayAdapter procer_type_atp = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, mother_board_LIST);
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

        ArrayAdapter procer_line_adt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, procer_name_s);
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

         mother_board = (Spinner) available_tab.findViewById(R.id.mother_board);
        ArrayAdapter mother_board_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, procer_name_s);
        mother_board_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mother_board.setAdapter(mother_board_adpt);
        mother_board.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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



       cabinet = (Spinner) available_tab.findViewById(R.id.cabinet);
        ArrayAdapter cabinet_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, cabinet_list);
        cabinet_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cabinet.setAdapter(cabinet_adpt);
        cabinet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


 smps = (Spinner) available_tab.findViewById(R.id.smps);
        ArrayAdapter smps_adpt = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, smps_list);
        smps_adpt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        smps.setAdapter(smps_adpt);
        smps.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
