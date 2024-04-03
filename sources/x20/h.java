package x20;

import j$.util.function.ToIntFunction;
import org.junit.jupiter.api.ClassDescriptor;
import org.junit.jupiter.api.ClassOrderer;

public final /* synthetic */ class h implements ToIntFunction {
    public final int applyAsInt(Object obj) {
        return ClassOrderer.OrderAnnotation.getOrder((ClassDescriptor) obj);
    }
}
