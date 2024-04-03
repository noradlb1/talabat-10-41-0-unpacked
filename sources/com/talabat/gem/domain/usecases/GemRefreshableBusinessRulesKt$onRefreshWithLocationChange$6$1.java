package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.Location;
import com.talabat.gem.ports.presentation.GemRefreshableViewPort;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/gem/domain/entities/GemOffer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemRefreshableBusinessRulesKt$onRefreshWithLocationChange$6$1 extends Lambda implements Function1<GemOffer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemRefreshableViewPort f60423g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<Location> f60424h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemRefreshableBusinessRulesKt$onRefreshWithLocationChange$6$1(GemRefreshableViewPort gemRefreshableViewPort, List<Location> list) {
        super(1);
        this.f60423g = gemRefreshableViewPort;
        this.f60424h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemOffer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemOffer gemOffer) {
        Intrinsics.checkNotNullParameter(gemOffer, "it");
        this.f60423g.getRefreshedLocation().onNext(this.f60424h.get(1));
    }
}
