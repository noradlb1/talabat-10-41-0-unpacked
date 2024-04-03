package com.huawei.location.lite.common.http.interceptor;

import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.http.adapter.InterceptorAdapter;
import com.huawei.location.lite.common.http.adapter.ResponseAdapter;
import com.huawei.location.lite.common.http.exception.AuthException;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.sign.SignRequest;
import com.huawei.location.lite.common.http.sign.ucs.UCSSignHelper;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.wisesecurity.ucs.common.exception.UcsCryptoException;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import java.io.IOException;

public class UcsAuthInterceptor extends BaseAuthInterceptor {
    private static final int MAX_SIGN_RETRY_COUNT = 3;
    private static final int REAPPLY_THE_CREDENTIAL = 1020;
    private static final String TAG = "UcsAuthInterceptor";
    private int requestTimes = 0;

    private boolean reTrySign(long j11) {
        if (j11 != 1020) {
            return false;
        }
        int i11 = this.requestTimes + 1;
        this.requestTimes = i11;
        if (i11 > 3) {
            return false;
        }
        UCSSignHelper.getInstance().reApplyCredential();
        return true;
    }

    public ResponseAdapter intercept(InterceptorAdapter.Chain chain) throws IOException, OnFailureException, OnErrorException {
        return chain.proceed(a(chain.request()));
    }

    public BaseRequest sign(BaseRequest baseRequest, SignRequest signRequest) throws IOException {
        try {
            String sign = UCSSignHelper.getInstance().sign(ContextUtil.getContext(), signRequest);
            LogConsole.d(TAG, "X_REQUEST_ID:" + baseRequest.getHeads().get("X-Request-ID"));
            LogConsole.d(TAG, "auth:" + sign);
            return baseRequest.newBuilder().addHeader("authorization", sign).build();
        } catch (UcsException e11) {
            LogConsole.e(TAG, "UcsException:errorCode:" + e11.getErrorCode() + ",message:" + e11.getMessage());
            if (reTrySign(e11.getErrorCode())) {
                return sign(baseRequest, signRequest);
            }
            LogConsole.e(TAG, "AuthException:41");
            throw new AuthException(ErrorCode.valueOf(41));
        } catch (UcsCryptoException e12) {
            LogConsole.e(TAG, "UcsCryptoException:" + e12.getMessage());
            if (reTrySign(e12.getErrorCode())) {
                return sign(baseRequest, signRequest);
            }
            LogConsole.e(TAG, "AuthException:41");
            throw new AuthException(ErrorCode.valueOf(41));
        }
    }
}
