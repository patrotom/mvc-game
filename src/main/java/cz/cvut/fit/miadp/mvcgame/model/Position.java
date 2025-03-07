package cz.cvut.fit.miadp.mvcgame.model;

public class Position {
    private int dimX;
	private int dimY;

	public Position(int posX, int posY) {
		this.dimX = posX;
		this.dimY = posY;
	}

	public void add(Vector v) {
		setX(getX() + v.getDX());
		setY(getY() + v.getDY());
	}

	public int getX() { return this.dimX; }

    public int getY() { return this.dimY; }

    public void setY(int y) { this.dimY = y; }

    public void setX(int x) { this.dimX = x; }
}
