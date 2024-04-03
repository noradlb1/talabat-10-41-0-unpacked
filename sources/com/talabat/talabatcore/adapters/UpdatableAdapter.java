package com.talabat.talabatcore.adapters;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0018\b\u0001\u0010\u0002*\u00020\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00050\u00042\b\u0012\u0004\u0012\u0002H\u00020\u0006BV\b\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\n\u0012%\u0010\f\u001a!\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\b\u0012\u00060\u000bj\u0002`\u000f\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0002\b\u0010¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u001d\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000R-\u0010\f\u001a!\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\b\u0012\u00060\u000bj\u0002`\u000f\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0002\b\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/talabatcore/adapters/UpdatableAdapter;", "T", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlin/Function1;", "", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "items", "", "bind", "Lkotlin/Function2;", "", "viewHolder", "Landroid/view/ViewGroup;", "Lcom/talabat/talabatcore/adapters/ParentViewGroup;", "Lcom/talabat/talabatcore/adapters/ViewType;", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "append", "value", "", "getItemCount", "onBindViewHolder", "holder", "position", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "onCreateViewHolder", "parent", "type", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "update", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdatableAdapter<T, VH extends RecyclerView.ViewHolder & Function1<? super T, ? extends Unit>> extends RecyclerView.Adapter<VH> {
    @NotNull
    private final Function2<VH, Integer, Unit> bind;
    @NotNull
    private final List<T> items;
    @NotNull
    private final Function2<ViewGroup, Integer, VH> viewHolder;

    public UpdatableAdapter(@NotNull List<T> list, @NotNull Function2<? super VH, ? super Integer, Unit> function2, @NotNull Function2<? super ViewGroup, ? super Integer, ? extends VH> function22) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function2, "bind");
        Intrinsics.checkNotNullParameter(function22, "viewHolder");
        this.items = list;
        this.bind = function2;
        this.viewHolder = function22;
    }

    public final void append(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull VH vh2, int i11) {
        Intrinsics.checkNotNullParameter(vh2, "holder");
        this.bind.invoke(vh2, Integer.valueOf(i11));
    }

    @NotNull
    public VH onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return (RecyclerView.ViewHolder) this.viewHolder.invoke(viewGroup, Integer.valueOf(i11));
    }

    public final void update(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }
}
