package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.newrelic.agent.android.util.Constants;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class RawDocumentFile extends DocumentFile {
    private File mFile;

    public RawDocumentFile(@Nullable DocumentFile documentFile, File file) {
        super(documentFile);
        this.mFile = file;
    }

    private static boolean deleteContents(File file) {
        File[] listFiles = file.listFiles();
        boolean z11 = true;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    z11 &= deleteContents(file2);
                }
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    z11 = false;
                }
            }
        }
        return z11;
    }

    private static String getTypeForName(String str) {
        String mimeTypeFromExtension;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1).toLowerCase())) == null) {
            return Constants.Network.ContentType.OCTET_STREAM;
        }
        return mimeTypeFromExtension;
    }

    public boolean canRead() {
        return this.mFile.canRead();
    }

    public boolean canWrite() {
        return this.mFile.canWrite();
    }

    @Nullable
    public DocumentFile createDirectory(String str) {
        File file = new File(this.mFile, str);
        if (file.isDirectory() || file.mkdir()) {
            return new RawDocumentFile(this, file);
        }
        return null;
    }

    @Nullable
    public DocumentFile createFile(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType != null) {
            str2 = str2 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + extensionFromMimeType;
        }
        File file = new File(this.mFile, str2);
        try {
            file.createNewFile();
            return new RawDocumentFile(this, file);
        } catch (IOException e11) {
            Log.w("DocumentFile", "Failed to createFile: " + e11);
            return null;
        }
    }

    public boolean delete() {
        deleteContents(this.mFile);
        return this.mFile.delete();
    }

    public boolean exists() {
        return this.mFile.exists();
    }

    public String getName() {
        return this.mFile.getName();
    }

    @Nullable
    public String getType() {
        if (this.mFile.isDirectory()) {
            return null;
        }
        return getTypeForName(this.mFile.getName());
    }

    public Uri getUri() {
        return Uri.fromFile(this.mFile);
    }

    public boolean isDirectory() {
        return this.mFile.isDirectory();
    }

    public boolean isFile() {
        return this.mFile.isFile();
    }

    public boolean isVirtual() {
        return false;
    }

    public long lastModified() {
        return this.mFile.lastModified();
    }

    public long length() {
        return this.mFile.length();
    }

    public DocumentFile[] listFiles() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.mFile.listFiles();
        if (listFiles != null) {
            for (File rawDocumentFile : listFiles) {
                arrayList.add(new RawDocumentFile(this, rawDocumentFile));
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    public boolean renameTo(String str) {
        File file = new File(this.mFile.getParentFile(), str);
        if (!this.mFile.renameTo(file)) {
            return false;
        }
        this.mFile = file;
        return true;
    }
}
