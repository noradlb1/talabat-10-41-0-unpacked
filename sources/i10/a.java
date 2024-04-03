package i10;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import library.talabat.mvp.home.domain.impl.ShouldShowLocationSelectionInHomeUseCaseImpl;

public final /* synthetic */ class a implements SingleOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ShouldShowLocationSelectionInHomeUseCaseImpl f24342a;

    public /* synthetic */ a(ShouldShowLocationSelectionInHomeUseCaseImpl shouldShowLocationSelectionInHomeUseCaseImpl) {
        this.f24342a = shouldShowLocationSelectionInHomeUseCaseImpl;
    }

    public final void subscribe(SingleEmitter singleEmitter) {
        ShouldShowLocationSelectionInHomeUseCaseImpl.m7884shouldShowLocationSelection$lambda0(this.f24342a, singleEmitter);
    }
}
