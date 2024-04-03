package com.talabat.helpcenter.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.helpcenter.data.repository.HelpCenterRepositoryDefault", f = "HelpCenterRepositoryDefault.kt", i = {}, l = {20}, m = "getGlobalHelpCenterConfig", n = {}, s = {})
public final class HelpCenterRepositoryDefault$getGlobalHelpCenterConfig$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f60736h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ HelpCenterRepositoryDefault f60737i;

    /* renamed from: j  reason: collision with root package name */
    public int f60738j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HelpCenterRepositoryDefault$getGlobalHelpCenterConfig$1(HelpCenterRepositoryDefault helpCenterRepositoryDefault, Continuation<? super HelpCenterRepositoryDefault$getGlobalHelpCenterConfig$1> continuation) {
        super(continuation);
        this.f60737i = helpCenterRepositoryDefault;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f60736h = obj;
        this.f60738j |= Integer.MIN_VALUE;
        return this.f60737i.getGlobalHelpCenterConfig((String) null, (String) null, (String) null, 0, (String) null, (String) null, this);
    }
}
