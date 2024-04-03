package sg;

import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.fwfprojectskeys.domain.FWFProject;
import fwfd.com.fwfsdk.manager.callback.FWFFeaturesCallback;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class a implements FWFFeaturesCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FWFProject f57397a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function0 f57398b;

    public /* synthetic */ a(FWFProject fWFProject, Function0 function0) {
        this.f57397a = fWFProject;
        this.f57398b = function0;
    }

    public final void onFwfResponse(HashMap hashMap) {
        FunWithFlags.m9589subscribe$lambda15$lambda14(this.f57397a, this.f57398b, hashMap);
    }
}
