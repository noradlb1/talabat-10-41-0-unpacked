package com.braze.ui.actions.brazeactions;

import android.net.Uri;
import com.appboy.enums.Channel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BrazeActionParser$execute$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Channel f44014g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Uri f44015h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrazeActionParser$execute$1(Channel channel, Uri uri) {
        super(0);
        this.f44014g = channel;
        this.f44015h = uri;
    }

    @NotNull
    public final String invoke() {
        return "Attempting to parse Braze Action with channel " + this.f44014g + " and uri:\n'" + this.f44015h + '\'';
    }
}
