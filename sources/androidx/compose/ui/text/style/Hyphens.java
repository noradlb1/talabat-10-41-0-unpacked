package androidx.compose.ui.text.style;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@StabilityInferred(parameters = 0)
@ExperimentalTextApi
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/text/style/Hyphens;", "", "()V", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Hyphens {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    @NotNull
    public static final Hyphens Auto = new Hyphens();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Hyphens None = new Hyphens();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/style/Hyphens$Companion;", "", "()V", "Auto", "Landroidx/compose/ui/text/style/Hyphens;", "getAuto", "()Landroidx/compose/ui/text/style/Hyphens;", "None", "getNone", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Hyphens getAuto() {
            return Hyphens.Auto;
        }

        @NotNull
        public final Hyphens getNone() {
            return Hyphens.None;
        }
    }

    private Hyphens() {
    }
}
