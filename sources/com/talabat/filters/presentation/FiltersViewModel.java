package com.talabat.filters.presentation;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.facebook.share.internal.ShareConstants;
import datamodels.filters.SelectableFilter;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.Selectables;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0010\u0018\u00002\u00020\u0001B¢\u0004\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0003\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0003\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0003\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u001e\b\u0002\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015\u0012.\b\u0002\u0010\u0019\u001a(\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\u001b0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001a\u00123\b\u0002\u0010\u001c\u001a-\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u001d0\u001a¢\u0006\u0002\b\u001f\u00123\b\u0002\u0010 \u001a-\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\t0\u0006j\u0002`!\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\t0\u0006j\u0002`!0\u001a¢\u0006\u0002\b\u001f\u00122\b\u0002\u0010\"\u001a,\b\u0001\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006j\u0004\u0018\u0001`\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001a\u0012\u001e\b\u0002\u0010$\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015\u00122\b\u0002\u0010%\u001a,\b\u0001\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001a\u0012\u001e\b\u0002\u0010&\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015\u0012\u001e\b\u0002\u0010'\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015ø\u0001\u0000¢\u0006\u0002\u0010(R#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*R,\u0010'\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015ø\u0001\u0000¢\u0006\n\n\u0002\u00101\u001a\u0004\b'\u00100R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010*R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010*R,\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015ø\u0001\u0000¢\u0006\n\n\u0002\u00101\u001a\u0004\b4\u00100R,\u0010&\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015ø\u0001\u0000¢\u0006\n\n\u0002\u00101\u001a\u0004\b5\u00100R,\u0010$\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015ø\u0001\u0000¢\u0006\n\n\u0002\u00101\u001a\u0004\b6\u00100R@\u0010%\u001a,\b\u0001\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001aø\u0001\u0000¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R@\u0010\"\u001a,\b\u0001\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006j\u0004\u0018\u0001`\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001aø\u0001\u0000¢\u0006\n\n\u0002\u00109\u001a\u0004\b:\u00108R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010*R<\u0010\u001c\u001a-\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u001d0\u001a¢\u0006\u0002\b\u001f¢\u0006\b\n\u0000\u001a\u0004\b<\u00108R<\u0010 \u001a-\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\t0\u0006j\u0002`!\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\t0\u0006j\u0002`!0\u001a¢\u0006\u0002\b\u001f¢\u0006\b\n\u0000\u001a\u0004\b=\u00108R<\u0010\u0019\u001a(\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\u001b0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001aø\u0001\u0000¢\u0006\n\n\u0002\u00109\u001a\u0004\b>\u00108\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lcom/talabat/filters/presentation/FiltersViewModel;", "Landroidx/lifecycle/ViewModel;", "progressing", "Landroidx/lifecycle/MutableLiveData;", "", "filters", "", "Ldatamodels/filters/SelectableFilter;", "popularFilters", "Ldatamodels/filters/SelectablePopularFilter;", "sorts", "Ldatamodels/filters/SelectableSortType;", "analyticsClick", "Lkotlin/Pair;", "", "buttonsContainerVisibility", "errors", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "requestSelectablesUseCase", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Ldatamodels/filters/Selectables;", "", "updateSelectedSortUseCase", "Lkotlin/Function2;", "Ldatamodels/SelectableSortTypes;", "updateSelectedFiltersUseCase", "Ldatamodels/SelectableFilters;", "", "Lkotlin/ExtensionFunctionType;", "updateSelectedPopularFiltersUseCase", "Ldatamodels/SelectablePopularFilters;", "saveSelectedSortTypeUseCase", "", "resetSelectedSortTypeUseCase", "saveSelectedFiltersUseCase", "resetSelectedFiltersUseCase", "isFilterOrSortSelectedUseCase", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAnalyticsClick", "()Landroidx/lifecycle/MutableLiveData;", "getButtonsContainerVisibility", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getErrors", "getFilters", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "getPopularFilters", "getProgressing", "getRequestSelectablesUseCase", "getResetSelectedFiltersUseCase", "getResetSelectedSortTypeUseCase", "getSaveSelectedFiltersUseCase", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getSaveSelectedSortTypeUseCase", "getSorts", "getUpdateSelectedFiltersUseCase", "getUpdateSelectedPopularFiltersUseCase", "getUpdateSelectedSortUseCase", "com_talabat_Components_filters_filters"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FiltersViewModel extends ViewModel {
    @NotNull
    private final MutableLiveData<Pair<String, String>> analyticsClick;
    @NotNull
    private final MutableLiveData<Boolean> buttonsContainerVisibility;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    @NotNull
    private final MutableLiveData<Throwable> errors;
    @NotNull
    private final MutableLiveData<List<SelectableFilter>> filters;
    @NotNull
    private final Function1<Continuation<? super Boolean>, Object> isFilterOrSortSelectedUseCase;
    @NotNull
    private final MutableLiveData<List<SelectablePopularFilter>> popularFilters;
    @NotNull
    private final MutableLiveData<Boolean> progressing;
    @NotNull
    private final Function1<Continuation<? super Selectables>, Object> requestSelectablesUseCase;
    @NotNull
    private final Function1<Continuation<? super Unit>, Object> resetSelectedFiltersUseCase;
    @NotNull
    private final Function1<Continuation<? super Unit>, Object> resetSelectedSortTypeUseCase;
    @NotNull
    private final Function2<List<SelectableFilter>, Continuation<? super Unit>, Object> saveSelectedFiltersUseCase;
    @NotNull
    private final Function2<List<SelectableSortType>, Continuation<? super Unit>, Object> saveSelectedSortTypeUseCase;
    @NotNull
    private final MutableLiveData<List<SelectableSortType>> sorts;
    @NotNull
    private final Function2<List<SelectableFilter>, Integer, List<SelectableFilter>> updateSelectedFiltersUseCase;
    @NotNull
    private final Function2<List<SelectablePopularFilter>, SelectablePopularFilter, List<SelectablePopularFilter>> updateSelectedPopularFiltersUseCase;
    @NotNull
    private final Function2<SelectableSortType, Continuation<? super List<SelectableSortType>>, Object> updateSelectedSortUseCase;

    public FiltersViewModel() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (CoroutineDispatcher) null, (Function1) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function1) null, (Function2) null, (Function1) null, (Function1) null, 131071, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FiltersViewModel(androidx.lifecycle.MutableLiveData r19, androidx.lifecycle.MutableLiveData r20, androidx.lifecycle.MutableLiveData r21, androidx.lifecycle.MutableLiveData r22, androidx.lifecycle.MutableLiveData r23, androidx.lifecycle.MutableLiveData r24, androidx.lifecycle.MutableLiveData r25, kotlinx.coroutines.CoroutineDispatcher r26, kotlin.jvm.functions.Function1 r27, kotlin.jvm.functions.Function2 r28, kotlin.jvm.functions.Function2 r29, kotlin.jvm.functions.Function2 r30, kotlin.jvm.functions.Function2 r31, kotlin.jvm.functions.Function1 r32, kotlin.jvm.functions.Function2 r33, kotlin.jvm.functions.Function1 r34, kotlin.jvm.functions.Function1 r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x000e
        L_0x000c:
            r1 = r19
        L_0x000e:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0018
            androidx.lifecycle.MutableLiveData r2 = new androidx.lifecycle.MutableLiveData
            r2.<init>()
            goto L_0x001a
        L_0x0018:
            r2 = r20
        L_0x001a:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0024
            androidx.lifecycle.MutableLiveData r3 = new androidx.lifecycle.MutableLiveData
            r3.<init>()
            goto L_0x0026
        L_0x0024:
            r3 = r21
        L_0x0026:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0030
            androidx.lifecycle.MutableLiveData r4 = new androidx.lifecycle.MutableLiveData
            r4.<init>()
            goto L_0x0032
        L_0x0030:
            r4 = r22
        L_0x0032:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x003c
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
            goto L_0x003e
        L_0x003c:
            r5 = r23
        L_0x003e:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0048
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
            goto L_0x004a
        L_0x0048:
            r6 = r24
        L_0x004a:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0054
            androidx.lifecycle.MutableLiveData r7 = new androidx.lifecycle.MutableLiveData
            r7.<init>()
            goto L_0x0056
        L_0x0054:
            r7 = r25
        L_0x0056:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x005f
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
            goto L_0x0061
        L_0x005f:
            r8 = r26
        L_0x0061:
            r9 = r0 & 256(0x100, float:3.59E-43)
            r10 = 0
            if (r9 == 0) goto L_0x006c
            com.talabat.filters.presentation.FiltersViewModel$1 r9 = new com.talabat.filters.presentation.FiltersViewModel$1
            r9.<init>(r10)
            goto L_0x006e
        L_0x006c:
            r9 = r27
        L_0x006e:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0078
            com.talabat.filters.presentation.FiltersViewModel$2 r11 = new com.talabat.filters.presentation.FiltersViewModel$2
            r11.<init>(r10)
            goto L_0x007a
        L_0x0078:
            r11 = r28
        L_0x007a:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0081
            com.talabat.filters.presentation.FiltersViewModel$3 r12 = com.talabat.filters.presentation.FiltersViewModel.AnonymousClass3.INSTANCE
            goto L_0x0083
        L_0x0081:
            r12 = r29
        L_0x0083:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x008a
            com.talabat.filters.presentation.FiltersViewModel$4 r13 = com.talabat.filters.presentation.FiltersViewModel.AnonymousClass4.INSTANCE
            goto L_0x008c
        L_0x008a:
            r13 = r30
        L_0x008c:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0096
            com.talabat.filters.presentation.FiltersViewModel$5 r14 = new com.talabat.filters.presentation.FiltersViewModel$5
            r14.<init>(r10)
            goto L_0x0098
        L_0x0096:
            r14 = r31
        L_0x0098:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x00a2
            com.talabat.filters.presentation.FiltersViewModel$6 r15 = new com.talabat.filters.presentation.FiltersViewModel$6
            r15.<init>(r10)
            goto L_0x00a4
        L_0x00a2:
            r15 = r32
        L_0x00a4:
            r10 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r10 == 0) goto L_0x00b1
            com.talabat.filters.presentation.FiltersViewModel$7 r10 = new com.talabat.filters.presentation.FiltersViewModel$7
            r37 = r15
            r15 = 0
            r10.<init>(r15)
            goto L_0x00b6
        L_0x00b1:
            r37 = r15
            r15 = 0
            r10 = r33
        L_0x00b6:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00c5
            r16 = r10
            com.talabat.filters.presentation.FiltersViewModel$8 r10 = new com.talabat.filters.presentation.FiltersViewModel$8
            r10.<init>(r15)
            goto L_0x00c9
        L_0x00c5:
            r16 = r10
            r10 = r34
        L_0x00c9:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x00d5
            com.talabat.filters.presentation.FiltersViewModel$9 r0 = new com.talabat.filters.presentation.FiltersViewModel$9
            r0.<init>(r15)
            goto L_0x00d7
        L_0x00d5:
            r0 = r35
        L_0x00d7:
            r19 = r18
            r20 = r1
            r21 = r2
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r37
            r34 = r16
            r35 = r10
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.presentation.FiltersViewModel.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, kotlinx.coroutines.CoroutineDispatcher, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @NotNull
    public final MutableLiveData<Pair<String, String>> getAnalyticsClick() {
        return this.analyticsClick;
    }

    @NotNull
    public final MutableLiveData<Boolean> getButtonsContainerVisibility() {
        return this.buttonsContainerVisibility;
    }

    @NotNull
    public final CoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    @NotNull
    public final MutableLiveData<Throwable> getErrors() {
        return this.errors;
    }

    @NotNull
    public final MutableLiveData<List<SelectableFilter>> getFilters() {
        return this.filters;
    }

    @NotNull
    public final MutableLiveData<List<SelectablePopularFilter>> getPopularFilters() {
        return this.popularFilters;
    }

    @NotNull
    public final MutableLiveData<Boolean> getProgressing() {
        return this.progressing;
    }

    @NotNull
    public final Function1<Continuation<? super Selectables>, Object> getRequestSelectablesUseCase() {
        return this.requestSelectablesUseCase;
    }

    @NotNull
    public final Function1<Continuation<? super Unit>, Object> getResetSelectedFiltersUseCase() {
        return this.resetSelectedFiltersUseCase;
    }

    @NotNull
    public final Function1<Continuation<? super Unit>, Object> getResetSelectedSortTypeUseCase() {
        return this.resetSelectedSortTypeUseCase;
    }

    @NotNull
    public final Function2<List<SelectableFilter>, Continuation<? super Unit>, Object> getSaveSelectedFiltersUseCase() {
        return this.saveSelectedFiltersUseCase;
    }

    @NotNull
    public final Function2<List<SelectableSortType>, Continuation<? super Unit>, Object> getSaveSelectedSortTypeUseCase() {
        return this.saveSelectedSortTypeUseCase;
    }

    @NotNull
    public final MutableLiveData<List<SelectableSortType>> getSorts() {
        return this.sorts;
    }

    @NotNull
    public final Function2<List<SelectableFilter>, Integer, List<SelectableFilter>> getUpdateSelectedFiltersUseCase() {
        return this.updateSelectedFiltersUseCase;
    }

    @NotNull
    public final Function2<List<SelectablePopularFilter>, SelectablePopularFilter, List<SelectablePopularFilter>> getUpdateSelectedPopularFiltersUseCase() {
        return this.updateSelectedPopularFiltersUseCase;
    }

    @NotNull
    public final Function2<SelectableSortType, Continuation<? super List<SelectableSortType>>, Object> getUpdateSelectedSortUseCase() {
        return this.updateSelectedSortUseCase;
    }

    @NotNull
    public final Function1<Continuation<? super Boolean>, Object> isFilterOrSortSelectedUseCase() {
        return this.isFilterOrSortSelectedUseCase;
    }

    public FiltersViewModel(@NotNull MutableLiveData<Boolean> mutableLiveData, @NotNull MutableLiveData<List<SelectableFilter>> mutableLiveData2, @NotNull MutableLiveData<List<SelectablePopularFilter>> mutableLiveData3, @NotNull MutableLiveData<List<SelectableSortType>> mutableLiveData4, @NotNull MutableLiveData<Pair<String, String>> mutableLiveData5, @NotNull MutableLiveData<Boolean> mutableLiveData6, @NotNull MutableLiveData<Throwable> mutableLiveData7, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function1<? super Continuation<? super Selectables>, ? extends Object> function1, @NotNull Function2<? super SelectableSortType, ? super Continuation<? super List<SelectableSortType>>, ? extends Object> function2, @NotNull Function2<? super List<SelectableFilter>, ? super Integer, ? extends List<SelectableFilter>> function22, @NotNull Function2<? super List<SelectablePopularFilter>, ? super SelectablePopularFilter, ? extends List<SelectablePopularFilter>> function23, @NotNull Function2<? super List<SelectableSortType>, ? super Continuation<? super Unit>, ? extends Object> function24, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function12, @NotNull Function2<? super List<SelectableFilter>, ? super Continuation<? super Unit>, ? extends Object> function25, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function13, @NotNull Function1<? super Continuation<? super Boolean>, ? extends Object> function14) {
        MutableLiveData<Boolean> mutableLiveData8 = mutableLiveData;
        MutableLiveData<List<SelectableFilter>> mutableLiveData9 = mutableLiveData2;
        MutableLiveData<List<SelectablePopularFilter>> mutableLiveData10 = mutableLiveData3;
        MutableLiveData<List<SelectableSortType>> mutableLiveData11 = mutableLiveData4;
        MutableLiveData<Pair<String, String>> mutableLiveData12 = mutableLiveData5;
        MutableLiveData<Boolean> mutableLiveData13 = mutableLiveData6;
        MutableLiveData<Throwable> mutableLiveData14 = mutableLiveData7;
        CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcher;
        Function1<? super Continuation<? super Selectables>, ? extends Object> function15 = function1;
        Function2<? super SelectableSortType, ? super Continuation<? super List<SelectableSortType>>, ? extends Object> function26 = function2;
        Function2<? super List<SelectableFilter>, ? super Integer, ? extends List<SelectableFilter>> function27 = function22;
        Function2<? super List<SelectablePopularFilter>, ? super SelectablePopularFilter, ? extends List<SelectablePopularFilter>> function28 = function23;
        Function2<? super List<SelectableSortType>, ? super Continuation<? super Unit>, ? extends Object> function29 = function24;
        Function1<? super Continuation<? super Unit>, ? extends Object> function16 = function12;
        Function1<? super Continuation<? super Unit>, ? extends Object> function17 = function13;
        Intrinsics.checkNotNullParameter(mutableLiveData8, "progressing");
        Intrinsics.checkNotNullParameter(mutableLiveData9, ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        Intrinsics.checkNotNullParameter(mutableLiveData10, "popularFilters");
        Intrinsics.checkNotNullParameter(mutableLiveData11, "sorts");
        Intrinsics.checkNotNullParameter(mutableLiveData12, "analyticsClick");
        Intrinsics.checkNotNullParameter(mutableLiveData13, "buttonsContainerVisibility");
        Intrinsics.checkNotNullParameter(mutableLiveData14, "errors");
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "dispatcher");
        Intrinsics.checkNotNullParameter(function15, "requestSelectablesUseCase");
        Intrinsics.checkNotNullParameter(function26, "updateSelectedSortUseCase");
        Intrinsics.checkNotNullParameter(function27, "updateSelectedFiltersUseCase");
        Intrinsics.checkNotNullParameter(function28, "updateSelectedPopularFiltersUseCase");
        Intrinsics.checkNotNullParameter(function29, "saveSelectedSortTypeUseCase");
        Intrinsics.checkNotNullParameter(function16, "resetSelectedSortTypeUseCase");
        Intrinsics.checkNotNullParameter(function25, "saveSelectedFiltersUseCase");
        Intrinsics.checkNotNullParameter(function13, "resetSelectedFiltersUseCase");
        Intrinsics.checkNotNullParameter(function14, "isFilterOrSortSelectedUseCase");
        this.progressing = mutableLiveData8;
        this.filters = mutableLiveData9;
        this.popularFilters = mutableLiveData10;
        this.sorts = mutableLiveData11;
        this.analyticsClick = mutableLiveData12;
        this.buttonsContainerVisibility = mutableLiveData13;
        this.errors = mutableLiveData14;
        this.dispatcher = coroutineDispatcher2;
        this.requestSelectablesUseCase = function15;
        this.updateSelectedSortUseCase = function26;
        this.updateSelectedFiltersUseCase = function27;
        this.updateSelectedPopularFiltersUseCase = function28;
        this.saveSelectedSortTypeUseCase = function29;
        this.resetSelectedSortTypeUseCase = function16;
        this.saveSelectedFiltersUseCase = function25;
        this.resetSelectedFiltersUseCase = function13;
        this.isFilterOrSortSelectedUseCase = function14;
        FiltersViewModelKt.initialize(this);
    }
}
