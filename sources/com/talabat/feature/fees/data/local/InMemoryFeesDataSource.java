package com.talabat.feature.fees.data.local;

import com.talabat.feature.fees.domain.model.Fees;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/fees/data/local/InMemoryFeesDataSource;", "Lcom/talabat/feature/fees/data/local/LocalFeesDataSource;", "()V", "cache", "Ljava/util/HashMap;", "", "Lcom/talabat/feature/fees/domain/model/Fees;", "Lkotlin/collections/HashMap;", "getFees", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putFees", "", "fees", "(Ljava/lang/String;Lcom/talabat/feature/fees/domain/model/Fees;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InMemoryFeesDataSource implements LocalFeesDataSource {
    @NotNull
    private final HashMap<String, Fees> cache = new HashMap<>();

    @Nullable
    public Object getFees(@NotNull String str, @NotNull Continuation<? super Fees> continuation) {
        return this.cache.get(str);
    }

    @Nullable
    public Object putFees(@NotNull String str, @NotNull Fees fees, @NotNull Continuation<? super Unit> continuation) {
        this.cache.put(str, fees);
        return Unit.INSTANCE;
    }
}
