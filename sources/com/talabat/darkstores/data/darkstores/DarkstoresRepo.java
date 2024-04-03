package com.talabat.darkstores.data.darkstores;

import com.integration.nfv.observability.NfvObservabilityHandler;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.darkstores.common.extensions.SingleExtensionsKt;
import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.DarkstoresConstantsKt;
import com.talabat.darkstores.data.basket.BasketApi;
import com.talabat.darkstores.data.darkstores.model.BannersResponse;
import com.talabat.darkstores.data.darkstores.model.CartProduct;
import com.talabat.darkstores.data.darkstores.model.CartRequestByCartId;
import com.talabat.darkstores.data.darkstores.model.CartRequestByVendorId;
import com.talabat.darkstores.data.discovery.ProductApi;
import com.talabat.darkstores.data.discovery.model.ProductListingResponse;
import com.talabat.darkstores.data.lookingglass.LookingGlassVoucherApi;
import com.talabat.darkstores.di.LibScope;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.feature.cart.model.PostCartData;
import com.talabat.darkstores.feature.cart.multibasket.Cart;
import com.talabat.darkstores.feature.observability.DarkStoreObservabilityTracker;
import com.talabat.darkstores.feature.product.models.ProductCampaign;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.darkstores.feature.tracking.data.DarkstoreDetails;
import com.talabat.darkstores.model.CampaignTriggersMapper;
import com.talabat.darkstores.model.ProductDiscount;
import com.talabat.darkstores.model.TargetAudienceType;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.feature.darkstorescart.data.model.CampaignTrigger;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.feature.darkstorescart.data.model.CartVendor;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.darkstoresvendor.domain.model.VendorParams;
import com.talabat.feature.darkstoresvendor.domain.repository.VendorRepository;
import com.talabat.features.swimlanevoucherslist.domain.LoadCustomerVouchersSwimLaneUseCase;
import com.talabat.features.swimlanevoucherslist.domain.model.CustomerVoucher;
import com.talabat.features.swimlanevoucherslist.domain.model.VouchersSwimLaneRequest;
import com.talabat.helpers.GlobalConstants;
import com.talabat.mapper.ModelMapper;
import com.talabat.observabilityNew.squads.nfv.ObservableNfvApiNames;
import com.talabat.talabatcore.logger.LogManager;
import di.a;
import di.b;
import di.c;
import di.d;
import di.e;
import di.f;
import di.g;
import di.h;
import di.i;
import di.j;
import di.k;
import di.l;
import di.m;
import di.n;
import di.o;
import di.p;
import di.q;
import di.r;
import di.s;
import di.t;
import di.u;
import di.v;
import di.w;
import di.x;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\b\u0001\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u000e\b\u0001\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0002\u0010#J\u0006\u00101\u001a\u000202J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000200H\u0002J\u0018\u00108\u001a\u0002092\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000200H\u0002J\u0006\u0010:\u001a\u00020;J\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0*0)J\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0)J\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020B0A2\u0006\u0010C\u001a\u00020%J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00170)J\u0012\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0*0)J\u0018\u0010G\u001a\u00020H2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000200H\u0002J\u0012\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0*0)J\u0018\u0010K\u001a\u00020H2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000200H\u0002J\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020M0*2\u0006\u00105\u001a\u000206H\u0002J\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020O0)2\u0006\u0010P\u001a\u00020%J\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002000)J\u0016\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00160)2\u0006\u00105\u001a\u000206H\u0007J\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00160)2\u0006\u00105\u001a\u000206J0\u0010T\u001a\u0002022\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020%2\u0006\u0010X\u001a\u00020%2\u000e\b\u0002\u0010Y\u001a\b\u0012\u0004\u0012\u00020\"0ZH\u0002J\u0010\u0010[\u001a\u0002022\u0006\u0010U\u001a\u00020VH\u0002J\f\u0010\\\u001a\u000202*\u000200H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R+\u0010(\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020+ ,*\n\u0012\u0004\u0012\u00020+\u0018\u00010*0*0)¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000)X\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "darkstoresApi", "Lcom/talabat/darkstores/data/darkstores/DarkstoresApi;", "productApi", "Lcom/talabat/darkstores/data/discovery/ProductApi;", "basketApi", "Lcom/talabat/darkstores/data/basket/BasketApi;", "lookingGlassVoucherApi", "Lcom/talabat/darkstores/data/lookingglass/LookingGlassVoucherApi;", "tracker", "Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "vendorRepository", "Lcom/talabat/feature/darkstoresvendor/domain/repository/VendorRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "darkstoresCartRepository", "Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;", "cartResponseMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "Lcom/talabat/darkstores/feature/cart/multibasket/Cart;", "darkStoreObservabilityTracker", "Lcom/talabat/darkstores/feature/observability/DarkStoreObservabilityTracker;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "ioScheduler", "Lio/reactivex/Scheduler;", "customerVouchersSwimLaneUseCase", "Lcom/talabat/features/swimlanevoucherslist/domain/LoadCustomerVouchersSwimLaneUseCase;", "selectedAreaId", "Ljavax/inject/Provider;", "", "(Lcom/talabat/darkstores/data/ConfigurationParameters;Lcom/talabat/darkstores/data/darkstores/DarkstoresApi;Lcom/talabat/darkstores/data/discovery/ProductApi;Lcom/talabat/darkstores/data/basket/BasketApi;Lcom/talabat/darkstores/data/lookingglass/LookingGlassVoucherApi;Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;Lcom/talabat/feature/darkstoresvendor/domain/repository/VendorRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;Lcom/talabat/mapper/ModelMapper;Lcom/talabat/darkstores/feature/observability/DarkStoreObservabilityTracker;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lio/reactivex/Scheduler;Lcom/talabat/features/swimlanevoucherslist/domain/LoadCustomerVouchersSwimLaneUseCase;Ljavax/inject/Provider;)V", "globalEntityId", "", "getIoScheduler", "()Lio/reactivex/Scheduler;", "vendorCampaigns", "Lio/reactivex/Single;", "", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "kotlin.jvm.PlatformType", "getVendorCampaigns", "()Lio/reactivex/Single;", "vendorSingle", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "clearVendorCache", "", "createCartRequest", "Lcom/talabat/darkstores/data/darkstores/model/CartRequestByCartId;", "postCartData", "Lcom/talabat/darkstores/feature/cart/model/PostCartData;", "vendor", "createCartRequestByVendorId", "Lcom/talabat/darkstores/data/darkstores/model/CartRequestByVendorId;", "generateVoucher", "Lio/reactivex/Completable;", "getAllCampaignsTriggers", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "getBanners", "Lcom/talabat/darkstores/data/darkstores/model/BannersResponse;", "getCampaignForProduct", "Lio/reactivex/Maybe;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign;", "productId", "getCart", "getCustomerVouchers", "Lcom/talabat/features/swimlanevoucherslist/domain/model/CustomerVoucher;", "getDeliveryFee", "", "getDiscounts", "Lcom/talabat/darkstores/model/ProductDiscount;", "getMinimumOrderValue", "getPostCartItems", "Lcom/talabat/darkstores/data/darkstores/model/CartProduct;", "getProductBySku", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "sku", "getVendor", "postCartByCartId", "postCartByVendorId", "trackObservability", "error", "", "globalVendorId", "apiName", "excludedHttpResponseCodes", "", "trackVendorError", "trackSuccess", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@LibScope
public final class DarkstoresRepo {
    @NotNull
    private static final String BRAND_TALABAT = "talabat";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final BasketApi basketApi;
    @NotNull
    private final ModelMapper<CartResponse, Cart> cartResponseMapper;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final LoadCustomerVouchersSwimLaneUseCase customerVouchersSwimLaneUseCase;
    @NotNull
    private final DarkStoreObservabilityTracker darkStoreObservabilityTracker;
    @NotNull
    private final DarkstoresApi darkstoresApi;
    @NotNull
    private final DarkstoresCartRepository darkstoresCartRepository;
    @NotNull
    private final String globalEntityId;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final LookingGlassVoucherApi lookingGlassVoucherApi;
    @NotNull
    private final ProductApi productApi;
    @NotNull
    private final Provider<Integer> selectedAreaId;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @NotNull
    private final DarkstoresEventTracker tracker;
    @NotNull
    private final Single<List<Campaign>> vendorCampaigns;
    @NotNull
    private final VendorRepository vendorRepository;
    @NotNull
    private final Single<Vendor> vendorSingle;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo$Companion;", "", "()V", "BRAND_TALABAT", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public DarkstoresRepo(@NotNull ConfigurationParameters configurationParameters2, @NotNull DarkstoresApi darkstoresApi2, @NotNull ProductApi productApi2, @NotNull BasketApi basketApi2, @NotNull LookingGlassVoucherApi lookingGlassVoucherApi2, @NotNull DarkstoresEventTracker darkstoresEventTracker, @NotNull VendorRepository vendorRepository2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull DarkstoresCartRepository darkstoresCartRepository2, @NotNull ModelMapper<CartResponse, Cart> modelMapper, @NotNull DarkStoreObservabilityTracker darkStoreObservabilityTracker2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @IoScheduler @NotNull Scheduler scheduler, @NotNull LoadCustomerVouchersSwimLaneUseCase loadCustomerVouchersSwimLaneUseCase, @NotNull @Named("selectedAreaId") Provider<Integer> provider) {
        ConfigurationParameters configurationParameters3 = configurationParameters2;
        DarkstoresApi darkstoresApi3 = darkstoresApi2;
        ProductApi productApi3 = productApi2;
        BasketApi basketApi3 = basketApi2;
        LookingGlassVoucherApi lookingGlassVoucherApi3 = lookingGlassVoucherApi2;
        DarkstoresEventTracker darkstoresEventTracker2 = darkstoresEventTracker;
        VendorRepository vendorRepository3 = vendorRepository2;
        ConfigurationLocalRepository configurationLocalRepository3 = configurationLocalRepository2;
        DarkstoresCartRepository darkstoresCartRepository3 = darkstoresCartRepository2;
        ModelMapper<CartResponse, Cart> modelMapper2 = modelMapper;
        DarkStoreObservabilityTracker darkStoreObservabilityTracker3 = darkStoreObservabilityTracker2;
        ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
        Scheduler scheduler2 = scheduler;
        LoadCustomerVouchersSwimLaneUseCase loadCustomerVouchersSwimLaneUseCase2 = loadCustomerVouchersSwimLaneUseCase;
        Provider<Integer> provider2 = provider;
        Intrinsics.checkNotNullParameter(configurationParameters3, "configurationParameters");
        Intrinsics.checkNotNullParameter(darkstoresApi3, "darkstoresApi");
        Intrinsics.checkNotNullParameter(productApi3, "productApi");
        Intrinsics.checkNotNullParameter(basketApi3, "basketApi");
        Intrinsics.checkNotNullParameter(lookingGlassVoucherApi3, "lookingGlassVoucherApi");
        Intrinsics.checkNotNullParameter(darkstoresEventTracker2, "tracker");
        Intrinsics.checkNotNullParameter(vendorRepository3, "vendorRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository3, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(darkstoresCartRepository3, "darkstoresCartRepository");
        Intrinsics.checkNotNullParameter(modelMapper2, "cartResponseMapper");
        Intrinsics.checkNotNullParameter(darkStoreObservabilityTracker3, "darkStoreObservabilityTracker");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(scheduler2, "ioScheduler");
        Intrinsics.checkNotNullParameter(loadCustomerVouchersSwimLaneUseCase2, "customerVouchersSwimLaneUseCase");
        Intrinsics.checkNotNullParameter(provider2, GlobalConstants.ExtraNames.SELECTED_AREA_ID);
        this.configurationParameters = configurationParameters3;
        this.darkstoresApi = darkstoresApi3;
        this.productApi = productApi3;
        this.basketApi = basketApi3;
        this.lookingGlassVoucherApi = lookingGlassVoucherApi3;
        this.tracker = darkstoresEventTracker2;
        this.vendorRepository = vendorRepository3;
        this.configurationLocalRepository = configurationLocalRepository3;
        this.darkstoresCartRepository = darkstoresCartRepository3;
        this.cartResponseMapper = modelMapper2;
        this.darkStoreObservabilityTracker = darkStoreObservabilityTracker3;
        this.talabatFeatureFlag = iTalabatFeatureFlag2;
        this.ioScheduler = scheduler2;
        this.customerVouchersSwimLaneUseCase = loadCustomerVouchersSwimLaneUseCase2;
        this.selectedAreaId = provider2;
        this.globalEntityId = configurationParameters2.getDjiniGlobalEntityId();
        Single<Vendor> doOnError = vendorRepository3.getVendor(new VendorParams(configurationParameters2.getVendorCode(), configurationParameters2.getDjiniGlobalEntityId(), configurationParameters2.getLocation().getLatitude(), configurationParameters2.getLocation().getLongitude(), configurationParameters2.getCustomerId())).doOnSuccess(new v(this)).doOnError(new w(this));
        Intrinsics.checkNotNullExpressionValue(doOnError, "vendorRepository\n       …Error(::trackVendorError)");
        Single<Vendor> subscribeOn = SingleExtensionsKt.cacheButRetryOnError(doOnError).subscribeOn(scheduler2);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "vendorRepository\n       ….subscribeOn(ioScheduler)");
        this.vendorSingle = subscribeOn;
        Single<R> flatMap = subscribeOn.flatMap(new x(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "vendorSingle\n        .fl…}\n            }\n        }");
        this.vendorCampaigns = flatMap;
    }

    private final CartRequestByCartId createCartRequest(PostCartData postCartData, Vendor vendor) {
        return new CartRequestByCartId(getPostCartItems(postCartData), vendor.getVendorId(), TargetAudienceType.ALL, this.globalEntityId, getDeliveryFee(postCartData, vendor), getMinimumOrderValue(postCartData, vendor), this.configurationParameters.getChainId());
    }

    private final CartRequestByVendorId createCartRequestByVendorId(PostCartData postCartData, Vendor vendor) {
        return new CartRequestByVendorId(getPostCartItems(postCartData), vendor.getVendorId(), this.configurationLocalRepository.selectedLanguage().getCode(), true, vendor.getVendorCode(), this.configurationParameters.getLocation().getLatitude(), this.configurationParameters.getLocation().getLongitude(), DarkstoresConstantsKt.DELIVERY_TYPE_DEFAULT, TargetAudienceType.ALL, this.globalEntityId, getDeliveryFee(postCartData, vendor), getMinimumOrderValue(postCartData, vendor), this.configurationParameters.getChainId(), postCartData.getEnableBasketBasedDeliveryFee());
    }

    /* access modifiers changed from: private */
    /* renamed from: generateVoucher$lambda-24  reason: not valid java name */
    public static final void m9658generateVoucher$lambda24(DarkstoresRepo darkstoresRepo, Throwable th2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        y(darkstoresRepo, th2, String.valueOf(darkstoresRepo.configurationParameters.getChainId()), ObservableNfvApiNames.GET_GENERATE_VOUCHER, (Set) null, 8, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: getAllCampaignsTriggers$lambda-17  reason: not valid java name */
    public static final SingleSource m9659getAllCampaignsTriggers$lambda17(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return darkstoresRepo.darkstoresApi.getCampaigns("", "", vendor.getVendorId(), darkstoresRepo.configurationParameters.getLanguageCode(), darkstoresRepo.globalEntityId).doOnError(new t(darkstoresRepo, vendor));
    }

    /* access modifiers changed from: private */
    /* renamed from: getAllCampaignsTriggers$lambda-17$lambda-16  reason: not valid java name */
    public static final void m9660getAllCampaignsTriggers$lambda17$lambda16(DarkstoresRepo darkstoresRepo, Vendor vendor, Throwable th2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "$vendor");
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(darkstoresRepo.talabatFeatureFlag, QCommerceFeatureFlagsKeys.CAMPAIGN_API_OBSERVABILITY, false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            y(darkstoresRepo, th2, vendor.getVendorId(), ObservableNfvApiNames.GET_ALL_CAMPAIGNS, (Set) null, 8, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getAllCampaignsTriggers$lambda-18  reason: not valid java name */
    public static final List m9661getAllCampaignsTriggers$lambda18(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return CampaignTriggersMapper.INSTANCE.map(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: getBanners$lambda-1  reason: not valid java name */
    public static final SingleSource m9662getBanners$lambda1(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "it");
        return darkstoresRepo.darkstoresApi.getBanners(vendor.getVendorId(), darkstoresRepo.configurationParameters.getLanguageCode(), darkstoresRepo.globalEntityId);
    }

    /* access modifiers changed from: private */
    /* renamed from: getBanners$lambda-4  reason: not valid java name */
    public static final BannersResponse m9663getBanners$lambda4(BannersResponse bannersResponse) {
        Intrinsics.checkNotNullParameter(bannersResponse, "response");
        return new BannersResponse(CollectionsKt___CollectionsKt.sortedWith(bannersResponse.getHeroBanners(), new DarkstoresRepo$getBanners$lambda4$$inlined$sortedBy$1()), CollectionsKt___CollectionsKt.sortedWith(bannersResponse.getBanners(), new DarkstoresRepo$getBanners$lambda4$$inlined$sortedBy$2()));
    }

    /* access modifiers changed from: private */
    /* renamed from: getCampaignForProduct$lambda-11  reason: not valid java name */
    public static final SingleSource m9664getCampaignForProduct$lambda11(DarkstoresRepo darkstoresRepo, String str, Vendor vendor) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(str, "$productId");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return darkstoresRepo.darkstoresApi.getCampaigns(str, "", vendor.getVendorId(), darkstoresRepo.configurationParameters.getLanguageCode(), darkstoresRepo.globalEntityId).doOnError(new k(darkstoresRepo, vendor));
    }

    /* access modifiers changed from: private */
    /* renamed from: getCampaignForProduct$lambda-11$lambda-10  reason: not valid java name */
    public static final void m9665getCampaignForProduct$lambda11$lambda10(DarkstoresRepo darkstoresRepo, Vendor vendor, Throwable th2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "$vendor");
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(darkstoresRepo.talabatFeatureFlag, QCommerceFeatureFlagsKeys.CAMPAIGN_API_OBSERVABILITY, false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            y(darkstoresRepo, th2, vendor.getVendorId(), ObservableNfvApiNames.GET_PRODUCT_CAMPAIGNS, (Set) null, 8, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: getCampaignForProduct$lambda-13  reason: not valid java name */
    public static final MaybeSource m9666getCampaignForProduct$lambda13(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return Maybe.fromCallable(new s(list));
    }

    /* access modifiers changed from: private */
    /* renamed from: getCampaignForProduct$lambda-13$lambda-12  reason: not valid java name */
    public static final ProductCampaign m9667getCampaignForProduct$lambda13$lambda12(List list) {
        Intrinsics.checkNotNullParameter(list, "$it");
        return ProductCampaign.Companion.fromResponse(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: getCart$lambda-23  reason: not valid java name */
    public static final SingleSource m9668getCart$lambda23(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return darkstoresRepo.basketApi.getCart(darkstoresRepo.configurationParameters.getCustomerId(), vendor.getVendorCode(), vendor.getVendorId(), darkstoresRepo.globalEntityId, darkstoresRepo.configurationParameters.getLocation().getLatitude(), darkstoresRepo.configurationParameters.getLocation().getLongitude(), DarkstoresConstantsKt.DELIVERY_TYPE_DEFAULT).doOnError(new b(darkstoresRepo, vendor)).map(darkstoresRepo.cartResponseMapper);
    }

    /* access modifiers changed from: private */
    /* renamed from: getCart$lambda-23$lambda-22  reason: not valid java name */
    public static final void m9669getCart$lambda23$lambda22(DarkstoresRepo darkstoresRepo, Vendor vendor, Throwable th2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "$vendor");
        Intrinsics.checkNotNullExpressionValue(th2, "e");
        darkstoresRepo.trackObservability(th2, vendor.getVendorId(), ObservableNfvApiNames.GET_CART, SetsKt__SetsJVMKt.setOf(404));
    }

    /* access modifiers changed from: private */
    /* renamed from: getCustomerVouchers$lambda-6  reason: not valid java name */
    public static final SingleSource m9670getCustomerVouchers$lambda6(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        LoadCustomerVouchersSwimLaneUseCase loadCustomerVouchersSwimLaneUseCase = darkstoresRepo.customerVouchersSwimLaneUseCase;
        String vendorId = vendor.getVendorId();
        String twoLetterCode = darkstoresRepo.configurationLocalRepository.selectedCountry().getTwoLetterCode();
        Integer num = darkstoresRepo.selectedAreaId.get();
        Intrinsics.checkNotNullExpressionValue(num, "selectedAreaId.get()");
        return loadCustomerVouchersSwimLaneUseCase.invoke(new VouchersSwimLaneRequest(vendorId, twoLetterCode, num.intValue(), String.valueOf(darkstoresRepo.configurationParameters.getChainId())));
    }

    private final float getDeliveryFee(PostCartData postCartData, Vendor vendor) {
        return (postCartData.getDeliveryFee() > -1.0f ? 1 : (postCartData.getDeliveryFee() == -1.0f ? 0 : -1)) == 0 ? vendor.getDeliveryFee() : postCartData.getDeliveryFee();
    }

    /* access modifiers changed from: private */
    /* renamed from: getDiscounts$lambda-5  reason: not valid java name */
    public static final SingleSource m9671getDiscounts$lambda5(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "it");
        return darkstoresRepo.darkstoresApi.getDiscounts(vendor.getVendorId(), darkstoresRepo.globalEntityId);
    }

    private final float getMinimumOrderValue(PostCartData postCartData, Vendor vendor) {
        return (postCartData.getMinOrder() > -1.0f ? 1 : (postCartData.getMinOrder() == -1.0f ? 0 : -1)) == 0 ? vendor.getMinimumOrderValue() : postCartData.getMinOrder();
    }

    private final List<CartProduct> getPostCartItems(PostCartData postCartData) {
        Iterable<Product> cartItems = postCartData.getCartItems();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(cartItems, 10));
        for (Product product : cartItems) {
            arrayList.add(new CartProduct(product.getId(), product.getCartCount()));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductBySku$lambda-7  reason: not valid java name */
    public static final SingleSource m9672getProductBySku$lambda7(DarkstoresRepo darkstoresRepo, String str, Vendor vendor) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(str, "$sku");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return darkstoresRepo.productApi.getProductDetailsBySku(vendor.getVendorId(), str, "talabat", darkstoresRepo.configurationParameters.getCountryCode(), darkstoresRepo.configurationParameters.getLanguageCode());
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductBySku$lambda-8  reason: not valid java name */
    public static final Product m9673getProductBySku$lambda8(ProductListingResponse productListingResponse) {
        Intrinsics.checkNotNullParameter(productListingResponse, "it");
        Product product = productListingResponse.getProduct();
        if (product != null) {
            return product;
        }
        throw new IllegalArgumentException("voucher product not found");
    }

    /* access modifiers changed from: private */
    /* renamed from: getProductBySku$lambda-9  reason: not valid java name */
    public static final void m9674getProductBySku$lambda9(Throwable th2) {
        String localizedMessage = th2.getLocalizedMessage();
        LogManager.debug("Voucher product not found " + localizedMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: postCartByCartId$lambda-19  reason: not valid java name */
    public static final SingleSource m9675postCartByCartId$lambda19(DarkstoresRepo darkstoresRepo, PostCartData postCartData, Vendor vendor) {
        DarkstoresRepo darkstoresRepo2 = darkstoresRepo;
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(postCartData, "$postCartData");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        CartRequestByCartId createCartRequest = darkstoresRepo.createCartRequest(postCartData, vendor);
        BasketApi basketApi2 = darkstoresRepo2.basketApi;
        String cartId = darkstoresRepo2.darkstoresCartRepository.getCartId();
        String customerId = darkstoresRepo2.configurationParameters.getCustomerId();
        String code = darkstoresRepo2.configurationLocalRepository.selectedLanguage().getCode();
        double latitude = darkstoresRepo2.configurationParameters.getLocation().getLatitude();
        double longitude = darkstoresRepo2.configurationParameters.getLocation().getLongitude();
        return basketApi2.postCartByCartId(cartId, customerId, code, true, latitude, longitude, vendor.getVendorCode(), DarkstoresConstantsKt.DELIVERY_TYPE_DEFAULT, createCartRequest, postCartData.getEnableBasketBasedDeliveryFee());
    }

    /* access modifiers changed from: private */
    /* renamed from: postCartByVendorId$lambda-21  reason: not valid java name */
    public static final SingleSource m9676postCartByVendorId$lambda21(DarkstoresRepo darkstoresRepo, PostCartData postCartData, Vendor vendor) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(postCartData, "$postCartData");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return darkstoresRepo.basketApi.postCartByVendorId(darkstoresRepo.configurationParameters.getCustomerId(), darkstoresRepo.createCartRequestByVendorId(postCartData, vendor)).doOnError(new u(darkstoresRepo, vendor));
    }

    /* access modifiers changed from: private */
    /* renamed from: postCartByVendorId$lambda-21$lambda-20  reason: not valid java name */
    public static final void m9677postCartByVendorId$lambda21$lambda20(DarkstoresRepo darkstoresRepo, Vendor vendor, Throwable th2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "$vendor");
        Intrinsics.checkNotNullExpressionValue(th2, "e");
        y(darkstoresRepo, th2, vendor.getVendorId(), ObservableNfvApiNames.POST_CART, (Set) null, 8, (Object) null);
    }

    private final void trackObservability(Throwable th2, String str, String str2, Set<Integer> set) {
        this.darkStoreObservabilityTracker.trackUnExpectedScenarios(th2, str, str2, set);
    }

    private final void trackSuccess(Vendor vendor) {
        DarkstoreDetails darkstoreDetails = new DarkstoreDetails(vendor.getVendorId(), vendor.getVendorCode(), vendor.getDeliveryFee(), vendor.getDeliveryTime(), vendor.getMinimumOrderValue());
        if (!this.configurationParameters.isMigrated()) {
            this.tracker.onDarkstoreLoaded(darkstoreDetails, this.configurationParameters.getRestaurantJson());
        }
    }

    /* access modifiers changed from: private */
    public final void trackVendorError(Throwable th2) {
        HttpException httpException;
        int i11;
        HttpException httpException2;
        NfvObservabilityHandler nfvObservabilityHandler = NfvObservabilityHandler.INSTANCE;
        String vendorCode = this.configurationParameters.getVendorCode();
        boolean z11 = th2 instanceof HttpException;
        String str = null;
        if (z11) {
            httpException = (HttpException) th2;
        } else {
            httpException = null;
        }
        if (httpException != null) {
            i11 = httpException.code();
        } else {
            i11 = -1;
        }
        if (z11) {
            httpException2 = (HttpException) th2;
        } else {
            httpException2 = null;
        }
        if (httpException2 != null) {
            str = httpException2.message();
        }
        if (str == null && (str = th2.getMessage()) == null) {
            str = "";
        }
        nfvObservabilityHandler.onDarkstoresVendorNotLoaded("", vendorCode, i11, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: vendorCampaigns$lambda-15  reason: not valid java name */
    public static final SingleSource m9678vendorCampaigns$lambda15(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        return darkstoresRepo.darkstoresApi.getCampaigns("", "", vendor.getVendorId(), darkstoresRepo.configurationParameters.getLanguageCode(), darkstoresRepo.globalEntityId).doOnError(new p(darkstoresRepo, vendor));
    }

    /* access modifiers changed from: private */
    /* renamed from: vendorCampaigns$lambda-15$lambda-14  reason: not valid java name */
    public static final void m9679vendorCampaigns$lambda15$lambda14(DarkstoresRepo darkstoresRepo, Vendor vendor, Throwable th2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        Intrinsics.checkNotNullParameter(vendor, "$vendor");
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(darkstoresRepo.talabatFeatureFlag, QCommerceFeatureFlagsKeys.CAMPAIGN_API_OBSERVABILITY, false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(th2, "error");
            y(darkstoresRepo, th2, vendor.getVendorId(), ObservableNfvApiNames.GET_ALL_CAMPAIGNS, (Set) null, 8, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: vendorSingle$lambda-0  reason: not valid java name */
    public static final void m9680vendorSingle$lambda0(DarkstoresRepo darkstoresRepo, Vendor vendor) {
        Intrinsics.checkNotNullParameter(darkstoresRepo, "this$0");
        darkstoresRepo.darkstoresCartRepository.setSelectedVendor(new CartVendor(vendor.getVendorId(), darkstoresRepo.configurationParameters.getVendorCode(), darkstoresRepo.configurationParameters.getTalabatVendorInfo().getName(), darkstoresRepo.configurationParameters.getRestaurantJson()));
        Intrinsics.checkNotNullExpressionValue(vendor, "vendor");
        darkstoresRepo.trackSuccess(vendor);
    }

    public static /* synthetic */ void y(DarkstoresRepo darkstoresRepo, Throwable th2, String str, String str2, Set set, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            set = SetsKt__SetsKt.emptySet();
        }
        darkstoresRepo.trackObservability(th2, str, str2, set);
    }

    public final void clearVendorCache() {
        this.vendorRepository.clearVendorCache();
    }

    @NotNull
    public final Completable generateVoucher() {
        Completable ignoreElement = this.lookingGlassVoucherApi.generateVoucher(this.configurationParameters.getCountryCode(), this.configurationParameters.getChainId()).subscribeOn(this.ioScheduler).doOnError(new m(this)).ignoreElement();
        Intrinsics.checkNotNullExpressionValue(ignoreElement, "lookingGlassVoucherApi.g…         .ignoreElement()");
        return ignoreElement;
    }

    @NotNull
    public final Single<List<CampaignTrigger>> getAllCampaignsTriggers() {
        Single<R> map = this.vendorSingle.flatMap(new c(this)).map(new d());
        Intrinsics.checkNotNullExpressionValue(map, "vendorSingle\n        .fl…nTriggersMapper.map(it) }");
        return map;
    }

    @NotNull
    public final Single<BannersResponse> getBanners() {
        Single<R> map = this.vendorSingle.flatMap(new n(this)).map(new o());
        Intrinsics.checkNotNullExpressionValue(map, "vendorSingle\n        .fl…}\n            )\n        }");
        return map;
    }

    @NotNull
    public final Maybe<ProductCampaign> getCampaignForProduct(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Maybe<R> flatMapMaybe = this.vendorSingle.flatMap(new i(this, str)).flatMapMaybe(new j());
        Intrinsics.checkNotNullExpressionValue(flatMapMaybe, "vendorSingle\n        .fl…aign.fromResponse(it) } }");
        return flatMapMaybe;
    }

    @NotNull
    public final Single<Cart> getCart() {
        Single<R> flatMap = this.vendorSingle.flatMap(new a(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "vendorSingle.flatMap { v…cartResponseMapper)\n    }");
        return flatMap;
    }

    @NotNull
    public final Single<List<CustomerVoucher>> getCustomerVouchers() {
        Single<R> flatMap = this.vendorSingle.flatMap(new l(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "vendorSingle\n        .fl…)\n            )\n        }");
        return flatMap;
    }

    @NotNull
    public final Single<List<ProductDiscount>> getDiscounts() {
        Single<R> flatMap = this.vendorSingle.flatMap(new r(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "vendorSingle.flatMap { d…ndorId, globalEntityId) }");
        return flatMap;
    }

    @NotNull
    public final Scheduler getIoScheduler() {
        return this.ioScheduler;
    }

    @NotNull
    public final Single<Product> getProductBySku(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sku");
        Single<R> doOnError = this.vendorSingle.flatMap(new f(this, str)).map(new g()).doOnError(new h());
        Intrinsics.checkNotNullExpressionValue(doOnError, "vendorSingle.flatMap { v…lizedMessage}\")\n        }");
        return doOnError;
    }

    @NotNull
    public final Single<Vendor> getVendor() {
        return this.vendorSingle;
    }

    @NotNull
    public final Single<List<Campaign>> getVendorCampaigns() {
        return this.vendorCampaigns;
    }

    @NotNull
    @Deprecated(message = "Use postCartByVendorId")
    public final Single<CartResponse> postCartByCartId(@NotNull PostCartData postCartData) {
        Intrinsics.checkNotNullParameter(postCartData, "postCartData");
        Single<R> flatMap = this.vendorSingle.flatMap(new q(this, postCartData));
        Intrinsics.checkNotNullExpressionValue(flatMap, "vendorSingle.flatMap { v…liveryFee\n        )\n    }");
        return flatMap;
    }

    @NotNull
    public final Single<CartResponse> postCartByVendorId(@NotNull PostCartData postCartData) {
        Intrinsics.checkNotNullParameter(postCartData, "postCartData");
        Single<R> flatMap = this.vendorSingle.flatMap(new e(this, postCartData));
        Intrinsics.checkNotNullExpressionValue(flatMap, "vendorSingle.flatMap { v…OST_CART)\n        }\n    }");
        return flatMap;
    }
}
