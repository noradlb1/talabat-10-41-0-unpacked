package com.talabat.wallet.ui.qrCodeScanner.view;

import android.util.SparseArray;
import android.widget.TextView;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.talabat.wallet.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ny.e;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/talabat/wallet/ui/qrCodeScanner/view/QRCodeScannerFragment$barCodeProcessor$1", "Lcom/google/android/gms/vision/Detector$Processor;", "Lcom/google/android/gms/vision/barcode/Barcode;", "receiveDetections", "", "detections", "Lcom/google/android/gms/vision/Detector$Detections;", "release", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QRCodeScannerFragment$barCodeProcessor$1 implements Detector.Processor<Barcode> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QRCodeScannerFragment f12714a;

    public QRCodeScannerFragment$barCodeProcessor$1(QRCodeScannerFragment qRCodeScannerFragment) {
        this.f12714a = qRCodeScannerFragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: receiveDetections$lambda-0  reason: not valid java name */
    public static final void m6017receiveDetections$lambda0(SparseArray sparseArray, QRCodeScannerFragment qRCodeScannerFragment) {
        Intrinsics.checkNotNullParameter(qRCodeScannerFragment, "this$0");
        String str = ((Barcode) sparseArray.valueAt(0)).displayValue;
        CameraSource access$getCameraSource$p = qRCodeScannerFragment.cameraSource;
        if (access$getCameraSource$p != null) {
            access$getCameraSource$p.stop();
        }
        if (!Intrinsics.areEqual((Object) qRCodeScannerFragment.lastQR, (Object) str) && !qRCodeScannerFragment.validateQrInProgress) {
            Intrinsics.checkNotNullExpressionValue(str, "value");
            qRCodeScannerFragment.validateQRCode(str);
        }
    }

    public void receiveDetections(@NotNull Detector.Detections<Barcode> detections) {
        Intrinsics.checkNotNullParameter(detections, "detections");
        try {
            SparseArray<Barcode> detectedItems = detections.getDetectedItems();
            if (detectedItems.size() != 0) {
                ((TextView) this.f12714a._$_findCachedViewById(R.id.scan_qr_code)).post(new e(detectedItems, this.f12714a));
            }
        } catch (Exception unused) {
        }
    }

    public void release() {
    }
}
