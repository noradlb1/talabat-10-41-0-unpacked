package com.talabat.darkstores.feature.product;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;
import com.designsystem.marshmallow.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.ResultKt;
import com.talabat.darkstores.common.base.BaseViewModel;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.darkstores.data.SearchResultData;
import com.talabat.darkstores.data.TrackingInfo;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker;
import com.talabat.darkstores.domain.common.BuildCartNavigationActionUseCase;
import com.talabat.darkstores.feature.cart.BasketLifeTimeTooltipUseCase;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.product.ProductFragmentDirections;
import com.talabat.darkstores.feature.product.models.CampaignAddedQuantity;
import com.talabat.darkstores.feature.product.models.CampaignFreeQuantity;
import com.talabat.darkstores.feature.product.models.ProductCampaign;
import com.talabat.darkstores.feature.product.models.SwimlaneLabel;
import com.talabat.darkstores.feature.product.usecase.ProductSwimlanesUseCase;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import com.talabat.feature.darkstorescart.data.model.ProductUrl;
import com.talabat.feature.darkstorescart.data.model.Tracking;
import com.talabat.wrapper.EventWrapper;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import jj.d;
import jj.e;
import jj.f;
import jj.g;
import jj.h;
import jj.i;
import jj.j;
import jj.k;
import jj.l;
import jj.m;
import jj.n;
import jj.o;
import jj.p;
import jj.q;
import jj.r;
import jj.s;
import jj.t;
import jj.u;
import jj.v;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001By\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0HJ\f\u0010I\u001a\b\u0012\u0004\u0012\u00020#0HJ\u001f\u0010$\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%j\u0002`(0Hø\u0001\u0000J\u000e\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020+J\b\u0010L\u001a\u00020!H\u0002J\b\u0010M\u001a\u000206H\u0002J\u001e\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020+J\u0006\u0010U\u001a\u00020\u0007J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00070WH\u0002J\u000e\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00070WH\u0002J\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u0002060.2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010Z\u001a\u000206J\u000e\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0WH\u0002J\b\u0010]\u001a\u00020FH\u0002J\u0010\u0010^\u001a\u00020!2\b\u0010_\u001a\u0004\u0018\u000106J\u000e\u0010`\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010a\u001a\u00020+J\u0012\u0010b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000204030HJ\u001c\u0010c\u001a\u00020!2\b\u0010d\u001a\u0004\u0018\u00010#2\b\u0010e\u001a\u0004\u0018\u000106H\u0002J\u0006\u0010f\u001a\u00020!J\u0014\u0010g\u001a\u00020!2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00070.J\u001a\u0010i\u001a\u00020!2\b\u0010d\u001a\u0004\u0018\u00010#2\b\u0010e\u001a\u0004\u0018\u000106J\u0006\u0010j\u001a\u00020!J:\u0010k\u001a\u00020;2\u0006\u0010l\u001a\u0002062\u0006\u0010m\u001a\u0002062\b\u0010n\u001a\u0004\u0018\u00010o2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00070.2\b\u0010q\u001a\u0004\u0018\u00010rH\u0002J\u0012\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0:0HJ\u0010\u0010s\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010t\u001a\u00020!2\u0006\u0010u\u001a\u00020AJ\f\u0010D\u001a\b\u0012\u0004\u0012\u00020+0HJ\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0HJ\f\u0010v\u001a\b\u0012\u0004\u0012\u00020#0HJ\u001a\u0010w\u001a\u00020!2\u0006\u0010d\u001a\u00020#2\b\u0010e\u001a\u0004\u0018\u000106H\u0002JM\u0010x\u001a\u00020!2\u0006\u0010y\u001a\u00020+2\u0006\u0010z\u001a\u0002062\u0006\u0010{\u001a\u0002062\b\u0010|\u001a\u0004\u0018\u0001062\u0006\u0010}\u001a\u0002062\u0006\u0010~\u001a\u0002062\t\u0010\u001a\u0005\u0018\u00010\u00012\b\u0010d\u001a\u0004\u0018\u00010#J\u001b\u0010\u0001\u001a\u00020!2\u0006\u0010m\u001a\u0002062\b\u0010q\u001a\u0004\u0018\u00010rH\u0002R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R'\u0010$\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%j\u0002`(0 X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010+0+0*X\u0004¢\u0006\u0002\n\u0000R(\u0010-\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 ,*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010.0.0*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020+XD¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u001a\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000204030 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R%\u00105\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u0001060%0 ¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0:0 X\u0004¢\u0006\u0002\n\u0000R#\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00070%0 ¢\u0006\b\n\u0000\u001a\u0004\b=\u00108R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00070 ¢\u0006\b\n\u0000\u001a\u0004\b?\u00108R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010@\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010A0A0*X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020C0*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020+0 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020F0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020#0 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lcom/talabat/darkstores/feature/product/ProductFragmentViewModel;", "Lcom/talabat/darkstores/common/base/BaseViewModel;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "tracker", "Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "productTracker", "Lcom/talabat/darkstores/data/tracking/product/ProductTracker;", "swimlanesTracker", "Lcom/talabat/darkstores/data/tracking/product/swimlanes/SwimlanesTracker;", "iTalabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "basketLifeTimeTooltipUseCase", "Lcom/talabat/darkstores/feature/cart/BasketLifeTimeTooltipUseCase;", "productSwimlanesUseCase", "Lcom/talabat/darkstores/feature/product/usecase/ProductSwimlanesUseCase;", "rxSchedulersFactory", "Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "buildCartNavigationAction", "Lcom/talabat/darkstores/domain/common/BuildCartNavigationActionUseCase;", "(Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/feature/darkstorescart/data/model/Product;Lio/reactivex/disposables/CompositeDisposable;Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;Lcom/talabat/darkstores/data/tracking/product/ProductTracker;Lcom/talabat/darkstores/data/tracking/product/swimlanes/SwimlanesTracker;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/darkstores/feature/cart/BasketLifeTimeTooltipUseCase;Lcom/talabat/darkstores/feature/product/usecase/ProductSwimlanesUseCase;Lcom/talabat/core/dispatcher/domain/RxSchedulersFactory;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/darkstores/domain/common/BuildCartNavigationActionUseCase;)V", "basketLifetimeTooltipLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "bottomProductExtendedInfoLiveData", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;", "campaignProgressData", "Lkotlin/Pair;", "Lcom/talabat/darkstores/feature/product/models/CampaignAddedQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignFreeQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignProgressData;", "canAddFreeProductSubject", "Lio/reactivex/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "cartProductsSubject", "", "isDesignSystemEnabled", "()Z", "isDesignSystemStepperEnabled", "navigationActionsLiveData", "Lcom/talabat/wrapper/EventWrapper;", "Landroidx/navigation/NavDirections;", "productDescriptionExpandState", "", "getProductDescriptionExpandState", "()Landroidx/lifecycle/MutableLiveData;", "productFragmentLiveData", "Lcom/talabat/darkstores/common/Result;", "Lcom/talabat/darkstores/feature/product/ProductFragmentData;", "productImagesZoomState", "getProductImagesZoomState", "productReadyLiveData", "getProductReadyLiveData", "quantityChangedSubject", "", "retrySubject", "", "showDiscountUsageLabelLiveData", "swimlaneLabelLiveData", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel;", "topProductExtendedInfoLiveData", "Landroidx/lifecycle/LiveData;", "bottomProductExtendedInfo", "canAddFreeProduct", "canAdd", "checkAndShowBasketLifetimeTooltip", "getExtendedInfoVariation", "getFormattedPrice", "", "priceAmount", "", "context", "Landroid/content/Context;", "hasPrevPrice", "getProduct", "getProductDetails", "Lio/reactivex/Single;", "getProductIfNeeded", "getProductImages", "getSelectedLanguage", "getSwimlanes", "Lcom/talabat/darkstores/data/SearchResultData;", "getSwimlanesTitle", "handleProductDescription", "description", "handleProductImages", "isExtendedInfoEnabled", "navigationActions", "notifyProductExtendedInfo", "productExtendedInfo", "productDescription", "onCartIndicatorClick", "onCartQuantityChanged", "products", "onProductExtendedInfoReceived", "onRetry", "prepareFragmentData", "swimlaneId", "swimlaneName", "campaign", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign;", "swimlanes", "trackingInfo", "Lcom/talabat/darkstores/data/TrackingInfo;", "productWithForSureMeaningfulDiscount", "quantityChanged", "quantity", "topProductExtendedInfo", "trackProductExtendedInfoShown", "trackProductOpened", "shouldTrackProductOpenedEvent", "deeplinkUri", "eventOrigin", "swimlaneRequestId", "searchRequestId", "searchTerm", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "trackSwimlanesLoadedEvent", "Companion", "Factory", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductFragmentViewModel extends BaseViewModel {
    @NotNull
    private static final String CAMPAIGN_BENEFIT_TAG = "campaign-benefit";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_SWIMLANE_COUNT = 10;
    @NotNull
    private static final String VARIATION_1 = "Variation1";
    @NotNull
    private static final String VARIATION_2 = "Variation2";
    @NotNull
    private final BasketLifeTimeTooltipUseCase basketLifeTimeTooltipUseCase;
    @NotNull
    private final MutableLiveData<Unit> basketLifetimeTooltipLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<ProductExtendedInfo> bottomProductExtendedInfoLiveData = new MutableLiveData<>();
    @NotNull
    private final BuildCartNavigationActionUseCase buildCartNavigationAction;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Pair<CampaignAddedQuantity, CampaignFreeQuantity>> campaignProgressData = new MutableLiveData<>();
    @NotNull
    private final PublishSubject<Boolean> canAddFreeProductSubject;
    @NotNull
    private final PublishSubject<List<Product>> cartProductsSubject;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final DiscoveryRepo discoveryRepo;
    @NotNull
    private final ITalabatFeatureFlag iTalabatFeatureFlag;
    private final boolean isDesignSystemEnabled;
    private final boolean isDesignSystemStepperEnabled;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<EventWrapper<NavDirections>> navigationActionsLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public Product product;
    @NotNull
    private final MutableLiveData<Pair<Boolean, String>> productDescriptionExpandState = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<ProductFragmentData>> productFragmentLiveData = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Pair<Boolean, Product>> productImagesZoomState = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Product> productReadyLiveData = new MutableLiveData<>();
    @NotNull
    private final ProductSwimlanesUseCase productSwimlanesUseCase;
    @NotNull
    private final ProductTracker productTracker;
    @NotNull
    private final PublishSubject<Integer> quantityChangedSubject;
    @NotNull
    private final PublishSubject<Object> retrySubject;
    @NotNull
    private final RxSchedulersFactory rxSchedulersFactory;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> showDiscountUsageLabelLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<SwimlaneLabel> swimlaneLabelLiveData = new MutableLiveData<>();
    @NotNull
    private final SwimlanesTracker swimlanesTracker;
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final MutableLiveData<ProductExtendedInfo> topProductExtendedInfoLiveData = new MutableLiveData<>();
    @NotNull
    private final DarkstoresEventTracker tracker;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/product/ProductFragmentViewModel$Companion;", "", "()V", "CAMPAIGN_BENEFIT_TAG", "", "MAX_SWIMLANE_COUNT", "", "VARIATION_1", "VARIATION_2", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/feature/product/ProductFragmentViewModel$Factory;", "", "create", "Lcom/talabat/darkstores/feature/product/ProductFragmentViewModel;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        ProductFragmentViewModel create(@NotNull Product product);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public ProductFragmentViewModel(@NotNull DiscoveryRepo discoveryRepo2, @NotNull DarkstoresRepo darkstoresRepo, @NotNull @Assisted Product product2, @NotNull CompositeDisposable compositeDisposable, @NotNull DarkstoresEventTracker darkstoresEventTracker, @NotNull ProductTracker productTracker2, @NotNull SwimlanesTracker swimlanesTracker2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag2, @NotNull BasketLifeTimeTooltipUseCase basketLifeTimeTooltipUseCase2, @NotNull ProductSwimlanesUseCase productSwimlanesUseCase2, @NotNull RxSchedulersFactory rxSchedulersFactory2, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull BuildCartNavigationActionUseCase buildCartNavigationActionUseCase) {
        super(compositeDisposable);
        Intrinsics.checkNotNullParameter(discoveryRepo2, "discoveryRepo");
        Intrinsics.checkNotNullParameter(darkstoresRepo, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(product2, "product");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        Intrinsics.checkNotNullParameter(darkstoresEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(productTracker2, "productTracker");
        Intrinsics.checkNotNullParameter(swimlanesTracker2, "swimlanesTracker");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "iTalabatFeatureFlag");
        Intrinsics.checkNotNullParameter(basketLifeTimeTooltipUseCase2, "basketLifeTimeTooltipUseCase");
        Intrinsics.checkNotNullParameter(productSwimlanesUseCase2, "productSwimlanesUseCase");
        Intrinsics.checkNotNullParameter(rxSchedulersFactory2, "rxSchedulersFactory");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(buildCartNavigationActionUseCase, "buildCartNavigationAction");
        this.discoveryRepo = discoveryRepo2;
        this.product = product2;
        this.tracker = darkstoresEventTracker;
        this.productTracker = productTracker2;
        this.swimlanesTracker = swimlanesTracker2;
        this.iTalabatFeatureFlag = iTalabatFeatureFlag2;
        this.basketLifeTimeTooltipUseCase = basketLifeTimeTooltipUseCase2;
        this.productSwimlanesUseCase = productSwimlanesUseCase2;
        this.rxSchedulersFactory = rxSchedulersFactory2;
        this.talabatExperiment = iTalabatExperiment;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.buildCartNavigationAction = buildCartNavigationActionUseCase;
        PublishSubject<Object> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this.retrySubject = create;
        PublishSubject<List<Product>> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<List<Product>>()");
        this.cartProductsSubject = create2;
        PublishSubject<Boolean> create3 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<Boolean>()");
        this.canAddFreeProductSubject = create3;
        PublishSubject<Integer> create4 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<Int>()");
        this.quantityChangedSubject = create4;
        this.isDesignSystemEnabled = iTalabatFeatureFlag2.getFeatureFlag(TalabatFeatureFlagConstants.DESIGN_SYSTEM_DARKSTORES_SCREEN_ADOPTION, false);
        Maybe<R> cache = getProductIfNeeded().subscribeOn(Schedulers.io()).doOnSuccess(new o(this)).flatMapMaybe(new p(darkstoresRepo)).cache();
        Observables observables = Observables.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(cache, "campaignForProduct");
        Maybe<U> ofType = cache.ofType(ProductCampaign.Free.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType, "ofType(R::class.java)");
        Observable<U> observable = ofType.toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "campaignForProduct.ofTyp…gn.Free>().toObservable()");
        Observable<R> map = observables.combineLatest(observable, create2).map(new q(this));
        Intrinsics.checkNotNullExpressionValue(map, "Observables\n            …rtProducts)\n            }");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default((Observable) map, (Function1) null, (Function0) null, (Function1) new Function1<Pair<? extends CampaignAddedQuantity, ? extends CampaignFreeQuantity>, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ProductFragmentViewModel f56496g;

            {
                this.f56496g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair<CampaignAddedQuantity, CampaignFreeQuantity>) (Pair) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Pair<CampaignAddedQuantity, CampaignFreeQuantity> pair) {
                this.f56496g.campaignProgressData.postValue(pair);
            }
        }, 3, (Object) null));
        Observable<R> observable2 = cache.flatMap(new r(this)).switchIfEmpty(getSwimlanes().map(new s(this))).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable2, "campaignForProduct\n     …          .toObservable()");
        Observable<Result<Type>> repeatWhen = ResultKt.toResult(observable2).repeatWhen(new t(this));
        Intrinsics.checkNotNullExpressionValue(repeatWhen, "campaignForProduct\n     …latMap { retrySubject } }");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default((Observable) repeatWhen, (Function1) null, (Function0) null, (Function1) new Function1<Result<ProductFragmentData>, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ProductFragmentViewModel f56497g;

            {
                this.f56497g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Result<ProductFragmentData>) (Result) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Result<ProductFragmentData> result) {
                this.f56497g.productFragmentLiveData.postValue(result);
            }
        }, 3, (Object) null));
        Boolean bool = Boolean.FALSE;
        Observable<R> flatMapMaybe = create3.startWith(bool).distinctUntilChanged().flatMapMaybe(new u(cache, this));
        Intrinsics.checkNotNullExpressionValue(flatMapMaybe, "canAddFreeProductSubject…nesTitle())\n            }");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default((Observable) flatMapMaybe, (Function1) null, (Function0) null, (Function1) new Function1<SwimlaneLabel, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ProductFragmentViewModel f56498g;

            {
                this.f56498g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SwimlaneLabel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SwimlaneLabel swimlaneLabel) {
                if (!Intrinsics.areEqual((Object) swimlaneLabel, (Object) SwimlaneLabel.Swimlanes.INSTANCE)) {
                    this.f56498g.swimlaneLabelLiveData.postValue(swimlaneLabel);
                }
            }
        }, 3, (Object) null));
        Maybe<U> ofType2 = cache.ofType(ProductCampaign.Discount.class);
        Intrinsics.checkExpressionValueIsNotNull(ofType2, "ofType(R::class.java)");
        Observable<R> observable3 = ofType2.map(new v()).filter(new e()).toObservable();
        Observable<Integer> startWith = create4.startWith(Integer.valueOf(this.product.getCartCount()));
        Intrinsics.checkNotNullExpressionValue(startWith, "quantityChangedSubject.s…rtWith(product.cartCount)");
        Intrinsics.checkNotNullExpressionValue(observable3, "discountCampaignUsageLimit");
        Observable<R> combineLatest = Observable.combineLatest(startWith, observable3, new ProductFragmentViewModel$special$$inlined$combineLatest$1());
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        Observable<R> distinctUntilChanged = combineLatest.startWith(bool).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "Observables\n            …  .distinctUntilChanged()");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default((Observable) distinctUntilChanged, (Function1) null, (Function0) null, (Function1) new Function1<Boolean, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ProductFragmentViewModel f56495g;

            {
                this.f56495g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                this.f56495g.showDiscountUsageLabelLiveData.postValue(bool);
            }
        }, 3, (Object) null));
        checkAndShowBasketLifetimeTooltip();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m10011_init_$lambda0(ProductFragmentViewModel productFragmentViewModel, Product product2) {
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        Intrinsics.checkNotNullExpressionValue(product2, "it");
        Product productWithForSureMeaningfulDiscount = productFragmentViewModel.productWithForSureMeaningfulDiscount(product2);
        productFragmentViewModel.product = productWithForSureMeaningfulDiscount;
        productFragmentViewModel.productReadyLiveData.postValue(productWithForSureMeaningfulDiscount);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final MaybeSource m10012_init_$lambda1(DarkstoresRepo darkstoresRepo, Product product2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "$darkstoresRepo");
        Intrinsics.checkNotNullParameter(product2, "product");
        return darkstoresRepo.getCampaignForProduct(product2.getId());
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-11  reason: not valid java name */
    public static final MaybeSource m10013_init_$lambda11(Maybe maybe, ProductFragmentViewModel productFragmentViewModel, Boolean bool) {
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(bool, "canAdd");
        return maybe.map(new f(bool, productFragmentViewModel)).defaultIfEmpty(productFragmentViewModel.getSwimlanesTitle());
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-12  reason: not valid java name */
    public static final Integer m10014_init_$lambda12(ProductCampaign.Discount discount) {
        int i11;
        Intrinsics.checkNotNullParameter(discount, "it");
        Integer usageLimit = discount.getUsageLimit();
        if (usageLimit != null) {
            i11 = usageLimit.intValue();
        } else {
            i11 = 0;
        }
        return Integer.valueOf(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-13  reason: not valid java name */
    public static final boolean m10015_init_$lambda13(Integer num) {
        Intrinsics.checkNotNullParameter(num, "it");
        if (num.intValue() > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final Pair m10016_init_$lambda2(ProductFragmentViewModel productFragmentViewModel, Pair pair) {
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        List list = (List) pair.component2();
        String id2 = productFragmentViewModel.product.getId();
        Intrinsics.checkNotNullExpressionValue(list, "cartProducts");
        return ((ProductCampaign.Free) pair.component1()).getProgressData(id2, list);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-6  reason: not valid java name */
    public static final MaybeSource m10017_init_$lambda6(ProductFragmentViewModel productFragmentViewModel, ProductCampaign productCampaign) {
        Single<SearchResultData> single;
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(productCampaign, "campaign");
        if ((productCampaign instanceof ProductCampaign.Free.MixAndMatch) || (productCampaign instanceof ProductCampaign.Free.MixAndMatchDiscount)) {
            single = productFragmentViewModel.discoveryRepo.getProductsForTag(productCampaign.createTag(), 10, 0).map(new d());
        } else {
            single = productFragmentViewModel.getSwimlanes();
        }
        return single.map(new n(productFragmentViewModel, productCampaign)).toMaybe();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-7  reason: not valid java name */
    public static final ProductFragmentData m10018_init_$lambda7(ProductFragmentViewModel productFragmentViewModel, SearchResultData searchResultData) {
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(searchResultData, "<name for destructuring parameter 0>");
        List<Product> component1 = searchResultData.component1();
        String component2 = searchResultData.component2();
        String component3 = searchResultData.component3();
        TrackingInfo component6 = searchResultData.component6();
        productFragmentViewModel.trackSwimlanesLoadedEvent(component3, component6);
        return productFragmentViewModel.prepareFragmentData(component2, component3, (ProductCampaign) null, component1, component6);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-9  reason: not valid java name */
    public static final ObservableSource m10019_init_$lambda9(ProductFragmentViewModel productFragmentViewModel, Observable observable) {
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(observable, "it");
        return observable.flatMap(new i(productFragmentViewModel));
    }

    private final void checkAndShowBasketLifetimeTooltip() {
        CompositeDisposable a11 = a();
        Disposable subscribe = this.basketLifeTimeTooltipUseCase.isBasketLifetimeTooltipEnabled().subscribeOn(this.rxSchedulersFactory.io()).filter(new j()).flatMapObservable(new k(this)).filter(new l()).subscribe(new m(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "basketLifeTimeTooltipUse…Value(Unit)\n            }");
        DisposableKt.plusAssign(a11, subscribe);
    }

    /* access modifiers changed from: private */
    /* renamed from: checkAndShowBasketLifetimeTooltip$lambda-23  reason: not valid java name */
    public static final boolean m10020checkAndShowBasketLifetimeTooltip$lambda23(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "isBasketLifetimeTooltipEnabled");
        return bool.booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: checkAndShowBasketLifetimeTooltip$lambda-24  reason: not valid java name */
    public static final ObservableSource m10021checkAndShowBasketLifetimeTooltip$lambda24(ProductFragmentViewModel productFragmentViewModel, Boolean bool) {
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(bool, "it");
        return productFragmentViewModel.quantityChangedSubject.hide();
    }

    /* access modifiers changed from: private */
    /* renamed from: checkAndShowBasketLifetimeTooltip$lambda-25  reason: not valid java name */
    public static final boolean m10022checkAndShowBasketLifetimeTooltip$lambda25(Integer num) {
        Intrinsics.checkNotNullParameter(num, FirebaseAnalytics.Param.QUANTITY);
        if (num.intValue() > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: checkAndShowBasketLifetimeTooltip$lambda-26  reason: not valid java name */
    public static final void m10023checkAndShowBasketLifetimeTooltip$lambda26(ProductFragmentViewModel productFragmentViewModel, Integer num) {
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        productFragmentViewModel.basketLifetimeTooltipLiveData.postValue(Unit.INSTANCE);
    }

    private final String getExtendedInfoVariation() {
        return this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.PRODUCT_DETAILS_PAGE_EXTENDED_INFO, "", TalabatExperimentDataSourceStrategy.FWF);
    }

    private final Single<Product> getProductDetails() {
        boolean z11;
        if (this.product.getId().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return this.discoveryRepo.getProductDetails(this.product.getId());
        }
        return this.discoveryRepo.getProductDetailsBySku(this.product.getSku());
    }

    private final Single<Product> getProductIfNeeded() {
        boolean z11;
        if (this.product.getName().length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return getProductDetails();
        }
        if (isExtendedInfoEnabled() && this.product.getExtendedInfo() == null) {
            Single<Product> subscribeOn = getProductDetails().subscribeOn(this.rxSchedulersFactory.io());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "getProductDetails()\n    …rxSchedulersFactory.io())");
            SubscribersKt.subscribeBy$default((Single) subscribeOn, (Function1) null, (Function1) new ProductFragmentViewModel$getProductIfNeeded$1(this), 1, (Object) null);
        }
        Single<Product> just = Single.just(this.product);
        Intrinsics.checkNotNullExpressionValue(just, "private fun getProductIf…(product)\n        }\n    }");
        return just;
    }

    private final Single<SearchResultData> getSwimlanes() {
        Single<SearchResultData> flatMap = Single.fromCallable(new g(this)).flatMap(new h(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "fromCallable {\n         …)\n            }\n        }");
        return flatMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: getSwimlanes$lambda-16  reason: not valid java name */
    public static final Boolean m10024getSwimlanes$lambda16(ProductFragmentViewModel productFragmentViewModel) {
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        return Boolean.valueOf(productFragmentViewModel.iTalabatFeatureFlag.getFeatureFlag(QCommerceFeatureFlagsKeys.PRODUCT_DETAIL_PAGE_SWIMLANES, false));
    }

    /* access modifiers changed from: private */
    /* renamed from: getSwimlanes$lambda-17  reason: not valid java name */
    public static final SingleSource m10025getSwimlanes$lambda17(ProductFragmentViewModel productFragmentViewModel, Boolean bool) {
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(bool, "isSwimlanesEnabled");
        if (bool.booleanValue()) {
            return productFragmentViewModel.productSwimlanesUseCase.getSwimlanes(productFragmentViewModel.product.getId(), productFragmentViewModel.product.getSku());
        }
        return productFragmentViewModel.discoveryRepo.getPopularProducts();
    }

    private final SwimlaneLabel getSwimlanesTitle() {
        if (this.iTalabatFeatureFlag.getFeatureFlag(QCommerceFeatureFlagsKeys.PRODUCT_DETAIL_PAGE_SWIMLANES, false)) {
            return SwimlaneLabel.Swimlanes.INSTANCE;
        }
        return SwimlaneLabel.PopularProducts.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-11$lambda-10  reason: not valid java name */
    public static final SwimlaneLabel m10026lambda11$lambda10(Boolean bool, ProductFragmentViewModel productFragmentViewModel, ProductCampaign productCampaign) {
        Intrinsics.checkNotNullParameter(bool, "$canAdd");
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(productCampaign, "it");
        if (!bool.booleanValue()) {
            return productFragmentViewModel.getSwimlanesTitle();
        }
        if (productCampaign instanceof ProductCampaign.Free.MixAndMatchDiscount) {
            return new SwimlaneLabel.MixAndMatch.Discounted(productCampaign.benefitCount());
        }
        return new SwimlaneLabel.MixAndMatch.Free(productCampaign.benefitCount());
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-6$lambda-4  reason: not valid java name */
    public static final SearchResultData m10027lambda6$lambda4(SearchResultData searchResultData) {
        Intrinsics.checkNotNullParameter(searchResultData, "result");
        ArrayList arrayList = new ArrayList();
        for (Object next : searchResultData.getProducts()) {
            if (((Product) next).getTags().contains(CAMPAIGN_BENEFIT_TAG)) {
                arrayList.add(next);
            }
        }
        return SearchResultData.copy$default(searchResultData, arrayList, (String) null, (String) null, 0, (List) null, (TrackingInfo) null, 62, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-6$lambda-5  reason: not valid java name */
    public static final ProductFragmentData m10028lambda6$lambda5(ProductFragmentViewModel productFragmentViewModel, ProductCampaign productCampaign, SearchResultData searchResultData) {
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(productCampaign, "$campaign");
        Intrinsics.checkNotNullParameter(searchResultData, "<name for destructuring parameter 0>");
        List<Product> component1 = searchResultData.component1();
        String component2 = searchResultData.component2();
        String component3 = searchResultData.component3();
        TrackingInfo component6 = searchResultData.component6();
        productFragmentViewModel.trackSwimlanesLoadedEvent(component3, component6);
        return productFragmentViewModel.prepareFragmentData(component2, component3, productCampaign, component1, component6);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-9$lambda-8  reason: not valid java name */
    public static final ObservableSource m10029lambda9$lambda8(ProductFragmentViewModel productFragmentViewModel, Object obj) {
        Intrinsics.checkNotNullParameter(productFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(obj, "it");
        return productFragmentViewModel.retrySubject;
    }

    /* access modifiers changed from: private */
    public final void notifyProductExtendedInfo(ProductExtendedInfo productExtendedInfo, String str) {
        if (productExtendedInfo != null) {
            String extendedInfoVariation = getExtendedInfoVariation();
            if (Intrinsics.areEqual((Object) extendedInfoVariation, (Object) "Variation1")) {
                trackProductExtendedInfoShown(productExtendedInfo, str);
                this.topProductExtendedInfoLiveData.postValue(productExtendedInfo);
            } else if (Intrinsics.areEqual((Object) extendedInfoVariation, (Object) "Variation2")) {
                trackProductExtendedInfoShown(productExtendedInfo, str);
                this.bottomProductExtendedInfoLiveData.postValue(productExtendedInfo);
            }
        }
    }

    private final ProductFragmentData prepareFragmentData(String str, String str2, ProductCampaign productCampaign, List<Product> list, TrackingInfo trackingInfo) {
        String str3;
        Product product2 = this.product;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (!Intrinsics.areEqual((Object) ((Product) next).getId(), (Object) this.product.getId())) {
                arrayList.add(next);
            }
        }
        String str4 = null;
        if (trackingInfo != null) {
            str3 = trackingInfo.getRequestId();
        } else {
            str3 = null;
        }
        if (trackingInfo != null) {
            str4 = trackingInfo.getTrackingId();
        }
        return new ProductFragmentData(str, str2, product2, arrayList, productCampaign, str3, str4);
    }

    private final Product productWithForSureMeaningfulDiscount(Product product2) {
        Float previousPrice = product2.getPreviousPrice();
        Float f11 = null;
        if (previousPrice != null) {
            float floatValue = previousPrice.floatValue();
            if (floatValue > product2.getPrice()) {
                f11 = Float.valueOf(floatValue);
            }
        }
        return Product.copy$default(product2, (String) null, (String) null, (String) null, 0.0f, f11, 0, 0, (Integer) null, (Float) null, (Tracking) null, (String) null, 0, false, (List) null, (List) null, (String) null, (List) null, (String) null, false, (String) null, false, (CampaignTrigger) null, 0, (ProductExtendedInfo) null, (List) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, 2147483631, (Object) null);
    }

    private final void trackProductExtendedInfoShown(ProductExtendedInfo productExtendedInfo, String str) {
        boolean z11 = true;
        boolean z12 = !productExtendedInfo.isInValidProductExtendedInfo();
        ProductTracker productTracker2 = this.productTracker;
        Product product2 = this.product;
        String screenName = this.tracker.getScreenName();
        if (!isExtendedInfoEnabled() || !z12) {
            z11 = false;
        }
        productTracker2.productExtendInfoShown(product2, screenName, z11, productExtendedInfo.getTrackingData(str));
    }

    private final void trackSwimlanesLoadedEvent(String str, TrackingInfo trackingInfo) {
        boolean z11;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && trackingInfo != null) {
            SwimlanesTracker.swimlanesLoaded$default(this.swimlanesTracker, trackingInfo.getRequestId(), (List) null, EventOriginType.Swimlane, (String) null, (String) null, 26, (Object) null);
        }
    }

    @NotNull
    public final LiveData<Unit> basketLifetimeTooltipLiveData() {
        return this.basketLifetimeTooltipLiveData;
    }

    @NotNull
    public final LiveData<ProductExtendedInfo> bottomProductExtendedInfo() {
        return this.bottomProductExtendedInfoLiveData;
    }

    @NotNull
    public final LiveData<Pair<CampaignAddedQuantity, CampaignFreeQuantity>> campaignProgressData() {
        return this.campaignProgressData;
    }

    public final void canAddFreeProduct(boolean z11) {
        this.canAddFreeProductSubject.onNext(Boolean.valueOf(z11));
    }

    @NotNull
    public final CharSequence getFormattedPrice(float f11, @NotNull Context context, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "context");
        return FloatExtensionsKt.getFormattedPriceAndCurrency(f11, context, z11, R.style.DSTextAppearance_Heading1, R.style.DSTextAppearance_Tag);
    }

    @NotNull
    public final Product getProduct() {
        return this.product;
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, String>> getProductDescriptionExpandState() {
        return this.productDescriptionExpandState;
    }

    @NotNull
    public final List<String> getProductImages(@NotNull Product product2) {
        Intrinsics.checkNotNullParameter(product2, "product");
        if (!product2.getImageUrls().isEmpty()) {
            Iterable<ProductUrl> imageUrls = product2.getImageUrls();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(imageUrls, 10));
            for (ProductUrl url : imageUrls) {
                arrayList.add(url.getUrl());
            }
            return arrayList;
        }
        String imageUrl = product2.getImageUrl();
        if (imageUrl == null) {
            imageUrl = "";
        }
        return CollectionsKt__CollectionsJVMKt.listOf(imageUrl);
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, Product>> getProductImagesZoomState() {
        return this.productImagesZoomState;
    }

    @NotNull
    public final MutableLiveData<Product> getProductReadyLiveData() {
        return this.productReadyLiveData;
    }

    @NotNull
    public final String getSelectedLanguage() {
        return this.configurationLocalRepository.selectedLanguage().getLanguageCode();
    }

    public final void handleProductDescription(@Nullable String str) {
        this.iTalabatFeatureFlag.getFeatureFlag((FWFKey) TalabatFeatureFlagConstants.ENABLE_PRODUCT_EXPAND_DECRIPTION, false, false, (Function1<? super Boolean, Unit>) new ProductFragmentViewModel$handleProductDescription$1(this, str));
    }

    public final void handleProductImages(@NotNull Product product2) {
        Intrinsics.checkNotNullParameter(product2, "product");
        this.iTalabatFeatureFlag.getFeatureFlag((FWFKey) TalabatFeatureFlagConstants.ENABLE_PRODUCT_ZOOM_IMAGE, false, false, (Function1<? super Boolean, Unit>) new ProductFragmentViewModel$handleProductImages$1(this, product2));
    }

    public final boolean isDesignSystemEnabled() {
        return this.isDesignSystemEnabled;
    }

    public final boolean isDesignSystemStepperEnabled() {
        return this.isDesignSystemStepperEnabled;
    }

    public final boolean isExtendedInfoEnabled() {
        String extendedInfoVariation = getExtendedInfoVariation();
        if (Intrinsics.areEqual((Object) extendedInfoVariation, (Object) "Variation1")) {
            return true;
        }
        return Intrinsics.areEqual((Object) extendedInfoVariation, (Object) "Variation2");
    }

    @NotNull
    public final LiveData<EventWrapper<NavDirections>> navigationActions() {
        return this.navigationActionsLiveData;
    }

    public final void onCartIndicatorClick() {
        CompositeDisposable a11 = a();
        BuildCartNavigationActionUseCase buildCartNavigationActionUseCase = this.buildCartNavigationAction;
        ProductFragmentDirections.Companion companion = ProductFragmentDirections.Companion;
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Single) buildCartNavigationActionUseCase.invoke(new ProductFragmentViewModel$onCartIndicatorClick$1(companion), new ProductFragmentViewModel$onCartIndicatorClick$2(companion)), (Function1) null, (Function1) new ProductFragmentViewModel$onCartIndicatorClick$3(this), 1, (Object) null));
    }

    public final void onCartQuantityChanged(@NotNull List<Product> list) {
        Intrinsics.checkNotNullParameter(list, "products");
        this.cartProductsSubject.onNext(list);
    }

    public final void onProductExtendedInfoReceived(@Nullable ProductExtendedInfo productExtendedInfo, @Nullable String str) {
        if (isExtendedInfoEnabled()) {
            notifyProductExtendedInfo(productExtendedInfo, str);
        }
    }

    public final void onRetry() {
        this.retrySubject.onNext(Unit.INSTANCE);
    }

    @NotNull
    public final LiveData<Result<ProductFragmentData>> productFragmentLiveData() {
        return this.productFragmentLiveData;
    }

    public final void quantityChanged(int i11) {
        this.quantityChangedSubject.onNext(Integer.valueOf(i11));
    }

    @NotNull
    public final LiveData<Boolean> showDiscountUsageLabelLiveData() {
        return this.showDiscountUsageLabelLiveData;
    }

    @NotNull
    public final LiveData<SwimlaneLabel> swimlaneLabelLiveData() {
        return this.swimlaneLabelLiveData;
    }

    @NotNull
    public final LiveData<ProductExtendedInfo> topProductExtendedInfo() {
        return this.topProductExtendedInfoLiveData;
    }

    public final void trackProductOpened(boolean z11, @NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @Nullable ProductClickTrackingAttribute productClickTrackingAttribute, @Nullable ProductExtendedInfo productExtendedInfo) {
        ProductExtendedInfo productExtendedInfo2 = productExtendedInfo;
        String str6 = str;
        Intrinsics.checkNotNullParameter(str, "deeplinkUri");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        Intrinsics.checkNotNullParameter(str4, "searchRequestId");
        Intrinsics.checkNotNullParameter(str5, "searchTerm");
        if (z11) {
            this.productTracker.productOpened(this.product, false, this.tracker.getScreenName(), str, str2, str3, str4, str5, productClickTrackingAttribute);
        }
        if (productExtendedInfo2 != null) {
            trackProductExtendedInfoShown(productExtendedInfo2, this.product.getDescription());
        }
    }
}
