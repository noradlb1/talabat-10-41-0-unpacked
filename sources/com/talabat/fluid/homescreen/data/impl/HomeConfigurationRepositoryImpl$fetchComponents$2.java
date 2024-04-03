package com.talabat.fluid.homescreen.data.impl;

import com.talabat.fluid.homescreen.data.remote.component.ContentApiResponse;
import com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams;
import com.talabat.fluid.homescreen.domain.repository.HomeConfigurationRepository;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/fluid/homescreen/domain/repository/HomeConfigurationRepository$Components;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$fetchComponents$2", f = "HomeConfigurationRepositoryImpl.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class HomeConfigurationRepositoryImpl$fetchComponents$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HomeConfigurationRepository.Components>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59674h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ HomeConfigurationRepositoryImpl f59675i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FluidHomeComponentRequestParams f59676j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeConfigurationRepositoryImpl$fetchComponents$2(HomeConfigurationRepositoryImpl homeConfigurationRepositoryImpl, FluidHomeComponentRequestParams fluidHomeComponentRequestParams, Continuation<? super HomeConfigurationRepositoryImpl$fetchComponents$2> continuation) {
        super(2, continuation);
        this.f59675i = homeConfigurationRepositoryImpl;
        this.f59676j = fluidHomeComponentRequestParams;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HomeConfigurationRepositoryImpl$fetchComponents$2(this.f59675i, this.f59676j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super HomeConfigurationRepository.Components> continuation) {
        return ((HomeConfigurationRepositoryImpl$fetchComponents$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ContentApiResponse.Configurations configurations;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59674h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(this.f59675i.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "homeConfigurationRepository.fetchComponents", (Map) null, 4, (Object) null);
            HomeConfigurationRepositoryImpl homeConfigurationRepositoryImpl = this.f59675i;
            FluidHomeComponentRequestParams fluidHomeComponentRequestParams = this.f59676j;
            this.f59674h = 1;
            obj = homeConfigurationRepositoryImpl.fetchComponentsAndTemplates(fluidHomeComponentRequestParams, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair pair = (Pair) obj;
        ContentApiResponse contentApiResponse = (ContentApiResponse) pair.component1();
        List access$mapToListCells = this.f59675i.mapToListCells(contentApiResponse, (Map) pair.component2(), this.f59676j.getSelectedLanguage());
        HomeConfigurationRepositoryImpl homeConfigurationRepositoryImpl2 = this.f59675i;
        ContentApiResponse.Data data = contentApiResponse.getData();
        ContentApiResponse.Metadata metadata = null;
        if (data != null) {
            configurations = data.getConfigurations();
        } else {
            configurations = null;
        }
        HomeConfigurationRepository.Components.Configuration access$toConfiguration = homeConfigurationRepositoryImpl2.toConfiguration(configurations);
        HomeConfigurationRepositoryImpl homeConfigurationRepositoryImpl3 = this.f59675i;
        ContentApiResponse.Data data2 = contentApiResponse.getData();
        if (data2 != null) {
            metadata = data2.getMetadata();
        }
        HomeConfigurationRepository.Components components = new HomeConfigurationRepository.Components(access$mapToListCells, access$toConfiguration, homeConfigurationRepositoryImpl3.toMetadata(metadata));
        HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(this.f59675i.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "homeConfigurationRepository.fetchComponents", (Map) null, 4, (Object) null);
        return components;
    }
}
