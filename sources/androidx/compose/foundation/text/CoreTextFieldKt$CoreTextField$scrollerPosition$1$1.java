package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$CoreTextField$scrollerPosition$1$1 extends Lambda implements Function0<TextFieldScrollerPosition> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Orientation f3461g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$scrollerPosition$1$1(Orientation orientation) {
        super(0);
        this.f3461g = orientation;
    }

    @NotNull
    public final TextFieldScrollerPosition invoke() {
        return new TextFieldScrollerPosition(this.f3461g, 0.0f, 2, (DefaultConstructorMarker) null);
    }
}
