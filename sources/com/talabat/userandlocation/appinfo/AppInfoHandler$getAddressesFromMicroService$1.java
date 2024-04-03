package com.talabat.userandlocation.appinfo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.appinfo.AppInfoHandler", f = "AppInfoHandler.kt", i = {}, l = {73}, m = "getAddressesFromMicroService", n = {}, s = {})
public final class AppInfoHandler$getAddressesFromMicroService$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f12165h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AppInfoHandler f12166i;

    /* renamed from: j  reason: collision with root package name */
    public int f12167j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoHandler$getAddressesFromMicroService$1(AppInfoHandler appInfoHandler, Continuation<? super AppInfoHandler$getAddressesFromMicroService$1> continuation) {
        super(continuation);
        this.f12166i = appInfoHandler;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12165h = obj;
        this.f12167j |= Integer.MIN_VALUE;
        return this.f12166i.getAddressesFromMicroService(0, this);
    }
}
