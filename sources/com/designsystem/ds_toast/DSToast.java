package com.designsystem.ds_toast;

import android.content.Context;
import android.util.AttributeSet;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0012\u001a\u00020\u0013H\u0017¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0013J\u0019\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/designsystem/ds_toast/DSToast;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lcom/designsystem/ds_toast/DSToastHostState;", "hostState", "getHostState", "()Lcom/designsystem/ds_toast/DSToastHostState;", "setHostState", "(Lcom/designsystem/ds_toast/DSToastHostState;)V", "hostState$delegate", "Landroidx/compose/runtime/MutableState;", "Content", "", "(Landroidx/compose/runtime/Composer;I)V", "hideDSToast", "showDSToast", "model", "Lcom/designsystem/ds_toast/DSToastModel;", "(Lcom/designsystem/ds_toast/DSToastModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSToast extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState hostState$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSToast(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSToast(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSToast(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final DSToastHostState getHostState() {
        return (DSToastHostState) this.hostState$delegate.getValue();
    }

    private final void setHostState(DSToastHostState dSToastHostState) {
        this.hostState$delegate.setValue(dSToastHostState);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-741840608);
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
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxSize$default);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r62, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r62, density, companion.getSetDensity());
            Updater.m2543setimpl(r62, layoutDirection, companion.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            DSToastKt.DSToast(getHostState(), (Modifier) null, ComposableSingletons$DSToastKt.INSTANCE.m8852getLambda2$marshmallow_release(), startRestartGroup, 0, 2);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSToast$Content$2(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final void hideDSToast() {
        getHostState().hideDSToast();
    }

    @Nullable
    public final Object showDSToast(@NotNull DSToastModel dSToastModel, @NotNull Continuation<? super Unit> continuation) {
        Object showDSToast = getHostState().showDSToast(dSToastModel, continuation);
        return showDSToast == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? showDSToast : Unit.INSTANCE;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSToast(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.hostState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new DSToastHostState(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
