package com.talabat.gem.samples;

import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.gem.adapters.presentation.home.GemSwimlanesViewHolderKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/talabat/gem/samples/HomeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "list", "", "", "getList", "()Ljava/util/List;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */
    @NotNull
    public final AppCompatActivity activity;
    @NotNull
    private final List<String> list = SampleGemRestaurantsActivityKt.Collections(30);

    public HomeAdapter(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        this.activity = appCompatActivity;
    }

    public int getItemCount() {
        return this.list.size();
    }

    public int getItemViewType(int i11) {
        return i11 == 3 ? 1 : 0;
    }

    @NotNull
    public final List<String> getList() {
        return this.list;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof CollectionViewHolder) {
            ((CollectionViewHolder) viewHolder).bind(this.list.get(i11));
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 != 1) {
            return new CollectionViewHolder(viewGroup);
        }
        return GemSwimlanesViewHolderKt.GemSwimlanesViewHolder(viewGroup, new HomeAdapter$onCreateViewHolder$1(this));
    }
}
