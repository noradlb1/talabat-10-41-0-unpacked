package com.designsystem.ds_image;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010<\u001a\u00020=H\u0017¢\u0006\u0002\u0010>R9\u0010\u000b\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR9\u0010\u0013\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00122\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR+\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u00178F@FX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR9\u0010\u001e\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00122\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR9\u0010\"\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00122\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR/\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\t\u001a\u0004\u0018\u00010&8F@FX\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R/\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\t\u001a\u0004\u0018\u00010-8F@FX\u0002¢\u0006\u0012\n\u0004\b3\u0010\u0011\u001a\u0004\b/\u00100\"\u0004\b1\u00102R/\u00104\u001a\u0004\u0018\u00010-2\b\u0010\t\u001a\u0004\u0018\u00010-8F@FX\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0011\u001a\u0004\b5\u00100\"\u0004\b6\u00102R9\u00108\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00122\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b;\u0010\u0011\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000f¨\u0006?"}, d2 = {"Lcom/designsystem/ds_image/DSRatioImage;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Landroidx/annotation/ColorRes;", "borderColor", "getBorderColor", "()Ljava/lang/Integer;", "setBorderColor", "(Ljava/lang/Integer;)V", "borderColor$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/annotation/DimenRes;", "borderWidth", "getBorderWidth", "setBorderWidth", "borderWidth$delegate", "Landroidx/compose/ui/layout/ContentScale;", "contentScale", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "contentScale$delegate", "cornerRadius", "getCornerRadius", "setCornerRadius", "cornerRadius$delegate", "height", "getHeight", "setHeight", "height$delegate", "Lcom/designsystem/ds_image/DSImageRatio;", "imageRatio", "getImageRatio", "()Lcom/designsystem/ds_image/DSImageRatio;", "setImageRatio", "(Lcom/designsystem/ds_image/DSImageRatio;)V", "imageRatio$delegate", "", "imageUrl", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "imageUrl$delegate", "placeholderImageUrl", "getPlaceholderImageUrl", "setPlaceholderImageUrl", "placeholderImageUrl$delegate", "width", "getWidth", "setWidth", "width$delegate", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSRatioImage extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState borderColor$delegate;
    @NotNull
    private final MutableState borderWidth$delegate;
    @NotNull
    private final MutableState contentScale$delegate;
    @NotNull
    private final MutableState cornerRadius$delegate;
    @NotNull
    private final MutableState height$delegate;
    @NotNull
    private final MutableState imageRatio$delegate;
    @NotNull
    private final MutableState imageUrl$delegate;
    @NotNull
    private final MutableState placeholderImageUrl$delegate;
    @NotNull
    private final MutableState width$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSRatioImage(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSRatioImage(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSRatioImage(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        Dp dp2;
        float f11;
        Dp dp3;
        float f12;
        Dp dp4;
        float f13;
        Dp dp5;
        Color color;
        int i13;
        int i14 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-991488927);
        if ((i14 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i14;
        } else {
            i12 = i14;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            if (getImageUrl() != null) {
                DSImageRatio imageRatio = getImageRatio();
            }
            String imageUrl = getImageUrl();
            if (imageUrl == null) {
                imageUrl = "";
            }
            DSImageRatio imageRatio2 = getImageRatio();
            if (imageRatio2 == null) {
                imageRatio2 = DSImageRatio.OneToOne;
            }
            String placeholderImageUrl = getPlaceholderImageUrl();
            Integer width = getWidth();
            if (width == null) {
                startRestartGroup.startReplaceableGroup(-671374380);
                startRestartGroup.endReplaceableGroup();
                dp2 = null;
            } else {
                startRestartGroup.startReplaceableGroup(-991488563);
                float dimensionResource = PrimitiveResources_androidKt.dimensionResource(width.intValue(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                dp2 = Dp.m5476boximpl(dimensionResource);
            }
            if (dp2 == null) {
                f11 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
            } else {
                f11 = dp2.m5492unboximpl();
            }
            float f14 = f11;
            Integer height = getHeight();
            if (height == null) {
                startRestartGroup.startReplaceableGroup(-671371807);
                startRestartGroup.endReplaceableGroup();
                dp3 = null;
            } else {
                startRestartGroup.startReplaceableGroup(-991488480);
                float dimensionResource2 = PrimitiveResources_androidKt.dimensionResource(height.intValue(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                dp3 = Dp.m5476boximpl(dimensionResource2);
            }
            if (dp3 == null) {
                f12 = Dp.Companion.m5498getUnspecifiedD9Ej5fM();
            } else {
                f12 = dp3.m5492unboximpl();
            }
            float f15 = f12;
            ContentScale contentScale = getContentScale();
            Integer cornerRadius = getCornerRadius();
            if (cornerRadius == null) {
                startRestartGroup.startReplaceableGroup(-671367591);
                startRestartGroup.endReplaceableGroup();
                dp4 = null;
            } else {
                startRestartGroup.startReplaceableGroup(-991488344);
                float dimensionResource3 = PrimitiveResources_androidKt.dimensionResource(cornerRadius.intValue(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                dp4 = Dp.m5476boximpl(dimensionResource3);
            }
            if (dp4 == null) {
                f13 = Dp.m5478constructorimpl((float) 0);
            } else {
                f13 = dp4.m5492unboximpl();
            }
            float f16 = f13;
            Integer borderWidth = getBorderWidth();
            if (borderWidth == null) {
                startRestartGroup.startReplaceableGroup(-671363871);
                startRestartGroup.endReplaceableGroup();
                dp5 = null;
            } else {
                startRestartGroup.startReplaceableGroup(-991488224);
                float dimensionResource4 = PrimitiveResources_androidKt.dimensionResource(borderWidth.intValue(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                dp5 = Dp.m5476boximpl(dimensionResource4);
            }
            Integer borderColor = getBorderColor();
            if (borderColor == null) {
                startRestartGroup.startReplaceableGroup(-671361546);
                startRestartGroup.endReplaceableGroup();
                color = null;
            } else {
                startRestartGroup.startReplaceableGroup(-991488149);
                long colorResource = ColorResources_androidKt.colorResource(borderColor.intValue(), startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                color = Color.m2909boximpl(colorResource);
            }
            DSRatioImageKt.m8361DSRatioImageDSyytA(imageUrl, imageRatio2, (Modifier) null, placeholderImageUrl, f14, f15, contentScale, f16, color, dp5, startRestartGroup, 0, 4);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSRatioImage$Content$7(this, i14));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final Integer getBorderColor() {
        return (Integer) this.borderColor$delegate.getValue();
    }

    @Nullable
    public final Integer getBorderWidth() {
        return (Integer) this.borderWidth$delegate.getValue();
    }

    @NotNull
    public final ContentScale getContentScale() {
        return (ContentScale) this.contentScale$delegate.getValue();
    }

    @Nullable
    public final Integer getCornerRadius() {
        return (Integer) this.cornerRadius$delegate.getValue();
    }

    @Nullable
    public final Integer getHeight() {
        return (Integer) this.height$delegate.getValue();
    }

    @Nullable
    public final DSImageRatio getImageRatio() {
        return (DSImageRatio) this.imageRatio$delegate.getValue();
    }

    @Nullable
    public final String getImageUrl() {
        return (String) this.imageUrl$delegate.getValue();
    }

    @Nullable
    public final String getPlaceholderImageUrl() {
        return (String) this.placeholderImageUrl$delegate.getValue();
    }

    @Nullable
    public final Integer getWidth() {
        return (Integer) this.width$delegate.getValue();
    }

    public final void setBorderColor(@Nullable Integer num) {
        this.borderColor$delegate.setValue(num);
    }

    public final void setBorderWidth(@Nullable Integer num) {
        this.borderWidth$delegate.setValue(num);
    }

    public final void setContentScale(@NotNull ContentScale contentScale) {
        Intrinsics.checkNotNullParameter(contentScale, "<set-?>");
        this.contentScale$delegate.setValue(contentScale);
    }

    public final void setCornerRadius(@Nullable Integer num) {
        this.cornerRadius$delegate.setValue(num);
    }

    public final void setHeight(@Nullable Integer num) {
        this.height$delegate.setValue(num);
    }

    public final void setImageRatio(@Nullable DSImageRatio dSImageRatio) {
        this.imageRatio$delegate.setValue(dSImageRatio);
    }

    public final void setImageUrl(@Nullable String str) {
        this.imageUrl$delegate.setValue(str);
    }

    public final void setPlaceholderImageUrl(@Nullable String str) {
        this.placeholderImageUrl$delegate.setValue(str);
    }

    public final void setWidth(@Nullable Integer num) {
        this.width$delegate.setValue(num);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSRatioImage(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.imageUrl$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.imageRatio$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.placeholderImageUrl$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.width$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.height$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.contentScale$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ContentScale.Companion.getCrop(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.cornerRadius$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.borderWidth$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.borderColor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSRatioImage, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…eable.DSRatioImage, 0, 0)");
            setImageUrl(obtainStyledAttributes.getString(R.styleable.DSRatioImage_ri_image_url));
            int i12 = R.styleable.DSRatioImage_ri_image_ratio;
            DSImageRatio dSImageRatio = DSImageRatio.OneToOne;
            int i13 = obtainStyledAttributes.getInt(i12, -1);
            setImageRatio(i13 >= 0 ? DSImageRatio.values()[i13] : dSImageRatio);
            setPlaceholderImageUrl(obtainStyledAttributes.getString(R.styleable.DSRatioImage_ri_placeholder_image_url));
            setWidth(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSRatioImage_ri_width));
            setHeight(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSRatioImage_ri_height));
            setCornerRadius(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSRatioImage_ri_corner_radius));
            setBorderWidth(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSRatioImage_ri_border_width));
            setBorderColor(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSRatioImage_ri_border_color));
            obtainStyledAttributes.recycle();
        }
    }
}
