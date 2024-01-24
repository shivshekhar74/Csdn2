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
public class computer_adpater extends BaseAdapter {

    private final Activity context;
    ImageView imageView;
    String TEMPPOSTION;

    public computer_adpater(Activity context, String POSTION) {
        super();
        // TODO Auto-generated constructor stub
        this.context = context;
        this.TEMPPOSTION = POSTION;
    }


    public Integer[] mThumbIds = {R.drawable.sellcomputer1, R.drawable.sellcomputer2,
            R.drawable.sellcomputer3, R.drawable.inqury
    };

    String[] item_list = {"HP best pc", "Lenevo best pc", "Acer best pc", "ENQUIRY "};
    String[] price_lis = {"15000 To 20000", "14000 to 34000", "18000 to 35000", ""};

    String[] item_discription = {"This document pertains to HP Notebook PCs with Windows Vista. The System Information tool is a utility that displays information that is specific to your computer", "The ThinkCentre is a line of business-oriented desktop computers which was introduced in 2003 by IBM and since has been produced and sold by Lenovo since 2005", "AImage result for acer desktop description\n" +
            "Acer Desktop Computer. ... This range of desktops is tested on a number of grounds before delivering them to our clients in order to certify its flawless variety.", ""};


    public Integer[] latp_img = {R.drawable.lapi1, R.drawable.lapi2,
            R.drawable.lapi3, R.drawable.inqury
    };

    String[] laptop_item = {"HP best Laptop", "Lenevo best Laptop", "Acer best Laptop", "ENQUIRY "};
    String[] laptop_price = {"15000 To 20000", "14000 to 34000", "18000 to 35000", ""};

    String[] laptop_discription = {"This document pertains to HP Notebook PCs with Windows Vista. The System Information tool is a utility that displays information that is specific to your computer", "The ThinkCentre is a line of business-oriented desktop computers which was introduced in 2003 by IBM and since has been produced and sold by Lenovo since 2005", "AImage result for acer desktop description\n" +
            "Acer Desktop Computer. ... This range of desktops is tested on a number of grounds before delivering them to our clients in order to certify its flawless variety.", ""};


    public Integer[] cccamera = {R.drawable.cccamera1, R.drawable.cccamera2,
            R.drawable.camera3, R.drawable.inqury
    };

    @Override
    public int getCount() {
        return mThumbIds.length;
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
        View rowView = inflater.inflate(R.layout.product_details_discription, null, true);

        imageView = (ImageView) rowView.findViewById(R.id.imageView);

        TextView txt_title = (TextView) rowView.findViewById(R.id.txt_title);
        TextView txt_price = (TextView) rowView.findViewById(R.id.txt_price);
        TextView txt_discription = (TextView) rowView.findViewById(R.id.txt_discription);


        if (TEMPPOSTION.equals("0")) {
            imageView.setImageResource(mThumbIds[position]);
            txt_title.setText(item_list[position]);
            txt_discription.setText(item_discription[position]);
            txt_price.setText("Rs " + price_lis[position]);
        }
        if (TEMPPOSTION.equals("1")) {

            imageView.setImageResource(latp_img[position]);
            txt_title.setText(laptop_item[position]);
            txt_discription.setText(laptop_discription[position]);
            txt_price.setText("Rs " + laptop_price[position]);

        }
        if (TEMPPOSTION.equals("2")) {
            imageView.setImageResource(cccamera[position]);
            txt_title.setText(item_list[position]);
            txt_discription.setText(item_discription[position]);
            txt_price.setText(price_lis[position]);
        }
        return rowView;
    }


}
