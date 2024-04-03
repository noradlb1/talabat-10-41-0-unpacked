package net.bytebuddy.agent;

import android.support.v4.media.session.PlaybackStateCompat;
import com.apptimize.c;
import com.braze.models.FeatureFlag;
import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public interface VirtualMachine {

    public static abstract class AbstractBase implements VirtualMachine {
        public void loadAgent(String str) throws IOException {
            loadAgent(str, (String) null);
        }

        public void loadAgentLibrary(String str) throws IOException {
            loadAgentLibrary(str, (String) null);
        }

        public void loadAgentPath(String str) throws IOException {
            loadAgentPath(str, (String) null);
        }
    }

    public static class ForOpenJ9 extends AbstractBase {
        private static final String IBM_TEMPORARY_FOLDER = "com.ibm.tools.attach.directory";
        private final Socket socket;

        public interface Dispatcher {

            public static class ForJnaPosixEnvironment implements Dispatcher {
                private final int attempts;

                /* renamed from: library  reason: collision with root package name */
                private final PosixLibrary f26932library = ((PosixLibrary) Native.loadLibrary(c.f41585a, PosixLibrary.class));
                private final long pause;
                private final TimeUnit timeUnit;

                public interface PosixLibrary extends Library {
                    public static final int EAGAIN = 11;
                    public static final int EDEADLK = 35;
                    public static final int ESRCH = 3;
                    public static final short IPC_NOWAIT = 2048;
                    public static final int NULL_SIGNAL = 0;
                    public static final short SEM_UNDO = 4096;

                    public static class SemaphoreOperation extends Structure {
                        public short flags;
                        public short number;
                        public short operation;
                    }

                    int chmod(String str, int i11) throws LastErrorException;

                    int ftok(String str, int i11) throws LastErrorException;

                    int getpid() throws LastErrorException;

                    int getuid() throws LastErrorException;

                    int kill(int i11, int i12) throws LastErrorException;

                    int semget(int i11, int i12, int i13) throws LastErrorException;

                    int semop(int i11, SemaphoreOperation semaphoreOperation, int i12) throws LastErrorException;
                }

                public ForJnaPosixEnvironment(int i11, long j11, TimeUnit timeUnit2) {
                    this.attempts = i11;
                    this.pause = j11;
                    this.timeUnit = timeUnit2;
                }

                @SuppressFBWarnings(justification = "Modifier is required by JNA.", value = {"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD", "UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD"})
                private void notifySemaphore(File file, String str, int i11, short s11, short s12, boolean z11) {
                    PosixLibrary posixLibrary = this.f26932library;
                    int semget = posixLibrary.semget(posixLibrary.ftok(new File(file, str).getAbsolutePath(), Opcodes.IF_ICMPLT), 2, 438);
                    PosixLibrary.SemaphoreOperation semaphoreOperation = new PosixLibrary.SemaphoreOperation();
                    semaphoreOperation.operation = s11;
                    semaphoreOperation.flags = s12;
                    while (true) {
                        int i12 = i11 - 1;
                        if (i11 > 0) {
                            try {
                                this.f26932library.semop(semget, semaphoreOperation, 1);
                                i11 = i12;
                            } catch (LastErrorException e11) {
                                if (z11) {
                                    if (Native.getLastError() == 11) {
                                        return;
                                    }
                                    if (Native.getLastError() == 35) {
                                        return;
                                    }
                                }
                                throw e11;
                            }
                        } else {
                            return;
                        }
                    }
                }

                public void decrementSemaphore(File file, String str, boolean z11, int i11) {
                    notifySemaphore(file, str, i11, -1, 6144, true);
                }

                /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
                    java.lang.Thread.sleep(r5.timeUnit.toMillis(r5.pause));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x0061, code lost:
                    r0 = r0 - 1;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
                    r0 = false;
                 */
                /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0056 */
                @edu.umd.cs.findbugs.annotations.SuppressFBWarnings(justification = "The stream life-cycle is bound to its process.", value = {"OS_OPEN_STREAM"})
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public int getOwnerIdOf(java.io.File r6) {
                    /*
                        r5 = this;
                        boolean r0 = com.sun.jna.Platform.isMac()     // Catch:{ IOException -> 0x0086 }
                        if (r0 == 0) goto L_0x0009
                        java.lang.String r0 = "-f"
                        goto L_0x000b
                    L_0x0009:
                        java.lang.String r0 = "-c"
                    L_0x000b:
                        java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0086 }
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0086 }
                        r2.<init>()     // Catch:{ IOException -> 0x0086 }
                        java.lang.String r3 = "stat "
                        r2.append(r3)     // Catch:{ IOException -> 0x0086 }
                        r2.append(r0)     // Catch:{ IOException -> 0x0086 }
                        java.lang.String r0 = " %u "
                        r2.append(r0)     // Catch:{ IOException -> 0x0086 }
                        java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ IOException -> 0x0086 }
                        r2.append(r6)     // Catch:{ IOException -> 0x0086 }
                        java.lang.String r6 = r2.toString()     // Catch:{ IOException -> 0x0086 }
                        java.lang.Process r6 = r1.exec(r6)     // Catch:{ IOException -> 0x0086 }
                        int r0 = r5.attempts     // Catch:{ IOException -> 0x0086 }
                        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0086 }
                        java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0086 }
                        java.io.InputStream r3 = r6.getInputStream()     // Catch:{ IOException -> 0x0086 }
                        java.lang.String r4 = "UTF-8"
                        r2.<init>(r3, r4)     // Catch:{ IOException -> 0x0086 }
                        r1.<init>(r2)     // Catch:{ IOException -> 0x0086 }
                        java.lang.String r1 = r1.readLine()     // Catch:{ IOException -> 0x0086 }
                    L_0x0046:
                        int r2 = r6.exitValue()     // Catch:{ IllegalThreadStateException -> 0x0056 }
                        if (r2 != 0) goto L_0x004e
                        r0 = 1
                        goto L_0x0066
                    L_0x004e:
                        java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ IllegalThreadStateException -> 0x0056 }
                        java.lang.String r3 = "Error while executing stat"
                        r2.<init>(r3)     // Catch:{ IllegalThreadStateException -> 0x0056 }
                        throw r2     // Catch:{ IllegalThreadStateException -> 0x0056 }
                    L_0x0056:
                        java.util.concurrent.TimeUnit r2 = r5.timeUnit     // Catch:{ InterruptedException -> 0x0078 }
                        long r3 = r5.pause     // Catch:{ InterruptedException -> 0x0078 }
                        long r2 = r2.toMillis(r3)     // Catch:{ InterruptedException -> 0x0078 }
                        java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x0078 }
                        int r0 = r0 + -1
                        if (r0 > 0) goto L_0x0046
                        r0 = 0
                    L_0x0066:
                        if (r0 == 0) goto L_0x006d
                        int r6 = java.lang.Integer.parseInt(r1)     // Catch:{ IOException -> 0x0086 }
                        return r6
                    L_0x006d:
                        r6.destroy()     // Catch:{ IOException -> 0x0086 }
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x0086 }
                        java.lang.String r0 = "Command for stat did not exit in time"
                        r6.<init>(r0)     // Catch:{ IOException -> 0x0086 }
                        throw r6     // Catch:{ IOException -> 0x0086 }
                    L_0x0078:
                        r6 = move-exception
                        java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ IOException -> 0x0086 }
                        r0.interrupt()     // Catch:{ IOException -> 0x0086 }
                        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x0086 }
                        r0.<init>(r6)     // Catch:{ IOException -> 0x0086 }
                        throw r0     // Catch:{ IOException -> 0x0086 }
                    L_0x0086:
                        r6 = move-exception
                        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                        java.lang.String r1 = "Unable to execute stat command"
                        r0.<init>(r1, r6)
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher.ForJnaPosixEnvironment.getOwnerIdOf(java.io.File):int");
                }

                public String getTemporaryFolder() {
                    String str = System.getenv("TMPDIR");
                    if (str == null) {
                        return "/tmp";
                    }
                    return str;
                }

                public void incrementSemaphore(File file, String str, boolean z11, int i11) {
                    notifySemaphore(file, str, i11, 1, 0, false);
                }

                public boolean isExistingProcess(int i11) {
                    return this.f26932library.kill(i11, 0) != 3;
                }

                public int pid() {
                    return this.f26932library.getpid();
                }

                public void setPermissions(File file, int i11) {
                    this.f26932library.chmod(file.getAbsolutePath(), i11);
                }

                public int userId() {
                    return this.f26932library.getuid();
                }
            }

            public static class ForJnaWindowsEnvironment implements Dispatcher {
                private static final String CREATION_MUTEX_NAME = "j9shsemcreationMutex";
                private static final int NO_USER_ID = 0;

                /* renamed from: library  reason: collision with root package name */
                private final WindowsLibrary f26933library = ((WindowsLibrary) Native.loadLibrary("kernel32", WindowsLibrary.class, W32APIOptions.DEFAULT_OPTIONS));

                public static class AttachmentHandle implements Closeable {
                    private final WinNT.HANDLE child;
                    private final WinNT.HANDLE parent;

                    public AttachmentHandle(WinNT.HANDLE handle, WinNT.HANDLE handle2) {
                        this.parent = handle;
                        this.child = handle2;
                    }

                    public WinNT.HANDLE a() {
                        return this.child;
                    }

                    public void close() {
                        Kernel32 kernel32;
                        WinNT.HANDLE handle;
                        try {
                            if (!Kernel32.INSTANCE.CloseHandle(this.child)) {
                                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                            } else if (!kernel32.CloseHandle(handle)) {
                                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                            }
                        } finally {
                            Kernel32.INSTANCE.CloseHandle(this.parent);
                        }
                    }
                }

                public interface WindowsLibrary extends StdCallLibrary {
                    public static final int SEMAPHORE_ALL_ACCESS = 2031619;

                    @SuppressFBWarnings(justification = "Field required by native implementation.", value = {"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD", "UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD"})
                    public static class SecurityAttributes extends Structure {
                        public boolean inherit;
                        public WinDef.DWORD length;
                        public Pointer securityDescriptor;
                    }

                    WinNT.HANDLE CreateMutex(SecurityAttributes securityAttributes, boolean z11, String str);

                    WinNT.HANDLE CreateSemaphoreW(WinBase.SECURITY_ATTRIBUTES security_attributes, long j11, long j12, String str);

                    WinNT.HANDLE OpenMutex(int i11, boolean z11, String str);

                    WinNT.HANDLE OpenSemaphoreW(int i11, boolean z11, String str);

                    boolean ReleaseMutex(WinNT.HANDLE handle);

                    boolean ReleaseSemaphore(WinNT.HANDLE handle, long j11, Long l11);
                }

                private AttachmentHandle openSemaphore(File file, String str, boolean z11) {
                    String str2;
                    WinNT.SECURITY_DESCRIPTOR security_descriptor = new WinNT.SECURITY_DESCRIPTOR(65536);
                    if (!Advapi32.INSTANCE.InitializeSecurityDescriptor(security_descriptor, 1)) {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    } else if (Advapi32.INSTANCE.SetSecurityDescriptorDacl(security_descriptor, true, (WinNT.ACL) null, true)) {
                        WindowsLibrary.SecurityAttributes securityAttributes = new WindowsLibrary.SecurityAttributes();
                        securityAttributes.length = new WinDef.DWORD((long) securityAttributes.size());
                        securityAttributes.securityDescriptor = security_descriptor.getPointer();
                        WinNT.HANDLE CreateMutex = this.f26933library.CreateMutex(securityAttributes, false, CREATION_MUTEX_NAME);
                        if (CreateMutex == null) {
                            int GetLastError = Kernel32.INSTANCE.GetLastError();
                            if (GetLastError == 183) {
                                CreateMutex = this.f26933library.OpenMutex(2031617, false, CREATION_MUTEX_NAME);
                                if (CreateMutex == null) {
                                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                                }
                            } else {
                                throw new Win32Exception(GetLastError);
                            }
                        }
                        int WaitForSingleObject = Kernel32.INSTANCE.WaitForSingleObject(CreateMutex, 2000);
                        if (WaitForSingleObject == -1 || WaitForSingleObject == 258) {
                            throw new Win32Exception(WaitForSingleObject);
                        }
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            if (z11) {
                                str2 = "Global\\";
                            } else {
                                str2 = "";
                            }
                            sb2.append(str2);
                            sb2.append((file.getAbsolutePath() + '_' + str).replaceAll("[^a-zA-Z0-9_]", ""));
                            sb2.append("_semaphore");
                            String sb3 = sb2.toString();
                            WinNT.HANDLE OpenSemaphoreW = this.f26933library.OpenSemaphoreW(WindowsLibrary.SEMAPHORE_ALL_ACCESS, false, sb3);
                            if (OpenSemaphoreW == null) {
                                WinNT.HANDLE CreateSemaphoreW = this.f26933library.CreateSemaphoreW((WinBase.SECURITY_ATTRIBUTES) null, 0, 2147483647L, sb3);
                                if (CreateSemaphoreW != null) {
                                    WindowsLibrary windowsLibrary = this.f26933library;
                                    WinNT.HANDLE CreateSemaphoreW2 = windowsLibrary.CreateSemaphoreW((WinBase.SECURITY_ATTRIBUTES) null, 0, 2147483647L, sb3 + "_set0");
                                    if (CreateSemaphoreW2 != null) {
                                        AttachmentHandle attachmentHandle = new AttachmentHandle(CreateSemaphoreW, CreateSemaphoreW2);
                                        if (this.f26933library.ReleaseMutex(CreateMutex)) {
                                            return attachmentHandle;
                                        }
                                        throw new Win32Exception(Native.getLastError());
                                    }
                                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                                }
                                throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                            }
                            WindowsLibrary windowsLibrary2 = this.f26933library;
                            WinNT.HANDLE OpenSemaphoreW2 = windowsLibrary2.OpenSemaphoreW(WindowsLibrary.SEMAPHORE_ALL_ACCESS, false, sb3 + "_set0");
                            if (OpenSemaphoreW2 != null) {
                                AttachmentHandle attachmentHandle2 = new AttachmentHandle(OpenSemaphoreW, OpenSemaphoreW2);
                                if (this.f26933library.ReleaseMutex(CreateMutex)) {
                                    return attachmentHandle2;
                                }
                                throw new Win32Exception(Native.getLastError());
                            }
                            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                        } catch (Throwable th2) {
                            if (!this.f26933library.ReleaseMutex(CreateMutex)) {
                                throw new Win32Exception(Native.getLastError());
                            }
                            throw th2;
                        }
                    } else {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                }

                /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
                    throw new com.sun.jna.platform.win32.Win32Exception(r4);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
                    if (r4 != 258) goto L_0x0021;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void decrementSemaphore(java.io.File r2, java.lang.String r3, boolean r4, int r5) {
                    /*
                        r1 = this;
                        net.bytebuddy.agent.VirtualMachine$ForOpenJ9$Dispatcher$ForJnaWindowsEnvironment$AttachmentHandle r2 = r1.openSemaphore(r2, r3, r4)
                    L_0x0004:
                        int r3 = r5 + -1
                        if (r5 <= 0) goto L_0x002e
                        com.sun.jna.platform.win32.Kernel32 r4 = com.sun.jna.platform.win32.Kernel32.INSTANCE     // Catch:{ all -> 0x0029 }
                        com.sun.jna.platform.win32.WinNT$HANDLE r5 = r2.a()     // Catch:{ all -> 0x0029 }
                        r0 = 0
                        int r4 = r4.WaitForSingleObject(r5, r0)     // Catch:{ all -> 0x0029 }
                        if (r4 == 0) goto L_0x0027
                        r5 = 128(0x80, float:1.794E-43)
                        if (r4 == r5) goto L_0x0027
                        r3 = 258(0x102, float:3.62E-43)
                        if (r4 != r3) goto L_0x0021
                        r2.close()
                        return
                    L_0x0021:
                        com.sun.jna.platform.win32.Win32Exception r3 = new com.sun.jna.platform.win32.Win32Exception     // Catch:{ all -> 0x0029 }
                        r3.<init>(r4)     // Catch:{ all -> 0x0029 }
                        throw r3     // Catch:{ all -> 0x0029 }
                    L_0x0027:
                        r5 = r3
                        goto L_0x0004
                    L_0x0029:
                        r3 = move-exception
                        r2.close()
                        throw r3
                    L_0x002e:
                        r2.close()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher.ForJnaWindowsEnvironment.decrementSemaphore(java.io.File, java.lang.String, boolean, int):void");
                }

                public int getOwnerIdOf(File file) {
                    return 0;
                }

                public String getTemporaryFolder() {
                    WinDef.DWORD dword = new WinDef.DWORD(260);
                    char[] cArr = new char[dword.intValue()];
                    if (Kernel32.INSTANCE.GetTempPath(dword, cArr).intValue() != 0) {
                        return Native.toString(cArr);
                    }
                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                }

                public void incrementSemaphore(File file, String str, boolean z11, int i11) {
                    AttachmentHandle openSemaphore = openSemaphore(file, str, z11);
                    while (true) {
                        int i12 = i11 - 1;
                        if (i11 > 0) {
                            try {
                                if (this.f26933library.ReleaseSemaphore(openSemaphore.a(), 1, (Long) null)) {
                                    i11 = i12;
                                } else {
                                    throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                                }
                            } catch (Throwable th2) {
                                openSemaphore.close();
                                throw th2;
                            }
                        } else {
                            openSemaphore.close();
                            return;
                        }
                    }
                }

                public boolean isExistingProcess(int i11) {
                    WinNT.HANDLE OpenProcess = Kernel32.INSTANCE.OpenProcess(1024, false, i11);
                    if (OpenProcess != null) {
                        IntByReference intByReference = new IntByReference();
                        if (!Kernel32.INSTANCE.GetExitCodeProcess(OpenProcess, intByReference)) {
                            throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                        } else if (intByReference.getValue() == 259) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
                    }
                }

                public int pid() {
                    return Kernel32.INSTANCE.GetCurrentProcessId();
                }

                public void setPermissions(File file, int i11) {
                }

                public int userId() {
                    return 0;
                }
            }

            void decrementSemaphore(File file, String str, boolean z11, int i11);

            int getOwnerIdOf(File file);

            String getTemporaryFolder();

            void incrementSemaphore(File file, String str, boolean z11, int i11);

            boolean isExistingProcess(int i11);

            int pid();

            void setPermissions(File file, int i11);

            int userId();
        }

        public ForOpenJ9(Socket socket2) {
            this.socket = socket2;
        }

        public static VirtualMachine attach(String str) throws IOException {
            return attach(str, 5000, Platform.isWindows() ? new Dispatcher.ForJnaWindowsEnvironment() : new Dispatcher.ForJnaPosixEnvironment(15, 100, TimeUnit.MILLISECONDS));
        }

        private static byte[] read(Socket socket2) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = socket2.getInputStream().read(bArr);
                if (read == -1) {
                    break;
                }
                if (read > 0) {
                    int i11 = read - 1;
                    if (bArr[i11] == 0) {
                        byteArrayOutputStream.write(bArr, 0, i11);
                        break;
                    }
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            return byteArrayOutputStream.toByteArray();
        }

        private static void write(Socket socket2, byte[] bArr) throws IOException {
            socket2.getOutputStream().write(bArr);
            socket2.getOutputStream().write(0);
            socket2.getOutputStream().flush();
        }

        public void detach() throws IOException {
            try {
                write(this.socket, "ATTACH_DETACH".getBytes("UTF-8"));
                read(this.socket);
            } finally {
                this.socket.close();
            }
        }

        public Properties getAgentProperties() throws IOException {
            write(this.socket, "ATTACH_GETAGENTPROPERTIES".getBytes("UTF-8"));
            Properties properties = new Properties();
            properties.load(new ByteArrayInputStream(read(this.socket)));
            return properties;
        }

        public Properties getSystemProperties() throws IOException {
            write(this.socket, "ATTACH_GETSYSTEMPROPERTIES".getBytes("UTF-8"));
            Properties properties = new Properties();
            properties.load(new ByteArrayInputStream(read(this.socket)));
            return properties;
        }

        public void loadAgent(String str, String str2) throws IOException {
            Socket socket2 = this.socket;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ATTACH_LOADAGENT(instrument,");
            sb2.append(str);
            sb2.append(SignatureVisitor.INSTANCEOF);
            if (str2 == null) {
                str2 = "";
            }
            sb2.append(str2);
            sb2.append(')');
            write(socket2, sb2.toString().getBytes("UTF-8"));
            String str3 = new String(read(this.socket), "UTF-8");
            if (str3.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM failed loading agent: " + str3);
            } else if (!str3.startsWith("ATTACH_ACK") && !str3.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: " + str3);
            }
        }

        public void loadAgentLibrary(String str, String str2) throws IOException {
            String str3;
            Socket socket2 = this.socket;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ATTACH_LOADAGENTLIBRARY(");
            sb2.append(str);
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = AbstractJsonLexerKt.COMMA + str2;
            }
            sb2.append(str3);
            sb2.append(')');
            write(socket2, sb2.toString().getBytes("UTF-8"));
            String str4 = new String(read(this.socket), "UTF-8");
            if (str4.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM failed loading native library: " + str4);
            } else if (!str4.startsWith("ATTACH_ACK") && !str4.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: " + str4);
            }
        }

        public void loadAgentPath(String str, String str2) throws IOException {
            String str3;
            Socket socket2 = this.socket;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ATTACH_LOADAGENTPATH(");
            sb2.append(str);
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = AbstractJsonLexerKt.COMMA + str2;
            }
            sb2.append(str3);
            sb2.append(')');
            write(socket2, sb2.toString().getBytes("UTF-8"));
            String str4 = new String(read(this.socket), "UTF-8");
            if (str4.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM failed loading native agent: " + str4);
            } else if (!str4.startsWith("ATTACH_ACK") && !str4.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: " + str4);
            }
        }

        public String startLocalManagementAgent() throws IOException {
            write(this.socket, "ATTACH_START_LOCAL_MANAGEMENT_AGENT".getBytes("UTF-8"));
            String str = new String(read(this.socket), "UTF-8");
            if (str.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM could not start management agent: " + str);
            } else if (str.startsWith("ATTACH_ACK")) {
                return str.substring(10);
            } else {
                if (str.startsWith("ATTACH_RESULT=")) {
                    return str.substring(14);
                }
                throw new IllegalStateException("Unexpected response: " + str);
            }
        }

        public void startManagementAgent(Properties properties) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            properties.store(byteArrayOutputStream, (String) null);
            write(this.socket, "ATTACH_START_MANAGEMENT_AGENT".getBytes("UTF-8"));
            write(this.socket, byteArrayOutputStream.toByteArray());
            String str = new String(read(this.socket), "UTF-8");
            if (str.startsWith("ATTACH_ERR")) {
                throw new IllegalStateException("Target VM could not start management agent: " + str);
            } else if (!str.startsWith("ATTACH_ACK") && !str.startsWith("ATTACH_RESULT=")) {
                throw new IllegalStateException("Unexpected response: " + str);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:100|(1:102)(1:103)|104|105|106|107|108|243) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x0202 */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:215:0x0384=Splitter:B:215:0x0384, B:155:0x02c7=Splitter:B:155:0x02c7} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static net.bytebuddy.agent.VirtualMachine attach(java.lang.String r30, int r31, net.bytebuddy.agent.VirtualMachine.ForOpenJ9.Dispatcher r32) throws java.io.IOException {
            /*
                r1 = r32
                java.lang.String r0 = "attachNotificationSync"
                java.lang.String r2 = "\n"
                java.lang.String r3 = "_master"
                java.lang.String r4 = "UTF-8"
                java.io.File r5 = new java.io.File
                java.lang.String r6 = r32.getTemporaryFolder()
                java.lang.String r7 = "com.ibm.tools.attach.directory"
                java.lang.String r6 = java.lang.System.getProperty(r7, r6)
                java.lang.String r7 = ".com_ibm_tools_attach"
                r5.<init>(r6, r7)
                java.io.RandomAccessFile r6 = new java.io.RandomAccessFile
                java.io.File r7 = new java.io.File
                java.lang.String r8 = "_attachlock"
                r7.<init>(r5, r8)
                java.lang.String r9 = "rw"
                r6.<init>(r7, r9)
                java.nio.channels.FileChannel r7 = r6.getChannel()     // Catch:{ all -> 0x0395 }
                java.nio.channels.FileLock r7 = r7.lock()     // Catch:{ all -> 0x0395 }
                java.io.RandomAccessFile r10 = new java.io.RandomAccessFile     // Catch:{ all -> 0x038a }
                java.io.File r11 = new java.io.File     // Catch:{ all -> 0x038a }
                r11.<init>(r5, r3)     // Catch:{ all -> 0x038a }
                r10.<init>(r11, r9)     // Catch:{ all -> 0x038a }
                java.nio.channels.FileChannel r11 = r10.getChannel()     // Catch:{ all -> 0x037f }
                java.nio.channels.FileLock r11 = r11.lock()     // Catch:{ all -> 0x037f }
                java.io.File[] r12 = r5.listFiles()     // Catch:{ all -> 0x0374 }
                if (r12 == 0) goto L_0x0356
                int r13 = r32.userId()     // Catch:{ all -> 0x0374 }
                long r13 = (long) r13     // Catch:{ all -> 0x0374 }
                java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x0374 }
                r15.<init>()     // Catch:{ all -> 0x0374 }
                r16 = r6
                int r6 = r12.length     // Catch:{ all -> 0x0354 }
                r17 = r7
                r19 = r3
                r7 = 0
            L_0x005b:
                java.lang.String r3 = "processId"
                if (r7 >= r6) goto L_0x0121
                r20 = r6
                r6 = r12[r7]     // Catch:{ all -> 0x0372 }
                boolean r21 = r6.isDirectory()     // Catch:{ all -> 0x0372 }
                if (r21 == 0) goto L_0x0107
                r21 = r12
                int r12 = r1.getOwnerIdOf(r6)     // Catch:{ all -> 0x0372 }
                r22 = r8
                r23 = r9
                long r8 = (long) r12     // Catch:{ all -> 0x0372 }
                int r8 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
                if (r8 != 0) goto L_0x0102
                java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0372 }
                java.lang.String r9 = "attachInfo"
                r8.<init>(r6, r9)     // Catch:{ all -> 0x0372 }
                boolean r9 = r8.isFile()     // Catch:{ all -> 0x0372 }
                if (r9 == 0) goto L_0x0102
                java.util.Properties r9 = new java.util.Properties     // Catch:{ all -> 0x0372 }
                r9.<init>()     // Catch:{ all -> 0x0372 }
                java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ all -> 0x0372 }
                r12.<init>(r8)     // Catch:{ all -> 0x0372 }
                r9.load(r12)     // Catch:{ all -> 0x00fc }
                r12.close()     // Catch:{ all -> 0x0372 }
                java.lang.String r3 = r9.getProperty(r3)     // Catch:{ all -> 0x0372 }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ all -> 0x0372 }
                r24 = 0
                java.lang.String r12 = "userUid"
                java.lang.String r12 = r9.getProperty(r12)     // Catch:{ NumberFormatException -> 0x00aa }
                long r26 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x00aa }
                goto L_0x00ac
            L_0x00aa:
                r26 = r24
            L_0x00ac:
                int r12 = (r13 > r24 ? 1 : (r13 == r24 ? 0 : -1))
                if (r12 == 0) goto L_0x00c0
                int r28 = (r26 > r24 ? 1 : (r26 == r24 ? 0 : -1))
                if (r28 != 0) goto L_0x00c0
                int r8 = r1.getOwnerIdOf(r8)     // Catch:{ all -> 0x0372 }
                r28 = r4
                r29 = r5
                long r4 = (long) r8     // Catch:{ all -> 0x0372 }
                r26 = r4
                goto L_0x00c4
            L_0x00c0:
                r28 = r4
                r29 = r5
            L_0x00c4:
                long r4 = (long) r3     // Catch:{ all -> 0x0372 }
                int r4 = (r4 > r24 ? 1 : (r4 == r24 ? 0 : -1))
                if (r4 == 0) goto L_0x00f8
                boolean r3 = r1.isExistingProcess(r3)     // Catch:{ all -> 0x0372 }
                if (r3 == 0) goto L_0x00d0
                goto L_0x00f8
            L_0x00d0:
                if (r12 == 0) goto L_0x00d6
                int r3 = (r26 > r13 ? 1 : (r26 == r13 ? 0 : -1))
                if (r3 != 0) goto L_0x0111
            L_0x00d6:
                java.io.File[] r3 = r6.listFiles()     // Catch:{ all -> 0x0372 }
                if (r3 == 0) goto L_0x00ee
                int r4 = r3.length     // Catch:{ all -> 0x0372 }
                r5 = 0
            L_0x00de:
                if (r5 >= r4) goto L_0x00ee
                r8 = r3[r5]     // Catch:{ all -> 0x0372 }
                boolean r9 = r8.delete()     // Catch:{ all -> 0x0372 }
                if (r9 != 0) goto L_0x00eb
                r8.deleteOnExit()     // Catch:{ all -> 0x0372 }
            L_0x00eb:
                int r5 = r5 + 1
                goto L_0x00de
            L_0x00ee:
                boolean r3 = r6.delete()     // Catch:{ all -> 0x0372 }
                if (r3 != 0) goto L_0x0111
                r6.deleteOnExit()     // Catch:{ all -> 0x0372 }
                goto L_0x0111
            L_0x00f8:
                r15.add(r9)     // Catch:{ all -> 0x0372 }
                goto L_0x0111
            L_0x00fc:
                r0 = move-exception
                r1 = r0
                r12.close()     // Catch:{ all -> 0x0372 }
                throw r1     // Catch:{ all -> 0x0372 }
            L_0x0102:
                r28 = r4
                r29 = r5
                goto L_0x0111
            L_0x0107:
                r28 = r4
                r29 = r5
                r22 = r8
                r23 = r9
                r21 = r12
            L_0x0111:
                int r7 = r7 + 1
                r6 = r20
                r12 = r21
                r8 = r22
                r9 = r23
                r4 = r28
                r5 = r29
                goto L_0x005b
            L_0x0121:
                r28 = r4
                r29 = r5
                r22 = r8
                r23 = r9
                r11.release()     // Catch:{ all -> 0x037d }
                r10.close()     // Catch:{ all -> 0x0388 }
                java.util.Iterator r4 = r15.iterator()     // Catch:{ all -> 0x0388 }
            L_0x0133:
                boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0388 }
                if (r5 == 0) goto L_0x014c
                java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0388 }
                java.util.Properties r5 = (java.util.Properties) r5     // Catch:{ all -> 0x0388 }
                java.lang.String r6 = r5.getProperty(r3)     // Catch:{ all -> 0x0388 }
                r7 = r30
                boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ all -> 0x0388 }
                if (r6 == 0) goto L_0x0133
                goto L_0x014d
            L_0x014c:
                r5 = 0
            L_0x014d:
                if (r5 == 0) goto L_0x033b
                java.net.ServerSocket r4 = new java.net.ServerSocket     // Catch:{ all -> 0x0388 }
                r6 = 0
                r4.<init>(r6)     // Catch:{ all -> 0x0388 }
                r7 = r31
                r4.setSoTimeout(r7)     // Catch:{ all -> 0x0336 }
                java.io.File r7 = new java.io.File     // Catch:{ all -> 0x0336 }
                java.lang.String r8 = "vmId"
                java.lang.String r8 = r5.getProperty(r8)     // Catch:{ all -> 0x0336 }
                r9 = r29
                r7.<init>(r9, r8)     // Catch:{ all -> 0x0336 }
                java.security.SecureRandom r8 = new java.security.SecureRandom     // Catch:{ all -> 0x0336 }
                r8.<init>()     // Catch:{ all -> 0x0336 }
                long r10 = r8.nextLong()     // Catch:{ all -> 0x0336 }
                java.lang.String r8 = java.lang.Long.toHexString(r10)     // Catch:{ all -> 0x0336 }
                java.io.File r10 = new java.io.File     // Catch:{ all -> 0x0336 }
                java.lang.String r11 = "replyInfo"
                r10.<init>(r7, r11)     // Catch:{ all -> 0x0336 }
                boolean r7 = r10.createNewFile()     // Catch:{ all -> 0x032b }
                if (r7 == 0) goto L_0x0186
                r7 = 384(0x180, float:5.38E-43)
                r1.setPermissions(r10, r7)     // Catch:{ all -> 0x032b }
            L_0x0186:
                java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x032b }
                r7.<init>(r10)     // Catch:{ all -> 0x032b }
                r11 = r28
                byte[] r12 = r8.getBytes(r11)     // Catch:{ all -> 0x0326 }
                r7.write(r12)     // Catch:{ all -> 0x0326 }
                byte[] r12 = r2.getBytes(r11)     // Catch:{ all -> 0x0326 }
                r7.write(r12)     // Catch:{ all -> 0x0326 }
                int r12 = r4.getLocalPort()     // Catch:{ all -> 0x0326 }
                long r12 = (long) r12     // Catch:{ all -> 0x0326 }
                java.lang.String r12 = java.lang.Long.toString(r12)     // Catch:{ all -> 0x0326 }
                byte[] r12 = r12.getBytes(r11)     // Catch:{ all -> 0x0326 }
                r7.write(r12)     // Catch:{ all -> 0x0326 }
                byte[] r2 = r2.getBytes(r11)     // Catch:{ all -> 0x0326 }
                r7.write(r2)     // Catch:{ all -> 0x0326 }
                r7.close()     // Catch:{ all -> 0x032b }
                java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x032b }
                r2.<init>()     // Catch:{ all -> 0x032b }
                int r7 = r32.pid()     // Catch:{ all -> 0x02f0 }
                long r12 = (long) r7     // Catch:{ all -> 0x02f0 }
                java.lang.String r7 = java.lang.Long.toString(r12)     // Catch:{ all -> 0x02f0 }
                java.util.Iterator r12 = r15.iterator()     // Catch:{ all -> 0x02f0 }
            L_0x01c7:
                boolean r13 = r12.hasNext()     // Catch:{ all -> 0x02f0 }
                if (r13 == 0) goto L_0x020b
                java.lang.Object r13 = r12.next()     // Catch:{ all -> 0x02f0 }
                java.util.Properties r13 = (java.util.Properties) r13     // Catch:{ all -> 0x02f0 }
                java.lang.String r14 = r13.getProperty(r3)     // Catch:{ all -> 0x02f0 }
                boolean r14 = r14.equalsIgnoreCase(r7)     // Catch:{ all -> 0x02f0 }
                if (r14 != 0) goto L_0x0206
                java.lang.String r13 = r13.getProperty(r0)     // Catch:{ all -> 0x02f0 }
                java.io.RandomAccessFile r14 = new java.io.RandomAccessFile     // Catch:{ all -> 0x02f0 }
                if (r13 != 0) goto L_0x01eb
                java.io.File r13 = new java.io.File     // Catch:{ all -> 0x02f0 }
                r13.<init>(r9, r0)     // Catch:{ all -> 0x02f0 }
                goto L_0x01f1
            L_0x01eb:
                java.io.File r15 = new java.io.File     // Catch:{ all -> 0x02f0 }
                r15.<init>(r13)     // Catch:{ all -> 0x02f0 }
                r13 = r15
            L_0x01f1:
                r15 = r23
                r14.<init>(r13, r15)     // Catch:{ all -> 0x02f0 }
                java.nio.channels.FileChannel r13 = r14.getChannel()     // Catch:{ IOException -> 0x0202 }
                java.nio.channels.FileLock r13 = r13.lock()     // Catch:{ IOException -> 0x0202 }
                r2.put(r14, r13)     // Catch:{ IOException -> 0x0202 }
                goto L_0x0208
            L_0x0202:
                r14.close()     // Catch:{ all -> 0x02f0 }
                goto L_0x0208
            L_0x0206:
                r15 = r23
            L_0x0208:
                r23 = r15
                goto L_0x01c7
            L_0x020b:
                java.io.File[] r0 = r9.listFiles()     // Catch:{ all -> 0x02f0 }
                java.lang.String r3 = "_notifier"
                if (r0 == 0) goto L_0x024e
                int r7 = r0.length     // Catch:{ all -> 0x02f0 }
                r12 = r6
            L_0x0215:
                if (r6 >= r7) goto L_0x024c
                r13 = r0[r6]     // Catch:{ all -> 0x02f0 }
                java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x02f0 }
                java.lang.String r14 = ".trash_"
                boolean r14 = r13.startsWith(r14)     // Catch:{ all -> 0x02f0 }
                if (r14 != 0) goto L_0x0241
                r14 = r22
                boolean r15 = r13.equalsIgnoreCase(r14)     // Catch:{ all -> 0x02f0 }
                if (r15 != 0) goto L_0x023e
                r15 = r19
                boolean r18 = r13.equalsIgnoreCase(r15)     // Catch:{ all -> 0x02f0 }
                if (r18 != 0) goto L_0x0245
                boolean r13 = r13.equalsIgnoreCase(r3)     // Catch:{ all -> 0x02f0 }
                if (r13 != 0) goto L_0x0245
                int r12 = r12 + 1
                goto L_0x0245
            L_0x023e:
                r15 = r19
                goto L_0x0245
            L_0x0241:
                r15 = r19
                r14 = r22
            L_0x0245:
                int r6 = r6 + 1
                r22 = r14
                r19 = r15
                goto L_0x0215
            L_0x024c:
                r7 = r12
                goto L_0x024f
            L_0x024e:
                r7 = r6
            L_0x024f:
                java.lang.String r0 = "globalSemaphore"
                java.lang.String r0 = r5.getProperty(r0)     // Catch:{ all -> 0x02f0 }
                boolean r5 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x02f0 }
                r1.incrementSemaphore(r9, r3, r5, r7)     // Catch:{ all -> 0x02f0 }
                java.net.Socket r0 = r4.accept()     // Catch:{ all -> 0x02eb }
                java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x02eb }
                byte[] r12 = read(r0)     // Catch:{ all -> 0x02eb }
                r6.<init>(r12, r11)     // Catch:{ all -> 0x02eb }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x02eb }
                r11.<init>()     // Catch:{ all -> 0x02eb }
                r12 = 32
                r11.append(r12)     // Catch:{ all -> 0x02eb }
                r11.append(r8)     // Catch:{ all -> 0x02eb }
                r11.append(r12)     // Catch:{ all -> 0x02eb }
                java.lang.String r8 = r11.toString()     // Catch:{ all -> 0x02eb }
                boolean r8 = r6.contains(r8)     // Catch:{ all -> 0x02eb }
                if (r8 == 0) goto L_0x02d1
                net.bytebuddy.agent.VirtualMachine$ForOpenJ9 r6 = new net.bytebuddy.agent.VirtualMachine$ForOpenJ9     // Catch:{ all -> 0x02eb }
                r6.<init>(r0)     // Catch:{ all -> 0x02eb }
                r1.decrementSemaphore(r9, r3, r5, r7)     // Catch:{ all -> 0x02f0 }
                java.util.Set r0 = r2.entrySet()     // Catch:{ all -> 0x032b }
                java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x032b }
            L_0x0293:
                boolean r0 = r1.hasNext()     // Catch:{ all -> 0x032b }
                if (r0 == 0) goto L_0x02be
                java.lang.Object r0 = r1.next()     // Catch:{ all -> 0x032b }
                r2 = r0
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x032b }
                java.lang.Object r0 = r2.getValue()     // Catch:{ all -> 0x02b3 }
                java.nio.channels.FileLock r0 = (java.nio.channels.FileLock) r0     // Catch:{ all -> 0x02b3 }
                r0.release()     // Catch:{ all -> 0x02b3 }
                java.lang.Object r0 = r2.getKey()     // Catch:{ all -> 0x0293 }
                java.io.RandomAccessFile r0 = (java.io.RandomAccessFile) r0     // Catch:{ all -> 0x0293 }
                r0.close()     // Catch:{ all -> 0x0293 }
                goto L_0x0293
            L_0x02b3:
                r0 = move-exception
                java.lang.Object r2 = r2.getKey()     // Catch:{ all -> 0x0293 }
                java.io.RandomAccessFile r2 = (java.io.RandomAccessFile) r2     // Catch:{ all -> 0x0293 }
                r2.close()     // Catch:{ all -> 0x0293 }
                throw r0     // Catch:{ all -> 0x0293 }
            L_0x02be:
                boolean r0 = r10.delete()     // Catch:{ all -> 0x0336 }
                if (r0 != 0) goto L_0x02c7
                r10.deleteOnExit()     // Catch:{ all -> 0x0336 }
            L_0x02c7:
                r4.close()     // Catch:{ all -> 0x0388 }
                r17.release()     // Catch:{ all -> 0x0393 }
                r16.close()
                return r6
            L_0x02d1:
                r0.close()     // Catch:{ all -> 0x02eb }
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x02eb }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x02eb }
                r8.<init>()     // Catch:{ all -> 0x02eb }
                java.lang.String r11 = "Unexpected answered to attachment: "
                r8.append(r11)     // Catch:{ all -> 0x02eb }
                r8.append(r6)     // Catch:{ all -> 0x02eb }
                java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x02eb }
                r0.<init>(r6)     // Catch:{ all -> 0x02eb }
                throw r0     // Catch:{ all -> 0x02eb }
            L_0x02eb:
                r0 = move-exception
                r1.decrementSemaphore(r9, r3, r5, r7)     // Catch:{ all -> 0x02f0 }
                throw r0     // Catch:{ all -> 0x02f0 }
            L_0x02f0:
                r0 = move-exception
                r1 = r0
                java.util.Set r0 = r2.entrySet()     // Catch:{ all -> 0x032b }
                java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x032b }
            L_0x02fa:
                boolean r0 = r2.hasNext()     // Catch:{ all -> 0x032b }
                if (r0 == 0) goto L_0x0325
                java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x032b }
                r3 = r0
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x032b }
                java.lang.Object r0 = r3.getValue()     // Catch:{ all -> 0x031a }
                java.nio.channels.FileLock r0 = (java.nio.channels.FileLock) r0     // Catch:{ all -> 0x031a }
                r0.release()     // Catch:{ all -> 0x031a }
                java.lang.Object r0 = r3.getKey()     // Catch:{ all -> 0x02fa }
                java.io.RandomAccessFile r0 = (java.io.RandomAccessFile) r0     // Catch:{ all -> 0x02fa }
                r0.close()     // Catch:{ all -> 0x02fa }
                goto L_0x02fa
            L_0x031a:
                r0 = move-exception
                java.lang.Object r3 = r3.getKey()     // Catch:{ all -> 0x02fa }
                java.io.RandomAccessFile r3 = (java.io.RandomAccessFile) r3     // Catch:{ all -> 0x02fa }
                r3.close()     // Catch:{ all -> 0x02fa }
                throw r0     // Catch:{ all -> 0x02fa }
            L_0x0325:
                throw r1     // Catch:{ all -> 0x032b }
            L_0x0326:
                r0 = move-exception
                r7.close()     // Catch:{ all -> 0x032b }
                throw r0     // Catch:{ all -> 0x032b }
            L_0x032b:
                r0 = move-exception
                boolean r1 = r10.delete()     // Catch:{ all -> 0x0336 }
                if (r1 != 0) goto L_0x0335
                r10.deleteOnExit()     // Catch:{ all -> 0x0336 }
            L_0x0335:
                throw r0     // Catch:{ all -> 0x0336 }
            L_0x0336:
                r0 = move-exception
                r4.close()     // Catch:{ all -> 0x0388 }
                throw r0     // Catch:{ all -> 0x0388 }
            L_0x033b:
                r9 = r29
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0388 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0388 }
                r1.<init>()     // Catch:{ all -> 0x0388 }
                java.lang.String r2 = "Could not locate target process info in "
                r1.append(r2)     // Catch:{ all -> 0x0388 }
                r1.append(r9)     // Catch:{ all -> 0x0388 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0388 }
                r0.<init>(r1)     // Catch:{ all -> 0x0388 }
                throw r0     // Catch:{ all -> 0x0388 }
            L_0x0354:
                r0 = move-exception
                goto L_0x0377
            L_0x0356:
                r9 = r5
                r16 = r6
                r17 = r7
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0372 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0372 }
                r1.<init>()     // Catch:{ all -> 0x0372 }
                java.lang.String r2 = "No descriptor files found in "
                r1.append(r2)     // Catch:{ all -> 0x0372 }
                r1.append(r9)     // Catch:{ all -> 0x0372 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0372 }
                r0.<init>(r1)     // Catch:{ all -> 0x0372 }
                throw r0     // Catch:{ all -> 0x0372 }
            L_0x0372:
                r0 = move-exception
                goto L_0x0379
            L_0x0374:
                r0 = move-exception
                r16 = r6
            L_0x0377:
                r17 = r7
            L_0x0379:
                r11.release()     // Catch:{ all -> 0x037d }
                throw r0     // Catch:{ all -> 0x037d }
            L_0x037d:
                r0 = move-exception
                goto L_0x0384
            L_0x037f:
                r0 = move-exception
                r16 = r6
                r17 = r7
            L_0x0384:
                r10.close()     // Catch:{ all -> 0x0388 }
                throw r0     // Catch:{ all -> 0x0388 }
            L_0x0388:
                r0 = move-exception
                goto L_0x038f
            L_0x038a:
                r0 = move-exception
                r16 = r6
                r17 = r7
            L_0x038f:
                r17.release()     // Catch:{ all -> 0x0393 }
                throw r0     // Catch:{ all -> 0x0393 }
            L_0x0393:
                r0 = move-exception
                goto L_0x0398
            L_0x0395:
                r0 = move-exception
                r16 = r6
            L_0x0398:
                r16.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.agent.VirtualMachine.ForOpenJ9.attach(java.lang.String, int, net.bytebuddy.agent.VirtualMachine$ForOpenJ9$Dispatcher):net.bytebuddy.agent.VirtualMachine");
        }
    }

    public enum Resolver implements PrivilegedAction<Class<? extends VirtualMachine>> {
        INSTANCE;

        public Class<? extends VirtualMachine> run() {
            try {
                Class.forName("com.sun.jna.Platform");
                return System.getProperty("java.vm.name", "").toUpperCase(Locale.US).contains("J9") ? ForOpenJ9.class : ForHotSpot.class;
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Optional JNA dependency is not available", e11);
            }
        }
    }

    void detach() throws IOException;

    Properties getAgentProperties() throws IOException;

    Properties getSystemProperties() throws IOException;

    void loadAgent(String str) throws IOException;

    void loadAgent(String str, String str2) throws IOException;

    void loadAgentLibrary(String str) throws IOException;

    void loadAgentLibrary(String str, String str2) throws IOException;

    void loadAgentPath(String str) throws IOException;

    void loadAgentPath(String str, String str2) throws IOException;

    String startLocalManagementAgent() throws IOException;

    void startManagementAgent(Properties properties) throws IOException;

    public static class ForHotSpot extends AbstractBase {
        private static final String ARGUMENT_DELIMITER = "=";
        private static final String INSTRUMENT_COMMAND = "instrument";
        private static final String LOAD_COMMAND = "load";
        private static final String PROTOCOL_VERSION = "1";
        private final Connection connection;

        public interface Connection extends Closeable {

            public interface Factory {

                public static abstract class ForSocketFile implements Factory {
                    private static final String ATTACH_FILE_PREFIX = ".attach_pid";
                    private static final String SOCKET_FILE_PREFIX = ".java_pid";
                    private final int attempts;
                    private final long pause;
                    private final String temporaryDirectory;
                    private final TimeUnit timeUnit;

                    public ForSocketFile(String str, int i11, long j11, TimeUnit timeUnit2) {
                        this.temporaryDirectory = str;
                        this.attempts = i11;
                        this.pause = j11;
                        this.timeUnit = timeUnit2;
                    }

                    public abstract void a(String str, int i11);

                    @SuppressFBWarnings(justification = "File name convention is specified.", value = {"DMI_HARDCODED_ABSOLUTE_FILENAME"})
                    public Connection connect(String str) throws IOException {
                        File file = new File(this.temporaryDirectory, SOCKET_FILE_PREFIX + str);
                        if (!file.exists()) {
                            String str2 = ATTACH_FILE_PREFIX + str;
                            File file2 = new File("/proc/" + str + "/cwd/" + str2);
                            try {
                                if (!file2.createNewFile()) {
                                    if (!file2.isFile()) {
                                        throw new IllegalStateException("Could not create attach file: " + file2);
                                    }
                                }
                            } catch (IOException unused) {
                                file2 = new File(this.temporaryDirectory, str2);
                                if (!file2.createNewFile() && !file2.isFile()) {
                                    throw new IllegalStateException("Could not create attach file: " + file2);
                                }
                            }
                            try {
                                a(str, 3);
                                int i11 = this.attempts;
                                while (!file.exists()) {
                                    int i12 = i11 - 1;
                                    if (i11 <= 0) {
                                        break;
                                    }
                                    this.timeUnit.sleep(this.pause);
                                    i11 = i12;
                                }
                                if (!file.exists()) {
                                    throw new IllegalStateException("Target VM did not respond: " + str);
                                } else if (!file2.delete()) {
                                    file2.deleteOnExit();
                                }
                            } catch (InterruptedException e11) {
                                Thread.currentThread().interrupt();
                                throw new IllegalStateException(e11);
                            } catch (Throwable th2) {
                                if (!file2.delete()) {
                                    file2.deleteOnExit();
                                }
                                throw th2;
                            }
                        }
                        return doConnect(file);
                    }

                    public abstract Connection doConnect(File file) throws IOException;
                }

                Connection connect(String str) throws IOException;
            }

            public static class ForJnaPosixSocket extends OnPersistentByteChannel<Integer> {

                /* renamed from: library  reason: collision with root package name */
                private final PosixLibrary f26924library;
                private final File socket;

                public static class Factory extends Factory.ForSocketFile {

                    /* renamed from: library  reason: collision with root package name */
                    private final PosixLibrary f26925library = ((PosixLibrary) Native.loadLibrary(c.f41585a, PosixLibrary.class));

                    public interface MacLibrary extends Library {
                        public static final int CS_DARWIN_USER_TEMP_DIR = 65537;

                        long confstr(int i11, Pointer pointer, long j11);
                    }

                    public Factory(String str, int i11, long j11, TimeUnit timeUnit) {
                        super(str, i11, j11, timeUnit);
                    }

                    public static Factory withDefaultTemporaryFolder(int i11, long j11, TimeUnit timeUnit) {
                        String str = "/tmp";
                        if (Platform.isMac()) {
                            MacLibrary macLibrary = (MacLibrary) Native.loadLibrary(c.f41585a, MacLibrary.class);
                            Memory memory = new Memory(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                            long confstr = macLibrary.confstr(65537, memory, memory.size());
                            if (confstr != 0) {
                                if (confstr <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                                    str = memory.getString(0);
                                }
                            }
                        }
                        return new Factory(str, i11, j11, timeUnit);
                    }

                    public void a(String str, int i11) {
                        this.f26925library.kill(Integer.parseInt(str), i11);
                    }

                    public Connection doConnect(File file) {
                        return new ForJnaPosixSocket(this.f26925library, file);
                    }
                }

                public interface PosixLibrary extends Library {

                    public static class SocketAddress extends Structure {
                        @SuppressFBWarnings(justification = "Field required by native implementation.", value = {"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
                        public short family = 1;
                        public byte[] path = new byte[100];

                        public void a(String str) {
                            try {
                                System.arraycopy(str.getBytes("UTF-8"), 0, this.path, 0, str.length());
                                System.arraycopy(new byte[]{0}, 0, this.path, str.length(), 1);
                            } catch (UnsupportedEncodingException e11) {
                                throw new IllegalStateException(e11);
                            }
                        }
                    }

                    int close(int i11) throws LastErrorException;

                    int connect(int i11, SocketAddress socketAddress, int i12) throws LastErrorException;

                    int kill(int i11, int i12) throws LastErrorException;

                    int read(int i11, ByteBuffer byteBuffer, int i12) throws LastErrorException;

                    int socket(int i11, int i12, int i13) throws LastErrorException;

                    int write(int i11, ByteBuffer byteBuffer, int i12) throws LastErrorException;
                }

                public ForJnaPosixSocket(PosixLibrary posixLibrary, File file) {
                    this.f26924library = posixLibrary;
                    this.socket = file;
                }

                public void close() {
                }

                /* renamed from: e */
                public void a(Integer num) {
                    this.f26924library.close(num.intValue());
                }

                /* renamed from: f */
                public Integer b() {
                    int socket2 = this.f26924library.socket(1, 1, 0);
                    try {
                        PosixLibrary.SocketAddress socketAddress = new PosixLibrary.SocketAddress();
                        socketAddress.a(this.socket.getAbsolutePath());
                        this.f26924library.connect(socket2, socketAddress, socketAddress.size());
                        return Integer.valueOf(socket2);
                    } catch (RuntimeException e11) {
                        this.f26924library.close(socket2);
                        throw e11;
                    }
                }

                /* renamed from: g */
                public int c(Integer num, byte[] bArr) {
                    int read = this.f26924library.read(num.intValue(), ByteBuffer.wrap(bArr), bArr.length);
                    if (read == 0) {
                        return -1;
                    }
                    return read;
                }

                /* renamed from: h */
                public void d(Integer num, byte[] bArr) {
                    this.f26924library.write(num.intValue(), ByteBuffer.wrap(bArr), bArr.length);
                }
            }

            public static class ForJnaSolarisDoor implements Connection {

                /* renamed from: library  reason: collision with root package name */
                private final SolarisLibrary f26926library;
                private final File socket;

                public static class Factory extends Factory.ForSocketFile {

                    /* renamed from: library  reason: collision with root package name */
                    private final SolarisLibrary f26927library = ((SolarisLibrary) Native.loadLibrary(c.f41585a, SolarisLibrary.class));

                    public Factory(int i11, long j11, TimeUnit timeUnit) {
                        super("/tmp", i11, j11, timeUnit);
                    }

                    public void a(String str, int i11) {
                        this.f26927library.kill(Integer.parseInt(str), i11);
                    }

                    public Connection doConnect(File file) {
                        return new ForJnaSolarisDoor(this.f26927library, file);
                    }
                }

                public static class Response implements Response {
                    private final int handle;

                    /* renamed from: library  reason: collision with root package name */
                    private final SolarisLibrary f26928library;

                    public Response(SolarisLibrary solarisLibrary, int i11) {
                        this.f26928library = solarisLibrary;
                        this.handle = i11;
                    }

                    public void close() {
                        this.f26928library.close(this.handle);
                    }

                    public int read(byte[] bArr) {
                        int read = this.f26928library.read(this.handle, ByteBuffer.wrap(bArr), bArr.length);
                        if (read == 0) {
                            return -1;
                        }
                        return read;
                    }
                }

                public interface SolarisLibrary extends Library {

                    public static class DoorArgument extends Structure {
                        public Pointer dataPointer;
                        public int dataSize;
                        public int descriptorCount;
                        public Pointer descriptorPointer;
                        public Pointer resultPointer;
                        public int resultSize;
                    }

                    int close(int i11) throws LastErrorException;

                    int door_call(int i11, DoorArgument doorArgument) throws LastErrorException;

                    int kill(int i11, int i12) throws LastErrorException;

                    int open(String str, int i11) throws LastErrorException;

                    int read(int i11, ByteBuffer byteBuffer, int i12) throws LastErrorException;
                }

                public ForJnaSolarisDoor(SolarisLibrary solarisLibrary, File file) {
                    this.f26926library = solarisLibrary;
                    this.socket = file;
                }

                public void close() {
                }

                @SuppressFBWarnings(justification = "This pattern is required for use of JNA.", value = {"UWF_UNWRITTEN_PUBLIC_OR_PROTECTED_FIELD", "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
                public Response execute(String str, String... strArr) throws IOException {
                    Pointer pointer;
                    int open = this.f26926library.open(this.socket.getAbsolutePath(), 2);
                    try {
                        SolarisLibrary.DoorArgument doorArgument = new SolarisLibrary.DoorArgument();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byteArrayOutputStream.write(str.getBytes("UTF-8"));
                        byteArrayOutputStream.write(0);
                        for (String str2 : strArr) {
                            if (str2 != null) {
                                byteArrayOutputStream.write(str2.getBytes("UTF-8"));
                            }
                            byteArrayOutputStream.write(0);
                        }
                        doorArgument.dataSize = byteArrayOutputStream.size();
                        Memory memory = new Memory((long) byteArrayOutputStream.size());
                        memory.write(0, byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                        doorArgument.dataPointer = memory;
                        Memory memory2 = new Memory(128);
                        doorArgument.resultPointer = memory2;
                        doorArgument.resultSize = (int) memory2.size();
                        if (this.f26926library.door_call(open, doorArgument) != 0) {
                            throw new IllegalStateException("Door call to target VM failed");
                        } else if (doorArgument.resultSize < 4 || doorArgument.resultPointer.getInt(0) != 0) {
                            throw new IllegalStateException("Target VM could not execute door call");
                        } else if (doorArgument.descriptorCount == 1 && (pointer = doorArgument.descriptorPointer) != null) {
                            return new Response(this.f26926library, pointer.getInt(4));
                        } else {
                            throw new IllegalStateException("Did not receive communication descriptor from target VM");
                        }
                    } finally {
                        this.f26926library.close(open);
                    }
                }
            }

            public static class ForJnaWindowsNamedPipe implements Connection {
                private static final int MEM_RELEASE = 32768;
                private final WindowsAttachLibrary attachLibrary;
                private final WinDef.LPVOID code;

                /* renamed from: library  reason: collision with root package name */
                private final WindowsLibrary f26929library;
                private final WinNT.HANDLE process;
                private final SecureRandom random = new SecureRandom();

                public static class Factory implements Factory {
                    public static final String LIBRARY_NAME = "net.bytebuddy.library.name";
                    private final WindowsAttachLibrary attachLibrary = ((WindowsAttachLibrary) Native.loadLibrary(System.getProperty(LIBRARY_NAME, "attach_hotspot_windows"), WindowsAttachLibrary.class));

                    /* renamed from: library  reason: collision with root package name */
                    private final WindowsLibrary f26930library = ((WindowsLibrary) Native.loadLibrary("kernel32", WindowsLibrary.class, W32APIOptions.DEFAULT_OPTIONS));

                    public Connection connect(String str) {
                        WinNT.HANDLE OpenProcess = Kernel32.INSTANCE.OpenProcess(2039803, false, Integer.parseInt(str));
                        if (OpenProcess != null) {
                            try {
                                WinDef.LPVOID allocate_remote_code = this.attachLibrary.allocate_remote_code(OpenProcess);
                                if (allocate_remote_code != null) {
                                    return new ForJnaWindowsNamedPipe(this.f26930library, this.attachLibrary, OpenProcess, allocate_remote_code);
                                }
                                throw new Win32Exception(Native.getLastError());
                            } catch (Throwable th2) {
                                if (!Kernel32.INSTANCE.CloseHandle(OpenProcess)) {
                                    throw new Win32Exception(Native.getLastError());
                                } else if (th2 instanceof RuntimeException) {
                                    throw th2;
                                } else {
                                    throw new IllegalStateException(th2);
                                }
                            }
                        } else {
                            throw new Win32Exception(Native.getLastError());
                        }
                    }
                }

                public static class NamedPipeResponse implements Response {
                    private final WinNT.HANDLE pipe;

                    public NamedPipeResponse(WinNT.HANDLE handle) {
                        this.pipe = handle;
                    }

                    public void close() {
                        try {
                            if (!Kernel32.INSTANCE.DisconnectNamedPipe(this.pipe)) {
                                throw new Win32Exception(Native.getLastError());
                            } else if (!Kernel32.INSTANCE.CloseHandle(this.pipe)) {
                                throw new Win32Exception(Native.getLastError());
                            }
                        } catch (Throwable th2) {
                            if (!Kernel32.INSTANCE.CloseHandle(this.pipe)) {
                                throw new Win32Exception(Native.getLastError());
                            }
                            throw th2;
                        }
                    }

                    public int read(byte[] bArr) {
                        IntByReference intByReference = new IntByReference();
                        if (Kernel32.INSTANCE.ReadFile(this.pipe, bArr, bArr.length, intByReference, (WinBase.OVERLAPPED) null)) {
                            return intByReference.getValue();
                        }
                        int lastError = Native.getLastError();
                        if (lastError == 109) {
                            return -1;
                        }
                        throw new Win32Exception(lastError);
                    }
                }

                public interface WindowsAttachLibrary extends StdCallLibrary {
                    WinDef.LPVOID allocate_remote_argument(WinNT.HANDLE handle, String str, String str2, String str3, String str4, String str5);

                    WinDef.LPVOID allocate_remote_code(WinNT.HANDLE handle);
                }

                public interface WindowsLibrary extends StdCallLibrary {
                    WinNT.HANDLE CreateRemoteThread(WinNT.HANDLE handle, WinBase.SECURITY_ATTRIBUTES security_attributes, int i11, Pointer pointer, Pointer pointer2, WinDef.DWORD dword, Pointer pointer3);

                    boolean GetExitCodeThread(WinNT.HANDLE handle, IntByReference intByReference);

                    Pointer VirtualAllocEx(WinNT.HANDLE handle, Pointer pointer, int i11, int i12, int i13);

                    boolean VirtualFreeEx(WinNT.HANDLE handle, Pointer pointer, int i11, int i12);
                }

                public ForJnaWindowsNamedPipe(WindowsLibrary windowsLibrary, WindowsAttachLibrary windowsAttachLibrary, WinNT.HANDLE handle, WinDef.LPVOID lpvoid) {
                    this.f26929library = windowsLibrary;
                    this.attachLibrary = windowsAttachLibrary;
                    this.process = handle;
                    this.code = lpvoid;
                }

                public void close() {
                    try {
                        if (!this.f26929library.VirtualFreeEx(this.process, this.code.getPointer(), 0, 32768)) {
                            throw new Win32Exception(Native.getLastError());
                        } else if (!Kernel32.INSTANCE.CloseHandle(this.process)) {
                            throw new Win32Exception(Native.getLastError());
                        }
                    } catch (Throwable th2) {
                        if (!Kernel32.INSTANCE.CloseHandle(this.process)) {
                            throw new Win32Exception(Native.getLastError());
                        }
                        throw th2;
                    }
                }

                /* JADX INFO: finally extract failed */
                public Response execute(String str, String... strArr) {
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    WinNT.HANDLE CreateRemoteThread;
                    if (!"1".equals(str)) {
                        throw new IllegalArgumentException("Unknown protocol version: " + str);
                    } else if (strArr.length <= 4) {
                        String str6 = "\\\\.\\pipe\\javatool" + Math.abs(this.random.nextInt() + 1);
                        WinNT.HANDLE CreateNamedPipe = Kernel32.INSTANCE.CreateNamedPipe(str6, 1, 0, 1, 4096, 8192, 0, (WinBase.SECURITY_ATTRIBUTES) null);
                        if (CreateNamedPipe != null) {
                            try {
                                WindowsAttachLibrary windowsAttachLibrary = this.attachLibrary;
                                WinNT.HANDLE handle = this.process;
                                if (strArr.length < 1) {
                                    str2 = null;
                                } else {
                                    str2 = strArr[0];
                                }
                                if (strArr.length < 2) {
                                    str3 = null;
                                } else {
                                    str3 = strArr[1];
                                }
                                if (strArr.length < 3) {
                                    str4 = null;
                                } else {
                                    str4 = strArr[2];
                                }
                                if (strArr.length < 4) {
                                    str5 = null;
                                } else {
                                    str5 = strArr[3];
                                }
                                WinDef.LPVOID allocate_remote_argument = windowsAttachLibrary.allocate_remote_argument(handle, str6, str2, str3, str4, str5);
                                if (allocate_remote_argument != null) {
                                    try {
                                        CreateRemoteThread = this.f26929library.CreateRemoteThread(this.process, (WinBase.SECURITY_ATTRIBUTES) null, 0, this.code.getPointer(), allocate_remote_argument.getPointer(), (WinDef.DWORD) null, (Pointer) null);
                                        if (CreateRemoteThread != null) {
                                            int WaitForSingleObject = Kernel32.INSTANCE.WaitForSingleObject(CreateRemoteThread, -1);
                                            if (WaitForSingleObject == 0) {
                                                IntByReference intByReference = new IntByReference();
                                                if (!this.f26929library.GetExitCodeThread(CreateRemoteThread, intByReference)) {
                                                    throw new Win32Exception(Native.getLastError());
                                                } else if (intByReference.getValue() == 0) {
                                                    if (!Kernel32.INSTANCE.ConnectNamedPipe(CreateNamedPipe, (WinBase.OVERLAPPED) null)) {
                                                        int lastError = Native.getLastError();
                                                        if (lastError != 535) {
                                                            throw new Win32Exception(lastError);
                                                        }
                                                    }
                                                    NamedPipeResponse namedPipeResponse = new NamedPipeResponse(CreateNamedPipe);
                                                    if (!Kernel32.INSTANCE.CloseHandle(CreateRemoteThread)) {
                                                        throw new Win32Exception(Native.getLastError());
                                                    } else if (this.f26929library.VirtualFreeEx(this.process, allocate_remote_argument.getPointer(), 0, 32768)) {
                                                        return namedPipeResponse;
                                                    } else {
                                                        throw new Win32Exception(Native.getLastError());
                                                    }
                                                } else {
                                                    throw new IllegalStateException("Target VM could not dispatch command successfully: " + intByReference.getValue());
                                                }
                                            } else {
                                                throw new Win32Exception(WaitForSingleObject);
                                            }
                                        } else {
                                            throw new Win32Exception(Native.getLastError());
                                        }
                                    } catch (Throwable th2) {
                                        if (!this.f26929library.VirtualFreeEx(this.process, allocate_remote_argument.getPointer(), 0, 32768)) {
                                            throw new Win32Exception(Native.getLastError());
                                        }
                                        throw th2;
                                    }
                                } else {
                                    throw new Win32Exception(Native.getLastError());
                                }
                            } catch (Throwable th3) {
                                if (!Kernel32.INSTANCE.CloseHandle(CreateNamedPipe)) {
                                    throw new Win32Exception(Native.getLastError());
                                } else if (th3 instanceof RuntimeException) {
                                    throw th3;
                                } else {
                                    throw new IllegalStateException(th3);
                                }
                            }
                        } else {
                            throw new Win32Exception(Native.getLastError());
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot supply more then four arguments to Windows attach mechanism: " + Arrays.asList(strArr));
                    }
                }
            }

            public static abstract class OnPersistentByteChannel<T> implements Connection {
                private static final byte[] BLANK = {0};

                public class Response implements Response {
                    private final T connection;

                    public void close() throws IOException {
                        OnPersistentByteChannel.this.a(this.connection);
                    }

                    public int read(byte[] bArr) throws IOException {
                        return OnPersistentByteChannel.this.c(this.connection, bArr);
                    }

                    private Response(T t11) {
                        this.connection = t11;
                    }
                }

                public abstract void a(T t11) throws IOException;

                public abstract T b() throws IOException;

                public abstract int c(T t11, byte[] bArr) throws IOException;

                public abstract void d(T t11, byte[] bArr) throws IOException;

                public Response execute(String str, String... strArr) throws IOException {
                    Object b11 = b();
                    try {
                        d(b11, str.getBytes("UTF-8"));
                        d(b11, BLANK);
                        for (String str2 : strArr) {
                            if (str2 != null) {
                                d(b11, str2.getBytes("UTF-8"));
                            }
                            d(b11, BLANK);
                        }
                        return new Response(b11);
                    } catch (Throwable th2) {
                        a(b11);
                        if (th2 instanceof RuntimeException) {
                            throw ((RuntimeException) th2);
                        } else if (th2 instanceof IOException) {
                            throw th2;
                        } else {
                            throw new IllegalStateException(th2);
                        }
                    }
                }
            }

            public interface Response extends Closeable {
                int read(byte[] bArr) throws IOException;
            }

            Response execute(String str, String... strArr) throws IOException;
        }

        public ForHotSpot(Connection connection2) {
            this.connection = connection2;
        }

        public static VirtualMachine attach(String str) throws IOException {
            if (Platform.isWindows()) {
                return attach(str, new Connection.ForJnaWindowsNamedPipe.Factory());
            }
            if (Platform.isSolaris()) {
                return attach(str, new Connection.ForJnaSolarisDoor.Factory(15, 100, TimeUnit.MILLISECONDS));
            }
            return attach(str, Connection.ForJnaPosixSocket.Factory.withDefaultTemporaryFolder(15, 100, TimeUnit.MILLISECONDS));
        }

        private static void checkHeader(Connection.Response response) throws IOException {
            byte[] bArr = new byte[1];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = response.read(bArr);
                if (read == -1) {
                    break;
                } else if (read > 0) {
                    byte b11 = bArr[0];
                    if (b11 == 10) {
                        break;
                    }
                    byteArrayOutputStream.write(b11);
                }
            }
            int parseInt = Integer.parseInt(byteArrayOutputStream.toString("UTF-8"));
            if (parseInt == 0) {
                return;
            }
            if (parseInt != 101) {
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                while (true) {
                    int read2 = response.read(bArr2);
                    if (read2 != -1) {
                        byteArrayOutputStream2.write(bArr2, 0, read2);
                    } else {
                        throw new IllegalStateException(byteArrayOutputStream2.toString("UTF-8"));
                    }
                }
            } else {
                throw new IOException("Protocol mismatch with target VM");
            }
        }

        private Properties getProperties(String str) throws IOException {
            Connection.Response execute = this.connection.execute("1", str, null, null, null);
            try {
                checkHeader(execute);
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = execute.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        Properties properties = new Properties();
                        properties.load(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                        return properties;
                    }
                }
            } finally {
                execute.close();
            }
        }

        public void a(String str, boolean z11, String str2) throws IOException {
            Connection connection2 = this.connection;
            String[] strArr = new String[4];
            strArr[0] = LOAD_COMMAND;
            strArr[1] = INSTRUMENT_COMMAND;
            strArr[2] = Boolean.toString(z11);
            if (str2 != null) {
                str = str + "=" + str2;
            }
            strArr[3] = str;
            Connection.Response execute = connection2.execute("1", strArr);
            try {
                checkHeader(execute);
            } finally {
                execute.close();
            }
        }

        public void detach() throws IOException {
            this.connection.close();
        }

        public Properties getAgentProperties() throws IOException {
            return getProperties("agentProperties");
        }

        public Properties getSystemProperties() throws IOException {
            return getProperties(FeatureFlag.PROPERTIES);
        }

        public void loadAgent(String str, String str2) throws IOException {
            a(str, false, str2);
        }

        public void loadAgentLibrary(String str, String str2) throws IOException {
            a(str, false, str2);
        }

        public void loadAgentPath(String str, String str2) throws IOException {
            a(str, true, str2);
        }

        public String startLocalManagementAgent() throws IOException {
            Connection.Response execute = this.connection.execute("1", "jcmd", "ManagementAgent.start_local", null, null);
            try {
                checkHeader(execute);
                return getAgentProperties().getProperty("com.sun.management.jmxremote.localConnectorAddress");
            } finally {
                execute.close();
            }
        }

        public void startManagementAgent(Properties properties) throws IOException {
            StringBuilder sb2 = new StringBuilder("ManagementAgent.start ");
            boolean z11 = true;
            for (Map.Entry entry : properties.entrySet()) {
                if (!(entry.getKey() instanceof String) || !((String) entry.getKey()).startsWith("com.sun.management.")) {
                    throw new IllegalArgumentException("Illegal property name: " + entry.getKey());
                }
                if (z11) {
                    z11 = false;
                } else {
                    sb2.append(' ');
                }
                sb2.append(((String) entry.getKey()).substring(19));
                sb2.append(SignatureVisitor.INSTANCEOF);
                String obj = entry.getValue().toString();
                if (obj.contains(" ")) {
                    sb2.append('\'');
                    sb2.append(obj);
                    sb2.append('\'');
                } else {
                    sb2.append(obj);
                }
            }
            Connection.Response execute = this.connection.execute("1", "jcmd", sb2.toString(), null, null);
            try {
                checkHeader(execute);
            } finally {
                execute.close();
            }
        }

        public static VirtualMachine attach(String str, Connection.Factory factory) throws IOException {
            return new ForHotSpot(factory.connect(str));
        }
    }
}
