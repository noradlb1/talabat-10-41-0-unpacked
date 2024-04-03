package com.talabat.darkstores.common.extensions;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.talabat.darkstores.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a1\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"styleGreySearchBar", "", "Landroidx/appcompat/widget/SearchView;", "styleMarshmallowSearchBar", "styleText", "textAppearanceResId", "", "hintTextColorColor", "overrideSearchIconColor", "(Landroidx/appcompat/widget/SearchView;IILjava/lang/Integer;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SearchViewExtensionsKt {
    public static /* synthetic */ void a(SearchView searchView, int i11, int i12, Integer num, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            num = null;
        }
        styleText(searchView, i11, i12, num);
    }

    public static final void styleGreySearchBar(@NotNull SearchView searchView) {
        Intrinsics.checkNotNullParameter(searchView, "<this>");
        searchView.setBackgroundResource(R.drawable.bgd_search_field_grey);
        searchView.getLayoutParams().height = searchView.getResources().getDimensionPixelOffset(com.designsystem.marshmallow.R.dimen.ds_xxl);
        a(searchView, com.designsystem.marshmallow.R.style.DSTextAppearance_Body0, ContextCompat.getColor(searchView.getContext(), com.designsystem.marshmallow.R.color.ds_neutral_55), (Integer) null, 4, (Object) null);
    }

    public static final void styleMarshmallowSearchBar(@NotNull SearchView searchView) {
        Intrinsics.checkNotNullParameter(searchView, "<this>");
        searchView.setBackgroundResource(R.drawable.bgd_search_field);
        searchView.getLayoutParams().height = searchView.getResources().getDimensionPixelOffset(R.dimen.default_view_height);
        int color = ContextCompat.getColor(searchView.getContext(), com.designsystem.marshmallow.R.color.ds_neutral_55);
        styleText(searchView, com.designsystem.marshmallow.R.style.DSTextAppearance_Body0, color, Integer.valueOf(color));
    }

    private static final void styleText(SearchView searchView, @StyleRes int i11, @ColorInt int i12, @ColorInt Integer num) {
        TextView textView = (TextView) searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        textView.setTextAppearance(i11);
        textView.setHintTextColor(i12);
        ImageView imageView = (ImageView) searchView.findViewById(androidx.appcompat.R.id.search_mag_icon);
        if (num != null) {
            imageView.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
        int dimensionPixelOffset = searchView.getResources().getDimensionPixelOffset(com.designsystem.marshmallow.R.dimen.ds_zero);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout.LayoutParams) layoutParams).setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
            if (layoutParams2 != null) {
                Resources resources = searchView.getResources();
                int i13 = com.designsystem.marshmallow.R.dimen.ds_m;
                ((LinearLayout.LayoutParams) layoutParams2).height = resources.getDimensionPixelOffset(i13);
                ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
                if (layoutParams3 != null) {
                    ((LinearLayout.LayoutParams) layoutParams3).width = searchView.getResources().getDimensionPixelOffset(i13);
                    ViewGroup.LayoutParams layoutParams4 = ((LinearLayout) searchView.findViewById(androidx.appcompat.R.id.search_edit_frame)).getLayoutParams();
                    if (layoutParams4 != null) {
                        ((LinearLayout.LayoutParams) layoutParams4).setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
}
