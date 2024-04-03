package com.talabat.talabatcommon.adapters.special.item;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J#\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\u0004R,\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00008\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/adapters/special/item/SpecialItemRecyclerViewBuilder;", "", "()V", "createSpecialItemViewHolder", "Lkotlin/Function2;", "Landroid/content/Context;", "Landroid/view/ViewGroup;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getCreateSpecialItemViewHolder$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "()Lkotlin/jvm/functions/Function2;", "setCreateSpecialItemViewHolder$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "(Lkotlin/jvm/functions/Function2;)V", "with", "getWith$annotations", "getWith", "()Lcom/talabat/talabatcommon/adapters/special/item/SpecialItemRecyclerViewBuilder;", "specialItemViewHolderFactory", "", "factory", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SpecialItemRecyclerViewBuilder {
    public Function2<? super Context, ? super ViewGroup, ? extends RecyclerView.ViewHolder> createSpecialItemViewHolder;
    @NotNull
    private final SpecialItemRecyclerViewBuilder with = this;

    @SpecialItemRecyclerViewDsl
    public static /* synthetic */ void getWith$annotations() {
    }

    @NotNull
    public final Function2<Context, ViewGroup, RecyclerView.ViewHolder> getCreateSpecialItemViewHolder$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        Function2<? super Context, ? super ViewGroup, ? extends RecyclerView.ViewHolder> function2 = this.createSpecialItemViewHolder;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("createSpecialItemViewHolder");
        return null;
    }

    @NotNull
    public final SpecialItemRecyclerViewBuilder getWith() {
        return this.with;
    }

    public final void setCreateSpecialItemViewHolder$com_talabat_NewArchi_TalabatCommon_TalabatCommon(@NotNull Function2<? super Context, ? super ViewGroup, ? extends RecyclerView.ViewHolder> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.createSpecialItemViewHolder = function2;
    }

    @SpecialItemRecyclerViewDsl
    public final void specialItemViewHolderFactory(@NotNull Function2<? super Context, ? super ViewGroup, ? extends RecyclerView.ViewHolder> function2) {
        Intrinsics.checkNotNullParameter(function2, "factory");
        setCreateSpecialItemViewHolder$com_talabat_NewArchi_TalabatCommon_TalabatCommon(function2);
    }
}
