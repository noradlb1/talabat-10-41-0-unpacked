package com.talabat.fluid.homescreen.data.impl;

import com.deliveryhero.fluid.template.Template;
import com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse;
import com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Pair;", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse;", "", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/Template;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2", f = "HomeConfigurationRepositoryImpl.kt", i = {0}, l = {105, 105}, m = "invokeSuspend", n = {"templates"}, s = {"L$0"})
public final class HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends ContentApiResponse, ? extends Map<String, ? extends Template>>>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59677h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ HomeConfigurationRepositoryImpl f59678i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FluidHomeComponentRequestParams f59679j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2(HomeConfigurationRepositoryImpl homeConfigurationRepositoryImpl, FluidHomeComponentRequestParams fluidHomeComponentRequestParams, Continuation<? super HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2> continuation) {
        super(2, continuation);
        this.f59678i = homeConfigurationRepositoryImpl;
        this.f59679j = fluidHomeComponentRequestParams;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2 homeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2 = new HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2(this.f59678i, this.f59679j, continuation);
        homeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2.L$0 = obj;
        return homeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Pair<ContentApiResponse, ? extends Map<String, Template>>> continuation) {
        return ((HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Deferred deferred;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59677h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$componentResponse$1(this.f59678i, this.f59679j, (Continuation<? super HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$componentResponse$1>) null), 3, (Object) null);
            Deferred async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$templates$1(this.f59678i, (Continuation<? super HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$templates$1>) null), 3, (Object) null);
            this.L$0 = async$default2;
            this.f59677h = 1;
            Object await = async$default.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj3 = await;
            deferred = async$default2;
            obj = obj3;
        } else if (i11 == 1) {
            deferred = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            obj2 = this.L$0;
            ResultKt.throwOnFailure(obj);
            return new Pair(obj2, obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.L$0 = obj;
        this.f59677h = 2;
        Object await2 = deferred.await(this);
        if (await2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        obj2 = obj;
        obj = await2;
        return new Pair(obj2, obj);
    }
}
