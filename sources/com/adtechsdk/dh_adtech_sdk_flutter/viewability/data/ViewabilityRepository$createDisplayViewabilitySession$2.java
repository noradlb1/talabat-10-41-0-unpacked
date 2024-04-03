package com.adtechsdk.dh_adtech_sdk_flutter.viewability.data;

import android.content.Context;
import com.adtechsdk.dh_adtech_sdk_flutter.viewability.entities.Creative;
import com.iab.omid.library.deliveryhero3.adsession.AdSession;
import com.iab.omid.library.deliveryhero3.adsession.CreativeType;
import com.iab.omid.library.deliveryhero3.adsession.ImpressionType;
import com.iab.omid.library.deliveryhero3.adsession.Owner;
import com.iab.omid.library.deliveryhero3.adsession.Partner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/OmSdkDisplayViewabilitySession;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.adtechsdk.dh_adtech_sdk_flutter.viewability.data.ViewabilityRepository$createDisplayViewabilitySession$2", f = "ViewabilityRepository.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
public final class ViewabilityRepository$createDisplayViewabilitySession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OmSdkDisplayViewabilitySession>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f40030h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ViewabilityRepository f40031i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Context f40032j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Creative f40033k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewabilityRepository$createDisplayViewabilitySession$2(ViewabilityRepository viewabilityRepository, Context context, Creative creative, Continuation<? super ViewabilityRepository$createDisplayViewabilitySession$2> continuation) {
        super(2, continuation);
        this.f40031i = viewabilityRepository;
        this.f40032j = context;
        this.f40033k = creative;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ViewabilityRepository$createDisplayViewabilitySession$2(this.f40031i, this.f40032j, this.f40033k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super OmSdkDisplayViewabilitySession> continuation) {
        return ((ViewabilityRepository$createDisplayViewabilitySession$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f40030h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            OmJsSdkDataSource access$getOmJsSdkDataSource$p = this.f40031i.omJsSdkDataSource;
            Context context = this.f40032j;
            this.f40030h = 1;
            obj = access$getOmJsSdkDataSource$p.getOmidJsSdk(context, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f40031i.omSdkDataSource.ensureOmidIsActivated(this.f40032j);
        Partner createPartner = this.f40031i.omSdkDataSource.createPartner(this.f40031i.partnerName, this.f40033k.getSdkVersion());
        AdSession createAdDisplaySession = this.f40031i.omSdkDataSource.createAdDisplaySession(this.f40031i.omSdkDataSource.createAdSessionConfiguration(CreativeType.NATIVE_DISPLAY, ImpressionType.VIEWABLE, Owner.NATIVE, Owner.NONE, false), this.f40031i.omSdkDataSource.createAdSessionContext(createPartner, (String) obj, this.f40031i.getVerificationScriptResources(this.f40033k), this.f40033k.getMediaURL(), (String) null));
        return new OmSdkDisplayViewabilitySession(createAdDisplaySession, this.f40031i.omSdkDataSource.createAdEvents(createAdDisplaySession));
    }
}
