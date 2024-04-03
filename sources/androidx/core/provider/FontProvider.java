package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = new a();

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    private FontProvider() {
    }

    @NonNull
    public static FontsContractCompat.FontFamilyResult b(@NonNull Context context, @NonNull FontRequest fontRequest, @Nullable CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo c11 = c(context.getPackageManager(), fontRequest, context.getResources());
        if (c11 == null) {
            return FontsContractCompat.FontFamilyResult.a(1, (FontsContractCompat.FontInfo[]) null);
        }
        return FontsContractCompat.FontFamilyResult.a(0, d(context, fontRequest, c11.authority, cancellationSignal));
    }

    @VisibleForTesting
    @Nullable
    public static ProviderInfo c(@NonNull PackageManager packageManager, @NonNull FontRequest fontRequest, @Nullable Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        } else if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            List<byte[]> convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(convertToByteArrayList, sByteArrayComparator);
            List<List<byte[]>> certificates = getCertificates(fontRequest, resources);
            for (int i11 = 0; i11 < certificates.size(); i11++) {
                ArrayList arrayList = new ArrayList(certificates.get(i11));
                Collections.sort(arrayList, sByteArrayComparator);
                if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        }
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    @VisibleForTesting
    @NonNull
    public static FontsContractCompat.FontInfo[] d(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        int i11;
        int i12;
        int i13;
        Uri uri;
        int i14;
        boolean z11;
        int i15;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str2).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath("file").build();
        Cursor cursor = null;
        try {
            int i16 = 0;
            cursor = Api16Impl.a(context.getContentResolver(), build, new String[]{InstabugDbContract.FeatureRequestEntry.COLUMN_ID, FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, FontsContractCompat.Columns.RESULT_CODE}, "query = ?", new String[]{fontRequest.getQuery()}, (String) null, cancellationSignal);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex(InstabugDbContract.FeatureRequestEntry.COLUMN_ID);
                int columnIndex3 = cursor.getColumnIndex(FontsContractCompat.Columns.FILE_ID);
                int columnIndex4 = cursor.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);
                int columnIndex5 = cursor.getColumnIndex(FontsContractCompat.Columns.WEIGHT);
                int columnIndex6 = cursor.getColumnIndex(FontsContractCompat.Columns.ITALIC);
                while (cursor.moveToNext()) {
                    if (columnIndex != -1) {
                        i11 = cursor.getInt(columnIndex);
                    } else {
                        i11 = i16;
                    }
                    if (columnIndex4 != -1) {
                        i12 = cursor.getInt(columnIndex4);
                    } else {
                        i12 = i16;
                    }
                    if (columnIndex3 == -1) {
                        i13 = i11;
                        uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        i13 = i11;
                        uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    if (columnIndex5 != -1) {
                        i14 = cursor.getInt(columnIndex5);
                    } else {
                        i14 = 400;
                    }
                    if (columnIndex6 == -1 || cursor.getInt(columnIndex6) != 1) {
                        i15 = i13;
                        z11 = false;
                    } else {
                        i15 = i13;
                        z11 = true;
                    }
                    arrayList2.add(FontsContractCompat.FontInfo.a(uri, i12, i14, z11, i15));
                    i16 = 0;
                }
                arrayList = arrayList2;
            }
            return (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (!Arrays.equals(list.get(i11), list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$static$0(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11];
            byte b12 = bArr2[i11];
            if (b11 != b12) {
                return b11 - b12;
            }
        }
        return 0;
    }
}
