package com.talabat.restaurants.v2.data.swimlane;

import com.talabat.restaurants.v2.data.InMemoryCache;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038BX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"SWIMLANES_REQUEST_VL", "", "inMemoryCache", "Lcom/talabat/restaurants/v2/data/InMemoryCache;", "getInMemoryCache", "()Lcom/talabat/restaurants/v2/data/InMemoryCache;", "inMemoryCache$delegate", "Lkotlin/Lazy;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneRepositoryImplKt {
    @NotNull
    private static final String SWIMLANES_REQUEST_VL = "SWIMLANES_REQUEST_VL";
    @NotNull
    private static final Lazy inMemoryCache$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, SwimlaneRepositoryImplKt$inMemoryCache$2.INSTANCE);

    /* access modifiers changed from: private */
    public static final InMemoryCache getInMemoryCache() {
        return (InMemoryCache) inMemoryCache$delegate.getValue();
    }
}
