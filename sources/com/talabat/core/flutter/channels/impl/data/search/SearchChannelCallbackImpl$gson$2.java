package com.talabat.core.flutter.channels.impl.data.search;

import JsonModels.parser.UniversalGson;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SearchChannelCallbackImpl$gson$2 extends Lambda implements Function0<Gson> {
    public static final SearchChannelCallbackImpl$gson$2 INSTANCE = new SearchChannelCallbackImpl$gson$2();

    public SearchChannelCallbackImpl$gson$2() {
        super(0);
    }

    public final Gson invoke() {
        return UniversalGson.INSTANCE.gson;
    }
}
