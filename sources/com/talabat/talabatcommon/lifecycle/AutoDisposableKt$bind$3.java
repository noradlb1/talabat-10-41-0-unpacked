package com.talabat.talabatcommon.lifecycle;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.talabat.talabatcommon.extentions.ThrowablesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "VM", "Landroidx/lifecycle/ViewModel;", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 176)
public final class AutoDisposableKt$bind$3 extends Lambda implements Function1<View, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f61759g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<VM, Unit> f61760h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoDisposableKt$bind$3(AutoDisposable autoDisposable, Function1<? super VM, Unit> function1) {
        super(1);
        this.f61759g = autoDisposable;
        this.f61760h = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withLayout");
        AutoDisposable autoDisposable = this.f61759g;
        Function1<VM, Unit> function1 = this.f61760h;
        if (autoDisposable instanceof View) {
            Intrinsics.needClassReification();
            AutoDisposableKt.autoDisposeView(autoDisposable, new AutoDisposableKt$bind$3$invoke$$inlined$withViewModel$1(autoDisposable, function1));
        } else if (autoDisposable instanceof AppCompatActivity) {
            Intrinsics.needClassReification();
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new AutoDisposableKt$bind$3$invoke$$inlined$withViewModel$2(autoDisposable, function1));
        } else if (autoDisposable instanceof Fragment) {
            Intrinsics.needClassReification();
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new AutoDisposableKt$bind$3$invoke$$inlined$withViewModel$3(autoDisposable, function1));
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(autoDisposable + " must be a View, AppCompatActivity, or a Fragment"));
        }
    }
}
