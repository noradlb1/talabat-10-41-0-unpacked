package com.designsystem.ds_dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u00105\u001a\u00020\u0013H\u0017¢\u0006\u0002\u00106J\u0006\u00107\u001a\u00020\u0013J\u000e\u00108\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bR/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR;\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R/\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\t\u001a\u0004\u0018\u00010\u001c8F@FX\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R+\u0010$\u001a\u00020#2\u0006\u0010\t\u001a\u00020#8F@FX\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0011\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R/\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\t\u001a\u0004\u0018\u00010*8F@FX\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0011\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R/\u00101\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0011\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000f¨\u00069"}, d2 = {"Lcom/designsystem/ds_dialog/DSDialog;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "content", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "content$delegate", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "onDismissRequest", "getOnDismissRequest", "()Lkotlin/jvm/functions/Function0;", "setOnDismissRequest", "(Lkotlin/jvm/functions/Function0;)V", "onDismissRequest$delegate", "parentViewGroup", "Landroid/view/ViewGroup;", "Lcom/designsystem/ds_dialog/DSDialogPrimaryAction;", "primaryAction", "getPrimaryAction", "()Lcom/designsystem/ds_dialog/DSDialogPrimaryAction;", "setPrimaryAction", "(Lcom/designsystem/ds_dialog/DSDialogPrimaryAction;)V", "primaryAction$delegate", "Landroidx/compose/ui/window/DialogProperties;", "properties", "getProperties", "()Landroidx/compose/ui/window/DialogProperties;", "setProperties", "(Landroidx/compose/ui/window/DialogProperties;)V", "properties$delegate", "Lcom/designsystem/ds_dialog/DSDialogSecondaryAction;", "secondaryAction", "getSecondaryAction", "()Lcom/designsystem/ds_dialog/DSDialogSecondaryAction;", "setSecondaryAction", "(Lcom/designsystem/ds_dialog/DSDialogSecondaryAction;)V", "secondaryAction$delegate", "title", "getTitle", "setTitle", "title$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "close", "show", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSDialog extends AbstractComposeView {
    public static final int $stable = 8;
    @NotNull
    private final MutableState content$delegate;
    @NotNull
    private final MutableState onDismissRequest$delegate;
    @Nullable
    private ViewGroup parentViewGroup;
    @NotNull
    private final MutableState primaryAction$delegate;
    @NotNull
    private final MutableState properties$delegate;
    @NotNull
    private final MutableState secondaryAction$delegate;
    @NotNull
    private final MutableState title$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSDialog(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSDialog(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSDialog(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-34221161);
        getPrimaryAction();
        String title = getTitle();
        DSDialogPrimaryAction primaryAction = getPrimaryAction();
        if (primaryAction == null) {
            primaryAction = new DSDialogPrimaryAction("", DSDialog$Content$2.INSTANCE, (DSDialogPrimaryActionType) null, 4, (DefaultConstructorMarker) null);
        }
        String content = getContent();
        DSDialogSecondaryAction secondaryAction = getSecondaryAction();
        DialogProperties properties = getProperties();
        DSDialogKt.DSDialog(new DSDialog$Content$3(this), primaryAction, (Modifier) null, title, content, secondaryAction, properties, startRestartGroup, 0, 4);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSDialog$Content$4(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final void close() {
        ViewGroup viewGroup = this.parentViewGroup;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    @Nullable
    public final String getContent() {
        return (String) this.content$delegate.getValue();
    }

    @Nullable
    public final Function0<Unit> getOnDismissRequest() {
        return (Function0) this.onDismissRequest$delegate.getValue();
    }

    @Nullable
    public final DSDialogPrimaryAction getPrimaryAction() {
        return (DSDialogPrimaryAction) this.primaryAction$delegate.getValue();
    }

    @NotNull
    public final DialogProperties getProperties() {
        return (DialogProperties) this.properties$delegate.getValue();
    }

    @Nullable
    public final DSDialogSecondaryAction getSecondaryAction() {
        return (DSDialogSecondaryAction) this.secondaryAction$delegate.getValue();
    }

    @Nullable
    public final String getTitle() {
        return (String) this.title$delegate.getValue();
    }

    public final void setContent(@Nullable String str) {
        this.content$delegate.setValue(str);
    }

    public final void setOnDismissRequest(@Nullable Function0<Unit> function0) {
        this.onDismissRequest$delegate.setValue(function0);
    }

    public final void setPrimaryAction(@Nullable DSDialogPrimaryAction dSDialogPrimaryAction) {
        this.primaryAction$delegate.setValue(dSDialogPrimaryAction);
    }

    public final void setProperties(@NotNull DialogProperties dialogProperties) {
        Intrinsics.checkNotNullParameter(dialogProperties, "<set-?>");
        this.properties$delegate.setValue(dialogProperties);
    }

    public final void setSecondaryAction(@Nullable DSDialogSecondaryAction dSDialogSecondaryAction) {
        this.secondaryAction$delegate.setValue(dSDialogSecondaryAction);
    }

    public final void setTitle(@Nullable String str) {
        this.title$delegate.setValue(str);
    }

    public final void show(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parentViewGroup");
        this.parentViewGroup = viewGroup;
        if (viewGroup != null) {
            viewGroup.addView(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSDialog(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.title$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.primaryAction$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.content$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.secondaryAction$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.properties$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onDismissRequest$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
