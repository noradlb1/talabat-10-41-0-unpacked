package com.talabat.gem.samples;

import android.widget.TextView;
import com.talabat.gem.adapters.R;
import com.talabat.talabatcommon.extension.ViewKt;
import gateways.PreferencesInterceptors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lgateways/PreferencesInterceptors;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleGemActivityKt$drawSandboxResponseSection$sandboxResponse$2 extends Lambda implements Function1<PreferencesInterceptors<Boolean>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SampleGemActivity f60497g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SampleGemActivityKt$drawSandboxResponseSection$sandboxResponse$2(SampleGemActivity sampleGemActivity) {
        super(1);
        this.f60497g = sampleGemActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PreferencesInterceptors<Boolean>) (PreferencesInterceptors) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PreferencesInterceptors<Boolean> preferencesInterceptors) {
        Intrinsics.checkNotNullParameter(preferencesInterceptors, "$this$preferences");
        PreferencesInterceptors<Boolean> on2 = preferencesInterceptors.getOn();
        final SampleGemActivity sampleGemActivity = this.f60497g;
        on2.initialized(new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Boolean bool) {
                TextView textView = (TextView) sampleGemActivity._$_findCachedViewById(R.id.sandboxResponseText);
                Intrinsics.checkNotNullExpressionValue(textView, "sandboxResponseText");
                ViewKt.plusAssign(textView, bool != null ? bool.toString() : null);
            }
        });
        PreferencesInterceptors<Boolean> on3 = preferencesInterceptors.getOn();
        final SampleGemActivity sampleGemActivity2 = this.f60497g;
        on3.saved(new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Boolean bool) {
                TextView textView = (TextView) sampleGemActivity2._$_findCachedViewById(R.id.sandboxResponseText);
                Intrinsics.checkNotNullExpressionValue(textView, "sandboxResponseText");
                ViewKt.plusAssign(textView, bool != null ? bool.toString() : null);
            }
        });
    }
}
