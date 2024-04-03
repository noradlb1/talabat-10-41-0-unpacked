package com.talabat.feature.subscriptions.domain.wrapper;

import com.talabat.feature.subscriptions.domain.model.CountryParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper", f = "ProCentralizationStatusWrapper.kt", i = {0}, l = {19}, m = "single", n = {"$this$single_u24lambda_u2d1"}, s = {"L$0"})
public final class ProCentralizationStatusWrapper$single$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59006h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59007i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ProCentralizationStatusWrapper f59008j;

    /* renamed from: k  reason: collision with root package name */
    public int f59009k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProCentralizationStatusWrapper$single$1(ProCentralizationStatusWrapper proCentralizationStatusWrapper, Continuation<? super ProCentralizationStatusWrapper$single$1> continuation) {
        super(continuation);
        this.f59008j = proCentralizationStatusWrapper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59007i = obj;
        this.f59009k |= Integer.MIN_VALUE;
        return this.f59008j.single((CountryParams) null, this);
    }
}
