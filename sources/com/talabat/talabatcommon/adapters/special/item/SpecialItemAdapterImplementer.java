package com.talabat.talabatcommon.adapters.special.item;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0010\fJ\u0006\u0010\u0015\u001a\u00020\bJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bJ\u0016\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bJ\f\u0010\u001f\u001a\u00020\b*\u00020\bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR#\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/talabat/talabatcommon/adapters/special/item/SpecialItemAdapterImplementer;", "", "context", "Landroid/content/Context;", "originalAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "specialItemIndex", "", "createSpecialItemViewHolder", "Lkotlin/Function2;", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroidx/recyclerview/widget/RecyclerView$Adapter;ILkotlin/jvm/functions/Function2;)V", "getContext", "()Landroid/content/Context;", "getCreateSpecialItemViewHolder", "()Lkotlin/jvm/functions/Function2;", "getOriginalAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getSpecialItemIndex", "()I", "adjustedSpecialItemIndex", "bindViewHolder", "", "holder", "position", "createViewHolder", "viewType", "parent", "itemCount", "itemViewType", "adjust", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpecialItemAdapterImplementer {
    @NotNull
    private final Context context;
    @NotNull
    private final Function2<Context, ViewGroup, RecyclerView.ViewHolder> createSpecialItemViewHolder;
    @NotNull
    private final RecyclerView.Adapter<RecyclerView.ViewHolder> originalAdapter;
    private final int specialItemIndex;

    public SpecialItemAdapterImplementer(@NotNull Context context2, @NotNull RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, int i11, @NotNull Function2<? super Context, ? super ViewGroup, ? extends RecyclerView.ViewHolder> function2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(adapter, "originalAdapter");
        Intrinsics.checkNotNullParameter(function2, "createSpecialItemViewHolder");
        this.context = context2;
        this.originalAdapter = adapter;
        this.specialItemIndex = i11;
        this.createSpecialItemViewHolder = function2;
    }

    private final int adjust(int i11) {
        return i11 < adjustedSpecialItemIndex() ? i11 : i11 - 1;
    }

    public final int adjustedSpecialItemIndex() {
        if (this.specialItemIndex >= this.originalAdapter.getItemCount()) {
            return this.originalAdapter.getItemCount();
        }
        return this.specialItemIndex;
    }

    public final void bindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (i11 != adjustedSpecialItemIndex()) {
            this.originalAdapter.onBindViewHolder(viewHolder, adjust(i11));
        }
    }

    @NotNull
    public final RecyclerView.ViewHolder createViewHolder(int i11, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == 8760) {
            return this.createSpecialItemViewHolder.invoke(this.context, viewGroup);
        }
        RecyclerView.ViewHolder onCreateViewHolder = this.originalAdapter.onCreateViewHolder(viewGroup, i11);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "originalAdapter.onCreate…wHolder(parent, viewType)");
        return onCreateViewHolder;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final Function2<Context, ViewGroup, RecyclerView.ViewHolder> getCreateSpecialItemViewHolder() {
        return this.createSpecialItemViewHolder;
    }

    @NotNull
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> getOriginalAdapter() {
        return this.originalAdapter;
    }

    public final int getSpecialItemIndex() {
        return this.specialItemIndex;
    }

    public final int itemCount() {
        return this.originalAdapter.getItemCount() + 1;
    }

    public final int itemViewType(int i11) {
        if (i11 == adjustedSpecialItemIndex()) {
            return SpecialItemAdapterKt.TYPE_SPECIAL_ITEM;
        }
        return this.originalAdapter.getItemViewType(adjust(i11));
    }
}
