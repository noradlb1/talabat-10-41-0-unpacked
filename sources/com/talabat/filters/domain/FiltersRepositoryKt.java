package com.talabat.filters.domain;

import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"7\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"KEY_SELECTED_COLLECTION_ID", "", "cache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getCache", "()Ljava/util/HashMap;", "cache$delegate", "Lkotlin/Lazy;", "com_talabat_Components_filters_filters"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FiltersRepositoryKt {
    @NotNull
    private static final String KEY_SELECTED_COLLECTION_ID = "KEY_SELECTED_COLLECTION_ID";
    @NotNull
    private static final Lazy cache$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, FiltersRepositoryKt$cache$2.INSTANCE);

    /* access modifiers changed from: private */
    public static final HashMap<Object, Object> getCache() {
        return (HashMap) cache$delegate.getValue();
    }
}
