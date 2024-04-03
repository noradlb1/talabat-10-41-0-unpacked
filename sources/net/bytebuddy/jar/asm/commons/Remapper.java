package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.signature.SignatureReader;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.jar.asm.signature.SignatureWriter;

public abstract class Remapper {
    private Type mapType(Type type) {
        switch (type.getSort()) {
            case 9:
                StringBuilder sb2 = new StringBuilder();
                for (int i11 = 0; i11 < type.getDimensions(); i11++) {
                    sb2.append('[');
                }
                sb2.append(mapType(type.getElementType()).getDescriptor());
                return Type.getType(sb2.toString());
            case 10:
                String map = map(type.getInternalName());
                return map != null ? Type.getObjectType(map) : type;
            case 11:
                return Type.getMethodType(mapMethodDesc(type.getDescriptor()));
            default:
                return type;
        }
    }

    public SignatureVisitor a(SignatureVisitor signatureVisitor) {
        return new SignatureRemapper(signatureVisitor, this);
    }

    public String map(String str) {
        return str;
    }

    public String mapAnnotationAttributeName(String str, String str2) {
        return str2;
    }

    public String mapDesc(String str) {
        return mapType(Type.getType(str)).getDescriptor();
    }

    public String mapFieldName(String str, String str2, String str3) {
        return str2;
    }

    public String mapInnerClassName(String str, String str2, String str3) {
        String mapType = mapType(str);
        if (!mapType.contains("$")) {
            return str3;
        }
        int lastIndexOf = mapType.lastIndexOf(36);
        do {
            lastIndexOf++;
            if (lastIndexOf >= mapType.length() || !Character.isDigit(mapType.charAt(lastIndexOf))) {
            }
            lastIndexOf++;
            break;
        } while (!Character.isDigit(mapType.charAt(lastIndexOf)));
        return mapType.substring(lastIndexOf);
    }

    public String mapInvokeDynamicMethodName(String str, String str2) {
        return str;
    }

    public String mapMethodDesc(String str) {
        if ("()V".equals(str)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder("(");
        for (Type mapType : Type.getArgumentTypes(str)) {
            sb2.append(mapType(mapType).getDescriptor());
        }
        Type returnType = Type.getReturnType(str);
        if (returnType == Type.VOID_TYPE) {
            sb2.append(")V");
        } else {
            sb2.append(')');
            sb2.append(mapType(returnType).getDescriptor());
        }
        return sb2.toString();
    }

    public String mapMethodName(String str, String str2, String str3) {
        return str2;
    }

    public String mapModuleName(String str) {
        return str;
    }

    public String mapPackageName(String str) {
        return str;
    }

    public String mapRecordComponentName(String str, String str2, String str3) {
        return str2;
    }

    public String mapSignature(String str, boolean z11) {
        if (str == null) {
            return null;
        }
        SignatureReader signatureReader = new SignatureReader(str);
        SignatureWriter signatureWriter = new SignatureWriter();
        SignatureVisitor a11 = a(signatureWriter);
        if (z11) {
            signatureReader.acceptType(a11);
        } else {
            signatureReader.accept(a11);
        }
        return signatureWriter.toString();
    }

    public String[] mapTypes(String[] strArr) {
        String[] strArr2 = null;
        for (int i11 = 0; i11 < strArr.length; i11++) {
            String mapType = mapType(strArr[i11]);
            if (mapType != null) {
                if (strArr2 == null) {
                    strArr2 = (String[]) strArr.clone();
                }
                strArr2[i11] = mapType;
            }
        }
        if (strArr2 != null) {
            return strArr2;
        }
        return strArr;
    }

    public Object mapValue(Object obj) {
        String str;
        if (obj instanceof Type) {
            return mapType((Type) obj);
        }
        if (obj instanceof Handle) {
            Handle handle = (Handle) obj;
            int tag = handle.getTag();
            String mapType = mapType(handle.getOwner());
            String mapMethodName = mapMethodName(handle.getOwner(), handle.getName(), handle.getDesc());
            if (handle.getTag() <= 4) {
                str = mapDesc(handle.getDesc());
            } else {
                str = mapMethodDesc(handle.getDesc());
            }
            return new Handle(tag, mapType, mapMethodName, str, handle.isInterface());
        } else if (!(obj instanceof ConstantDynamic)) {
            return obj;
        } else {
            ConstantDynamic constantDynamic = (ConstantDynamic) obj;
            int bootstrapMethodArgumentCount = constantDynamic.getBootstrapMethodArgumentCount();
            Object[] objArr = new Object[bootstrapMethodArgumentCount];
            for (int i11 = 0; i11 < bootstrapMethodArgumentCount; i11++) {
                objArr[i11] = mapValue(constantDynamic.getBootstrapMethodArgument(i11));
            }
            String descriptor = constantDynamic.getDescriptor();
            return new ConstantDynamic(mapInvokeDynamicMethodName(constantDynamic.getName(), descriptor), mapDesc(descriptor), (Handle) mapValue(constantDynamic.getBootstrapMethod()), objArr);
        }
    }

    public String mapType(String str) {
        if (str == null) {
            return null;
        }
        return mapType(Type.getObjectType(str)).getInternalName();
    }
}
