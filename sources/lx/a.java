package lx;

import com.talabat.userandlocation.otp.data.remote.api.GetOtpResponse;
import com.talabat.userandlocation.otp.data.remote.impl.RequestOtpRemoteDataSourceImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return RequestOtpRemoteDataSourceImpl.m5936requestOtp$lambda0((GetOtpResponse) obj);
    }
}
