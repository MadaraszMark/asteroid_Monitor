package hu.madarasz.asteroids.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AsteroidDto {

    private String name;

    @JsonProperty("estimated_diameter_min_meters")
    private double estimatedDiameterMinMeters;

    @JsonProperty("estimated_diameter_max_meters")
    private double estimatedDiameterMaxMeters;

    @JsonProperty("relative_velocity_kps")
    private double relativeVelocityKps;

    @JsonProperty("miss_distance_km")
    private double missDistanceKm;

    @JsonProperty("is_potentially_hazardous")
    private boolean isPotentiallyHazardous;

    public AsteroidDto() {
    }

    public AsteroidDto(String name, double estimatedDiameterMinMeters, double estimatedDiameterMaxMeters,
                       double relativeVelocityKps, double missDistanceKm, boolean isPotentiallyHazardous) {
        this.name = name;
        this.estimatedDiameterMinMeters = estimatedDiameterMinMeters;
        this.estimatedDiameterMaxMeters = estimatedDiameterMaxMeters;
        this.relativeVelocityKps = relativeVelocityKps;
        this.missDistanceKm = missDistanceKm;
        this.isPotentiallyHazardous = isPotentiallyHazardous;
    }

    public String getName() {
        return name;
    }

    public double getEstimatedDiameterMinMeters() {
        return estimatedDiameterMinMeters;
    }

    public double getEstimatedDiameterMaxMeters() {
        return estimatedDiameterMaxMeters;
    }

    public double getRelativeVelocityKps() {
        return relativeVelocityKps;
    }

    public double getMissDistanceKm() {
        return missDistanceKm;
    }

    public boolean isPotentiallyHazardous() {
        return isPotentiallyHazardous;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEstimatedDiameterMinMeters(double estimatedDiameterMinMeters) {
        this.estimatedDiameterMinMeters = estimatedDiameterMinMeters;
    }

    public void setEstimatedDiameterMaxMeters(double estimatedDiameterMaxMeters) {
        this.estimatedDiameterMaxMeters = estimatedDiameterMaxMeters;
    }

    public void setRelativeVelocityKps(double relativeVelocityKps) {
        this.relativeVelocityKps = relativeVelocityKps;
    }

    public void setMissDistanceKm(double missDistanceKm) {
        this.missDistanceKm = missDistanceKm;
    }

    public void setPotentiallyHazardous(boolean potentiallyHazardous) {
        isPotentiallyHazardous = potentiallyHazardous;
    }
}
