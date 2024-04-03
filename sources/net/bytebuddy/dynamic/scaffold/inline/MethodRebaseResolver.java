package net.bytebuddy.dynamic.scaffold.inline;

import androidx.core.view.InputDeviceCompat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodAccessorFactory;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import net.bytebuddy.implementation.auxiliary.TrivialType;
import net.bytebuddy.utility.CompoundList;

public interface MethodRebaseResolver {

    @HashCodeAndEqualsPlugin.Enhance
    public static class Default implements MethodRebaseResolver {
        private final List<DynamicType> dynamicTypes;
        private final Map<MethodDescription.InDefinedShape, Resolution> resolutions;

        public Default(Map<MethodDescription.InDefinedShape, Resolution> map, List<DynamicType> list) {
            this.resolutions = map;
            this.dynamicTypes = list;
        }

        public static MethodRebaseResolver make(TypeDescription typeDescription, Set<? extends MethodDescription.SignatureToken> set, ClassFileVersion classFileVersion, AuxiliaryType.NamingStrategy namingStrategy, MethodNameTransformer methodNameTransformer) {
            Resolution resolution;
            HashMap hashMap = new HashMap();
            DynamicType dynamicType = null;
            for (MethodDescription.InDefinedShape inDefinedShape : typeDescription.getDeclaredMethods()) {
                if (set.contains(inDefinedShape.asSignatureToken())) {
                    if (inDefinedShape.isConstructor()) {
                        if (dynamicType == null) {
                            dynamicType = TrivialType.SIGNATURE_RELEVANT.make(namingStrategy.name(typeDescription), classFileVersion, MethodAccessorFactory.Illegal.INSTANCE);
                        }
                        resolution = Resolution.ForRebasedConstructor.of(inDefinedShape, dynamicType.getTypeDescription());
                    } else {
                        resolution = Resolution.ForRebasedMethod.of(typeDescription, inDefinedShape, methodNameTransformer);
                    }
                    hashMap.put(inDefinedShape, resolution);
                }
            }
            if (dynamicType == null) {
                return new Default(hashMap, Collections.emptyList());
            }
            return new Default(hashMap, Collections.singletonList(dynamicType));
        }

        public Map<MethodDescription.SignatureToken, Resolution> asTokenMap() {
            HashMap hashMap = new HashMap();
            for (Map.Entry next : this.resolutions.entrySet()) {
                hashMap.put(((MethodDescription.InDefinedShape) next.getKey()).asSignatureToken(), next.getValue());
            }
            return hashMap;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default defaultR = (Default) obj;
            return this.resolutions.equals(defaultR.resolutions) && this.dynamicTypes.equals(defaultR.dynamicTypes);
        }

        public List<DynamicType> getAuxiliaryTypes() {
            return this.dynamicTypes;
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.resolutions.hashCode()) * 31) + this.dynamicTypes.hashCode();
        }

        public Resolution resolve(MethodDescription.InDefinedShape inDefinedShape) {
            Resolution resolution = this.resolutions.get(inDefinedShape);
            if (resolution == null) {
                return new Resolution.Preserved(inDefinedShape);
            }
            return resolution;
        }
    }

    public enum Disabled implements MethodRebaseResolver {
        INSTANCE;

        public Map<MethodDescription.SignatureToken, Resolution> asTokenMap() {
            return Collections.emptyMap();
        }

        public List<DynamicType> getAuxiliaryTypes() {
            return Collections.emptyList();
        }

        public Resolution resolve(MethodDescription.InDefinedShape inDefinedShape) {
            return new Resolution.Preserved(inDefinedShape);
        }
    }

    public interface Resolution {

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForRebasedConstructor implements Resolution {
            private final MethodDescription.InDefinedShape methodDescription;
            private final TypeDescription placeholderType;

            public static class RebasedConstructor extends MethodDescription.InDefinedShape.AbstractBase {
                private final MethodDescription.InDefinedShape methodDescription;
                private final TypeDescription placeholderType;

                public RebasedConstructor(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
                    this.methodDescription = inDefinedShape;
                    this.placeholderType = typeDescription;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public AnnotationValue<?, ?> getDefaultValue() {
                    return AnnotationValue.UNDEFINED;
                }

                public TypeList.Generic getExceptionTypes() {
                    return this.methodDescription.getExceptionTypes().asRawTypes();
                }

                public String getInternalName() {
                    return MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                }

                public int getModifiers() {
                    return InputDeviceCompat.SOURCE_TOUCHSCREEN;
                }

                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) CompoundList.of(this.methodDescription.getParameters().asTypeList().asErasures(), this.placeholderType));
                }

                public TypeDescription.Generic getReturnType() {
                    return TypeDescription.Generic.VOID;
                }

                public TypeList.Generic getTypeVariables() {
                    return new TypeList.Generic.Empty();
                }

                public TypeDescription getDeclaringType() {
                    return this.methodDescription.getDeclaringType();
                }
            }

            public ForRebasedConstructor(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
                this.methodDescription = inDefinedShape;
                this.placeholderType = typeDescription;
            }

            public static Resolution of(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
                return new ForRebasedConstructor(new RebasedConstructor(inDefinedShape, typeDescription), typeDescription);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForRebasedConstructor forRebasedConstructor = (ForRebasedConstructor) obj;
                return this.methodDescription.equals(forRebasedConstructor.methodDescription) && this.placeholderType.equals(forRebasedConstructor.placeholderType);
            }

            public TypeList getPrependedParameters() {
                return new TypeList.Explicit(this.placeholderType);
            }

            public MethodDescription.InDefinedShape getResolvedMethod() {
                return this.methodDescription;
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.methodDescription.hashCode()) * 31) + this.placeholderType.hashCode();
            }

            public boolean isRebased() {
                return true;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class ForRebasedMethod implements Resolution {
            private final MethodDescription.InDefinedShape methodDescription;

            public static class RebasedMethod extends MethodDescription.InDefinedShape.AbstractBase {
                private final TypeDescription instrumentedType;
                private final MethodDescription.InDefinedShape methodDescription;
                private final MethodNameTransformer methodNameTransformer;

                public RebasedMethod(TypeDescription typeDescription, MethodDescription.InDefinedShape inDefinedShape, MethodNameTransformer methodNameTransformer2) {
                    this.instrumentedType = typeDescription;
                    this.methodDescription = inDefinedShape;
                    this.methodNameTransformer = methodNameTransformer2;
                }

                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }

                public AnnotationValue<?, ?> getDefaultValue() {
                    return AnnotationValue.UNDEFINED;
                }

                public TypeList.Generic getExceptionTypes() {
                    return this.methodDescription.getExceptionTypes().asRawTypes();
                }

                public String getInternalName() {
                    return this.methodNameTransformer.transform(this.methodDescription);
                }

                public int getModifiers() {
                    int i11;
                    int i12;
                    int i13 = 0;
                    if (this.methodDescription.isStatic()) {
                        i11 = 8;
                    } else {
                        i11 = 0;
                    }
                    int i14 = i11 | 4096;
                    if (this.methodDescription.isNative()) {
                        i13 = 272;
                    }
                    int i15 = i14 | i13;
                    if (!this.instrumentedType.isInterface() || this.methodDescription.isNative()) {
                        i12 = 2;
                    } else {
                        i12 = 1;
                    }
                    return i15 | i12;
                }

                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new ParameterList.Explicit.ForTypes((MethodDescription.InDefinedShape) this, (List<? extends TypeDefinition>) this.methodDescription.getParameters().asTypeList().asRawTypes());
                }

                public TypeDescription.Generic getReturnType() {
                    return this.methodDescription.getReturnType().asRawType();
                }

                public TypeList.Generic getTypeVariables() {
                    return new TypeList.Generic.Empty();
                }

                public TypeDescription getDeclaringType() {
                    return this.methodDescription.getDeclaringType();
                }
            }

            public ForRebasedMethod(MethodDescription.InDefinedShape inDefinedShape) {
                this.methodDescription = inDefinedShape;
            }

            public static Resolution of(TypeDescription typeDescription, MethodDescription.InDefinedShape inDefinedShape, MethodNameTransformer methodNameTransformer) {
                return new ForRebasedMethod(new RebasedMethod(typeDescription, inDefinedShape, methodNameTransformer));
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((ForRebasedMethod) obj).methodDescription);
            }

            public TypeList getPrependedParameters() {
                return new TypeList.Empty();
            }

            public MethodDescription.InDefinedShape getResolvedMethod() {
                return this.methodDescription;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
            }

            public boolean isRebased() {
                return true;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Preserved implements Resolution {
            private final MethodDescription.InDefinedShape methodDescription;

            public Preserved(MethodDescription.InDefinedShape inDefinedShape) {
                this.methodDescription = inDefinedShape;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((Preserved) obj).methodDescription);
            }

            public TypeList getPrependedParameters() {
                throw new IllegalStateException("Cannot process additional parameters for non-rebased method: " + this.methodDescription);
            }

            public MethodDescription.InDefinedShape getResolvedMethod() {
                return this.methodDescription;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.methodDescription.hashCode();
            }

            public boolean isRebased() {
                return false;
            }
        }

        TypeList getPrependedParameters();

        MethodDescription.InDefinedShape getResolvedMethod();

        boolean isRebased();
    }

    Map<MethodDescription.SignatureToken, Resolution> asTokenMap();

    List<DynamicType> getAuxiliaryTypes();

    Resolution resolve(MethodDescription.InDefinedShape inDefinedShape);
}
