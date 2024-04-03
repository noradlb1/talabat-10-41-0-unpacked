package com.deliveryhero.fluid.widgets.containers.stack;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/widgets/containers/stack/StackModel;", "widget", "Landroid/widget/FrameLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class StackFactory$defaultsFactory$1 extends Lambda implements Function1<FrameLayout, StackModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ StackFactory f30271g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StackFactory$defaultsFactory$1(StackFactory stackFactory) {
        super(1);
        this.f30271g = stackFactory;
    }

    @NotNull
    public final StackModel invoke(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "widget");
        return new StackModel(CollectionsKt__CollectionsKt.emptyList(), this.f30271g.a(frameLayout));
    }
}
