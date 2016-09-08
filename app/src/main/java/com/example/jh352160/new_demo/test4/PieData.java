package com.example.jh352160.new_demo.test4;

import android.support.annotation.NonNull;

/**
 * Created by jh352160 on 2016/9/5.
 */

public class PieData {
    //用户关键数据
    private String name;
    private float value;
    private float percentage;

    //非用户关心数据
    private int color=0;
    private float angle=0;

    public PieData(@NonNull String name,@NonNull float value){
        this.name=name;
        this.value=value;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
