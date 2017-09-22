package lzf.gank.fragment.gank;

import android.view.View;

import butterknife.ButterKnife;
import lzf.common.base.BaseFragment;
import lzf.common.network.CustomSubscriber;
import lzf.common.network.RetrofitProxy;
import lzf.common.network.bean.BaseRequestMode;
import lzf.common.network.bean.UserBean;

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
        RetrofitProxy.getData(apiService.doLogin("","")).subscribe(new CustomSubscriber<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {

            }
        });
        RetrofitProxy
                .getData(apiService.doLogin("",""))
                .subscribe(new CustomSubscriber<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {

            }
        });
    }
}
