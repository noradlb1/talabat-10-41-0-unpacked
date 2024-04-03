package com.talabat.verticals.ui.customViewLCAware.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.verticals.R;
import com.talabat.verticals.ui.customViewLCAware.adapter.VerticalsItemSmallViewHolder;
import com.talabat.verticals.ui.customViewLCAware.adapter.VerticalsItemViewHolder;
import com.talabat.verticals.ui.customViewLCAware.adapter.VerticalsSubListViewHolder;
import com.talabat.verticals.ui.customViewLCAware.model.Vertical;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0002-.B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0016J\u0012\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001e\u0010)\u001a\u00020\u00192\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010J\u000e\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\bR\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006/"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsLauncherAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsItemViewHolder$ItemCLickListener;", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsItemSmallViewHolder$ItemCLickListener;", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsSubListViewHolder$ItemCLickListener;", "()V", "mListener", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsLauncherAdapter$MainVerticalsClickListener;", "getMListener", "()Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsLauncherAdapter$MainVerticalsClickListener;", "setMListener", "(Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsLauncherAdapter$MainVerticalsClickListener;)V", "mainVerticals", "Ljava/util/ArrayList;", "Lcom/talabat/verticals/ui/customViewLCAware/model/Vertical;", "Lkotlin/collections/ArrayList;", "getMainVerticals", "()Ljava/util/ArrayList;", "setMainVerticals", "(Ljava/util/ArrayList;)V", "subVerticals", "getSubVerticals", "setSubVerticals", "bindNormalItem", "", "holder", "position", "", "bindSmallItem", "bindSubVerticalsList", "getItemCount", "getItemViewType", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemCLicked", "deepLink", "", "setData", "data", "setListerner", "listener", "Companion", "MainVerticalsClickListener", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsLauncherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements VerticalsItemViewHolder.ItemCLickListener, VerticalsItemSmallViewHolder.ItemCLickListener, VerticalsSubListViewHolder.ItemCLickListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ITEM_VERTICALS_BIG = 1;
    public static final int ITEM_VERTICALS_HORIZONTAL_LIST = 3;
    public static final int ITEM_VERTICALS_SMALL = 2;
    public static final int NO_ITEM = -1;
    public MainVerticalsClickListener mListener;
    @NotNull
    private ArrayList<Vertical> mainVerticals = new ArrayList<>();
    @NotNull
    private ArrayList<Vertical> subVerticals = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsLauncherAdapter$Companion;", "", "()V", "ITEM_VERTICALS_BIG", "", "ITEM_VERTICALS_HORIZONTAL_LIST", "ITEM_VERTICALS_SMALL", "NO_ITEM", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsLauncherAdapter$MainVerticalsClickListener;", "", "onItemClicked", "", "deepLink", "", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface MainVerticalsClickListener {
        void onItemClicked(@Nullable String str);
    }

    private final void bindNormalItem(RecyclerView.ViewHolder viewHolder, int i11) {
        Vertical vertical = this.mainVerticals.get(i11);
        Intrinsics.checkNotNullExpressionValue(vertical, "mainVerticals.get(position)");
        ((VerticalsItemViewHolder) viewHolder).bindItem(vertical, this);
    }

    private final void bindSmallItem(RecyclerView.ViewHolder viewHolder, int i11) {
        Vertical vertical = this.mainVerticals.get(i11);
        Intrinsics.checkNotNullExpressionValue(vertical, "mainVerticals.get(position)");
        ((VerticalsItemSmallViewHolder) viewHolder).bindItem(vertical, this);
    }

    private final void bindSubVerticalsList(RecyclerView.ViewHolder viewHolder) {
        ((VerticalsSubListViewHolder) viewHolder).bindItem(this.subVerticals, this);
    }

    public int getItemCount() {
        int size = this.mainVerticals.size();
        if (this.subVerticals.size() > 0) {
            return size + 1;
        }
        return size;
    }

    public int getItemViewType(int i11) {
        if (this.subVerticals.size() <= 0) {
            int itemCount = getItemCount();
            if (itemCount == 2) {
                return 1;
            }
            if (itemCount != 3) {
                return -1;
            }
            return 2;
        } else if (i11 == 0 || i11 == 1) {
            return 1;
        } else {
            if (i11 != 2) {
                return -1;
            }
            return 3;
        }
    }

    @NotNull
    public final MainVerticalsClickListener getMListener() {
        MainVerticalsClickListener mainVerticalsClickListener = this.mListener;
        if (mainVerticalsClickListener != null) {
            return mainVerticalsClickListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mListener");
        return null;
    }

    @NotNull
    public final ArrayList<Vertical> getMainVerticals() {
        return this.mainVerticals;
    }

    @NotNull
    public final ArrayList<Vertical> getSubVerticals() {
        return this.subVerticals;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof VerticalsSubListViewHolder) {
            bindSubVerticalsList(viewHolder);
        } else if (viewHolder instanceof VerticalsItemViewHolder) {
            bindNormalItem(viewHolder, i11);
        } else if (viewHolder instanceof VerticalsItemSmallViewHolder) {
            bindSmallItem(viewHolder, i11);
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == 1) {
            return new VerticalsItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vertical, viewGroup, false));
        }
        if (i11 == 2) {
            return new VerticalsItemSmallViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vertical_small, viewGroup, false));
        }
        if (i11 != 3) {
            return new VerticalsItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vertical_small, viewGroup, false));
        }
        return new VerticalsSubListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_verticals_horizontal_list, viewGroup, false));
    }

    public void onItemCLicked(@Nullable String str) {
        getMListener().onItemClicked(str);
    }

    public final void setData(@NotNull ArrayList<Vertical> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "data");
        if (arrayList.size() == 1) {
            getItemCount();
            return;
        }
        int size = arrayList.size();
        if (size == 2 || size == 3) {
            this.mainVerticals = arrayList;
        } else {
            for (int i11 = 0; i11 < 2; i11++) {
                this.mainVerticals.add(arrayList.get(i11));
            }
            int size2 = arrayList.size();
            for (int i12 = 2; i12 < size2; i12++) {
                this.subVerticals.add(arrayList.get(i12));
            }
        }
        notifyDataSetChanged();
    }

    public final void setListerner(@NotNull MainVerticalsClickListener mainVerticalsClickListener) {
        Intrinsics.checkNotNullParameter(mainVerticalsClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        setMListener(mainVerticalsClickListener);
    }

    public final void setMListener(@NotNull MainVerticalsClickListener mainVerticalsClickListener) {
        Intrinsics.checkNotNullParameter(mainVerticalsClickListener, "<set-?>");
        this.mListener = mainVerticalsClickListener;
    }

    public final void setMainVerticals(@NotNull ArrayList<Vertical> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mainVerticals = arrayList;
    }

    public final void setSubVerticals(@NotNull ArrayList<Vertical> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.subVerticals = arrayList;
    }
}
