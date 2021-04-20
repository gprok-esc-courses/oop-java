package p09_snake_game;

public class SnakeCell {
    private int x;
    private int y;
    private boolean head;

    public SnakeCell(int x, int y) {
        this.x = x;
        this.y = y;
        head = false;
    }

    public SnakeCell setHead() {
        head = true;
        return this;
    }

    public boolean isHead() {
        return head;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
