package com.example.bv.onixtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import io.fabric.sdk.android.Fabric;



/**
 * Created by bv on 02.07.16.
 */
public class MainActivity extends Activity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "UFZbipXZHVUAlEXo9rF771vtv";
    private static final String TWITTER_SECRET = "jQvXj3Z9YFd1dl9HEimeCNDyXY8ClDNg7c9h2dR10S5sGGcDsG";
    private Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Twitter.logIn(MainActivity.this, new Callback<TwitterSession>() {
                    @Override
                    public void success(Result<TwitterSession> result) {

                    }

                    @Override
                    public void failure(TwitterException exception) {

                    }
                });
            }
        });
    }

}
