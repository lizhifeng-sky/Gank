package lzf.gank.presenter.activity;

import android.util.Log;

import lzf.common.bean.UserBean;
import lzf.common.mvp.BasePresenter;
import lzf.common.network.CustomSubscriber;
import lzf.gank.activity.TestActivity;
import lzf.gank.model.ModelProvider;
import lzf.gank.view.activity.TestActivityView;

/**
 * Created by lizhifeng on 2017/10/26 0026.
 */

public class TestActivityPresenter extends BasePresenter<TestActivity> {
    private TestActivity testActivityView;

    public TestActivityPresenter(TestActivity testActivityView) {
        this.testActivityView = testActivityView;
    }

    public void login(String name, String password) {
        if (isViewAttached()) {
            ModelProvider.getInstance().doLogin(name, password).subscribe(new CustomSubscriber<UserBean>(testActivityView) {
                @Override
                public void onSuccess(UserBean userBean) {
                    testActivityView.showUserInfo(userBean);
                    Log.e("lzf_presenter", "onSuccess");
                }

                @Override
                public void onCompleted() {
                    super.onCompleted();
                    Log.e("lzf_presenter", "onCompleted");
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                }
            });
        }
    }
}
