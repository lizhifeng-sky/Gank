package lzf.gank.fragment.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import lzf.common.base.BaseFragment;
import lzf.common.network.CustomSubscriber;
import lzf.common.network.RetrofitProxy;
import lzf.common.network.bean.UserBean;
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
//        RetrofitProxy.getData(apiService.doLogin("15824857592","888888")).subscribe(new CustomSubscriber<UserBean>() {
//            @Override
//            public void onSuccess(UserBean userBean) {
//                Log.e("lzf_success",userBean.toString());
//            }
//        });
//        RetrofitProxy.getData(apiService.doLogin("15824857592","123456")).subscribe(new CustomSubscriber<UserBean>() {
//            @Override
//            public void onSuccess(UserBean userBean) {
//                Log.e("lzf_success",userBean.toString());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                super.onError(e);
//                Log.e("lzf_onError",e.getMessage());
//            }
//        });
        RetrofitProxy
                .getData(apiService.doLogin("15824857592","888888"))
                .subscribe(new CustomSubscriber<UserBean>() {
                    @Override
                    public void onSuccess(UserBean userBean) {
                        Log.e("lzf_success",userBean.toString());
                    }
                });
    }

    @Override
    public void initVariable(View view) {
        ButterKnife.bind(this,view);
    }
}
