package com.airbnb.lottie.network;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class NetworkFetcher {
    @NonNull
    private final LottieNetworkFetcher fetcher;
    @NonNull
    private final NetworkCache networkCache;

    public NetworkFetcher(@NonNull NetworkCache networkCache2, @NonNull LottieNetworkFetcher lottieNetworkFetcher) {
        this.networkCache = networkCache2;
        this.fetcher = lottieNetworkFetcher;
    }

    @WorkerThread
    @Nullable
    private LottieComposition fetchFromCache(@NonNull String str, @Nullable String str2) {
        Pair<FileExtension, InputStream> a11;
        LottieResult<LottieComposition> lottieResult;
        if (str2 == null || (a11 = this.networkCache.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) a11.first;
        InputStream inputStream = (InputStream) a11.second;
        if (fileExtension == FileExtension.ZIP) {
            lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), str);
        } else {
            lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
        }
        if (lottieResult.getValue() != null) {
            return lottieResult.getValue();
        }
        return null;
    }

    @WorkerThread
    @NonNull
    private LottieResult<LottieComposition> fetchFromNetwork(@NonNull String str, @Nullable String str2) {
        boolean z11;
        Logger.debug("Fetching " + str);
        LottieFetchResult lottieFetchResult = null;
        try {
            lottieFetchResult = this.fetcher.fetchSync(str);
            if (lottieFetchResult.isSuccessful()) {
                LottieResult<LottieComposition> fromInputStream = fromInputStream(str, lottieFetchResult.bodyByteStream(), lottieFetchResult.contentType(), str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Completed fetch from network. Success: ");
                if (fromInputStream.getValue() != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                sb2.append(z11);
                Logger.debug(sb2.toString());
                try {
                    lottieFetchResult.close();
                } catch (IOException e11) {
                    Logger.warning("LottieFetchResult close failed ", e11);
                }
                return fromInputStream;
            }
            LottieResult<LottieComposition> lottieResult = new LottieResult<>((Throwable) new IllegalArgumentException(lottieFetchResult.error()));
            try {
                lottieFetchResult.close();
            } catch (IOException e12) {
                Logger.warning("LottieFetchResult close failed ", e12);
            }
            return lottieResult;
        } catch (Exception e13) {
            LottieResult<LottieComposition> lottieResult2 = new LottieResult<>((Throwable) e13);
            if (lottieFetchResult != null) {
                try {
                    lottieFetchResult.close();
                } catch (IOException e14) {
                    Logger.warning("LottieFetchResult close failed ", e14);
                }
            }
            return lottieResult2;
        } catch (Throwable th2) {
            if (lottieFetchResult != null) {
                try {
                    lottieFetchResult.close();
                } catch (IOException e15) {
                    Logger.warning("LottieFetchResult close failed ", e15);
                }
            }
            throw th2;
        }
    }

    @NonNull
    private LottieResult<LottieComposition> fromInputStream(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> lottieResult;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            Logger.debug("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            lottieResult = fromZipStream(str, inputStream, str3);
        } else {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            lottieResult = fromJsonStream(str, inputStream, str3);
        }
        if (!(str3 == null || lottieResult.getValue() == null)) {
            this.networkCache.b(str, fileExtension);
        }
        return lottieResult;
    }

    @NonNull
    private LottieResult<LottieComposition> fromJsonStream(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, (String) null);
        }
        return LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(this.networkCache.c(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }

    @NonNull
    private LottieResult<LottieComposition> fromZipStream(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), (String) null);
        }
        return LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.c(str, inputStream, FileExtension.ZIP))), str);
    }

    @WorkerThread
    @NonNull
    public LottieResult<LottieComposition> fetchSync(@NonNull String str, @Nullable String str2) {
        LottieComposition fetchFromCache = fetchFromCache(str, str2);
        if (fetchFromCache != null) {
            return new LottieResult<>(fetchFromCache);
        }
        Logger.debug("Animation for " + str + " not found in cache. Fetching from network.");
        return fetchFromNetwork(str, str2);
    }
}
