package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.BitEncoding;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReadKotlinClassHeaderAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
    private static final Map<ClassId, KotlinClassHeader.Kind> HEADER_KINDS;
    private static final boolean IGNORE_OLD_METADATA = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    /* access modifiers changed from: private */
    public String[] data = null;
    /* access modifiers changed from: private */
    public int extraInt = 0;
    /* access modifiers changed from: private */
    public String extraString = null;
    /* access modifiers changed from: private */
    public KotlinClassHeader.Kind headerKind = null;
    private String[] incompatibleData = null;
    /* access modifiers changed from: private */
    public int[] metadataVersionArray = null;
    /* access modifiers changed from: private */
    public String packageName = null;
    /* access modifiers changed from: private */
    public String[] serializedIrFields = null;
    /* access modifiers changed from: private */
    public String[] strings = null;

    public static abstract class CollectStringArrayAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
        private final List<String> strings = new ArrayList();

        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            Object[] objArr = new Object[3];
            if (i11 == 1) {
                objArr[0] = "enumEntryName";
            } else if (i11 == 2) {
                objArr[0] = "classLiteralValue";
            } else if (i11 != 3) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i11 == 2) {
                objArr[2] = "visitClassLiteral";
            } else if (i11 != 3) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public abstract void a(@NotNull String[] strArr);

        public void visit(@Nullable Object obj) {
            if (obj instanceof String) {
                this.strings.add((String) obj);
            }
        }

        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId) {
            if (classId != null) {
                return null;
            }
            $$$reportNull$$$0(3);
            return null;
        }

        public void visitClassLiteral(@NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(2);
            }
        }

        public void visitEnd() {
            a((String[]) this.strings.toArray(new String[0]));
        }

        public void visitEnum(@NotNull ClassId classId, @NotNull Name name2) {
            if (classId == null) {
                $$$reportNull$$$0(0);
            }
            if (name2 == null) {
                $$$reportNull$$$0(1);
            }
        }
    }

    public class KotlinMetadataArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            Object[] objArr = new Object[3];
            if (i11 == 1) {
                objArr[0] = "enumClassId";
            } else if (i11 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i11 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (i11 == 1 || i11 == 2) {
                objArr[2] = "visitEnum";
            } else if (i11 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private KotlinMetadataArgumentVisitor() {
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() {
                private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"}));
                }

                public void a(@NotNull String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    String[] unused = ReadKotlinClassHeaderAnnotationVisitor.this.data = strArr;
                }
            };
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() {
                private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"}));
                }

                public void a(@NotNull String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    String[] unused = ReadKotlinClassHeaderAnnotationVisitor.this.strings = strArr;
                }
            };
        }

        public void visit(@Nullable Name name2, @Nullable Object obj) {
            if (name2 != null) {
                String asString = name2.asString();
                if ("k".equals(asString)) {
                    if (obj instanceof Integer) {
                        KotlinClassHeader.Kind unused = ReadKotlinClassHeaderAnnotationVisitor.this.headerKind = KotlinClassHeader.Kind.getById(((Integer) obj).intValue());
                    }
                } else if ("mv".equals(asString)) {
                    if (obj instanceof int[]) {
                        int[] unused2 = ReadKotlinClassHeaderAnnotationVisitor.this.metadataVersionArray = (int[]) obj;
                    }
                } else if ("xs".equals(asString)) {
                    if (obj instanceof String) {
                        String unused3 = ReadKotlinClassHeaderAnnotationVisitor.this.extraString = (String) obj;
                    }
                } else if ("xi".equals(asString)) {
                    if (obj instanceof Integer) {
                        int unused4 = ReadKotlinClassHeaderAnnotationVisitor.this.extraInt = ((Integer) obj).intValue();
                    }
                } else if ("pn".equals(asString) && (obj instanceof String)) {
                    String unused5 = ReadKotlinClassHeaderAnnotationVisitor.this.packageName = (String) obj;
                }
            }
        }

        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name2, @NotNull ClassId classId) {
            if (classId != null) {
                return null;
            }
            $$$reportNull$$$0(3);
            return null;
        }

        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name2) {
            String str;
            if (name2 != null) {
                str = name2.asString();
            } else {
                str = null;
            }
            if ("d1".equals(str)) {
                return dataArrayVisitor();
            }
            if ("d2".equals(str)) {
                return stringsArrayVisitor();
            }
            return null;
        }

        public void visitClassLiteral(@Nullable Name name2, @NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(0);
            }
        }

        public void visitEnd() {
        }

        public void visitEnum(@Nullable Name name2, @NotNull ClassId classId, @NotNull Name name3) {
            if (classId == null) {
                $$$reportNull$$$0(1);
            }
            if (name3 == null) {
                $$$reportNull$$$0(2);
            }
        }
    }

    public class KotlinSerializedIrArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            Object[] objArr = new Object[3];
            if (i11 == 1) {
                objArr[0] = "enumClassId";
            } else if (i11 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i11 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (i11 == 1 || i11 == 2) {
                objArr[2] = "visitEnum";
            } else if (i11 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private KotlinSerializedIrArgumentVisitor() {
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor serializedIrArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() {
                private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1", "visitEnd"}));
                }

                public void a(@NotNull String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    String[] unused = ReadKotlinClassHeaderAnnotationVisitor.this.serializedIrFields = strArr;
                }
            };
        }

        public void visit(@Nullable Name name2, @Nullable Object obj) {
        }

        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name2, @NotNull ClassId classId) {
            if (classId != null) {
                return null;
            }
            $$$reportNull$$$0(3);
            return null;
        }

        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name2) {
            String str;
            if (name2 != null) {
                str = name2.asString();
            } else {
                str = null;
            }
            if ("b".equals(str)) {
                return serializedIrArrayVisitor();
            }
            return null;
        }

        public void visitClassLiteral(@Nullable Name name2, @NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(0);
            }
        }

        public void visitEnd() {
        }

        public void visitEnum(@Nullable Name name2, @NotNull ClassId classId, @NotNull Name name3) {
            if (classId == null) {
                $$$reportNull$$$0(1);
            }
            if (name3 == null) {
                $$$reportNull$$$0(2);
            }
        }
    }

    public class OldDeprecatedAnnotationArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        private static /* synthetic */ void $$$reportNull$$$0(int i11) {
            Object[] objArr = new Object[3];
            if (i11 == 1) {
                objArr[0] = "enumClassId";
            } else if (i11 == 2) {
                objArr[0] = "enumEntryName";
            } else if (i11 != 3) {
                objArr[0] = "classLiteralValue";
            } else {
                objArr[0] = "classId";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (i11 == 1 || i11 == 2) {
                objArr[2] = "visitEnum";
            } else if (i11 != 3) {
                objArr[2] = "visitClassLiteral";
            } else {
                objArr[2] = "visitAnnotation";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private OldDeprecatedAnnotationArgumentVisitor() {
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor dataArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() {
                private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"}));
                }

                public void a(@NotNull String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    String[] unused = ReadKotlinClassHeaderAnnotationVisitor.this.data = strArr;
                }
            };
        }

        @NotNull
        private KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor stringsArrayVisitor() {
            return new CollectStringArrayAnnotationVisitor() {
                private static /* synthetic */ void $$$reportNull$$$0(int i11) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"}));
                }

                public void a(@NotNull String[] strArr) {
                    if (strArr == null) {
                        $$$reportNull$$$0(0);
                    }
                    String[] unused = ReadKotlinClassHeaderAnnotationVisitor.this.strings = strArr;
                }
            };
        }

        public void visit(@Nullable Name name2, @Nullable Object obj) {
            String str;
            if (name2 != null) {
                String asString = name2.asString();
                if ("version".equals(asString)) {
                    if (obj instanceof int[]) {
                        int[] unused = ReadKotlinClassHeaderAnnotationVisitor.this.metadataVersionArray = (int[]) obj;
                    }
                } else if ("multifileClassName".equals(asString)) {
                    ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = ReadKotlinClassHeaderAnnotationVisitor.this;
                    if (obj instanceof String) {
                        str = (String) obj;
                    } else {
                        str = null;
                    }
                    String unused2 = readKotlinClassHeaderAnnotationVisitor.extraString = str;
                }
            }
        }

        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@Nullable Name name2, @NotNull ClassId classId) {
            if (classId != null) {
                return null;
            }
            $$$reportNull$$$0(3);
            return null;
        }

        @Nullable
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(@Nullable Name name2) {
            String str;
            if (name2 != null) {
                str = name2.asString();
            } else {
                str = null;
            }
            if ("data".equals(str) || "filePartClassNames".equals(str)) {
                return dataArrayVisitor();
            }
            if ("strings".equals(str)) {
                return stringsArrayVisitor();
            }
            return null;
        }

        public void visitClassLiteral(@Nullable Name name2, @NotNull ClassLiteralValue classLiteralValue) {
            if (classLiteralValue == null) {
                $$$reportNull$$$0(0);
            }
        }

        public void visitEnd() {
        }

        public void visitEnum(@Nullable Name name2, @NotNull ClassId classId, @NotNull Name name3) {
            if (classId == null) {
                $$$reportNull$$$0(1);
            }
            if (name3 == null) {
                $$$reportNull$$$0(2);
            }
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        Object[] objArr = new Object[3];
        if (i11 != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    static {
        HashMap hashMap = new HashMap();
        HEADER_KINDS = hashMap;
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.Kind.CLASS);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.Kind.FILE_FACADE);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.Kind.MULTIFILE_CLASS);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.Kind.MULTIFILE_CLASS_PART);
        hashMap.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.Kind.SYNTHETIC_CLASS);
    }

    private boolean shouldHaveData() {
        KotlinClassHeader.Kind kind = this.headerKind;
        return kind == KotlinClassHeader.Kind.CLASS || kind == KotlinClassHeader.Kind.FILE_FACADE || kind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART;
    }

    @Nullable
    public KotlinClassHeader createHeader() {
        boolean z11;
        byte[] bArr = null;
        if (this.headerKind == null || this.metadataVersionArray == null) {
            return null;
        }
        int[] iArr = this.metadataVersionArray;
        if ((this.extraInt & 8) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(iArr, z11);
        if (!jvmMetadataVersion.isCompatible()) {
            this.incompatibleData = this.data;
            this.data = null;
        } else if (shouldHaveData() && this.data == null) {
            return null;
        }
        String[] strArr = this.serializedIrFields;
        if (strArr != null) {
            bArr = BitEncoding.decodeBytes(strArr);
        }
        return new KotlinClassHeader(this.headerKind, jvmMetadataVersion, this.data, this.incompatibleData, this.strings, this.extraString, this.extraInt, this.packageName, bArr);
    }

    @Nullable
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement) {
        KotlinClassHeader.Kind kind;
        if (classId == null) {
            $$$reportNull$$$0(0);
        }
        if (sourceElement == null) {
            $$$reportNull$$$0(1);
        }
        FqName asSingleFqName = classId.asSingleFqName();
        if (asSingleFqName.equals(JvmAnnotationNames.METADATA_FQ_NAME)) {
            return new KotlinMetadataArgumentVisitor();
        }
        if (asSingleFqName.equals(JvmAnnotationNames.SERIALIZED_IR_FQ_NAME)) {
            return new KotlinSerializedIrArgumentVisitor();
        }
        if (IGNORE_OLD_METADATA || this.headerKind != null || (kind = HEADER_KINDS.get(classId)) == null) {
            return null;
        }
        this.headerKind = kind;
        return new OldDeprecatedAnnotationArgumentVisitor();
    }

    public void visitEnd() {
    }
}
