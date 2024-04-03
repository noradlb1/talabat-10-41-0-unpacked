package kotlinx.serialization.json.internal;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@ExperimentalUnsignedTypes
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tH\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "sb", "Lkotlinx/serialization/json/internal/JsonStringBuilder;", "(Lkotlinx/serialization/json/internal/JsonStringBuilder;)V", "print", "", "v", "", "", "", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ComposerForUnsignedNumbers extends Composer {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(@NotNull JsonStringBuilder jsonStringBuilder) {
        super(jsonStringBuilder);
        Intrinsics.checkNotNullParameter(jsonStringBuilder, "sb");
    }

    public void print(int i11) {
        super.print(UInt.m6468toStringimpl(UInt.m6423constructorimpl(i11)));
    }

    public void print(long j11) {
        super.print(ULong.m6546toStringimpl(ULong.m6501constructorimpl(j11)));
    }

    public void print(byte b11) {
        super.print(UByte.m6390toStringimpl(UByte.m6347constructorimpl(b11)));
    }

    public void print(short s11) {
        super.print(UShort.m6650toStringimpl(UShort.m6607constructorimpl(s11)));
    }
}
