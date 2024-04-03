package com.talabat.fluttercore.engine;

import android.content.Context;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.fluttercore.channels.ObservabilityMethodChannelCallback;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0011H\u0016J$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0011H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/talabat/fluttercore/engine/ObservabilityMethodChannelCallbackImpl;", "Lcom/talabat/fluttercore/channels/ObservabilityMethodChannelCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "talabatObservability", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getTalabatObservability", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "talabatObservability$delegate", "Lkotlin/Lazy;", "observe", "", "eventName", "", "featureName", "attributes", "", "trackUnexpectedScenario", "explanation", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObservabilityMethodChannelCallbackImpl implements ObservabilityMethodChannelCallback {
    @NotNull
    private final Lazy talabatObservability$delegate;

    public ObservabilityMethodChannelCallbackImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.talabatObservability$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new ObservabilityMethodChannelCallbackImpl$talabatObservability$2(context));
    }

    private final IObservabilityManager getTalabatObservability() {
        return (IObservabilityManager) this.talabatObservability$delegate.getValue();
    }

    public void observe(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        getTalabatObservability().track(str, str2, map);
    }

    public void trackUnexpectedScenario(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "explanation");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        getTalabatObservability().trackUnExpectedScenario(str, map);
    }
}
