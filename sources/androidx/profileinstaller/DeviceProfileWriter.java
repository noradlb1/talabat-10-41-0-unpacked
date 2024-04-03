package androidx.profileinstaller;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.profileinstaller.ProfileInstaller;
import i2.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DeviceProfileWriter {
    @NonNull
    private final String mApkName;
    @NonNull
    private final AssetManager mAssetManager;
    @NonNull
    private final File mCurProfile;
    @Nullable
    private final byte[] mDesiredVersion;
    private boolean mDeviceSupportsAotProfile = false;
    @NonNull
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    @NonNull
    private final Executor mExecutor;
    @Nullable
    private DexProfileData[] mProfile;
    @NonNull
    private final String mProfileMetaSourceLocation;
    @NonNull
    private final String mProfileSourceLocation;
    @Nullable
    private byte[] mTranscodedProfile;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter(@NonNull AssetManager assetManager, @NonNull Executor executor, @NonNull ProfileInstaller.DiagnosticsCallback diagnosticsCallback, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull File file) {
        this.mAssetManager = assetManager;
        this.mExecutor = executor;
        this.mDiagnostics = diagnosticsCallback;
        this.mApkName = str;
        this.mProfileSourceLocation = str2;
        this.mProfileMetaSourceLocation = str3;
        this.mCurProfile = file;
        this.mDesiredVersion = desiredVersion();
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (!this.mDeviceSupportsAotProfile) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    @Nullable
    private static byte[] desiredVersion() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 24) {
            return null;
        }
        switch (i11) {
            case 24:
            case 25:
                return ProfileVersion.f37399e;
            case 26:
                return ProfileVersion.f37398d;
            case 27:
                return ProfileVersion.f37397c;
            case 28:
            case 29:
            case 30:
                return ProfileVersion.f37396b;
            case 31:
                return ProfileVersion.f37395a;
            default:
                return null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$result$0(int i11, Object obj) {
        this.mDiagnostics.onResultReceived(i11, obj);
    }

    private static boolean requiresMetadata() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 24) {
            return false;
        }
        return i11 == 24 || i11 == 25 || i11 == 31;
    }

    private void result(int i11, @Nullable Object obj) {
        this.mExecutor.execute(new a(this, i11, obj));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion == null) {
            result(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        } else if (!this.mCurProfile.canWrite()) {
            result(4, (Object) null);
            return false;
        } else {
            this.mDeviceSupportsAotProfile = true;
            return true;
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter read() {
        FileInputStream createInputStream;
        FileInputStream createInputStream2;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion == null) {
            return this;
        }
        try {
            AssetFileDescriptor openFd = this.mAssetManager.openFd(this.mProfileSourceLocation);
            try {
                createInputStream2 = openFd.createInputStream();
                this.mProfile = ProfileTranscoder.e(createInputStream2, ProfileTranscoder.a(createInputStream2, ProfileTranscoder.f37393a), this.mApkName);
                if (createInputStream2 != null) {
                    createInputStream2.close();
                }
                openFd.close();
                DexProfileData[] dexProfileDataArr = this.mProfile;
                if (dexProfileDataArr != null && requiresMetadata()) {
                    try {
                        AssetFileDescriptor openFd2 = this.mAssetManager.openFd(this.mProfileMetaSourceLocation);
                        try {
                            createInputStream = openFd2.createInputStream();
                            this.mProfile = ProfileTranscoder.b(createInputStream, ProfileTranscoder.a(createInputStream, ProfileTranscoder.f37394b), this.mDesiredVersion, dexProfileDataArr);
                            if (createInputStream != null) {
                                createInputStream.close();
                            }
                            openFd2.close();
                            return this;
                        } catch (Throwable th2) {
                            if (openFd2 != null) {
                                openFd2.close();
                            }
                            throw th2;
                        }
                    } catch (FileNotFoundException e11) {
                        this.mDiagnostics.onResultReceived(9, e11);
                    } catch (IOException e12) {
                        this.mDiagnostics.onResultReceived(7, e12);
                    } catch (IllegalStateException e13) {
                        this.mProfile = null;
                        this.mDiagnostics.onResultReceived(8, e13);
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                return this;
            } catch (Throwable th4) {
                if (openFd != null) {
                    openFd.close();
                }
                throw th4;
            }
        } catch (FileNotFoundException e14) {
            this.mDiagnostics.onResultReceived(6, e14);
        } catch (IOException e15) {
            this.mDiagnostics.onResultReceived(7, e15);
        } catch (IllegalStateException e16) {
            this.mDiagnostics.onResultReceived(8, e16);
        } catch (Throwable th5) {
            th4.addSuppressed(th5);
        }
        throw th;
        throw th;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter transcodeIfNeeded() {
        ByteArrayOutputStream byteArrayOutputStream;
        DexProfileData[] dexProfileDataArr = this.mProfile;
        byte[] bArr = this.mDesiredVersion;
        if (!(dexProfileDataArr == null || bArr == null)) {
            assertDeviceAllowsProfileInstallerAotWritesCalled();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                ProfileTranscoder.g(byteArrayOutputStream, bArr);
                if (!ProfileTranscoder.f(byteArrayOutputStream, bArr, dexProfileDataArr)) {
                    this.mDiagnostics.onResultReceived(5, (Object) null);
                    this.mProfile = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.mTranscodedProfile = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.mProfile = null;
            } catch (IOException e11) {
                this.mDiagnostics.onResultReceived(7, e11);
            } catch (IllegalStateException e12) {
                this.mDiagnostics.onResultReceived(8, e12);
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        return this;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean write() {
        FileOutputStream fileOutputStream;
        byte[] bArr = this.mTranscodedProfile;
        if (bArr == null) {
            return false;
        }
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                fileOutputStream = new FileOutputStream(this.mCurProfile);
                Encoding.l(byteArrayInputStream, fileOutputStream);
                result(1, (Object) null);
                fileOutputStream.close();
                byteArrayInputStream.close();
                this.mTranscodedProfile = null;
                this.mProfile = null;
                return true;
            } catch (Throwable th2) {
                byteArrayInputStream.close();
                throw th2;
            }
        } catch (FileNotFoundException e11) {
            result(6, e11);
            this.mTranscodedProfile = null;
            this.mProfile = null;
            return false;
        } catch (IOException e12) {
            try {
                result(7, e12);
                this.mTranscodedProfile = null;
                this.mProfile = null;
                return false;
            } catch (Throwable th3) {
                this.mTranscodedProfile = null;
                this.mProfile = null;
                throw th3;
            }
        } catch (Throwable th4) {
            th2.addSuppressed(th4);
        }
        throw th;
    }
}
