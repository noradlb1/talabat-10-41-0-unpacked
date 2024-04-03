package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.database.core.ValidationPath;
import com.huawei.hms.flutter.map.constants.Param;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class CameraSource {
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_BACK = 0;
    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_FRONT = 1;
    /* access modifiers changed from: private */
    public int facing;
    /* access modifiers changed from: private */
    public int rotation;
    /* access modifiers changed from: private */
    public Context zze;
    /* access modifiers changed from: private */
    public final Object zzf;
    /* access modifiers changed from: private */
    @GuardedBy("cameraLock")
    public Camera zzg;
    /* access modifiers changed from: private */
    public Size zzh;
    /* access modifiers changed from: private */
    public float zzi;
    /* access modifiers changed from: private */
    public int zzj;
    /* access modifiers changed from: private */
    public int zzk;
    /* access modifiers changed from: private */
    public boolean zzl;
    /* access modifiers changed from: private */
    public String zzm;
    private SurfaceTexture zzn;
    private boolean zzo;
    private Thread zzp;
    /* access modifiers changed from: private */
    public zzb zzq;
    /* access modifiers changed from: private */
    public Map<byte[], ByteBuffer> zzr;

    public static class Builder {
        private final Detector<?> zzt;
        private CameraSource zzu;

        public Builder(Context context, Detector<?> detector) {
            CameraSource cameraSource = new CameraSource();
            this.zzu = cameraSource;
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector != null) {
                this.zzt = detector;
                Context unused = cameraSource.zze = context;
            } else {
                throw new IllegalArgumentException("No detector supplied.");
            }
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzu;
            cameraSource.getClass();
            zzb unused = cameraSource.zzq = new zzb(this.zzt);
            return this.zzu;
        }

        public Builder setAutoFocusEnabled(boolean z11) {
            boolean unused = this.zzu.zzl = z11;
            return this;
        }

        public Builder setFacing(int i11) {
            if (i11 == 0 || i11 == 1) {
                int unused = this.zzu.facing = i11;
                return this;
            }
            StringBuilder sb2 = new StringBuilder(27);
            sb2.append("Invalid camera: ");
            sb2.append(i11);
            throw new IllegalArgumentException(sb2.toString());
        }

        public Builder setFocusMode(String str) {
            if (!str.equals("continuous-video") && !str.equals("continuous-picture")) {
                Log.w("CameraSource", String.format("FocusMode %s is not supported for now.", new Object[]{str}));
                str = null;
            }
            String unused = this.zzu.zzm = str;
            return this;
        }

        public Builder setRequestedFps(float f11) {
            if (f11 > 0.0f) {
                float unused = this.zzu.zzi = f11;
                return this;
            }
            StringBuilder sb2 = new StringBuilder(28);
            sb2.append("Invalid fps: ");
            sb2.append(f11);
            throw new IllegalArgumentException(sb2.toString());
        }

        public Builder setRequestedPreviewSize(int i11, int i12) {
            if (i11 <= 0 || i11 > 1000000 || i12 <= 0 || i12 > 1000000) {
                StringBuilder sb2 = new StringBuilder(45);
                sb2.append("Invalid preview size: ");
                sb2.append(i11);
                sb2.append(Param.X);
                sb2.append(i12);
                throw new IllegalArgumentException(sb2.toString());
            }
            int unused = this.zzu.zzj = i11;
            int unused2 = this.zzu.zzk = i12;
            return this;
        }
    }

    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    public class zza implements Camera.PreviewCallback {
        private zza() {
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.zzq.zza(bArr, camera);
        }
    }

    public class zzb implements Runnable {
        private final Object lock = new Object();
        private Detector<?> zzt;
        private long zzv = SystemClock.elapsedRealtime();
        private boolean zzw = true;
        private long zzx;
        private int zzy = 0;
        private ByteBuffer zzz;

        public zzb(Detector<?> detector) {
            this.zzt = detector;
        }

        @SuppressLint({"Assert"})
        public final void release() {
            this.zzt.release();
            this.zzt = null;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r6.zzt.receiveFrame(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x006b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            android.util.Log.e("CameraSource", "Exception thrown from receiver.", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0084, code lost:
            com.google.android.gms.vision.CameraSource.zzb(r6.zzs).addCallbackBuffer(r2.array());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0091, code lost:
            throw r0;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0017  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0015 A[SYNTHETIC] */
        @android.annotation.SuppressLint({"InlinedApi"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r6 = this;
            L_0x0000:
                java.lang.Object r0 = r6.lock
                monitor-enter(r0)
            L_0x0003:
                boolean r1 = r6.zzw     // Catch:{ all -> 0x0092 }
                if (r1 == 0) goto L_0x0013
                java.nio.ByteBuffer r2 = r6.zzz     // Catch:{ all -> 0x0092 }
                if (r2 != 0) goto L_0x0013
                java.lang.Object r1 = r6.lock     // Catch:{ InterruptedException -> 0x0011 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0011 }
                goto L_0x0003
            L_0x0011:
                monitor-exit(r0)     // Catch:{ all -> 0x0092 }
                return
            L_0x0013:
                if (r1 != 0) goto L_0x0017
                monitor-exit(r0)     // Catch:{ all -> 0x0092 }
                return
            L_0x0017:
                com.google.android.gms.vision.Frame$Builder r1 = new com.google.android.gms.vision.Frame$Builder     // Catch:{ all -> 0x0092 }
                r1.<init>()     // Catch:{ all -> 0x0092 }
                java.nio.ByteBuffer r2 = r6.zzz     // Catch:{ all -> 0x0092 }
                com.google.android.gms.vision.CameraSource r3 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x0092 }
                com.google.android.gms.common.images.Size r3 = r3.zzh     // Catch:{ all -> 0x0092 }
                int r3 = r3.getWidth()     // Catch:{ all -> 0x0092 }
                com.google.android.gms.vision.CameraSource r4 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x0092 }
                com.google.android.gms.common.images.Size r4 = r4.zzh     // Catch:{ all -> 0x0092 }
                int r4 = r4.getHeight()     // Catch:{ all -> 0x0092 }
                r5 = 17
                com.google.android.gms.vision.Frame$Builder r1 = r1.setImageData(r2, r3, r4, r5)     // Catch:{ all -> 0x0092 }
                int r2 = r6.zzy     // Catch:{ all -> 0x0092 }
                com.google.android.gms.vision.Frame$Builder r1 = r1.setId(r2)     // Catch:{ all -> 0x0092 }
                long r2 = r6.zzx     // Catch:{ all -> 0x0092 }
                com.google.android.gms.vision.Frame$Builder r1 = r1.setTimestampMillis(r2)     // Catch:{ all -> 0x0092 }
                com.google.android.gms.vision.CameraSource r2 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x0092 }
                int r2 = r2.rotation     // Catch:{ all -> 0x0092 }
                com.google.android.gms.vision.Frame$Builder r1 = r1.setRotation(r2)     // Catch:{ all -> 0x0092 }
                com.google.android.gms.vision.Frame r1 = r1.build()     // Catch:{ all -> 0x0092 }
                java.nio.ByteBuffer r2 = r6.zzz     // Catch:{ all -> 0x0092 }
                r3 = 0
                r6.zzz = r3     // Catch:{ all -> 0x0092 }
                monitor-exit(r0)     // Catch:{ all -> 0x0092 }
                com.google.android.gms.vision.Detector<?> r0 = r6.zzt     // Catch:{ Exception -> 0x006d }
                r0.receiveFrame(r1)     // Catch:{ Exception -> 0x006d }
                com.google.android.gms.vision.CameraSource r0 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r0 = r0.zzg
                byte[] r1 = r2.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x006b:
                r0 = move-exception
                goto L_0x0084
            L_0x006d:
                r0 = move-exception
                java.lang.String r1 = "CameraSource"
                java.lang.String r3 = "Exception thrown from receiver."
                android.util.Log.e(r1, r3, r0)     // Catch:{ all -> 0x006b }
                com.google.android.gms.vision.CameraSource r0 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r0 = r0.zzg
                byte[] r1 = r2.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x0084:
                com.google.android.gms.vision.CameraSource r1 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r1 = r1.zzg
                byte[] r2 = r2.array()
                r1.addCallbackBuffer(r2)
                throw r0
            L_0x0092:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0092 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zzb.run():void");
        }

        public final void setActive(boolean z11) {
            synchronized (this.lock) {
                this.zzw = z11;
                this.lock.notifyAll();
            }
        }

        public final void zza(byte[] bArr, Camera camera) {
            synchronized (this.lock) {
                ByteBuffer byteBuffer = this.zzz;
                if (byteBuffer != null) {
                    camera.addCallbackBuffer(byteBuffer.array());
                    this.zzz = null;
                }
                if (CameraSource.this.zzr.containsKey(bArr)) {
                    this.zzx = SystemClock.elapsedRealtime() - this.zzv;
                    this.zzy++;
                    this.zzz = (ByteBuffer) CameraSource.this.zzr.get(bArr);
                    this.lock.notifyAll();
                }
            }
        }
    }

    public static class zzc implements Camera.ShutterCallback {
        /* access modifiers changed from: private */
        public ShutterCallback zzaa;

        private zzc() {
        }

        public final void onShutter() {
            ShutterCallback shutterCallback = this.zzaa;
            if (shutterCallback != null) {
                shutterCallback.onShutter();
            }
        }
    }

    public class zzd implements Camera.PictureCallback {
        /* access modifiers changed from: private */
        public PictureCallback zzab;

        private zzd() {
        }

        public final void onPictureTaken(byte[] bArr, Camera camera) {
            PictureCallback pictureCallback = this.zzab;
            if (pictureCallback != null) {
                pictureCallback.onPictureTaken(bArr);
            }
            synchronized (CameraSource.this.zzf) {
                if (CameraSource.this.zzg != null) {
                    CameraSource.this.zzg.startPreview();
                }
            }
        }
    }

    @VisibleForTesting
    public static class zze {
        private Size zzac;
        private Size zzad;

        public zze(Camera.Size size, @Nullable Camera.Size size2) {
            this.zzac = new Size(size.width, size.height);
            if (size2 != null) {
                this.zzad = new Size(size2.width, size2.height);
            }
        }

        public final Size zzb() {
            return this.zzac;
        }

        @Nullable
        public final Size zzc() {
            return this.zzad;
        }
    }

    private CameraSource() {
        this.zzf = new Object();
        this.facing = 0;
        this.zzi = 30.0f;
        this.zzj = 1024;
        this.zzk = ValidationPath.MAX_PATH_LENGTH_BYTES;
        this.zzl = false;
        this.zzr = new HashMap();
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ec  */
    @android.annotation.SuppressLint({"InlinedApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.hardware.Camera zza() throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            int r1 = r0.facing
            android.hardware.Camera$CameraInfo r2 = new android.hardware.Camera$CameraInfo
            r2.<init>()
            r3 = 0
            r4 = r3
        L_0x000b:
            int r5 = android.hardware.Camera.getNumberOfCameras()
            r6 = -1
            if (r4 >= r5) goto L_0x001d
            android.hardware.Camera.getCameraInfo(r4, r2)
            int r5 = r2.facing
            if (r5 != r1) goto L_0x001a
            goto L_0x001e
        L_0x001a:
            int r4 = r4 + 1
            goto L_0x000b
        L_0x001d:
            r4 = r6
        L_0x001e:
            if (r4 == r6) goto L_0x0231
            android.hardware.Camera r1 = android.hardware.Camera.open(r4)
            int r2 = r0.zzj
            int r5 = r0.zzk
            android.hardware.Camera$Parameters r6 = r1.getParameters()
            java.util.List r7 = r6.getSupportedPreviewSizes()
            java.util.List r6 = r6.getSupportedPictureSizes()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r9 = r7.iterator()
        L_0x003d:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x007d
            java.lang.Object r10 = r9.next()
            android.hardware.Camera$Size r10 = (android.hardware.Camera.Size) r10
            int r11 = r10.width
            float r11 = (float) r11
            int r12 = r10.height
            float r12 = (float) r12
            float r11 = r11 / r12
            java.util.Iterator r12 = r6.iterator()
        L_0x0054:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x003d
            java.lang.Object r13 = r12.next()
            android.hardware.Camera$Size r13 = (android.hardware.Camera.Size) r13
            int r14 = r13.width
            float r14 = (float) r14
            int r15 = r13.height
            float r15 = (float) r15
            float r14 = r14 / r15
            float r14 = r11 - r14
            float r14 = java.lang.Math.abs(r14)
            r15 = 1008981770(0x3c23d70a, float:0.01)
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 >= 0) goto L_0x0054
            com.google.android.gms.vision.CameraSource$zze r11 = new com.google.android.gms.vision.CameraSource$zze
            r11.<init>(r10, r13)
            r8.add(r11)
            goto L_0x003d
        L_0x007d:
            int r6 = r8.size()
            java.lang.String r9 = "CameraSource"
            r10 = 0
            if (r6 != 0) goto L_0x00a4
            java.lang.String r6 = "No preview sizes have a corresponding same-aspect-ratio picture size"
            android.util.Log.w(r9, r6)
            java.util.Iterator r6 = r7.iterator()
        L_0x008f:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00a4
            java.lang.Object r7 = r6.next()
            android.hardware.Camera$Size r7 = (android.hardware.Camera.Size) r7
            com.google.android.gms.vision.CameraSource$zze r11 = new com.google.android.gms.vision.CameraSource$zze
            r11.<init>(r7, r10)
            r8.add(r11)
            goto L_0x008f
        L_0x00a4:
            int r6 = r8.size()
            r7 = 2147483647(0x7fffffff, float:NaN)
            r11 = r3
            r13 = r7
            r12 = r10
        L_0x00ae:
            if (r11 >= r6) goto L_0x00d6
            java.lang.Object r14 = r8.get(r11)
            int r11 = r11 + 1
            com.google.android.gms.vision.CameraSource$zze r14 = (com.google.android.gms.vision.CameraSource.zze) r14
            com.google.android.gms.common.images.Size r15 = r14.zzb()
            int r16 = r15.getWidth()
            int r16 = r16 - r2
            int r16 = java.lang.Math.abs(r16)
            int r15 = r15.getHeight()
            int r15 = r15 - r5
            int r15 = java.lang.Math.abs(r15)
            int r15 = r16 + r15
            if (r15 >= r13) goto L_0x00ae
            r12 = r14
            r13 = r15
            goto L_0x00ae
        L_0x00d6:
            if (r12 == 0) goto L_0x0229
            com.google.android.gms.common.images.Size r2 = r12.zzc()
            com.google.android.gms.common.images.Size r5 = r12.zzb()
            r0.zzh = r5
            float r5 = r0.zzi
            r6 = 1148846080(0x447a0000, float:1000.0)
            float r5 = r5 * r6
            int r5 = (int) r5
            android.hardware.Camera$Parameters r6 = r1.getParameters()
            java.util.List r6 = r6.getSupportedPreviewFpsRange()
            java.util.Iterator r6 = r6.iterator()
            r8 = r10
        L_0x00f5:
            boolean r11 = r6.hasNext()
            r12 = 1
            if (r11 == 0) goto L_0x0118
            java.lang.Object r11 = r6.next()
            int[] r11 = (int[]) r11
            r13 = r11[r3]
            int r13 = r5 - r13
            r12 = r11[r12]
            int r12 = r5 - r12
            int r13 = java.lang.Math.abs(r13)
            int r12 = java.lang.Math.abs(r12)
            int r13 = r13 + r12
            if (r13 >= r7) goto L_0x00f5
            r8 = r11
            r7 = r13
            goto L_0x00f5
        L_0x0118:
            if (r8 == 0) goto L_0x0221
            android.hardware.Camera$Parameters r5 = r1.getParameters()
            if (r2 == 0) goto L_0x012b
            int r6 = r2.getWidth()
            int r2 = r2.getHeight()
            r5.setPictureSize(r6, r2)
        L_0x012b:
            com.google.android.gms.common.images.Size r2 = r0.zzh
            int r2 = r2.getWidth()
            com.google.android.gms.common.images.Size r6 = r0.zzh
            int r6 = r6.getHeight()
            r5.setPreviewSize(r2, r6)
            r2 = r8[r3]
            r6 = r8[r12]
            r5.setPreviewFpsRange(r2, r6)
            r2 = 17
            r5.setPreviewFormat(r2)
            android.content.Context r2 = r0.zze
            java.lang.String r6 = "window"
            java.lang.Object r2 = r2.getSystemService(r6)
            android.view.WindowManager r2 = (android.view.WindowManager) r2
            android.view.Display r2 = r2.getDefaultDisplay()
            int r2 = r2.getRotation()
            if (r2 == 0) goto L_0x0182
            if (r2 == r12) goto L_0x017f
            r6 = 2
            if (r2 == r6) goto L_0x017c
            r6 = 3
            if (r2 == r6) goto L_0x0179
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r7 = 31
            r6.<init>(r7)
            java.lang.String r7 = "Bad rotation value: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            android.util.Log.e(r9, r2)
            goto L_0x0182
        L_0x0179:
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x0183
        L_0x017c:
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x0183
        L_0x017f:
            r2 = 90
            goto L_0x0183
        L_0x0182:
            r2 = r3
        L_0x0183:
            android.hardware.Camera$CameraInfo r6 = new android.hardware.Camera$CameraInfo
            r6.<init>()
            android.hardware.Camera.getCameraInfo(r4, r6)
            int r4 = r6.facing
            if (r4 != r12) goto L_0x0199
            int r4 = r6.orientation
            int r4 = r4 + r2
            int r4 = r4 % 360
            int r2 = 360 - r4
            int r2 = r2 % 360
            goto L_0x01a1
        L_0x0199:
            int r4 = r6.orientation
            int r4 = r4 - r2
            int r4 = r4 + 360
            int r4 = r4 % 360
            r2 = r4
        L_0x01a1:
            int r6 = r4 / 90
            r0.rotation = r6
            r1.setDisplayOrientation(r2)
            r5.setRotation(r4)
            java.lang.String r2 = r0.zzm
            if (r2 == 0) goto L_0x01d2
            java.util.List r2 = r5.getSupportedFocusModes()
            java.lang.String r4 = r0.zzm
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L_0x01c1
            java.lang.String r2 = r0.zzm
            r5.setFocusMode(r2)
            goto L_0x01d2
        L_0x01c1:
            java.lang.Object[] r2 = new java.lang.Object[r12]
            java.lang.String r4 = r0.zzm
            r2[r3] = r4
            java.lang.String r3 = "FocusMode %s is not supported on this device."
            java.lang.String r2 = java.lang.String.format(r3, r2)
            android.util.Log.w(r9, r2)
            r0.zzm = r10
        L_0x01d2:
            java.lang.String r2 = r0.zzm
            if (r2 != 0) goto L_0x01f1
            boolean r2 = r0.zzl
            if (r2 == 0) goto L_0x01f1
            java.util.List r2 = r5.getSupportedFocusModes()
            java.lang.String r3 = "continuous-video"
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x01ec
            r5.setFocusMode(r3)
            r0.zzm = r3
            goto L_0x01f1
        L_0x01ec:
            java.lang.String r2 = "Camera auto focus is not supported on this device."
            android.util.Log.i(r9, r2)
        L_0x01f1:
            r1.setParameters(r5)
            com.google.android.gms.vision.CameraSource$zza r2 = new com.google.android.gms.vision.CameraSource$zza
            r2.<init>()
            r1.setPreviewCallbackWithBuffer(r2)
            com.google.android.gms.common.images.Size r2 = r0.zzh
            byte[] r2 = r0.zza((com.google.android.gms.common.images.Size) r2)
            r1.addCallbackBuffer(r2)
            com.google.android.gms.common.images.Size r2 = r0.zzh
            byte[] r2 = r0.zza((com.google.android.gms.common.images.Size) r2)
            r1.addCallbackBuffer(r2)
            com.google.android.gms.common.images.Size r2 = r0.zzh
            byte[] r2 = r0.zza((com.google.android.gms.common.images.Size) r2)
            r1.addCallbackBuffer(r2)
            com.google.android.gms.common.images.Size r2 = r0.zzh
            byte[] r2 = r0.zza((com.google.android.gms.common.images.Size) r2)
            r1.addCallbackBuffer(r2)
            return r1
        L_0x0221:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Could not find suitable preview frames per second range."
            r1.<init>(r2)
            throw r1
        L_0x0229:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Could not find suitable preview size."
            r1.<init>(r2)
            throw r1
        L_0x0231:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Could not find requested camera."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zza():android.hardware.Camera");
    }

    public int getCameraFacing() {
        return this.facing;
    }

    public Size getPreviewSize() {
        return this.zzh;
    }

    public void release() {
        synchronized (this.zzf) {
            stop();
            this.zzq.release();
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start() throws IOException {
        synchronized (this.zzf) {
            if (this.zzg != null) {
                return this;
            }
            this.zzg = zza();
            SurfaceTexture surfaceTexture = new SurfaceTexture(100);
            this.zzn = surfaceTexture;
            this.zzg.setPreviewTexture(surfaceTexture);
            this.zzo = true;
            this.zzg.startPreview();
            Thread thread = new Thread(this.zzq);
            this.zzp = thread;
            thread.setName("gms.vision.CameraSource");
            this.zzq.setActive(true);
            this.zzp.start();
            return this;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stop() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.zzf
            monitor-enter(r0)
            com.google.android.gms.vision.CameraSource$zzb r1 = r6.zzq     // Catch:{ all -> 0x005e }
            r2 = 0
            r1.setActive(r2)     // Catch:{ all -> 0x005e }
            java.lang.Thread r1 = r6.zzp     // Catch:{ all -> 0x005e }
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r1.join()     // Catch:{ InterruptedException -> 0x0011 }
        L_0x0011:
            r6.zzp = r2     // Catch:{ all -> 0x005e }
        L_0x0013:
            android.hardware.Camera r1 = r6.zzg     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x0057
            r1.stopPreview()     // Catch:{ all -> 0x005e }
            android.hardware.Camera r1 = r6.zzg     // Catch:{ all -> 0x005e }
            r1.setPreviewCallbackWithBuffer(r2)     // Catch:{ all -> 0x005e }
            boolean r1 = r6.zzo     // Catch:{ Exception -> 0x002f }
            if (r1 == 0) goto L_0x0029
            android.hardware.Camera r1 = r6.zzg     // Catch:{ Exception -> 0x002f }
            r1.setPreviewTexture(r2)     // Catch:{ Exception -> 0x002f }
            goto L_0x0050
        L_0x0029:
            android.hardware.Camera r1 = r6.zzg     // Catch:{ Exception -> 0x002f }
            r1.setPreviewDisplay(r2)     // Catch:{ Exception -> 0x002f }
            goto L_0x0050
        L_0x002f:
            r1 = move-exception
            java.lang.String r3 = "CameraSource"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x005e }
            int r4 = r1.length()     // Catch:{ all -> 0x005e }
            int r4 = r4 + 32
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r5.<init>(r4)     // Catch:{ all -> 0x005e }
            java.lang.String r4 = "Failed to clear camera preview: "
            r5.append(r4)     // Catch:{ all -> 0x005e }
            r5.append(r1)     // Catch:{ all -> 0x005e }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x005e }
            android.util.Log.e(r3, r1)     // Catch:{ all -> 0x005e }
        L_0x0050:
            android.hardware.Camera r1 = r6.zzg     // Catch:{ all -> 0x005e }
            r1.release()     // Catch:{ all -> 0x005e }
            r6.zzg = r2     // Catch:{ all -> 0x005e }
        L_0x0057:
            java.util.Map<byte[], java.nio.ByteBuffer> r1 = r6.zzr     // Catch:{ all -> 0x005e }
            r1.clear()     // Catch:{ all -> 0x005e }
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            return
        L_0x005e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.stop():void");
    }

    public void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback) {
        synchronized (this.zzf) {
            if (this.zzg != null) {
                zzc zzc2 = new zzc();
                ShutterCallback unused = zzc2.zzaa = shutterCallback;
                zzd zzd2 = new zzd();
                PictureCallback unused2 = zzd2.zzab = pictureCallback;
                this.zzg.takePicture(zzc2, (Camera.PictureCallback) null, (Camera.PictureCallback) null, zzd2);
            }
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start(SurfaceHolder surfaceHolder) throws IOException {
        synchronized (this.zzf) {
            if (this.zzg != null) {
                return this;
            }
            Camera zza2 = zza();
            this.zzg = zza2;
            zza2.setPreviewDisplay(surfaceHolder);
            this.zzg.startPreview();
            this.zzp = new Thread(this.zzq);
            this.zzq.setActive(true);
            this.zzp.start();
            this.zzo = false;
            return this;
        }
    }

    @SuppressLint({"InlinedApi"})
    private final byte[] zza(Size size) {
        byte[] bArr = new byte[(((int) Math.ceil(((double) ((long) ((size.getHeight() * size.getWidth()) * ImageFormat.getBitsPerPixel(17)))) / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (!wrap.hasArray() || wrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.zzr.put(bArr, wrap);
        return bArr;
    }
}
