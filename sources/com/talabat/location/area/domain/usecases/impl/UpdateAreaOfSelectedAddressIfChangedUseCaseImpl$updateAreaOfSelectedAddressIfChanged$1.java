package com.talabat.location.area.domain.usecases.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.location.area.domain.usecases.impl.UpdateAreaOfSelectedAddressIfChangedUseCaseImpl", f = "UpdateAreaOfSelectedAddressIfChangedUseCaseImpl.kt", i = {0, 0, 1, 1}, l = {68, 85}, m = "updateAreaOfSelectedAddressIfChanged", n = {"this", "selectedSelectedAddress", "this", "selectedSelectedAddress"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAreaOfSelectedAddressIfChanged$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61034h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61035i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f61036j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ UpdateAreaOfSelectedAddressIfChangedUseCaseImpl f61037k;

    /* renamed from: l  reason: collision with root package name */
    public int f61038l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAreaOfSelectedAddressIfChanged$1(UpdateAreaOfSelectedAddressIfChangedUseCaseImpl updateAreaOfSelectedAddressIfChangedUseCaseImpl, Continuation<? super UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAreaOfSelectedAddressIfChanged$1> continuation) {
        super(continuation);
        this.f61037k = updateAreaOfSelectedAddressIfChangedUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61036j = obj;
        this.f61038l |= Integer.MIN_VALUE;
        return this.f61037k.updateAreaOfSelectedAddressIfChanged(this);
    }
}
