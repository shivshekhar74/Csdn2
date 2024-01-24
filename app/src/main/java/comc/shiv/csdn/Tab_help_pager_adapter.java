
package comc.shiv.csdn;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Tab_help_pager_adapter extends FragmentStatePagerAdapter {

    public Tab_help_pager_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new TAB_HELP_REGISTER_PAGE();
            case 1:
                return new HELP_UNREGISTER_PAGE();

        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "REGISTER ";
            case 1:
                return "UNREGISTER";

        }
        return null;
    }

}
