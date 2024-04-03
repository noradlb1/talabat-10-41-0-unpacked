package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ClickableKt$clickable$4$delayPressInteraction$1$1 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f1536g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Boolean> f1537h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$clickable$4$delayPressInteraction$1$1(MutableState<Boolean> mutableState, Function0<Boolean> function0) {
        super(0);
        this.f1536g = mutableState;
        this.f1537h = function0;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(this.f1536g.getValue().booleanValue() || this.f1537h.invoke().booleanValue());
    }
}
