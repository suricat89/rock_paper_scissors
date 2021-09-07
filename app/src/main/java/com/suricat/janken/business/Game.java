package com.suricat.janken.business;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.suricat.janken.model.Gesture;
import com.suricat.janken.model.GestureTypes;
import com.suricat.janken.model.ResultTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Gesture> gestures;

    public Game() {
        gestures = new ArrayList<>();

        Gesture rock = new Gesture(GestureTypes.Rock);
        rock.addStrength(GestureTypes.Scissors);
        rock.addWeakness(GestureTypes.Paper);
        gestures.add(rock);

        Gesture paper = new Gesture(GestureTypes.Paper);
        paper.addStrength(GestureTypes.Rock);
        paper.addWeakness(GestureTypes.Scissors);
        gestures.add(paper);

        Gesture scissors = new Gesture(GestureTypes.Scissors);
        scissors.addStrength(GestureTypes.Paper);
        scissors.addWeakness(GestureTypes.Rock);
        gestures.add(scissors);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ResultTypes validateResult (GestureTypes playerGesture, GestureTypes oponentGesture) {
        boolean hasPlayerWon = gestures.stream().anyMatch(gesture ->
           gesture.getGestureType().equals(playerGesture) &&
           gesture.getStrength().contains(oponentGesture)
        );

        boolean hasPlayerLost = gestures.stream().anyMatch(gesture ->
                gesture.getGestureType().equals(playerGesture) &&
                gesture.getWeakness().contains(oponentGesture)
        );

        if (hasPlayerWon) return ResultTypes.Win;
        if (hasPlayerLost) return ResultTypes.Lose;
        return ResultTypes.Draw;
    }

    public GestureTypes oponentPlay () {
        int selected = new Random().nextInt(GestureTypes.values().length);
        return GestureTypes.values()[selected];
    }
}
