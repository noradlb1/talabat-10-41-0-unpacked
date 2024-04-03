package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.ImmutableList;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.FileAttribute;
import java.util.EnumSet;
import java.util.Set;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
abstract class TempFileCreator {
    static final TempFileCreator INSTANCE = pickSecureCreator();

    public static final class JavaIoCreator extends TempFileCreator {
        private static final int TEMP_DIR_ATTEMPTS = 10000;

        private JavaIoCreator() {
            super();
        }

        public File createTempDir() {
            File file = new File(StandardSystemProperty.JAVA_IO_TMPDIR.value());
            String str = System.currentTimeMillis() + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
            for (int i11 = 0; i11 < 10000; i11++) {
                File file2 = new File(file, str + i11);
                if (file2.mkdir()) {
                    return file2;
                }
            }
            throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + str + "0 to " + str + 9999 + ')');
        }

        public File createTempFile(String str) throws IOException {
            return File.createTempFile(str, (String) null, (File) null);
        }
    }

    @IgnoreJRERequirement
    public static final class JavaNioCreator extends TempFileCreator {
        private static final PermissionSupplier directoryPermissions;
        private static final PermissionSupplier filePermissions;

        @IgnoreJRERequirement
        public interface PermissionSupplier {
            FileAttribute<?> get() throws IOException;
        }

        static {
            Set a11 = FileSystems.getDefault().supportedFileAttributeViews();
            if (a11.contains("posix")) {
                filePermissions = new a();
                directoryPermissions = new b();
            } else if (a11.contains("acl")) {
                PermissionSupplier userPermissions = userPermissions();
                directoryPermissions = userPermissions;
                filePermissions = userPermissions;
            } else {
                c cVar = new c();
                directoryPermissions = cVar;
                filePermissions = cVar;
            }
        }

        private JavaNioCreator() {
            super();
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ FileAttribute lambda$static$2() throws IOException {
            throw new IOException("unrecognized FileSystem type " + FileSystems.getDefault());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ FileAttribute lambda$userPermissions$3(FileAttribute fileAttribute) throws IOException {
            return fileAttribute;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ FileAttribute lambda$userPermissions$4(IOException iOException) throws IOException {
            throw new IOException("Could not find user", iOException);
        }

        private static PermissionSupplier userPermissions() {
            try {
                final ImmutableList of2 = ImmutableList.of(AclEntry.newBuilder().setType(AclEntryType.ALLOW).setPrincipal(FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName(StandardSystemProperty.USER_NAME.value())).setPermissions(EnumSet.allOf(AclEntryPermission.class)).setFlags(new AclEntryFlag[]{AclEntryFlag.DIRECTORY_INHERIT, AclEntryFlag.FILE_INHERIT}).build());
                return new d(new FileAttribute<ImmutableList<AclEntry>>() {
                    public String name() {
                        return "acl:acl";
                    }

                    public ImmutableList<AclEntry> value() {
                        return ImmutableList.this;
                    }
                });
            } catch (IOException e11) {
                return new e(e11);
            }
        }

        public File createTempDir() {
            try {
                return Files.createTempDirectory(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]), (String) null, new FileAttribute[]{directoryPermissions.get()}).toFile();
            } catch (IOException e11) {
                throw new IllegalStateException("Failed to create directory", e11);
            }
        }

        public File createTempFile(String str) throws IOException {
            return Files.createTempFile(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]), str, (String) null, new FileAttribute[]{filePermissions.get()}).toFile();
        }
    }

    public static final class ThrowingCreator extends TempFileCreator {
        private static final String MESSAGE = "Guava cannot securely create temporary files or directories under SDK versions before Jelly Bean. You can create one yourself, either in the insecure default directory or in a more secure directory, such as context.getCacheDir(). For more information, see the Javadoc for Files.createTempDir().";

        private ThrowingCreator() {
            super();
        }

        public File createTempDir() {
            throw new IllegalStateException(MESSAGE);
        }

        public File createTempFile(String str) throws IOException {
            throw new IOException(MESSAGE);
        }
    }

    private TempFileCreator() {
    }

    private static TempFileCreator pickSecureCreator() {
        try {
            Class.forName("java.nio.file.Path");
            return new JavaNioCreator();
        } catch (ClassNotFoundException unused) {
            try {
                if (((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null)).intValue() < ((Integer) Class.forName("android.os.Build$VERSION_CODES").getField("JELLY_BEAN").get((Object) null)).intValue()) {
                    return new ThrowingCreator();
                }
                return new JavaIoCreator();
            } catch (NoSuchFieldException unused2) {
                return new ThrowingCreator();
            } catch (ClassNotFoundException unused3) {
                return new ThrowingCreator();
            } catch (IllegalAccessException unused4) {
                return new ThrowingCreator();
            }
        }
    }

    public abstract File createTempDir();

    public abstract File createTempFile(String str) throws IOException;
}
