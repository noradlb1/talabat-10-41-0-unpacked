package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemTier;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a \u0012\u0004\u0012\u00020\u0002 \u0004*\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\u0004\u0018\u0001`\u00030\u0001j\u0002`\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/domain/entities/GemTier;", "Lcom/talabat/gem/domain/entities/GemTiers;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BusinessRulesKt$selectedTierIndex$1 extends Lambda implements Function0<List<? extends GemTier>> {
    public static final BusinessRulesKt$selectedTierIndex$1 INSTANCE = new BusinessRulesKt$selectedTierIndex$1();

    public BusinessRulesKt$selectedTierIndex$1() {
        super(0);
    }

    public final List<GemTier> invoke() {
        return BusinessRulesKt.loadGemTiers();
    }
}
