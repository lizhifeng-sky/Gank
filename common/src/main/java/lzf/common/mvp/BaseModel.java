package lzf.common.mvp;

import lzf.common.network.APIService;
import lzf.common.network.SingleRetrofit;

/**
 * Created by lizhifeng on 2017/10/23 0023.
 */

public abstract class BaseModel {
   public APIService apiService = SingleRetrofit.create("http://new.antwk.com/api/");
}
