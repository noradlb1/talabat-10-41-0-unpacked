package com.talabat.growth.features.matketPlace;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.growth.features.matketPlace.data.network.MarketPlaceApi;
import com.talabat.growth.features.matketPlace.data.network.MarketPlaceService;
import com.talabat.growth.features.matketPlace.model.MarketPlaceItemsRequestModel;
import com.talabat.growth.features.matketPlace.model.response.MarketPlaceBurnOptionsResponse;
import com.talabat.growth.ui.loyalty.burn.models.BurnListDisplayModel;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J%\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/talabat/growth/features/matketPlace/GetMarketPlaceItems;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnListDisplayModel;", "Lcom/talabat/growth/features/matketPlace/model/MarketPlaceItemsRequestModel;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "service", "Lcom/talabat/growth/features/matketPlace/data/network/MarketPlaceService;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "talabatRemoteConfiguration", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/growth/features/matketPlace/data/network/MarketPlaceService;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;)V", "getBurnTypes", "", "getVoucherOptionType", "isBurnOptionTypeAllowed", "", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/growth/features/matketPlace/model/MarketPlaceItemsRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetMarketPlaceItems extends UseCase<BurnListDisplayModel, MarketPlaceItemsRequestModel> {
    @NotNull
    @Deprecated
    public static final String BURN_OPTION_TYPE = "burnOptionType";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final MarketPlaceService f60572service;
    @NotNull
    private final RemoteConfiguration talabatRemoteConfiguration;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/growth/features/matketPlace/GetMarketPlaceItems$Companion;", "", "()V", "BURN_OPTION_TYPE", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetMarketPlaceItems(NetworkHandler networkHandler2, MarketPlaceService marketPlaceService, LocationConfigurationRepository locationConfigurationRepository2, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, RemoteConfiguration remoteConfiguration, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(networkHandler2, marketPlaceService, locationConfigurationRepository2, coroutineScope, coroutineDispatcher, (i11 & 32) != 0 ? RemoteConfiguration.INSTANCE : remoteConfiguration);
    }

    private final String getBurnTypes() {
        List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(LoyaltyBurnOptionType.VOUCHER.getStringValue(), LoyaltyBurnOptionType.WALLET.getStringValue(), LoyaltyBurnOptionType.CHARITY.getStringValue());
        if (isBurnOptionTypeAllowed()) {
            mutableListOf.add(LoyaltyBurnOptionType.RAFFLE.getStringValue());
        }
        return CollectionsKt___CollectionsKt.joinToString$default(mutableListOf, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
    }

    private final String getVoucherOptionType() {
        return CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsKt.listOf(VoucherOptionType.LOYALTY.name(), VoucherOptionType.NFP.name(), VoucherOptionType.TPRO.name()), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isBurnOptionTypeAllowed() {
        /*
            r7 = this;
            com.talabat.talabatremoteconfiguration.RemoteConfiguration r0 = r7.talabatRemoteConfiguration
            com.talabat.talabatremoteconfiguration.keys.RewardsRemoteConfiguration r1 = com.talabat.talabatremoteconfiguration.keys.RewardsRemoteConfiguration.REWARDS_REDEMPTION_FLOW_BOTTOM_SHEET
            java.util.Map r2 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.Class r3 = r3.getClass()
            java.lang.Object r0 = r0.getRemoteConfiguration(r1, r2, r3)
            java.util.Map r0 = (java.util.Map) r0
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType r1 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType.RAFFLE
            java.lang.String r1 = r1.getStringValue()
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r2)
            java.lang.String r2 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r3 = "burnOptionType"
            java.lang.Object r0 = r0.get(r3)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            r3 = 0
            if (r0 == 0) goto L_0x0056
            java.util.Iterator r0 = r0.iterator()
        L_0x0037:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0054
            java.lang.Object r4 = r0.next()
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            java.util.Locale r6 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
            if (r5 == 0) goto L_0x0037
            r3 = r4
        L_0x0054:
            java.lang.String r3 = (java.lang.String) r3
        L_0x0056:
            if (r3 == 0) goto L_0x005a
            r0 = 1
            goto L_0x005b
        L_0x005a:
            r0 = 0
        L_0x005b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.features.matketPlace.GetMarketPlaceItems.isBurnOptionTypeAllowed():boolean");
    }

    @Nullable
    public Object run(@NotNull MarketPlaceItemsRequestModel marketPlaceItemsRequestModel, @NotNull Continuation<? super Either<? extends Failure, BurnListDisplayModel>> continuation) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(MarketPlaceApi.DefaultImpls.getItems$default(this.f60572service, 0, marketPlaceItemsRequestModel.getCountry(), marketPlaceItemsRequestModel.getLanguageCode(), marketPlaceItemsRequestModel.getPageNumber(), marketPlaceItemsRequestModel.getPageSize(), getVoucherOptionType(), getBurnTypes(), marketPlaceItemsRequestModel.getAreaId(), 1, (Object) null), new GetMarketPlaceItems$run$2(this), new MarketPlaceBurnOptionsResponse());
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetMarketPlaceItems(@NotNull NetworkHandler networkHandler2, @NotNull MarketPlaceService marketPlaceService, @NotNull LocationConfigurationRepository locationConfigurationRepository2, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull RemoteConfiguration remoteConfiguration) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(marketPlaceService, "service");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(remoteConfiguration, "talabatRemoteConfiguration");
        this.networkHandler = networkHandler2;
        this.f60572service = marketPlaceService;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.talabatRemoteConfiguration = remoteConfiguration;
    }
}
