package net.bytebuddy.jar.asm;

import java.util.Arrays;

public final class ConstantDynamic {
    private final Handle bootstrapMethod;
    private final Object[] bootstrapMethodArguments;
    private final String descriptor;

    /* renamed from: name  reason: collision with root package name */
    private final String f27355name;

    public ConstantDynamic(String str, String str2, Handle handle, Object... objArr) {
        this.f27355name = str;
        this.descriptor = str2;
        this.bootstrapMethod = handle;
        this.bootstrapMethodArguments = objArr;
    }

    public Object[] a() {
        return this.bootstrapMethodArguments;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConstantDynamic)) {
            return false;
        }
        ConstantDynamic constantDynamic = (ConstantDynamic) obj;
        if (!this.f27355name.equals(constantDynamic.f27355name) || !this.descriptor.equals(constantDynamic.descriptor) || !this.bootstrapMethod.equals(constantDynamic.bootstrapMethod) || !Arrays.equals(this.bootstrapMethodArguments, constantDynamic.bootstrapMethodArguments)) {
            return false;
        }
        return true;
    }

    public Handle getBootstrapMethod() {
        return this.bootstrapMethod;
    }

    public Object getBootstrapMethodArgument(int i11) {
        return this.bootstrapMethodArguments[i11];
    }

    public int getBootstrapMethodArgumentCount() {
        return this.bootstrapMethodArguments.length;
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public String getName() {
        return this.f27355name;
    }

    public int getSize() {
        char charAt = this.descriptor.charAt(0);
        return (charAt == 'J' || charAt == 'D') ? 2 : 1;
    }

    public int hashCode() {
        return ((this.f27355name.hashCode() ^ Integer.rotateLeft(this.descriptor.hashCode(), 8)) ^ Integer.rotateLeft(this.bootstrapMethod.hashCode(), 16)) ^ Integer.rotateLeft(Arrays.hashCode(this.bootstrapMethodArguments), 24);
    }

    public String toString() {
        return this.f27355name + " : " + this.descriptor + ' ' + this.bootstrapMethod + ' ' + Arrays.toString(this.bootstrapMethodArguments);
    }
}
