package ny;

import android.content.DialogInterface;
import com.talabat.wallet.ui.qrCodeScanner.view.QRCodeScannerFragment;

public final /* synthetic */ class b implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QRCodeScannerFragment f24017b;

    public /* synthetic */ b(QRCodeScannerFragment qRCodeScannerFragment) {
        this.f24017b = qRCodeScannerFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        QRCodeScannerFragment.m6016openAppSettingAlert$lambda14$lambda13(this.f24017b, dialogInterface, i11);
    }
}
