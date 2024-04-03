package com.talabat.talabatcommon.views.tabBarWithTag;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.views.tabBarWithTag.TabBarWithTagView;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarBinder;", "", "initialState", "", "itemModel", "Lcom/talabat/talabatcommon/views/tabBarWithTag/TabItemModel;", "context", "Landroid/content/Context;", "viewHolder", "Lcom/talabat/talabatcommon/views/tabBarWithTag/TabBarWithTagView$ViewHolder;", "selected", "tagIcon", "", "tagTextMarginStart", "", "tagIvRes", "unselected", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TabBarBinder {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void initialState(@NotNull TabBarBinder tabBarBinder, @NotNull TabItemModel tabItemModel, @NotNull Context context, @NotNull TabBarWithTagView.ViewHolder viewHolder) {
            int i11;
            Intrinsics.checkNotNullParameter(tabItemModel, "itemModel");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            int tagIcon = tagIcon(tabBarBinder, tabItemModel);
            float tagTextMarginStart = tagTextMarginStart(tabBarBinder, context, tabItemModel, tagIcon);
            TextView tabText = viewHolder.getTabText();
            if (tabText != null) {
                tabText.setText(tabItemModel.getTitle());
            }
            TextView tabText2 = viewHolder.getTabText();
            if (tabText2 != null) {
                ViewKt.setMargin$default(tabText2, Float.valueOf(tagTextMarginStart), (Float) null, (Float) null, (Float) null, 14, (Object) null);
            }
            ImageView tagIv = viewHolder.getTagIv();
            if (tagIv != null) {
                tagIv.setImageResource(tagIcon);
            }
            ImageView tagIv2 = viewHolder.getTagIv();
            int i12 = 8;
            if (tagIv2 != null) {
                if (!tabItemModel.isRevamp() || !tabItemModel.isShowIcon()) {
                    i11 = 8;
                } else {
                    i11 = 0;
                }
                tagIv2.setVisibility(i11);
            }
            CardView tagContainer = viewHolder.getTagContainer();
            if (tagContainer != null) {
                tagContainer.setContentDescription("Percentage tag " + tabItemModel.getId());
            }
            CardView tagContainer2 = viewHolder.getTagContainer();
            if (tagContainer2 != null) {
                if (tabItemModel.getShouldShowTag()) {
                    i12 = 0;
                }
                tagContainer2.setVisibility(i12);
            }
            TextView tagTv = viewHolder.getTagTv();
            if (tagTv != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Locale locale = Locale.ENGLISH;
                String string = context.getString(R.string.pickup_tab_discount);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…ring.pickup_tab_discount)");
                String format = String.format(locale, string, Arrays.copyOf(new Object[]{Integer.valueOf(tabItemModel.getTagPercentage())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
                tagTv.setText(format);
            }
            tabBarBinder.unselected(context, viewHolder);
        }

        private static int tagIcon(TabBarBinder tabBarBinder, TabItemModel tabItemModel) {
            if (tabItemModel.getId() == 0) {
                return com.designsystem.marshmallow.R.drawable.ds_delivery_bike_filled;
            }
            return com.designsystem.marshmallow.R.drawable.ds_walking;
        }

        private static float tagTextMarginStart(TabBarBinder tabBarBinder, Context context, TabItemModel tabItemModel, int i11) {
            int i12;
            Resources resources = context.getResources();
            if (!tabItemModel.isShowIcon()) {
                i12 = com.designsystem.marshmallow.R.dimen.ds_zero;
            } else if (i11 == com.designsystem.marshmallow.R.drawable.ds_walking) {
                i12 = com.talabat.talabatcommon.R.dimen.toggle_tag_icon_1dp;
            } else {
                i12 = com.designsystem.marshmallow.R.dimen.ds_xxxs;
            }
            return resources.getDimension(i12);
        }
    }

    void initialState(@NotNull TabItemModel tabItemModel, @NotNull Context context, @NotNull TabBarWithTagView.ViewHolder viewHolder);

    void selected(@NotNull Context context, @NotNull TabBarWithTagView.ViewHolder viewHolder);

    void unselected(@NotNull Context context, @NotNull TabBarWithTagView.ViewHolder viewHolder);
}
