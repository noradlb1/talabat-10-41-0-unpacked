package com.designsystem.ds_fixed_footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b\u001a\u0010\u001bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u00118F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/designsystem/ds_fixed_footer/DSBaseFixedFooter;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isElevated", "()Z", "setElevated", "(Z)V", "isElevated$delegate", "Landroidx/compose/runtime/MutableState;", "Landroid/view/View;", "topContent", "getTopContent", "()Landroid/view/View;", "setTopContent", "(Landroid/view/View;)V", "topContent$delegate", "FixedFooterPadding", "", "FixedFooterPadding$marshmallow_release", "(ZLandroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DSBaseFixedFooter extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState isElevated$delegate;
    @NotNull
    private final MutableState topContent$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBaseFixedFooter(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBaseFixedFooter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSBaseFixedFooter(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public final void FixedFooterPadding$marshmallow_release(boolean z11, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-2008882082);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(z11)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else if (z11) {
            startRestartGroup.startReplaceableGroup(-2008882012);
            setPadding(0, ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).m5441roundToPx0680j_4(DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8848getDsXxxsD9Ej5fM()), 0, 0);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-2008881859);
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSBaseFixedFooter$FixedFooterPadding$1(this, z11, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final View getTopContent() {
        return (View) this.topContent$delegate.getValue();
    }

    public final boolean isElevated() {
        return ((Boolean) this.isElevated$delegate.getValue()).booleanValue();
    }

    public final void setElevated(boolean z11) {
        this.isElevated$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void setTopContent(@Nullable View view) {
        this.topContent$delegate.setValue(view);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSBaseFixedFooter(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isElevated$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.topContent$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSBaseFixedFooter, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….DSBaseFixedFooter, 0, 0)");
            setElevated(obtainStyledAttributes.getBoolean(R.styleable.DSBaseFixedFooter_ff_is_elevated, true));
            obtainStyledAttributes.recycle();
        }
    }
}
