package lzf.gank.model;

import java.util.List;
import java.util.Map;

import lzf.common.bean.BaseRequestMode;
import lzf.common.bean.CityBean;
import lzf.common.bean.ConfigBean;
import lzf.common.bean.GuideBean;
import lzf.common.bean.UserBean;
import lzf.common.mvp.BaseModel;
import lzf.common.network.APIService;
import lzf.common.network.ScheduleTransformer;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 *
 * @author lizhifeng
 * @date 2017/10/23 0023
 */

public class LoginModel extends BaseModel implements APIService{
    @Override
    public Observable<BaseRequestMode<UserBean>> getUser(@Path("username") String username) {
        return null;
    }

    @Override
    public Observable<BaseRequestMode<UserBean>> doLogin(@Field("mobile") String email, @Field("password") String pwd) {
        return apiService.doLogin(email,pwd).compose(new ScheduleTransformer<UserBean>());
    }

    @Override
    public Observable<UserBean> getPost() {
        return null;
    }

    @Override
    public Observable<BaseRequestMode<List<GuideBean>>> getStartView(@Field("appType") int type) {
        return null;
    }

    @Override
    public Observable<BaseRequestMode<List<GuideBean>>> getStartView(@Field("appType") int type, int s) {
        return null;
    }

    @Override
    public Observable<BaseRequestMode<List<CityBean>>> getCityInfo() {
        return null;
    }

    @Override
    public Observable<BaseRequestMode<ConfigBean>> getConfig() {
        return null;
    }

    @Override
    public Observable<BaseRequestMode<List<GuideBean>>> getStartView2(@Field("appType") int type) {
        return null;
    }

    @Override
    public Observable<UserBean> getPost(@FieldMap Map<String, String> params) {
        return null;
    }

    @Override
    public Observable<UserBean> getGet() {
        return null;
    }

    @Override
    public Observable<UserBean> getGet(@Query("time") long time) {
        return null;
    }

    @Override
    public Observable<UserBean> getGet(@QueryMap Map<String, String> params) {
        return null;
    }
}
