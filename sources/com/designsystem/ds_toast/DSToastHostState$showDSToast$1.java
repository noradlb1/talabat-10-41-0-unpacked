package com.designsystem.ds_toast;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.designsystem.ds_toast.DSToastHostState", f = "DSToastHostState.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {264, 267}, m = "showDSToast", n = {"this", "model", "$this$withLock_u24default$iv", "this", "model", "$this$withLock_u24default$iv", "$completion$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
public final class DSToastHostState$showDSToast$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f33178h;

    /* renamed from: i  reason: collision with root package name */
    public Object f33179i;

    /* renamed from: j  reason: collision with root package name */
    public Object f33180j;

    /* renamed from: k  reason: collision with root package name */
    public Object f33181k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f33182l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ DSToastHostState f33183m;

    /* renamed from: n  reason: collision with root package name */
    public int f33184n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSToastHostState$showDSToast$1(DSToastHostState dSToastHostState, Continuation<? super DSToastHostState$showDSToast$1> continuation) {
        super(continuation);
        this.f33183m = dSToastHostState;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f33182l = obj;
        this.f33184n |= Integer.MIN_VALUE;
        return this.f33183m.showDSToast((DSToastModel) null, this);
    }
}
