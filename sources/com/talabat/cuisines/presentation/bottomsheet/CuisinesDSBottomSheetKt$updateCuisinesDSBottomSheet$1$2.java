package com.talabat.cuisines.presentation.bottomsheet;

import androidx.fragment.app.Fragment;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.talabat.cuisines.navigation.StartCuisineViewForResult;
import datamodels.Cuisine;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisinesDSBottomSheetKt$updateCuisinesDSBottomSheet$1$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Pair<Cuisine, String>> f56088g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSBottomSheet f56089h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ StartCuisineViewForResult<Pair<Cuisine, String>> f56090i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f56091j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisinesDSBottomSheetKt$updateCuisinesDSBottomSheet$1$2(Ref.ObjectRef<Pair<Cuisine, String>> objectRef, DSBottomSheet dSBottomSheet, StartCuisineViewForResult<Pair<Cuisine, String>> startCuisineViewForResult, Function0<Unit> function0) {
        super(0);
        this.f56088g = objectRef;
        this.f56089h = dSBottomSheet;
        this.f56090i = startCuisineViewForResult;
        this.f56091j = function0;
    }

    public final void invoke() {
        if (this.f56088g.element == null) {
            Fragment body = this.f56089h.getBody();
            CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment = body instanceof CuisinesDSBottomSheetBodyFragment ? (CuisinesDSBottomSheetBodyFragment) body : null;
            if (cuisinesDSBottomSheetBodyFragment != null) {
                cuisinesDSBottomSheetBodyFragment.applyLastSelection();
            }
            this.f56090i.getOnCancelled$com_talabat_Components_cuisines_cuisines().invoke();
        }
        this.f56091j.invoke();
    }
}
