package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Modifier;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;
import org.jetbrains.annotations.NotNull;

public interface ReflectJavaModifierListOwner extends JavaModifierListOwner {

    public static final class DefaultImpls {
        @NotNull
        public static Visibility getVisibility(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            int modifiers = reflectJavaModifierListOwner.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                return Visibilities.Public.INSTANCE;
            }
            if (Modifier.isPrivate(modifiers)) {
                return Visibilities.Private.INSTANCE;
            }
            if (!Modifier.isProtected(modifiers)) {
                return JavaVisibilities.PackageVisibility.INSTANCE;
            }
            if (Modifier.isStatic(modifiers)) {
                return JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
            }
            return JavaVisibilities.ProtectedAndPackage.INSTANCE;
        }

        public static boolean isAbstract(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isAbstract(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isFinal(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isFinal(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isStatic(@NotNull ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isStatic(reflectJavaModifierListOwner.getModifiers());
        }
    }

    int getModifiers();
}
