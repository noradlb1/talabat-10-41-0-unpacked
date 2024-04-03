package com.adtechsdk.dh_adtech_sdk_flutter.viewability.data;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.adtechsdk.dh_adtech_sdk_flutter.viewability.data.OmJsSdkDataSource$loadOmidJsSdk$2", f = "OmJsSdkDataSource.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
public final class OmJsSdkDataSource$loadOmidJsSdk$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f40027h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OmJsSdkDataSource f40028i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Context f40029j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OmJsSdkDataSource$loadOmidJsSdk$2(OmJsSdkDataSource omJsSdkDataSource, Context context, Continuation<? super OmJsSdkDataSource$loadOmidJsSdk$2> continuation) {
        super(2, continuation);
        this.f40028i = omJsSdkDataSource;
        this.f40029j = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OmJsSdkDataSource$loadOmidJsSdk$2(this.f40028i, this.f40029j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((OmJsSdkDataSource$loadOmidJsSdk$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f40027h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Semaphore access$getSemaphore$p = this.f40028i.semaphore;
            this.f40027h = 1;
            if (access$getSemaphore$p.acquire(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String access$getOmidJsSdk$p = this.f40028i.omidJsSdk;
        if (access$getOmidJsSdk$p == null) {
            try {
                access$getOmidJsSdk$p = this.f40028i.loadOmidSdkFromFile(this.f40029j);
            } finally {
                this.f40028i.semaphore.release();
            }
        }
        return access$getOmidJsSdk$p;
    }
}
