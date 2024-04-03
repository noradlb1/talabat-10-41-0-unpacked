package com.designsystem.ds_empty_state_v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AbstractComposeView;
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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR/\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR7\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168F@FX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010\u001e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0011\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000f¨\u0006\""}, d2 = {"Lcom/designsystem/ds_empty_state_v2/DSEmptyStateV2;", "Landroidx/compose/ui/platform/AbstractComposeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "buttonText", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "buttonText$delegate", "Landroidx/compose/runtime/MutableState;", "details", "getDetails", "setDetails", "details$delegate", "Lkotlin/Function0;", "", "onButtonTap", "getOnButtonTap", "()Lkotlin/jvm/functions/Function0;", "setOnButtonTap", "(Lkotlin/jvm/functions/Function0;)V", "onButtonTap$delegate", "title", "getTitle", "setTitle", "title$delegate", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DSEmptyStateV2 extends AbstractComposeView {
    public static final int $stable = 0;
    @NotNull
    private final MutableState buttonText$delegate;
    @NotNull
    private final MutableState details$delegate;
    @NotNull
    private final MutableState onButtonTap$delegate;
    @NotNull
    private final MutableState title$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyStateV2(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyStateV2(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSEmptyStateV2(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Nullable
    public final String getButtonText() {
        return (String) this.buttonText$delegate.getValue();
    }

    @Nullable
    public final String getDetails() {
        return (String) this.details$delegate.getValue();
    }

    @NotNull
    public final Function0<Unit> getOnButtonTap() {
        return (Function0) this.onButtonTap$delegate.getValue();
    }

    @NotNull
    public final String getTitle() {
        return (String) this.title$delegate.getValue();
    }

    public final void setButtonText(@Nullable String str) {
        this.buttonText$delegate.setValue(str);
    }

    public final void setDetails(@Nullable String str) {
        this.details$delegate.setValue(str);
    }

    public final void setOnButtonTap(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onButtonTap$delegate.setValue(function0);
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title$delegate.setValue(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSEmptyStateV2(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "";
        this.title$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.details$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.buttonText$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.onButtonTap$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DSEmptyStateV2$onButtonTap$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DSEmptyStateV2, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…ble.DSEmptyStateV2, 0, 0)");
            String string = obtainStyledAttributes.getString(R.styleable.DSEmptyStateV2_es_v2_title);
            setTitle(string != null ? string : str);
            setDetails(obtainStyledAttributes.getString(R.styleable.DSEmptyStateV2_es_v2_details));
            setButtonText(obtainStyledAttributes.getString(R.styleable.DSEmptyStateV2_es_v2_button_text));
            obtainStyledAttributes.recycle();
        }
    }
}
