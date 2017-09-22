package lzf.gank.fragment.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import lzf.common.base.BaseFragment;
import lzf.gank.R;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public class GankFragment extends BaseFragment {
    @BindView(R.id.tab_gank)
    TabLayout tab_gank;
    @BindView(R.id.viewPager_gank)
    ViewPager viewPager;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void initVariable(View view) {
        ButterKnife.bind(this,view);
    }
}
