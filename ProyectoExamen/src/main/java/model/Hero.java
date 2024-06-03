package model;

import java.awt.Color;
import java.awt.Graphics;

public class Hero extends Role {

    public Hero(int value) {
        super(value);
        coord_X = new int[]{350, 400, 450};
        coord_Y = new int[]{500, 450, 500};
    }

    @Override
    public void move(String direction, int movSpeed) {
        switch (direction) {
            case "LEFT":
                if (canMove(-movSpeed)) {
                    for (int i = 0; i < coord_X.length; i++) {
                        coord_X[i] -= movSpeed;
                    }
                }
                break;
            case "RIGHT":
                if (canMove(movSpeed)) {
                    for (int i = 0; i < coord_X.length; i++) {
                        coord_X[i] += movSpeed;
                    }
                }
                break;
        }
    }

    private boolean canMove(int deltaX) {
        for (int coordX : coord_X) {
            int newX = coordX + deltaX;
            if (newX < 0 || newX > 790) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void draw(Graphics graphics, Role p) {
        graphics.setColor(Color.BLUE);
        graphics.fillPolygon(p.coord_X, p.coord_Y, 3);
    }
}
