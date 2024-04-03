package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import android.content.Context;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetMyPossibleVouchersUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetPossibleBinRestrictedVoucherUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsBasketVouchersFeatureEnabledUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsTmartVouchersFeatureEnabledUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsVoucherCodesFeatureEnabledUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.UnApplyAllVoucherUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.MarketPlaceRedeemBurnOptionService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.MarketPlaceRedeemBurnOptionRepositoryImpl;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcommon.feature.vouchers.monolith.GetMenuItemDetailsUseCase;
import com.talabat.talabatcommon.feature.vouchers.monolith.network.GroceryService;
import com.talabat.talabatcommon.feature.vouchers.monolith.network.MonolithService;
import com.talabat.talabatcommon.feature.vouchers.monolith.repository.MenuRepositoryImpl;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import library.talabat.mvp.login.data.repository.impl.CustomerRepositoryImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u001e"}, d2 = {"getAddVoucherCodeUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/AddVoucherCodeUseCase;", "context", "Landroid/content/Context;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getApplyVoucherUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/ApplyVoucherUseCaseOutput;", "getIsBasketVouchersEnabled", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/IsBasketVouchersFeatureEnabledUseCase;", "getIsVoucherCodesEnabled", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/IsVoucherCodesFeatureEnabledUseCase;", "getIsVouchersEnabledInTmartUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/IsTmartVouchersFeatureEnabledUseCase;", "getPossibleBinRestrictedVoucherUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GetPossibleBinRestrictedVoucherUseCase;", "getPossibleVouchersUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GetMyPossibleVouchersUseCase;", "getRedeemVoucherCodeUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherCodeUseCase;", "getRedeemVoucherUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getUnApplyAllVoucherUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/UnApplyAllVoucherUseCase;", "getVoucherMenuItemUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/GetMenuItemDetailsUseCase;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ApplyVoucherViewModelBuilderKt {
    /* access modifiers changed from: private */
    public static final AddVoucherCodeUseCase getAddVoucherCodeUseCase(Context context, TalabatTracker talabatTracker, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new AddVoucherCodeUseCase(getRedeemVoucherCodeUseCase(context, talabatTracker, iTalabatFeatureFlag), getApplyVoucherUseCase(context, iTalabatFeatureFlag));
    }

    /* access modifiers changed from: private */
    public static final ApplyVoucherUseCaseOutput getApplyVoucherUseCase(Context context, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new ApplyVoucherUseCaseOutput(new VoucherRepositoryImpl(new NetworkHandler(context), new VouchersService(new TalabatAPIBuilder())), getVoucherMenuItemUseCase(context), (GrowthTracker) null, iTalabatFeatureFlag, 4, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final IsBasketVouchersFeatureEnabledUseCase getIsBasketVouchersEnabled(Context context, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new IsBasketVouchersFeatureEnabledUseCase(Dispatchers.getIO(), iTalabatFeatureFlag, new CustomerRepositoryImpl(context, (Customer) null, (Function1) null, 6, (DefaultConstructorMarker) null), ApplyVoucherViewModelBuilderKt$getIsBasketVouchersEnabled$1.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final IsVoucherCodesFeatureEnabledUseCase getIsVoucherCodesEnabled(Context context, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new IsVoucherCodesFeatureEnabledUseCase(Dispatchers.getIO(), iTalabatFeatureFlag, new CustomerRepositoryImpl(context, (Customer) null, (Function1) null, 6, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public static final IsTmartVouchersFeatureEnabledUseCase getIsVouchersEnabledInTmartUseCase(Context context, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new IsTmartVouchersFeatureEnabledUseCase(Dispatchers.getIO(), iTalabatFeatureFlag, new CustomerRepositoryImpl(context, (Customer) null, (Function1) null, 6, (DefaultConstructorMarker) null), ApplyVoucherViewModelBuilderKt$getIsVouchersEnabledInTmartUseCase$1.INSTANCE, new ApplyVoucherViewModelBuilderKt$getIsVouchersEnabledInTmartUseCase$2(iTalabatFeatureFlag));
    }

    /* access modifiers changed from: private */
    public static final GetPossibleBinRestrictedVoucherUseCase getPossibleBinRestrictedVoucherUseCase(Context context, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new GetPossibleBinRestrictedVoucherUseCase(new VoucherRepositoryImpl(new NetworkHandler(context), new VouchersService(new TalabatAPIBuilder())), iTalabatFeatureFlag);
    }

    /* access modifiers changed from: private */
    public static final GetMyPossibleVouchersUseCase getPossibleVouchersUseCase(Context context, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return new GetMyPossibleVouchersUseCase(Dispatchers.getIO(), new CustomerRepositoryImpl(context, (Customer) null, (Function1) null, 6, (DefaultConstructorMarker) null), new VoucherRepositoryImpl(new NetworkHandler(context), new VouchersService(new TalabatAPIBuilder())), iTalabatFeatureFlag, ApplyVoucherViewModelBuilderKt$getPossibleVouchersUseCase$1.INSTANCE);
    }

    @NotNull
    public static final RedeemVoucherCodeUseCase getRedeemVoucherCodeUseCase(@NotNull Context context, @NotNull TalabatTracker talabatTracker, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(talabatTracker, "talabatTracker");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        return new RedeemVoucherCodeUseCase(new VoucherRepositoryImpl(new NetworkHandler(context), new VouchersService(new TalabatAPIBuilder())), GrowthTracker.INSTANCE.setTalabatTracker(talabatTracker), iTalabatFeatureFlag);
    }

    /* access modifiers changed from: private */
    public static final RedeemVoucherUseCase getRedeemVoucherUseCase(Context context, TalabatTracker talabatTracker, ConfigurationLocalRepository configurationLocalRepository) {
        return new RedeemVoucherUseCase(Dispatchers.getIO(), new MarketPlaceRedeemBurnOptionRepositoryImpl(new NetworkHandler(context), new MarketPlaceRedeemBurnOptionService(new TalabatAPIBuilder()), configurationLocalRepository), talabatTracker);
    }

    /* access modifiers changed from: private */
    public static final UnApplyAllVoucherUseCase getUnApplyAllVoucherUseCase(Context context) {
        return new UnApplyAllVoucherUseCase(Dispatchers.getIO(), new VoucherRepositoryImpl(new NetworkHandler(context), new VouchersService(new TalabatAPIBuilder())));
    }

    private static final GetMenuItemDetailsUseCase getVoucherMenuItemUseCase(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            return new GetMenuItemDetailsUseCase(new MenuRepositoryImpl(((ConfigurationLocalCoreLibApi) ((ApiContainer) applicationContext).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository(), new NetworkHandler(context), new MonolithService(new TalabatAPIBuilder()), new GroceryService(new TalabatAPIBuilder())));
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }
}
