package sp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.talabat.feature.walletaddcard.presentation.WalletAddCard3DSHandler;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;

public final /* synthetic */ class a implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WalletMethodCallHandler f62897a;

    public /* synthetic */ a(WalletMethodCallHandler walletMethodCallHandler) {
        this.f62897a = walletMethodCallHandler;
    }

    public final void onActivityResult(Object obj) {
        WalletAddCard3DSHandler.m10431launcher$lambda0(this.f62897a, (ActivityResult) obj);
    }
}
