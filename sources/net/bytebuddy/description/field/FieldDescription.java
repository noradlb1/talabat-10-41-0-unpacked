package net.bytebuddy.description.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeVariableToken;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.jar.asm.signature.SignatureWriter;
import net.bytebuddy.matcher.ElementMatcher;

public interface FieldDescription extends ByteCodeElement, ModifierReviewable.ForFieldDescription, NamedElement.WithGenericName, ByteCodeElement.TypeDependant<InDefinedShape, Token> {
    public static final Object NO_DEFAULT_VALUE = null;

    public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements FieldDescription {
        private transient /* synthetic */ int hashCode;

        public SignatureToken asSignatureToken() {
            return new SignatureToken(getInternalName(), getType().asErasure());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FieldDescription)) {
                return false;
            }
            FieldDescription fieldDescription = (FieldDescription) obj;
            if (!getName().equals(fieldDescription.getName()) || !getDeclaringType().equals(fieldDescription.getDeclaringType())) {
                return false;
            }
            return true;
        }

        public int getActualModifiers() {
            return getModifiers() | (getDeclaredAnnotations().isAnnotationPresent((Class<? extends Annotation>) Deprecated.class) ? 131072 : 0);
        }

        public String getActualName() {
            return getName();
        }

        public String getDescriptor() {
            return getType().asErasure().getDescriptor();
        }

        public String getGenericSignature() {
            TypeDescription.Generic type = getType();
            try {
                if (type.getSort().isNonGeneric()) {
                    return NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE;
                }
                return ((SignatureVisitor) type.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(new SignatureWriter()))).toString();
            } catch (GenericSignatureFormatError unused) {
                return NamedElement.WithDescriptor.NON_GENERIC_SIGNATURE;
            }
        }

        public String getInternalName() {
            return getName();
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode2 = this.hashCode != 0 ? 0 : getDeclaringType().hashCode() + ((getName().hashCode() + 17) * 31);
            if (hashCode2 == 0) {
                return this.hashCode;
            }
            this.hashCode = hashCode2;
            return hashCode2;
        }

        public boolean isAccessibleTo(TypeDescription typeDescription) {
            if (isPublic() || typeDescription.equals(getDeclaringType().asErasure()) || ((!isPrivate() && typeDescription.isSamePackage(getDeclaringType().asErasure())) || (isPrivate() && typeDescription.isNestMateOf(getDeclaringType().asErasure())))) {
                return true;
            }
            return false;
        }

        public boolean isVisibleTo(TypeDescription typeDescription) {
            if (!getDeclaringType().asErasure().isVisibleTo(typeDescription) || (!isPublic() && !typeDescription.equals(getDeclaringType().asErasure()) && ((!isProtected() || !getDeclaringType().asErasure().isAssignableFrom(typeDescription)) && ((isPrivate() || !typeDescription.isSamePackage(getDeclaringType().asErasure())) && (!isPrivate() || !typeDescription.isNestMateOf(getDeclaringType().asErasure())))))) {
                return false;
            }
            return true;
        }

        public String toGenericString() {
            StringBuilder sb2 = new StringBuilder();
            if (getModifiers() != 0) {
                sb2.append(Modifier.toString(getModifiers()));
                sb2.append(' ');
            }
            sb2.append(getType().getActualName());
            sb2.append(' ');
            sb2.append(getDeclaringType().asErasure().getActualName());
            sb2.append('.');
            sb2.append(getName());
            return sb2.toString();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            if (getModifiers() != 0) {
                sb2.append(Modifier.toString(getModifiers()));
                sb2.append(' ');
            }
            sb2.append(getType().asErasure().getActualName());
            sb2.append(' ');
            sb2.append(getDeclaringType().asErasure().getActualName());
            sb2.append('.');
            sb2.append(getName());
            return sb2.toString();
        }

        public Token asToken(ElementMatcher<? super TypeDescription> elementMatcher) {
            return new Token(getName(), getModifiers(), (TypeDescription.Generic) getType().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(elementMatcher)), getDeclaredAnnotations());
        }
    }

    public static class ForLoadedField extends InDefinedShape.AbstractBase {
        private transient /* synthetic */ AnnotationList declaredAnnotations;
        private final Field field;

        public ForLoadedField(Field field2) {
            this.field = field2;
        }

        @CachedReturnPlugin.Enhance("declaredAnnotations")
        public AnnotationList getDeclaredAnnotations() {
            AnnotationList.ForLoadedAnnotations forLoadedAnnotations = this.declaredAnnotations != null ? null : new AnnotationList.ForLoadedAnnotations(this.field.getDeclaredAnnotations());
            if (forLoadedAnnotations == null) {
                return this.declaredAnnotations;
            }
            this.declaredAnnotations = forLoadedAnnotations;
            return forLoadedAnnotations;
        }

        public int getModifiers() {
            return this.field.getModifiers();
        }

        public String getName() {
            return this.field.getName();
        }

        public TypeDescription.Generic getType() {
            if (TypeDescription.AbstractBase.RAW_TYPES) {
                return TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.field.getType());
            }
            return new TypeDescription.Generic.LazyProjection.ForLoadedFieldType(this.field);
        }

        public boolean isSynthetic() {
            return this.field.isSynthetic();
        }

        public TypeDescription getDeclaringType() {
            return TypeDescription.ForLoadedType.of(this.field.getDeclaringClass());
        }
    }

    public interface InDefinedShape extends FieldDescription {

        public static abstract class AbstractBase extends AbstractBase implements InDefinedShape {
            public InDefinedShape asDefined() {
                return this;
            }
        }

        TypeDescription getDeclaringType();
    }

    public interface InGenericShape extends FieldDescription {
        TypeDescription.Generic getDeclaringType();
    }

    public static class Latent extends InDefinedShape.AbstractBase {
        private final List<? extends AnnotationDescription> declaredAnnotations;
        private final TypeDescription declaringType;
        private final TypeDescription.Generic fieldType;
        private final int modifiers;

        /* renamed from: name  reason: collision with root package name */
        private final String f27097name;

        public Latent(TypeDescription typeDescription, Token token) {
            this(typeDescription, token.getName(), token.getModifiers(), token.getType(), token.getAnnotations());
        }

        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.declaredAnnotations);
        }

        public int getModifiers() {
            return this.modifiers;
        }

        public String getName() {
            return this.f27097name;
        }

        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.fieldType.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.of((FieldDescription) this));
        }

        public TypeDescription getDeclaringType() {
            return this.declaringType;
        }

        public Latent(TypeDescription typeDescription, String str, int i11, TypeDescription.Generic generic, List<? extends AnnotationDescription> list) {
            this.declaringType = typeDescription;
            this.f27097name = str;
            this.modifiers = i11;
            this.fieldType = generic;
            this.declaredAnnotations = list;
        }
    }

    public static class SignatureToken {
        private transient /* synthetic */ int hashCode;

        /* renamed from: name  reason: collision with root package name */
        private final String f27098name;
        private final TypeDescription type;

        public SignatureToken(String str, TypeDescription typeDescription) {
            this.f27098name = str;
            this.type = typeDescription;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SignatureToken)) {
                return false;
            }
            SignatureToken signatureToken = (SignatureToken) obj;
            if (!this.f27098name.equals(signatureToken.f27098name) || !this.type.equals(signatureToken.type)) {
                return false;
            }
            return true;
        }

        public String getName() {
            return this.f27098name;
        }

        public TypeDescription getType() {
            return this.type;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i11;
            if (this.hashCode != 0) {
                i11 = 0;
            } else {
                i11 = (this.f27098name.hashCode() * 31) + this.type.hashCode();
            }
            if (i11 == 0) {
                return this.hashCode;
            }
            this.hashCode = i11;
            return i11;
        }

        public String toString() {
            return this.type + " " + this.f27098name;
        }
    }

    public static class Token implements ByteCodeElement.Token<Token> {
        private final List<? extends AnnotationDescription> annotations;
        private transient /* synthetic */ int hashCode;
        private final int modifiers;

        /* renamed from: name  reason: collision with root package name */
        private final String f27099name;
        private final TypeDescription.Generic type;

        public Token(String str, int i11, TypeDescription.Generic generic) {
            this(str, i11, generic, Collections.emptyList());
        }

        public SignatureToken asSignatureToken(TypeDescription typeDescription) {
            return new SignatureToken(this.f27099name, (TypeDescription) this.type.accept(new TypeDescription.Generic.Visitor.Reducing(typeDescription, new TypeVariableToken[0])));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Token token = (Token) obj;
            if (this.modifiers != token.modifiers || !this.f27099name.equals(token.f27099name) || !this.type.equals(token.type) || !this.annotations.equals(token.annotations)) {
                return false;
            }
            return true;
        }

        public AnnotationList getAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        public int getModifiers() {
            return this.modifiers;
        }

        public String getName() {
            return this.f27099name;
        }

        public TypeDescription.Generic getType() {
            return this.type;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i11;
            if (this.hashCode != 0) {
                i11 = 0;
            } else {
                i11 = (((((this.f27099name.hashCode() * 31) + this.modifiers) * 31) + this.type.hashCode()) * 31) + this.annotations.hashCode();
            }
            if (i11 == 0) {
                return this.hashCode;
            }
            this.hashCode = i11;
            return i11;
        }

        public Token(String str, int i11, TypeDescription.Generic generic, List<? extends AnnotationDescription> list) {
            this.f27099name = str;
            this.modifiers = i11;
            this.type = generic;
            this.annotations = list;
        }

        public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            return new Token(this.f27099name, this.modifiers, (TypeDescription.Generic) this.type.accept(visitor), this.annotations);
        }
    }

    public static class TypeSubstituting extends AbstractBase implements InGenericShape {
        private final TypeDescription.Generic declaringType;
        private final FieldDescription fieldDescription;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(TypeDescription.Generic generic, FieldDescription fieldDescription2, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor2) {
            this.declaringType = generic;
            this.fieldDescription = fieldDescription2;
            this.visitor = visitor2;
        }

        public AnnotationList getDeclaredAnnotations() {
            return this.fieldDescription.getDeclaredAnnotations();
        }

        public int getModifiers() {
            return this.fieldDescription.getModifiers();
        }

        public String getName() {
            return this.fieldDescription.getName();
        }

        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.fieldDescription.getType().accept(this.visitor);
        }

        public InDefinedShape asDefined() {
            return (InDefinedShape) this.fieldDescription.asDefined();
        }

        public TypeDescription.Generic getDeclaringType() {
            return this.declaringType;
        }
    }

    SignatureToken asSignatureToken();

    int getActualModifiers();

    TypeDescription.Generic getType();
}
