package comc.shiv.csdn;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    int displayheight, displaywidth;
    private SliderLayout new_arrival_slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((AppCompatActivity) this).getSupportActionBar().setTitle("CSDN");

        new_arrival_slider();

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                if (position == 0) {
                    Intent i = new Intent(getApplicationContext(), computer_details.class);
                    i.putExtra("send_position", String.valueOf(position));
                    startActivity(i);
                }
                if (position == 1) {
                    Intent i = new Intent(getApplicationContext(), computer_details.class);
                    i.putExtra("send_position", String.valueOf(position));
                    startActivity(i);
                }
                if (position == 2) {
                    Intent i = new Intent(getApplicationContext(), computer_details.class);
                    i.putExtra("send_position", String.valueOf(position));
                    startActivity(i);
                }



            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_home:

                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
                return true;
            case R.id.action_edit:
                Intent iI = new Intent(MainActivity.this, Profile_Page.class);
                startActivity(iI);
                return true;
            case R.id.action_cantact:
                Intent cantact = new Intent(MainActivity.this, Cantact_Us.class);
                startActivity(cantact);
                return true;
            case R.id.action_help:
                Intent Tab_help_disk_main = new Intent(MainActivity.this, Tab_help_disk_main.class);
                startActivity(Tab_help_disk_main);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void new_arrival_slider() {

        Integer[] mThumbIds = {R.drawable.home_computer, R.drawable.lapi,
                R.drawable.cctvcamera, R.drawable.wificamera,
                R.drawable.bio_matrix, R.drawable.vdpcontrol,

        };


        new_arrival_slider = (SliderLayout) findViewById(R.id.new_arrival_slider);

        for (int i = 0; i < mThumbIds.length; i++) {
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView.description("")
                    .image(mThumbIds[i])
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("postion", Integer.toString(i));

            new_arrival_slider.addSlider(textSliderView);

        }


        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);

        displayheight = displaymetrics.heightPixels;
        displaywidth = displaymetrics.widthPixels;

        float factor = ((float) 35 / (float) 100);
        int height = (int) (displayheight * factor);

        android.view.ViewGroup.LayoutParams layoutParams = new_arrival_slider.getLayoutParams();
        layoutParams.height = height;
        layoutParams.width = displaywidth;
        new_arrival_slider.setLayoutParams(layoutParams);
        new_arrival_slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        new_arrival_slider.setCustomAnimation(null);
        new_arrival_slider.setDuration(3000);



    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        //new_arrival_slider.stopAutoCycle();
        super.onStop();
    }


    @Override
    public void onSliderClick(BaseSliderView slider) {

        String scan_logo = slider.getBundle().get("postion").toString();

        Intent cantact = new Intent(MainActivity.this, Cantact_Us.class);
        startActivity(cantact);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}