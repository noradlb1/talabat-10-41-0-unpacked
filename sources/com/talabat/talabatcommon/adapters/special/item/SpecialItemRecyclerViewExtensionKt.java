package com.talabat.talabatcommon.adapters.special.item;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.lifecycle.AutoDisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\tH\u0002\u001a5\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\tH\u0000¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006.\u0010\u0010\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00050\u0005 \u0013*\u0006\u0012\u0002\b\u00030\u00040\u00040\u00120\u0011X\u0002"}, d2 = {"switchAdapters", "", "Landroidx/recyclerview/widget/RecyclerView;", "originalAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "index", "", "createSpecialItemViewHolder", "Lkotlin/Function2;", "Landroid/content/Context;", "Landroid/view/ViewGroup;", "withSpecialItem", "specialItemIndex", "(Landroidx/recyclerview/widget/RecyclerView;ILkotlin/jvm/functions/Function2;)Lkotlin/Unit;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon", "adaptersStream", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/talabatcommon/extentions/Nullable;", "kotlin.jvm.PlatformType"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SpecialItemRecyclerViewExtensionKt {
    /* access modifiers changed from: private */
    public static final void switchAdapters(RecyclerView recyclerView, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, int i11, Function2<? super Context, ? super ViewGroup, ? extends RecyclerView.ViewHolder> function2) {
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        SpecialItemAdapter specialItemAdapter = new SpecialItemAdapter(new SpecialItemAdapterImplementer(context, adapter, i11, function2));
        adapter.registerAdapterDataObserver(new AdapterDataObserver(specialItemAdapter));
        recyclerView.setAdapter(specialItemAdapter);
    }

    @Nullable
    public static final Unit withSpecialItem(@NotNull RecyclerView recyclerView, int i11, @NotNull Function2<? super Context, ? super ViewGroup, ? extends RecyclerView.ViewHolder> function2) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(function2, "createSpecialItemViewHolder");
        Context context = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return AutoDisposableKt.withAutoDisposables(context, new SpecialItemRecyclerViewExtensionKt$withSpecialItem$1(recyclerView, i11, function2));
    }
}
