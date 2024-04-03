package com.talabat.darkstores.feature.home;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0010\b&\u0018\u0000 /*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001/B\u001d\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000 \u0012\u0006\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H$J \u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H$J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J \u0010\u0015\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00138\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R6\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010*\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010,\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b+\u0010)¨\u00060"}, d2 = {"Lcom/talabat/darkstores/feature/home/LoopingPagerAdapter;", "T", "Landroidx/viewpager/widget/PagerAdapter;", "", "position", "getListPosition", "viewType", "Landroid/view/ViewGroup;", "container", "listPosition", "Landroid/view/View;", "b", "convertView", "", "a", "", "instantiateItem", "view", "object", "", "isViewFromObject", "destroyItem", "getItemPosition", "getCount", "isInfinite", "Z", "canInfinite", "getCanInfinite", "()Z", "setCanInfinite", "(Z)V", "dataSetChangeLock", "", "value", "itemList", "Ljava/util/List;", "getItemList", "()Ljava/util/List;", "setItemList", "(Ljava/util/List;)V", "getListCount", "()I", "listCount", "getLastItemPosition", "lastItemPosition", "<init>", "(Ljava/util/List;Z)V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public abstract class LoopingPagerAdapter<T> extends PagerAdapter {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_TYPE = 0;
    private boolean canInfinite = true;
    private boolean dataSetChangeLock;
    private boolean isInfinite;
    @NotNull
    private List<? extends T> itemList = CollectionsKt__CollectionsKt.emptyList();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/home/LoopingPagerAdapter$Companion;", "", "()V", "DEFAULT_TYPE", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LoopingPagerAdapter(@NotNull List<? extends T> list, boolean z11) {
        Intrinsics.checkNotNullParameter(list, "itemList");
        this.isInfinite = z11;
        setItemList(list);
    }

    private final int getListPosition(int i11) {
        if (!this.isInfinite || !this.canInfinite) {
            return i11;
        }
        if (i11 == 0) {
            return (getCount() - 1) - 2;
        }
        if (i11 > getCount() - 2) {
            return 0;
        }
        return i11 - 1;
    }

    public abstract void a(@NotNull View view, int i11, int i12);

    @NotNull
    public abstract View b(int i11, @NotNull ViewGroup viewGroup, int i12);

    public void destroyItem(@NotNull ViewGroup viewGroup, int i11, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(obj, "object");
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        int size = this.itemList.size();
        if (!this.isInfinite || !this.canInfinite) {
            return size;
        }
        return size + 2;
    }

    @NotNull
    public final List<T> getItemList() {
        return this.itemList;
    }

    public int getItemPosition(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "object");
        return -2;
    }

    public final int getLastItemPosition() {
        if (this.isInfinite) {
            return this.itemList.size();
        }
        return this.itemList.size() - 1;
    }

    public final int getListCount() {
        return this.itemList.size();
    }

    @NotNull
    public Object instantiateItem(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        int listPosition = getListPosition(i11);
        View b11 = b(0, viewGroup, listPosition);
        a(b11, listPosition, 0);
        viewGroup.addView(b11);
        return b11;
    }

    public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "object");
        return view == obj;
    }

    public final void setItemList(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.itemList = list;
        boolean z11 = true;
        if (list.size() <= 1) {
            z11 = false;
        }
        this.canInfinite = z11;
        notifyDataSetChanged();
    }
}
