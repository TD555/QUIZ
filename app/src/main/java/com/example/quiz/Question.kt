package com.example.quiz

object Question {
    fun getQuestions():ArrayList<QuestionModel>
    {
        val questionslist=ArrayList<QuestionModel>()
        var que=QuestionModel(1,
            "How many planets are in the solar system, not counting Pluto?",
            R.drawable.planets1,
            "7","10","8","9",
            3)
        questionslist.add(que)
        que= QuestionModel(2,"For how long does the Earth turn around its axis",
        R.drawable.planets2,
        "24 Hours","7 days","12 hours","1 month",
        1)
        questionslist.add(que)
        que=QuestionModel(3,"What's the name of our planet",
        R.drawable.planets3,"Moon","Earth",  "Mercury","Saturn",
        2)
        questionslist.add(que)
        que=QuestionModel(4,"Which planet is farther from the Sun? (Pluto is not considered a planet)",
                R.drawable.planets4,"Venus","Earth",  "Neptune","Saturn",
                3)
        questionslist.add(que)
        que=QuestionModel(5,"Which planet is the biggest?",
                R.drawable.planets5,"Neptune","Saturn",  "Mercury","Jupiter",
                4)
        questionslist.add(que)
        que=QuestionModel(6,"Which planet is the smallest? (Pluto is not considered a planet)",
                R.drawable.planets6,"Mercury","Earth",  "Mars","Saturn",
                1)
        questionslist.add(que)
        que=QuestionModel(7,"\"Tailed\" celestial bodies is-?",
                R.drawable.planets7,"Comet","Star",  "Planet","Asteroids",
                1)
        questionslist.add(que)
        que=QuestionModel(8,"What is the Moon?",
                R.drawable.planets8,"Comet","Planet",  "Star","Companion",
                4)
        questionslist.add(que)
        que=QuestionModel(9,"Which planet has a ring?",
                R.drawable.planets9,"Mercury","Saturn",  "Jupiter","Mars",
                2)
        questionslist.add(que)
        que=QuestionModel(10,"For how long does the Earth orbit the Sun?",
                R.drawable.planets10,"day","week",  "year","month",
                3)
        questionslist.add(que)
        return questionslist
    }
}