package kx;

import com.talabat.userandlocation.otp.data.impl.RequestOtpRepositoryImpl;
import com.talabat.userandlocation.otp.data.remote.dto.RequestOtpDto;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {
    public final Object apply(Object obj) {
        return RequestOtpRepositoryImpl.m5935requestOtp$lambda1((RequestOtpDto) obj);
    }
}
