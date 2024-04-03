package com.talabat.splash.domain.usecase;

import com.talabat.splash.domain.model.AppInfoResponseWrapper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.splash.domain.usecase.GetAppInfoUseCase", f = "GetAppInfoUseCase.kt", i = {0, 0}, l = {100}, m = "handleAppInfoResponseAndGetScreenRedirection", n = {"this", "appInfoResponseWrapper"}, s = {"L$0", "L$1"})
public final class GetAppInfoUseCase$handleAppInfoResponseAndGetScreenRedirection$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61483h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61484i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f61485j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ GetAppInfoUseCase f61486k;

    /* renamed from: l  reason: collision with root package name */
    public int f61487l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetAppInfoUseCase$handleAppInfoResponseAndGetScreenRedirection$1(GetAppInfoUseCase getAppInfoUseCase, Continuation<? super GetAppInfoUseCase$handleAppInfoResponseAndGetScreenRedirection$1> continuation) {
        super(continuation);
        this.f61486k = getAppInfoUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61485j = obj;
        this.f61487l |= Integer.MIN_VALUE;
        return this.f61486k.handleAppInfoResponseAndGetScreenRedirection((AppInfoResponseWrapper) null, this);
    }
}
