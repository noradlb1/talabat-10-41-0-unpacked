package com.talabat.gem.adapters.presentation.collections;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.GemOfferRequester;
import com.talabat.gem.domain.usecases.GemViewBusinessRulesKt;
import com.talabat.gem.domain.usecases.SaveUpToAmountText;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEvents;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEventsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.ReplaySubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionViewHolder$initialize$1$2 extends Lambda implements Function1<AutoDisposable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f59975g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemCollectionViewHolder f59976h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ View f59977i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCollectionViewHolder$initialize$1$2(ViewGroup viewGroup, GemCollectionViewHolder gemCollectionViewHolder, View view) {
        super(1);
        this.f59975g = viewGroup;
        this.f59976h = gemCollectionViewHolder;
        this.f59977i = view;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AutoDisposable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AutoDisposable autoDisposable) {
        Intrinsics.checkNotNullParameter(autoDisposable, "$this$null");
        final GemCollectionViewHolder gemCollectionViewHolder = this.f59976h;
        autoDisposable.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                return RxKt.invoke(gemCollectionViewHolder.getErrors(), AnonymousClass1.INSTANCE);
            }
        });
        final GemCollectionViewHolder gemCollectionViewHolder2 = this.f59976h;
        final View view = this.f59977i;
        autoDisposable.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                BehaviorSubject<Boolean> visibility = gemCollectionViewHolder2.getVisibility();
                final GemCollectionViewHolder gemCollectionViewHolder = gemCollectionViewHolder2;
                final View view = view;
                return RxKt.invoke(visibility, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                        observerCallbacks.transform(AnonymousClass1.INSTANCE);
                        ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                        final GemCollectionViewHolder gemCollectionViewHolder = gemCollectionViewHolder;
                        final View view = view;
                        on2.next(new Function1<Boolean, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Boolean) obj);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARNING: Removed duplicated region for block: B:21:0x006b  */
                            /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
                            /* JADX WARNING: Removed duplicated region for block: B:8:0x003c  */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void invoke(java.lang.Boolean r5) {
                                /*
                                    r4 = this;
                                    com.talabat.gem.adapters.presentation.collections.GemCollectionViewHolder r0 = r1
                                    io.reactivex.subjects.BehaviorSubject r0 = r0.mode
                                    java.lang.Object r0 = com.talabat.talabatcommon.extentions.RxKt.invoke(r0)
                                    com.talabat.gem.domain.entities.GemMode r1 = com.talabat.gem.domain.entities.GemMode.DISABLED
                                    r2 = 0
                                    if (r0 == r1) goto L_0x001c
                                    java.lang.String r0 = "it"
                                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                                    boolean r5 = r5.booleanValue()
                                    if (r5 == 0) goto L_0x001c
                                    r5 = 1
                                    goto L_0x001d
                                L_0x001c:
                                    r5 = r2
                                L_0x001d:
                                    com.talabat.gem.adapters.presentation.collections.GemCollectionViewHolder r0 = r1
                                    android.view.View r0 = r0.itemView
                                    java.lang.String r1 = "itemView"
                                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r5)
                                    r3 = 8
                                    com.talabat.talabatcommon.extension.ViewKt.get(r0, r1, r3)
                                    android.view.View r0 = r2
                                    android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
                                    java.lang.String r1 = "layoutParams"
                                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                                    if (r5 == 0) goto L_0x003d
                                    r2 = -2
                                L_0x003d:
                                    r0.width = r2
                                    android.view.View r1 = r2
                                    r1.setLayoutParams(r0)
                                    if (r5 == 0) goto L_0x0059
                                    com.talabat.gem.adapters.presentation.collections.GemCollectionViewHolder r0 = r1
                                    com.talabat.talabatcommon.extentions.SingleAccess r0 = r0.onEnabledAction
                                    if (r0 == 0) goto L_0x0059
                                    java.lang.Object r0 = r0.getValue()
                                    kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
                                    if (r0 == 0) goto L_0x0059
                                    r0.invoke()
                                L_0x0059:
                                    if (r5 != 0) goto L_0x006e
                                    com.talabat.gem.adapters.presentation.collections.GemCollectionViewHolder r5 = r1
                                    com.talabat.talabatcommon.extentions.SingleAccess r5 = r5.onDisabledAction
                                    if (r5 == 0) goto L_0x006e
                                    java.lang.Object r5 = r5.getValue()
                                    kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
                                    if (r5 == 0) goto L_0x006e
                                    r5.invoke()
                                L_0x006e:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.adapters.presentation.collections.GemCollectionViewHolder$initialize$1$2.AnonymousClass2.AnonymousClass1.AnonymousClass2.invoke(java.lang.Boolean):void");
                            }
                        });
                    }
                });
            }
        });
        final GemCollectionViewHolder gemCollectionViewHolder3 = this.f59976h;
        final View view2 = this.f59977i;
        autoDisposable.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                BehaviorSubject<String> counter = gemCollectionViewHolder3.getCounter();
                final View view = view2;
                return RxKt.invoke(counter, new Function1<ObserverCallbacks<String, Observable<String>>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ObserverCallbacks<String, Observable<String>>) (ObserverCallbacks) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull ObserverCallbacks<String, Observable<String>> observerCallbacks) {
                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                        ObserverCallbacks<String, Observable<String>> on2 = observerCallbacks.getOn();
                        final View view = view;
                        on2.next(new Function1<String, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((String) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(String str) {
                                TextView textView = (TextView) view.findViewById(R.id.gemCollectionCounterTextView);
                                Intrinsics.checkNotNullExpressionValue(textView, "gemCollectionCounterTextView");
                                ViewKt.plusAssign(textView, str);
                            }
                        });
                    }
                });
            }
        });
        final GemCollectionViewHolder gemCollectionViewHolder4 = this.f59976h;
        final View view3 = this.f59977i;
        autoDisposable.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                BehaviorSubject<SaveUpToAmountText> saveUpToAmountText = gemCollectionViewHolder4.getSaveUpToAmountText();
                final View view = view3;
                return RxKt.invoke(saveUpToAmountText, new Function1<ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>>) (ObserverCallbacks) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>> observerCallbacks) {
                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                        ObserverCallbacks<SaveUpToAmountText, Observable<SaveUpToAmountText>> on2 = observerCallbacks.getOn();
                        final View view = view;
                        on2.next(new Function1<SaveUpToAmountText, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SaveUpToAmountText) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SaveUpToAmountText saveUpToAmountText) {
                                TextView textView = (TextView) view.findViewById(R.id.gemCollectionLabelTextView);
                                Intrinsics.checkNotNullExpressionValue(textView, "gemCollectionLabelTextView");
                                View view = view;
                                Intrinsics.checkNotNullExpressionValue(view, "");
                                ViewKt.plusAssign(textView, StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(ViewKt.getString(view, com.talabat.localization.R.string.gem_floating_view_save_amount), "{saveAmount}", saveUpToAmountText.getSaveAmount(), false, 4, (Object) null), "{currency}", saveUpToAmountText.getCurrency(), false, 4, (Object) null));
                            }
                        });
                    }
                });
            }
        });
        final GemCollectionViewHolder gemCollectionViewHolder5 = this.f59976h;
        autoDisposable.autoDispose(new Function0<Disposable>() {
            @Nullable
            public final Disposable invoke() {
                ReplaySubject<GemEntryViewConfigurations> gemCollectionsConfigurations = GemCollectionsIntegrationKt.getGemCollectionsConfigurations();
                final GemCollectionViewHolder gemCollectionViewHolder = gemCollectionViewHolder5;
                return RxKt.invoke(gemCollectionsConfigurations, new Function1<ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>>) (ObserverCallbacks) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>> observerCallbacks) {
                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                        ObserverCallbacks<GemEntryViewConfigurations, Observable<GemEntryViewConfigurations>> on2 = observerCallbacks.getOn();
                        final GemCollectionViewHolder gemCollectionViewHolder = gemCollectionViewHolder;
                        on2.next(new Function1<GemEntryViewConfigurations, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GemEntryViewConfigurations) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GemEntryViewConfigurations gemEntryViewConfigurations) {
                                GemMode mode$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getWith().getMode$com_talabat_Components_gem_gem();
                                if (mode$com_talabat_Components_gem_gem != null) {
                                    RxKt.plusAssign(gemCollectionViewHolder.mode, mode$com_talabat_Components_gem_gem);
                                }
                                Function1<GemRestaurant, Unit> onSelected$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getOn().getOnSelected$com_talabat_Components_gem_gem();
                                if (onSelected$com_talabat_Components_gem_gem != null) {
                                    gemCollectionViewHolder.onSelectedAction = onSelected$com_talabat_Components_gem_gem;
                                }
                                Function0<Unit> onEnabled$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getOn().getOnEnabled$com_talabat_Components_gem_gem();
                                if (onEnabled$com_talabat_Components_gem_gem != null) {
                                    gemCollectionViewHolder.onEnabledAction = new SingleAccess(onEnabled$com_talabat_Components_gem_gem);
                                }
                                Function0<Unit> onDisabled$com_talabat_Components_gem_gem = gemEntryViewConfigurations.getOn().getOnDisabled$com_talabat_Components_gem_gem();
                                if (onDisabled$com_talabat_Components_gem_gem != null) {
                                    gemCollectionViewHolder.onDisabledAction = new SingleAccess(onDisabled$com_talabat_Components_gem_gem);
                                }
                            }
                        });
                    }
                });
            }
        });
        Context context = this.f59975g.getContext();
        final GemCollectionViewHolder gemCollectionViewHolder6 = this.f59976h;
        ContextLifecycleEventsKt.withLifecycleEvents(context, new Function1<ContextLifecycleEvents, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContextLifecycleEvents) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContextLifecycleEvents contextLifecycleEvents) {
                Intrinsics.checkNotNullParameter(contextLifecycleEvents, "$this$null");
                ContextLifecycleEvents on2 = contextLifecycleEvents.getOn();
                final GemCollectionViewHolder gemCollectionViewHolder = gemCollectionViewHolder6;
                on2.resume(new Function0<Unit>() {
                    public final void invoke() {
                        GemViewBusinessRulesKt.bindOffer$default(gemCollectionViewHolder, GemOfferRequester.Existing.INSTANCE, (Function1) null, 2, (Object) null);
                    }
                });
            }
        });
    }
}
