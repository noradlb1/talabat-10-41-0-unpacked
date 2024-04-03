package com.talabat.gem.adapters.analytics;

import com.talabat.gem.domain.entities.GemRestaurant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"NO_AMOUNT", "", "generateShopIds", "", "restaurants", "", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "Lcom/talabat/gem/domain/entities/GemRestaurants;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemAnalyticsKt {
    public static final double NO_AMOUNT = 0.0d;

    @NotNull
    public static final String generateShopIds(@Nullable List<GemRestaurant> list) {
        if (list != null) {
            Iterable<GemRestaurant> iterable = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (GemRestaurant id2 : iterable) {
                arrayList.add(id2.getId());
            }
            String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            if (joinToString$default == null) {
                return "";
            }
            return joinToString$default;
        }
        return "";
    }
}
