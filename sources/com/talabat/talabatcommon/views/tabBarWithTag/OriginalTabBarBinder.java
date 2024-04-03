package com.talabat.talabatcommon.views.tabBarWithTag;

import android.content.Context;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.designsystem.marshmallow.R;
import com.talabat.talabatcommon.views.tabBarWithTag.TabBarBinder;
import com.talabat.talabatcommon.views.tabBarWithTag.TabBarWithTagView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/views/tabBarWithTag/OriginalTabBarBinder;", "Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarBinder;", "()V", "selected", "", "context", "Landroid/content/Context;", "viewHolder", "Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarWithTagView$ViewHolder;", "unselected", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OriginalTabBarBinder implements TabBarBinder {
    public void initialState(@NotNull TabItemModel tabItemModel, @NotNull Context context, @NotNull TabBarWithTagView.ViewHolder viewHolder) {
        TabBarBinder.DefaultImpls.initialState(this, tabItemModel, context, viewHolder);
    }

    public void selected(@NotNull Context context, @NotNull TabBarWithTagView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        TextView tabText = viewHolder.getTabText();
        if (tabText != null) {
            tabText.setTextAppearance(R.style.DSTextAppearance_Subheading2);
        }
        TextView tabText2 = viewHolder.getTabText();
        if (tabText2 != null) {
            tabText2.setTextColor(context.getColor(R.color.primary_100));
        }
        CardView tagContainer = viewHolder.getTagContainer();
        if (tagContainer != null) {
            tagContainer.setCardBackgroundColor(context.getColor(R.color.primary_100));
        }
        TextView tagTv = viewHolder.getTagTv();
        if (tagTv != null) {
            tagTv.setTextColor(context.getColor(R.color.ds_white));
        }
    }

    public void unselected(@NotNull Context context, @NotNull TabBarWithTagView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        TextView tabText = viewHolder.getTabText();
        if (tabText != null) {
            tabText.setTextAppearance(R.style.DSTextAppearance_Subheading2);
        }
        TextView tabText2 = viewHolder.getTabText();
        if (tabText2 != null) {
            tabText2.setTextColor(context.getColor(R.color.ds_neutral_70));
        }
        CardView tagContainer = viewHolder.getTagContainer();
        if (tagContainer != null) {
            tagContainer.setCardBackgroundColor(context.getColor(R.color.ds_neutral_70));
        }
        TextView tagTv = viewHolder.getTagTv();
        if (tagTv != null) {
            tagTv.setTextColor(context.getColor(R.color.ds_white));
        }
    }
}
