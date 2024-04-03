package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;

public class AppCompatDialogFragment extends DialogFragment {
    public AppCompatDialogFragment() {
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new AppCompatDialog(getContext(), getTheme());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog dialog, int i11) {
        if (dialog instanceof AppCompatDialog) {
            AppCompatDialog appCompatDialog = (AppCompatDialog) dialog;
            if (!(i11 == 1 || i11 == 2)) {
                if (i11 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            appCompatDialog.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i11);
    }

    public AppCompatDialogFragment(@LayoutRes int i11) {
        super(i11);
    }
}
