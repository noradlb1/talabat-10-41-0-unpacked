package net.bytebuddy.utility;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

public interface JavaConstant {

    /* renamed from: net.bytebuddy.utility.JavaConstant$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27495a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType[] r0 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27495a = r0
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType r1 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.GET_FIELD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f27495a     // Catch:{ NoSuchFieldError -> 0x001d }
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType r1 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.GET_STATIC_FIELD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f27495a     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType r1 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.PUT_FIELD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f27495a     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType r1 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.PUT_STATIC_FIELD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.JavaConstant.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Dynamic implements JavaConstant {
        public static final String DEFAULT_NAME = "_";
        private final List<JavaConstant> arguments;
        private final MethodHandle bootstrap;

        /* renamed from: name  reason: collision with root package name */
        private final String f27496name;
        private final TypeDescription typeDescription;

        public Dynamic(String str, TypeDescription typeDescription2, MethodHandle methodHandle, List<JavaConstant> list) {
            this.f27496name = str;
            this.typeDescription = typeDescription2;
            this.bootstrap = methodHandle;
            this.arguments = list;
        }

        public static Dynamic bootstrap(String str, Method method, Object... objArr) {
            return bootstrap(str, method, (List<?>) Arrays.asList(objArr));
        }

        public static JavaConstant ofArrayVarHandle(Class<?> cls) {
            return ofArrayVarHandle(TypeDescription.ForLoadedType.of(cls));
        }

        public static JavaConstant ofEnumeration(Enum<?> enumR) {
            return ofEnumeration((EnumerationDescription) new EnumerationDescription.ForLoadedEnumeration(enumR));
        }

        public static Dynamic ofField(Field field) {
            return ofField((FieldDescription.InDefinedShape) new FieldDescription.ForLoadedField(field));
        }

        public static Dynamic ofInvocation(Method method, Object... objArr) {
            return ofInvocation(method, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic ofNullConstant() {
            TypeDescription typeDescription2 = TypeDescription.OBJECT;
            return new Dynamic(DEFAULT_NAME, typeDescription2, new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "nullConstant", typeDescription2, Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, TypeDescription.CLASS})), Collections.emptyList());
        }

        public static JavaConstant ofPrimitiveType(Class<?> cls) {
            return ofPrimitiveType(TypeDescription.ForLoadedType.of(cls));
        }

        public static JavaConstant ofVarHandle(Field field) {
            return ofVarHandle((FieldDescription.InDefinedShape) new FieldDescription.ForLoadedField(field));
        }

        public <T> T accept(Visitor<T> visitor) {
            return visitor.onDynamic(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Dynamic dynamic = (Dynamic) obj;
            if (this.f27496name.equals(dynamic.f27496name) && this.typeDescription.equals(dynamic.typeDescription) && this.bootstrap.equals(dynamic.bootstrap)) {
                return this.arguments.equals(dynamic.arguments);
            }
            return false;
        }

        public List<JavaConstant> getArguments() {
            return this.arguments;
        }

        public MethodHandle getBootstrap() {
            return this.bootstrap;
        }

        public String getName() {
            return this.f27496name;
        }

        public TypeDescription getTypeDescription() {
            return this.typeDescription;
        }

        public int hashCode() {
            return (((((this.f27496name.hashCode() * 31) + this.typeDescription.hashCode()) * 31) + this.bootstrap.hashCode()) * 31) + this.arguments.hashCode();
        }

        public Object toDescription() {
            Object[] array = Simple.f27502b.toArray(this.arguments.size());
            for (int i11 = 0; i11 < array.length; i11++) {
                array[i11] = this.arguments.get(i11).toDescription();
            }
            Simple.Dispatcher.OfDynamicConstantDesc ofDynamicConstantDesc = Simple.f27508h;
            Simple.Dispatcher.OfMethodHandleDesc ofMethodHandleDesc = Simple.f27505e;
            Object valueOf = Simple.f27507g.valueOf(this.bootstrap.getHandleType().getIdentifier(), this.bootstrap.getOwnerType().isInterface());
            Simple.Dispatcher.OfClassDesc ofClassDesc = Simple.f27503c;
            return ofDynamicConstantDesc.ofCanonical(ofMethodHandleDesc.of(valueOf, ofClassDesc.ofDescriptor(this.bootstrap.getOwnerType().getDescriptor()), this.bootstrap.getName(), this.bootstrap.getDescriptor()), getName(), ofClassDesc.ofDescriptor(this.typeDescription.getDescriptor()), array);
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.bootstrap.getOwnerType().getSimpleName());
            sb2.append("::");
            sb2.append(this.bootstrap.getName());
            sb2.append('(');
            if (this.f27496name.equals(DEFAULT_NAME)) {
                str = "";
            } else {
                str = this.f27496name;
            }
            sb2.append(str);
            sb2.append('/');
            boolean z11 = true;
            for (JavaConstant next : this.arguments) {
                if (z11) {
                    z11 = false;
                } else {
                    sb2.append(AbstractJsonLexerKt.COMMA);
                }
                sb2.append(next.toString());
            }
            sb2.append(')');
            sb2.append(this.typeDescription.getSimpleName());
            return sb2.toString();
        }

        public JavaConstant withType(Class<?> cls) {
            return withType(TypeDescription.ForLoadedType.of(cls));
        }

        public static Dynamic bootstrap(String str, Method method, List<?> list) {
            return bootstrap(str, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), list);
        }

        public static JavaConstant ofArrayVarHandle(TypeDescription typeDescription2) {
            if (typeDescription2.isArray()) {
                JavaType javaType = JavaType.VAR_HANDLE;
                TypeDescription typeStub = javaType.getTypeStub();
                MethodHandle.HandleType handleType = MethodHandle.HandleType.INVOKE_STATIC;
                TypeDescription typeStub2 = JavaType.CONSTANT_BOOTSTRAPS.getTypeStub();
                TypeDescription typeStub3 = javaType.getTypeStub();
                TypeDescription typeDescription3 = TypeDescription.CLASS;
                return new Dynamic(DEFAULT_NAME, typeStub, new MethodHandle(handleType, typeStub2, "arrayVarHandle", typeStub3, Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, typeDescription3, typeDescription3})), Collections.singletonList(Simple.of(typeDescription2)));
            }
            throw new IllegalArgumentException("Not an array type: " + typeDescription2);
        }

        public static JavaConstant ofEnumeration(EnumerationDescription enumerationDescription) {
            return new Dynamic(enumerationDescription.getValue(), enumerationDescription.getEnumerationType(), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "enumConstant", TypeDescription.ForLoadedType.of(Enum.class), Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, TypeDescription.CLASS})), Collections.emptyList());
        }

        public static Dynamic ofField(FieldDescription.InDefinedShape inDefinedShape) {
            boolean z11;
            List list;
            List list2;
            if (!inDefinedShape.isStatic() || !inDefinedShape.isFinal()) {
                throw new IllegalArgumentException("Field must be static and final: " + inDefinedShape);
            }
            if (inDefinedShape.getType().isPrimitive()) {
                z11 = inDefinedShape.getType().asErasure().asBoxed().equals(inDefinedShape.getType().asErasure());
            } else {
                z11 = inDefinedShape.getDeclaringType().equals(inDefinedShape.getType().asErasure());
            }
            String internalName = inDefinedShape.getInternalName();
            TypeDescription asErasure = inDefinedShape.getType().asErasure();
            MethodHandle.HandleType handleType = MethodHandle.HandleType.INVOKE_STATIC;
            TypeDescription typeStub = JavaType.CONSTANT_BOOTSTRAPS.getTypeStub();
            TypeDescription typeDescription2 = TypeDescription.OBJECT;
            if (z11) {
                list = Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, TypeDescription.CLASS});
            } else {
                TypeDescription typeDescription3 = TypeDescription.CLASS;
                list = Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, typeDescription3, typeDescription3});
            }
            MethodHandle methodHandle = new MethodHandle(handleType, typeStub, "getStaticFinal", typeDescription2, list);
            if (z11) {
                list2 = Collections.emptyList();
            } else {
                list2 = Collections.singletonList(Simple.of(inDefinedShape.getDeclaringType()));
            }
            return new Dynamic(internalName, asErasure, methodHandle, list2);
        }

        public static Dynamic ofInvocation(Method method, List<?> list) {
            return ofInvocation((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), list);
        }

        public static JavaConstant ofPrimitiveType(TypeDescription typeDescription2) {
            if (typeDescription2.isPrimitive()) {
                String descriptor = typeDescription2.getDescriptor();
                TypeDescription typeDescription3 = TypeDescription.CLASS;
                return new Dynamic(descriptor, typeDescription3, new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "primitiveClass", typeDescription3, Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, typeDescription3})), Collections.emptyList());
            }
            throw new IllegalArgumentException("Not a primitive type: " + typeDescription2);
        }

        public static JavaConstant ofVarHandle(FieldDescription.InDefinedShape inDefinedShape) {
            String internalName = inDefinedShape.getInternalName();
            JavaType javaType = JavaType.VAR_HANDLE;
            TypeDescription typeStub = javaType.getTypeStub();
            MethodHandle.HandleType handleType = MethodHandle.HandleType.INVOKE_STATIC;
            TypeDescription typeStub2 = JavaType.CONSTANT_BOOTSTRAPS.getTypeStub();
            String str = inDefinedShape.isStatic() ? "staticFieldVarHandle" : "fieldVarHandle";
            TypeDescription typeStub3 = javaType.getTypeStub();
            TypeDescription typeDescription2 = TypeDescription.CLASS;
            return new Dynamic(internalName, typeStub, new MethodHandle(handleType, typeStub2, str, typeStub3, Arrays.asList(new TypeDescription[]{JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, typeDescription2, typeDescription2, typeDescription2})), Arrays.asList(new JavaConstant[]{Simple.of(inDefinedShape.getDeclaringType()), Simple.of(inDefinedShape.getType().asErasure())}));
        }

        public JavaConstant withType(TypeDescription typeDescription2) {
            if (typeDescription2.represents(Void.TYPE)) {
                throw new IllegalArgumentException("Constant value cannot represent void");
            } else if (!getBootstrap().getName().equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME) ? typeDescription2.asBoxed().isInHierarchyWith(getTypeDescription().asBoxed()) : getTypeDescription().isAssignableTo(typeDescription2)) {
                return new Dynamic(getName(), typeDescription2, getBootstrap(), getArguments());
            } else {
                throw new IllegalArgumentException(typeDescription2 + " is not compatible with bootstrapped type " + getTypeDescription());
            }
        }

        public static Dynamic bootstrap(String str, Constructor<?> constructor, Object... objArr) {
            return bootstrap(str, constructor, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic ofInvocation(Constructor<?> constructor, Object... objArr) {
            return ofInvocation(constructor, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic bootstrap(String str, Constructor<?> constructor, List<?> list) {
            return bootstrap(str, (MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), list);
        }

        public static Dynamic ofInvocation(Constructor<?> constructor, List<?> list) {
            return ofInvocation((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor), list);
        }

        public static Dynamic bootstrap(String str, MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
            return bootstrap(str, inDefinedShape, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic ofInvocation(MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
            return ofInvocation(inDefinedShape, (List<?>) Arrays.asList(objArr));
        }

        public static Dynamic bootstrap(String str, MethodDescription.InDefinedShape inDefinedShape, List<?> list) {
            TypeDescription typeDescription2;
            TypeDescription typeDescription3;
            if (str.length() == 0 || str.contains(RealDiscoveryConfigurationRepository.VERSION_DELIMETER)) {
                throw new IllegalArgumentException("Not a valid field name: " + str);
            }
            ArrayList arrayList = new ArrayList(list.size());
            ArrayList arrayList2 = new ArrayList(list.size());
            for (Object wrap : list) {
                JavaConstant wrap2 = Simple.wrap((Object) wrap);
                arrayList.add(wrap2);
                arrayList2.add(wrap2.getTypeDescription());
            }
            if (inDefinedShape.isConstantBootstrap(arrayList2)) {
                if (inDefinedShape.isConstructor()) {
                    typeDescription2 = inDefinedShape.getDeclaringType();
                } else {
                    typeDescription2 = inDefinedShape.getReturnType().asErasure();
                }
                MethodHandle.HandleType handleType = inDefinedShape.isConstructor() ? MethodHandle.HandleType.INVOKE_SPECIAL_CONSTRUCTOR : MethodHandle.HandleType.INVOKE_STATIC;
                if (inDefinedShape.isConstructor()) {
                    typeDescription3 = inDefinedShape.getDeclaringType();
                } else {
                    typeDescription3 = inDefinedShape.getReturnType().asErasure();
                }
                return new Dynamic(str, typeDescription2, new MethodHandle(handleType, typeDescription3, inDefinedShape.getInternalName(), inDefinedShape.getReturnType().asErasure(), inDefinedShape.getParameters().asTypeList().asErasures()), arrayList);
            }
            throw new IllegalArgumentException("Not a valid bootstrap method " + inDefinedShape + " for " + arrayList);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
            if ((r12.getParameters().size() + ((r12.isStatic() || r12.isConstructor()) ? 0 : 1)) <= (r13.size() + 1)) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0074, code lost:
            if ((r12.getParameters().size() + ((r12.isStatic() || r12.isConstructor()) ? 0 : 1)) == r13.size()) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x019e, code lost:
            throw new java.lang.IllegalArgumentException("Cannot assign " + r13 + " to " + r12);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static net.bytebuddy.utility.JavaConstant.Dynamic ofInvocation(net.bytebuddy.description.method.MethodDescription.InDefinedShape r12, java.util.List<?> r13) {
            /*
                boolean r0 = r12.isConstructor()
                if (r0 != 0) goto L_0x002a
                net.bytebuddy.description.type.TypeDescription$Generic r0 = r12.getReturnType()
                java.lang.Class r1 = java.lang.Void.TYPE
                boolean r0 = r0.represents(r1)
                if (r0 != 0) goto L_0x0013
                goto L_0x002a
            L_0x0013:
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Bootstrap method is no constructor or non-void static factory: "
                r0.append(r1)
                r0.append(r12)
                java.lang.String r12 = r0.toString()
                r13.<init>(r12)
                throw r13
            L_0x002a:
                boolean r0 = r12.isVarArgs()
                java.lang.String r1 = " to "
                java.lang.String r2 = "Cannot assign "
                r3 = 0
                r4 = 1
                if (r0 == 0) goto L_0x0057
                net.bytebuddy.description.method.ParameterList r0 = r12.getParameters()
                int r0 = r0.size()
                boolean r5 = r12.isStatic()
                if (r5 != 0) goto L_0x004d
                boolean r5 = r12.isConstructor()
                if (r5 == 0) goto L_0x004b
                goto L_0x004d
            L_0x004b:
                r5 = r4
                goto L_0x004e
            L_0x004d:
                r5 = r3
            L_0x004e:
                int r0 = r0 + r5
                int r5 = r13.size()
                int r5 = r5 + r4
                if (r0 > r5) goto L_0x0184
                goto L_0x0076
            L_0x0057:
                net.bytebuddy.description.method.ParameterList r0 = r12.getParameters()
                int r0 = r0.size()
                boolean r5 = r12.isStatic()
                if (r5 != 0) goto L_0x006e
                boolean r5 = r12.isConstructor()
                if (r5 == 0) goto L_0x006c
                goto L_0x006e
            L_0x006c:
                r5 = r4
                goto L_0x006f
            L_0x006e:
                r5 = r3
            L_0x006f:
                int r0 = r0 + r5
                int r5 = r13.size()
                if (r0 != r5) goto L_0x0184
            L_0x0076:
                boolean r0 = r12.isStatic()
                if (r0 != 0) goto L_0x0098
                boolean r0 = r12.isConstructor()
                if (r0 == 0) goto L_0x0083
                goto L_0x0098
            L_0x0083:
                net.bytebuddy.description.type.TypeDescription r0 = r12.getDeclaringType()
                net.bytebuddy.description.method.ParameterList r5 = r12.getParameters()
                net.bytebuddy.description.type.TypeList$Generic r5 = r5.asTypeList()
                net.bytebuddy.description.type.TypeList r5 = r5.asErasures()
                java.util.List r0 = net.bytebuddy.utility.CompoundList.of(r0, r5)
                goto L_0x00a4
            L_0x0098:
                net.bytebuddy.description.method.ParameterList r0 = r12.getParameters()
                net.bytebuddy.description.type.TypeList$Generic r0 = r0.asTypeList()
                net.bytebuddy.description.type.TypeList r0 = r0.asErasures()
            L_0x00a4:
                boolean r5 = r12.isVarArgs()
                if (r5 == 0) goto L_0x00d9
                int r5 = r0.size()
                int r5 = r5 - r4
                java.util.List r5 = r0.subList(r3, r5)
                int r6 = r13.size()
                int r7 = r0.size()
                int r6 = r6 - r7
                int r6 = r6 + r4
                int r7 = r0.size()
                int r7 = r7 - r4
                java.lang.Object r0 = r0.get(r7)
                net.bytebuddy.description.type.TypeDescription r0 = (net.bytebuddy.description.type.TypeDescription) r0
                net.bytebuddy.description.type.TypeDescription r0 = r0.getComponentType()
                java.util.List r0 = java.util.Collections.nCopies(r6, r0)
                java.util.List r0 = net.bytebuddy.utility.CompoundList.of(r5, r0)
                java.util.Iterator r0 = r0.iterator()
                goto L_0x00dd
            L_0x00d9:
                java.util.Iterator r0 = r0.iterator()
            L_0x00dd:
                java.util.ArrayList r5 = new java.util.ArrayList
                int r6 = r13.size()
                int r6 = r6 + r4
                r5.<init>(r6)
                net.bytebuddy.utility.JavaConstant$MethodHandle r6 = net.bytebuddy.utility.JavaConstant.MethodHandle.of((net.bytebuddy.description.method.MethodDescription.InDefinedShape) r12)
                r5.add(r6)
                java.util.Iterator r6 = r13.iterator()
            L_0x00f2:
                boolean r7 = r6.hasNext()
                if (r7 == 0) goto L_0x012f
                java.lang.Object r7 = r6.next()
                net.bytebuddy.utility.JavaConstant r7 = net.bytebuddy.utility.JavaConstant.Simple.wrap((java.lang.Object) r7)
                net.bytebuddy.description.type.TypeDescription r8 = r7.getTypeDescription()
                java.lang.Object r9 = r0.next()
                net.bytebuddy.description.type.TypeDescription r9 = (net.bytebuddy.description.type.TypeDescription) r9
                boolean r8 = r8.isAssignableTo((net.bytebuddy.description.type.TypeDescription) r9)
                if (r8 == 0) goto L_0x0114
                r5.add(r7)
                goto L_0x00f2
            L_0x0114:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                r3.append(r13)
                r3.append(r1)
                r3.append(r12)
                java.lang.String r12 = r3.toString()
                r0.<init>(r12)
                throw r0
            L_0x012f:
                net.bytebuddy.utility.JavaConstant$Dynamic r13 = new net.bytebuddy.utility.JavaConstant$Dynamic
                boolean r0 = r12.isConstructor()
                if (r0 == 0) goto L_0x013c
                net.bytebuddy.description.type.TypeDescription r12 = r12.getDeclaringType()
                goto L_0x0144
            L_0x013c:
                net.bytebuddy.description.type.TypeDescription$Generic r12 = r12.getReturnType()
                net.bytebuddy.description.type.TypeDescription r12 = r12.asErasure()
            L_0x0144:
                net.bytebuddy.utility.JavaConstant$MethodHandle r0 = new net.bytebuddy.utility.JavaConstant$MethodHandle
                net.bytebuddy.utility.JavaConstant$MethodHandle$HandleType r7 = net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.INVOKE_STATIC
                net.bytebuddy.utility.JavaType r1 = net.bytebuddy.utility.JavaType.CONSTANT_BOOTSTRAPS
                net.bytebuddy.description.type.TypeDescription r8 = r1.getTypeStub()
                java.lang.String r9 = "invoke"
                net.bytebuddy.description.type.TypeDescription r10 = net.bytebuddy.description.type.TypeDescription.OBJECT
                r1 = 5
                net.bytebuddy.description.type.TypeDescription[] r1 = new net.bytebuddy.description.type.TypeDescription[r1]
                net.bytebuddy.utility.JavaType r2 = net.bytebuddy.utility.JavaType.METHOD_HANDLES_LOOKUP
                net.bytebuddy.description.type.TypeDescription r2 = r2.getTypeStub()
                r1[r3] = r2
                net.bytebuddy.description.type.TypeDescription r2 = net.bytebuddy.description.type.TypeDescription.STRING
                r1[r4] = r2
                r2 = 2
                net.bytebuddy.description.type.TypeDescription r3 = net.bytebuddy.description.type.TypeDescription.CLASS
                r1[r2] = r3
                net.bytebuddy.utility.JavaType r2 = net.bytebuddy.utility.JavaType.METHOD_HANDLE
                net.bytebuddy.description.type.TypeDescription r2 = r2.getTypeStub()
                r3 = 3
                r1[r3] = r2
                r2 = 4
                net.bytebuddy.description.type.TypeDescription r3 = net.bytebuddy.description.type.TypeDescription.ArrayProjection.of(r10)
                r1[r2] = r3
                java.util.List r11 = java.util.Arrays.asList(r1)
                r6 = r0
                r6.<init>(r7, r8, r9, r10, r11)
                java.lang.String r1 = "_"
                r13.<init>(r1, r12, r0, r5)
                return r13
            L_0x0184:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                r3.append(r13)
                r3.append(r1)
                r3.append(r12)
                java.lang.String r12 = r3.toString()
                r0.<init>(r12)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.JavaConstant.Dynamic.ofInvocation(net.bytebuddy.description.method.MethodDescription$InDefinedShape, java.util.List):net.bytebuddy.utility.JavaConstant$Dynamic");
        }
    }

    public static class MethodHandle implements JavaConstant {
        private static final boolean ACCESS_CONTROLLER;

        /* renamed from: a  reason: collision with root package name */
        public static final MethodHandleInfo f27497a = ((MethodHandleInfo) doPrivileged(JavaDispatcher.of(MethodHandleInfo.class)));

        /* renamed from: b  reason: collision with root package name */
        public static final MethodType f27498b = ((MethodType) doPrivileged(JavaDispatcher.of(MethodType.class)));

        /* renamed from: c  reason: collision with root package name */
        public static final MethodHandles f27499c = ((MethodHandles) doPrivileged(JavaDispatcher.of(MethodHandles.class)));

        /* renamed from: d  reason: collision with root package name */
        public static final MethodHandles.Lookup f27500d = ((MethodHandles.Lookup) doPrivileged(JavaDispatcher.of(MethodHandles.Lookup.class)));
        private final HandleType handleType;

        /* renamed from: name  reason: collision with root package name */
        private final String f27501name;
        private final TypeDescription ownerType;
        private final List<? extends TypeDescription> parameterTypes;
        private final TypeDescription returnType;

        public enum HandleType {
            INVOKE_VIRTUAL(5, false),
            INVOKE_STATIC(6, false),
            INVOKE_SPECIAL(7, false),
            INVOKE_INTERFACE(9, false),
            INVOKE_SPECIAL_CONSTRUCTOR(8, false),
            PUT_FIELD(3, true),
            GET_FIELD(1, true),
            PUT_STATIC_FIELD(4, true),
            GET_STATIC_FIELD(2, true);
            
            private final boolean field;
            private final int identifier;

            private HandleType(int i11, boolean z11) {
                this.identifier = i11;
                this.field = z11;
            }

            public static HandleType a(int i11) {
                for (HandleType handleType : values()) {
                    if (handleType.getIdentifier() == i11) {
                        return handleType;
                    }
                }
                throw new IllegalArgumentException("Unknown handle type: " + i11);
            }

            public static HandleType b(MethodDescription.InDefinedShape inDefinedShape) {
                if (inDefinedShape.isTypeInitializer()) {
                    throw new IllegalArgumentException("Cannot create handle of type initializer " + inDefinedShape);
                } else if (inDefinedShape.isStatic()) {
                    return INVOKE_STATIC;
                } else {
                    if (inDefinedShape.isConstructor()) {
                        return INVOKE_SPECIAL_CONSTRUCTOR;
                    }
                    if (inDefinedShape.isPrivate()) {
                        return INVOKE_SPECIAL;
                    }
                    if (inDefinedShape.getDeclaringType().isInterface()) {
                        return INVOKE_INTERFACE;
                    }
                    return INVOKE_VIRTUAL;
                }
            }

            public static HandleType c(FieldDescription.InDefinedShape inDefinedShape) {
                return inDefinedShape.isStatic() ? GET_STATIC_FIELD : GET_FIELD;
            }

            public static HandleType d(FieldDescription.InDefinedShape inDefinedShape) {
                return inDefinedShape.isStatic() ? PUT_STATIC_FIELD : PUT_FIELD;
            }

            public static HandleType e(MethodDescription.InDefinedShape inDefinedShape) {
                if (inDefinedShape.isStatic() || inDefinedShape.isAbstract()) {
                    throw new IllegalArgumentException("Cannot invoke " + inDefinedShape + " via invokespecial");
                } else if (inDefinedShape.isConstructor()) {
                    return INVOKE_SPECIAL_CONSTRUCTOR;
                } else {
                    return INVOKE_SPECIAL;
                }
            }

            public int getIdentifier() {
                return this.identifier;
            }

            public boolean isField() {
                return this.field;
            }
        }

        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandleInfo")
        public interface MethodHandleInfo {
            @JavaDispatcher.Proxied("getDeclaringClass")
            Class<?> getDeclaringClass(Object obj);

            @JavaDispatcher.Proxied("getMethodType")
            Object getMethodType(Object obj);

            @JavaDispatcher.Proxied("getName")
            String getName(Object obj);

            @JavaDispatcher.Proxied("getReferenceKind")
            int getReferenceKind(Object obj);

            @JavaDispatcher.Proxied("revealDirect")
            @JavaDispatcher.IsConstructor
            Object revealDirect(@JavaDispatcher.Proxied("java.lang.invoke.MethodHandle") Object obj);
        }

        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles")
        public interface MethodHandles {

            @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup")
            public interface Lookup {
                @JavaDispatcher.Proxied("lookupClass")
                Class<?> lookupClass(Object obj);

                @JavaDispatcher.Proxied("revealDirect")
                Object revealDirect(Object obj, @JavaDispatcher.Proxied("java.lang.invoke.MethodHandle") Object obj2);
            }

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("publicLookup")
            Object publicLookup();
        }

        @JavaDispatcher.Proxied("java.lang.invoke.MethodType")
        public interface MethodType {
            @JavaDispatcher.Proxied("parameterArray")
            Class<?>[] parameterArray(Object obj);

            @JavaDispatcher.Proxied("returnType")
            Class<?> returnType(Object obj);
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

        public MethodHandle(HandleType handleType2, TypeDescription typeDescription, String str, TypeDescription typeDescription2, List<? extends TypeDescription> list) {
            this.handleType = handleType2;
            this.ownerType = typeDescription;
            this.f27501name = str;
            this.returnType = typeDescription2;
            this.parameterTypes = list;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        public static Class<?> lookupType(Object obj) {
            return f27500d.lookupClass(obj);
        }

        public static MethodHandle of(Method method) {
            return of((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method));
        }

        public static MethodHandle ofGetter(Field field) {
            return ofGetter((FieldDescription.InDefinedShape) new FieldDescription.ForLoadedField(field));
        }

        public static MethodHandle ofLoaded(Object obj) {
            return ofLoaded(obj, f27499c.publicLookup());
        }

        public static MethodHandle ofSetter(Field field) {
            return ofSetter((FieldDescription.InDefinedShape) new FieldDescription.ForLoadedField(field));
        }

        public static MethodHandle ofSpecial(Method method, Class<?> cls) {
            return ofSpecial((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls));
        }

        public <T> T accept(Visitor<T> visitor) {
            return visitor.onMethodHandle(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodHandle)) {
                return false;
            }
            MethodHandle methodHandle = (MethodHandle) obj;
            if (this.handleType != methodHandle.handleType || !this.f27501name.equals(methodHandle.f27501name) || !this.ownerType.equals(methodHandle.ownerType) || !this.parameterTypes.equals(methodHandle.parameterTypes) || !this.returnType.equals(methodHandle.returnType)) {
                return false;
            }
            return true;
        }

        public String getDescriptor() {
            int i11 = AnonymousClass1.f27495a[this.handleType.ordinal()];
            if (i11 == 1 || i11 == 2) {
                return this.returnType.getDescriptor();
            }
            if (i11 == 3 || i11 == 4) {
                return ((TypeDescription) this.parameterTypes.get(0)).getDescriptor();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append('(');
            for (TypeDescription descriptor : this.parameterTypes) {
                sb2.append(descriptor.getDescriptor());
            }
            sb2.append(')');
            sb2.append(this.returnType.getDescriptor());
            return sb2.toString();
        }

        public HandleType getHandleType() {
            return this.handleType;
        }

        public String getName() {
            return this.f27501name;
        }

        public TypeDescription getOwnerType() {
            return this.ownerType;
        }

        public TypeList getParameterTypes() {
            return new TypeList.Explicit(this.parameterTypes);
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        public TypeDescription getTypeDescription() {
            return JavaType.METHOD_HANDLE.getTypeStub();
        }

        public int hashCode() {
            return (((((((this.handleType.hashCode() * 31) + this.ownerType.hashCode()) * 31) + this.f27501name.hashCode()) * 31) + this.returnType.hashCode()) * 31) + this.parameterTypes.hashCode();
        }

        public Object toDescription() {
            return Simple.f27505e.of(Simple.f27507g.valueOf(this.handleType.getIdentifier(), this.ownerType.isInterface()), Simple.f27503c.ofDescriptor(this.ownerType.getDescriptor()), this.f27501name, getDescriptor());
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.handleType.name());
            if (!this.ownerType.isInterface() || this.handleType.isField() || this.handleType == HandleType.INVOKE_INTERFACE) {
                str = "";
            } else {
                str = "@interface";
            }
            sb2.append(str);
            sb2.append('/');
            sb2.append(this.ownerType.getSimpleName());
            sb2.append("::");
            sb2.append(this.f27501name);
            sb2.append('(');
            boolean z11 = true;
            for (TypeDescription typeDescription : this.parameterTypes) {
                if (z11) {
                    z11 = false;
                } else {
                    sb2.append(AbstractJsonLexerKt.COMMA);
                }
                sb2.append(typeDescription.getSimpleName());
            }
            sb2.append(')');
            sb2.append(this.returnType.getSimpleName());
            return sb2.toString();
        }

        public static MethodHandle of(Constructor<?> constructor) {
            return of((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor));
        }

        public static MethodHandle ofGetter(FieldDescription.InDefinedShape inDefinedShape) {
            return new MethodHandle(HandleType.c(inDefinedShape), inDefinedShape.getDeclaringType().asErasure(), inDefinedShape.getInternalName(), inDefinedShape.getType().asErasure(), Collections.emptyList());
        }

        public static MethodHandle ofLoaded(Object obj, Object obj2) {
            Object obj3;
            if (!JavaType.METHOD_HANDLE.isInstance(obj)) {
                throw new IllegalArgumentException("Expected method handle object: " + obj);
            } else if (JavaType.METHOD_HANDLES_LOOKUP.isInstance(obj2)) {
                if (ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V8).isAtMost(ClassFileVersion.JAVA_V7)) {
                    obj3 = f27497a.revealDirect(obj);
                } else {
                    obj3 = f27500d.revealDirect(obj2, obj);
                }
                MethodHandleInfo methodHandleInfo = f27497a;
                Object methodType = methodHandleInfo.getMethodType(obj3);
                HandleType a11 = HandleType.a(methodHandleInfo.getReferenceKind(obj3));
                TypeDescription of2 = TypeDescription.ForLoadedType.of(methodHandleInfo.getDeclaringClass(obj3));
                String name2 = methodHandleInfo.getName(obj3);
                MethodType methodType2 = f27498b;
                return new MethodHandle(a11, of2, name2, TypeDescription.ForLoadedType.of(methodType2.returnType(methodType)), new TypeList.ForLoadedTypes((Class<?>[]) methodType2.parameterArray(methodType)));
            } else {
                throw new IllegalArgumentException("Expected method handle lookup object: " + obj2);
            }
        }

        public static MethodHandle ofSetter(FieldDescription.InDefinedShape inDefinedShape) {
            return new MethodHandle(HandleType.d(inDefinedShape), inDefinedShape.getDeclaringType().asErasure(), inDefinedShape.getInternalName(), TypeDescription.VOID, Collections.singletonList(inDefinedShape.getType().asErasure()));
        }

        public static MethodHandle ofSpecial(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
            if (inDefinedShape.isSpecializableFor(typeDescription)) {
                return new MethodHandle(HandleType.e(inDefinedShape), typeDescription, inDefinedShape.getInternalName(), inDefinedShape.getReturnType().asErasure(), inDefinedShape.getParameters().asTypeList().asErasures());
            }
            throw new IllegalArgumentException("Cannot specialize " + inDefinedShape + " for " + typeDescription);
        }

        public static MethodHandle of(MethodDescription.InDefinedShape inDefinedShape) {
            return new MethodHandle(HandleType.b(inDefinedShape), inDefinedShape.getDeclaringType().asErasure(), inDefinedShape.getInternalName(), inDefinedShape.getReturnType().asErasure(), inDefinedShape.getParameters().asTypeList().asErasures());
        }
    }

    public static class MethodType implements JavaConstant {
        private static final boolean ACCESS_CONTROLLER;
        private static final Dispatcher DISPATCHER = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));
        private final List<? extends TypeDescription> parameterTypes;
        private final TypeDescription returnType;

        @JavaDispatcher.Proxied("java.lang.invoke.MethodType")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("parameterArray")
            Class<?>[] parameterArray(Object obj);

            @JavaDispatcher.Proxied("returnType")
            Class<?> returnType(Object obj);
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

        public MethodType(TypeDescription typeDescription, List<? extends TypeDescription> list) {
            this.returnType = typeDescription;
            this.parameterTypes = list;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        public static MethodType of(Class<?> cls, Class<?>... clsArr) {
            return of(TypeDescription.ForLoadedType.of(cls), (List<? extends TypeDescription>) new TypeList.ForLoadedTypes(clsArr));
        }

        public static MethodType ofConstant(Object obj) {
            return ofConstant(obj.getClass());
        }

        public static MethodType ofGetter(Field field) {
            return ofGetter((FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public static MethodType ofLoaded(Object obj) {
            if (JavaType.METHOD_TYPE.isInstance(obj)) {
                Dispatcher dispatcher = DISPATCHER;
                return of(dispatcher.returnType(obj), (Class<?>[]) dispatcher.parameterArray(obj));
            }
            throw new IllegalArgumentException("Expected method type object: " + obj);
        }

        public static MethodType ofSetter(Field field) {
            return ofSetter((FieldDescription) new FieldDescription.ForLoadedField(field));
        }

        public <T> T accept(Visitor<T> visitor) {
            return visitor.onMethodType(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodType)) {
                return false;
            }
            MethodType methodType = (MethodType) obj;
            if (!this.parameterTypes.equals(methodType.parameterTypes) || !this.returnType.equals(methodType.returnType)) {
                return false;
            }
            return true;
        }

        public String getDescriptor() {
            StringBuilder sb2 = new StringBuilder("(");
            for (TypeDescription descriptor : this.parameterTypes) {
                sb2.append(descriptor.getDescriptor());
            }
            sb2.append(')');
            sb2.append(this.returnType.getDescriptor());
            return sb2.toString();
        }

        public TypeList getParameterTypes() {
            return new TypeList.Explicit(this.parameterTypes);
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        public TypeDescription getTypeDescription() {
            return JavaType.METHOD_TYPE.getTypeStub();
        }

        public int hashCode() {
            return (this.returnType.hashCode() * 31) + this.parameterTypes.hashCode();
        }

        public Object toDescription() {
            Object[] array = Simple.f27503c.toArray(this.parameterTypes.size());
            for (int i11 = 0; i11 < this.parameterTypes.size(); i11++) {
                array[i11] = Simple.f27503c.ofDescriptor(((TypeDescription) this.parameterTypes.get(i11)).getDescriptor());
            }
            return Simple.f27504d.of(Simple.f27503c.ofDescriptor(this.returnType.getDescriptor()), array);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('(');
            boolean z11 = true;
            for (TypeDescription typeDescription : this.parameterTypes) {
                if (z11) {
                    z11 = false;
                } else {
                    sb2.append(AbstractJsonLexerKt.COMMA);
                }
                sb2.append(typeDescription.getSimpleName());
            }
            sb2.append(')');
            sb2.append(this.returnType.getSimpleName());
            return sb2.toString();
        }

        public static MethodType of(TypeDescription typeDescription, TypeDescription... typeDescriptionArr) {
            return new MethodType(typeDescription, Arrays.asList(typeDescriptionArr));
        }

        public static MethodType ofConstant(Class<?> cls) {
            return ofConstant(TypeDescription.ForLoadedType.of(cls));
        }

        public static MethodType ofGetter(FieldDescription fieldDescription) {
            return new MethodType(fieldDescription.getType().asErasure(), Collections.emptyList());
        }

        public static MethodType ofSetter(FieldDescription fieldDescription) {
            return new MethodType(TypeDescription.VOID, Collections.singletonList(fieldDescription.getType().asErasure()));
        }

        public static MethodType of(TypeDescription typeDescription, List<? extends TypeDescription> list) {
            return new MethodType(typeDescription, list);
        }

        public static MethodType ofConstant(TypeDescription typeDescription) {
            return new MethodType(typeDescription, Collections.emptyList());
        }

        public static MethodType of(Method method) {
            return of((MethodDescription) new MethodDescription.ForLoadedMethod(method));
        }

        public static MethodType of(Constructor<?> constructor) {
            return of((MethodDescription) new MethodDescription.ForLoadedConstructor(constructor));
        }

        public static MethodType of(MethodDescription methodDescription) {
            return new MethodType(methodDescription.getReturnType().asErasure(), methodDescription.getParameters().asTypeList().asErasures());
        }
    }

    public static abstract class Simple<T> implements JavaConstant {
        private static final boolean ACCESS_CONTROLLER;

        /* renamed from: b  reason: collision with root package name */
        public static final Dispatcher f27502b = ((Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class)));

        /* renamed from: c  reason: collision with root package name */
        public static final Dispatcher.OfClassDesc f27503c = ((Dispatcher.OfClassDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfClassDesc.class)));

        /* renamed from: d  reason: collision with root package name */
        public static final Dispatcher.OfMethodTypeDesc f27504d = ((Dispatcher.OfMethodTypeDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfMethodTypeDesc.class)));

        /* renamed from: e  reason: collision with root package name */
        public static final Dispatcher.OfMethodHandleDesc f27505e = ((Dispatcher.OfMethodHandleDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfMethodHandleDesc.class)));

        /* renamed from: f  reason: collision with root package name */
        public static final Dispatcher.OfDirectMethodHandleDesc f27506f = ((Dispatcher.OfDirectMethodHandleDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfDirectMethodHandleDesc.class)));

        /* renamed from: g  reason: collision with root package name */
        public static final Dispatcher.OfDirectMethodHandleDesc.ForKind f27507g = ((Dispatcher.OfDirectMethodHandleDesc.ForKind) doPrivileged(JavaDispatcher.of(Dispatcher.OfDirectMethodHandleDesc.ForKind.class)));

        /* renamed from: h  reason: collision with root package name */
        public static final Dispatcher.OfDynamicConstantDesc f27508h = ((Dispatcher.OfDynamicConstantDesc) doPrivileged(JavaDispatcher.of(Dispatcher.OfDynamicConstantDesc.class)));

        /* renamed from: a  reason: collision with root package name */
        public final T f27509a;
        private final TypeDescription typeDescription;

        @JavaDispatcher.Proxied("java.lang.constant.ConstantDesc")
        public interface Dispatcher {

            @JavaDispatcher.Proxied("java.lang.constant.ClassDesc")
            public interface OfClassDesc extends Dispatcher {
                @JavaDispatcher.Proxied("descriptorString")
                String descriptorString(Object obj);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("ofDescriptor")
                Object ofDescriptor(String str);
            }

            @JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc")
            public interface OfDirectMethodHandleDesc extends Dispatcher {

                @JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc$Kind")
                public interface ForKind {
                    @JavaDispatcher.IsStatic
                    @JavaDispatcher.Proxied("valueOf")
                    Object valueOf(int i11, boolean z11);
                }

                @JavaDispatcher.Proxied("lookupDescriptor")
                String lookupDescriptor(Object obj);

                @JavaDispatcher.Proxied("methodName")
                String methodName(Object obj);

                @JavaDispatcher.Proxied("owner")
                Object owner(Object obj);

                @JavaDispatcher.Proxied("refKind")
                int refKind(Object obj);
            }

            @JavaDispatcher.Proxied("java.lang.constant.DynamicConstantDesc")
            public interface OfDynamicConstantDesc extends Dispatcher {
                @JavaDispatcher.Proxied("bootstrapArgs")
                Object[] bootstrapArgs(Object obj);

                @JavaDispatcher.Proxied("bootstrapMethod")
                Object bootstrapMethod(Object obj);

                @JavaDispatcher.Proxied("constantName")
                String constantName(Object obj);

                @JavaDispatcher.Proxied("constantType")
                Object constantType(Object obj);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("ofCanonical")
                Object ofCanonical(@JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc") Object obj, String str, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj2, @JavaDispatcher.Proxied("java.lang.constant.ConstantDesc") Object[] objArr);
            }

            @JavaDispatcher.Proxied("java.lang.constant.MethodHandleDesc")
            public interface OfMethodHandleDesc extends Dispatcher {
                @JavaDispatcher.Proxied("invocationType")
                Object invocationType(Object obj);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("of")
                Object of(@JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc$Kind") Object obj, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj2, String str, String str2);
            }

            @JavaDispatcher.Proxied("java.lang.constant.MethodTypeDesc")
            public interface OfMethodTypeDesc extends Dispatcher {
                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("of")
                Object of(@JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object[] objArr);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Proxied("ofDescriptor")
                Object ofDescriptor(String str);

                @JavaDispatcher.Proxied("parameterArray")
                Object[] parameterArray(Object obj);

                @JavaDispatcher.Proxied("returnType")
                Object returnType(Object obj);
            }

            @JavaDispatcher.Proxied("isInstance")
            @JavaDispatcher.Instance
            boolean isInstance(Object obj);

            @JavaDispatcher.Container
            @JavaDispatcher.Proxied("toArray")
            Object[] toArray(int i11);
        }

        public static class OfTrivialValue<S> extends Simple<S> {
            public OfTrivialValue(S s11, TypeDescription typeDescription) {
                super(s11, typeDescription);
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onValue(this);
            }

            public Object toDescription() {
                return this.f27509a;
            }
        }

        public static class OfTypeDescription extends Simple<TypeDescription> {
            public OfTypeDescription(TypeDescription typeDescription) {
                super(typeDescription, TypeDescription.CLASS);
            }

            public <T> T accept(Visitor<T> visitor) {
                return visitor.onType(this);
            }

            public Object toDescription() {
                return Simple.f27503c.ofDescriptor(((TypeDescription) this.f27509a).getDescriptor());
            }
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

        public Simple(T t11, TypeDescription typeDescription2) {
            this.f27509a = t11;
            this.typeDescription = typeDescription2;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction);
            }
            return privilegedAction.run();
        }

        public static JavaConstant of(TypeDescription typeDescription2) {
            if (!typeDescription2.isPrimitive()) {
                return new OfTypeDescription(typeDescription2);
            }
            throw new IllegalArgumentException("A primitive type cannot be represented as a type constant: " + typeDescription2);
        }

        public static JavaConstant ofDescription(Object obj, ClassLoader classLoader) {
            return ofDescription(obj, ClassFileLocator.ForClassLoader.of(classLoader));
        }

        public static JavaConstant ofLoaded(Object obj) {
            if (obj instanceof Integer) {
                return new OfTrivialValue((Integer) obj, TypeDescription.ForLoadedType.of(Integer.TYPE));
            }
            if (obj instanceof Long) {
                return new OfTrivialValue((Long) obj, TypeDescription.ForLoadedType.of(Long.TYPE));
            }
            if (obj instanceof Float) {
                return new OfTrivialValue((Float) obj, TypeDescription.ForLoadedType.of(Float.TYPE));
            }
            if (obj instanceof Double) {
                return new OfTrivialValue((Double) obj, TypeDescription.ForLoadedType.of(Double.TYPE));
            }
            if (obj instanceof String) {
                return new OfTrivialValue((String) obj, TypeDescription.STRING);
            }
            if (obj instanceof Class) {
                return of(TypeDescription.ForLoadedType.of((Class) obj));
            }
            if (JavaType.METHOD_HANDLE.isInstance(obj)) {
                return MethodHandle.ofLoaded(obj);
            }
            if (JavaType.METHOD_TYPE.isInstance(obj)) {
                return MethodType.ofLoaded(obj);
            }
            throw new IllegalArgumentException("Not a loaded Java constant value: " + obj);
        }

        public static JavaConstant wrap(Object obj) {
            if (obj instanceof JavaConstant) {
                return (JavaConstant) obj;
            }
            if (obj instanceof TypeDescription) {
                return of((TypeDescription) obj);
            }
            return ofLoaded(obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f27509a.equals(((Simple) obj).f27509a);
        }

        public TypeDescription getTypeDescription() {
            return this.typeDescription;
        }

        public T getValue() {
            return this.f27509a;
        }

        public int hashCode() {
            return this.f27509a.hashCode();
        }

        public String toString() {
            return this.f27509a.toString();
        }

        public static JavaConstant ofDescription(Object obj, ClassFileLocator classFileLocator) {
            return ofDescription(obj, TypePool.Default.WithLazyResolution.of(classFileLocator));
        }

        public static JavaConstant ofDescription(Object obj, TypePool typePool) {
            String str;
            String str2;
            String str3;
            TypeDescription resolve;
            String str4;
            String str5;
            String str6;
            String str7;
            Object obj2 = obj;
            TypePool typePool2 = typePool;
            if (obj2 instanceof Integer) {
                return new OfTrivialValue((Integer) obj2, TypeDescription.ForLoadedType.of(Integer.TYPE));
            }
            if (obj2 instanceof Long) {
                return new OfTrivialValue((Long) obj2, TypeDescription.ForLoadedType.of(Long.TYPE));
            }
            if (obj2 instanceof Float) {
                return new OfTrivialValue((Float) obj2, TypeDescription.ForLoadedType.of(Float.TYPE));
            }
            if (obj2 instanceof Double) {
                return new OfTrivialValue((Double) obj2, TypeDescription.ForLoadedType.of(Double.TYPE));
            }
            if (obj2 instanceof String) {
                return new OfTrivialValue((String) obj2, TypeDescription.STRING);
            }
            Dispatcher.OfClassDesc ofClassDesc = f27503c;
            if (ofClassDesc.isInstance(obj2)) {
                Type type = Type.getType(ofClassDesc.descriptorString(obj2));
                if (type.getSort() == 9) {
                    str7 = type.getInternalName().replace('/', '.');
                } else {
                    str7 = type.getClassName();
                }
                return of(typePool2.describe(str7).resolve());
            }
            Dispatcher.OfMethodTypeDesc ofMethodTypeDesc = f27504d;
            int i11 = 0;
            if (ofMethodTypeDesc.isInstance(obj2)) {
                Object[] parameterArray = ofMethodTypeDesc.parameterArray(obj2);
                ArrayList arrayList = new ArrayList(parameterArray.length);
                int length = parameterArray.length;
                while (i11 < length) {
                    Type type2 = Type.getType(f27503c.descriptorString(parameterArray[i11]));
                    if (type2.getSort() == 9) {
                        str6 = type2.getInternalName().replace('/', '.');
                    } else {
                        str6 = type2.getClassName();
                    }
                    arrayList.add(typePool2.describe(str6).resolve());
                    i11++;
                }
                Type type3 = Type.getType(f27503c.descriptorString(f27504d.returnType(obj2)));
                if (type3.getSort() == 9) {
                    str5 = type3.getInternalName().replace('/', '.');
                } else {
                    str5 = type3.getClassName();
                }
                return MethodType.of(typePool2.describe(str5).resolve(), (List<? extends TypeDescription>) arrayList);
            }
            Dispatcher.OfDirectMethodHandleDesc ofDirectMethodHandleDesc = f27506f;
            if (ofDirectMethodHandleDesc.isInstance(obj2)) {
                Object[] parameterArray2 = ofMethodTypeDesc.parameterArray(f27505e.invocationType(obj2));
                ArrayList arrayList2 = new ArrayList(parameterArray2.length);
                int length2 = parameterArray2.length;
                while (i11 < length2) {
                    Type type4 = Type.getType(f27503c.descriptorString(parameterArray2[i11]));
                    if (type4.getSort() == 9) {
                        str4 = type4.getInternalName().replace('/', '.');
                    } else {
                        str4 = type4.getClassName();
                    }
                    arrayList2.add(typePool2.describe(str4).resolve());
                    i11++;
                }
                Dispatcher.OfClassDesc ofClassDesc2 = f27503c;
                Type type5 = Type.getType(ofClassDesc2.descriptorString(f27504d.returnType(f27505e.invocationType(obj2))));
                Dispatcher.OfDirectMethodHandleDesc ofDirectMethodHandleDesc2 = f27506f;
                MethodHandle.HandleType a11 = MethodHandle.HandleType.a(ofDirectMethodHandleDesc2.refKind(obj2));
                TypeDescription resolve2 = typePool2.describe(Type.getType(ofClassDesc2.descriptorString(ofDirectMethodHandleDesc2.owner(obj2))).getClassName()).resolve();
                String methodName = ofDirectMethodHandleDesc2.methodName(obj2);
                if (ofDirectMethodHandleDesc2.refKind(obj2) == 8) {
                    resolve = TypeDescription.VOID;
                } else {
                    resolve = typePool2.describe(type5.getSort() == 9 ? type5.getInternalName().replace('/', '.') : type5.getClassName()).resolve();
                }
                return new MethodHandle(a11, resolve2, methodName, resolve, arrayList2);
            }
            Dispatcher.OfDynamicConstantDesc ofDynamicConstantDesc = f27508h;
            if (ofDynamicConstantDesc.isInstance(obj2)) {
                Type methodType = Type.getMethodType(ofDirectMethodHandleDesc.lookupDescriptor(ofDynamicConstantDesc.bootstrapMethod(obj2)));
                ArrayList arrayList3 = new ArrayList(methodType.getArgumentTypes().length);
                for (Type type6 : methodType.getArgumentTypes()) {
                    if (type6.getSort() == 9) {
                        str3 = type6.getInternalName().replace('/', '.');
                    } else {
                        str3 = type6.getClassName();
                    }
                    arrayList3.add(typePool2.describe(str3).resolve());
                }
                Object[] bootstrapArgs = f27508h.bootstrapArgs(obj2);
                ArrayList arrayList4 = new ArrayList(bootstrapArgs.length);
                int length3 = bootstrapArgs.length;
                while (i11 < length3) {
                    arrayList4.add(ofDescription(bootstrapArgs[i11], typePool2));
                    i11++;
                }
                Dispatcher.OfClassDesc ofClassDesc3 = f27503c;
                Dispatcher.OfDynamicConstantDesc ofDynamicConstantDesc2 = f27508h;
                Type type7 = Type.getType(ofClassDesc3.descriptorString(ofDynamicConstantDesc2.constantType(obj2)));
                String constantName = ofDynamicConstantDesc2.constantName(obj2);
                if (type7.getSort() == 9) {
                    str = type7.getInternalName().replace('/', '.');
                } else {
                    str = type7.getClassName();
                }
                TypeDescription resolve3 = typePool2.describe(str).resolve();
                Dispatcher.OfDirectMethodHandleDesc ofDirectMethodHandleDesc3 = f27506f;
                MethodHandle.HandleType a12 = MethodHandle.HandleType.a(ofDirectMethodHandleDesc3.refKind(ofDynamicConstantDesc2.bootstrapMethod(obj2)));
                TypeDescription resolve4 = typePool2.describe(Type.getType(ofClassDesc3.descriptorString(ofDirectMethodHandleDesc3.owner(ofDynamicConstantDesc2.bootstrapMethod(obj2)))).getClassName()).resolve();
                String methodName2 = ofDirectMethodHandleDesc3.methodName(ofDynamicConstantDesc2.bootstrapMethod(obj2));
                if (methodType.getReturnType().getSort() == 9) {
                    str2 = methodType.getReturnType().getInternalName().replace('/', '.');
                } else {
                    str2 = methodType.getReturnType().getClassName();
                }
                MethodHandle methodHandle = r8;
                TypeDescription typeDescription2 = resolve4;
                TypeDescription typeDescription3 = resolve3;
                String str8 = methodName2;
                String str9 = constantName;
                MethodHandle methodHandle2 = new MethodHandle(a12, typeDescription2, str8, typePool2.describe(str2).resolve(), arrayList3);
                return new Dynamic(str9, typeDescription3, methodHandle, arrayList4);
            }
            throw new IllegalArgumentException("Not a resolvable constant description or not expressible as a constant pool value: " + obj2);
        }

        public static List<JavaConstant> wrap(List<?> list) {
            ArrayList arrayList = new ArrayList(list.size());
            for (Object wrap : list) {
                arrayList.add(wrap((Object) wrap));
            }
            return arrayList;
        }
    }

    public interface Visitor<T> {

        public enum NoOp implements Visitor<JavaConstant> {
            INSTANCE;

            public JavaConstant onDynamic(Dynamic dynamic) {
                return dynamic;
            }

            public JavaConstant onMethodHandle(MethodHandle methodHandle) {
                return methodHandle;
            }

            public JavaConstant onMethodType(MethodType methodType) {
                return methodType;
            }

            public JavaConstant onType(Simple<TypeDescription> simple) {
                return simple;
            }

            public JavaConstant onValue(Simple<?> simple) {
                return simple;
            }
        }

        T onDynamic(Dynamic dynamic);

        T onMethodHandle(MethodHandle methodHandle);

        T onMethodType(MethodType methodType);

        T onType(Simple<TypeDescription> simple);

        T onValue(Simple<?> simple);
    }

    <T> T accept(Visitor<T> visitor);

    TypeDescription getTypeDescription();

    Object toDescription();
}
