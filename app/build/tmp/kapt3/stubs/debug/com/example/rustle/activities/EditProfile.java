package com.example.rustle.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001eJ\"\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0012\u0010\'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020\u001eH\u0014J\u0006\u0010+\u001a\u00020\u001eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e\u00a8\u0006,"}, d2 = {"Lcom/example/rustle/activities/EditProfile;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "SELECT_PICTURE", "", "getSELECT_PICTURE", "()I", "TAKE_PICTURE", "getTAKE_PICTURE", "currentPath", "", "getCurrentPath", "()Ljava/lang/String;", "setCurrentPath", "(Ljava/lang/String;)V", "imageuri", "Landroid/net/Uri;", "getImageuri", "()Landroid/net/Uri;", "setImageuri", "(Landroid/net/Uri;)V", "user_grade", "getUser_grade", "setUser_grade", "user_major", "getUser_major", "setUser_major", "createImage", "Ljava/io/File;", "dispatchCameraIntent", "", "dispatchGalleryIntent", "", "loaduser", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "saveprofile", "app_debug"})
public final class EditProfile extends android.support.v7.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String currentPath;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri imageuri;
    private final int TAKE_PICTURE = 1;
    private final int SELECT_PICTURE = 2;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String user_grade;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String user_major;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrentPath() {
        return null;
    }
    
    public final void setCurrentPath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getImageuri() {
        return null;
    }
    
    public final void setImageuri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    public final int getTAKE_PICTURE() {
        return 0;
    }
    
    public final int getSELECT_PICTURE() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUser_grade() {
        return null;
    }
    
    public final void setUser_grade(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUser_major() {
        return null;
    }
    
    public final void setUser_major(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    public final void loaduser() {
    }
    
    public final void saveprofile() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final boolean dispatchGalleryIntent() {
        return false;
    }
    
    public final void dispatchCameraIntent() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File createImage() {
        return null;
    }
    
    public EditProfile() {
        super();
    }
}