package com.talabat.talabatcommon.views.twolinesbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.talabat.talabatcommon.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/talabat/talabatcommon/views/twolinesbutton/TwoLinesButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyles", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "firstLineText", "getFirstLineText", "()Ljava/lang/String;", "setFirstLineText", "(Ljava/lang/String;)V", "secondLineFontSize", "getSecondLineFontSize", "()I", "setSecondLineFontSize", "(I)V", "secondLineText", "getSecondLineText", "setSecondLineText", "compileText", "", "init", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TwoLinesButton extends AppCompatButton {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private String firstLineText;
    private int secondLineFontSize;
    @NotNull
    private String secondLineText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TwoLinesButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.firstLineText = "";
        this.secondLineText = "";
        this.secondLineFontSize = -1;
    }

    private final void compileText() {
        boolean z11;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(this.firstLineText);
        if (this.secondLineText.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            spannableStringBuilder.append(StringUtils.LF);
            SpannableString spannableString = new SpannableString(this.secondLineText);
            if (this.secondLineFontSize > 0) {
                spannableString.setSpan(new AbsoluteSizeSpan(this.secondLineFontSize), 0, spannableString.length(), 18);
            }
            spannableStringBuilder.append(spannableString);
        }
        setText(spannableStringBuilder);
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
    public final String getFirstLineText() {
        return this.firstLineText;
    }

    public final int getSecondLineFontSize() {
        return this.secondLineFontSize;
    }

    @NotNull
    public final String getSecondLineText() {
        return this.secondLineText;
    }

    public final void init(@Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TwoLinesButton);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…styleable.TwoLinesButton)");
        try {
            String string = obtainStyledAttributes.getString(R.styleable.TwoLinesButton_firstLineText);
            String str = "";
            if (string == null) {
                string = str;
            }
            setFirstLineText(string);
            String string2 = obtainStyledAttributes.getString(R.styleable.TwoLinesButton_secondLineText);
            if (string2 != null) {
                str = string2;
            }
            setSecondLineText(str);
            setSecondLineFontSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.TwoLinesButton_secondLineFontSize, -1));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final void setFirstLineText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.firstLineText = str;
        compileText();
    }

    public final void setSecondLineFontSize(int i11) {
        this.secondLineFontSize = i11;
        compileText();
    }

    public final void setSecondLineText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.secondLineText = str;
        compileText();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TwoLinesButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.firstLineText = "";
        this.secondLineText = "";
        this.secondLineFontSize = -1;
        init(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TwoLinesButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.firstLineText = "";
        this.secondLineText = "";
        this.secondLineFontSize = -1;
        init(attributeSet);
    }
}
