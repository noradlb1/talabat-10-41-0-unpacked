package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileNotFoundException;
import java.util.List;

public final class DocumentsContractCompat {
    private static final String PATH_TREE = "tree";

    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        private DocumentCompat() {
        }
    }

    @RequiresApi(19)
    public static class DocumentsContractApi19Impl {
        private DocumentsContractApi19Impl() {
        }

        @DoNotInline
        public static boolean a(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
            return DocumentsContract.deleteDocument(contentResolver, uri);
        }

        @DoNotInline
        public static String b(Uri uri) {
            return DocumentsContract.getDocumentId(uri);
        }

        @DoNotInline
        public static Uri buildDocumentUri(String str, String str2) {
            return DocumentsContract.buildDocumentUri(str, str2);
        }

        @DoNotInline
        public static boolean c(Context context, @Nullable Uri uri) {
            return DocumentsContract.isDocumentUri(context, uri);
        }
    }

    @RequiresApi(21)
    public static class DocumentsContractApi21Impl {
        private DocumentsContractApi21Impl() {
        }

        @DoNotInline
        public static Uri a(String str, String str2) {
            return DocumentsContract.buildChildDocumentsUri(str, str2);
        }

        @DoNotInline
        public static Uri b(Uri uri, String str) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(uri, str);
        }

        @DoNotInline
        public static Uri buildTreeDocumentUri(String str, String str2) {
            return DocumentsContract.buildTreeDocumentUri(str, str2);
        }

        @DoNotInline
        public static Uri c(Uri uri, String str) {
            return DocumentsContract.buildDocumentUriUsingTree(uri, str);
        }

        @DoNotInline
        public static Uri d(ContentResolver contentResolver, Uri uri, String str, String str2) throws FileNotFoundException {
            return DocumentsContract.createDocument(contentResolver, uri, str, str2);
        }

        @DoNotInline
        public static String e(Uri uri) {
            return DocumentsContract.getTreeDocumentId(uri);
        }

        @DoNotInline
        public static Uri f(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
            return DocumentsContract.renameDocument(contentResolver, uri, str);
        }
    }

    @RequiresApi(24)
    public static class DocumentsContractApi24Impl {
        private DocumentsContractApi24Impl() {
        }

        @DoNotInline
        public static boolean a(@NonNull Uri uri) {
            return DocumentsContract.isTreeUri(uri);
        }

        @DoNotInline
        public static boolean b(ContentResolver contentResolver, Uri uri, Uri uri2) throws FileNotFoundException {
            return DocumentsContract.removeDocument(contentResolver, uri, uri2);
        }
    }

    private DocumentsContractCompat() {
    }

    @Nullable
    public static Uri buildChildDocumentsUri(@NonNull String str, @Nullable String str2) {
        return DocumentsContractApi21Impl.a(str, str2);
    }

    @Nullable
    public static Uri buildChildDocumentsUriUsingTree(@NonNull Uri uri, @NonNull String str) {
        return DocumentsContractApi21Impl.b(uri, str);
    }

    @Nullable
    public static Uri buildDocumentUri(@NonNull String str, @NonNull String str2) {
        return DocumentsContractApi19Impl.buildDocumentUri(str, str2);
    }

    @Nullable
    public static Uri buildDocumentUriUsingTree(@NonNull Uri uri, @NonNull String str) {
        return DocumentsContractApi21Impl.c(uri, str);
    }

    @Nullable
    public static Uri buildTreeDocumentUri(@NonNull String str, @NonNull String str2) {
        return DocumentsContractApi21Impl.buildTreeDocumentUri(str, str2);
    }

    @Nullable
    public static Uri createDocument(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str, @NonNull String str2) throws FileNotFoundException {
        return DocumentsContractApi21Impl.d(contentResolver, uri, str, str2);
    }

    @Nullable
    public static String getDocumentId(@NonNull Uri uri) {
        return DocumentsContractApi19Impl.b(uri);
    }

    @Nullable
    public static String getTreeDocumentId(@NonNull Uri uri) {
        return DocumentsContractApi21Impl.e(uri);
    }

    public static boolean isDocumentUri(@NonNull Context context, @Nullable Uri uri) {
        return DocumentsContractApi19Impl.c(context, uri);
    }

    public static boolean isTreeUri(@NonNull Uri uri) {
        if (Build.VERSION.SDK_INT >= 24) {
            return DocumentsContractApi24Impl.a(uri);
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() < 2 || !PATH_TREE.equals(pathSegments.get(0))) {
            return false;
        }
        return true;
    }

    public static boolean removeDocument(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull Uri uri2) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return DocumentsContractApi24Impl.b(contentResolver, uri, uri2);
        }
        return DocumentsContractApi19Impl.a(contentResolver, uri);
    }

    @Nullable
    public static Uri renameDocument(@NonNull ContentResolver contentResolver, @NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        return DocumentsContractApi21Impl.f(contentResolver, uri, str);
    }
}
