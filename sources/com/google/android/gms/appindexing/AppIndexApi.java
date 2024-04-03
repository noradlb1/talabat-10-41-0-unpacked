package com.google.android.gms.appindexing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

@Deprecated
public interface AppIndexApi {

    @Deprecated
    @VisibleForTesting
    public interface ActionResult {
        @NonNull
        PendingResult<Status> end(@NonNull GoogleApiClient googleApiClient);

        @NonNull
        PendingResult<Status> getPendingResult();
    }

    @Deprecated
    public static final class AppIndexingLink {
        @NonNull
        public final Uri appIndexingUrl;
        public final int viewId;
        @NonNull
        public final Uri webUrl;

        @VisibleForTesting
        public AppIndexingLink(@NonNull Uri uri, @NonNull Uri uri2, @NonNull View view) {
            this.appIndexingUrl = uri;
            this.webUrl = uri2;
            this.viewId = view.getId();
        }

        @VisibleForTesting
        public AppIndexingLink(@NonNull Uri uri, @NonNull View view) {
            this(uri, (Uri) null, view);
        }
    }

    @NonNull
    @Deprecated
    @VisibleForTesting
    ActionResult action(@NonNull GoogleApiClient googleApiClient, @NonNull Action action);

    @NonNull
    PendingResult<Status> end(@NonNull GoogleApiClient googleApiClient, @NonNull Action action);

    @NonNull
    @VisibleForTesting
    PendingResult<Status> start(@NonNull GoogleApiClient googleApiClient, @NonNull Action action);

    @NonNull
    @Deprecated
    @VisibleForTesting
    PendingResult<Status> view(@NonNull GoogleApiClient googleApiClient, @NonNull Activity activity, @NonNull Intent intent, @NonNull String str, @NonNull Uri uri, @NonNull List<AppIndexingLink> list);

    @NonNull
    @Deprecated
    @VisibleForTesting
    PendingResult<Status> view(@NonNull GoogleApiClient googleApiClient, @NonNull Activity activity, @NonNull Uri uri, @NonNull String str, @NonNull Uri uri2, @NonNull List<AppIndexingLink> list);

    @NonNull
    @Deprecated
    @VisibleForTesting
    PendingResult<Status> viewEnd(@NonNull GoogleApiClient googleApiClient, @NonNull Activity activity, @NonNull Intent intent);

    @NonNull
    @Deprecated
    @VisibleForTesting
    PendingResult<Status> viewEnd(@NonNull GoogleApiClient googleApiClient, @NonNull Activity activity, @NonNull Uri uri);
}
