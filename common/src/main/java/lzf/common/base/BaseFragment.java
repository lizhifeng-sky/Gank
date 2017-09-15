package lzf.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public abstract class BaseFragment extends Fragment implements BaseView{
    private boolean isFirstComing=false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(getLayoutId(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isFirstComing) {
            isFirstComing=false;
            loadData();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void hideLoading() {

    }
}
