package com.detonegames.smart_test;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.detonegames.smart_test.MyGdxGame;

public class AndroidLauncher extends AndroidApplication implements Google_helper {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MyGdxGame(this), config);
	}

	@Override
	public void signIn() {

	}

	@Override
	public void signOut() {

	}
}
