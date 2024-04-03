package kotlin.reflect.jvm.internal.impl.renderer;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    @NotNull
    private final Lazy functionTypeAnnotationsRenderer$delegate = LazyKt__LazyJVMKt.lazy(new DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(this));
    @NotNull
    private final DescriptorRendererOptionsImpl options;

    public final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PropertyAccessorRenderingPolicy.values().length];
                iArr[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                iArr[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                iArr[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public RenderDeclarationDescriptorVisitor() {
        }

        private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb2, String str) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[DescriptorRendererImpl.this.getPropertyAccessorRenderingPolicy().ordinal()];
            if (i11 == 1) {
                DescriptorRendererImpl.this.renderAccessorModifiers(propertyAccessorDescriptor, sb2);
                sb2.append(str + " for ");
                DescriptorRendererImpl descriptorRendererImpl = DescriptorRendererImpl.this;
                PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
                Intrinsics.checkNotNullExpressionValue(correspondingProperty, "descriptor.correspondingProperty");
                descriptorRendererImpl.renderProperty(correspondingProperty, sb2);
            } else if (i11 == 2) {
                visitFunctionDescriptor((FunctionDescriptor) propertyAccessorDescriptor, sb2);
            }
        }

        public /* bridge */ /* synthetic */ Object visitClassDescriptor(ClassDescriptor classDescriptor, Object obj) {
            visitClassDescriptor(classDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, Object obj) {
            visitConstructorDescriptor(constructorDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitFunctionDescriptor(FunctionDescriptor functionDescriptor, Object obj) {
            visitFunctionDescriptor(functionDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitModuleDeclaration(ModuleDescriptor moduleDescriptor, Object obj) {
            visitModuleDeclaration(moduleDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, Object obj) {
            visitPackageFragmentDescriptor(packageFragmentDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, Object obj) {
            visitPackageViewDescriptor(packageViewDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, Object obj) {
            visitPropertyDescriptor(propertyDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, Object obj) {
            visitPropertyGetterDescriptor(propertyGetterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, Object obj) {
            visitPropertySetterDescriptor(propertySetterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, Object obj) {
            visitReceiverParameterDescriptor(receiverParameterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, Object obj) {
            visitTypeAliasDescriptor(typeAliasDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, Object obj) {
            visitTypeParameterDescriptor(typeParameterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public /* bridge */ /* synthetic */ Object visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, Object obj) {
            visitValueParameterDescriptor(valueParameterDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public void visitClassDescriptor(@NotNull ClassDescriptor classDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.this.renderClass(classDescriptor, sb2);
        }

        public void visitConstructorDescriptor(@NotNull ConstructorDescriptor constructorDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(constructorDescriptor, "constructorDescriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.this.renderConstructor(constructorDescriptor, sb2);
        }

        public void visitFunctionDescriptor(@NotNull FunctionDescriptor functionDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(functionDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.this.renderFunction(functionDescriptor, sb2);
        }

        public void visitModuleDeclaration(@NotNull ModuleDescriptor moduleDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.this.renderName(moduleDescriptor, sb2, true);
        }

        public void visitPackageFragmentDescriptor(@NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.this.renderPackageFragment(packageFragmentDescriptor, sb2);
        }

        public void visitPackageViewDescriptor(@NotNull PackageViewDescriptor packageViewDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(packageViewDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.this.renderPackageView(packageViewDescriptor, sb2);
        }

        public void visitPropertyDescriptor(@NotNull PropertyDescriptor propertyDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.this.renderProperty(propertyDescriptor, sb2);
        }

        public void visitPropertyGetterDescriptor(@NotNull PropertyGetterDescriptor propertyGetterDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(propertyGetterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            visitPropertyAccessorDescriptor(propertyGetterDescriptor, sb2, "getter");
        }

        public void visitPropertySetterDescriptor(@NotNull PropertySetterDescriptor propertySetterDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(propertySetterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            visitPropertyAccessorDescriptor(propertySetterDescriptor, sb2, "setter");
        }

        public void visitReceiverParameterDescriptor(@NotNull ReceiverParameterDescriptor receiverParameterDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(receiverParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            sb2.append(receiverParameterDescriptor.getName());
        }

        public void visitTypeAliasDescriptor(@NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.this.renderTypeAlias(typeAliasDescriptor, sb2);
        }

        public void visitTypeParameterDescriptor(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.this.renderTypeParameter(typeParameterDescriptor, sb2, true);
        }

        public void visitValueParameterDescriptor(@NotNull ValueParameterDescriptor valueParameterDescriptor, @NotNull StringBuilder sb2) {
            Intrinsics.checkNotNullParameter(valueParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb2, "builder");
            DescriptorRendererImpl.this.renderValueParameter(valueParameterDescriptor, true, sb2, true);
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            iArr[RenderingFormat.PLAIN.ordinal()] = 1;
            iArr[RenderingFormat.HTML.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ParameterNameRenderingPolicy.values().length];
            iArr2[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            iArr2[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            iArr2[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DescriptorRendererImpl(@NotNull DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        Intrinsics.checkNotNullParameter(descriptorRendererOptionsImpl, "options");
        this.options = descriptorRendererOptionsImpl;
        descriptorRendererOptionsImpl.isLocked();
    }

    public static /* synthetic */ void a(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb2, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.renderAnnotations(sb2, annotated, annotationUseSiteTarget);
    }

    private final void appendDefinedIn(StringBuilder sb2, DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptor containingDeclaration;
        String str;
        String name2;
        if (!(declarationDescriptor instanceof PackageFragmentDescriptor) && !(declarationDescriptor instanceof PackageViewDescriptor) && (containingDeclaration = declarationDescriptor.getContainingDeclaration()) != null && !(containingDeclaration instanceof ModuleDescriptor)) {
            sb2.append(" ");
            sb2.append(renderMessage("defined in"));
            sb2.append(" ");
            FqNameUnsafe fqName = DescriptorUtils.getFqName(containingDeclaration);
            Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(containingDeclaration)");
            if (fqName.isRoot()) {
                str = "root package";
            } else {
                str = renderFqName(fqName);
            }
            sb2.append(str);
            if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource) && (name2 = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile().getName()) != null) {
                sb2.append(" ");
                sb2.append(renderMessage("in file"));
                sb2.append(" ");
                sb2.append(name2);
            }
        }
    }

    private final void appendTypeProjections(StringBuilder sb2, List<? extends TypeProjection> list) {
        Appendable unused = CollectionsKt___CollectionsKt.joinTo$default(list, sb2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new DescriptorRendererImpl$appendTypeProjections$1(this), 60, (Object) null);
    }

    private final String arrow() {
        int i11 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i11 == 1) {
            return escape("->");
        }
        if (i11 == 2) {
            return "&rarr;";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void b(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb2, KotlinType kotlinType, TypeConstructor typeConstructor, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            typeConstructor = kotlinType.getConstructor();
        }
        descriptorRendererImpl.renderTypeConstructorAndArguments(sb2, kotlinType, typeConstructor);
    }

    public static /* synthetic */ void c(DescriptorRendererImpl descriptorRendererImpl, VariableDescriptor variableDescriptor, StringBuilder sb2, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        descriptorRendererImpl.renderValVarPrefix(variableDescriptor, sb2, z11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0032, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7 + '?', (java.lang.Object) r8) == false) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean differsOnlyInNullability(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r1 = "?"
            java.lang.String r2 = ""
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r8
            java.lang.String r0 = kotlin.text.StringsKt__StringsJVMKt.replace$default((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2, (boolean) r3, (int) r4, (java.lang.Object) r5)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0050
            r0 = 2
            r1 = 0
            java.lang.String r2 = "?"
            r3 = 0
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r8, r2, r3, r0, r1)
            if (r0 == 0) goto L_0x0034
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r1 = 63
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r8)
            if (r0 != 0) goto L_0x0050
        L_0x0034:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 40
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = ")?"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0051
        L_0x0050:
            r3 = 1
        L_0x0051:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.differsOnlyInNullability(java.lang.String, java.lang.String):boolean");
    }

    private final String escape(String str) {
        return getTextFormat().escape(str);
    }

    private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        return (DescriptorRendererImpl) this.functionTypeAnnotationsRenderer$delegate.getValue();
    }

    private final String gt() {
        return escape(">");
    }

    private final boolean hasModifiersOrAnnotations(KotlinType kotlinType) {
        return FunctionTypesKt.isSuspendFunctionType(kotlinType) || !kotlinType.getAnnotations().isEmpty();
    }

    private final Modality implicitModalityWithoutExtensions(MemberDescriptor memberDescriptor) {
        ClassDescriptor classDescriptor;
        if (!(memberDescriptor instanceof ClassDescriptor)) {
            DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
            if (containingDeclaration instanceof ClassDescriptor) {
                classDescriptor = (ClassDescriptor) containingDeclaration;
            } else {
                classDescriptor = null;
            }
            if (classDescriptor == null) {
                return Modality.FINAL;
            }
            if (!(memberDescriptor instanceof CallableMemberDescriptor)) {
                return Modality.FINAL;
            }
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
            if ((!overriddenDescriptors.isEmpty()) && classDescriptor.getModality() != Modality.FINAL) {
                return Modality.OPEN;
            }
            if (classDescriptor.getKind() != ClassKind.INTERFACE || Intrinsics.areEqual((Object) callableMemberDescriptor.getVisibility(), (Object) DescriptorVisibilities.PRIVATE)) {
                return Modality.FINAL;
            }
            Modality modality = callableMemberDescriptor.getModality();
            Modality modality2 = Modality.ABSTRACT;
            if (modality == modality2) {
                return modality2;
            }
            return Modality.OPEN;
        } else if (((ClassDescriptor) memberDescriptor).getKind() == ClassKind.INTERFACE) {
            return Modality.ABSTRACT;
        } else {
            return Modality.FINAL;
        }
    }

    private final boolean isParameterName(AnnotationDescriptor annotationDescriptor) {
        return Intrinsics.areEqual((Object) annotationDescriptor.getFqName(), (Object) StandardNames.FqNames.parameterName);
    }

    private final String lt() {
        return escape("<");
    }

    private final boolean overridesSomething(CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.getOverriddenDescriptors().isEmpty();
    }

    private final void renderAbbreviatedTypeExpansion(StringBuilder sb2, AbbreviatedType abbreviatedType) {
        RenderingFormat textFormat = getTextFormat();
        RenderingFormat renderingFormat = RenderingFormat.HTML;
        if (textFormat == renderingFormat) {
            sb2.append("<font color=\"808080\"><i>");
        }
        sb2.append(" /* = ");
        renderNormalizedTypeAsIs(sb2, abbreviatedType.getExpandedType());
        sb2.append(" */");
        if (getTextFormat() == renderingFormat) {
            sb2.append("</i></font>");
        }
    }

    /* access modifiers changed from: private */
    public final void renderAccessorModifiers(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb2) {
        renderMemberModifiers(propertyAccessorDescriptor, sb2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void renderAdditionalModifiers(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6, java.lang.StringBuilder r7) {
        /*
            r5 = this;
            boolean r0 = r6.isOperator()
            java.lang.String r1 = "functionDescriptor.overriddenDescriptors"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x003f
            java.util.Collection r0 = r6.getOverriddenDescriptors()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x001e
        L_0x001c:
            r0 = r3
            goto L_0x0035
        L_0x001e:
            java.util.Iterator r0 = r0.iterator()
        L_0x0022:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x001c
            java.lang.Object r4 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            boolean r4 = r4.isOperator()
            if (r4 == 0) goto L_0x0022
            r0 = r2
        L_0x0035:
            if (r0 != 0) goto L_0x003d
            boolean r0 = r5.getAlwaysRenderModifiers()
            if (r0 == 0) goto L_0x003f
        L_0x003d:
            r0 = r3
            goto L_0x0040
        L_0x003f:
            r0 = r2
        L_0x0040:
            boolean r4 = r6.isInfix()
            if (r4 == 0) goto L_0x007a
            java.util.Collection r4 = r6.getOverriddenDescriptors()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x005a
        L_0x0058:
            r1 = r3
            goto L_0x0071
        L_0x005a:
            java.util.Iterator r1 = r4.iterator()
        L_0x005e:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0058
            java.lang.Object r4 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r4
            boolean r4 = r4.isInfix()
            if (r4 == 0) goto L_0x005e
            r1 = r2
        L_0x0071:
            if (r1 != 0) goto L_0x0079
            boolean r1 = r5.getAlwaysRenderModifiers()
            if (r1 == 0) goto L_0x007a
        L_0x0079:
            r2 = r3
        L_0x007a:
            boolean r1 = r6.isTailrec()
            java.lang.String r3 = "tailrec"
            r5.renderModifier(r7, r1, r3)
            r5.renderSuspendModifier(r6, r7)
            boolean r6 = r6.isInline()
            java.lang.String r1 = "inline"
            r5.renderModifier(r7, r6, r1)
            java.lang.String r6 = "infix"
            r5.renderModifier(r7, r2, r6)
            java.lang.String r6 = "operator"
            r5.renderModifier(r7, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderAdditionalModifiers(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.StringBuilder):void");
    }

    private final List<String> renderAndSortAnnotationArguments(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor classDescriptor;
        String str;
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        List<ValueParameterDescriptor> valueParameters;
        Map<Name, ConstantValue<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
        List list = null;
        if (getRenderDefaultAnnotationArguments()) {
            classDescriptor = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        } else {
            classDescriptor = null;
        }
        if (!(classDescriptor == null || (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) == null || (valueParameters = unsubstitutedPrimaryConstructor.getValueParameters()) == null)) {
            ArrayList<ValueParameterDescriptor> arrayList = new ArrayList<>();
            for (Object next : valueParameters) {
                if (((ValueParameterDescriptor) next).declaresDefaultValue()) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (ValueParameterDescriptor name2 : arrayList) {
                arrayList2.add(name2.getName());
            }
            list = arrayList2;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList<Name> arrayList3 = new ArrayList<>();
        for (Object next2 : list) {
            Name name3 = (Name) next2;
            Intrinsics.checkNotNullExpressionValue(name3, "it");
            if (!allValueArguments.containsKey(name3)) {
                arrayList3.add(next2);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10));
        for (Name asString : arrayList3) {
            arrayList4.add(asString.asString() + " = ...");
        }
        Set<Map.Entry<Name, ConstantValue<?>>> entrySet = allValueArguments.entrySet();
        ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(entrySet, 10));
        for (Map.Entry entry : entrySet) {
            Name name4 = (Name) entry.getKey();
            ConstantValue constantValue = (ConstantValue) entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(name4.asString());
            sb2.append(" = ");
            if (!list.contains(name4)) {
                str = renderConstant(constantValue);
            } else {
                str = "...";
            }
            sb2.append(str);
            arrayList5.add(sb2.toString());
        }
        return CollectionsKt___CollectionsKt.sorted(CollectionsKt___CollectionsKt.plus(arrayList4, arrayList5));
    }

    private final void renderAnnotations(StringBuilder sb2, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget) {
        Set<FqName> set;
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            if (annotated instanceof KotlinType) {
                set = getExcludedTypeAnnotationClasses();
            } else {
                set = getExcludedAnnotationClasses();
            }
            Function1<AnnotationDescriptor, Boolean> annotationFilter = getAnnotationFilter();
            for (AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
                if (!CollectionsKt___CollectionsKt.contains(set, annotationDescriptor.getFqName()) && !isParameterName(annotationDescriptor)) {
                    if (annotationFilter == null || annotationFilter.invoke(annotationDescriptor).booleanValue()) {
                        sb2.append(renderAnnotation(annotationDescriptor, annotationUseSiteTarget));
                        if (getEachAnnotationOnNewLine()) {
                            sb2.append(10);
                            Intrinsics.checkNotNullExpressionValue(sb2, "append('\\n')");
                        } else {
                            sb2.append(" ");
                        }
                    }
                }
            }
        }
    }

    private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb2) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "classifier.typeConstructor.parameters");
        if (getVerbose() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb2.append(" /*captured type parameters: ");
            renderTypeParameterList(sb2, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb2.append("*/");
        }
    }

    /* access modifiers changed from: private */
    public final void renderClass(ClassDescriptor classDescriptor, StringBuilder sb2) {
        boolean z11;
        ClassConstructorDescriptor unsubstitutedPrimaryConstructor;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        if (classDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!getStartFromName()) {
            a(this, sb2, classDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
            List<ReceiverParameterDescriptor> contextReceivers = classDescriptor.getContextReceivers();
            Intrinsics.checkNotNullExpressionValue(contextReceivers, "klass.contextReceivers");
            renderContextReceivers(contextReceivers, sb2);
            if (!z11) {
                DescriptorVisibility visibility = classDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "klass.visibility");
                renderVisibility(visibility, sb2);
            }
            if (!(classDescriptor.getKind() == ClassKind.INTERFACE && classDescriptor.getModality() == Modality.ABSTRACT) && (!classDescriptor.getKind().isSingleton() || classDescriptor.getModality() != Modality.FINAL)) {
                Modality modality = classDescriptor.getModality();
                Intrinsics.checkNotNullExpressionValue(modality, "klass.modality");
                renderModality(modality, sb2, implicitModalityWithoutExtensions(classDescriptor));
            }
            renderMemberModifiers(classDescriptor, sb2);
            if (!getModifiers().contains(DescriptorRendererModifier.INNER) || !classDescriptor.isInner()) {
                z12 = false;
            } else {
                z12 = true;
            }
            renderModifier(sb2, z12, "inner");
            if (!getModifiers().contains(DescriptorRendererModifier.DATA) || !classDescriptor.isData()) {
                z13 = false;
            } else {
                z13 = true;
            }
            renderModifier(sb2, z13, "data");
            if (!getModifiers().contains(DescriptorRendererModifier.INLINE) || !classDescriptor.isInline()) {
                z14 = false;
            } else {
                z14 = true;
            }
            renderModifier(sb2, z14, "inline");
            if (!getModifiers().contains(DescriptorRendererModifier.VALUE) || !classDescriptor.isValue()) {
                z15 = false;
            } else {
                z15 = true;
            }
            renderModifier(sb2, z15, "value");
            if (!getModifiers().contains(DescriptorRendererModifier.FUN) || !classDescriptor.isFun()) {
                z16 = false;
            } else {
                z16 = true;
            }
            renderModifier(sb2, z16, "fun");
            renderClassKindPrefix(classDescriptor, sb2);
        }
        if (!DescriptorUtils.isCompanionObject(classDescriptor)) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(sb2);
            }
            renderName(classDescriptor, sb2, true);
        } else {
            renderCompanionObjectName(classDescriptor, sb2);
        }
        if (!z11) {
            List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "klass.declaredTypeParameters");
            renderTypeParameters(declaredTypeParameters, sb2, false);
            renderCapturedTypeParametersIfRequired(classDescriptor, sb2);
            if (!classDescriptor.getKind().isSingleton() && getClassWithPrimaryConstructor() && (unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor()) != null) {
                sb2.append(" ");
                a(this, sb2, unsubstitutedPrimaryConstructor, (AnnotationUseSiteTarget) null, 2, (Object) null);
                DescriptorVisibility visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility2, "primaryConstructor.visibility");
                renderVisibility(visibility2, sb2);
                sb2.append(renderKeyword("constructor"));
                List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "primaryConstructor.valueParameters");
                renderValueParameters(valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb2);
            }
            renderSuperTypes(classDescriptor, sb2);
            renderWhereSuffix(declaredTypeParameters, sb2);
        }
    }

    private final void renderClassKindPrefix(ClassDescriptor classDescriptor, StringBuilder sb2) {
        sb2.append(renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix(classDescriptor)));
    }

    private final void renderCompanionObjectName(DeclarationDescriptor declarationDescriptor, StringBuilder sb2) {
        if (getRenderCompanionObjectName()) {
            if (getStartFromName()) {
                sb2.append("companion object");
            }
            renderSpaceIfNeeded(sb2);
            DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            if (containingDeclaration != null) {
                sb2.append("of ");
                Name name2 = containingDeclaration.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "containingDeclaration.name");
                sb2.append(renderName(name2, false));
            }
        }
        if (getVerbose() || !Intrinsics.areEqual((Object) declarationDescriptor.getName(), (Object) SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(sb2);
            }
            Name name3 = declarationDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "descriptor.name");
            sb2.append(renderName(name3, true));
        }
    }

    /* access modifiers changed from: private */
    public final String renderConstant(ConstantValue<?> constantValue) {
        if (constantValue instanceof ArrayValue) {
            return CollectionsKt___CollectionsKt.joinToString$default((Iterable) ((ArrayValue) constantValue).getValue(), IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "{", "}", 0, (CharSequence) null, new DescriptorRendererImpl$renderConstant$1(this), 24, (Object) null);
        }
        if (constantValue instanceof AnnotationValue) {
            return StringsKt__StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, (AnnotationDescriptor) ((AnnotationValue) constantValue).getValue(), (AnnotationUseSiteTarget) null, 2, (Object) null), (CharSequence) "@");
        }
        if (!(constantValue instanceof KClassValue)) {
            return constantValue.toString();
        }
        KClassValue.Value value = (KClassValue.Value) ((KClassValue) constantValue).getValue();
        if (value instanceof KClassValue.Value.LocalClass) {
            return ((KClassValue.Value.LocalClass) value).getType() + "::class";
        } else if (value instanceof KClassValue.Value.NormalClass) {
            KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value;
            String asString = normalClass.getClassId().asSingleFqName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "classValue.classId.asSingleFqName().asString()");
            for (int i11 = 0; i11 < normalClass.getArrayDimensions(); i11++) {
                asString = "kotlin.Array<" + asString + Typography.greater;
            }
            return asString + "::class";
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void renderConstructor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r18, java.lang.StringBuilder r19) {
        /*
            r17 = this;
            r6 = r17
            r7 = r19
            r3 = 0
            r4 = 2
            r5 = 0
            r0 = r17
            r1 = r19
            r2 = r18
            a(r0, r1, r2, r3, r4, r5)
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r0 = r6.options
            boolean r0 = r0.getRenderDefaultVisibility()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0026
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = r18.getConstructedClass()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r0 = r0.getModality()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r3 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED
            if (r0 == r3) goto L_0x0037
        L_0x0026:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r0 = r18.getVisibility()
            java.lang.String r3 = "constructor.visibility"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r0 = r6.renderVisibility(r0, r7)
            if (r0 == 0) goto L_0x0037
            r0 = r2
            goto L_0x0038
        L_0x0037:
            r0 = r1
        L_0x0038:
            r17.renderMemberKind(r18, r19)
            boolean r3 = r17.getRenderConstructorKeyword()
            if (r3 != 0) goto L_0x004c
            boolean r3 = r18.isPrimary()
            if (r3 == 0) goto L_0x004c
            if (r0 == 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r0 = r1
            goto L_0x004d
        L_0x004c:
            r0 = r2
        L_0x004d:
            if (r0 == 0) goto L_0x0058
            java.lang.String r3 = "constructor"
            java.lang.String r3 = r6.renderKeyword(r3)
            r7.append(r3)
        L_0x0058:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r3 = r18.getContainingDeclaration()
            java.lang.String r4 = "constructor.containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r4 = r17.getSecondaryConstructorsAsPrimary()
            java.lang.String r5 = "constructor.typeParameters"
            if (r4 == 0) goto L_0x007d
            if (r0 == 0) goto L_0x0070
            java.lang.String r0 = " "
            r7.append(r0)
        L_0x0070:
            r6.renderName(r3, r7, r2)
            java.util.List r0 = r18.getTypeParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r6.renderTypeParameters(r0, r7, r1)
        L_0x007d:
            java.util.List r0 = r18.getValueParameters()
            java.lang.String r4 = "constructor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r4 = r18.hasSynthesizedParameterNames()
            r6.renderValueParameters(r0, r4, r7)
            boolean r0 = r17.getRenderConstructorDelegation()
            if (r0 == 0) goto L_0x0107
            boolean r0 = r18.isPrimary()
            if (r0 != 0) goto L_0x0107
            boolean r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r0 == 0) goto L_0x0107
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r0 = r3.getUnsubstitutedPrimaryConstructor()
            if (r0 == 0) goto L_0x0107
            java.util.List r0 = r0.getValueParameters()
            java.lang.String r3 = "primaryConstructor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x00bb:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00dd
            java.lang.Object r3 = r0.next()
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            boolean r9 = r4.declaresDefaultValue()
            if (r9 != 0) goto L_0x00d6
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.getVarargElementType()
            if (r4 != 0) goto L_0x00d6
            r4 = r2
            goto L_0x00d7
        L_0x00d6:
            r4 = r1
        L_0x00d7:
            if (r4 == 0) goto L_0x00bb
            r8.add(r3)
            goto L_0x00bb
        L_0x00dd:
            boolean r0 = r8.isEmpty()
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0107
            java.lang.String r0 = " : "
            r7.append(r0)
            java.lang.String r0 = "this"
            java.lang.String r0 = r6.renderKeyword(r0)
            r7.append(r0)
            java.lang.String r9 = ", "
            java.lang.String r10 = "("
            java.lang.String r11 = ")"
            r12 = 0
            r13 = 0
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstructor$1 r14 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstructor$1.INSTANCE
            r15 = 24
            r16 = 0
            java.lang.String r0 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r7.append(r0)
        L_0x0107:
            boolean r0 = r17.getSecondaryConstructorsAsPrimary()
            if (r0 == 0) goto L_0x0117
            java.util.List r0 = r18.getTypeParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r6.renderWhereSuffix(r0, r7)
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderConstructor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, java.lang.StringBuilder):void");
    }

    private final void renderContextReceivers(List<? extends ReceiverParameterDescriptor> list, StringBuilder sb2) {
        if (!list.isEmpty()) {
            sb2.append("context(");
            int i11 = 0;
            for (ReceiverParameterDescriptor receiverParameterDescriptor : list) {
                int i12 = i11 + 1;
                renderAnnotations(sb2, receiverParameterDescriptor, AnnotationUseSiteTarget.RECEIVER);
                KotlinType type = receiverParameterDescriptor.getType();
                Intrinsics.checkNotNullExpressionValue(type, "contextReceiver.type");
                sb2.append(renderForReceiver(type));
                if (i11 == CollectionsKt__CollectionsKt.getLastIndex(list)) {
                    sb2.append(") ");
                } else {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                i11 = i12;
            }
        }
    }

    private final void renderDefaultType(StringBuilder sb2, KotlinType kotlinType) {
        DefinitelyNotNullType definitelyNotNullType;
        a(this, sb2, kotlinType, (AnnotationUseSiteTarget) null, 2, (Object) null);
        SimpleType simpleType = null;
        if (kotlinType instanceof DefinitelyNotNullType) {
            definitelyNotNullType = (DefinitelyNotNullType) kotlinType;
        } else {
            definitelyNotNullType = null;
        }
        if (definitelyNotNullType != null) {
            simpleType = definitelyNotNullType.getOriginal();
        }
        if (KotlinTypeKt.isError(kotlinType)) {
            if (TypeUtilsKt.isUnresolvedType(kotlinType) && getPresentableUnresolvedTypes()) {
                sb2.append(((ErrorType) kotlinType).getDebugMessage());
            } else if (!(kotlinType instanceof ErrorType) || getInformativeErrorType()) {
                sb2.append(kotlinType.getConstructor().toString());
            } else {
                sb2.append(((ErrorType) kotlinType).getDebugMessage());
            }
            sb2.append(renderTypeArguments(kotlinType.getArguments()));
        } else if (kotlinType instanceof StubTypeForBuilderInference) {
            sb2.append(((StubTypeForBuilderInference) kotlinType).getOriginalTypeVariable().toString());
        } else if (simpleType instanceof StubTypeForBuilderInference) {
            sb2.append(((StubTypeForBuilderInference) simpleType).getOriginalTypeVariable().toString());
        } else {
            b(this, sb2, kotlinType, (TypeConstructor) null, 2, (Object) null);
        }
        if (kotlinType.isMarkedNullable()) {
            sb2.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
        }
        if (SpecialTypesKt.isDefinitelyNotNullType(kotlinType)) {
            sb2.append(" & Any");
        }
    }

    private final String renderError(String str) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i11 == 1) {
            return str;
        }
        if (i11 == 2) {
            return "<font color=red><b>" + str + "</b></font>";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String renderForReceiver(KotlinType kotlinType) {
        String renderType = renderType(kotlinType);
        if (!shouldRenderAsPrettyFunctionType(kotlinType) || TypeUtils.isNullableType(kotlinType)) {
            return renderType;
        }
        return '(' + renderType + ')';
    }

    /* access modifiers changed from: private */
    public final void renderFunction(FunctionDescriptor functionDescriptor, StringBuilder sb2) {
        String str;
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                a(this, sb2, functionDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
                List<ReceiverParameterDescriptor> contextReceiverParameters = functionDescriptor.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "function.contextReceiverParameters");
                renderContextReceivers(contextReceiverParameters, sb2);
                DescriptorVisibility visibility = functionDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "function.visibility");
                renderVisibility(visibility, sb2);
                renderModalityForCallable(functionDescriptor, sb2);
                if (getIncludeAdditionalModifiers()) {
                    renderMemberModifiers(functionDescriptor, sb2);
                }
                renderOverride(functionDescriptor, sb2);
                if (getIncludeAdditionalModifiers()) {
                    renderAdditionalModifiers(functionDescriptor, sb2);
                } else {
                    renderSuspendModifier(functionDescriptor, sb2);
                }
                renderMemberKind(functionDescriptor, sb2);
                if (getVerbose()) {
                    if (functionDescriptor.isHiddenToOvercomeSignatureClash()) {
                        sb2.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb2.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb2.append(renderKeyword("fun"));
            sb2.append(" ");
            List<TypeParameterDescriptor> typeParameters = functionDescriptor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "function.typeParameters");
            renderTypeParameters(typeParameters, sb2, true);
            renderReceiver(functionDescriptor, sb2);
        }
        renderName(functionDescriptor, sb2, true);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "function.valueParameters");
        renderValueParameters(valueParameters, functionDescriptor.hasSynthesizedParameterNames(), sb2);
        renderReceiverAfterName(functionDescriptor, sb2);
        KotlinType returnType = functionDescriptor.getReturnType();
        if (!getWithoutReturnType() && (getUnitReturnType() || returnType == null || !KotlinBuiltIns.isUnit(returnType))) {
            sb2.append(": ");
            if (returnType == null) {
                str = "[NULL]";
            } else {
                str = renderType(returnType);
            }
            sb2.append(str);
        }
        List<TypeParameterDescriptor> typeParameters2 = functionDescriptor.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "function.typeParameters");
        renderWhereSuffix(typeParameters2, sb2);
    }

    private final void renderFunctionType(StringBuilder sb2, KotlinType kotlinType) {
        boolean z11;
        boolean z12;
        Name name2;
        boolean z13;
        int length = sb2.length();
        a(getFunctionTypeAnnotationsRenderer(), sb2, kotlinType, (AnnotationUseSiteTarget) null, 2, (Object) null);
        if (sb2.length() != length) {
            z11 = true;
        } else {
            z11 = false;
        }
        KotlinType receiverTypeFromFunctionType = FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        List<KotlinType> contextReceiverTypesFromFunctionType = FunctionTypesKt.getContextReceiverTypesFromFunctionType(kotlinType);
        if (!contextReceiverTypesFromFunctionType.isEmpty()) {
            sb2.append("context(");
            for (KotlinType renderNormalizedType : contextReceiverTypesFromFunctionType.subList(0, CollectionsKt__CollectionsKt.getLastIndex(contextReceiverTypesFromFunctionType))) {
                renderNormalizedType(sb2, renderNormalizedType);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            renderNormalizedType(sb2, (KotlinType) CollectionsKt___CollectionsKt.last(contextReceiverTypesFromFunctionType));
            sb2.append(") ");
        }
        boolean isSuspendFunctionType = FunctionTypesKt.isSuspendFunctionType(kotlinType);
        boolean isMarkedNullable = kotlinType.isMarkedNullable();
        if (isMarkedNullable || (z11 && receiverTypeFromFunctionType != null)) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            if (isSuspendFunctionType) {
                sb2.insert(length, '(');
            } else {
                if (z11) {
                    boolean unused = CharsKt__CharJVMKt.isWhitespace(StringsKt___StringsKt.last(sb2));
                    if (sb2.charAt(StringsKt__StringsKt.getLastIndex(sb2) - 1) != ')') {
                        sb2.insert(StringsKt__StringsKt.getLastIndex(sb2), "()");
                    }
                }
                sb2.append("(");
            }
        }
        renderModifier(sb2, isSuspendFunctionType, "suspend");
        if (receiverTypeFromFunctionType != null) {
            if ((!shouldRenderAsPrettyFunctionType(receiverTypeFromFunctionType) || receiverTypeFromFunctionType.isMarkedNullable()) && !hasModifiersOrAnnotations(receiverTypeFromFunctionType)) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13) {
                sb2.append("(");
            }
            renderNormalizedType(sb2, receiverTypeFromFunctionType);
            if (z13) {
                sb2.append(")");
            }
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        }
        sb2.append("(");
        if (!FunctionTypesKt.isBuiltinExtensionFunctionalType(kotlinType) || kotlinType.getArguments().size() > 1) {
            int i11 = 0;
            for (TypeProjection next : FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType)) {
                int i12 = i11 + 1;
                if (i11 > 0) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                if (getParameterNamesInFunctionalTypes()) {
                    KotlinType type = next.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "typeProjection.type");
                    name2 = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type);
                } else {
                    name2 = null;
                }
                if (name2 != null) {
                    sb2.append(renderName(name2, false));
                    sb2.append(": ");
                }
                sb2.append(renderTypeProjection(next));
                i11 = i12;
            }
        } else {
            sb2.append("???");
        }
        sb2.append(") ");
        sb2.append(arrow());
        sb2.append(" ");
        renderNormalizedType(sb2, FunctionTypesKt.getReturnTypeFromFunctionType(kotlinType));
        if (z12) {
            sb2.append(")");
        }
        if (isMarkedNullable) {
            sb2.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
        }
    }

    private final void renderInitializer(VariableDescriptor variableDescriptor, StringBuilder sb2) {
        ConstantValue<?> compileTimeInitializer;
        if (getIncludePropertyConstant() && (compileTimeInitializer = variableDescriptor.getCompileTimeInitializer()) != null) {
            sb2.append(" = ");
            sb2.append(escape(renderConstant(compileTimeInitializer)));
        }
    }

    private final String renderKeyword(String str) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i11 == 1) {
            return str;
        }
        if (i11 != 2) {
            throw new NoWhenBranchMatchedException();
        } else if (getBoldOnlyForNamesInHtml()) {
            return str;
        } else {
            return "<b>" + str + "</b>";
        }
    }

    private final void renderMemberKind(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb2) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) && getVerbose() && callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb2.append("/*");
            sb2.append(CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(callableMemberDescriptor.getKind().name()));
            sb2.append("*/ ");
        }
    }

    private final void renderMemberModifiers(MemberDescriptor memberDescriptor, StringBuilder sb2) {
        boolean z11;
        renderModifier(sb2, memberDescriptor.isExternal(), "external");
        boolean z12 = true;
        if (!getModifiers().contains(DescriptorRendererModifier.EXPECT) || !memberDescriptor.isExpect()) {
            z11 = false;
        } else {
            z11 = true;
        }
        renderModifier(sb2, z11, "expect");
        if (!getModifiers().contains(DescriptorRendererModifier.ACTUAL) || !memberDescriptor.isActual()) {
            z12 = false;
        }
        renderModifier(sb2, z12, "actual");
    }

    private final void renderModality(Modality modality, StringBuilder sb2, Modality modality2) {
        if (getRenderDefaultModality() || modality != modality2) {
            renderModifier(sb2, getModifiers().contains(DescriptorRendererModifier.MODALITY), CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(modality.name()));
        }
    }

    private final void renderModalityForCallable(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb2) {
        if (DescriptorUtils.isTopLevelDeclaration(callableMemberDescriptor) && callableMemberDescriptor.getModality() == Modality.FINAL) {
            return;
        }
        if (getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OVERRIDE || callableMemberDescriptor.getModality() != Modality.OPEN || !overridesSomething(callableMemberDescriptor)) {
            Modality modality = callableMemberDescriptor.getModality();
            Intrinsics.checkNotNullExpressionValue(modality, "callable.modality");
            renderModality(modality, sb2, implicitModalityWithoutExtensions(callableMemberDescriptor));
        }
    }

    private final void renderModifier(StringBuilder sb2, boolean z11, String str) {
        if (z11) {
            sb2.append(renderKeyword(str));
            sb2.append(" ");
        }
    }

    private final void renderNormalizedType(StringBuilder sb2, KotlinType kotlinType) {
        AbbreviatedType abbreviatedType;
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof AbbreviatedType) {
            abbreviatedType = (AbbreviatedType) unwrap;
        } else {
            abbreviatedType = null;
        }
        if (abbreviatedType == null) {
            renderNormalizedTypeAsIs(sb2, kotlinType);
        } else if (getRenderTypeExpansions()) {
            renderNormalizedTypeAsIs(sb2, abbreviatedType.getExpandedType());
        } else {
            renderNormalizedTypeAsIs(sb2, abbreviatedType.getAbbreviation());
            if (getRenderUnabbreviatedType()) {
                renderAbbreviatedTypeExpansion(sb2, abbreviatedType);
            }
        }
    }

    private final void renderNormalizedTypeAsIs(StringBuilder sb2, KotlinType kotlinType) {
        if (!(kotlinType instanceof WrappedType) || !getDebugMode() || ((WrappedType) kotlinType).isComputed()) {
            UnwrappedType unwrap = kotlinType.unwrap();
            if (unwrap instanceof FlexibleType) {
                sb2.append(((FlexibleType) unwrap).render(this, this));
            } else if (unwrap instanceof SimpleType) {
                renderSimpleType(sb2, (SimpleType) unwrap);
            }
        } else {
            sb2.append("<Not computed yet>");
        }
    }

    private final void renderOverride(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb2) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) && overridesSomething(callableMemberDescriptor) && getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OPEN) {
            renderModifier(sb2, true, "override");
            if (getVerbose()) {
                sb2.append("/*");
                sb2.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                sb2.append("*/ ");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void renderPackageFragment(PackageFragmentDescriptor packageFragmentDescriptor, StringBuilder sb2) {
        renderPackageHeader(packageFragmentDescriptor.getFqName(), "package-fragment", sb2);
        if (getDebugMode()) {
            sb2.append(" in ");
            renderName(packageFragmentDescriptor.getContainingDeclaration(), sb2, false);
        }
    }

    private final void renderPackageHeader(FqName fqName, String str, StringBuilder sb2) {
        boolean z11;
        sb2.append(renderKeyword(str));
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "fqName.toUnsafe()");
        String renderFqName = renderFqName(unsafe);
        if (renderFqName.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            sb2.append(" ");
            sb2.append(renderFqName);
        }
    }

    /* access modifiers changed from: private */
    public final void renderPackageView(PackageViewDescriptor packageViewDescriptor, StringBuilder sb2) {
        renderPackageHeader(packageViewDescriptor.getFqName(), "package", sb2);
        if (getDebugMode()) {
            sb2.append(" in context of ");
            renderName(packageViewDescriptor.getModule(), sb2, false);
        }
    }

    private final void renderPossiblyInnerType(StringBuilder sb2, PossiblyInnerType possiblyInnerType) {
        PossiblyInnerType outerType = possiblyInnerType.getOuterType();
        if (outerType != null) {
            renderPossiblyInnerType(sb2, outerType);
            sb2.append('.');
            Name name2 = possiblyInnerType.getClassifierDescriptor().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "possiblyInnerType.classifierDescriptor.name");
            sb2.append(renderName(name2, false));
        } else {
            TypeConstructor typeConstructor = possiblyInnerType.getClassifierDescriptor().getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "possiblyInnerType.classi…escriptor.typeConstructor");
            sb2.append(renderTypeConstructor(typeConstructor));
        }
        sb2.append(renderTypeArguments(possiblyInnerType.getArguments()));
    }

    /* access modifiers changed from: private */
    public final void renderProperty(PropertyDescriptor propertyDescriptor, StringBuilder sb2) {
        boolean z11;
        if (!getStartFromName()) {
            if (!getStartFromDeclarationKeyword()) {
                renderPropertyAnnotations(propertyDescriptor, sb2);
                List<ReceiverParameterDescriptor> contextReceiverParameters = propertyDescriptor.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "property.contextReceiverParameters");
                renderContextReceivers(contextReceiverParameters, sb2);
                DescriptorVisibility visibility = propertyDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "property.visibility");
                renderVisibility(visibility, sb2);
                boolean z12 = false;
                if (!getModifiers().contains(DescriptorRendererModifier.CONST) || !propertyDescriptor.isConst()) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                renderModifier(sb2, z11, "const");
                renderMemberModifiers(propertyDescriptor, sb2);
                renderModalityForCallable(propertyDescriptor, sb2);
                renderOverride(propertyDescriptor, sb2);
                if (getModifiers().contains(DescriptorRendererModifier.LATEINIT) && propertyDescriptor.isLateInit()) {
                    z12 = true;
                }
                renderModifier(sb2, z12, "lateinit");
                renderMemberKind(propertyDescriptor, sb2);
            }
            c(this, propertyDescriptor, sb2, false, 4, (Object) null);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "property.typeParameters");
            renderTypeParameters(typeParameters, sb2, true);
            renderReceiver(propertyDescriptor, sb2);
        }
        renderName(propertyDescriptor, sb2, true);
        sb2.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "property.type");
        sb2.append(renderType(type));
        renderReceiverAfterName(propertyDescriptor, sb2);
        renderInitializer(propertyDescriptor, sb2);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "property.typeParameters");
        renderWhereSuffix(typeParameters2, sb2);
    }

    private final void renderPropertyAnnotations(PropertyDescriptor propertyDescriptor, StringBuilder sb2) {
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            a(this, sb2, propertyDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
            FieldDescriptor backingField = propertyDescriptor.getBackingField();
            if (backingField != null) {
                renderAnnotations(sb2, backingField, AnnotationUseSiteTarget.FIELD);
            }
            FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
            if (delegateField != null) {
                renderAnnotations(sb2, delegateField, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (getPropertyAccessorRenderingPolicy() == PropertyAccessorRenderingPolicy.NONE) {
                PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
                if (getter != null) {
                    renderAnnotations(sb2, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                }
                PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                if (setter != null) {
                    renderAnnotations(sb2, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                    List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                    Intrinsics.checkNotNullExpressionValue(valueParameters, "setter.valueParameters");
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt___CollectionsKt.single(valueParameters);
                    Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "it");
                    renderAnnotations(sb2, valueParameterDescriptor, AnnotationUseSiteTarget.SETTER_PARAMETER);
                }
            }
        }
    }

    private final void renderReceiver(CallableDescriptor callableDescriptor, StringBuilder sb2) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            renderAnnotations(sb2, extensionReceiverParameter, AnnotationUseSiteTarget.RECEIVER);
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
            sb2.append(renderForReceiver(type));
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        }
    }

    private final void renderReceiverAfterName(CallableDescriptor callableDescriptor, StringBuilder sb2) {
        ReceiverParameterDescriptor extensionReceiverParameter;
        if (getReceiverAfterName() && (extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter()) != null) {
            sb2.append(" on ");
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
            sb2.append(renderType(type));
        }
    }

    private final void renderSimpleType(StringBuilder sb2, SimpleType simpleType) {
        if (Intrinsics.areEqual((Object) simpleType, (Object) TypeUtils.CANNOT_INFER_FUNCTION_PARAM_TYPE) || TypeUtils.isDontCarePlaceholder(simpleType)) {
            sb2.append("???");
        } else if (ErrorUtils.isUninferredTypeVariable(simpleType)) {
            if (getUninferredTypeParameterAsName()) {
                TypeConstructor constructor = simpleType.getConstructor();
                Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                sb2.append(renderError(((ErrorTypeConstructor) constructor).getParam(0)));
                return;
            }
            sb2.append("???");
        } else if (KotlinTypeKt.isError(simpleType)) {
            renderDefaultType(sb2, simpleType);
        } else if (shouldRenderAsPrettyFunctionType(simpleType)) {
            renderFunctionType(sb2, simpleType);
        } else {
            renderDefaultType(sb2, simpleType);
        }
    }

    private final void renderSpaceIfNeeded(StringBuilder sb2) {
        int length = sb2.length();
        if (length == 0 || sb2.charAt(length - 1) != ' ') {
            sb2.append(' ');
        }
    }

    private final void renderSuperTypes(ClassDescriptor classDescriptor, StringBuilder sb2) {
        if (!getWithoutSuperTypes() && !KotlinBuiltIns.isNothing(classDescriptor.getDefaultType())) {
            Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
            Intrinsics.checkNotNullExpressionValue(supertypes, "klass.typeConstructor.supertypes");
            if (supertypes.isEmpty()) {
                return;
            }
            if (supertypes.size() != 1 || !KotlinBuiltIns.isAnyOrNullableAny(supertypes.iterator().next())) {
                renderSpaceIfNeeded(sb2);
                sb2.append(": ");
                Appendable unused = CollectionsKt___CollectionsKt.joinTo$default(supertypes, sb2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new DescriptorRendererImpl$renderSuperTypes$1(this), 60, (Object) null);
            }
        }
    }

    private final void renderSuspendModifier(FunctionDescriptor functionDescriptor, StringBuilder sb2) {
        renderModifier(sb2, functionDescriptor.isSuspend(), "suspend");
    }

    /* access modifiers changed from: private */
    public final void renderTypeAlias(TypeAliasDescriptor typeAliasDescriptor, StringBuilder sb2) {
        a(this, sb2, typeAliasDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
        DescriptorVisibility visibility = typeAliasDescriptor.getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "typeAlias.visibility");
        renderVisibility(visibility, sb2);
        renderMemberModifiers(typeAliasDescriptor, sb2);
        sb2.append(renderKeyword("typealias"));
        sb2.append(" ");
        renderName(typeAliasDescriptor, sb2, true);
        List<TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "typeAlias.declaredTypeParameters");
        renderTypeParameters(declaredTypeParameters, sb2, false);
        renderCapturedTypeParametersIfRequired(typeAliasDescriptor, sb2);
        sb2.append(" = ");
        sb2.append(renderType(typeAliasDescriptor.getUnderlyingType()));
    }

    private final void renderTypeConstructorAndArguments(StringBuilder sb2, KotlinType kotlinType, TypeConstructor typeConstructor) {
        PossiblyInnerType buildPossiblyInnerType = TypeParameterUtilsKt.buildPossiblyInnerType(kotlinType);
        if (buildPossiblyInnerType == null) {
            sb2.append(renderTypeConstructor(typeConstructor));
            sb2.append(renderTypeArguments(kotlinType.getArguments()));
            return;
        }
        renderPossiblyInnerType(sb2, buildPossiblyInnerType);
    }

    /* access modifiers changed from: private */
    public final void renderTypeParameter(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb2, boolean z11) {
        boolean z12;
        if (z11) {
            sb2.append(lt());
        }
        if (getVerbose()) {
            sb2.append("/*");
            sb2.append(typeParameterDescriptor.getIndex());
            sb2.append("*/ ");
        }
        renderModifier(sb2, typeParameterDescriptor.isReified(), "reified");
        String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z13 = true;
        if (label.length() > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        renderModifier(sb2, z12, label);
        a(this, sb2, typeParameterDescriptor, (AnnotationUseSiteTarget) null, 2, (Object) null);
        renderName(typeParameterDescriptor, sb2, z11);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z11) || size == 1) {
            KotlinType next = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (!KotlinBuiltIns.isDefaultBound(next)) {
                sb2.append(" : ");
                Intrinsics.checkNotNullExpressionValue(next, "upperBound");
                sb2.append(renderType(next));
            }
        } else if (z11) {
            for (KotlinType next2 : typeParameterDescriptor.getUpperBounds()) {
                if (!KotlinBuiltIns.isDefaultBound(next2)) {
                    if (z13) {
                        sb2.append(" : ");
                    } else {
                        sb2.append(" & ");
                    }
                    Intrinsics.checkNotNullExpressionValue(next2, "upperBound");
                    sb2.append(renderType(next2));
                    z13 = false;
                }
            }
        }
        if (z11) {
            sb2.append(gt());
        }
    }

    private final void renderTypeParameterList(StringBuilder sb2, List<? extends TypeParameterDescriptor> list) {
        Iterator<? extends TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            renderTypeParameter((TypeParameterDescriptor) it.next(), sb2, false);
            if (it.hasNext()) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
    }

    private final void renderTypeParameters(List<? extends TypeParameterDescriptor> list, StringBuilder sb2, boolean z11) {
        if (!getWithoutTypeParameters() && (!list.isEmpty())) {
            sb2.append(lt());
            renderTypeParameterList(sb2, list);
            sb2.append(gt());
            if (z11) {
                sb2.append(" ");
            }
        }
    }

    private final void renderValVarPrefix(VariableDescriptor variableDescriptor, StringBuilder sb2, boolean z11) {
        String str;
        if (z11 || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            if (variableDescriptor.isVar()) {
                str = "var";
            } else {
                str = "val";
            }
            sb2.append(renderKeyword(str));
            sb2.append(" ");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008e, code lost:
        if (r11 != false) goto L_0x0092;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void renderValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r10, boolean r11, java.lang.StringBuilder r12, boolean r13) {
        /*
            r9 = this;
            if (r13 == 0) goto L_0x0010
            java.lang.String r0 = "value-parameter"
            java.lang.String r0 = r9.renderKeyword(r0)
            r12.append(r0)
            java.lang.String r0 = " "
            r12.append(r0)
        L_0x0010:
            boolean r0 = r9.getVerbose()
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = "/*"
            r12.append(r0)
            int r0 = r10.getIndex()
            r12.append(r0)
            java.lang.String r0 = "*/ "
            r12.append(r0)
        L_0x0027:
            r4 = 0
            r5 = 2
            r6 = 0
            r1 = r9
            r2 = r12
            r3 = r10
            a(r1, r2, r3, r4, r5, r6)
            boolean r0 = r10.isCrossinline()
            java.lang.String r1 = "crossinline"
            r9.renderModifier(r12, r0, r1)
            boolean r0 = r10.isNoinline()
            java.lang.String r1 = "noinline"
            r9.renderModifier(r12, r0, r1)
            boolean r0 = r9.getRenderPrimaryConstructorParametersAsProperties()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0065
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r0 = r10.getContainingDeclaration()
            boolean r3 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor
            if (r3 == 0) goto L_0x0055
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r0
            goto L_0x0056
        L_0x0055:
            r0 = 0
        L_0x0056:
            if (r0 == 0) goto L_0x0060
            boolean r0 = r0.isPrimary()
            if (r0 != r1) goto L_0x0060
            r0 = r1
            goto L_0x0061
        L_0x0060:
            r0 = r2
        L_0x0061:
            if (r0 == 0) goto L_0x0065
            r8 = r1
            goto L_0x0066
        L_0x0065:
            r8 = r2
        L_0x0066:
            if (r8 == 0) goto L_0x0071
            boolean r0 = r9.getActualPropertiesInPrimaryConstructor()
            java.lang.String r3 = "actual"
            r9.renderModifier(r12, r0, r3)
        L_0x0071:
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r3.renderVariable(r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function1 r11 = r9.getDefaultParameterValueRenderer()
            if (r11 == 0) goto L_0x0091
            boolean r11 = r9.getDebugMode()
            if (r11 == 0) goto L_0x008a
            boolean r11 = r10.declaresDefaultValue()
            goto L_0x008e
        L_0x008a:
            boolean r11 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(r10)
        L_0x008e:
            if (r11 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0091:
            r1 = r2
        L_0x0092:
            if (r1 == 0) goto L_0x00b5
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = " = "
            r11.append(r13)
            kotlin.jvm.functions.Function1 r13 = r9.getDefaultParameterValueRenderer()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            java.lang.Object r10 = r13.invoke(r10)
            java.lang.String r10 = (java.lang.String) r10
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r12.append(r10)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, boolean, java.lang.StringBuilder, boolean):void");
    }

    private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> collection, boolean z11, StringBuilder sb2) {
        boolean shouldRenderParameterNames = shouldRenderParameterNames(z11);
        int size = collection.size();
        getValueParametersHandler().appendBeforeValueParameters(size, sb2);
        int i11 = 0;
        for (ValueParameterDescriptor valueParameterDescriptor : collection) {
            getValueParametersHandler().appendBeforeValueParameter(valueParameterDescriptor, i11, size, sb2);
            renderValueParameter(valueParameterDescriptor, shouldRenderParameterNames, sb2, false);
            getValueParametersHandler().appendAfterValueParameter(valueParameterDescriptor, i11, size, sb2);
            i11++;
        }
        getValueParametersHandler().appendAfterValueParameters(size, sb2);
    }

    private final void renderVariable(VariableDescriptor variableDescriptor, boolean z11, StringBuilder sb2, boolean z12, boolean z13) {
        ValueParameterDescriptor valueParameterDescriptor;
        KotlinType kotlinType;
        boolean z14;
        KotlinType type = variableDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "variable.type");
        KotlinType kotlinType2 = null;
        if (variableDescriptor instanceof ValueParameterDescriptor) {
            valueParameterDescriptor = (ValueParameterDescriptor) variableDescriptor;
        } else {
            valueParameterDescriptor = null;
        }
        if (valueParameterDescriptor != null) {
            kotlinType2 = valueParameterDescriptor.getVarargElementType();
        }
        if (kotlinType2 == null) {
            kotlinType = type;
        } else {
            kotlinType = kotlinType2;
        }
        if (kotlinType2 != null) {
            z14 = true;
        } else {
            z14 = false;
        }
        renderModifier(sb2, z14, "vararg");
        if (z13 || (z12 && !getStartFromName())) {
            renderValVarPrefix(variableDescriptor, sb2, z13);
        }
        if (z11) {
            renderName(variableDescriptor, sb2, z12);
            sb2.append(": ");
        }
        sb2.append(renderType(kotlinType));
        renderInitializer(variableDescriptor, sb2);
        if (getVerbose() && kotlinType2 != null) {
            sb2.append(" /*");
            sb2.append(renderType(type));
            sb2.append("*/");
        }
    }

    private final boolean renderVisibility(DescriptorVisibility descriptorVisibility, StringBuilder sb2) {
        if (!getModifiers().contains(DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        if (getNormalizedVisibilities()) {
            descriptorVisibility = descriptorVisibility.normalize();
        }
        if (!getRenderDefaultVisibility() && Intrinsics.areEqual((Object) descriptorVisibility, (Object) DescriptorVisibilities.DEFAULT_VISIBILITY)) {
            return false;
        }
        sb2.append(renderKeyword(descriptorVisibility.getInternalDisplayName()));
        sb2.append(" ");
        return true;
    }

    private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> list, StringBuilder sb2) {
        if (!getWithoutTypeParameters()) {
            ArrayList arrayList = new ArrayList(0);
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
                for (KotlinType kotlinType : CollectionsKt___CollectionsKt.drop(upperBounds, 1)) {
                    StringBuilder sb3 = new StringBuilder();
                    Name name2 = typeParameterDescriptor.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "typeParameter.name");
                    sb3.append(renderName(name2, false));
                    sb3.append(" : ");
                    Intrinsics.checkNotNullExpressionValue(kotlinType, "it");
                    sb3.append(renderType(kotlinType));
                    arrayList.add(sb3.toString());
                }
            }
            if (!arrayList.isEmpty()) {
                sb2.append(" ");
                sb2.append(renderKeyword("where"));
                sb2.append(" ");
                Appendable unused = CollectionsKt___CollectionsKt.joinTo$default(arrayList, sb2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null);
            }
        }
    }

    private final String replacePrefixes(String str, String str2, String str3, String str4, String str5) {
        if (StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, (Object) null) && StringsKt__StringsJVMKt.startsWith$default(str3, str4, false, 2, (Object) null)) {
            String substring = str.substring(str2.length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            String substring2 = str3.substring(str4.length());
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            String str6 = str5 + substring;
            if (Intrinsics.areEqual((Object) substring, (Object) substring2)) {
                return str6;
            }
            if (differsOnlyInNullability(substring, substring2)) {
                return str6 + '!';
            }
        }
        return null;
    }

    private final boolean shouldRenderAsPrettyFunctionType(KotlinType kotlinType) {
        boolean z11;
        if (!FunctionTypesKt.isBuiltinFunctionalType(kotlinType)) {
            return false;
        }
        Iterable arguments = kotlinType.getArguments();
        if (!(arguments instanceof Collection) || !((Collection) arguments).isEmpty()) {
            Iterator it = arguments.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((TypeProjection) it.next()).isStarProjection()) {
                        z11 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z11 = true;
        if (z11) {
            return true;
        }
        return false;
    }

    private final boolean shouldRenderParameterNames(boolean z11) {
        int i11 = WhenMappings.$EnumSwitchMapping$1[getParameterNameRenderingPolicy().ordinal()];
        if (i11 == 1) {
            return true;
        }
        if (i11 != 2) {
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!z11) {
            return true;
        }
        return false;
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.options.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.options.getAlwaysRenderModifiers();
    }

    @NotNull
    public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.options.getAnnotationArgumentsRenderingPolicy();
    }

    @Nullable
    public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter() {
        return this.options.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.options.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.options.getClassWithPrimaryConstructor();
    }

    @NotNull
    public ClassifierNamePolicy getClassifierNamePolicy() {
        return this.options.getClassifierNamePolicy();
    }

    public boolean getDebugMode() {
        return this.options.getDebugMode();
    }

    @Nullable
    public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer() {
        return this.options.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.options.getEachAnnotationOnNewLine();
    }

    public boolean getEnhancedTypes() {
        return this.options.getEnhancedTypes();
    }

    @NotNull
    public Set<FqName> getExcludedAnnotationClasses() {
        return this.options.getExcludedAnnotationClasses();
    }

    @NotNull
    public Set<FqName> getExcludedTypeAnnotationClasses() {
        return this.options.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.options.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.options.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.options.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.options.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.options.getInformativeErrorType();
    }

    @NotNull
    public Set<DescriptorRendererModifier> getModifiers() {
        return this.options.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.options.getNormalizedVisibilities();
    }

    @NotNull
    public final DescriptorRendererOptionsImpl getOptions() {
        return this.options;
    }

    @NotNull
    public OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.options.getOverrideRenderingPolicy();
    }

    @NotNull
    public ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.options.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.options.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.options.getPresentableUnresolvedTypes();
    }

    @NotNull
    public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return this.options.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.options.getReceiverAfterName();
    }

    public boolean getRenderCompanionObjectName() {
        return this.options.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.options.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.options.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.options.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.options.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.options.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.options.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.options.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.options.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.options.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.options.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.options.getStartFromName();
    }

    @NotNull
    public RenderingFormat getTextFormat() {
        return this.options.getTextFormat();
    }

    @NotNull
    public Function1<KotlinType, KotlinType> getTypeNormalizer() {
        return this.options.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.options.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.options.getUnitReturnType();
    }

    @NotNull
    public DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.options.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.options.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.options.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.options.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.options.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.options.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.options.getWithoutTypeParameters();
    }

    @NotNull
    public String render(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb2 = new StringBuilder();
        declarationDescriptor.accept(new RenderDeclarationDescriptorVisitor(), sb2);
        if (getWithDefinedIn()) {
            appendDefinedIn(sb2, declarationDescriptor);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public String renderAnnotation(@NotNull AnnotationDescriptor annotationDescriptor, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "annotation");
        StringBuilder sb2 = new StringBuilder();
        sb2.append('@');
        if (annotationUseSiteTarget != null) {
            sb2.append(annotationUseSiteTarget.getRenderName() + AbstractJsonLexerKt.COLON);
        }
        KotlinType type = annotationDescriptor.getType();
        sb2.append(renderType(type));
        if (getIncludeAnnotationArguments()) {
            List<String> renderAndSortAnnotationArguments = renderAndSortAnnotationArguments(annotationDescriptor);
            if (getIncludeEmptyAnnotationArguments() || (!renderAndSortAnnotationArguments.isEmpty())) {
                Appendable unused = CollectionsKt___CollectionsKt.joinTo$default(renderAndSortAnnotationArguments, sb2, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, "(", ")", 0, (CharSequence) null, (Function1) null, 112, (Object) null);
            }
        }
        if (getVerbose() && (KotlinTypeKt.isError(type) || (type.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor))) {
            sb2.append(" /* annotation class not found */");
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public String renderClassifierName(@NotNull ClassifierDescriptor classifierDescriptor) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, "klass");
        if (ErrorUtils.isError(classifierDescriptor)) {
            return classifierDescriptor.getTypeConstructor().toString();
        }
        return getClassifierNamePolicy().renderClassifier(classifierDescriptor, this);
    }

    @NotNull
    public String renderFlexibleType(@NotNull String str, @NotNull String str2, @NotNull KotlinBuiltIns kotlinBuiltIns) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "lowerRendered");
        Intrinsics.checkNotNullParameter(str4, "upperRendered");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (!differsOnlyInNullability(str, str2)) {
            ClassifierNamePolicy classifierNamePolicy = getClassifierNamePolicy();
            ClassDescriptor collection = kotlinBuiltIns.getCollection();
            Intrinsics.checkNotNullExpressionValue(collection, "builtIns.collection");
            String substringBefore$default = StringsKt__StringsKt.substringBefore$default(classifierNamePolicy.renderClassifier(collection, this), "Collection", (String) null, 2, (Object) null);
            String replacePrefixes = replacePrefixes(str, substringBefore$default + "Mutable", str2, substringBefore$default, substringBefore$default + '(' + "Mutable" + ')');
            if (replacePrefixes != null) {
                return replacePrefixes;
            }
            String replacePrefixes2 = replacePrefixes(str, substringBefore$default + "MutableMap.MutableEntry", str2, substringBefore$default + "Map.Entry", substringBefore$default + "(Mutable)Map.(Mutable)Entry");
            if (replacePrefixes2 != null) {
                return replacePrefixes2;
            }
            ClassifierNamePolicy classifierNamePolicy2 = getClassifierNamePolicy();
            ClassDescriptor array = kotlinBuiltIns.getArray();
            Intrinsics.checkNotNullExpressionValue(array, "builtIns.array");
            String substringBefore$default2 = StringsKt__StringsKt.substringBefore$default(classifierNamePolicy2.renderClassifier(array, this), "Array", (String) null, 2, (Object) null);
            String replacePrefixes3 = replacePrefixes(str, substringBefore$default2 + escape("Array<"), str2, substringBefore$default2 + escape("Array<out "), substringBefore$default2 + escape("Array<(out) "));
            if (replacePrefixes3 != null) {
                return replacePrefixes3;
            }
            return '(' + str3 + ".." + str4 + ')';
        } else if (StringsKt__StringsJVMKt.startsWith$default(str4, "(", false, 2, (Object) null)) {
            return '(' + str3 + ")!";
        } else {
            return str3 + '!';
        }
    }

    @NotNull
    public String renderFqName(@NotNull FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "fqName");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "fqName.pathSegments()");
        return renderFqName(pathSegments);
    }

    @NotNull
    public String renderMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        int i11 = WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i11 == 1) {
            return str;
        }
        if (i11 == 2) {
            return "<i>" + str + "</i>";
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public String renderName(@NotNull Name name2, boolean z11) {
        Intrinsics.checkNotNullParameter(name2, "name");
        String escape = escape(RenderingUtilsKt.render(name2));
        if (!getBoldOnlyForNamesInHtml() || getTextFormat() != RenderingFormat.HTML || !z11) {
            return escape;
        }
        return "<b>" + escape + "</b>";
    }

    @NotNull
    public String renderType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        StringBuilder sb2 = new StringBuilder();
        renderNormalizedType(sb2, getTypeNormalizer().invoke(kotlinType));
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public String renderTypeArguments(@NotNull List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(lt());
        appendTypeProjections(sb2, list);
        sb2.append(gt());
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @NotNull
    public String renderTypeConstructor(@NotNull TypeConstructor typeConstructor) {
        boolean z11;
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        boolean z12 = true;
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            z11 = true;
        } else {
            z11 = declarationDescriptor instanceof ClassDescriptor;
        }
        if (!z11) {
            z12 = declarationDescriptor instanceof TypeAliasDescriptor;
        }
        if (z12) {
            return renderClassifierName(declarationDescriptor);
        }
        if (declarationDescriptor != null) {
            throw new IllegalStateException(("Unexpected classifier: " + declarationDescriptor.getClass()).toString());
        } else if (typeConstructor instanceof IntersectionTypeConstructor) {
            return ((IntersectionTypeConstructor) typeConstructor).makeDebugNameForIntersectionType(DescriptorRendererImpl$renderTypeConstructor$1.INSTANCE);
        } else {
            return typeConstructor.toString();
        }
    }

    @NotNull
    public String renderTypeProjection(@NotNull TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        StringBuilder sb2 = new StringBuilder();
        appendTypeProjections(sb2, CollectionsKt__CollectionsJVMKt.listOf(typeProjection));
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        this.options.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.options.setClassifierNamePolicy(classifierNamePolicy);
    }

    public void setDebugMode(boolean z11) {
        this.options.setDebugMode(z11);
    }

    public void setExcludedTypeAnnotationClasses(@NotNull Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setExcludedTypeAnnotationClasses(set);
    }

    public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setModifiers(set);
    }

    public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.options.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    public void setReceiverAfterName(boolean z11) {
        this.options.setReceiverAfterName(z11);
    }

    public void setRenderCompanionObjectName(boolean z11) {
        this.options.setRenderCompanionObjectName(z11);
    }

    public void setStartFromName(boolean z11) {
        this.options.setStartFromName(z11);
    }

    public void setTextFormat(@NotNull RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        this.options.setTextFormat(renderingFormat);
    }

    public void setVerbose(boolean z11) {
        this.options.setVerbose(z11);
    }

    public void setWithDefinedIn(boolean z11) {
        this.options.setWithDefinedIn(z11);
    }

    public void setWithoutSuperTypes(boolean z11) {
        this.options.setWithoutSuperTypes(z11);
    }

    public void setWithoutTypeParameters(boolean z11) {
        this.options.setWithoutTypeParameters(z11);
    }

    private final String renderFqName(List<Name> list) {
        return escape(RenderingUtilsKt.renderFqName(list));
    }

    /* access modifiers changed from: private */
    public final void renderName(DeclarationDescriptor declarationDescriptor, StringBuilder sb2, boolean z11) {
        Name name2 = declarationDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "descriptor.name");
        sb2.append(renderName(name2, z11));
    }
}
