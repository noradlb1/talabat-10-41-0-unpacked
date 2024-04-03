package com.talabat.filters.navigation;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.navigation.FiltersView$updateBubbleVisibility$1$onResume$2", f = "FiltersView.kt", i = {}, l = {66, 72, 72}, m = "invokeSuspend", n = {}, s = {})
public final class FiltersView$updateBubbleVisibility$1$onResume$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f59570h;

    /* renamed from: i  reason: collision with root package name */
    public int f59571i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ View f59572j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ FiltersView f59573k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersView$updateBubbleVisibility$1$onResume$2(View view, FiltersView filtersView, Continuation<? super FiltersView$updateBubbleVisibility$1$onResume$2> continuation) {
        super(1, continuation);
        this.f59572j = view;
        this.f59573k = filtersView;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new FiltersView$updateBubbleVisibility$1$onResume$2(this.f59572j, this.f59573k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((FiltersView$updateBubbleVisibility$1$onResume$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c0  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.f59571i
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 == r4) goto L_0x002b
            if (r1 == r3) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            java.lang.Object r0 = r11.f59570h
            com.talabat.talabatcommon.views.counterpill.CounterPillTextView r0 = (com.talabat.talabatcommon.views.counterpill.CounterPillTextView) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00b4
        L_0x001a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0022:
            java.lang.Object r1 = r11.f59570h
            com.talabat.talabatcommon.views.counterpill.CounterPillTextView r1 = (com.talabat.talabatcommon.views.counterpill.CounterPillTextView) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x009a
        L_0x002b:
            java.lang.Object r1 = r11.f59570h
            com.talabat.talabatcommon.views.counterpill.CounterPillTextView r1 = (com.talabat.talabatcommon.views.counterpill.CounterPillTextView) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x005f
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r12)
            android.view.View r12 = r11.f59572j
            int r1 = com.talabat.filters.R.id.filtersViewLayout
            android.view.View r12 = r12.findViewById(r1)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            r12.setEnabled(r4)
            android.view.View r12 = r11.f59572j
            int r1 = com.talabat.filters.R.id.counterPill
            android.view.View r12 = r12.findViewById(r1)
            r1 = r12
            com.talabat.talabatcommon.views.counterpill.CounterPillTextView r1 = (com.talabat.talabatcommon.views.counterpill.CounterPillTextView) r1
            com.talabat.filters.navigation.FiltersView r12 = r11.f59573k
            kotlin.jvm.functions.Function1 r12 = r12.hasSelection
            r11.f59570h = r1
            r11.f59571i = r4
            java.lang.Object r12 = r12.invoke(r11)
            if (r12 != r0) goto L_0x005f
            return r0
        L_0x005f:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x0069
            r12 = 0
            goto L_0x006b
        L_0x0069:
            r12 = 8
        L_0x006b:
            r1.setVisibility(r12)
            com.talabat.core.experiment.data.TalabatExperiment r4 = com.talabat.core.experiment.data.TalabatExperiment.INSTANCE
            com.talabat.core.experiment.data.TalabatExperimentConstants r5 = com.talabat.core.experiment.data.TalabatExperimentConstants.COUNTERS_AND_NEW_DESIGN_FILTERS_CUISINES
            r6 = 0
            r7 = 0
            r8 = 4
            r9 = 0
            boolean r12 = com.talabat.core.experiment.domain.ITalabatExperiment.DefaultImpls.getBooleanVariant$default(r4, r5, r6, r7, r8, r9)
            if (r12 == 0) goto L_0x00c5
            android.view.View r12 = r11.f59572j
            int r1 = com.talabat.filters.R.id.counterPill
            android.view.View r12 = r12.findViewById(r1)
            com.talabat.talabatcommon.views.counterpill.CounterPillTextView r12 = (com.talabat.talabatcommon.views.counterpill.CounterPillTextView) r12
            com.talabat.filters.navigation.FiltersView r1 = r11.f59573k
            kotlin.jvm.functions.Function1 r1 = r1.filtersSelected
            r11.f59570h = r12
            r11.f59571i = r3
            java.lang.Object r1 = r1.invoke(r11)
            if (r1 != r0) goto L_0x0097
            return r0
        L_0x0097:
            r10 = r1
            r1 = r12
            r12 = r10
        L_0x009a:
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            if (r12 <= 0) goto L_0x00c0
            com.talabat.filters.navigation.FiltersView r12 = r11.f59573k
            kotlin.jvm.functions.Function1 r12 = r12.filtersSelected
            r11.f59570h = r1
            r11.f59571i = r2
            java.lang.Object r12 = r12.invoke(r11)
            if (r12 != r0) goto L_0x00b3
            return r0
        L_0x00b3:
            r0 = r1
        L_0x00b4:
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r1 = r0
            goto L_0x00c2
        L_0x00c0:
            java.lang.String r12 = ""
        L_0x00c2:
            r1.setText(r12)
        L_0x00c5:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.navigation.FiltersView$updateBubbleVisibility$1$onResume$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
