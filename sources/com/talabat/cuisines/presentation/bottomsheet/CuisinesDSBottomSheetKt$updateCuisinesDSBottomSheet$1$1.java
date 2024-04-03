package com.talabat.cuisines.presentation.bottomsheet;

import android.os.Bundle;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.cuisines.navigation.StartCuisineViewForResult;
import datamodels.Cuisine;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Instrumented
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisinesDSBottomSheetKt$updateCuisinesDSBottomSheet$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ StartCuisineViewForResult<Pair<Cuisine, String>> f56085g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSBottomSheet f56086h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Pair<Cuisine, String>> f56087i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisinesDSBottomSheetKt$updateCuisinesDSBottomSheet$1$1(StartCuisineViewForResult<Pair<Cuisine, String>> startCuisineViewForResult, DSBottomSheet dSBottomSheet, Ref.ObjectRef<Pair<Cuisine, String>> objectRef) {
        super(0);
        this.f56085g = startCuisineViewForResult;
        this.f56086h = dSBottomSheet;
        this.f56087i = objectRef;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m9628invoke$lambda0(Ref.ObjectRef objectRef, StartCuisineViewForResult startCuisineViewForResult, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(objectRef, "$successResult");
        Intrinsics.checkNotNullParameter(startCuisineViewForResult, "$callbacks");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("EXTRA_DS_BOTTOM_SHEET_CUISINE");
        objectRef.element = new Pair(GsonInstrumentation.fromJson(new Gson(), string, Cuisine.class), bundle.getString("EXTRA_DS_BOTTOM_SHEET_SHOP_CATEGORY"));
        startCuisineViewForResult.getOnSuccess$com_talabat_Components_cuisines_cuisines().invoke(objectRef.element);
    }

    public final void invoke() {
        this.f56085g.getOnStart$com_talabat_Components_cuisines_cuisines().invoke();
        this.f56086h.getChildFragmentManager().setFragmentResultListener("EXTRA_DS_BOTTOM_SHEET_SUCCESS", this.f56086h.getViewLifecycleOwner(), new a(this.f56087i, this.f56085g));
    }
}
