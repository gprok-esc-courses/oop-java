package p09_snake_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

public class Board extends JPanel implements KeyListener {

    public static final int BOARD_SIZE = 300;
    public static final int CELL_SIZE = 10;
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;

    private Vector<SnakeCell> snake;
    private FruitCell fruit;
    private int direction;

    public Board() {
        initSnake();
        placeFruit();
        direction = UP;
        setFocusable(true);
        setBackground(Color.CYAN);
        setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
        addKeyListener(this);
    }

    public void initSnake() {
        snake = new Vector<>();
        snake.add(new SnakeCell(150, 150).setHead());
        snake.add(new SnakeCell(150, 160));
        snake.add(new SnakeCell(150, 170));
        repaint();
    }

    public void placeFruit() {
        Random random = new Random();
        int x = (random.nextInt(27) + 1) * CELL_SIZE;
        int y = (random.nextInt(27) + 1) * CELL_SIZE;
        fruit = new FruitCell(x, y);
    }

    public boolean onFruit() {
        SnakeCell head = snake.firstElement();
        return (head.getX() == fruit.getX() &&
                head.getY() == fruit.getY());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (SnakeCell cell : snake) {
            if(cell.isHead()) {
                g.setColor(Color.RED);
            }
            else {
                g.setColor(new Color(0, 100, 0));
            }
            g.fillRect(cell.getX(), cell.getY(), CELL_SIZE, CELL_SIZE);
        }

        g.setColor(Color.MAGENTA);
        g.fillOval(fruit.getX(), fruit.getY(), CELL_SIZE, CELL_SIZE);
    }

    public void moveSnake() {
        SnakeCell last = snake.lastElement();
        int lastX = last.getX();
        int lastY = last.getY();

        for(int idx = snake.size()-1; idx > 0; idx--) {
            SnakeCell current = snake.elementAt(idx);
            SnakeCell previous = snake.elementAt(idx-1);
            current.setX(previous.getX());
            current.setY(previous.getY());
        }
        SnakeCell head = snake.firstElement();
        switch (direction) {
            case UP:
                head.setY(head.getY() - CELL_SIZE);
                break;
            case DOWN:
                head.setY(head.getY() + CELL_SIZE);
                break;
            case LEFT:
                head.setX(head.getX() - CELL_SIZE);
                break;
            case RIGHT:
                head.setX(head.getX() + CELL_SIZE);
                break;
        }

        if(onFruit()) {
            SnakeCell newCell = new SnakeCell(lastX, lastY);
            snake.add(newCell);
            placeFruit();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_UP:
                direction = direction != DOWN ? UP : direction;
                break;
            case KeyEvent.VK_DOWN:
                direction = direction != UP ? DOWN : direction;
                break;
            case KeyEvent.VK_LEFT:
                direction = direction != RIGHT ? LEFT : direction;
                break;
            case KeyEvent.VK_RIGHT:
                direction = direction != LEFT ? RIGHT : direction;
                break;
        }

        moveSnake();
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}
