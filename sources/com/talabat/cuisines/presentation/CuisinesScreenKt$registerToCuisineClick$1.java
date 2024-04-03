package com.talabat.cuisines.presentation;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "intent", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisinesScreenKt$registerToCuisineClick$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CuisinesFragmentMultipleSelection f56062g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CuisinesViewModel f56063h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f56064i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisinesScreenKt$registerToCuisineClick$1(CuisinesFragmentMultipleSelection cuisinesFragmentMultipleSelection, CuisinesViewModel cuisinesViewModel, boolean z11) {
        super(1);
        this.f56062g = cuisinesFragmentMultipleSelection;
        this.f56063h = cuisinesViewModel;
        this.f56064i = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable android.content.Intent r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x005c
            java.lang.String r0 = "EXTRA_CUISINE"
            java.io.Serializable r7 = r7.getSerializableExtra(r0)
            if (r7 == 0) goto L_0x005c
            boolean r1 = r7 instanceof com.talabat.cuisines.domain.SelectableCuisine
            r2 = 0
            if (r1 == 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r7 = r2
        L_0x0011:
            if (r7 == 0) goto L_0x005c
            com.talabat.cuisines.domain.SelectableCuisine r7 = (com.talabat.cuisines.domain.SelectableCuisine) r7
            com.talabat.cuisines.presentation.CuisinesViewModel r1 = r6.f56063h
            com.talabat.cuisines.presentation.CuisinesViewModelKt.selectMultipleCuisines(r1, r7)
            com.talabat.cuisines.presentation.CuisinesFragmentMultipleSelection r1 = r6.f56062g
            com.talabat.cuisines.presentation.CuisinesViewModel r3 = r6.f56063h
            boolean r4 = r6.f56064i
            boolean r5 = r7.isOn()
            if (r5 == 0) goto L_0x0037
            android.content.Context r1 = r1.getContext()
            kotlin.jvm.functions.Function0 r3 = r3.getShopCategorySelected()
            java.lang.Object r3 = r3.invoke()
            java.lang.String r3 = (java.lang.String) r3
            tracking.AppTracker.onRestaurantsCuisineSelection(r1, r3, r4)
        L_0x0037:
            datamodels.Cuisine r7 = r7.getCuisine()
            if (r7 == 0) goto L_0x005c
            r1 = 1
            java.lang.String r7 = com.talabat.talabatcommon.extentions.GsonKt.toJson$default(r7, r2, r1, r2)
            if (r7 == 0) goto L_0x005c
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            android.content.Intent r7 = r1.putExtra(r0, r7)
            if (r7 == 0) goto L_0x005c
            com.talabat.cuisines.presentation.CuisinesFragmentMultipleSelection r0 = r6.f56062g
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            if (r0 == 0) goto L_0x0068
            r1 = -1
            r0.setResult(r1, r7)
            goto L_0x0068
        L_0x005c:
            com.talabat.cuisines.presentation.CuisinesFragmentMultipleSelection r7 = r6.f56062g
            androidx.fragment.app.FragmentActivity r7 = r7.getActivity()
            if (r7 == 0) goto L_0x0068
            r0 = 0
            r7.setResult(r0)
        L_0x0068:
            com.talabat.cuisines.presentation.CuisinesFragmentMultipleSelection r7 = r6.f56062g
            int r0 = com.talabat.cuisines.R.id.cuisineRecyclerView
            android.view.View r7 = r7._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            androidx.recyclerview.widget.RecyclerView$Adapter r7 = r7.getAdapter()
            if (r7 == 0) goto L_0x00a7
            com.talabat.cuisines.presentation.CuisinesAdapter r7 = (com.talabat.cuisines.presentation.CuisinesAdapter) r7
            android.widget.Filter r7 = r7.getFilter()
            com.talabat.cuisines.presentation.CuisinesFragmentMultipleSelection r0 = r6.f56062g
            int r1 = com.talabat.cuisines.R.id.searchEdt
            android.view.View r0 = r0._$_findCachedViewById(r1)
            android.widget.EditText r0 = (android.widget.EditText) r0
            android.text.Editable r0 = r0.getText()
            r7.filter(r0)
            com.talabat.cuisines.presentation.CuisinesFragmentMultipleSelection r7 = r6.f56062g
            android.content.Context r7 = r7.getContext()
            com.talabat.cuisines.presentation.CuisinesViewModel r0 = r6.f56063h
            kotlin.jvm.functions.Function0 r0 = r0.getShopCategorySelected()
            java.lang.Object r0 = r0.invoke()
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = r6.f56064i
            tracking.AppTracker.onRestaurantsCuisineSelection(r7, r0, r1)
            return
        L_0x00a7:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type com.talabat.cuisines.presentation.CuisinesAdapter"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.cuisines.presentation.CuisinesScreenKt$registerToCuisineClick$1.invoke(android.content.Intent):void");
    }
}
