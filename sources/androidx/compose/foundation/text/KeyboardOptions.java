package androidx.compose.foundation.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB0\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nJ;\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0017\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions;", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "autoCorrect", "", "keyboardType", "Landroidx/compose/ui/text/input/KeyboardType;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "(IZIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoCorrect", "()Z", "getCapitalization-IUNYP9k", "()I", "I", "getImeAction-eUduSuo", "getKeyboardType-PjHm6EE", "copy", "copy-3m2b7yw", "(IZII)Landroidx/compose/foundation/text/KeyboardOptions;", "equals", "other", "hashCode", "", "toImeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "singleLine", "toImeOptions$foundation_release", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeyboardOptions {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final KeyboardOptions Default = new KeyboardOptions(0, false, 0, 0, 15, (DefaultConstructorMarker) null);
    private final boolean autoCorrect;
    private final int capitalization;
    private final int imeAction;
    private final int keyboardType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/KeyboardOptions$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardOptions;", "getDefault", "()Landroidx/compose/foundation/text/KeyboardOptions;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KeyboardOptions getDefault() {
            return KeyboardOptions.Default;
        }
    }

    private KeyboardOptions(int i11, boolean z11, int i12, int i13) {
        this.capitalization = i11;
        this.autoCorrect = z11;
        this.keyboardType = i12;
        this.imeAction = i13;
    }

    public /* synthetic */ KeyboardOptions(int i11, boolean z11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, z11, i12, i13);
    }

    /* renamed from: copy-3m2b7yw$default  reason: not valid java name */
    public static /* synthetic */ KeyboardOptions m857copy3m2b7yw$default(KeyboardOptions keyboardOptions, int i11, boolean z11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = keyboardOptions.capitalization;
        }
        if ((i14 & 2) != 0) {
            z11 = keyboardOptions.autoCorrect;
        }
        if ((i14 & 4) != 0) {
            i12 = keyboardOptions.keyboardType;
        }
        if ((i14 & 8) != 0) {
            i13 = keyboardOptions.imeAction;
        }
        return keyboardOptions.m858copy3m2b7yw(i11, z11, i12, i13);
    }

    public static /* synthetic */ ImeOptions toImeOptions$foundation_release$default(KeyboardOptions keyboardOptions, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = ImeOptions.Companion.getDefault().getSingleLine();
        }
        return keyboardOptions.toImeOptions$foundation_release(z11);
    }

    @NotNull
    /* renamed from: copy-3m2b7yw  reason: not valid java name */
    public final KeyboardOptions m858copy3m2b7yw(int i11, boolean z11, int i12, int i13) {
        return new KeyboardOptions(i11, z11, i12, i13, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) obj;
        if (KeyboardCapitalization.m5205equalsimpl0(this.capitalization, keyboardOptions.capitalization) && this.autoCorrect == keyboardOptions.autoCorrect && KeyboardType.m5216equalsimpl0(this.keyboardType, keyboardOptions.keyboardType) && ImeAction.m5183equalsimpl0(this.imeAction, keyboardOptions.imeAction)) {
            return true;
        }
        return false;
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public final int m859getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    /* renamed from: getImeAction-eUduSuo  reason: not valid java name */
    public final int m860getImeActioneUduSuo() {
        return this.imeAction;
    }

    /* renamed from: getKeyboardType-PjHm6EE  reason: not valid java name */
    public final int m861getKeyboardTypePjHm6EE() {
        return this.keyboardType;
    }

    public int hashCode() {
        return (((((KeyboardCapitalization.m5206hashCodeimpl(this.capitalization) * 31) + e.a(this.autoCorrect)) * 31) + KeyboardType.m5217hashCodeimpl(this.keyboardType)) * 31) + ImeAction.m5184hashCodeimpl(this.imeAction);
    }

    @NotNull
    public final ImeOptions toImeOptions$foundation_release(boolean z11) {
        return new ImeOptions(z11, this.capitalization, this.autoCorrect, this.keyboardType, this.imeAction, (DefaultConstructorMarker) null);
    }

    @NotNull
    public String toString() {
        return "KeyboardOptions(capitalization=" + KeyboardCapitalization.m5207toStringimpl(this.capitalization) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + KeyboardType.m5218toStringimpl(this.keyboardType) + ", imeAction=" + ImeAction.m5185toStringimpl(this.imeAction) + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KeyboardOptions(int i11, boolean z11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? KeyboardCapitalization.Companion.m5210getNoneIUNYP9k() : i11, (i14 & 2) != 0 ? true : z11, (i14 & 4) != 0 ? KeyboardType.Companion.m5227getTextPjHm6EE() : i12, (i14 & 8) != 0 ? ImeAction.Companion.m5187getDefaulteUduSuo() : i13, (DefaultConstructorMarker) null);
    }
}
