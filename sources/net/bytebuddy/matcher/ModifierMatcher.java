package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
public class ModifierMatcher<T extends ModifierReviewable> extends ElementMatcher.Junction.AbstractBase<T> {
    private final Mode mode;

    public enum Mode {
        PUBLIC(1, "isPublic()"),
        PROTECTED(4, "isProtected()"),
        PRIVATE(2, "isPrivate()"),
        FINAL(16, "isFinal()"),
        STATIC(8, "isStatic()"),
        SYNCHRONIZED(32, "isSynchronized()"),
        NATIVE(256, "isNative()"),
        STRICT(2048, "isStrict()"),
        VAR_ARGS(128, "isVarArgs()"),
        SYNTHETIC(4096, "isSynthetic()"),
        BRIDGE(64, "isBridge()"),
        ABSTRACT(1024, "isAbstract()"),
        INTERFACE(512, "isInterface()"),
        ANNOTATION(8192, "isAnnotation()"),
        VOLATILE(64, "isVolatile()"),
        TRANSIENT(128, "isTransient()"),
        MANDATED(32768, "isMandated()"),
        ENUMERATION(16384, "isEnum()");
        
        private final String description;
        private final ModifierMatcher<?> matcher;
        private final int modifiers;

        private Mode(int i11, String str) {
            this.modifiers = i11;
            this.description = str;
            this.matcher = new ModifierMatcher<>(this);
        }

        public String a() {
            return this.description;
        }

        public ModifierMatcher<?> b() {
            return this.matcher;
        }

        public int c() {
            return this.modifiers;
        }
    }

    public ModifierMatcher(Mode mode2) {
        this.mode = mode2;
    }

    public static <T extends ModifierReviewable> ElementMatcher.Junction<T> of(Mode mode2) {
        return mode2.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mode.equals(((ModifierMatcher) obj).mode);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.mode.hashCode();
    }

    public String toString() {
        return this.mode.a();
    }

    public boolean matches(T t11) {
        return (t11.getModifiers() & this.mode.c()) != 0;
    }
}
