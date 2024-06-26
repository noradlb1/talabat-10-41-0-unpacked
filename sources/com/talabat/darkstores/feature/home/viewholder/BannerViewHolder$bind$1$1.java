package com.talabat.darkstores.feature.home.viewholder;

import com.talabat.darkstores.feature.home.BannerItemViewHolderData;
import com.talabat.darkstores.model.Banner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "banner", "Lcom/talabat/darkstores/model/Banner;", "position", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BannerViewHolder$bind$1$1 extends Lambda implements Function2<Banner, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BannerItemViewHolderData f56433g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerViewHolder$bind$1$1(BannerItemViewHolderData bannerItemViewHolderData) {
        super(2);
        this.f56433g = bannerItemViewHolderData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Banner) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Banner banner, int i11) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        this.f56433g.getOnBannerShownListener().invoke(banner, Integer.valueOf(i11));
    }
}
