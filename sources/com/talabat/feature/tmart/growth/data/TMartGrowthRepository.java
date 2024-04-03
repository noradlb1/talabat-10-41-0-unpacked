package com.talabat.feature.tmart.growth.data;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.feature.tmart.growth.data.remote.TMartGrowthApi;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimConfirmation;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthLoaderData;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u00010B)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\"\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0011\u0010%\u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0019\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0017H\u0016J\u001d\u0010*\u001a\u00020\u00172\u0006\u0010'\u001a\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\u00020!*\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010/R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000fR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001fX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository;", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthRepository;", "countryCode", "", "growthApi", "Lcom/talabat/feature/tmart/growth/data/remote/TMartGrowthApi;", "globalDataModel", "Lcom/integration/IntegrationGlobalDataModel$Companion;", "dispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Ljava/lang/String;Lcom/talabat/feature/tmart/growth/data/remote/TMartGrowthApi;Lcom/integration/IntegrationGlobalDataModel$Companion;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "claimInfo", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimInfo;", "getClaimInfo", "()Lkotlinx/coroutines/flow/Flow;", "combinedTrigger", "Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType;", "loaderData", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthLoaderData;", "getLoaderData", "refreshVoucherTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "requestTrigger", "scope", "Lkotlinx/coroutines/CoroutineScope;", "trackingData", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "getTrackingData", "voucherResponse", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlin/Result;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse;", "claimVoucher", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimConfirmation;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBasicVoucher", "getVoucher", "voucherId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshVoucher", "triggerGettingVoucher", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthVoucherId;", "triggerGettingVoucher-99KcVpk", "(Ljava/lang/String;)V", "createRequest", "(Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RequestType", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthRepository implements ITMartGrowthRepository {
    @NotNull
    private final Flow<TMartGrowthClaimInfo> claimInfo;
    @NotNull
    private final Flow<RequestType> combinedTrigger;
    /* access modifiers changed from: private */
    @NotNull
    public final String countryCode;
    @NotNull
    private final IntegrationGlobalDataModel.Companion globalDataModel;
    /* access modifiers changed from: private */
    @NotNull
    public final TMartGrowthApi growthApi;
    @NotNull
    private final Flow<TMartGrowthLoaderData> loaderData;
    @NotNull
    private final MutableSharedFlow<Unit> refreshVoucherTrigger;
    @NotNull
    private final MutableSharedFlow<RequestType> requestTrigger;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final Flow<TMartGrowthTrackingInfo> trackingData;
    @NotNull
    private final SharedFlow<Result<TMartGrowthVoucherResponse>> voucherResponse;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType;", "", "()V", "GrowthWidget", "None", "ReminderWidget", "Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType$GrowthWidget;", "Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType$ReminderWidget;", "Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType$None;", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class RequestType {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType$GrowthWidget;", "Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType;", "voucherId", "", "(Ljava/lang/String;)V", "getVoucherId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class GrowthWidget extends RequestType {
            @NotNull
            private final String voucherId;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GrowthWidget(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
                this.voucherId = str;
            }

            public static /* synthetic */ GrowthWidget copy$default(GrowthWidget growthWidget, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = growthWidget.voucherId;
                }
                return growthWidget.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.voucherId;
            }

            @NotNull
            public final GrowthWidget copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
                return new GrowthWidget(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof GrowthWidget) && Intrinsics.areEqual((Object) this.voucherId, (Object) ((GrowthWidget) obj).voucherId);
            }

            @NotNull
            public final String getVoucherId() {
                return this.voucherId;
            }

            public int hashCode() {
                return this.voucherId.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.voucherId;
                return "GrowthWidget(voucherId=" + str + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType$None;", "Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType;", "()V", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class None extends RequestType {
            @NotNull
            public static final None INSTANCE = new None();

            private None() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType$ReminderWidget;", "Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType;", "()V", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class ReminderWidget extends RequestType {
            @NotNull
            public static final ReminderWidget INSTANCE = new ReminderWidget();

            private ReminderWidget() {
                super((DefaultConstructorMarker) null);
            }
        }

        private RequestType() {
        }

        public /* synthetic */ RequestType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public TMartGrowthRepository(@NotNull @Named("countryCode") String str, @NotNull TMartGrowthApi tMartGrowthApi, @NotNull IntegrationGlobalDataModel.Companion companion, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Intrinsics.checkNotNullParameter(tMartGrowthApi, "growthApi");
        Intrinsics.checkNotNullParameter(companion, "globalDataModel");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "dispatchersFactory");
        this.countryCode = str;
        this.growthApi = tMartGrowthApi;
        this.globalDataModel = companion;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatchersFactory.io());
        this.scope = CoroutineScope;
        MutableSharedFlow<Unit> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 1, (BufferOverflow) null, 4, (Object) null);
        this.refreshVoucherTrigger = MutableSharedFlow$default;
        MutableSharedFlow<RequestType> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(1, 1, (BufferOverflow) null, 4, (Object) null);
        this.requestTrigger = MutableSharedFlow$default2;
        Flow<RequestType> combine = FlowKt.combine(MutableSharedFlow$default2, FlowKt.onStart(MutableSharedFlow$default, new TMartGrowthRepository$combinedTrigger$1((Continuation<? super TMartGrowthRepository$combinedTrigger$1>) null)), new TMartGrowthRepository$combinedTrigger$2((Continuation<? super TMartGrowthRepository$combinedTrigger$2>) null));
        this.combinedTrigger = combine;
        SharedFlow<Result<TMartGrowthVoucherResponse>> shareIn = FlowKt.shareIn(FlowKt.transformLatest(combine, new TMartGrowthRepository$special$$inlined$flatMapLatest$1((Continuation) null, this)), CoroutineScope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, (Object) null), 1);
        this.voucherResponse = shareIn;
        this.claimInfo = FlowKt.merge((Flow<? extends T>[]) new Flow[]{new TMartGrowthRepository$special$$inlined$map$1(MutableSharedFlow$default), new TMartGrowthRepository$special$$inlined$map$2(shareIn)});
        this.loaderData = new TMartGrowthRepository$special$$inlined$map$3(shareIn);
        this.trackingData = FlowKt.combine(shareIn, MutableSharedFlow$default2, new TMartGrowthRepository$trackingData$1((Continuation<? super TMartGrowthRepository$trackingData$1>) null));
    }

    /* access modifiers changed from: private */
    public final Object createRequest(RequestType requestType, Continuation<? super TMartGrowthVoucherResponse> continuation) {
        if (requestType instanceof RequestType.GrowthWidget) {
            return getVoucher(((RequestType.GrowthWidget) requestType).getVoucherId(), continuation);
        }
        if (requestType instanceof RequestType.ReminderWidget) {
            return getBasicVoucher(continuation);
        }
        if (requestType instanceof RequestType.None) {
            throw new IllegalArgumentException("VoucherId cannot be empty!");
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public final Object getBasicVoucher(Continuation<? super TMartGrowthVoucherResponse> continuation) {
        return this.growthApi.getBasicWidgetData(this.countryCode, this.globalDataModel.getSelectedAreaId(), this.globalDataModel.selectedLocationLatitude(), this.globalDataModel.selectedLocationLongitude(), continuation);
    }

    /* access modifiers changed from: private */
    public final Object getVoucher(String str, Continuation<? super TMartGrowthVoucherResponse> continuation) {
        return this.growthApi.getWidgetData(this.countryCode, this.globalDataModel.getSelectedAreaId(), this.globalDataModel.selectedLocationLatitude(), this.globalDataModel.selectedLocationLongitude(), str, continuation);
    }

    @Nullable
    public Object claimVoucher(@NotNull Continuation<? super TMartGrowthClaimConfirmation> continuation) {
        return FlowKt.first(FlowKt.mapLatest(new TMartGrowthRepository$claimVoucher$$inlined$filterIsInstance$1(this.requestTrigger), new TMartGrowthRepository$claimVoucher$2(this, (Continuation<? super TMartGrowthRepository$claimVoucher$2>) null)), continuation);
    }

    @NotNull
    public Flow<TMartGrowthClaimInfo> getClaimInfo() {
        return this.claimInfo;
    }

    @NotNull
    public Flow<TMartGrowthLoaderData> getLoaderData() {
        return this.loaderData;
    }

    @NotNull
    public Flow<TMartGrowthTrackingInfo> getTrackingData() {
        return this.trackingData;
    }

    public void refreshVoucher() {
        this.refreshVoucherTrigger.tryEmit(Unit.INSTANCE);
    }

    /* renamed from: triggerGettingVoucher-99KcVpk  reason: not valid java name */
    public void m10296triggerGettingVoucher99KcVpk(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        this.requestTrigger.tryEmit(RequestType.ReminderWidget.INSTANCE);
    }
}
