package com.talabat.talabatcore.adapters;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0018\b\u0001\u0010\u0003*\u00020\u0004*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u0002H\u00032\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "T", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Function1;", "holder", "position", "", "invoke", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FunctionalAdaptersKt$Adapter$1 extends Lambda implements Function2 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List f12002g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionalAdaptersKt$Adapter$1(List list) {
        super(2);
        this.f12002g = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((RecyclerView.ViewHolder) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ((Function1) viewHolder).invoke(this.f12002g.get(i11));
    }
}
