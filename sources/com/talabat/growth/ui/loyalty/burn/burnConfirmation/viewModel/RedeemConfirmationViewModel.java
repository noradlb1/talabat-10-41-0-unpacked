package com.talabat.growth.ui.loyalty.burn.burnConfirmation.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.rewards.data.tracking.events.ShopClickedTrackingEvent;
import com.talabat.feature.rewards.domain.RewardsTracker;
import com.talabat.feature.rewards.domain.model.ButtonType;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.SingleLiveEvent;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcommon.views.vouchers.models.OrderNowDirection;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import datamodels.Restaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0002./B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0012\u0010(\u001a\u00020)2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0006\u0010*\u001a\u00020\u001aJ\"\u0010+\u001a\u00020\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u0013J\b\u0010-\u001a\u00020\u001aH\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "rewardsTracker", "Lcom/talabat/feature/rewards/domain/RewardsTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/feature/rewards/domain/RewardsTracker;)V", "burnItemData", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "getBurnItemData", "()Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "setBurnItemData", "(Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;)V", "burnType", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType;", "getBurnType", "()Landroidx/lifecycle/MutableLiveData;", "confirmationDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "getConfirmationDisplayModel", "()Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "setConfirmationDisplayModel", "(Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;)V", "eventOpenMultipleRestaurants", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "", "getEventOpenMultipleRestaurants", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "eventOpenOneRestaurant", "Ldatamodels/Restaurant;", "getEventOpenOneRestaurant", "remainingPoints", "", "getRemainingPoints", "()I", "setRemainingPoints", "(I)V", "burnOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "isOrderNowAvailable", "", "navigateToRestaurants", "setup", "conformationViewModel", "trackPointsSuccessLoaded", "BurnType", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemConfirmationViewModel extends BaseViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private BurnItemDisplayModel burnItemData;
    @NotNull
    private final MutableLiveData<BurnType> burnType = new MutableLiveData<>(BurnType.Other.INSTANCE);
    @Nullable
    private ConfirmationDisplayModel confirmationDisplayModel;
    @NotNull
    private final SingleLiveEvent<Unit> eventOpenMultipleRestaurants = new SingleLiveEvent<>();
    @NotNull
    private final SingleLiveEvent<Restaurant> eventOpenOneRestaurant = new SingleLiveEvent<>();
    private int remainingPoints = IntKt.orZero(IntCompanionObject.INSTANCE);
    @NotNull
    private final RewardsTracker rewardsTracker;
    @NotNull
    private final TalabatTracker talabatTracker;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType;", "", "()V", "Charity", "Other", "Raffle", "Voucher", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Charity;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Raffle;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Other;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class BurnType {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Charity;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType;", "()V", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Charity extends BurnType {
            @NotNull
            public static final Charity INSTANCE = new Charity();

            private Charity() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Other;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType;", "()V", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Other extends BurnType {
            @NotNull
            public static final Other INSTANCE = new Other();

            private Other() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Raffle;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType;", "burnItemData", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "conformationViewModel", "Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "(Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;)V", "getBurnItemData", "()Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "getConformationViewModel", "()Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Raffle extends BurnType {
            @Nullable
            private final BurnItemDisplayModel burnItemData;
            @Nullable
            private final ConfirmationDisplayModel conformationViewModel;

            public Raffle(@Nullable BurnItemDisplayModel burnItemDisplayModel, @Nullable ConfirmationDisplayModel confirmationDisplayModel) {
                super((DefaultConstructorMarker) null);
                this.burnItemData = burnItemDisplayModel;
                this.conformationViewModel = confirmationDisplayModel;
            }

            @Nullable
            public final BurnItemDisplayModel getBurnItemData() {
                return this.burnItemData;
            }

            @Nullable
            public final ConfirmationDisplayModel getConformationViewModel() {
                return this.conformationViewModel;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0011\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType;", "burnItemData", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "(Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;)V", "getBurnItemData", "()Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "LinkRedemption", "Nfp", "Other", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher$Nfp;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher$LinkRedemption;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher$Other;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static abstract class Voucher extends BurnType {
            @Nullable
            private final BurnItemDisplayModel burnItemData;

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher$LinkRedemption;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher;", "burnItemData", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "(Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;)V", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final class LinkRedemption extends Voucher {
                public LinkRedemption(@Nullable BurnItemDisplayModel burnItemDisplayModel) {
                    super(burnItemDisplayModel, (DefaultConstructorMarker) null);
                }
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher$Nfp;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher;", "burnItemData", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "confirmationDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "(Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;)V", "getConfirmationDisplayModel", "()Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final class Nfp extends Voucher {
                @Nullable
                private final ConfirmationDisplayModel confirmationDisplayModel;

                public Nfp(@Nullable BurnItemDisplayModel burnItemDisplayModel, @Nullable ConfirmationDisplayModel confirmationDisplayModel2) {
                    super(burnItemDisplayModel, (DefaultConstructorMarker) null);
                    this.confirmationDisplayModel = confirmationDisplayModel2;
                }

                @Nullable
                public final ConfirmationDisplayModel getConfirmationDisplayModel() {
                    return this.confirmationDisplayModel;
                }
            }

            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher$Other;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher;", "burnItemData", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "(Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;)V", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final class Other extends Voucher {
                public Other(@Nullable BurnItemDisplayModel burnItemDisplayModel) {
                    super(burnItemDisplayModel, (DefaultConstructorMarker) null);
                }
            }

            private Voucher(BurnItemDisplayModel burnItemDisplayModel) {
                super((DefaultConstructorMarker) null);
                this.burnItemData = burnItemDisplayModel;
            }

            public /* synthetic */ Voucher(BurnItemDisplayModel burnItemDisplayModel, DefaultConstructorMarker defaultConstructorMarker) {
                this(burnItemDisplayModel);
            }

            @Nullable
            public final BurnItemDisplayModel getBurnItemData() {
                return this.burnItemData;
            }
        }

        private BurnType() {
        }

        public /* synthetic */ BurnType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$Companion;", "", "()V", "getInstance", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "rewardsTracker", "Lcom/talabat/feature/rewards/domain/RewardsTracker;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RedeemConfirmationViewModel getInstance(@NotNull TalabatTracker talabatTracker, @NotNull RewardsTracker rewardsTracker) {
            Intrinsics.checkNotNullParameter(talabatTracker, "talabatTracker");
            Intrinsics.checkNotNullParameter(rewardsTracker, "rewardsTracker");
            return new RedeemConfirmationViewModel(talabatTracker, rewardsTracker);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoyaltyBurnOptionType.values().length];
            iArr[LoyaltyBurnOptionType.CHARITY.ordinal()] = 1;
            iArr[LoyaltyBurnOptionType.VOUCHER.ordinal()] = 2;
            iArr[LoyaltyBurnOptionType.RAFFLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RedeemConfirmationViewModel(@NotNull TalabatTracker talabatTracker2, @NotNull RewardsTracker rewardsTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(rewardsTracker2, "rewardsTracker");
        this.talabatTracker = talabatTracker2;
        this.rewardsTracker = rewardsTracker2;
    }

    private final boolean isOrderNowAvailable(ConfirmationDisplayModel confirmationDisplayModel2) {
        OrderNowDirection orderNowDirection;
        if (confirmationDisplayModel2 != null) {
            orderNowDirection = confirmationDisplayModel2.getOrderNowDirection();
        } else {
            orderNowDirection = null;
        }
        boolean z11 = true;
        if (!Intrinsics.areEqual((Object) orderNowDirection, (Object) OrderNowDirection.MultipleRestaurants.INSTANCE) && !(orderNowDirection instanceof OrderNowDirection.OneRestaurant)) {
            z11 = false;
            if (!Intrinsics.areEqual((Object) orderNowDirection, (Object) OrderNowDirection.Undefined.INSTANCE) && orderNowDirection != null) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return z11;
    }

    private final void trackPointsSuccessLoaded() {
        ButtonType buttonType;
        String str;
        if (this.burnType.getValue() instanceof BurnType.Voucher.LinkRedemption) {
            buttonType = ButtonType.ORDER_NOW;
        } else {
            buttonType = ButtonType.NONE;
        }
        ConfirmationDisplayModel confirmationDisplayModel2 = this.confirmationDisplayModel;
        if (confirmationDisplayModel2 != null) {
            str = confirmationDisplayModel2.getCustomerVoucherId();
        } else {
            str = null;
        }
        this.rewardsTracker.onPointsSuccessLoaded(str, buttonType);
    }

    @Nullable
    public final BurnItemDisplayModel getBurnItemData() {
        return this.burnItemData;
    }

    @NotNull
    public final MutableLiveData<BurnType> getBurnType() {
        return this.burnType;
    }

    @Nullable
    public final ConfirmationDisplayModel getConfirmationDisplayModel() {
        return this.confirmationDisplayModel;
    }

    @NotNull
    public final SingleLiveEvent<Unit> getEventOpenMultipleRestaurants() {
        return this.eventOpenMultipleRestaurants;
    }

    @NotNull
    public final SingleLiveEvent<Restaurant> getEventOpenOneRestaurant() {
        return this.eventOpenOneRestaurant;
    }

    public final int getRemainingPoints() {
        return this.remainingPoints;
    }

    public final void navigateToRestaurants() {
        OrderNowDirection orderNowDirection;
        ShopClickedTrackingEvent shopClickedTrackingEvent;
        String str;
        String str2;
        ConfirmationDisplayModel confirmationDisplayModel2 = this.confirmationDisplayModel;
        String str3 = null;
        if (confirmationDisplayModel2 != null) {
            orderNowDirection = confirmationDisplayModel2.getOrderNowDirection();
        } else {
            orderNowDirection = null;
        }
        if (orderNowDirection instanceof OrderNowDirection.OneRestaurant) {
            OrderNowDirection.OneRestaurant oneRestaurant = (OrderNowDirection.OneRestaurant) orderNowDirection;
            this.eventOpenOneRestaurant.setValue(oneRestaurant.getRestaurant());
            ConfirmationDisplayModel confirmationDisplayModel3 = this.confirmationDisplayModel;
            if (confirmationDisplayModel3 != null) {
                str3 = confirmationDisplayModel3.getCustomerVoucherId();
            }
            if (str3 == null) {
                str2 = "";
            } else {
                str2 = str3;
            }
            shopClickedTrackingEvent = new ShopClickedTrackingEvent(str2, oneRestaurant.getRestaurant(), (List) null, (TalabatGTM.Companion) null, 12, (DefaultConstructorMarker) null);
        } else if (Intrinsics.areEqual((Object) orderNowDirection, (Object) OrderNowDirection.MultipleRestaurants.INSTANCE)) {
            this.eventOpenMultipleRestaurants.call();
            ConfirmationDisplayModel confirmationDisplayModel4 = this.confirmationDisplayModel;
            if (confirmationDisplayModel4 != null) {
                str3 = confirmationDisplayModel4.getCustomerVoucherId();
            }
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            shopClickedTrackingEvent = new ShopClickedTrackingEvent(str, (Restaurant) null, (List) null, (TalabatGTM.Companion) null, 14, (DefaultConstructorMarker) null);
        } else if (!Intrinsics.areEqual((Object) orderNowDirection, (Object) OrderNowDirection.Undefined.INSTANCE) && orderNowDirection != null) {
            throw new NoWhenBranchMatchedException();
        } else {
            return;
        }
        this.talabatTracker.track(shopClickedTrackingEvent);
    }

    public final void setBurnItemData(@Nullable BurnItemDisplayModel burnItemDisplayModel) {
        this.burnItemData = burnItemDisplayModel;
    }

    public final void setConfirmationDisplayModel(@Nullable ConfirmationDisplayModel confirmationDisplayModel2) {
        this.confirmationDisplayModel = confirmationDisplayModel2;
    }

    public final void setRemainingPoints(int i11) {
        this.remainingPoints = i11;
    }

    public final void setup(@Nullable BurnItemDisplayModel burnItemDisplayModel, int i11, @Nullable ConfirmationDisplayModel confirmationDisplayModel2) {
        LoyaltyBurnOptionType loyaltyBurnOptionType;
        this.burnItemData = burnItemDisplayModel;
        this.remainingPoints = i11;
        this.confirmationDisplayModel = confirmationDisplayModel2;
        MutableLiveData<BurnType> mutableLiveData = this.burnType;
        if (burnItemDisplayModel != null) {
            loyaltyBurnOptionType = burnItemDisplayModel.getBurnOptionType();
        } else {
            loyaltyBurnOptionType = null;
        }
        mutableLiveData.setValue(getBurnType(loyaltyBurnOptionType));
        trackPointsSuccessLoaded();
    }

    private final BurnType getBurnType(LoyaltyBurnOptionType loyaltyBurnOptionType) {
        int i11 = loyaltyBurnOptionType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[loyaltyBurnOptionType.ordinal()];
        if (i11 == 1) {
            return BurnType.Charity.INSTANCE;
        }
        if (i11 == 2) {
            BurnItemDisplayModel burnItemDisplayModel = this.burnItemData;
            if ((burnItemDisplayModel != null ? burnItemDisplayModel.getVoucherOptionType() : null) == VoucherOptionType.NFP) {
                return new BurnType.Voucher.Nfp(this.burnItemData, this.confirmationDisplayModel);
            }
            if (isOrderNowAvailable(this.confirmationDisplayModel)) {
                return new BurnType.Voucher.LinkRedemption(this.burnItemData);
            }
            return new BurnType.Voucher.Other(this.burnItemData);
        } else if (i11 != 3) {
            return BurnType.Other.INSTANCE;
        } else {
            return new BurnType.Raffle(this.burnItemData, this.confirmationDisplayModel);
        }
    }
}
