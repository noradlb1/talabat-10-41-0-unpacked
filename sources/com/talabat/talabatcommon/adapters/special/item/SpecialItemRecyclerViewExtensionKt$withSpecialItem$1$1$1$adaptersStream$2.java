package com.talabat.talabatcommon.adapters.special.item;

import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.extentions.Nullable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a \u0012\u001c\u0012\u001a\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0006\u0012\u0002\b\u00030\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/extentions/Nullable;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SpecialItemRecyclerViewExtensionKt$withSpecialItem$1$1$1$adaptersStream$2 extends Lambda implements Function0<Nullable<RecyclerView.Adapter<?>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f46868g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpecialItemRecyclerViewExtensionKt$withSpecialItem$1$1$1$adaptersStream$2(RecyclerView recyclerView) {
        super(0);
        this.f46868g = recyclerView;
    }

    @NotNull
    public final Nullable<RecyclerView.Adapter<?>> invoke() {
        return new Nullable<>(this.f46868g.getAdapter());
    }
}
