package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemTier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\u0004\u0018\u0001`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/domain/entities/GemTier;", "Lcom/talabat/gem/domain/entities/GemTiers;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemSubTotalBusinessRulesKt$nextGemTier$1 extends Lambda implements Function0<List<? extends GemTier>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Triple<String, Double, List<GemTier>> f60435g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemSubTotalBusinessRulesKt$nextGemTier$1(Triple<String, Double, ? extends List<GemTier>> triple) {
        super(0);
        this.f60435g = triple;
    }

    @Nullable
    public final List<GemTier> invoke() {
        return this.f60435g.getThird();
    }
}
