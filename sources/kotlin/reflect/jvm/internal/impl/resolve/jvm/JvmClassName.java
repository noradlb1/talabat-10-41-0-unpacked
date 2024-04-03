package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

public class JvmClassName {
    private FqName fqName;
    private final String internalName;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = (i11 == 3 || i11 == 6 || i11 == 7 || i11 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i11 == 3 || i11 == 6 || i11 == 7 || i11 == 8) ? 2 : 3)];
        switch (i11) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i11 == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i11 == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i11 == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i11 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i11) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i11 == 3 || i11 == 6 || i11 == 7 || i11 == 8) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    private JvmClassName(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(5);
        }
        this.internalName = str;
    }

    @NotNull
    public static JvmClassName byClassId(@NotNull ClassId classId) {
        if (classId == null) {
            $$$reportNull$$$0(1);
        }
        FqName packageFqName = classId.getPackageFqName();
        String replace = classId.getRelativeClassName().asString().replace('.', '$');
        if (packageFqName.isRoot()) {
            return new JvmClassName(replace);
        }
        return new JvmClassName(packageFqName.asString().replace('.', '/') + "/" + replace);
    }

    @NotNull
    public static JvmClassName byFqNameWithoutInnerClasses(@NotNull FqName fqName2) {
        if (fqName2 == null) {
            $$$reportNull$$$0(2);
        }
        JvmClassName jvmClassName = new JvmClassName(fqName2.asString().replace('.', '/'));
        jvmClassName.fqName = fqName2;
        return jvmClassName;
    }

    @NotNull
    public static JvmClassName byInternalName(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(0);
        }
        return new JvmClassName(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.internalName.equals(((JvmClassName) obj).internalName);
    }

    @NotNull
    public FqName getFqNameForTopLevelClassMaybeWithDollars() {
        return new FqName(this.internalName.replace('/', '.'));
    }

    @NotNull
    public String getInternalName() {
        String str = this.internalName;
        if (str == null) {
            $$$reportNull$$$0(8);
        }
        return str;
    }

    @NotNull
    public FqName getPackageFqName() {
        int lastIndexOf = this.internalName.lastIndexOf("/");
        if (lastIndexOf != -1) {
            return new FqName(this.internalName.substring(0, lastIndexOf).replace('/', '.'));
        }
        FqName fqName2 = FqName.ROOT;
        if (fqName2 == null) {
            $$$reportNull$$$0(7);
        }
        return fqName2;
    }

    public int hashCode() {
        return this.internalName.hashCode();
    }

    public String toString() {
        return this.internalName;
    }
}
