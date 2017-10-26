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

public class ModelProvider extends BaseModel{
    private static ModelProvider modelProvider =new ModelProvider();
    public static ModelProvider getInstance(){
        if (modelProvider ==null){
            synchronized (ModelProvider.class){
                if (modelProvider ==null){
                    modelProvider =new ModelProvider();
                }
            }
        }
        return modelProvider;
    }

    public Observable<BaseRequestMode<UserBean>> doLogin(@Field("mobile") String email, @Field("password") String pwd) {
        return apiService.doLogin(email,pwd).compose(new ScheduleTransformer<UserBean>());
    }
}
