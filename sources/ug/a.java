package ug;

import com.talabat.core.fwf.data.sdkwrapper.FunWithFlagsSdkWrapperImpl;
import fwfd.com.fwfsdk.model.api.FWFSubscribeResult;
import fwfd.com.fwfsdk.util.FWFSubscribeObserverCallback;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements FWFSubscribeObserverCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f57867a;

    public /* synthetic */ a(Function1 function1) {
        this.f57867a = function1;
    }

    public final void onFwfResponse(FWFSubscribeResult fWFSubscribeResult) {
        FunWithFlagsSdkWrapperImpl.m9592subscribeObserver$lambda0(this.f57867a, fWFSubscribeResult);
    }
}
