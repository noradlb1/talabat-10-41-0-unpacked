package androidx.compose.ui.text.input;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB:\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJE\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions;", "", "singleLine", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "(ZIZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect", "()Z", "getCapitalization-IUNYP9k", "()I", "I", "getImeAction-eUduSuo", "getKeyboardType-PjHm6EE", "getSingleLine", "copy", "copy-uxg59PA", "(ZIZII)Landroidx/compose/ui/text/input/ImeOptions;", "equals", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImeOptions {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final ImeOptions Default = new ImeOptions(false, 0, false, 0, 0, 31, (DefaultConstructorMarker) null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final int imeAction;
    private final int keyboardType;
    private final boolean singleLine;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/ImeOptions$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/input/ImeOptions;", "getDefault", "()Landroidx/compose/ui/text/input/ImeOptions;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ImeOptions getDefault() {
            return ImeOptions.Default;
        }
    }

    private ImeOptions(boolean z11, int i11, boolean z12, int i12, int i13) {
        this.singleLine = z11;
        this.capitalization = i11;
        this.autoCorrect = z12;
        this.keyboardType = i12;
        this.imeAction = i13;
    }

    public /* synthetic */ ImeOptions(boolean z11, int i11, boolean z12, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, i11, z12, i12, i13);
    }

    /* renamed from: copy-uxg59PA$default  reason: not valid java name */
    public static /* synthetic */ ImeOptions m5195copyuxg59PA$default(ImeOptions imeOptions, boolean z11, int i11, boolean z12, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            z11 = imeOptions.singleLine;
        }
        if ((i14 & 2) != 0) {
            i11 = imeOptions.capitalization;
        }
        int i15 = i11;
        if ((i14 & 4) != 0) {
            z12 = imeOptions.autoCorrect;
        }
        boolean z13 = z12;
        if ((i14 & 8) != 0) {
            i12 = imeOptions.keyboardType;
        }
        int i16 = i12;
        if ((i14 & 16) != 0) {
            i13 = imeOptions.imeAction;
        }
        return imeOptions.m5196copyuxg59PA(z11, i15, z13, i16, i13);
    }

    @NotNull
    /* renamed from: copy-uxg59PA  reason: not valid java name */
    public final ImeOptions m5196copyuxg59PA(boolean z11, int i11, boolean z12, int i12, int i13) {
        return new ImeOptions(z11, i11, z12, i12, i13, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImeOptions)) {
            return false;
        }
        ImeOptions imeOptions = (ImeOptions) obj;
        if (this.singleLine == imeOptions.singleLine && KeyboardCapitalization.m5205equalsimpl0(this.capitalization, imeOptions.capitalization) && this.autoCorrect == imeOptions.autoCorrect && KeyboardType.m5216equalsimpl0(this.keyboardType, imeOptions.keyboardType) && ImeAction.m5183equalsimpl0(this.imeAction, imeOptions.imeAction)) {
            return true;
        }
        return false;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public final int m5197getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    /* renamed from: getImeAction-eUduSuo  reason: not valid java name */
    public final int m5198getImeActioneUduSuo() {
        return this.imeAction;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public final int m5199getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public int hashCode() {
        return (((((((e.a(this.singleLine) * 31) + KeyboardCapitalization.m5206hashCodeimpl(this.capitalization)) * 31) + e.a(this.autoCorrect)) * 31) + KeyboardType.m5217hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m5184hashCodeimpl(this.imeAction);
    }

    @NotNull
    public String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + KeyboardCapitalization.m5207toStringimpl(this.capitalization) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + KeyboardType.m5218toStringimpl(this.keyboardType) + ", imeAction=" + ImeAction.m5185toStringimpl(this.imeAction) + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImeOptions(boolean z11, int i11, boolean z12, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? false : z11, (i14 & 2) != 0 ? KeyboardCapitalization.Companion.m5210getNoneIUNYP9k() : i11, (i14 & 4) != 0 ? true : z12, (i14 & 8) != 0 ? KeyboardType.Companion.m5227getTextPjHm6EE() : i12, (i14 & 16) != 0 ? ImeAction.Companion.m5187getDefaulteUduSuo() : i13, (DefaultConstructorMarker) null);
    }
}
