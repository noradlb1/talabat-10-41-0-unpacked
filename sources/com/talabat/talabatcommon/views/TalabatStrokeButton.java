package com.talabat.talabatcommon.views;

import android.animation.StateListAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.talabat.talabatcommon.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/TalabatStrokeButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatStrokeButton extends AppCompatButton {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatStrokeButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setTextAppearance(getContext(), R.style.buttonMedium);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.rounded_button_stroke));
        setTextColor(ContextCompat.getColorStateList(getContext(), R.color.stroke_button_text_color));
        setStateListAnimator((StateListAnimator) null);
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
    public TalabatStrokeButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setTextAppearance(getContext(), R.style.buttonMedium);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.rounded_button_stroke));
        setTextColor(ContextCompat.getColorStateList(getContext(), R.color.stroke_button_text_color));
        setStateListAnimator((StateListAnimator) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatStrokeButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        setTextAppearance(getContext(), R.style.buttonMedium);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.rounded_button_stroke));
        setTextColor(ContextCompat.getColorStateList(getContext(), R.color.stroke_button_text_color));
        setStateListAnimator((StateListAnimator) null);
    }
}
