package ny;

import android.content.DialogInterface;
import com.talabat.wallet.ui.qrCodeScanner.view.QRCodeScannerFragment;

public final /* synthetic */ class d implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QRCodeScannerFragment f24019b;

    public /* synthetic */ d(QRCodeScannerFragment qRCodeScannerFragment) {
        this.f24019b = qRCodeScannerFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        QRCodeScannerFragment.m6013addDialogToShowInfo$lambda11$lambda10(this.f24019b, dialogInterface, i11);
    }
}
