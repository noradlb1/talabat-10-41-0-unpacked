package com.designsystem.ds_chip;

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
import com.designsystem.extensions.TypedArrayExtensionsKt;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010+\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010,R+\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR9\u0010\u0012\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00112\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00118F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R7\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188F@FX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010!\u001a\u00020 2\u0006\u0010\t\u001a\u00020 8F@FX\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0010\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R9\u0010'\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00112\r\u0010\t\u001a\t\u0018\u00010\u0007¢\u0006\u0002\b\u00118F@FX\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0010\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016¨\u0006-"}, d2 = {"Lcom/designsystem/ds_chip/DSMultiSelectionChip;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "count", "getCount", "()I", "setCount", "(I)V", "count$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/annotation/DrawableRes;", "leadingIcon", "getLeadingIcon", "()Ljava/lang/Integer;", "setLeadingIcon", "(Ljava/lang/Integer;)V", "leadingIcon$delegate", "Lkotlin/Function0;", "", "onTap", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "setOnTap", "(Lkotlin/jvm/functions/Function0;)V", "onTap$delegate", "", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "text$delegate", "trailingIcon", "getTrailingIcon", "setTrailingIcon", "trailingIcon$delegate", "Content", "(Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSMultiSelectionChip extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState count$delegate;
    @NotNull
    private final MutableState leadingIcon$delegate;
    @NotNull
    private final MutableState onTap$delegate;
    @NotNull
    private final MutableState text$delegate;
    @NotNull
    private final MutableState trailingIcon$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSMultiSelectionChip(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSMultiSelectionChip(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSMultiSelectionChip(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    @Composable
    public void Content(@Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-585770662);
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
            DSMultiSelectionChipKt.DSMultiSelectionChip(getText(), (Modifier) null, getLeadingIcon(), getTrailingIcon(), getCount(), getOnTap(), startRestartGroup, 0, 2);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSMultiSelectionChip$Content$1(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final int getCount() {
        return ((Number) this.count$delegate.getValue()).intValue();
    }

    @Nullable
    public final Integer getLeadingIcon() {
        return (Integer) this.leadingIcon$delegate.getValue();
    }

    @NotNull
    public final Function0<Unit> getOnTap() {
        return (Function0) this.onTap$delegate.getValue();
    }

    @NotNull
    public final String getText() {
        return (String) this.text$delegate.getValue();
    }

    @Nullable
    public final Integer getTrailingIcon() {
        return (Integer) this.trailingIcon$delegate.getValue();
    }

    public final void setCount(int i11) {
        this.count$delegate.setValue(Integer.valueOf(i11));
    }

    public final void setLeadingIcon(@Nullable Integer num) {
        this.leadingIcon$delegate.setValue(num);
    }

    public final void setOnTap(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onTap$delegate.setValue(function0);
    }

    public final void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text$delegate.setValue(str);
    }

    public final void setTrailingIcon(@Nullable Integer num) {
        this.trailingIcon$delegate.setValue(num);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSMultiSelectionChip(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "";
        this.text$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.leadingIcon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.trailingIcon$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onTap$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DSMultiSelectionChip$onTap$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.count$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSMultiSelectionChip, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…MultiSelectionChip, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSMultiSelectionChip_msc_text);
            setText(string != null ? string : str);
            setLeadingIcon(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSMultiSelectionChip_msc_leading_icon));
            setTrailingIcon(TypedArrayExtensionsKt.getResourceIdOrNull(obtainStyledAttributes, R.styleable.DSMultiSelectionChip_msc_trailing_icon));
            setCount(obtainStyledAttributes.getInt(R.styleable.DSMultiSelectionChip_msc_count, 0));
            obtainStyledAttributes.recycle();
        }
    }
}
