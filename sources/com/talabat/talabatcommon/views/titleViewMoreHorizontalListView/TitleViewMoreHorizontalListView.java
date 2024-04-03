package com.talabat.talabatcommon.views.titleViewMoreHorizontalListView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatcommon/views/titleViewMoreHorizontalListView/TitleViewMoreHorizontalListView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "Landroid/view/View$OnClickListener;", "viewAllOnClickListener", "getViewAllOnClickListener", "()Landroid/view/View$OnClickListener;", "setViewAllOnClickListener", "(Landroid/view/View$OnClickListener;)V", "setViewAdapter", "", "adapter", "Landroidx/viewpager/widget/PagerAdapter;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TitleViewMoreHorizontalListView extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private String title;
    @Nullable
    private View.OnClickListener viewAllOnClickListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleViewMoreHorizontalListView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.title = "";
        LayoutInflater.from(getContext()).inflate(R.layout.view_title_view_more_horizontal_list, this, true);
        setOrientation(1);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final View.OnClickListener getViewAllOnClickListener() {
        return this.viewAllOnClickListener;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) _$_findCachedViewById(R.id.titleViewMoreTitleTextView)).setText(str);
        this.title = str;
    }

    public final void setViewAdapter(@NotNull PagerAdapter pagerAdapter) {
        Intrinsics.checkNotNullParameter(pagerAdapter, "adapter");
        int i11 = R.id.titleViewMoreViewPager;
        ((ViewPager) _$_findCachedViewById(i11)).setPageMargin(getResources().getDimensionPixelSize(R.dimen.standard_margin));
        if (IntegrationGlobalDataModel.Companion.isArabic()) {
            ((ViewPager) _$_findCachedViewById(i11)).setCurrentItem(pagerAdapter.getCount() - 1);
        }
        ((ViewPager) _$_findCachedViewById(i11)).setAdapter(pagerAdapter);
    }

    public final void setViewAllOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.viewAllOnClickListener = onClickListener;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.titleViewMoreViewAllImageView);
        imageView.setVisibility(0);
        imageView.setOnClickListener(this.viewAllOnClickListener);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleViewMoreHorizontalListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "";
        this.title = str;
        LayoutInflater.from(getContext()).inflate(R.layout.view_title_view_more_horizontal_list, this, true);
        setOrientation(1);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TitleViewMoreListView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…          0\n            )");
            String string = obtainStyledAttributes.getString(R.styleable.TitleViewMoreListView_Listtitle);
            setTitle(string != null ? string : str);
            obtainStyledAttributes.recycle();
            ((TextView) _$_findCachedViewById(R.id.titleViewMoreTitleTextView)).setText(this.title);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleViewMoreHorizontalListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.title = "";
        LayoutInflater.from(getContext()).inflate(R.layout.view_title_view_more_horizontal_list, this, true);
        setOrientation(1);
    }
}
