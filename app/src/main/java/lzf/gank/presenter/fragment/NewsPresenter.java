package lzf.gank.presenter.fragment;

import android.util.Log;

import lzf.common.base.BaseUIFlow;
import lzf.common.bean.UserBean;
import lzf.common.mvp.BasePresenter;
import lzf.common.mvp.BaseView;
import lzf.common.network.CustomSubscriber;
import lzf.gank.model.LoginModel;
import lzf.gank.view.fragment.NewsLoginView;

/**
 *
 * @author lizhifeng
 * @date 2017/10/24 0024
 */

public class NewsPresenter extends BasePresenter<NewsLoginView> {
    private NewsLoginView newsLoginView;
    private LoginModel loginModel;
    public NewsPresenter(NewsLoginView baseView) {
        this.newsLoginView = baseView;
        loginModel=new LoginModel();
    }

    public void login(String name,String password){
        if (isViewAttached()) {
            loginModel.doLogin(name,password).subscribe(new CustomSubscriber<UserBean>(newsLoginView) {
                @Override
                public void onSuccess(UserBean userBean) {
                    newsLoginView.showUserInfo(userBean);
                    Log.e("lzf_presenter","onSuccess");
                }

                @Override
                public void onCompleted() {
                    super.onCompleted();
                    Log.e("lzf_presenter","onCompleted");
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                }
            });
        }
    }
}
