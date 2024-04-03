package kotlin.reflect.jvm.internal.impl.name;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassId {
    private final boolean local;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str;
        int i12;
        Throwable th2;
        if (!(i11 == 5 || i11 == 6 || i11 == 7 || i11 == 9)) {
            switch (i11) {
                case 13:
                case 14:
                case 15:
                case 16:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        }
        str = "@NotNull method %s.%s must not return null";
        if (!(i11 == 5 || i11 == 6 || i11 == 7 || i11 == 9)) {
            switch (i11) {
                case 13:
                case 14:
                case 15:
                case 16:
                    break;
                default:
                    i12 = 3;
                    break;
            }
        }
        i12 = 2;
        Object[] objArr = new Object[i12];
        switch (i11) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = TypedValues.Custom.S_STRING;
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i11 == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i11 == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i11 == 7) {
            objArr[1] = "getShortClassName";
        } else if (i11 != 9) {
            switch (i11) {
                case 13:
                case 14:
                    objArr[1] = "asString";
                    break;
                case 15:
                case 16:
                    objArr[1] = "asFqNameString";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                    break;
            }
        } else {
            objArr[1] = "asSingleFqName";
        }
        switch (i11) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
            case 15:
            case 16:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        if (!(i11 == 5 || i11 == 6 || i11 == 7 || i11 == 9)) {
            switch (i11) {
                case 13:
                case 14:
                case 15:
                case 16:
                    break;
                default:
                    th2 = new IllegalArgumentException(format);
                    break;
            }
        }
        th2 = new IllegalStateException(format);
        throw th2;
    }

    public ClassId(@NotNull FqName fqName, @NotNull FqName fqName2, boolean z11) {
        if (fqName == null) {
            $$$reportNull$$$0(1);
        }
        if (fqName2 == null) {
            $$$reportNull$$$0(2);
        }
        this.packageFqName = fqName;
        this.relativeClassName = fqName2;
        this.local = z11;
    }

    @NotNull
    public static ClassId fromString(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(11);
        }
        return fromString(str, false);
    }

    @NotNull
    public static ClassId topLevel(@NotNull FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(0);
        }
        return new ClassId(fqName.parent(), fqName.shortName());
    }

    @NotNull
    public FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            FqName fqName = this.relativeClassName;
            if (fqName == null) {
                $$$reportNull$$$0(9);
            }
            return fqName;
        }
        return new FqName(this.packageFqName.asString() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + this.relativeClassName.asString());
    }

    @NotNull
    public String asString() {
        if (this.packageFqName.isRoot()) {
            String asString = this.relativeClassName.asString();
            if (asString == null) {
                $$$reportNull$$$0(13);
            }
            return asString;
        }
        String str = this.packageFqName.asString().replace('.', '/') + "/" + this.relativeClassName.asString();
        if (str == null) {
            $$$reportNull$$$0(14);
        }
        return str;
    }

    @NotNull
    public ClassId createNestedClassId(@NotNull Name name2) {
        if (name2 == null) {
            $$$reportNull$$$0(8);
        }
        return new ClassId(getPackageFqName(), this.relativeClassName.child(name2), this.local);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClassId.class != obj.getClass()) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        if (!this.packageFqName.equals(classId.packageFqName) || !this.relativeClassName.equals(classId.relativeClassName) || this.local != classId.local) {
            return false;
        }
        return true;
    }

    @Nullable
    public ClassId getOuterClassId() {
        FqName parent = this.relativeClassName.parent();
        if (parent.isRoot()) {
            return null;
        }
        return new ClassId(getPackageFqName(), parent, this.local);
    }

    @NotNull
    public FqName getPackageFqName() {
        FqName fqName = this.packageFqName;
        if (fqName == null) {
            $$$reportNull$$$0(5);
        }
        return fqName;
    }

    @NotNull
    public FqName getRelativeClassName() {
        FqName fqName = this.relativeClassName;
        if (fqName == null) {
            $$$reportNull$$$0(6);
        }
        return fqName;
    }

    @NotNull
    public Name getShortClassName() {
        Name shortName = this.relativeClassName.shortName();
        if (shortName == null) {
            $$$reportNull$$$0(7);
        }
        return shortName;
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31) + Boolean.valueOf(this.local).hashCode();
    }

    public boolean isLocal() {
        return this.local;
    }

    public boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public String toString() {
        if (!this.packageFqName.isRoot()) {
            return asString();
        }
        return "/" + asString();
    }

    @NotNull
    public static ClassId fromString(@NotNull String str, boolean z11) {
        String str2;
        if (str == null) {
            $$$reportNull$$$0(12);
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            str2 = "";
        } else {
            String replace = str.substring(0, lastIndexOf).replace('/', '.');
            str = str.substring(lastIndexOf + 1);
            str2 = replace;
        }
        return new ClassId(new FqName(str2), new FqName(str), z11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ClassId(@NotNull FqName fqName, @NotNull Name name2) {
        this(fqName, FqName.topLevel(name2), false);
        if (fqName == null) {
            $$$reportNull$$$0(3);
        }
        if (name2 == null) {
            $$$reportNull$$$0(4);
        }
    }
}
