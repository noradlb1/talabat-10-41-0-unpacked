package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public interface SyntheticJavaPartsProvider {
    @NotNull
    public static final Companion Companion = Companion.f24811a;

    public static final class Companion {
        @NotNull
        private static final CompositeSyntheticJavaPartsProvider EMPTY = new CompositeSyntheticJavaPartsProvider(CollectionsKt__CollectionsKt.emptyList());

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f24811a = new Companion();

        private Companion() {
        }

        @NotNull
        public final CompositeSyntheticJavaPartsProvider getEMPTY() {
            return EMPTY;
        }
    }

    void generateConstructors(@NotNull ClassDescriptor classDescriptor, @NotNull List<ClassConstructorDescriptor> list);

    void generateMethods(@NotNull ClassDescriptor classDescriptor, @NotNull Name name2, @NotNull Collection<SimpleFunctionDescriptor> collection);

    void generateStaticFunctions(@NotNull ClassDescriptor classDescriptor, @NotNull Name name2, @NotNull Collection<SimpleFunctionDescriptor> collection);

    @NotNull
    List<Name> getMethodNames(@NotNull ClassDescriptor classDescriptor);

    @NotNull
    List<Name> getStaticFunctionNames(@NotNull ClassDescriptor classDescriptor);
}
