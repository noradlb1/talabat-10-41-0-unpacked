package com.talabat.talabatcommon.views.darkstores.lookingGlass;

import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.GDisplayItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "item", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LookingGlassView$setupView$3$1$1 extends Lambda implements Function1<GDisplayItem, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LookingGlassView f11723g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LookingGlassView$setupView$3$1$1(LookingGlassView lookingGlassView) {
        super(1);
        this.f11723g = lookingGlassView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GDisplayItem) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GDisplayItem gDisplayItem) {
        Intrinsics.checkNotNullParameter(gDisplayItem, "item");
        this.f11723g.onProductClicked(gDisplayItem);
    }
}
