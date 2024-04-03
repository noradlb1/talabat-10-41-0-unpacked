package net.bytebuddy.description.method;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

public interface ParameterDescription extends AnnotationSource, NamedElement.WithRuntimeName, NamedElement.WithOptionalName, ModifierReviewable.ForParameterDescription, ByteCodeElement.TypeDependant<InDefinedShape, Token> {
    public static final String NAME_PREFIX = "arg";

    public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements ParameterDescription {
        private transient /* synthetic */ int hashCode;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ParameterDescription)) {
                return false;
            }
            ParameterDescription parameterDescription = (ParameterDescription) obj;
            if (!getDeclaringMethod().equals(parameterDescription.getDeclaringMethod()) || getIndex() != parameterDescription.getIndex()) {
                return false;
            }
            return true;
        }

        public String getActualName() {
            if (isNamed()) {
                return getName();
            }
            return "";
        }

        public String getInternalName() {
            return getName();
        }

        public int getModifiers() {
            return 0;
        }

        public String getName() {
            return ParameterDescription.NAME_PREFIX.concat(String.valueOf(getIndex()));
        }

        public int getOffset() {
            int i11;
            TypeList asErasures = getDeclaringMethod().getParameters().asTypeList().asErasures();
            if (getDeclaringMethod().isStatic()) {
                i11 = StackSize.ZERO.getSize();
            } else {
                i11 = StackSize.SINGLE.getSize();
            }
            for (int i12 = 0; i12 < getIndex(); i12++) {
                i11 += ((TypeDescription) asErasures.get(i12)).getStackSize().getSize();
            }
            return i11;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode2 = this.hashCode != 0 ? 0 : getDeclaringMethod().hashCode() ^ getIndex();
            if (hashCode2 == 0) {
                return this.hashCode;
            }
            this.hashCode = hashCode2;
            return hashCode2;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder(Modifier.toString(getModifiers()));
            if (getModifiers() != 0) {
                sb2.append(' ');
            }
            if (isVarArgs()) {
                str = getType().asErasure().getName().replaceFirst("\\[]$", "...");
            } else {
                str = getType().asErasure().getName();
            }
            sb2.append(str);
            sb2.append(' ');
            sb2.append(getName());
            return sb2.toString();
        }

        public Token asToken(ElementMatcher<? super TypeDescription> elementMatcher) {
            return new Token((TypeDescription.Generic) getType().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(elementMatcher)), getDeclaredAnnotations(), isNamed() ? getName() : Token.NO_NAME, hasModifiers() ? Integer.valueOf(getModifiers()) : Token.NO_MODIFIERS);
        }
    }

    public static abstract class ForLoadedParameter<T extends AccessibleObject> extends InDefinedShape.AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        private static final Parameter PARAMETER = ((Parameter) doPrivileged(JavaDispatcher.of(Parameter.class)));

        /* renamed from: b  reason: collision with root package name */
        public final T f27107b;

        /* renamed from: c  reason: collision with root package name */
        public final int f27108c;

        /* renamed from: d  reason: collision with root package name */
        public final ParameterAnnotationSource f27109d;

        public static class OfConstructor extends ForLoadedParameter<Constructor<?>> {
            public OfConstructor(Constructor<?> constructor, int i11, ParameterAnnotationSource parameterAnnotationSource) {
                super(constructor, i11, parameterAnnotationSource);
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs", value = {"BC_UNCONFIRMED_CAST"})
            public AnnotationList getDeclaredAnnotations() {
                Annotation[][] parameterAnnotations = this.f27109d.getParameterAnnotations();
                MethodDescription.InDefinedShape declaringMethod = getDeclaringMethod();
                if (parameterAnnotations.length == declaringMethod.getParameters().size() || !declaringMethod.getDeclaringType().isInnerClass()) {
                    return new AnnotationList.ForLoadedAnnotations(parameterAnnotations[this.f27108c]);
                }
                if (this.f27108c == 0) {
                    return new AnnotationList.Empty();
                }
                return new AnnotationList.ForLoadedAnnotations(parameterAnnotations[this.f27108c - 1]);
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs", value = {"BC_UNCONFIRMED_CAST"})
            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(((Constructor) this.f27107b).getParameterTypes()[this.f27108c]);
                }
                T t11 = this.f27107b;
                return new TypeDescription.Generic.LazyProjection.OfConstructorParameter((Constructor) t11, this.f27108c, ((Constructor) t11).getParameterTypes());
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs", value = {"BC_UNCONFIRMED_CAST"})
            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedConstructor((Constructor) this.f27107b);
            }
        }

        public static class OfLegacyVmConstructor extends InDefinedShape.AbstractBase {
            private final Constructor<?> constructor;
            private final int index;
            private final ParameterAnnotationSource parameterAnnotationSource;
            private final Class<?>[] parameterType;

            public OfLegacyVmConstructor(Constructor<?> constructor2, int i11, Class<?>[] clsArr, ParameterAnnotationSource parameterAnnotationSource2) {
                this.constructor = constructor2;
                this.index = i11;
                this.parameterType = clsArr;
                this.parameterAnnotationSource = parameterAnnotationSource2;
            }

            public AnnotationList getDeclaredAnnotations() {
                MethodDescription.InDefinedShape declaringMethod = getDeclaringMethod();
                Annotation[][] parameterAnnotations = this.parameterAnnotationSource.getParameterAnnotations();
                if (parameterAnnotations.length == declaringMethod.getParameters().size() || !declaringMethod.getDeclaringType().isInnerClass()) {
                    return new AnnotationList.ForLoadedAnnotations(parameterAnnotations[this.index]);
                }
                if (this.index == 0) {
                    return new AnnotationList.Empty();
                }
                return new AnnotationList.ForLoadedAnnotations(parameterAnnotations[this.index - 1]);
            }

            public int getIndex() {
                return this.index;
            }

            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.parameterType[this.index]);
                }
                return new TypeDescription.Generic.LazyProjection.OfConstructorParameter(this.constructor, this.index, this.parameterType);
            }

            public boolean hasModifiers() {
                return false;
            }

            public boolean isNamed() {
                return false;
            }

            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedConstructor(this.constructor);
            }
        }

        public static class OfLegacyVmMethod extends InDefinedShape.AbstractBase {
            private final int index;
            private final Method method;
            private final ParameterAnnotationSource parameterAnnotationSource;
            private final Class<?>[] parameterType;

            public OfLegacyVmMethod(Method method2, int i11, Class<?>[] clsArr, ParameterAnnotationSource parameterAnnotationSource2) {
                this.method = method2;
                this.index = i11;
                this.parameterType = clsArr;
                this.parameterAnnotationSource = parameterAnnotationSource2;
            }

            public AnnotationList getDeclaredAnnotations() {
                return new AnnotationList.ForLoadedAnnotations(this.parameterAnnotationSource.getParameterAnnotations()[this.index]);
            }

            public int getIndex() {
                return this.index;
            }

            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.parameterType[this.index]);
                }
                return new TypeDescription.Generic.LazyProjection.OfMethodParameter(this.method, this.index, this.parameterType);
            }

            public boolean hasModifiers() {
                return false;
            }

            public boolean isNamed() {
                return false;
            }

            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedMethod(this.method);
            }
        }

        public static class OfMethod extends ForLoadedParameter<Method> {
            public OfMethod(Method method, int i11, ParameterAnnotationSource parameterAnnotationSource) {
                super(method, i11, parameterAnnotationSource);
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs", value = {"BC_UNCONFIRMED_CAST"})
            public AnnotationList getDeclaredAnnotations() {
                return new AnnotationList.ForLoadedAnnotations(this.f27109d.getParameterAnnotations()[this.f27108c]);
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs", value = {"BC_UNCONFIRMED_CAST"})
            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(((Method) this.f27107b).getParameterTypes()[this.f27108c]);
                }
                T t11 = this.f27107b;
                return new TypeDescription.Generic.LazyProjection.OfMethodParameter((Method) t11, this.f27108c, ((Method) t11).getParameterTypes());
            }

            @SuppressFBWarnings(justification = "The implicit field type casting is not understood by Findbugs", value = {"BC_UNCONFIRMED_CAST"})
            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedMethod((Method) this.f27107b);
            }
        }

        @JavaDispatcher.Proxied("java.lang.reflect.Parameter")
        public interface Parameter {
            @JavaDispatcher.Proxied("getModifiers")
            int getModifiers(Object obj);

            @JavaDispatcher.Proxied("getName")
            String getName(Object obj);

            @JavaDispatcher.Proxied("isNamePresent")
            boolean isNamePresent(Object obj);
        }

        public interface ParameterAnnotationSource {

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForLoadedConstructor implements ParameterAnnotationSource {
                private final Constructor<?> constructor;

                public ForLoadedConstructor(Constructor<?> constructor2) {
                    this.constructor = constructor2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.constructor.equals(((ForLoadedConstructor) obj).constructor);
                }

                public Annotation[][] getParameterAnnotations() {
                    return this.constructor.getParameterAnnotations();
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.constructor.hashCode();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            public static class ForLoadedMethod implements ParameterAnnotationSource {
                private final Method method;

                public ForLoadedMethod(Method method2) {
                    this.method = method2;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.method.equals(((ForLoadedMethod) obj).method);
                }

                public Annotation[][] getParameterAnnotations() {
                    return this.method.getParameterAnnotations();
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.method.hashCode();
                }
            }

            Annotation[][] getParameterAnnotations();
        }

        static {
            boolean z11 = false;
            try {
                Class.forName("java.security.AccessController", false, (ClassLoader) null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
            } catch (SecurityException unused2) {
                z11 = true;
            }
            ACCESS_CONTROLLER = z11;
        }

        public ForLoadedParameter(T t11, int i11, ParameterAnnotationSource parameterAnnotationSource) {
            this.f27107b = t11;
            this.f27108c = i11;
            this.f27109d = parameterAnnotationSource;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        public int getIndex() {
            return this.f27108c;
        }

        public int getModifiers() {
            return PARAMETER.getModifiers(ParameterList.ForLoadedExecutable.f27112d.getParameters(this.f27107b)[this.f27108c]);
        }

        public String getName() {
            return PARAMETER.getName(ParameterList.ForLoadedExecutable.f27112d.getParameters(this.f27107b)[this.f27108c]);
        }

        public boolean hasModifiers() {
            return isNamed() || getModifiers() != 0;
        }

        public boolean isNamed() {
            return PARAMETER.isNamePresent(ParameterList.ForLoadedExecutable.f27112d.getParameters(this.f27107b)[this.f27108c]);
        }
    }

    public interface InDefinedShape extends ParameterDescription {

        public static abstract class AbstractBase extends AbstractBase implements InDefinedShape {
            public InDefinedShape asDefined() {
                return this;
            }
        }

        MethodDescription.InDefinedShape getDeclaringMethod();
    }

    public interface InGenericShape extends ParameterDescription {
        MethodDescription.InGenericShape getDeclaringMethod();
    }

    public static class Latent extends InDefinedShape.AbstractBase {
        private final List<? extends AnnotationDescription> declaredAnnotations;
        private final MethodDescription.InDefinedShape declaringMethod;
        private final int index;
        private final Integer modifiers;

        /* renamed from: name  reason: collision with root package name */
        private final String f27110name;
        private final int offset;
        private final TypeDescription.Generic parameterType;

        public Latent(MethodDescription.InDefinedShape inDefinedShape, Token token, int i11, int i12) {
            this(inDefinedShape, token.getType(), token.getAnnotations(), token.getName(), token.getModifiers(), i11, i12);
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.declaredAnnotations);
        }

        public int getIndex() {
            return this.index;
        }

        public int getModifiers() {
            if (hasModifiers()) {
                return this.modifiers.intValue();
            }
            return super.getModifiers();
        }

        public String getName() {
            if (isNamed()) {
                return this.f27110name;
            }
            return super.getName();
        }

        public int getOffset() {
            return this.offset;
        }

        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.parameterType.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of((ParameterDescription) this));
        }

        public boolean hasModifiers() {
            return this.modifiers != null;
        }

        public boolean isNamed() {
            return this.f27110name != null;
        }

        public MethodDescription.InDefinedShape getDeclaringMethod() {
            return this.declaringMethod;
        }

        public Latent(MethodDescription.InDefinedShape inDefinedShape, TypeDescription.Generic generic, int i11, int i12) {
            this(inDefinedShape, generic, Collections.emptyList(), Token.NO_NAME, Token.NO_MODIFIERS, i11, i12);
        }

        public Latent(MethodDescription.InDefinedShape inDefinedShape, TypeDescription.Generic generic, List<? extends AnnotationDescription> list, String str, Integer num, int i11, int i12) {
            this.declaringMethod = inDefinedShape;
            this.parameterType = generic;
            this.declaredAnnotations = list;
            this.f27110name = str;
            this.modifiers = num;
            this.index = i11;
            this.offset = i12;
        }
    }

    public static class Token implements ByteCodeElement.Token<Token> {
        public static final Integer NO_MODIFIERS = null;
        public static final String NO_NAME = null;
        private final List<? extends AnnotationDescription> annotations;
        private transient /* synthetic */ int hashCode;
        private final Integer modifiers;

        /* renamed from: name  reason: collision with root package name */
        private final String f27111name;
        private final TypeDescription.Generic type;

        public static class TypeList extends AbstractList<Token> {
            private final List<? extends TypeDefinition> typeDescriptions;

            public TypeList(List<? extends TypeDefinition> list) {
                this.typeDescriptions = list;
            }

            public int size() {
                return this.typeDescriptions.size();
            }

            public Token get(int i11) {
                return new Token(((TypeDefinition) this.typeDescriptions.get(i11)).asGenericType());
            }
        }

        public Token(TypeDescription.Generic generic) {
            this(generic, Collections.emptyList());
        }

        public boolean equals(Object obj) {
            String str;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.type.equals(token.type) && this.annotations.equals(token.annotations) && ((str = this.f27111name) == null ? token.f27111name == null : str.equals(token.f27111name))) {
                Integer num = this.modifiers;
                if (num != null) {
                    if (num.equals(token.modifiers)) {
                        return true;
                    }
                } else if (token.modifiers == null) {
                    return true;
                }
            }
            return false;
        }

        public AnnotationList getAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        public Integer getModifiers() {
            return this.modifiers;
        }

        public String getName() {
            return this.f27111name;
        }

        public TypeDescription.Generic getType() {
            return this.type;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i11;
            int i12 = 0;
            if (this.hashCode == 0) {
                int hashCode2 = ((this.type.hashCode() * 31) + this.annotations.hashCode()) * 31;
                String str = this.f27111name;
                if (str != null) {
                    i11 = str.hashCode();
                } else {
                    i11 = 0;
                }
                int i13 = (hashCode2 + i11) * 31;
                Integer num = this.modifiers;
                if (num != null) {
                    i12 = num.hashCode();
                }
                i12 += i13;
            }
            if (i12 == 0) {
                return this.hashCode;
            }
            this.hashCode = i12;
            return i12;
        }

        public String toString() {
            return "ParameterDescription.Token{type=" + this.type + ", annotations=" + this.annotations + ", name='" + this.f27111name + '\'' + ", modifiers=" + this.modifiers + AbstractJsonLexerKt.END_OBJ;
        }

        public Token(TypeDescription.Generic generic, List<? extends AnnotationDescription> list) {
            this(generic, list, NO_NAME, NO_MODIFIERS);
        }

        public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            return new Token((TypeDescription.Generic) this.type.accept(visitor), this.annotations, this.f27111name, this.modifiers);
        }

        public Token(TypeDescription.Generic generic, String str, Integer num) {
            this(generic, Collections.emptyList(), str, num);
        }

        public Token(TypeDescription.Generic generic, List<? extends AnnotationDescription> list, String str, Integer num) {
            this.type = generic;
            this.annotations = list;
            this.f27111name = str;
            this.modifiers = num;
        }
    }

    public static class TypeSubstituting extends AbstractBase implements InGenericShape {
        private final MethodDescription.InGenericShape declaringMethod;
        private final ParameterDescription parameterDescription;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(MethodDescription.InGenericShape inGenericShape, ParameterDescription parameterDescription2, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
            this.declaringMethod = inGenericShape;
            this.parameterDescription = parameterDescription2;
            this.visitor = visitor2;
        }

        public AnnotationList getDeclaredAnnotations() {
            return this.parameterDescription.getDeclaredAnnotations();
        }

        public int getIndex() {
            return this.parameterDescription.getIndex();
        }

        public int getModifiers() {
            return this.parameterDescription.getModifiers();
        }

        public String getName() {
            return this.parameterDescription.getName();
        }

        public int getOffset() {
            return this.parameterDescription.getOffset();
        }

        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.parameterDescription.getType().accept(this.visitor);
        }

        public boolean hasModifiers() {
            return this.parameterDescription.hasModifiers();
        }

        public boolean isNamed() {
            return this.parameterDescription.isNamed();
        }

        public InDefinedShape asDefined() {
            return (InDefinedShape) this.parameterDescription.asDefined();
        }

        public MethodDescription.InGenericShape getDeclaringMethod() {
            return this.declaringMethod;
        }
    }

    MethodDescription getDeclaringMethod();

    int getIndex();

    int getOffset();

    TypeDescription.Generic getType();

    boolean hasModifiers();
}
