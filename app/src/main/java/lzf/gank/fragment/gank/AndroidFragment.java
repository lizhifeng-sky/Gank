package lzf.gank.fragment.gank;

import android.view.View;

import butterknife.ButterKnife;
import lzf.common.base.BaseFragment;

/**
 * Created by Administrator on 2017/9/21 0021.
 */
public class AndroidFragment extends BaseFragment {
    @Override
    public void initVariable(View view) {
        ButterKnife.bind(this,view);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void loadData() {

    }
}
