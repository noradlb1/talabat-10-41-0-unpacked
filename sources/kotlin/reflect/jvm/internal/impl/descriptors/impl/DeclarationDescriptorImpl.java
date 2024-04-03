package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

public abstract class DeclarationDescriptorImpl extends AnnotatedImpl implements DeclarationDescriptor {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final Name f24513name;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = (i11 == 2 || i11 == 3 || i11 == 5 || i11 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i11 == 2 || i11 == 3 || i11 == 5 || i11 == 6) ? 2 : 3)];
        switch (i11) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
                break;
            case 4:
                objArr[0] = "descriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        if (i11 == 2) {
            objArr[1] = "getName";
        } else if (i11 == 3) {
            objArr[1] = "getOriginal";
        } else if (i11 == 5 || i11 == 6) {
            objArr[1] = "toString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl";
        }
        if (!(i11 == 2 || i11 == 3)) {
            if (i11 == 4) {
                objArr[2] = "toString";
            } else if (!(i11 == 5 || i11 == 6)) {
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
            }
        }
        String format = String.format(str, objArr);
        throw ((i11 == 2 || i11 == 3 || i11 == 5 || i11 == 6) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeclarationDescriptorImpl(@NotNull Annotations annotations, @NotNull Name name2) {
        super(annotations);
        if (annotations == null) {
            $$$reportNull$$$0(0);
        }
        if (name2 == null) {
            $$$reportNull$$$0(1);
        }
        this.f24513name = name2;
    }

    @NotNull
    public Name getName() {
        Name name2 = this.f24513name;
        if (name2 == null) {
            $$$reportNull$$$0(2);
        }
        return name2;
    }

    @NotNull
    public DeclarationDescriptor getOriginal() {
        return this;
    }

    public String toString() {
        return toString(this);
    }

    @NotNull
    public static String toString(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(4);
        }
        try {
            String str = DescriptorRenderer.DEBUG_TEXT.render(declarationDescriptor) + "[" + declarationDescriptor.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(declarationDescriptor)) + "]";
            if (str == null) {
                $$$reportNull$$$0(5);
            }
            return str;
        } catch (Throwable unused) {
            String str2 = declarationDescriptor.getClass().getSimpleName() + " " + declarationDescriptor.getName();
            if (str2 == null) {
                $$$reportNull$$$0(6);
            }
            return str2;
        }
    }
}
