package com.designsystem.ds_box_shadow;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_theme.DSElevationKt;
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J$\u0010\u0017\u001a\u0002062\n\b\u0001\u00107\u001a\u0004\u0018\u00010\u0007H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b8\u00109J\b\u0010:\u001a\u00020;H\u0016R9\u0010\u000b\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR9\u0010\u0012\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR9\u0010\u0016\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R9\u0010#\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n8F@FX\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0011\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR9\u0010'\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n2\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\n8F@FX\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR+\u0010,\u001a\u00020+2\u0006\u0010\t\u001a\u00020+8F@FX\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0011\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006<"}, d2 = {"Lcom/designsystem/ds_box_shadow/DSBoxShadowLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Landroidx/annotation/DimenRes;", "bottomEndCornerRadius", "getBottomEndCornerRadius", "()Ljava/lang/Integer;", "setBottomEndCornerRadius", "(Ljava/lang/Integer;)V", "bottomEndCornerRadius$delegate", "Lcom/designsystem/ds_box_shadow/OnUpdate;", "bottomStartCornerRadius", "getBottomStartCornerRadius", "setBottomStartCornerRadius", "bottomStartCornerRadius$delegate", "cornerRadius", "getCornerRadius", "setCornerRadius", "cornerRadius$delegate", "density", "", "getDensity", "()F", "shadows", "", "Lcom/designsystem/ds_box_shadow/Shadow;", "getShadows", "()Ljava/util/List;", "topEndCornerRadius", "getTopEndCornerRadius", "setTopEndCornerRadius", "topEndCornerRadius$delegate", "topStartCornerRadius", "getTopStartCornerRadius", "setTopStartCornerRadius", "topStartCornerRadius$delegate", "Lcom/designsystem/ds_box_shadow/DSBoxShadowType;", "type", "getType", "()Lcom/designsystem/ds_box_shadow/DSBoxShadowType;", "setType", "(Lcom/designsystem/ds_box_shadow/DSBoxShadowType;)V", "type$delegate", "draw", "", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/unit/Dp;", "id", "getCornerRadius-u2uoSUM", "(Ljava/lang/Integer;)F", "getOutlineProvider", "Landroid/view/ViewOutlineProvider;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSBoxShadowLayout extends FrameLayout {
    public static final int $stable = 8;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f30606b;
    @NotNull
    private final OnUpdate bottomEndCornerRadius$delegate;
    @NotNull
    private final OnUpdate bottomStartCornerRadius$delegate;
    @NotNull
    private final OnUpdate cornerRadius$delegate;
    @NotNull
    private final OnUpdate topEndCornerRadius$delegate;
    @NotNull
    private final OnUpdate topStartCornerRadius$delegate;
    @NotNull
    private final OnUpdate type$delegate;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DSBoxShadowType.values().length];
            iArr[DSBoxShadowType.SMALL.ordinal()] = 1;
            iArr[DSBoxShadowType.MEDIUM.ordinal()] = 2;
            iArr[DSBoxShadowType.LARGE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Class<DSBoxShadowLayout> cls = DSBoxShadowLayout.class;
        f30606b = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "type", "getType()Lcom/designsystem/ds_box_shadow/DSBoxShadowType;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "topStartCornerRadius", "getTopStartCornerRadius()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "topEndCornerRadius", "getTopEndCornerRadius()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "bottomStartCornerRadius", "getBottomStartCornerRadius()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "bottomEndCornerRadius", "getBottomEndCornerRadius()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "cornerRadius", "getCornerRadius()Ljava/lang/Integer;", 0))};
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBoxShadowLayout(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBoxShadowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSBoxShadowLayout(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* renamed from: getCornerRadius-u2uoSUM  reason: not valid java name */
    private final float m8268getCornerRadiusu2uoSUM(@DimenRes Integer num) {
        Float f11;
        float f12;
        Integer cornerRadius = getCornerRadius();
        if (cornerRadius == null) {
            f11 = null;
        } else {
            f11 = Float.valueOf(getContext().getResources().getDimension(cornerRadius.intValue()));
        }
        if (f11 != null) {
            f12 = f11.floatValue();
        } else if (num == null) {
            f12 = 0.0f;
        } else {
            f12 = getContext().getResources().getDimension(num.intValue());
        }
        return Dp.m5478constructorimpl(f12 / getDensity());
    }

    private final float getDensity() {
        return ((float) Resources.getSystem().getDisplayMetrics().densityDpi) / ((float) Opcodes.IF_ICMPNE);
    }

    private final List<Shadow> getShadows() {
        int i11 = WhenMappings.$EnumSwitchMapping$0[getType().ordinal()];
        if (i11 == 1) {
            return DSElevationKt.getDefaultDSElevation().getDsElevationSmall();
        }
        if (i11 == 2) {
            return DSElevationKt.getDefaultDSElevation().getDsElevationMedium();
        }
        if (i11 == 3) {
            return DSElevationKt.getDefaultDSElevation().getDsElevationLarge();
        }
        throw new NoWhenBranchMatchedException();
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void draw(@Nullable Canvas canvas) {
        if (canvas != null) {
            List<Shadow> shadows = getShadows();
            RoundedCornerShape r12 = RoundedCornerShapeKt.m822RoundedCornerShapea9UjIt4(m8268getCornerRadiusu2uoSUM(getTopStartCornerRadius()), m8268getCornerRadiusu2uoSUM(getTopEndCornerRadius()), m8268getCornerRadiusu2uoSUM(getBottomEndCornerRadius()), m8268getCornerRadiusu2uoSUM(getBottomStartCornerRadius()));
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            BoxShadowDrawingKt.drawBoxShadow(canvas, shadows, r12, context, getDensity());
            super.draw(canvas);
        }
    }

    @Nullable
    public final Integer getBottomEndCornerRadius() {
        return (Integer) this.bottomEndCornerRadius$delegate.getValue((View) this, (KProperty<?>) f30606b[4]);
    }

    @Nullable
    public final Integer getBottomStartCornerRadius() {
        return (Integer) this.bottomStartCornerRadius$delegate.getValue((View) this, (KProperty<?>) f30606b[3]);
    }

    @Nullable
    public final Integer getCornerRadius() {
        return (Integer) this.cornerRadius$delegate.getValue((View) this, (KProperty<?>) f30606b[5]);
    }

    @NotNull
    public ViewOutlineProvider getOutlineProvider() {
        return new DSBoxShadowLayout$getOutlineProvider$1();
    }

    @Nullable
    public final Integer getTopEndCornerRadius() {
        return (Integer) this.topEndCornerRadius$delegate.getValue((View) this, (KProperty<?>) f30606b[2]);
    }

    @Nullable
    public final Integer getTopStartCornerRadius() {
        return (Integer) this.topStartCornerRadius$delegate.getValue((View) this, (KProperty<?>) f30606b[1]);
    }

    @NotNull
    public final DSBoxShadowType getType() {
        return (DSBoxShadowType) this.type$delegate.getValue((View) this, (KProperty<?>) f30606b[0]);
    }

    public final void setBottomEndCornerRadius(@Nullable Integer num) {
        this.bottomEndCornerRadius$delegate.setValue((View) this, (KProperty<?>) f30606b[4], num);
    }

    public final void setBottomStartCornerRadius(@Nullable Integer num) {
        this.bottomStartCornerRadius$delegate.setValue((View) this, (KProperty<?>) f30606b[3], num);
    }

    public final void setCornerRadius(@Nullable Integer num) {
        this.cornerRadius$delegate.setValue((View) this, (KProperty<?>) f30606b[5], num);
    }

    public final void setTopEndCornerRadius(@Nullable Integer num) {
        this.topEndCornerRadius$delegate.setValue((View) this, (KProperty<?>) f30606b[2], num);
    }

    public final void setTopStartCornerRadius(@Nullable Integer num) {
        this.topStartCornerRadius$delegate.setValue((View) this, (KProperty<?>) f30606b[1], num);
    }

    public final void setType(@NotNull DSBoxShadowType dSBoxShadowType) {
        Intrinsics.checkNotNullParameter(dSBoxShadowType, "<set-?>");
        this.type$delegate.setValue((View) this, (KProperty<?>) f30606b[0], dSBoxShadowType);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBoxShadowLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        Intrinsics.checkNotNullParameter(context2, "context");
        DSBoxShadowType dSBoxShadowType = DSBoxShadowType.SMALL;
        this.type$delegate = new OnUpdate(dSBoxShadowType, (Function1) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        this.topStartCornerRadius$delegate = new OnUpdate((Object) null, (Function1) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        this.topEndCornerRadius$delegate = new OnUpdate((Object) null, (Function1) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        this.bottomStartCornerRadius$delegate = new OnUpdate((Object) null, (Function1) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        this.bottomEndCornerRadius$delegate = new OnUpdate((Object) null, (Function1) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        this.cornerRadius$delegate = new OnUpdate((Object) null, (Function1) null, (Function1) null, 6, (DefaultConstructorMarker) null);
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, R.styleable.DSBoxShadowLayout, i11, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…wLayout, defStyleAttr, 0)");
            int i12 = obtainStyledAttributes.getInt(R.styleable.DSBoxShadowLayout_bsl_type, -1);
            setType(i12 >= 0 ? DSBoxShadowType.values()[i12] : dSBoxShadowType);
            setTopStartCornerRadius(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSBoxShadowLayout_bsl_top_start_corner_radius));
            setTopEndCornerRadius(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSBoxShadowLayout_bsl_top_end_corner_radius));
            setBottomStartCornerRadius(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSBoxShadowLayout_bsl_bottom_start_corner_radius));
            setBottomEndCornerRadius(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSBoxShadowLayout_bsl_bottom_end_corner_radius));
            setCornerRadius(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSBoxShadowLayout_bsl_corner_radius));
            obtainStyledAttributes.recycle();
        }
        setWillNotDraw(false);
    }
}
