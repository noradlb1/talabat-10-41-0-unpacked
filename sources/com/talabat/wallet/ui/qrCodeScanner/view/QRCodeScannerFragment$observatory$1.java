package com.talabat.wallet.ui.qrCodeScanner.view;

import com.talabat.wallet.ui.qrCodeScanner.model.ValidateQRCodeDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class QRCodeScannerFragment$observatory$1 extends FunctionReferenceImpl implements Function1<ValidateQRCodeDisplayModel, Unit> {
    public QRCodeScannerFragment$observatory$1(Object obj) {
        super(1, obj, QRCodeScannerFragment.class, "updateQrCode", "updateQrCode(Lcom/talabat/wallet/ui/qrCodeScanner/model/ValidateQRCodeDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ValidateQRCodeDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ValidateQRCodeDisplayModel validateQRCodeDisplayModel) {
        ((QRCodeScannerFragment) this.receiver).updateQrCode(validateQRCodeDisplayModel);
    }
}
