package com.shj.educationapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MathGame
{
    private String currentEquation;
    private int    numQuestAsked;
    private int    numMistakes;
    private String operation;


    public MathGame(String str)
    {
        operation = str;
        currentEquation = "";
        numQuestAsked = 0;
        numMistakes = 0;
    }


    public String generateEquation()
    {
        // a (operation) b = ans
        Random rand = new Random();
        int a = rand.nextInt(9) + 1;
        int b = rand.nextInt(9) + 1;

        int ans;
        if (operation.equals("+"))
        {
            ans = a + b;
        }
        else if (operation.equals("-"))
        {
            ans = a - b;
        }
        else if (operation.equals("*"))
        {
            ans = a * b;
        }
        else
        {
            ans = a + b;
        }

        currentEquation = a + " " + operation + " " + b + " " + "= " + ans;
        numQuestAsked++;
        return currentEquation;
    }


    public String getCurrentEquation()
    {
        return currentEquation;
    }


    public String generateQuestion(String equation)
    {
        return equation.substring(0, findAnsLocation(equation));
    }


    public int[] generateChoices(String equation)
    {
        int[] choices = new int[4];
        Random rand = new Random();

        int ans = findAns(equation);

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(ans);
        list.add(ans + 1);
        list.add(ans + 2);
        list.add(ans - 1);

        for (int i = 0; i < choices.length; i++)
        {
            int x = rand.nextInt(list.size());
            choices[i] = list.get(x);
            list.remove(x);
        }

        return choices;

    }


    public int findAnsLocation(String equation)
    {
        int x = 0;
        for (int i = 0; i < equation.length(); i++)
        {
            if (equation.charAt(i) == '=')
            {
                x = i;
                break;
            }
        }
        return x;
    }


    public int findAns(String equation)
    {
        return Integer.parseInt(equation
            .substring(findAnsLocation(equation) + 2));
    }


    public int getNumQuestAsked()
    {
        return numQuestAsked;
    }


    public int getNumMistakes()
    {
        return numMistakes;
    }


    public void addMistake()
    {
        numMistakes++;
    }


    public String getOperation()
    {
        return operation;
    }


    public String operationWord()
    {
        if (operation.equals("+"))
            {
            return "Addition";

            }
        else if (operation.equals("-"))
        {
            return "Subtraction";
        }
        else
        {
            return "Multiplication";
        }
    }
}
