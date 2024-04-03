package com.designsystem.ds_button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import b6.a;
import com.designsystem.extensions.ContextExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u000e\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u000206R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010$\"\u0004\b1\u0010&R\u001a\u00102\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010$\"\u0004\b4\u0010&¨\u0006="}, d2 = {"Lcom/designsystem/ds_button/DSButton;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attrCenterText", "", "getAttrCenterText", "()Ljava/lang/String;", "setAttrCenterText", "(Ljava/lang/String;)V", "attrCount", "getAttrCount", "()Ljava/lang/Integer;", "setAttrCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "attrDetails", "getAttrDetails", "setAttrDetails", "attrEndText", "getAttrEndText", "setAttrEndText", "attrIcon", "Landroid/graphics/drawable/Drawable;", "getAttrIcon", "()Landroid/graphics/drawable/Drawable;", "setAttrIcon", "(Landroid/graphics/drawable/Drawable;)V", "attrIsEnabled", "", "getAttrIsEnabled", "()Z", "setAttrIsEnabled", "(Z)V", "attrStartText", "getAttrStartText", "setAttrStartText", "dataSource", "Lcom/designsystem/ds_button/DSButtonDataSource;", "getDataSource", "()Lcom/designsystem/ds_button/DSButtonDataSource;", "setDataSource", "(Lcom/designsystem/ds_button/DSButtonDataSource;)V", "isLoading", "setLoading", "retainTextColorForIcon", "getRetainTextColorForIcon", "setRetainTextColorForIcon", "addBorderAndCorner", "", "backgroundColor", "borderColor", "setupTheme", "theme", "Lcom/designsystem/ds_button/AttributedButton;", "setupTouchHandler", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This class has been replaced by buttons from package 'com.designsystem.ds_button_v2'")
public class DSButton extends RelativeLayout {
    public static final int $stable = 8;
    @NotNull
    private String attrCenterText;
    @Nullable
    private Integer attrCount;
    @NotNull
    private String attrDetails;
    @NotNull
    private String attrEndText;
    @Nullable
    private Drawable attrIcon;
    private boolean attrIsEnabled;
    @NotNull
    private String attrStartText;
    public DSButtonDataSource dataSource;
    private boolean isLoading;
    private boolean retainTextColorForIcon;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSButton(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSButton(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void addBorderAndCorner(int i11, int i12) {
        setBackgroundResource(R.drawable.ds_button_shape);
        Drawable background = getBackground();
        if (background != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            gradientDrawable.setColor(i11);
            gradientDrawable.setStroke(2, i12);
            setBackground(gradientDrawable);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    }

    /* access modifiers changed from: private */
    /* renamed from: setupTouchHandler$lambda-1  reason: not valid java name */
    public static final boolean m8285setupTouchHandler$lambda1(DSButton dSButton, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(dSButton, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            dSButton.setupTheme(dSButton.getDataSource().getTheme(false));
        } else if (action == 1) {
            dSButton.setupTheme(dSButton.getDataSource().getTheme(true));
            dSButton.performClick();
        }
        return true;
    }

    public void _$_clearFindViewByIdCache() {
    }

    @NotNull
    public final String getAttrCenterText() {
        return this.attrCenterText;
    }

    @Nullable
    public final Integer getAttrCount() {
        return this.attrCount;
    }

    @NotNull
    public final String getAttrDetails() {
        return this.attrDetails;
    }

    @NotNull
    public final String getAttrEndText() {
        return this.attrEndText;
    }

    @Nullable
    public final Drawable getAttrIcon() {
        return this.attrIcon;
    }

    public final boolean getAttrIsEnabled() {
        return this.attrIsEnabled;
    }

    @NotNull
    public final String getAttrStartText() {
        return this.attrStartText;
    }

    @NotNull
    public final DSButtonDataSource getDataSource() {
        DSButtonDataSource dSButtonDataSource = this.dataSource;
        if (dSButtonDataSource != null) {
            return dSButtonDataSource;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dataSource");
        return null;
    }

    public final boolean getRetainTextColorForIcon() {
        return this.retainTextColorForIcon;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final void setAttrCenterText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attrCenterText = str;
    }

    public final void setAttrCount(@Nullable Integer num) {
        this.attrCount = num;
    }

    public final void setAttrDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attrDetails = str;
    }

    public final void setAttrEndText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attrEndText = str;
    }

    public final void setAttrIcon(@Nullable Drawable drawable) {
        this.attrIcon = drawable;
    }

    public final void setAttrIsEnabled(boolean z11) {
        this.attrIsEnabled = z11;
    }

    public final void setAttrStartText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attrStartText = str;
    }

    public final void setDataSource(@NotNull DSButtonDataSource dSButtonDataSource) {
        Intrinsics.checkNotNullParameter(dSButtonDataSource, "<set-?>");
        this.dataSource = dSButtonDataSource;
    }

    public final void setLoading(boolean z11) {
        this.isLoading = z11;
    }

    public final void setRetainTextColorForIcon(boolean z11) {
        this.retainTextColorForIcon = z11;
    }

    public final void setupTheme(@NotNull AttributedButton attributedButton) {
        Intrinsics.checkNotNullParameter(attributedButton, "theme");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int colorCompat = ContextExtensionsKt.getColorCompat(context, attributedButton.getBackgroundColor());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int colorCompat2 = ContextExtensionsKt.getColorCompat(context2, attributedButton.getTextColor());
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        int colorCompat3 = ContextExtensionsKt.getColorCompat(context3, attributedButton.getBorderColor());
        setBackgroundColor(colorCompat);
        ((TextView) findViewById(R.id.centerTextView)).setTextColor(colorCompat2);
        ((TextView) findViewById(R.id.startTextView)).setTextColor(colorCompat2);
        ((TextView) findViewById(R.id.endTextView)).setTextColor(colorCompat2);
        ((TextView) findViewById(R.id.detailsTextView)).setTextColor(colorCompat2);
        ((TextView) findViewById(R.id.buttonCountTv)).setTextColor(colorCompat2);
        ((TextView) findViewById(R.id.buttonCountAnimTv)).setTextColor(colorCompat2);
        if (this.retainTextColorForIcon) {
            ((ImageView) findViewById(R.id.iconImageView)).setColorFilter(colorCompat2, PorterDuff.Mode.SRC_ATOP);
        }
        addBorderAndCorner(colorCompat, colorCompat3);
    }

    public final void setupTouchHandler() {
        setOnTouchListener(new a(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "";
        this.attrCenterText = str;
        this.attrStartText = str;
        this.attrEndText = str;
        this.attrDetails = str;
        this.attrIsEnabled = true;
        this.retainTextColorForIcon = true;
        LayoutInflater.from(context).inflate(R.layout.ds_button, this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSButton, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…styleable.DSButton, 0, 0)");
            setAttrIcon(obtainStyledAttributes.getDrawable(R.styleable.DSButton_ds_icon));
            String string = obtainStyledAttributes.getString(R.styleable.DSButton_ds_centerText);
            setAttrCenterText(string == null ? str : string);
            String string2 = obtainStyledAttributes.getString(R.styleable.DSButton_ds_startText);
            setAttrStartText(string2 == null ? str : string2);
            String string3 = obtainStyledAttributes.getString(R.styleable.DSButton_ds_endText);
            setAttrEndText(string3 == null ? str : string3);
            String string4 = obtainStyledAttributes.getString(R.styleable.DSButton_ds_details);
            setAttrDetails(string4 != null ? string4 : str);
            setAttrIsEnabled(obtainStyledAttributes.getBoolean(R.styleable.DSButton_ds_isEnabled, true));
            int i12 = R.styleable.DSButton_ds_retain_text_color_for_icon;
            setRetainTextColorForIcon(obtainStyledAttributes.getBoolean(i12, true));
            setRetainTextColorForIcon(obtainStyledAttributes.getBoolean(i12, true));
            int i13 = R.styleable.DSButton_ds_count;
            if (obtainStyledAttributes.hasValue(i13)) {
                setAttrCount(Integer.valueOf(obtainStyledAttributes.getInt(i13, 0)));
            }
            obtainStyledAttributes.recycle();
        }
    }
}
