package com.detonegames.smart_test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.detonegames.smart_test.MyGdxGame.google_help;

public class Test_state extends State  {
    boolean signed=false;


    public Test_state(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            if(!signed){
                signed=true;
                google_help.signIn();
            }else
            {
                signed=false;
                google_help.signOut();
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

    }

    @Override
    public void dispose() {

    }
}