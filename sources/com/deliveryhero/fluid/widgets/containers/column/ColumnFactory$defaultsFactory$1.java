package com.deliveryhero.fluid.widgets.containers.column;

import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/deliveryhero/fluid/widgets/containers/column/ColumnModel;", "widget", "Landroid/widget/LinearLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ColumnFactory$defaultsFactory$1 extends Lambda implements Function1<LinearLayout, ColumnModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ColumnFactory f30269g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ColumnFactory$defaultsFactory$1(ColumnFactory columnFactory) {
        super(1);
        this.f30269g = columnFactory;
    }

    @NotNull
    public final ColumnModel invoke(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "widget");
        return new ColumnModel(CollectionsKt__CollectionsKt.emptyList(), this.f30269g.a(linearLayout));
    }
}
