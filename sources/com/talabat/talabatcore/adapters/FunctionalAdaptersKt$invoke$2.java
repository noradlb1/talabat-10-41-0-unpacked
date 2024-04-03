package com.talabat.talabatcore.adapters;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcore/adapters/UpdatableViewHolder;", "I", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FunctionalAdaptersKt$invoke$2 extends Lambda implements Function1<ViewGroup, UpdatableViewHolder<I>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f12004g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<View, I, Unit> f12005h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionalAdaptersKt$invoke$2(int i11, Function2<? super View, ? super I, Unit> function2) {
        super(1);
        this.f12004g = i11;
        this.f12005h = function2;
    }

    @NotNull
    public final UpdatableViewHolder<I> invoke(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "$this$withAdapter");
        int i11 = this.f12004g;
        final Function2<View, I, Unit> function2 = this.f12005h;
        return FunctionalAdaptersKt.ViewHolder(viewGroup, i11, new Function2<View, I, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((View) obj, obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view, I i11) {
                Intrinsics.checkNotNullParameter(view, "$this$ViewHolder");
                function2.invoke(view, i11);
            }
        });
    }
}
