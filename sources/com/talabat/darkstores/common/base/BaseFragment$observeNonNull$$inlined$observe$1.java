package com.talabat.darkstores.common.base;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BaseFragment$observeNonNull$$inlined$observe$1<T> implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f56102a;

    public BaseFragment$observeNonNull$$inlined$observe$1(Function1 function1) {
        this.f56102a = function1;
    }

    public final void onChanged(T t11) {
        if (t11 != null) {
            this.f56102a.invoke(t11);
        }
    }
}
