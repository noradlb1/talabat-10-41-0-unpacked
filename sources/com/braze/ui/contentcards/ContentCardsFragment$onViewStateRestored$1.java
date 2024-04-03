package com.braze.ui.contentcards;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import com.braze.ui.contentcards.adapters.ContentCardAdapter;
import java.util.ArrayList;
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
@DebugMetadata(c = "com.braze.ui.contentcards.ContentCardsFragment$onViewStateRestored$1", f = "ContentCardsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ContentCardsFragment$onViewStateRestored$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f44061h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Bundle f44062i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ContentCardsFragment f44063j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentCardsFragment$onViewStateRestored$1(Bundle bundle, ContentCardsFragment contentCardsFragment, Continuation<? super ContentCardsFragment$onViewStateRestored$1> continuation) {
        super(2, continuation);
        this.f44062i = bundle;
        this.f44063j = contentCardsFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ContentCardsFragment$onViewStateRestored$1(this.f44062i, this.f44063j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ContentCardsFragment$onViewStateRestored$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Parcelable parcelable;
        ArrayList<String> stringArrayList;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f44061h == 0) {
            ResultKt.throwOnFailure(obj);
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) this.f44062i.getParcelable("LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY", Parcelable.class);
            } else {
                parcelable = this.f44062i.getParcelable("LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY");
            }
            RecyclerView contentCardsRecyclerView = this.f44063j.getContentCardsRecyclerView();
            if (contentCardsRecyclerView != null) {
                RecyclerView.LayoutManager layoutManager = contentCardsRecyclerView.getLayoutManager();
                if (!(parcelable == null || layoutManager == null)) {
                    layoutManager.onRestoreInstanceState(parcelable);
                }
            }
            ContentCardAdapter contentCardAdapter = this.f44063j.cardAdapter;
            if (!(contentCardAdapter == null || (stringArrayList = this.f44062i.getStringArrayList("KNOWN_CARD_IMPRESSIONS_SAVED_INSTANCE_STATE_KEY")) == null)) {
                contentCardAdapter.setImpressedCardIds(stringArrayList);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
