package net.bytebuddy.dynamic.loading;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

public interface ClassFilePostProcessor {

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForClassFileTransformer implements ClassFilePostProcessor {
        private static final Class<?> UNLOADED_TYPE = null;
        private final ClassFileTransformer classFileTransformer;

        public ForClassFileTransformer(ClassFileTransformer classFileTransformer2) {
            this.classFileTransformer = classFileTransformer2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFileTransformer.equals(((ForClassFileTransformer) obj).classFileTransformer);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.classFileTransformer.hashCode();
        }

        public byte[] transform(ClassLoader classLoader, String str, ProtectionDomain protectionDomain, byte[] bArr) {
            try {
                byte[] transform = this.classFileTransformer.transform(classLoader, str.replace('.', '/'), UNLOADED_TYPE, protectionDomain, bArr);
                if (transform == null) {
                    return bArr;
                }
                return transform;
            } catch (IllegalClassFormatException e11) {
                throw new IllegalStateException("Failed to transform " + str, e11);
            }
        }
    }

    public enum NoOp implements ClassFilePostProcessor {
        INSTANCE;

        public byte[] transform(ClassLoader classLoader, String str, ProtectionDomain protectionDomain, byte[] bArr) {
            return bArr;
        }
    }

    byte[] transform(ClassLoader classLoader, String str, ProtectionDomain protectionDomain, byte[] bArr);
}
