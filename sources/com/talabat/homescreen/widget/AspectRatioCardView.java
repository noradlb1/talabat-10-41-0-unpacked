package com.talabat.homescreen.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.talabat.homescreen.R;
import com.talabat.homescreen.adapter.model.vetrical.VerticalItem;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014J\u0016\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/homescreen/widget/AspectRatioCardView;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "aspectRatio", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "widthPercent", "getWidthPercent", "setWidthPercent", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "widthType", "Lcom/talabat/homescreen/adapter/model/vetrical/VerticalItem$WidthType;", "gapPerItem", "setWidthWithGap", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AspectRatioCardView extends CardView {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    private float aspectRatio;
    private float widthPercent;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VerticalItem.WidthType.values().length];
            iArr[VerticalItem.WidthType.QUOTER.ordinal()] = 1;
            iArr[VerticalItem.WidthType.HALF.ordinal()] = 2;
            iArr[VerticalItem.WidthType.FULL.ordinal()] = 3;
            iArr[VerticalItem.WidthType.THIRD.ordinal()] = 4;
            iArr[VerticalItem.WidthType.THREEFOURTHS.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AspectRatioCardView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AspectRatioCardView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AspectRatioCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AspectRatioCardView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…able.AspectRatioCardView)");
        setAspectRatio(obtainStyledAttributes.getFloat(R.styleable.AspectRatioCardView_aspect_ratio, -1.0f));
        setWidthPercent(obtainStyledAttributes.getFloat(R.styleable.AspectRatioCardView_width_percent, 100.0f));
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

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final float getWidthPercent() {
        return this.widthPercent;
    }

    public void onMeasure(int i11, int i12) {
        boolean z11;
        float size = ((float) View.MeasureSpec.getSize(i11)) * this.widthPercent;
        float f11 = this.aspectRatio;
        if (f11 == -1.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            i12 = View.MeasureSpec.makeMeasureSpec((int) (f11 * size), 1073741824);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) size, 1073741824), i12);
    }

    public final void setAspectRatio(float f11) {
        this.aspectRatio = f11;
        requestLayout();
    }

    public final void setWidthPercent(float f11) {
        this.widthPercent = f11 / 100.0f;
        requestLayout();
    }

    public final void setWidthWithGap(@NotNull VerticalItem.WidthType widthType) {
        Intrinsics.checkNotNullParameter(widthType, "widthType");
        int i11 = WhenMappings.$EnumSwitchMapping$0[widthType.ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3 || i11 == 4 || i11 == 5) {
            setWidthPercent(widthType.getPercent() - ((float) 5));
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setWidthPercent(@NotNull VerticalItem.WidthType widthType, float f11) {
        Intrinsics.checkNotNullParameter(widthType, "widthType");
        setWidthPercent(widthType.getPercent() - f11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AspectRatioCardView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
