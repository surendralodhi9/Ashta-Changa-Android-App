package com.example.astachanga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {

    public TextView rulesView;
    public TextView rule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_rules);
        //System.out.println("Han to nahi dikh raha");
        setUpUi();
        String rulesList="1. First, add the name of players by clicking on the ADD PLAYER button.\n" +
                "2. Now anyone player might throw toss by clicking on the TOSS button, to determine who will play first, second, and so on.\n" +
                "3. The player whose name is displaying in green color(near the bottom of the board) can roll the dice first.\n" +
                "4. Whose name is displaying in red color was the previous player who rolled the dice.\n" +
                "5. You can see the list of a comma-separated list of numbers that means you can move(to move a token touch that token) the token by that number, " +
                "the player will continue to move his/her tokens until all moves are done or no move possible.\n" +
                "6. The player can only move their token in the sequence that they are getting the score(i.e. if score list is 8,5,2 " +
                "then first move 8 boxes and then 5 boxes, etc.)\n" +
                "7. If the player tries to move the token that can not be moved by the current score, will lose the current score.\n" +
                "8. Once the ROLL text displayed on the button or no move is possible of the previous player, the next player can start rolling dice.\n" +
                "9. You can open your token with any score value 1,2,3,5,...\n" +
                "10. You have to move all your token into the cell(box) which is having a yellow color.\n" +
                "11. The first player who moved their all tokens in the yellow color box will be the winner.\n" +
                "12. If you move your token to the box(Not colored box) and there is already one token of another player, then the another player's token\n" +
                "will be killed and sent back home and the current player(who is moving the token) will get another chance to roll the dice.\n" +
                "\n"+
                "Rules of 5, 8, 10\n" +
                "1. If you get any score 5, 8, or 10. you will get another chance to roll dice.\n" +
                "2. If a 5, 8, or 10 is rolled three times in a row, the player loses his turn(Only if they display in current score list).";

        rulesView.setMovementMethod(new ScrollingMovementMethod());
        rulesView.setText(rulesList.toString());
        rule.setText("Rules");


    }
    
    public void setUpUi()
    {

        rulesView=(TextView) findViewById(R.id.rulesTextView);
        rule=(TextView)findViewById(R.id.rulesView);

    }
}