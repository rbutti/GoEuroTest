package com.goeuro.javatest.loc2csv.domain;

public class GeoPosition {

    private double longitude;
    private double latitude;

    public double getLongitude() {
	return longitude;
    }

    public void setLongitude(double longitude) {
	this.longitude = longitude;
    }

    public double getLatitude() {
	return latitude;
    }

    public void setLatitude(double latitude) {
	this.latitude = latitude;
    }

    @Override
    public String toString() {
	return "GeoPosition [longitude=" + longitude + ", latitude=" + latitude + "]";
    }

    @Override
    public int hashCode() {

	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(latitude);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(longitude);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
    }

    @Override
    public boolean equals(Object obj) {

	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	GeoPosition other = (GeoPosition) obj;
	if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
	    return false;
	if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
	    return false;
	return true;
    }
}
