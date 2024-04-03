package com.talabat.growth.features.loyalty;

import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragment;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0016\u0017\u0018B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J%\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget;", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetails;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "talabatRemoteConfiguration", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;)V", "navigate", "shouldShowBottomSheet", "", "burnOptionDetails", "run", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "params", "(Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "burnItemDisplayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "BurnOptionDetails", "BurnOptionDetailsTarget", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionDetailsNavigator extends UseCase<BurnOptionDetailsTarget, BurnOptionDetails> {
    @NotNull
    @Deprecated
    public static final String BURN_OPTION_TYPE = "burnOptionType";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String VOUCHER_OPTION_TYPE = "voucherOptionType";
    @NotNull
    private final RemoteConfiguration talabatRemoteConfiguration;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetails;", "", "totalPoints", "", "burnItemDisplayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "position", "Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsFragment$VoucherPosition;", "(ILcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsFragment$VoucherPosition;)V", "getBurnItemDisplayModel", "()Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "getPosition", "()Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsFragment$VoucherPosition;", "getTotalPoints", "()I", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BurnOptionDetails {
        @NotNull
        private final BurnItemDisplayModel burnItemDisplayModel;
        @NotNull
        private final BurnOptionsDetailsFragment.VoucherPosition position;
        private final int totalPoints;

        public BurnOptionDetails(int i11, @NotNull BurnItemDisplayModel burnItemDisplayModel2, @NotNull BurnOptionsDetailsFragment.VoucherPosition voucherPosition) {
            Intrinsics.checkNotNullParameter(burnItemDisplayModel2, "burnItemDisplayModel");
            Intrinsics.checkNotNullParameter(voucherPosition, "position");
            this.totalPoints = i11;
            this.burnItemDisplayModel = burnItemDisplayModel2;
            this.position = voucherPosition;
        }

        @NotNull
        public final BurnItemDisplayModel getBurnItemDisplayModel() {
            return this.burnItemDisplayModel;
        }

        @NotNull
        public final BurnOptionsDetailsFragment.VoucherPosition getPosition() {
            return this.position;
        }

        public final int getTotalPoints() {
            return this.totalPoints;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget;", "", "()V", "BottomSheet", "View", "WarningNotEnoughPoints", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget$View;", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget$BottomSheet;", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget$WarningNotEnoughPoints;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class BurnOptionDetailsTarget {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget$BottomSheet;", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget;", "details", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetails;", "(Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetails;)V", "getDetails", "()Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetails;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class BottomSheet extends BurnOptionDetailsTarget {
            @NotNull
            private final BurnOptionDetails details;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public BottomSheet(@NotNull BurnOptionDetails burnOptionDetails) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(burnOptionDetails, "details");
                this.details = burnOptionDetails;
            }

            @NotNull
            public final BurnOptionDetails getDetails() {
                return this.details;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget$View;", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget;", "details", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetails;", "(Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetails;)V", "getDetails", "()Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetails;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class View extends BurnOptionDetailsTarget {
            @NotNull
            private final BurnOptionDetails details;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public View(@NotNull BurnOptionDetails burnOptionDetails) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(burnOptionDetails, "details");
                this.details = burnOptionDetails;
            }

            @NotNull
            public final BurnOptionDetails getDetails() {
                return this.details;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget$WarningNotEnoughPoints;", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget;", "points", "", "(I)V", "getPoints", "()I", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class WarningNotEnoughPoints extends BurnOptionDetailsTarget {
            private final int points;

            public WarningNotEnoughPoints(int i11) {
                super((DefaultConstructorMarker) null);
                this.points = i11;
            }

            public final int getPoints() {
                return this.points;
            }
        }

        private BurnOptionDetailsTarget() {
        }

        public /* synthetic */ BurnOptionDetailsTarget(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$Companion;", "", "()V", "BURN_OPTION_TYPE", "", "VOUCHER_OPTION_TYPE", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BurnOptionDetailsNavigator(CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, RemoteConfiguration remoteConfiguration, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, coroutineDispatcher, (i11 & 4) != 0 ? RemoteConfiguration.INSTANCE : remoteConfiguration);
    }

    private final BurnOptionDetailsTarget navigate(boolean z11, BurnOptionDetails burnOptionDetails) {
        BurnOptionDetailsTarget burnOptionDetailsTarget;
        if (z11) {
            int pointsCost = burnOptionDetails.getBurnItemDisplayModel().getPointsCost();
            if (pointsCost > burnOptionDetails.getTotalPoints()) {
                return new BurnOptionDetailsTarget.WarningNotEnoughPoints(pointsCost - burnOptionDetails.getTotalPoints());
            }
            burnOptionDetailsTarget = new BurnOptionDetailsTarget.BottomSheet(burnOptionDetails);
        } else {
            burnOptionDetailsTarget = new BurnOptionDetailsTarget.View(burnOptionDetails);
        }
        return burnOptionDetailsTarget;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean shouldShowBottomSheet(com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel r9) {
        /*
            r8 = this;
            com.talabat.talabatremoteconfiguration.RemoteConfiguration r0 = r8.talabatRemoteConfiguration
            com.talabat.talabatremoteconfiguration.keys.RewardsRemoteConfiguration r1 = com.talabat.talabatremoteconfiguration.keys.RewardsRemoteConfiguration.REWARDS_REDEMPTION_FLOW_BOTTOM_SHEET
            java.util.Map r2 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.Class r3 = r3.getClass()
            java.lang.Object r0 = r0.getRemoteConfiguration(r1, r2, r3)
            java.util.Map r0 = (java.util.Map) r0
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType r1 = r9.getBurnOptionType()
            java.lang.String r1 = r1.getStringValue()
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r2)
            java.lang.String r2 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r3 = "burnOptionType"
            java.lang.Object r3 = r0.get(r3)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            r4 = 0
            if (r3 == 0) goto L_0x005a
            java.util.Iterator r3 = r3.iterator()
        L_0x0039:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0056
            java.lang.Object r5 = r3.next()
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r6 = r6.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r6 == 0) goto L_0x0039
            goto L_0x0057
        L_0x0056:
            r5 = r4
        L_0x0057:
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x005b
        L_0x005a:
            r5 = r4
        L_0x005b:
            r3 = 1
            r6 = 0
            if (r5 == 0) goto L_0x0061
            r5 = r3
            goto L_0x0062
        L_0x0061:
            r5 = r6
        L_0x0062:
            if (r5 != 0) goto L_0x0065
            return r6
        L_0x0065:
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType r5 = com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType.VOUCHER
            java.lang.String r5 = r5.getStringValue()
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            if (r1 == 0) goto L_0x00bb
            com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType r9 = r9.getVoucherOptionType()
            java.lang.String r9 = r9.name()
            java.lang.String r9 = r9.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            java.lang.String r1 = "voucherOptionType"
            java.lang.Object r0 = r0.get(r1)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 == 0) goto L_0x00b7
            java.util.Iterator r0 = r0.iterator()
        L_0x0098:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00b5
            java.lang.Object r1 = r0.next()
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r9)
            if (r5 == 0) goto L_0x0098
            r4 = r1
        L_0x00b5:
            java.lang.String r4 = (java.lang.String) r4
        L_0x00b7:
            if (r4 == 0) goto L_0x00ba
            goto L_0x00bb
        L_0x00ba:
            r3 = r6
        L_0x00bb:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator.shouldShowBottomSheet(com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel):boolean");
    }

    @Nullable
    public Object run(@NotNull BurnOptionDetails burnOptionDetails, @NotNull Continuation<? super Either<? extends Failure, ? extends BurnOptionDetailsTarget>> continuation) {
        return new Either.Right(navigate(shouldShowBottomSheet(burnOptionDetails.getBurnItemDisplayModel()), burnOptionDetails));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BurnOptionDetailsNavigator(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull RemoteConfiguration remoteConfiguration) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(remoteConfiguration, "talabatRemoteConfiguration");
        this.talabatRemoteConfiguration = remoteConfiguration;
    }
}
