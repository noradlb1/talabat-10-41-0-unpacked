package com.designsystem.ds_fixed_footer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0012\u001a\u00020\u0013H\u0017¢\u0006\u0002\u0010\u0014R/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/designsystem/ds_fixed_footer/DSFixedFooter;", "Lcom/designsystem/ds_fixed_footer/DSBaseFixedFooter;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Landroid/view/View;", "content", "getContent", "()Landroid/view/View;", "setContent", "(Landroid/view/View;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooter extends DSBaseFixedFooter {
    public static final int $stable = 0;
    @NotNull
    private final MutableState content$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSFixedFooter(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSFixedFooter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSFixedFooter(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        ComposableLambda composableLambda;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-129432186);
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
        if ((2 ^ (i12 & 11)) != 0 || !startRestartGroup.getSkipping()) {
            getContent();
            boolean isElevated = isElevated();
            View topContent = getTopContent();
            Function2<Composer, Integer, Unit> function2 = null;
            if (topContent == null) {
                composableLambda = null;
            } else {
                composableLambda = ComposableLambdaKt.composableLambdaInstance(-985531366, true, new DSFixedFooter$Content$2$1(topContent));
            }
            View content = getContent();
            if (content != null) {
                function2 = ComposableLambdaKt.composableLambdaInstance(-985531147, true, new DSFixedFooter$Content$3$1(content));
            }
            if (function2 == null) {
                function2 = ComposableSingletons$DSFixedFooterKt.INSTANCE.m8345getLambda1$marshmallow_release();
            }
            DSFixedFooterKt.DSFixedFooter((Modifier) null, isElevated, composableLambda, function2, startRestartGroup, 0, 1);
            FixedFooterPadding$marshmallow_release(isElevated(), startRestartGroup, (i12 << 3) & 112);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSFixedFooter$Content$4(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final View getContent() {
        return (View) this.content$delegate.getValue();
    }

    public final void setContent(@Nullable View view) {
        this.content$delegate.setValue(view);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSFixedFooter(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.content$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
