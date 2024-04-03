package com.designsystem.ds_stepper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.designsystem.animation.CountAnimation;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0007R1\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Lcom/designsystem/ds_stepper/StepperCounterLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroidx/compose/ui/graphics/Color;", "color", "getColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "setColor-Y2TPw74", "(Landroidx/compose/ui/graphics/Color;)V", "count", "setInitialValue", "", "initialCount", "updateCounter", "newCount", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StepperCounterLayout extends FrameLayout {
    @Nullable
    private Color color;
    private int count;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StepperCounterLayout(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StepperCounterLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StepperCounterLayout(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    /* renamed from: getColor-QN2ZGVo  reason: not valid java name */
    public final Color m8622getColorQN2ZGVo() {
        return this.color;
    }

    /* renamed from: setColor-Y2TPw74  reason: not valid java name */
    public final void m8623setColorY2TPw74(@Nullable Color color2) {
        if (color2 != null) {
            color2.m2929unboximpl();
            this.color = color2;
            ((TextView) findViewById(R.id.tv_stepper_in)).setTextColor(ColorKt.m2974toArgb8_81llA(color2.m2929unboximpl()));
            ((TextView) findViewById(R.id.tv_stepper_out)).setTextColor(ColorKt.m2974toArgb8_81llA(color2.m2929unboximpl()));
        }
    }

    public final void setInitialValue(int i11) {
        this.count = i11;
    }

    public final void updateCounter(int i11) {
        CountAnimation countAnimation = CountAnimation.INSTANCE;
        TextView textView = (TextView) findViewById(R.id.tv_stepper_out);
        Intrinsics.checkNotNullExpressionValue(textView, "tv_stepper_out");
        TextView textView2 = (TextView) findViewById(R.id.tv_stepper_in);
        Intrinsics.checkNotNullExpressionValue(textView2, "tv_stepper_in");
        int i12 = this.count;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        countAnimation.setAnimatedCount(textView, textView2, i12, i11, context);
        this.count = i11;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StepperCounterLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.stepper_counter, this, true);
    }
}
