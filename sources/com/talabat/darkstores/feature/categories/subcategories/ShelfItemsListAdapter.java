package com.talabat.darkstores.feature.categories.subcategories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.Transformation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;
import com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfItem;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yi.d;
import yi.e;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\bH\u0016J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0014\u0010\u0012\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u0000H\u0016J\u0014\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/ShelfItemsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/darkstores/feature/categories/subcategories/ShelfItemsListAdapter$ViewHolder;", "()V", "shelfItems", "", "Lcom/talabat/darkstores/feature/categories/subcategories/shelf/ShelfItem;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "submitList", "items", "", "ViewHolder", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShelfItemsListAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    private final List<ShelfItem> shelfItems = new ArrayList();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/ShelfItemsListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/categories/subcategories/ShelfItemsListAdapter;Landroid/view/View;)V", "clickListener", "Landroid/view/View$OnClickListener;", "getContainerView", "()Landroid/view/View;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "bind", "", "item", "Lcom/talabat/darkstores/feature/categories/subcategories/shelf/ShelfItem;", "dispose", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @Nullable
        private View.OnClickListener clickListener;
        @NotNull
        private final View containerView;
        @NotNull
        private final CompositeDisposable disposable = new CompositeDisposable();

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ShelfItemsListAdapter f56317h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ShelfItemsListAdapter shelfItemsListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.f56317h = shelfItemsListAdapter;
            this.containerView = view;
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-2$lambda-0  reason: not valid java name */
        public static final void m9866bind$lambda2$lambda0(ShelfItem shelfItem, View view) {
            Intrinsics.checkNotNullParameter(shelfItem, "$item");
            shelfItem.onClick();
        }

        /* access modifiers changed from: private */
        /* renamed from: bind$lambda-2$lambda-1  reason: not valid java name */
        public static final void m9867bind$lambda2$lambda1(View view, Boolean bool) {
            int i11;
            int i12;
            Intrinsics.checkNotNullParameter(view, "$this_with");
            Intrinsics.checkNotNullExpressionValue(bool, "isSelected");
            if (bool.booleanValue()) {
                i11 = R.drawable.bg_shelf_item_selected;
            } else {
                i11 = R.drawable.bg_m_item_tile;
            }
            ((ImageView) view.findViewById(R.id.shelfItemImage)).setBackgroundResource(i11);
            TextView textView = (TextView) view.findViewById(R.id.shelfItemName);
            Intrinsics.checkNotNullExpressionValue(textView, "shelfItemName");
            int i13 = 0;
            if (!bool.booleanValue()) {
                i12 = 0;
            } else {
                i12 = 8;
            }
            textView.setVisibility(i12);
            TextView textView2 = (TextView) view.findViewById(R.id.shelfItemNameSelected);
            Intrinsics.checkNotNullExpressionValue(textView2, "shelfItemNameSelected");
            if (!bool.booleanValue()) {
                i13 = 8;
            }
            textView2.setVisibility(i13);
        }

        public final void bind(@NotNull ShelfItem shelfItem) {
            Intrinsics.checkNotNullParameter(shelfItem, "item");
            View containerView2 = getContainerView();
            ((TextView) containerView2.findViewById(R.id.shelfItemName)).setText(shelfItem.getName());
            ((TextView) containerView2.findViewById(R.id.shelfItemNameSelected)).setText(shelfItem.getName());
            ImageView imageView = (ImageView) containerView2.findViewById(R.id.shelfItemImage);
            Intrinsics.checkNotNullExpressionValue(imageView, "shelfItemImage");
            BindingAdaptersKt.loadImageWithGlide$default(imageView, shelfItem.getUrl(), (Integer) null, (ResizeStrategy) null, (Transformation) null, (Integer) null, 28, (Object) null);
            this.clickListener = new d(shelfItem);
            getContainerView().setOnClickListener(this.clickListener);
            CompositeDisposable compositeDisposable = this.disposable;
            Disposable subscribe = shelfItem.isSelected().subscribe(new e(containerView2));
            Intrinsics.checkNotNullExpressionValue(subscribe, "item.isSelected\n        …ted\n                    }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }

        public final void dispose() {
            this.disposable.clear();
            this.clickListener = null;
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    public int getItemCount() {
        return this.shelfItems.size();
    }

    public int getItemViewType(int i11) {
        return R.layout.darkstores_view_shelf_item;
    }

    public final void submitList(@NotNull List<ShelfItem> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.shelfItems.clear();
        this.shelfItems.addAll(list);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        viewHolder.bind(this.shelfItems.get(i11));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…(viewType, parent, false)");
        return new ViewHolder(this, inflate);
    }

    public void onViewRecycled(@NotNull ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        viewHolder.dispose();
    }
}
