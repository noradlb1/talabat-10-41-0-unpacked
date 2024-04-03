package com.talabat.wallet.ui.qrCodeScanner.view;

import androidx.fragment.app.FragmentActivity;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.talabatcommon.views.talabarSnackBar.TalabatNotifySnackBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/wallet/ui/qrCodeScanner/view/QRCodeScannerFragment$errorNotifyCallback$1", "Lcom/google/android/material/snackbar/BaseTransientBottomBar$BaseCallback;", "Lcom/talabat/talabatcommon/views/talabarSnackBar/TalabatNotifySnackBar;", "onDismissed", "", "transientBottomBar", "event", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QRCodeScannerFragment$errorNotifyCallback$1 extends BaseTransientBottomBar.BaseCallback<TalabatNotifySnackBar> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QRCodeScannerFragment f12715a;

    public QRCodeScannerFragment$errorNotifyCallback$1(QRCodeScannerFragment qRCodeScannerFragment) {
        this.f12715a = qRCodeScannerFragment;
    }

    public void onDismissed(@NotNull TalabatNotifySnackBar talabatNotifySnackBar, int i11) {
        Intrinsics.checkNotNullParameter(talabatNotifySnackBar, "transientBottomBar");
        super.onDismissed(talabatNotifySnackBar, i11);
        FragmentActivity activity = this.f12715a.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
