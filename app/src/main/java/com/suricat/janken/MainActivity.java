package com.suricat.janken;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.suricat.janken.business.Game;
import com.suricat.janken.model.GestureTypes;
import com.suricat.janken.model.ResultTypes;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void selectedRock (View v) {
        handlePlayerOptionSelected(GestureTypes.Rock);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void selectedPaper (View v) {
        handlePlayerOptionSelected(GestureTypes.Paper);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void selectedSissors (View v) {
        handlePlayerOptionSelected(GestureTypes.Sissors);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void handlePlayerOptionSelected (GestureTypes selected) {
        Game game = new Game();
        GestureTypes oponentGesture = game.oponentPlay();
        ImageView imgOponentPlay = findViewById(R.id.imgOponentPlay);
        switch(oponentGesture) {
            case Rock:
                imgOponentPlay.setImageResource(R.drawable.rock_gesture);
                break;
            case Paper:
                imgOponentPlay.setImageResource(R.drawable.paper_gesture);
                break;
            case Sissors:
                imgOponentPlay.setImageResource(R.drawable.sissors_gesture);
                break;
        }

        ResultTypes result = game.validateResult(selected, oponentGesture);
        String message = "";
        switch(result) {
            case Win:
                message = "Congratulations, you won!";
                break;
            case Lose:
                message = "You lost, try again :(";
                break;
            case Draw:
                message = "That's a draw...";
                break;
        }

        TextView txtResult = findViewById(R.id.txtResult);
        txtResult.setText(message);
    }

}