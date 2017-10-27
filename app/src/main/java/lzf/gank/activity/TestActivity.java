package lzf.gank.activity;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzf.common.base.BaseActivity;
import lzf.common.bean.UserBean;
import lzf.gank.R;
import lzf.gank.presenter.activity.TestActivityPresenter;
import lzf.gank.view.activity.TestActivityView;

/**
 * 不用接口 简单代理 实际和mvp没什么区别 类大幅度减少
 *
 * @author Administrator*/
public class TestActivity extends BaseActivity{
    @BindView(R.id.login)
    TextView login;
    private TestActivityPresenter testActivityPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initVariable() {
        super.initVariable();
        ButterKnife.bind(this);
        testActivityPresenter=new TestActivityPresenter(this);
        testActivityPresenter.attachView(this);
    }


    @OnClick(R.id.login)
    public void onViewClicked() {
        login("15824857592","888888");
    }

    public void login(String name, String password) {
        testActivityPresenter.login(name,password);
    }

    public void showUserInfo(UserBean userBean) {
        login.setText(userBean.toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
        testActivityPresenter.detachView();
    }
}
