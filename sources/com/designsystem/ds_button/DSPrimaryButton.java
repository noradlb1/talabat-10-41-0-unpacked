package com.designsystem.ds_button;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.designsystem.animation.CountAnimation;
import com.designsystem.marshmallow.R;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001aH\u0016J\b\u0010/\u001a\u000200H\u0002R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b@FX\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u001a8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\n\u001a\u0004\u0018\u00010#8F@FX\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u000e¢\u0006\f\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010¨\u00061"}, d2 = {"Lcom/designsystem/ds_button/DSPrimaryButton;", "Lcom/designsystem/ds_button/DSButton;", "Lcom/designsystem/ds_button/DSButtonDataSource;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "centerText", "getCenterText", "()Ljava/lang/String;", "setCenterText", "(Ljava/lang/String;)V", "count", "getCount", "()Ljava/lang/Integer;", "setCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "details", "getDetails", "setDetails", "", "dsIsEnabled", "getDsIsEnabled", "()Z", "setDsIsEnabled", "(Z)V", "endText", "getEndText", "setEndText", "Landroid/graphics/drawable/Drawable;", "icon", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "startText", "getStartText", "setStartText", "getTheme", "Lcom/designsystem/ds_button/AttributedButton;", "isActive", "setupViewsVisibility", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This class has been replaced by 'com.designsystem.ds_button_v2.DSPrimaryButton'", replaceWith = @ReplaceWith(expression = "DSPrimaryButton", imports = {"com.designsystem.ds_button_v2.DSPrimaryButton"}))
public final class DSPrimaryButton extends DSButton implements DSButtonDataSource {
    public static final int $stable = 8;
    @Nullable
    private Integer count;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPrimaryButton(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPrimaryButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSPrimaryButton(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void setupViewsVisibility() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        ImageView imageView = (ImageView) findViewById(R.id.iconImageView);
        int i16 = 0;
        if (getIcon() != null) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        imageView.setVisibility(i11);
        TextView textView = (TextView) findViewById(R.id.centerTextView);
        if (!StringsKt__StringsJVMKt.isBlank(getCenterText())) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        textView.setVisibility(i12);
        TextView textView2 = (TextView) findViewById(R.id.startTextView);
        if (!StringsKt__StringsJVMKt.isBlank(getStartText())) {
            i13 = 0;
        } else {
            i13 = 8;
        }
        textView2.setVisibility(i13);
        TextView textView3 = (TextView) findViewById(R.id.endTextView);
        if (!StringsKt__StringsJVMKt.isBlank(getEndText())) {
            i14 = 0;
        } else {
            i14 = 8;
        }
        textView3.setVisibility(i14);
        TextView textView4 = (TextView) findViewById(R.id.detailsTextView);
        if (!StringsKt__StringsJVMKt.isBlank(getDetails())) {
            i15 = 0;
        } else {
            i15 = 8;
        }
        textView4.setVisibility(i15);
        View findViewById = findViewById(R.id.buttonCounter);
        if (this.count == null) {
            i16 = 8;
        }
        findViewById.setVisibility(i16);
    }

    public void _$_clearFindViewByIdCache() {
    }

    @NotNull
    public final String getCenterText() {
        return ((TextView) findViewById(R.id.centerTextView)).getText().toString();
    }

    @Nullable
    public final Integer getCount() {
        return this.count;
    }

    @NotNull
    public final String getDetails() {
        return ((TextView) findViewById(R.id.detailsTextView)).getText().toString();
    }

    public final boolean getDsIsEnabled() {
        return isEnabled();
    }

    @NotNull
    public final String getEndText() {
        return ((TextView) findViewById(R.id.endTextView)).getText().toString();
    }

    @Nullable
    public final Drawable getIcon() {
        return ((ImageView) findViewById(R.id.iconImageView)).getDrawable();
    }

    @NotNull
    public final String getStartText() {
        return ((TextView) findViewById(R.id.startTextView)).getText().toString();
    }

    @NotNull
    public AttributedButton getTheme(boolean z11) {
        DSButtonTheme dSButtonTheme;
        if (isLoading()) {
            dSButtonTheme = DSButtonTheme.primaryLoading;
        } else if (!getDsIsEnabled()) {
            dSButtonTheme = DSButtonTheme.primaryDisabled;
        } else if (z11) {
            dSButtonTheme = DSButtonTheme.primaryActive;
        } else {
            dSButtonTheme = DSButtonTheme.primaryPressed;
        }
        return dSButtonTheme.getValue();
    }

    public final void setCenterText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) findViewById(R.id.centerTextView)).setText(str);
        setupViewsVisibility();
    }

    public final void setCount(@Nullable Integer num) {
        int i11;
        if (num != null) {
            int i12 = 0;
            if (num.intValue() < 0) {
                i11 = 0;
            } else {
                i11 = num.intValue();
            }
            CountAnimation countAnimation = CountAnimation.INSTANCE;
            TextView textView = (TextView) findViewById(R.id.buttonCountAnimTv);
            Intrinsics.checkNotNullExpressionValue(textView, "buttonCountAnimTv");
            TextView textView2 = (TextView) findViewById(R.id.buttonCountTv);
            Intrinsics.checkNotNullExpressionValue(textView2, "buttonCountTv");
            Integer num2 = this.count;
            if (num2 != null) {
                i12 = num2.intValue();
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            countAnimation.setAnimatedCount(textView, textView2, i12, i11, context);
            num = Integer.valueOf(i11);
        }
        this.count = num;
        setupViewsVisibility();
    }

    public final void setDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) findViewById(R.id.detailsTextView)).setText(str);
        setupViewsVisibility();
    }

    public final void setDsIsEnabled(boolean z11) {
        setEnabled(z11);
        setupTheme(getTheme(getDsIsEnabled()));
    }

    public final void setEndText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) findViewById(R.id.endTextView)).setText(str);
        setupViewsVisibility();
    }

    public final void setIcon(@Nullable Drawable drawable) {
        ((ImageView) findViewById(R.id.iconImageView)).setImageDrawable(drawable);
        setupViewsVisibility();
    }

    public final void setStartText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) findViewById(R.id.startTextView)).setText(str);
        setupViewsVisibility();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSPrimaryButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        setDataSource(this);
        setIcon(getAttrIcon());
        setCenterText(getAttrCenterText());
        setStartText(getAttrStartText());
        setEndText(getAttrEndText());
        setDetails(getAttrDetails());
        setDsIsEnabled(getAttrIsEnabled());
        setCount(getAttrCount());
        setupViewsVisibility();
        setupTheme(getTheme(getDsIsEnabled()));
        setupTouchHandler();
    }
}
