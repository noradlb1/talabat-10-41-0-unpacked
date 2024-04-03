package com.talabat.darkstores.feature.home;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;
import com.integration.nfv.observability.NfvObservabilityHandler;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.entity.QCommerceScreenTracingNames;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.core.ui.lifecycle.SingleLiveEvent;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.common.base.BaseViewModel;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.darkstores.model.BannersResponse;
import com.talabat.darkstores.data.discovery.model.FeedMultiListData;
import com.talabat.darkstores.data.discovery.model.ImageUrl;
import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.data.tracking.HomeTracker;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.impression.TrackingData;
import com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker;
import com.talabat.darkstores.domain.common.BuildBannerCampaignProductListingNavigationUseCase;
import com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildLifestyleSearchResultNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildSwimlanesSearchResultNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildTalabatAiNavigationActionUseCase;
import com.talabat.darkstores.domain.common.BuildVoucherDetailsNavigationUseCase;
import com.talabat.darkstores.domain.common.BuildVoucherProductListingNavigationUseCase;
import com.talabat.darkstores.feature.Darkstores;
import com.talabat.darkstores.feature.checkout.DarkstoresListener;
import com.talabat.darkstores.feature.home.HomeFragmentDirections;
import com.talabat.darkstores.feature.home.banner.BannerView;
import com.talabat.darkstores.feature.home.usecase.GetVendorLightningOptimizationExpVariantUseCase;
import com.talabat.darkstores.feature.home.usecase.IsVLPLoadTimeTrackingEnabledUseCase;
import com.talabat.darkstores.feature.home.usecase.IsVendorLightningOptimizationEnabledUseCase;
import com.talabat.darkstores.feature.home.usecase.ShouldShowTalabatAiEntryPointUseCase;
import com.talabat.darkstores.feature.observability.DarkStoreObservabilityTracker;
import com.talabat.darkstores.feature.observability.PerformanceAttribute;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.darkstores.feature.tracking.data.ProductDetails;
import com.talabat.darkstores.feature.tracking.data.ShopDetails;
import com.talabat.darkstores.feature.tracking.data.ShopDetailsCategory;
import com.talabat.darkstores.feature.tracking.data.ShopDetailsSubCategory;
import com.talabat.darkstores.feature.tracking.data.ShopDetailsSwimlane;
import com.talabat.darkstores.model.Banner;
import com.talabat.darkstores.model.Category;
import com.talabat.darkstores.model.SubCategory;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.darkstores.model.viewstate.TproBannerViewState;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import com.talabat.wrapper.EventWrapper;
import com.tekartik.sqflite.Constant;
import datamodels.Restaurant;
import dj.t;
import dj.u;
import dj.v;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ò\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0002\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'\u0012\b\b\u0001\u0010(\u001a\u00020'\u0012\b\b\u0001\u0010)\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020+\u0012\u0006\u0010,\u001a\u00020-\u0012\u0006\u0010.\u001a\u00020/\u0012\u0006\u00100\u001a\u000201\u0012\u0006\u00102\u001a\u000203\u0012\u0006\u00104\u001a\u000205\u0012\u0006\u00106\u001a\u000207\u0012\u0006\u00108\u001a\u000209\u0012\u0006\u0010:\u001a\u00020;\u0012\u0006\u0010<\u001a\u00020=¢\u0006\u0002\u0010>J\u0006\u0010~\u001a\u00020TJ\u0006\u0010\u001a\u00020TJ\u0019\u0010\u0001\u001a\u00020T2\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010LH\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020d2\b\u0010\u0001\u001a\u00030\u0001H\u0002J3\u0010\u0001\u001a\u001c\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010L\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010L0x2\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010LH\u0002J\u0007\u0010\u0001\u001a\u00020'J\u001b\u0010\u0001\u001a\u00020d2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J\u001b\u0010\u0001\u001a\u00020d2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J\u0007\u0010\u0001\u001a\u00020'J3\u0010\u0001\u001a\u00020d2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0016\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002JW\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\u001d\u0010\u0001\u001a\u0018\u0012\u0005\u0012\u00030\u0001\u0012\u0005\u0012\u00030\u0001\u0012\u0005\u0012\u00030\u00010\u00012\u0018\u0010 \u0001\u001a\u0013\u0012\u0007\u0012\u0005\u0018\u00010\u0001\u0012\u0005\u0012\u00030\u00010¡\u0001J\u0007\u0010¢\u0001\u001a\u00020TJ\u0014\u0010£\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001J\u0013\u0010¤\u0001\u001a\u00030\u00012\u0007\u0010¥\u0001\u001a\u00020dH\u0002J&\u0010¦\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010§\u0001\u001a\u00030\u00012\b\u0010¨\u0001\u001a\u00030\u0001J\u0007\u0010©\u0001\u001a\u00020TJ\u0012\u0010ª\u0001\u001a\u00030\u00012\b\u0010«\u0001\u001a\u00030¬\u0001J%\u0010­\u0001\u001a\u00030\u00012\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010°\u0001\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020HJ(\u0010²\u0001\u001a\u00030\u00012\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010L2\u000e\u0010³\u0001\u001a\t\u0012\u0005\u0012\u00030´\u00010LJ%\u0010µ\u0001\u001a\u00030\u00012\b\u0010¶\u0001\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020H2\b\u0010·\u0001\u001a\u00030¸\u0001J\b\u0010¹\u0001\u001a\u00030\u0001J\b\u0010º\u0001\u001a\u00030\u0001J\u001c\u0010»\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J\u001c\u0010¼\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J\u001c\u0010½\u0001\u001a\u00030\u00012\b\u0010¾\u0001\u001a\u00030¿\u00012\b\u0010®\u0001\u001a\u00030¿\u0001J\u001c\u0010À\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001J\b\u0010Á\u0001\u001a\u00030\u0001J\b\u0010Â\u0001\u001a\u00030\u0001J\b\u0010Ã\u0001\u001a\u00030\u0001J\u001c\u0010Ä\u0001\u001a\u00030\u00012\b\u0010³\u0001\u001a\u00030´\u00012\b\u0010·\u0001\u001a\u00030Å\u0001J\b\u0010Æ\u0001\u001a\u00030\u0001J\b\u0010Ç\u0001\u001a\u00030\u0001J\u0018\u0010È\u0001\u001a\u00030\u00012\u000e\u0010É\u0001\u001a\t\u0012\u0005\u0012\u00030Ê\u00010LJ&\u0010Ë\u0001\u001a\u00030\u00012\b\u0010¾\u0001\u001a\u00030¿\u00012\b\u0010®\u0001\u001a\u00030¿\u00012\b\u0010Ì\u0001\u001a\u00030Í\u0001J\u001c\u0010Î\u0001\u001a\u00030\u00012\b\u0010Ï\u0001\u001a\u00030Ð\u00012\b\u0010Ñ\u0001\u001a\u00030Ò\u0001J\u0007\u0010Ó\u0001\u001a\u00020TJ\u0007\u0010Ô\u0001\u001a\u00020TJ\u0007\u0010Õ\u0001\u001a\u00020TJ\u0019\u0010Ö\u0001\u001a\u00020T2\u0007\u0010×\u0001\u001a\u00020T2\u0007\u0010Ø\u0001\u001a\u00020TJ\u0019\u0010Ù\u0001\u001a\u00020T2\u0007\u0010×\u0001\u001a\u00020T2\u0007\u0010Ø\u0001\u001a\u00020TJ\u0019\u0010Ú\u0001\u001a\u00020T2\u0007\u0010×\u0001\u001a\u00020T2\u0007\u0010Ø\u0001\u001a\u00020TJ\b\u0010Û\u0001\u001a\u00030\u0001J\b\u0010Ü\u0001\u001a\u00030\u0001J\u0007\u0010Ý\u0001\u001a\u00020TJ,\u0010Þ\u0001\u001a\u00030\u00012\b\u0010¶\u0001\u001a\u00030\u00012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\b\u0002\u0010ß\u0001\u001a\u00030\u0001J'\u0010à\u0001\u001a\u00030\u00012\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010°\u0001\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020HH\u0002J%\u0010á\u0001\u001a\u00030\u00012\b\u0010®\u0001\u001a\u00030¯\u00012\b\u0010°\u0001\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020HJ\u001d\u0010â\u0001\u001a\u00030\u00012\b\u0010¶\u0001\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020HH\u0002J\u001e\u0010ã\u0001\u001a\u00030\u00012\b\u0010ä\u0001\u001a\u00030\u00012\b\u0010å\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010æ\u0001\u001a\u00030\u00012\n\b\u0002\u0010ç\u0001\u001a\u00030è\u0001J\u001c\u0010é\u0001\u001a\u00030\u00012\b\u0010ê\u0001\u001a\u00030\u00012\b\u0010·\u0001\u001a\u00030\u0001J\n\u0010ë\u0001\u001a\u00030\u0001H\u0002J%\u0010ì\u0001\u001a\u00030\u00012\b\u0010ê\u0001\u001a\u00030\u00012\u0007\u0010±\u0001\u001a\u00020H2\b\u0010í\u0001\u001a\u00030\u0001J\"\u0010î\u0001\u001a\u00030\u00012\b\u0010ê\u0001\u001a\u00030\u00012\u000e\u0010ï\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010LJ\b\u0010ð\u0001\u001a\u00030\u0001J\n\u0010ñ\u0001\u001a\u00030\u0001H\u0002J\u000f\u0010ò\u0001\u001a\u00030\u0001*\u00030ó\u0001H\u0002R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020F0EX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020H0EX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u001d\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0L0@¢\u0006\b\n\u0000\u001a\u0004\bN\u0010CR\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010S\u001a\u00020TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010U\"\u0004\bV\u0010WR\u000e\u0010X\u001a\u00020TX\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0L0ZX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010[\u001a\u0010\u0012\f\u0012\n \\*\u0004\u0018\u00010T0T0ZX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020^0ZX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020a0`X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0@¢\u0006\b\n\u0000\u001a\u0004\be\u0010CR\u001a\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0c0ZX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010g\u001a\u00020h8F¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0014\u0010k\u001a\b\u0012\u0004\u0012\u00020l0EX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010o\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020q0p0@¢\u0006\b\n\u0000\u001a\u0004\br\u0010CR\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010s\u001a\b\u0012\u0004\u0012\u00020T0@¢\u0006\b\n\u0000\u001a\u0004\bt\u0010CR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010u\u001a\b\u0012\u0004\u0012\u00020^0@¢\u0006\b\n\u0000\u001a\u0004\bv\u0010CR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R#\u0010w\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020T0x0@¢\u0006\b\n\u0000\u001a\u0004\bz\u0010CR \u0010{\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020y\u0012\u0004\u0012\u00020T0x0ZX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010|\u001a\b\u0012\u0004\u0012\u00020a0@¢\u0006\b\n\u0000\u001a\u0004\b}\u0010C¨\u0006ô\u0001"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragmentViewModel;", "Lcom/talabat/darkstores/common/base/BaseViewModel;", "cartController", "Lcom/talabat/darkstores/feature/cart/CartController;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "tracker", "Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "homeTracker", "Lcom/talabat/darkstores/data/tracking/HomeTracker;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "subscriptionsFlagsRepo", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "ioScheduler", "Lio/reactivex/Scheduler;", "buildSearchNavigationAction", "Lcom/talabat/darkstores/domain/common/BuildSearchNavigationActionUseCase;", "buildTalabatAiNavigationActionUseCase", "Lcom/talabat/darkstores/domain/common/BuildTalabatAiNavigationActionUseCase;", "listener", "Lcom/talabat/darkstores/feature/checkout/DarkstoresListener;", "shouldShowTalabatAiEntryPointUseCase", "Lcom/talabat/darkstores/feature/home/usecase/ShouldShowTalabatAiEntryPointUseCase;", "vendorLandingFeedUseCase", "Lcom/talabat/darkstores/feature/home/VendorLandingFeedUseCase;", "buildCategoryProductsNavigationAction", "Lcom/talabat/darkstores/domain/common/BuildCategoryProductsNavigationActionUseCase;", "productImpressionTracker", "Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "smallBannerProductTracker", "heroBannerProductTracker", "buildSwimlanesSearchResultNavigationActionUseCase", "Lcom/talabat/darkstores/domain/common/BuildSwimlanesSearchResultNavigationActionUseCase;", "buildLifestyleSearchNavigationActionUseCase", "Lcom/talabat/darkstores/domain/common/BuildLifestyleSearchResultNavigationActionUseCase;", "darkStoreObservabilityTracker", "Lcom/talabat/darkstores/feature/observability/DarkStoreObservabilityTracker;", "isVLPLoadTimeTrackingEnabledUseCase", "Lcom/talabat/darkstores/feature/home/usecase/IsVLPLoadTimeTrackingEnabledUseCase;", "getVendorLightningOptimizationExpVariant", "Lcom/talabat/darkstores/feature/home/usecase/GetVendorLightningOptimizationExpVariantUseCase;", "isVendorLightningOptimizationEnabledUseCase", "Lcom/talabat/darkstores/feature/home/usecase/IsVendorLightningOptimizationEnabledUseCase;", "swimlanesTracker", "Lcom/talabat/darkstores/data/tracking/product/swimlanes/SwimlanesTracker;", "buildVoucherDetailsNavigationUseCase", "Lcom/talabat/darkstores/domain/common/BuildVoucherDetailsNavigationUseCase;", "buildVoucherProductListingNavigationUseCase", "Lcom/talabat/darkstores/domain/common/BuildVoucherProductListingNavigationUseCase;", "buildBannerCampaignProductListingNavigationUseCase", "Lcom/talabat/darkstores/domain/common/BuildBannerCampaignProductListingNavigationUseCase;", "(Lcom/talabat/darkstores/feature/cart/CartController;Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/core/observabilityNew/domain/IScreenTracker;Lcom/talabat/customer/domain/CustomerRepository;Lio/reactivex/disposables/CompositeDisposable;Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;Lcom/talabat/darkstores/data/tracking/HomeTracker;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;Lcom/talabat/darkstores/data/ConfigurationParameters;Lio/reactivex/Scheduler;Lcom/talabat/darkstores/domain/common/BuildSearchNavigationActionUseCase;Lcom/talabat/darkstores/domain/common/BuildTalabatAiNavigationActionUseCase;Lcom/talabat/darkstores/feature/checkout/DarkstoresListener;Lcom/talabat/darkstores/feature/home/usecase/ShouldShowTalabatAiEntryPointUseCase;Lcom/talabat/darkstores/feature/home/VendorLandingFeedUseCase;Lcom/talabat/darkstores/domain/common/BuildCategoryProductsNavigationActionUseCase;Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;Lcom/talabat/darkstores/domain/common/BuildSwimlanesSearchResultNavigationActionUseCase;Lcom/talabat/darkstores/domain/common/BuildLifestyleSearchResultNavigationActionUseCase;Lcom/talabat/darkstores/feature/observability/DarkStoreObservabilityTracker;Lcom/talabat/darkstores/feature/home/usecase/IsVLPLoadTimeTrackingEnabledUseCase;Lcom/talabat/darkstores/feature/home/usecase/GetVendorLightningOptimizationExpVariantUseCase;Lcom/talabat/darkstores/feature/home/usecase/IsVendorLightningOptimizationEnabledUseCase;Lcom/talabat/darkstores/data/tracking/product/swimlanes/SwimlanesTracker;Lcom/talabat/darkstores/domain/common/BuildVoucherDetailsNavigationUseCase;Lcom/talabat/darkstores/domain/common/BuildVoucherProductListingNavigationUseCase;Lcom/talabat/darkstores/domain/common/BuildBannerCampaignProductListingNavigationUseCase;)V", "bannersListLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/darkstores/data/darkstores/model/BannersResponse;", "getBannersListLiveData", "()Landroidx/lifecycle/LiveData;", "bannersObservability", "Lio/reactivex/subjects/PublishSubject;", "Lcom/talabat/darkstores/feature/home/BannerObservabilityData;", "categoriesObservability", "", "getCustomerRepository", "()Lcom/talabat/customer/domain/CustomerRepository;", "customerVouchersSwimLane", "", "Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "getCustomerVouchersSwimLane", "getDarkstoresRepo", "()Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "setDarkstoresRepo", "(Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;)V", "isCartEmpty", "", "()Z", "setCartEmpty", "(Z)V", "isNewTrackingEnabled", "mutableCustomerVouchersSwimLane", "Landroidx/lifecycle/MutableLiveData;", "mutableTalabatAiShowEventLiveData", "kotlin.jvm.PlatformType", "mutableTproBannerLiveData", "Lcom/talabat/darkstores/model/viewstate/TproBannerViewState;", "mutableVoucherProduct", "Lcom/talabat/core/ui/lifecycle/SingleLiveEvent;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "navigationActions", "Lcom/talabat/wrapper/EventWrapper;", "Landroidx/navigation/NavDirections;", "getNavigationActions", "navigationActionsMutableLiveData", "restaurant", "Ldatamodels/Restaurant;", "getRestaurant", "()Ldatamodels/Restaurant;", "retrySubject", "", "getScreenTracker", "()Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "swimlanesLiveData", "Lcom/talabat/darkstores/common/Result;", "Lcom/talabat/darkstores/feature/home/HomeFragmentData;", "getSwimlanesLiveData", "talabatAiShowEventLiveData", "getTalabatAiShowEventLiveData", "tproBannerLiveData", "getTproBannerLiveData", "vendor", "Lkotlin/Pair;", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "getVendor", "vendorLiveData", "voucherProduct", "getVoucherProduct", "canShowGreySearchBar", "canShowTopHeaderChanges", "canShowTopTwoCategories", "categories", "Lcom/talabat/darkstores/model/Category;", "checkAndEnableTalabatAiEntryPointIfApplicable", "", "getBannerNativeNavAction", "bannerId", "", "getCategories", "getHeroBannerImpressionTracker", "getLifestyleMissionControlV2NativeNavAction", "swimlaneId", "name", "getPrimaryMissionControlNativeNavAction", "code", "getSmallBannerImpressionTracker", "getSwimlanesNativeNavDirection", "headline", "categoryId", "tag", "getVlpUpliftVariation", "Lcom/talabat/darkstores/feature/home/VLPUplift;", "handleCategoriesError", "e", "", "handleVoucherDetailsNavigation", "sku", "voucherId", "navigateToVoucherDetailsBottomSheet", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "navigateToProduct", "Lkotlin/Function1;", "isLifestyleMissionV2", "loadProductBySkuFromVoucher", "navigate", "action", "navigateToVoucherProductListing", "voucherName", "voucherOrigin", "nfvEnabled", "onBackPressed", "activity", "Landroid/app/Activity;", "onBannerClicked", "banner", "Lcom/talabat/darkstores/model/Banner;", "type", "position", "onCategoriesAndSwimlanesLoaded", "swimlanes", "Lcom/talabat/darkstores/model/Swimlane;", "onCategoryClicked", "category", "eventOrigin", "Lcom/talabat/darkstores/data/tracking/EventOrigin;", "onFirstLayout", "onInteractionReady", "onLifestyleMissionControlClicked", "onLifestyleMissionControlV2Clicked", "onParentScrolled", "heroBanner", "Lcom/talabat/darkstores/feature/home/banner/BannerView;", "onPrimaryMissionControlClicked", "onReadyForInteractionDhDefinition", "onRetry", "onSearchFieldClicked", "onSwimlaneClicked", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "onTalabatAiIconClicked", "recalculateImpression", "setSwimlaneImpressionData", "homeRecyclerViewItem", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "setupBannerImpressionTracking", "trackingData", "Lcom/talabat/darkstores/data/tracking/impression/TrackingData;", "setupSwimlaneImpression", "viewGroup", "Landroid/view/ViewGroup;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "shouldBuildUIUsingRecyclerView", "shouldListenToScrollChange", "shouldShowTopAndMidCompactSwimlanesInsteadOfPrimaryMissions", "shouldShowTproBanner", "isMigrated", "isTproVendor", "shouldShowTproBannerForNFV", "shouldShowTproBannerForTmart", "startVendorListingPageTTFLTrace", "startVendorListingPageTTITrace", "tproForTmartEnabled", "trackAllButtonClicked", "originType", "trackBannerClicked", "trackBannerShown", "trackCategoryClicked", "trackCollectionClicked", "collectionId", "collectionName", "trackDarkstoreLoadTime", "loadEndTime", "", "trackNavigateToVoucherProductDetails", "screenName", "trackSearchBarClicked", "trackVoucherSwimLaneClicked", "title", "trackVoucherSwimLaneLoaded", "voucherTitles", "unregisterImpressions", "updateTProState", "trackResponse", "Lcom/talabat/darkstores/data/discovery/model/FeedMultiListData;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeFragmentViewModel extends BaseViewModel {
    @NotNull
    private final LiveData<BannersResponse> bannersListLiveData = new MutableLiveData();
    @NotNull
    private final PublishSubject<BannerObservabilityData> bannersObservability;
    @NotNull
    private final BuildBannerCampaignProductListingNavigationUseCase buildBannerCampaignProductListingNavigationUseCase;
    @NotNull
    private final BuildCategoryProductsNavigationActionUseCase buildCategoryProductsNavigationAction;
    @NotNull
    private final BuildLifestyleSearchResultNavigationActionUseCase buildLifestyleSearchNavigationActionUseCase;
    @NotNull
    private final BuildSearchNavigationActionUseCase buildSearchNavigationAction;
    @NotNull
    private final BuildSwimlanesSearchResultNavigationActionUseCase buildSwimlanesSearchResultNavigationActionUseCase;
    @NotNull
    private final BuildTalabatAiNavigationActionUseCase buildTalabatAiNavigationActionUseCase;
    @NotNull
    private final BuildVoucherDetailsNavigationUseCase buildVoucherDetailsNavigationUseCase;
    @NotNull
    private final BuildVoucherProductListingNavigationUseCase buildVoucherProductListingNavigationUseCase;
    @NotNull
    private final PublishSubject<Integer> categoriesObservability;
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationParameters configurationParameters;
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final LiveData<List<CustomerVoucher>> customerVouchersSwimLane;
    @NotNull
    private final DarkStoreObservabilityTracker darkStoreObservabilityTracker;
    @NotNull
    private DarkstoresRepo darkstoresRepo;
    @NotNull
    private final GetVendorLightningOptimizationExpVariantUseCase getVendorLightningOptimizationExpVariant;
    @NotNull
    private final ProductImpressionTracker heroBannerProductTracker;
    @NotNull
    private final HomeTracker homeTracker;
    @NotNull
    private final Scheduler ioScheduler;
    private boolean isCartEmpty;
    private final boolean isNewTrackingEnabled;
    @NotNull
    private final IsVLPLoadTimeTrackingEnabledUseCase isVLPLoadTimeTrackingEnabledUseCase;
    @NotNull
    private final IsVendorLightningOptimizationEnabledUseCase isVendorLightningOptimizationEnabledUseCase;
    @NotNull
    private final DarkstoresListener listener;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<List<CustomerVoucher>> mutableCustomerVouchersSwimLane;
    @NotNull
    private final MutableLiveData<Boolean> mutableTalabatAiShowEventLiveData;
    @NotNull
    private final MutableLiveData<TproBannerViewState> mutableTproBannerLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final SingleLiveEvent<Product> mutableVoucherProduct;
    @NotNull
    private final LiveData<EventWrapper<NavDirections>> navigationActions;
    @NotNull
    private final MutableLiveData<EventWrapper<NavDirections>> navigationActionsMutableLiveData;
    @NotNull
    private final ProductImpressionTracker productImpressionTracker;
    @NotNull
    private final PublishSubject<Object> retrySubject;
    @NotNull
    private final IScreenTracker screenTracker;
    @NotNull
    private final ShouldShowTalabatAiEntryPointUseCase shouldShowTalabatAiEntryPointUseCase;
    @NotNull
    private final ProductImpressionTracker smallBannerProductTracker;
    @NotNull
    private final ISubscriptionsFeatureFlagsRepository subscriptionsFlagsRepo;
    @NotNull
    private final LiveData<Result<HomeFragmentData>> swimlanesLiveData = new MutableLiveData();
    /* access modifiers changed from: private */
    @NotNull
    public final SwimlanesTracker swimlanesTracker;
    @NotNull
    private final LiveData<Boolean> talabatAiShowEventLiveData;
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final LiveData<TproBannerViewState> tproBannerLiveData;
    @NotNull
    private final DarkstoresEventTracker tracker;
    @NotNull
    private final LiveData<Pair<Vendor, Boolean>> vendor;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Pair<Vendor, Boolean>> vendorLiveData;
    @NotNull
    private final LiveData<Product> voucherProduct;

    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HomeFragmentViewModel(@org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.cart.CartController r17, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.darkstores.DarkstoresRepo r18, @org.jetbrains.annotations.NotNull com.talabat.core.observabilityNew.domain.IScreenTracker r19, @org.jetbrains.annotations.NotNull com.talabat.customer.domain.CustomerRepository r20, @org.jetbrains.annotations.NotNull io.reactivex.disposables.CompositeDisposable r21, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.tracking.DarkstoresEventTracker r22, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.tracking.HomeTracker r23, @org.jetbrains.annotations.NotNull com.talabat.core.experiment.domain.ITalabatExperiment r24, @org.jetbrains.annotations.NotNull com.talabat.core.featureflag.domain.ITalabatFeatureFlag r25, @org.jetbrains.annotations.NotNull com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository r26, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.ConfigurationParameters r27, @com.talabat.darkstores.di.qualifier.IoScheduler @org.jetbrains.annotations.NotNull io.reactivex.Scheduler r28, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase r29, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.common.BuildTalabatAiNavigationActionUseCase r30, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.checkout.DarkstoresListener r31, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.home.usecase.ShouldShowTalabatAiEntryPointUseCase r32, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.home.VendorLandingFeedUseCase r33, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCase r34, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker r35, @org.jetbrains.annotations.NotNull @com.talabat.darkstores.di.qualifier.SmallBannerImpressionTracker com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker r36, @org.jetbrains.annotations.NotNull @com.talabat.darkstores.di.qualifier.HeroBannerImpressionTracker com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker r37, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.common.BuildSwimlanesSearchResultNavigationActionUseCase r38, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.common.BuildLifestyleSearchResultNavigationActionUseCase r39, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.observability.DarkStoreObservabilityTracker r40, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.home.usecase.IsVLPLoadTimeTrackingEnabledUseCase r41, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.home.usecase.GetVendorLightningOptimizationExpVariantUseCase r42, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.home.usecase.IsVendorLightningOptimizationEnabledUseCase r43, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker r44, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.common.BuildVoucherDetailsNavigationUseCase r45, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.common.BuildVoucherProductListingNavigationUseCase r46, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.common.BuildBannerCampaignProductListingNavigationUseCase r47) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r14 = r31
            r15 = r32
            r0 = r33
            java.lang.String r0 = "cartController"
            r15 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "darkstoresRepo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "screenTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "customerRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "compositeDisposable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "tracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "homeTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "talabatExperiment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "talabatFeatureFlag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "subscriptionsFlagsRepo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "configurationParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "ioScheduler"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "buildSearchNavigationAction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "buildTalabatAiNavigationActionUseCase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "shouldShowTalabatAiEntryPointUseCase"
            r15 = r32
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "vendorLandingFeedUseCase"
            r15 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "buildCategoryProductsNavigationAction"
            r15 = r34
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "productImpressionTracker"
            r15 = r35
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "smallBannerProductTracker"
            r15 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "heroBannerProductTracker"
            r15 = r37
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "buildSwimlanesSearchResultNavigationActionUseCase"
            r15 = r38
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "buildLifestyleSearchNavigationActionUseCase"
            r15 = r39
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "darkStoreObservabilityTracker"
            r15 = r40
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "isVLPLoadTimeTrackingEnabledUseCase"
            r15 = r41
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "getVendorLightningOptimizationExpVariant"
            r15 = r42
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "isVendorLightningOptimizationEnabledUseCase"
            r15 = r43
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "swimlanesTracker"
            r15 = r44
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "buildVoucherDetailsNavigationUseCase"
            r15 = r45
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "buildVoucherProductListingNavigationUseCase"
            r15 = r46
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "buildBannerCampaignProductListingNavigationUseCase"
            r15 = r47
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = r16
            r15 = r33
            r0.<init>(r4)
            r0.darkstoresRepo = r1
            r0.screenTracker = r2
            r0.customerRepository = r3
            r0.tracker = r5
            r0.homeTracker = r6
            r0.talabatExperiment = r7
            r0.talabatFeatureFlag = r8
            r0.subscriptionsFlagsRepo = r9
            r0.configurationParameters = r10
            r0.ioScheduler = r11
            r0.buildSearchNavigationAction = r12
            r0.buildTalabatAiNavigationActionUseCase = r13
            r0.listener = r14
            r1 = r32
            r0.shouldShowTalabatAiEntryPointUseCase = r1
            r1 = r34
            r2 = r35
            r0.buildCategoryProductsNavigationAction = r1
            r0.productImpressionTracker = r2
            r1 = r36
            r2 = r37
            r0.smallBannerProductTracker = r1
            r0.heroBannerProductTracker = r2
            r1 = r38
            r2 = r39
            r0.buildSwimlanesSearchResultNavigationActionUseCase = r1
            r0.buildLifestyleSearchNavigationActionUseCase = r2
            r1 = r40
            r2 = r41
            r0.darkStoreObservabilityTracker = r1
            r0.isVLPLoadTimeTrackingEnabledUseCase = r2
            r1 = r42
            r2 = r43
            r0.getVendorLightningOptimizationExpVariant = r1
            r0.isVendorLightningOptimizationEnabledUseCase = r2
            r1 = r44
            r3 = r45
            r0.swimlanesTracker = r1
            r0.buildVoucherDetailsNavigationUseCase = r3
            r1 = r46
            r3 = r47
            r0.buildVoucherProductListingNavigationUseCase = r1
            r0.buildBannerCampaignProductListingNavigationUseCase = r3
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0.vendorLiveData = r1
            androidx.lifecycle.MutableLiveData r3 = new androidx.lifecycle.MutableLiveData
            r3.<init>()
            r0.navigationActionsMutableLiveData = r3
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
            r0.mutableTproBannerLiveData = r5
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r6.<init>(r7)
            r0.mutableTalabatAiShowEventLiveData = r6
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            r0.mutableCustomerVouchersSwimLane = r7
            com.talabat.core.ui.lifecycle.SingleLiveEvent r9 = new com.talabat.core.ui.lifecycle.SingleLiveEvent
            r9.<init>()
            r0.mutableVoucherProduct = r9
            r0.vendor = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0.bannersListLiveData = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0.swimlanesLiveData = r1
            r0.navigationActions = r3
            r0.tproBannerLiveData = r5
            r0.talabatAiShowEventLiveData = r6
            r0.customerVouchersSwimLane = r7
            r0.voucherProduct = r9
            io.reactivex.subjects.PublishSubject r1 = io.reactivex.subjects.PublishSubject.create()
            java.lang.String r3 = "create()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r0.retrySubject = r1
            io.reactivex.subjects.PublishSubject r1 = io.reactivex.subjects.PublishSubject.create()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r0.categoriesObservability = r1
            io.reactivex.subjects.PublishSubject r5 = io.reactivex.subjects.PublishSubject.create()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            r0.bannersObservability = r5
            r3 = 1
            r0.isCartEmpty = r3
            com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys r6 = com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys.TRACKING_LIBRARY_MIGRATION
            r7 = 0
            boolean r6 = r8.getFeatureFlag(r6, r7)
            r0.isNewTrackingEnabled = r6
            boolean r2 = r43.invoke()
            r6 = 0
            if (r2 != 0) goto L_0x0205
            com.talabat.darkstores.data.darkstores.DarkstoresRepo r2 = r0.darkstoresRepo
            io.reactivex.Single r2 = r2.getVendor()
            io.reactivex.Single r2 = r2.subscribeOn(r11)
            java.lang.String r7 = "darkstoresRepo.getVendor….subscribeOn(ioScheduler)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            com.talabat.darkstores.feature.home.HomeFragmentViewModel$1 r7 = new com.talabat.darkstores.feature.home.HomeFragmentViewModel$1
            r7.<init>(r0)
            io.reactivex.disposables.Disposable r2 = io.reactivex.rxkotlin.SubscribersKt.subscribeBy$default((io.reactivex.Single) r2, (kotlin.jvm.functions.Function1) r6, (kotlin.jvm.functions.Function1) r7, (int) r3, (java.lang.Object) r6)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r4, r2)
            com.talabat.darkstores.data.darkstores.DarkstoresRepo r2 = r0.darkstoresRepo
            io.reactivex.Single r2 = r2.getBanners()
            io.reactivex.Scheduler r7 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r2 = r2.subscribeOn(r7)
            io.reactivex.Observable r2 = r2.toObservable()
            dj.w r7 = new dj.w
            r7.<init>(r0)
            io.reactivex.Observable r2 = r2.retryWhen(r7)
            dj.x r7 = new dj.x
            r7.<init>(r0)
            io.reactivex.Observable r2 = r2.switchMap(r7)
            io.reactivex.disposables.Disposable r2 = r2.subscribe()
            java.lang.String r7 = "darkstoresRepo.getBanner…            }.subscribe()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r4, r2)
        L_0x0205:
            r16.checkAndEnableTalabatAiEntryPointIfApplicable()
            io.reactivex.Observable r2 = r17.getAllAsObservable()
            io.reactivex.Scheduler r7 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Observable r2 = r2.subscribeOn(r7)
            io.reactivex.Single r2 = r2.firstOrError()
            java.lang.String r7 = "cartController.getAllAsO…          .firstOrError()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            com.talabat.darkstores.feature.home.HomeFragmentViewModel$4 r7 = new com.talabat.darkstores.feature.home.HomeFragmentViewModel$4
            r7.<init>(r0)
            io.reactivex.disposables.Disposable r2 = io.reactivex.rxkotlin.SubscribersKt.subscribeBy$default((io.reactivex.Single) r2, (kotlin.jvm.functions.Function1) r6, (kotlin.jvm.functions.Function1) r7, (int) r3, (java.lang.Object) r6)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r4, r2)
            com.talabat.darkstores.data.darkstores.DarkstoresRepo r2 = r0.darkstoresRepo
            io.reactivex.Single r2 = r2.getCustomerVouchers()
            io.reactivex.Scheduler r7 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r2 = r2.subscribeOn(r7)
            java.lang.String r7 = "darkstoresRepo.getCustom…scribeOn(Schedulers.io())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            com.talabat.darkstores.feature.home.HomeFragmentViewModel$5 r7 = new com.talabat.darkstores.feature.home.HomeFragmentViewModel$5
            r7.<init>(r0)
            io.reactivex.disposables.Disposable r2 = io.reactivex.rxkotlin.SubscribersKt.subscribeBy$default((io.reactivex.Single) r2, (kotlin.jvm.functions.Function1) r6, (kotlin.jvm.functions.Function1) r7, (int) r3, (java.lang.Object) r6)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r4, r2)
            com.talabat.darkstores.data.discovery.model.FeedEndpointRequest$PageType r2 = com.talabat.darkstores.data.discovery.model.FeedEndpointRequest.PageType.landing_page
            io.reactivex.Single r2 = r15.getFeedMultiListData(r2)
            io.reactivex.Scheduler r7 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Single r2 = r2.subscribeOn(r7)
            dj.y r7 = new dj.y
            r7.<init>(r0)
            io.reactivex.Single r2 = r2.doOnError(r7)
            dj.z r7 = new dj.z
            r7.<init>(r0)
            io.reactivex.Single r2 = r2.doOnSuccess(r7)
            java.lang.String r7 = "vendorLandingFeedUseCase…kResponse()\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            io.reactivex.Observable r2 = r2.toObservable()
            java.lang.String r7 = "toObservable()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            com.talabat.darkstores.feature.home.HomeFragmentViewModel$special$$inlined$toResult$1 r7 = new com.talabat.darkstores.feature.home.HomeFragmentViewModel$special$$inlined$toResult$1
            r7.<init>(r0)
            io.reactivex.Observable r2 = r2.map(r7)
            com.talabat.darkstores.common.ResultKt$toResult$4<T, R> r7 = com.talabat.darkstores.common.ResultKt$toResult$4.INSTANCE
            io.reactivex.Observable r2 = r2.onErrorReturn(r7)
            com.talabat.darkstores.common.Result$Loading r7 = new com.talabat.darkstores.common.Result$Loading
            r7.<init>(r6, r3, r6)
            io.reactivex.Observable r2 = r2.startWith(r7)
            java.lang.String r3 = "crossinline mapper: (Inp…artWith(Result.Loading())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            dj.a0 r3 = new dj.a0
            r3.<init>(r0)
            io.reactivex.Observable r2 = r2.repeatWhen(r3)
            java.lang.String r3 = "vendorLandingFeedUseCase…peatWhen { retrySubject }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = 0
            r6 = 0
            com.talabat.darkstores.feature.home.HomeFragmentViewModel$10 r7 = new com.talabat.darkstores.feature.home.HomeFragmentViewModel$10
            r7.<init>(r0)
            r8 = 3
            r9 = 0
            r22 = r2
            r23 = r3
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            io.reactivex.disposables.Disposable r2 = io.reactivex.rxkotlin.SubscribersKt.subscribeBy$default((io.reactivex.Observable) r22, (kotlin.jvm.functions.Function1) r23, (kotlin.jvm.functions.Function0) r24, (kotlin.jvm.functions.Function1) r25, (int) r26, (java.lang.Object) r27)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r4, r2)
            io.reactivex.Scheduler r2 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Observable r1 = r1.subscribeOn(r2)
            dj.b0 r2 = new dj.b0
            r2.<init>(r0)
            io.reactivex.Observable r1 = r1.switchMap(r2)
            io.reactivex.disposables.Disposable r1 = r1.subscribe()
            java.lang.String r2 = "categoriesObservability\n…\n            .subscribe()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r4, r1)
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.io()
            io.reactivex.Observable r1 = r5.subscribeOn(r1)
            com.talabat.darkstores.feature.home.a r2 = new com.talabat.darkstores.feature.home.a
            r2.<init>()
            io.reactivex.Observable r1 = r1.map(r2)
            io.reactivex.disposables.Disposable r1 = r1.subscribe()
            java.lang.String r2 = "bannersObservability\n   …\n            .subscribe()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.home.HomeFragmentViewModel.<init>(com.talabat.darkstores.feature.cart.CartController, com.talabat.darkstores.data.darkstores.DarkstoresRepo, com.talabat.core.observabilityNew.domain.IScreenTracker, com.talabat.customer.domain.CustomerRepository, io.reactivex.disposables.CompositeDisposable, com.talabat.darkstores.feature.tracking.DarkstoresEventTracker, com.talabat.darkstores.data.tracking.HomeTracker, com.talabat.core.experiment.domain.ITalabatExperiment, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository, com.talabat.darkstores.data.ConfigurationParameters, io.reactivex.Scheduler, com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase, com.talabat.darkstores.domain.common.BuildTalabatAiNavigationActionUseCase, com.talabat.darkstores.feature.checkout.DarkstoresListener, com.talabat.darkstores.feature.home.usecase.ShouldShowTalabatAiEntryPointUseCase, com.talabat.darkstores.feature.home.VendorLandingFeedUseCase, com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCase, com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker, com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker, com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker, com.talabat.darkstores.domain.common.BuildSwimlanesSearchResultNavigationActionUseCase, com.talabat.darkstores.domain.common.BuildLifestyleSearchResultNavigationActionUseCase, com.talabat.darkstores.feature.observability.DarkStoreObservabilityTracker, com.talabat.darkstores.feature.home.usecase.IsVLPLoadTimeTrackingEnabledUseCase, com.talabat.darkstores.feature.home.usecase.GetVendorLightningOptimizationExpVariantUseCase, com.talabat.darkstores.feature.home.usecase.IsVendorLightningOptimizationEnabledUseCase, com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker, com.talabat.darkstores.domain.common.BuildVoucherDetailsNavigationUseCase, com.talabat.darkstores.domain.common.BuildVoucherProductListingNavigationUseCase, com.talabat.darkstores.domain.common.BuildBannerCampaignProductListingNavigationUseCase):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final ObservableSource m9959_init_$lambda1(HomeFragmentViewModel homeFragmentViewModel, Observable observable) {
        Intrinsics.checkNotNullParameter(homeFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(observable, "it");
        return observable.flatMap(new u(homeFragmentViewModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-11  reason: not valid java name */
    public static final ObservableSource m9960_init_$lambda11(HomeFragmentViewModel homeFragmentViewModel, Integer num) {
        Intrinsics.checkNotNullParameter(homeFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(num, BindingAdaptersKt.QUERY_SIZE);
        return homeFragmentViewModel.darkstoresRepo.getVendor().toObservable().map(new v(num));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-12  reason: not valid java name */
    public static final Unit m9961_init_$lambda12(BannerObservabilityData bannerObservabilityData) {
        Intrinsics.checkNotNullParameter(bannerObservabilityData, "it");
        if (bannerObservabilityData.getHeroBannerSize() == 0) {
            NfvObservabilityHandler.INSTANCE.onDarkstoresHeroBannersEmpty(bannerObservabilityData.getVendorId());
        }
        if (bannerObservabilityData.getBannerSize() == 0) {
            NfvObservabilityHandler.INSTANCE.onDarkstoresBannersEmpty(bannerObservabilityData.getVendorId());
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final ObservableSource m9962_init_$lambda3(HomeFragmentViewModel homeFragmentViewModel, BannersResponse bannersResponse) {
        Intrinsics.checkNotNullParameter(homeFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(bannersResponse, "bannersResponse");
        return homeFragmentViewModel.darkstoresRepo.getVendor().toObservable().map(new t(homeFragmentViewModel, bannersResponse));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-4  reason: not valid java name */
    public static final void m9963_init_$lambda4(HomeFragmentViewModel homeFragmentViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(homeFragmentViewModel, "this$0");
        homeFragmentViewModel.handleCategoriesError(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-5  reason: not valid java name */
    public static final void m9964_init_$lambda5(HomeFragmentViewModel homeFragmentViewModel, FeedMultiListData feedMultiListData) {
        Intrinsics.checkNotNullParameter(homeFragmentViewModel, "this$0");
        if (homeFragmentViewModel.isVendorLightningOptimizationEnabledUseCase.invoke()) {
            if (feedMultiListData.getVendor() != null) {
                homeFragmentViewModel.vendorLiveData.postValue(TuplesKt.to(feedMultiListData.getVendor(), Boolean.valueOf(homeFragmentViewModel.configurationParameters.isMigrated())));
                homeFragmentViewModel.bannersObservability.onNext(new BannerObservabilityData(feedMultiListData.getHeroBanners().size(), feedMultiListData.getBanners().size(), feedMultiListData.getVendor().getVendorId()));
            }
            homeFragmentViewModel.updateTProState();
            ((MutableLiveData) homeFragmentViewModel.bannersListLiveData).postValue(new BannersResponse(feedMultiListData.getHeroBanners(), feedMultiListData.getBanners()));
        }
        Intrinsics.checkNotNullExpressionValue(feedMultiListData, "it");
        homeFragmentViewModel.trackResponse(feedMultiListData);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-9  reason: not valid java name */
    public static final ObservableSource m9965_init_$lambda9(HomeFragmentViewModel homeFragmentViewModel, Observable observable) {
        Intrinsics.checkNotNullParameter(homeFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(observable, "it");
        return homeFragmentViewModel.retrySubject;
    }

    private final boolean canShowTopTwoCategories(List<Category> list) {
        if (getVlpUpliftVariation() != VLPUplift.NEW_TOP_HEADER_WITH_TOP_TWO_CATEGORIES || list.size() < 3) {
            return false;
        }
        return true;
    }

    private final void checkAndEnableTalabatAiEntryPointIfApplicable() {
        if (this.configurationParameters.getRestaurant().isDarkStore && this.customerRepository.isTPro() && this.shouldShowTalabatAiEntryPointUseCase.invoke()) {
            this.mutableTalabatAiShowEventLiveData.postValue(Boolean.TRUE);
        }
    }

    /* access modifiers changed from: private */
    public final NavDirections getBannerNativeNavAction(String str) {
        return HomeFragmentDirections.Companion.actionHomeFragmentToSearchResultsFragment(new SearchResultsType.Banner(str), EventOriginType.Banner.getTrackingName());
    }

    /* access modifiers changed from: private */
    public final Pair<List<Category>, List<Category>> getCategories(List<Category> list) {
        if (!canShowTopTwoCategories(list)) {
            return new Pair<>(CollectionsKt__CollectionsKt.emptyList(), list);
        }
        Iterable iterable = list;
        return new Pair<>(CollectionsKt___CollectionsKt.take(iterable, 2), CollectionsKt___CollectionsKt.drop(iterable, 2));
    }

    private final VLPUplift getVlpUpliftVariation() {
        String stringVariant = this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.QCOMMERCE_VLP_UPLIFT, "", TalabatExperimentDataSourceStrategy.FWF);
        if (Intrinsics.areEqual((Object) stringVariant, (Object) "Variation1")) {
            return VLPUplift.NEW_TOP_HEADER_WITH_TOP_TWO_CATEGORIES;
        }
        if (Intrinsics.areEqual((Object) stringVariant, (Object) "Variation2")) {
            return VLPUplift.NEW_TOP_HEADER;
        }
        return VLPUplift.NONE;
    }

    private final void handleCategoriesError(Throwable th2) {
        if (th2 != null) {
            LiveData<Result<HomeFragmentData>> liveData = this.swimlanesLiveData;
            MutableLiveData mutableLiveData = (MutableLiveData) liveData;
            ((MutableLiveData) liveData).postValue(new Result.Error(th2, false, (Object) null, 6, (DefaultConstructorMarker) null));
            this.categoriesObservability.onNext(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-1$lambda-0  reason: not valid java name */
    public static final ObservableSource m9966lambda1$lambda0(HomeFragmentViewModel homeFragmentViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(homeFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(th2, "it");
        return homeFragmentViewModel.retrySubject;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-11$lambda-10  reason: not valid java name */
    public static final Unit m9967lambda11$lambda10(Integer num, Vendor vendor2) {
        Intrinsics.checkNotNullParameter(num, "$size");
        Intrinsics.checkNotNullParameter(vendor2, "vendor");
        if (num.intValue() < 6) {
            NfvObservabilityHandler.INSTANCE.onDarkstoresCategoriesMissing(vendor2.getVendorId(), num.intValue());
        }
        if (num.intValue() == 0) {
            NfvObservabilityHandler.INSTANCE.onDarkstoresCategoriesNotLoaded(vendor2.getVendorId());
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-3$lambda-2  reason: not valid java name */
    public static final Unit m9968lambda3$lambda2(HomeFragmentViewModel homeFragmentViewModel, BannersResponse bannersResponse, Vendor vendor2) {
        Intrinsics.checkNotNullParameter(homeFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(bannersResponse, "$bannersResponse");
        Intrinsics.checkNotNullParameter(vendor2, "vendorInfo");
        ((MutableLiveData) homeFragmentViewModel.bannersListLiveData).postValue(bannersResponse);
        homeFragmentViewModel.bannersObservability.onNext(new BannerObservabilityData(bannersResponse.getHeroBanners().size(), bannersResponse.getBanners().size(), vendor2.getVendorId()));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void navigate(NavDirections navDirections) {
        this.navigationActionsMutableLiveData.postValue(new EventWrapper(navDirections));
    }

    public static /* synthetic */ void trackAllButtonClicked$default(HomeFragmentViewModel homeFragmentViewModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = "";
        }
        if ((i11 & 4) != 0) {
            str3 = StringUtils.empty(StringCompanionObject.INSTANCE);
        }
        homeFragmentViewModel.trackAllButtonClicked(str, str2, str3);
    }

    /* access modifiers changed from: private */
    public final void trackBannerClicked(Banner banner, String str, int i11) {
        this.tracker.onBannerClicked(banner, str, i11);
    }

    private final void trackCategoryClicked(Category category, int i11) {
        Iterable<SubCategory> subcategories = category.getSubcategories();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subcategories, 10));
        for (SubCategory name2 : subcategories) {
            arrayList.add(name2.getName());
        }
        this.tracker.onCategoryClicked(category.getName(), category.getId(), arrayList, i11);
        trackCollectionClicked(category.getId(), category.getName());
    }

    private final void trackCollectionClicked(String str, String str2) {
        this.tracker.onCollectionClicked(this.configurationParameters.getChainId(), this.configurationParameters.getBranchId(), !this.configurationParameters.isMigrated(), str, str2);
    }

    public static /* synthetic */ void trackDarkstoreLoadTime$default(HomeFragmentViewModel homeFragmentViewModel, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = System.currentTimeMillis();
        }
        homeFragmentViewModel.trackDarkstoreLoadTime(j11);
    }

    private final void trackResponse(FeedMultiListData feedMultiListData) {
        onCategoriesAndSwimlanesLoaded(feedMultiListData.getCategories(), feedMultiListData.getSwimlanes());
        this.categoriesObservability.onNext(Integer.valueOf(feedMultiListData.getCategories().size()));
    }

    private final void trackSearchBarClicked() {
        this.homeTracker.searchBarClicked();
    }

    /* access modifiers changed from: private */
    public final void updateTProState() {
        if (shouldShowTproBanner(this.configurationParameters.isMigrated(), getRestaurant().isProRestaurant)) {
            this.mutableTproBannerLiveData.postValue(new TproBannerViewState.Shown(!this.customerRepository.isTPro()));
        } else {
            this.mutableTproBannerLiveData.postValue(TproBannerViewState.Hidden.INSTANCE);
        }
    }

    public final boolean canShowGreySearchBar() {
        return !Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.QCOMMERCE_SEARCH_BAR_BGCOLOR, "", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    public final boolean canShowTopHeaderChanges() {
        return getVlpUpliftVariation() != VLPUplift.NONE;
    }

    @NotNull
    public final LiveData<BannersResponse> getBannersListLiveData() {
        return this.bannersListLiveData;
    }

    @NotNull
    public final CustomerRepository getCustomerRepository() {
        return this.customerRepository;
    }

    @NotNull
    public final LiveData<List<CustomerVoucher>> getCustomerVouchersSwimLane() {
        return this.customerVouchersSwimLane;
    }

    @NotNull
    public final DarkstoresRepo getDarkstoresRepo() {
        return this.darkstoresRepo;
    }

    @NotNull
    public final ProductImpressionTracker getHeroBannerImpressionTracker() {
        return this.heroBannerProductTracker;
    }

    @NotNull
    public final NavDirections getLifestyleMissionControlV2NativeNavAction(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "swimlaneId");
        Intrinsics.checkNotNullParameter(str2, "name");
        return HomeFragmentDirections.Companion.actionHomeFragmentToSearchResultsFragment$default(HomeFragmentDirections.Companion, new SearchResultsType.LifestyleMissionControlV2(str, str2), (String) null, 2, (Object) null);
    }

    @NotNull
    public final LiveData<EventWrapper<NavDirections>> getNavigationActions() {
        return this.navigationActions;
    }

    @NotNull
    public final NavDirections getPrimaryMissionControlNativeNavAction(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str2, "name");
        return HomeFragmentDirections.Companion.actionHomeFragmentToSearchResultsFragment$default(HomeFragmentDirections.Companion, new SearchResultsType.PrimaryMissionControl(str, str2), (String) null, 2, (Object) null);
    }

    @NotNull
    public final Restaurant getRestaurant() {
        return this.configurationParameters.getRestaurant();
    }

    @NotNull
    public final IScreenTracker getScreenTracker() {
        return this.screenTracker;
    }

    @NotNull
    public final ProductImpressionTracker getSmallBannerImpressionTracker() {
        return this.smallBannerProductTracker;
    }

    @NotNull
    public final LiveData<Result<HomeFragmentData>> getSwimlanesLiveData() {
        return this.swimlanesLiveData;
    }

    @NotNull
    public final NavDirections getSwimlanesNativeNavDirection(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "swimlaneId");
        Intrinsics.checkNotNullParameter(str2, "headline");
        if (str3 != null) {
            return HomeFragmentDirections.Companion.actionHomeFragmentToCategoriesFragment(new Category(str2, str3, (List) null, (List) null, 12, (DefaultConstructorMarker) null), EventOrigin.CATEGORY_SECTION_VLP.getTrackingName());
        } else if (str4 != null) {
            return HomeFragmentDirections.Companion.actionHomeFragmentToSearchResultsFragment$default(HomeFragmentDirections.Companion, new SearchResultsType.Tag(str4, str2), (String) null, 2, (Object) null);
        } else {
            return HomeFragmentDirections.Companion.actionHomeFragmentToSearchResultsFragment$default(HomeFragmentDirections.Companion, new SearchResultsType.SwimlaneProducts(str, str2, "", ""), (String) null, 2, (Object) null);
        }
    }

    @NotNull
    public final LiveData<Boolean> getTalabatAiShowEventLiveData() {
        return this.talabatAiShowEventLiveData;
    }

    @NotNull
    public final LiveData<TproBannerViewState> getTproBannerLiveData() {
        return this.tproBannerLiveData;
    }

    @NotNull
    public final LiveData<Pair<Vendor, Boolean>> getVendor() {
        return this.vendor;
    }

    @NotNull
    public final LiveData<Product> getVoucherProduct() {
        return this.voucherProduct;
    }

    public final void handleVoucherDetailsNavigation(@Nullable String str, @NotNull String str2, @NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, Unit> function2, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(str2, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(function2, "navigateToVoucherDetailsBottomSheet");
        Intrinsics.checkNotNullParameter(function1, "navigateToProduct");
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildVoucherDetailsNavigationUseCase.invoke(str2, str, function2, function1), (Function1) null, (Function1) null, 3, (Object) null));
    }

    public final boolean isCartEmpty() {
        return this.isCartEmpty;
    }

    public final boolean isLifestyleMissionV2() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, QCommerceFeatureFlagsKeys.LIFESTYLE_MISSION_V2, false, 2, (Object) null);
    }

    public final void loadProductBySkuFromVoucher(@Nullable String str) {
        if (str != null) {
            CompositeDisposable a11 = a();
            Single<Product> subscribeOn = this.darkstoresRepo.getProductBySku(str).subscribeOn(this.ioScheduler);
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "darkstoresRepo\n         ….subscribeOn(ioScheduler)");
            DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Single) subscribeOn, (Function1) null, (Function1) new HomeFragmentViewModel$loadProductBySkuFromVoucher$1$1(this), 1, (Object) null));
        }
    }

    public final void navigateToVoucherProductListing(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(str2, "voucherName");
        Intrinsics.checkNotNullParameter(str3, "voucherOrigin");
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildVoucherProductListingNavigationUseCase.invoke(str, str2, str3, new HomeFragmentViewModel$navigateToVoucherProductListing$1(HomeFragmentDirections.Companion)), (Function1) null, (Function1) new HomeFragmentViewModel$navigateToVoucherProductListing$2(this), 1, (Object) null));
    }

    public final boolean nfvEnabled() {
        return this.subscriptionsFlagsRepo.isTProEnabledForNFV();
    }

    public final void onBackPressed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.configurationParameters.isFromDeeplink()) {
            this.listener.onBackFromDSAfterDeepLink(activity);
        } else {
            this.listener.onBackPressed(activity);
        }
        activity.finish();
    }

    public final void onBannerClicked(@NotNull Banner banner, @NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(str, "type");
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildBannerCampaignProductListingNavigationUseCase.invoke(banner.getGlobalId(), new HomeFragmentViewModel$onBannerClicked$1(HomeFragmentDirections.Companion), new HomeFragmentViewModel$onBannerClicked$2(this)), (Function1) null, (Function1) new HomeFragmentViewModel$onBannerClicked$3(this, banner, str, i11), 1, (Object) null));
    }

    public final void onCategoriesAndSwimlanesLoaded(@NotNull List<Category> list, @NotNull List<Swimlane> list2) {
        String str;
        ImageUrl imageUrl;
        List<Category> list3 = list;
        List<Swimlane> list4 = list2;
        Intrinsics.checkNotNullParameter(list3, "categories");
        Intrinsics.checkNotNullParameter(list4, "swimlanes");
        Iterable<Category> iterable = list3;
        int i11 = 10;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Category category : iterable) {
            Iterable<SubCategory> subcategories = category.getSubcategories();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subcategories, 10));
            for (SubCategory subCategory : subcategories) {
                arrayList2.add(new ShopDetailsSubCategory(subCategory.getName(), subCategory.getId()));
            }
            String name2 = category.getName();
            String id2 = category.getId();
            List<ImageUrl> imageUrls = category.getImageUrls();
            if (imageUrls == null || (imageUrl = (ImageUrl) CollectionsKt___CollectionsKt.firstOrNull(imageUrls)) == null) {
                str = null;
            } else {
                str = imageUrl.getUrl();
            }
            arrayList.add(new ShopDetailsCategory(name2, id2, str, arrayList2));
        }
        Iterable<Swimlane> iterable2 = list4;
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
        for (Swimlane swimlane : iterable2) {
            Iterable<Product> products = swimlane.getProducts();
            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(products, i11));
            for (Product product : products) {
                ProductDetails productDetails = r9;
                ProductDetails productDetails2 = new ProductDetails(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCartCount(), product.getImageUrl(), (String) null, false, (SwimlaneTrackingData) null, (Integer) null, 960, (DefaultConstructorMarker) null);
                arrayList4.add(productDetails);
            }
            arrayList3.add(new ShopDetailsSwimlane(swimlane.getHeadline(), swimlane.getTag(), swimlane.getCategoryId(), arrayList4));
            i11 = 10;
        }
        this.tracker.onShopDetailsLoaded(new ShopDetails(arrayList, arrayList3), this.isCartEmpty, this.configurationParameters.getSearchTerm(), this.isNewTrackingEnabled);
    }

    public final void onCategoryClicked(@NotNull Category category, int i11, @NotNull EventOrigin eventOrigin) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(eventOrigin, "eventOrigin");
        trackCategoryClicked(category, i11);
        CompositeDisposable a11 = a();
        BuildCategoryProductsNavigationActionUseCase buildCategoryProductsNavigationActionUseCase = this.buildCategoryProductsNavigationAction;
        String id2 = category.getId();
        String name2 = category.getName();
        String trackingName = eventOrigin.getTrackingName();
        HomeFragmentDirections.Companion companion = HomeFragmentDirections.Companion;
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Single) buildCategoryProductsNavigationActionUseCase.invoke(id2, name2, trackingName, new HomeFragmentViewModel$onCategoryClicked$1(companion), new HomeFragmentViewModel$onCategoryClicked$2(companion)), (Function1) null, (Function1) new HomeFragmentViewModel$onCategoryClicked$3(this), 1, (Object) null));
    }

    public final void onFirstLayout() {
        this.screenTracker.stopTrace(ScreenTrackerParams.Companion.create(QCommerceScreenTracingNames.TTFL_QCOMMERCE_VLP.getValue()));
    }

    public final void onInteractionReady() {
        this.screenTracker.stopTrace(ScreenTrackerParams.Companion.create(QCommerceScreenTracingNames.TTI_QCOMMERCE_VLP.getValue()));
    }

    public final void onLifestyleMissionControlClicked(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str2, "name");
        trackCollectionClicked(str, str2);
        navigate(HomeFragmentDirections.Companion.actionHomeFragmentToSearchResultsFragment$default(HomeFragmentDirections.Companion, new SearchResultsType.LifestyleMissionControl(str, str2), (String) null, 2, (Object) null));
    }

    public final void onLifestyleMissionControlV2Clicked(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "swimlaneId");
        Intrinsics.checkNotNullParameter(str2, "name");
        trackCollectionClicked(str, str2);
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildLifestyleSearchNavigationActionUseCase.invoke(str, str2, EventOriginType.Lifestyle.getTrackingName(), new HomeFragmentViewModel$onLifestyleMissionControlV2Clicked$1(HomeFragmentDirections.Companion), new HomeFragmentViewModel$onLifestyleMissionControlV2Clicked$2(this)), (Function1) null, (Function1) new HomeFragmentViewModel$onLifestyleMissionControlV2Clicked$3(this), 1, (Object) null));
    }

    public final void onParentScrolled(@NotNull BannerView bannerView, @NotNull BannerView bannerView2) {
        Intrinsics.checkNotNullParameter(bannerView, "heroBanner");
        Intrinsics.checkNotNullParameter(bannerView2, "banner");
        bannerView.onParentScrolled();
        bannerView2.onParentScrolled();
    }

    public final void onPrimaryMissionControlClicked(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str2, "name");
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildLifestyleSearchNavigationActionUseCase.invoke(str, str2, EventOriginType.Swimlane.getTrackingName(), new HomeFragmentViewModel$onPrimaryMissionControlClicked$1(HomeFragmentDirections.Companion), new HomeFragmentViewModel$onPrimaryMissionControlClicked$2(this)), (Function1) null, (Function1) new HomeFragmentViewModel$onPrimaryMissionControlClicked$3(this), 1, (Object) null));
    }

    public final void onReadyForInteractionDhDefinition() {
        this.screenTracker.stopTrace(ScreenTrackerParams.Companion.create(QCommerceScreenTracingNames.QCOMMERCE_VLP_START_TO_INTERACTIVE.getValue()));
    }

    public final void onRetry() {
        this.retrySubject.onNext(Unit.INSTANCE);
    }

    public final void onSearchFieldClicked() {
        trackSearchBarClicked();
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildSearchNavigationAction.invoke(new HomeFragmentViewModel$onSearchFieldClicked$1(HomeFragmentDirections.Companion)), (Function1) null, (Function1) new HomeFragmentViewModel$onSearchFieldClicked$2(this), 1, (Object) null));
    }

    public final void onSwimlaneClicked(@NotNull Swimlane swimlane, @NotNull EventOriginType eventOriginType) {
        Intrinsics.checkNotNullParameter(swimlane, "swimlanes");
        Intrinsics.checkNotNullParameter(eventOriginType, "eventOrigin");
        String swimlaneId = swimlane.getSwimlaneId();
        if (swimlaneId != null) {
            DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildSwimlanesSearchResultNavigationActionUseCase.invoke(swimlaneId, swimlane.getHeadline(), eventOriginType.getTrackingName(), swimlane.getCategoryId(), swimlane.getTag(), new HomeFragmentViewModel$onSwimlaneClicked$1(HomeFragmentDirections.Companion), new HomeFragmentViewModel$onSwimlaneClicked$2(this)), (Function1) null, (Function1) new HomeFragmentViewModel$onSwimlaneClicked$3(this), 1, (Object) null));
            return;
        }
        String headline = swimlane.getHeadline();
        throw new IllegalArgumentException("Can not find Nav Direction for Swimlanes " + headline);
    }

    public final void onTalabatAiIconClicked() {
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Maybe) this.buildTalabatAiNavigationActionUseCase.invoke(new HomeFragmentViewModel$onTalabatAiIconClicked$1(HomeFragmentDirections.Companion)), (Function1) null, (Function0) null, (Function1) new HomeFragmentViewModel$onTalabatAiIconClicked$2(this), 3, (Object) null));
    }

    public final void recalculateImpression() {
        this.heroBannerProductTracker.reCalculate();
        this.smallBannerProductTracker.reCalculate();
    }

    public final void setCartEmpty(boolean z11) {
        this.isCartEmpty = z11;
    }

    public final void setDarkstoresRepo(@NotNull DarkstoresRepo darkstoresRepo2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo2, "<set-?>");
        this.darkstoresRepo = darkstoresRepo2;
    }

    public final void setSwimlaneImpressionData(@NotNull List<? extends HomeRecyclerViewItem> list) {
        Intrinsics.checkNotNullParameter(list, "homeRecyclerViewItem");
        this.productImpressionTracker.updateSwimlaneItems(list, ScreenTrackingProvider.ScreenName.LANDING, ScreenTrackingProvider.ScreenType.LANDING, ScreenTrackingProvider.EventOrigin.LANDING);
    }

    public final void setupBannerImpressionTracking(@NotNull BannerView bannerView, @NotNull BannerView bannerView2, @NotNull TrackingData trackingData) {
        Intrinsics.checkNotNullParameter(bannerView, "heroBanner");
        Intrinsics.checkNotNullParameter(bannerView2, "banner");
        Intrinsics.checkNotNullParameter(trackingData, "trackingData");
        BannerView.setupImpressionTracking$default(bannerView2, this.smallBannerProductTracker, trackingData, (LifecycleOwner) null, 4, (Object) null);
        BannerView.setupImpressionTracking$default(bannerView, this.heroBannerProductTracker, trackingData, (LifecycleOwner) null, 4, (Object) null);
    }

    public final void setupSwimlaneImpression(@NotNull ViewGroup viewGroup, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        if (shouldBuildUIUsingRecyclerView()) {
            this.productImpressionTracker.register(viewGroup, lifecycleOwner);
        }
    }

    public final boolean shouldBuildUIUsingRecyclerView() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, QCommerceFeatureFlagsKeys.SWIMLANE_IMPRESSIONS_TRACKING, false, 2, (Object) null);
    }

    public final boolean shouldListenToScrollChange() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, QCommerceFeatureFlagsKeys.RECALCULATE_BANNER_IMPRESSION, false, 2, (Object) null);
    }

    public final boolean shouldShowTopAndMidCompactSwimlanesInsteadOfPrimaryMissions() {
        return Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.QCOMMERCE_EXPOSED_COLLECTIONS, "", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    public final boolean shouldShowTproBanner(boolean z11, boolean z12) {
        if (shouldShowTproBannerForTmart(z11, z12) || shouldShowTproBannerForNFV(z11, z12)) {
            return true;
        }
        return false;
    }

    public final boolean shouldShowTproBannerForNFV(boolean z11, boolean z12) {
        return nfvEnabled() && z11 && z12;
    }

    public final boolean shouldShowTproBannerForTmart(boolean z11, boolean z12) {
        return tproForTmartEnabled() && !z11 && z12;
    }

    public final void startVendorListingPageTTFLTrace() {
        IScreenTracker iScreenTracker = this.screenTracker;
        ScreenTrackerParams.Companion companion = ScreenTrackerParams.Companion;
        iScreenTracker.startTrace(companion.create(QCommerceScreenTracingNames.TTFL_QCOMMERCE_VLP.getValue()));
        this.screenTracker.startTrace(companion.create(QCommerceScreenTracingNames.QCOMMERCE_VLP_START_TO_INTERACTIVE.getValue()));
    }

    public final void startVendorListingPageTTITrace() {
        this.screenTracker.startTrace(ScreenTrackerParams.Companion.create(QCommerceScreenTracingNames.TTI_QCOMMERCE_VLP.getValue()));
    }

    public final boolean tproForTmartEnabled() {
        return this.subscriptionsFlagsRepo.isTProEnabledForTMart();
    }

    public final void trackAllButtonClicked(@NotNull String str, @Nullable String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "category");
        Intrinsics.checkNotNullParameter(str3, "originType");
        this.tracker.onDarkstoresAllButtonClicked(str, str2, str3);
    }

    public final void trackBannerShown(@NotNull Banner banner, @NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(str, "type");
        this.tracker.onBannerShown(banner, str, i11);
    }

    public final void trackDarkstoreLoadTime(long j11) {
        Darkstores.DarkstoresTrackingData darkstoresTrackingData;
        if (this.isVLPLoadTimeTrackingEnabledUseCase.invoke() && (darkstoresTrackingData = this.configurationParameters.getDarkstoresTrackingData()) != null) {
            long loadingStartTime = j11 - darkstoresTrackingData.getLoadingStartTime();
            this.darkStoreObservabilityTracker.trackQCPerformance(new PerformanceAttribute.TimeToLoad(loadingStartTime), this.configurationParameters.getVendorCode(), ScreenTrackingProvider.ScreenName.LANDING, MapsKt__MapsKt.mapOf(TuplesKt.to("vlp_lightning_variant", this.getVendorLightningOptimizationExpVariant.invoke()), TuplesKt.to("deeplink_type", String.valueOf(this.configurationParameters.getDeeplinkType()))));
        }
    }

    public final void trackNavigateToVoucherProductDetails(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        this.tracker.sendNavigateToVoucherProductDetails(str, str2);
    }

    public final void trackVoucherSwimLaneClicked(@NotNull String str, int i11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.tracker.sendSwimLaneVoucherClickedEvent(str, i11, str2);
    }

    public final void trackVoucherSwimLaneLoaded(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(list, "voucherTitles");
        this.tracker.sendSwimLaneLoadedEvent(str, list);
    }

    public final void unregisterImpressions() {
        this.heroBannerProductTracker.unregister();
        this.smallBannerProductTracker.unregister();
        this.productImpressionTracker.unregister();
    }
}
