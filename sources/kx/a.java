package kx;

import com.talabat.userandlocation.otp.data.impl.RequestOtpRepositoryImpl;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RequestOtpRepositoryImpl f23906b;

    public /* synthetic */ a(RequestOtpRepositoryImpl requestOtpRepositoryImpl) {
        this.f23906b = requestOtpRepositoryImpl;
    }

    public final void accept(Object obj) {
        RequestOtpRepositoryImpl.m5934requestOtp$lambda0(this.f23906b, (Throwable) obj);
    }
}
