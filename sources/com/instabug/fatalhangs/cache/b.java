package com.instabug.fatalhangs.cache;

import android.content.Context;
import android.net.Uri;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.fatalhangs.model.c;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.AttachmentsDbHelper;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
import com.instabug.library.internal.storage.cache.dbv2.IBGDbManager;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import com.instabug.library.internal.storage.operation.DeleteUriDiskOperation;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b implements a {
    private final IBGContentValues b(c cVar) {
        IBGContentValues iBGContentValues = new IBGContentValues();
        if (cVar.c() != null) {
            iBGContentValues.put("id", cVar.c(), true);
        }
        String j11 = cVar.j();
        if (j11 != null) {
            iBGContentValues.put("temporary_server_token", j11, true);
        }
        String f11 = cVar.f();
        if (f11 != null) {
            iBGContentValues.put("message", f11, true);
        }
        iBGContentValues.put("fatal_hang_state", Integer.valueOf(cVar.b()), true);
        Uri i11 = cVar.i();
        if (i11 != null) {
            iBGContentValues.put("state", i11.toString(), true);
        }
        String e11 = cVar.e();
        if (e11 != null) {
            iBGContentValues.put("main_thread_details", e11, true);
        }
        String g11 = cVar.g();
        if (g11 != null) {
            iBGContentValues.put(InstabugDbContract.CrashEntry.COLUMN_THREADS_DETAILS, g11, true);
        }
        iBGContentValues.put("last_activity", cVar.d(), true);
        String uuid = cVar.getMetadata().getUuid();
        if (uuid != null) {
            iBGContentValues.put("uuid", uuid, true);
        }
        return iBGContentValues;
    }

    public void a(@NotNull c cVar, @Nullable Context context) {
        Intrinsics.checkNotNullParameter(cVar, "fatalHang");
        try {
            IBGDbManager.getInstance().insert("fatal_hangs_table", (String) null, b(cVar));
            for (Attachment attachment : cVar.a()) {
                long insert = AttachmentsDbHelper.insert(attachment, cVar.c());
                if (insert != -1) {
                    attachment.setId(insert);
                }
            }
            a(com.instabug.fatalhangs.di.c.f46466a.h(), context);
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "Failed to insert Fatal-Hang");
        }
    }

    public void a(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "fatalHang");
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new IBGWhereArg(String.valueOf(cVar.c()), true));
            IBGDbManager.getInstance().update("fatal_hangs_table", b(cVar), "id = ?", arrayList);
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "Failed to update Fatal-Hang");
        }
    }

    public void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new IBGWhereArg(str, true));
            IBGDbManager.getInstance().delete("fatal_hangs_table", "id = ?", arrayList);
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "Failed to delete Fatal-Hang");
        }
    }

    @Nullable
    @androidx.annotation.Nullable
    public c a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            IBGCursor query = IBGDbManager.getInstance().query("fatal_hangs_table", (String[]) null, (String) null, (List<IBGWhereArg>) null, (String) null, (String) null, (String) null, "1");
            if (query == null) {
                return null;
            }
            if (query.moveToFirst()) {
                c cVar = new c(IncidentMetadata.Factory.create(query.getString(query.getColumnIndex("uuid"))));
                cVar.a(query.getString(query.getColumnIndex("id")));
                cVar.d(query.getString(query.getColumnIndex("message")));
                cVar.c(query.getString(query.getColumnIndex("main_thread_details")));
                cVar.e(query.getString(query.getColumnIndex(InstabugDbContract.CrashEntry.COLUMN_THREADS_DETAILS)));
                cVar.a(query.getInt(query.getColumnIndex("fatal_hang_state")));
                String string = query.getString(query.getColumnIndex("state"));
                cVar.f(query.getString(query.getColumnIndex("temporary_server_token")));
                String string2 = query.getString(query.getColumnIndex("last_activity"));
                Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(cursor.…ry.COLUMN_LAST_ACTIVITY))");
                cVar.b(string2);
                ArrayList<Attachment> retrieve = AttachmentsDbHelper.retrieve(cVar.c(), DatabaseManager.getInstance().openDatabase());
                Intrinsics.checkNotNullExpressionValue(retrieve, "retrieve(\n              …                        )");
                cVar.a((List) retrieve);
                if (string != null) {
                    a(cVar, context, string);
                }
                query.close();
                return cVar;
            }
            query.close();
            return null;
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "Failed to retrieve Fatal-Hangs");
            return null;
        }
    }

    public void b(@Nullable Context context) {
        a(0, context);
    }

    private final void a(int i11, Context context) {
        try {
            IBGCursor query = IBGDbManager.getInstance().query("fatal_hangs_table", (String[]) null, (String) null, (List<IBGWhereArg>) null, (String) null, (String) null, (String) null);
            if (query != null) {
                int count = query.getCount();
                if (query.getCount() <= i11) {
                    query.close();
                    return;
                }
                query.moveToFirst();
                if (context != null) {
                    while (count > i11) {
                        String string = query.getString(query.getColumnIndex("state"));
                        String string2 = query.getString(query.getColumnIndex("id"));
                        if (string != null) {
                            DiskUtils.with(context).deleteOperation(new DeleteUriDiskOperation(Uri.parse(string))).execute();
                        }
                        Intrinsics.checkNotNullExpressionValue(string2, "id");
                        a(string2);
                        count--;
                        query.moveToNext();
                    }
                }
                query.close();
            }
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "Failed to trim Fatal-Hangs");
        }
    }

    private final void a(c cVar, Context context, String str) {
        Object obj;
        Uri uri;
        try {
            Result.Companion companion = Result.Companion;
            if (str == null) {
                uri = null;
            } else {
                uri = Uri.parse(str);
            }
            cVar.b(uri);
            cVar.a(State.getState(context, uri));
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            InstabugCore.reportError(r22, "Retrieving Fatal hang state throws OOM");
            InstabugSDKLogger.e("IBG-CR", "Retrieving Fatal hang state throws OOM", r22);
        }
    }
}
