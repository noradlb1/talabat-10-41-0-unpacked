package com.talabat.splash.core.extension;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.talabat.splash.core.exception.Failure;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uu.a;
import uu.b;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010\t\u001aG\u0010\n\u001a\u00020\u0001\"\b\b\u0000\u0010\u000b*\u00020\f\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u000b0\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010\t\u001aG\u0010\r\u001a\u00020\u0001\"\b\b\u0000\u0010\u000b*\u00020\f\"\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u000b0\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u000b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010\t¨\u0006\u000e"}, d2 = {"failure", "", "L", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/splash/core/exception/Failure;", "Landroidx/lifecycle/LifecycleOwner;", "liveData", "body", "Lkotlin/Function1;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function1;)V", "observe", "T", "", "observeAndRemove", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LifeCycleKt {
    public static final <L extends LiveData<Failure>> void failure(@NotNull LifecycleOwner lifecycleOwner, @NotNull L l11, @NotNull Function1<? super Failure, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(l11, "liveData");
        Intrinsics.checkNotNullParameter(function1, "body");
        l11.observe(lifecycleOwner, new b(function1));
    }

    /* access modifiers changed from: private */
    /* renamed from: failure$lambda-1  reason: not valid java name */
    public static final void m10907failure$lambda1(Function1 function1, Failure failure) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(failure);
    }

    public static final <T, L extends LiveData<T>> void observe(@NotNull LifecycleOwner lifecycleOwner, @NotNull L l11, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(l11, "liveData");
        Intrinsics.checkNotNullParameter(function1, "body");
        l11.observe(lifecycleOwner, new a(function1));
    }

    /* access modifiers changed from: private */
    /* renamed from: observe$lambda-0  reason: not valid java name */
    public static final void m10908observe$lambda0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final <T, L extends LiveData<T>> void observeAndRemove(@NotNull LifecycleOwner lifecycleOwner, @NotNull L l11, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(l11, "liveData");
        Intrinsics.checkNotNullParameter(function1, "body");
        l11.observe(lifecycleOwner, new LifeCycleKt$observeAndRemove$1(l11, function1));
    }
}
