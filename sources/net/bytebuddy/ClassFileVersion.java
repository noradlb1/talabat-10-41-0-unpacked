package net.bytebuddy;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.OpenedClassReader;

@HashCodeAndEqualsPlugin.Enhance
public class ClassFileVersion implements Comparable<ClassFileVersion> {
    private static final boolean ACCESS_CONTROLLER;
    public static final ClassFileVersion JAVA_V1 = new ClassFileVersion(Opcodes.V1_1);
    public static final ClassFileVersion JAVA_V10 = new ClassFileVersion(54);
    public static final ClassFileVersion JAVA_V11 = new ClassFileVersion(55);
    public static final ClassFileVersion JAVA_V12 = new ClassFileVersion(56);
    public static final ClassFileVersion JAVA_V13 = new ClassFileVersion(57);
    public static final ClassFileVersion JAVA_V14 = new ClassFileVersion(58);
    public static final ClassFileVersion JAVA_V15 = new ClassFileVersion(59);
    public static final ClassFileVersion JAVA_V16 = new ClassFileVersion(60);
    public static final ClassFileVersion JAVA_V17 = new ClassFileVersion(61);
    public static final ClassFileVersion JAVA_V18 = new ClassFileVersion(62);
    public static final ClassFileVersion JAVA_V2 = new ClassFileVersion(46);
    public static final ClassFileVersion JAVA_V3 = new ClassFileVersion(47);
    public static final ClassFileVersion JAVA_V4 = new ClassFileVersion(48);
    public static final ClassFileVersion JAVA_V5 = new ClassFileVersion(49);
    public static final ClassFileVersion JAVA_V6 = new ClassFileVersion(50);
    public static final ClassFileVersion JAVA_V7 = new ClassFileVersion(51);
    public static final ClassFileVersion JAVA_V8 = new ClassFileVersion(52);
    public static final ClassFileVersion JAVA_V9 = new ClassFileVersion(53);
    private static final VersionLocator VERSION_LOCATOR = ((VersionLocator) doPrivileged(VersionLocator.Resolver.INSTANCE));
    private final int versionNumber;

    public interface VersionLocator {
        public static final String JAVA_VERSION = "java.version";

        @HashCodeAndEqualsPlugin.Enhance
        public static class Resolved implements VersionLocator {
            private final ClassFileVersion classFileVersion;

            public Resolved(ClassFileVersion classFileVersion2) {
                this.classFileVersion = classFileVersion2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.classFileVersion.equals(((Resolved) obj).classFileVersion);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.classFileVersion.hashCode();
            }

            public ClassFileVersion resolve() {
                return this.classFileVersion;
            }
        }

        public enum Resolver implements PrivilegedAction<VersionLocator> {
            INSTANCE;

            @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback", value = {"REC_CATCH_EXCEPTION"})
            public VersionLocator run() {
                Class<Runtime> cls = Runtime.class;
                try {
                    return new Resolved(ClassFileVersion.ofJavaVersion(((Integer) Class.forName(cls.getName() + "$Version").getMethod("major", new Class[0]).invoke(cls.getMethod("version", new Class[0]).invoke((Object) null, new Object[0]), new Object[0])).intValue()));
                } catch (Throwable th2) {
                    return new Unresolved(th2.getMessage());
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        public static class Unresolved implements VersionLocator {
            private final String message;

            public Unresolved(String str) {
                this.message = str;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.message.equals(((Unresolved) obj).message);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.message.hashCode();
            }

            public ClassFileVersion resolve() {
                throw new IllegalStateException("Failed to resolve the class file version of the current VM: " + this.message);
            }
        }

        ClassFileVersion resolve();
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

    public ClassFileVersion(int i11) {
        this.versionNumber = i11;
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        if (ACCESS_CONTROLLER) {
            return AccessController.doPrivileged(privilegedAction);
        }
        return privilegedAction.run();
    }

    public static ClassFileVersion latest() {
        return JAVA_V18;
    }

    public static ClassFileVersion of(Class<?> cls) throws IOException {
        return of(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public static ClassFileVersion ofClassFile(byte[] bArr) {
        if (bArr.length >= 7) {
            return ofMinorMajor((bArr[7] & 255) | (bArr[6] << 8));
        }
        throw new IllegalArgumentException("Supplied byte array is too short to be a class file with " + bArr.length + " byte");
    }

    public static ClassFileVersion ofJavaVersion(int i11) {
        switch (i11) {
            case 1:
                return JAVA_V1;
            case 2:
                return JAVA_V2;
            case 3:
                return JAVA_V3;
            case 4:
                return JAVA_V4;
            case 5:
                return JAVA_V5;
            case 6:
                return JAVA_V6;
            case 7:
                return JAVA_V7;
            case 8:
                return JAVA_V8;
            case 9:
                return JAVA_V9;
            case 10:
                return JAVA_V10;
            case 11:
                return JAVA_V11;
            case 12:
                return JAVA_V12;
            case 13:
                return JAVA_V13;
            case 14:
                return JAVA_V14;
            case 15:
                return JAVA_V15;
            case 16:
                return JAVA_V16;
            case 17:
                return JAVA_V17;
            case 18:
                return JAVA_V18;
            default:
                if (OpenedClassReader.EXPERIMENTAL && i11 > 0) {
                    return new ClassFileVersion(i11 + 44);
                }
                throw new IllegalArgumentException("Unknown Java version: " + i11);
        }
    }

    public static ClassFileVersion ofJavaVersionString(String str) {
        String str2;
        if (str.equals("1.1")) {
            return JAVA_V1;
        }
        if (str.equals("1.2")) {
            return JAVA_V2;
        }
        if (str.equals("1.3")) {
            return JAVA_V3;
        }
        if (str.equals("1.4")) {
            return JAVA_V4;
        }
        if (str.equals("1.5") || str.equals("5")) {
            return JAVA_V5;
        }
        if (str.equals("1.6") || str.equals("6")) {
            return JAVA_V6;
        }
        if (str.equals("1.7") || str.equals("7")) {
            return JAVA_V7;
        }
        if (str.equals("1.8") || str.equals("8")) {
            return JAVA_V8;
        }
        if (str.equals("1.9") || str.equals("9")) {
            return JAVA_V9;
        }
        if (str.equals("1.10") || str.equals("10")) {
            return JAVA_V10;
        }
        if (str.equals("1.11") || str.equals("11")) {
            return JAVA_V11;
        }
        if (str.equals("1.12") || str.equals("12")) {
            return JAVA_V12;
        }
        if (str.equals("1.13") || str.equals("13")) {
            return JAVA_V13;
        }
        if (str.equals("1.14") || str.equals("14")) {
            return JAVA_V14;
        }
        if (str.equals("1.15") || str.equals("15")) {
            return JAVA_V15;
        }
        if (str.equals("1.16") || str.equals("16")) {
            return JAVA_V16;
        }
        if (str.equals("1.17") || str.equals("17")) {
            return JAVA_V17;
        }
        if (str.equals("1.18") || str.equals("18")) {
            return JAVA_V18;
        }
        if (OpenedClassReader.EXPERIMENTAL) {
            try {
                if (str.startsWith("1.")) {
                    str2 = str.substring(2);
                } else {
                    str2 = str;
                }
                int parseInt = Integer.parseInt(str2);
                if (parseInt > 0) {
                    return new ClassFileVersion(parseInt + 44);
                }
            } catch (NumberFormatException unused) {
            }
        }
        throw new IllegalArgumentException("Unknown Java version string: " + str);
    }

    public static ClassFileVersion ofMinorMajor(int i11) {
        ClassFileVersion classFileVersion = new ClassFileVersion(i11);
        if (classFileVersion.getMajorVersion() > 44) {
            return classFileVersion;
        }
        throw new IllegalArgumentException("Class version " + i11 + " is not valid");
    }

    public static ClassFileVersion ofThisVm() {
        return VERSION_LOCATOR.resolve();
    }

    public ClassFileVersion asPreviewVersion() {
        return new ClassFileVersion(this.versionNumber | -65536);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.versionNumber == ((ClassFileVersion) obj).versionNumber;
    }

    public int getJavaVersion() {
        return getMajorVersion() - 44;
    }

    public short getMajorVersion() {
        return (short) (this.versionNumber & 255);
    }

    public int getMinorMajorVersion() {
        return this.versionNumber;
    }

    public short getMinorVersion() {
        return (short) (this.versionNumber >> 16);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.versionNumber;
    }

    public boolean isAtLeast(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) > -1;
    }

    public boolean isAtMost(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) < 1;
    }

    public boolean isGreaterThan(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) > 0;
    }

    public boolean isLessThan(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) < 0;
    }

    public boolean isPreviewVersion() {
        return (this.versionNumber & -65536) == -65536;
    }

    public String toString() {
        return "Java " + getJavaVersion() + " (" + getMinorMajorVersion() + ")";
    }

    public static ClassFileVersion of(Class<?> cls, ClassFileLocator classFileLocator) throws IOException {
        return of(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    @SuppressFBWarnings(justification = "Exception should not be rethrown but trigger a fallback", value = {"REC_CATCH_EXCEPTION"})
    public static ClassFileVersion ofThisVm(ClassFileVersion classFileVersion) {
        try {
            return ofThisVm();
        } catch (Exception unused) {
            return classFileVersion;
        }
    }

    public int compareTo(ClassFileVersion classFileVersion) {
        short s11;
        short s12;
        if (getMajorVersion() == classFileVersion.getMajorVersion()) {
            s12 = getMinorVersion();
            s11 = classFileVersion.getMinorVersion();
        } else {
            s12 = getMajorVersion();
            s11 = classFileVersion.getMajorVersion();
        }
        return Integer.signum(s12 - s11);
    }

    public static ClassFileVersion of(TypeDescription typeDescription, ClassFileLocator classFileLocator) throws IOException {
        return ofClassFile(classFileLocator.locate(typeDescription.getName()).resolve());
    }
}
