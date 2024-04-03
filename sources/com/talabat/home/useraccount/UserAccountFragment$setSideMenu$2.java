package com.talabat.home.useraccount;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class UserAccountFragment$setSideMenu$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public UserAccountFragment$setSideMenu$2(Object obj) {
        super(1, obj, UserAccountFragment.class, "onUpdateRenewalResult", "onUpdateRenewalResult(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z11) {
        ((UserAccountFragment) this.receiver).onUpdateRenewalResult(z11);
    }
}
