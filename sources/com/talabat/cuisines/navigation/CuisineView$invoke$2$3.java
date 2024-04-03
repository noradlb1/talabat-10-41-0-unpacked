package com.talabat.cuisines.navigation;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisineView$invoke$2$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CuisineView f56037g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisineView$invoke$2$3(CuisineView cuisineView) {
        super(0);
        this.f56037g = cuisineView;
    }

    public final void invoke() {
        StartCuisineViewForResult access$getStartCuisineViewForResult$p = this.f56037g.startCuisineViewForResult;
        if (access$getStartCuisineViewForResult$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startCuisineViewForResult");
            access$getStartCuisineViewForResult$p = null;
        }
        access$getStartCuisineViewForResult$p.getOnCancelled$com_talabat_Components_cuisines_cuisines().invoke();
    }
}
