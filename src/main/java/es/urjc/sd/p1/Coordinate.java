package es.urjc.sd.p1;
/* ********************************************************************* */

/* ********************************************************************* */

/**
 * An object to model a set of decimal coordinates
 */
public class Coordinate {
    /* Attributes */
    /**
     * Latitude of a cardinal point. Maximum decimal digit allowed are 6.
     */
    private float latitude;

    /**
     * Longitude of a cardinal point. Maximum decimal digit allowed are 6.
     */
    private float longitude;

    /* ********************************************************************* */
    /* Builders */
    /**
     * Default builder for an Coordinate object
     * @param lat Latitude of the cardinal point.
     * @param lon Longitude of the cardinal point.
     */
    public Coordinate(float lat, float lon){
        this.latitude = lat;
        this.longitude = lon;
    }

    /* ********************************************************************* */
    /* Get & Set */
    /**
     * Getter for latitude Attribute.
     * @return The latitude of the cardinal point.
     */
    public float getLatitude(){
        return this.latitude;
    }

    /**
     * Setter for latitude attribute.
     * @param lat New latitude.
     */
    public void setLatitude(float lat){
        this.latitude = lat;
    }



    /**
     * Getter for longitude attribute.
     * @return The longitude of the cardinal point.
     */
    public float getLongitude(){
        return this.longitude;
    }

    /**
     * Setter for longitude attibute.
     * @param lon New longitude.
     */
    public void setLongitude(float lon){
        this.longitude = lon;
    }

    /* ********************************************************************* */
    /* Methods */
    public Coordinate edit(Float[] coor){
        this.setLatitude(coor[0]);
        this.setLongitude(coor[1]);
        return this;
    }
}// End class Coordinate
