package com.talabat.gem.domain.usecases;

import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/text/DecimalFormat;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BusinessRulesKt$DecimalFormat$2 extends Lambda implements Function0<DecimalFormat> {
    public static final BusinessRulesKt$DecimalFormat$2 INSTANCE = new BusinessRulesKt$DecimalFormat$2();

    public BusinessRulesKt$DecimalFormat$2() {
        super(0);
    }

    @NotNull
    public final DecimalFormat invoke() {
        return new DecimalFormat("#0.##");
    }
}
