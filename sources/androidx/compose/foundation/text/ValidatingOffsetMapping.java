package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/ValidatingOffsetMapping;", "Landroidx/compose/ui/text/input/OffsetMapping;", "delegate", "originalLength", "", "transformedLength", "(Landroidx/compose/ui/text/input/OffsetMapping;II)V", "originalToTransformed", "offset", "transformedToOriginal", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ValidatingOffsetMapping implements OffsetMapping {
    @NotNull
    private final OffsetMapping delegate;
    private final int originalLength;
    private final int transformedLength;

    public ValidatingOffsetMapping(@NotNull OffsetMapping offsetMapping, int i11, int i12) {
        Intrinsics.checkNotNullParameter(offsetMapping, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = offsetMapping;
        this.originalLength = i11;
        this.transformedLength = i12;
    }

    public int originalToTransformed(int i11) {
        int originalToTransformed = this.delegate.originalToTransformed(i11);
        boolean z11 = false;
        if (originalToTransformed >= 0 && originalToTransformed <= this.transformedLength) {
            z11 = true;
        }
        if (z11) {
            return originalToTransformed;
        }
        throw new IllegalStateException(("OffsetMapping.originalToTransformed returned invalid mapping: " + i11 + " -> " + originalToTransformed + " is not in range of transformed text [0, " + this.transformedLength + AbstractJsonLexerKt.END_LIST).toString());
    }

    public int transformedToOriginal(int i11) {
        int transformedToOriginal = this.delegate.transformedToOriginal(i11);
        boolean z11 = false;
        if (transformedToOriginal >= 0 && transformedToOriginal <= this.originalLength) {
            z11 = true;
        }
        if (z11) {
            return transformedToOriginal;
        }
        throw new IllegalStateException(("OffsetMapping.transformedToOriginal returned invalid mapping: " + i11 + " -> " + transformedToOriginal + " is not in range of original text [0, " + this.originalLength + AbstractJsonLexerKt.END_LIST).toString());
    }
}
