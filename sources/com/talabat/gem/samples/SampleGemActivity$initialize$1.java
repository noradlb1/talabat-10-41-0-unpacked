package com.talabat.gem.samples;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.talabat.gem.adapters.R;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleGemActivity$initialize$1 extends Lambda implements Function1<AppCompatActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SampleGemActivity f60493g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SampleGemActivity$initialize$1(SampleGemActivity sampleGemActivity) {
        super(1);
        this.f60493g = sampleGemActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$withLayout");
        SampleDataSourcesKt.updateDataSources();
        SampleGemActivityKt.drawStartFlowSection(this.f60493g);
        SampleGemActivityKt.drawTiersCountSection(this.f60493g);
        SampleGemActivityKt.drawSandboxResponseSection(this.f60493g);
        Button button = (Button) appCompatActivity.findViewById(R.id.flowButton);
        Intrinsics.checkNotNullExpressionValue(button, "flowButton");
        ViewKt.invoke(button, new Function1<View, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "$this$invoke");
                RouterKt.navigate$default(appCompatActivity, Reflection.getOrCreateKotlinClass(SampleGemHomeActivity.class), 0, 0.0d, 4, (Object) null);
            }
        });
    }
}
