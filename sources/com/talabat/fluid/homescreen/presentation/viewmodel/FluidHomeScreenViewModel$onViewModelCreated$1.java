package com.talabat.fluid.homescreen.presentation.viewmodel;

import com.talabat.core.network.testutils.TalabatIdlingResource;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import com.talabat.fluid.homescreen.domain.usecase.business.FetchHomeCollectionsUseCase;
import com.talabat.observability.localTracer.PointOfInterest;
import com.talabat.observability.localTracer.PointOfInterestReporter;
import com.talabat.observability.localTracer.SectionOfInterest;
import java.util.Map;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel$onViewModelCreated$1", f = "FluidHomeScreenViewModel.kt", i = {1}, l = {167, 173}, m = "invokeSuspend", n = {"homeCollectionsResult"}, s = {"L$0"})
public final class FluidHomeScreenViewModel$onViewModelCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f59729h;

    /* renamed from: i  reason: collision with root package name */
    public int f59730i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenViewModel f59731j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeScreenViewModel$onViewModelCreated$1(FluidHomeScreenViewModel fluidHomeScreenViewModel, Continuation<? super FluidHomeScreenViewModel$onViewModelCreated$1> continuation) {
        super(2, continuation);
        this.f59731j = fluidHomeScreenViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FluidHomeScreenViewModel$onViewModelCreated$1(this.f59731j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FluidHomeScreenViewModel$onViewModelCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FetchHomeCollectionsUseCase.HomeCollectionResult homeCollectionResult;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59730i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            HomeScreenPerformanceObservability.DefaultImpls.traceStart$default(this.f59731j.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "fluidHomeScreenViewModel.onViewModelCreated", (Map) null, 4, (Object) null);
            this.f59731j.showLoading();
            this.f59731j.resetTrackingCache();
            TalabatIdlingResource.busy("homeloading");
            FetchHomeCollectionsUseCase access$getFetchHomeCollectionsUseCase$p = this.f59731j.fetchHomeCollectionsUseCase;
            this.f59730i = 1;
            obj = access$getFetchHomeCollectionsUseCase$p.fetchHomeCollections(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i11 == 2) {
            homeCollectionResult = (FetchHomeCollectionsUseCase.HomeCollectionResult) this.f59729h;
            ResultKt.throwOnFailure(obj);
            this.f59731j.clearVoucherCampaignIfApplicable(homeCollectionResult.getMetadata());
            this.f59731j.showItemReplacementBottomSheet(homeCollectionResult.getCollectionData());
            TalabatIdlingResource.idle("homeloading");
            HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(this.f59731j.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "fluidHomeScreenViewModel.onViewModelCreated", (Map) null, 4, (Object) null);
            PointOfInterestReporter pointOfInterestReporter = PointOfInterestReporter.INSTANCE;
            SectionOfInterest sectionOfInterest = SectionOfInterest.HOME_SCREEN_ACTIVITY;
            PointOfInterest pointOfInterest = PointOfInterest.TOTAL_TIME;
            pointOfInterestReporter.endTraceLog(sectionOfInterest, pointOfInterest);
            pointOfInterestReporter.endTraceLog(SectionOfInterest.APP_START_TO_INTERACTIVE, pointOfInterest);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        FetchHomeCollectionsUseCase.HomeCollectionResult homeCollectionResult2 = (FetchHomeCollectionsUseCase.HomeCollectionResult) obj;
        this.f59731j._components.postValue(homeCollectionResult2.getCollectionData());
        this.f59731j.setupConfigurationIfAvailable(homeCollectionResult2.getConfiguration());
        this.f59731j.hideLoading();
        this.f59731j.stopHomeScreenTraceUseCase.stopHomeScreenTrace();
        this.f59731j.trackLoadedComponents(homeCollectionResult2.getCollectionData());
        FluidHomeScreenViewModel fluidHomeScreenViewModel = this.f59731j;
        this.f59729h = homeCollectionResult2;
        this.f59730i = 2;
        if (fluidHomeScreenViewModel.showRatingBottomSheet(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        homeCollectionResult = homeCollectionResult2;
        this.f59731j.clearVoucherCampaignIfApplicable(homeCollectionResult.getMetadata());
        this.f59731j.showItemReplacementBottomSheet(homeCollectionResult.getCollectionData());
        TalabatIdlingResource.idle("homeloading");
        HomeScreenPerformanceObservability.DefaultImpls.traceEnd$default(this.f59731j.homeScreenPerformanceObservability, HomeScreenPerformanceObservability.Level.INFO, "fluidHomeScreenViewModel.onViewModelCreated", (Map) null, 4, (Object) null);
        PointOfInterestReporter pointOfInterestReporter2 = PointOfInterestReporter.INSTANCE;
        SectionOfInterest sectionOfInterest2 = SectionOfInterest.HOME_SCREEN_ACTIVITY;
        PointOfInterest pointOfInterest2 = PointOfInterest.TOTAL_TIME;
        pointOfInterestReporter2.endTraceLog(sectionOfInterest2, pointOfInterest2);
        pointOfInterestReporter2.endTraceLog(SectionOfInterest.APP_START_TO_INTERACTIVE, pointOfInterest2);
        return Unit.INSTANCE;
    }
}
