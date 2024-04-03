package org.mockito.internal.creation.bytebuddy;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.reflect.Method;
import java.util.Random;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import org.mockito.codegen.InjectionBase;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.StringUtil;

abstract class ModuleHandler {

    public static class ModuleSystemFound extends ModuleHandler {
        private final Method addExports;
        private final Method addOpens;
        private final Method addReads;
        private final ByteBuddy byteBuddy;
        private final Method canRead;
        private final Method forName;
        private final Method getModule;
        private final int injectonBaseSuffix;
        private final Method isExported;
        private final Method isExportedUnqualified;
        private final Method isOpen;
        private final SubclassLoader loader;
        private final Random random;

        private static Object invoke(Method method, Object obj, Object... objArr) {
            try {
                return method.invoke(obj, objArr);
            } catch (Exception e11) {
                throw new MockitoException(StringUtil.join("Could not invoke " + method + " using reflection", "", "Mockito attempted to interact with the Java module system but an unexpected method behavior was encountered"), e11);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
            if (r8 == r19.getClassLoader()) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
            r12 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
            r12 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
            if (r12 != false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
            if (r8 == null) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
            r8 = r8.getParent();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
            if (r8 != r19.getClassLoader()) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0046, code lost:
            r13 = java.lang.Object.class;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004a, code lost:
            if (r12 == false) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
            r3 = net.bytebuddy.implementation.MethodCall.invoke(r1.getModule).onMethodCall(net.bytebuddy.implementation.MethodCall.invoke(r1.forName).with(r19.getName()));
            r12 = net.bytebuddy.implementation.StubMethod.INSTANCE;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            r10 = r1.byteBuddy.subclass(r13, (net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy) net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.NO_CONSTRUCTORS).name(java.lang.String.format("%s$%d", new java.lang.Object[]{"org.mockito.codegen.MockitoTypeCarrier", java.lang.Integer.valueOf(java.lang.Math.abs(r1.random.nextInt()))})).defineField("mockitoType", (java.lang.reflect.Type) java.lang.Class.class, net.bytebuddy.description.modifier.Visibility.PUBLIC, net.bytebuddy.description.modifier.Ownership.STATIC).make().load(r18.getClassLoader(), r1.loader.resolveStrategy(r2, r18.getClassLoader(), false)).getLoaded();
            r3 = r10.getField("mockitoType");
            r3.set((java.lang.Object) null, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c6, code lost:
            r3 = net.bytebuddy.implementation.MethodCall.invoke(r1.getModule).onField(r3);
            r12 = net.bytebuddy.implementation.MethodCall.invoke(r1.getModule).onMethodCall(net.bytebuddy.implementation.MethodCall.invoke(r1.forName).with(r10.getName()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ec, code lost:
            r10 = net.bytebuddy.implementation.MethodCall.invoke(r1.getModule).onMethodCall(net.bytebuddy.implementation.MethodCall.invoke(r1.forName).with(r18.getName()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0108, code lost:
            if (r6 == false) goto L_0x012c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x010a, code lost:
            r12 = r12.andThen((net.bytebuddy.implementation.Implementation.Composable) net.bytebuddy.implementation.MethodCall.invoke(r1.addExports).onMethodCall(r10).with(r19.getPackage().getName()).withMethodCall(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x012c, code lost:
            if (r7 == false) goto L_0x0140;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x012e, code lost:
            r12 = r12.andThen((net.bytebuddy.implementation.Implementation.Composable) net.bytebuddy.implementation.MethodCall.invoke(r1.addReads).onMethodCall(r10).withMethodCall(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            java.lang.Class.forName(r1.byteBuddy.subclass(r13).name(java.lang.String.format("%s$%s$%d", new java.lang.Object[]{r18.getName(), "MockitoModuleProbe", java.lang.Integer.valueOf(java.lang.Math.abs(r1.random.nextInt()))})).invokable((net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.method.MethodDescription>) net.bytebuddy.matcher.ElementMatchers.isTypeInitializer()).intercept(r12).make().load(r18.getClassLoader(), r1.loader.resolveStrategy(r2, r18.getClassLoader(), false)).getLoaded().getName(), true, r18.getClassLoader());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x019e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x019f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x01c3, code lost:
            throw new org.mockito.exceptions.base.MockitoException(org.mockito.internal.util.StringUtil.join("Could not force module adjustment of the module of " + r2, "", "This is required to adjust the module graph to enable mock creation"), r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x01c4, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x01e8, code lost:
            throw new org.mockito.exceptions.base.MockitoException(org.mockito.internal.util.StringUtil.join("Could not create a carrier for making the Mockito type visible to " + r2, "", "This is required to adjust the module graph to enable mock creation"), r0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.lang.Class<?> r18, java.lang.Class<?> r19, boolean r20, boolean r21) {
            /*
                r17 = this;
                r1 = r17
                r2 = r18
                r0 = r19
                java.lang.String r3 = "mockitoType"
                r4 = 1
                r5 = 0
                if (r20 == 0) goto L_0x0014
                boolean r6 = r17.g(r18, r19)
                if (r6 != 0) goto L_0x0014
                r6 = r4
                goto L_0x0015
            L_0x0014:
                r6 = r5
            L_0x0015:
                if (r21 == 0) goto L_0x001f
                boolean r7 = r17.f(r18, r19)
                if (r7 != 0) goto L_0x001f
                r7 = r4
                goto L_0x0020
            L_0x001f:
                r7 = r5
            L_0x0020:
                if (r6 != 0) goto L_0x0025
                if (r7 != 0) goto L_0x0025
                return
            L_0x0025:
                java.lang.ClassLoader r8 = r18.getClassLoader()
                java.lang.String r9 = ""
                r11 = 2
                if (r8 == 0) goto L_0x01e9
                java.lang.ClassLoader r12 = r19.getClassLoader()
                if (r8 != r12) goto L_0x0036
            L_0x0034:
                r12 = r4
                goto L_0x0037
            L_0x0036:
                r12 = r5
            L_0x0037:
                if (r12 != 0) goto L_0x0046
                if (r8 == 0) goto L_0x0046
                java.lang.ClassLoader r8 = r8.getParent()
                java.lang.ClassLoader r12 = r19.getClassLoader()
                if (r8 != r12) goto L_0x0036
                goto L_0x0034
            L_0x0046:
                java.lang.String r8 = "This is required to adjust the module graph to enable mock creation"
                java.lang.Class<java.lang.Object> r13 = java.lang.Object.class
                if (r12 == 0) goto L_0x006c
                java.lang.reflect.Method r3 = r1.getModule
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r3 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r3)
                java.lang.reflect.Method r12 = r1.forName
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r12 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r12)
                java.lang.Object[] r14 = new java.lang.Object[r4]
                java.lang.String r15 = r19.getName()
                r14[r5] = r15
                net.bytebuddy.implementation.MethodCall r12 = r12.with((java.lang.Object[]) r14)
                net.bytebuddy.implementation.MethodCall r3 = r3.onMethodCall(r12)
                net.bytebuddy.implementation.StubMethod r12 = net.bytebuddy.implementation.StubMethod.INSTANCE
                goto L_0x00ec
            L_0x006c:
                net.bytebuddy.ByteBuddy r12 = r1.byteBuddy     // Catch:{ Exception -> 0x01c4 }
                net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy$Default r14 = net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy.Default.NO_CONSTRUCTORS     // Catch:{ Exception -> 0x01c4 }
                net.bytebuddy.dynamic.DynamicType$Builder r12 = r12.subclass(r13, (net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy) r14)     // Catch:{ Exception -> 0x01c4 }
                java.lang.String r14 = "%s$%d"
                java.lang.Object[] r15 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x01c4 }
                java.lang.String r16 = "org.mockito.codegen.MockitoTypeCarrier"
                r15[r5] = r16     // Catch:{ Exception -> 0x01c4 }
                java.util.Random r10 = r1.random     // Catch:{ Exception -> 0x01c4 }
                int r10 = r10.nextInt()     // Catch:{ Exception -> 0x01c4 }
                int r10 = java.lang.Math.abs(r10)     // Catch:{ Exception -> 0x01c4 }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x01c4 }
                r15[r4] = r10     // Catch:{ Exception -> 0x01c4 }
                java.lang.String r10 = java.lang.String.format(r14, r15)     // Catch:{ Exception -> 0x01c4 }
                net.bytebuddy.dynamic.DynamicType$Builder r10 = r12.name(r10)     // Catch:{ Exception -> 0x01c4 }
                java.lang.Class<java.lang.Class> r12 = java.lang.Class.class
                net.bytebuddy.description.modifier.ModifierContributor$ForField[] r14 = new net.bytebuddy.description.modifier.ModifierContributor.ForField[r11]     // Catch:{ Exception -> 0x01c4 }
                net.bytebuddy.description.modifier.Visibility r15 = net.bytebuddy.description.modifier.Visibility.PUBLIC     // Catch:{ Exception -> 0x01c4 }
                r14[r5] = r15     // Catch:{ Exception -> 0x01c4 }
                net.bytebuddy.description.modifier.Ownership r15 = net.bytebuddy.description.modifier.Ownership.STATIC     // Catch:{ Exception -> 0x01c4 }
                r14[r4] = r15     // Catch:{ Exception -> 0x01c4 }
                net.bytebuddy.dynamic.DynamicType$Builder$FieldDefinition$Optional$Valuable r10 = r10.defineField((java.lang.String) r3, (java.lang.reflect.Type) r12, (net.bytebuddy.description.modifier.ModifierContributor.ForField[]) r14)     // Catch:{ Exception -> 0x01c4 }
                net.bytebuddy.dynamic.DynamicType$Unloaded r10 = r10.make()     // Catch:{ Exception -> 0x01c4 }
                java.lang.ClassLoader r12 = r18.getClassLoader()     // Catch:{ Exception -> 0x01c4 }
                org.mockito.internal.creation.bytebuddy.SubclassLoader r14 = r1.loader     // Catch:{ Exception -> 0x01c4 }
                java.lang.ClassLoader r15 = r18.getClassLoader()     // Catch:{ Exception -> 0x01c4 }
                net.bytebuddy.dynamic.loading.ClassLoadingStrategy r14 = r14.resolveStrategy(r2, r15, r5)     // Catch:{ Exception -> 0x01c4 }
                net.bytebuddy.dynamic.DynamicType$Loaded r10 = r10.load(r12, r14)     // Catch:{ Exception -> 0x01c4 }
                java.lang.Class r10 = r10.getLoaded()     // Catch:{ Exception -> 0x01c4 }
                java.lang.reflect.Field r3 = r10.getField(r3)     // Catch:{ Exception -> 0x01c4 }
                r12 = 0
                r3.set(r12, r0)     // Catch:{ Exception -> 0x01c4 }
                java.lang.reflect.Method r12 = r1.getModule
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r12 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r12)
                net.bytebuddy.implementation.MethodCall r3 = r12.onField((java.lang.reflect.Field) r3)
                java.lang.reflect.Method r12 = r1.getModule
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r12 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r12)
                java.lang.reflect.Method r14 = r1.forName
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r14 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r14)
                java.lang.Object[] r15 = new java.lang.Object[r4]
                java.lang.String r10 = r10.getName()
                r15[r5] = r10
                net.bytebuddy.implementation.MethodCall r10 = r14.with((java.lang.Object[]) r15)
                net.bytebuddy.implementation.MethodCall r12 = r12.onMethodCall(r10)
            L_0x00ec:
                java.lang.reflect.Method r10 = r1.getModule
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r10 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r10)
                java.lang.reflect.Method r14 = r1.forName
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r14 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r14)
                java.lang.Object[] r15 = new java.lang.Object[r4]
                java.lang.String r16 = r18.getName()
                r15[r5] = r16
                net.bytebuddy.implementation.MethodCall r14 = r14.with((java.lang.Object[]) r15)
                net.bytebuddy.implementation.MethodCall r10 = r10.onMethodCall(r14)
                if (r6 == 0) goto L_0x012c
                java.lang.reflect.Method r6 = r1.addExports
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r6 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r6)
                net.bytebuddy.implementation.MethodCall r6 = r6.onMethodCall(r10)
                java.lang.Object[] r14 = new java.lang.Object[r4]
                java.lang.Package r0 = r19.getPackage()
                java.lang.String r0 = r0.getName()
                r14[r5] = r0
                net.bytebuddy.implementation.MethodCall r0 = r6.with((java.lang.Object[]) r14)
                net.bytebuddy.implementation.MethodCall r0 = r0.withMethodCall(r3)
                net.bytebuddy.implementation.Implementation$Composable r12 = r12.andThen((net.bytebuddy.implementation.Implementation.Composable) r0)
            L_0x012c:
                if (r7 == 0) goto L_0x0140
                java.lang.reflect.Method r0 = r1.addReads
                net.bytebuddy.implementation.MethodCall$WithoutSpecifiedTarget r0 = net.bytebuddy.implementation.MethodCall.invoke((java.lang.reflect.Method) r0)
                net.bytebuddy.implementation.MethodCall r0 = r0.onMethodCall(r10)
                net.bytebuddy.implementation.MethodCall r0 = r0.withMethodCall(r3)
                net.bytebuddy.implementation.Implementation$Composable r12 = r12.andThen((net.bytebuddy.implementation.Implementation.Composable) r0)
            L_0x0140:
                net.bytebuddy.ByteBuddy r0 = r1.byteBuddy     // Catch:{ Exception -> 0x019f }
                net.bytebuddy.dynamic.DynamicType$Builder r0 = r0.subclass(r13)     // Catch:{ Exception -> 0x019f }
                java.lang.String r3 = "%s$%s$%d"
                r6 = 3
                java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x019f }
                java.lang.String r6 = r18.getName()     // Catch:{ Exception -> 0x019f }
                r7[r5] = r6     // Catch:{ Exception -> 0x019f }
                java.lang.String r6 = "MockitoModuleProbe"
                r7[r4] = r6     // Catch:{ Exception -> 0x019f }
                java.util.Random r6 = r1.random     // Catch:{ Exception -> 0x019f }
                int r6 = r6.nextInt()     // Catch:{ Exception -> 0x019f }
                int r6 = java.lang.Math.abs(r6)     // Catch:{ Exception -> 0x019f }
                java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x019f }
                r7[r11] = r6     // Catch:{ Exception -> 0x019f }
                java.lang.String r3 = java.lang.String.format(r3, r7)     // Catch:{ Exception -> 0x019f }
                net.bytebuddy.dynamic.DynamicType$Builder r0 = r0.name(r3)     // Catch:{ Exception -> 0x019f }
                net.bytebuddy.matcher.ElementMatcher$Junction r3 = net.bytebuddy.matcher.ElementMatchers.isTypeInitializer()     // Catch:{ Exception -> 0x019f }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ImplementationDefinition r0 = r0.invokable((net.bytebuddy.matcher.ElementMatcher<? super net.bytebuddy.description.method.MethodDescription>) r3)     // Catch:{ Exception -> 0x019f }
                net.bytebuddy.dynamic.DynamicType$Builder$MethodDefinition$ReceiverTypeDefinition r0 = r0.intercept(r12)     // Catch:{ Exception -> 0x019f }
                net.bytebuddy.dynamic.DynamicType$Unloaded r0 = r0.make()     // Catch:{ Exception -> 0x019f }
                java.lang.ClassLoader r3 = r18.getClassLoader()     // Catch:{ Exception -> 0x019f }
                org.mockito.internal.creation.bytebuddy.SubclassLoader r6 = r1.loader     // Catch:{ Exception -> 0x019f }
                java.lang.ClassLoader r7 = r18.getClassLoader()     // Catch:{ Exception -> 0x019f }
                net.bytebuddy.dynamic.loading.ClassLoadingStrategy r6 = r6.resolveStrategy(r2, r7, r5)     // Catch:{ Exception -> 0x019f }
                net.bytebuddy.dynamic.DynamicType$Loaded r0 = r0.load(r3, r6)     // Catch:{ Exception -> 0x019f }
                java.lang.Class r0 = r0.getLoaded()     // Catch:{ Exception -> 0x019f }
                java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x019f }
                java.lang.ClassLoader r3 = r18.getClassLoader()     // Catch:{ Exception -> 0x019f }
                java.lang.Class.forName(r0, r4, r3)     // Catch:{ Exception -> 0x019f }
                return
            L_0x019f:
                r0 = move-exception
                org.mockito.exceptions.base.MockitoException r3 = new org.mockito.exceptions.base.MockitoException
                r6 = 3
                java.lang.Object[] r6 = new java.lang.Object[r6]
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r10 = "Could not force module adjustment of the module of "
                r7.append(r10)
                r7.append(r2)
                java.lang.String r2 = r7.toString()
                r6[r5] = r2
                r6[r4] = r9
                r6[r11] = r8
                java.lang.String r2 = org.mockito.internal.util.StringUtil.join(r6)
                r3.<init>(r2, r0)
                throw r3
            L_0x01c4:
                r0 = move-exception
                org.mockito.exceptions.base.MockitoException r3 = new org.mockito.exceptions.base.MockitoException
                r6 = 3
                java.lang.Object[] r6 = new java.lang.Object[r6]
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r10 = "Could not create a carrier for making the Mockito type visible to "
                r7.append(r10)
                r7.append(r2)
                java.lang.String r2 = r7.toString()
                r6[r5] = r2
                r6[r4] = r9
                r6[r11] = r8
                java.lang.String r2 = org.mockito.internal.util.StringUtil.join(r6)
                r3.<init>(r2, r0)
                throw r3
            L_0x01e9:
                org.mockito.exceptions.base.MockitoException r3 = new org.mockito.exceptions.base.MockitoException
                r8 = 5
                java.lang.Object[] r8 = new java.lang.Object[r8]
                java.lang.String r10 = "Cannot adjust module graph for modules in the bootstrap loader"
                r8[r5] = r10
                r8[r4] = r9
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r2)
                java.lang.String r2 = " is declared by the bootstrap loader and cannot be adjusted"
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                r8[r11] = r2
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "Requires package export to "
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = ": "
                r2.append(r4)
                r2.append(r6)
                java.lang.String r2 = r2.toString()
                r5 = 3
                r8[r5] = r2
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = "Requires adjusted reading of "
                r2.append(r5)
                r2.append(r0)
                r2.append(r4)
                r2.append(r7)
                java.lang.String r0 = r2.toString()
                r2 = 4
                r8[r2] = r0
                java.lang.String r0 = org.mockito.internal.util.StringUtil.join(r8)
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: org.mockito.internal.creation.bytebuddy.ModuleHandler.ModuleSystemFound.a(java.lang.Class, java.lang.Class, boolean, boolean):void");
        }

        public Class<?> b(ClassLoader classLoader, String str) {
            Class<?> cls;
            String substring = str.substring(0, str.lastIndexOf(46));
            if (classLoader == InjectionBase.class.getClassLoader() && InjectionBase.class.getPackage().getName().equals(substring)) {
                return InjectionBase.class;
            }
            synchronized (this) {
                int i11 = this.injectonBaseSuffix;
                while (true) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(substring);
                    sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                    sb2.append(InjectionBase.class.getSimpleName());
                    sb2.append("$");
                    int i12 = i11 + 1;
                    sb2.append(i11);
                    String sb3 = sb2.toString();
                    try {
                        cls = Class.forName(sb3, false, classLoader);
                        if (cls.getClassLoader() != classLoader) {
                            i11 = i12;
                        }
                    } catch (ClassNotFoundException unused) {
                        return this.byteBuddy.subclass(Object.class, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS).name(sb3).make().load(classLoader, this.loader.resolveStrategy(InjectionBase.class, classLoader, false)).getLoaded();
                    }
                }
            }
            return cls;
        }

        public boolean c(Class<?> cls) {
            if (cls.getPackage() == null) {
                return true;
            }
            return ((Boolean) invoke(this.isExportedUnqualified, invoke(this.getModule, cls, new Object[0]), cls.getPackage().getName())).booleanValue();
        }

        public boolean d(Class<?> cls, Class<?> cls2) {
            if (cls.getPackage() == null) {
                return true;
            }
            return ((Boolean) invoke(this.isOpen, invoke(this.getModule, cls, new Object[0]), cls.getPackage().getName(), invoke(this.getModule, cls2, new Object[0]))).booleanValue();
        }

        public boolean f(Class<?> cls, Class<?> cls2) {
            return ((Boolean) invoke(this.canRead, invoke(this.getModule, cls, new Object[0]), invoke(this.getModule, cls2, new Object[0]))).booleanValue();
        }

        public boolean g(Class<?> cls, Class<?> cls2) {
            if (cls.getPackage() == null) {
                return true;
            }
            return ((Boolean) invoke(this.isExported, invoke(this.getModule, cls, new Object[0]), cls.getPackage().getName(), invoke(this.getModule, cls2, new Object[0]))).booleanValue();
        }

        private ModuleSystemFound(ByteBuddy byteBuddy2, SubclassLoader subclassLoader, Random random2) throws Exception {
            this.byteBuddy = byteBuddy2;
            this.loader = subclassLoader;
            this.random = random2;
            this.injectonBaseSuffix = Math.abs(random2.nextInt());
            Class<?> cls = Class.forName("java.lang.Module");
            Class<Class> cls2 = Class.class;
            this.getModule = cls2.getMethod("getModule", new Class[0]);
            Class<String> cls3 = String.class;
            this.isOpen = cls.getMethod("isOpen", new Class[]{cls3, cls});
            this.isExported = cls.getMethod("isExported", new Class[]{cls3, cls});
            this.isExportedUnqualified = cls.getMethod("isExported", new Class[]{cls3});
            this.canRead = cls.getMethod("canRead", new Class[]{cls});
            this.addExports = cls.getMethod("addExports", new Class[]{cls3, cls});
            this.addReads = cls.getMethod("addReads", new Class[]{cls});
            this.addOpens = cls.getMethod("addOpens", new Class[]{cls3, cls});
            this.forName = cls2.getMethod("forName", new Class[]{cls3});
        }
    }

    public static class NoModuleSystemFound extends ModuleHandler {
        private NoModuleSystemFound() {
        }

        public void a(Class<?> cls, Class<?> cls2, boolean z11, boolean z12) {
        }

        public Class<?> b(ClassLoader classLoader, String str) {
            return InjectionBase.class;
        }

        public boolean c(Class<?> cls) {
            return true;
        }

        public boolean d(Class<?> cls, Class<?> cls2) {
            return true;
        }
    }

    public static ModuleHandler e(ByteBuddy byteBuddy, SubclassLoader subclassLoader, Random random) {
        try {
            return new ModuleSystemFound(byteBuddy, subclassLoader, random);
        } catch (Exception unused) {
            return new NoModuleSystemFound();
        }
    }

    public abstract void a(Class<?> cls, Class<?> cls2, boolean z11, boolean z12);

    public abstract Class<?> b(ClassLoader classLoader, String str);

    public abstract boolean c(Class<?> cls);

    public abstract boolean d(Class<?> cls, Class<?> cls2);
}
