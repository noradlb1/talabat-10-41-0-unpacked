package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;

@Instrumented
class ResourceRequestHandler extends RequestHandler {
    private final Context context;

    public ResourceRequestHandler(Context context2) {
        this.context = context2;
    }

    private static Bitmap decodeResource(Resources resources, int i11, Request request) {
        BitmapFactory.Options c11 = RequestHandler.c(request);
        if (RequestHandler.e(c11)) {
            BitmapFactoryInstrumentation.decodeResource(resources, i11, c11);
            RequestHandler.b(request.targetWidth, request.targetHeight, c11, request);
        }
        return BitmapFactoryInstrumentation.decodeResource(resources, i11, c11);
    }

    public boolean canHandleRequest(Request request) {
        if (request.resourceId != 0) {
            return true;
        }
        return "android.resource".equals(request.uri.getScheme());
    }

    public RequestHandler.Result load(Request request, int i11) throws IOException {
        Resources n11 = Utils.n(this.context, request);
        return new RequestHandler.Result(decodeResource(n11, Utils.m(n11, request), request), Picasso.LoadedFrom.DISK);
    }
}
