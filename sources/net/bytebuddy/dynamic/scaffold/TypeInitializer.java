package net.bytebuddy.dynamic.scaffold;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;

public interface TypeInitializer extends ByteCodeAppender {

    public interface Drain {

        @HashCodeAndEqualsPlugin.Enhance
        public static class Default implements Drain {

            /* renamed from: b  reason: collision with root package name */
            public final TypeDescription f27203b;

            /* renamed from: c  reason: collision with root package name */
            public final TypeWriter.MethodPool f27204c;

            /* renamed from: d  reason: collision with root package name */
            public final AnnotationValueFilter.Factory f27205d;

            public Default(TypeDescription typeDescription, TypeWriter.MethodPool methodPool, AnnotationValueFilter.Factory factory) {
                this.f27203b = typeDescription;
                this.f27204c = methodPool;
                this.f27205d = factory;
            }

            public void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context context) {
                typeInitializer.wrap(this.f27204c.target(new MethodDescription.Latent.TypeInitializer(this.f27203b))).apply(classVisitor, context, this.f27205d);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Default defaultR = (Default) obj;
                return this.f27203b.equals(defaultR.f27203b) && this.f27204c.equals(defaultR.f27204c) && this.f27205d.equals(defaultR.f27205d);
            }

            public int hashCode() {
                return (((((getClass().hashCode() * 31) + this.f27203b.hashCode()) * 31) + this.f27204c.hashCode()) * 31) + this.f27205d.hashCode();
            }
        }

        void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context context);
    }

    public enum None implements TypeInitializer {
        INSTANCE;

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            return ByteCodeAppender.Size.ZERO;
        }

        public TypeInitializer expandWith(ByteCodeAppender byteCodeAppender) {
            return new Simple(byteCodeAppender);
        }

        public boolean isDefined() {
            return false;
        }

        public TypeWriter.MethodPool.Record wrap(TypeWriter.MethodPool.Record record) {
            return record;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple implements TypeInitializer {
        private final ByteCodeAppender byteCodeAppender;

        public Simple(ByteCodeAppender byteCodeAppender2) {
            this.byteCodeAppender = byteCodeAppender2;
        }

        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            return this.byteCodeAppender.apply(methodVisitor, context, methodDescription);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.byteCodeAppender.equals(((Simple) obj).byteCodeAppender);
        }

        public TypeInitializer expandWith(ByteCodeAppender byteCodeAppender2) {
            return new Simple(new ByteCodeAppender.Compound(this.byteCodeAppender, byteCodeAppender2));
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.byteCodeAppender.hashCode();
        }

        public boolean isDefined() {
            return true;
        }

        public TypeWriter.MethodPool.Record wrap(TypeWriter.MethodPool.Record record) {
            return record.prepend(this.byteCodeAppender);
        }
    }

    TypeInitializer expandWith(ByteCodeAppender byteCodeAppender);

    boolean isDefined();

    TypeWriter.MethodPool.Record wrap(TypeWriter.MethodPool.Record record);
}
