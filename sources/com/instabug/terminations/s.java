package com.instabug.terminations;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.instabug.commons.snapshot.e;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(30)
public final class s extends g {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(@NotNull e eVar) {
        super(eVar);
        Intrinsics.checkNotNullParameter(eVar, "configurations");
    }

    @NotNull
    /* renamed from: b */
    public r a(@NotNull Context context, @Nullable Object obj) {
        r rVar;
        Intrinsics.checkNotNullParameter(context, "ctx");
        q qVar = q.f52649a;
        if (obj instanceof r) {
            rVar = (r) obj;
        } else {
            rVar = null;
        }
        return qVar.a(context, rVar);
    }
}
