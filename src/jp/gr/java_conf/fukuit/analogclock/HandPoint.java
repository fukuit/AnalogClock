package jp.gr.java_conf.fukuit.analogclock;

public class HandPoint {
	private int posx;
	private int posy;

	public int X() {
		return posx;
	}

	public int Y() {
		return posy;
	}

	public void setPoint(int _x, int _y) {
		posx = _x;
		posy = _y;
	}

	public HandPoint(int _x, int _y) {
		posx = _x;
		posy = _y;
	}
}
