package il.co.shenkar.mapmarkshw2.entities;

public class Marker {

	private static int idIncer = 0;
	private int markerId;
	private float markerX;
	private float markerY;
	private String markerDescription;
	
	public Marker(float markerX, float markerY, String markerDescription) {
		super();
		this.markerId = idIncer++;
		this.markerX = markerX;
		this.markerY = markerY;
		this.markerDescription = markerDescription;
	}
	
	public Marker(float f, float g) {
		super();
		this.markerId = idIncer++;
		this.markerX = f;
		this.markerY = g;
	}
	public int getMarkerId() {
		return markerId;
	}
	public void setMarkerId(int markerId) {
		this.markerId = markerId;
	}
	public float getMarkerX() {
		return markerX;
	}
	public void setMarkerX(int markerX) {
		this.markerX = markerX;
	}
	public float getMarkerY() {
		return markerY;
	}
	public void setMarkerY(int markerY) {
		this.markerY = markerY;
	}
	public String getMarkerDescription() {
		return markerDescription;
	}
	public void setMarkerDescription(String markerDescription) {
		this.markerDescription = markerDescription;
	}
}
