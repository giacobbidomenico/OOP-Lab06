package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private final double batteryLevel;
	private final double batteryRequired;
	
	public NotEnoughBatteryException(final double batteryLevel,final double batteryRequired) {
		super();
		this.batteryLevel = batteryLevel;
		this.batteryRequired = batteryRequired;
	}
	
	public String toString() {
		return "Insufficient battery!!! Battery level:"+ this.batteryLevel
				+ "Battery required:" + this.batteryRequired;
	}
	
	public String getMessage() {
		return this.toString();
	}
}
