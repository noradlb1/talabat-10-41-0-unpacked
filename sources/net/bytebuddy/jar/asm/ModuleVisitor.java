package net.bytebuddy.jar.asm;

public abstract class ModuleVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final int f27402a;

    /* renamed from: b  reason: collision with root package name */
    public ModuleVisitor f27403b;

    public ModuleVisitor(int i11) {
        this(i11, (ModuleVisitor) null);
    }

    public void visitEnd() {
        ModuleVisitor moduleVisitor = this.f27403b;
        if (moduleVisitor != null) {
            moduleVisitor.visitEnd();
        }
    }

    public void visitExport(String str, int i11, String... strArr) {
        ModuleVisitor moduleVisitor = this.f27403b;
        if (moduleVisitor != null) {
            moduleVisitor.visitExport(str, i11, strArr);
        }
    }

    public void visitMainClass(String str) {
        ModuleVisitor moduleVisitor = this.f27403b;
        if (moduleVisitor != null) {
            moduleVisitor.visitMainClass(str);
        }
    }

    public void visitOpen(String str, int i11, String... strArr) {
        ModuleVisitor moduleVisitor = this.f27403b;
        if (moduleVisitor != null) {
            moduleVisitor.visitOpen(str, i11, strArr);
        }
    }

    public void visitPackage(String str) {
        ModuleVisitor moduleVisitor = this.f27403b;
        if (moduleVisitor != null) {
            moduleVisitor.visitPackage(str);
        }
    }

    public void visitProvide(String str, String... strArr) {
        ModuleVisitor moduleVisitor = this.f27403b;
        if (moduleVisitor != null) {
            moduleVisitor.visitProvide(str, strArr);
        }
    }

    public void visitRequire(String str, int i11, String str2) {
        ModuleVisitor moduleVisitor = this.f27403b;
        if (moduleVisitor != null) {
            moduleVisitor.visitRequire(str, i11, str2);
        }
    }

    public void visitUse(String str) {
        ModuleVisitor moduleVisitor = this.f27403b;
        if (moduleVisitor != null) {
            moduleVisitor.visitUse(str);
        }
    }

    public ModuleVisitor(int i11, ModuleVisitor moduleVisitor) {
        if (i11 == 589824 || i11 == 524288 || i11 == 458752 || i11 == 393216 || i11 == 327680 || i11 == 262144 || i11 == 17432576) {
            if (i11 == 17432576) {
                Constants.a(this);
            }
            this.f27402a = i11;
            this.f27403b = moduleVisitor;
            return;
        }
        throw new IllegalArgumentException("Unsupported api " + i11);
    }
}
