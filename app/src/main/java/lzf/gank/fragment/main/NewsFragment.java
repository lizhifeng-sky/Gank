package lzf.gank.fragment.main;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzf.common.base.BaseFragment;
import lzf.common.bean.UserBean;
import lzf.common.mvp.BasePresenter;
import lzf.gank.R;
import lzf.gank.presenter.fragment.NewsPresenter;
import lzf.gank.view.fragment.NewsLoginView;

/**
 *
 * @author Administrator
 * @date 2017/9/15 0015
 */
public class NewsFragment extends BaseFragment implements NewsLoginView{
    @BindView(R.id.text)
    TextView textView;
    @BindView(R.id.button)
    TextView button;
    @BindView(R.id.parent)
    RelativeLayout relativeLayout;
    private NewsPresenter newsPresenter;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    public void initVariable() {
        ButterKnife.bind(this,getFragmentContentView());
        newsPresenter=new NewsPresenter(this);
        newsPresenter.attachView(this);
    }

    @Override
    public void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login("15824857592","888888");
            }
        });
    }

    @Override
    public void login(String name, String password) {
        newsPresenter.login(name,password);
    }

    @Override
    public void showUserInfo(UserBean userBean) {
        textView.setText(userBean.toString());
    }

    @Override
    public void onDetach() {
        newsPresenter.detachView();
        super.onDetach();
    }

}
