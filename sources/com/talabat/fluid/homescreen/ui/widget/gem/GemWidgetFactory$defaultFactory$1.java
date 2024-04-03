package com.talabat.fluid.homescreen.ui.widget.gem;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/fluid/homescreen/ui/widget/gem/GemModel;", "it", "Lcom/talabat/fluid/homescreen/ui/widget/gem/GemWidgetView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemWidgetFactory$defaultFactory$1 extends Lambda implements Function1<GemWidgetView, GemModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemWidgetFactory f59751g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemWidgetFactory$defaultFactory$1(GemWidgetFactory gemWidgetFactory) {
        super(1);
        this.f59751g = gemWidgetFactory;
    }

    @NotNull
    public final GemModel invoke(@NotNull GemWidgetView gemWidgetView) {
        Intrinsics.checkNotNullParameter(gemWidgetView, "it");
        return new GemModel(this.f59751g.a(gemWidgetView));
    }
}
