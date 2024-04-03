package com.talabat.cuisines.presentation;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.cuisines.R;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/cuisines/presentation/HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "container", "Lcom/talabat/cuisines/presentation/ItemContainer;", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeaderViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @NotNull
    private final View containerView;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HEADERTYPE.values().length];
            iArr[HEADERTYPE.ALL_CUISINES.ordinal()] = 1;
            iArr[HEADERTYPE.POPULAR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        this.containerView = view;
    }

    public final void bind(@NotNull ItemContainer itemContainer) {
        String str;
        Intrinsics.checkNotNullParameter(itemContainer, TtmlNode.RUBY_CONTAINER);
        View containerView2 = getContainerView();
        TextView textView = (TextView) containerView2.findViewById(R.id.cuisineHeaderName);
        int i11 = WhenMappings.$EnumSwitchMapping$0[((HEADERTYPE) itemContainer.getItem()).ordinal()];
        if (i11 == 1) {
            str = ViewKt.getString(containerView2, com.talabat.localization.R.string.all_cuisines);
        } else if (i11 == 2) {
            str = ViewKt.getString(containerView2, com.talabat.localization.R.string.popular_cuisines);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        textView.setText(str);
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
