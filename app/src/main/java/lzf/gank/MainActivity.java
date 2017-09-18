package lzf.gank;

import lzf.common.base.BaseActivity;
import lzf.common.network.CustomSubscriber;
import lzf.common.network.RetrofitProxy;
import lzf.common.network.bean.UserBean;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void loadData() {
        //test
        RetrofitProxy.getData(apiService.doLogin("", ""), new CustomSubscriber<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {

            }
        });
    }
}
