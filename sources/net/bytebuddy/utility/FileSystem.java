package net.bytebuddy.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

public abstract class FileSystem {
    private static final boolean ACCESS_CONTROLLER;
    private static /* synthetic */ FileSystem INSTANCE;

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForLegacyVm extends FileSystem {
        public void copy(File file, File file2) throws IOException {
            FileOutputStream fileOutputStream;
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return;
                    }
                }
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return getClass().hashCode();
        }

        public void move(File file, File file2) throws IOException {
            FileOutputStream fileOutputStream;
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                fileInputStream.close();
                if (!file.delete()) {
                    file.deleteOnExit();
                }
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    public static class ForNio2CapableVm extends FileSystem {
        private static final Dispatcher DISPATCHER = ((Dispatcher) FileSystem.doPrivileged(JavaDispatcher.of(Dispatcher.class)));
        private static final Files FILES = ((Files) FileSystem.doPrivileged(JavaDispatcher.of(Files.class)));
        private static final StandardCopyOption STANDARD_COPY_OPTION = ((StandardCopyOption) FileSystem.doPrivileged(JavaDispatcher.of(StandardCopyOption.class)));

        @JavaDispatcher.Proxied("java.io.File")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("toPath")
            Object toPath(File file) throws IOException;
        }

        @JavaDispatcher.Proxied("java.nio.file.Files")
        public interface Files {
            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("copy")
            Object copy(@JavaDispatcher.Proxied("java.nio.file.Path") Object obj, @JavaDispatcher.Proxied("java.nio.file.Path") Object obj2, @JavaDispatcher.Proxied("java.nio.file.CopyOption") Object[] objArr) throws IOException;

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("move")
            Object move(@JavaDispatcher.Proxied("java.nio.file.Path") Object obj, @JavaDispatcher.Proxied("java.nio.file.Path") Object obj2, @JavaDispatcher.Proxied("java.nio.file.CopyOption") Object[] objArr) throws IOException;
        }

        @JavaDispatcher.Proxied("java.nio.file.StandardCopyOption")
        public interface StandardCopyOption {
            @JavaDispatcher.Container
            @JavaDispatcher.Proxied("toArray")
            Object[] toArray(int i11);

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("valueOf")
            Object valueOf(String str);
        }

        public void copy(File file, File file2) throws IOException {
            StandardCopyOption standardCopyOption = STANDARD_COPY_OPTION;
            Object[] array = standardCopyOption.toArray(1);
            array[0] = standardCopyOption.valueOf("REPLACE_EXISTING");
            Files files = FILES;
            Dispatcher dispatcher = DISPATCHER;
            files.copy(dispatcher.toPath(file), dispatcher.toPath(file2), array);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return getClass().hashCode();
        }

        public void move(File file, File file2) throws IOException {
            StandardCopyOption standardCopyOption = STANDARD_COPY_OPTION;
            Object[] array = standardCopyOption.toArray(1);
            array[0] = standardCopyOption.valueOf("REPLACE_EXISTING");
            Files files = FILES;
            Dispatcher dispatcher = DISPATCHER;
            files.move(dispatcher.toPath(file), dispatcher.toPath(file2), array);
        }
    }

    static {
        boolean z11 = false;
        try {
            Class.forName("java.security.AccessController", false, (ClassLoader) null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            return;
        } catch (ClassNotFoundException unused) {
        } catch (SecurityException unused2) {
            z11 = true;
        }
        ACCESS_CONTROLLER = z11;
    }

    /* access modifiers changed from: private */
    @AccessControllerPlugin.Enhance
    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        if (ACCESS_CONTROLLER) {
            return AccessController.doPrivileged(privilegedAction);
        }
        return privilegedAction.run();
    }

    @CachedReturnPlugin.Enhance("INSTANCE")
    public static FileSystem getInstance() {
        FileSystem fileSystem;
        if (INSTANCE != null) {
            fileSystem = null;
        } else {
            try {
                Class.forName("java.nio.file.Files", false, ClassLoadingStrategy.BOOTSTRAP_LOADER);
                fileSystem = new ForNio2CapableVm();
            } catch (ClassNotFoundException unused) {
                fileSystem = new ForLegacyVm();
            }
        }
        if (fileSystem == null) {
            return INSTANCE;
        }
        INSTANCE = fileSystem;
        return fileSystem;
    }

    public abstract void copy(File file, File file2) throws IOException;

    public abstract void move(File file, File file2) throws IOException;
}
