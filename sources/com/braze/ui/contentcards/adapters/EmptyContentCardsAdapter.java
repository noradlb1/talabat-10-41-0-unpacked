package com.braze.ui.contentcards.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.appboy.ui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/braze/ui/contentcards/adapters/EmptyContentCardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "NetworkUnavailableViewHolder", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class EmptyContentCardsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/braze/ui/contentcards/adapters/EmptyContentCardsAdapter$NetworkUnavailableViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NetworkUnavailableViewHolder extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NetworkUnavailableViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public int getItemCount() {
        return 1;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.com_braze_content_cards_empty, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new NetworkUnavailableViewHolder(inflate);
    }
}
