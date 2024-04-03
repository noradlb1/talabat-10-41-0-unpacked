package androidx.webkit;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.io.FileNotFoundException;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;

public final class DropDataContentProvider extends ContentProvider {

    /* renamed from: b  reason: collision with root package name */
    public DropDataContentProviderBoundaryInterface f37926b;

    private DropDataContentProviderBoundaryInterface getDropImpl() {
        if (this.f37926b == null) {
            DropDataContentProviderBoundaryInterface dropDataProvider = WebViewGlueCommunicator.getFactory().getDropDataProvider();
            this.f37926b = dropDataProvider;
            dropDataProvider.onCreate();
        }
        return this.f37926b;
    }

    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        return getDropImpl().call(str, str2, bundle);
    }

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("delete method is not supported.");
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return getDropImpl().getType(uri);
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        throw new UnsupportedOperationException("Insert method is not supported.");
    }

    public boolean onCreate() {
        return true;
    }

    @Nullable
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        return getDropImpl().openFile(this, uri);
    }

    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return getDropImpl().query(uri, strArr, str, strArr2, str2);
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException("update method is not supported.");
    }
}
