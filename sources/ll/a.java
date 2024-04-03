package ll;

import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;
import com.talabat.feature.bnplcheckout.BNPLCheckoutFlutterBottomSheet;

public final /* synthetic */ class a implements FragmentResultListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BNPLCheckoutFlutterBottomSheet f62240a;

    public /* synthetic */ a(BNPLCheckoutFlutterBottomSheet bNPLCheckoutFlutterBottomSheet) {
        this.f62240a = bNPLCheckoutFlutterBottomSheet;
    }

    public final void onFragmentResult(String str, Bundle bundle) {
        BNPLCheckoutFlutterBottomSheet.m10140showInNativeBottomSheet$lambda1(this.f62240a, str, bundle);
    }
}
