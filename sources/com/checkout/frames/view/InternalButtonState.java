package com.checkout.frames.view;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import com.google.firebase.perf.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/checkout/frames/view/InternalButtonState;", "", "isEnabled", "Landroidx/compose/runtime/MutableState;", "", "textState", "Lcom/checkout/frames/view/TextLabelState;", "(Landroidx/compose/runtime/MutableState;Lcom/checkout/frames/view/TextLabelState;)V", "()Landroidx/compose/runtime/MutableState;", "getTextState", "()Lcom/checkout/frames/view/TextLabelState;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InternalButtonState {
    @NotNull
    private final MutableState<Boolean> isEnabled;
    @NotNull
    private final TextLabelState textState;

    public InternalButtonState(@NotNull MutableState<Boolean> mutableState, @NotNull TextLabelState textLabelState) {
        Intrinsics.checkNotNullParameter(mutableState, Constants.ENABLE_DISABLE);
        Intrinsics.checkNotNullParameter(textLabelState, "textState");
        this.isEnabled = mutableState;
        this.textState = textLabelState;
    }

    public static /* synthetic */ InternalButtonState copy$default(InternalButtonState internalButtonState, MutableState<Boolean> mutableState, TextLabelState textLabelState, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            mutableState = internalButtonState.isEnabled;
        }
        if ((i11 & 2) != 0) {
            textLabelState = internalButtonState.textState;
        }
        return internalButtonState.copy(mutableState, textLabelState);
    }

    @NotNull
    public final MutableState<Boolean> component1() {
        return this.isEnabled;
    }

    @NotNull
    public final TextLabelState component2() {
        return this.textState;
    }

    @NotNull
    public final InternalButtonState copy(@NotNull MutableState<Boolean> mutableState, @NotNull TextLabelState textLabelState) {
        Intrinsics.checkNotNullParameter(mutableState, Constants.ENABLE_DISABLE);
        Intrinsics.checkNotNullParameter(textLabelState, "textState");
        return new InternalButtonState(mutableState, textLabelState);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InternalButtonState)) {
            return false;
        }
        InternalButtonState internalButtonState = (InternalButtonState) obj;
        return Intrinsics.areEqual((Object) this.isEnabled, (Object) internalButtonState.isEnabled) && Intrinsics.areEqual((Object) this.textState, (Object) internalButtonState.textState);
    }

    @NotNull
    public final TextLabelState getTextState() {
        return this.textState;
    }

    public int hashCode() {
        return (this.isEnabled.hashCode() * 31) + this.textState.hashCode();
    }

    @NotNull
    public final MutableState<Boolean> isEnabled() {
        return this.isEnabled;
    }

    @NotNull
    public String toString() {
        MutableState<Boolean> mutableState = this.isEnabled;
        TextLabelState textLabelState = this.textState;
        return "InternalButtonState(isEnabled=" + mutableState + ", textState=" + textLabelState + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InternalButtonState(MutableState mutableState, TextLabelState textLabelState, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null) : mutableState, textLabelState);
    }
}
