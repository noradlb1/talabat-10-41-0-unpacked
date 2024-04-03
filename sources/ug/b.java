package ug;

import com.talabat.core.fwf.data.sdkwrapper.FunWithFlagsSdkWrapperImpl;
import fwfd.com.fwfsdk.manager.callback.FWFFeatureCallback;
import fwfd.com.fwfsdk.model.db.FWFResult;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements FWFFeatureCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f57868a;

    public /* synthetic */ b(Function1 function1) {
        this.f57868a = function1;
    }

    public final void onFwfResponse(FWFResult fWFResult) {
        FunWithFlagsSdkWrapperImpl.m9591getVariation$lambda1(this.f57868a, fWFResult);
    }
}
