package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public abstract class DescriptorRenderer {
    @NotNull
    @JvmField
    public static final DescriptorRenderer COMPACT;
    @NotNull
    @JvmField
    public static final DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES;
    @NotNull
    @JvmField
    public static final DescriptorRenderer COMPACT_WITH_MODIFIERS;
    @NotNull
    @JvmField
    public static final DescriptorRenderer COMPACT_WITH_SHORT_TYPES;
    @NotNull
    public static final Companion Companion;
    @NotNull
    @JvmField
    public static final DescriptorRenderer DEBUG_TEXT;
    @NotNull
    @JvmField
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES;
    @NotNull
    @JvmField
    public static final DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS;
    @NotNull
    @JvmField
    public static final DescriptorRenderer HTML;
    @NotNull
    @JvmField
    public static final DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES;
    @NotNull
    @JvmField
    public static final DescriptorRenderer SHORT_NAMES_IN_TYPES;

    public static final class Companion {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ClassKind.values().length];
                iArr[ClassKind.CLASS.ordinal()] = 1;
                iArr[ClassKind.INTERFACE.ordinal()] = 2;
                iArr[ClassKind.ENUM_CLASS.ordinal()] = 3;
                iArr[ClassKind.OBJECT.ordinal()] = 4;
                iArr[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                iArr[ClassKind.ENUM_ENTRY.ordinal()] = 6;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getClassifierKindPrefix(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
            Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "classifier");
            if (classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor) {
                return "typealias";
            }
            if (classifierDescriptorWithTypeParameters instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptorWithTypeParameters;
                if (classDescriptor.isCompanionObject()) {
                    return "companion object";
                }
                switch (WhenMappings.$EnumSwitchMapping$0[classDescriptor.getKind().ordinal()]) {
                    case 1:
                        return "class";
                    case 2:
                        return "interface";
                    case 3:
                        return "enum class";
                    case 4:
                        return "object";
                    case 5:
                        return "annotation class";
                    case 6:
                        return "enum entry";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            } else {
                throw new AssertionError("Unexpected classifier: " + classifierDescriptorWithTypeParameters);
            }
        }

        @NotNull
        public final DescriptorRenderer withOptions(@NotNull Function1<? super DescriptorRendererOptions, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "changeOptions");
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
            function1.invoke(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.lock();
            return new DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }
    }

    public interface ValueParametersHandler {

        public static final class DEFAULT implements ValueParametersHandler {
            @NotNull
            public static final DEFAULT INSTANCE = new DEFAULT();

            private DEFAULT() {
            }

            public void appendAfterValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i11, int i12, @NotNull StringBuilder sb2) {
                Intrinsics.checkNotNullParameter(valueParameterDescriptor, "parameter");
                Intrinsics.checkNotNullParameter(sb2, "builder");
                if (i11 != i12 - 1) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
            }

            public void appendAfterValueParameters(int i11, @NotNull StringBuilder sb2) {
                Intrinsics.checkNotNullParameter(sb2, "builder");
                sb2.append(")");
            }

            public void appendBeforeValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i11, int i12, @NotNull StringBuilder sb2) {
                Intrinsics.checkNotNullParameter(valueParameterDescriptor, "parameter");
                Intrinsics.checkNotNullParameter(sb2, "builder");
            }

            public void appendBeforeValueParameters(int i11, @NotNull StringBuilder sb2) {
                Intrinsics.checkNotNullParameter(sb2, "builder");
                sb2.append("(");
            }
        }

        void appendAfterValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i11, int i12, @NotNull StringBuilder sb2);

        void appendAfterValueParameters(int i11, @NotNull StringBuilder sb2);

        void appendBeforeValueParameter(@NotNull ValueParameterDescriptor valueParameterDescriptor, int i11, int i12, @NotNull StringBuilder sb2);

        void appendBeforeValueParameters(int i11, @NotNull StringBuilder sb2);
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        COMPACT_WITH_MODIFIERS = companion.withOptions(DescriptorRenderer$Companion$COMPACT_WITH_MODIFIERS$1.INSTANCE);
        COMPACT = companion.withOptions(DescriptorRenderer$Companion$COMPACT$1.INSTANCE);
        COMPACT_WITHOUT_SUPERTYPES = companion.withOptions(DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1.INSTANCE);
        COMPACT_WITH_SHORT_TYPES = companion.withOptions(DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1.INSTANCE);
        ONLY_NAMES_WITH_SHORT_TYPES = companion.withOptions(DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES = companion.withOptions(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1.INSTANCE);
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = companion.withOptions(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$1.INSTANCE);
        SHORT_NAMES_IN_TYPES = companion.withOptions(DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1.INSTANCE);
        DEBUG_TEXT = companion.withOptions(DescriptorRenderer$Companion$DEBUG_TEXT$1.INSTANCE);
        HTML = companion.withOptions(DescriptorRenderer$Companion$HTML$1.INSTANCE);
    }

    public static /* synthetic */ String renderAnnotation$default(DescriptorRenderer descriptorRenderer, AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                annotationUseSiteTarget = null;
            }
            return descriptorRenderer.renderAnnotation(annotationDescriptor, annotationUseSiteTarget);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    @NotNull
    public abstract String render(@NotNull DeclarationDescriptor declarationDescriptor);

    @NotNull
    public abstract String renderAnnotation(@NotNull AnnotationDescriptor annotationDescriptor, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget);

    @NotNull
    public abstract String renderFlexibleType(@NotNull String str, @NotNull String str2, @NotNull KotlinBuiltIns kotlinBuiltIns);

    @NotNull
    public abstract String renderFqName(@NotNull FqNameUnsafe fqNameUnsafe);

    @NotNull
    public abstract String renderName(@NotNull Name name2, boolean z11);

    @NotNull
    public abstract String renderType(@NotNull KotlinType kotlinType);

    @NotNull
    public abstract String renderTypeProjection(@NotNull TypeProjection typeProjection);

    @NotNull
    public final DescriptorRenderer withOptions(@NotNull Function1<? super DescriptorRendererOptions, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "changeOptions");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        DescriptorRendererOptionsImpl copy = ((DescriptorRendererImpl) this).getOptions().copy();
        function1.invoke(copy);
        copy.lock();
        return new DescriptorRendererImpl(copy);
    }
}
