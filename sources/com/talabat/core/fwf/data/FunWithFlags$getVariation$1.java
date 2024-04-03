package com.talabat.core.fwf.data;

import com.google.gson.JsonObject;
import com.talabat.core.fwf.data.observability.FunWithFlagsObservability;
import fwfd.com.fwfsdk.model.db.FWFResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "Lfwfd/com/fwfsdk/model/db/FWFResult;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FunWithFlags$getVariation$1 extends Lambda implements Function1<FWFResult, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f55938g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Object, Unit> f55939h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f55940i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunWithFlags$getVariation$1(String str, Function1<Object, Unit> function1, Object obj) {
        super(1);
        this.f55938g = str;
        this.f55939h = function1;
        this.f55940i = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FWFResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FWFResult fWFResult) {
        Object obj;
        Intrinsics.checkNotNullParameter(fWFResult, "result");
        JsonObject explanation = fWFResult.getExplanation();
        if (!explanation.has("error")) {
            explanation = null;
        }
        if (explanation != null) {
            String str = this.f55938g;
            FunWithFlagsObservability funWithFlagsObservability$com_talabat_core_fwf_data_data = FunWithFlags.INSTANCE.getFunWithFlagsObservability$com_talabat_core_fwf_data_data();
            String asString = explanation.get("error").getAsString();
            Intrinsics.checkNotNullExpressionValue(asString, "it[FWF_EXPLANATION_JSON_ERROR_KEY].asString");
            funWithFlagsObservability$com_talabat_core_fwf_data_data.observeFwfSdkError(str, asString);
        }
        FunWithFlags funWithFlags = FunWithFlags.INSTANCE;
        funWithFlags.trackParticipatedExperimentEvent(this.f55938g, fWFResult);
        Function1<Object, Unit> function1 = this.f55939h;
        if (!(fWFResult.variation != null)) {
            fWFResult = null;
        }
        if (fWFResult == null || (obj = funWithFlags.getVariationValue(fWFResult)) == null) {
            obj = this.f55940i;
        }
        function1.invoke(obj);
    }
}
