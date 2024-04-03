package com.talabat.gem.adapters.presentation.offer;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.GemRestaurantKt;
import com.talabat.gem.ports.analytics.AnalyticsPort;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "scrollingList", "", "Lkotlin/Pair;", "", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemOfferActivity$initialize$1$8 extends Lambda implements Function1<List<? extends Pair<? extends Integer, ? extends GemRestaurant>>, Unit> {
    public static final GemOfferActivity$initialize$1$8 INSTANCE = new GemOfferActivity$initialize$1$8();

    public GemOfferActivity$initialize$1$8() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<Pair<Integer, GemRestaurant>>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull List<Pair<Integer, GemRestaurant>> list) {
        Intrinsics.checkNotNullParameter(list, "scrollingList");
        AnalyticsPort analytics = IntegrationKt.getAnalytics();
        Iterable<Pair> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Pair pair : iterable) {
            arrayList.add(GemRestaurantKt.toImpressionProperties((GemRestaurant) pair.getSecond(), ((Number) pair.getFirst()).intValue()));
        }
        analytics.onGemJokerImpressionTriggered(arrayList, "Restaurant List Screen", "shop_list");
    }
}
