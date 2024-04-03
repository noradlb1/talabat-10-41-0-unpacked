package com.designsystem.marshmallow.views.gridview.viewholder;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;
import com.designsystem.marshmallow.viewsentity.gridview.GridItemViewEntity;
import com.squareup.picasso.Picasso;
import i6.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0003H\u0002¨\u0006\r"}, d2 = {"Lcom/designsystem/marshmallow/views/gridview/viewholder/GridViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "Lcom/designsystem/marshmallow/viewsentity/gridview/GridItemViewEntity;", "getBackground", "", "loadImage", "view", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GridViewHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GridViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8853bind$lambda1$lambda0(GridItemViewEntity gridItemViewEntity, View view) {
        Intrinsics.checkNotNullParameter(gridItemViewEntity, "$item");
        gridItemViewEntity.getOnItemClick().invoke();
    }

    private final String getBackground(GridItemViewEntity gridItemViewEntity) {
        return StringsKt__StringsJVMKt.startsWith$default(gridItemViewEntity.getItemBackGroundHexa(), "#", false, 2, (Object) null) ? gridItemViewEntity.getItemBackGroundHexa() : "#ff9459";
    }

    private final void loadImage(GridItemViewEntity gridItemViewEntity, View view) {
        boolean z11;
        if (gridItemViewEntity.getImageUrl().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            Picasso.get().load(gridItemViewEntity.getImageUrl()).into((ImageView) (AppCompatImageView) view.findViewById(R.id.gridItemImage));
        }
    }

    public final void bind(@NotNull GridItemViewEntity gridItemViewEntity) {
        Intrinsics.checkNotNullParameter(gridItemViewEntity, "item");
        View view = this.itemView;
        ((AppCompatTextView) view.findViewById(R.id.gridItemName)).setText(gridItemViewEntity.getItemName());
        int i11 = R.id.gridItemContainer;
        ((CardView) view.findViewById(i11)).setCardBackgroundColor(ColorStateList.valueOf(Color.parseColor(getBackground(gridItemViewEntity))));
        ((CardView) view.findViewById(i11)).setOnClickListener(new a(gridItemViewEntity));
        Intrinsics.checkNotNullExpressionValue(view, "this");
        loadImage(gridItemViewEntity, view);
    }
}
