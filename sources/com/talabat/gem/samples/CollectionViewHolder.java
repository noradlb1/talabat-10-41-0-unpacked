package com.talabat.gem.samples;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.gem.adapters.R;
import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/talabat/gem/samples/CollectionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTextView", "()Landroid/widget/TextView;", "textView$delegate", "Lkotlin/Lazy;", "bind", "", "name", "", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class CollectionViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final Lazy textView$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new CollectionViewHolder$textView$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionViewHolder(@NotNull ViewGroup viewGroup) {
        super(FunctionalAdaptersKt.inflateView(viewGroup, R.layout.sample_collection_item));
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    private final TextView getTextView() {
        return (TextView) this.textView$delegate.getValue();
    }

    public final void bind(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        getTextView().setText(str);
    }
}
