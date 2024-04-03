package com.talabat.gem.adapters.presentation.collections.list;

import com.talabat.core.navigation.domain.screen.gem.GemCollectionEntrypoint;
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
public final class GemCollectionActivity$initialize$1$8 extends Lambda implements Function1<List<? extends Pair<? extends Integer, ? extends GemRestaurant>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemCollectionEntrypoint f60049g;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GemCollectionEntrypoint.values().length];
            iArr[GemCollectionEntrypoint.HOME.ordinal()] = 1;
            iArr[GemCollectionEntrypoint.FOOD_LIST.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCollectionActivity$initialize$1$8(GemCollectionEntrypoint gemCollectionEntrypoint) {
        super(1);
        this.f60049g = gemCollectionEntrypoint;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<Pair<Integer, GemRestaurant>>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull List<Pair<Integer, GemRestaurant>> list) {
        Intrinsics.checkNotNullParameter(list, "scrollingList");
        GemCollectionEntrypoint gemCollectionEntrypoint = this.f60049g;
        int i11 = gemCollectionEntrypoint == null ? -1 : WhenMappings.$EnumSwitchMapping$0[gemCollectionEntrypoint.ordinal()];
        String str = i11 != 1 ? i11 != 2 ? "" : "shop_list" : "home";
        AnalyticsPort analytics = IntegrationKt.getAnalytics();
        Iterable<Pair> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Pair pair : iterable) {
            arrayList.add(GemRestaurantKt.toImpressionProperties((GemRestaurant) pair.getSecond(), ((Number) pair.getFirst()).intValue()));
        }
        analytics.onGemJokerImpressionTriggered(arrayList, "Restaurant List Screen", str);
    }
}
