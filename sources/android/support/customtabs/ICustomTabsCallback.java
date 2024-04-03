package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface ICustomTabsCallback extends IInterface {
    public static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsCallback";

    public static class Default implements ICustomTabsCallback {
        public IBinder asBinder() {
            return null;
        }

        public void extraCallback(String str, Bundle bundle) throws RemoteException {
        }

        public Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
            return null;
        }

        public void onActivityResized(int i11, int i12, Bundle bundle) throws RemoteException {
        }

        public void onMessageChannelReady(Bundle bundle) throws RemoteException {
        }

        public void onNavigationEvent(int i11, Bundle bundle) throws RemoteException {
        }

        public void onPostMessage(String str, Bundle bundle) throws RemoteException {
        }

        public void onRelationshipValidationResult(int i11, Uri uri, boolean z11, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICustomTabsCallback {

        public static class Proxy implements ICustomTabsCallback {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void extraCallback(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsCallback.DESCRIPTOR);
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsCallback.DESCRIPTOR);
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Bundle) _Parcel.readTypedObject(obtain2, Bundle.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return ICustomTabsCallback.DESCRIPTOR;
            }

            public void onActivityResized(int i11, int i12, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsCallback.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(8, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onMessageChannelReady(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsCallback.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onNavigationEvent(int i11, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsCallback.DESCRIPTOR);
                    obtain.writeInt(i11);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onPostMessage(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsCallback.DESCRIPTOR);
                    obtain.writeString(str);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRelationshipValidationResult(int i11, Uri uri, boolean z11, Bundle bundle) throws RemoteException {
                int i12;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(ICustomTabsCallback.DESCRIPTOR);
                    obtain.writeInt(i11);
                    _Parcel.writeTypedObject(obtain, uri, 0);
                    if (z11) {
                        i12 = 1;
                    } else {
                        i12 = 0;
                    }
                    obtain.writeInt(i12);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    this.mRemote.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, ICustomTabsCallback.DESCRIPTOR);
        }

        public static ICustomTabsCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(ICustomTabsCallback.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ICustomTabsCallback)) {
                return new Proxy(iBinder);
            }
            return (ICustomTabsCallback) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            boolean z11;
            if (i11 >= 1 && i11 <= 16777215) {
                parcel.enforceInterface(ICustomTabsCallback.DESCRIPTOR);
            }
            if (i11 != 1598968902) {
                switch (i11) {
                    case 2:
                        onNavigationEvent(parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                        break;
                    case 3:
                        extraCallback(parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                        break;
                    case 4:
                        onMessageChannelReady((Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        break;
                    case 5:
                        onPostMessage(parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        break;
                    case 6:
                        int readInt = parcel.readInt();
                        Uri uri = (Uri) _Parcel.readTypedObject(parcel, Uri.CREATOR);
                        if (parcel.readInt() != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        onRelationshipValidationResult(readInt, uri, z11, (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                        break;
                    case 7:
                        Bundle extraCallbackWithResult = extraCallbackWithResult(parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        _Parcel.writeTypedObject(parcel2, extraCallbackWithResult, 1);
                        break;
                    case 8:
                        onActivityResized(parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                        break;
                    default:
                        return super.onTransact(i11, parcel, parcel2, i12);
                }
                return true;
            }
            parcel2.writeString(ICustomTabsCallback.DESCRIPTOR);
            return true;
        }
    }

    public static class _Parcel {
        /* access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t11, int i11) {
            if (t11 != null) {
                parcel.writeInt(1);
                t11.writeToParcel(parcel, i11);
                return;
            }
            parcel.writeInt(0);
        }
    }

    void extraCallback(String str, Bundle bundle) throws RemoteException;

    Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException;

    void onActivityResized(int i11, int i12, Bundle bundle) throws RemoteException;

    void onMessageChannelReady(Bundle bundle) throws RemoteException;

    void onNavigationEvent(int i11, Bundle bundle) throws RemoteException;

    void onPostMessage(String str, Bundle bundle) throws RemoteException;

    void onRelationshipValidationResult(int i11, Uri uri, boolean z11, Bundle bundle) throws RemoteException;
}
