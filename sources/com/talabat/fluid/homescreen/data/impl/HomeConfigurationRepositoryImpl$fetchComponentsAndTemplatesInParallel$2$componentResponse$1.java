package com.talabat.fluid.homescreen.data.impl;

import com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse;
import com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$componentResponse$1", f = "HomeConfigurationRepositoryImpl.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
public final class HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$componentResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ContentApiResponse>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59680h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ HomeConfigurationRepositoryImpl f59681i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FluidHomeComponentRequestParams f59682j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$componentResponse$1(HomeConfigurationRepositoryImpl homeConfigurationRepositoryImpl, FluidHomeComponentRequestParams fluidHomeComponentRequestParams, Continuation<? super HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$componentResponse$1> continuation) {
        super(2, continuation);
        this.f59681i = homeConfigurationRepositoryImpl;
        this.f59682j = fluidHomeComponentRequestParams;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$componentResponse$1(this.f59681i, this.f59682j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ContentApiResponse> continuation) {
        return ((HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$componentResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59680h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            HomeConfigurationRepositoryImpl homeConfigurationRepositoryImpl = this.f59681i;
            FluidHomeComponentRequestParams fluidHomeComponentRequestParams = this.f59682j;
            this.f59680h = 1;
            obj = homeConfigurationRepositoryImpl.getComponents(fluidHomeComponentRequestParams, this);
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
