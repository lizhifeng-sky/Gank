package lzf.gank.view.fragment;

import lzf.common.bean.UserBean;
import lzf.common.mvp.BaseView;

/**
 * Created by lizhifeng on 2017/10/24 0024.
 */

public interface NewsLoginView extends BaseView{
    void login(String name,String password);
    void showUserInfo(UserBean userBean);
}
