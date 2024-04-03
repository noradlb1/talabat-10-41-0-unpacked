package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;

public class AttributeLayout implements IMatcher {
    public static final String ACC_ABSTRACT = "ACC_ABSTRACT";
    public static final String ACC_ANNOTATION = "ACC_ANNOTATION";
    public static final String ACC_ENUM = "ACC_ENUM";
    public static final String ACC_FINAL = "ACC_FINAL";
    public static final String ACC_INTERFACE = "ACC_INTERFACE";
    public static final String ACC_NATIVE = "ACC_NATIVE";
    public static final String ACC_PRIVATE = "ACC_PRIVATE";
    public static final String ACC_PROTECTED = "ACC_PROTECTED";
    public static final String ACC_PUBLIC = "ACC_PUBLIC";
    public static final String ACC_STATIC = "ACC_STATIC";
    public static final String ACC_STRICT = "ACC_STRICT";
    public static final String ACC_SYNCHRONIZED = "ACC_SYNCHRONIZED";
    public static final String ACC_SYNTHETIC = "ACC_SYNTHETIC";
    public static final String ACC_TRANSIENT = "ACC_TRANSIENT";
    public static final String ACC_VOLATILE = "ACC_VOLATILE";
    public static final String ATTRIBUTE_ANNOTATION_DEFAULT = "AnnotationDefault";
    public static final String ATTRIBUTE_CLASS_FILE_VERSION = "class-file version";
    public static final String ATTRIBUTE_CODE = "Code";
    public static final String ATTRIBUTE_CONSTANT_VALUE = "ConstantValue";
    public static final String ATTRIBUTE_DEPRECATED = "Deprecated";
    public static final String ATTRIBUTE_ENCLOSING_METHOD = "EnclosingMethod";
    public static final String ATTRIBUTE_EXCEPTIONS = "Exceptions";
    public static final String ATTRIBUTE_INNER_CLASSES = "InnerClasses";
    public static final String ATTRIBUTE_LINE_NUMBER_TABLE = "LineNumberTable";
    public static final String ATTRIBUTE_LOCAL_VARIABLE_TABLE = "LocalVariableTable";
    public static final String ATTRIBUTE_LOCAL_VARIABLE_TYPE_TABLE = "LocalVariableTypeTable";
    public static final String ATTRIBUTE_RUNTIME_INVISIBLE_ANNOTATIONS = "RuntimeInvisibleAnnotations";
    public static final String ATTRIBUTE_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = "RuntimeInvisibleParameterAnnotations";
    public static final String ATTRIBUTE_RUNTIME_VISIBLE_ANNOTATIONS = "RuntimeVisibleAnnotations";
    public static final String ATTRIBUTE_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS = "RuntimeVisibleParameterAnnotations";
    public static final String ATTRIBUTE_SIGNATURE = "Signature";
    public static final String ATTRIBUTE_SOURCE_FILE = "SourceFile";
    public static final int CONTEXT_CLASS = 0;
    public static final int CONTEXT_CODE = 3;
    public static final int CONTEXT_FIELD = 1;
    public static final int CONTEXT_METHOD = 2;
    public static final String[] contextNames = {"Class", "Field", "Method", ATTRIBUTE_CODE};
    private int backwardsCallCount;
    private final int context;
    private final int index;
    private final boolean isDefault;
    private final String layout;
    private long mask;

    /* renamed from: name  reason: collision with root package name */
    private final String f27753name;

    public AttributeLayout(String str, int i11, String str2, int i12) throws Pack200Exception {
        this(str, i11, str2, i12, true);
    }

    private static ClassFileEntry getValue(String str, long j11, SegmentConstantPool segmentConstantPool) throws Pack200Exception {
        if (str.startsWith("R")) {
            if (str.indexOf(78) != -1) {
                j11--;
            }
            if (str.startsWith("RU")) {
                return segmentConstantPool.getValue(1, j11);
            }
            if (str.startsWith("RS")) {
                return segmentConstantPool.getValue(8, j11);
            }
        } else if (str.startsWith("K")) {
            char charAt = str.charAt(1);
            if (charAt != 'C') {
                if (charAt == 'D') {
                    return segmentConstantPool.getValue(5, j11);
                }
                if (charAt == 'F') {
                    return segmentConstantPool.getValue(3, j11);
                }
                if (charAt == 'S') {
                    return segmentConstantPool.getValue(6, j11);
                }
                if (charAt != 'I') {
                    if (charAt == 'J') {
                        return segmentConstantPool.getValue(4, j11);
                    }
                }
            }
            return segmentConstantPool.getValue(2, j11);
        }
        throw new Pack200Exception("Unknown layout encoding: " + str);
    }

    public Codec getCodec() {
        if (this.layout.indexOf(79) >= 0) {
            return Codec.BRANCH5;
        }
        if (this.layout.indexOf(80) >= 0) {
            return Codec.BCI5;
        }
        if (this.layout.indexOf(83) >= 0 && this.layout.indexOf("KS") < 0 && this.layout.indexOf("RS") < 0) {
            return Codec.SIGNED5;
        }
        if (this.layout.indexOf(66) >= 0) {
            return Codec.BYTE1;
        }
        return Codec.UNSIGNED5;
    }

    public int getContext() {
        return this.context;
    }

    public int getIndex() {
        return this.index;
    }

    public String getLayout() {
        return this.layout;
    }

    public String getName() {
        return this.f27753name;
    }

    public int hashCode() {
        int i11;
        String str = this.f27753name;
        if (str != null) {
            i11 = str.hashCode() + 31;
        } else {
            i11 = 1;
        }
        String str2 = this.layout;
        if (str2 != null) {
            i11 = (i11 * 31) + str2.hashCode();
        }
        return (((i11 * 31) + this.index) * 31) + this.context;
    }

    public boolean isDefaultLayout() {
        return this.isDefault;
    }

    public boolean matches(long j11) {
        return (j11 & this.mask) != 0;
    }

    public int numBackwardsCallables() {
        if (this.layout == "*") {
            return 1;
        }
        return this.backwardsCallCount;
    }

    public void setBackwardsCallCount(int i11) {
        this.backwardsCallCount = i11;
    }

    public String toString() {
        return contextNames[this.context] + ": " + this.f27753name;
    }

    public AttributeLayout(String str, int i11, String str2, int i12, boolean z11) throws Pack200Exception {
        this.index = i12;
        this.context = i11;
        if (i12 >= 0) {
            this.mask = 1 << i12;
        } else {
            this.mask = 0;
        }
        if (i11 != 0 && i11 != 3 && i11 != 1 && i11 != 2) {
            throw new Pack200Exception("Attribute context out of range: " + i11);
        } else if (str2 == null) {
            throw new Pack200Exception("Cannot have a null layout");
        } else if (str == null || str.length() == 0) {
            throw new Pack200Exception("Cannot have an unnamed layout");
        } else {
            this.f27753name = str;
            this.layout = str2;
            this.isDefault = z11;
        }
    }

    public ClassFileEntry getValue(long j11, SegmentConstantPool segmentConstantPool) throws Pack200Exception {
        return getValue(this.layout, j11, segmentConstantPool);
    }

    public ClassFileEntry getValue(long j11, String str, SegmentConstantPool segmentConstantPool) throws Pack200Exception {
        if (!this.layout.startsWith("KQ")) {
            return getValue(this.layout, j11, segmentConstantPool);
        }
        if (str.equals("Ljava/lang/String;")) {
            return getValue("KS", j11, segmentConstantPool);
        }
        return getValue("K" + str + this.layout.substring(2), j11, segmentConstantPool);
    }
}
