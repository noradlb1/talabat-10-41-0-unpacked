package net.bytebuddy.description.type;

import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;

public interface PackageDescription extends NamedElement.WithRuntimeName, AnnotationSource {
    public static final String PACKAGE_CLASS_NAME = "package-info";
    public static final int PACKAGE_MODIFIERS = 5632;
    public static final PackageDescription UNDEFINED = null;

    public static abstract class AbstractBase implements PackageDescription {
        public boolean contains(TypeDescription typeDescription) {
            return equals(typeDescription.getPackage());
        }

        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof PackageDescription) && getName().equals(((PackageDescription) obj).getName()));
        }

        public String getActualName() {
            return getName();
        }

        public String getInternalName() {
            return getName().replace('.', '/');
        }

        public int hashCode() {
            return getName().hashCode();
        }

        public String toString() {
            return "package " + getName();
        }
    }

    public static class ForLoadedPackage extends AbstractBase {
        private final Package aPackage;

        public ForLoadedPackage(Package packageR) {
            this.aPackage = packageR;
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.ForLoadedAnnotations(this.aPackage.getDeclaredAnnotations());
        }

        public String getName() {
            return this.aPackage.getName();
        }
    }

    public static class Simple extends AbstractBase {

        /* renamed from: name  reason: collision with root package name */
        private final String f27116name;

        public Simple(String str) {
            this.f27116name = str;
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Empty();
        }

        public String getName() {
            return this.f27116name;
        }
    }

    boolean contains(TypeDescription typeDescription);
}
