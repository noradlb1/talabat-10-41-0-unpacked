package com.talabat.components.gem;

import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/adapters/presentation/GemEntryViewConfigurations;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemComponentRestaurantsListStrategy$startGemFlow$1$1 extends Lambda implements Function1<GemEntryViewConfigurations, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f55704g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemComponentRestaurantsListStrategy f55705h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RestaurantsListScreenRefactor f55706i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemComponentRestaurantsListStrategy$startGemFlow$1$1(boolean z11, GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy, RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        super(1);
        this.f55704g = z11;
        this.f55705h = gemComponentRestaurantsListStrategy;
        this.f55706i = restaurantsListScreenRefactor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemEntryViewConfigurations) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemEntryViewConfigurations gemEntryViewConfigurations) {
        Intrinsics.checkNotNullParameter(gemEntryViewConfigurations, "$this$invoke");
        gemEntryViewConfigurations.getWith().mode((!this.f55704g || !this.f55705h.isFoodVertical(this.f55706i)) ? GemMode.DISABLED : GemMode.ENABLED);
    }
}
