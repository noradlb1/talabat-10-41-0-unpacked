package com.talabat.talabatcore.adapters;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcore/adapters/UpdatableViewHolder;", "I", "Landroid/view/ViewGroup;", "Lcom/talabat/talabatcore/adapters/ParentViewGroup;", "it", "", "Lcom/talabat/talabatcore/adapters/ViewType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FunctionalAdaptersKt$withAdapter$updatableAdapter$1 extends Lambda implements Function2<ViewGroup, Integer, UpdatableViewHolder<I>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<ViewGroup, UpdatableViewHolder<I>> f12012g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionalAdaptersKt$withAdapter$updatableAdapter$1(Function1<? super ViewGroup, UpdatableViewHolder<I>> function1) {
        super(2);
        this.f12012g = function1;
    }

    @NotNull
    public final UpdatableViewHolder<I> invoke(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$Adapter");
        return this.f12012g.invoke(viewGroup);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((ViewGroup) obj, ((Number) obj2).intValue());
    }
}
