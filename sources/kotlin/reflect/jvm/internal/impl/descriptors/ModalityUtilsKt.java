package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ModalityUtilsKt {
    public static final boolean isFinalClass(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        if (classDescriptor.getModality() != Modality.FINAL || classDescriptor.getKind() == ClassKind.ENUM_CLASS) {
            return false;
        }
        return true;
    }
}
