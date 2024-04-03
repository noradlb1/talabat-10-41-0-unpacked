package com.talabat.sdsquad.data.inlineads;

import androidx.annotation.VisibleForTesting;
import com.talabat.sdsquad.data.vendorslist.VendorsApi;
import com.talabat.searchdiscovery.features.vendorslist.models.responses.Ad;
import com.talabat.searchdiscovery.features.vendorslist.models.responses.InlineAdsResponse;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wt.a;
import wt.b;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/data/inlineads/InLineAdsRepositoryImp;", "Lcom/talabat/sdsquad/data/inlineads/InLineAdsRepository;", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "(Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;)V", "cachedInlineAds", "Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/InlineAdsResponse;", "getCachedInlineAds$annotations", "()V", "getCachedInlineAds", "()Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/InlineAdsResponse;", "setCachedInlineAds", "(Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/InlineAdsResponse;)V", "getInlineAds", "Lio/reactivex/Flowable;", "isForceUpdate", "", "countryId", "", "loadInlineAds", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InLineAdsRepositoryImp implements InLineAdsRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static InLineAdsRepositoryImp INSTANCE;
    @Nullable
    private InlineAdsResponse cachedInlineAds;
    @NotNull
    private final VendorsApi vendorsApi;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/sdsquad/data/inlineads/InLineAdsRepositoryImp$Companion;", "", "()V", "INSTANCE", "Lcom/talabat/sdsquad/data/inlineads/InLineAdsRepositoryImp;", "destroyInstance", "", "getInstance", "vendorsApi", "Lcom/talabat/sdsquad/data/vendorslist/VendorsApi;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void destroyInstance() {
            InLineAdsRepositoryImp.INSTANCE = null;
        }

        @JvmStatic
        @NotNull
        public final InLineAdsRepositoryImp getInstance(@NotNull VendorsApi vendorsApi) {
            InLineAdsRepositoryImp access$getINSTANCE$cp;
            Intrinsics.checkNotNullParameter(vendorsApi, "vendorsApi");
            InLineAdsRepositoryImp access$getINSTANCE$cp2 = InLineAdsRepositoryImp.INSTANCE;
            if (access$getINSTANCE$cp2 != null) {
                return access$getINSTANCE$cp2;
            }
            synchronized (InLineAdsRepositoryImp.class) {
                access$getINSTANCE$cp = InLineAdsRepositoryImp.INSTANCE;
                if (access$getINSTANCE$cp == null) {
                    access$getINSTANCE$cp = new InLineAdsRepositoryImp(vendorsApi, (DefaultConstructorMarker) null);
                    InLineAdsRepositoryImp.INSTANCE = access$getINSTANCE$cp;
                }
            }
            return access$getINSTANCE$cp;
        }
    }

    private InLineAdsRepositoryImp(VendorsApi vendorsApi2) {
        this.vendorsApi = vendorsApi2;
    }

    public /* synthetic */ InLineAdsRepositoryImp(VendorsApi vendorsApi2, DefaultConstructorMarker defaultConstructorMarker) {
        this(vendorsApi2);
    }

    @JvmStatic
    public static final void destroyInstance() {
        Companion.destroyInstance();
    }

    @VisibleForTesting
    public static /* synthetic */ void getCachedInlineAds$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final InLineAdsRepositoryImp getInstance(@NotNull VendorsApi vendorsApi2) {
        return Companion.getInstance(vendorsApi2);
    }

    private final Flowable<InlineAdsResponse> loadInlineAds(String str) {
        Flowable<InlineAdsResponse> doOnNext = this.vendorsApi.getInlineAds(str).onErrorReturn(new a()).doOnNext(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "vendorsApi.getInlineAds(… { cachedInlineAds = it }");
        return doOnNext;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadInlineAds$lambda-0  reason: not valid java name */
    public static final InlineAdsResponse m10775loadInlineAds$lambda0(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return new InlineAdsResponse((List<Ad>) null, (Integer) null, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadInlineAds$lambda-1  reason: not valid java name */
    public static final void m10776loadInlineAds$lambda1(InLineAdsRepositoryImp inLineAdsRepositoryImp, InlineAdsResponse inlineAdsResponse) {
        Intrinsics.checkNotNullParameter(inLineAdsRepositoryImp, "this$0");
        inLineAdsRepositoryImp.cachedInlineAds = inlineAdsResponse;
    }

    @Nullable
    public final InlineAdsResponse getCachedInlineAds() {
        return this.cachedInlineAds;
    }

    @NotNull
    public Flowable<InlineAdsResponse> getInlineAds(boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "countryId");
        InlineAdsResponse inlineAdsResponse = this.cachedInlineAds;
        if (inlineAdsResponse == null || z11) {
            return loadInlineAds(str);
        }
        Flowable<InlineAdsResponse> just = Flowable.just(inlineAdsResponse);
        Intrinsics.checkNotNullExpressionValue(just, "{\n            Flowable.j…achedInlineAds)\n        }");
        return just;
    }

    public final void setCachedInlineAds(@Nullable InlineAdsResponse inlineAdsResponse) {
        this.cachedInlineAds = inlineAdsResponse;
    }
}
