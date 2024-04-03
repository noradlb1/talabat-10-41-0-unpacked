package ny;

import android.view.View;
import com.talabat.wallet.ui.qrCodeScanner.view.QRCodeScannerFragment;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QRCodeScannerFragment f24018b;

    public /* synthetic */ c(QRCodeScannerFragment qRCodeScannerFragment) {
        this.f24018b = qRCodeScannerFragment;
    }

    public final void onClick(View view) {
        QRCodeScannerFragment.m6014onViewCreated$lambda1(this.f24018b, view);
    }
}
