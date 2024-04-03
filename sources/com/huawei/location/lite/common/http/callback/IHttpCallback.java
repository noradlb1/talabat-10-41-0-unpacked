package com.huawei.location.lite.common.http.callback;

import androidx.annotation.NonNull;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.response.BaseResponse;

public interface IHttpCallback<T extends BaseResponse> {
    void onError(@NonNull OnErrorException onErrorException);

    void onFailure(@NonNull OnFailureException onFailureException);

    void onSuccess(@NonNull T t11);
}
