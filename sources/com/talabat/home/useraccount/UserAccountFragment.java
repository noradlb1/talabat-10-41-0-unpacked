package com.talabat.home.useraccount;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Customer;
import buisnessmodels.TalabatFormatter;
import com.android.volley.VolleyError;
import com.designsystem.ds_alert.DSAlert;
import com.designsystem.ds_alert.DSAlertType;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.subscription.SubscriptionFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageRemoteConfigurationsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.navigation.domain.screen.voucherlist.VouchersListDeeplinkBuilder;
import com.talabat.core.navigation.domain.screen.wallet.CobrandedCreditCardFlutterScreenKt;
import com.talabat.core.observabilityNew.domain.IAppLaunchTrackingManager;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.observabilityNew.domain.common.EventType;
import com.talabat.core.observabilityNew.domain.common.GrowthEvents;
import com.talabat.core.observabilityNew.domain.squads.home.UserAccountScreenPerformanceParams;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.di.DaggerUserAccountFragmentComponent;
import com.talabat.feature.bnplcore.domain.BnplCoreFeatureApi;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import com.talabat.feature.bnplcore.domain.usecase.SendNavigationOptionLoadedEventUseCase;
import com.talabat.feature.bnplcore.domain.usecase.impl.IsUserBNPLEligibleUseCase;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.referafriend.domain.models.RafRemoteConfig;
import com.talabat.feature.referafriend.domain.models.SenderVoucherValue;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase;
import com.talabat.feature.tpro.presentation.benefits.SubscriptionBenefitsDeeplinkBuilder;
import com.talabat.feature.tpro.presentation.management.details.SubscriptionManagementDeeplinkBuilder;
import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcFeatureApi;
import com.talabat.feature.walletcobrandedcc.domain.model.WalletStatus;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModel;
import com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModelFactory;
import com.talabat.fluttercore.channels.GlobalMethodChannelCallback;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModelFactory;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.tracking.vouchers.VoucherBadgeEventSource;
import com.talabat.home.tracking.vouchers.VouchersNotificationBadgeTracker;
import com.talabat.home.useraccount.tracking.UserAccountTracker;
import com.talabat.sidemenu.SideMenuFactory;
import com.talabat.sidemenu.SideMenuHeader;
import com.talabat.sidemenu.SideMenuPresenter;
import com.talabat.sidemenu.SideMenuRecyclerViewAdapter;
import com.talabat.sidemenu.SideMenuResource;
import com.talabat.sidemenu.SideMenuView;
import com.talabat.sidemenu.SidemenuExpandableListItem;
import com.talabat.talabatnavigation.base.NavigatorModelForResult;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.wallet.ui.walletDashboard.view.WalletDashboardActivity;
import datamodels.CustomerInfo;
import es.a;
import es.b;
import io.reactivex.Scheduler;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Instrumented
@Metadata(d1 = {"\u0000ü\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002»\u0001\u0018\u0000 \u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001b\u0010±\u0001\u001a\u00030²\u00012\u000f\u0010³\u0001\u001a\n\u0012\u0005\u0012\u00030µ\u00010´\u0001H\u0002J\n\u0010¶\u0001\u001a\u00030·\u0001H\u0002J\n\u0010¸\u0001\u001a\u00030·\u0001H\u0002J\n\u0010¹\u0001\u001a\u00030²\u0001H\u0002J\u001a\u0010º\u0001\u001a\u00030»\u00012\b\u0010¼\u0001\u001a\u00030½\u0001H\u0002¢\u0006\u0003\u0010¾\u0001J\u001e\u0010¿\u0001\u001a\u00030À\u00012\b\u0010Á\u0001\u001a\u00030Â\u00012\b\u0010Ã\u0001\u001a\u00030Ä\u0001H\u0002J\n\u0010Å\u0001\u001a\u00030²\u0001H\u0016J\n\u0010Æ\u0001\u001a\u00030·\u0001H\u0002J\n\u0010Ç\u0001\u001a\u00030·\u0001H\u0002J\b\u0010È\u0001\u001a\u00030·\u0001J\n\u0010É\u0001\u001a\u00030·\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030·\u0001H\u0002J\n\u0010Ë\u0001\u001a\u00030·\u0001H\u0002J\n\u0010Ì\u0001\u001a\u00030·\u0001H\u0002J\n\u0010Í\u0001\u001a\u00030²\u0001H\u0002J\n\u0010Î\u0001\u001a\u00030²\u0001H\u0002J\n\u0010Ï\u0001\u001a\u00030²\u0001H\u0002J\n\u0010Ð\u0001\u001a\u00030²\u0001H\u0002J\n\u0010Ñ\u0001\u001a\u00030²\u0001H\u0002J\u0014\u0010Ò\u0001\u001a\u00030²\u00012\b\u0010Ó\u0001\u001a\u00030Â\u0001H\u0002J\n\u0010Ô\u0001\u001a\u00030²\u0001H\u0002J\n\u0010Õ\u0001\u001a\u00030²\u0001H\u0002J\n\u0010Ö\u0001\u001a\u00030²\u0001H\u0002J\n\u0010×\u0001\u001a\u00030²\u0001H\u0002J*\u0010Ø\u0001\u001a\u00030²\u00012\b\u0010Ã\u0001\u001a\u00030Ä\u00012\b\u0010Ù\u0001\u001a\u00030Ä\u00012\n\u0010Ú\u0001\u001a\u0005\u0018\u00010Û\u0001H\u0016J\u0014\u0010Ü\u0001\u001a\u00030²\u00012\b\u0010¼\u0001\u001a\u00030½\u0001H\u0016J\n\u0010Ý\u0001\u001a\u00030²\u0001H\u0016J.\u0010Þ\u0001\u001a\u0005\u0018\u00010ß\u00012\b\u0010à\u0001\u001a\u00030á\u00012\n\u0010â\u0001\u001a\u0005\u0018\u00010ã\u00012\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u0001H\u0016J\n\u0010æ\u0001\u001a\u00030²\u0001H\u0016J\n\u0010ç\u0001\u001a\u00030²\u0001H\u0016J\n\u0010è\u0001\u001a\u00030²\u0001H\u0016J\n\u0010é\u0001\u001a\u00030²\u0001H\u0016J\u0016\u0010ê\u0001\u001a\u00030²\u00012\n\u0010ë\u0001\u001a\u0005\u0018\u00010ì\u0001H\u0016J\"\u0010í\u0001\u001a\u00030²\u00012\n\u0010î\u0001\u001a\u0005\u0018\u00010Â\u00012\n\u0010ï\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0016J\u0016\u0010ð\u0001\u001a\u00030²\u00012\n\u0010ñ\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0016J\u0014\u0010ò\u0001\u001a\u00030²\u00012\b\u0010ó\u0001\u001a\u00030·\u0001H\u0002J \u0010ô\u0001\u001a\u00030²\u00012\b\u0010õ\u0001\u001a\u00030ß\u00012\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u0001H\u0016J\u001b\u0010ö\u0001\u001a\u00030²\u00012\u000f\u0010÷\u0001\u001a\n\u0012\u0005\u0012\u00030µ\u00010´\u0001H\u0002J\u001b\u0010ø\u0001\u001a\u00030²\u00012\u000f\u0010÷\u0001\u001a\n\u0012\u0005\u0012\u00030µ\u00010´\u0001H\u0002J\n\u0010ù\u0001\u001a\u00030²\u0001H\u0002J\n\u0010ú\u0001\u001a\u00030²\u0001H\u0016J\n\u0010û\u0001\u001a\u00030²\u0001H\u0002J\u0014\u0010ü\u0001\u001a\u00030²\u00012\b\u0010õ\u0001\u001a\u00030ß\u0001H\u0002J\n\u0010ý\u0001\u001a\u00030²\u0001H\u0016J\u0014\u0010þ\u0001\u001a\u00030²\u00012\b\u0010ÿ\u0001\u001a\u00030\u0002H\u0016J\n\u0010\u0002\u001a\u00030²\u0001H\u0016J\n\u0010\u0002\u001a\u00030²\u0001H\u0016J\n\u0010\u0002\u001a\u00030²\u0001H\u0002J0\u0010\u0002\u001a\u00030²\u00012\b\u0010\u0002\u001a\u00030Â\u00012\f\b\u0002\u0010\u0002\u001a\u0005\u0018\u00010Â\u00012\f\b\u0002\u0010\u0002\u001a\u0005\u0018\u00010Â\u0001H\u0002J\u0014\u0010\u0002\u001a\u00030²\u00012\b\u0010\u0002\u001a\u00030Â\u0001H\u0016J\u0016\u0010\u0002\u001a\u00030²\u00012\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0016J \u0010\u0002\u001a\u00030²\u0001*\n\u0012\u0005\u0012\u00030µ\u00010´\u00012\b\u0010\u0002\u001a\u00030Â\u0001H\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0002008\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u00105\u001a\u0002068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u00020<8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010A\u001a\u00020B8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010G\u001a\u00020H8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001e\u0010M\u001a\u00020N8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010S\u001a\u00020T8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010U\"\u0004\bV\u0010WR\u001e\u0010X\u001a\u00020Y8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001e\u0010^\u001a\u00020_8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001e\u0010d\u001a\u00020e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u000e\u0010j\u001a\u00020kX.¢\u0006\u0002\n\u0000R\u001e\u0010l\u001a\u00020m8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001e\u0010r\u001a\u00020s8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001e\u0010x\u001a\u00020y8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R)\u0010~\u001a\u000208\u0006@\u0006X.¢\u0006\u0019\n\u0000\u0012\u0005\b\u0001\u0010\u0004\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X.¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010 \u0001R$\u0010¡\u0001\u001a\u00030¢\u00018\u0006@\u0006X.¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R \u0010§\u0001\u001a\u00030¨\u00018BX\u0002¢\u0006\u000f\n\u0005\b«\u0001\u0010\u0010\u001a\u0006\b©\u0001\u0010ª\u0001R \u0010¬\u0001\u001a\u00030­\u00018BX\u0002¢\u0006\u000f\n\u0005\b°\u0001\u0010\u0010\u001a\u0006\b®\u0001\u0010¯\u0001¨\u0006\u0002"}, d2 = {"Lcom/talabat/home/useraccount/UserAccountFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/sidemenu/SideMenuView;", "Lcom/talabat/fluttercore/channels/GlobalMethodChannelCallback;", "()V", "appLaunchTrackingManager", "Lcom/talabat/core/observabilityNew/domain/IAppLaunchTrackingManager;", "getAppLaunchTrackingManager", "()Lcom/talabat/core/observabilityNew/domain/IAppLaunchTrackingManager;", "setAppLaunchTrackingManager", "(Lcom/talabat/core/observabilityNew/domain/IAppLaunchTrackingManager;)V", "cobrandedCcViewModel", "Lcom/talabat/feature/walletcobrandedcc/presentation/CobrandedCcViewModel;", "getCobrandedCcViewModel", "()Lcom/talabat/feature/walletcobrandedcc/presentation/CobrandedCcViewModel;", "cobrandedCcViewModel$delegate", "Lkotlin/Lazy;", "cobrandedCcViewModelFactory", "Lcom/talabat/feature/walletcobrandedcc/presentation/CobrandedCcViewModelFactory;", "getCobrandedCcViewModelFactory", "()Lcom/talabat/feature/walletcobrandedcc/presentation/CobrandedCcViewModelFactory;", "setCobrandedCcViewModelFactory", "(Lcom/talabat/feature/walletcobrandedcc/presentation/CobrandedCcViewModelFactory;)V", "configurationRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "getCoroutineDispatchersFactory", "()Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "setCoroutineDispatchersFactory", "(Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "getCustomerRepository", "()Lcom/talabat/customer/domain/CustomerRepository;", "setCustomerRepository", "(Lcom/talabat/customer/domain/CustomerRepository;)V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "experiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "getExperiment", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "setExperiment", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "factory", "Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModelFactory;", "getFactory", "()Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModelFactory;", "setFactory", "(Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModelFactory;)V", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getOverdueUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "getGetOverdueUseCase", "()Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "setGetOverdueUseCase", "(Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;)V", "getSubscriptionsSavingsInfo", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "getGetSubscriptionsSavingsInfo", "()Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "setGetSubscriptionsSavingsInfo", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;)V", "helpCenterDeeplinkBuilder", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "getHelpCenterDeeplinkBuilder", "()Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "setHelpCenterDeeplinkBuilder", "(Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;)V", "isUserBNPLEligibleUseCase", "Lcom/talabat/feature/bnplcore/domain/usecase/impl/IsUserBNPLEligibleUseCase;", "()Lcom/talabat/feature/bnplcore/domain/usecase/impl/IsUserBNPLEligibleUseCase;", "setUserBNPLEligibleUseCase", "(Lcom/talabat/feature/bnplcore/domain/usecase/impl/IsUserBNPLEligibleUseCase;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "renewalSuccessAlert", "Lcom/designsystem/ds_alert/DSAlert;", "schedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "getSchedulersFactory", "()Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "setSchedulersFactory", "(Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;)V", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "getScreenTracker", "()Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "setScreenTracker", "(Lcom/talabat/core/observabilityNew/domain/IScreenTracker;)V", "sendNavigationOptionLoadedEventUsecase", "Lcom/talabat/feature/bnplcore/domain/usecase/SendNavigationOptionLoadedEventUseCase;", "getSendNavigationOptionLoadedEventUsecase", "()Lcom/talabat/feature/bnplcore/domain/usecase/SendNavigationOptionLoadedEventUseCase;", "setSendNavigationOptionLoadedEventUsecase", "(Lcom/talabat/feature/bnplcore/domain/usecase/SendNavigationOptionLoadedEventUseCase;)V", "sideMenuPresenter", "Lcom/talabat/sidemenu/SideMenuPresenter;", "getSideMenuPresenter$annotations", "getSideMenuPresenter", "()Lcom/talabat/sidemenu/SideMenuPresenter;", "setSideMenuPresenter", "(Lcom/talabat/sidemenu/SideMenuPresenter;)V", "sideMenuRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sideMenuRecyclerViewAdapter", "Lcom/talabat/sidemenu/SideMenuRecyclerViewAdapter;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "getSubscriptionStatusRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "setSubscriptionStatusRepository", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;)V", "subscriptionTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "getSubscriptionTracker", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "setSubscriptionTracker", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;)V", "subscriptionsFeatureFlagRepo", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "getSubscriptionsFeatureFlagRepo", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "setSubscriptionsFeatureFlagRepo", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;)V", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "setTalabatTracker", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "updateAutoRenewalUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase;", "getUpdateAutoRenewalUseCase", "()Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase;", "setUpdateAutoRenewalUseCase", "(Lcom/talabat/feature/subscriptions/domain/usecase/UpdateAutoRenewalUseCase;)V", "userAccountTracker", "Lcom/talabat/home/useraccount/tracking/UserAccountTracker;", "getUserAccountTracker", "()Lcom/talabat/home/useraccount/tracking/UserAccountTracker;", "userAccountTracker$delegate", "voucherEntryPointViewModel", "Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModel;", "getVoucherEntryPointViewModel", "()Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModel;", "voucherEntryPointViewModel$delegate", "addTProBanner", "", "mutableList", "", "Lcom/talabat/sidemenu/SideMenuHeader;", "canShowSavingsBanner", "", "canShowSubscriptionList", "checkIsUserBNPLEligible", "createLinearLayoutManager", "com/talabat/home/useraccount/UserAccountFragment$createLinearLayoutManager$1", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Lcom/talabat/home/useraccount/UserAccountFragment$createLinearLayoutManager$1;", "createNavigationToBNPLDashboard", "Lcom/talabat/talabatnavigation/base/NavigatorModelForResult;", "eventOrigin", "", "requestCode", "", "hideBnplOverdueNotification", "isBnplOverdueNotificationEnabled", "isCobrandedApplicationIncomplete", "isReferAFriendEnabled", "isReferAFriendExperimentEnabled", "isReferAFriendFlagEnabled", "isUserLoggedIn", "isWalletDashboardFlutterEnabled", "loadBnplOverdue", "loadCreditBalanceAndVouchers", "loadPendingCcApplication", "loadRafSenderVoucherLabel", "navigateToBnplDashboard", "navigateToDeeplink", "deeplink", "navigateToOnboarding", "navigateToSubscriptionManagement", "navigateToVoucherList", "navigateToWallet", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onBackPressedFromFlutter", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreditBalanceRefresh", "onDataError", "onNetworkError", "onResume", "onServerError", "error", "Lcom/android/volley/VolleyError;", "onSideMenuLinkNavigation", "pageTitle", "url", "onSideMenuNavigation", "pageName", "onUpdateRenewalResult", "isSuccess", "onViewCreated", "view", "removeBnplItem", "sideMenuHeaders", "removeDisabledSideMenuItems", "requestCreditBalance", "setSideMenu", "setStatusBarColor", "setupSideMenuListView", "showBNPLOption", "showBnplOverdueNotification", "overdueAmount", "", "startLodingPopup", "stopLodingPopup", "trackHelpCenterClick", "trackOptionClick", "navigationOption", "badgeType", "badgeValue", "updateRafVoucherLabel", "rafSenderVoucherLabel", "updateVoucherCounter", "voucherStateDomainModel", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "removeSideMenuHeaderItem", "matchingString", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserAccountFragment extends Fragment implements SideMenuView, GlobalMethodChannelCallback, TraceFieldInterface {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String FLUTTER_ORDERS_LIST_ENABLED = "Variation1";
    @NotNull
    @Deprecated
    public static final String VARIATION_RAF_EXPERIMENT_ENABLED = "Variation1";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Inject
    public IAppLaunchTrackingManager appLaunchTrackingManager;
    @NotNull
    private final Lazy cobrandedCcViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CobrandedCcViewModel.class), new UserAccountFragment$special$$inlined$activityViewModels$default$4(this), new UserAccountFragment$special$$inlined$activityViewModels$default$5((Function0) null, this), new UserAccountFragment$cobrandedCcViewModel$2(this));
    @Inject
    public CobrandedCcViewModelFactory cobrandedCcViewModelFactory;
    @Inject
    public ConfigurationLocalRepository configurationRepository;
    @Inject
    public CoroutineDispatchersFactory coroutineDispatchersFactory;
    @Inject
    public CustomerRepository customerRepository;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @Inject
    public ITalabatExperiment experiment;
    @Inject
    public VoucherEntryPointViewModelFactory factory;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @Inject
    public GetOverdueUseCase getOverdueUseCase;
    @Inject
    public GetSavingsInfoUseCase getSubscriptionsSavingsInfo;
    @Inject
    public IHelpCenterDeeplinkBuilder helpCenterDeeplinkBuilder;
    @Inject
    public IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Inject
    public Navigator navigator;
    @Inject
    public IObservabilityManager observabilityManager;
    private DSAlert renewalSuccessAlert;
    @Inject
    public RxSchedulersFactory schedulersFactory;
    @Inject
    public IScreenTracker screenTracker;
    @Inject
    public SendNavigationOptionLoadedEventUseCase sendNavigationOptionLoadedEventUsecase;
    public SideMenuPresenter sideMenuPresenter;
    private RecyclerView sideMenuRecyclerView;
    @Nullable
    private SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter;
    @Inject
    public ISubscriptionStatusRepository subscriptionStatusRepository;
    @Inject
    public ISubscriptionsTracker subscriptionTracker;
    @Inject
    public ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlagRepo;
    @Inject
    public TalabatTracker talabatTracker;
    @Inject
    public UpdateAutoRenewalUseCase updateAutoRenewalUseCase;
    @NotNull
    private final Lazy userAccountTracker$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new UserAccountFragment$userAccountTracker$2(this));
    @NotNull
    private final Lazy voucherEntryPointViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(VoucherEntryPointViewModel.class), new UserAccountFragment$special$$inlined$activityViewModels$default$1(this), new UserAccountFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new UserAccountFragment$voucherEntryPointViewModel$2(this));

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/home/useraccount/UserAccountFragment$Companion;", "", "()V", "FLUTTER_ORDERS_LIST_ENABLED", "", "VARIATION_RAF_EXPERIMENT_ENABLED", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void addTProBanner(List<SideMenuHeader> list) {
        if (getSubscriptionsFeatureFlagRepo().isTProSideBannerEnabled()) {
            SideMenuHeader sideMenuHeader = new SideMenuHeader();
            sideMenuHeader.setRef("tPro");
            Unit unit = Unit.INSTANCE;
            list.add(1, sideMenuHeader);
        }
    }

    public static /* synthetic */ void c(UserAccountFragment userAccountFragment, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        if ((i11 & 4) != 0) {
            str3 = null;
        }
        userAccountFragment.trackOptionClick(str, str2, str3);
    }

    private final boolean canShowSavingsBanner() {
        boolean z11;
        boolean z12;
        boolean z13;
        if (!isUserLoggedIn() || !getSubscriptionStatusRepository().getHasAnySubscription()) {
            return false;
        }
        if (!getSubscriptionStatusRepository().isTProCancellationPeriod() || !getSubscriptionsFeatureFlagRepo().isReactivateFromROIBannerEnabled()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!getSubscriptionStatusRepository().isTProExpiredPeriod() || !getSubscriptionsFeatureFlagRepo().isROIbannerExpiredModeEnabled()) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!getSubscriptionStatusRepository().isTProUser() || !getSubscriptionsFeatureFlagRepo().isSavingsBannerEnabled()) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z11 || z12 || z13) {
            return true;
        }
        return false;
    }

    private final boolean canShowSubscriptionList() {
        boolean featureFlag = getFeatureFlagRepo().getFeatureFlag(SubscriptionFeatureFlagConstants.INSTANCE.getSubscriptionFeatureFwfKey(Integer.valueOf(GlobalDataModel.SelectedCountryId), SubscriptionFeatureFlagConstants.SUBSCRIPTION_LIST), false);
        if (!getSubscriptionsFeatureFlagRepo().isTproSubscriptionEnabled() || !featureFlag || !isUserLoggedIn()) {
            return false;
        }
        return true;
    }

    private final void checkIsUserBNPLEligible() {
        if (isUserLoggedIn() && getFeatureFlagRepo().getFeatureFlag(OrderingFeatureFlagsKeys.LENDING_BNPL_HIDE_OPTION_ENABLED, false)) {
            getSideMenuPresenter().checkUserBNPLEligible();
        }
    }

    private final UserAccountFragment$createLinearLayoutManager$1 createLinearLayoutManager(Context context) {
        return new UserAccountFragment$createLinearLayoutManager$1(context, this);
    }

    private final NavigatorModelForResult createNavigationToBNPLDashboard(String str, int i11) {
        Bundle bundle = new Bundle();
        bundle.putString(WalletNavigatorActions.EXTRA_EVENT_ORIGIN_BNPL_DASHBOARD, str);
        return new NavigatorModelForResult(WalletNavigatorActions.OPEN_FLUTTER_BNPL_DASHBOARD_ACTIVITY, bundle, (Function1) null, i11, 4, (DefaultConstructorMarker) null);
    }

    private final CobrandedCcViewModel getCobrandedCcViewModel() {
        return (CobrandedCcViewModel) this.cobrandedCcViewModel$delegate.getValue();
    }

    @VisibleForTesting
    public static /* synthetic */ void getSideMenuPresenter$annotations() {
    }

    private final UserAccountTracker getUserAccountTracker() {
        return (UserAccountTracker) this.userAccountTracker$delegate.getValue();
    }

    private final VoucherEntryPointViewModel getVoucherEntryPointViewModel() {
        return (VoucherEntryPointViewModel) this.voucherEntryPointViewModel$delegate.getValue();
    }

    private final boolean isBnplOverdueNotificationEnabled() {
        boolean z11;
        if (!getFeatureFlagRepo().getFeatureFlag(OrderingFeatureFlagsKeys.LENDING_BNPL_OVERDUE_ENABLED, false) || !getFeatureFlagRepo().getFeatureFlag(PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_BNPL_DASHBOARD_ENABLED, false) || !isUserLoggedIn()) {
            return false;
        }
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = this.sideMenuRecyclerViewAdapter;
        if (sideMenuRecyclerViewAdapter2 == null || !sideMenuRecyclerViewAdapter2.isBnplOptionShowing()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    private final boolean isCobrandedApplicationIncomplete() {
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        if (customerInfo != null) {
            return customerInfo.talabatCcIncomplete;
        }
        return false;
    }

    private final boolean isReferAFriendExperimentEnabled() {
        return Intrinsics.areEqual((Object) getExperiment().getStringVariant(HomePageExperimentsKeys.REFER_A_FRIEND_CONFIG, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    private final boolean isReferAFriendFlagEnabled() {
        if (((RafRemoteConfig) RemoteConfiguration.INSTANCE.getRemoteConfiguration(HomePageRemoteConfigurationsKeys.INCENTIVES_REFER_A_FRIEND_CONFIG, new RafRemoteConfig((SenderVoucherValue) null, 1, (DefaultConstructorMarker) null), RafRemoteConfig.class)).getSenderVoucherValue() != null) {
            return true;
        }
        return false;
    }

    private final boolean isUserLoggedIn() {
        return Customer.getInstance().isLoggedIn();
    }

    private final boolean isWalletDashboardFlutterEnabled() {
        return getFeatureFlagRepo().getFeatureFlag(EcosystemsFeatureFlagsKeys.IS_FLUTTER_WALLET_DASHBOARD_ENABLED, false);
    }

    private final void loadBnplOverdue() {
        if (isBnplOverdueNotificationEnabled()) {
            getSideMenuPresenter().loadBnplOverdues();
        }
    }

    private final void loadCreditBalanceAndVouchers() {
        boolean z11;
        requestCreditBalance();
        getVoucherEntryPointViewModel().getVouchersState().observe(this, new b(this));
        VoucherEntryPointViewModel voucherEntryPointViewModel = getVoucherEntryPointViewModel();
        if (Customer.getInstance() == null || !Customer.getInstance().isLoggedIn()) {
            z11 = false;
        } else {
            z11 = true;
        }
        voucherEntryPointViewModel.getVouchersState(z11);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadCreditBalanceAndVouchers$lambda-4  reason: not valid java name */
    public static final void m10646loadCreditBalanceAndVouchers$lambda4(UserAccountFragment userAccountFragment, VoucherStateDomainModel voucherStateDomainModel) {
        Intrinsics.checkNotNullParameter(userAccountFragment, "this$0");
        userAccountFragment.updateVoucherCounter(voucherStateDomainModel);
    }

    private final void loadPendingCcApplication() {
        getCobrandedCcViewModel().getWalletStatus().observe(getViewLifecycleOwner(), new a(this));
        getCobrandedCcViewModel().getCcPendingApplication();
    }

    /* access modifiers changed from: private */
    /* renamed from: loadPendingCcApplication$lambda-3  reason: not valid java name */
    public static final void m10647loadPendingCcApplication$lambda3(UserAccountFragment userAccountFragment, WalletStatus walletStatus) {
        boolean z11;
        Intrinsics.checkNotNullParameter(userAccountFragment, "this$0");
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        if (customerInfo != null) {
            String text = walletStatus.getText();
            if (text.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                text = TalabatFormatter.getInstance().getFormattedCurrency(customerInfo.talabatCredit);
            }
            customerInfo.talabatPayStatus = text;
            customerInfo.talabatCcIncomplete = walletStatus.getShouldShowNotification();
        }
        userAccountFragment.onCreditBalanceRefresh();
    }

    private final void loadRafSenderVoucherLabel() {
        if (isReferAFriendEnabled() && isUserLoggedIn()) {
            getSideMenuPresenter().onLoadRafSenderVoucherLabel();
        }
    }

    private final void navigateToBnplDashboard() {
        DeepLinkNavigator deepLinkNavigator2 = getDeepLinkNavigator();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator2, requireContext, "talabat://?s=bnpl-dashboard/side_menu", (Function0) null, 4, (Object) null);
    }

    private final void navigateToDeeplink(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserAccountFragment$navigateToDeeplink$1(this, str, (Continuation<? super UserAccountFragment$navigateToDeeplink$1>) null), 3, (Object) null);
    }

    private final void navigateToOnboarding() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserAccountFragment$navigateToOnboarding$1(this, new SubscriptionBenefitsDeeplinkBuilder().build(), (Continuation<? super UserAccountFragment$navigateToOnboarding$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void navigateToSubscriptionManagement() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserAccountFragment$navigateToSubscriptionManagement$1(this, new SubscriptionManagementDeeplinkBuilder().build(), (Continuation<? super UserAccountFragment$navigateToSubscriptionManagement$1>) null), 3, (Object) null);
    }

    private final void navigateToVoucherList() {
        IObservabilityManager.DefaultImpls.trackEvent$default(getObservabilityManager(), GrowthEvents.VOUCHER_LIST_MENU_ITEM_TAPPED.getValue(), EventType.GrowthEvents.name(), (Map) null, 4, (Object) null);
        DeepLinkNavigator deepLinkNavigator2 = getDeepLinkNavigator();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator2, requireContext, VouchersListDeeplinkBuilder.build$default(new VouchersListDeeplinkBuilder(), (String) null, (String) null, (String) null, false, false, 31, (Object) null), (Function0) null, 4, (Object) null);
    }

    private final void navigateToWallet() {
        if (isWalletDashboardFlutterEnabled()) {
            Navigator navigator2 = getNavigator();
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            Navigator.DefaultImpls.navigateTo$default(navigator2, requireContext, new FlutterScreen(new FlutterScreen.FlutterScreenData(CobrandedCreditCardFlutterScreenKt.PARAM_SOURCE_VALUE)), (Function1) null, 4, (Object) null);
            return;
        }
        Intent intent = new Intent(requireContext(), WalletDashboardActivity.class);
        intent.putExtra("extraDisableOpeningHome", true);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void onUpdateRenewalResult(boolean z11) {
        DSAlertType dSAlertType;
        int i11;
        if (z11) {
            dSAlertType = DSAlertType.SUCCESS;
        } else {
            dSAlertType = DSAlertType.ERROR;
        }
        if (z11) {
            i11 = R.string.tpro_reactivate_success;
        } else {
            i11 = R.string.tpro_reactivate_failure;
        }
        DSAlert dSAlert = this.renewalSuccessAlert;
        if (dSAlert == null) {
            Intrinsics.throwUninitializedPropertyAccessException("renewalSuccessAlert");
            dSAlert = null;
        }
        dSAlert.setAlertType(dSAlertType);
        dSAlert.setDescriptor(getString(i11));
        dSAlert.setIconButton(new DSIconButtonModel(R.drawable.ds_close, new UserAccountFragment$onUpdateRenewalResult$1$1(dSAlert)));
        dSAlert.setVisibility(0);
    }

    private final void removeBnplItem(List<SideMenuHeader> list) {
        if (!getFeatureFlagRepo().getFeatureFlag(PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_BNPL_DASHBOARD_ENABLED, false) || !isUserLoggedIn() || getFeatureFlagRepo().getFeatureFlag(OrderingFeatureFlagsKeys.LENDING_BNPL_HIDE_OPTION_ENABLED, false)) {
            removeSideMenuHeaderItem(list, "paylater");
        }
    }

    private final void removeDisabledSideMenuItems(List<SideMenuHeader> list) {
        if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId() || !isUserLoggedIn()) {
            removeSideMenuHeaderItem(list, ScreenNames.VOUCHERS_LIST);
        }
        if (!canShowSubscriptionList()) {
            removeSideMenuHeaderItem(list, "Subscriptions");
        }
        if (!isReferAFriendEnabled() || !isUserLoggedIn()) {
            removeSideMenuHeaderItem(list, SideMenuResource.REF_REFER_A_FRIEND);
        }
        if (!canShowSavingsBanner()) {
            removeSideMenuHeaderItem(list, "tProSavings");
        }
        if (!isUserLoggedIn()) {
            removeSideMenuHeaderItem(list, "talabatcredit");
        }
        removeSideMenuHeaderItem(list, "Home");
        removeBnplItem(list);
    }

    private final void removeSideMenuHeaderItem(List<SideMenuHeader> list, String str) {
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(list, new UserAccountFragment$removeSideMenuHeaderItem$1(str));
    }

    private final void requestCreditBalance() {
        Customer instance;
        datamodels.Country selectedCountry = TalabatUtils.getSelectedCountry(getConfigurationRepository(), getLocationConfigurationRepository());
        boolean featureFlag = getFeatureFlagRepo().getFeatureFlag(PayFeatureFlagConstants.INSTANCE.getWalletFeatureFwfKey(Integer.valueOf(GlobalDataModel.SelectedCountryId), ""), false);
        if (selectedCountry != null && selectedCountry.enableTalabtCredit && featureFlag) {
            Customer instance2 = Customer.getInstance();
            if (instance2 != null && instance2.isLoggedIn() && selectedCountry.f13845id > 0) {
                GlobalDataModel.APPBOYNOTIFICATION.mLastCreditLoadTime = SystemClock.elapsedRealtime();
                getSideMenuPresenter().onLoadTalabatCreditBalance();
            }
        } else if (GlobalDataModel.FunWithFlag.TalabatCreditRevampEnabled && (instance = Customer.getInstance()) != null && selectedCountry != null && selectedCountry.f13845id > 0 && instance.isLoggedIn()) {
            GlobalDataModel.APPBOYNOTIFICATION.mLastCreditLoadTime = SystemClock.elapsedRealtime();
            getSideMenuPresenter().onLoadTalabatCreditBalance();
        }
    }

    private final void setStatusBarColor() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.getWindow().setStatusBarColor(getResources().getColor(R.color.ds_neutral_white, requireActivity.getTheme()));
    }

    private final void setupSideMenuListView(View view) {
        View findViewById = view.findViewById(R.id.list_slidemenu_home);
        if (findViewById != null) {
            this.sideMenuRecyclerView = (RecyclerView) findViewById;
            View findViewById2 = view.findViewById(R.id.alert_renewal_update_success);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.a…t_renewal_update_success)");
            this.renewalSuccessAlert = (DSAlert) findViewById2;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    private final void trackHelpCenterClick() {
        String str;
        Customer instance = Customer.getInstance();
        UserAccountTracker userAccountTracker = getUserAccountTracker();
        CustomerInfo customerInfo = instance.getCustomerInfo();
        if (customerInfo != null) {
            str = customerInfo.encgid;
        } else {
            str = null;
        }
        userAccountTracker.trackHelpCenterClick(str, instance.getSelectedCustomerAddress());
    }

    private final void trackOptionClick(String str, String str2, String str3) {
        String str4;
        Customer instance = Customer.getInstance();
        UserAccountTracker userAccountTracker = getUserAccountTracker();
        CustomerInfo customerInfo = instance.getCustomerInfo();
        if (customerInfo != null) {
            str4 = customerInfo.encgid;
        } else {
            str4 = null;
        }
        userAccountTracker.trackNavigationOptionClick(str, str4, instance.getSelectedCustomerAddress(), str2, str3);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public final IAppLaunchTrackingManager getAppLaunchTrackingManager() {
        IAppLaunchTrackingManager iAppLaunchTrackingManager = this.appLaunchTrackingManager;
        if (iAppLaunchTrackingManager != null) {
            return iAppLaunchTrackingManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appLaunchTrackingManager");
        return null;
    }

    @NotNull
    public final CobrandedCcViewModelFactory getCobrandedCcViewModelFactory() {
        CobrandedCcViewModelFactory cobrandedCcViewModelFactory2 = this.cobrandedCcViewModelFactory;
        if (cobrandedCcViewModelFactory2 != null) {
            return cobrandedCcViewModelFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cobrandedCcViewModelFactory");
        return null;
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationRepository() {
        ConfigurationLocalRepository configurationLocalRepository = this.configurationRepository;
        if (configurationLocalRepository != null) {
            return configurationLocalRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationRepository");
        return null;
    }

    @NotNull
    public final CoroutineDispatchersFactory getCoroutineDispatchersFactory() {
        CoroutineDispatchersFactory coroutineDispatchersFactory2 = this.coroutineDispatchersFactory;
        if (coroutineDispatchersFactory2 != null) {
            return coroutineDispatchersFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineDispatchersFactory");
        return null;
    }

    @NotNull
    public final CustomerRepository getCustomerRepository() {
        CustomerRepository customerRepository2 = this.customerRepository;
        if (customerRepository2 != null) {
            return customerRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customerRepository");
        return null;
    }

    @NotNull
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @NotNull
    public final ITalabatExperiment getExperiment() {
        ITalabatExperiment iTalabatExperiment = this.experiment;
        if (iTalabatExperiment != null) {
            return iTalabatExperiment;
        }
        Intrinsics.throwUninitializedPropertyAccessException(InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT);
        return null;
    }

    @NotNull
    public final VoucherEntryPointViewModelFactory getFactory() {
        VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory = this.factory;
        if (voucherEntryPointViewModelFactory != null) {
            return voucherEntryPointViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepo() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepo;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepo");
        return null;
    }

    @NotNull
    public final GetOverdueUseCase getGetOverdueUseCase() {
        GetOverdueUseCase getOverdueUseCase2 = this.getOverdueUseCase;
        if (getOverdueUseCase2 != null) {
            return getOverdueUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getOverdueUseCase");
        return null;
    }

    @NotNull
    public final GetSavingsInfoUseCase getGetSubscriptionsSavingsInfo() {
        GetSavingsInfoUseCase getSavingsInfoUseCase = this.getSubscriptionsSavingsInfo;
        if (getSavingsInfoUseCase != null) {
            return getSavingsInfoUseCase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getSubscriptionsSavingsInfo");
        return null;
    }

    @NotNull
    public final IHelpCenterDeeplinkBuilder getHelpCenterDeeplinkBuilder() {
        IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder = this.helpCenterDeeplinkBuilder;
        if (iHelpCenterDeeplinkBuilder != null) {
            return iHelpCenterDeeplinkBuilder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("helpCenterDeeplinkBuilder");
        return null;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
    }

    @NotNull
    public final Navigator getNavigator() {
        Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @NotNull
    public final RxSchedulersFactory getSchedulersFactory() {
        RxSchedulersFactory rxSchedulersFactory = this.schedulersFactory;
        if (rxSchedulersFactory != null) {
            return rxSchedulersFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("schedulersFactory");
        return null;
    }

    @NotNull
    public final IScreenTracker getScreenTracker() {
        IScreenTracker iScreenTracker = this.screenTracker;
        if (iScreenTracker != null) {
            return iScreenTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("screenTracker");
        return null;
    }

    @NotNull
    public final SendNavigationOptionLoadedEventUseCase getSendNavigationOptionLoadedEventUsecase() {
        SendNavigationOptionLoadedEventUseCase sendNavigationOptionLoadedEventUseCase = this.sendNavigationOptionLoadedEventUsecase;
        if (sendNavigationOptionLoadedEventUseCase != null) {
            return sendNavigationOptionLoadedEventUseCase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sendNavigationOptionLoadedEventUsecase");
        return null;
    }

    @NotNull
    public final SideMenuPresenter getSideMenuPresenter() {
        SideMenuPresenter sideMenuPresenter2 = this.sideMenuPresenter;
        if (sideMenuPresenter2 != null) {
            return sideMenuPresenter2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sideMenuPresenter");
        return null;
    }

    @NotNull
    public final ISubscriptionStatusRepository getSubscriptionStatusRepository() {
        ISubscriptionStatusRepository iSubscriptionStatusRepository = this.subscriptionStatusRepository;
        if (iSubscriptionStatusRepository != null) {
            return iSubscriptionStatusRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionStatusRepository");
        return null;
    }

    @NotNull
    public final ISubscriptionsTracker getSubscriptionTracker() {
        ISubscriptionsTracker iSubscriptionsTracker = this.subscriptionTracker;
        if (iSubscriptionsTracker != null) {
            return iSubscriptionsTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionTracker");
        return null;
    }

    @NotNull
    public final ISubscriptionsFeatureFlagsRepository getSubscriptionsFeatureFlagRepo() {
        ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository = this.subscriptionsFeatureFlagRepo;
        if (iSubscriptionsFeatureFlagsRepository != null) {
            return iSubscriptionsFeatureFlagsRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionsFeatureFlagRepo");
        return null;
    }

    @NotNull
    public final TalabatTracker getTalabatTracker() {
        TalabatTracker talabatTracker2 = this.talabatTracker;
        if (talabatTracker2 != null) {
            return talabatTracker2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatTracker");
        return null;
    }

    @NotNull
    public final UpdateAutoRenewalUseCase getUpdateAutoRenewalUseCase() {
        UpdateAutoRenewalUseCase updateAutoRenewalUseCase2 = this.updateAutoRenewalUseCase;
        if (updateAutoRenewalUseCase2 != null) {
            return updateAutoRenewalUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("updateAutoRenewalUseCase");
        return null;
    }

    public void hideBnplOverdueNotification() {
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = this.sideMenuRecyclerViewAdapter;
        if (sideMenuRecyclerViewAdapter2 != null) {
            sideMenuRecyclerViewAdapter2.removeBnplNotificationsAndUpdateSideMenus();
        }
    }

    public final boolean isReferAFriendEnabled() {
        return isReferAFriendFlagEnabled() || isReferAFriendExperimentEnabled();
    }

    @NotNull
    public final IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase() {
        IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase2 = this.isUserBNPLEligibleUseCase;
        if (isUserBNPLEligibleUseCase2 != null) {
            return isUserBNPLEligibleUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("isUserBNPLEligibleUseCase");
        return null;
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 100 && isBnplOverdueNotificationEnabled()) {
            SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = this.sideMenuRecyclerViewAdapter;
            if (sideMenuRecyclerViewAdapter2 != null) {
                sideMenuRecyclerViewAdapter2.showBnplOverdueLoading();
            }
            getSideMenuPresenter().reloadBnplOverdue();
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ApiContainer apiContainer = AndroidComponentsKt.apiContainer((Fragment) this);
        FeatureFlagCoreLibApi featureFlagCoreLibApi = (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class);
        ExperimentCoreLibApi experimentCoreLibApi = (ExperimentCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ExperimentCoreLibApi.class);
        DaggerUserAccountFragmentComponent.factory().create((ContextCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ContextCoreLibApi.class), (BnplCoreFeatureApi) apiContainer.getFeature(BnplCoreFeatureApi.class), (ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (DeepLinkCoreLibApi) apiContainer.getFeature(DeepLinkCoreLibApi.class), featureFlagCoreLibApi, experimentCoreLibApi, (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SubscriptionsFeatureApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DispatcherCoreLibApi.class), (CustomerCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(CustomerCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NavigationCoreLibApi.class), (HelpCenterFeatureApi) apiContainer.getFeature(HelpCenterFeatureApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TrackingCoreLibApi.class), (WalletCobrandedCcFeatureApi) apiContainer.getFeature(WalletCobrandedCcFeatureApi.class)).inject(this);
        super.onAttach(context);
        getScreenTracker().startTrace(UserAccountScreenPerformanceParams.INSTANCE.createScreenTrackerParams());
    }

    public void onBackPressedFromFlutter() {
    }

    public void onBackPressedFromFlutter(@NotNull Object obj) {
        GlobalMethodChannelCallback.DefaultImpls.onBackPressedFromFlutter(this, obj);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "UserAccountFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "UserAccountFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_user_account, (ViewGroup) null, false);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onCreditBalanceRefresh() {
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = this.sideMenuRecyclerViewAdapter;
        if (sideMenuRecyclerViewAdapter2 != null) {
            sideMenuRecyclerViewAdapter2.stopCreditLoading();
        }
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter3 = this.sideMenuRecyclerViewAdapter;
        if (sideMenuRecyclerViewAdapter3 == null) {
            setSideMenu();
        } else if (sideMenuRecyclerViewAdapter3 != null) {
            sideMenuRecyclerViewAdapter3.notifyDataSetChanged();
        }
    }

    public void onDataError() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onNetworkError() {
    }

    public void onResume() {
        boolean z11;
        super.onResume();
        if (this.sideMenuRecyclerViewAdapter != null) {
            VoucherEntryPointViewModel voucherEntryPointViewModel = getVoucherEntryPointViewModel();
            if (Customer.getInstance() == null || !Customer.getInstance().isLoggedIn()) {
                z11 = false;
            } else {
                z11 = true;
            }
            voucherEntryPointViewModel.getVouchersState(z11);
            SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = this.sideMenuRecyclerViewAdapter;
            if (sideMenuRecyclerViewAdapter2 != null) {
                ((UserAccountRecyclerViewAdapter) sideMenuRecyclerViewAdapter2).refreshSavingsInfo();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.home.useraccount.UserAccountRecyclerViewAdapter");
        }
    }

    public void onServerError(@Nullable VolleyError volleyError) {
    }

    public void onSetBottomNavigation(boolean z11) {
        GlobalMethodChannelCallback.DefaultImpls.onSetBottomNavigation(this, z11);
    }

    public void onSideMenuLinkNavigation(@Nullable String str, @Nullable String str2) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a8, code lost:
        if (r15.equals(tracking.ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT) == false) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x017f, code lost:
        if (r15.equals("Wallet Dashboard screen") == false) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0187, code lost:
        if (isCobrandedApplicationIncomplete() == false) goto L_0x0191;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0189, code lost:
        trackOptionClick(tracking.ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT, "co_branded_card - application incomplete", "Application Incomplete");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0191, code lost:
        c(r14, tracking.ScreenNames.OPTIONS_SCREEN_TALABAT_CREDIT, (java.lang.String) null, (java.lang.String) null, 6, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x019b, code lost:
        navigateToWallet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSideMenuNavigation(@org.jetbrains.annotations.Nullable java.lang.String r15) {
        /*
            r14 = this;
            r0 = 0
            if (r15 == 0) goto L_0x024e
            int r1 = r15.hashCode()
            r2 = 0
            java.lang.String r3 = "Talabat Credit Options Screen"
            java.lang.String r4 = "disableSideMenu"
            r5 = 1
            switch(r1) {
                case -1564234843: goto L_0x01fb;
                case -1497443633: goto L_0x01c7;
                case -722687141: goto L_0x01a0;
                case -390281025: goto L_0x0179;
                case -84463992: goto L_0x016a;
                case 162378673: goto L_0x013f;
                case 400972179: goto L_0x00ee;
                case 664791359: goto L_0x00cf;
                case 735791969: goto L_0x00ac;
                case 843415560: goto L_0x00a4;
                case 1043408476: goto L_0x007d;
                case 1100650276: goto L_0x0054;
                case 1503638281: goto L_0x0039;
                case 1698881252: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x024e
        L_0x0012:
            java.lang.String r1 = "Notifications Screen"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x001c
            goto L_0x024e
        L_0x001c:
            java.lang.String r7 = "Notifications Screen"
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r14
            c(r6, r7, r8, r9, r10, r11)
            android.content.Intent r15 = new android.content.Intent
            android.content.Context r0 = r14.requireContext()
            java.lang.Class<com.talabat.appboy.Notifications> r1 = com.talabat.appboy.Notifications.class
            r15.<init>(r0, r1)
            r15.putExtra(r4, r5)
            r14.startActivity(r15)
            goto L_0x027b
        L_0x0039:
            java.lang.String r1 = "Settings Screen"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x0043
            goto L_0x024e
        L_0x0043:
            java.lang.String r3 = "Settings Screen"
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r14
            c(r2, r3, r4, r5, r6, r7)
            java.lang.String r15 = "talabat://?s=settings"
            r14.navigateToDeeplink(r15)
            goto L_0x027b
        L_0x0054:
            java.lang.String r1 = "rewards"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x005e
            goto L_0x024e
        L_0x005e:
            java.lang.String r3 = "Rewards"
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r14
            c(r2, r3, r4, r5, r6, r7)
            com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen$RewardsCatalogueOrigin r10 = com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen.RewardsCatalogueOrigin.ACCOUNT
            com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions$Companion r8 = com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions.Companion
            android.content.Context r9 = r14.requireContext()
            java.lang.String r15 = "requireContext()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r15)
            r11 = 0
            r12 = 4
            r13 = 0
            com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions.Companion.startLoyaltyDashboardActivity$default(r8, r9, r10, r11, r12, r13)
            goto L_0x027b
        L_0x007d:
            java.lang.String r1 = "Promotions Screen"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x0087
            goto L_0x024e
        L_0x0087:
            java.lang.String r7 = "Promotions Screen"
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r14
            c(r6, r7, r8, r9, r10, r11)
            android.content.Intent r15 = new android.content.Intent
            android.content.Context r0 = r14.requireContext()
            java.lang.Class<com.talabat.OffersListScreen> r1 = com.talabat.OffersListScreen.class
            r15.<init>(r0, r1)
            r15.putExtra(r4, r5)
            r14.startActivity(r15)
            goto L_0x027b
        L_0x00a4:
            boolean r1 = r15.equals(r3)
            if (r1 != 0) goto L_0x0183
            goto L_0x024e
        L_0x00ac:
            java.lang.String r1 = "experiment alert pay later dashboard"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x00b6
            goto L_0x024e
        L_0x00b6:
            java.lang.String r3 = "bnpl_missed_payment"
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r14
            c(r2, r3, r4, r5, r6, r7)
            com.talabat.talabatnavigation.Navigator$Companion r15 = com.talabat.talabatnavigation.Navigator.Companion
            java.lang.String r0 = "side_menu"
            r1 = 100
            com.talabat.talabatnavigation.base.NavigatorModelForResult r0 = r14.createNavigationToBNPLDashboard(r0, r1)
            r15.navigate((androidx.fragment.app.Fragment) r14, (com.talabat.talabatnavigation.base.NavigatorModelForResult) r0)
            goto L_0x027b
        L_0x00cf:
            java.lang.String r1 = "wallet_subscription_settings"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x00da
            goto L_0x024e
        L_0x00da:
            com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository r15 = r14.getSubscriptionStatusRepository()
            boolean r15 = r15.hasManagedSubscription()
            if (r15 == 0) goto L_0x00e9
            r14.navigateToSubscriptionManagement()
            goto L_0x027b
        L_0x00e9:
            r14.navigateToOnboarding()
            goto L_0x027b
        L_0x00ee:
            java.lang.String r1 = "Orders List Screen"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x00f8
            goto L_0x024e
        L_0x00f8:
            java.lang.String r7 = "Orders List Screen"
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r14
            c(r6, r7, r8, r9, r10, r11)
            com.talabat.core.experiment.domain.ITalabatExperiment r15 = r14.getExperiment()
            com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageExperimentsKeys r1 = com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageExperimentsKeys.FLUTTER_ORDERS_LIST
            java.lang.String r2 = ""
            com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy r3 = com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy.FWF
            java.lang.String r15 = r15.getStringVariant(r1, r2, r3)
            java.lang.String r1 = "Variation1"
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r1)
            if (r15 == 0) goto L_0x012c
            androidx.lifecycle.LifecycleCoroutineScope r6 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r14)
            r7 = 0
            r8 = 0
            com.talabat.home.useraccount.UserAccountFragment$onSideMenuNavigation$1 r9 = new com.talabat.home.useraccount.UserAccountFragment$onSideMenuNavigation$1
            java.lang.String r15 = "talabat://?s=orders-list"
            r9.<init>(r14, r15, r0)
            r10 = 3
            r11 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            goto L_0x027b
        L_0x012c:
            android.content.Intent r15 = new android.content.Intent
            android.content.Context r0 = r14.requireContext()
            java.lang.Class<com.talabat.OrderListScreen> r1 = com.talabat.OrderListScreen.class
            r15.<init>(r0, r1)
            r15.putExtra(r4, r5)
            r14.startActivity(r15)
            goto L_0x027b
        L_0x013f:
            java.lang.String r1 = "Live Support Screen"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x0149
            goto L_0x024e
        L_0x0149:
            r14.trackHelpCenterClick()
            com.talabat.core.deeplink.domain.DeepLinkNavigator r2 = r14.getDeepLinkNavigator()
            androidx.fragment.app.FragmentActivity r3 = r14.requireActivity()
            java.lang.String r15 = "requireActivity()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r15)
            com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder r15 = r14.getHelpCenterDeeplinkBuilder()
            r1 = 3
            java.lang.String r4 = com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder.DefaultImpls.build$default(r15, r0, r0, r1, r0)
            r5 = 0
            r6 = 4
            r7 = 0
            com.talabat.core.deeplink.domain.DeepLinkNavigator.DefaultImpls.navigateTo$default(r2, r3, r4, r5, r6, r7)
            goto L_0x027b
        L_0x016a:
            java.lang.String r1 = "pay later dashboard"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x0174
            goto L_0x024e
        L_0x0174:
            r14.navigateToBnplDashboard()
            goto L_0x027b
        L_0x0179:
            java.lang.String r1 = "Wallet Dashboard screen"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x0183
            goto L_0x024e
        L_0x0183:
            boolean r15 = r14.isCobrandedApplicationIncomplete()
            if (r15 == 0) goto L_0x0191
            java.lang.String r15 = "co_branded_card - application incomplete"
            java.lang.String r0 = "Application Incomplete"
            r14.trackOptionClick(r3, r15, r0)
            goto L_0x019b
        L_0x0191:
            java.lang.String r5 = "Talabat Credit Options Screen"
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r14
            c(r4, r5, r6, r7, r8, r9)
        L_0x019b:
            r14.navigateToWallet()
            goto L_0x027b
        L_0x01a0:
            java.lang.String r1 = "About us Screen"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x01aa
            goto L_0x024e
        L_0x01aa:
            java.lang.String r7 = "About us Screen"
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r14
            c(r6, r7, r8, r9, r10, r11)
            android.content.Intent r15 = new android.content.Intent
            android.content.Context r0 = r14.requireContext()
            java.lang.Class<com.talabat.AboutUsScreen> r1 = com.talabat.AboutUsScreen.class
            r15.<init>(r0, r1)
            r15.putExtra(r4, r5)
            r14.startActivity(r15)
            goto L_0x027b
        L_0x01c7:
            java.lang.String r1 = "Refer A Friend Screen"
            boolean r1 = r15.equals(r1)
            if (r1 != 0) goto L_0x01d1
            goto L_0x024e
        L_0x01d1:
            java.lang.String r4 = "Refer a Friend"
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            r3 = r14
            c(r3, r4, r5, r6, r7, r8)
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r15 = r14.getFeatureFlagRepo()
            com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys r0 = com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys.INCENTIVES_REFER_A_FRIEND_NEW_PACKAGE
            boolean r15 = r15.getFeatureFlag(r0, r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "talabat://?s=refer-a-friend/sender?isNewRAFSenderEnabled="
            r0.append(r1)
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            r14.navigateToDeeplink(r15)
            goto L_0x027b
        L_0x01fb:
            java.lang.String r1 = "Vouchers"
            boolean r3 = r15.equals(r1)
            if (r3 != 0) goto L_0x0204
            goto L_0x024e
        L_0x0204:
            com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel r15 = r14.getVoucherEntryPointViewModel()
            androidx.lifecycle.LiveData r15 = r15.getVouchersState()
            java.lang.Object r15 = r15.getValue()
            library.talabat.mvp.home.VoucherStateDomainModel r15 = (library.talabat.mvp.home.VoucherStateDomainModel) r15
            if (r15 == 0) goto L_0x0219
            java.lang.String r3 = r15.getNotificationLabel()
            goto L_0x021a
        L_0x0219:
            r3 = r0
        L_0x021a:
            if (r3 == 0) goto L_0x0222
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r3)
            if (r3 == 0) goto L_0x0223
        L_0x0222:
            r2 = r5
        L_0x0223:
            if (r2 == 0) goto L_0x0227
            r2 = r0
            goto L_0x023a
        L_0x0227:
            if (r15 == 0) goto L_0x022e
            library.talabat.mvp.home.VoucherNotificationStyle r2 = r15.getNotificationStyle()
            goto L_0x022f
        L_0x022e:
            r2 = r0
        L_0x022f:
            library.talabat.mvp.home.VoucherNotificationStyle r3 = library.talabat.mvp.home.VoucherNotificationStyle.WARNING
            if (r2 != r3) goto L_0x0237
            java.lang.String r2 = "voucher - expiring"
            goto L_0x023a
        L_0x0237:
            java.lang.String r2 = "voucher - unused"
        L_0x023a:
            if (r15 == 0) goto L_0x0240
            java.lang.String r0 = r15.getNotificationLabel()
        L_0x0240:
            r14.trackOptionClick(r1, r2, r0)
            com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel r15 = r14.getVoucherEntryPointViewModel()
            r15.clearVouchersState()
            r14.navigateToVoucherList()
            goto L_0x027b
        L_0x024e:
            com.talabat.core.observabilityNew.domain.IObservabilityManager r1 = r14.getObservabilityManager()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Account page - ScreenName not handled: "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r3 = 2
            com.talabat.core.observabilityNew.domain.IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(r1, r2, r0, r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ScreenName not handled: "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            com.talabat.talabatcore.logger.LogManager.info(r15)
        L_0x027b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.home.useraccount.UserAccountFragment.onSideMenuNavigation(java.lang.String):void");
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupSideMenuListView(view);
        GlobalConstants.SettingSelection = "";
        setStatusBarColor();
        ConfigurationLocalRepository configurationRepository2 = getConfigurationRepository();
        GetOverdueUseCase getOverdueUseCase2 = getGetOverdueUseCase();
        IObservabilityManager observabilityManager2 = getObservabilityManager();
        Scheduler io2 = getSchedulersFactory().io();
        Scheduler main = getSchedulersFactory().main();
        SendNavigationOptionLoadedEventUseCase sendNavigationOptionLoadedEventUsecase2 = getSendNavigationOptionLoadedEventUsecase();
        IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase2 = isUserBNPLEligibleUseCase();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        setSideMenuPresenter(new SideMenuPresenter(this, configurationRepository2, getOverdueUseCase2, observabilityManager2, io2, main, sendNavigationOptionLoadedEventUsecase2, isUserBNPLEligibleUseCase2, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner)));
        getSideMenuPresenter().setSideMenu();
    }

    public final void setAppLaunchTrackingManager(@NotNull IAppLaunchTrackingManager iAppLaunchTrackingManager) {
        Intrinsics.checkNotNullParameter(iAppLaunchTrackingManager, "<set-?>");
        this.appLaunchTrackingManager = iAppLaunchTrackingManager;
    }

    public final void setCobrandedCcViewModelFactory(@NotNull CobrandedCcViewModelFactory cobrandedCcViewModelFactory2) {
        Intrinsics.checkNotNullParameter(cobrandedCcViewModelFactory2, "<set-?>");
        this.cobrandedCcViewModelFactory = cobrandedCcViewModelFactory2;
    }

    public final void setConfigurationRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "<set-?>");
        this.configurationRepository = configurationLocalRepository;
    }

    public final void setCoroutineDispatchersFactory(@NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "<set-?>");
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    public final void setCustomerRepository(@NotNull CustomerRepository customerRepository2) {
        Intrinsics.checkNotNullParameter(customerRepository2, "<set-?>");
        this.customerRepository = customerRepository2;
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setExperiment(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "<set-?>");
        this.experiment = iTalabatExperiment;
    }

    public final void setFactory(@NotNull VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory) {
        Intrinsics.checkNotNullParameter(voucherEntryPointViewModelFactory, "<set-?>");
        this.factory = voucherEntryPointViewModelFactory;
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void setGetOverdueUseCase(@NotNull GetOverdueUseCase getOverdueUseCase2) {
        Intrinsics.checkNotNullParameter(getOverdueUseCase2, "<set-?>");
        this.getOverdueUseCase = getOverdueUseCase2;
    }

    public final void setGetSubscriptionsSavingsInfo(@NotNull GetSavingsInfoUseCase getSavingsInfoUseCase) {
        Intrinsics.checkNotNullParameter(getSavingsInfoUseCase, "<set-?>");
        this.getSubscriptionsSavingsInfo = getSavingsInfoUseCase;
    }

    public final void setHelpCenterDeeplinkBuilder(@NotNull IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        Intrinsics.checkNotNullParameter(iHelpCenterDeeplinkBuilder, "<set-?>");
        this.helpCenterDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setSchedulersFactory(@NotNull RxSchedulersFactory rxSchedulersFactory) {
        Intrinsics.checkNotNullParameter(rxSchedulersFactory, "<set-?>");
        this.schedulersFactory = rxSchedulersFactory;
    }

    public final void setScreenTracker(@NotNull IScreenTracker iScreenTracker) {
        Intrinsics.checkNotNullParameter(iScreenTracker, "<set-?>");
        this.screenTracker = iScreenTracker;
    }

    public final void setSendNavigationOptionLoadedEventUsecase(@NotNull SendNavigationOptionLoadedEventUseCase sendNavigationOptionLoadedEventUseCase) {
        Intrinsics.checkNotNullParameter(sendNavigationOptionLoadedEventUseCase, "<set-?>");
        this.sendNavigationOptionLoadedEventUsecase = sendNavigationOptionLoadedEventUseCase;
    }

    public void setSideMenu() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ArrayList<SideMenuHeader> createSideMenuItems = SideMenuFactory.createSideMenuItems(GlobalDataModel.JSON.sideMenuSection, GlobalDataModel.JSON.sideMenuSectionLinks, requireContext, getConfigurationRepository().selectedCountry());
        Intrinsics.checkNotNullExpressionValue(createSideMenuItems, "createSideMenuItems(\n   …lectedCountry()\n        )");
        List mutableList = CollectionsKt___CollectionsKt.toMutableList(createSideMenuItems);
        removeDisabledSideMenuItems(mutableList);
        addTProBanner(mutableList);
        UserAccountFragment$createLinearLayoutManager$1 createLinearLayoutManager = createLinearLayoutManager(requireContext);
        RecyclerView recyclerView = this.sideMenuRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sideMenuRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(createLinearLayoutManager);
        ArrayList<SidemenuExpandableListItem> menuExpandableList = SideMenuFactory.getMenuExpandableList(new ArrayList(mutableList));
        ConfigurationLocalRepository configurationRepository2 = getConfigurationRepository();
        LocationConfigurationRepository locationConfigurationRepository2 = getLocationConfigurationRepository();
        UserAccountFragment$setSideMenu$1 userAccountFragment$setSideMenu$1 = r11;
        UserAccountFragment$setSideMenu$1 userAccountFragment$setSideMenu$12 = new UserAccountFragment$setSideMenu$1(this, createLinearLayoutManager);
        Intrinsics.checkNotNullExpressionValue(menuExpandableList, "sideMenuExpandableListItems");
        Country selectedCountry = getConfigurationRepository().selectedCountry();
        ITalabatFeatureFlag featureFlagRepo2 = getFeatureFlagRepo();
        ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlagRepo2 = getSubscriptionsFeatureFlagRepo();
        ISubscriptionStatusRepository subscriptionStatusRepository2 = getSubscriptionStatusRepository();
        ISubscriptionsTracker subscriptionTracker2 = getSubscriptionTracker();
        IAppLaunchTrackingManager appLaunchTrackingManager2 = getAppLaunchTrackingManager();
        IObservabilityManager observabilityManager2 = getObservabilityManager();
        GetSavingsInfoUseCase getSubscriptionsSavingsInfo2 = getGetSubscriptionsSavingsInfo();
        UpdateAutoRenewalUseCase updateAutoRenewalUseCase2 = getUpdateAutoRenewalUseCase();
        CoroutineDispatchersFactory coroutineDispatchersFactory2 = getCoroutineDispatchersFactory();
        CustomerRepository customerRepository2 = getCustomerRepository();
        DeepLinkNavigator deepLinkNavigator2 = getDeepLinkNavigator();
        UserAccountFragment$setSideMenu$2 userAccountFragment$setSideMenu$2 = r1;
        UserAccountFragment$setSideMenu$2 userAccountFragment$setSideMenu$22 = new UserAccountFragment$setSideMenu$2(this);
        UserAccountFragment$setSideMenu$3 userAccountFragment$setSideMenu$3 = r1;
        UserAccountFragment$setSideMenu$3 userAccountFragment$setSideMenu$32 = new UserAccountFragment$setSideMenu$3(this);
        this.sideMenuRecyclerViewAdapter = new UserAccountRecyclerViewAdapter(configurationRepository2, locationConfigurationRepository2, userAccountFragment$setSideMenu$1, menuExpandableList, true, selectedCountry, featureFlagRepo2, subscriptionsFeatureFlagRepo2, subscriptionStatusRepository2, subscriptionTracker2, appLaunchTrackingManager2, observabilityManager2, getSubscriptionsSavingsInfo2, updateAutoRenewalUseCase2, coroutineDispatchersFactory2, customerRepository2, deepLinkNavigator2, userAccountFragment$setSideMenu$2, userAccountFragment$setSideMenu$3);
        loadCreditBalanceAndVouchers();
        loadPendingCcApplication();
        RecyclerView recyclerView3 = this.sideMenuRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sideMenuRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(this.sideMenuRecyclerViewAdapter);
        loadBnplOverdue();
        loadRafSenderVoucherLabel();
        checkIsUserBNPLEligible();
    }

    public final void setSideMenuPresenter(@NotNull SideMenuPresenter sideMenuPresenter2) {
        Intrinsics.checkNotNullParameter(sideMenuPresenter2, "<set-?>");
        this.sideMenuPresenter = sideMenuPresenter2;
    }

    public final void setSubscriptionStatusRepository(@NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "<set-?>");
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }

    public final void setSubscriptionTracker(@NotNull ISubscriptionsTracker iSubscriptionsTracker) {
        Intrinsics.checkNotNullParameter(iSubscriptionsTracker, "<set-?>");
        this.subscriptionTracker = iSubscriptionsTracker;
    }

    public final void setSubscriptionsFeatureFlagRepo(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "<set-?>");
        this.subscriptionsFeatureFlagRepo = iSubscriptionsFeatureFlagsRepository;
    }

    public final void setTalabatTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "<set-?>");
        this.talabatTracker = talabatTracker2;
    }

    public final void setUpdateAutoRenewalUseCase(@NotNull UpdateAutoRenewalUseCase updateAutoRenewalUseCase2) {
        Intrinsics.checkNotNullParameter(updateAutoRenewalUseCase2, "<set-?>");
        this.updateAutoRenewalUseCase = updateAutoRenewalUseCase2;
    }

    public final void setUserBNPLEligibleUseCase(@NotNull IsUserBNPLEligibleUseCase isUserBNPLEligibleUseCase2) {
        Intrinsics.checkNotNullParameter(isUserBNPLEligibleUseCase2, "<set-?>");
        this.isUserBNPLEligibleUseCase = isUserBNPLEligibleUseCase2;
    }

    public void showBNPLOption() {
        if (getFeatureFlagRepo().getFeatureFlag(OrderingFeatureFlagsKeys.LENDING_BNPL_HIDE_OPTION_ENABLED, false)) {
            SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = this.sideMenuRecyclerViewAdapter;
            if (sideMenuRecyclerViewAdapter2 != null) {
                SideMenuHeader sideMenuHeader = new SideMenuHeader();
                sideMenuHeader.setRef("paylater");
                sideMenuHeader.setTitle(getString(R.string.pay_later));
                sideMenuRecyclerViewAdapter2.showBnplOption(new SidemenuExpandableListItem(sideMenuHeader, 10));
            }
            loadBnplOverdue();
        }
    }

    public void showBnplOverdueNotification(double d11) {
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = this.sideMenuRecyclerViewAdapter;
        if (sideMenuRecyclerViewAdapter2 != null) {
            sideMenuRecyclerViewAdapter2.showBnplOverdueNotification((float) d11);
        }
    }

    public void startLodingPopup() {
    }

    public void stopLodingPopup() {
    }

    public void updateRafVoucherLabel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "rafSenderVoucherLabel");
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = this.sideMenuRecyclerViewAdapter;
        if (sideMenuRecyclerViewAdapter2 != null) {
            sideMenuRecyclerViewAdapter2.updateRafSenderVoucherLabel(str);
        }
    }

    public void updateVoucherCounter(@Nullable VoucherStateDomainModel voucherStateDomainModel) {
        if (this.sideMenuRecyclerViewAdapter == null) {
            setSideMenu();
        }
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter2 = this.sideMenuRecyclerViewAdapter;
        if (sideMenuRecyclerViewAdapter2 != null) {
            sideMenuRecyclerViewAdapter2.stopCreditLoading();
        }
        new VouchersNotificationBadgeTracker(getTalabatTracker()).trackVouchersNotificationBadgeLoaded(VoucherBadgeEventSource.ACCOUNT, voucherStateDomainModel);
        SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter3 = this.sideMenuRecyclerViewAdapter;
        if (sideMenuRecyclerViewAdapter3 != null) {
            sideMenuRecyclerViewAdapter3.updateUSerActiveVoucherCount(voucherStateDomainModel);
        }
    }
}
