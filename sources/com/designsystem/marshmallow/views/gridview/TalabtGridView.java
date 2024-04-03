package com.designsystem.marshmallow.views.gridview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;
import com.designsystem.marshmallow.views.gridview.adapter.GridViewAdapter;
import com.designsystem.marshmallow.viewsentity.gridview.GridViewsEntity;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0007¨\u0006\u000e"}, d2 = {"Lcom/designsystem/marshmallow/views/gridview/TalabtGridView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bind", "", "gridViewsEntity", "Lcom/designsystem/marshmallow/viewsentity/gridview/GridViewsEntity;", "numberOfColumns", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This component is no longer part of the Design System")
public final class TalabtGridView extends ConstraintLayout {
    public static final int $stable = 0;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TalabtGridView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TalabtGridView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TalabtGridView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static /* synthetic */ void bind$default(TalabtGridView talabtGridView, GridViewsEntity gridViewsEntity, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 3;
        }
        talabtGridView.bind(gridViewsEntity, i11);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final void bind(@NotNull GridViewsEntity gridViewsEntity, int i11) {
        Intrinsics.checkNotNullParameter(gridViewsEntity, "gridViewsEntity");
        int i12 = R.id.gridList;
        ((RecyclerView) findViewById(i12)).setLayoutManager(new GridLayoutManager(getContext(), i11));
        ((RecyclerView) findViewById(i12)).setAdapter(new GridViewAdapter(gridViewsEntity));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TalabtGridView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.grid_view, this);
    }
}
