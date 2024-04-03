package com.talabat.gem.adapters.presentation.home;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/gem/adapters/presentation/home/GemSwimlanesViewHolder$layoutManager$1", "Landroidx/recyclerview/widget/GridLayoutManager;", "checkLayoutParams", "", "params", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemSwimlanesViewHolder$layoutManager$1 extends GridLayoutManager {
    public GemSwimlanesViewHolder$layoutManager$1(Context context) {
        super(context, 2, 0, false);
    }

    public boolean checkLayoutParams(@NotNull RecyclerView.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, NativeProtocol.WEB_DIALOG_PARAMS);
        layoutParams.width = (int) (((double) getWidth()) * 0.85d);
        return true;
    }
}
