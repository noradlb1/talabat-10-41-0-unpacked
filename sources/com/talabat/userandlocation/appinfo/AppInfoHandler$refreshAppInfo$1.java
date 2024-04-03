package com.talabat.userandlocation.appinfo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.appinfo.AppInfoHandler", f = "AppInfoHandler.kt", i = {0, 0, 0, 1, 1}, l = {43, 51}, m = "refreshAppInfo", n = {"this", "$this$refreshAppInfo_u24lambda_u2d1", "countryId", "this", "appInfoApiExecution"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1"})
public final class AppInfoHandler$refreshAppInfo$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12168h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12169i;

    /* renamed from: j  reason: collision with root package name */
    public int f12170j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f12171k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ AppInfoHandler f12172l;

    /* renamed from: m  reason: collision with root package name */
    public int f12173m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoHandler$refreshAppInfo$1(AppInfoHandler appInfoHandler, Continuation<? super AppInfoHandler$refreshAppInfo$1> continuation) {
        super(continuation);
        this.f12172l = appInfoHandler;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12171k = obj;
        this.f12173m |= Integer.MIN_VALUE;
        return this.f12172l.refreshAppInfo(0, this);
    }
}
