package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldScrollKt$textFieldScrollable$2$controller$1$1 extends Lambda implements Function1<Float, Float> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextFieldScrollerPosition f3615g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextFieldScrollKt$textFieldScrollable$2$controller$1$1(TextFieldScrollerPosition textFieldScrollerPosition) {
        super(1);
        this.f3615g = textFieldScrollerPosition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }

    @NotNull
    public final Float invoke(float f11) {
        float offset = this.f3615g.getOffset() + f11;
        if (offset > this.f3615g.getMaximum()) {
            f11 = this.f3615g.getMaximum() - this.f3615g.getOffset();
        } else if (offset < 0.0f) {
            f11 = -this.f3615g.getOffset();
        }
        TextFieldScrollerPosition textFieldScrollerPosition = this.f3615g;
        textFieldScrollerPosition.setOffset(textFieldScrollerPosition.getOffset() + f11);
        return Float.valueOf(f11);
    }
}
