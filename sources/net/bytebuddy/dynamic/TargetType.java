package net.bytebuddy.dynamic;

import net.bytebuddy.description.type.TypeDescription;

public final class TargetType {
    public static final TypeDescription DESCRIPTION = TypeDescription.ForLoadedType.of(TargetType.class);

    private TargetType() {
        throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
    }

    public static TypeDescription resolve(TypeDescription typeDescription, TypeDescription typeDescription2) {
        int i11 = 0;
        TypeDescription typeDescription3 = typeDescription;
        while (typeDescription3.isArray()) {
            typeDescription3 = typeDescription3.getComponentType();
            i11++;
        }
        if (typeDescription3.represents(TargetType.class)) {
            return TypeDescription.ArrayProjection.of(typeDescription2, i11);
        }
        return typeDescription;
    }
}
