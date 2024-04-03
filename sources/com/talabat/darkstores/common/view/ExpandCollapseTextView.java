package com.talabat.darkstores.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.talabat.darkstores.R;
import com.talabat.talabatcommon.extension.ViewKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u001c\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006 "}, d2 = {"Lcom/talabat/darkstores/common/view/ExpandCollapseTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "linesCollapsePoint", "getLinesCollapsePoint", "()I", "setLinesCollapsePoint", "(I)V", "linesLimit", "getLinesLimit", "setLinesLimit", "drawWithSpanIfNeeded", "", "onSizeChanged", "w", "h", "oldw", "oldh", "setText", "t", "", "type", "Landroid/widget/TextView$BufferType;", "showCollapsedTextWithMore", "showExpandedTextWithLess", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExpandCollapseTextView extends AppCompatTextView {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String ELLIPSIZE = "... ";
    public static final int MAX_LIMIT = 100;
    public static final int MAX_LINES_DEFAULT = 2;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    private int linesCollapsePoint;
    private int linesLimit;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/common/view/ExpandCollapseTextView$Companion;", "", "()V", "ELLIPSIZE", "", "MAX_LIMIT", "", "MAX_LINES_DEFAULT", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandCollapseTextView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandCollapseTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandCollapseTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.linesCollapsePoint = 2;
        this.linesLimit = 2;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandOnceTextView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…eable.ExpandOnceTextView)");
            int integer = obtainStyledAttributes.getInteger(R.styleable.ExpandOnceTextView_lines_limit, 2);
            this.linesLimit = integer;
            this.linesCollapsePoint = integer;
            obtainStyledAttributes.recycle();
        }
    }

    private final void drawWithSpanIfNeeded() {
        if (getTag() == null || Intrinsics.areEqual(getTag(), (Object) "")) {
            setTag(getText());
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ExpandCollapseTextView$drawWithSpanIfNeeded$1(this));
    }

    /* access modifiers changed from: private */
    public final void showCollapsedTextWithMore() {
        boolean z11;
        String str;
        String string = ViewKt.getString(this, com.talabat.localization.R.string.more);
        String str2 = ELLIPSIZE + string;
        int lineEnd = getLayout().getLineEnd(this.linesLimit - 1);
        if (lineEnd - str2.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str = getText().subSequence(0, (lineEnd - str2.length()) + 1) + str2;
        } else {
            str = StringsKt__StringsKt.trimEnd((CharSequence) getText().subSequence(0, lineEnd).toString()).toString() + str2;
        }
        ExpandCollapseTextView$showCollapsedTextWithMore$moreClick$1 expandCollapseTextView$showCollapsedTextWithMore$moreClick$1 = new ExpandCollapseTextView$showCollapsedTextWithMore$moreClick$1(this);
        SpannableString spannableString = new SpannableString(str);
        SpannableString spannableString2 = spannableString;
        String str3 = string;
        spannableString.setSpan(expandCollapseTextView$showCollapsedTextWithMore$moreClick$1, StringsKt__StringsKt.indexOf$default((CharSequence) spannableString2, str3, 0, false, 6, (Object) null), StringsKt__StringsKt.indexOf$default((CharSequence) spannableString2, str3, 0, false, 6, (Object) null) + string.length(), 33);
        setMovementMethod(LinkMovementMethod.getInstance());
        setText(spannableString);
    }

    /* access modifiers changed from: private */
    public final void showExpandedTextWithLess() {
        String string = ViewKt.getString(this, com.talabat.localization.R.string.less);
        if (getLineCount() > this.linesCollapsePoint) {
            ExpandCollapseTextView$showExpandedTextWithLess$clickableSpan$1 expandCollapseTextView$showExpandedTextWithLess$clickableSpan$1 = new ExpandCollapseTextView$showExpandedTextWithLess$clickableSpan$1(this);
            SpannableString spannableString = new SpannableString(getText() + " " + string);
            SpannableString spannableString2 = spannableString;
            String str = string;
            spannableString.setSpan(expandCollapseTextView$showExpandedTextWithLess$clickableSpan$1, StringsKt__StringsKt.indexOf$default((CharSequence) spannableString2, str, 0, false, 6, (Object) null), StringsKt__StringsKt.indexOf$default((CharSequence) spannableString2, str, 0, false, 6, (Object) null) + string.length(), 33);
            setMovementMethod(LinkMovementMethod.getInstance());
            setText(spannableString);
        }
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

    public final int getLinesCollapsePoint() {
        return this.linesCollapsePoint;
    }

    public final int getLinesLimit() {
        return this.linesLimit;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public final void setLinesCollapsePoint(int i11) {
        this.linesCollapsePoint = i11;
    }

    public final void setLinesLimit(int i11) {
        this.linesLimit = i11;
    }

    public void setText(@Nullable CharSequence charSequence, @Nullable TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (charSequence != null) {
            drawWithSpanIfNeeded();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExpandCollapseTextView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }
}
