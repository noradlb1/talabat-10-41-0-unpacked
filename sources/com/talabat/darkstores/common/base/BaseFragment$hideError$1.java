package com.talabat.darkstores.common.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class BaseFragment$hideError$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public BaseFragment$hideError$1(Object obj) {
        super(0, obj, BaseFragment.class, "onRetryClicked", "onRetryClicked()V", 0);
    }

    public final void invoke() {
        ((BaseFragment) this.receiver).onRetryClicked();
    }
}
