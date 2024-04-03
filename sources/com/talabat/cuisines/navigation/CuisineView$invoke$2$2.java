package com.talabat.cuisines.navigation;

import datamodels.Cuisine;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Ldatamodels/Cuisine;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisineView$invoke$2$2 extends Lambda implements Function1<Pair<? extends Cuisine, ? extends String>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CuisineView f56036g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisineView$invoke$2$2(CuisineView cuisineView) {
        super(1);
        this.f56036g = cuisineView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<? extends Cuisine, String>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Pair<? extends Cuisine, String> pair) {
        StartCuisineViewForResult access$getStartCuisineViewForResult$p = this.f56036g.startCuisineViewForResult;
        if (access$getStartCuisineViewForResult$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startCuisineViewForResult");
            access$getStartCuisineViewForResult$p = null;
        }
        access$getStartCuisineViewForResult$p.getOnSuccess$com_talabat_Components_cuisines_cuisines().invoke(pair);
    }
}
