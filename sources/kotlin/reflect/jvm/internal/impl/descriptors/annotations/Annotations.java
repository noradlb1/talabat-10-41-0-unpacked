package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {
    @NotNull
    public static final Companion Companion = Companion.f24493a;

    public static final class Companion {
        @NotNull
        private static final Annotations EMPTY = new Annotations$Companion$EMPTY$1();

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f24493a = new Companion();

        private Companion() {
        }

        @NotNull
        public final Annotations create(@NotNull List<? extends AnnotationDescriptor> list) {
            Intrinsics.checkNotNullParameter(list, "annotations");
            if (list.isEmpty()) {
                return EMPTY;
            }
            return new AnnotationsImpl(list);
        }

        @NotNull
        public final Annotations getEMPTY() {
            return EMPTY;
        }
    }

    public static final class DefaultImpls {
        @Nullable
        public static AnnotationDescriptor findAnnotation(@NotNull Annotations annotations, @NotNull FqName fqName) {
            Object obj;
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Iterator it = annotations.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((AnnotationDescriptor) obj).getFqName(), (Object) fqName)) {
                    break;
                }
            }
            return (AnnotationDescriptor) obj;
        }

        public static boolean hasAnnotation(@NotNull Annotations annotations, @NotNull FqName fqName) {
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            if (annotations.findAnnotation(fqName) != null) {
                return true;
            }
            return false;
        }
    }

    @Nullable
    AnnotationDescriptor findAnnotation(@NotNull FqName fqName);

    boolean hasAnnotation(@NotNull FqName fqName);

    boolean isEmpty();
}
