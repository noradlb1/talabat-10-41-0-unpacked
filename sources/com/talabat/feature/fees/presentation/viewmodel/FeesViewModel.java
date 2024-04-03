package com.talabat.feature.fees.presentation.viewmodel;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import buisnessmodels.TalabatFormatter;
import com.talabat.feature.fees.domain.IFeesTracker;
import com.talabat.feature.fees.domain.model.FeeDescription;
import com.talabat.feature.fees.domain.model.FeeDescriptionType;
import com.talabat.feature.fees.domain.repository.IDisclaimerRepository;
import com.talabat.feature.fees.domain.usecase.GetFeesUseCase;
import com.talabat.feature.fees.presentation.displaymodel.DisclaimerBannerDisplayModel;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;
import com.talabat.feature.fees.presentation.displaymodel.FeesDescriptionsDisplayModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0014\u0010 \u001a\u0004\u0018\u00010\u000f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J*\u0010#\u001a\u0004\u0018\u00010\"2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\"0$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u001e\u0010)\u001a\u0004\u0018\u00010(2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020,0+H\u0002J\u001e\u0010-\u001a\u0004\u0018\u00010(2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020,0+H\u0002J9\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H@ø\u0001\u0000¢\u0006\u0002\u00107J\u0014\u00108\u001a\u00020\u00112\f\u00109\u001a\b\u0012\u0004\u0012\u00020\"0$J\u000e\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020(J\u000e\u0010<\u001a\u00020/2\u0006\u0010;\u001a\u00020(J\u0006\u0010=\u001a\u00020/J\u000e\u0010>\u001a\u00020/2\u0006\u0010;\u001a\u00020(J\u000e\u0010?\u001a\u00020/2\u0006\u0010;\u001a\u00020(J\u000e\u0010@\u001a\u00020/2\u0006\u0010;\u001a\u00020(J\u000e\u0010A\u001a\u00020/2\u0006\u0010;\u001a\u00020(J.\u0010B\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00158F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00158F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006C"}, d2 = {"Lcom/talabat/feature/fees/presentation/viewmodel/FeesViewModel;", "Landroidx/lifecycle/ViewModel;", "getFeesUseCase", "Lcom/talabat/feature/fees/domain/usecase/GetFeesUseCase;", "disclaimerRepository", "Lcom/talabat/feature/fees/domain/repository/IDisclaimerRepository;", "tracker", "Lcom/talabat/feature/fees/domain/IFeesTracker;", "currencyFormatter", "Lbuisnessmodels/TalabatFormatter;", "(Lcom/talabat/feature/fees/domain/usecase/GetFeesUseCase;Lcom/talabat/feature/fees/domain/repository/IDisclaimerRepository;Lcom/talabat/feature/fees/domain/IFeesTracker;Lbuisnessmodels/TalabatFormatter;)V", "_deliveryFeeValue", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/feature/fees/presentation/displaymodel/FeeValue;", "_disclaimerBannerInformation", "Lcom/talabat/feature/fees/presentation/displaymodel/DisclaimerBannerDisplayModel;", "_feesDescriptions", "Lcom/talabat/feature/fees/presentation/displaymodel/FeesDescriptionsDisplayModel;", "_serviceFeeValue", "_smallOrderFeeValue", "deliveryFeeValue", "Landroidx/lifecycle/LiveData;", "getDeliveryFeeValue", "()Landroidx/lifecycle/LiveData;", "disclaimerBannerInformation", "getDisclaimerBannerInformation", "feesDescriptions", "getFeesDescriptions", "serviceFeeValue", "getServiceFeeValue", "smallOrderFeeValue", "getSmallOrderFeeValue", "createDisclaimerBannerDisplayModel", "disclaimerInfo", "Lcom/talabat/feature/fees/domain/model/FeeDescription;", "createFeeDescription", "", "type", "Lcom/talabat/feature/fees/domain/model/FeeDescriptionType;", "url", "", "firstOrderFreeDelivery", "tags", "", "", "firstOrderFreeDeliveryOriginalFee", "getCalculatedFeesAndDescriptions", "", "subtotalBeforeDiscounts", "", "subtotal", "couponDiscount", "latitude", "", "longitude", "(FFFDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDarkstoreFeesDescriptions", "feeDescriptions", "onContinueOrderClicked", "screenName", "onDeliveryFeeInfoClicked", "onDismissDisclaimerClicked", "onGeneralFeesInfoClicked", "onReadMoreExternalInfoClicked", "onServiceFeeInfoClicked", "onSmallOrderFeeInfoClicked", "onSubtotalChanged", "com_talabat_feature_pricing_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeesViewModel extends ViewModel {
    public static final int $stable = 8;
    @NotNull
    private final MutableLiveData<FeeValue> _deliveryFeeValue = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<DisclaimerBannerDisplayModel> _disclaimerBannerInformation = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<FeesDescriptionsDisplayModel> _feesDescriptions = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<FeeValue> _serviceFeeValue = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<FeeValue> _smallOrderFeeValue = new MutableLiveData<>();
    @NotNull
    private final TalabatFormatter currencyFormatter;
    @NotNull
    private final IDisclaimerRepository disclaimerRepository;
    @NotNull
    private final GetFeesUseCase getFeesUseCase;
    @NotNull
    private final IFeesTracker tracker;

    @Inject
    public FeesViewModel(@NotNull GetFeesUseCase getFeesUseCase2, @NotNull IDisclaimerRepository iDisclaimerRepository, @NotNull IFeesTracker iFeesTracker, @NotNull TalabatFormatter talabatFormatter) {
        Intrinsics.checkNotNullParameter(getFeesUseCase2, "getFeesUseCase");
        Intrinsics.checkNotNullParameter(iDisclaimerRepository, "disclaimerRepository");
        Intrinsics.checkNotNullParameter(iFeesTracker, "tracker");
        Intrinsics.checkNotNullParameter(talabatFormatter, "currencyFormatter");
        this.getFeesUseCase = getFeesUseCase2;
        this.disclaimerRepository = iDisclaimerRepository;
        this.tracker = iFeesTracker;
        this.currencyFormatter = talabatFormatter;
    }

    private final DisclaimerBannerDisplayModel createDisclaimerBannerDisplayModel(FeeDescription feeDescription) {
        if (feeDescription == null) {
            return null;
        }
        return new DisclaimerBannerDisplayModel(feeDescription.getName(), feeDescription.getDescription(), feeDescription.getUrlText(), feeDescription.getUrl());
    }

    private final FeeDescription createFeeDescription(List<FeeDescription> list, FeeDescriptionType feeDescriptionType, String str) {
        Object obj;
        boolean z11;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((FeeDescription) obj).getType() == feeDescriptionType) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        FeeDescription feeDescription = (FeeDescription) obj;
        if (feeDescription != null) {
            return FeeDescription.copy$default(feeDescription, (FeeDescriptionType) null, (String) null, (String) null, (String) null, str, (String) null, 47, (Object) null);
        }
        return null;
    }

    private final String firstOrderFreeDelivery(Map<String, ? extends Object> map) {
        String str;
        Boolean bool;
        boolean z11;
        Object obj = map.get("reason");
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        Object obj2 = map.get("free_first_order");
        if (obj2 instanceof Boolean) {
            bool = (Boolean) obj2;
        } else {
            bool = null;
        }
        if (bool != null) {
            z11 = bool.booleanValue();
        } else {
            z11 = false;
        }
        if (z11) {
            return str;
        }
        return null;
    }

    private final String firstOrderFreeDeliveryOriginalFee(Map<String, ? extends Object> map) {
        Double d11;
        String str;
        Boolean bool;
        boolean z11;
        Object obj = map.get("standard_fee");
        if (obj instanceof Double) {
            d11 = (Double) obj;
        } else {
            d11 = null;
        }
        if (d11 != null) {
            str = this.currencyFormatter.getFormattedCurrency((float) d11.doubleValue());
        } else {
            str = null;
        }
        Object obj2 = map.get("free_first_order");
        if (obj2 instanceof Boolean) {
            bool = (Boolean) obj2;
        } else {
            bool = null;
        }
        if (bool != null) {
            z11 = bool.booleanValue();
        } else {
            z11 = false;
        }
        if (z11) {
            return str;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.talabat.feature.fees.domain.model.FeeDescription} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.talabat.feature.fees.domain.model.FeeDescription} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: com.talabat.feature.fees.domain.model.FeeDescription} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.talabat.feature.fees.domain.model.FeeDescription} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0144 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01a2 A[EDGE_INSN: B:83:0x01a2->B:64:0x01a2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getCalculatedFeesAndDescriptions(float r16, float r17, float r18, double r19, double r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r15 = this;
            r0 = r15
            r1 = r23
            boolean r2 = r1 instanceof com.talabat.feature.fees.presentation.viewmodel.FeesViewModel$getCalculatedFeesAndDescriptions$1
            if (r2 == 0) goto L_0x0016
            r2 = r1
            com.talabat.feature.fees.presentation.viewmodel.FeesViewModel$getCalculatedFeesAndDescriptions$1 r2 = (com.talabat.feature.fees.presentation.viewmodel.FeesViewModel$getCalculatedFeesAndDescriptions$1) r2
            int r3 = r2.f58542k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f58542k = r3
            goto L_0x001b
        L_0x0016:
            com.talabat.feature.fees.presentation.viewmodel.FeesViewModel$getCalculatedFeesAndDescriptions$1 r2 = new com.talabat.feature.fees.presentation.viewmodel.FeesViewModel$getCalculatedFeesAndDescriptions$1
            r2.<init>(r15, r1)
        L_0x001b:
            r11 = r2
            java.lang.Object r1 = r11.f58540i
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r11.f58542k
            r12 = 1
            if (r3 == 0) goto L_0x0039
            if (r3 != r12) goto L_0x0031
            java.lang.Object r2 = r11.f58539h
            com.talabat.feature.fees.presentation.viewmodel.FeesViewModel r2 = (com.talabat.feature.fees.presentation.viewmodel.FeesViewModel) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0054
        L_0x0031:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r1)
            com.talabat.feature.fees.domain.usecase.GetFeesUseCase r3 = r0.getFeesUseCase
            r11.f58539h = r0
            r11.f58542k = r12
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r9 = r21
            java.lang.Object r1 = r3.invoke(r4, r5, r6, r7, r9, r11)
            if (r1 != r2) goto L_0x0053
            return r2
        L_0x0053:
            r2 = r0
        L_0x0054:
            com.talabat.feature.fees.domain.model.Fees r1 = (com.talabat.feature.fees.domain.model.Fees) r1
            java.util.List r3 = r1.getFees()
            boolean r3 = r3.isEmpty()
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x0073
            androidx.lifecycle.MutableLiveData<com.talabat.feature.fees.presentation.displaymodel.FeeValue> r3 = r2._serviceFeeValue
            r3.postValue(r5)
            androidx.lifecycle.MutableLiveData<com.talabat.feature.fees.presentation.displaymodel.FeeValue> r3 = r2._deliveryFeeValue
            r3.postValue(r5)
            androidx.lifecycle.MutableLiveData<com.talabat.feature.fees.presentation.displaymodel.FeeValue> r3 = r2._smallOrderFeeValue
            r3.postValue(r5)
            goto L_0x011f
        L_0x0073:
            java.util.List r3 = r1.getFees()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x007d:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x011f
            java.lang.Object r6 = r3.next()
            com.talabat.feature.fees.domain.model.Fee r6 = (com.talabat.feature.fees.domain.model.Fee) r6
            com.talabat.feature.fees.presentation.displaymodel.FeeValue r7 = new com.talabat.feature.fees.presentation.displaymodel.FeeValue
            java.lang.String r8 = r6.getName()
            double r9 = r6.getTotal()
            buisnessmodels.TalabatFormatter r11 = r2.currencyFormatter
            double r13 = r6.getTotal()
            float r13 = (float) r13
            java.lang.String r11 = r11.getFormattedCurrency(r13)
            java.lang.String r13 = "currencyFormatter.getFor…rency(it.total.toFloat())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)
            java.util.Map r13 = r6.getTags()
            java.lang.String r13 = r2.firstOrderFreeDelivery(r13)
            java.util.Map r14 = r6.getTags()
            java.lang.String r14 = r2.firstOrderFreeDeliveryOriginalFee(r14)
            r16 = r7
            r17 = r8
            r18 = r9
            r20 = r11
            r21 = r13
            r22 = r14
            r16.<init>(r17, r18, r20, r21, r22)
            java.lang.String r6 = r6.getFeeType()
            int r8 = r6.hashCode()
            r9 = -284372129(0xffffffffef0cd35f, float:-4.3583433E28)
            if (r8 == r9) goto L_0x00f8
            r9 = 268677297(0x1003b0b1, float:2.5971313E-29)
            if (r8 == r9) goto L_0x00e9
            r9 = 720022226(0x2aeaaad2, float:4.168528E-13)
            if (r8 == r9) goto L_0x00da
            goto L_0x007d
        L_0x00da:
            java.lang.String r8 = "DeliveryFee"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x00e3
            goto L_0x007d
        L_0x00e3:
            androidx.lifecycle.MutableLiveData<com.talabat.feature.fees.presentation.displaymodel.FeeValue> r6 = r2._deliveryFeeValue
            r6.postValue(r7)
            goto L_0x007d
        L_0x00e9:
            java.lang.String r8 = "ServiceFee"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x00f2
            goto L_0x007d
        L_0x00f2:
            androidx.lifecycle.MutableLiveData<com.talabat.feature.fees.presentation.displaymodel.FeeValue> r6 = r2._serviceFeeValue
            r6.postValue(r7)
            goto L_0x007d
        L_0x00f8:
            java.lang.String r8 = "SmallOrderFee"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x0102
            goto L_0x007d
        L_0x0102:
            double r8 = r7.getValue()
            r10 = 0
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x010e
            r6 = r12
            goto L_0x010f
        L_0x010e:
            r6 = r4
        L_0x010f:
            if (r6 != 0) goto L_0x0118
            androidx.lifecycle.MutableLiveData<com.talabat.feature.fees.presentation.displaymodel.FeeValue> r6 = r2._smallOrderFeeValue
            r6.postValue(r7)
            goto L_0x007d
        L_0x0118:
            androidx.lifecycle.MutableLiveData<com.talabat.feature.fees.presentation.displaymodel.FeeValue> r6 = r2._smallOrderFeeValue
            r6.postValue(r5)
            goto L_0x007d
        L_0x011f:
            java.util.List r3 = r1.getFeesDescriptions()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0129:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0144
            java.lang.Object r6 = r3.next()
            r7 = r6
            com.talabat.feature.fees.domain.model.FeeDescription r7 = (com.talabat.feature.fees.domain.model.FeeDescription) r7
            com.talabat.feature.fees.domain.model.FeeDescriptionType r7 = r7.getType()
            com.talabat.feature.fees.domain.model.FeeDescriptionType r8 = com.talabat.feature.fees.domain.model.FeeDescriptionType.HowFeesWork
            if (r7 != r8) goto L_0x0140
            r7 = r12
            goto L_0x0141
        L_0x0140:
            r7 = r4
        L_0x0141:
            if (r7 == 0) goto L_0x0129
            goto L_0x0145
        L_0x0144:
            r6 = r5
        L_0x0145:
            com.talabat.feature.fees.domain.model.FeeDescription r6 = (com.talabat.feature.fees.domain.model.FeeDescription) r6
            if (r6 == 0) goto L_0x017d
            androidx.lifecycle.MutableLiveData<com.talabat.feature.fees.presentation.displaymodel.FeesDescriptionsDisplayModel> r3 = r2._feesDescriptions
            com.talabat.feature.fees.presentation.displaymodel.FeesDescriptionsDisplayModel r7 = new com.talabat.feature.fees.presentation.displaymodel.FeesDescriptionsDisplayModel
            java.util.List r8 = r1.getFeesDescriptions()
            com.talabat.feature.fees.domain.model.FeeDescriptionType r9 = com.talabat.feature.fees.domain.model.FeeDescriptionType.DeliveryFee
            java.lang.String r10 = r6.getUrl()
            com.talabat.feature.fees.domain.model.FeeDescription r8 = r2.createFeeDescription(r8, r9, r10)
            java.util.List r9 = r1.getFeesDescriptions()
            com.talabat.feature.fees.domain.model.FeeDescriptionType r10 = com.talabat.feature.fees.domain.model.FeeDescriptionType.ServiceFee
            java.lang.String r11 = r6.getUrl()
            com.talabat.feature.fees.domain.model.FeeDescription r9 = r2.createFeeDescription(r9, r10, r11)
            java.util.List r10 = r1.getFeesDescriptions()
            com.talabat.feature.fees.domain.model.FeeDescriptionType r11 = com.talabat.feature.fees.domain.model.FeeDescriptionType.SmallOrderFee
            java.lang.String r13 = r6.getUrl()
            com.talabat.feature.fees.domain.model.FeeDescription r10 = r2.createFeeDescription(r10, r11, r13)
            r7.<init>(r6, r8, r9, r10)
            r3.postValue(r7)
        L_0x017d:
            java.util.List r1 = r1.getFeesDescriptions()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0187:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x01a2
            java.lang.Object r3 = r1.next()
            r6 = r3
            com.talabat.feature.fees.domain.model.FeeDescription r6 = (com.talabat.feature.fees.domain.model.FeeDescription) r6
            com.talabat.feature.fees.domain.model.FeeDescriptionType r6 = r6.getType()
            com.talabat.feature.fees.domain.model.FeeDescriptionType r7 = com.talabat.feature.fees.domain.model.FeeDescriptionType.FeesBanner
            if (r6 != r7) goto L_0x019e
            r6 = r12
            goto L_0x019f
        L_0x019e:
            r6 = r4
        L_0x019f:
            if (r6 == 0) goto L_0x0187
            r5 = r3
        L_0x01a2:
            com.talabat.feature.fees.domain.model.FeeDescription r5 = (com.talabat.feature.fees.domain.model.FeeDescription) r5
            if (r5 == 0) goto L_0x01af
            androidx.lifecycle.MutableLiveData<com.talabat.feature.fees.presentation.displaymodel.DisclaimerBannerDisplayModel> r1 = r2._disclaimerBannerInformation
            com.talabat.feature.fees.presentation.displaymodel.DisclaimerBannerDisplayModel r2 = r2.createDisclaimerBannerDisplayModel(r5)
            r1.postValue(r2)
        L_0x01af:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.fees.presentation.viewmodel.FeesViewModel.getCalculatedFeesAndDescriptions(float, float, float, double, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final FeesDescriptionsDisplayModel getDarkstoreFeesDescriptions(@NotNull List<FeeDescription> list) {
        String str;
        Object obj;
        String str2;
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "feeDescriptions");
        Iterator it = list.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((FeeDescription) obj).getType() == FeeDescriptionType.HowFeesWork) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                break;
            }
        }
        FeeDescription feeDescription = (FeeDescription) obj;
        FeeDescriptionType feeDescriptionType = FeeDescriptionType.DeliveryFee;
        if (feeDescription != null) {
            str2 = feeDescription.getUrl();
        } else {
            str2 = null;
        }
        FeeDescription createFeeDescription = createFeeDescription(list, feeDescriptionType, str2);
        FeeDescriptionType feeDescriptionType2 = FeeDescriptionType.ServiceFee;
        if (feeDescription != null) {
            str = feeDescription.getUrl();
        }
        return new FeesDescriptionsDisplayModel(feeDescription, createFeeDescription, createFeeDescription(list, feeDescriptionType2, str), (FeeDescription) null, 8, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final LiveData<FeeValue> getDeliveryFeeValue() {
        return this._deliveryFeeValue;
    }

    @NotNull
    public final LiveData<DisclaimerBannerDisplayModel> getDisclaimerBannerInformation() {
        return this._disclaimerBannerInformation;
    }

    @NotNull
    public final LiveData<FeesDescriptionsDisplayModel> getFeesDescriptions() {
        return this._feesDescriptions;
    }

    @NotNull
    public final LiveData<FeeValue> getServiceFeeValue() {
        return this._serviceFeeValue;
    }

    @NotNull
    public final LiveData<FeeValue> getSmallOrderFeeValue() {
        return this._smallOrderFeeValue;
    }

    public final void onContinueOrderClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.tracker.onContinueOrderClicked(str);
    }

    public final void onDeliveryFeeInfoClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.tracker.onDeliveryFeeInfoClicked(str);
    }

    public final void onDismissDisclaimerClicked() {
        this.disclaimerRepository.setDisclaimerDismissed(true);
        this._disclaimerBannerInformation.postValue(null);
    }

    public final void onGeneralFeesInfoClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.tracker.onGeneralFeesInfoClicked(str);
    }

    public final void onReadMoreExternalInfoClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.tracker.onReadMoreExternalInfoClicked(str);
    }

    public final void onServiceFeeInfoClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.tracker.onServiceFeeInfoClicked(str);
    }

    public final void onSmallOrderFeeInfoClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.tracker.onSmallOrderFeeInfoClicked(str);
    }

    public final void onSubtotalChanged(float f11, float f12, float f13, double d11, double d12) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new FeesViewModel$onSubtotalChanged$1(this, f11, f12, f13, d11, d12, (Continuation<? super FeesViewModel$onSubtotalChanged$1>) null), 3, (Object) null);
    }
}
