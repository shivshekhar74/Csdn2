package comc.shiv.csdn;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kalptech on 27-Jul-16.
 */
public class camera_select_adapter extends BaseAdapter {

    private final Activity context;
    ArrayList<String> ctype, cqty, cmega, cdistance;

    public camera_select_adapter(Activity context, ArrayList<String> ctype, ArrayList<String> cqty, ArrayList<String> cmega, ArrayList<String> cdistance) {
        super();
        // TODO Auto-generated constructor stub
        this.context = context;
        this.ctype = ctype;
        this.cqty = cqty;
        this.cmega = cmega;
        this.cdistance = cdistance;


    }


    @Override
    public int getCount() {
        return cdistance.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.camera_select_layout, null, true);

        TextView camera_type = (TextView) rowView.findViewById(R.id.camera_type);
        TextView camera_qty = (TextView) rowView.findViewById(R.id.camera_qty);
        TextView camera_pixel = (TextView) rowView.findViewById(R.id.camera_pixel);
        TextView camera_distance = (TextView) rowView.findViewById(R.id.camera_distance);
        TextView txt_delet = (TextView) rowView.findViewById(R.id.txt_delet);

        txt_delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case DialogInterface.BUTTON_POSITIVE:
                                ctype.remove(position);
                                cqty.remove(position);
                                cmega.remove(position);
                                cdistance.remove(position);
                                notifyDataSetChanged();

                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Are you sure want to delete?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No",
                                dialogClickListener).show();


            }
        });

        camera_type.setText(ctype.get(position));
        camera_qty.setText(cqty.get(position));
        camera_pixel.setText(cmega.get(position));
        camera_distance.setText(cdistance.get(position));
        return rowView;

    }

    ;


}
