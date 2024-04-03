package com.instabug.library.diagnostics.nonfatals.cache;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.diagnostics.nonfatals.model.b;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.operation.DeleteUriDiskOperation;
import com.instabug.library.internal.storage.operation.WriteStateToFileDiskOperation;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a implements NonFatalCacheManager {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final b f34293a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final d f34294b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final com.instabug.library.diagnostics.nonfatals.settings.a f34295c;

    public a(@NonNull b bVar, @NonNull d dVar, @NonNull com.instabug.library.diagnostics.nonfatals.settings.a aVar) {
        this.f34293a = bVar;
        this.f34294b = dVar;
        this.f34295c = aVar;
    }

    private void a(@Nullable List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String[] b11 = this.f34294b.b(((Long) it.next()).longValue());
                if (b11 != null) {
                    for (String parse : b11) {
                        new DeleteUriDiskOperation(Uri.parse(parse)).execute((Void) null);
                    }
                }
            }
        }
    }

    public void clearCache() {
        this.f34294b.a();
        this.f34293a.a();
    }

    public void deleteNonFatal(long j11) {
        this.f34293a.deleteNonFatal(j11);
    }

    public void deleteOccurrence(@Nullable String str) {
        if (str != null) {
            this.f34294b.deleteOccurrence(str);
        }
    }

    @NonNull
    public List getAllNonFatals() {
        return this.f34293a.getAllNonFatals();
    }

    @NonNull
    public List getAllOccurrences() {
        return this.f34294b.getAllOccurrences();
    }

    @NonNull
    public List getNonFatalOccurrences(long j11) {
        return this.f34294b.getNonFatalOccurrences(j11);
    }

    public List getStateFilesForAllOccurrences() {
        return this.f34294b.b();
    }

    public void saveNonFatal(@NonNull com.instabug.library.diagnostics.nonfatals.model.a aVar) {
        boolean z11;
        File a11;
        long a12 = this.f34293a.a(aVar);
        boolean z12 = true;
        if (a12 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            a12 = this.f34293a.b(aVar);
            if (a12 != -1) {
                List a13 = this.f34293a.a(this.f34295c.b());
                a(a13);
                this.f34293a.a(a13);
            } else {
                return;
            }
        }
        long j11 = a12;
        if (j11 == -1) {
            z12 = false;
        }
        if (z12) {
            if (this.f34294b.a(j11) < this.f34295c.c() && (a11 = a()) != null) {
                if (!this.f34294b.a(new b(j11, System.currentTimeMillis(), a11.toURI().toString()))) {
                    a11.delete();
                }
            }
            InstabugSDKLogger.d("IBG-Core", aVar.b() + " has been reported");
            return;
        }
        InstabugSDKLogger.e("IBG-Core", "Something went wrong! NonFatal not reported!!");
    }

    public List saveNonFatals(@NonNull List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(this.f34293a.b((com.instabug.library.diagnostics.nonfatals.model.a) it.next())));
        }
        return arrayList;
    }

    public void saveOccurrence(b bVar) {
        this.f34294b.a(bVar);
    }

    @Nullable
    private File a() {
        Context a11 = com.instabug.library.diagnostics.nonfatals.di.a.a();
        if (a11 == null) {
            return null;
        }
        State buildSimplifiedState = new State.Builder(a11).buildSimplifiedState();
        File createStateTextFile = DiskUtils.createStateTextFile(a11, NonFatalCacheManager.NON_FATAL_STATE);
        try {
            buildSimplifiedState.setUri(DiskUtils.with(a11).writeOperation(new WriteStateToFileDiskOperation(createStateTextFile, buildSimplifiedState.toJson())).execute());
            return createStateTextFile;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
