package com.talabat.darkstores.feature.cart;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.navigation.NavDestination;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.integration.nfv.observability.NfvObservabilityHandler;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointData;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.entity.QCommerceScreenTracingNames;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.OnProductQuantityChangeTrackingListener;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.ResultKt;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.common.base.BaseViewModel;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.DarkstoresConstantsKt;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.deliveryfee.FlutterDeliveryFeeTierRequest;
import com.talabat.darkstores.data.deliveryfee.FlutterDeliveryTierMapper;
import com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetails;
import com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetailsRepo;
import com.talabat.darkstores.data.partialFulfillment.model.Control;
import com.talabat.darkstores.data.partialFulfillment.model.PreferencesResponse;
import com.talabat.darkstores.data.partialFulfillment.remote.PartialFulfillmentRepo;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.data.tracking.bottomsheet.tracker.BottomSheetClickOriginIconType;
import com.talabat.darkstores.data.tracking.bottomsheet.tracker.DarkStoreBottomSheetTracker;
import com.talabat.darkstores.data.tracking.bottomsheet.tracker.DarkStoresBottomSheetName;
import com.talabat.darkstores.data.tracking.bottomsheet.tracker.DeliveryFeeFlowType;
import com.talabat.darkstores.data.tracking.fees.FeeTrackingConstantsKt;
import com.talabat.darkstores.data.tracking.fees.events.swimlane.CartSwimlaneShownEvent;
import com.talabat.darkstores.data.tracking.fees.events.swimlane.CartSwimlaneSwipedEvent;
import com.talabat.darkstores.data.tracking.fees.tracker.IDarkstoresFeesTracker;
import com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker;
import com.talabat.darkstores.di.InjectorKt;
import com.talabat.darkstores.domain.basket.SaveBasketUpsellBottomSheetShownUseCase;
import com.talabat.darkstores.domain.common.BuildBasketUpsellActionUseCase;
import com.talabat.darkstores.domain.common.BuildDeliveryFeeTierNavigationUseCase;
import com.talabat.darkstores.feature.campaigns.CampaignProgressVisualisation;
import com.talabat.darkstores.feature.cart.cartabadonment.StartCartClearedEventTrackerUseCase;
import com.talabat.darkstores.feature.cart.model.BottomCartViewState;
import com.talabat.darkstores.feature.cart.model.CartProductViewType;
import com.talabat.darkstores.feature.cart.model.FeeDescriptionDisplayModelKt;
import com.talabat.darkstores.feature.cart.model.ScreenTrackingInfo;
import com.talabat.darkstores.feature.cart.multibasket.InitCartUseCase;
import com.talabat.darkstores.feature.checkout.DarkstoresListener;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import com.talabat.darkstores.feature.main.viewmodel.DeliveryTierClickOrigin;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.darkstores.feature.tracking.data.VendorVisitDetails;
import com.talabat.feature.darkstores.domain.disclaimer.DisclaimerRepository;
import com.talabat.feature.darkstores.domain.repository.DarkstoresRepository;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagManager;
import com.talabat.feature.darkstorescart.data.model.CampaignLabel;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.feature.darkstorescart.data.model.CartResponseProduct;
import com.talabat.feature.darkstorescart.data.model.CartVendor;
import com.talabat.feature.darkstorescart.data.model.CheckoutParams;
import com.talabat.feature.darkstorescart.data.model.FeeDescription;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescartlist.domain.model.CartListToast;
import com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCase;
import com.talabat.feature.darkstorescartlist.domain.usecase.InvalidateCartListCacheUseCase;
import com.talabat.feature.darkstoresvendor.domain.model.BasketDeliveryFeeTiersInfo;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import com.talabat.talabatcommon.optional.Optional;
import com.talabat.talabatcommon.optional.OptionalKt;
import com.talabat.wrapper.EventWrapper;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SinglesKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;
import ri.a0;
import ri.a1;
import ri.b0;
import ri.b1;
import ri.c0;
import ri.c1;
import ri.d0;
import ri.d1;
import ri.e0;
import ri.e1;
import ri.f0;
import ri.f1;
import ri.g0;
import ri.g1;
import ri.h0;
import ri.h1;
import ri.i0;
import ri.i1;
import ri.j0;
import ri.j1;
import ri.k0;
import ri.l0;
import ri.m0;
import ri.n0;
import ri.o0;
import ri.p0;
import ri.q0;
import ri.r0;
import ri.s;
import ri.s0;
import ri.t;
import ri.t0;
import ri.u;
import ri.u0;
import ri.v;
import ri.v0;
import ri.w;
import ri.w0;
import ri.x;
import ri.x0;
import ri.y;
import ri.y0;
import ri.z;
import ri.z0;

@Metadata(d1 = {"\u0000ª\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 Â\u00022\u00020\u00012\u00020\u0002:\b¿\u0002À\u0002Á\u0002Â\u0002Bÿ\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\"\u0012\u0006\u0010#\u001a\u00020$\u0012\u0006\u0010%\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020*\u0012\u0006\u0010+\u001a\u00020,\u0012\u0006\u0010-\u001a\u00020.\u0012\u0006\u0010/\u001a\u000200\u0012\u0006\u00101\u001a\u000202\u0012\u0006\u00103\u001a\u000204\u0012\u0006\u00105\u001a\u000206\u0012\u0006\u00107\u001a\u000208\u0012\u0006\u00109\u001a\u00020:\u0012\u0006\u0010;\u001a\u00020<\u0012\u0006\u0010=\u001a\u00020>\u0012\u0006\u0010?\u001a\u00020@¢\u0006\u0002\u0010AJ\u001b\u0010¶\u0001\u001a\u00020R2\n\u0010·\u0001\u001a\u0005\u0018\u00010¸\u00012\u0006\u0010X\u001a\u00020OJ\u0013\u0010¹\u0001\u001a\u00020R2\b\u0010º\u0001\u001a\u00030¦\u0001H\u0002J*\u0010»\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010|2\u000e\u0010¼\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010|2\b\u0010½\u0001\u001a\u00030¾\u0001H\u0002JC\u0010¿\u0001\u001a\u0019\u0012\u0014\u0012\u0012\u0012\u0005\u0012\u00030¦\u0001\u0012\u0006\u0012\u0004\u0018\u00010D0Á\u00010À\u00012\u0007\u0010Â\u0001\u001a\u00020P2\b\u0010º\u0001\u001a\u00030¦\u00012\u000e\u0010Ã\u0001\u001a\t\u0012\u0004\u0012\u00020R0Ä\u0001H\u0002J\u0007\u0010Å\u0001\u001a\u00020TJ\u0014\u0010Æ\u0001\u001a\u00030Ç\u00012\b\u0010½\u0001\u001a\u00030¾\u0001H\u0002J\f\u0010b\u001a\b\u0012\u0004\u0012\u00020c0jJ\u0013\u0010È\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020}0|0jJ\u001f\u0010É\u0001\u001a\u0011\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020P\u0018\u00010Á\u00012\u0007\u0010Ê\u0001\u001a\u00020OJ\u0017\u0010Ë\u0001\u001a\u00020T2\u000e\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00020G0Í\u0001J\u001e\u0010Î\u0001\u001a\u00020R2\b\u0010Ï\u0001\u001a\u00030Ð\u00012\u000b\b\u0002\u0010Ñ\u0001\u001a\u0004\u0018\u00010VJ\u0007\u0010Ò\u0001\u001a\u00020RJ\u0007\u0010Ó\u0001\u001a\u00020RJ\t\u0010Ô\u0001\u001a\u00020RH\u0002Jd\u0010Õ\u0001\u001a\u00020R2\b\u0010Ö\u0001\u001a\u00030\u00012\u0007\u0010×\u0001\u001a\u00020P2\t\u0010Ø\u0001\u001a\u0004\u0018\u00010P2\n\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u00012\n\u0010Û\u0001\u001a\u0005\u0018\u00010Ü\u00012\t\u0010Ý\u0001\u001a\u0004\u0018\u00010O2\t\u0010Þ\u0001\u001a\u0004\u0018\u00010O2\u0007\u0010ß\u0001\u001a\u00020TH\u0016¢\u0006\u0003\u0010à\u0001J\u0014\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010F0jJ\u0007\u0010á\u0001\u001a\u00020RJ\u001c\u0010â\u0001\u001a\u00020T2\u0007\u0010ã\u0001\u001a\u00020T2\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u0001J\u001d\u0010æ\u0001\u001a\u00020T2\b\u0010ç\u0001\u001a\u00030Ç\u00012\b\u0010è\u0001\u001a\u00030é\u0001H\u0002J\t\u0010ê\u0001\u001a\u00020TH\u0002J\u0013\u0010ë\u0001\u001a\u00030ì\u00012\u0007\u0010í\u0001\u001a\u00020TH\u0002J\u0012\u0010î\u0001\u001a\u00030ï\u00012\b\u0010ä\u0001\u001a\u00030å\u0001J \u0010ð\u0001\u001a\u00030ñ\u00012\b\u0010ò\u0001\u001a\u00030ó\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001H\u0002J\b\u0010ö\u0001\u001a\u00030õ\u0001J5\u0010÷\u0001\u001a\u00020R2\u001c\u0010ø\u0001\u001a\u0017\u0012\u0005\u0012\u00030ú\u0001\u0012\u0005\u0012\u00030û\u0001\u0012\u0004\u0012\u00020R0ù\u00012\u000e\u0010ü\u0001\u001a\t\u0012\u0004\u0012\u00020R0Ä\u0001J%\u0010ý\u0001\u001a\u00020R2\u001c\u0010ø\u0001\u001a\u0017\u0012\u0005\u0012\u00030ú\u0001\u0012\u0005\u0012\u00030û\u0001\u0012\u0004\u0012\u00020R0ù\u0001J\u001d\u0010þ\u0001\u001a\u00020R2\b\u0010ò\u0001\u001a\u00030ó\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001Jt\u0010ÿ\u0001\u001a\u00020R2\b\u0010Ö\u0001\u001a\u00030\u00012\u0007\u0010×\u0001\u001a\u00020P2\t\u0010Ø\u0001\u001a\u0004\u0018\u00010P2\n\u0010Ù\u0001\u001a\u0005\u0018\u00010Ú\u00012\n\u0010Û\u0001\u001a\u0005\u0018\u00010Ü\u00012\t\u0010Ý\u0001\u001a\u0004\u0018\u00010O2\t\u0010Þ\u0001\u001a\u0004\u0018\u00010O2\u0007\u0010ß\u0001\u001a\u00020T2\u000e\u0010Ã\u0001\u001a\t\u0012\u0004\u0012\u00020R0Ä\u0001H\u0016¢\u0006\u0003\u0010\u0002J\u0007\u0010\u0002\u001a\u00020RJ\t\u0010\u0002\u001a\u00020RH\u0002J\u0007\u0010\u0002\u001a\u00020TJ\u0007\u0010\u0002\u001a\u00020TJ\u0007\u0010\u0002\u001a\u00020RJ\u001a\u0010\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u00022\u0007\u0010\u0002\u001a\u00020OJ\u0010\u0010\u0002\u001a\u00020R2\u0007\u0010\u0002\u001a\u00020DJ\u0010\u0010\u0002\u001a\u00020R2\u0007\u0010\u0002\u001a\u00020DJ\t\u0010\u0002\u001a\u00020RH\u0016J\u001a\u0010\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030©\u00012\u0007\u0010\u0002\u001a\u00020TJ\u001b\u0010\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u0002J\u0007\u0010\u0002\u001a\u00020RJ\u0007\u0010\u0002\u001a\u00020RJ\u0007\u0010\u0002\u001a\u00020RJ\u0007\u0010\u0002\u001a\u00020RJ\u0007\u0010\u0002\u001a\u00020RJ\u0007\u0010\u0002\u001a\u00020RJ\u0006\u0010;\u001a\u00020RJ\u0011\u0010\u0002\u001a\u00020R2\b\u0010\u0002\u001a\u00030©\u0001J\u001b\u0010\u0002\u001a\u00020T2\u0007\u0010Â\u0001\u001a\u00020P2\u0007\u0010\u0002\u001a\u00020OH\u0002J\u000f\u0010\u0002\u001a\u00020RH\u0001¢\u0006\u0003\b\u0002J\u0007\u0010 \u0002\u001a\u00020TJ\u0007\u0010¡\u0002\u001a\u00020RJ\n\u0010¢\u0002\u001a\u00030£\u0002H\u0002J\u0007\u0010¤\u0002\u001a\u00020RJ\u0019\u0010¥\u0002\u001a\u00020R2\u0007\u0010¦\u0002\u001a\u00020O2\u0007\u0010\u0002\u001a\u00020OJ\u0013\u0010§\u0002\u001a\u00020R2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0007\u0010¨\u0002\u001a\u00020RJ\u0010\u0010©\u0002\u001a\u00020R2\u0007\u0010ª\u0002\u001a\u00020OJ\u0007\u0010«\u0002\u001a\u00020RJ\u0007\u0010¬\u0002\u001a\u00020RJ\u001e\u0010­\u0002\u001a\u00020R2\t\u0010¦\u0002\u001a\u0004\u0018\u00010O2\n\b\u0002\u0010\u0001\u001a\u00030\u0001J\u0010\u0010®\u0002\u001a\u00020R2\u0007\u0010¯\u0002\u001a\u00020J\u0019\u0010°\u0002\u001a\u00020R2\u0007\u0010¯\u0002\u001a\u000202\u0007\u0010±\u0002\u001a\u00020PJ\t\u0010²\u0002\u001a\u00020RH\u0002J\u0019\u0010³\u0002\u001a\u00020R2\u0007\u0010´\u0002\u001a\u00020T2\u0007\u0010µ\u0002\u001a\u00020OJ\u0011\u0010¶\u0002\u001a\u00020R2\b\u0010\u0001\u001a\u00030\u0001J\u0019\u0010·\u0002\u001a\u00020R2\b\u0010Ï\u0001\u001a\u00030Ð\u0001H\u0001¢\u0006\u0003\b¸\u0002J\u0010\u0010¹\u0002\u001a\u00020R2\u0007\u0010º\u0002\u001a\u00020OJ\u0007\u0010»\u0002\u001a\u00020RJ$\u0010¼\u0002\u001a\n\u0012\u0005\u0012\u0003H¾\u00020½\u0002\"\u0005\b\u0000\u0010¾\u0002*\n\u0012\u0005\u0012\u0003H¾\u00020½\u0002H\u0002R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0F0CX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I0CX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0I0CX\u0004¢\u0006\u0002\n\u0000R \u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P0N0CX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0F0CX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020T0CX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0I0CX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0I0CX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010X\u001a\u00020OX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R&\u0010]\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0I0CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u000e\u00109\u001a\u00020:X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010b\u001a\b\u0012\u0004\u0012\u00020c0CX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020D0C8F¢\u0006\u0006\u001a\u0004\be\u0010_R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010f\u001a\b\u0012\u0004\u0012\u00020h0gX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0F0j8F¢\u0006\u0006\u001a\u0004\bk\u0010lR\u001d\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I0j8F¢\u0006\u0006\u001a\u0004\bn\u0010lR\u001d\u0010o\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0I0j8F¢\u0006\u0006\u001a\u0004\bp\u0010lR7\u0010q\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P r*\u0010\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P\u0018\u00010N0N0j8F¢\u0006\u0006\u001a\u0004\bs\u0010lR\u001e\u0010v\u001a\u00020u2\u0006\u0010t\u001a\u00020u@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u001d\u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0F0j8F¢\u0006\u0006\u001a\u0004\bz\u0010lR\u001a\u0010{\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020}0|0CX\u0004¢\u0006\u0002\n\u0000R&\u0010~\u001a\b\u0012\u0004\u0012\u000200g8\u0000X\u0004¢\u0006\u0012\n\u0000\u0012\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020T0C8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010_R\u0016\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010gX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0001\u001a\u00020P¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0I0j8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010lR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0001\u001a\u00020O8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010ZR\u0016\u0010\u0001\u001a\u00020O8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010ZR\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010F0CX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0I0C¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010_R)\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0I0CX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010_\"\u0005\b\u0001\u0010aR\u0010\u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020TX\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020TX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020R0I0j8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010lR\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u001d\u0010¤\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030¦\u00010¥\u00010gX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010§\u0001\u001a\u0010\u0012\f\u0012\n r*\u0004\u0018\u00010R0R0gX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R-\u0010¨\u0001\u001a \u0012\u001c\u0012\u001a\u0012\u0005\u0012\u00030©\u0001 r*\f\u0012\u0005\u0012\u00030©\u0001\u0018\u00010¥\u00010¥\u00010gX\u0004¢\u0006\u0002\n\u0000R!\u0010ª\u0001\u001a\u00020T2\u0006\u0010t\u001a\u00020T@BX\u000e¢\u0006\n\n\u0000\u001a\u0006\b«\u0001\u0010¬\u0001R\u0017\u0010­\u0001\u001a\u00020T8BX\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¬\u0001R\u001a\u0010¯\u0001\u001a\t\u0012\u0005\u0012\u00030°\u00010j8F¢\u0006\u0007\u001a\u0005\b±\u0001\u0010lR\u0016\u0010²\u0001\u001a\t\u0012\u0005\u0012\u00030°\u00010CX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010³\u0001\u001a\u00020OX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010Z\"\u0005\bµ\u0001\u0010\\R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006Ã\u0002"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;", "Lcom/talabat/darkstores/common/base/BaseViewModel;", "Lcom/talabat/darkstores/common/OnProductQuantityChangeTrackingListener;", "cartController", "Lcom/talabat/darkstores/feature/cart/CartController;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "listener", "Lcom/talabat/darkstores/feature/checkout/DarkstoresListener;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "tracker", "Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "feesTracker", "Lcom/talabat/darkstores/data/tracking/fees/tracker/IDarkstoresFeesTracker;", "deliveryDetailsRepo", "Lcom/talabat/darkstores/data/dynamicPricing/remote/DeliveryDetailsRepo;", "partialFulfillmentRepo", "Lcom/talabat/darkstores/data/partialFulfillment/remote/PartialFulfillmentRepo;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "customer", "Lbuisnessmodels/Customer;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "cartSwimlaneUseCase", "Lcom/talabat/darkstores/feature/cart/CartSwimlaneUseCase;", "campaignProgressUseCase", "Lcom/talabat/darkstores/feature/cart/CampaignProgressUseCase;", "darkstoresRepository", "Lcom/talabat/feature/darkstores/domain/repository/DarkstoresRepository;", "disclaimerRepository", "Lcom/talabat/feature/darkstores/domain/disclaimer/DisclaimerRepository;", "postCart", "Lcom/talabat/darkstores/feature/cart/PostCartUseCase;", "flutterDeliveryTierMapper", "Lcom/talabat/darkstores/data/deliveryfee/FlutterDeliveryTierMapper;", "deliveryTierBottomSheetTracker", "Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DarkStoreBottomSheetTracker;", "deliveryFeeTierFeatureFlagUseCase", "Lcom/talabat/darkstores/feature/cart/GroceryDeliveryFeeTierFeatureFlagUseCase;", "storeInfoTrackingProvider", "Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;", "nonMigratedCart", "Lbuisnessmodels/Cart;", "getCartListToast", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/GetCartListToastUseCase;", "invalidateCartListCache", "Lcom/talabat/feature/darkstorescartlist/domain/usecase/InvalidateCartListCacheUseCase;", "initCartUseCase", "Lcom/talabat/darkstores/feature/cart/multibasket/InitCartUseCase;", "startCartClearedEventTracker", "Lcom/talabat/darkstores/feature/cart/cartabadonment/StartCartClearedEventTrackerUseCase;", "buildBasketUpsellAction", "Lcom/talabat/darkstores/domain/common/BuildBasketUpsellActionUseCase;", "saveBasketUpsellBottomSheetShown", "Lcom/talabat/darkstores/domain/basket/SaveBasketUpsellBottomSheetShownUseCase;", "swimlanesTracker", "Lcom/talabat/darkstores/data/tracking/product/swimlanes/SwimlanesTracker;", "buildDeliveryFeeTierNavigationUseCase", "Lcom/talabat/darkstores/domain/common/BuildDeliveryFeeTierNavigationUseCase;", "(Lcom/talabat/darkstores/feature/cart/CartController;Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/core/observabilityNew/domain/IScreenTracker;Lcom/talabat/darkstores/feature/checkout/DarkstoresListener;Lio/reactivex/disposables/CompositeDisposable;Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;Lcom/talabat/darkstores/data/tracking/fees/tracker/IDarkstoresFeesTracker;Lcom/talabat/darkstores/data/dynamicPricing/remote/DeliveryDetailsRepo;Lcom/talabat/darkstores/data/partialFulfillment/remote/PartialFulfillmentRepo;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lbuisnessmodels/Customer;Lcom/talabat/darkstores/data/ConfigurationParameters;Lcom/talabat/darkstores/feature/cart/CartSwimlaneUseCase;Lcom/talabat/darkstores/feature/cart/CampaignProgressUseCase;Lcom/talabat/feature/darkstores/domain/repository/DarkstoresRepository;Lcom/talabat/feature/darkstores/domain/disclaimer/DisclaimerRepository;Lcom/talabat/darkstores/feature/cart/PostCartUseCase;Lcom/talabat/darkstores/data/deliveryfee/FlutterDeliveryTierMapper;Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DarkStoreBottomSheetTracker;Lcom/talabat/darkstores/feature/cart/GroceryDeliveryFeeTierFeatureFlagUseCase;Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;Lbuisnessmodels/Cart;Lcom/talabat/feature/darkstorescartlist/domain/usecase/GetCartListToastUseCase;Lcom/talabat/feature/darkstorescartlist/domain/usecase/InvalidateCartListCacheUseCase;Lcom/talabat/darkstores/feature/cart/multibasket/InitCartUseCase;Lcom/talabat/darkstores/feature/cart/cartabadonment/StartCartClearedEventTrackerUseCase;Lcom/talabat/darkstores/domain/common/BuildBasketUpsellActionUseCase;Lcom/talabat/darkstores/domain/basket/SaveBasketUpsellBottomSheetShownUseCase;Lcom/talabat/darkstores/data/tracking/product/swimlanes/SwimlanesTracker;Lcom/talabat/darkstores/domain/common/BuildDeliveryFeeTierNavigationUseCase;)V", "_cartClearPermission", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel$ClearCartPermissionData;", "_cartFragmentLiveData", "Lcom/talabat/darkstores/common/Result;", "Lcom/talabat/darkstores/feature/cart/CartFragmentData;", "_cartInitErrorLiveData", "Lcom/talabat/wrapper/EventWrapper;", "", "_cartListToastLiveData", "Lcom/talabat/feature/darkstorescartlist/domain/model/CartListToast;", "_cartMapLiveData", "", "", "", "_cartReadyLiveData", "", "_cartSyncWarning", "", "_checkoutActionLiveData", "Lcom/talabat/feature/darkstorescart/data/model/CheckoutParams;", "_navigationReadyLiveData", "ageLimit", "getAgeLimit", "()Ljava/lang/String;", "setAgeLimit", "(Ljava/lang/String;)V", "ageLive", "getAgeLive", "()Landroidx/lifecycle/MutableLiveData;", "setAgeLive", "(Landroidx/lifecycle/MutableLiveData;)V", "campaignVisualisation", "Lcom/talabat/darkstores/feature/campaigns/CampaignProgressVisualisation;", "cartClearPermission", "getCartClearPermission", "cartErrorObservability", "Lio/reactivex/subjects/PublishSubject;", "Lretrofit2/HttpException;", "cartFragmentLiveData", "Landroidx/lifecycle/LiveData;", "getCartFragmentLiveData", "()Landroidx/lifecycle/LiveData;", "cartInitErrorLiveData", "getCartInitErrorLiveData", "cartListToastLiveData", "getCartListToastLiveData", "cartMapLiveData", "kotlin.jvm.PlatformType", "getCartMapLiveData", "<set-?>", "Lcom/talabat/darkstores/feature/cart/model/CartProductViewType;", "cartProductViewType", "getCartProductViewType", "()Lcom/talabat/darkstores/feature/cart/model/CartProductViewType;", "cartReadyLiveData", "getCartReadyLiveData", "cartScreenListLiveData", "", "", "cartSwimlaneSubject", "Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "getCartSwimlaneSubject$com_talabat_NewArchi_darkstores_darkstores$annotations", "()V", "getCartSwimlaneSubject$com_talabat_NewArchi_darkstores_darkstores", "()Lio/reactivex/subjects/PublishSubject;", "cartSyncWarning", "getCartSyncWarning", "cartValidationErrorObservability", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "categoriesRowsCount", "getCategoriesRowsCount", "()I", "checkoutActionLiveData", "getCheckoutActionLiveData", "currentVendorCode", "getCurrentVendorCode$com_talabat_NewArchi_darkstores_darkstores", "currentVendorName", "getCurrentVendorName$com_talabat_NewArchi_darkstores_darkstores", "deliveryDetails", "Lcom/talabat/darkstores/data/dynamicPricing/remote/DeliveryDetails;", "duplicateCartLiveData", "getDuplicateCartLiveData", "eligibilityLive", "getEligibilityLive", "setEligibilityLive", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "isCartReady", "isCategoriesRowsCountEnabled", "navigationReadyLiveData", "getNavigationReadyLiveData", "preferences", "Lcom/talabat/darkstores/data/partialFulfillment/model/PreferencesResponse;", "getPreferences", "()Lcom/talabat/darkstores/data/partialFulfillment/model/PreferencesResponse;", "setPreferences", "(Lcom/talabat/darkstores/data/partialFulfillment/model/PreferencesResponse;)V", "productCountChanged", "Lcom/talabat/talabatcommon/optional/Optional;", "Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel$AddToCartData;", "retrySubject", "selectedControlSubject", "Lcom/talabat/darkstores/data/partialFulfillment/model/Control;", "serviceFeeEnabled", "getServiceFeeEnabled", "()Z", "showAlertsOnCart", "getShowAlertsOnCart", "showBottomCartViewStateLiveData", "Lcom/talabat/darkstores/feature/cart/model/BottomCartViewState;", "getShowBottomCartViewStateLiveData", "showBottomCartViewStateMutableLiveData", "specialRequest", "getSpecialRequest", "setSpecialRequest", "addAgeLimitToExitPointIfNeeded", "exitPointData", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointData;", "addProductToCart", "addToCartData", "applyPricesAndCategories", "productsFromDb", "cartResponse", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "attachClearCartDataIfNeeded", "Lio/reactivex/Single;", "Lkotlin/Pair;", "cartCount", "onFailure", "Lkotlin/Function0;", "basketBaseDeliveryFeeIsEnabled", "calcSummary", "Lcom/talabat/darkstores/feature/cart/CartSummary;", "cartListLiveData", "cartProductQuantityAndStock", "productId", "checkAgeRestricted", "result", "Lcom/talabat/darkstores/common/Result$Success;", "checkout", "activity", "Lcom/talabat/darkstores/feature/main/DarkstoresMainActivity;", "checkoutParams", "clearCart", "clearVendorCache", "computeCartProductViewType", "decreaseProductCount", "product", "count", "listPosition", "trackingCategoryId", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "swimlaneTrackingData", "Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "swimlaneRequestId", "swimlaneStrategy", "useOldTracking", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Lcom/talabat/darkstores/common/SwimlaneTrackingData;Ljava/lang/String;Ljava/lang/String;Z)V", "dismissDisclaimer", "enableBasketBasedDeliveryFee", "isTPro", "basketDeliveryFeeTiersInfo", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "enableCheckout", "cartSummary", "vendor", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "enableServiceFeeDescriptionFix", "getDeliveyFeeFlowType", "Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DeliveryFeeFlowType;", "isBasketBaseDeliveryFeeEnabled", "getFlutterDeliveryFeeTierRequest", "Lcom/talabat/darkstores/data/deliveryfee/FlutterDeliveryFeeTierRequest;", "getScreenTrackingInfo", "Lcom/talabat/darkstores/feature/cart/model/ScreenTrackingInfo;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "getStoreTrackingInfo", "handleCheckoutNavigation", "navigateToFlutterBottomSheet", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "navigateToCheckout", "handleDeliveryFeeNavigation", "handleNavDestinationChange", "increaseProductCount", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Lcom/talabat/darkstores/common/SwimlaneTrackingData;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "initCart", "initViewModel", "isDisclaimerDismissed", "isLoggedIn", "onCartScreenLoaded", "onCheckoutClicked", "fragment", "Landroidx/fragment/app/Fragment;", "vendorCode", "onClearCartPermissionDenied", "clearCartPermissionData", "onClearCartPermissionGranted", "onCleared", "onControlSelected", "selected", "save", "onDeliveryTierBottomSheetClicked", "eventOrigin", "clickOrigin", "Lcom/talabat/darkstores/feature/main/viewmodel/DeliveryTierClickOrigin;", "onHomeReady", "onReadyForInteractionDhDefinition", "onReadyForInteractionTlbDefinition", "onRetry", "onVendorMenuOpened", "resetCartWithNewId", "saveUserPreference", "shouldClearCart", "branchId", "showMultiBasketToast", "showMultiBasketToast$com_talabat_NewArchi_darkstores_darkstores", "showOosPredictionAlert", "startTraceDefinition", "subscribeToCartProducts", "Lio/reactivex/disposables/Disposable;", "trackCartOpened", "trackCheckoutAlertVisibility", "screenName", "trackDeliveryTierBottomSheetLoaded", "trackDisclaimerDisplayed", "trackFeeInfoClicked", "disclaimerType", "trackFeeInfoUrlClicked", "trackPaymentSummaryExpanded", "trackScreenOpened", "trackSwimlaneShown", "swimlane", "trackSwimlaneSwiped", "position", "trackVendorVisitEvent", "updateEligibility", "eligible", "age", "updateEventOrigin", "updateNonMigratedCartForCheckoutWithDarkstores", "updateNonMigratedCartForCheckoutWithDarkstores$com_talabat_NewArchi_darkstores_darkstores", "updateSpecialRequest", "value", "validateCart", "ignoreIfCartOwnedByAnotherVendor", "Lio/reactivex/Observable;", "T", "AddToCartData", "CartListContent", "ClearCartPermissionData", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentViewModel extends BaseViewModel implements OnProductQuantityChangeTrackingListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String KEY_SEARCH_RESULT_TYPE = "resultsType";
    @NotNull
    private final MutableLiveData<ClearCartPermissionData> _cartClearPermission;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<CartFragmentData>> _cartFragmentLiveData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<EventWrapper<Throwable>> _cartInitErrorLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<EventWrapper<CartListToast>> _cartListToastLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Map<String, Integer>> _cartMapLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<Unit>> _cartReadyLiveData;
    @NotNull
    private final MutableLiveData<Boolean> _cartSyncWarning;
    /* access modifiers changed from: private */
    @NotNull
    public MutableLiveData<EventWrapper<CheckoutParams>> _checkoutActionLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<EventWrapper<Unit>> _navigationReadyLiveData;
    @NotNull
    private String ageLimit;
    @NotNull
    private MutableLiveData<EventWrapper<String>> ageLive;
    @NotNull
    private final BuildBasketUpsellActionUseCase buildBasketUpsellAction;
    @NotNull
    private final BuildDeliveryFeeTierNavigationUseCase buildDeliveryFeeTierNavigationUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final CampaignProgressUseCase campaignProgressUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<CampaignProgressVisualisation> campaignVisualisation = new MutableLiveData<>();
    @NotNull
    private final CartController cartController;
    @NotNull
    private final PublishSubject<HttpException> cartErrorObservability;
    /* access modifiers changed from: private */
    @NotNull
    public volatile CartProductViewType cartProductViewType;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<List<Object>> cartScreenListLiveData = new MutableLiveData<>();
    @NotNull
    private final PublishSubject<CartSwimlane> cartSwimlaneSubject;
    @NotNull
    private final CartSwimlaneUseCase cartSwimlaneUseCase;
    @NotNull
    private final PublishSubject<Product> cartValidationErrorObservability;
    private final int categoriesRowsCount;
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final Customer customer;
    @NotNull
    private final DarkstoresRepo darkstoresRepo;
    @NotNull
    private final DarkstoresRepository darkstoresRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<DeliveryDetails>> deliveryDetails = new MutableLiveData<>();
    @NotNull
    private final DeliveryDetailsRepo deliveryDetailsRepo;
    @NotNull
    private final GroceryDeliveryFeeTierFeatureFlagUseCase deliveryFeeTierFeatureFlagUseCase;
    @NotNull
    private final DarkStoreBottomSheetTracker deliveryTierBottomSheetTracker;
    @NotNull
    private final DisclaimerRepository disclaimerRepository;
    @NotNull
    private final MutableLiveData<EventWrapper<Boolean>> duplicateCartLiveData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<EventWrapper<Boolean>> eligibilityLive;
    @NotNull
    private EventOriginType eventOriginType;
    @NotNull
    private final IDarkstoresFeesTracker feesTracker;
    @NotNull
    private final FlutterDeliveryTierMapper flutterDeliveryTierMapper;
    @NotNull
    private final GetCartListToastUseCase getCartListToast;
    @NotNull
    private final InitCartUseCase initCartUseCase;
    @NotNull
    private final InvalidateCartListCacheUseCase invalidateCartListCache;
    /* access modifiers changed from: private */
    public volatile boolean isCartReady;
    private final boolean isCategoriesRowsCountEnabled;
    @NotNull
    private final DarkstoresListener listener;
    @NotNull
    private final Cart nonMigratedCart;
    @NotNull
    private final PartialFulfillmentRepo partialFulfillmentRepo;
    @NotNull
    private final PostCartUseCase postCart;
    @NotNull
    private PreferencesResponse preferences;
    /* access modifiers changed from: private */
    @NotNull
    public final PublishSubject<Optional<AddToCartData>> productCountChanged;
    @NotNull
    private final PublishSubject<Unit> retrySubject;
    @NotNull
    private final SaveBasketUpsellBottomSheetShownUseCase saveBasketUpsellBottomSheetShown;
    @NotNull
    private final IScreenTracker screenTracker;
    @NotNull
    private final PublishSubject<Optional<Control>> selectedControlSubject;
    private boolean serviceFeeEnabled;
    @NotNull
    private final MutableLiveData<BottomCartViewState> showBottomCartViewStateMutableLiveData;
    @NotNull
    private String specialRequest;
    @NotNull
    private final StartCartClearedEventTrackerUseCase startCartClearedEventTracker;
    @NotNull
    private final StoreInfoTrackingProvider storeInfoTrackingProvider;
    @NotNull
    private final SwimlanesTracker swimlanesTracker;
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final DarkstoresEventTracker tracker;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003Jr\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00100\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012¨\u00061"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel$AddToCartData;", "", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "quantity", "", "listPosition", "isAdded", "", "trackingCategoryId", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "swimlaneTrackingData", "Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "swimlaneRequestId", "", "swimlaneStrategy", "useOldTracking", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;ZLcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Lcom/talabat/darkstores/common/SwimlaneTrackingData;Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getListPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProduct", "()Lcom/talabat/feature/darkstorescart/data/model/Product;", "getQuantity", "()I", "getSwimlaneRequestId", "()Ljava/lang/String;", "getSwimlaneStrategy", "getSwimlaneTrackingData", "()Lcom/talabat/darkstores/common/SwimlaneTrackingData;", "getTrackingCategoryId", "()Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "getUseOldTracking", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;ZLcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Lcom/talabat/darkstores/common/SwimlaneTrackingData;Ljava/lang/String;Ljava/lang/String;Z)Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel$AddToCartData;", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AddToCartData {
        private final boolean isAdded;
        @Nullable
        private final Integer listPosition;
        @NotNull
        private final Product product;
        private final int quantity;
        @Nullable
        private final String swimlaneRequestId;
        @Nullable
        private final String swimlaneStrategy;
        @Nullable
        private final SwimlaneTrackingData swimlaneTrackingData;
        @Nullable
        private final TrackingCategoryId trackingCategoryId;
        private final boolean useOldTracking;

        public AddToCartData(@NotNull Product product2, int i11, @Nullable Integer num, boolean z11, @Nullable TrackingCategoryId trackingCategoryId2, @Nullable SwimlaneTrackingData swimlaneTrackingData2, @Nullable String str, @Nullable String str2, boolean z12) {
            Intrinsics.checkNotNullParameter(product2, "product");
            this.product = product2;
            this.quantity = i11;
            this.listPosition = num;
            this.isAdded = z11;
            this.trackingCategoryId = trackingCategoryId2;
            this.swimlaneTrackingData = swimlaneTrackingData2;
            this.swimlaneRequestId = str;
            this.swimlaneStrategy = str2;
            this.useOldTracking = z12;
        }

        public static /* synthetic */ AddToCartData copy$default(AddToCartData addToCartData, Product product2, int i11, Integer num, boolean z11, TrackingCategoryId trackingCategoryId2, SwimlaneTrackingData swimlaneTrackingData2, String str, String str2, boolean z12, int i12, Object obj) {
            AddToCartData addToCartData2 = addToCartData;
            int i13 = i12;
            return addToCartData.copy((i13 & 1) != 0 ? addToCartData2.product : product2, (i13 & 2) != 0 ? addToCartData2.quantity : i11, (i13 & 4) != 0 ? addToCartData2.listPosition : num, (i13 & 8) != 0 ? addToCartData2.isAdded : z11, (i13 & 16) != 0 ? addToCartData2.trackingCategoryId : trackingCategoryId2, (i13 & 32) != 0 ? addToCartData2.swimlaneTrackingData : swimlaneTrackingData2, (i13 & 64) != 0 ? addToCartData2.swimlaneRequestId : str, (i13 & 128) != 0 ? addToCartData2.swimlaneStrategy : str2, (i13 & 256) != 0 ? addToCartData2.useOldTracking : z12);
        }

        @NotNull
        public final Product component1() {
            return this.product;
        }

        public final int component2() {
            return this.quantity;
        }

        @Nullable
        public final Integer component3() {
            return this.listPosition;
        }

        public final boolean component4() {
            return this.isAdded;
        }

        @Nullable
        public final TrackingCategoryId component5() {
            return this.trackingCategoryId;
        }

        @Nullable
        public final SwimlaneTrackingData component6() {
            return this.swimlaneTrackingData;
        }

        @Nullable
        public final String component7() {
            return this.swimlaneRequestId;
        }

        @Nullable
        public final String component8() {
            return this.swimlaneStrategy;
        }

        public final boolean component9() {
            return this.useOldTracking;
        }

        @NotNull
        public final AddToCartData copy(@NotNull Product product2, int i11, @Nullable Integer num, boolean z11, @Nullable TrackingCategoryId trackingCategoryId2, @Nullable SwimlaneTrackingData swimlaneTrackingData2, @Nullable String str, @Nullable String str2, boolean z12) {
            Intrinsics.checkNotNullParameter(product2, "product");
            return new AddToCartData(product2, i11, num, z11, trackingCategoryId2, swimlaneTrackingData2, str, str2, z12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AddToCartData)) {
                return false;
            }
            AddToCartData addToCartData = (AddToCartData) obj;
            return Intrinsics.areEqual((Object) this.product, (Object) addToCartData.product) && this.quantity == addToCartData.quantity && Intrinsics.areEqual((Object) this.listPosition, (Object) addToCartData.listPosition) && this.isAdded == addToCartData.isAdded && Intrinsics.areEqual((Object) this.trackingCategoryId, (Object) addToCartData.trackingCategoryId) && Intrinsics.areEqual((Object) this.swimlaneTrackingData, (Object) addToCartData.swimlaneTrackingData) && Intrinsics.areEqual((Object) this.swimlaneRequestId, (Object) addToCartData.swimlaneRequestId) && Intrinsics.areEqual((Object) this.swimlaneStrategy, (Object) addToCartData.swimlaneStrategy) && this.useOldTracking == addToCartData.useOldTracking;
        }

        @Nullable
        public final Integer getListPosition() {
            return this.listPosition;
        }

        @NotNull
        public final Product getProduct() {
            return this.product;
        }

        public final int getQuantity() {
            return this.quantity;
        }

        @Nullable
        public final String getSwimlaneRequestId() {
            return this.swimlaneRequestId;
        }

        @Nullable
        public final String getSwimlaneStrategy() {
            return this.swimlaneStrategy;
        }

        @Nullable
        public final SwimlaneTrackingData getSwimlaneTrackingData() {
            return this.swimlaneTrackingData;
        }

        @Nullable
        public final TrackingCategoryId getTrackingCategoryId() {
            return this.trackingCategoryId;
        }

        public final boolean getUseOldTracking() {
            return this.useOldTracking;
        }

        public int hashCode() {
            int hashCode = ((this.product.hashCode() * 31) + this.quantity) * 31;
            Integer num = this.listPosition;
            int i11 = 0;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            boolean z11 = this.isAdded;
            boolean z12 = true;
            if (z11) {
                z11 = true;
            }
            int i12 = (hashCode2 + (z11 ? 1 : 0)) * 31;
            TrackingCategoryId trackingCategoryId2 = this.trackingCategoryId;
            int hashCode3 = (i12 + (trackingCategoryId2 == null ? 0 : trackingCategoryId2.hashCode())) * 31;
            SwimlaneTrackingData swimlaneTrackingData2 = this.swimlaneTrackingData;
            int hashCode4 = (hashCode3 + (swimlaneTrackingData2 == null ? 0 : swimlaneTrackingData2.hashCode())) * 31;
            String str = this.swimlaneRequestId;
            int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.swimlaneStrategy;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            int i13 = (hashCode5 + i11) * 31;
            boolean z13 = this.useOldTracking;
            if (!z13) {
                z12 = z13;
            }
            return i13 + (z12 ? 1 : 0);
        }

        public final boolean isAdded() {
            return this.isAdded;
        }

        @NotNull
        public String toString() {
            Product product2 = this.product;
            int i11 = this.quantity;
            Integer num = this.listPosition;
            boolean z11 = this.isAdded;
            TrackingCategoryId trackingCategoryId2 = this.trackingCategoryId;
            SwimlaneTrackingData swimlaneTrackingData2 = this.swimlaneTrackingData;
            String str = this.swimlaneRequestId;
            String str2 = this.swimlaneStrategy;
            boolean z12 = this.useOldTracking;
            return "AddToCartData(product=" + product2 + ", quantity=" + i11 + ", listPosition=" + num + ", isAdded=" + z11 + ", trackingCategoryId=" + trackingCategoryId2 + ", swimlaneTrackingData=" + swimlaneTrackingData2 + ", swimlaneRequestId=" + str + ", swimlaneStrategy=" + str2 + ", useOldTracking=" + z12 + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel$ClearCartPermissionData;", "", "cartVendorName", "", "addToCartData", "Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel$AddToCartData;", "onAddToCartFailure", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel$AddToCartData;Lkotlin/jvm/functions/Function0;)V", "getAddToCartData", "()Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel$AddToCartData;", "getCartVendorName", "()Ljava/lang/String;", "getOnAddToCartFailure", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ClearCartPermissionData {
        @NotNull
        private final AddToCartData addToCartData;
        @NotNull
        private final String cartVendorName;
        @NotNull
        private final Function0<Unit> onAddToCartFailure;

        public ClearCartPermissionData(@NotNull String str, @NotNull AddToCartData addToCartData2, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "cartVendorName");
            Intrinsics.checkNotNullParameter(addToCartData2, "addToCartData");
            Intrinsics.checkNotNullParameter(function0, "onAddToCartFailure");
            this.cartVendorName = str;
            this.addToCartData = addToCartData2;
            this.onAddToCartFailure = function0;
        }

        public static /* synthetic */ ClearCartPermissionData copy$default(ClearCartPermissionData clearCartPermissionData, String str, AddToCartData addToCartData2, Function0<Unit> function0, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = clearCartPermissionData.cartVendorName;
            }
            if ((i11 & 2) != 0) {
                addToCartData2 = clearCartPermissionData.addToCartData;
            }
            if ((i11 & 4) != 0) {
                function0 = clearCartPermissionData.onAddToCartFailure;
            }
            return clearCartPermissionData.copy(str, addToCartData2, function0);
        }

        @NotNull
        public final String component1() {
            return this.cartVendorName;
        }

        @NotNull
        public final AddToCartData component2() {
            return this.addToCartData;
        }

        @NotNull
        public final Function0<Unit> component3() {
            return this.onAddToCartFailure;
        }

        @NotNull
        public final ClearCartPermissionData copy(@NotNull String str, @NotNull AddToCartData addToCartData2, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "cartVendorName");
            Intrinsics.checkNotNullParameter(addToCartData2, "addToCartData");
            Intrinsics.checkNotNullParameter(function0, "onAddToCartFailure");
            return new ClearCartPermissionData(str, addToCartData2, function0);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClearCartPermissionData)) {
                return false;
            }
            ClearCartPermissionData clearCartPermissionData = (ClearCartPermissionData) obj;
            return Intrinsics.areEqual((Object) this.cartVendorName, (Object) clearCartPermissionData.cartVendorName) && Intrinsics.areEqual((Object) this.addToCartData, (Object) clearCartPermissionData.addToCartData) && Intrinsics.areEqual((Object) this.onAddToCartFailure, (Object) clearCartPermissionData.onAddToCartFailure);
        }

        @NotNull
        public final AddToCartData getAddToCartData() {
            return this.addToCartData;
        }

        @NotNull
        public final String getCartVendorName() {
            return this.cartVendorName;
        }

        @NotNull
        public final Function0<Unit> getOnAddToCartFailure() {
            return this.onAddToCartFailure;
        }

        public int hashCode() {
            return (((this.cartVendorName.hashCode() * 31) + this.addToCartData.hashCode()) * 31) + this.onAddToCartFailure.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.cartVendorName;
            AddToCartData addToCartData2 = this.addToCartData;
            Function0<Unit> function0 = this.onAddToCartFailure;
            return "ClearCartPermissionData(cartVendorName=" + str + ", addToCartData=" + addToCartData2 + ", onAddToCartFailure=" + function0 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel$Companion;", "", "()V", "KEY_SEARCH_RESULT_TYPE", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeliveryTierClickOrigin.values().length];
            iArr[DeliveryTierClickOrigin.CART_PROGRESS_INFO.ordinal()] = 1;
            iArr[DeliveryTierClickOrigin.DELIVERY_FEE_INFO.ordinal()] = 2;
            iArr[DeliveryTierClickOrigin.PAYMENT_INFO.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CartFragmentViewModel(@org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.cart.CartController r19, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.darkstores.DarkstoresRepo r20, @org.jetbrains.annotations.NotNull com.talabat.core.observabilityNew.domain.IScreenTracker r21, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.checkout.DarkstoresListener r22, @org.jetbrains.annotations.NotNull io.reactivex.disposables.CompositeDisposable r23, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.tracking.DarkstoresEventTracker r24, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.tracking.fees.tracker.IDarkstoresFeesTracker r25, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetailsRepo r26, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.partialFulfillment.remote.PartialFulfillmentRepo r27, @org.jetbrains.annotations.NotNull com.talabat.core.featureflag.domain.ITalabatFeatureFlag r28, @org.jetbrains.annotations.NotNull com.talabat.core.experiment.domain.ITalabatExperiment r29, @org.jetbrains.annotations.NotNull buisnessmodels.Customer r30, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.ConfigurationParameters r31, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.cart.CartSwimlaneUseCase r32, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.cart.CampaignProgressUseCase r33, @org.jetbrains.annotations.NotNull com.talabat.feature.darkstores.domain.repository.DarkstoresRepository r34, @org.jetbrains.annotations.NotNull com.talabat.feature.darkstores.domain.disclaimer.DisclaimerRepository r35, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.cart.PostCartUseCase r36, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.deliveryfee.FlutterDeliveryTierMapper r37, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.tracking.bottomsheet.tracker.DarkStoreBottomSheetTracker r38, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.cart.GroceryDeliveryFeeTierFeatureFlagUseCase r39, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider r40, @org.jetbrains.annotations.NotNull buisnessmodels.Cart r41, @org.jetbrains.annotations.NotNull com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCase r42, @org.jetbrains.annotations.NotNull com.talabat.feature.darkstorescartlist.domain.usecase.InvalidateCartListCacheUseCase r43, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.cart.multibasket.InitCartUseCase r44, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.cart.cartabadonment.StartCartClearedEventTrackerUseCase r45, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.common.BuildBasketUpsellActionUseCase r46, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.basket.SaveBasketUpsellBottomSheetShownUseCase r47, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker r48, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.common.BuildDeliveryFeeTierNavigationUseCase r49) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r28
            r11 = r29
            r12 = r30
            r13 = r31
            r14 = r32
            r15 = r33
            r0 = r34
            java.lang.String r0 = "cartController"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "darkstoresRepo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "screenTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "compositeDisposable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "tracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "feesTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "deliveryDetailsRepo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "partialFulfillmentRepo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "talabatFeatureFlag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "talabatExperiment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "customer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "configurationParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "cartSwimlaneUseCase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "campaignProgressUseCase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "darkstoresRepository"
            r15 = r34
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "disclaimerRepository"
            r15 = r35
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "postCart"
            r15 = r36
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "flutterDeliveryTierMapper"
            r15 = r37
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "deliveryTierBottomSheetTracker"
            r15 = r38
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "deliveryFeeTierFeatureFlagUseCase"
            r15 = r39
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "storeInfoTrackingProvider"
            r15 = r40
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "nonMigratedCart"
            r15 = r41
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "getCartListToast"
            r15 = r42
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "invalidateCartListCache"
            r15 = r43
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "initCartUseCase"
            r15 = r44
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "startCartClearedEventTracker"
            r15 = r45
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "buildBasketUpsellAction"
            r15 = r46
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "saveBasketUpsellBottomSheetShown"
            r15 = r47
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "swimlanesTracker"
            r15 = r48
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "buildDeliveryFeeTierNavigationUseCase"
            r15 = r49
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = r18
            r15 = r34
            r0.<init>(r5)
            r0.cartController = r1
            r0.darkstoresRepo = r2
            r0.screenTracker = r3
            r0.listener = r4
            r0.tracker = r6
            r0.feesTracker = r7
            r0.deliveryDetailsRepo = r8
            r0.partialFulfillmentRepo = r9
            r0.talabatFeatureFlag = r10
            r0.talabatExperiment = r11
            r0.customer = r12
            r0.configurationParameters = r13
            r0.cartSwimlaneUseCase = r14
            r1 = r33
            r0.campaignProgressUseCase = r1
            r0.darkstoresRepository = r15
            r1 = r35
            r2 = r36
            r0.disclaimerRepository = r1
            r0.postCart = r2
            r1 = r37
            r2 = r38
            r0.flutterDeliveryTierMapper = r1
            r0.deliveryTierBottomSheetTracker = r2
            r1 = r39
            r2 = r40
            r0.deliveryFeeTierFeatureFlagUseCase = r1
            r0.storeInfoTrackingProvider = r2
            r1 = r41
            r2 = r42
            r0.nonMigratedCart = r1
            r0.getCartListToast = r2
            r1 = r43
            r2 = r44
            r0.invalidateCartListCache = r1
            r0.initCartUseCase = r2
            r1 = r45
            r2 = r46
            r0.startCartClearedEventTracker = r1
            r0.buildBasketUpsellAction = r2
            r1 = r47
            r2 = r48
            r0.saveBasketUpsellBottomSheetShown = r1
            r0.swimlanesTracker = r2
            r1 = r49
            r0.buildDeliveryFeeTierNavigationUseCase = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0.cartScreenListLiveData = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0.duplicateCartLiveData = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0._cartFragmentLiveData = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0.campaignVisualisation = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0.deliveryDetails = r1
            io.reactivex.subjects.PublishSubject r1 = io.reactivex.subjects.PublishSubject.create()
            java.lang.String r2 = "create<Unit>()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.retrySubject = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0._cartMapLiveData = r1
            io.reactivex.subjects.PublishSubject r1 = io.reactivex.subjects.PublishSubject.create()
            java.lang.String r2 = "create()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.productCountChanged = r1
            io.reactivex.subjects.PublishSubject r1 = io.reactivex.subjects.PublishSubject.create()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.cartErrorObservability = r1
            io.reactivex.subjects.PublishSubject r1 = io.reactivex.subjects.PublishSubject.create()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.cartValidationErrorObservability = r1
            io.reactivex.subjects.PublishSubject r1 = io.reactivex.subjects.PublishSubject.create()
            java.lang.String r3 = "create<Optional<Control>>()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r0.selectedControlSubject = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0._cartSyncWarning = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0._cartClearPermission = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0._cartListToastLiveData = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0._navigationReadyLiveData = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0._cartReadyLiveData = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0.showBottomCartViewStateMutableLiveData = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0._checkoutActionLiveData = r1
            java.lang.String r1 = ""
            r0.specialRequest = r1
            com.talabat.darkstores.data.partialFulfillment.model.PreferencesResponse r3 = new com.talabat.darkstores.data.partialFulfillment.model.PreferencesResponse
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 511(0x1ff, float:7.16E-43)
            r17 = 0
            r32 = r3
            r33 = r4
            r34 = r5
            r35 = r6
            r36 = r7
            r37 = r8
            r38 = r9
            r39 = r12
            r40 = r14
            r41 = r15
            r42 = r16
            r43 = r17
            r32.<init>(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43)
            r0.preferences = r3
            r0.ageLimit = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0.ageLive = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0.eligibilityLive = r1
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            r0._cartInitErrorLiveData = r1
            com.talabat.darkstores.feature.tracking.EventOriginType r1 = com.talabat.darkstores.feature.tracking.EventOriginType.None
            r0.eventOriginType = r1
            com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants r1 = com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants.DARKSTORES_VLP_DYNAMIC_CATEGORIES_ROWS_COUNT
            r3 = 0
            boolean r1 = r10.getFeatureFlag(r1, r3)
            r0.isCategoriesRowsCountEnabled = r1
            if (r1 == 0) goto L_0x022c
            r1 = 3
            goto L_0x022d
        L_0x022c:
            r1 = 2
        L_0x022d:
            r0.categoriesRowsCount = r1
            com.talabat.darkstores.feature.cart.model.CartProductViewType r1 = com.talabat.darkstores.feature.cart.model.CartProductViewType.NEW
            r0.cartProductViewType = r1
            io.reactivex.subjects.PublishSubject r1 = io.reactivex.subjects.PublishSubject.create()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.cartSwimlaneSubject = r1
            com.talabat.core.experiment.domain.FWFAttributes r1 = com.talabat.core.experiment.domain.FWFAttributes.VENDOR_ID
            java.lang.String r2 = r31.getVendorCode()
            com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy r3 = com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy.FWF
            r11.setAttribute(r1, r2, r3)
            r18.initViewModel()
            r18.initCart()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.cart.CartFragmentViewModel.<init>(com.talabat.darkstores.feature.cart.CartController, com.talabat.darkstores.data.darkstores.DarkstoresRepo, com.talabat.core.observabilityNew.domain.IScreenTracker, com.talabat.darkstores.feature.checkout.DarkstoresListener, io.reactivex.disposables.CompositeDisposable, com.talabat.darkstores.feature.tracking.DarkstoresEventTracker, com.talabat.darkstores.data.tracking.fees.tracker.IDarkstoresFeesTracker, com.talabat.darkstores.data.dynamicPricing.remote.DeliveryDetailsRepo, com.talabat.darkstores.data.partialFulfillment.remote.PartialFulfillmentRepo, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, com.talabat.core.experiment.domain.ITalabatExperiment, buisnessmodels.Customer, com.talabat.darkstores.data.ConfigurationParameters, com.talabat.darkstores.feature.cart.CartSwimlaneUseCase, com.talabat.darkstores.feature.cart.CampaignProgressUseCase, com.talabat.feature.darkstores.domain.repository.DarkstoresRepository, com.talabat.feature.darkstores.domain.disclaimer.DisclaimerRepository, com.talabat.darkstores.feature.cart.PostCartUseCase, com.talabat.darkstores.data.deliveryfee.FlutterDeliveryTierMapper, com.talabat.darkstores.data.tracking.bottomsheet.tracker.DarkStoreBottomSheetTracker, com.talabat.darkstores.feature.cart.GroceryDeliveryFeeTierFeatureFlagUseCase, com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider, buisnessmodels.Cart, com.talabat.feature.darkstorescartlist.domain.usecase.GetCartListToastUseCase, com.talabat.feature.darkstorescartlist.domain.usecase.InvalidateCartListCacheUseCase, com.talabat.darkstores.feature.cart.multibasket.InitCartUseCase, com.talabat.darkstores.feature.cart.cartabadonment.StartCartClearedEventTrackerUseCase, com.talabat.darkstores.domain.common.BuildBasketUpsellActionUseCase, com.talabat.darkstores.domain.basket.SaveBasketUpsellBottomSheetShownUseCase, com.talabat.darkstores.data.tracking.product.swimlanes.SwimlanesTracker, com.talabat.darkstores.domain.common.BuildDeliveryFeeTierNavigationUseCase):void");
    }

    private final void addProductToCart(AddToCartData addToCartData) {
        this.productCountChanged.onNext(OptionalKt.toOptional(addToCartData));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Float} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.talabat.feature.darkstorescart.data.model.Product> applyPricesAndCategories(java.util.List<com.talabat.feature.darkstorescart.data.model.Product> r41, com.talabat.feature.darkstorescart.data.model.CartResponse r42) {
        /*
            r40 = this;
            java.util.List r0 = r42.getItems()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x000f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00b1
            java.lang.Object r2 = r0.next()
            com.talabat.feature.darkstorescart.data.model.CartResponseProduct r2 = (com.talabat.feature.darkstorescart.data.model.CartResponseProduct) r2
            r3 = r41
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0023:
            boolean r4 = r3.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x0040
            java.lang.Object r4 = r3.next()
            r6 = r4
            com.talabat.feature.darkstorescart.data.model.Product r6 = (com.talabat.feature.darkstorescart.data.model.Product) r6
            java.lang.String r6 = r6.getId()
            java.lang.String r7 = r2.getProductId()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0023
            goto L_0x0041
        L_0x0040:
            r4 = r5
        L_0x0041:
            r6 = r4
            com.talabat.feature.darkstorescart.data.model.Product r6 = (com.talabat.feature.darkstorescart.data.model.Product) r6
            if (r6 == 0) goto L_0x00aa
            int r12 = r2.getQuantity()
            float r10 = r2.getTotal()
            float r3 = r2.getSubtotal()
            float r4 = r2.getTotal()
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x005c
            r4 = 1
            goto L_0x005d
        L_0x005c:
            r4 = 0
        L_0x005d:
            if (r4 != 0) goto L_0x0063
            java.lang.Float r5 = java.lang.Float.valueOf(r3)
        L_0x0063:
            r11 = r5
            java.util.List r23 = r2.getAppliedCampaigns()
            float r3 = r2.getAbsoluteDiscount()
            java.util.List r31 = r2.getProductCategoryIds()
            r7 = 0
            r8 = 0
            r9 = 0
            r13 = 0
            r14 = 0
            java.lang.Float r15 = java.lang.Float.valueOf(r3)
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 2130640583(0x7efefec7, float:1.694734E38)
            r39 = 0
            com.talabat.feature.darkstorescart.data.model.Product r5 = com.talabat.feature.darkstorescart.data.model.Product.copy$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39)
        L_0x00aa:
            if (r5 == 0) goto L_0x000f
            r1.add(r5)
            goto L_0x000f
        L_0x00b1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.cart.CartFragmentViewModel.applyPricesAndCategories(java.util.List, com.talabat.feature.darkstorescart.data.model.CartResponse):java.util.List");
    }

    private final Single<Pair<AddToCartData, ClearCartPermissionData>> attachClearCartDataIfNeeded(int i11, AddToCartData addToCartData, Function0<Unit> function0) {
        Single<R> single = this.cartController.getCartOwner().map(new v0(this, i11, addToCartData, function0)).toSingle(TuplesKt.to(addToCartData, null));
        Intrinsics.checkNotNullExpressionValue(single, "cartController.getCartOw…le(addToCartData to null)");
        return single;
    }

    /* access modifiers changed from: private */
    /* renamed from: attachClearCartDataIfNeeded$lambda-41  reason: not valid java name */
    public static final Pair m9784attachClearCartDataIfNeeded$lambda41(CartFragmentViewModel cartFragmentViewModel, int i11, AddToCartData addToCartData, Function0 function0, CartVendor cartVendor) {
        ClearCartPermissionData clearCartPermissionData;
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(addToCartData, "$addToCartData");
        Intrinsics.checkNotNullParameter(function0, "$onFailure");
        Intrinsics.checkNotNullParameter(cartVendor, "cartOwner");
        if (cartFragmentViewModel.shouldClearCart(i11, cartVendor.getBranchId())) {
            clearCartPermissionData = new ClearCartPermissionData(cartVendor.getName(), addToCartData, function0);
        } else {
            clearCartPermissionData = null;
        }
        return TuplesKt.to(addToCartData, clearCartPermissionData);
    }

    private final CartSummary calcSummary(CartResponse cartResponse) {
        Iterable<CartResponseProduct> items = cartResponse.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(items, 10));
        for (CartResponseProduct absoluteDiscount : items) {
            arrayList.add(Float.valueOf(absoluteDiscount.getAbsoluteDiscount()));
        }
        float sumOfFloat = CollectionsKt___CollectionsKt.sumOfFloat(arrayList);
        String cartId = this.cartController.getCartId();
        float subtotal = cartResponse.getSubtotal();
        Float subtotalAfterDiscount = cartResponse.getSubtotalAfterDiscount();
        float deliveryFee = cartResponse.getDeliveryFee();
        float deliveryTotal = cartResponse.getDeliveryTotal();
        Float serviceFee = cartResponse.getServiceFee();
        float absoluteDiscount2 = cartResponse.getAbsoluteDiscount() + sumOfFloat;
        float total = cartResponse.getTotal();
        String targetAudience = cartResponse.getTargetAudience();
        float deliveryAbsoluteDiscount = cartResponse.getDeliveryAbsoluteDiscount();
        List<CampaignLabel> appliedCampaigns = cartResponse.getAppliedCampaigns();
        float absoluteDiscount3 = cartResponse.getAbsoluteDiscount();
        List<FeeDescription> feeDescriptions = cartResponse.getFeeDescriptions();
        if (feeDescriptions == null) {
            feeDescriptions = CollectionsKt__CollectionsKt.emptyList();
        }
        return new CartSummary(cartId, subtotal, subtotalAfterDiscount, deliveryFee, Float.valueOf(deliveryTotal), serviceFee, absoluteDiscount2, total, targetAudience, deliveryAbsoluteDiscount, absoluteDiscount3, appliedCampaigns, feeDescriptions);
    }

    public static /* synthetic */ void checkout$default(CartFragmentViewModel cartFragmentViewModel, DarkstoresMainActivity darkstoresMainActivity, CheckoutParams checkoutParams, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            checkoutParams = null;
        }
        cartFragmentViewModel.checkout(darkstoresMainActivity, checkoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: clearCart$lambda-42  reason: not valid java name */
    public static final void m9785clearCart$lambda42(CartFragmentViewModel cartFragmentViewModel) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        cartFragmentViewModel.productCountChanged.onNext(Optional.None.INSTANCE);
    }

    private final void computeCartProductViewType() {
        CompositeDisposable a11 = a();
        Single subscribeOn = Single.fromCallable(new h1(this)).map(new i1()).subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "fromCallable {\n         …scribeOn(Schedulers.io())");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy(subscribeOn, (Function1<? super Throwable, Unit>) CartFragmentViewModel$computeCartProductViewType$3.INSTANCE, new CartFragmentViewModel$computeCartProductViewType$4(this)));
    }

    /* access modifiers changed from: private */
    /* renamed from: computeCartProductViewType$lambda-59  reason: not valid java name */
    public static final String m9786computeCartProductViewType$lambda59(CartFragmentViewModel cartFragmentViewModel) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        return cartFragmentViewModel.talabatExperiment.getStringVariant(TalabatExperimentConstants.BASKET_PRODUCT_VIEW_TYPE_VARIANT, "", TalabatExperimentDataSourceStrategy.FWF);
    }

    /* access modifiers changed from: private */
    /* renamed from: computeCartProductViewType$lambda-60  reason: not valid java name */
    public static final CartProductViewType m9787computeCartProductViewType$lambda60(String str) {
        Intrinsics.checkNotNullParameter(str, "variation");
        switch (str.hashCode()) {
            case -546800482:
                if (str.equals("Variation1")) {
                    return CartProductViewType.NEW_COMPACT;
                }
                break;
            case -546800481:
                if (str.equals("Variation2")) {
                    return CartProductViewType.NEW_COMPACT_WITH_ALERTS;
                }
                break;
        }
        return CartProductViewType.NEW;
    }

    private final boolean enableCheckout(CartSummary cartSummary, Vendor vendor) {
        Float subtotalAfterDiscount = cartSummary.getSubtotalAfterDiscount();
        if (subtotalAfterDiscount != null) {
            if (subtotalAfterDiscount.floatValue() >= vendor.getMinimumOrderValue()) {
                return true;
            }
        } else if (cartSummary.getTotal() >= vendor.getMinimumOrderValue()) {
            return true;
        }
        return false;
    }

    private final boolean enableServiceFeeDescriptionFix() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, QCommerceFeatureFlagsKeys.ENABLE_SERVICE_FEE_DESCRIPTION_FIX, false, 2, (Object) null);
    }

    @VisibleForTesting
    public static /* synthetic */ void getCartSwimlaneSubject$com_talabat_NewArchi_darkstores_darkstores$annotations() {
    }

    private final DeliveryFeeFlowType getDeliveyFeeFlowType(boolean z11) {
        if (z11) {
            return DeliveryFeeFlowType.BBDF;
        }
        return DeliveryFeeFlowType.MOV;
    }

    private final ScreenTrackingInfo getScreenTrackingInfo(NavDestination navDestination, Bundle bundle) {
        boolean z11;
        SearchResultsType searchResultsType;
        EventOriginType eventOriginType2;
        int id2 = navDestination.getId();
        if (id2 == R.id.homeFragment) {
            return new ScreenTrackingInfo(EventOriginType.VendorLanding, ScreenTrackingProvider.ScreenName.LANDING, ScreenTrackingProvider.ScreenType.LANDING);
        }
        boolean z12 = false;
        if (id2 == R.id.categoriesFragment || id2 == R.id.subcategoriesFragmentNew) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new ScreenTrackingInfo(EventOriginType.Category, ScreenTrackingProvider.ScreenName.CATEGORY, ScreenTrackingProvider.ScreenType.CATEGORY);
        }
        if (id2 == R.id.searchResultsFragment) {
            if (bundle != null) {
                searchResultsType = (SearchResultsType) bundle.getParcelable(KEY_SEARCH_RESULT_TYPE);
            } else {
                searchResultsType = null;
            }
            if (searchResultsType instanceof SearchResultsType.Banner) {
                eventOriginType2 = EventOriginType.Banner;
            } else {
                eventOriginType2 = EventOriginType.Search;
            }
            return new ScreenTrackingInfo(eventOriginType2, ScreenTrackingProvider.ScreenName.SEARCH, ScreenTrackingProvider.ScreenType.SEARCH_RESULTS);
        }
        if (id2 == R.id.searchFragment || id2 == R.id.flutterSearchFragment) {
            z12 = true;
        }
        if (z12) {
            return new ScreenTrackingInfo(EventOriginType.Search, ScreenTrackingProvider.ScreenName.SEARCH, ScreenTrackingProvider.ScreenType.SEARCH_DETAILS);
        }
        return new ScreenTrackingInfo(EventOriginType.None, ScreenTrackingProvider.ScreenName.LANDING, ScreenTrackingProvider.ScreenType.LANDING);
    }

    private final boolean getShowAlertsOnCart() {
        return this.cartProductViewType == CartProductViewType.NEW_COMPACT_WITH_ALERTS;
    }

    private final <T> Observable<T> ignoreIfCartOwnedByAnotherVendor(Observable<T> observable) {
        Observable<R> flatMapMaybe = observable.flatMapMaybe(new u0(this));
        Intrinsics.checkNotNullExpressionValue(flatMapMaybe, "flatMapMaybe { item ->\n …  .map { item }\n        }");
        return flatMapMaybe;
    }

    /* access modifiers changed from: private */
    /* renamed from: ignoreIfCartOwnedByAnotherVendor$lambda-64  reason: not valid java name */
    public static final MaybeSource m9788ignoreIfCartOwnedByAnotherVendor$lambda64(CartFragmentViewModel cartFragmentViewModel, Object obj) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        return cartFragmentViewModel.cartController.getCartOwner().map(new d0()).toSingle(Optional.None.INSTANCE).filter(new o0(cartFragmentViewModel)).map(new z0(obj));
    }

    /* access modifiers changed from: private */
    /* renamed from: ignoreIfCartOwnedByAnotherVendor$lambda-64$lambda-61  reason: not valid java name */
    public static final Optional m9789ignoreIfCartOwnedByAnotherVendor$lambda64$lambda61(CartVendor cartVendor) {
        Intrinsics.checkNotNullParameter(cartVendor, "it");
        return OptionalKt.toOptional(cartVendor);
    }

    /* access modifiers changed from: private */
    /* renamed from: ignoreIfCartOwnedByAnotherVendor$lambda-64$lambda-62  reason: not valid java name */
    public static final boolean m9790ignoreIfCartOwnedByAnotherVendor$lambda64$lambda62(CartFragmentViewModel cartFragmentViewModel, Optional optional) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(optional, "cartOwnerOptional");
        CartVendor cartVendor = (CartVendor) optional.toNullable();
        if (cartVendor == null || Intrinsics.areEqual((Object) cartVendor.getBranchId(), (Object) cartFragmentViewModel.getCurrentVendorCode$com_talabat_NewArchi_darkstores_darkstores())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: ignoreIfCartOwnedByAnotherVendor$lambda-64$lambda-63  reason: not valid java name */
    public static final Object m9791ignoreIfCartOwnedByAnotherVendor$lambda64$lambda63(Object obj, Optional optional) {
        Intrinsics.checkNotNullParameter(optional, "it");
        return obj;
    }

    /* access modifiers changed from: private */
    /* renamed from: increaseProductCount$lambda-38  reason: not valid java name */
    public static final Pair m9792increaseProductCount$lambda38(Product product, int i11, Integer num, TrackingCategoryId trackingCategoryId, SwimlaneTrackingData swimlaneTrackingData, String str, String str2, boolean z11, Integer num2) {
        Integer num3 = num2;
        Intrinsics.checkNotNullParameter(product, "$product");
        Intrinsics.checkNotNullParameter(num3, "cartCount");
        return TuplesKt.to(num3, new AddToCartData(product, i11, num, true, trackingCategoryId, swimlaneTrackingData, str, str2, z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: increaseProductCount$lambda-39  reason: not valid java name */
    public static final SingleSource m9793increaseProductCount$lambda39(CartFragmentViewModel cartFragmentViewModel, Function0 function0, Pair pair) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$onFailure");
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        Integer num = (Integer) pair.component1();
        Intrinsics.checkNotNullExpressionValue(num, "cartCount");
        return cartFragmentViewModel.attachClearCartDataIfNeeded(num.intValue(), (AddToCartData) pair.component2(), function0);
    }

    /* access modifiers changed from: private */
    /* renamed from: increaseProductCount$lambda-40  reason: not valid java name */
    public static final void m9794increaseProductCount$lambda40(CartFragmentViewModel cartFragmentViewModel, Pair pair) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        AddToCartData addToCartData = (AddToCartData) pair.component1();
        ClearCartPermissionData clearCartPermissionData = (ClearCartPermissionData) pair.component2();
        if (clearCartPermissionData != null) {
            cartFragmentViewModel._cartClearPermission.postValue(clearCartPermissionData);
        } else {
            cartFragmentViewModel.addProductToCart(addToCartData);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initCart$lambda-0  reason: not valid java name */
    public static final void m9795initCart$lambda0(CartFragmentViewModel cartFragmentViewModel, Disposable disposable) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        cartFragmentViewModel._cartReadyLiveData.postValue(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
    }

    private final void initViewModel() {
        Observable<CampaignProgressVisualisation> observable;
        computeCartProductViewType();
        DisposableKt.plusAssign(a(), subscribeToCartProducts());
        Observable<R> mergeWith = this.productCountChanged.filter(new w(this)).switchMapSingle(new i0(this)).mergeWith(this.cartController.observeCartQuantityUpdatedChanges());
        Intrinsics.checkNotNullExpressionValue(mergeWith, "productCountChanged\n    …QuantityUpdatedChanges())");
        Observable<R> share = ignoreIfCartOwnedByAnotherVendor(mergeWith).switchMapSingleDelayError(new j0(this)).share();
        Observable<R> share2 = share.map(new k0(this)).share();
        Observable<R> map = share2.map(new l0(this));
        Observable<R> map2 = this.cartController.getOOSProducts().map(new m0());
        Observable<R> map3 = share.map(new n0(this));
        CompositeDisposable a11 = a();
        Observable distinctUntilChanged = Observable.mergeArray(map3.map(new p0()), map.map(new q0()), map2.map(new r0()), this.cartSwimlaneSubject.hide().map(new x())).scan(new CartListContent((List) null, (List) null, (List) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null), new y()).map(new z(this)).onErrorReturnItem(CollectionsKt__CollectionsKt.emptyList()).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "mergeArray<(CartListCont…  .distinctUntilChanged()");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default(distinctUntilChanged, (Function1) null, (Function0) null, (Function1) new CartFragmentViewModel$initViewModel$7(this), 3, (Object) null));
        CompositeDisposable a12 = a();
        Observable<R> retryWhen = Observable.combineLatest(share2, this.darkstoresRepo.getVendor().toObservable(), new a0(this)).doOnError(new b0(this)).retryWhen(new c0(this));
        Intrinsics.checkNotNullExpressionValue(retryWhen, "combineLatest(\n         …latMap { retrySubject } }");
        DisposableKt.plusAssign(a12, SubscribersKt.subscribeBy$default((Observable) retryWhen, (Function1) new CartFragmentViewModel$initViewModel$11(this), (Function0) null, (Function1) new CartFragmentViewModel$initViewModel$12(this), 2, (Object) null));
        CompositeDisposable a13 = a();
        Disposable subscribe = this.cartErrorObservability.subscribeOn(Schedulers.io()).switchMap(new e0(this)).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "cartErrorObservability\n …\n            .subscribe()");
        DisposableKt.plusAssign(a13, subscribe);
        CompositeDisposable a14 = a();
        Disposable subscribe2 = this.cartValidationErrorObservability.subscribeOn(Schedulers.io()).switchMap(new f0(this)).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe2, "cartValidationErrorObser…\n            .subscribe()");
        DisposableKt.plusAssign(a14, subscribe2);
        boolean featureFlag$default = ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, TalabatFeatureFlagConstants.ENABLE_DARKSTORES_CAMPAIGN_VISUALISATION, false, 2, (Object) null);
        if (featureFlag$default) {
            observable = this.campaignProgressUseCase.getCampaignProgressObservable();
        } else {
            observable = Observable.just(CampaignProgressVisualisation.Companion.hidden());
            Intrinsics.checkNotNullExpressionValue(observable, "{\n                Observ…n.hidden())\n            }");
        }
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Observable) observable, (Function1) null, (Function0) null, (Function1) new CartFragmentViewModel$initViewModel$15(this), 3, (Object) null));
        CompositeDisposable a15 = a();
        Observable<R> switchMap = this.retrySubject.startWith(Unit.INSTANCE).switchMap(new g0(this));
        Intrinsics.checkNotNullExpressionValue(switchMap, "retrySubject\n           …DetailsModel.toResult() }");
        DisposableKt.plusAssign(a15, SubscribersKt.subscribeBy$default((Observable) switchMap, (Function1) null, (Function0) null, (Function1) new CartFragmentViewModel$initViewModel$17(this), 3, (Object) null));
        CompositeDisposable a16 = a();
        Observable<R> filter = share.filter(new h0(featureFlag$default));
        Intrinsics.checkNotNullExpressionValue(filter, "cartResponse\n           …shouldShowVisualisation }");
        DisposableKt.plusAssign(a16, SubscribersKt.subscribeBy$default((Observable) filter, (Function1) null, (Function0) null, (Function1) new CartFragmentViewModel$initViewModel$19(this), 3, (Object) null));
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Observable) this.startCartClearedEventTracker.invoke(), (Function1) null, (Function0) null, (Function1) null, 7, (Object) null));
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Observable) this.cartController.getNavigateToCheckoutActions(), (Function1) null, (Function0) null, (Function1) new CartFragmentViewModel$initViewModel$20(this), 3, (Object) null));
        trackVendorVisitEvent();
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-1  reason: not valid java name */
    public static final boolean m9796initViewModel$lambda1(CartFragmentViewModel cartFragmentViewModel, Optional optional) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(optional, "it");
        return cartFragmentViewModel.isCartReady;
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-12  reason: not valid java name */
    public static final SingleSource m9797initViewModel$lambda12(CartFragmentViewModel cartFragmentViewModel, Unit unit) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(unit, "it");
        Single<List<Product>> subscribeOn = cartFragmentViewModel.cartController.getAllAsObservable().firstOrError().subscribeOn(Schedulers.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "cartController.getAllAsO…scribeOn(Schedulers.io())");
        return SinglesKt.zipWith(subscribeOn, cartFragmentViewModel.deliveryDetailsRepo.getDeliveryDetailsModel()).flatMap(new j1(cartFragmentViewModel)).doOnError(new t(cartFragmentViewModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-12$lambda-10  reason: not valid java name */
    public static final SingleSource m9798initViewModel$lambda12$lambda10(CartFragmentViewModel cartFragmentViewModel, Pair pair) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        List list = (List) pair.component1();
        DeliveryDetails deliveryDetails2 = (DeliveryDetails) pair.component2();
        PostCartUseCase postCartUseCase = cartFragmentViewModel.postCart;
        Intrinsics.checkNotNullExpressionValue(list, "products");
        return postCartUseCase.invoke(list, deliveryDetails2.getDeliveryFee(), deliveryDetails2.getMinOrderValue(), cartFragmentViewModel.enableBasketBasedDeliveryFee(deliveryDetails2.isTPro(), deliveryDetails2.getBasketDeliveryFeeTiersInfo())).subscribeOn(Schedulers.io()).doOnSubscribe(new w0(cartFragmentViewModel)).doOnSuccess(new x0(list, cartFragmentViewModel)).doOnError(new y0(cartFragmentViewModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-12$lambda-10$lambda-5  reason: not valid java name */
    public static final void m9799initViewModel$lambda12$lambda10$lambda5(CartFragmentViewModel cartFragmentViewModel, Disposable disposable) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        cartFragmentViewModel._cartFragmentLiveData.postValue(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        cartFragmentViewModel.cartController.updateCartSyncStarted();
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-12$lambda-10$lambda-8  reason: not valid java name */
    public static final void m9800initViewModel$lambda12$lambda10$lambda8(List list, CartFragmentViewModel cartFragmentViewModel, CartResponse cartResponse) {
        Object obj;
        boolean z11;
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Product product = (Product) it.next();
            Iterator it2 = cartResponse.getItems().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (Intrinsics.areEqual((Object) ((CartResponseProduct) obj).getProductId(), (Object) product.getId())) {
                    break;
                }
            }
            CartResponseProduct cartResponseProduct = (CartResponseProduct) obj;
            boolean z12 = true;
            if (cartResponseProduct == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (cartResponseProduct != null) {
                if (product.getCartCount() != cartResponseProduct.getQuantity()) {
                    cartFragmentViewModel.cartValidationErrorObservability.onNext(product);
                } else {
                    z12 = z11;
                }
                z11 = z12;
            }
            if (!cartFragmentViewModel.getShowAlertsOnCart()) {
                cartFragmentViewModel._cartSyncWarning.postValue(Boolean.valueOf(z11));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-12$lambda-10$lambda-9  reason: not valid java name */
    public static final void m9801initViewModel$lambda12$lambda10$lambda9(CartFragmentViewModel cartFragmentViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        cartFragmentViewModel.cartController.updateCartSyncFailure();
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-12$lambda-11  reason: not valid java name */
    public static final void m9802initViewModel$lambda12$lambda11(CartFragmentViewModel cartFragmentViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        if (th2 instanceof HttpException) {
            if (((HttpException) th2).code() == 409) {
                cartFragmentViewModel.duplicateCartLiveData.postValue(new EventWrapper(Boolean.TRUE));
            } else {
                cartFragmentViewModel._cartFragmentLiveData.postValue(new Result.Error(th2, false, (Object) null, 6, (DefaultConstructorMarker) null));
            }
            cartFragmentViewModel.cartErrorObservability.onNext(th2);
            return;
        }
        MutableLiveData<Result<CartFragmentData>> mutableLiveData = cartFragmentViewModel._cartFragmentLiveData;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        mutableLiveData.postValue(new Result.Error(th2, false, (Object) null, 6, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-13  reason: not valid java name */
    public static final Pair m9803initViewModel$lambda13(CartFragmentViewModel cartFragmentViewModel, CartResponse cartResponse) {
        List<Product> list;
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(cartResponse, "response");
        if (cartFragmentViewModel.getShowAlertsOnCart()) {
            list = cartFragmentViewModel.cartController.updateCartSyncSuccessV2(cartResponse);
        } else {
            list = cartFragmentViewModel.cartController.updateCartSyncSuccess(cartResponse);
        }
        return new Pair(cartFragmentViewModel.applyPricesAndCategories(list, cartResponse), cartFragmentViewModel.calcSummary(cartResponse));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-16  reason: not valid java name */
    public static final List m9804initViewModel$lambda16(CartFragmentViewModel cartFragmentViewModel, Pair pair) {
        boolean z11;
        String str;
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        Iterable<Product> iterable = (List) pair.component1();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Product product : iterable) {
            Iterable appliedCampaigns = product.getAppliedCampaigns();
            if (!(appliedCampaigns instanceof Collection) || !((Collection) appliedCampaigns).isEmpty()) {
                Iterator it = appliedCampaigns.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String campaignId = ((CampaignLabel) it.next()).getCampaignId();
                    CampaignTrigger campaignTrigger = product.getCampaignTrigger();
                    if (campaignTrigger != null) {
                        str = campaignTrigger.getCampaignId();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual((Object) campaignId, (Object) str)) {
                        z11 = true;
                        break;
                    }
                }
            }
            z11 = false;
            arrayList.add(new CartProduct(product, z11, false, cartFragmentViewModel.getShowAlertsOnCart()));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-18  reason: not valid java name */
    public static final List m9805initViewModel$lambda18(List list) {
        Intrinsics.checkNotNullParameter(list, "products");
        Iterable<Product> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Product cartProduct : iterable) {
            arrayList.add(new CartProduct(cartProduct, false, true, false));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-20  reason: not valid java name */
    public static final List m9806initViewModel$lambda20(CartFragmentViewModel cartFragmentViewModel, CartResponse cartResponse) {
        FeeDescription feeDescription;
        String str;
        String str2;
        String str3;
        Object obj;
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(cartResponse, "response");
        List<FeeDescription> feeDescriptions = cartResponse.getFeeDescriptions();
        String str4 = null;
        if (feeDescriptions != null) {
            Iterator it = feeDescriptions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((FeeDescription) obj).getType(), (Object) DarkstoresConstantsKt.FEE_DESCRIPTION_TYPE_BANNER)) {
                    break;
                }
            }
            feeDescription = (FeeDescription) obj;
        } else {
            feeDescription = null;
        }
        if (!FeeDescriptionDisplayModelKt.isValidForDisplay(feeDescription) || cartFragmentViewModel.disclaimerRepository.isDisclaimerDismissed()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (feeDescription != null) {
            str = feeDescription.getName();
        } else {
            str = null;
        }
        if (feeDescription != null) {
            str2 = feeDescription.getDescription();
        } else {
            str2 = null;
        }
        if (feeDescription != null) {
            str3 = feeDescription.getUrl();
        } else {
            str3 = null;
        }
        if (feeDescription != null) {
            str4 = feeDescription.getUrlText();
        }
        return CollectionsKt__CollectionsJVMKt.listOf(new CartDisclaimer(str, str2, str3, str4));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-21  reason: not valid java name */
    public static final Function1 m9807initViewModel$lambda21(List list) {
        Intrinsics.checkNotNullParameter(list, "disclaimer");
        return new CartFragmentViewModel$initViewModel$1$1(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-22  reason: not valid java name */
    public static final Function1 m9808initViewModel$lambda22(List list) {
        Intrinsics.checkNotNullParameter(list, "products");
        return new CartFragmentViewModel$initViewModel$2$1(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-23  reason: not valid java name */
    public static final Function1 m9809initViewModel$lambda23(List list) {
        Intrinsics.checkNotNullParameter(list, "products");
        return new CartFragmentViewModel$initViewModel$3$1(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-24  reason: not valid java name */
    public static final Function1 m9810initViewModel$lambda24(CartSwimlane cartSwimlane) {
        Intrinsics.checkNotNullParameter(cartSwimlane, "cartSwimlane");
        return new CartFragmentViewModel$initViewModel$4$1(cartSwimlane);
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-25  reason: not valid java name */
    public static final CartListContent m9811initViewModel$lambda25(CartListContent cartListContent, Function1 function1) {
        Intrinsics.checkNotNullParameter(cartListContent, "currentItems");
        Intrinsics.checkNotNullParameter(function1, "aggregator");
        return (CartListContent) function1.invoke(cartListContent);
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-27  reason: not valid java name */
    public static final List m9812initViewModel$lambda27(CartFragmentViewModel cartFragmentViewModel, CartListContent cartListContent) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(cartListContent, "it");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cartListContent.getDisclaimer());
        arrayList.addAll(cartListContent.getProducts());
        if (cartFragmentViewModel.getShowAlertsOnCart() && (!cartListContent.getOosProducts().isEmpty())) {
            arrayList.add(new CartSectionHeader(CartSectionType.OOS));
            arrayList.addAll(cartListContent.getOosProducts());
        }
        arrayList.addAll(cartListContent.getSwimlane());
        arrayList.addAll(cartListContent.getStaticItems());
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-28  reason: not valid java name */
    public static final CartFragmentData m9813initViewModel$lambda28(CartFragmentViewModel cartFragmentViewModel, Pair pair, Vendor vendor) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(pair, "productsWithSummary");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return new CartFragmentData(pair, vendor, cartFragmentViewModel.enableCheckout((CartSummary) pair.getSecond(), vendor), cartFragmentViewModel.enableBasketBasedDeliveryFee(vendor.isTPro(), vendor.getBasketDeliveryFeeTiersInfo()), cartFragmentViewModel.enableServiceFeeDescriptionFix());
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-29  reason: not valid java name */
    public static final void m9814initViewModel$lambda29(CartFragmentViewModel cartFragmentViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        MutableLiveData<Result<CartFragmentData>> mutableLiveData = cartFragmentViewModel._cartFragmentLiveData;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        mutableLiveData.postValue(new Result.Error(th2, true, (Object) null, 4, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-31  reason: not valid java name */
    public static final ObservableSource m9815initViewModel$lambda31(CartFragmentViewModel cartFragmentViewModel, Observable observable) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(observable, "it");
        return observable.flatMap(new e1(cartFragmentViewModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-31$lambda-30  reason: not valid java name */
    public static final ObservableSource m9816initViewModel$lambda31$lambda30(CartFragmentViewModel cartFragmentViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(th2, "it");
        return cartFragmentViewModel.retrySubject;
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-33  reason: not valid java name */
    public static final ObservableSource m9817initViewModel$lambda33(CartFragmentViewModel cartFragmentViewModel, HttpException httpException) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(httpException, "e");
        return cartFragmentViewModel.darkstoresRepo.getVendor().toObservable().map(new s(cartFragmentViewModel, httpException));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-33$lambda-32  reason: not valid java name */
    public static final Unit m9818initViewModel$lambda33$lambda32(CartFragmentViewModel cartFragmentViewModel, HttpException httpException, Vendor vendor) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(httpException, "$e");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        NfvObservabilityHandler nfvObservabilityHandler = NfvObservabilityHandler.INSTANCE;
        String cartId = cartFragmentViewModel.cartController.getCartId();
        String vendorId = vendor.getVendorId();
        int code = httpException.code();
        String message = httpException.message();
        Intrinsics.checkNotNullExpressionValue(message, "e.message()");
        nfvObservabilityHandler.onDarkstoresCartError(cartId, vendorId, code, message);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-35  reason: not valid java name */
    public static final ObservableSource m9819initViewModel$lambda35(CartFragmentViewModel cartFragmentViewModel, Product product) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(product, "product");
        return cartFragmentViewModel.darkstoresRepo.getVendor().toObservable().map(new s0(cartFragmentViewModel, product));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-35$lambda-34  reason: not valid java name */
    public static final Unit m9820initViewModel$lambda35$lambda34(CartFragmentViewModel cartFragmentViewModel, Product product, Vendor vendor) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(product, "$product");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        if (cartFragmentViewModel.configurationParameters.isMigrated()) {
            NfvObservabilityHandler.INSTANCE.onDarkstoresMigratedFalseDjiniValidation(cartFragmentViewModel.cartController.getCartId(), vendor.getVendorId(), product.getId());
        } else {
            NfvObservabilityHandler.INSTANCE.onDarkstoresOutOfStockError(cartFragmentViewModel.cartController.getCartId(), vendor.getVendorId(), product.getId(), cartFragmentViewModel.configurationParameters.getCountryCode());
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-36  reason: not valid java name */
    public static final ObservableSource m9821initViewModel$lambda36(CartFragmentViewModel cartFragmentViewModel, Unit unit) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(unit, "it");
        return ResultKt.toResult(cartFragmentViewModel.deliveryDetailsRepo.getDeliveryDetailsModel());
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-37  reason: not valid java name */
    public static final boolean m9822initViewModel$lambda37(boolean z11, CartResponse cartResponse) {
        Intrinsics.checkNotNullParameter(cartResponse, "it");
        return z11;
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewModel$lambda-4  reason: not valid java name */
    public static final SingleSource m9823initViewModel$lambda4(CartFragmentViewModel cartFragmentViewModel, Optional optional) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(optional, "it");
        if (optional instanceof Optional.Some) {
            AddToCartData addToCartData = (AddToCartData) ((Optional.Some) optional).getValue();
            return cartFragmentViewModel.cartController.setProductCount(addToCartData.getProduct(), addToCartData.getQuantity(), addToCartData.isAdded(), addToCartData.getListPosition(), cartFragmentViewModel.eventOriginType, addToCartData.getTrackingCategoryId(), addToCartData.getSwimlaneTrackingData(), addToCartData.getSwimlaneRequestId(), addToCartData.getSwimlaneStrategy(), addToCartData.getUseOldTracking()).toSingleDefault(Unit.INSTANCE);
        } else if (Intrinsics.areEqual((Object) optional, (Object) Optional.None.INSTANCE)) {
            return Single.just(Unit.INSTANCE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onClearCartPermissionGranted$lambda-49  reason: not valid java name */
    public static final void m9824onClearCartPermissionGranted$lambda49(CartFragmentViewModel cartFragmentViewModel, ClearCartPermissionData clearCartPermissionData) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(clearCartPermissionData, "$clearCartPermissionData");
        cartFragmentViewModel.addProductToCart(clearCartPermissionData.getAddToCartData());
    }

    private final boolean shouldClearCart(int i11, String str) {
        return i11 > 0 && !Intrinsics.areEqual((Object) str, (Object) getCurrentVendorCode$com_talabat_NewArchi_darkstores_darkstores());
    }

    /* access modifiers changed from: private */
    /* renamed from: showMultiBasketToast$lambda-50  reason: not valid java name */
    public static final MaybeSource m9825showMultiBasketToast$lambda50(CartFragmentViewModel cartFragmentViewModel, Vendor vendor) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return cartFragmentViewModel.getCartListToast.invoke(vendor.getVendorId());
    }

    /* access modifiers changed from: private */
    /* renamed from: showMultiBasketToast$lambda-51  reason: not valid java name */
    public static final void m9826showMultiBasketToast$lambda51(CartFragmentViewModel cartFragmentViewModel) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "this$0");
        cartFragmentViewModel.invalidateCartListCache.invoke();
    }

    private final Disposable subscribeToCartProducts() {
        Observable<R> map = ignoreIfCartOwnedByAnotherVendor(this.cartController.getAllAsObservable()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(new a1());
        Intrinsics.checkNotNullExpressionValue(map, "cartController.getAllAsO…id }, { it.cartCount }) }");
        return SubscribersKt.subscribeBy$default((Observable) map, (Function1) CartFragmentViewModel$subscribeToCartProducts$2.INSTANCE, (Function0) null, (Function1) new CartFragmentViewModel$subscribeToCartProducts$3(this), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToCartProducts$lambda-67  reason: not valid java name */
    public static final Map m9827subscribeToCartProducts$lambda67(List list) {
        Intrinsics.checkNotNullParameter(list, "products");
        Iterable<Product> iterable = list;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Product product : iterable) {
            linkedHashMap.put(product.getId(), Integer.valueOf(product.getCartCount()));
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    public final void trackDeliveryTierBottomSheetLoaded(DeliveryDetails deliveryDetails2) {
        this.deliveryTierBottomSheetTracker.trackDarkStoreBottomSheetLoadedEvent(DarkStoresBottomSheetName.DELIVERY_FEE_TIERS, getDeliveyFeeFlowType(this.deliveryFeeTierFeatureFlagUseCase.isBasketBasedDeliveryFeeEnabled(deliveryDetails2.isTPro(), deliveryDetails2.getBasketDeliveryFeeTiersInfo())));
    }

    public static /* synthetic */ void trackScreenOpened$default(CartFragmentViewModel cartFragmentViewModel, String str, EventOriginType eventOriginType2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            eventOriginType2 = EventOriginType.None;
        }
        cartFragmentViewModel.trackScreenOpened(str, eventOriginType2);
    }

    private final void trackVendorVisitEvent() {
        DarkstoresEventTracker darkstoresEventTracker = this.tracker;
        int chainId = this.configurationParameters.getChainId();
        String str = this.configurationParameters.getRestaurant().f13873name;
        Intrinsics.checkNotNullExpressionValue(str, "configurationParameters.restaurant.name");
        int branchId = this.configurationParameters.getBranchId();
        String str2 = this.configurationParameters.getRestaurant().branchName;
        Intrinsics.checkNotNullExpressionValue(str2, "configurationParameters.restaurant.branchName");
        darkstoresEventTracker.onVendorVisit(new VendorVisitDetails(chainId, str, branchId, str2, this.configurationParameters.getRestaurant().shopType, !this.configurationParameters.isMigrated()));
    }

    public final void addAgeLimitToExitPointIfNeeded(@Nullable ExitPointData exitPointData, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "ageLimit");
        if (exitPointData != null) {
            exitPointData.setAgeRestricedLimit(str);
        }
    }

    public final boolean basketBaseDeliveryFeeIsEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(QCommerceFeatureFlagsKeys.BASKET_BASED_DELIVERY_FEE, false);
    }

    @NotNull
    public final LiveData<CampaignProgressVisualisation> campaignVisualisation() {
        return this.campaignVisualisation;
    }

    @NotNull
    public final LiveData<List<Object>> cartListLiveData() {
        return this.cartScreenListLiveData;
    }

    @Nullable
    public final Pair<Integer, Integer> cartProductQuantityAndStock(@NotNull String str) {
        Result.Success success;
        CartFragmentData cartFragmentData;
        Pair<List<Product>, CartSummary> cartProductsWithSummary;
        List first;
        Object obj;
        Intrinsics.checkNotNullParameter(str, "productId");
        Result value = this._cartFragmentLiveData.getValue();
        if (value == null) {
            return null;
        }
        if (value instanceof Result.Success) {
            success = (Result.Success) value;
        } else {
            success = null;
        }
        if (success == null || (cartFragmentData = (CartFragmentData) success.getData()) == null || (cartProductsWithSummary = cartFragmentData.getCartProductsWithSummary()) == null || (first = cartProductsWithSummary.getFirst()) == null) {
            return null;
        }
        Iterator it = first.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((Product) obj).getId(), (Object) str)) {
                break;
            }
        }
        Product product = (Product) obj;
        if (product != null) {
            return TuplesKt.to(Integer.valueOf(product.getCartCount()), Integer.valueOf(product.getStock()));
        }
        return null;
    }

    public final boolean checkAgeRestricted(@NotNull Result.Success<CartFragmentData> success) {
        Intrinsics.checkNotNullParameter(success, "result");
        Iterable<Product> first = success.getData().getCartProductsWithSummary().getFirst();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(first, 10));
        for (Product ageLimit2 : first) {
            arrayList.add(Integer.valueOf(ageLimit2.getAgeLimit()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            boolean z11 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Number) next).intValue() == 0) {
                z11 = true;
            }
            if (!z11) {
                arrayList2.add(next);
            }
        }
        List sorted = CollectionsKt___CollectionsKt.sorted(arrayList2);
        if (!(!sorted.isEmpty())) {
            return false;
        }
        this.ageLive.postValue(new EventWrapper(String.valueOf(((Number) CollectionsKt___CollectionsKt.last(sorted)).intValue())));
        this.tracker.onDarkstoresAgeVerificationShown();
        return true;
    }

    public final void checkout(@NotNull DarkstoresMainActivity darkstoresMainActivity, @Nullable CheckoutParams checkoutParams) {
        CartFragmentData cartFragmentData;
        String str;
        CartSummary cartSummary;
        Float f11;
        Float f12;
        Float f13;
        String str2;
        Vendor vendor;
        Pair<List<Product>, CartSummary> cartProductsWithSummary;
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "activity");
        Result value = getCartFragmentLiveData().getValue();
        ExitPointData exitPointData = null;
        if (value != null) {
            cartFragmentData = (CartFragmentData) value.getData();
        } else {
            cartFragmentData = null;
        }
        if (checkoutParams == null) {
            if (cartFragmentData == null || (cartProductsWithSummary = cartFragmentData.getCartProductsWithSummary()) == null) {
                cartSummary = null;
            } else {
                cartSummary = cartProductsWithSummary.getSecond();
            }
            IDarkstoresFeesTracker iDarkstoresFeesTracker = this.feesTracker;
            if (cartSummary != null) {
                f11 = Float.valueOf(cartSummary.getDeliveryFee());
            } else {
                f11 = null;
            }
            if (cartSummary != null) {
                f12 = cartSummary.getServiceFee();
            } else {
                f12 = null;
            }
            if (cartSummary != null) {
                f13 = Float.valueOf(cartSummary.getTotal());
            } else {
                f13 = null;
            }
            if (cartFragmentData == null || (vendor = cartFragmentData.getVendor()) == null) {
                str2 = null;
            } else {
                str2 = vendor.getVendorCode();
            }
            iDarkstoresFeesTracker.onCheckoutClicked(f11, f12, f13, str2);
        }
        if (cartFragmentData != null) {
            exitPointData = CartFragmentViewModelKt.toExitPointData(cartFragmentData);
        }
        if (exitPointData != null) {
            if (checkoutParams == null || (str = checkoutParams.getSpecialRequest()) == null) {
                str = this.specialRequest;
            }
            exitPointData.setDarkstoresSpecialRequest(str);
        }
        addAgeLimitToExitPointIfNeeded(exitPointData, this.ageLimit);
        updateNonMigratedCartForCheckoutWithDarkstores$com_talabat_NewArchi_darkstores_darkstores(darkstoresMainActivity);
        this.listener.onCheckout(darkstoresMainActivity, exitPointData, InjectorKt.getAppComponent().getConfigurationParameters().getRestaurant());
    }

    public final void clearCart() {
        CompositeDisposable a11 = a();
        Disposable subscribe = this.cartController.clearCart().doOnComplete(new v(this)).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "cartController.clearCart…\n            .subscribe()");
        DisposableKt.plusAssign(a11, subscribe);
    }

    public final void clearVendorCache() {
        this.darkstoresRepo.clearVendorCache();
    }

    public void decreaseProductCount(@NotNull Product product, int i11, @Nullable Integer num, @Nullable TrackingCategoryId trackingCategoryId, @Nullable SwimlaneTrackingData swimlaneTrackingData, @Nullable String str, @Nullable String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(product, "product");
        this.productCountChanged.onNext(OptionalKt.toOptional(new AddToCartData(product, i11, num, false, trackingCategoryId, swimlaneTrackingData, str, str2, z11)));
    }

    @NotNull
    public final LiveData<Result<DeliveryDetails>> deliveryDetails() {
        return this.deliveryDetails;
    }

    public final void dismissDisclaimer() {
        this.disclaimerRepository.setDisclaimerDismissed(true);
    }

    public final boolean enableBasketBasedDeliveryFee(boolean z11, @Nullable BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo) {
        return !z11 && basketDeliveryFeeTiersInfo != null && basketBaseDeliveryFeeIsEnabled();
    }

    @NotNull
    public final String getAgeLimit() {
        return this.ageLimit;
    }

    @NotNull
    public final MutableLiveData<EventWrapper<String>> getAgeLive() {
        return this.ageLive;
    }

    @NotNull
    public final MutableLiveData<ClearCartPermissionData> getCartClearPermission() {
        return this._cartClearPermission;
    }

    @NotNull
    public final LiveData<Result<CartFragmentData>> getCartFragmentLiveData() {
        return this._cartFragmentLiveData;
    }

    @NotNull
    public final LiveData<EventWrapper<Throwable>> getCartInitErrorLiveData() {
        return this._cartInitErrorLiveData;
    }

    @NotNull
    public final LiveData<EventWrapper<CartListToast>> getCartListToastLiveData() {
        return this._cartListToastLiveData;
    }

    @NotNull
    public final LiveData<Map<String, Integer>> getCartMapLiveData() {
        LiveData<Map<String, Integer>> distinctUntilChanged = Transformations.distinctUntilChanged(this._cartMapLiveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "Transformations.distinctUntilChanged(this)");
        return distinctUntilChanged;
    }

    @NotNull
    public final CartProductViewType getCartProductViewType() {
        return this.cartProductViewType;
    }

    @NotNull
    public final LiveData<Result<Unit>> getCartReadyLiveData() {
        return this._cartReadyLiveData;
    }

    @NotNull
    public final PublishSubject<CartSwimlane> getCartSwimlaneSubject$com_talabat_NewArchi_darkstores_darkstores() {
        return this.cartSwimlaneSubject;
    }

    @NotNull
    public final MutableLiveData<Boolean> getCartSyncWarning() {
        return this._cartSyncWarning;
    }

    public final int getCategoriesRowsCount() {
        return this.categoriesRowsCount;
    }

    @NotNull
    public final LiveData<EventWrapper<CheckoutParams>> getCheckoutActionLiveData() {
        return this._checkoutActionLiveData;
    }

    @NotNull
    public final String getCurrentVendorCode$com_talabat_NewArchi_darkstores_darkstores() {
        return this.configurationParameters.getVendorCode();
    }

    @NotNull
    public final String getCurrentVendorName$com_talabat_NewArchi_darkstores_darkstores() {
        return this.configurationParameters.getTalabatVendorInfo().getName();
    }

    @NotNull
    public final MutableLiveData<EventWrapper<Boolean>> getDuplicateCartLiveData() {
        return this.duplicateCartLiveData;
    }

    @NotNull
    public final MutableLiveData<EventWrapper<Boolean>> getEligibilityLive() {
        return this.eligibilityLive;
    }

    @NotNull
    public final FlutterDeliveryFeeTierRequest getFlutterDeliveryFeeTierRequest(@NotNull BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo) {
        Intrinsics.checkNotNullParameter(basketDeliveryFeeTiersInfo, "basketDeliveryFeeTiersInfo");
        return this.flutterDeliveryTierMapper.apply(basketDeliveryFeeTiersInfo);
    }

    @NotNull
    public final LiveData<EventWrapper<Unit>> getNavigationReadyLiveData() {
        return this._navigationReadyLiveData;
    }

    @NotNull
    public final PreferencesResponse getPreferences() {
        return this.preferences;
    }

    public final boolean getServiceFeeEnabled() {
        return this.serviceFeeEnabled;
    }

    @NotNull
    public final LiveData<BottomCartViewState> getShowBottomCartViewStateLiveData() {
        return this.showBottomCartViewStateMutableLiveData;
    }

    @NotNull
    public final String getSpecialRequest() {
        return this.specialRequest;
    }

    @NotNull
    public final Bundle getStoreTrackingInfo() {
        return this.storeInfoTrackingProvider.getStoreInfoParams();
    }

    public final void handleCheckoutNavigation(@NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, Unit> function2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function2, "navigateToFlutterBottomSheet");
        Intrinsics.checkNotNullParameter(function0, "navigateToCheckout");
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildBasketUpsellAction.invoke(this.cartController.getCartId(), function2, function0), (Function1) null, (Function1) null, 3, (Object) null));
    }

    public final void handleDeliveryFeeNavigation(@NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "navigateToFlutterBottomSheet");
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildDeliveryFeeTierNavigationUseCase.invoke(function2), (Function1) null, (Function1) null, 3, (Object) null));
    }

    public final void handleNavDestinationChange(@NotNull NavDestination navDestination, @Nullable Bundle bundle) {
        boolean z11;
        Intrinsics.checkNotNullParameter(navDestination, "destination");
        int id2 = navDestination.getId();
        boolean z12 = false;
        if (id2 == R.id.cartFragment || id2 == R.id.productFragment) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || id2 == R.id.flutterSearchFragment) {
            z12 = true;
        }
        if (z12) {
            this.showBottomCartViewStateMutableLiveData.postValue(BottomCartViewState.HideBottomCartViewState.INSTANCE);
            return;
        }
        this.showBottomCartViewStateMutableLiveData.postValue(new BottomCartViewState.ShowBottomCartViewState(getScreenTrackingInfo(navDestination, bundle)));
    }

    public void increaseProductCount(@NotNull Product product, int i11, @Nullable Integer num, @Nullable TrackingCategoryId trackingCategoryId, @Nullable SwimlaneTrackingData swimlaneTrackingData, @Nullable String str, @Nullable String str2, boolean z11, @NotNull Function0<Unit> function0) {
        Function0<Unit> function02 = function0;
        Product product2 = product;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(function02, "onFailure");
        if (i11 != 0) {
            CompositeDisposable a11 = a();
            Disposable subscribe = this.cartController.getCartCount().map(new b1(product, i11, num, trackingCategoryId, swimlaneTrackingData, str, str2, z11)).flatMap(new c1(this, function02)).subscribe(new d1(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "cartController.getCartCo…          }\n            }");
            DisposableKt.plusAssign(a11, subscribe);
        }
    }

    public final void initCart() {
        CompositeDisposable a11 = a();
        Completable doOnSubscribe = this.initCartUseCase.invoke().doOnSubscribe(new u(this));
        Intrinsics.checkNotNullExpressionValue(doOnSubscribe, "initCartUseCase()\n      ….Loading())\n            }");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy(doOnSubscribe, (Function1<? super Throwable, Unit>) new CartFragmentViewModel$initCart$2(this), (Function0<Unit>) new CartFragmentViewModel$initCart$3(this)));
    }

    public final boolean isDisclaimerDismissed() {
        return this.disclaimerRepository.isDisclaimerDismissed();
    }

    public final boolean isLoggedIn() {
        return this.customer.isLoggedIn();
    }

    public final void onCartScreenLoaded() {
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Maybe) this.cartSwimlaneUseCase.getCartSwimlane(), (Function1) null, (Function0) null, (Function1) new CartFragmentViewModel$onCartScreenLoaded$1(this), 3, (Object) null));
    }

    public final void onCheckoutClicked(@NotNull Fragment fragment, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.VENDOR_CODE);
        new DarkstoresCarrierBagManager(fragment, str, new CartFragmentViewModel$onCheckoutClicked$1(this, fragment)).show();
    }

    public final void onClearCartPermissionDenied(@NotNull ClearCartPermissionData clearCartPermissionData) {
        Intrinsics.checkNotNullParameter(clearCartPermissionData, "clearCartPermissionData");
        clearCartPermissionData.getOnAddToCartFailure().invoke();
    }

    public final void onClearCartPermissionGranted(@NotNull ClearCartPermissionData clearCartPermissionData) {
        Intrinsics.checkNotNullParameter(clearCartPermissionData, "clearCartPermissionData");
        CompositeDisposable a11 = a();
        Disposable subscribe = this.cartController.clearCart().doOnComplete(new t0(this, clearCartPermissionData)).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "cartController.clearCart…\n            .subscribe()");
        DisposableKt.plusAssign(a11, subscribe);
    }

    public void onCleared() {
        this.cartController.clearSelectedVendor();
        super.onCleared();
    }

    public final void onControlSelected(@NotNull Control control, boolean z11) {
        Intrinsics.checkNotNullParameter(control, "selected");
        this.selectedControlSubject.onNext(new Optional.Some(control));
        if (z11) {
            saveUserPreference(control);
        }
    }

    public final void onDeliveryTierBottomSheetClicked(@NotNull EventOriginType eventOriginType2, @NotNull DeliveryTierClickOrigin deliveryTierClickOrigin) {
        BottomSheetClickOriginIconType bottomSheetClickOriginIconType;
        Intrinsics.checkNotNullParameter(eventOriginType2, "eventOrigin");
        Intrinsics.checkNotNullParameter(deliveryTierClickOrigin, ConstantsKt.CLICK_CLICK_ORIGIN);
        int i11 = WhenMappings.$EnumSwitchMapping$0[deliveryTierClickOrigin.ordinal()];
        if (i11 == 1) {
            bottomSheetClickOriginIconType = BottomSheetClickOriginIconType.CART_PROGRESS_INFO;
        } else if (i11 == 2) {
            bottomSheetClickOriginIconType = BottomSheetClickOriginIconType.DELIVERY_FEE_INFO;
        } else if (i11 == 3) {
            bottomSheetClickOriginIconType = BottomSheetClickOriginIconType.PAYMENT_INFO;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.deliveryTierBottomSheetTracker.trackDarkStoreBottomSheetClickedEvent(eventOriginType2, bottomSheetClickOriginIconType, DarkStoresBottomSheetName.DELIVERY_FEE_TIERS);
    }

    public final void onHomeReady() {
        showMultiBasketToast$com_talabat_NewArchi_darkstores_darkstores();
    }

    public final void onReadyForInteractionDhDefinition() {
        this.screenTracker.stopTrace(ScreenTrackerParams.Companion.create(QCommerceScreenTracingNames.QCOMMERCE_BASKET_START_TO_INTERACTIVE.getValue()));
    }

    public final void onReadyForInteractionTlbDefinition() {
        this.screenTracker.stopTrace(ScreenTrackerParams.Companion.create(QCommerceScreenTracingNames.TLB_QCOMMERCE_BASKET_START_TO_INTERACTIVE.getValue()));
    }

    public final void onRetry() {
        this.retrySubject.onNext(Unit.INSTANCE);
    }

    public final void onVendorMenuOpened() {
        CompositeDisposable a11 = a();
        Disposable subscribe = this.darkstoresRepository.putLastVisitedVendor(this.configurationParameters.getRestaurant()).onErrorComplete().subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "darkstoresRepository\n   …\n            .subscribe()");
        DisposableKt.plusAssign(a11, subscribe);
    }

    public final void resetCartWithNewId() {
        this.cartController.clearDuplicateCartId();
        validateCart();
    }

    public final void saveBasketUpsellBottomSheetShown() {
        this.saveBasketUpsellBottomSheetShown.invoke(this.cartController.getCartId());
    }

    public final void saveUserPreference(@NotNull Control control) {
        Intrinsics.checkNotNullParameter(control, "selected");
        CompositeDisposable a11 = a();
        Disposable subscribe = this.partialFulfillmentRepo.savePreference(control.getCode()).observeOn(AndroidSchedulers.mainThread()).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "partialFulfillmentRepo.s…\n            .subscribe()");
        DisposableKt.plusAssign(a11, subscribe);
    }

    public final void setAgeLimit(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ageLimit = str;
    }

    public final void setAgeLive(@NotNull MutableLiveData<EventWrapper<String>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.ageLive = mutableLiveData;
    }

    public final void setEligibilityLive(@NotNull MutableLiveData<EventWrapper<Boolean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.eligibilityLive = mutableLiveData;
    }

    public final void setPreferences(@NotNull PreferencesResponse preferencesResponse) {
        Intrinsics.checkNotNullParameter(preferencesResponse, "<set-?>");
        this.preferences = preferencesResponse;
    }

    public final void setSpecialRequest(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.specialRequest = str;
    }

    @VisibleForTesting
    public final void showMultiBasketToast$com_talabat_NewArchi_darkstores_darkstores() {
        CompositeDisposable a11 = a();
        Maybe<R> doFinally = this.darkstoresRepo.getVendor().flatMapMaybe(new f1(this)).subscribeOn(Schedulers.io()).doFinally(new g1(this));
        Intrinsics.checkNotNullExpressionValue(doFinally, "darkstoresRepo.getVendor…ListCache()\n            }");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Maybe) doFinally, (Function1) null, (Function0) null, (Function1) new CartFragmentViewModel$showMultiBasketToast$3(this), 3, (Object) null));
    }

    public final boolean showOosPredictionAlert() {
        return Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.BASKET_PRE_CHECKOUT_PAINTED_DOOR_TEST, "", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    public final void startTraceDefinition() {
        IScreenTracker iScreenTracker = this.screenTracker;
        ScreenTrackerParams.Companion companion = ScreenTrackerParams.Companion;
        iScreenTracker.startTrace(companion.create(QCommerceScreenTracingNames.QCOMMERCE_BASKET_START_TO_INTERACTIVE.getValue()));
        this.screenTracker.startTrace(companion.create(QCommerceScreenTracingNames.TLB_QCOMMERCE_BASKET_START_TO_INTERACTIVE.getValue()));
    }

    public final void trackCartOpened() {
        CartFragmentData cartFragmentData;
        CartSummary cartSummary;
        Float f11;
        Float f12;
        Float f13;
        Vendor vendor;
        Pair<List<Product>, CartSummary> cartProductsWithSummary;
        Result value = getCartFragmentLiveData().getValue();
        String str = null;
        if (value != null) {
            cartFragmentData = (CartFragmentData) value.getData();
        } else {
            cartFragmentData = null;
        }
        if (cartFragmentData == null || (cartProductsWithSummary = cartFragmentData.getCartProductsWithSummary()) == null) {
            cartSummary = null;
        } else {
            cartSummary = cartProductsWithSummary.getSecond();
        }
        IDarkstoresFeesTracker iDarkstoresFeesTracker = this.feesTracker;
        if (cartSummary != null) {
            f11 = Float.valueOf(cartSummary.getDeliveryFee());
        } else {
            f11 = null;
        }
        if (cartSummary != null) {
            f12 = cartSummary.getServiceFee();
        } else {
            f12 = null;
        }
        if (cartSummary != null) {
            f13 = Float.valueOf(cartSummary.getTotal());
        } else {
            f13 = null;
        }
        if (!(cartFragmentData == null || (vendor = cartFragmentData.getVendor()) == null)) {
            str = vendor.getVendorCode();
        }
        iDarkstoresFeesTracker.onCartLoaded(f11, f12, f13, str);
    }

    public final void trackCheckoutAlertVisibility(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "eventOrigin");
        this.tracker.trackPreCheckoutAlertVisibility(str, str2);
    }

    public final void trackDisclaimerDisplayed() {
        String str;
        CartFragmentData cartFragmentData;
        Vendor vendor;
        IDarkstoresFeesTracker iDarkstoresFeesTracker = this.feesTracker;
        Result value = getCartFragmentLiveData().getValue();
        if (value == null || (cartFragmentData = (CartFragmentData) value.getData()) == null || (vendor = cartFragmentData.getVendor()) == null) {
            str = null;
        } else {
            str = vendor.getVendorCode();
        }
        iDarkstoresFeesTracker.onFeeDisclaimerBannerDisplayed(str, "Cart Screen");
    }

    public final void trackFeeInfoClicked(@NotNull String str) {
        String str2;
        CartFragmentData cartFragmentData;
        Vendor vendor;
        Intrinsics.checkNotNullParameter(str, FeeTrackingConstantsKt.ATTRIBUTE_DISCLAIMER_TYPE);
        IDarkstoresFeesTracker iDarkstoresFeesTracker = this.feesTracker;
        Result value = getCartFragmentLiveData().getValue();
        if (value == null || (cartFragmentData = (CartFragmentData) value.getData()) == null || (vendor = cartFragmentData.getVendor()) == null) {
            str2 = null;
        } else {
            str2 = vendor.getVendorCode();
        }
        iDarkstoresFeesTracker.onFeeInfoClicked(str, str2, "Cart Screen");
    }

    public final void trackFeeInfoUrlClicked() {
        String str;
        CartFragmentData cartFragmentData;
        Vendor vendor;
        IDarkstoresFeesTracker iDarkstoresFeesTracker = this.feesTracker;
        Result value = getCartFragmentLiveData().getValue();
        if (value == null || (cartFragmentData = (CartFragmentData) value.getData()) == null || (vendor = cartFragmentData.getVendor()) == null) {
            str = null;
        } else {
            str = vendor.getVendorCode();
        }
        iDarkstoresFeesTracker.onFeeInfoExternalClicked(str, "Cart Screen");
    }

    public final void trackPaymentSummaryExpanded() {
        CartFragmentData cartFragmentData;
        CartSummary cartSummary;
        Vendor vendor;
        Float f11;
        Float f12;
        Float f13;
        Pair<List<Product>, CartSummary> cartProductsWithSummary;
        Result value = getCartFragmentLiveData().getValue();
        String str = null;
        if (value != null) {
            cartFragmentData = (CartFragmentData) value.getData();
        } else {
            cartFragmentData = null;
        }
        if (cartFragmentData == null || (cartProductsWithSummary = cartFragmentData.getCartProductsWithSummary()) == null) {
            cartSummary = null;
        } else {
            cartSummary = cartProductsWithSummary.getSecond();
        }
        if (cartFragmentData != null) {
            vendor = cartFragmentData.getVendor();
        } else {
            vendor = null;
        }
        IDarkstoresFeesTracker iDarkstoresFeesTracker = this.feesTracker;
        if (cartSummary != null) {
            f11 = Float.valueOf(cartSummary.getDeliveryFee());
        } else {
            f11 = null;
        }
        if (cartSummary != null) {
            f12 = cartSummary.getServiceFee();
        } else {
            f12 = null;
        }
        if (cartSummary != null) {
            f13 = Float.valueOf(cartSummary.getTotal());
        } else {
            f13 = null;
        }
        if (vendor != null) {
            str = vendor.getVendorCode();
        }
        iDarkstoresFeesTracker.onPaymentSummaryExpanded(f11, f12, f13, str, "Cart Screen");
    }

    public final void trackScreenOpened(@Nullable String str, @NotNull EventOriginType eventOriginType2) {
        Intrinsics.checkNotNullParameter(eventOriginType2, "eventOriginType");
        this.tracker.onScreenOpened(str, eventOriginType2);
    }

    public final void trackSwimlaneShown(@NotNull CartSwimlane cartSwimlane) {
        String str;
        CartFragmentData cartFragmentData;
        Vendor vendor;
        Intrinsics.checkNotNullParameter(cartSwimlane, "swimlane");
        IDarkstoresFeesTracker iDarkstoresFeesTracker = this.feesTracker;
        Result value = getCartFragmentLiveData().getValue();
        if (value == null || (cartFragmentData = (CartFragmentData) value.getData()) == null || (vendor = cartFragmentData.getVendor()) == null) {
            str = null;
        } else {
            str = vendor.getVendorCode();
        }
        if (str == null) {
            str = "";
        }
        iDarkstoresFeesTracker.onSwimlaneShown(new CartSwimlaneShownEvent(str, cartSwimlane, this.customer.getCustomerInfo()));
        SwimlanesTracker.swimlanesLoaded$default(this.swimlanesTracker, cartSwimlane.getSwimlane().getRequestId(), (List) null, EventOriginType.Cart, ScreenTrackingProvider.ScreenType.CART.getTrackingName(), ScreenTrackingProvider.ScreenName.CART.getTrackingName(), 2, (Object) null);
    }

    public final void trackSwimlaneSwiped(@NotNull CartSwimlane cartSwimlane, int i11) {
        String str;
        CartFragmentData cartFragmentData;
        Vendor vendor;
        Intrinsics.checkNotNullParameter(cartSwimlane, "swimlane");
        IDarkstoresFeesTracker iDarkstoresFeesTracker = this.feesTracker;
        Result value = getCartFragmentLiveData().getValue();
        if (value == null || (cartFragmentData = (CartFragmentData) value.getData()) == null || (vendor = cartFragmentData.getVendor()) == null) {
            str = null;
        } else {
            str = vendor.getVendorCode();
        }
        if (str == null) {
            str = "";
        }
        iDarkstoresFeesTracker.onSwimlaneSwiped(new CartSwimlaneSwipedEvent(str, cartSwimlane, this.customer.getCustomerInfo(), i11));
    }

    public final void updateEligibility(boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "age");
        this.eligibilityLive.postValue(new EventWrapper(Boolean.valueOf(z11)));
        this.ageLimit = str;
    }

    public final void updateEventOrigin(@NotNull EventOriginType eventOriginType2) {
        Intrinsics.checkNotNullParameter(eventOriginType2, "eventOriginType");
        this.eventOriginType = eventOriginType2;
    }

    @VisibleForTesting
    public final void updateNonMigratedCartForCheckoutWithDarkstores$com_talabat_NewArchi_darkstores_darkstores(@NotNull DarkstoresMainActivity darkstoresMainActivity) {
        Intrinsics.checkNotNullParameter(darkstoresMainActivity, "activity");
        Cart cart = this.nonMigratedCart;
        cart.clearCartFromDarkstores(darkstoresMainActivity);
        cart.setRestaurant(this.configurationParameters.getRestaurant(), darkstoresMainActivity);
    }

    public final void updateSpecialRequest(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.specialRequest = str;
    }

    public final void validateCart() {
        this.productCountChanged.onNext(Optional.None.INSTANCE);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BU\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003JY\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel$CartListContent;", "", "disclaimer", "", "Lcom/talabat/darkstores/feature/cart/CartDisclaimer;", "products", "Lcom/talabat/darkstores/feature/cart/CartProduct;", "oosProducts", "swimlane", "Lcom/talabat/darkstores/feature/cart/CartSwimlane;", "staticItems", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDisclaimer", "()Ljava/util/List;", "getOosProducts", "getProducts", "getStaticItems", "getSwimlane", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CartListContent {
        @NotNull
        private final List<CartDisclaimer> disclaimer;
        @NotNull
        private final List<CartProduct> oosProducts;
        @NotNull
        private final List<CartProduct> products;
        @NotNull
        private final List<Object> staticItems;
        @NotNull
        private final List<CartSwimlane> swimlane;

        public CartListContent() {
            this((List) null, (List) null, (List) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
        }

        public CartListContent(@NotNull List<CartDisclaimer> list, @NotNull List<CartProduct> list2, @NotNull List<CartProduct> list3, @NotNull List<CartSwimlane> list4, @NotNull List<? extends Object> list5) {
            Intrinsics.checkNotNullParameter(list, "disclaimer");
            Intrinsics.checkNotNullParameter(list2, "products");
            Intrinsics.checkNotNullParameter(list3, "oosProducts");
            Intrinsics.checkNotNullParameter(list4, "swimlane");
            Intrinsics.checkNotNullParameter(list5, "staticItems");
            this.disclaimer = list;
            this.products = list2;
            this.oosProducts = list3;
            this.swimlane = list4;
            this.staticItems = list5;
        }

        public static /* synthetic */ CartListContent copy$default(CartListContent cartListContent, List<CartDisclaimer> list, List<CartProduct> list2, List<CartProduct> list3, List<CartSwimlane> list4, List<Object> list5, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = cartListContent.disclaimer;
            }
            if ((i11 & 2) != 0) {
                list2 = cartListContent.products;
            }
            List<CartProduct> list6 = list2;
            if ((i11 & 4) != 0) {
                list3 = cartListContent.oosProducts;
            }
            List<CartProduct> list7 = list3;
            if ((i11 & 8) != 0) {
                list4 = cartListContent.swimlane;
            }
            List<CartSwimlane> list8 = list4;
            if ((i11 & 16) != 0) {
                list5 = cartListContent.staticItems;
            }
            return cartListContent.copy(list, list6, list7, list8, list5);
        }

        @NotNull
        public final List<CartDisclaimer> component1() {
            return this.disclaimer;
        }

        @NotNull
        public final List<CartProduct> component2() {
            return this.products;
        }

        @NotNull
        public final List<CartProduct> component3() {
            return this.oosProducts;
        }

        @NotNull
        public final List<CartSwimlane> component4() {
            return this.swimlane;
        }

        @NotNull
        public final List<Object> component5() {
            return this.staticItems;
        }

        @NotNull
        public final CartListContent copy(@NotNull List<CartDisclaimer> list, @NotNull List<CartProduct> list2, @NotNull List<CartProduct> list3, @NotNull List<CartSwimlane> list4, @NotNull List<? extends Object> list5) {
            Intrinsics.checkNotNullParameter(list, "disclaimer");
            Intrinsics.checkNotNullParameter(list2, "products");
            Intrinsics.checkNotNullParameter(list3, "oosProducts");
            Intrinsics.checkNotNullParameter(list4, "swimlane");
            Intrinsics.checkNotNullParameter(list5, "staticItems");
            return new CartListContent(list, list2, list3, list4, list5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CartListContent)) {
                return false;
            }
            CartListContent cartListContent = (CartListContent) obj;
            return Intrinsics.areEqual((Object) this.disclaimer, (Object) cartListContent.disclaimer) && Intrinsics.areEqual((Object) this.products, (Object) cartListContent.products) && Intrinsics.areEqual((Object) this.oosProducts, (Object) cartListContent.oosProducts) && Intrinsics.areEqual((Object) this.swimlane, (Object) cartListContent.swimlane) && Intrinsics.areEqual((Object) this.staticItems, (Object) cartListContent.staticItems);
        }

        @NotNull
        public final List<CartDisclaimer> getDisclaimer() {
            return this.disclaimer;
        }

        @NotNull
        public final List<CartProduct> getOosProducts() {
            return this.oosProducts;
        }

        @NotNull
        public final List<CartProduct> getProducts() {
            return this.products;
        }

        @NotNull
        public final List<Object> getStaticItems() {
            return this.staticItems;
        }

        @NotNull
        public final List<CartSwimlane> getSwimlane() {
            return this.swimlane;
        }

        public int hashCode() {
            return (((((((this.disclaimer.hashCode() * 31) + this.products.hashCode()) * 31) + this.oosProducts.hashCode()) * 31) + this.swimlane.hashCode()) * 31) + this.staticItems.hashCode();
        }

        @NotNull
        public String toString() {
            List<CartDisclaimer> list = this.disclaimer;
            List<CartProduct> list2 = this.products;
            List<CartProduct> list3 = this.oosProducts;
            List<CartSwimlane> list4 = this.swimlane;
            List<Object> list5 = this.staticItems;
            return "CartListContent(disclaimer=" + list + ", products=" + list2 + ", oosProducts=" + list3 + ", swimlane=" + list4 + ", staticItems=" + list5 + ")";
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ CartListContent(java.util.List r4, java.util.List r5, java.util.List r6, java.util.List r7, java.util.List r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
            /*
                r3 = this;
                r10 = r9 & 1
                if (r10 == 0) goto L_0x0008
                java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            L_0x0008:
                r10 = r9 & 2
                if (r10 == 0) goto L_0x0010
                java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            L_0x0010:
                r10 = r5
                r5 = r9 & 4
                if (r5 == 0) goto L_0x0019
                java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            L_0x0019:
                r0 = r6
                r5 = r9 & 8
                if (r5 == 0) goto L_0x0022
                java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            L_0x0022:
                r1 = r7
                r5 = r9 & 16
                if (r5 == 0) goto L_0x002b
                java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            L_0x002b:
                r2 = r8
                r5 = r3
                r6 = r4
                r7 = r10
                r8 = r0
                r9 = r1
                r10 = r2
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.cart.CartFragmentViewModel.CartListContent.<init>(java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
