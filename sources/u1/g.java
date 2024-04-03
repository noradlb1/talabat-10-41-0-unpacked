package u1;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

public final /* synthetic */ class g implements InputConnectionCompat.OnCommitContentListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f11625a;

    public /* synthetic */ g(View view) {
        this.f11625a = view;
    }

    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i11, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(this.f11625a, inputContentInfoCompat, i11, bundle);
    }
}
