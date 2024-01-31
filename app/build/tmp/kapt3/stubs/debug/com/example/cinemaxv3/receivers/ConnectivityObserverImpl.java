package com.example.cinemaxv3.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import androidx.annotation.RequiresApi;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/example/cinemaxv3/receivers/ConnectivityObserverImpl;", "Lcom/example/cinemaxv3/receivers/ConnectivityObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "networkChangeReceiver", "Lcom/example/cinemaxv3/receivers/NetworkChangeReceiver;", "getNetworkChangeReceiver", "()Lcom/example/cinemaxv3/receivers/NetworkChangeReceiver;", "observer", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/cinemaxv3/receivers/ConnectivityObserver$Status;", "presentation_debug"})
public final class ConnectivityObserverImpl implements com.example.cinemaxv3.receivers.ConnectivityObserver {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final android.net.ConnectivityManager connectivityManager = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.cinemaxv3.receivers.NetworkChangeReceiver networkChangeReceiver = null;
    
    public ConnectivityObserverImpl(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.cinemaxv3.receivers.NetworkChangeReceiver getNetworkChangeReceiver() {
        return null;
    }
    
    @java.lang.Override
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.example.cinemaxv3.receivers.ConnectivityObserver.Status> observer() {
        return null;
    }
}