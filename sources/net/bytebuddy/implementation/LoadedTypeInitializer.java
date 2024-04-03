package net.bytebuddy.implementation;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.privilege.SetAccessibleAction;

public interface LoadedTypeInitializer {

    @HashCodeAndEqualsPlugin.Enhance
    @SuppressFBWarnings(justification = "Serialization is considered opt-in for a rare use case", value = {"SE_BAD_FIELD"})
    public static class Compound implements LoadedTypeInitializer, Serializable {
        private static final long serialVersionUID = 1;
        private final List<LoadedTypeInitializer> loadedTypeInitializers;

        public Compound(LoadedTypeInitializer... loadedTypeInitializerArr) {
            this((List<? extends LoadedTypeInitializer>) Arrays.asList(loadedTypeInitializerArr));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.loadedTypeInitializers.equals(((Compound) obj).loadedTypeInitializers);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.loadedTypeInitializers.hashCode();
        }

        public boolean isAlive() {
            for (LoadedTypeInitializer isAlive : this.loadedTypeInitializers) {
                if (isAlive.isAlive()) {
                    return true;
                }
            }
            return false;
        }

        public void onLoad(Class<?> cls) {
            for (LoadedTypeInitializer onLoad : this.loadedTypeInitializers) {
                onLoad.onLoad(cls);
            }
        }

        public Compound(List<? extends LoadedTypeInitializer> list) {
            this.loadedTypeInitializers = new ArrayList();
            for (LoadedTypeInitializer loadedTypeInitializer : list) {
                if (loadedTypeInitializer instanceof Compound) {
                    this.loadedTypeInitializers.addAll(((Compound) loadedTypeInitializer).loadedTypeInitializers);
                } else if (!(loadedTypeInitializer instanceof NoOp)) {
                    this.loadedTypeInitializers.add(loadedTypeInitializer);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForStaticField implements LoadedTypeInitializer, Serializable {
        private static final boolean ACCESS_CONTROLLER;
        private static final Object STATIC_FIELD = null;
        private static final long serialVersionUID = 1;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
        private final transient Object accessControlContext = getContext();
        private final String fieldName;
        private final Object value;

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

        public ForStaticField(String str, Object obj) {
            this.fieldName = str;
            this.value = obj;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction, Object obj) {
            if (ACCESS_CONTROLLER) {
                return AccessController.doPrivileged(privilegedAction, (AccessControlContext) obj);
            }
            return privilegedAction.run();
        }

        @AccessControllerPlugin.Enhance
        private static Object getContext() {
            if (ACCESS_CONTROLLER) {
                return AccessController.getContext();
            }
            return null;
        }

        private Object readResolve() {
            return new ForStaticField(this.fieldName, this.value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForStaticField forStaticField = (ForStaticField) obj;
            return this.fieldName.equals(forStaticField.fieldName) && this.value.equals(forStaticField.value);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.fieldName.hashCode()) * 31) + this.value.hashCode();
        }

        public boolean isAlive() {
            return true;
        }

        public void onLoad(Class<?> cls) {
            try {
                Field declaredField = cls.getDeclaredField(this.fieldName);
                if (!Modifier.isPublic(declaredField.getModifiers()) || !Modifier.isPublic(declaredField.getDeclaringClass().getModifiers()) || (JavaModule.isSupported() && !JavaModule.ofType(cls).isExported(new TypeDescription.ForLoadedType(cls).getPackage(), JavaModule.ofType(ForStaticField.class)))) {
                    doPrivileged(new SetAccessibleAction(declaredField), this.accessControlContext);
                }
                declaredField.set(STATIC_FIELD, this.value);
            } catch (IllegalAccessException e11) {
                throw new IllegalArgumentException("Cannot access " + this.fieldName + " from " + cls, e11);
            } catch (NoSuchFieldException e12) {
                throw new IllegalStateException("There is no field " + this.fieldName + " defined on " + cls, e12);
            }
        }
    }

    public enum NoOp implements LoadedTypeInitializer {
        INSTANCE;

        public boolean isAlive() {
            return false;
        }

        public void onLoad(Class<?> cls) {
        }
    }

    boolean isAlive();

    void onLoad(Class<?> cls);
}
