package com.talabat.gem.samples;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleGemActivityKt$drawSandboxResponseSection$1 extends Lambda implements Function1<View, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ReadWriteProperty<Object, Boolean> f60496g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SampleGemActivityKt$drawSandboxResponseSection$1(ReadWriteProperty<Object, Boolean> readWriteProperty) {
        super(1);
        this.f60496g = readWriteProperty;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$invoke");
        ReadWriteProperty<Object, Boolean> readWriteProperty = this.f60496g;
        Boolean r02 = SampleGemActivityKt.m10587drawSandboxResponseSection$lambda2(readWriteProperty);
        SampleGemActivityKt.m10588drawSandboxResponseSection$lambda3(readWriteProperty, Boolean.valueOf(!(r02 != null ? r02.booleanValue() : false)));
    }
}
