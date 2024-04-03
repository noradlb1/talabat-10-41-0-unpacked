package com.deliveryhero.fluid.widgets.space;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/widgets/space/SpaceModel;", "widget", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SpaceFactory$defaultsFactory$1 extends Lambda implements Function1<View, SpaceModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SpaceFactory f30280g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpaceFactory$defaultsFactory$1(SpaceFactory spaceFactory) {
        super(1);
        this.f30280g = spaceFactory;
    }

    @NotNull
    public final SpaceModel invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        return new SpaceModel(this.f30280g.a(view));
    }
}
