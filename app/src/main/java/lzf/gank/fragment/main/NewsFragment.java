package lzf.gank.fragment.main;

import android.graphics.Matrix;
import android.os.Looper;
import android.support.annotation.IntRange;
import android.support.annotation.RequiresPermission;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.TabLayout;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lzf.common.base.BaseFragment;
import lzf.common.dialog.AlertDialogFragment;
import lzf.common.network.APIService;
import lzf.common.network.CustomSubscriber;
import lzf.common.network.RetrofitProxy;
import lzf.common.network.SingleRetrofit;
import lzf.common.network.bean.UserBean;
import lzf.gank.R;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public class NewsFragment extends BaseFragment {
//    @BindView(R.id.tab_gank)
//    TabLayout tab_gank;
//    @BindView(R.id.viewPager_gank)
//    ViewPager viewPager;
//    @BindView(R.id.text)
//    TextView textView;
//    @BindView(R.id.parent)
//    RelativeLayout relativeLayout;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    public void initListener() {

    }

    @OnClick(R.id.button)
    @UiThread
    public void test(View view){
//        TransitionManager.beginDelayedTransition(relativeLayout,new AutoTransition());
//        if (textView.getVisibility()!=View.VISIBLE){
//            textView.setVisibility(View.VISIBLE);
//        }else {
//            textView.setVisibility(View.GONE);
//        }
//        Toast.makeText()
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Looper.prepare();
////                Toast.makeText(getContext(),"123",Toast.LENGTH_SHORT).show();
//                Toast toast=new Toast(getContext());
//                View v=LayoutInflater.from(getContext()).inflate(R.layout.fragment_gank,null,false);
//                TextView textView= (TextView) v.findViewById(R.id.text);
//                textView.setText("测试Toast");
//                toast.setView(v);
//                toast.setDuration(Toast.LENGTH_SHORT);
//                toast.show();
//                Looper.loop();
//            }
//        }).start();

        FragmentTransaction mFragTransaction = getFragmentManager().beginTransaction();
        Fragment fragment =  getFragmentManager().findFragmentByTag("dialogFragment");
        if(fragment!=null){
            //为了不重复显示dialog，在显示对话框之前移除正在显示的对话框
            mFragTransaction.remove(fragment);
        }
        AlertDialogFragment dialogFragment =new AlertDialogFragment();
        mFragTransaction.add(dialogFragment,"dialogFragment").commit();
    }
    @Override
    public void loadData() {
        /*
        * Subscription
        * */
        RetrofitProxy
                .getData(apiService.doLogin("15824857592","123456"))
                .subscribe(new CustomSubscriber<UserBean>() {
                    @Override
                    public void onSuccess(UserBean userBean) {
                        Log.e("lzf_success",userBean.toString());
                    }
                });
        /*
        * Observable
        * */
        RetrofitProxy.getData(
                apiService.doLogin("15824857595", "888888"),
                new CustomSubscriber<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {

            }
        });

        SingleRetrofit.getData(apiService.doLogin("","")).subscribe(new CustomSubscriber<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {

            }
        });
    }

    @Override
    public void initVariable(View view) {
        ButterKnife.bind(this,view);
    }
}
