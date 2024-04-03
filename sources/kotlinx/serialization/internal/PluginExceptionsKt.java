package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"throwArrayMissingFieldException", "", "seenArray", "", "goldenMaskArray", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "throwMissingFieldException", "seen", "", "goldenMask", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PluginExceptionsKt {
    @InternalSerializationApi
    public static final void throwArrayMissingFieldException(@NotNull int[] iArr, @NotNull int[] iArr2, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(iArr, "seenArray");
        Intrinsics.checkNotNullParameter(iArr2, "goldenMaskArray");
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int length = iArr2.length;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = iArr2[i11] & (~iArr[i11]);
            if (i12 != 0) {
                for (int i13 = 0; i13 < 32; i13++) {
                    if ((i12 & 1) != 0) {
                        arrayList.add(serialDescriptor.getElementName((i11 * 32) + i13));
                    }
                    i12 >>>= 1;
                }
            }
        }
        throw new MissingFieldException((List<String>) arrayList, serialDescriptor.getSerialName());
    }

    @InternalSerializationApi
    public static final void throwMissingFieldException(int i11, int i12, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i13 = (~i11) & i12;
        for (int i14 = 0; i14 < 32; i14++) {
            if ((i13 & 1) != 0) {
                arrayList.add(serialDescriptor.getElementName(i14));
            }
            i13 >>>= 1;
        }
        throw new MissingFieldException((List<String>) arrayList, serialDescriptor.getSerialName());
    }
}
