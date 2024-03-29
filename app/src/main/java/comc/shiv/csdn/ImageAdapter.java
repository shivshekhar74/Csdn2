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
public class ImageAdapter extends BaseAdapter  {

    private final Activity context;
    TextView txt_name;
    ImageView imageView;

    public ImageAdapter(Activity context) {
        super();
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    public Integer[] mThumbIds = {  R.drawable.ic_computer, R.drawable.ic_laptop,
            R.drawable.ic_cctv, R.drawable.ic_wifi_camera,
            R.drawable.boimatic, R.drawable.coo,

    };

    String[] item_list = {"COMPUTER", "LAPTOP", "CCTV CAMERA","WIFI CAMERA","BIO -METRIC","VDP CONTROL"};

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
        View rowView=inflater.inflate(R.layout.home_page_adapter, null,true);

        txt_name = (TextView) rowView.findViewById(R.id.item_name_show);
        imageView = (ImageView) rowView.findViewById(R.id.imageView);

        imageView.setImageResource(mThumbIds[position]);
        txt_name.setText(item_list[position]);
        return rowView;

    };


}
