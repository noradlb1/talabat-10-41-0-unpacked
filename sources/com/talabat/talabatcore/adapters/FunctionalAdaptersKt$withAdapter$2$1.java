package com.talabat.talabatcore.adapters;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "I", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FunctionalAdaptersKt$withAdapter$2$1 extends Lambda implements Function1<List<? extends I>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<UpdatableAdapter<I, UpdatableViewHolder<I>>, List<? extends I>, Unit> f12010g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Binding<I> f12011h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionalAdaptersKt$withAdapter$2$1(Function2<? super UpdatableAdapter<I, UpdatableViewHolder<I>>, ? super List<? extends I>, Unit> function2, Binding<I> binding) {
        super(1);
        this.f12010g = function2;
        this.f12011h = binding;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable List<? extends I> list) {
        this.f12010g.invoke(this.f12011h.getItemsAdapter(), list);
    }
}
