package com.teddy.abmnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LoginActivity extends AppCompatActivity {

    //Inisialiasi Variabel
    DrawerLayout drawerLayout;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //buka webnya
        webView = findViewById(R.id.login_webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://abmreborn.com");

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.supportZoom();
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);

        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebChromeClient(new WebChromeClient());

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView wv, String url) {
                if(url.startsWith("tel:") || url.startsWith("whatsapp:") || url.startsWith("tg:") || url.startsWith("facebook:") ) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        //Assign variabel
        drawerLayout = findViewById(R.id.drawer_layout);

    }
    public void ClickMenu(View view){
        //Open drawer
        openDrawer (drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open Drawer Layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
        //Close Drawernya
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close Drawer Layout
        //Check Condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //Jika drawernya masih terbuka
            //maka tutup Drawer-nya
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        //Redirect activity ke Beranda
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickLogin (View view){
        ///Recreate activity
        recreate();
    }

    public void ClickCompany (View view){
        //Redirect activity ke Company Profile
        MainActivity.redirectActivity(this,ProfilActivity.class);
    }

    public void ClickProduk (View view){
        //Redirect activity ke Produk
        MainActivity.redirectActivity(this,ProdukActivity.class);
    }

    public void ClickPlan (View view){
        //Redirect activity ke Marketing Plan
        MainActivity.redirectActivity(this,PlanActivity.class);
    }

    public void ClickTestimoni (View view){
        //Redirect activity ke Testiminoni
        MainActivity.redirectActivity(this,TestimoniActivity.class);
    }

    public void ClickInfoTerkini (View view){
        //Redirect activity ke Info Terkini
        MainActivity.redirectActivity(this,InfoActivity.class);
    }

    public void ClickTips (View view){
        //Redirect activity ke Tips
        MainActivity.redirectActivity(this,TipsActivity.class);
    }

    public void ClickLeaders (View view){
        //Redirect activity ke Leaders
        MainActivity.redirectActivity(this,LeadersActivity.class);
    }

    public void ClickTutorial (View view){
        //Redirect activity ke Tutorial
        MainActivity.redirectActivity(this,TutorialActivity.class);
    }

    public void ClickKontak (View view){
        //Redirect activity ke Kontak
        MainActivity.redirectActivity(this,KontakActivity.class);
    }

    public void ClickTentang (View view){
        //Redirect activity ke Tentang
        MainActivity.redirectActivity(this,TentangActivity.class);
    }

    public void ClickLogout (View view){
        //Menutup Aplikasi
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Close Drawer
        closeDrawer(drawerLayout);
    }

}

