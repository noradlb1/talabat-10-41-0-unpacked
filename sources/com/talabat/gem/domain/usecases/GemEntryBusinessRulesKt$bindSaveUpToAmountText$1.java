package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.ports.presentation.GemEntryViewPort;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemEntryBusinessRulesKt$bindSaveUpToAmountText$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemEntryViewPort f60392g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemEntryBusinessRulesKt$bindSaveUpToAmountText$1(GemEntryViewPort gemEntryViewPort) {
        super(0);
        this.f60392g = gemEntryViewPort;
    }

    @Nullable
    public final Disposable invoke() {
        Observable<GemOffer> observeOn = this.f60392g.getOffer().share().observeOn(this.f60392g.getScheduler());
        Intrinsics.checkNotNullExpressionValue(observeOn, "offer.share().observeOn(scheduler)");
        AnonymousClass1 r32 = new Function1<Throwable, Unit>(this.f60392g.getErrors()) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "p0");
                ((Subject) this.receiver).onNext(th2);
            }
        };
        final GemEntryViewPort gemEntryViewPort = this.f60392g;
        return SubscribersKt.subscribeBy$default((Observable) observeOn, (Function1) r32, (Function0) null, (Function1) new Function1<GemOffer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GemOffer) obj);
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: com.talabat.gem.domain.entities.GemTier} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(com.talabat.gem.domain.entities.GemOffer r11) {
                /*
                    r10 = this;
                    java.util.List r0 = r11.getTiers()
                    if (r0 == 0) goto L_0x00a9
                    java.lang.Iterable r0 = (java.lang.Iterable) r0
                    java.util.Iterator r0 = r0.iterator()
                    boolean r1 = r0.hasNext()
                    if (r1 != 0) goto L_0x0014
                    r0 = 0
                    goto L_0x0053
                L_0x0014:
                    java.lang.Object r1 = r0.next()
                    boolean r2 = r0.hasNext()
                    if (r2 != 0) goto L_0x0020
                L_0x001e:
                    r0 = r1
                    goto L_0x0053
                L_0x0020:
                    r2 = r1
                    com.talabat.gem.domain.entities.GemTier r2 = (com.talabat.gem.domain.entities.GemTier) r2
                    java.lang.Double r2 = r2.getOnTotalAmount()
                    r3 = 0
                    if (r2 == 0) goto L_0x0030
                    double r5 = r2.doubleValue()
                    goto L_0x0031
                L_0x0030:
                    r5 = r3
                L_0x0031:
                    java.lang.Object r2 = r0.next()
                    r7 = r2
                    com.talabat.gem.domain.entities.GemTier r7 = (com.talabat.gem.domain.entities.GemTier) r7
                    java.lang.Double r7 = r7.getOnTotalAmount()
                    if (r7 == 0) goto L_0x0043
                    double r7 = r7.doubleValue()
                    goto L_0x0044
                L_0x0043:
                    r7 = r3
                L_0x0044:
                    int r9 = java.lang.Double.compare(r5, r7)
                    if (r9 >= 0) goto L_0x004c
                    r1 = r2
                    r5 = r7
                L_0x004c:
                    boolean r2 = r0.hasNext()
                    if (r2 != 0) goto L_0x0031
                    goto L_0x001e
                L_0x0053:
                    com.talabat.gem.domain.entities.GemTier r0 = (com.talabat.gem.domain.entities.GemTier) r0
                    if (r0 == 0) goto L_0x00a9
                    com.talabat.gem.ports.presentation.GemEntryViewPort r1 = r0
                    io.reactivex.subjects.BehaviorSubject r1 = r1.getSaveUpToAmountText()
                    com.talabat.gem.domain.usecases.SaveUpToAmountText r9 = new com.talabat.gem.domain.usecases.SaveUpToAmountText
                    java.text.DecimalFormat r2 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
                    double r3 = com.talabat.gem.domain.usecases.BusinessRulesKt.savedAmount(r0)
                    java.lang.String r3 = r2.format(r3)
                    java.lang.String r2 = "DecimalFormat.format(it.savedAmount())"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
                    java.lang.String r2 = r0.getCurrency()
                    if (r2 != 0) goto L_0x0078
                    java.lang.String r2 = ""
                L_0x0078:
                    r4 = r2
                    java.text.DecimalFormat r2 = com.talabat.gem.domain.usecases.BusinessRulesKt.getDecimalFormat()
                    java.lang.Float r0 = r0.getDiscountPercentage()
                    float r0 = com.talabat.talabatcommon.extentions.FloatKt.orZero((java.lang.Float) r0)
                    r5 = 100
                    float r5 = (float) r5
                    float r0 = r0 * r5
                    java.lang.Float r0 = java.lang.Float.valueOf(r0)
                    java.lang.String r5 = r2.format(r0)
                    java.lang.String r0 = "DecimalFormat.format(it.…Zero().times(PERCENTAGE))"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                    java.lang.String r6 = r11.getBrandingMessage()
                    java.lang.String r7 = r11.getCollectionTitle()
                    java.lang.String r8 = r11.getCollectionSubtitle()
                    r2 = r9
                    r2.<init>(r3, r4, r5, r6, r7, r8)
                    com.talabat.talabatcommon.extentions.RxKt.plusAssign(r1, r9)
                L_0x00a9:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.domain.usecases.GemEntryBusinessRulesKt$bindSaveUpToAmountText$1.AnonymousClass2.invoke(com.talabat.gem.domain.entities.GemOffer):void");
            }
        }, 2, (Object) null);
    }
}
