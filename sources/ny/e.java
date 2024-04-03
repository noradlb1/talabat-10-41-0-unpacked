package ny;

import android.util.SparseArray;
import com.talabat.wallet.ui.qrCodeScanner.view.QRCodeScannerFragment;
import com.talabat.wallet.ui.qrCodeScanner.view.QRCodeScannerFragment$barCodeProcessor$1;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SparseArray f24020b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QRCodeScannerFragment f24021c;

    public /* synthetic */ e(SparseArray sparseArray, QRCodeScannerFragment qRCodeScannerFragment) {
        this.f24020b = sparseArray;
        this.f24021c = qRCodeScannerFragment;
    }

    public final void run() {
        QRCodeScannerFragment$barCodeProcessor$1.m6017receiveDetections$lambda0(this.f24020b, this.f24021c);
    }
}
