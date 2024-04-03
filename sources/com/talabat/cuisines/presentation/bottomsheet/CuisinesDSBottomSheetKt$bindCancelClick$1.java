package com.talabat.cuisines.presentation.bottomsheet;

import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisinesDSBottomSheetKt$bindCancelClick$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CuisinesDSBottomSheetBodyFragment f56076g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisinesDSBottomSheetKt$bindCancelClick$1(CuisinesDSBottomSheetBodyFragment cuisinesDSBottomSheetBodyFragment) {
        super(0);
        this.f56076g = cuisinesDSBottomSheetBodyFragment;
    }

    public final void invoke() {
        DSBottomSheet access$parent = CuisinesDSBottomSheetKt.parent(this.f56076g);
        if (access$parent != null) {
            access$parent.dismiss();
        }
    }
}
