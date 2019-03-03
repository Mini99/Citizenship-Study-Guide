package com.example.welcome;

public class QuestionLibrary {

    private String mQuestions [] = {
            "What do we call the first ten amendments to the Constitution?",
            "We elect a President for how many years?",
            "What is one reason colonists came to America?",
            "What is the political party of the President now?",
            "How many U.S. Senators are there?",
            "What territory did the United States buy from France in 1803?",
            "What do we show loyalty to when we say the Pledge of Allegiance?",
            "Name one problem that led to the Civil War.",
            "If the President can no longer serve, who becomes President?",
            "What did the Declaration of Independence do?",
    };

    private String mChoices [][] = {
            {"The Declaration of Independence", "the inalieanable rights", "the Bill of Rights"},
            {"8", "2", "4"},
            {"to join a civic group", "freedom", "for the experience traveling across the ocean"},
            {"Republican Party", "Independent Party", "Democratic Party"},
            {"50", "100", "435"},
            {"The Louisiana Territory", "Alaska", "Hawaii"},
            {"The President", "Congress", "the United States"},
            {"oil", "slavery", "sugar"},
            {"the Secretary of State", "the Vice President", "the Speaker of the House"},
            {"gave women the right to vote", "freed the slaves", "declared our independence from Great Britain"},

    };

    private String mCorrectAns[] = {"the Bill of Rights", "4", "freedom", "Republican Party", "100", "The Louisiana Territory", "the United States", "slavery", "the Vice President", "declared our independence from Great Britain"};

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAns[a];
        return answer;
    }

}
