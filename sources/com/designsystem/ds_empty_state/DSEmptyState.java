package com.designsystem.ds_empty_state;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.widget.ConstraintLayout;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\"\u001a\u00020#H\u0002R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\t\u001a\u0004\u0018\u00010\u00198F@FX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015¨\u0006$"}, d2 = {"Lcom/designsystem/ds_empty_state/DSEmptyState;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroid/view/View$OnClickListener;", "ctaClickListener", "getCtaClickListener", "()Landroid/view/View$OnClickListener;", "setCtaClickListener", "(Landroid/view/View$OnClickListener;)V", "", "ctaTitle", "getCtaTitle", "()Ljava/lang/String;", "setCtaTitle", "(Ljava/lang/String;)V", "details", "getDetails", "setDetails", "Landroid/graphics/drawable/Drawable;", "image", "getImage", "()Landroid/graphics/drawable/Drawable;", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "title", "getTitle", "setTitle", "setupViewsVisibility", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "Use DSEmptyState, DSEmptyStateWithIcon, DSEmptyStateWithLargeIllustration or DSEmptyStateWithSmallIllustration from 'com.designsystem.ds_empty_state_v2' instead", replaceWith = @ReplaceWith(expression = "com.designsystem.ds_empty_state_v2", imports = {"com.designsystem.ds_empty_state_v2"}))
public final class DSEmptyState extends ConstraintLayout {
    public static final int $stable = 8;
    @Nullable
    private View.OnClickListener ctaClickListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyState(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyState(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSEmptyState(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void setupViewsVisibility() {
        boolean z11;
        ((TextView) findViewById(R.id.empty_state_title)).setVisibility(0);
        ((TextView) findViewById(R.id.empty_state_description)).setVisibility(0);
        if (getImage() != null) {
            ((ImageView) findViewById(R.id.empty_state_image)).setVisibility(0);
        } else {
            ((ImageView) findViewById(R.id.empty_state_image)).setVisibility(8);
        }
        String ctaTitle = getCtaTitle();
        if (ctaTitle == null || StringsKt__StringsJVMKt.isBlank(ctaTitle)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            ((TextView) findViewById(R.id.empty_state_cta)).setVisibility(0);
        } else {
            ((TextView) findViewById(R.id.empty_state_cta)).setVisibility(8);
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final View.OnClickListener getCtaClickListener() {
        return this.ctaClickListener;
    }

    @Nullable
    public final String getCtaTitle() {
        return ((TextView) findViewById(R.id.empty_state_cta)).getText().toString();
    }

    @NotNull
    public final String getDetails() {
        return ((TextView) findViewById(R.id.empty_state_description)).getText().toString();
    }

    @Nullable
    public final Drawable getImage() {
        return ((ImageView) findViewById(R.id.empty_state_image)).getDrawable();
    }

    @NotNull
    public final String getTitle() {
        return ((TextView) findViewById(R.id.empty_state_title)).getText().toString();
    }

    public final void setCtaClickListener(@Nullable View.OnClickListener onClickListener) {
        ((TextView) findViewById(R.id.empty_state_cta)).setOnClickListener(onClickListener);
    }

    public final void setCtaTitle(@Nullable String str) {
        ((TextView) findViewById(R.id.empty_state_cta)).setText(str);
        setupViewsVisibility();
    }

    public final void setDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) findViewById(R.id.empty_state_description)).setText(str);
        setupViewsVisibility();
    }

    public final void setImage(@Nullable Drawable drawable) {
        ((ImageView) findViewById(R.id.empty_state_image)).setImageDrawable(drawable);
        setupViewsVisibility();
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((TextView) findViewById(R.id.empty_state_title)).setText(str);
        setupViewsVisibility();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyState(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.ds_empty_state, this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSEmptyState, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…eable.DSEmptyState, 0, 0)");
            setImage(obtainStyledAttributes.getDrawable(R.styleable.DSEmptyState_es_image));
            String string = obtainStyledAttributes.getString(R.styleable.DSEmptyState_es_title);
            String str = "";
            setTitle(string == null ? str : string);
            String string2 = obtainStyledAttributes.getString(R.styleable.DSEmptyState_es_details);
            setDetails(string2 == null ? str : string2);
            String string3 = obtainStyledAttributes.getString(R.styleable.DSEmptyState_es_ctaTitle);
            setCtaTitle(string3 != null ? string3 : str);
            setupViewsVisibility();
            obtainStyledAttributes.recycle();
        }
    }
}
