package com.talabat.cuisines.presentation.bottomsheet;

import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;
import com.talabat.cuisines.navigation.StartCuisineViewForResult;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class a implements FragmentResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f56093a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StartCuisineViewForResult f56094b;

    public /* synthetic */ a(Ref.ObjectRef objectRef, StartCuisineViewForResult startCuisineViewForResult) {
        this.f56093a = objectRef;
        this.f56094b = startCuisineViewForResult;
    }

    public final void onFragmentResult(String str, Bundle bundle) {
        CuisinesDSBottomSheetKt$updateCuisinesDSBottomSheet$1$1.m9628invoke$lambda0(this.f56093a, this.f56094b, str, bundle);
    }
}
