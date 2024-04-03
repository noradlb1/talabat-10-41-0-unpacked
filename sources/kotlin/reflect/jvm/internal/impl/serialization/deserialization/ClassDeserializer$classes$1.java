package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassDeserializer$classes$1 extends Lambda implements Function1<ClassDeserializer.ClassKey, ClassDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ClassDeserializer f24825g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClassDeserializer$classes$1(ClassDeserializer classDeserializer) {
        super(1);
        this.f24825g = classDeserializer;
    }

    @Nullable
    public final ClassDescriptor invoke(@NotNull ClassDeserializer.ClassKey classKey) {
        Intrinsics.checkNotNullParameter(classKey, "key");
        return this.f24825g.createClass(classKey);
    }
}
