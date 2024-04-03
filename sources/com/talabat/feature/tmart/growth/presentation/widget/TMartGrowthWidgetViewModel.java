package com.talabat.feature.tmart.growth.presentation.widget;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.feature.tmart.growth.domain.ITMartGrowthReminderRepository;
import com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase;
import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthVoucherId;
import com.talabat.feature.tmart.growth.presentation.widget.WidgetState;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\"B;\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0019\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0012*\b\u0012\u0004\u0012\u00020\u001c0\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthWidgetViewModel;", "Landroidx/lifecycle/ViewModel;", "voucherId", "", "screen", "Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthScreen;", "getWidgetUseCase", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimInfoUseCase;", "reminderRepository", "Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthReminderRepository;", "reminderDisplayMapper", "Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthReminderDisplayMapper;", "trackingUseCase", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimTrackingUseCase;", "(Ljava/lang/String;Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthScreen;Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimInfoUseCase;Lcom/talabat/feature/tmart/growth/domain/ITMartGrowthReminderRepository;Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthReminderDisplayMapper;Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimTrackingUseCase;)V", "screenType", "Lcom/talabat/feature/tmart/growth/domain/TMartGrowthScreenType;", "widgetState", "Lkotlinx/coroutines/flow/Flow;", "Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState;", "getWidgetState", "()Lkotlinx/coroutines/flow/Flow;", "onTMartOpened", "", "onWidgetClaimed", "shouldTrackEvent", "", "previous", "Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;", "new", "trackWidgetLoaded", "widgetDisplayModel", "(Lcom/talabat/feature/tmart/growth/domain/claim/TMartGrowthClaimDisplayModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackEvents", "Factory", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthWidgetViewModel extends ViewModel {
    @NotNull
    private final TMartGrowthScreen screen;
    /* access modifiers changed from: private */
    @NotNull
    public final TMartGrowthScreenType screenType;
    /* access modifiers changed from: private */
    @NotNull
    public final TMartGrowthClaimTrackingUseCase trackingUseCase;
    @NotNull
    private final String voucherId;
    @NotNull
    private final Flow<WidgetState> widgetState;

    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthWidgetViewModel$Factory;", "", "create", "Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthWidgetViewModel;", "widgetTag", "", "screenType", "Lcom/talabat/feature/tmart/growth/presentation/widget/TMartGrowthScreen;", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        TMartGrowthWidgetViewModel create(@NotNull String str, @NotNull TMartGrowthScreen tMartGrowthScreen);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TMartGrowthScreen.values().length];
            iArr[TMartGrowthScreen.HOME.ordinal()] = 1;
            iArr[TMartGrowthScreen.ORDER_CONFIRMATION.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TMartGrowthScreenType.values().length];
            iArr2[TMartGrowthScreenType.HOME.ordinal()] = 1;
            iArr2[TMartGrowthScreenType.ORDER_CONFIRMATION.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @AssistedInject
    public TMartGrowthWidgetViewModel(@NotNull @Assisted String str, @NotNull @Assisted TMartGrowthScreen tMartGrowthScreen, @NotNull TMartGrowthClaimInfoUseCase tMartGrowthClaimInfoUseCase, @NotNull ITMartGrowthReminderRepository iTMartGrowthReminderRepository, @NotNull TMartGrowthReminderDisplayMapper tMartGrowthReminderDisplayMapper, @NotNull TMartGrowthClaimTrackingUseCase tMartGrowthClaimTrackingUseCase) {
        TMartGrowthScreenType tMartGrowthScreenType;
        Flow<TMartGrowthClaimDisplayModel> flow;
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(tMartGrowthScreen, "screen");
        Intrinsics.checkNotNullParameter(tMartGrowthClaimInfoUseCase, "getWidgetUseCase");
        Intrinsics.checkNotNullParameter(iTMartGrowthReminderRepository, "reminderRepository");
        Intrinsics.checkNotNullParameter(tMartGrowthReminderDisplayMapper, "reminderDisplayMapper");
        Intrinsics.checkNotNullParameter(tMartGrowthClaimTrackingUseCase, "trackingUseCase");
        this.voucherId = str;
        this.screen = tMartGrowthScreen;
        this.trackingUseCase = tMartGrowthClaimTrackingUseCase;
        int i11 = WhenMappings.$EnumSwitchMapping$0[tMartGrowthScreen.ordinal()];
        if (i11 == 1) {
            tMartGrowthScreenType = TMartGrowthScreenType.HOME;
        } else if (i11 == 2) {
            tMartGrowthScreenType = TMartGrowthScreenType.ORDER_CONFIRMATION;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.screenType = tMartGrowthScreenType;
        if (tMartGrowthScreenType == TMartGrowthScreenType.HOME) {
            tMartGrowthClaimInfoUseCase.m10321triggerGettingWidget6cUBHk(TMartGrowthVoucherId.m10331constructorimpl(str), tMartGrowthScreenType);
        }
        int i12 = WhenMappings.$EnumSwitchMapping$1[tMartGrowthScreenType.ordinal()];
        if (i12 == 1) {
            flow = trackEvents(tMartGrowthClaimInfoUseCase.getClaimDisplayModel());
        } else if (i12 == 2) {
            flow = FlowKt.onEach(FlowKt.m7822catch(new TMartGrowthWidgetViewModel$special$$inlined$map$1(FlowKt.flow(new TMartGrowthWidgetViewModel$widgetState$1(iTMartGrowthReminderRepository, this, (Continuation<? super TMartGrowthWidgetViewModel$widgetState$1>) null)), tMartGrowthReminderDisplayMapper), new TMartGrowthWidgetViewModel$widgetState$3((Continuation<? super TMartGrowthWidgetViewModel$widgetState$3>) null)), new TMartGrowthWidgetViewModel$widgetState$4(this));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.widgetState = FlowKt.stateIn(FlowKt.m7822catch(new TMartGrowthWidgetViewModel$special$$inlined$map$2(flow), new TMartGrowthWidgetViewModel$widgetState$6((Continuation<? super TMartGrowthWidgetViewModel$widgetState$6>) null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.getLazily(), WidgetState.Loading.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final boolean shouldTrackEvent(TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel, TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel2) {
        boolean z11;
        boolean z12;
        if (!Intrinsics.areEqual((Object) tMartGrowthClaimDisplayModel.getTitle(), (Object) tMartGrowthClaimDisplayModel2.getTitle()) || !Intrinsics.areEqual((Object) tMartGrowthClaimDisplayModel.getSubtitle(), (Object) tMartGrowthClaimDisplayModel2.getSubtitle())) {
            return false;
        }
        if (tMartGrowthClaimDisplayModel2.getTitle().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        if (tMartGrowthClaimDisplayModel2.getSubtitle().length() > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            return true;
        }
        return false;
    }

    private final Flow<TMartGrowthClaimDisplayModel> trackEvents(Flow<? extends TMartGrowthClaimDisplayModel> flow) {
        return FlowKt.runningReduce(flow, new TMartGrowthWidgetViewModel$trackEvents$1(this, (Continuation<? super TMartGrowthWidgetViewModel$trackEvents$1>) null));
    }

    /* access modifiers changed from: private */
    public final Object trackWidgetLoaded(TMartGrowthClaimDisplayModel tMartGrowthClaimDisplayModel, Continuation<? super Unit> continuation) {
        boolean z11;
        if (tMartGrowthClaimDisplayModel instanceof TMartGrowthClaimDisplayModel.Unclaimed) {
            z11 = true;
        } else {
            z11 = tMartGrowthClaimDisplayModel instanceof TMartGrowthClaimDisplayModel.Claimed;
        }
        if (z11) {
            Object trackHomeWidgetShown = this.trackingUseCase.trackHomeWidgetShown(continuation);
            if (trackHomeWidgetShown == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return trackHomeWidgetShown;
            }
            return Unit.INSTANCE;
        }
        if (tMartGrowthClaimDisplayModel instanceof TMartGrowthClaimDisplayModel.Reminder) {
            this.trackingUseCase.trackReminderWidgetShown(tMartGrowthClaimDisplayModel.getTitle());
        } else if (!Intrinsics.areEqual((Object) tMartGrowthClaimDisplayModel, (Object) TMartGrowthClaimDisplayModel.None.INSTANCE)) {
            Intrinsics.areEqual((Object) tMartGrowthClaimDisplayModel, (Object) TMartGrowthClaimDisplayModel.Loading.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final Flow<WidgetState> getWidgetState() {
        return this.widgetState;
    }

    public final void onTMartOpened() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TMartGrowthWidgetViewModel$onTMartOpened$1(this, (Continuation<? super TMartGrowthWidgetViewModel$onTMartOpened$1>) null), 3, (Object) null);
    }

    public final void onWidgetClaimed() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TMartGrowthWidgetViewModel$onWidgetClaimed$1(this, (Continuation<? super TMartGrowthWidgetViewModel$onWidgetClaimed$1>) null), 3, (Object) null);
    }
}
