package lzf.common.base;

import lzf.common.network.APIService;
import lzf.common.network.SingleRetrofit;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public interface BaseView {
    APIService apiService = SingleRetrofit.create("");

    int getLayoutId();

    void initVariable();

    void initListener();

    void loadData();

    void showLoading();

    void onError(Throwable throwable);

    void hideLoading();
}
