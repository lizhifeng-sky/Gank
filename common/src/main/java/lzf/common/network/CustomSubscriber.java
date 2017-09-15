package lzf.common.network;


import lzf.common.base.BaseView;
import lzf.common.network.bean.BaseRequestMode;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public abstract class CustomSubscriber<T> extends Subscriber<BaseRequestMode<T>> {

    private BaseView baseView;

    /**
     * @param baseView activity 存在就显示 加载动画
     * @author lzf
     * create at 2017/8/25 0025 10:00
     * description
     */
    public CustomSubscriber(BaseView baseView) {
        this.baseView = baseView;
    }

    /**
     * @author lzf
     * create at 2017/8/25 0025 10:00
     * description 不显示加载动画
     */
    public CustomSubscriber() {
    }

    @Override
    public void onStart() {
        super.onStart();
        if (baseView != null) {
            baseView.showLoading();
        }
    }

    @Override
    public void onCompleted() {
        if (baseView != null) {
            baseView.hideLoading();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (baseView != null) {
            baseView.hideLoading();
            baseView.onError(e);
        }
    }

    /*
    * final修饰方法
    * */
    @Override
    final public void onNext(BaseRequestMode<T> tBaseRequestMode) {
        if (tBaseRequestMode.getError() == 200 || tBaseRequestMode.getError() == 419) {
            onSuccess(tBaseRequestMode.getData());
        } else {
            if (tBaseRequestMode.getMsg() != null) {
                Exception exception = new Exception(tBaseRequestMode.getMsg());
                onError(exception);
            } else {
                Exception exception = new Exception("未知错误");
                onError(exception);
            }
        }
    }

    public abstract void onSuccess(T t);

}
