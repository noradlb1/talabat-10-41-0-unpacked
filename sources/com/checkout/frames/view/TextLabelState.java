package com.checkout.frames.view;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001Bq\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u0012\u001b\b\u0002\u0010\u0007\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\n0\u0003\u0012\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\n0\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003HÆ\u0003J\u001c\u0010\u0016\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\n0\u0003HÆ\u0003J\u001c\u0010\u0017\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\n0\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003Ju\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00032\u001b\b\u0002\u0010\u0007\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\n0\u00032\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\n0\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000fR$\u0010\u0007\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR$\u0010\u000b\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\b\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/checkout/frames/view/TextLabelState;", "", "text", "Landroidx/compose/runtime/MutableState;", "", "textId", "", "leadingIcon", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "trailingIcon", "isVisible", "", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "()Landroidx/compose/runtime/MutableState;", "getLeadingIcon", "getText", "getTextId", "getTrailingIcon", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextLabelState {
    @NotNull
    private final MutableState<Boolean> isVisible;
    @NotNull
    private final MutableState<Function2<Composer, Integer, Unit>> leadingIcon;
    @NotNull
    private final MutableState<String> text;
    @NotNull
    private final MutableState<Integer> textId;
    @NotNull
    private final MutableState<Function2<Composer, Integer, Unit>> trailingIcon;

    public TextLabelState() {
        this((MutableState) null, (MutableState) null, (MutableState) null, (MutableState) null, (MutableState) null, 31, (DefaultConstructorMarker) null);
    }

    public TextLabelState(@NotNull MutableState<String> mutableState, @NotNull MutableState<Integer> mutableState2, @NotNull MutableState<Function2<Composer, Integer, Unit>> mutableState3, @NotNull MutableState<Function2<Composer, Integer, Unit>> mutableState4, @NotNull MutableState<Boolean> mutableState5) {
        Intrinsics.checkNotNullParameter(mutableState, "text");
        Intrinsics.checkNotNullParameter(mutableState2, "textId");
        Intrinsics.checkNotNullParameter(mutableState3, "leadingIcon");
        Intrinsics.checkNotNullParameter(mutableState4, "trailingIcon");
        Intrinsics.checkNotNullParameter(mutableState5, "isVisible");
        this.text = mutableState;
        this.textId = mutableState2;
        this.leadingIcon = mutableState3;
        this.trailingIcon = mutableState4;
        this.isVisible = mutableState5;
    }

    public static /* synthetic */ TextLabelState copy$default(TextLabelState textLabelState, MutableState<String> mutableState, MutableState<Integer> mutableState2, MutableState<Function2<Composer, Integer, Unit>> mutableState3, MutableState<Function2<Composer, Integer, Unit>> mutableState4, MutableState<Boolean> mutableState5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            mutableState = textLabelState.text;
        }
        if ((i11 & 2) != 0) {
            mutableState2 = textLabelState.textId;
        }
        MutableState<Integer> mutableState6 = mutableState2;
        if ((i11 & 4) != 0) {
            mutableState3 = textLabelState.leadingIcon;
        }
        MutableState<Function2<Composer, Integer, Unit>> mutableState7 = mutableState3;
        if ((i11 & 8) != 0) {
            mutableState4 = textLabelState.trailingIcon;
        }
        MutableState<Function2<Composer, Integer, Unit>> mutableState8 = mutableState4;
        if ((i11 & 16) != 0) {
            mutableState5 = textLabelState.isVisible;
        }
        return textLabelState.copy(mutableState, mutableState6, mutableState7, mutableState8, mutableState5);
    }

    @NotNull
    public final MutableState<String> component1() {
        return this.text;
    }

    @NotNull
    public final MutableState<Integer> component2() {
        return this.textId;
    }

    @NotNull
    public final MutableState<Function2<Composer, Integer, Unit>> component3() {
        return this.leadingIcon;
    }

    @NotNull
    public final MutableState<Function2<Composer, Integer, Unit>> component4() {
        return this.trailingIcon;
    }

    @NotNull
    public final MutableState<Boolean> component5() {
        return this.isVisible;
    }

    @NotNull
    public final TextLabelState copy(@NotNull MutableState<String> mutableState, @NotNull MutableState<Integer> mutableState2, @NotNull MutableState<Function2<Composer, Integer, Unit>> mutableState3, @NotNull MutableState<Function2<Composer, Integer, Unit>> mutableState4, @NotNull MutableState<Boolean> mutableState5) {
        Intrinsics.checkNotNullParameter(mutableState, "text");
        Intrinsics.checkNotNullParameter(mutableState2, "textId");
        Intrinsics.checkNotNullParameter(mutableState3, "leadingIcon");
        Intrinsics.checkNotNullParameter(mutableState4, "trailingIcon");
        Intrinsics.checkNotNullParameter(mutableState5, "isVisible");
        return new TextLabelState(mutableState, mutableState2, mutableState3, mutableState4, mutableState5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLabelState)) {
            return false;
        }
        TextLabelState textLabelState = (TextLabelState) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) textLabelState.text) && Intrinsics.areEqual((Object) this.textId, (Object) textLabelState.textId) && Intrinsics.areEqual((Object) this.leadingIcon, (Object) textLabelState.leadingIcon) && Intrinsics.areEqual((Object) this.trailingIcon, (Object) textLabelState.trailingIcon) && Intrinsics.areEqual((Object) this.isVisible, (Object) textLabelState.isVisible);
    }

    @NotNull
    public final MutableState<Function2<Composer, Integer, Unit>> getLeadingIcon() {
        return this.leadingIcon;
    }

    @NotNull
    public final MutableState<String> getText() {
        return this.text;
    }

    @NotNull
    public final MutableState<Integer> getTextId() {
        return this.textId;
    }

    @NotNull
    public final MutableState<Function2<Composer, Integer, Unit>> getTrailingIcon() {
        return this.trailingIcon;
    }

    public int hashCode() {
        return (((((((this.text.hashCode() * 31) + this.textId.hashCode()) * 31) + this.leadingIcon.hashCode()) * 31) + this.trailingIcon.hashCode()) * 31) + this.isVisible.hashCode();
    }

    @NotNull
    public final MutableState<Boolean> isVisible() {
        return this.isVisible;
    }

    @NotNull
    public String toString() {
        MutableState<String> mutableState = this.text;
        MutableState<Integer> mutableState2 = this.textId;
        MutableState<Function2<Composer, Integer, Unit>> mutableState3 = this.leadingIcon;
        MutableState<Function2<Composer, Integer, Unit>> mutableState4 = this.trailingIcon;
        MutableState<Boolean> mutableState5 = this.isVisible;
        return "TextLabelState(text=" + mutableState + ", textId=" + mutableState2 + ", leadingIcon=" + mutableState3 + ", trailingIcon=" + mutableState4 + ", isVisible=" + mutableState5 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextLabelState(androidx.compose.runtime.MutableState r5, androidx.compose.runtime.MutableState r6, androidx.compose.runtime.MutableState r7, androidx.compose.runtime.MutableState r8, androidx.compose.runtime.MutableState r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 2
            r1 = 0
            if (r11 == 0) goto L_0x000c
            java.lang.String r5 = ""
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r1, r0, r1)
        L_0x000c:
            r11 = r10 & 2
            if (r11 == 0) goto L_0x0014
            androidx.compose.runtime.MutableState r6 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r1, r0, r1)
        L_0x0014:
            r11 = r6
            r6 = r10 & 4
            if (r6 == 0) goto L_0x001d
            androidx.compose.runtime.MutableState r7 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r1, r0, r1)
        L_0x001d:
            r2 = r7
            r6 = r10 & 8
            if (r6 == 0) goto L_0x0026
            androidx.compose.runtime.MutableState r8 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r1, r0, r1)
        L_0x0026:
            r3 = r8
            r6 = r10 & 16
            if (r6 == 0) goto L_0x0031
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            androidx.compose.runtime.MutableState r9 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r6, r1, r0, r1)
        L_0x0031:
            r0 = r9
            r6 = r4
            r7 = r5
            r8 = r11
            r9 = r2
            r10 = r3
            r11 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.view.TextLabelState.<init>(androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
