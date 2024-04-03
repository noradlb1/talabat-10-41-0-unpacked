package com.talabat.darkstores.feature.product.views;

import androidx.lifecycle.ViewModel;
import com.talabat.darkstores.feature.product.models.CampaignAddedQuantity;
import com.talabat.darkstores.feature.product.models.CampaignFreeQuantity;
import com.talabat.darkstores.feature.product.models.ProductCampaign;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00050\u00050\tX\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u0002`\u000f0\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007RA\u0010\u0011\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e \n*\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fj\u0004\u0018\u0001`\u000f0\fj\u0002`\u000f0\tX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R8\u0010\u0012\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00140\u0014 \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00140\u0014\u0018\u00010\u00130\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CampaignProgressViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "campaignInfoObserver", "Lio/reactivex/Observer;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;", "getCampaignInfoObserver", "()Lio/reactivex/Observer;", "campaignInfoSubject", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "quantityChangedObserver", "Lkotlin/Pair;", "Lcom/talabat/darkstores/feature/product/models/CampaignAddedQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignFreeQuantity;", "Lcom/talabat/darkstores/feature/product/models/CampaignProgressData;", "getQuantityChangedObserver", "quantityChangedSubject", "stateObservable", "Lio/reactivex/Observable;", "Lcom/talabat/darkstores/feature/product/views/CampaignProgressState;", "getStateObservable$com_talabat_NewArchi_darkstores_darkstores", "()Lio/reactivex/Observable;", "createState", "added", "free", "campaign", "createState-MlP_i40", "(IILcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;)Lcom/talabat/darkstores/feature/product/views/CampaignProgressState;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignProgressViewModel extends ViewModel {
    @NotNull
    private final Observer<ProductCampaign.Free> campaignInfoObserver;
    @NotNull
    private final PublishSubject<ProductCampaign.Free> campaignInfoSubject;
    @NotNull
    private final Observer<Pair<CampaignAddedQuantity, CampaignFreeQuantity>> quantityChangedObserver;
    @NotNull
    private final PublishSubject<Pair<CampaignAddedQuantity, CampaignFreeQuantity>> quantityChangedSubject;
    private final Observable<CampaignProgressState> stateObservable;

    public CampaignProgressViewModel() {
        PublishSubject<ProductCampaign.Free> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<ProductCampaign.Free>()");
        this.campaignInfoSubject = create;
        PublishSubject<Pair<CampaignAddedQuantity, CampaignFreeQuantity>> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<CampaignProgressData>()");
        this.quantityChangedSubject = create2;
        Observables observables = Observables.INSTANCE;
        Observable<R> combineLatest = Observable.combineLatest(create2, create, new CampaignProgressViewModel$special$$inlined$combineLatest$1(this));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        this.stateObservable = combineLatest.distinctUntilChanged();
        this.campaignInfoObserver = create;
        this.quantityChangedObserver = create2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* renamed from: createState-MlP_i40  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.talabat.darkstores.feature.product.views.CampaignProgressState m10054createStateMlP_i40(int r8, int r9, com.talabat.darkstores.feature.product.models.ProductCampaign.Free r10) {
        /*
            r7 = this;
            int r0 = r10.requiredItems()
            boolean r1 = r10 instanceof com.talabat.darkstores.feature.product.models.ProductCampaign.Free.MixAndMatch
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x000e
            boolean r1 = r10 instanceof com.talabat.darkstores.feature.product.models.ProductCampaign.Free.MixAndMatchDiscount
            if (r1 == 0) goto L_0x003e
        L_0x000e:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0020 }
            int r1 = r8 / r0
            if (r9 >= r1) goto L_0x0016
            r1 = r2
            goto L_0x0017
        L_0x0016:
            r1 = r3
        L_0x0017:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x0020 }
            java.lang.Object r1 = kotlin.Result.m6329constructorimpl(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x002b
        L_0x0020:
            r1 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r1 = kotlin.Result.m6329constructorimpl(r1)
        L_0x002b:
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            boolean r5 = kotlin.Result.m6335isFailureimpl(r1)
            if (r5 == 0) goto L_0x0034
            r1 = r4
        L_0x0034:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x003e
            r1 = r2
            goto L_0x003f
        L_0x003e:
            r1 = r3
        L_0x003f:
            if (r0 == 0) goto L_0x0051
            java.lang.Integer r4 = r10.getUsageLimit()
            if (r4 != 0) goto L_0x0048
            goto L_0x004f
        L_0x0048:
            int r4 = r4.intValue()
            if (r4 != 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r4 = r3
            goto L_0x0052
        L_0x0051:
            r4 = r2
        L_0x0052:
            boolean r5 = r10 instanceof com.talabat.darkstores.feature.product.models.ProductCampaign.Free.SameItemDiscount
            java.lang.Integer r6 = r10.getUsageLimit()
            if (r6 == 0) goto L_0x0068
            int r6 = r6.intValue()
            if (r9 < r6) goto L_0x0062
            r6 = r2
            goto L_0x0063
        L_0x0062:
            r6 = r3
        L_0x0063:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            goto L_0x0069
        L_0x0068:
            r6 = 0
        L_0x0069:
            boolean r6 = com.talabat.talabatcommon.extentions.BooleanKt.orFalse((java.lang.Boolean) r6)
            int r0 = r0 * r9
            if (r0 < r8) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r2 = r3
        L_0x0072:
            if (r4 != 0) goto L_0x0097
            if (r8 == 0) goto L_0x0097
            if (r5 == 0) goto L_0x0079
            goto L_0x0097
        L_0x0079:
            if (r1 == 0) goto L_0x0087
            com.talabat.darkstores.feature.product.views.CampaignProgressState$CanAddProduct r8 = new com.talabat.darkstores.feature.product.views.CampaignProgressState$CanAddProduct
            int r9 = r10.benefitCount()
            boolean r10 = r10 instanceof com.talabat.darkstores.feature.product.models.ProductCampaign.Free.MixAndMatchDiscount
            r8.<init>(r9, r10)
            goto L_0x0099
        L_0x0087:
            if (r6 != 0) goto L_0x0094
            if (r2 == 0) goto L_0x008c
            goto L_0x0094
        L_0x008c:
            com.talabat.darkstores.feature.product.views.CampaignProgressState$Added r9 = new com.talabat.darkstores.feature.product.views.CampaignProgressState$Added
            int r8 = r8 - r0
            r9.<init>(r8, r10)
            r8 = r9
            goto L_0x0099
        L_0x0094:
            com.talabat.darkstores.feature.product.views.CampaignProgressState$Fulfilled r8 = com.talabat.darkstores.feature.product.views.CampaignProgressState.Fulfilled.INSTANCE
            goto L_0x0099
        L_0x0097:
            com.talabat.darkstores.feature.product.views.CampaignProgressState$Hidden r8 = com.talabat.darkstores.feature.product.views.CampaignProgressState.Hidden.INSTANCE
        L_0x0099:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.product.views.CampaignProgressViewModel.m10054createStateMlP_i40(int, int, com.talabat.darkstores.feature.product.models.ProductCampaign$Free):com.talabat.darkstores.feature.product.views.CampaignProgressState");
    }

    @NotNull
    public final Observer<ProductCampaign.Free> getCampaignInfoObserver() {
        return this.campaignInfoObserver;
    }

    @NotNull
    public final Observer<Pair<CampaignAddedQuantity, CampaignFreeQuantity>> getQuantityChangedObserver() {
        return this.quantityChangedObserver;
    }

    public final Observable<CampaignProgressState> getStateObservable$com_talabat_NewArchi_darkstores_darkstores() {
        return this.stateObservable;
    }
}
