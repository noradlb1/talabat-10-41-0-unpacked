package com.talabat.helpcenter.presentation.viewModel;

import com.talabat.helpcenter.domain.entity.GlobalHelpCenterConfig;
import com.talabat.helpcenter.domain.exception.UnableToFetchGlobalHelpCenterConfig;
import com.talabat.helpcenter.domain.repository.HelpCenterRepository;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.helpcenter.presentation.viewModel.GlobalHelpCenterViewModel$onAttach$1", f = "GlobalHelpCenterViewModel.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
public final class GlobalHelpCenterViewModel$onAttach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60757h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ GlobalHelpCenterViewModel f60758i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f60759j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f60760k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f60761l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalHelpCenterViewModel$onAttach$1(GlobalHelpCenterViewModel globalHelpCenterViewModel, String str, String str2, String str3, Continuation<? super GlobalHelpCenterViewModel$onAttach$1> continuation) {
        super(2, continuation);
        this.f60758i = globalHelpCenterViewModel;
        this.f60759j = str;
        this.f60760k = str2;
        this.f60761l = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlobalHelpCenterViewModel$onAttach$1(this.f60758i, this.f60759j, this.f60760k, this.f60761l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlobalHelpCenterViewModel$onAttach$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60757h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            HelpCenterRepository access$getHelpCenterRepository$p = this.f60758i.helpCenterRepository;
            String str = this.f60759j;
            String str2 = this.f60760k;
            String access$getSelectedLanguage$p = this.f60758i.selectedLanguage;
            int access$getCountry$p = this.f60758i.country;
            String str3 = this.f60761l;
            String access$getAppPlatform$p = this.f60758i.appPlatform;
            this.f60757h = 1;
            obj = access$getHelpCenterRepository$p.getGlobalHelpCenterConfig(str, str2, access$getSelectedLanguage$p, access$getCountry$p, str3, access$getAppPlatform$p, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (UnableToFetchGlobalHelpCenterConfig unused) {
                this.f60758i.hideHelpCenter();
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f60758i.showHelpCenter(((GlobalHelpCenterConfig) obj).getHelpCenterUrl());
        return Unit.INSTANCE;
    }
}
