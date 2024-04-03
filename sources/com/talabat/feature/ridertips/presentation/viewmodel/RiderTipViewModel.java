package com.talabat.feature.ridertips.presentation.viewmodel;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.talabat.feature.ridertips.domain.IRiderTipTracker;
import com.talabat.feature.ridertips.domain.model.RiderTip;
import com.talabat.feature.ridertips.domain.usecases.GetRiderTipUseCase;
import com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase;
import com.talabat.feature.ridertips.presentation.displaymodel.CtaMode;
import com.talabat.feature.ridertips.presentation.displaymodel.CustomTipInputDetailsDisplayModel;
import com.talabat.feature.ridertips.presentation.displaymodel.RiderTipDisplayModel;
import com.talabat.feature.ridertips.presentation.displaymodel.TermsDisplayModel;
import com.talabat.feature.ridertips.presentation.displaymodel.TipOptionDisplayModel;
import com.talabat.feature.ridertips.presentation.displaymodel.TipOptionsDetailsDisplayModel;
import com.talabat.feature.ridertips.presentation.mapper.IRiderTipDisplayModelMapper;
import com.talabat.localization.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010 \u001a\u00020!J\u001f\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00172\u0006\u0010%\u001a\u00020\fH\u0002¢\u0006\u0002\u0010&J\u001d\u0010'\u001a\u0004\u0018\u00010\u00172\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0019H\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0019H\u0002J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0019H\u0002J\u0010\u00100\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0019H\u0002J\u0010\u00101\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0019H\u0002J\u0018\u00102\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0019H\u0002J\u0010\u00106\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0019H\u0002J \u00107\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00192\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\fH\u0002J,\u0010;\u001a\b\u0012\u0004\u0012\u00020*0)2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\fH\u0002J!\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010?J\u0018\u0010@\u001a\u00020\f2\u0006\u00108\u001a\u0002092\u0006\u0010A\u001a\u000209H\u0002J\u0006\u0010B\u001a\u00020!J\u0006\u0010C\u001a\u00020!J\u0006\u0010D\u001a\u00020!J\u000e\u0010E\u001a\u00020!2\u0006\u00103\u001a\u000204J\u0006\u0010F\u001a\u00020!J\u0006\u0010G\u001a\u00020!J\u0016\u0010H\u001a\u00020!2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\fJ\u0010\u0010I\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0019H\u0002J\u0018\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fH\u0002J\u0016\u0010L\u001a\u00020\f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0006\u0010M\u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R/\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8F@BX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R/\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u00198@@BX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006N"}, d2 = {"Lcom/talabat/feature/ridertips/presentation/viewmodel/RiderTipViewModel;", "Landroidx/lifecycle/ViewModel;", "getRiderTipUseCase", "Lcom/talabat/feature/ridertips/domain/usecases/GetRiderTipUseCase;", "mapper", "Lcom/talabat/feature/ridertips/presentation/mapper/IRiderTipDisplayModelMapper;", "tracker", "Lcom/talabat/feature/ridertips/domain/IRiderTipTracker;", "saveRiderTipUseCase", "Lcom/talabat/feature/ridertips/domain/usecases/SaveRiderTipUseCase;", "(Lcom/talabat/feature/ridertips/domain/usecases/GetRiderTipUseCase;Lcom/talabat/feature/ridertips/presentation/mapper/IRiderTipDisplayModelMapper;Lcom/talabat/feature/ridertips/domain/IRiderTipTracker;Lcom/talabat/feature/ridertips/domain/usecases/SaveRiderTipUseCase;)V", "reuseTipAutoSelection", "", "<set-?>", "Lcom/talabat/feature/ridertips/presentation/displaymodel/TermsDisplayModel;", "terms", "getTerms", "()Lcom/talabat/feature/ridertips/presentation/displaymodel/TermsDisplayModel;", "setTerms", "(Lcom/talabat/feature/ridertips/presentation/displaymodel/TermsDisplayModel;)V", "terms$delegate", "Landroidx/compose/runtime/MutableState;", "threshold", "", "Ljava/lang/Double;", "Lcom/talabat/feature/ridertips/presentation/displaymodel/RiderTipDisplayModel;", "viewState", "getViewState$com_talabat_feature_ridertips_presentation_presentation", "()Lcom/talabat/feature/ridertips/presentation/displaymodel/RiderTipDisplayModel;", "setViewState", "(Lcom/talabat/feature/ridertips/presentation/displaymodel/RiderTipDisplayModel;)V", "viewState$delegate", "disclaimerClicked", "", "getCtaBasedOnCustomTipValue", "Lcom/talabat/feature/ridertips/presentation/displaymodel/CtaMode;", "customTipValue", "isDefaultTipEnabled", "(Ljava/lang/Double;Z)Lcom/talabat/feature/ridertips/presentation/displaymodel/CtaMode;", "getTipAmount", "tipOptions", "", "Lcom/talabat/feature/ridertips/presentation/displaymodel/TipOptionDisplayModel;", "(Ljava/util/List;)Ljava/lang/Double;", "getUpdatedStateOnReuseTipTap", "previousState", "getUpdatedStateOnTipCustomInputApplyCtaTap", "getUpdatedStateOnTipCustomInputCloseCtaTap", "getUpdatedStateOnTipCustomInputCtaTap", "getUpdatedStateOnTipCustomInputRemoveCtaTap", "getUpdatedStateOnTipCustomInputTextChange", "inputText", "", "getUpdatedStateOnTipDisabled", "getUpdatedStateOnTipEnabled", "getUpdatedStateOnTipOptionTap", "tappedOptionIndex", "", "isTappedOptionSelected", "getUpdatedTipOptionsAfterResetting", "previousTipOptions", "isCtaEnabled", "customTipAmount", "(Ljava/lang/Double;Ljava/lang/Double;)Z", "isNormalOptionTapped", "customOptionIndex", "onClearTipTap", "onReuseTipTap", "onTipCustomInputCtaTap", "onTipCustomInputTextChange", "onTipDisabled", "onTipEnabled", "onTipOptionTap", "reuseTipSelected", "shouldSelectReuseTip", "tappedOptionSelected", "shouldShowReuseTip", "updateSaveRiderTip", "com_talabat_feature_ridertips_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipViewModel extends ViewModel {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    @NotNull
    public final GetRiderTipUseCase getRiderTipUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final IRiderTipDisplayModelMapper mapper;
    private boolean reuseTipAutoSelection = true;
    /* access modifiers changed from: private */
    @NotNull
    public final SaveRiderTipUseCase saveRiderTipUseCase;
    @NotNull
    private final MutableState terms$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    /* access modifiers changed from: private */
    @Nullable
    public Double threshold;
    /* access modifiers changed from: private */
    @NotNull
    public final IRiderTipTracker tracker;
    @NotNull
    private final MutableState viewState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel$1", f = "RiderTipViewModel.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f58886h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ RiderTipViewModel f58887i;

        {
            this.f58887i = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(this.f58887i, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object obj2;
            Double d11;
            boolean z11;
            Object obj3;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f58886h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                RiderTipViewModel riderTipViewModel = this.f58887i;
                Result.Companion companion = Result.Companion;
                GetRiderTipUseCase access$getGetRiderTipUseCase$p = riderTipViewModel.getRiderTipUseCase;
                this.f58886h = 1;
                obj3 = access$getGetRiderTipUseCase$p.getRiderTip(this);
                if (obj3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                    obj3 = obj;
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            obj2 = Result.m6329constructorimpl((RiderTip) obj3);
            RiderTipViewModel riderTipViewModel2 = this.f58887i;
            if (Result.m6336isSuccessimpl(obj2)) {
                RiderTip riderTip = (RiderTip) obj2;
                TipOptionsDetailsDisplayModel mapTipToTipOptionsViewState = riderTipViewModel2.mapper.mapTipToTipOptionsViewState(riderTip.getTip());
                if (mapTipToTipOptionsViewState != null) {
                    riderTipViewModel2.threshold = riderTip.getTip().getThreshold();
                    Double value = ((TipOptionDisplayModel) CollectionsKt___CollectionsKt.last(mapTipToTipOptionsViewState.getTipOptions())).getValue();
                    Boolean isDefaultTipEnabled = riderTip.getTip().isDefaultTipEnabled();
                    boolean z12 = false;
                    if (isDefaultTipEnabled != null) {
                        z11 = isDefaultTipEnabled.booleanValue();
                    } else {
                        z11 = false;
                    }
                    CtaMode access$getCtaBasedOnCustomTipValue = riderTipViewModel2.getCtaBasedOnCustomTipValue(value, z11);
                    String title = riderTip.getTitle();
                    if (title == null) {
                        title = "";
                    }
                    String subtitle = riderTip.getSubtitle();
                    if (subtitle == null) {
                        subtitle = "";
                    }
                    Double preferred = riderTip.getTip().getPreferred();
                    Boolean isDefaultTipEnabled2 = riderTip.getTip().isDefaultTipEnabled();
                    if (isDefaultTipEnabled2 != null) {
                        z12 = isDefaultTipEnabled2.booleanValue();
                    }
                    boolean z13 = z12;
                    int stringBasedOnCta = riderTipViewModel2.mapper.getStringBasedOnCta(access$getCtaBasedOnCustomTipValue);
                    int i12 = R.string.rider_tip_custom_tip_input_hint;
                    if (value == null) {
                        value = "";
                    }
                    riderTipViewModel2.setViewState(new RiderTipDisplayModel(title, subtitle, preferred, false, z13, mapTipToTipOptionsViewState, new CustomTipInputDetailsDisplayModel(access$getCtaBasedOnCustomTipValue, stringBasedOnCta, i12, String.valueOf(value), true)));
                    riderTipViewModel2.setTerms(riderTipViewModel2.mapper.mapTermsToTermsDisplayModel(riderTip.getTerms()));
                }
                IRiderTipTracker access$getTracker$p = riderTipViewModel2.tracker;
                RiderTipDisplayModel viewState$com_talabat_feature_ridertips_presentation_presentation = riderTipViewModel2.getViewState$com_talabat_feature_ridertips_presentation_presentation();
                if (viewState$com_talabat_feature_ridertips_presentation_presentation != null) {
                    d11 = viewState$com_talabat_feature_ridertips_presentation_presentation.getTipAmount();
                } else {
                    d11 = null;
                }
                access$getTracker$p.onRiderTipLoaded(d11, "checkoutScreen");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CtaMode.values().length];
            iArr[CtaMode.CLOSE.ordinal()] = 1;
            iArr[CtaMode.Remove.ordinal()] = 2;
            iArr[CtaMode.APPLY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public RiderTipViewModel(@NotNull GetRiderTipUseCase getRiderTipUseCase2, @NotNull IRiderTipDisplayModelMapper iRiderTipDisplayModelMapper, @NotNull IRiderTipTracker iRiderTipTracker, @NotNull SaveRiderTipUseCase saveRiderTipUseCase2) {
        Intrinsics.checkNotNullParameter(getRiderTipUseCase2, "getRiderTipUseCase");
        Intrinsics.checkNotNullParameter(iRiderTipDisplayModelMapper, "mapper");
        Intrinsics.checkNotNullParameter(iRiderTipTracker, "tracker");
        Intrinsics.checkNotNullParameter(saveRiderTipUseCase2, "saveRiderTipUseCase");
        this.getRiderTipUseCase = getRiderTipUseCase2;
        this.mapper = iRiderTipDisplayModelMapper;
        this.tracker = iRiderTipTracker;
        this.saveRiderTipUseCase = saveRiderTipUseCase2;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final CtaMode getCtaBasedOnCustomTipValue(Double d11, boolean z11) {
        if (d11 == null) {
            return CtaMode.CLOSE;
        }
        if (z11) {
            return CtaMode.APPLY;
        }
        return CtaMode.Remove;
    }

    private final Double getTipAmount(List<TipOptionDisplayModel> list) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((TipOptionDisplayModel) obj).getSelected()) {
                break;
            }
        }
        TipOptionDisplayModel tipOptionDisplayModel = (TipOptionDisplayModel) obj;
        if (tipOptionDisplayModel != null) {
            return tipOptionDisplayModel.getValue();
        }
        return null;
    }

    private final RiderTipDisplayModel getUpdatedStateOnReuseTipTap(RiderTipDisplayModel riderTipDisplayModel) {
        if (!reuseTipSelected(riderTipDisplayModel)) {
            this.tracker.onRiderTipSaved(riderTipDisplayModel.getTipAmount(), "checkoutScreen", "checkoutScreen");
        } else {
            this.tracker.onRiderTipUnsaved(riderTipDisplayModel.getTipAmount(), "checkoutScreen", "checkoutScreen");
        }
        return RiderTipDisplayModel.copy$default(riderTipDisplayModel, (String) null, (String) null, (Double) null, false, false, TipOptionsDetailsDisplayModel.copy$default(riderTipDisplayModel.getTipOptionsDetails(), (List) null, false, !riderTipDisplayModel.getTipOptionsDetails().getReuseTipSelected(), 0, 11, (Object) null), (CustomTipInputDetailsDisplayModel) null, 95, (Object) null);
    }

    private final RiderTipDisplayModel getUpdatedStateOnTipCustomInputApplyCtaTap(RiderTipDisplayModel riderTipDisplayModel) {
        boolean z11;
        Double d11;
        String str;
        double parseDouble = Double.parseDouble(riderTipDisplayModel.getCustomTipInputDetails().getInputText());
        Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(riderTipDisplayModel.getCustomTipInputDetails().getInputText());
        CtaMode ctaBasedOnCustomTipValue = getCtaBasedOnCustomTipValue(doubleOrNull, riderTipDisplayModel.isDefaultTipEnabled());
        this.tracker.onRiderTipClicked(doubleOrNull, "checkoutScreen", "checkoutScreen");
        TipOptionsDetailsDisplayModel tipOptionsDetails = riderTipDisplayModel.getTipOptionsDetails();
        Iterable<TipOptionDisplayModel> tipOptions = riderTipDisplayModel.getTipOptionsDetails().getTipOptions();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(tipOptions, 10));
        for (TipOptionDisplayModel tipOptionDisplayModel : tipOptions) {
            boolean isCustomTip = tipOptionDisplayModel.isCustomTip();
            if (tipOptionDisplayModel.isCustomTip()) {
                d11 = Double.valueOf(parseDouble);
            } else {
                d11 = tipOptionDisplayModel.getValue();
            }
            Double d12 = d11;
            if (tipOptionDisplayModel.isCustomTip()) {
                str = this.mapper.getDisplayCustomTipValue(Double.valueOf(parseDouble));
            } else {
                str = tipOptionDisplayModel.getDisplayTipValue();
            }
            arrayList.add(TipOptionDisplayModel.copy$default(tipOptionDisplayModel, d12, str, isCustomTip, false, 8, (Object) null));
        }
        if (this.reuseTipAutoSelection) {
            z11 = true;
        } else {
            z11 = riderTipDisplayModel.getTipOptionsDetails().getReuseTipSelected();
        }
        return RiderTipDisplayModel.copy$default(riderTipDisplayModel, (String) null, (String) null, doubleOrNull, false, false, TipOptionsDetailsDisplayModel.copy$default(tipOptionsDetails, arrayList, true, z11, 0, 8, (Object) null), CustomTipInputDetailsDisplayModel.copy$default(riderTipDisplayModel.getCustomTipInputDetails(), ctaBasedOnCustomTipValue, this.mapper.getStringBasedOnCta(ctaBasedOnCustomTipValue), 0, (String) null, false, 28, (Object) null), 19, (Object) null);
    }

    private final RiderTipDisplayModel getUpdatedStateOnTipCustomInputCloseCtaTap(RiderTipDisplayModel riderTipDisplayModel) {
        TipOptionDisplayModel tipOptionDisplayModel;
        TipOptionDisplayModel tipOptionDisplayModel2 = new TipOptionDisplayModel((Double) null, this.mapper.getDisplayCustomTipValue((Double) null), false, true);
        Iterable<TipOptionDisplayModel> tipOptions = riderTipDisplayModel.getTipOptionsDetails().getTipOptions();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(tipOptions, 10));
        for (TipOptionDisplayModel tipOptionDisplayModel3 : tipOptions) {
            if (tipOptionDisplayModel3.isCustomTip()) {
                tipOptionDisplayModel = tipOptionDisplayModel2;
            } else {
                tipOptionDisplayModel = TipOptionDisplayModel.copy$default(tipOptionDisplayModel3, (Double) null, (String) null, false, false, 15, (Object) null);
            }
            arrayList.add(tipOptionDisplayModel);
        }
        TipOptionsDetailsDisplayModel copy$default = TipOptionsDetailsDisplayModel.copy$default(riderTipDisplayModel.getTipOptionsDetails(), arrayList, shouldShowReuseTip(arrayList), false, 0, 12, (Object) null);
        return RiderTipDisplayModel.copy$default(riderTipDisplayModel, (String) null, (String) null, getTipAmount(copy$default.getTipOptions()), false, false, copy$default, CustomTipInputDetailsDisplayModel.copy$default(riderTipDisplayModel.getCustomTipInputDetails(), (CtaMode) null, 0, 0, "", false, 23, (Object) null), 19, (Object) null);
    }

    private final RiderTipDisplayModel getUpdatedStateOnTipCustomInputCtaTap(RiderTipDisplayModel riderTipDisplayModel) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[riderTipDisplayModel.getCustomTipInputDetails().getCtaMode().ordinal()];
        if (i11 == 1) {
            return getUpdatedStateOnTipCustomInputCloseCtaTap(riderTipDisplayModel);
        }
        if (i11 == 2) {
            return getUpdatedStateOnTipCustomInputRemoveCtaTap(riderTipDisplayModel);
        }
        if (i11 == 3) {
            return getUpdatedStateOnTipCustomInputApplyCtaTap(riderTipDisplayModel);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final RiderTipDisplayModel getUpdatedStateOnTipCustomInputRemoveCtaTap(RiderTipDisplayModel riderTipDisplayModel) {
        Double d11;
        String str;
        CtaMode ctaMode = CtaMode.CLOSE;
        this.tracker.onRiderTipRemoved((Double) null, "checkoutScreen", "checkoutScreen");
        TipOptionsDetailsDisplayModel tipOptionsDetails = riderTipDisplayModel.getTipOptionsDetails();
        Iterable<TipOptionDisplayModel> tipOptions = riderTipDisplayModel.getTipOptionsDetails().getTipOptions();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(tipOptions, 10));
        for (TipOptionDisplayModel tipOptionDisplayModel : tipOptions) {
            if (tipOptionDisplayModel.isCustomTip()) {
                d11 = null;
            } else {
                d11 = tipOptionDisplayModel.getValue();
            }
            if (tipOptionDisplayModel.isCustomTip()) {
                str = this.mapper.getDisplayCustomTipValue((Double) null);
            } else {
                str = tipOptionDisplayModel.getDisplayTipValue();
            }
            arrayList.add(TipOptionDisplayModel.copy$default(tipOptionDisplayModel, d11, str, false, false, 8, (Object) null));
        }
        return RiderTipDisplayModel.copy$default(riderTipDisplayModel, (String) null, (String) null, (Double) null, false, false, TipOptionsDetailsDisplayModel.copy$default(tipOptionsDetails, arrayList, false, false, 0, 12, (Object) null), CustomTipInputDetailsDisplayModel.copy$default(riderTipDisplayModel.getCustomTipInputDetails(), ctaMode, this.mapper.getStringBasedOnCta(ctaMode), 0, "", false, 20, (Object) null), 19, (Object) null);
    }

    private final RiderTipDisplayModel getUpdatedStateOnTipCustomInputTextChange(RiderTipDisplayModel riderTipDisplayModel, String str) {
        CtaMode ctaMode;
        Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(str);
        if (doubleOrNull == null || doubleOrNull.doubleValue() <= 0.0d) {
            ctaMode = CtaMode.CLOSE;
        } else {
            ctaMode = CtaMode.APPLY;
        }
        CtaMode ctaMode2 = ctaMode;
        return RiderTipDisplayModel.copy$default(riderTipDisplayModel, (String) null, (String) null, (Double) null, false, false, (TipOptionsDetailsDisplayModel) null, CustomTipInputDetailsDisplayModel.copy$default(riderTipDisplayModel.getCustomTipInputDetails(), ctaMode2, this.mapper.getStringBasedOnCta(ctaMode2), 0, str, isCtaEnabled(doubleOrNull, this.threshold), 4, (Object) null), 63, (Object) null);
    }

    private final RiderTipDisplayModel getUpdatedStateOnTipDisabled(RiderTipDisplayModel riderTipDisplayModel) {
        return RiderTipDisplayModel.copy$default(riderTipDisplayModel, (String) null, (String) null, (Double) null, false, false, (TipOptionsDetailsDisplayModel) null, (CustomTipInputDetailsDisplayModel) null, 123, (Object) null);
    }

    private final RiderTipDisplayModel getUpdatedStateOnTipEnabled(RiderTipDisplayModel riderTipDisplayModel) {
        return RiderTipDisplayModel.copy$default(riderTipDisplayModel, (String) null, (String) null, getTipAmount(riderTipDisplayModel.getTipOptionsDetails().getTipOptions()), false, false, (TipOptionsDetailsDisplayModel) null, (CustomTipInputDetailsDisplayModel) null, 123, (Object) null);
    }

    private final RiderTipDisplayModel getUpdatedStateOnTipOptionTap(RiderTipDisplayModel riderTipDisplayModel, int i11, boolean z11) {
        int i12 = i11;
        boolean z12 = z11;
        if (isNormalOptionTapped(i12, riderTipDisplayModel.getTipOptionsDetails().getTipOptions().size() - 1)) {
            List<TipOptionDisplayModel> updatedTipOptionsAfterResetting = getUpdatedTipOptionsAfterResetting(riderTipDisplayModel.getTipOptionsDetails().getTipOptions(), i12, z12);
            boolean shouldSelectReuseTip = shouldSelectReuseTip(z12, riderTipDisplayModel.getTipOptionsDetails().getReuseTipSelected());
            Double tipAmount = getTipAmount(updatedTipOptionsAfterResetting);
            if (z12) {
                this.tracker.onRiderTipClicked(tipAmount, "checkoutScreen", "checkoutScreen");
            } else {
                this.tracker.onRiderTipRemoved((Double) null, "checkoutScreen", "checkoutScreen");
            }
            return RiderTipDisplayModel.copy$default(riderTipDisplayModel, (String) null, (String) null, tipAmount, false, false, TipOptionsDetailsDisplayModel.copy$default(riderTipDisplayModel.getTipOptionsDetails(), updatedTipOptionsAfterResetting, z11, shouldSelectReuseTip, 0, 8, (Object) null), (CustomTipInputDetailsDisplayModel) null, 83, (Object) null);
        }
        this.tracker.onRiderTipOpened((Double) null, "checkoutScreen", "checkoutScreen");
        return RiderTipDisplayModel.copy$default(riderTipDisplayModel, (String) null, (String) null, (Double) null, true, false, (TipOptionsDetailsDisplayModel) null, (CustomTipInputDetailsDisplayModel) null, 119, (Object) null);
    }

    private final List<TipOptionDisplayModel> getUpdatedTipOptionsAfterResetting(List<TipOptionDisplayModel> list, int i11, boolean z11) {
        boolean z12;
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i12 = 0;
        for (Object next : iterable) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            TipOptionDisplayModel tipOptionDisplayModel = (TipOptionDisplayModel) next;
            if (i12 == i11) {
                z12 = z11;
            } else {
                z12 = false;
            }
            arrayList.add(TipOptionDisplayModel.copy$default(tipOptionDisplayModel, (Double) null, (String) null, z12, false, 11, (Object) null));
            i12 = i13;
        }
        return arrayList;
    }

    private final boolean isCtaEnabled(Double d11, Double d12) {
        return d11 == null || d12 == null || d11.doubleValue() <= d12.doubleValue();
    }

    private final boolean isNormalOptionTapped(int i11, int i12) {
        return i11 != i12;
    }

    private final boolean reuseTipSelected(RiderTipDisplayModel riderTipDisplayModel) {
        return riderTipDisplayModel.getTipOptionsDetails().getReuseTipSelected();
    }

    /* access modifiers changed from: private */
    public final void setTerms(TermsDisplayModel termsDisplayModel) {
        this.terms$delegate.setValue(termsDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void setViewState(RiderTipDisplayModel riderTipDisplayModel) {
        this.viewState$delegate.setValue(riderTipDisplayModel);
    }

    private final boolean shouldSelectReuseTip(boolean z11, boolean z12) {
        return this.reuseTipAutoSelection ? z11 : z12;
    }

    private final boolean shouldShowReuseTip(List<TipOptionDisplayModel> list) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((TipOptionDisplayModel) obj).getSelected()) {
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    public final void disclaimerClicked() {
        this.tracker.disclaimerClicked();
    }

    @Nullable
    public final TermsDisplayModel getTerms() {
        return (TermsDisplayModel) this.terms$delegate.getValue();
    }

    @Nullable
    public final RiderTipDisplayModel getViewState$com_talabat_feature_ridertips_presentation_presentation() {
        return (RiderTipDisplayModel) this.viewState$delegate.getValue();
    }

    public final void onClearTipTap() {
        RiderTipDisplayModel viewState$com_talabat_feature_ridertips_presentation_presentation = getViewState$com_talabat_feature_ridertips_presentation_presentation();
        if (viewState$com_talabat_feature_ridertips_presentation_presentation != null) {
            TipOptionsDetailsDisplayModel tipOptionsDetails = viewState$com_talabat_feature_ridertips_presentation_presentation.getTipOptionsDetails();
            Iterable<TipOptionDisplayModel> tipOptions = viewState$com_talabat_feature_ridertips_presentation_presentation.getTipOptionsDetails().getTipOptions();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(tipOptions, 10));
            for (TipOptionDisplayModel copy$default : tipOptions) {
                arrayList.add(TipOptionDisplayModel.copy$default(copy$default, (Double) null, (String) null, false, false, 11, (Object) null));
            }
            setViewState(RiderTipDisplayModel.copy$default(viewState$com_talabat_feature_ridertips_presentation_presentation, (String) null, (String) null, (Double) null, false, false, TipOptionsDetailsDisplayModel.copy$default(tipOptionsDetails, arrayList, false, false, 0, 8, (Object) null), (CustomTipInputDetailsDisplayModel) null, 91, (Object) null));
            this.tracker.onRiderTipRemoved((Double) null, "checkoutScreen", "checkoutScreen");
        }
    }

    public final void onReuseTipTap() {
        RiderTipDisplayModel viewState$com_talabat_feature_ridertips_presentation_presentation = getViewState$com_talabat_feature_ridertips_presentation_presentation();
        if (viewState$com_talabat_feature_ridertips_presentation_presentation != null) {
            setViewState(getUpdatedStateOnReuseTipTap(viewState$com_talabat_feature_ridertips_presentation_presentation));
            Unit unit = Unit.INSTANCE;
        }
        this.reuseTipAutoSelection = false;
    }

    public final void onTipCustomInputCtaTap() {
        RiderTipDisplayModel viewState$com_talabat_feature_ridertips_presentation_presentation = getViewState$com_talabat_feature_ridertips_presentation_presentation();
        if (viewState$com_talabat_feature_ridertips_presentation_presentation != null) {
            setViewState(getUpdatedStateOnTipCustomInputCtaTap(viewState$com_talabat_feature_ridertips_presentation_presentation));
        }
    }

    public final void onTipCustomInputTextChange(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "inputText");
        RiderTipDisplayModel viewState$com_talabat_feature_ridertips_presentation_presentation = getViewState$com_talabat_feature_ridertips_presentation_presentation();
        if (viewState$com_talabat_feature_ridertips_presentation_presentation != null) {
            setViewState(getUpdatedStateOnTipCustomInputTextChange(viewState$com_talabat_feature_ridertips_presentation_presentation, str));
        }
    }

    public final void onTipDisabled() {
        RiderTipDisplayModel viewState$com_talabat_feature_ridertips_presentation_presentation = getViewState$com_talabat_feature_ridertips_presentation_presentation();
        if (viewState$com_talabat_feature_ridertips_presentation_presentation != null) {
            setViewState(getUpdatedStateOnTipDisabled(viewState$com_talabat_feature_ridertips_presentation_presentation));
        }
    }

    public final void onTipEnabled() {
        RiderTipDisplayModel viewState$com_talabat_feature_ridertips_presentation_presentation = getViewState$com_talabat_feature_ridertips_presentation_presentation();
        if (viewState$com_talabat_feature_ridertips_presentation_presentation != null) {
            setViewState(getUpdatedStateOnTipEnabled(viewState$com_talabat_feature_ridertips_presentation_presentation));
        }
    }

    public final void onTipOptionTap(int i11, boolean z11) {
        RiderTipDisplayModel viewState$com_talabat_feature_ridertips_presentation_presentation = getViewState$com_talabat_feature_ridertips_presentation_presentation();
        if (viewState$com_talabat_feature_ridertips_presentation_presentation != null) {
            setViewState(getUpdatedStateOnTipOptionTap(viewState$com_talabat_feature_ridertips_presentation_presentation, i11, z11));
        }
    }

    public final void updateSaveRiderTip() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new RiderTipViewModel$updateSaveRiderTip$1(this, (Continuation<? super RiderTipViewModel$updateSaveRiderTip$1>) null), 3, (Object) null);
    }
}
