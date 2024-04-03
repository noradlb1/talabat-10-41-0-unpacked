package org.mockito.internal.creation.bytebuddy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.creation.bytebuddy.MockMethodInterceptor;
import org.mockito.internal.util.StringUtil;
import w30.a;

class SubclassBytecodeGenerator implements BytecodeGenerator {
    private static final String CODEGEN_PACKAGE = "org.mockito.codegen.";
    private final ByteBuddy byteBuddy;
    private final Implementation dispatcher;
    private final Implementation equals;
    private final ModuleHandler handler;
    private final Implementation hashCode;
    private final SubclassLoader loader;
    private final ElementMatcher<? super MethodDescription> matcher;
    private final Random random;
    private final Implementation readReplace;
    private final Implementation writeReplace;

    public SubclassBytecodeGenerator() {
        this(new SubclassInjectionLoader());
    }

    private static void assertVisibility(Class<?> cls) {
        if (!Modifier.isPublic(cls.getModifiers())) {
            throw new MockitoException(StringUtil.join("Cannot create mock for " + cls, "", "The type is not public and its mock class is loaded by a different class loader.", "This can have multiple reasons:", " - You are mocking a class with additional interfaces of another class loader", " - Mockito is loaded by a different class loader than the mocked type (e.g. with OSGi)", " - The thread's context class loader is different than the mock's class loader"));
        }
    }

    private <T> Collection<Class<? super T>> getAllTypes(Class<T> cls) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(cls);
        for (Class<? super T> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            linkedList.add(cls2);
        }
        return linkedList;
    }

    private static boolean hasNonPublicTypeReference(Class<?> cls) {
        for (Method method : cls.getMethods()) {
            if (!Modifier.isPublic(method.getReturnType().getModifiers())) {
                return true;
            }
            for (Class modifiers : method.getParameterTypes()) {
                if (!Modifier.isPublic(modifiers.getModifiers())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isComingFromJDK(Class<?> cls) {
        if ((cls.getPackage() == null || !"Java Runtime Environment".equalsIgnoreCase(cls.getPackage().getImplementationTitle())) && !cls.getName().startsWith("java.") && !cls.getName().startsWith("javax.")) {
            return false;
        }
        return true;
    }

    private static ElementMatcher<MethodDescription> isGroovyMethod() {
        return ElementMatchers.isDeclaredBy((ElementMatcher<? super TypeDescription>) ElementMatchers.named("groovy.lang.GroovyObjectSupport")).or(ElementMatchers.isAnnotatedWith((ElementMatcher<? super TypeDescription>) ElementMatchers.named("groovy.transform.Internal")));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean needsSamePackageClassLoader(org.mockito.internal.creation.bytebuddy.MockFeatures<?> r3) {
        /*
            java.lang.Class<T> r0 = r3.f63158a
            int r0 = r0.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isPublic(r0)
            r1 = 1
            if (r0 == 0) goto L_0x0045
            java.lang.Class<T> r0 = r3.f63158a
            boolean r0 = r0.isInterface()
            if (r0 != 0) goto L_0x0016
            goto L_0x0045
        L_0x0016:
            java.lang.Class<T> r0 = r3.f63158a
            boolean r0 = hasNonPublicTypeReference(r0)
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            java.util.Set<java.lang.Class<?>> r3 = r3.f63159b
            java.util.Iterator r3 = r3.iterator()
        L_0x0025:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0043
            java.lang.Object r0 = r3.next()
            java.lang.Class r0 = (java.lang.Class) r0
            int r2 = r0.getModifiers()
            boolean r2 = java.lang.reflect.Modifier.isPublic(r2)
            if (r2 != 0) goto L_0x003c
            return r1
        L_0x003c:
            boolean r0 = hasNonPublicTypeReference(r0)
            if (r0 == 0) goto L_0x0025
            return r1
        L_0x0043:
            r3 = 0
            return r3
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.needsSamePackageClassLoader(org.mockito.internal.creation.bytebuddy.MockFeatures):boolean");
    }

    public /* synthetic */ void clearAllCaches() {
        a.a(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Class<? extends T> mockClass(org.mockito.internal.creation.bytebuddy.MockFeatures<T> r13) {
        /*
            r12 = this;
            net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder r0 = new net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder
            r0.<init>()
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]
            java.lang.Class<T> r3 = r13.f63158a
            r4 = 0
            r2[r4] = r3
            net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder r0 = r0.appendMostSpecific((java.lang.Class<?>[]) r2)
            java.util.Set<java.lang.Class<?>> r2 = r13.f63159b
            net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder r0 = r0.appendMostSpecific((java.util.Collection<? extends java.lang.Class<?>>) r2)
            r2 = 2
            java.lang.Class[] r3 = new java.lang.Class[r2]
            java.lang.Class<org.mockito.internal.creation.bytebuddy.MockAccess> r5 = org.mockito.internal.creation.bytebuddy.MockAccess.class
            r3[r4] = r5
            java.lang.Class<org.mockito.internal.creation.bytebuddy.MockMethodInterceptor$DispatcherDefaultingToRealMethod> r6 = org.mockito.internal.creation.bytebuddy.MockMethodInterceptor.DispatcherDefaultingToRealMethod.class
            r3[r1] = r6
            net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder r0 = r0.appendMostSpecific((java.lang.Class<?>[]) r3)
            r3 = 3
            java.lang.Class[] r6 = new java.lang.Class[r3]
            java.lang.Class<org.mockito.internal.creation.bytebuddy.MockMethodInterceptor> r7 = org.mockito.internal.creation.bytebuddy.MockMethodInterceptor.class
            r6[r4] = r7
            java.lang.Class<org.mockito.internal.creation.bytebuddy.MockMethodInterceptor$ForHashCode> r8 = org.mockito.internal.creation.bytebuddy.MockMethodInterceptor.ForHashCode.class
            r6[r1] = r8
            java.lang.Class<org.mockito.internal.creation.bytebuddy.MockMethodInterceptor$ForEquals> r8 = org.mockito.internal.creation.bytebuddy.MockMethodInterceptor.ForEquals.class
            r6[r2] = r8
            net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder r0 = r0.appendMostSpecific((java.lang.Class<?>[]) r6)
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            java.lang.ClassLoader r6 = r6.getContextClassLoader()
            boolean r8 = needsSamePackageClassLoader(r13)
            if (r8 == 0) goto L_0x0057
            java.lang.ClassLoader r8 = r0.build()
            r9 = r6
        L_0x004c:
            if (r9 == 0) goto L_0x0057
            if (r9 != r8) goto L_0x0052
            r8 = r4
            goto L_0x0058
        L_0x0052:
            java.lang.ClassLoader r9 = r9.getParent()
            goto L_0x004c
        L_0x0057:
            r8 = r1
        L_0x0058:
            if (r8 == 0) goto L_0x0062
            java.lang.ClassLoader[] r8 = new java.lang.ClassLoader[r1]
            r8[r4] = r6
            net.bytebuddy.dynamic.loading.MultipleParentClassLoader$Builder r0 = r0.appendMostSpecific((java.lang.ClassLoader[]) r8)
        L_0x0062:
            java.lang.ClassLoader r0 = r0.build()
            java.lang.Class<T> r6 = r13.f63158a
            java.lang.ClassLoader r6 = r6.getClassLoader()
            if (r0 != r6) goto L_0x0090
            org.mockito.mock.SerializableMode r6 = r13.f63160c
            org.mockito.mock.SerializableMode r8 = org.mockito.mock.SerializableMode.ACROSS_CLASSLOADERS
            if (r6 == r8) goto L_0x0090
            java.lang.Class<T> r6 = r13.f63158a
            boolean r6 = r12.isComingFromJDK(r6)
            if (r6 != 0) goto L_0x0090
            org.mockito.internal.creation.bytebuddy.SubclassLoader r6 = r12.loader
            boolean r6 = r6.isDisrespectingOpenness()
            if (r6 != 0) goto L_0x008e
            org.mockito.internal.creation.bytebuddy.ModuleHandler r6 = r12.handler
            java.lang.Class<T> r8 = r13.f63158a
            boolean r6 = r6.d(r8, r5)
            if (r6 == 0) goto L_0x0090
        L_0x008e:
            r6 = r1
            goto L_0x0091
        L_0x0090:
            r6 = r4
        L_0x0091:
            if (r6 != 0) goto L_0x00c7
            org.mockito.internal.creation.bytebuddy.SubclassLoader r8 = r12.loader
            boolean r8 = r8 instanceof net.bytebuddy.dynamic.loading.MultipleParentClassLoader
            if (r8 == 0) goto L_0x00a2
            java.lang.Class<T> r8 = r13.f63158a
            boolean r8 = r12.isComingFromJDK(r8)
            if (r8 != 0) goto L_0x00a2
            goto L_0x00c7
        L_0x00a2:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.Class<org.mockito.codegen.InjectionBase> r9 = org.mockito.codegen.InjectionBase.class
            java.lang.Package r9 = r9.getPackage()
            java.lang.String r9 = r9.getName()
            r8.append(r9)
            java.lang.String r9 = "."
            r8.append(r9)
            java.lang.Class<T> r9 = r13.f63158a
            java.lang.String r9 = r9.getSimpleName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            goto L_0x00cd
        L_0x00c7:
            java.lang.Class<T> r8 = r13.f63158a
            java.lang.String r8 = r8.getName()
        L_0x00cd:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r8
            java.lang.String r9 = "MockitoMock"
            r3[r1] = r9
            java.util.Random r9 = r12.random
            int r9 = r9.nextInt()
            int r9 = java.lang.Math.abs(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r3[r2] = r9
            java.lang.String r9 = "%s$%s$%d"
            java.lang.String r3 = java.lang.String.format(r9, r3)
            if (r6 == 0) goto L_0x0115
            org.mockito.internal.creation.bytebuddy.ModuleHandler r8 = r12.handler
            java.lang.Class<T> r9 = r13.f63158a
            r8.a(r9, r5, r4, r1)
            java.util.Set<java.lang.Class<?>> r8 = r13.f63159b
            java.util.Iterator r8 = r8.iterator()
        L_0x00fa:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0182
            java.lang.Object r9 = r8.next()
            java.lang.Class r9 = (java.lang.Class) r9
            org.mockito.internal.creation.bytebuddy.ModuleHandler r10 = r12.handler
            java.lang.Class<T> r11 = r13.f63158a
            r10.a(r9, r11, r1, r4)
            org.mockito.internal.creation.bytebuddy.ModuleHandler r10 = r12.handler
            java.lang.Class<T> r11 = r13.f63158a
            r10.a(r11, r9, r4, r1)
            goto L_0x00fa
        L_0x0115:
            org.mockito.internal.creation.bytebuddy.ModuleHandler r9 = r12.handler
            java.lang.Class<T> r10 = r13.f63158a
            boolean r9 = r9.c(r10)
            java.util.Set<java.lang.Class<?>> r10 = r13.f63159b
            java.util.Iterator r10 = r10.iterator()
        L_0x0123:
            if (r9 == 0) goto L_0x0138
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0138
            org.mockito.internal.creation.bytebuddy.ModuleHandler r9 = r12.handler
            java.lang.Object r11 = r10.next()
            java.lang.Class r11 = (java.lang.Class) r11
            boolean r9 = r9.c(r11)
            goto L_0x0123
        L_0x0138:
            if (r9 == 0) goto L_0x0155
            java.lang.Class<T> r8 = r13.f63158a
            assertVisibility(r8)
            java.util.Set<java.lang.Class<?>> r8 = r13.f63159b
            java.util.Iterator r8 = r8.iterator()
        L_0x0145:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0182
            java.lang.Object r9 = r8.next()
            java.lang.Class r9 = (java.lang.Class) r9
            assertVisibility(r9)
            goto L_0x0145
        L_0x0155:
            org.mockito.internal.creation.bytebuddy.ModuleHandler r9 = r12.handler
            java.lang.Class r8 = r9.b(r0, r8)
            java.lang.Class<T> r9 = r13.f63158a
            assertVisibility(r9)
            org.mockito.internal.creation.bytebuddy.ModuleHandler r9 = r12.handler
            java.lang.Class<T> r10 = r13.f63158a
            r9.a(r10, r8, r1, r4)
            java.util.Set<java.lang.Class<?>> r9 = r13.f63159b
            java.util.Iterator r9 = r9.iterator()
        L_0x016d:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0182
            java.lang.Object r10 = r9.next()
            java.lang.Class r10 = (java.lang.Class) r10
            assertVisibility(r10)
            org.mockito.internal.creation.bytebuddy.ModuleHandler r11 = r12.handler
            r11.a(r10, r8, r1, r4)
            goto L_0x016d
        L_0x0182:
            net.bytebuddy.ByteBuddy r8 = r12.byteBuddy
            java.lang.Class<T> r9 = r13.f63158a
            net.bytebuddy.dynamic.DynamicType$Builder r8 = r8.subclass(r9)
            net.bytebuddy.dynamic.DynamicType$Builder r8 = r8.name(r3)
            net.bytebuddy.matcher.ElementMatcher r9 = isGroovyMethod()
            net.bytebuddy.dynamic.DynamicType$Builder r8 = r8.ignoreAlso((net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.method.MethodDescription>) r9)
            boolean r9 = r13.f63161d
            if (r9 == 0) goto L_0x019d
            java.lang.annotation.Annotation[] r9 = new java.lang.annotation.Annotation[r4]
            goto L_0x01a3
        L_0x019d:
            java.lang.Class<T> r9 = r13.f63158a
            java.lang.annotation.Annotation[] r9 = r9.getAnnotations()
        L_0x01a3:
            net.bytebuddy.dynamic.DynamicType$Builder r8 = r8.annotateType((java.lang.annotation.Annotation[]) r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            java.util.Set<java.lang.Class<?>> r10 = r13.f63159b
            r9.<init>(r10)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition$Optional r8 = r8.implement((java.util.List<? extends java.lang.reflect.Type>) r9)
            net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.method.MethodDescription> r9 = r12.matcher
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r8 = r8.method(r9)
            net.bytebuddy.implementation.Implementation r9 = r12.dispatcher
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r8 = r8.intercept(r9)
            net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r9 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r1]
            net.bytebuddy.description.modifier.SynchronizationState r10 = net.bytebuddy.description.modifier.SynchronizationState.PLAIN
            r9[r4] = r10
            net.bytebuddy.dynamic.Transformer r9 = net.bytebuddy.dynamic.Transformer.ForMethod.withModifiers((net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r9)
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition r8 = r8.transform(r9)
            boolean r9 = r13.f63161d
            if (r9 == 0) goto L_0x01d3
            net.bytebuddy.implementation.attribute.MethodAttributeAppender$NoOp r9 = net.bytebuddy.implementation.attribute.MethodAttributeAppender.NoOp.INSTANCE
            goto L_0x01d5
        L_0x01d3:
            net.bytebuddy.implementation.attribute.MethodAttributeAppender$ForInstrumentedMethod r9 = net.bytebuddy.implementation.attribute.MethodAttributeAppender.ForInstrumentedMethod.INCLUDING_RECEIVER
        L_0x01d5:
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition r8 = r8.attribute(r9)
            r9 = 42
            net.bytebuddy.dynamic.DynamicType$Builder$FieldDefinition$Optional r8 = r8.serialVersionUid(r9)
            net.bytebuddy.description.modifier.ModifierContributor$ForField[] r9 = new net.bytebuddy.description.modifier.ModifierContributor.ForField[r1]
            net.bytebuddy.description.modifier.Visibility r10 = net.bytebuddy.description.modifier.Visibility.PRIVATE
            r9[r4] = r10
            java.lang.String r11 = "mockitoInterceptor"
            net.bytebuddy.dynamic.DynamicType$Builder$FieldDefinition$Optional$Valuable r7 = r8.defineField((java.lang.String) r11, (java.lang.reflect.Type) r7, (net.bytebuddy.description.modifier.ModifierContributor.ForField[]) r9)
            java.lang.reflect.Type[] r8 = new java.lang.reflect.Type[r1]
            r8[r4] = r5
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition$Optional r5 = r7.implement((java.lang.reflect.Type[]) r8)
            net.bytebuddy.implementation.FieldAccessor$OwnerTypeLocatable r7 = net.bytebuddy.implementation.FieldAccessor.ofBeanProperty()
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r5 = r5.intercept(r7)
            net.bytebuddy.matcher.ElementMatcher$Junction r7 = net.bytebuddy.matcher.ElementMatchers.isHashCode()
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r5 = r5.method(r7)
            net.bytebuddy.implementation.Implementation r7 = r12.hashCode
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r5 = r5.intercept(r7)
            net.bytebuddy.matcher.ElementMatcher$Junction r7 = net.bytebuddy.matcher.ElementMatchers.isEquals()
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r5 = r5.method(r7)
            net.bytebuddy.implementation.Implementation r7 = r12.equals
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r5 = r5.intercept(r7)
            org.mockito.mock.SerializableMode r7 = r13.f63160c
            org.mockito.mock.SerializableMode r8 = org.mockito.mock.SerializableMode.ACROSS_CLASSLOADERS
            if (r7 != r8) goto L_0x022d
            java.lang.reflect.Type[] r7 = new java.lang.reflect.Type[r1]
            java.lang.Class<org.mockito.internal.creation.bytebuddy.ByteBuddyCrossClassLoaderSerializationSupport$CrossClassLoaderSerializableMock> r8 = org.mockito.internal.creation.bytebuddy.ByteBuddyCrossClassLoaderSerializationSupport.CrossClassLoaderSerializableMock.class
            r7[r4] = r8
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition$Optional r5 = r5.implement((java.lang.reflect.Type[]) r7)
            net.bytebuddy.implementation.Implementation r7 = r12.writeReplace
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r5 = r5.intercept(r7)
        L_0x022d:
            net.bytebuddy.implementation.Implementation r7 = r12.readReplace
            if (r7 == 0) goto L_0x025b
            java.lang.Class r7 = java.lang.Void.TYPE
            net.bytebuddy.description.modifier.ModifierContributor$ForMethod[] r8 = new net.bytebuddy.description.modifier.ModifierContributor.ForMethod[r1]
            r8[r4] = r10
            java.lang.String r9 = "readObject"
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ParameterDefinition$Initial r5 = r5.defineMethod((java.lang.String) r9, (java.lang.reflect.Type) r7, (net.bytebuddy.description.modifier.ModifierContributor.ForMethod[]) r8)
            java.lang.reflect.Type[] r7 = new java.lang.reflect.Type[r1]
            java.lang.Class<java.io.ObjectInputStream> r8 = java.io.ObjectInputStream.class
            r7[r4] = r8
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r5 = r5.withParameters((java.lang.reflect.Type[]) r7)
            java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r2]
            java.lang.Class<java.lang.ClassNotFoundException> r7 = java.lang.ClassNotFoundException.class
            r2[r4] = r7
            java.lang.Class<java.io.IOException> r4 = java.io.IOException.class
            r2[r1] = r4
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ExceptionDefinition r1 = r5.throwing((java.lang.reflect.Type[]) r2)
            net.bytebuddy.implementation.Implementation r2 = r12.readReplace
            net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r5 = r1.intercept(r2)
        L_0x025b:
            java.lang.String r1 = "org.mockito.codegen."
            boolean r1 = r3.startsWith(r1)
            if (r1 != 0) goto L_0x0267
            boolean r1 = r0 instanceof net.bytebuddy.dynamic.loading.MultipleParentClassLoader
            if (r1 == 0) goto L_0x028f
        L_0x0267:
            net.bytebuddy.matcher.ElementMatcher$Junction r1 = net.bytebuddy.matcher.ElementMatchers.isPackagePrivate()
            net.bytebuddy.matcher.ElementMatcher$Junction r2 = net.bytebuddy.matcher.ElementMatchers.isPackagePrivate()
            net.bytebuddy.matcher.ElementMatcher$Junction r2 = net.bytebuddy.matcher.ElementMatchers.returns((net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.type.TypeDescription>) r2)
            net.bytebuddy.matcher.ElementMatcher$Junction r1 = r1.or(r2)
            net.bytebuddy.matcher.ElementMatcher$Junction r2 = net.bytebuddy.matcher.ElementMatchers.isPackagePrivate()
            net.bytebuddy.matcher.ElementMatcher$Junction r2 = net.bytebuddy.matcher.ElementMatchers.hasType(r2)
            net.bytebuddy.matcher.ElementMatcher$Junction r2 = net.bytebuddy.matcher.ElementMatchers.whereAny(r2)
            net.bytebuddy.matcher.ElementMatcher$Junction r2 = net.bytebuddy.matcher.ElementMatchers.hasParameters(r2)
            net.bytebuddy.matcher.ElementMatcher$Junction r1 = r1.or(r2)
            net.bytebuddy.dynamic.DynamicType$Builder r5 = r5.ignoreAlso((net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.method.MethodDescription>) r1)
        L_0x028f:
            net.bytebuddy.dynamic.DynamicType$Unloaded r1 = r5.make()
            org.mockito.internal.creation.bytebuddy.SubclassLoader r2 = r12.loader
            java.lang.Class<T> r13 = r13.f63158a
            net.bytebuddy.dynamic.loading.ClassLoadingStrategy r13 = r2.resolveStrategy(r13, r0, r6)
            net.bytebuddy.dynamic.DynamicType$Loaded r13 = r1.load(r0, r13)
            java.lang.Class r13 = r13.getLoaded()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.creation.bytebuddy.SubclassBytecodeGenerator.mockClass(org.mockito.internal.creation.bytebuddy.MockFeatures):java.lang.Class");
    }

    public void mockClassConstruction(Class<?> cls) {
        throw new MockitoException("The subclass byte code generator cannot create construction mocks");
    }

    public void mockClassStatic(Class<?> cls) {
        throw new MockitoException("The subclass byte code generator cannot create static mocks");
    }

    public SubclassBytecodeGenerator(SubclassLoader subclassLoader) {
        this(subclassLoader, (Implementation) null, ElementMatchers.any());
    }

    public SubclassBytecodeGenerator(Implementation implementation, ElementMatcher<? super MethodDescription> elementMatcher) {
        this(new SubclassInjectionLoader(), implementation, elementMatcher);
    }

    public SubclassBytecodeGenerator(SubclassLoader subclassLoader, Implementation implementation, ElementMatcher<? super MethodDescription> elementMatcher) {
        this.dispatcher = MethodDelegation.to((Class<?>) MockMethodInterceptor.DispatcherDefaultingToRealMethod.class);
        this.hashCode = MethodDelegation.to((Class<?>) MockMethodInterceptor.ForHashCode.class);
        this.equals = MethodDelegation.to((Class<?>) MockMethodInterceptor.ForEquals.class);
        this.writeReplace = MethodDelegation.to((Class<?>) MockMethodInterceptor.ForWriteReplace.class);
        this.loader = subclassLoader;
        this.readReplace = implementation;
        this.matcher = elementMatcher;
        ByteBuddy with = new ByteBuddy().with(TypeValidation.DISABLED);
        this.byteBuddy = with;
        Random random2 = new Random();
        this.random = random2;
        this.handler = ModuleHandler.e(with, subclassLoader, random2);
    }
}
