package com.talabat.cuisines.presentation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.cuisines.domain.SelectableCuisine;
import datamodels.Cuisine;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0010\u0018\u00002\u00020\u0001B÷\u0001\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0011\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u0012\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0010\u001aR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001f\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&¨\u0006,"}, d2 = {"Lcom/talabat/cuisines/presentation/CuisinesViewModel;", "Landroidx/lifecycle/ViewModel;", "cuisines", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "progress", "", "showCuisinesWithPopular", "Lcom/talabat/cuisines/presentation/ItemContainer;", "errors", "", "selectCuisine", "Lkotlin/Function1;", "Ldatamodels/Cuisine;", "", "requestCuisinesUseCase", "Lkotlin/Function0;", "requestPopularUseCase", "showPopularCuisines", "applyLastSelection", "clearSelection", "shopCategorySelected", "", "clearUpAnalyticsSelectedCuisines", "updateAnalyticsCuisinesOnClick", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getApplyLastSelection", "()Lkotlin/jvm/functions/Function0;", "getClearSelection", "getClearUpAnalyticsSelectedCuisines", "getCuisines", "()Landroidx/lifecycle/MutableLiveData;", "getErrors", "getProgress", "getRequestCuisinesUseCase", "getRequestPopularUseCase", "getSelectCuisine", "()Lkotlin/jvm/functions/Function1;", "getShopCategorySelected", "getShowCuisinesWithPopular", "getShowPopularCuisines", "()Z", "getUpdateAnalyticsCuisinesOnClick", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CuisinesViewModel extends ViewModel {
    @NotNull
    private final Function0<Unit> applyLastSelection;
    @NotNull
    private final Function0<Unit> clearSelection;
    @NotNull
    private final Function0<Unit> clearUpAnalyticsSelectedCuisines;
    @NotNull
    private final MutableLiveData<List<SelectableCuisine>> cuisines;
    @NotNull
    private final MutableLiveData<Throwable> errors;
    @NotNull
    private final MutableLiveData<Boolean> progress;
    @NotNull
    private final Function0<List<SelectableCuisine>> requestCuisinesUseCase;
    @NotNull
    private final Function0<List<SelectableCuisine>> requestPopularUseCase;
    @NotNull
    private final Function1<Cuisine, Unit> selectCuisine;
    @NotNull
    private final Function0<String> shopCategorySelected;
    @NotNull
    private final MutableLiveData<List<ItemContainer>> showCuisinesWithPopular;
    private final boolean showPopularCuisines;
    @NotNull
    private final Function1<SelectableCuisine, Unit> updateAnalyticsCuisinesOnClick;

    public CuisinesViewModel() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (Function1) null, (Function0) null, (Function0) null, false, (Function0) null, (Function0) null, (Function0) null, (Function0) null, (Function1) null, 8191, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CuisinesViewModel(androidx.lifecycle.MutableLiveData r14, androidx.lifecycle.MutableLiveData r15, androidx.lifecycle.MutableLiveData r16, androidx.lifecycle.MutableLiveData r17, kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function0 r19, kotlin.jvm.functions.Function0 r20, boolean r21, kotlin.jvm.functions.Function0 r22, kotlin.jvm.functions.Function0 r23, kotlin.jvm.functions.Function0 r24, kotlin.jvm.functions.Function0 r25, kotlin.jvm.functions.Function1 r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r13 = this;
            r0 = r27
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x000d
        L_0x000c:
            r1 = r14
        L_0x000d:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0017
            androidx.lifecycle.MutableLiveData r2 = new androidx.lifecycle.MutableLiveData
            r2.<init>()
            goto L_0x0018
        L_0x0017:
            r2 = r15
        L_0x0018:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0022
            androidx.lifecycle.MutableLiveData r3 = new androidx.lifecycle.MutableLiveData
            r3.<init>()
            goto L_0x0024
        L_0x0022:
            r3 = r16
        L_0x0024:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x002e
            androidx.lifecycle.MutableLiveData r4 = new androidx.lifecycle.MutableLiveData
            r4.<init>()
            goto L_0x0030
        L_0x002e:
            r4 = r17
        L_0x0030:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0037
            com.talabat.cuisines.presentation.CuisinesViewModel$1 r5 = com.talabat.cuisines.presentation.CuisinesViewModel.AnonymousClass1.INSTANCE
            goto L_0x0039
        L_0x0037:
            r5 = r18
        L_0x0039:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0040
            com.talabat.cuisines.presentation.CuisinesViewModel$2 r6 = com.talabat.cuisines.presentation.CuisinesViewModel.AnonymousClass2.INSTANCE
            goto L_0x0042
        L_0x0040:
            r6 = r19
        L_0x0042:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0049
            com.talabat.cuisines.presentation.CuisinesViewModel$3 r7 = com.talabat.cuisines.presentation.CuisinesViewModel.AnonymousClass3.INSTANCE
            goto L_0x004b
        L_0x0049:
            r7 = r20
        L_0x004b:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0051
            r8 = 0
            goto L_0x0053
        L_0x0051:
            r8 = r21
        L_0x0053:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x005a
            com.talabat.cuisines.presentation.CuisinesViewModel$4 r9 = com.talabat.cuisines.presentation.CuisinesViewModel.AnonymousClass4.INSTANCE
            goto L_0x005c
        L_0x005a:
            r9 = r22
        L_0x005c:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x0063
            com.talabat.cuisines.presentation.CuisinesViewModel$5 r10 = com.talabat.cuisines.presentation.CuisinesViewModel.AnonymousClass5.INSTANCE
            goto L_0x0065
        L_0x0063:
            r10 = r23
        L_0x0065:
            r11 = r0 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x006c
            com.talabat.cuisines.presentation.CuisinesViewModel$6 r11 = com.talabat.cuisines.presentation.CuisinesViewModel.AnonymousClass6.INSTANCE
            goto L_0x006e
        L_0x006c:
            r11 = r24
        L_0x006e:
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0075
            com.talabat.cuisines.presentation.CuisinesViewModel$7 r12 = com.talabat.cuisines.presentation.CuisinesViewModel.AnonymousClass7.INSTANCE
            goto L_0x0077
        L_0x0075:
            r12 = r25
        L_0x0077:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x007e
            com.talabat.cuisines.presentation.CuisinesViewModel$8 r0 = com.talabat.cuisines.presentation.CuisinesViewModel.AnonymousClass8.INSTANCE
            goto L_0x0080
        L_0x007e:
            r0 = r26
        L_0x0080:
            r14 = r13
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.cuisines.presentation.CuisinesViewModel.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @NotNull
    public final Function0<Unit> getApplyLastSelection() {
        return this.applyLastSelection;
    }

    @NotNull
    public final Function0<Unit> getClearSelection() {
        return this.clearSelection;
    }

    @NotNull
    public final Function0<Unit> getClearUpAnalyticsSelectedCuisines() {
        return this.clearUpAnalyticsSelectedCuisines;
    }

    @NotNull
    public final MutableLiveData<List<SelectableCuisine>> getCuisines() {
        return this.cuisines;
    }

    @NotNull
    public final MutableLiveData<Throwable> getErrors() {
        return this.errors;
    }

    @NotNull
    public final MutableLiveData<Boolean> getProgress() {
        return this.progress;
    }

    @NotNull
    public final Function0<List<SelectableCuisine>> getRequestCuisinesUseCase() {
        return this.requestCuisinesUseCase;
    }

    @NotNull
    public final Function0<List<SelectableCuisine>> getRequestPopularUseCase() {
        return this.requestPopularUseCase;
    }

    @NotNull
    public final Function1<Cuisine, Unit> getSelectCuisine() {
        return this.selectCuisine;
    }

    @NotNull
    public final Function0<String> getShopCategorySelected() {
        return this.shopCategorySelected;
    }

    @NotNull
    public final MutableLiveData<List<ItemContainer>> getShowCuisinesWithPopular() {
        return this.showCuisinesWithPopular;
    }

    public final boolean getShowPopularCuisines() {
        return this.showPopularCuisines;
    }

    @NotNull
    public final Function1<SelectableCuisine, Unit> getUpdateAnalyticsCuisinesOnClick() {
        return this.updateAnalyticsCuisinesOnClick;
    }

    public CuisinesViewModel(@NotNull MutableLiveData<List<SelectableCuisine>> mutableLiveData, @NotNull MutableLiveData<Boolean> mutableLiveData2, @NotNull MutableLiveData<List<ItemContainer>> mutableLiveData3, @NotNull MutableLiveData<Throwable> mutableLiveData4, @NotNull Function1<? super Cuisine, Unit> function1, @NotNull Function0<? extends List<SelectableCuisine>> function0, @NotNull Function0<? extends List<SelectableCuisine>> function02, boolean z11, @NotNull Function0<Unit> function03, @NotNull Function0<Unit> function04, @NotNull Function0<String> function05, @NotNull Function0<Unit> function06, @NotNull Function1<? super SelectableCuisine, Unit> function12) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "cuisines");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "progress");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "showCuisinesWithPopular");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "errors");
        Intrinsics.checkNotNullParameter(function1, "selectCuisine");
        Intrinsics.checkNotNullParameter(function0, "requestCuisinesUseCase");
        Intrinsics.checkNotNullParameter(function02, "requestPopularUseCase");
        Intrinsics.checkNotNullParameter(function03, "applyLastSelection");
        Intrinsics.checkNotNullParameter(function04, "clearSelection");
        Intrinsics.checkNotNullParameter(function05, "shopCategorySelected");
        Intrinsics.checkNotNullParameter(function06, "clearUpAnalyticsSelectedCuisines");
        Intrinsics.checkNotNullParameter(function12, "updateAnalyticsCuisinesOnClick");
        this.cuisines = mutableLiveData;
        this.progress = mutableLiveData2;
        this.showCuisinesWithPopular = mutableLiveData3;
        this.errors = mutableLiveData4;
        this.selectCuisine = function1;
        this.requestCuisinesUseCase = function0;
        this.requestPopularUseCase = function02;
        this.showPopularCuisines = z11;
        this.applyLastSelection = function03;
        this.clearSelection = function04;
        this.shopCategorySelected = function05;
        this.clearUpAnalyticsSelectedCuisines = function06;
        this.updateAnalyticsCuisinesOnClick = function12;
        CuisinesViewModelKt.initialize(this);
    }
}
