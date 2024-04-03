package com.talabat.fluid.homescreen.ui.widget.ramadanclock;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/fluid/homescreen/ui/widget/ramadanclock/RamadanClockModel;", "it", "Lcom/talabat/fluid/homescreen/ui/widget/ramadanclock/RamadanClockWidgetView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RamadanClockWidgetFactory$defaultFactory$1 extends Lambda implements Function1<RamadanClockWidgetView, RamadanClockModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RamadanClockWidgetFactory f59754g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RamadanClockWidgetFactory$defaultFactory$1(RamadanClockWidgetFactory ramadanClockWidgetFactory) {
        super(1);
        this.f59754g = ramadanClockWidgetFactory;
    }

    @NotNull
    public final RamadanClockModel invoke(@NotNull RamadanClockWidgetView ramadanClockWidgetView) {
        Intrinsics.checkNotNullParameter(ramadanClockWidgetView, "it");
        return new RamadanClockModel(this.f59754g.a(ramadanClockWidgetView));
    }
}
