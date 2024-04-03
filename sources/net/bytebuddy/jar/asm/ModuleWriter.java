package net.bytebuddy.jar.asm;

final class ModuleWriter extends ModuleVisitor {
    private final ByteVector exports = new ByteVector();
    private int exportsCount;
    private int mainClassIndex;
    private final int moduleFlags;
    private final int moduleNameIndex;
    private final int moduleVersionIndex;
    private final ByteVector opens = new ByteVector();
    private int opensCount;
    private int packageCount;
    private final ByteVector packageIndex = new ByteVector();
    private final ByteVector provides = new ByteVector();
    private int providesCount;
    private final ByteVector requires = new ByteVector();
    private int requiresCount;
    private final SymbolTable symbolTable;
    private int usesCount;
    private final ByteVector usesIndex = new ByteVector();

    public ModuleWriter(SymbolTable symbolTable2, int i11, int i12, int i13) {
        super(Opcodes.ASM9);
        this.symbolTable = symbolTable2;
        this.moduleNameIndex = i11;
        this.moduleFlags = i12;
        this.moduleVersionIndex = i13;
    }

    public int a() {
        this.symbolTable.r("Module");
        int i11 = this.requires.f27350b + 22 + this.exports.f27350b + this.opens.f27350b + this.usesIndex.f27350b + this.provides.f27350b;
        if (this.packageCount > 0) {
            this.symbolTable.r("ModulePackages");
            i11 += this.packageIndex.f27350b + 8;
        }
        if (this.mainClassIndex <= 0) {
            return i11;
        }
        this.symbolTable.r("ModuleMainClass");
        return i11 + 8;
    }

    public int b() {
        int i11 = 0;
        int i12 = (this.packageCount > 0 ? 1 : 0) + 1;
        if (this.mainClassIndex > 0) {
            i11 = 1;
        }
        return i12 + i11;
    }

    public void c(ByteVector byteVector) {
        ByteVector putShort = byteVector.putShort(this.symbolTable.r("Module")).putInt(this.requires.f27350b + 16 + this.exports.f27350b + this.opens.f27350b + this.usesIndex.f27350b + this.provides.f27350b).putShort(this.moduleNameIndex).putShort(this.moduleFlags).putShort(this.moduleVersionIndex).putShort(this.requiresCount);
        ByteVector byteVector2 = this.requires;
        ByteVector putShort2 = putShort.putByteArray(byteVector2.f27349a, 0, byteVector2.f27350b).putShort(this.exportsCount);
        ByteVector byteVector3 = this.exports;
        ByteVector putShort3 = putShort2.putByteArray(byteVector3.f27349a, 0, byteVector3.f27350b).putShort(this.opensCount);
        ByteVector byteVector4 = this.opens;
        ByteVector putShort4 = putShort3.putByteArray(byteVector4.f27349a, 0, byteVector4.f27350b).putShort(this.usesCount);
        ByteVector byteVector5 = this.usesIndex;
        ByteVector putShort5 = putShort4.putByteArray(byteVector5.f27349a, 0, byteVector5.f27350b).putShort(this.providesCount);
        ByteVector byteVector6 = this.provides;
        putShort5.putByteArray(byteVector6.f27349a, 0, byteVector6.f27350b);
        if (this.packageCount > 0) {
            ByteVector putShort6 = byteVector.putShort(this.symbolTable.r("ModulePackages")).putInt(this.packageIndex.f27350b + 2).putShort(this.packageCount);
            ByteVector byteVector7 = this.packageIndex;
            putShort6.putByteArray(byteVector7.f27349a, 0, byteVector7.f27350b);
        }
        if (this.mainClassIndex > 0) {
            byteVector.putShort(this.symbolTable.r("ModuleMainClass")).putInt(2).putShort(this.mainClassIndex);
        }
    }

    public void visitEnd() {
    }

    public void visitExport(String str, int i11, String... strArr) {
        this.exports.putShort(this.symbolTable.p(str).f27406a).putShort(i11);
        if (strArr == null) {
            this.exports.putShort(0);
        } else {
            this.exports.putShort(strArr.length);
            for (String n11 : strArr) {
                this.exports.putShort(this.symbolTable.n(n11).f27406a);
            }
        }
        this.exportsCount++;
    }

    public void visitMainClass(String str) {
        this.mainClassIndex = this.symbolTable.c(str).f27406a;
    }

    public void visitOpen(String str, int i11, String... strArr) {
        this.opens.putShort(this.symbolTable.p(str).f27406a).putShort(i11);
        if (strArr == null) {
            this.opens.putShort(0);
        } else {
            this.opens.putShort(strArr.length);
            for (String n11 : strArr) {
                this.opens.putShort(this.symbolTable.n(n11).f27406a);
            }
        }
        this.opensCount++;
    }

    public void visitPackage(String str) {
        this.packageIndex.putShort(this.symbolTable.p(str).f27406a);
        this.packageCount++;
    }

    public void visitProvide(String str, String... strArr) {
        this.provides.putShort(this.symbolTable.c(str).f27406a);
        this.provides.putShort(strArr.length);
        for (String c11 : strArr) {
            this.provides.putShort(this.symbolTable.c(c11).f27406a);
        }
        this.providesCount++;
    }

    public void visitRequire(String str, int i11, String str2) {
        int i12;
        ByteVector putShort = this.requires.putShort(this.symbolTable.n(str).f27406a).putShort(i11);
        if (str2 == null) {
            i12 = 0;
        } else {
            i12 = this.symbolTable.r(str2);
        }
        putShort.putShort(i12);
        this.requiresCount++;
    }

    public void visitUse(String str) {
        this.usesIndex.putShort(this.symbolTable.c(str).f27406a);
        this.usesCount++;
    }
}
