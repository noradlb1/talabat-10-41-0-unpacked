package oa;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;

public final /* synthetic */ class b implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f50691a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LibraryVersionComponent.VersionExtractor f50692b;

    public /* synthetic */ b(String str, LibraryVersionComponent.VersionExtractor versionExtractor) {
        this.f50691a = str;
        this.f50692b = versionExtractor;
    }

    public final Object create(ComponentContainer componentContainer) {
        return LibraryVersion.create(this.f50691a, this.f50692b.extract((Context) componentContainer.get(Context.class)));
    }
}
