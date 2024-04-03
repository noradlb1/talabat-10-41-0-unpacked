package com.talabat.talabatcore.adapters;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B.\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001d\u0010\u0007\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\rR%\u0010\u0007\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcore/adapters/UpdatableViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Function1;", "", "view", "Landroid/view/View;", "bind", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "invoke", "item", "(Ljava/lang/Object;)V", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdatableViewHolder<T> extends RecyclerView.ViewHolder implements Function1<T, Unit> {
    @NotNull
    private final Function2<View, T, Unit> bind;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpdatableViewHolder(@NotNull View view, @NotNull Function2<? super View, ? super T, Unit> function2) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function2, "bind");
        this.bind = function2;
    }

    public void invoke(T t11) {
        Function2<View, T, Unit> function2 = this.bind;
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        function2.invoke(view, t11);
    }
}
