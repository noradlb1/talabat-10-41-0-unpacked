package com.talabat.talabatcommon.lifecycle;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AutoDisposableKt$bind$2 extends Lambda implements Function1<AppCompatActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f61756g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f61757h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoDisposableKt$bind$2(AutoDisposable autoDisposable, Function0<Unit> function0) {
        super(1);
        this.f61756g = autoDisposable;
        this.f61757h = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$withLayout");
        AutoDisposable autoDisposable = this.f61756g;
        final Function0<Unit> function0 = this.f61757h;
        AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
            public final void invoke() {
                function0.invoke();
            }
        });
    }
}
