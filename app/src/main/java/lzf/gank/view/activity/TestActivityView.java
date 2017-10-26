package lzf.gank.view.activity;

import lzf.common.bean.UserBean;
import lzf.common.mvp.BaseView;

/**
 * Created by lizhifeng on 2017/10/26 0026.
 */

public interface TestActivityView extends BaseView {
    void login(String name,String password);
    void showUserInfo(UserBean userBean);
}
