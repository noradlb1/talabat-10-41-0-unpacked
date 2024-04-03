package com.instabug.terminations.model;

import android.content.Context;
import android.net.Uri;
import com.instabug.commons.models.IncidentMetadata;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.operation.WriteStateToFileDiskOperation;
import com.instabug.library.model.State;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f52632a = new a();

    private a() {
    }

    public static /* synthetic */ b a(a aVar, Context context, long j11, String str, State state, IncidentMetadata incidentMetadata, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            incidentMetadata = IncidentMetadata.Factory.create$default((String) null, 1, (Object) null);
        }
        return aVar.a(context, j11, str, state, incidentMetadata);
    }

    @NotNull
    public final b a(@Nullable Context context, long j11, @NotNull String str, @Nullable State state, @NotNull IncidentMetadata incidentMetadata) {
        Uri uri;
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(incidentMetadata, TtmlNode.TAG_METADATA);
        b bVar = new b(incidentMetadata, j11);
        if (context == null || state == null) {
            uri = null;
        } else {
            state.updateVisualUserSteps();
            uri = f52632a.a(state, context);
        }
        bVar.a(uri);
        bVar.a(str);
        return bVar;
    }

    @NotNull
    public final b a(long j11, @NotNull IncidentMetadata incidentMetadata, @NotNull Function1 function1) {
        Intrinsics.checkNotNullParameter(incidentMetadata, TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullParameter(function1, "creator");
        b bVar = new b(incidentMetadata, j11);
        function1.invoke(bVar);
        return bVar;
    }

    private final Uri a(State state, Context context) {
        Uri execute = DiskUtils.with(context).writeOperation(new WriteStateToFileDiskOperation(DiskUtils.createStateTextFile(context, "app_termination_state"), state.toJson())).execute();
        Intrinsics.checkNotNullExpressionValue(execute, "createStateTextFile(cont… .execute()\n            }");
        return execute;
    }
}
