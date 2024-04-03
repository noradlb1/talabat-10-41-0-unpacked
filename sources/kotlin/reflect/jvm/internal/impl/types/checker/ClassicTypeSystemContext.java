package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeWithEnhancement;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RawTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContextKt;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, TypeSystemInferenceExtensionContext {

    public static final class DefaultImpls {
        public static boolean areEqualTypeConstructors(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "c1");
            Intrinsics.checkNotNullParameter(typeConstructorMarker2, "c2");
            if (!(typeConstructorMarker instanceof TypeConstructor)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
            } else if (typeConstructorMarker2 instanceof TypeConstructor) {
                return Intrinsics.areEqual((Object) typeConstructorMarker, (Object) typeConstructorMarker2);
            } else {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker2.getClass())).toString());
            }
        }

        public static int argumentsCount(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentListMarker asArgumentList(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            if (simpleTypeMarker instanceof SimpleType) {
                return (TypeArgumentListMarker) simpleTypeMarker;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static CapturedTypeMarker asCapturedType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            if (!(simpleTypeMarker instanceof SimpleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
            } else if (simpleTypeMarker instanceof SimpleTypeWithEnhancement) {
                return classicTypeSystemContext.asCapturedType(((SimpleTypeWithEnhancement) simpleTypeMarker).getOrigin());
            } else {
                if (simpleTypeMarker instanceof NewCapturedType) {
                    return (NewCapturedType) simpleTypeMarker;
                }
                return null;
            }
        }

        @Nullable
        public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            if (!(simpleTypeMarker instanceof SimpleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
            } else if (simpleTypeMarker instanceof DefinitelyNotNullType) {
                return (DefinitelyNotNullType) simpleTypeMarker;
            } else {
                return null;
            }
        }

        @Nullable
        public static DynamicTypeMarker asDynamicType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            Intrinsics.checkNotNullParameter(flexibleTypeMarker, "$receiver");
            if (!(flexibleTypeMarker instanceof FlexibleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
            } else if (flexibleTypeMarker instanceof DynamicType) {
                return (DynamicType) flexibleTypeMarker;
            } else {
                return null;
            }
        }

        @Nullable
        public static FlexibleTypeMarker asFlexibleType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (kotlinTypeMarker instanceof KotlinType) {
                UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
                if (unwrap instanceof FlexibleType) {
                    return (FlexibleType) unwrap;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        @Nullable
        public static RawTypeMarker asRawType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            Intrinsics.checkNotNullParameter(flexibleTypeMarker, "$receiver");
            if (!(flexibleTypeMarker instanceof FlexibleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
            } else if (flexibleTypeMarker instanceof RawType) {
                return (RawType) flexibleTypeMarker;
            } else {
                return null;
            }
        }

        @Nullable
        public static SimpleTypeMarker asSimpleType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (kotlinTypeMarker instanceof KotlinType) {
                UnwrappedType unwrap = ((KotlinType) kotlinTypeMarker).unwrap();
                if (unwrap instanceof SimpleType) {
                    return (SimpleType) unwrap;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentMarker asTypeArgument(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (kotlinTypeMarker instanceof KotlinType) {
                return TypeUtilsKt.asTypeProjection((KotlinType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        @Nullable
        public static SimpleTypeMarker captureFromArguments(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CaptureStatus captureStatus) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "type");
            Intrinsics.checkNotNullParameter(captureStatus, "status");
            if (simpleTypeMarker instanceof SimpleType) {
                return NewCapturedTypeKt.captureFromArguments((SimpleType) simpleTypeMarker, captureStatus);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static CaptureStatus captureStatus(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeMarker, "$receiver");
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).getCaptureStatus();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker createFlexibleType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "lowerBound");
            Intrinsics.checkNotNullParameter(simpleTypeMarker2, "upperBound");
            if (!(simpleTypeMarker instanceof SimpleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
            } else if (simpleTypeMarker2 instanceof SimpleType) {
                return KotlinTypeFactory.flexibleType((SimpleType) simpleTypeMarker, (SimpleType) simpleTypeMarker2);
            } else {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(classicTypeSystemContext.getClass())).toString());
            }
        }

        @Nullable
        public static List<SimpleTypeMarker> fastCorrespondingSupertypes(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "constructor");
            return TypeSystemInferenceExtensionContext.DefaultImpls.fastCorrespondingSupertypes(classicTypeSystemContext, simpleTypeMarker, typeConstructorMarker);
        }

        @NotNull
        public static TypeArgumentMarker get(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker, int i11) {
            Intrinsics.checkNotNullParameter(typeArgumentListMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.get(classicTypeSystemContext, typeArgumentListMarker, i11);
        }

        @NotNull
        public static TypeArgumentMarker getArgument(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, int i11) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments().get(i11);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        @Nullable
        public static TypeArgumentMarker getArgumentOrNull(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, int i11) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.getArgumentOrNull(classicTypeSystemContext, simpleTypeMarker, i11);
        }

        @NotNull
        public static List<TypeArgumentMarker> getArguments(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getArguments();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static FqNameUnsafe getClassFqNameUnsafe(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return DescriptorUtilsKt.getFqNameUnsafe((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static TypeParameterMarker getParameter(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker, int i11) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) typeConstructorMarker).getParameters().get(i11);
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "this.parameters[index]");
                return typeParameterDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static List<TypeParameterMarker> getParameters(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                List<TypeParameterDescriptor> parameters = ((TypeConstructor) typeConstructorMarker).getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "this.parameters");
                return parameters;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @Nullable
        public static PrimitiveType getPrimitiveArrayType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return KotlinBuiltIns.getPrimitiveArrayType((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @Nullable
        public static PrimitiveType getPrimitiveType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return KotlinBuiltIns.getPrimitiveType((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker getRepresentativeUpperBound(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker typeParameterMarker) {
            Intrinsics.checkNotNullParameter(typeParameterMarker, "$receiver");
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                return TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor) typeParameterMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker getType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            Intrinsics.checkNotNullParameter(typeArgumentMarker, "$receiver");
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).getType().unwrap();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
        }

        @Nullable
        public static TypeParameterMarker getTypeParameter(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeVariableTypeConstructorMarker, "$receiver");
            if (typeVariableTypeConstructorMarker instanceof NewTypeVariableConstructor) {
                return ((NewTypeVariableConstructor) typeVariableTypeConstructorMarker).getOriginalTypeParameter();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeVariableTypeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeVariableTypeConstructorMarker.getClass())).toString());
        }

        @Nullable
        public static TypeParameterMarker getTypeParameterClassifier(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                if (declarationDescriptor instanceof TypeParameterDescriptor) {
                    return (TypeParameterDescriptor) declarationDescriptor;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @Nullable
        public static KotlinTypeMarker getUnsubstitutedUnderlyingType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (kotlinTypeMarker instanceof KotlinType) {
                return InlineClassesUtilsKt.unsubstitutedUnderlyingType((KotlinType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static List<KotlinTypeMarker> getUpperBounds(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker typeParameterMarker) {
            Intrinsics.checkNotNullParameter(typeParameterMarker, "$receiver");
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                List<KotlinType> upperBounds = ((TypeParameterDescriptor) typeParameterMarker).getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "this.upperBounds");
                return upperBounds;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass())).toString());
        }

        @NotNull
        public static TypeVariance getVariance(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            Intrinsics.checkNotNullParameter(typeArgumentMarker, "$receiver");
            if (typeArgumentMarker instanceof TypeProjection) {
                Variance projectionKind = ((TypeProjection) typeArgumentMarker).getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "this.projectionKind");
                return TypeSystemContextKt.convertVariance(projectionKind);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
        }

        public static boolean hasAnnotation(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull FqName fqName) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            if (kotlinTypeMarker instanceof KotlinType) {
                return ((KotlinType) kotlinTypeMarker).getAnnotations().hasAnnotation(fqName);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean hasFlexibleNullability(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.hasFlexibleNullability(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean hasRecursiveBounds(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker typeParameterMarker, @Nullable TypeConstructorMarker typeConstructorMarker) {
            boolean z11;
            Intrinsics.checkNotNullParameter(typeParameterMarker, "$receiver");
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                if (typeConstructorMarker == null) {
                    z11 = true;
                } else {
                    z11 = typeConstructorMarker instanceof TypeConstructor;
                }
                if (z11) {
                    return TypeUtilsKt.hasTypeParameterRecursiveBounds$default((TypeParameterDescriptor) typeParameterMarker, (TypeConstructor) typeConstructorMarker, (Set) null, 4, (Object) null);
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass())).toString());
        }

        public static boolean identicalArguments(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "a");
            Intrinsics.checkNotNullParameter(simpleTypeMarker2, "b");
            if (!(simpleTypeMarker instanceof SimpleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
            } else if (!(simpleTypeMarker2 instanceof SimpleType)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker2 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker2.getClass())).toString());
            } else if (((SimpleType) simpleTypeMarker).getArguments() == ((SimpleType) simpleTypeMarker2).getArguments()) {
                return true;
            } else {
                return false;
            }
        }

        @NotNull
        public static KotlinTypeMarker intersectTypes(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull List<? extends KotlinTypeMarker> list) {
            Intrinsics.checkNotNullParameter(list, "types");
            return IntersectionTypeKt.intersectTypes(list);
        }

        public static boolean isAnyConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, StandardNames.FqNames.any);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isCapturedType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isCapturedType(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isClassType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isClassType(classicTypeSystemContext, simpleTypeMarker);
        }

        public static boolean isClassTypeConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor() instanceof ClassDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isCommonFinalClassConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            ClassDescriptor classDescriptor;
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                if (declarationDescriptor instanceof ClassDescriptor) {
                    classDescriptor = (ClassDescriptor) declarationDescriptor;
                } else {
                    classDescriptor = null;
                }
                if (classDescriptor == null || !ModalityUtilsKt.isFinalClass(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isDefinitelyNotNullType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDefinitelyNotNullType(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isDenotable(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).isDenotable();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isDynamic(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isDynamic(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isError(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (kotlinTypeMarker instanceof KotlinType) {
                return KotlinTypeKt.isError((KotlinType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean isInlineClass(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            ClassDescriptor classDescriptor;
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                ValueClassRepresentation<SimpleType> valueClassRepresentation = null;
                if (declarationDescriptor instanceof ClassDescriptor) {
                    classDescriptor = (ClassDescriptor) declarationDescriptor;
                } else {
                    classDescriptor = null;
                }
                if (classDescriptor != null) {
                    valueClassRepresentation = classDescriptor.getValueClassRepresentation();
                }
                return valueClassRepresentation instanceof InlineClassRepresentation;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isIntegerLiteralType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isIntegerLiteralType(classicTypeSystemContext, simpleTypeMarker);
        }

        public static boolean isIntegerLiteralTypeConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntegerLiteralTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isIntersection(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntersectionTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isMarkedNullable(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isMarkedNullable(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isNotNullTypeParameter(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            return kotlinTypeMarker instanceof NotNullTypeParameter;
        }

        public static boolean isNothing(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.isNothing(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean isNothingConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor) typeConstructorMarker, StandardNames.FqNames.nothing);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        public static boolean isNullableType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (kotlinTypeMarker instanceof KotlinType) {
                return TypeUtils.isNullableType((KotlinType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean isOldCapturedType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeMarker, "$receiver");
            return capturedTypeMarker instanceof CapturedType;
        }

        public static boolean isPrimitiveType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            if (simpleTypeMarker instanceof KotlinType) {
                return KotlinBuiltIns.isPrimitiveType((KotlinType) simpleTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static boolean isProjectionNotNull(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeMarker, "$receiver");
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).isProjectionNotNull();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass())).toString());
        }

        public static boolean isSingleClassifierType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            if (simpleTypeMarker instanceof SimpleType) {
                if (!KotlinTypeKt.isError((KotlinType) simpleTypeMarker)) {
                    SimpleType simpleType = (SimpleType) simpleTypeMarker;
                    if ((simpleType.getConstructor().getDeclarationDescriptor() instanceof TypeAliasDescriptor) || (simpleType.getConstructor().getDeclarationDescriptor() == null && !(simpleTypeMarker instanceof CapturedType) && !(simpleTypeMarker instanceof NewCapturedType) && !(simpleTypeMarker instanceof DefinitelyNotNullType) && !(simpleType.getConstructor() instanceof IntegerLiteralTypeConstructor) && !isSingleClassifierTypeWithEnhancement(classicTypeSystemContext, simpleTypeMarker))) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        private static boolean isSingleClassifierTypeWithEnhancement(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            return (simpleTypeMarker instanceof SimpleTypeWithEnhancement) && classicTypeSystemContext.isSingleClassifierType(((SimpleTypeWithEnhancement) simpleTypeMarker).getOrigin());
        }

        public static boolean isStarProjection(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            Intrinsics.checkNotNullParameter(typeArgumentMarker, "$receiver");
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).isStarProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeArgumentMarker.getClass())).toString());
        }

        public static boolean isStubType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            if (simpleTypeMarker instanceof SimpleType) {
                return TypeUtilsKt.isStubType((KotlinType) simpleTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static boolean isStubTypeForBuilderInference(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            if (simpleTypeMarker instanceof SimpleType) {
                return TypeUtilsKt.isStubTypeForBuilderInference((KotlinType) simpleTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static boolean isTypeVariableType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (!(kotlinTypeMarker instanceof UnwrappedType) || !(((UnwrappedType) kotlinTypeMarker).getConstructor() instanceof NewTypeVariableConstructor)) {
                return false;
            }
            return true;
        }

        public static boolean isUnderKotlinPackage(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                if (declarationDescriptor == null || !KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
                    return false;
                }
                return true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker lowerBound(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            Intrinsics.checkNotNullParameter(flexibleTypeMarker, "$receiver");
            if (flexibleTypeMarker instanceof FlexibleType) {
                return ((FlexibleType) flexibleTypeMarker).getLowerBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker lowerBoundIfFlexible(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.lowerBoundIfFlexible(classicTypeSystemContext, kotlinTypeMarker);
        }

        @Nullable
        public static KotlinTypeMarker lowerType(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeMarker, "$receiver");
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).getLowerType();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker makeDefinitelyNotNullOrNotNull(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (kotlinTypeMarker instanceof UnwrappedType) {
                return ClassicTypeSystemContextKt.makeDefinitelyNotNullOrNotNullInternal((UnwrappedType) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker makeNullable(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            return TypeSystemCommonBackendContext.DefaultImpls.makeNullable(classicTypeSystemContext, kotlinTypeMarker);
        }

        @NotNull
        public static TypeCheckerState newTypeCheckerState(@NotNull ClassicTypeSystemContext classicTypeSystemContext, boolean z11, boolean z12) {
            return ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(z11, z12, classicTypeSystemContext, (KotlinTypePreparator) null, (KotlinTypeRefiner) null, 24, (Object) null);
        }

        @NotNull
        public static SimpleTypeMarker original(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
            Intrinsics.checkNotNullParameter(definitelyNotNullTypeMarker, "$receiver");
            if (definitelyNotNullTypeMarker instanceof DefinitelyNotNullType) {
                return ((DefinitelyNotNullType) definitelyNotNullTypeMarker).getOriginal();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + definitelyNotNullTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(definitelyNotNullTypeMarker.getClass())).toString());
        }

        public static int parametersCount(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static Collection<KotlinTypeMarker> possibleIntegerTypes(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            TypeConstructorMarker typeConstructor = classicTypeSystemContext.typeConstructor(simpleTypeMarker);
            if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) typeConstructor).getPossibleTypes();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentMarker projection(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeConstructorMarker capturedTypeConstructorMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeConstructorMarker, "$receiver");
            if (capturedTypeConstructorMarker instanceof NewCapturedTypeConstructor) {
                return ((NewCapturedTypeConstructor) capturedTypeConstructorMarker).getProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(capturedTypeConstructorMarker.getClass())).toString());
        }

        public static int size(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker) {
            Intrinsics.checkNotNullParameter(typeArgumentListMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.size(classicTypeSystemContext, typeArgumentListMarker);
        }

        @NotNull
        public static TypeCheckerState.SupertypesPolicy substitutionSupertypePolicy(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "type");
            if (simpleTypeMarker instanceof SimpleType) {
                return new ClassicTypeSystemContext$substitutionSupertypePolicy$2(classicTypeSystemContext, TypeConstructorSubstitution.Companion.create((KotlinType) simpleTypeMarker).buildSubstitutor());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static Collection<KotlinTypeMarker> supertypes(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            Intrinsics.checkNotNullParameter(typeConstructorMarker, "$receiver");
            if (typeConstructorMarker instanceof TypeConstructor) {
                Collection<KotlinType> supertypes = ((TypeConstructor) typeConstructorMarker).getSupertypes();
                Intrinsics.checkNotNullExpressionValue(supertypes, "this.supertypes");
                return supertypes;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static TypeConstructorMarker typeConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.typeConstructor(classicTypeSystemContext, kotlinTypeMarker);
        }

        @NotNull
        public static SimpleTypeMarker upperBound(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            Intrinsics.checkNotNullParameter(flexibleTypeMarker, "$receiver");
            if (flexibleTypeMarker instanceof FlexibleType) {
                return ((FlexibleType) flexibleTypeMarker).getUpperBound();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(flexibleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker upperBoundIfFlexible(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            return TypeSystemInferenceExtensionContext.DefaultImpls.upperBoundIfFlexible(classicTypeSystemContext, kotlinTypeMarker);
        }

        @NotNull
        public static SimpleTypeMarker withNullability(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, boolean z11) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).makeNullableAsSpecified(z11);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        public static boolean isMarkedNullable(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).isMarkedNullable();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static TypeConstructorMarker typeConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            Intrinsics.checkNotNullParameter(simpleTypeMarker, "$receiver");
            if (simpleTypeMarker instanceof SimpleType) {
                return ((SimpleType) simpleTypeMarker).getConstructor();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static TypeVariance getVariance(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker typeParameterMarker) {
            Intrinsics.checkNotNullParameter(typeParameterMarker, "$receiver");
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                Variance variance = ((TypeParameterDescriptor) typeParameterMarker).getVariance();
                Intrinsics.checkNotNullExpressionValue(variance, "this.variance");
                return TypeSystemContextKt.convertVariance(variance);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(typeParameterMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker withNullability(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, boolean z11) {
            Intrinsics.checkNotNullParameter(kotlinTypeMarker, "$receiver");
            if (kotlinTypeMarker instanceof SimpleTypeMarker) {
                return classicTypeSystemContext.withNullability((SimpleTypeMarker) kotlinTypeMarker, z11);
            }
            if (kotlinTypeMarker instanceof FlexibleTypeMarker) {
                FlexibleTypeMarker flexibleTypeMarker = (FlexibleTypeMarker) kotlinTypeMarker;
                return classicTypeSystemContext.createFlexibleType(classicTypeSystemContext.withNullability(classicTypeSystemContext.lowerBound(flexibleTypeMarker), z11), classicTypeSystemContext.withNullability(classicTypeSystemContext.upperBound(flexibleTypeMarker), z11));
            }
            throw new IllegalStateException("sealed".toString());
        }

        @NotNull
        public static CapturedTypeConstructorMarker typeConstructor(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            Intrinsics.checkNotNullParameter(capturedTypeMarker, "$receiver");
            if (capturedTypeMarker instanceof NewCapturedType) {
                return ((NewCapturedType) capturedTypeMarker).getConstructor();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + Reflection.getOrCreateKotlinClass(capturedTypeMarker.getClass())).toString());
        }
    }

    @Nullable
    CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Nullable
    SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    KotlinTypeMarker createFlexibleType(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2);

    boolean isSingleClassifierType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker);

    @NotNull
    SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @NotNull
    SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker simpleTypeMarker, boolean z11);
}
