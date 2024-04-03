package net.bytebuddy.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatchers;

public interface Transformer<T> {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Compound<S> implements Transformer<S> {
        private final List<Transformer<S>> transformers;

        public Compound(Transformer<S>... transformerArr) {
            this(Arrays.asList(transformerArr));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.transformers.equals(((Compound) obj).transformers);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.transformers.hashCode();
        }

        public S transform(TypeDescription typeDescription, S s11) {
            for (Transformer<S> transform : this.transformers) {
                s11 = transform.transform(typeDescription, s11);
            }
            return s11;
        }

        public Compound(List<? extends Transformer<S>> list) {
            this.transformers = new ArrayList();
            for (Transformer transformer : list) {
                if (transformer instanceof Compound) {
                    this.transformers.addAll(((Compound) transformer).transformers);
                } else if (!(transformer instanceof NoOp)) {
                    this.transformers.add(transformer);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForField implements Transformer<FieldDescription> {
        private final Transformer<FieldDescription.Token> transformer;

        @HashCodeAndEqualsPlugin.Enhance
        public static class FieldModifierTransformer implements Transformer<FieldDescription.Token> {
            private final ModifierContributor.Resolver<ModifierContributor.ForField> resolver;

            public FieldModifierTransformer(ModifierContributor.Resolver<ModifierContributor.ForField> resolver2) {
                this.resolver = resolver2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.resolver.equals(((FieldModifierTransformer) obj).resolver);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.resolver.hashCode();
            }

            public FieldDescription.Token transform(TypeDescription typeDescription, FieldDescription.Token token) {
                return new FieldDescription.Token(token.getName(), this.resolver.resolve(token.getModifiers()), token.getType(), token.getAnnotations());
            }
        }

        public static class TransformedField extends FieldDescription.AbstractBase {
            private final TypeDefinition declaringType;
            private final FieldDescription.InDefinedShape fieldDescription;
            private final TypeDescription instrumentedType;
            private final FieldDescription.Token token;

            public TransformedField(TypeDescription typeDescription, TypeDefinition typeDefinition, FieldDescription.Token token2, FieldDescription.InDefinedShape inDefinedShape) {
                this.instrumentedType = typeDescription;
                this.declaringType = typeDefinition;
                this.token = token2;
                this.fieldDescription = inDefinedShape;
            }

            public AnnotationList getDeclaredAnnotations() {
                return this.token.getAnnotations();
            }

            public TypeDefinition getDeclaringType() {
                return this.declaringType;
            }

            public int getModifiers() {
                return this.token.getModifiers();
            }

            public String getName() {
                return this.token.getName();
            }

            public TypeDescription.Generic getType() {
                return (TypeDescription.Generic) this.token.getType().accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of(this.instrumentedType));
            }

            public FieldDescription.InDefinedShape asDefined() {
                return this.fieldDescription;
            }
        }

        public ForField(Transformer<FieldDescription.Token> transformer2) {
            this.transformer = transformer2;
        }

        public static Transformer<FieldDescription> withModifiers(ModifierContributor.ForField... forFieldArr) {
            return withModifiers((List<? extends ModifierContributor.ForField>) Arrays.asList(forFieldArr));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.transformer.equals(((ForField) obj).transformer);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.transformer.hashCode();
        }

        public static Transformer<FieldDescription> withModifiers(List<? extends ModifierContributor.ForField> list) {
            return new ForField(new FieldModifierTransformer(ModifierContributor.Resolver.of(list)));
        }

        public FieldDescription transform(TypeDescription typeDescription, FieldDescription fieldDescription) {
            return new TransformedField(typeDescription, fieldDescription.getDeclaringType(), this.transformer.transform(typeDescription, fieldDescription.asToken(ElementMatchers.none())), (FieldDescription.InDefinedShape) fieldDescription.asDefined());
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForMethod implements Transformer<MethodDescription> {
        private final Transformer<MethodDescription.Token> transformer;

        @HashCodeAndEqualsPlugin.Enhance
        public static class MethodModifierTransformer implements Transformer<MethodDescription.Token> {
            private final ModifierContributor.Resolver<ModifierContributor.ForMethod> resolver;

            public MethodModifierTransformer(ModifierContributor.Resolver<ModifierContributor.ForMethod> resolver2) {
                this.resolver = resolver2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.resolver.equals(((MethodModifierTransformer) obj).resolver);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.resolver.hashCode();
            }

            public MethodDescription.Token transform(TypeDescription typeDescription, MethodDescription.Token token) {
                return new MethodDescription.Token(token.getName(), this.resolver.resolve(token.getModifiers()), token.getTypeVariableTokens(), token.getReturnType(), token.getParameterTokens(), token.getExceptionTypes(), token.getAnnotations(), token.getDefaultValue(), token.getReceiverType());
            }
        }

        public static class TransformedMethod extends MethodDescription.AbstractBase {
            private final TypeDefinition declaringType;
            /* access modifiers changed from: private */
            public final TypeDescription instrumentedType;
            /* access modifiers changed from: private */
            public final MethodDescription.InDefinedShape methodDescription;
            /* access modifiers changed from: private */
            public final MethodDescription.Token token;

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class AttachmentVisitor extends TypeDescription.Generic.Visitor.Substitutor.WithoutTypeSubstitution {
                public AttachmentVisitor() {
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && TransformedMethod.this.equals(TransformedMethod.this);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + TransformedMethod.this.hashCode();
                }

                public TypeDescription.Generic onTypeVariable(TypeDescription.Generic generic) {
                    TypeDescription.Generic generic2;
                    TypeList.Generic generic3 = (TypeList.Generic) TransformedMethod.this.getTypeVariables().filter(ElementMatchers.named(generic.getSymbol()));
                    if (generic3.isEmpty()) {
                        generic2 = TransformedMethod.this.instrumentedType.findVariable(generic.getSymbol());
                    } else {
                        generic2 = (TypeDescription.Generic) generic3.getOnly();
                    }
                    if (generic2 != null) {
                        return new TypeDescription.Generic.OfTypeVariable.WithAnnotationOverlay(generic2, generic);
                    }
                    throw new IllegalArgumentException("Cannot attach undefined variable: " + generic);
                }
            }

            public class TransformedParameter extends ParameterDescription.AbstractBase {
                private final int index;
                private final ParameterDescription.Token parameterToken;

                public TransformedParameter(int i11, ParameterDescription.Token token) {
                    this.index = i11;
                    this.parameterToken = token;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return this.parameterToken.getAnnotations();
                }

                public MethodDescription getDeclaringMethod() {
                    return TransformedMethod.this;
                }

                public int getIndex() {
                    return this.index;
                }

                public int getModifiers() {
                    if (hasModifiers()) {
                        return this.parameterToken.getModifiers().intValue();
                    }
                    return super.getModifiers();
                }

                public String getName() {
                    if (isNamed()) {
                        return this.parameterToken.getName();
                    }
                    return super.getName();
                }

                public TypeDescription.Generic getType() {
                    return (TypeDescription.Generic) this.parameterToken.getType().accept(new AttachmentVisitor());
                }

                public boolean hasModifiers() {
                    return this.parameterToken.getModifiers() != null;
                }

                public boolean isNamed() {
                    return this.parameterToken.getName() != null;
                }

                public ParameterDescription.InDefinedShape asDefined() {
                    return (ParameterDescription.InDefinedShape) TransformedMethod.this.methodDescription.getParameters().get(this.index);
                }
            }

            public class TransformedParameterList extends ParameterList.AbstractBase<ParameterDescription> {
                public TransformedParameterList() {
                }

                public int size() {
                    return TransformedMethod.this.token.getParameterTokens().size();
                }

                public ParameterDescription get(int i11) {
                    TransformedMethod transformedMethod = TransformedMethod.this;
                    return new TransformedParameter(i11, (ParameterDescription.Token) transformedMethod.token.getParameterTokens().get(i11));
                }
            }

            public TransformedMethod(TypeDescription typeDescription, TypeDefinition typeDefinition, MethodDescription.Token token2, MethodDescription.InDefinedShape inDefinedShape) {
                this.instrumentedType = typeDescription;
                this.declaringType = typeDefinition;
                this.token = token2;
                this.methodDescription = inDefinedShape;
            }

            public AnnotationList getDeclaredAnnotations() {
                return this.token.getAnnotations();
            }

            public TypeDefinition getDeclaringType() {
                return this.declaringType;
            }

            public AnnotationValue<?, ?> getDefaultValue() {
                return this.token.getDefaultValue();
            }

            public TypeList.Generic getExceptionTypes() {
                return new TypeList.Generic.ForDetachedTypes(this.token.getExceptionTypes(), new AttachmentVisitor());
            }

            public String getInternalName() {
                return this.token.getName();
            }

            public int getModifiers() {
                return this.token.getModifiers();
            }

            public ParameterList<?> getParameters() {
                return new TransformedParameterList();
            }

            public TypeDescription.Generic getReceiverType() {
                TypeDescription.Generic receiverType = this.token.getReceiverType();
                if (receiverType == null) {
                    return TypeDescription.Generic.UNDEFINED;
                }
                return (TypeDescription.Generic) receiverType.accept(new AttachmentVisitor());
            }

            public TypeDescription.Generic getReturnType() {
                return (TypeDescription.Generic) this.token.getReturnType().accept(new AttachmentVisitor());
            }

            public TypeList.Generic getTypeVariables() {
                return new TypeList.Generic.ForDetachedTypes.OfTypeVariables(this, this.token.getTypeVariableTokens(), new AttachmentVisitor());
            }

            public MethodDescription.InDefinedShape asDefined() {
                return this.methodDescription;
            }
        }

        public ForMethod(Transformer<MethodDescription.Token> transformer2) {
            this.transformer = transformer2;
        }

        public static Transformer<MethodDescription> withModifiers(ModifierContributor.ForMethod... forMethodArr) {
            return withModifiers((List<? extends ModifierContributor.ForMethod>) Arrays.asList(forMethodArr));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.transformer.equals(((ForMethod) obj).transformer);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.transformer.hashCode();
        }

        public static Transformer<MethodDescription> withModifiers(List<? extends ModifierContributor.ForMethod> list) {
            return new ForMethod(new MethodModifierTransformer(ModifierContributor.Resolver.of(list)));
        }

        public MethodDescription transform(TypeDescription typeDescription, MethodDescription methodDescription) {
            return new TransformedMethod(typeDescription, methodDescription.getDeclaringType(), this.transformer.transform(typeDescription, methodDescription.asToken(ElementMatchers.none())), (MethodDescription.InDefinedShape) methodDescription.asDefined());
        }
    }

    public enum NoOp implements Transformer<Object> {
        INSTANCE;

        public static <T> Transformer<T> make() {
            return INSTANCE;
        }

        public Object transform(TypeDescription typeDescription, Object obj) {
            return obj;
        }
    }

    T transform(TypeDescription typeDescription, T t11);
}
