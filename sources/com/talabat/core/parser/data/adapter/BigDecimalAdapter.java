package com.talabat.core.parser.data.adapter;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/core/parser/data/adapter/BigDecimalAdapter;", "", "()V", "fromJson", "Ljava/math/BigDecimal;", "string", "", "toJson", "value", "com_talabat_core_parser_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BigDecimalAdapter {
    @NotNull
    public static final BigDecimalAdapter INSTANCE = new BigDecimalAdapter();

    private BigDecimalAdapter() {
    }

    @NotNull
    @FromJson
    public final BigDecimal fromJson(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        return new BigDecimal(str);
    }

    @ToJson
    @NotNull
    public final String toJson(@NotNull BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "value");
        String bigDecimal2 = bigDecimal.toString();
        Intrinsics.checkNotNullExpressionValue(bigDecimal2, "value.toString()");
        return bigDecimal2;
    }
}
