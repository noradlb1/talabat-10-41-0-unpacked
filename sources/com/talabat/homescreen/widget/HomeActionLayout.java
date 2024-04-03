package com.talabat.homescreen.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.talabat.homescreen.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\r"}, d2 = {"Lcom/talabat/homescreen/widget/HomeActionLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "applyAttributes", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeActionLayout extends LinearLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeActionLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.layout_home_action, this);
        setOrientation(0);
    }

    private final void applyAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HomeActionLayout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…yleable.HomeActionLayout)");
        String string = obtainStyledAttributes.getString(R.styleable.HomeActionLayout_actionDescription);
        if (string != null) {
            ((TextView) _$_findCachedViewById(R.id.tvHomeActionLayoutTitle)).setText(string);
        }
        ((ImageView) _$_findCachedViewById(R.id.ivHomeActionLayoutIcon)).setImageResource(obtainStyledAttributes.getResourceId(R.styleable.HomeActionLayout_actionIcon, com.designsystem.marshmallow.R.drawable.ds_reorder));
        Unit unit = Unit.INSTANCE;
        obtainStyledAttributes.recycle();
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeActionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.layout_home_action, this);
        setOrientation(0);
        applyAttributes(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeActionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.layout_home_action, this);
        setOrientation(0);
        applyAttributes(attributeSet);
    }
}
