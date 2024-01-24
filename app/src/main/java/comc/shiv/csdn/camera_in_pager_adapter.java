
package comc.shiv.csdn;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class camera_in_pager_adapter extends FragmentStatePagerAdapter {

    public camera_in_pager_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new TAB_CAMERA_HD();
            case 1:
                return new TAB_CAMERA_IP();

        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0 :
                return "HD DVR CAMERA";
            case 1 :
                return "IP NETWORK CAMERA";

        }
        return null;
    }

}
