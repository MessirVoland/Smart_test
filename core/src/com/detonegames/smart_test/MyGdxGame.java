package com.detonegames.smart_test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private GameStateManager gsm;
	private SpriteBatch batch;
	OrthographicCamera cam;
	public static final int WIDTH = 1280; //480
	public static final int HEIGHT = 720; // 800
	//SpriteBatch batch;
	public static Google_helper google_help;
	public MyGdxGame(Google_helper google_helper){
		if (google_helper != null) {
			google_help = google_helper;
		} else {
			google_help = new DummyAdsController();
		}
	}

	@Override
	public void create () {

		cam = new OrthographicCamera();
		cam.setToOrtho(false, WIDTH, HEIGHT);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		gsm = new GameStateManager();
		//Gdx.gl20.glEnable(GL30.GL_BLEND);
		Gdx.gl.glClearColor(255, 255, 255, 0);
		gsm.push(new Test_state(gsm));
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (gsm!=null) {
			gsm.update(Gdx.graphics.getDeltaTime());
			gsm.render(batch);
		}

		Gdx.gl.glFlush();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		batch.dispose();
	}


	private class DummyAdsController implements Google_helper{

		@Override
		public void signIn() {
			System.out.println("try sign in");
		}

		@Override
		public void signOut() {
			System.out.println("try sign out");
		}
	}

}



