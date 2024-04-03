package com.deliveryhero.fluid.widgets.plain;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/widgets/plain/PlainModel;", "widget", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PlainFactory$defaultsFactory$1 extends Lambda implements Function1<View, PlainModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PlainFactory f30279g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlainFactory$defaultsFactory$1(PlainFactory plainFactory) {
        super(1);
        this.f30279g = plainFactory;
    }

    @NotNull
    public final PlainModel invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        return new PlainModel(this.f30279g.a(view));
    }
}
