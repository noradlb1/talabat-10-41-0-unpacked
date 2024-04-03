package com.google.android.recaptcha.internal;

import android.webkit.ValueCallback;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzba extends SuspendLambda implements Function2 {
    final /* synthetic */ String[] zza;
    final /* synthetic */ zzbb zzb;
    final /* synthetic */ String zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzba(String[] strArr, zzbb zzbb, String str, Continuation continuation) {
        super(2, continuation);
        this.zza = strArr;
        this.zzb = zzbb;
        this.zzc = str;
    }

    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new zzba(this.zza, this.zzb, this.zzc, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzba) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = new ArrayList(r1);
        for (String str : this.zza) {
            arrayList.add("\"" + str + "\"");
        }
        this.zzb.zza.evaluateJavascript(this.zzc + "(" + CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + ")", (ValueCallback) null);
        return Unit.INSTANCE;
    }
}
