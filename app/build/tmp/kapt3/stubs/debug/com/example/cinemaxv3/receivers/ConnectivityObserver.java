package com.example.cinemaxv3.receivers;

import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0006\u00c0\u0006\u0001"}, d2 = {"Lcom/example/cinemaxv3/receivers/ConnectivityObserver;", "", "observer", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/cinemaxv3/receivers/ConnectivityObserver$Status;", "Status", "presentation_debug"})
public abstract interface ConnectivityObserver {
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.example.cinemaxv3.receivers.ConnectivityObserver.Status> observer();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/cinemaxv3/receivers/ConnectivityObserver$Status;", "", "(Ljava/lang/String;I)V", "Available", "UnAvailable", "presentation_debug"})
    public static enum Status {
        /*public static final*/ Available /* = new Available() */,
        /*public static final*/ UnAvailable /* = new UnAvailable() */;
        
        Status() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.example.cinemaxv3.receivers.ConnectivityObserver.Status> getEntries() {
            return null;
        }
    }
}