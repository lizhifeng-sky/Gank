package lzf.common.image;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public class GlideImageLoader {
    private static RequestManager requestManager;
    public static RequestManager with(Context context) {
        requestManager=Glide.with(context);
        return requestManager;
    }

    public static RequestManager with(Activity context) {
        return Glide.with(context);
    }

    public static RequestManager with(Fragment context) {
        return Glide.with(context);
    }


    public static DrawableTypeRequest<String> load(String url){
       return requestManager.load(url);
    }
}
