package com.talabat.feature.pickup.presentation;

import com.talabat.cuisines.navigation.StartCuisineViewForResult;
import datamodels.Cuisine;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001*\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/talabat/cuisines/navigation/StartCuisineViewForResult;", "Lkotlin/Pair;", "Ldatamodels/Cuisine;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PickupActivity$initFiltersAndCuisines$1 extends Lambda implements Function1<StartCuisineViewForResult<Pair<? extends Cuisine, ? extends String>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PickupActivity f58641g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupActivity$initFiltersAndCuisines$1(PickupActivity pickupActivity) {
        super(1);
        this.f58641g = pickupActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StartCuisineViewForResult<Pair<Cuisine, String>>) (StartCuisineViewForResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull StartCuisineViewForResult<Pair<Cuisine, String>> startCuisineViewForResult) {
        Intrinsics.checkNotNullParameter(startCuisineViewForResult, "$this$invoke");
        StartCuisineViewForResult<Pair<Cuisine, String>> on2 = startCuisineViewForResult.getOn();
        final PickupActivity pickupActivity = this.f58641g;
        on2.success(new Function1<Pair<? extends Cuisine, ? extends String>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair<? extends Cuisine, String>) (Pair) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Pair<? extends Cuisine, String> pair) {
                pickupActivity.loadPickupVendors();
            }
        });
    }
}
