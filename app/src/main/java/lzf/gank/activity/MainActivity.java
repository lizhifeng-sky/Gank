package lzf.gank.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lzf.common.base.BaseActivity;
import lzf.gank.R;
import lzf.gank.adapter.MainActivityViewPagerAdapter;
import lzf.gank.fragment.main.NewsFragment;
import lzf.gank.fragment.main.MusicFragment;
import lzf.gank.fragment.main.ReadFragment;
import lzf.gank.fragment.main.VideoFragment;

public class MainActivity extends BaseActivity {
    @BindView(R.id.viewPager)
    public ViewPager viewPager;
    @BindView(R.id.tab)
    public TabLayout tabLayout;

    private MainActivityViewPagerAdapter adapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initVariable() {
        ButterKnife.bind(this);
        List<Fragment> fragmentList = new ArrayList<>();
        NewsFragment gankFragment = new NewsFragment();
        ReadFragment readFragment = new ReadFragment();
        VideoFragment videoFragment = new VideoFragment();
        MusicFragment musicFragment = new MusicFragment();
        fragmentList.add(gankFragment);
        fragmentList.add(readFragment);
        fragmentList.add(musicFragment);
        fragmentList.add(videoFragment);

        List<String> stringList = new ArrayList<>();
        stringList.add("干货");
        stringList.add("阅读");
        stringList.add("音乐");
        stringList.add("视频");
        adapter=new MainActivityViewPagerAdapter(getSupportFragmentManager(),
                stringList, fragmentList);
    }

    @Override
    public void initListener() {
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        int tabCount=tabLayout.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            TabLayout.Tab tab=tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(adapter.getTabView(getApplicationContext(),i));
            }
        }
    }
}
