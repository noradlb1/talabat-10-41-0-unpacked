package com.talabat.components.gem;

import android.widget.LinearLayout;
import com.talabat.R;
import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import com.talabat.gem.adapters.presentation.GemSelectionCallbacks;
import com.talabat.gem.adapters.presentation.restaurants.GemFloatingView;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/adapters/presentation/GemEntryViewConfigurations;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemComponentRestaurantsListStrategy$initializeViews$1$1 extends Lambda implements Function1<GemEntryViewConfigurations, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemComponentRestaurantsListStrategy f55699g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListScreenRefactor f55700h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemComponentRestaurantsListStrategy$initializeViews$1$1(GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy, RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        super(1);
        this.f55699g = gemComponentRestaurantsListStrategy;
        this.f55700h = restaurantsListScreenRefactor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemEntryViewConfigurations) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemEntryViewConfigurations gemEntryViewConfigurations) {
        Intrinsics.checkNotNullParameter(gemEntryViewConfigurations, "$this$invoke");
        gemEntryViewConfigurations.getWith().mode(GemMode.DISABLED);
        GemSelectionCallbacks<GemRestaurant> on2 = gemEntryViewConfigurations.getOn();
        final GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = this.f55699g;
        on2.selected(new Function1<GemRestaurant, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemRestaurant) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GemRestaurant gemRestaurant) {
                Intrinsics.checkNotNullParameter(gemRestaurant, "it");
                Restaurant unused = gemComponentRestaurantsListStrategy.openRestaurant(gemRestaurant);
            }
        });
        GemSelectionCallbacks<GemRestaurant> on3 = gemEntryViewConfigurations.getOn();
        final RestaurantsListScreenRefactor restaurantsListScreenRefactor = this.f55700h;
        on3.cancelled(new Function0<Unit>() {
            public final void invoke() {
                restaurantsListScreenRefactor.refreshCartCount();
            }
        });
        GemSelectionCallbacks<GemRestaurant> on4 = gemEntryViewConfigurations.getOn();
        final RestaurantsListScreenRefactor restaurantsListScreenRefactor2 = this.f55700h;
        on4.enabled(new Function0<Unit>() {
            public final void invoke() {
                ((LinearLayout) restaurantsListScreenRefactor2.findViewById(R.id.linearLayout_gemFloating)).setVisibility(8);
                ((GemFloatingView) restaurantsListScreenRefactor2.findViewById(R.id.gemFloatingView)).setVisibility(0);
            }
        });
    }
}
