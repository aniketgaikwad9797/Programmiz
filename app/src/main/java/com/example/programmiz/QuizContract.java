package com.example.programmiz;

import android.provider.BaseColumns;

public final class QuizContract     //final so that a subclass can't be created of QuizContact Class
{
    private QuizContract()   //a private constructor so that we don't accidentally create a object
    {

    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "quiz_question";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String ANSWER_NO = "answer";
        public static final String COLUMN_DIFFICULTY = "answer";
    }
}
