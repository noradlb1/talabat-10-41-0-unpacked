package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/gem/domain/entities/GemOffer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BusinessRulesKt$NullGemOffer$2 extends Lambda implements Function0<GemOffer> {
    public static final BusinessRulesKt$NullGemOffer$2 INSTANCE = new BusinessRulesKt$NullGemOffer$2();

    public BusinessRulesKt$NullGemOffer$2() {
        super(0);
    }

    @NotNull
    public final GemOffer invoke() {
        return new GemOffer("-1", (Double) null, (List) null, (List) null, (Long) null, (String) null, (String) null, (String) null, 254, (DefaultConstructorMarker) null);
    }
}
