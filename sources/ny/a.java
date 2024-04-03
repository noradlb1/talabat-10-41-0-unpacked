package ny;

import android.content.DialogInterface;
import com.talabat.wallet.ui.qrCodeScanner.view.QRCodeScannerFragment;

public final /* synthetic */ class a implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QRCodeScannerFragment f24016b;

    public /* synthetic */ a(QRCodeScannerFragment qRCodeScannerFragment) {
        this.f24016b = qRCodeScannerFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        QRCodeScannerFragment.m6015openAppSettingAlert$lambda14$lambda12(this.f24016b, dialogInterface, i11);
    }
}
