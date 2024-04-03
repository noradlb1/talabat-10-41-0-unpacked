package com.talabat.gem.samples;

import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import com.talabat.gem.adapters.presentation.GemSelectionCallbacks;
import com.talabat.gem.domain.entities.GemRestaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/adapters/presentation/GemEntryViewConfigurations;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeAdapter$onCreateViewHolder$1 extends Lambda implements Function1<GemEntryViewConfigurations, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeAdapter f60482g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeAdapter$onCreateViewHolder$1(HomeAdapter homeAdapter) {
        super(1);
        this.f60482g = homeAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemEntryViewConfigurations) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemEntryViewConfigurations gemEntryViewConfigurations) {
        Intrinsics.checkNotNullParameter(gemEntryViewConfigurations, "$this$GemSwimlanesViewHolder");
        GemSelectionCallbacks<GemRestaurant> on2 = gemEntryViewConfigurations.getOn();
        final HomeAdapter homeAdapter = this.f60482g;
        on2.selected(new Function1<GemRestaurant, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemRestaurant) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GemRestaurant gemRestaurant) {
                Intrinsics.checkNotNullParameter(gemRestaurant, "selection");
                Integer id2 = gemRestaurant.getId();
                if (id2 != null) {
                    HomeAdapter homeAdapter = homeAdapter;
                    RouterKt.navigate$default(homeAdapter.activity, Reflection.getOrCreateKotlinClass(SampleGemMenuActivity.class), id2.intValue(), 0.0d, 4, (Object) null);
                }
            }
        });
    }
}
