package net.bytebuddy.jar.asm.commons;

import net.bytebuddy.jar.asm.ModuleVisitor;
import net.bytebuddy.jar.asm.Opcodes;

public class ModuleRemapper extends ModuleVisitor {

    /* renamed from: c  reason: collision with root package name */
    public final Remapper f27422c;

    public ModuleRemapper(ModuleVisitor moduleVisitor, Remapper remapper) {
        this(Opcodes.ASM9, moduleVisitor, remapper);
    }

    public void visitExport(String str, int i11, String... strArr) {
        String[] strArr2;
        if (strArr != null) {
            strArr2 = new String[strArr.length];
            for (int i12 = 0; i12 < strArr.length; i12++) {
                strArr2[i12] = this.f27422c.mapModuleName(strArr[i12]);
            }
        } else {
            strArr2 = null;
        }
        super.visitExport(this.f27422c.mapPackageName(str), i11, strArr2);
    }

    public void visitMainClass(String str) {
        super.visitMainClass(this.f27422c.mapType(str));
    }

    public void visitOpen(String str, int i11, String... strArr) {
        String[] strArr2;
        if (strArr != null) {
            strArr2 = new String[strArr.length];
            for (int i12 = 0; i12 < strArr.length; i12++) {
                strArr2[i12] = this.f27422c.mapModuleName(strArr[i12]);
            }
        } else {
            strArr2 = null;
        }
        super.visitOpen(this.f27422c.mapPackageName(str), i11, strArr2);
    }

    public void visitPackage(String str) {
        super.visitPackage(this.f27422c.mapPackageName(str));
    }

    public void visitProvide(String str, String... strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            strArr2[i11] = this.f27422c.mapType(strArr[i11]);
        }
        super.visitProvide(this.f27422c.mapType(str), strArr2);
    }

    public void visitRequire(String str, int i11, String str2) {
        super.visitRequire(this.f27422c.mapModuleName(str), i11, str2);
    }

    public void visitUse(String str) {
        super.visitUse(this.f27422c.mapType(str));
    }

    public ModuleRemapper(int i11, ModuleVisitor moduleVisitor, Remapper remapper) {
        super(i11, moduleVisitor);
        this.f27422c = remapper;
    }
}
