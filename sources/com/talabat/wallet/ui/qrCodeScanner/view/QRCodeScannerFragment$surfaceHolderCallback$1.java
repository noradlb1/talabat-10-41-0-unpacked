package com.talabat.wallet.ui.qrCodeScanner.view;

import android.view.SurfaceHolder;
import com.google.android.gms.vision.CameraSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/talabat/wallet/ui/qrCodeScanner/view/QRCodeScannerFragment$surfaceHolderCallback$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QRCodeScannerFragment$surfaceHolderCallback$1 implements SurfaceHolder.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QRCodeScannerFragment f12716b;

    public QRCodeScannerFragment$surfaceHolderCallback$1(QRCodeScannerFragment qRCodeScannerFragment) {
        this.f12716b = qRCodeScannerFragment;
    }

    public void surfaceChanged(@NotNull SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
    }

    public void surfaceCreated(@NotNull SurfaceHolder surfaceHolder) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
        QRCodeScannerFragment qRCodeScannerFragment = this.f12716b;
        if (qRCodeScannerFragment.hasCameraPermission(qRCodeScannerFragment.getActivity())) {
            this.f12716b.startCamera();
        } else if (PermissionUtils.Companion.neverAskAgainSelected(this.f12716b.getActivity(), "android.permission.CAMERA")) {
            this.f12716b.openAppSettingAlert();
        } else {
            QRCodeScannerFragment qRCodeScannerFragment2 = this.f12716b;
            if (!qRCodeScannerFragment2.hasCameraPermission(qRCodeScannerFragment2.getActivity())) {
                this.f12716b.requestPermission();
            }
        }
    }

    public void surfaceDestroyed(@NotNull SurfaceHolder surfaceHolder) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
        CameraSource access$getCameraSource$p = this.f12716b.cameraSource;
        if (access$getCameraSource$p != null) {
            access$getCameraSource$p.stop();
        }
    }
}
