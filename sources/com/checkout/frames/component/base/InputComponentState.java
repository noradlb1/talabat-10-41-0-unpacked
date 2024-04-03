package com.checkout.frames.component.base;

import com.checkout.frames.view.InputFieldState;
import com.checkout.frames.view.TextLabelState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/checkout/frames/component/base/InputComponentState;", "", "inputFieldState", "Lcom/checkout/frames/view/InputFieldState;", "titleState", "Lcom/checkout/frames/view/TextLabelState;", "subtitleState", "infoState", "errorState", "isInputFieldOptional", "", "(Lcom/checkout/frames/view/InputFieldState;Lcom/checkout/frames/view/TextLabelState;Lcom/checkout/frames/view/TextLabelState;Lcom/checkout/frames/view/TextLabelState;Lcom/checkout/frames/view/TextLabelState;Z)V", "getErrorState", "()Lcom/checkout/frames/view/TextLabelState;", "getInfoState", "getInputFieldState", "()Lcom/checkout/frames/view/InputFieldState;", "()Z", "getSubtitleState", "getTitleState", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputComponentState {
    @NotNull
    private final TextLabelState errorState;
    @NotNull
    private final TextLabelState infoState;
    @NotNull
    private final InputFieldState inputFieldState;
    private final boolean isInputFieldOptional;
    @NotNull
    private final TextLabelState subtitleState;
    @NotNull
    private final TextLabelState titleState;

    public InputComponentState() {
        this((InputFieldState) null, (TextLabelState) null, (TextLabelState) null, (TextLabelState) null, (TextLabelState) null, false, 63, (DefaultConstructorMarker) null);
    }

    public InputComponentState(@NotNull InputFieldState inputFieldState2, @NotNull TextLabelState textLabelState, @NotNull TextLabelState textLabelState2, @NotNull TextLabelState textLabelState3, @NotNull TextLabelState textLabelState4, boolean z11) {
        Intrinsics.checkNotNullParameter(inputFieldState2, "inputFieldState");
        Intrinsics.checkNotNullParameter(textLabelState, "titleState");
        Intrinsics.checkNotNullParameter(textLabelState2, "subtitleState");
        Intrinsics.checkNotNullParameter(textLabelState3, "infoState");
        Intrinsics.checkNotNullParameter(textLabelState4, "errorState");
        this.inputFieldState = inputFieldState2;
        this.titleState = textLabelState;
        this.subtitleState = textLabelState2;
        this.infoState = textLabelState3;
        this.errorState = textLabelState4;
        this.isInputFieldOptional = z11;
    }

    public static /* synthetic */ InputComponentState copy$default(InputComponentState inputComponentState, InputFieldState inputFieldState2, TextLabelState textLabelState, TextLabelState textLabelState2, TextLabelState textLabelState3, TextLabelState textLabelState4, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            inputFieldState2 = inputComponentState.inputFieldState;
        }
        if ((i11 & 2) != 0) {
            textLabelState = inputComponentState.titleState;
        }
        TextLabelState textLabelState5 = textLabelState;
        if ((i11 & 4) != 0) {
            textLabelState2 = inputComponentState.subtitleState;
        }
        TextLabelState textLabelState6 = textLabelState2;
        if ((i11 & 8) != 0) {
            textLabelState3 = inputComponentState.infoState;
        }
        TextLabelState textLabelState7 = textLabelState3;
        if ((i11 & 16) != 0) {
            textLabelState4 = inputComponentState.errorState;
        }
        TextLabelState textLabelState8 = textLabelState4;
        if ((i11 & 32) != 0) {
            z11 = inputComponentState.isInputFieldOptional;
        }
        return inputComponentState.copy(inputFieldState2, textLabelState5, textLabelState6, textLabelState7, textLabelState8, z11);
    }

    @NotNull
    public final InputFieldState component1() {
        return this.inputFieldState;
    }

    @NotNull
    public final TextLabelState component2() {
        return this.titleState;
    }

    @NotNull
    public final TextLabelState component3() {
        return this.subtitleState;
    }

    @NotNull
    public final TextLabelState component4() {
        return this.infoState;
    }

    @NotNull
    public final TextLabelState component5() {
        return this.errorState;
    }

    public final boolean component6() {
        return this.isInputFieldOptional;
    }

    @NotNull
    public final InputComponentState copy(@NotNull InputFieldState inputFieldState2, @NotNull TextLabelState textLabelState, @NotNull TextLabelState textLabelState2, @NotNull TextLabelState textLabelState3, @NotNull TextLabelState textLabelState4, boolean z11) {
        Intrinsics.checkNotNullParameter(inputFieldState2, "inputFieldState");
        Intrinsics.checkNotNullParameter(textLabelState, "titleState");
        Intrinsics.checkNotNullParameter(textLabelState2, "subtitleState");
        Intrinsics.checkNotNullParameter(textLabelState3, "infoState");
        Intrinsics.checkNotNullParameter(textLabelState4, "errorState");
        return new InputComponentState(inputFieldState2, textLabelState, textLabelState2, textLabelState3, textLabelState4, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputComponentState)) {
            return false;
        }
        InputComponentState inputComponentState = (InputComponentState) obj;
        return Intrinsics.areEqual((Object) this.inputFieldState, (Object) inputComponentState.inputFieldState) && Intrinsics.areEqual((Object) this.titleState, (Object) inputComponentState.titleState) && Intrinsics.areEqual((Object) this.subtitleState, (Object) inputComponentState.subtitleState) && Intrinsics.areEqual((Object) this.infoState, (Object) inputComponentState.infoState) && Intrinsics.areEqual((Object) this.errorState, (Object) inputComponentState.errorState) && this.isInputFieldOptional == inputComponentState.isInputFieldOptional;
    }

    @NotNull
    public final TextLabelState getErrorState() {
        return this.errorState;
    }

    @NotNull
    public final TextLabelState getInfoState() {
        return this.infoState;
    }

    @NotNull
    public final InputFieldState getInputFieldState() {
        return this.inputFieldState;
    }

    @NotNull
    public final TextLabelState getSubtitleState() {
        return this.subtitleState;
    }

    @NotNull
    public final TextLabelState getTitleState() {
        return this.titleState;
    }

    public int hashCode() {
        int hashCode = ((((((((this.inputFieldState.hashCode() * 31) + this.titleState.hashCode()) * 31) + this.subtitleState.hashCode()) * 31) + this.infoState.hashCode()) * 31) + this.errorState.hashCode()) * 31;
        boolean z11 = this.isInputFieldOptional;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isInputFieldOptional() {
        return this.isInputFieldOptional;
    }

    @NotNull
    public String toString() {
        InputFieldState inputFieldState2 = this.inputFieldState;
        TextLabelState textLabelState = this.titleState;
        TextLabelState textLabelState2 = this.subtitleState;
        TextLabelState textLabelState3 = this.infoState;
        TextLabelState textLabelState4 = this.errorState;
        boolean z11 = this.isInputFieldOptional;
        return "InputComponentState(inputFieldState=" + inputFieldState2 + ", titleState=" + textLabelState + ", subtitleState=" + textLabelState2 + ", infoState=" + textLabelState3 + ", errorState=" + textLabelState4 + ", isInputFieldOptional=" + z11 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InputComponentState(com.checkout.frames.view.InputFieldState r14, com.checkout.frames.view.TextLabelState r15, com.checkout.frames.view.TextLabelState r16, com.checkout.frames.view.TextLabelState r17, com.checkout.frames.view.TextLabelState r18, boolean r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r13 = this;
            r0 = r20 & 1
            if (r0 == 0) goto L_0x0013
            com.checkout.frames.view.InputFieldState r0 = new com.checkout.frames.view.InputFieldState
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 31
            r8 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0014
        L_0x0013:
            r0 = r14
        L_0x0014:
            r1 = r20 & 2
            if (r1 == 0) goto L_0x0027
            com.checkout.frames.view.TextLabelState r1 = new com.checkout.frames.view.TextLabelState
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 31
            r9 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0028
        L_0x0027:
            r1 = r15
        L_0x0028:
            r2 = r20 & 4
            if (r2 == 0) goto L_0x003b
            com.checkout.frames.view.TextLabelState r2 = new com.checkout.frames.view.TextLabelState
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 31
            r10 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x003d
        L_0x003b:
            r2 = r16
        L_0x003d:
            r3 = r20 & 8
            if (r3 == 0) goto L_0x0050
            com.checkout.frames.view.TextLabelState r3 = new com.checkout.frames.view.TextLabelState
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 31
            r11 = 0
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            goto L_0x0052
        L_0x0050:
            r3 = r17
        L_0x0052:
            r4 = r20 & 16
            if (r4 == 0) goto L_0x0065
            com.checkout.frames.view.TextLabelState r4 = new com.checkout.frames.view.TextLabelState
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 31
            r12 = 0
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            goto L_0x0067
        L_0x0065:
            r4 = r18
        L_0x0067:
            r5 = r20 & 32
            if (r5 == 0) goto L_0x006d
            r5 = 0
            goto L_0x006f
        L_0x006d:
            r5 = r19
        L_0x006f:
            r14 = r13
            r15 = r0
            r16 = r1
            r17 = r2
            r18 = r3
            r19 = r4
            r20 = r5
            r14.<init>(r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.component.base.InputComponentState.<init>(com.checkout.frames.view.InputFieldState, com.checkout.frames.view.TextLabelState, com.checkout.frames.view.TextLabelState, com.checkout.frames.view.TextLabelState, com.checkout.frames.view.TextLabelState, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
