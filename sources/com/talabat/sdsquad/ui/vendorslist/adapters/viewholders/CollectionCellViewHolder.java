package com.talabat.sdsquad.ui.vendorslist.adapters.viewholders;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.CollectionDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ou.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/CollectionCellViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "mCollectionClickListener", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/CollectionCellViewHolder$OnCollectionClicked;", "(Landroid/view/View;Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/CollectionCellViewHolder$OnCollectionClicked;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "collectionModel", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "getCollectionIcon", "", "iconUrl", "baseUrl", "OnCollectionClicked", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionCellViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @NotNull
    private final View containerView;
    @Nullable
    private final OnCollectionClicked mCollectionClickListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/CollectionCellViewHolder$OnCollectionClicked;", "", "collectionClicked", "", "clickedCollection", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnCollectionClicked {
        void collectionClicked(@NotNull CollectionDisplayModel collectionDisplayModel);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionCellViewHolder(@NotNull View view, @Nullable OnCollectionClicked onCollectionClicked) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
        this.mCollectionClickListener = onCollectionClicked;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10889bind$lambda0(CollectionCellViewHolder collectionCellViewHolder, CollectionDisplayModel collectionDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(collectionCellViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(collectionDisplayModel, "$collectionModel");
        OnCollectionClicked onCollectionClicked = collectionCellViewHolder.mCollectionClickListener;
        if (onCollectionClicked != null) {
            onCollectionClicked.collectionClicked(collectionDisplayModel);
        }
    }

    private final String getCollectionIcon(String str, String str2) {
        boolean z11;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return "";
        }
        String replace = new Regex(" ").replace((CharSequence) str, "%20");
        return str2 + "restaurants/" + replace;
    }

    public final void bind(@NotNull CollectionDisplayModel collectionDisplayModel) {
        Intrinsics.checkNotNullParameter(collectionDisplayModel, "collectionModel");
        ((TextView) getContainerView().findViewById(R.id.nameTextView)).setText(collectionDisplayModel.getName());
        RequestBuilder<Drawable> load = Glide.with(getContainerView().getContext()).load(getCollectionIcon(collectionDisplayModel.getImage(), collectionDisplayModel.getBaseUrl()));
        View containerView2 = getContainerView();
        int i11 = R.id.iconImageView;
        ((RequestBuilder) load.override(((ImageView) containerView2.findViewById(i11)).getWidth(), ((ImageView) getContainerView().findViewById(i11)).getHeight())).into((ImageView) getContainerView().findViewById(i11));
        getContainerView().setOnClickListener(new a(this, collectionDisplayModel));
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
