package com.braze.ui.contentcards.adapters;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ContentCardAdapter$getCardAtIndex$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f44064g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ContentCardAdapter f44065h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentCardAdapter$getCardAtIndex$1(int i11, ContentCardAdapter contentCardAdapter) {
        super(0);
        this.f44064g = i11;
        this.f44065h = contentCardAdapter;
    }

    @NotNull
    public final String invoke() {
        return "Cannot return card at index: " + this.f44064g + " in cards list of size: " + this.f44065h.cardData.size();
    }
}
