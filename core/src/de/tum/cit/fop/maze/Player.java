package de.tum.cit.fop.maze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {
    private String name;
    private int score;
    private int highscore;
    private int lives;
    private int level;
    private boolean gameOver;
    private boolean gameWon;
    private boolean gamePaused;
    private boolean gameStarted;
    private final Texture texture;
    private final Animation<TextureRegion> walkAnimation;
    private float x, y;
    private float speed = 100f; // Movement speed

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.highscore = 0;
        this.lives = 3;
        this.level = 1;
        this.gameOver = false;
        this.gameWon = false;
        this.gamePaused = false;
        this.gameStarted = false;
        this.texture = new Texture("character.png");
        TextureRegion[][] regions = TextureRegion.split(texture, 64, 64);
        this.walkAnimation = new Animation<>(0.1f, regions[0]);
        this.walkAnimation.setPlayMode(Animation.PlayMode.LOOP);
        this.x = 0;
        this.y = 0;
    }

    public void render(SpriteBatch batch, float elapsedTime) {
        TextureRegion currentFrame = walkAnimation.getKeyFrame(elapsedTime, true);
        batch.draw(currentFrame, x, y, 64, 64);
    }

    public void update(float delta) {
        keyboardInput(delta);
    }

    private void keyboardInput(float delta) {
        float currentSpeed = Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) ? speed * 2 : speed;
        if (Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            y += currentSpeed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            y -= currentSpeed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= currentSpeed * delta;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += currentSpeed * delta;
        }
    }

    public void reset() {
        this.name = "";
        this.score = 0;
        this.highscore = 0;
        this.lives = 3;
        this.level = 1;
        this.gameOver = false;
        this.gameWon = false;
        this.gamePaused = false;
        this.x = 0;
        this.y = 0;
    }

    public void dispose() {
        texture.dispose();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    public boolean isGamePaused() {
        return gamePaused;
    }

    public void setGamePaused(boolean gamePaused) {
        this.gamePaused = gamePaused;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public Texture getTexture() {
        return texture;
    }

    public Animation<TextureRegion> getWalkAnimation() {
        return walkAnimation;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
