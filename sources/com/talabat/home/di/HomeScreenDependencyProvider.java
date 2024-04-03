package com.talabat.home.di;

import android.app.Activity;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueNotificationAcknowledgeUseCase;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.UpdateOverdueAcknowledgeStateUseCase;
import com.talabat.feature.rating.domain.EventTracker;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase;
import com.talabat.rating.presenter.OrderRatingPresenter;
import com.talabat.rating.repo.impl.OrderRatingRepositoryImpl;
import com.talabat.rating.view.OrderRatingViewImpl;
import com.talabat.talabatcommon.helpers.RxProcessor;
import io.reactivex.Scheduler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import library.talabat.mvp.home.HomePresenter;
import library.talabat.mvp.home.HomeView;
import library.talabat.mvp.home.IsNfvFlutterNavigationUsecase;
import library.talabat.mvp.home.domain.EnableShowLocationSelectionInHomeScreenUseCase;
import library.talabat.mvp.home.domain.GetActiveCartInfoUseCase;
import library.talabat.mvp.home.domain.ShouldShowLocationSelectionInHomeUseCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;
import tracking.gtm.GTMCart;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J¦\u0001\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208J\u001e\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020;2\u0006\u0010#\u001a\u00020$2\u0006\u0010<\u001a\u00020=R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006>"}, d2 = {"Lcom/talabat/home/di/HomeScreenDependencyProvider;", "", "()V", "mockHomePresenter", "Llibrary/talabat/mvp/home/HomePresenter;", "getMockHomePresenter$annotations", "getMockHomePresenter", "()Llibrary/talabat/mvp/home/HomePresenter;", "setMockHomePresenter", "(Llibrary/talabat/mvp/home/HomePresenter;)V", "orderRatingPresenter", "Lcom/talabat/rating/presenter/OrderRatingPresenter;", "getOrderRatingPresenter$annotations", "getOrderRatingPresenter", "()Lcom/talabat/rating/presenter/OrderRatingPresenter;", "setOrderRatingPresenter", "(Lcom/talabat/rating/presenter/OrderRatingPresenter;)V", "provideHomePresenter", "homeView", "Llibrary/talabat/mvp/home/HomeView;", "shouldShowLocationSelectionInHomeUseCase", "Llibrary/talabat/mvp/home/domain/ShouldShowLocationSelectionInHomeUseCase;", "enableShowLocationSelectionInHomeScreenUseCase", "Llibrary/talabat/mvp/home/domain/EnableShowLocationSelectionInHomeScreenUseCase;", "ioScheduler", "Lio/reactivex/Scheduler;", "mainScheduler", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "mutableLocationConfigurationRepository", "Lcom/talabat/configuration/MutableLocationConfigurationRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getOverdueUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "getOverdueNotificationAcknowledgeUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueNotificationAcknowledgeUseCase;", "updateOverdueAcknowledgeStateUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/UpdateOverdueAcknowledgeStateUseCase;", "getActiveCartInfoUseCase", "Llibrary/talabat/mvp/home/domain/GetActiveCartInfoUseCase;", "shouldRateLastOrderUseCase", "Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "isOnboardingExperimentEnabledUseCase", "Lcom/talabat/onboarding/domain/usecase/IsOnboardingExperimentEnabledUseCase;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "isNfvFlutterNavigationUsecase", "Llibrary/talabat/mvp/home/IsNfvFlutterNavigationUsecase;", "provideOrderRatingPresenter", "activity", "Landroid/app/Activity;", "ratingEventTracker", "Lcom/talabat/feature/rating/domain/EventTracker;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenDependencyProvider {
    @NotNull
    public static final HomeScreenDependencyProvider INSTANCE = new HomeScreenDependencyProvider();
    @Nullable
    private static HomePresenter mockHomePresenter;
    @Nullable
    private static OrderRatingPresenter orderRatingPresenter;

    private HomeScreenDependencyProvider() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMockHomePresenter$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getOrderRatingPresenter$annotations() {
    }

    @Nullable
    public final HomePresenter getMockHomePresenter() {
        return mockHomePresenter;
    }

    @Nullable
    public final OrderRatingPresenter getOrderRatingPresenter() {
        return orderRatingPresenter;
    }

    @NotNull
    public final HomePresenter provideHomePresenter(@NotNull HomeView homeView, @NotNull ShouldShowLocationSelectionInHomeUseCase shouldShowLocationSelectionInHomeUseCase, @NotNull EnableShowLocationSelectionInHomeScreenUseCase enableShowLocationSelectionInHomeScreenUseCase, @NotNull Scheduler scheduler, @NotNull Scheduler scheduler2, @NotNull AppVersionProvider appVersionProvider, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull IObservabilityManager iObservabilityManager, @NotNull MutableLocationConfigurationRepository mutableLocationConfigurationRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull GetOverdueUseCase getOverdueUseCase, @NotNull GetOverdueNotificationAcknowledgeUseCase getOverdueNotificationAcknowledgeUseCase, @NotNull UpdateOverdueAcknowledgeStateUseCase updateOverdueAcknowledgeStateUseCase, @NotNull GetActiveCartInfoUseCase getActiveCartInfoUseCase, @NotNull ShouldRateLastOrderUseCase shouldRateLastOrderUseCase, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CustomerRepository customerRepository, @NotNull IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory, @NotNull IsNfvFlutterNavigationUsecase isNfvFlutterNavigationUsecase) {
        Intrinsics.checkNotNullParameter(homeView, "homeView");
        Intrinsics.checkNotNullParameter(shouldShowLocationSelectionInHomeUseCase, "shouldShowLocationSelectionInHomeUseCase");
        Intrinsics.checkNotNullParameter(enableShowLocationSelectionInHomeScreenUseCase, "enableShowLocationSelectionInHomeScreenUseCase");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(scheduler2, "mainScheduler");
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(mutableLocationConfigurationRepository, "mutableLocationConfigurationRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(getOverdueUseCase, "getOverdueUseCase");
        Intrinsics.checkNotNullParameter(getOverdueNotificationAcknowledgeUseCase, "getOverdueNotificationAcknowledgeUseCase");
        Intrinsics.checkNotNullParameter(updateOverdueAcknowledgeStateUseCase, "updateOverdueAcknowledgeStateUseCase");
        Intrinsics.checkNotNullParameter(getActiveCartInfoUseCase, "getActiveCartInfoUseCase");
        Intrinsics.checkNotNullParameter(shouldRateLastOrderUseCase, "shouldRateLastOrderUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        Intrinsics.checkNotNullParameter(isOnboardingExperimentEnabledUseCase, "isOnboardingExperimentEnabledUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
        Intrinsics.checkNotNullParameter(isNfvFlutterNavigationUsecase, "isNfvFlutterNavigationUsecase");
        HomePresenter homePresenter = mockHomePresenter;
        if (homePresenter != null) {
            return homePresenter;
        }
        return new HomePresenter(homeView, shouldShowLocationSelectionInHomeUseCase, enableShowLocationSelectionInHomeScreenUseCase, getOverdueUseCase, getOverdueNotificationAcknowledgeUseCase, updateOverdueAcknowledgeStateUseCase, scheduler, scheduler2, iObservabilityManager, iTalabatFeatureFlag, Customer.getInstance(), appVersionProvider, configurationLocalRepository, mutableLocationConfigurationRepository, getActiveCartInfoUseCase, GTMCart.INSTANCE, shouldRateLastOrderUseCase, coroutineDispatcher, customerRepository, isOnboardingExperimentEnabledUseCase, isNfvFlutterNavigationUsecase, coroutineDispatchersFactory);
    }

    @NotNull
    public final OrderRatingPresenter provideOrderRatingPresenter(@NotNull Activity activity, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull EventTracker eventTracker) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(eventTracker, "ratingEventTracker");
        OrderRatingPresenter orderRatingPresenter2 = orderRatingPresenter;
        if (orderRatingPresenter2 == null) {
            return new OrderRatingPresenter(new OrderRatingViewImpl(activity, "HOME_SCREEN", eventTracker), new OrderRatingRepositoryImpl((ApiHandler.Services) null, iTalabatFeatureFlag, 1, (DefaultConstructorMarker) null), (RxProcessor) null, 4, (DefaultConstructorMarker) null);
        }
        return orderRatingPresenter2;
    }

    public final void setMockHomePresenter(@Nullable HomePresenter homePresenter) {
        mockHomePresenter = homePresenter;
    }

    public final void setOrderRatingPresenter(@Nullable OrderRatingPresenter orderRatingPresenter2) {
        orderRatingPresenter = orderRatingPresenter2;
    }
}
