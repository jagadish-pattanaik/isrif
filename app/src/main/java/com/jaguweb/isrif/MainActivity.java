package com.jaguweb.isrif;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import java.util.HashMap;
import java.util.ArrayList;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.View;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private DrawerLayout _drawer;
	private String a = "";
	private String b = "";
	private double points = 0;
	private String latest_version = "";
	private String your_version = "";
	private String package_name = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String Title = "";
	private String Message = "";
	private String web_latest = "";
	private String web_your = "";
	private HashMap<String, Object> map1 = new HashMap<>();
	private String app_path = "";
	private double web_up = 0;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> web_listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private WebView webview2;
	private LinearLayout linear2;
	private ImageView imageview1;
	private LinearLayout linear9;
	private LinearLayout linear4;
	private TextView textview1;
	private ImageView imageview2;
	private ProgressBar progressbar1;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private TextView textview2;
	private TextView textview3;
	private ImageView imageview3;
	private ImageView imageview4;
	private ImageView imageview5;
	private ImageView imageview6;
	private ImageView imageview7;
	private ScrollView _drawer_vscroll1;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear11;
	private LinearLayout _drawer_d2;
	private LinearLayout _drawer_d10;
	private LinearLayout _drawer_d4;
	private LinearLayout _drawer_d3;
	private LinearLayout _drawer_d5;
	private LinearLayout _drawer_d6;
	private LinearLayout _drawer_d7;
	private LinearLayout _drawer_d8;
	private LinearLayout _drawer_d11;
	private LinearLayout _drawer_d13;
	private LinearLayout _drawer_d12;
	private LinearLayout _drawer_d9;
	private LinearLayout _drawer_linear10;
	private ImageView _drawer_imageview10;
	private TextView _drawer_textview10;
	private ImageView _drawer_imageview1;
	private TextView _drawer_textview1;
	private ImageView _drawer_imageview13;
	private TextView _drawer_textview14;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview3;
	private ImageView _drawer_imageview3;
	private TextView _drawer_textview2;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview4;
	private ImageView _drawer_imageview5;
	private TextView _drawer_textview5;
	private ImageView _drawer_imageview6;
	private TextView _drawer_textview6;
	private ImageView _drawer_imageview7;
	private TextView _drawer_textview7;
	private ImageView _drawer_imageview11;
	private TextView _drawer_textview12;
	private ImageView _drawer_imageview14;
	private TextView _drawer_textview15;
	private ImageView _drawer_imageview12;
	private TextView _drawer_textview13;
	private ImageView _drawer_imageview9;
	private TextView _drawer_textview11;
	private TextView _drawer_textview9;
	
	private AlertDialog.Builder d;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private AlertDialog.Builder dialogue1;
	private TimerTask time;
	private SharedPreferences sp;
	private Intent i = new Intent();
	private Intent intent = new Intent();
	private TimerTask timer;
	private SharedPreferences tap;
	private DatabaseReference ver = _firebase.getReference("Version");
	private ChildEventListener _ver_child_listener;
	private DatabaseReference notify = _firebase.getReference("Notification");
	private ChildEventListener _notify_child_listener;
	private DatabaseReference web_ver = _firebase.getReference("Website Version");
	private ChildEventListener _web_ver_child_listener;
	private InterstitialAd Ads;
	private AdListener _Ads_ad_listener;
	private ObjectAnimator anime = new ObjectAnimator();
	private Intent in = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = (DrawerLayout) findViewById(R.id._drawer);ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		webview2 = (WebView) findViewById(R.id.webview2);
		webview2.getSettings().setJavaScriptEnabled(true);
		webview2.getSettings().setSupportZoom(true);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		_drawer_vscroll1 = (ScrollView) _nav_view.findViewById(R.id.vscroll1);
		_drawer_linear1 = (LinearLayout) _nav_view.findViewById(R.id.linear1);
		_drawer_linear11 = (LinearLayout) _nav_view.findViewById(R.id.linear11);
		_drawer_d2 = (LinearLayout) _nav_view.findViewById(R.id.d2);
		_drawer_d10 = (LinearLayout) _nav_view.findViewById(R.id.d10);
		_drawer_d4 = (LinearLayout) _nav_view.findViewById(R.id.d4);
		_drawer_d3 = (LinearLayout) _nav_view.findViewById(R.id.d3);
		_drawer_d5 = (LinearLayout) _nav_view.findViewById(R.id.d5);
		_drawer_d6 = (LinearLayout) _nav_view.findViewById(R.id.d6);
		_drawer_d7 = (LinearLayout) _nav_view.findViewById(R.id.d7);
		_drawer_d8 = (LinearLayout) _nav_view.findViewById(R.id.d8);
		_drawer_d11 = (LinearLayout) _nav_view.findViewById(R.id.d11);
		_drawer_d13 = (LinearLayout) _nav_view.findViewById(R.id.d13);
		_drawer_d12 = (LinearLayout) _nav_view.findViewById(R.id.d12);
		_drawer_d9 = (LinearLayout) _nav_view.findViewById(R.id.d9);
		_drawer_linear10 = (LinearLayout) _nav_view.findViewById(R.id.linear10);
		_drawer_imageview10 = (ImageView) _nav_view.findViewById(R.id.imageview10);
		_drawer_textview10 = (TextView) _nav_view.findViewById(R.id.textview10);
		_drawer_imageview1 = (ImageView) _nav_view.findViewById(R.id.imageview1);
		_drawer_textview1 = (TextView) _nav_view.findViewById(R.id.textview1);
		_drawer_imageview13 = (ImageView) _nav_view.findViewById(R.id.imageview13);
		_drawer_textview14 = (TextView) _nav_view.findViewById(R.id.textview14);
		_drawer_imageview2 = (ImageView) _nav_view.findViewById(R.id.imageview2);
		_drawer_textview3 = (TextView) _nav_view.findViewById(R.id.textview3);
		_drawer_imageview3 = (ImageView) _nav_view.findViewById(R.id.imageview3);
		_drawer_textview2 = (TextView) _nav_view.findViewById(R.id.textview2);
		_drawer_imageview4 = (ImageView) _nav_view.findViewById(R.id.imageview4);
		_drawer_textview4 = (TextView) _nav_view.findViewById(R.id.textview4);
		_drawer_imageview5 = (ImageView) _nav_view.findViewById(R.id.imageview5);
		_drawer_textview5 = (TextView) _nav_view.findViewById(R.id.textview5);
		_drawer_imageview6 = (ImageView) _nav_view.findViewById(R.id.imageview6);
		_drawer_textview6 = (TextView) _nav_view.findViewById(R.id.textview6);
		_drawer_imageview7 = (ImageView) _nav_view.findViewById(R.id.imageview7);
		_drawer_textview7 = (TextView) _nav_view.findViewById(R.id.textview7);
		_drawer_imageview11 = (ImageView) _nav_view.findViewById(R.id.imageview11);
		_drawer_textview12 = (TextView) _nav_view.findViewById(R.id.textview12);
		_drawer_imageview14 = (ImageView) _nav_view.findViewById(R.id.imageview14);
		_drawer_textview15 = (TextView) _nav_view.findViewById(R.id.textview15);
		_drawer_imageview12 = (ImageView) _nav_view.findViewById(R.id.imageview12);
		_drawer_textview13 = (TextView) _nav_view.findViewById(R.id.textview13);
		_drawer_imageview9 = (ImageView) _nav_view.findViewById(R.id.imageview9);
		_drawer_textview11 = (TextView) _nav_view.findViewById(R.id.textview11);
		_drawer_textview9 = (TextView) _nav_view.findViewById(R.id.textview9);
		d = new AlertDialog.Builder(this);
		net = new RequestNetwork(this);
		dialogue1 = new AlertDialog.Builder(this);
		sp = getSharedPreferences("data", Activity.MODE_PRIVATE);
		tap = getSharedPreferences("tap", Activity.MODE_PRIVATE);
		
		webview2.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				net.startRequestNetwork(RequestNetworkController.GET, "https://google.com/", "A", _net_request_listener);
				linear5.setVisibility(View.VISIBLE);
				sp.edit().putString("testweb", "2").commit();
				if (_url.equals("https://jaguweb.wixsite.com/scienceonlineforum") || webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum")) {
					linear5.setVisibility(View.VISIBLE);
					webview2.goBack();
					webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/isrifforum");
				}
				else {
					
				}
				if (_url.equals("https://jaguweb.wixsite.com/scienceonlineforum/") || webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum/")) {
					linear5.setVisibility(View.VISIBLE);
					webview2.goBack();
					webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/isrifforum");
				}
				else {
					
				}
				if (_url.equals("https://apps.wix.com/place-invites/join-lp/16eb45e1-67e3-4575-90fc-76b9f94ca8c2?ref=free_banner") || webview2.getUrl().equals("https://apps.wix.com/place-invites/join-lp/16eb45e1-67e3-4575-90fc-76b9f94ca8c2?ref=free_banner")) {
					linear5.setVisibility(View.VISIBLE);
					webview2.goBack();
				}
				else {
					
				}
				if (sp.getString("testweb", "").equals("1")) {
					if (webview2.getUrl().contains("forum-post") || _url.contains("forum-post")) {
						if (!sp.getString("fpo", "").equals("1")) {
							d.setTitle("Forum Posts");
							d.setMessage("Here you can view forum posts.");
							d.setNeutralButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							d.setNegativeButton("Dont show again", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sp.edit().putString("fpo", "1").commit();
								}
							});
							d.create().show();
							SketchwareUtil.showMessage(getApplicationContext(), "Forum Posts");
							textview1.setText("Forum Posts");
						}
						else {
							
						}
					}
					if (_url.contains("forum-comments") || webview2.getUrl().contains("forum-comments")) {
						if (!sp.getString("fco", "").equals("1")) {
							d.setTitle("Forum Comments");
							d.setMessage("Here you can view forum comments.");
							d.setNeutralButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							d.setNegativeButton("Dont show again", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sp.edit().putString("fco", "1").commit();
								}
							});
							d.create().show();
							SketchwareUtil.showMessage(getApplicationContext(), "Forum Comments");
							textview1.setText("Forum Comments");
						}
						else {
							
						}
					}
					if (_url.contains("blog-post") || webview2.getUrl().contains("blog-post")) {
						if (!sp.getString("bpo", "").equals("1")) {
							d.setTitle("Feed Posts");
							d.setMessage("Here you can view feed posts.");
							d.setNeutralButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							d.setNegativeButton("Dont show again", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sp.edit().putString("bpo", "1").commit();
								}
							});
							d.create().show();
							SketchwareUtil.showMessage(getApplicationContext(), "Feed Posts");
							textview1.setText("Feed Posts");
						}
						else {
							
						}
					}
					if (_url.contains("blog-comments") || webview2.getUrl().contains("blog-comments")) {
						if (!sp.getString("bco", "").equals("1")) {
							d.setTitle("Feed Comments");
							d.setMessage("Here you can view feed comments.");
							d.setNeutralButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							d.setNegativeButton("Dont show again", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sp.edit().putString("bco", "1").commit();
								}
							});
							d.create().show();
							SketchwareUtil.showMessage(getApplicationContext(), "Feed Comments");
							textview1.setText("Feed Comments");
						}
						else {
							
						}
					}
					if (_url.equals("blog-likes")) {
						if (!sp.getString("bli", "").equals("1")) {
							d.setTitle("Feed Likes");
							d.setMessage("Here you can view feed likes.");
							d.setNeutralButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							d.setNegativeButton("Dont show again", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sp.edit().putString("bli", "1").commit();
								}
							});
							d.create().show();
							SketchwareUtil.showMessage(getApplicationContext(), "Feed Likes");
							textview1.setText("Feed Likes");
						}
						else {
							
						}
					}
					if (_url.contains("profile") && (!_url.contains("blog-likes") && (!_url.contains("blog-comments") && (!_url.contains("blog-likes") && (!_url.contains("forum-posts") && !_url.contains("forum-comments")))))) {
						if (!sp.getString("pro", "").equals("1")) {
							d.setTitle("Profile");
							d.setMessage("Here you can view profile.");
							d.setNeutralButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							d.setNegativeButton("Dont show again", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sp.edit().putString("pro", "1").commit();
								}
							});
							d.create().show();
							SketchwareUtil.showMessage(getApplicationContext(), "Profile");
							textview1.setText("Profile");
						}
						else {
							
						}
					}
					if (_url.contains("my-drafts")) {
						if (!sp.getString("mdr", "").equals("1")) {
							d.setTitle("My Drafts");
							d.setMessage("Here you can view your drafts.");
							d.setNeutralButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							d.setNegativeButton("Dont show again", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sp.edit().putString("mdr", "1").commit();
								}
							});
							d.create().show();
							SketchwareUtil.showMessage(getApplicationContext(), "My Drafts");
							textview1.setText("My Drafts");
						}
						else {
							
						}
					}
					if (_url.contains("my-accounts")) {
						if (!sp.getString("mac", "").equals("1")) {
							d.setTitle("My Account");
							d.setMessage("Here you can view your account.");
							d.setNeutralButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							d.setNegativeButton("Dont show again", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sp.edit().putString("mac", "1").commit();
								}
							});
							d.create().show();
							SketchwareUtil.showMessage(getApplicationContext(), "My Account");
							textview1.setText("My Account");
						}
						else {
							
						}
					}
					if (_url.contains("notifications")) {
						if (!sp.getString("not", "").equals("1")) {
							d.setTitle("Notification");
							d.setMessage("Here you can view notifications.");
							d.setNeutralButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							d.setNegativeButton("Dont show again", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sp.edit().putString("not", "1").commit();
								}
							});
							d.create().show();
							SketchwareUtil.showMessage(getApplicationContext(), "Notification");
							textview1.setText("Notification");
						}
						else {
							
						}
					}
					if (_url.equals("settings")) {
						if (!sp.getString("set", "").equals("1")) {
							d.setTitle("Settings");
							d.setMessage("Here you can view settings.");
							d.setNeutralButton("OK", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							d.setNegativeButton("Dont show again", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sp.edit().putString("set", "1").commit();
								}
							});
							d.create().show();
							SketchwareUtil.showMessage(getApplicationContext(), "Settings");
							textview1.setText("Settings");
						}
						else {
							
						}
					}
				}
				else {
					
				}
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				net.startRequestNetwork(RequestNetworkController.GET, "https://google.com/", "A", _net_request_listener);
				linear5.setVisibility(View.GONE);
				if (_url.equals("https://jaguweb.wixsite.com/scienceonlineforum") || webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum")) {
					linear5.setVisibility(View.VISIBLE);
					webview2.goBack();
					webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/isrifforum");
				}
				else {
					
				}
				if (_url.equals("https://jaguweb.wixsite.com/scienceonlineforum/") || webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum/")) {
					linear5.setVisibility(View.VISIBLE);
					webview2.goBack();
					webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/isrifforum");
				}
				else {
					
				}
				if (_url.equals("https://apps.wix.com/place-invites/join-lp/16eb45e1-67e3-4575-90fc-76b9f94ca8c2?ref=free_banner") || webview2.getUrl().equals("https://apps.wix.com/place-invites/join-lp/16eb45e1-67e3-4575-90fc-76b9f94ca8c2?ref=free_banner")) {
					linear5.setVisibility(View.VISIBLE);
					webview2.goBack();
				}
				else {
					
				}
				super.onPageFinished(_param1, _param2);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (_drawer.isDrawerOpen(GravityCompat.START)) {
					
				}
				else {
					_drawer.openDrawer(GravityCompat.START);
				}
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview1.setText("Message");
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
				webview2.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
				webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/scientists");
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
				SketchwareUtil.showMessage(getApplicationContext(), "Message");
				if (sp.getString("d1", "").equals("1")) {
					
				}
				else {
					dialogue1.setTitle("Message ");
					dialogue1.setMessage("Here you can chat with your friends, to chat first follow them");
					dialogue1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialogue1.setNegativeButton("Don't Show Again", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							sp.edit().putString("d1", "1").commit();
						}
					});
					dialogue1.create().show();
				}
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				setTitle("FORUM");
				webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/isrifforum");
				linear7.setBackgroundColor(0xFFBDBDBD);
				linear8.setBackgroundColor(0xFFFFFFFF);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
				SketchwareUtil.showMessage(getApplicationContext(), "Forum");
				if (sp.getString("d5", "").equals("1")) {
					
				}
				else {
					dialogue1.setTitle("FORUM");
					dialogue1.setMessage("Ask your questions and have discussion with different people");
					dialogue1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialogue1.setNegativeButton("Don't Show Again", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							sp.edit().putString("d5", "1").commit();
						}
					});
					dialogue1.create().show();
				}
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				setTitle("FEED");
				webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/blog");
				linear7.setBackgroundColor(0xFFFFFFFF);
				linear8.setBackgroundColor(0xFFBDBDBD);
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
				SketchwareUtil.showMessage(getApplicationContext(), "Feed");
				if (sp.getString("d6", "").equals("1")) {
					
				}
				else {
					dialogue1.setTitle("FEED ");
					dialogue1.setMessage("Post photos and videos and share thrn with your friends");
					dialogue1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialogue1.setNegativeButton("Don't Show Again", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							sp.edit().putString("d6", "1").commit();
						}
					});
					dialogue1.create().show();
				}
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview1.setText("ISRIF");
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
				webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/isrifforum");
				webview2.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
				imageview1.setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
				imageview2.setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
				imageview3.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
				imageview4.setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
				imageview5.setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
				imageview6.setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
				linear7.setVisibility(View.VISIBLE);
				linear8.setVisibility(View.VISIBLE);
				if (webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum/isrifforum")) {
					linear7.setBackgroundColor(0xFFBDBDBD);
					SketchwareUtil.showMessage(getApplicationContext(), "Forum");
				}
				else {
					linear7.setBackgroundColor(0xFFFFFFFF);
				}
				if (webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum/blog")) {
					linear8.setBackgroundColor(0xFFBDBDBD);
					SketchwareUtil.showMessage(getApplicationContext(), "Feed");
				}
				else {
					linear8.setBackgroundColor(0xFFFFFFFF);
				}
				if (sp.getString("d7", "").equals("1")) {
					
				}
				else {
					dialogue1.setTitle("Home Page");
					dialogue1.setMessage("The Home Page contains Forum and Feed");
					dialogue1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialogue1.setNegativeButton("Don't Show Again", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							sp.edit().putString("d7", "1").commit();
						}
					});
					dialogue1.create().show();
				}
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview1.setText("People");
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
				webview2.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
				webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/scientists");
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
				SketchwareUtil.showMessage(getApplicationContext(), "Explore People");
				if (sp.getString("d2", "").equals("1")) {
					
				}
				else {
					dialogue1.setTitle("Explore People");
					dialogue1.setMessage("Explore new people and make friends. To begin follow them and to see profile click on their name");
					dialogue1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialogue1.setNegativeButton("Don't Show Again", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							sp.edit().putString("d2", "1").commit();
						}
					});
					dialogue1.create().show();
				}
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview1.setText("ISRIF Videos");
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
				webview2.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
				webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/isrif-videos");
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
				SketchwareUtil.showMessage(getApplicationContext(), "ISRIF Videos");
				if (sp.getString("d3", "").equals("1")) {
					
				}
				else {
					dialogue1.setTitle("ISRIF Videos");
					dialogue1.setMessage("Premium Quality Research and interesting videos for knowledge");
					dialogue1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialogue1.setNegativeButton("Don't Show Again", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							sp.edit().putString("d3", "1").commit();
						}
					});
					dialogue1.create().show();
				}
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview1.setText("Research Material");
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
				webview2.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
				webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/research-material");
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
				SketchwareUtil.showMessage(getApplicationContext(), "ISRIF Research Material");
				if (sp.getString("d4", "").equals("1")) {
					
				}
				else {
					dialogue1.setTitle("Research Material");
					dialogue1.setMessage("Premium Quality Research Material covering all topic both basic and advance for knowledge");
					dialogue1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialogue1.setNegativeButton("Don't Show Again", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							sp.edit().putString("d4", "1").commit();
						}
					});
					dialogue1.create().show();
				}
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview1.setText("Notifications");
				Ads = new InterstitialAd(getApplicationContext());
				Ads.setAdListener(_Ads_ad_listener);
				Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
				Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
				.build());
				webview2.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
				webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/isrifforum/official-info");
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
				SketchwareUtil.showMessage(getApplicationContext(), "Notifications");
				if (sp.getString("nt1", "").equals("1")) {
					
				}
				else {
					dialogue1.setTitle("Notifications");
					dialogue1.setMessage("Check regularly to stay updated.");
					dialogue1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialogue1.setNegativeButton("Don't Show Again", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							sp.edit().putString("nt1", "1").commit();
						}
					});
					dialogue1.create().show();
				}
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				progressbar1.setVisibility(View.GONE);
				d.setTitle("No Internet Connection");
				d.setMessage("Please check your internet connection and try again");
				d.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						finish();
					}
				});
				d.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						net.startRequestNetwork(RequestNetworkController.GET, "https://google.com/", "A", _net_request_listener);
						progressbar1.setVisibility(View.VISIBLE);
					}
				});
				d.create().show();
			}
		};
		
		_ver_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				ver.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						latest_version = listmap.get((int)0).get("v").toString();
						if (Double.parseDouble(latest_version) > Double.parseDouble(your_version)) {
							time = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											SketchwareUtil.showMessage(getApplicationContext(), "Update Required !");
											dialogue1.setTitle("Update Application");
											dialogue1.setMessage("Latest version ".concat("v ".concat(latest_version.concat(" of this app is now available. Please update your app."))));
											dialogue1.setPositiveButton("Update", new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface _dialog, int _which) {
													webview2.clearCache(true);
													webview2.clearHistory();
													in.setAction(Intent.ACTION_VIEW);
													in.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.isrif"));
													startActivity(in);
												}
											});
											dialogue1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface _dialog, int _which) {
													SketchwareUtil.showMessage(getApplicationContext(), "Please update soon");
												}
											});
											dialogue1.create().show();
										}
									});
								}
							};
							_timer.schedule(time, (int)(8000));
						}
						else {
							time = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											SketchwareUtil.showMessage(getApplicationContext(), "You are using latest version of the app");
										}
									});
								}
							};
							_timer.schedule(time, (int)(8000));
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		ver.addChildEventListener(_ver_child_listener);
		
		_notify_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				sp.edit().putString("notify", _childValue.get("Message").toString()).commit();
				if (!sp.getString("notify", "").equals(Message)) {
					Title = _childValue.get("Title").toString();
					Message = _childValue.get("Message").toString();
					Intent intent = new Intent(MainActivity.this, MainActivity.class);
					
					
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
					
					
					PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
					
					androidx.core.app.NotificationCompat.Builder builder = new androidx.core.app.NotificationCompat.Builder(MainActivity.this, "id 1")
					
					
					.setSmallIcon(R.drawable.ic_whatshot_black)
					
					.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
					
					.setContentTitle(Title.toString())
					
					.setContentText(Message.toString())
					
					.setOngoing(false)
					
					.setPriority(androidx.core.app.NotificationCompat.PRIORITY_DEFAULT)
					
					.setAutoCancel(true);
					
					androidx.core.app.NotificationManagerCompat notificationManager = androidx.core.app.NotificationManagerCompat.from(MainActivity.this);
					
					
					notificationManager.notify(1, builder.build());
					
					
				}
				else {
					
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		notify.addChildEventListener(_notify_child_listener);
		
		_web_ver_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				web_ver.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						web_listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								web_listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						web_latest = web_listmap.get((int)0).get("v").toString();
						if (Double.parseDouble(web_latest) > Double.parseDouble(web_your)) {
							time = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											SketchwareUtil.showMessage(getApplicationContext(), "Update Required !");
											dialogue1.setTitle("Update Application");
											dialogue1.setMessage("Latest version ".concat("v ".concat(web_latest.concat(" of this app is now available. Please update your app."))));
											dialogue1.setPositiveButton("Update", new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface _dialog, int _which) {
													webview2.clearCache(true);
													webview2.clearHistory();
													d.setTitle("Updated !");
													d.setMessage("Congratulations Your App Is Updated");
													d.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
														@Override
														public void onClick(DialogInterface _dialog, int _which) {
															
														}
													});
													d.create().show();
												}
											});
											dialogue1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface _dialog, int _which) {
													SketchwareUtil.showMessage(getApplicationContext(), "Please update soon");
												}
											});
											dialogue1.create().show();
										}
									});
								}
							};
							_timer.schedule(time, (int)(8000));
						}
						else {
							time = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											SketchwareUtil.showMessage(getApplicationContext(), "You are using latest version of the app");
										}
									});
								}
							};
							_timer.schedule(time, (int)(8000));
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		web_ver.addChildEventListener(_web_ver_child_listener);
		
		_drawer_d2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_d10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), DocumentationActivity.class);
				startActivity(intent);
			}
		});
		
		_drawer_d4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), FaqActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_d3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutJaguwebActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_d5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				a = "ISRIF - Best Social media platform for science lovers";
				b = "ISRIF\nIndian Scientific Research And Innovation Forum\nDownload from play store - https://play.google.com/work/apps/details?id=com.jaguweb.isrif\nForum, Feed, Chat, Follow friends and teachers, Research Videos, Research Material and many more..\nHurry Up Download now !!!";
				Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
				
			}
		});
		
		_drawer_d6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.isrif"));
				startActivity(intent);
			}
		});
		
		_drawer_d7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("mailto:jaguweb1234@gmail.com"));
				intent.putExtra("subject", "Report problem about ISRIF Android App");
				startActivity(intent);
			}
		});
		
		_drawer_d8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("mailto:jaguweb1234@gmail.com"));
				intent.putExtra("subject", "Feedback about ISRIF Android App");
				startActivity(intent);
			}
		});
		
		_drawer_d11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), PrivacyPolicyActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_d13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), TermsConditionsActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_d12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://www.youtube.com/channel/UCgdd03ctC4odnUCNlPBSdUg"));
				startActivity(intent);
			}
		});
		
		_drawer_d9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MoreByJaguwebActivity.class);
				startActivity(i);
			}
		});
		
		_Ads_ad_listener = new AdListener() {
			@Override
			public void onAdLoaded() {
				Ads.show();
				Ads.loadAd(new
				AdRequest.Builder().build());
			}
			
			@Override
			public void onAdFailedToLoad(int _param1) {
				final int _errorCode = _param1;
				
			}
			
			@Override
			public void onAdOpened() {
				
			}
			
			@Override
			public void onAdClosed() {
				
			}
		};
	}
	private void initializeLogic() {
		i.setClass(getApplicationContext(), SplashActivity.class);
		startActivity(i);
		try{
			getSupportActionBar().hide();
			 } catch (Exception e){}
		net.startRequestNetwork(RequestNetworkController.GET, "https://google.com/", "A", _net_request_listener);
		linear5.setVisibility(View.GONE);
		textview1.setText("ISRIF");
		webview2.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webview2.loadUrl("https://jaguweb.wixsite.com/scienceonlineforum/isrifforum");
		_createChannel();
		_ripple(imageview1, "#bdbdbd");
		_ripple(imageview2, "#bdbdbd");
		_ripple(imageview3, "#bdbdbd");
		_ripple(imageview4, "#bdbdbd");
		_ripple(imageview5, "#bdbdbd");
		_ripple(imageview6, "#bdbdbd");
		_ripple(imageview7, "#bdbdbd");
		_ripple(linear7, "#bdbdbd");
		_ripple(linear8, "#bdbdbd");
		webview2.setElevation(10f);
		progressbar1.setElevation(10f);
		linear3.setElevation(10f);
		linear2.setElevation(10f);
		linear7.setElevation(10f);
		linear8.setElevation(10f);
		imageview1.setElevation(10f);
		imageview2.setElevation(10f);
		imageview3.setElevation(10f);
		imageview4.setElevation(10f);
		imageview5.setElevation(10f);
		imageview6.setElevation(10f);
		package_name = "com.jaguweb.isrif";
		try {
			android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo( package_name, android.content.pm.PackageManager.GET_ACTIVITIES);
			your_version = pinfo.versionName; }
		catch (Exception e){ showMessage(e.toString()); }
		DatabaseReference rootRef = _firebase.getReference(); rootRef.child("version").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if (snapshot.exists()) { } else {
					map = new HashMap<>();
					map.put("v", your_version);
					ver.child("app").updateChildren(map);
					map.clear();
				} }
			@Override
			public void onCancelled(DatabaseError _error) { } });
		try {
			android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo( package_name, android.content.pm.PackageManager.GET_ACTIVITIES);
			web_your = pinfo.versionName; }
		catch (Exception e){ showMessage(e.toString()); }
		DatabaseReference rootRef1 = _firebase.getReference(); rootRef.child("version").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if (snapshot.exists()) { } else {
					map1 = new HashMap<>();
					map1.put("v", web_your);
					web_ver.child("web").updateChildren(map1);
					map1.clear();
				} }
			@Override
			public void onCancelled(DatabaseError _error) { } });
		time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						dialogue1.setTitle("Share App\n");
						dialogue1.setMessage("Share App and Invite your friends");
						dialogue1.setPositiveButton("Share with friends", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								a = "ISRIF - Best Social media platform for science lovers";
								b = "ISRIF\nIndian Scientific Research And Innovation Forum\nDownload from play store - https://play.google.com/work/apps/details?id=com.jaguweb.isrif\nForum, Feed, Chat, Follow friends and teachers, Research Videos, Research Material and many more..\nHurry Up Download now !!!";
								Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
								
							}
						});
						dialogue1.setNegativeButton("Later", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
								time = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												dialogue1.setTitle("Share App\n");
												dialogue1.setMessage("Share App with your colleague and help them in online teaching.");
												dialogue1.setPositiveButton("Share with friends", new DialogInterface.OnClickListener() {
													@Override
													public void onClick(DialogInterface _dialog, int _which) {
														a = "ISRIF - Best Social media platform for science lovers";
														b = "ISRIF\nIndian Scientific Research And Innovation Forum\nDownload from play store - https://play.google.com/work/apps/details?id=com.jaguweb.isrif\nForum, Feed, Chat, Follow friends and teachers, Research Videos, Research Material and many more..\nHurry Up Download now !!!";
														Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
														
													}
												});
												dialogue1.setNegativeButton("Later", new DialogInterface.OnClickListener() {
													@Override
													public void onClick(DialogInterface _dialog, int _which) {
														SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
													}
												});
												dialogue1.create().show();
											}
										});
									}
								};
								_timer.schedule(time, (int)(1200000));
							}
						});
						dialogue1.create().show();
					}
				});
			}
		};
		_timer.schedule(time, (int)(600000));
		if (webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum/isrifforum")) {
			linear7.setBackgroundColor(0xFFBDBDBD);
			linear7.setVisibility(View.VISIBLE);
			linear8.setVisibility(View.VISIBLE);
		}
		else {
			if (webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum/blog")) {
				linear8.setBackgroundColor(0xFFBDBDBD);
				linear7.setVisibility(View.VISIBLE);
				linear8.setVisibility(View.VISIBLE);
			}
			else {
				linear8.setBackgroundColor(0xFFBDBDBD);
				linear7.setVisibility(View.VISIBLE);
				linear8.setVisibility(View.VISIBLE);
			}
			if (webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum/scientists")) {
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
			}
			else {
				
			}
			if (webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum/isrif-videos")) {
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
			}
			else {
				
			}
			if (webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum/research-material")) {
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
			}
			else {
				
			}
			if (webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum/scientists")) {
				linear7.setVisibility(View.GONE);
				linear8.setVisibility(View.GONE);
			}
			else {
				
			}
			linear7.setBackgroundColor(0xFFFFFFFF);
		}
		if (!sp.getString("done", "").equals("1")) {
			time = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							dialogue1.setTitle("Enjoying ?");
							dialogue1.setMessage("Enjoying ISRIF ?");
							dialogue1.setPositiveButton("Enjoying !", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									dialogue1.setTitle("Rate Us and Share");
									dialogue1.setMessage("Would you mind rating us ?");
									dialogue1.setPositiveButton("Rate Us", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											intent.setAction(Intent.ACTION_VIEW);
											intent.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.isrif&hl=en"));
											startActivity(intent);
											sp.edit().putString("done", "1").commit();
										}
									});
									dialogue1.setNegativeButton("Share with Friends", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											a = "ISRIF - Best Social media platform for science lovers";
											b = "ISRIF\nIndian Scientific Research And Innovation Forum\nDownload from play store - https://play.google.com/work/apps/details?id=com.jaguweb.isrif\nForum, Feed, Chat, Follow friends and teachers, Research Videos, Research Material and many more..\nHurry Up Download now !!!";
											Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
											
										}
									});
									dialogue1.setNeutralButton("Later", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
											time = new TimerTask() {
												@Override
												public void run() {
													runOnUiThread(new Runnable() {
														@Override
														public void run() {
															dialogue1.setTitle("Rate Us and Share");
															dialogue1.setMessage("Would you mind rating us ?");
															dialogue1.setPositiveButton("Rate Us", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	intent.setAction(Intent.ACTION_VIEW);
																	intent.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.isrif&hl=en"));
																	startActivity(intent);
																	sp.edit().putString("done", "1").commit();
																}
															});
															dialogue1.setNegativeButton("Share with Friends", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	a = "ISRIF - Best Social media platform for science lovers";
																	b = "ISRIF\nIndian Scientific Research And Innovation Forum\nDownload from play store - https://play.google.com/work/apps/details?id=com.jaguweb.isrif\nForum, Feed, Chat, Follow friends and teachers, Research Videos, Research Material and many more..\nHurry Up Download now !!!";
																	Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
																	
																}
															});
															dialogue1.setNeutralButton("Later", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
																}
															});
															dialogue1.create().show();
														}
													});
												}
											};
											_timer.schedule(time, (int)(600000));
										}
									});
									dialogue1.create().show();
								}
							});
							dialogue1.setNegativeButton("Not really", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									dialogue1.setTitle("Report");
									dialogue1.setMessage("Not enjoying ? Report us about the problem");
									dialogue1.setPositiveButton("Report", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											sp.edit().putString("done", "1").commit();
											intent.setAction(Intent.ACTION_VIEW);
											intent.setData(Uri.parse("mailto:jaguweb1234@gmail.com"));
											intent.putExtra("subject", "Report problem about ISRIF Android App");
											startActivity(intent);
										}
									});
									dialogue1.setNegativeButton("Feedback", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											sp.edit().putString("done", "1").commit();
											intent.setAction(Intent.ACTION_VIEW);
											intent.setData(Uri.parse("mailto:jaguweb1234@gmail.com"));
											intent.putExtra("subject", "Feedback about ISRIF Android App");
											startActivity(intent);
										}
									});
									dialogue1.setNeutralButton("Later", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
										}
									});
									dialogue1.create().show();
								}
							});
							dialogue1.create().show();
						}
					});
				}
			};
			_timer.schedule(time, (int)(100000));
		}
		else {
			time = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							dialogue1.setTitle("Enjoying ?");
							dialogue1.setMessage("Enjoying ISRIF ?");
							dialogue1.setPositiveButton("Enjoying !", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									dialogue1.setTitle("Rate Us and Share");
									dialogue1.setMessage("Would you mind rating us ?");
									dialogue1.setPositiveButton("Rate Us", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											intent.setAction(Intent.ACTION_VIEW);
											intent.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.isrif&hl=en"));
											startActivity(intent);
											sp.edit().putString("done", "1").commit();
										}
									});
									dialogue1.setNegativeButton("Share with Friends", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											a = "ISRIF - Best Social media platform for science lovers";
											b = "ISRIF\nIndian Scientific Research And Innovation Forum\nDownload from play store - https://play.google.com/work/apps/details?id=com.jaguweb.isrif\nForum, Feed, Chat, Follow friends and teachers, Research Videos, Research Material and many more..\nHurry Up Download now !!!";
											Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
											
										}
									});
									dialogue1.setNeutralButton("Later", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface _dialog, int _which) {
											SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
											time = new TimerTask() {
												@Override
												public void run() {
													runOnUiThread(new Runnable() {
														@Override
														public void run() {
															dialogue1.setTitle("Rate Us and Share");
															dialogue1.setMessage("Would you mind rating us ?");
															dialogue1.setPositiveButton("Rate Us", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	intent.setAction(Intent.ACTION_VIEW);
																	intent.setData(Uri.parse("https://play.google.com/work/apps/details?id=com.jaguweb.isrif&hl=en"));
																	startActivity(intent);
																	sp.edit().putString("done", "1").commit();
																}
															});
															dialogue1.setNegativeButton("Share with Friends", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	a = "ISRIF - Best Social media platform for science lovers";
																	b = "ISRIF\nIndian Scientific Research And Innovation Forum\nDownload from play store - https://play.google.com/work/apps/details?id=com.jaguweb.isrif\nForum, Feed, Chat, Follow friends and teachers, Research Videos, Research Material and many more..\nHurry Up Download now !!!";
																	Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
																	
																}
															});
															dialogue1.setNeutralButton("Later", new DialogInterface.OnClickListener() {
																@Override
																public void onClick(DialogInterface _dialog, int _which) {
																	SketchwareUtil.showMessage(getApplicationContext(), "Ok we will remind you later");
																}
															});
															dialogue1.create().show();
														}
													});
												}
											};
											_timer.schedule(time, (int)(100000));
										}
									});
									dialogue1.create().show();
								}
							});
							dialogue1.setNegativeButton("Not really", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									SketchwareUtil.showMessage(getApplicationContext(), "We are sorry for that");
									intent.setAction(Intent.ACTION_VIEW);
									intent.setData(Uri.parse("mailto:jaguweb1234@gmail.com"));
									intent.putExtra("subject", "Report problem about ISRIF Android App");
									startActivity(intent);
								}
							});
							dialogue1.create().show();
						}
					});
				}
			};
			_timer.schedule(time, (int)(100000));
		}
		Bitmap bm = ((android.graphics.drawable.BitmapDrawable)
		imageview1.getDrawable()).getBitmap();
		imageview1.setImageBitmap(getRoundedCornerBitmap(bm,360));
		Bitmap bm1 = ((android.graphics.drawable.BitmapDrawable)
		imageview2.getDrawable()).getBitmap();
		imageview2.setImageBitmap(getRoundedCornerBitmap(bm1,360));
		Bitmap bm2 = ((android.graphics.drawable.BitmapDrawable)
		imageview3.getDrawable()).getBitmap();
		imageview3.setImageBitmap(getRoundedCornerBitmap(bm2,360));
		Bitmap bm3 = ((android.graphics.drawable.BitmapDrawable)
		imageview4.getDrawable()).getBitmap();
		imageview4.setImageBitmap(getRoundedCornerBitmap(bm3,360));
		Bitmap bm4 = ((android.graphics.drawable.BitmapDrawable)
		imageview5.getDrawable()).getBitmap();
		imageview5.setImageBitmap(getRoundedCornerBitmap(bm4,360));
		Bitmap bm5 = ((android.graphics.drawable.BitmapDrawable)
		imageview6.getDrawable()).getBitmap();
		imageview6.setImageBitmap(getRoundedCornerBitmap(bm5,360));
		Bitmap bm6 = ((android.graphics.drawable.BitmapDrawable)
		imageview7.getDrawable()).getBitmap();
		imageview7.setImageBitmap(getRoundedCornerBitmap(bm6,360));
	}
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) { Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888); Canvas canvas = new Canvas(output); final int color = 0xff424242; final Paint paint = new Paint(); final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()); final RectF rectF = new RectF(rect); final float roundPx = pixels; paint.setAntiAlias(true); canvas.drawARGB(0, 0, 0, 0); paint.setColor(color); canvas.drawRoundRect(rectF, roundPx, roundPx, paint); paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN)); canvas.drawBitmap(bitmap, rect, rect, paint); return output;
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		Ads = new InterstitialAd(getApplicationContext());
		Ads.setAdListener(_Ads_ad_listener);
		if (webview2.getUrl().equals("https://jaguweb.wixsite.com/scienceonlineforum/isrifforum")) {
			d.setTitle("Quit Application ?");
			d.setMessage("Are you sure you want to exit ISRIF ?");
			d.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					Ads = new InterstitialAd(getApplicationContext());
					Ads.setAdListener(_Ads_ad_listener);
					Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
					Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
					.build());
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									SketchwareUtil.showMessage(getApplicationContext(), "Good Bye see you back soon..");
									finish();
								}
							});
						}
					};
					_timer.schedule(timer, (int)(2000));
				}
			});
			d.setNegativeButton("Stay", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					SketchwareUtil.showMessage(getApplicationContext(), "Welcome back !");
				}
			});
			d.setNeutralButton("Share App", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					a = "ISRIF - Best Social media platform for science lovers";
					b = "ISRIF\nIndian Scientific Research And Innovation Forum\nDownload from play store - https://play.google.com/work/apps/details?id=com.jaguweb.isrif\nForum, Feed, Chat, Follow friends and teachers, Research Videos, Research Material and many more..\nHurry Up Download now !!!";
					Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
					
				}
			});
			d.create().show();
		}
		else {
			if (webview2.canGoBack()) {
				webview2.goBack();
			}
			else {
				d.setTitle("Quit Application ?");
				d.setMessage("Are you sure you want to exit ISRIF ?");
				d.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						Ads = new InterstitialAd(getApplicationContext());
						Ads.setAdListener(_Ads_ad_listener);
						Ads.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
						Ads.loadAd(new AdRequest.Builder().addTestDevice("BD9FD479715A0179701A6F269C8AC4D5")
						.build());
						time = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										SketchwareUtil.showMessage(getApplicationContext(), "Good Bye see you back soon..");
										finish();
									}
								});
							}
						};
						_timer.schedule(time, (int)(2000));
					}
				});
				d.setNegativeButton("Stay", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), "Welcome back !");
					}
				});
				d.setNeutralButton("Share App", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						a = "ISRIF - Best Social media platform for science lovers";
						b = "ISRIF\nIndian Scientific Research And Innovation Forum\nDownload from play store - https://play.google.com/work/apps/details?id=com.jaguweb.isrif\nForum, Feed, Chat, Follow friends and teachers, Research Videos, Research Material and many more..\nHurry Up Download now !!!";
						Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"Share using"));
						
					}
				});
				d.create().show();
			}
		}
	}
	private void _createChannel () {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			CharSequence name = "ISRIF";
			String description = "Notification by ISRIF";
			int importance = NotificationManager.IMPORTANCE_DEFAULT;
			NotificationChannel channel = new NotificationChannel("id 1", name, importance);
			channel.setDescription(description);
			
			NotificationManager notificationManager = getSystemService(NotificationManager.class);
			notificationManager.createNotificationChannel(channel);
			
		}
		
		
		
	}
	
	
	private void _ripple (final View _view, final String _color) {
		android.content.res.ColorStateList clr0 = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)}); android.graphics.drawable.RippleDrawable ripdr0 = new android.graphics.drawable.RippleDrawable(clr0, null, null); _view.setBackground(ripdr0);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
