package com.adyen.checkout.core;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public interface RedirectDetails extends Parcelable {
    @NonNull
    Uri getUri();
}
