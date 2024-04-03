package com.talabat.core.fwf.data;

import com.talabat.core.fwf.data.observability.FunWithFlagsObservability;
import fwfd.com.fwfsdk.model.api.FWFSubscribeResult;
import fwfd.com.fwfsdk.model.db.FWFResult;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "Lfwfd/com/fwfsdk/model/api/FWFSubscribeResult;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FunWithFlags$observe$1$1 extends Lambda implements Function1<FWFSubscribeResult, Unit> {
    public static final FunWithFlags$observe$1$1 INSTANCE = new FunWithFlags$observe$1$1();

    public FunWithFlags$observe$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FWFSubscribeResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FWFSubscribeResult fWFSubscribeResult) {
        Intrinsics.checkNotNullParameter(fWFSubscribeResult, "result");
        for (Map.Entry entry : fWFSubscribeResult.getFlags().entrySet()) {
            Map access$getCache$p = FunWithFlags.cache;
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "flag.key");
            Object value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "flag.value");
            access$getCache$p.put(key, value);
        }
        Set<Map.Entry<String, FWFResult>> entrySet = fWFSubscribeResult.getFlags().entrySet();
        boolean z11 = true;
        if (entrySet.size() <= 1) {
            z11 = false;
        }
        Set<Map.Entry<String, FWFResult>> set = null;
        if (!z11) {
            entrySet = null;
        }
        if (entrySet != null) {
            FunWithFlagsObservability funWithFlagsObservability$com_talabat_core_fwf_data_data = FunWithFlags.INSTANCE.getFunWithFlagsObservability$com_talabat_core_fwf_data_data();
            List access$getFlagsNames$p = FunWithFlags.flagsNames;
            if (access$getFlagsNames$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flagsNames");
                access$getFlagsNames$p = null;
            }
            funWithFlagsObservability$com_talabat_core_fwf_data_data.observeCacheFill(CollectionsKt___CollectionsKt.toSet(access$getFlagsNames$p), FunWithFlags.cache.keySet());
        }
        Set<Map.Entry<String, FWFResult>> entrySet2 = fWFSubscribeResult.getFlags().entrySet();
        if (entrySet2.isEmpty()) {
            set = entrySet2;
        }
        if (set != null) {
            FunWithFlags.INSTANCE.getFunWithFlagsObservability$com_talabat_core_fwf_data_data().observeEmptyResponseError();
        }
    }
}
