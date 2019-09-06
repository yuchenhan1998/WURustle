package com.example.rustle.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0007H\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/rustle/fragments/SearchFragment;", "Landroid/support/v4/app/Fragment;", "()V", "adapter", "Lcom/example/rustle/fragments/SearchFragment$BookListAdapter;", "bookList", "Ljava/util/ArrayList;", "Lcom/example/rustle/model/book;", "Lkotlin/collections/ArrayList;", "subject", "", "viewModel", "Lcom/example/rustle/viewmodel/BookViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "toActivity", "b", "BookListAdapter", "Companion", "app_debug"})
public final class SearchFragment extends android.support.v4.app.Fragment {
    private com.example.rustle.fragments.SearchFragment.BookListAdapter adapter;
    private com.example.rustle.viewmodel.BookViewModel viewModel;
    private java.util.ArrayList<com.example.rustle.model.book> bookList;
    private java.lang.String subject;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_NAME = "BOOK_NAME";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_COURSE = "BOOK_COURSE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_IMAGE = "BOOK_IMAGE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_UNTIL = "BOOK_UNTIL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_PRICE = "BOOK_PRICE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_ISBN = "BOOK_ISBN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_SELLER = "BOOK_SELLER";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_EMAIL = "BOOK_EMAIL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_MESSAGE = "BOOK_MESSAGE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOK_SELLERIMG = "BOOK_SELLERIMG";
    public static final com.example.rustle.fragments.SearchFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void toActivity(com.example.rustle.model.book b) {
    }
    
    public SearchFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/example/rustle/fragments/SearchFragment$BookListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/example/rustle/fragments/SearchFragment$BookListAdapter$BookListViewHolder;", "Lcom/example/rustle/fragments/SearchFragment;", "(Lcom/example/rustle/fragments/SearchFragment;)V", "getItemCount", "", "onBindViewHolder", "", "p0", "p1", "onCreateViewHolder", "Landroid/view/ViewGroup;", "BookListViewHolder", "app_debug"})
    public final class BookListAdapter extends android.support.v7.widget.RecyclerView.Adapter<com.example.rustle.fragments.SearchFragment.BookListAdapter.BookListViewHolder> {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.example.rustle.fragments.SearchFragment.BookListAdapter.BookListViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup p0, int p1) {
            return null;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.rustle.fragments.SearchFragment.BookListAdapter.BookListViewHolder p0, int p1) {
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        public BookListAdapter() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/example/rustle/fragments/SearchFragment$BookListAdapter$BookListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "mView", "Landroid/view/View;", "(Lcom/example/rustle/fragments/SearchFragment$BookListAdapter;Landroid/view/View;)V", "bookClass", "Landroid/widget/TextView;", "getBookClass", "()Landroid/widget/TextView;", "bookCover", "Landroid/widget/ImageView;", "getBookCover", "()Landroid/widget/ImageView;", "bookName", "getBookName", "bookPrice", "getBookPrice", "row", "getRow", "()Landroid/view/View;", "app_debug"})
        public final class BookListViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull()
            private final android.widget.ImageView bookCover = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView bookName = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView bookPrice = null;
            @org.jetbrains.annotations.NotNull()
            private final android.widget.TextView bookClass = null;
            @org.jetbrains.annotations.NotNull()
            private final android.view.View row = null;
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.ImageView getBookCover() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getBookName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getBookPrice() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.widget.TextView getBookClass() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final android.view.View getRow() {
                return null;
            }
            
            public BookListViewHolder(@org.jetbrains.annotations.NotNull()
            android.view.View mView) {
                super(null);
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/rustle/fragments/SearchFragment$Companion;", "", "()V", "BOOK_COURSE", "", "BOOK_EMAIL", "BOOK_IMAGE", "BOOK_ISBN", "BOOK_MESSAGE", "BOOK_NAME", "BOOK_PRICE", "BOOK_SELLER", "BOOK_SELLERIMG", "BOOK_UNTIL", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}