package com.talabat.gem.domain.usecases;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(J)Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCounterBusinessRulesKt$countDownTimer$2 extends Lambda implements Function1<Long, Long> {
    public static final GemCounterBusinessRulesKt$countDownTimer$2 INSTANCE = new GemCounterBusinessRulesKt$countDownTimer$2();

    public GemCounterBusinessRulesKt$countDownTimer$2() {
        super(1);
    }

    @NotNull
    public final Long invoke(long j11) {
        return Long.valueOf(j11 / 60);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }
}
