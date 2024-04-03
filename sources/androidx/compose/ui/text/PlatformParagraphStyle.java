package androidx.compose.ui.text;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0000J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/PlatformParagraphStyle;", "", "includeFontPadding", "", "(Z)V", "()V", "getIncludeFontPadding$annotations", "getIncludeFontPadding", "()Z", "equals", "other", "hashCode", "", "merge", "toString", "", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PlatformParagraphStyle {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final PlatformParagraphStyle Default = new PlatformParagraphStyle();
    private final boolean includeFontPadding;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/PlatformParagraphStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "getDefault", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PlatformParagraphStyle getDefault() {
            return PlatformParagraphStyle.Default;
        }
    }

    @Deprecated(message = "Provides configuration options for behavior compatibility.")
    public PlatformParagraphStyle(boolean z11) {
        this.includeFontPadding = z11;
    }

    @Deprecated(message = "Sets includeFontPadding parameter for transitioning. Will be removed.")
    public static /* synthetic */ void getIncludeFontPadding$annotations() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof PlatformParagraphStyle) && this.includeFontPadding == ((PlatformParagraphStyle) obj).includeFontPadding) {
            return true;
        }
        return false;
    }

    public final boolean getIncludeFontPadding() {
        return this.includeFontPadding;
    }

    public int hashCode() {
        return e.a(this.includeFontPadding);
    }

    @NotNull
    public final PlatformParagraphStyle merge(@Nullable PlatformParagraphStyle platformParagraphStyle) {
        return platformParagraphStyle == null ? this : platformParagraphStyle;
    }

    @NotNull
    public String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.includeFontPadding + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlatformParagraphStyle(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11);
    }

    public PlatformParagraphStyle() {
        this(true);
    }
}
