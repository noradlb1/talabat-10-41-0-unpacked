package com.talabat.feature.fees.data.local;

import com.talabat.feature.fees.domain.model.Fees;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/fees/data/local/LocalFeesDataSource;", "", "getFees", "Lcom/talabat/feature/fees/domain/model/Fees;", "key", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putFees", "", "fees", "(Ljava/lang/String;Lcom/talabat/feature/fees/domain/model/Fees;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LocalFeesDataSource {
    @Nullable
    Object getFees(@NotNull String str, @NotNull Continuation<? super Fees> continuation);

    @Nullable
    Object putFees(@NotNull String str, @NotNull Fees fees, @NotNull Continuation<? super Unit> continuation);
}
