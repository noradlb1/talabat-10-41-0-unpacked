package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FilteredAnnotations implements Annotations {
    @NotNull
    private final Annotations delegate;
    @NotNull
    private final Function1<FqName, Boolean> fqNameFilter;
    private final boolean isDefinitelyNewInference;

    public FilteredAnnotations(@NotNull Annotations annotations, boolean z11, @NotNull Function1<? super FqName, Boolean> function1) {
        Intrinsics.checkNotNullParameter(annotations, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        Intrinsics.checkNotNullParameter(function1, "fqNameFilter");
        this.delegate = annotations;
        this.isDefinitelyNewInference = z11;
        this.fqNameFilter = function1;
    }

    private final boolean shouldBeReturned(AnnotationDescriptor annotationDescriptor) {
        FqName fqName = annotationDescriptor.getFqName();
        if (fqName == null || !this.fqNameFilter.invoke(fqName).booleanValue()) {
            return false;
        }
        return true;
    }

    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fqNameFilter.invoke(fqName).booleanValue()) {
            return this.delegate.findAnnotation(fqName);
        }
        return null;
    }

    public boolean hasAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fqNameFilter.invoke(fqName).booleanValue()) {
            return this.delegate.hasAnnotation(fqName);
        }
        return false;
    }

    public boolean isEmpty() {
        boolean z11;
        Annotations annotations = this.delegate;
        if (!(annotations instanceof Collection) || !((Collection) annotations).isEmpty()) {
            Iterator it = annotations.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (shouldBeReturned((AnnotationDescriptor) it.next())) {
                        z11 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z11 = false;
        if (!this.isDefinitelyNewInference) {
            return z11;
        }
        if (!z11) {
            return true;
        }
        return false;
    }

    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        Annotations annotations = this.delegate;
        ArrayList arrayList = new ArrayList();
        for (Object next : annotations) {
            if (shouldBeReturned((AnnotationDescriptor) next)) {
                arrayList.add(next);
            }
        }
        return arrayList.iterator();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FilteredAnnotations(@NotNull Annotations annotations, @NotNull Function1<? super FqName, Boolean> function1) {
        this(annotations, false, function1);
        Intrinsics.checkNotNullParameter(annotations, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        Intrinsics.checkNotNullParameter(function1, "fqNameFilter");
    }
}
