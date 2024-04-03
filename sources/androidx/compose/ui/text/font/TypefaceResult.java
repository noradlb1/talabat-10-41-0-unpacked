package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0007\bR\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\nø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceResult;", "Landroidx/compose/runtime/State;", "", "cacheable", "", "getCacheable", "()Z", "Async", "Immutable", "Landroidx/compose/ui/text/font/TypefaceResult$Async;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface TypefaceResult extends State<Object> {

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u0003X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceResult$Async;", "Landroidx/compose/ui/text/font/TypefaceResult;", "Landroidx/compose/runtime/State;", "", "current", "Landroidx/compose/ui/text/font/AsyncFontListLoader;", "(Landroidx/compose/ui/text/font/AsyncFontListLoader;)V", "cacheable", "", "getCacheable", "()Z", "getCurrent$ui_text_release", "()Landroidx/compose/ui/text/font/AsyncFontListLoader;", "value", "getValue", "()Ljava/lang/Object;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Async implements TypefaceResult, State<Object> {
        public static final int $stable = 0;
        @NotNull
        private final AsyncFontListLoader current;

        public Async(@NotNull AsyncFontListLoader asyncFontListLoader) {
            Intrinsics.checkNotNullParameter(asyncFontListLoader, "current");
            this.current = asyncFontListLoader;
        }

        public boolean getCacheable() {
            return this.current.getCacheable$ui_text_release();
        }

        @NotNull
        public final AsyncFontListLoader getCurrent$ui_text_release() {
            return this.current;
        }

        @NotNull
        public Object getValue() {
            return this.current.getValue();
        }
    }

    boolean getCacheable();

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "Landroidx/compose/ui/text/font/TypefaceResult;", "value", "", "cacheable", "", "(Ljava/lang/Object;Z)V", "getCacheable", "()Z", "getValue", "()Ljava/lang/Object;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Immutable implements TypefaceResult {
        public static final int $stable = 0;
        private final boolean cacheable;
        @NotNull
        private final Object value;

        public Immutable(@NotNull Object obj, boolean z11) {
            Intrinsics.checkNotNullParameter(obj, "value");
            this.value = obj;
            this.cacheable = z11;
        }

        public boolean getCacheable() {
            return this.cacheable;
        }

        @NotNull
        public Object getValue() {
            return this.value;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Immutable(Object obj, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i11 & 2) != 0 ? true : z11);
        }
    }
}
