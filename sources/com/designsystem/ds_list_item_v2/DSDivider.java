package com.designsystem.ds_list_item_v2;

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
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.unit.Dp;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0016\u001a\u00020\u0017H\u0017¢\u0006\u0002\u0010\u0018R4\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR4\u0010\u0012\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/designsystem/ds_list_item_v2/DSDivider;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Landroidx/compose/ui/unit/Dp;", "paddingEnd", "getPaddingEnd-D9Ej5fM", "()F", "setPaddingEnd-0680j_4", "(F)V", "paddingEnd$delegate", "Landroidx/compose/runtime/MutableState;", "paddingStart", "getPaddingStart-D9Ej5fM", "setPaddingStart-0680j_4", "paddingStart$delegate", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSDivider extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState paddingEnd$delegate;
    @NotNull
    private final MutableState paddingStart$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSDivider(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSDivider(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSDivider(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(747097133);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) this)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            DSDividerKt.m8478DSDividerWMci_g0((Modifier) null, m8475getPaddingStartD9Ej5fM(), m8474getPaddingEndD9Ej5fM(), startRestartGroup, 0, 1);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSDivider$Content$1(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* renamed from: getPaddingEnd-D9Ej5fM  reason: not valid java name */
    public final float m8474getPaddingEndD9Ej5fM() {
        return ((Dp) this.paddingEnd$delegate.getValue()).m5492unboximpl();
    }

    /* renamed from: getPaddingStart-D9Ej5fM  reason: not valid java name */
    public final float m8475getPaddingStartD9Ej5fM() {
        return ((Dp) this.paddingStart$delegate.getValue()).m5492unboximpl();
    }

    /* renamed from: setPaddingEnd-0680j_4  reason: not valid java name */
    public final void m8476setPaddingEnd0680j_4(float f11) {
        this.paddingEnd$delegate.setValue(Dp.m5476boximpl(f11));
    }

    /* renamed from: setPaddingStart-0680j_4  reason: not valid java name */
    public final void m8477setPaddingStart0680j_4(float f11) {
        this.paddingStart$delegate.setValue(Dp.m5476boximpl(f11));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSDivider(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        float f11 = (float) 0;
        this.paddingStart$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m5476boximpl(Dp.m5478constructorimpl(f11)), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.paddingEnd$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Dp.m5476boximpl(Dp.m5478constructorimpl(f11)), (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSDivider, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…tyleable.DSDivider, 0, 0)");
            m8477setPaddingStart0680j_4(Dp.m5478constructorimpl(obtainStyledAttributes.getDimension(R.styleable.DSDivider_d_padding_start, 0.0f)));
            m8476setPaddingEnd0680j_4(Dp.m5478constructorimpl(obtainStyledAttributes.getDimension(R.styleable.DSDivider_d_padding_end, 0.0f)));
            obtainStyledAttributes.recycle();
        }
    }
}
