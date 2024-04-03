package com.marshmallow;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import com.talabat.marshmallow.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010 \u001a\u00020!2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\"\u001a\u00020!H\u0002R$\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00178F@FX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/marshmallow/TalabatTag;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "tagBg", "getTagBg", "()I", "setTagBg", "(I)V", "tagIcon", "getTagIcon", "setTagIcon", "tagIconTint", "getTagIconTint", "setTagIconTint", "", "tagText", "getTagText", "()Ljava/lang/String;", "setTagText", "(Ljava/lang/String;)V", "tagTextColor", "getTagTextColor", "setTagTextColor", "initTagView", "", "updateUi", "com_talabat_NewArchi_Marshmallow_Marshmallow"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatTag extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private int tagBg;
    private int tagIcon;
    private int tagIconTint;
    private int tagTextColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatTag(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initTagView((AttributeSet) null);
    }

    private final void initTagView(AttributeSet attributeSet) {
        View.inflate(getContext(), R.layout.view_talabat_tag, this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TalabatTag);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…, R.styleable.TalabatTag)");
        String string = obtainStyledAttributes.getString(R.styleable.TalabatTag_tag_text);
        if (string != null) {
            setTagText(string);
        }
        setTagIcon(obtainStyledAttributes.getResourceId(R.styleable.TalabatTag_tag_icon, 0));
        setTagBg(obtainStyledAttributes.getResourceId(R.styleable.TalabatTag_tag_bg, 0));
        setTagIconTint(obtainStyledAttributes.getResourceId(R.styleable.TalabatTag_tag_Icon_tint, 0));
        setTagTextColor(obtainStyledAttributes.getResourceId(R.styleable.TalabatTag_tag_text_color, 0));
        obtainStyledAttributes.recycle();
    }

    private final void updateUi() {
        invalidate();
        requestLayout();
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

    public final int getTagBg() {
        return this.tagBg;
    }

    public final int getTagIcon() {
        return this.tagIcon;
    }

    public final int getTagIconTint() {
        return this.tagIconTint;
    }

    @NotNull
    public final String getTagText() {
        return ((TextView) _$_findCachedViewById(R.id.tagTextView)).getText().toString();
    }

    public final int getTagTextColor() {
        return this.tagTextColor;
    }

    public final void setTagBg(int i11) {
        ((LinearLayout) _$_findCachedViewById(R.id.tagContainer)).setBackgroundResource(i11);
        updateUi();
        this.tagBg = i11;
    }

    public final void setTagIcon(int i11) {
        if (i11 > 0) {
            int i12 = R.id.tagImageView;
            ((ImageView) _$_findCachedViewById(i12)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(i12)).setImageResource(i11);
            this.tagIcon = i11;
        } else {
            ((ImageView) _$_findCachedViewById(R.id.tagImageView)).setVisibility(8);
        }
        updateUi();
    }

    public final void setTagIconTint(int i11) {
        if (i11 > 0) {
            ImageViewCompat.setImageTintList((ImageView) _$_findCachedViewById(R.id.tagImageView), ColorStateList.valueOf(ContextCompat.getColor(getContext(), i11)));
            this.tagIconTint = i11;
        }
        updateUi();
    }

    public final void setTagText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) _$_findCachedViewById(R.id.tagTextView)).setText(str);
        updateUi();
    }

    public final void setTagTextColor(int i11) {
        if (i11 > 0) {
            ((TextView) _$_findCachedViewById(R.id.tagTextView)).setTextColor(ContextCompat.getColor(getContext(), i11));
            updateUi();
            this.tagTextColor = i11;
        }
        updateUi();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatTag(@NotNull Context context, @Nullable @androidx.annotation.Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initTagView(attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatTag(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        initTagView(attributeSet);
    }
}
