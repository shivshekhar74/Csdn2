
package comc.shiv.csdn;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class dexttop_in_pager_adapter extends FragmentStatePagerAdapter {

    public dexttop_in_pager_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new Assemble_Computer_In();
            case 1:
                return new Branded_Computer_In();

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

        switch (position) {
            case 0:
                return "ASSEMBLED DESKTOP";
            case 1:
                return "BRANED DESKTOP";

        }
        return null;
    }

}
