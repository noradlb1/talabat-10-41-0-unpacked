package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.gtm.TalabatGTM;

final class MultiDexExtractor implements Closeable {
    private static final int BUFFER_SIZE = 16384;
    private static final String DEX_PREFIX = "classes";
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String KEY_CRC = "crc";
    private static final String KEY_DEX_CRC = "dex.crc.";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String KEY_DEX_TIME = "dex.time.";
    private static final String KEY_TIME_STAMP = "timestamp";
    private static final String LOCK_FILENAME = "MultiDex.lock";
    private static final int MAX_EXTRACT_ATTEMPTS = 3;
    private static final long NO_VALUE = -1;
    private static final String PREFS_FILE = "multidex.version";
    private static final String TAG = "MultiDex";
    private final FileLock cacheLock;
    private final File dexDir;
    private final FileChannel lockChannel;
    private final RandomAccessFile lockRaf;
    private final File sourceApk;
    private final long sourceCrc;

    public static class ExtractedDex extends File {
        public long crc = -1;

        public ExtractedDex(File file, String str) {
            super(file, str);
        }
    }

    public MultiDexExtractor(File file, File file2) throws IOException {
        Log.i(TAG, "MultiDexExtractor(" + file.getPath() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + file2.getPath() + ")");
        this.sourceApk = file;
        this.dexDir = file2;
        this.sourceCrc = getZipCrc(file);
        File file3 = new File(file2, LOCK_FILENAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.lockRaf = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.lockChannel = channel;
            try {
                Log.i(TAG, "Blocking on lock " + file3.getPath());
                this.cacheLock = channel.lock();
                Log.i(TAG, file3.getPath() + " locked");
            } catch (IOException e11) {
                e = e11;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (RuntimeException e12) {
                e = e12;
                closeQuietly(this.lockChannel);
                throw e;
            } catch (Error e13) {
                e = e13;
                closeQuietly(this.lockChannel);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e14) {
            closeQuietly(this.lockRaf);
            throw e14;
        }
    }

    private void clearDexDir() {
        File[] listFiles = this.dexDir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return !file.getName().equals(MultiDexExtractor.LOCK_FILENAME);
            }
        });
        if (listFiles == null) {
            Log.w(TAG, "Failed to list secondary dex dir content (" + this.dexDir.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i(TAG, "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (!file.delete()) {
                Log.w(TAG, "Failed to delete old file " + file.getPath());
            } else {
                Log.i(TAG, "Deleted old file " + file.getPath());
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e11) {
            Log.w(TAG, "Failed to close resource", e11);
        }
    }

    private static void extract(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, ".zip", file.getParentFile());
        Log.i(TAG, "Extracting " + createTempFile.getPath());
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                Log.i(TAG, "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    closeQuietly(inputStream);
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
        } catch (Throwable th2) {
            closeQuietly(inputStream);
            createTempFile.delete();
            throw th2;
        }
    }

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, 4);
    }

    private static long getTimeStamp(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long getZipCrc(File file) throws IOException {
        long c11 = ZipUtil.c(file);
        return c11 == -1 ? c11 - 1 : c11;
    }

    private static boolean isModified(Context context, File file, long j11, String str) {
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        if (multiDexPreferences.getLong(str + "timestamp", -1) == getTimeStamp(file)) {
            if (multiDexPreferences.getLong(str + KEY_CRC, -1) != j11) {
                return true;
            }
            return false;
        }
        return true;
    }

    private List<ExtractedDex> loadExistingExtractions(Context context, String str) throws IOException {
        String str2 = str;
        Log.i(TAG, "loading existing secondary dex files");
        String str3 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        SharedPreferences multiDexPreferences = getMultiDexPreferences(context);
        int i11 = multiDexPreferences.getInt(str2 + KEY_DEX_NUMBER, 1);
        ArrayList arrayList = new ArrayList(i11 + -1);
        int i12 = 2;
        while (i12 <= i11) {
            ExtractedDex extractedDex = new ExtractedDex(this.dexDir, str3 + i12 + ".zip");
            if (extractedDex.isFile()) {
                extractedDex.crc = getZipCrc(extractedDex);
                long j11 = multiDexPreferences.getLong(str2 + KEY_DEX_CRC + i12, -1);
                long j12 = multiDexPreferences.getLong(str2 + KEY_DEX_TIME + i12, -1);
                long lastModified = extractedDex.lastModified();
                if (j12 == lastModified) {
                    String str4 = str3;
                    SharedPreferences sharedPreferences = multiDexPreferences;
                    if (j11 == extractedDex.crc) {
                        arrayList.add(extractedDex);
                        i12++;
                        multiDexPreferences = sharedPreferences;
                        str3 = str4;
                    }
                }
                throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str2 + "\"), expected modification time: " + j12 + ", modification time: " + lastModified + ", expected crc: " + j11 + ", file crc: " + extractedDex.crc);
            }
            throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
        }
        return arrayList;
    }

    private List<ExtractedDex> performExtractions() throws IOException {
        ExtractedDex extractedDex;
        boolean z11;
        String str;
        String str2 = this.sourceApk.getName() + EXTRACTED_NAME_EXT;
        clearDexDir();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.sourceApk);
        try {
            int i11 = 2;
            ZipEntry entry = zipFile.getEntry(DEX_PREFIX + 2 + ".dex");
            while (entry != null) {
                extractedDex = new ExtractedDex(this.dexDir, str2 + i11 + ".zip");
                arrayList.add(extractedDex);
                Log.i(TAG, "Extraction is needed for file " + extractedDex);
                int i12 = 0;
                boolean z12 = false;
                while (i12 < 3 && !z12) {
                    int i13 = i12 + 1;
                    extract(zipFile, entry, extractedDex, str2);
                    extractedDex.crc = getZipCrc(extractedDex);
                    z11 = true;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Extraction ");
                    if (z11) {
                        str = "succeeded";
                    } else {
                        str = TalabatGTM.FAILED;
                    }
                    sb2.append(str);
                    sb2.append(" '");
                    sb2.append(extractedDex.getAbsolutePath());
                    sb2.append("': length ");
                    int i14 = i13;
                    sb2.append(extractedDex.length());
                    sb2.append(" - crc: ");
                    sb2.append(extractedDex.crc);
                    Log.i(TAG, sb2.toString());
                    if (!z11) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w(TAG, "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                        }
                    }
                    z12 = z11;
                    i12 = i14;
                }
                if (z12) {
                    i11++;
                    entry = zipFile.getEntry(DEX_PREFIX + i11 + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i11 + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e11) {
                Log.w(TAG, "Failed to close resource", e11);
            }
            return arrayList;
        } catch (IOException e12) {
            Log.w(TAG, "Failed to read crc from " + extractedDex.getAbsolutePath(), e12);
            z11 = false;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            try {
                zipFile.close();
            } catch (IOException e13) {
                Log.w(TAG, "Failed to close resource", e13);
            }
            throw th3;
        }
    }

    private static void putStoredApkInfo(Context context, String str, long j11, long j12, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = getMultiDexPreferences(context).edit();
        edit.putLong(str + "timestamp", j11);
        edit.putLong(str + KEY_CRC, j12);
        edit.putInt(str + KEY_DEX_NUMBER, list.size() + 1);
        int i11 = 2;
        for (ExtractedDex next : list) {
            edit.putLong(str + KEY_DEX_CRC + i11, next.crc);
            edit.putLong(str + KEY_DEX_TIME + i11, next.lastModified());
            i11++;
        }
        edit.commit();
    }

    public List<? extends File> a(Context context, String str, boolean z11) throws IOException {
        List<ExtractedDex> list;
        List<ExtractedDex> list2;
        Log.i(TAG, "MultiDexExtractor.load(" + this.sourceApk.getPath() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + z11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + str + ")");
        if (this.cacheLock.isValid()) {
            if (z11 || isModified(context, this.sourceApk, this.sourceCrc, str)) {
                if (z11) {
                    Log.i(TAG, "Forced extraction must be performed.");
                } else {
                    Log.i(TAG, "Detected that extraction must be performed.");
                }
                list2 = performExtractions();
                putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, list2);
            } else {
                try {
                    list = loadExistingExtractions(context, str);
                } catch (IOException e11) {
                    Log.w(TAG, "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e11);
                    list2 = performExtractions();
                    putStoredApkInfo(context, str, getTimeStamp(this.sourceApk), this.sourceCrc, list2);
                }
                Log.i(TAG, "load found " + list.size() + " secondary dex files");
                return list;
            }
            list = list2;
            Log.i(TAG, "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public void close() throws IOException {
        this.cacheLock.release();
        this.lockChannel.close();
        this.lockRaf.close();
    }
}
