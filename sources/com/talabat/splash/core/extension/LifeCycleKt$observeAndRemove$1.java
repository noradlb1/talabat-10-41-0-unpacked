package com.talabat.splash.core.extension;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"com/talabat/splash/core/extension/LifeCycleKt$observeAndRemove$1", "Landroidx/lifecycle/Observer;", "onChanged", "", "t", "(Ljava/lang/Object;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifeCycleKt$observeAndRemove$1 implements Observer<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ L f61422a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Unit> f61423b;

    public LifeCycleKt$observeAndRemove$1(L l11, Function1<? super T, Unit> function1) {
        this.f61422a = l11;
        this.f61423b = function1;
    }

    public void onChanged(@NotNull T t11) {
        Intrinsics.checkNotNullParameter(t11, "t");
        this.f61422a.removeObserver(this);
        this.f61423b.invoke(t11);
    }
}
