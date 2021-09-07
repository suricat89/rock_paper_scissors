package com.suricat.janken.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Gesture {
    private GestureTypes gestureType;
    private List<GestureTypes> strength;
    private List<GestureTypes> weakness;

    public Gesture(GestureTypes gestureType) {
        this.gestureType = gestureType;
        this.strength = new ArrayList<>();
        this.weakness = new ArrayList<>();
    }

    public GestureTypes getGestureType() {
        return gestureType;
    }

    public void setGestureType(GestureTypes gestureType) {
        this.gestureType = gestureType;
    }

    public List<GestureTypes> getStrength() {
        return strength;
    }

    public void setStrength(List<GestureTypes> strength) {
        this.strength = strength;
    }

    public List<GestureTypes> getWeakness() {
        return weakness;
    }

    public void setWeakness(List<GestureTypes> weakness) {
        this.weakness = weakness;
    }

    public void addStrength(GestureTypes... strengths) {
        Collections.addAll(this.strength, strengths);
    }

    public void addWeakness(GestureTypes... weaknesses) {
        Collections.addAll(this.weakness, weaknesses);
    }
}
