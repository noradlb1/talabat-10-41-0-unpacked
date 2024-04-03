package com.instabug.library.diagnostics.nonfatals;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.diagnostics.nonfatals.cache.NonFatalCacheManager;
import com.instabug.library.diagnostics.nonfatals.model.b;
import com.instabug.library.diagnostics.nonfatals.settings.a;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.operation.ReadStateFromFileDiskOperation;
import com.instabug.library.model.State;
import com.instabug.library.util.FileUtils;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class f implements e {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final NonFatalCacheManager f34300a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final a f34301b;

    public f(@NonNull NonFatalCacheManager nonFatalCacheManager, @NonNull a aVar) {
        this.f34300a = nonFatalCacheManager;
        this.f34301b = aVar;
    }

    public List a() {
        List<com.instabug.library.diagnostics.nonfatals.model.a> allNonFatals = this.f34300a.getAllNonFatals();
        try {
            Iterator<com.instabug.library.diagnostics.nonfatals.model.a> it = allNonFatals.iterator();
            while (it.hasNext()) {
                com.instabug.library.diagnostics.nonfatals.model.a next = it.next();
                if (a.a(next, this.f34301b.a())) {
                    InstabugSDKLogger.v("IBG-Core", "NonFatal " + next.b() + " - " + next.c() + " won't be synced, as it is present in ignore list");
                    it.remove();
                } else {
                    for (b next2 : this.f34300a.getNonFatalOccurrences(next.d())) {
                        if (a(next2)) {
                            State c11 = next2.c();
                            next.a(next2);
                            next.a(c11);
                        } else {
                            this.f34300a.deleteOccurrence(next2.d());
                        }
                    }
                }
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "error while preparing non-fatals for sync", e11);
        }
        return allNonFatals;
    }

    public void b() {
        for (com.instabug.library.diagnostics.nonfatals.model.a next : this.f34300a.getAllNonFatals()) {
            if (this.f34300a.getNonFatalOccurrences(next.d()).isEmpty()) {
                this.f34300a.deleteNonFatal(next.d());
            }
        }
    }

    public void c() {
        boolean z11;
        List<File> stateFiles = FileUtils.getStateFiles("files:non_fatal_state:");
        List<String> stateFilesForAllOccurrences = this.f34300a.getStateFilesForAllOccurrences();
        if (!stateFiles.isEmpty()) {
            for (File next : stateFiles) {
                try {
                    Iterator<String> it = stateFilesForAllOccurrences.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z11 = false;
                            break;
                        }
                        z11 = true;
                        if (it.next().contains(next.getName().substring(next.getName().indexOf("non_fatal_state:") + 16 + 1))) {
                            break;
                        }
                    }
                    if (!z11) {
                        if (next.delete()) {
                            InstabugSDKLogger.v("IBG-Core", "file " + next.getName() + " is deleted");
                        } else {
                            InstabugSDKLogger.v("IBG-Core", "file " + next.getName() + " is not deleted");
                        }
                    }
                } catch (Exception e11) {
                    InstabugSDKLogger.e("IBG-Core", "Error: " + e11.getMessage() + " while cleaning stale non fatals state files");
                    IBGDiagnostics.reportNonFatal(e11, "can't clean Stale non fatals State Files");
                }
            }
        }
    }

    public void clearCache() {
        DiskUtils.deleteNonfatalStateFiles();
        this.f34300a.clearCache();
    }

    public void saveNonFatal(@NotNull @NonNull com.instabug.library.diagnostics.nonfatals.model.a aVar) {
        if (this.f34301b.d()) {
            if (a.a(aVar, this.f34301b.a())) {
                InstabugSDKLogger.v("IBG-Core", "NonFatal " + aVar.b() + " - " + aVar.c() + " was ignored");
                return;
            }
            this.f34300a.saveNonFatal(aVar);
        }
    }

    private boolean a(b bVar) {
        try {
            Context a11 = com.instabug.library.diagnostics.nonfatals.di.a.a();
            if (a11 == null || bVar.d() == null) {
                return false;
            }
            State state = new State();
            state.fromJson(DiskUtils.with(a11).readOperation(new ReadStateFromFileDiskOperation(Uri.parse(bVar.d()))).execute());
            bVar.a(state);
            return true;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while loading state for non fatal", e11);
            return false;
        }
    }
}
