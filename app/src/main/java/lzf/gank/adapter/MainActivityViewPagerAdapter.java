package lzf.gank.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import lzf.gank.R;

/**
 * Created by Administrator on 2017/9/21 0021.
 */
public class MainActivityViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> fragmentTitle;
    private List<Fragment> fragmentList;

    public MainActivityViewPagerAdapter(FragmentManager fm, List<String> fragmentTitle, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentTitle = fragmentTitle;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }

    public View getTabView(Context context,int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_main_tabview, null);
        TextView textView = (TextView) v.findViewById(R.id.title);
        textView.setText(fragmentTitle.get(position));
        return v;
    }
}
