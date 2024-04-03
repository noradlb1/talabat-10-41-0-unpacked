package com.talabat.userandlocation.appinfo.data.impl;

import com.talabat.domain.address.Address;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/talabat/domain/address/Address;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.appinfo.data.impl.AppInfoRepositoryImpl$fetchAddressesAsync$1", f = "AppInfoRepositoryImpl.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
public final class AppInfoRepositoryImpl$fetchAddressesAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Address>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12179h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AppInfoRepositoryImpl f12180i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12181j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoRepositoryImpl$fetchAddressesAsync$1(AppInfoRepositoryImpl appInfoRepositoryImpl, int i11, Continuation<? super AppInfoRepositoryImpl$fetchAddressesAsync$1> continuation) {
        super(2, continuation);
        this.f12180i = appInfoRepositoryImpl;
        this.f12181j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AppInfoRepositoryImpl$fetchAddressesAsync$1(this.f12180i, this.f12181j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<Address>> continuation) {
        return ((AppInfoRepositoryImpl$fetchAddressesAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12179h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            AppInfoRepositoryImpl appInfoRepositoryImpl = this.f12180i;
            int i12 = this.f12181j;
            this.f12179h = 1;
            obj = appInfoRepositoryImpl.getAddressesFromMicroService(i12, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
