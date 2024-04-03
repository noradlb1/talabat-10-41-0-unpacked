package com.talabat.splash.data.remote.worker;

import java.io.BufferedInputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DownloadWorker$downloadFile$readData$1 extends Lambda implements Function0<Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f61447g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BufferedInputStream f61448h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ byte[] f61449i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadWorker$downloadFile$readData$1(Ref.IntRef intRef, BufferedInputStream bufferedInputStream, byte[] bArr) {
        super(0);
        this.f61447g = intRef;
        this.f61448h = bufferedInputStream;
        this.f61449i = bArr;
    }

    @NotNull
    public final Integer invoke() {
        this.f61447g.element = this.f61448h.read(this.f61449i);
        return Integer.valueOf(this.f61447g.element);
    }
}
