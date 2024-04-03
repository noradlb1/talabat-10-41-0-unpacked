package com.instabug.library.diagnostics.nonfatals;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.instabug.library.diagnostics.nonfatals.model.a;
import java.util.List;

public interface e {
    List a();

    void b();

    void c();

    void clearCache();

    @WorkerThread
    void saveNonFatal(@NonNull a aVar);
}
