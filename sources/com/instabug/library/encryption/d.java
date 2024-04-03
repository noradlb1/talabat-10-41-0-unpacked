package com.instabug.library.encryption;

import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.Encryptor;
import com.instabug.library.util.DiskUtils;
import com.instabug.library.util.FileUtils;
import java.io.File;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final d f34347a = new d();

    private d() {
    }

    private final void a() {
        if (Instabug.getApplicationContext() != null) {
            Iterator<File> it = DiskUtils.listFilesInDirectory(com.instabug.library.internal.storage.DiskUtils.getInstabugDirectory(Instabug.getApplicationContext())).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (FileUtils.isFileRelatedToBugOrCrashReport(next.getPath())) {
                    if (!next.isDirectory()) {
                        Encryptor.a(next.getPath());
                    } else if (next.isDirectory()) {
                        Iterator<File> it2 = DiskUtils.listFilesInDirectory(next).iterator();
                        while (it2.hasNext()) {
                            Encryptor.a(it2.next().getPath());
                        }
                    }
                }
            }
        }
    }

    private final void b() {
        if (Instabug.getApplicationContext() != null) {
            Iterator<File> it = DiskUtils.listFilesInDirectory(com.instabug.library.internal.storage.DiskUtils.getInstabugDirectory(Instabug.getApplicationContext())).iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (FileUtils.isFileRelatedToBugOrCrashReport(next.getPath())) {
                    if (!next.isDirectory()) {
                        FileUtils.encryptFile(next.getPath());
                    } else if (next.isDirectory()) {
                        Iterator<File> it2 = DiskUtils.listFilesInDirectory(next).iterator();
                        while (it2.hasNext()) {
                            FileUtils.encryptFile(it2.next().getPath());
                        }
                    }
                }
            }
        }
    }

    public final void c() {
        a();
        b();
        InstabugCore.saveEncryptorVersion(2);
    }
}
