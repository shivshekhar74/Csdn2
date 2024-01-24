package comc.shiv.csdn;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kalptech on 27-Jul-16.
 */
public class all_product_list_adapter extends BaseAdapter  {

    private final Activity context;
    TextView txt_name;
    ImageView imageView;
    Integer[] mThumbIds;
    String[] item_list;

    public all_product_list_adapter(Activity context, Integer[] mThumbIds, String[] item_list) {
        super();
        // TODO Auto-generated constructor stub
        this.context = context;
        this.mThumbIds = mThumbIds;
        this.item_list = item_list;
    }



    @Override
    public int getCount() {
        return  mThumbIds.length;
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
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.product_detais_ad, null,true);

        txt_name = (TextView) rowView.findViewById(R.id.item_name_show);
        imageView = (ImageView) rowView.findViewById(R.id.imageView);

        imageView.setImageResource(mThumbIds[position]);
        txt_name.setText(item_list[position]);



        return rowView;

    };


}
