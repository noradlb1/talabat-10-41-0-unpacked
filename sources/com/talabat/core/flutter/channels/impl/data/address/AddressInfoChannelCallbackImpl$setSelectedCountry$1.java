package com.talabat.core.flutter.channels.impl.data.address;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.flutter.channels.impl.data.address.AddressInfoChannelCallbackImpl", f = "AddressInfoChannelCallbackImpl.kt", i = {0}, l = {289}, m = "setSelectedCountry", n = {"this"}, s = {"L$0"})
public final class AddressInfoChannelCallbackImpl$setSelectedCountry$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55907h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55908i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AddressInfoChannelCallbackImpl f55909j;

    /* renamed from: k  reason: collision with root package name */
    public int f55910k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddressInfoChannelCallbackImpl$setSelectedCountry$1(AddressInfoChannelCallbackImpl addressInfoChannelCallbackImpl, Continuation<? super AddressInfoChannelCallbackImpl$setSelectedCountry$1> continuation) {
        super(continuation);
        this.f55909j = addressInfoChannelCallbackImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55908i = obj;
        this.f55910k |= Integer.MIN_VALUE;
        return this.f55909j.setSelectedCountry(0, this);
    }
}
