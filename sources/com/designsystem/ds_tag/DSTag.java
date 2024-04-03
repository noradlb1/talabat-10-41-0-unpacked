package com.designsystem.ds_tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u00015B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J\u000e\u0010\u000f\u001a\u00020-2\u0006\u0010\f\u001a\u00020\u0007J\u0012\u0010.\u001a\u00020-2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0017\u0010/\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020-2\u0006\u00100\u001a\u00020\u0007H\u0002J\u0017\u00103\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u00101J\u0010\u00104\u001a\u00020-2\u0006\u00100\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R&\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R&\u0010\u001e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R$\u0010\"\u001a\u00020!2\u0006\u0010\n\u001a\u00020!8F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u00020!2\u0006\u0010\n\u001a\u00020!8F@FX\u000e¢\u0006\f\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&¨\u00066"}, d2 = {"Lcom/designsystem/ds_tag/DSTag;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultPrimaryColor", "value", "Landroid/graphics/drawable/Drawable;", "icon", "getIcon", "()Landroid/graphics/drawable/Drawable;", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "iconColor", "getIconColor", "()I", "setIconColor", "(I)V", "primaryColor", "getPrimaryColor", "setPrimaryColor", "secondaryColor", "getSecondaryColor", "setSecondaryColor", "tagType", "Lcom/designsystem/ds_tag/DSTag$TagType;", "textColor", "getTextColor", "setTextColor", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "type", "getType", "setType", "dpToPx", "", "dp", "", "setupIcon", "setupIconColor", "color", "(Ljava/lang/Integer;)V", "setupPrimaryColor", "setupTextColor", "setupType", "TagType", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSTag extends ConstraintLayout {
    public static final int $stable = 8;
    private final int defaultPrimaryColor;
    @Nullable
    private Drawable icon;
    @ColorInt
    private int iconColor;
    @ColorInt
    private int primaryColor;
    @ColorInt
    private int secondaryColor;
    @NotNull
    private TagType tagType;
    @ColorInt
    private int textColor;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/designsystem/ds_tag/DSTag$TagType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FILLED", "STROKE", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum TagType {
        FILLED("0"),
        STROKE("1");
        
        @NotNull
        private final String value;

        private TagType(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTag(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTag(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSTag(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final float dpToPx(float f11) {
        return TypedValue.applyDimension(1, f11, getResources().getDisplayMetrics());
    }

    private final void setupIcon(Drawable drawable) {
        if (drawable != null) {
            int i11 = R.id.iconImageView;
            ((ImageView) findViewById(i11)).setVisibility(0);
            ((ImageView) findViewById(i11)).setImageDrawable(drawable);
            return;
        }
        ((ImageView) findViewById(R.id.iconImageView)).setVisibility(8);
    }

    private final void setupIconColor(Integer num) {
        if (num != null) {
            ((ImageView) findViewById(R.id.iconImageView)).setColorFilter(num.intValue());
        }
    }

    private final void setupPrimaryColor(int i11) {
        int i12;
        TextView textView = (TextView) findViewById(R.id.titleTextView);
        if (getTextColor() != 0) {
            i12 = getTextColor();
        } else {
            i12 = i11;
        }
        textView.setTextColor(i12);
        ImageView imageView = (ImageView) findViewById(R.id.iconImageView);
        int i13 = this.iconColor;
        if (i13 != 0) {
            i11 = i13;
        }
        imageView.setColorFilter(i11);
    }

    private final void setupTextColor(Integer num) {
        if (num != null) {
            ((TextView) findViewById(R.id.titleTextView)).setTextColor(num.intValue());
        }
    }

    private final void setupType(int i11) {
        int i12;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float dpToPx = dpToPx(13.0f);
        gradientDrawable.setCornerRadii(new float[]{dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx});
        if (this.tagType == TagType.FILLED) {
            i12 = i11;
        } else {
            i12 = ContextCompat.getColor(getContext(), R.color.ds_neutral_white);
        }
        gradientDrawable.setColor(i12);
        gradientDrawable.setStroke(2, i11);
        setBackground(gradientDrawable);
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final Drawable getIcon() {
        return this.icon;
    }

    public final int getIconColor() {
        return this.iconColor;
    }

    public final int getPrimaryColor() {
        return this.primaryColor;
    }

    public final int getSecondaryColor() {
        return this.secondaryColor;
    }

    public final int getTextColor() {
        return ((TextView) findViewById(R.id.titleTextView)).getCurrentTextColor();
    }

    @NotNull
    public final String getTitle() {
        return ((TextView) findViewById(R.id.titleTextView)).getText().toString();
    }

    @NotNull
    public final String getType() {
        return this.tagType.getValue();
    }

    public final void setIcon(@Nullable Drawable drawable) {
        this.icon = drawable;
        setupIcon(drawable);
    }

    public final void setIconColor(int i11) {
        this.iconColor = i11;
        setupIconColor(Integer.valueOf(i11));
    }

    public final void setPrimaryColor(int i11) {
        this.primaryColor = i11;
        setupPrimaryColor(i11);
    }

    public final void setSecondaryColor(int i11) {
        this.secondaryColor = i11;
        setupType(i11);
    }

    public final void setTextColor(int i11) {
        this.textColor = i11;
        setupTextColor(Integer.valueOf(i11));
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) findViewById(R.id.titleTextView)).setText(str);
    }

    public final void setType(@NotNull String str) {
        TagType tagType2;
        Intrinsics.checkNotNullParameter(str, "value");
        if (Intrinsics.areEqual((Object) str, (Object) "0")) {
            tagType2 = TagType.FILLED;
        } else {
            tagType2 = TagType.STROKE;
        }
        this.tagType = tagType2;
        setupType(this.secondaryColor);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTag(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(context, "context");
        int i14 = R.color.ds_neutral_100;
        this.defaultPrimaryColor = i14;
        TagType tagType2 = TagType.FILLED;
        this.tagType = tagType2;
        LayoutInflater.from(context).inflate(R.layout.ds_tag, this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSTag, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr… R.styleable.DSTag, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSTag_tg_title);
            setTitle(string == null ? "" : string);
            setIcon(obtainStyledAttributes.getDrawable(R.styleable.DSTag_tg_icon));
            String string2 = obtainStyledAttributes.getString(R.styleable.DSTag_tg_type);
            setType(string2 == null ? tagType2.getValue() : string2);
            try {
                Result.Companion companion = Result.Companion;
                i12 = Result.m6329constructorimpl(Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.DSTag_tg_iconColor, ContextCompat.getColor(context, i14))));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                i12 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            setIconColor(((Number) (Result.m6332exceptionOrNullimpl(i12) != null ? 0 : i12)).intValue());
            System.out.println(Intrinsics.stringPlus("iconColor:  ", Integer.valueOf(getIconColor())));
            try {
                i13 = Result.m6329constructorimpl(Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.DSTag_tg_textColor, 0)));
            } catch (Throwable th3) {
                Result.Companion companion3 = Result.Companion;
                i13 = Result.m6329constructorimpl(ResultKt.createFailure(th3));
            }
            setTextColor(((Number) (Result.m6332exceptionOrNullimpl(i13) != null ? 0 : i13)).intValue());
            System.out.println(Intrinsics.stringPlus("textColor:  ", Integer.valueOf(getTextColor())));
            setPrimaryColor(obtainStyledAttributes.getColor(R.styleable.DSTag_tg_primaryColor, ContextCompat.getColor(context, this.defaultPrimaryColor)));
            setSecondaryColor(obtainStyledAttributes.getColor(R.styleable.DSTag_tg_secondaryColor, ContextCompat.getColor(context, R.color.ds_neutral_35)));
            setupType(getSecondaryColor());
            obtainStyledAttributes.recycle();
        }
    }

    public final void setIcon(int i11) {
        setIcon(ContextCompat.getDrawable(getContext(), i11));
    }
}
