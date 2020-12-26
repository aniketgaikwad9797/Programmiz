package com.example.programmiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.programmiz.QuizContract.QuestionsTable;

import java.util.ArrayList;

/*public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="programmiz.db";
    private static final int DATABASE_VERSION=1;

    private SQLiteDatabase db;   //holds reference to actual database


    public QuizDbHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    this.db=db;    //use later to add some values once database is created

        final String CREATE_QUESTIONS_TABLE="Create table "+QuestionsTable.TABLE_NAME+"(    "+
                QuestionsTable._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                QuestionsTable.COLUMN_QUESTION+" TEXT, "+
                QuestionsTable.COLUMN_OPTION1+" TEXT, "+
                QuestionsTable.COLUMN_OPTION2+" TEXT, "+
                QuestionsTable.COLUMN_OPTION3+" TEXT, "+
                QuestionsTable.ANSWER_NO+" INTEGER  " + ')';

        db.execSQL(CREATE_QUESTIONS_TABLE);   //will execute this string as a query

        fillQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+QuestionsTable.TABLE_NAME);
        onCreate(db);

    }
    private void fillQuestionTable()
    {
    Question q1=new Question("IS EGG VEG","YES","NO","DONNO",2);
    addQuestion(q1);
    Question q2=new Question("Question","YES","NO","DONNO",1);
    addQuestion(q2);
    Question q3=new Question("Egg","YES","NO","DONNO",2);
    addQuestion(q3);
    }

    private void addQuestion(Question question)   //storing questions in the database
    {
        ContentValues cv=new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionsTable.ANSWER_NO,question.getAnswerNo());
        db.insert(QuestionsTable.TABLE_NAME,null,cv);
    }
    public List<Question> getAllQuestions()        //retrieving questions from database
    {
        List<Question> questionList=new ArrayList<>();
        db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from "+QuestionsTable.TABLE_NAME,null); //cursor to perform the query
        if(c.moveToFirst())   //we will move to first query if it exists
        {
            do {
            Question question=new Question();
            question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
            question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
            question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
            question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
            question.setAnswerNo(c.getInt(c.getColumnIndex(QuestionsTable.ANSWER_NO)));
            questionList.add(question);
            }while(c.moveToNext());   //we will move to next query only if it exists
        }
        c.close();
        return questionList;
    }
}*/
public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz1.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.ANSWER_NO + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("#include <stdio.h>\n" +
                "    int main()\n" +
                "    {\n" +
                "        int x = 2, y = 0;\n" +
                "        int z = (y++) ? y == 1 && x : 0;\n" +
                "        printf(\"%d\\n\", z);\n" +
                "        return 0;\n" +
                "    }", "0", "1", "CompileTimeError", 1);
        addQuestion(q1);
        Question q2 = new Question("What is the output of this statement \"printf(\"%d\", (a++))\"?", "The value of (a+1)", "The current value of a", "Garbage Value", 2);
        addQuestion(q2);
        Question q3 = new Question("How many times will the following loop execute? \n for(j = 1; j <= 10; j = j-1)", "Forever", "Never", "10", 1);
        addQuestion(q3);
        Question q4 = new Question("What will the result of num variable after execution of the following statements? \n int num = 58;\n num % = 11;", "3", "5", "8", 1);
        addQuestion(q4);
        Question q5 = new Question("What will the result of num1 variable after execution of the following statements?\nint j = 1, num1 = 4;\nwhile (++j <= 10)  \n" +
                "{  \n" +
                "  num1++;  \n" +
                "}", "11", "12", "13", 3);
        addQuestion(q5);
        Question q6 = new Question("What will the result of len variable after execution of the following statements?\nint len;  \n" +
                "char str1[] = {\"39 march road\"};  \n" +
                "len = strlen(str1); ", "11", "12", "13", 3);
        addQuestion(q6);
        Question q7 = new Question("What does this statement mean?\nx - = y + 1;", "x = x - y + 1", "x = -x - y - 1", "x = x + y - 1", 1);
        addQuestion(q7);
        Question q8 = new Question("What will be the output?\nfor (i = 3; i < 15; i + = 3)  \n" +
                "{printf (\"%d\", i);  \n" +
                " ++i;  \n" +
                "}", "3 6 9 12", "3 7 11", "3 6 9 12 15", 2);
        addQuestion(q8);
        Question q9 = new Question("Which of the following statement is correct?\nint num[10] = {3, 3, 3};", "num[9] is the last element of the array num", "The value of num[8] is 3", "The value of num[3] is 3", 1);
        addQuestion(q9);
        Question q10 = new Question("How many bytes does \"int = D\" use?", "0", "1", "2 or 4", 3);
        addQuestion(q10);
        Question q11 = new Question("Each instance of a class has a different set of", "Class interfaces", "Attribute Values", "Methods", 2);
        addQuestion(q11);
        Question q12 = new Question("Which of the following statement is not true?", "A pointer to an int and a pointer to a double are of the same size.", "A pointer must point to a data item on the heap (free store).", "A pointer can be reassigned to point to another data item.", 2);
        addQuestion(q12);
        Question q13 = new Question("Which of the following is not a Java features?", "Dynamic", "Architectural Neutral", "Use of Pointers", 3);
        addQuestion(q13);
        Question q14 = new Question("Which package contains the Random class?", "java.util", "java.lang", "java.awt", 1);
        addQuestion(q14);
        Question q15 = new Question("An interface with no fields or methods is known as a ______.", "Abstract Interface", "Marker Interface", "Runnable Interface", 2);
        addQuestion(q15);
        Question q16 = new Question("Which of these classes are the direct subclasses of the Throwable class?", "RuntimeException and Error class", "Error and Exception class", "Exception and VirtualMachineError class", 2);
        addQuestion(q16);
        Question q17 = new Question("Which keyword is used for accessing the features of a package?", "package", "imprort", "extends", 2);
        addQuestion(q17);
        Question q18 = new Question("In java, jar stands for_____.", "Java Application Runner", "Java Archive", "Java Applications", 2);
        addQuestion(q18);
        Question q19 = new Question("Which of the following is a mutable class in java?", "java.lang.String", "java.lang.StringBuffer", "java.lang.Byte", 2);
        addQuestion(q19);
        Question q20 = new Question("How many threads can be executed at a time?", "A single thread", "Only main() thread", "multiple threads", 3);
        addQuestion(q20);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.ANSWER_NO, question.getAnswerNo());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setAnswerNo(c.getInt(c.getColumnIndex(QuestionsTable.ANSWER_NO)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
