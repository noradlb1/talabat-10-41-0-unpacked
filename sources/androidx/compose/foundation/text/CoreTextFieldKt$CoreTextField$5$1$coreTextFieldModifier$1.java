package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1 extends Lambda implements Function0<TextLayoutResultProxy> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldState f3416g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1(TextFieldState textFieldState) {
        super(0);
        this.f3416g = textFieldState;
    }

    @Nullable
    public final TextLayoutResultProxy invoke() {
        return this.f3416g.getLayoutResult();
    }
}
