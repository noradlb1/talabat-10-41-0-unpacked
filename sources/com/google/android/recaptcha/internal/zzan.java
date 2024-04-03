package com.google.android.recaptcha.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
final class zzan extends SuspendLambda implements Function2 {
    final /* synthetic */ zzmy zza;
    final /* synthetic */ zzao zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzan(zzmy zzmy, zzao zzao, Continuation continuation) {
        super(2, continuation);
        this.zza = zzmy;
        this.zzb = zzao;
    }

    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new zzan(this.zza, this.zzb, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzan) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzmy zzmy = this.zza;
        zzao zzao = this.zzb;
        synchronized (zzaj.class) {
            byte[] zzd = zzmy.zzd();
            zzae zzae = new zzae(zzek.zzg().zzi(zzd, 0, zzd.length), System.currentTimeMillis(), 0);
            zzad zza2 = zzao.zze;
            ContentValues contentValues = new ContentValues();
            contentValues.put("ss", zzae.zzc());
            contentValues.put("ts", Long.valueOf(zzae.zzb()));
            SQLiteDatabase writableDatabase = zza2.getWritableDatabase();
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.insert("ce", (String) null, contentValues);
            } else {
                SQLiteInstrumentation.insert(writableDatabase, "ce", (String) null, contentValues);
            }
            int zzb2 = zzao.zze.zzb() - 500;
            if (zzb2 > 0) {
                zzao.zze.zza(CollectionsKt___CollectionsKt.take(zzao.zze.zzd(), zzb2));
            }
            if (zzao.zze.zzb() >= 20) {
                zzao.zzg();
            }
        }
        return Unit.INSTANCE;
    }
}
