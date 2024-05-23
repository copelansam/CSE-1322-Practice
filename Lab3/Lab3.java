import java.util.Scanner;
import java.util.ArrayList;
public class Lab3 {

    static class Question {
        private String text;
        private String answer;
        private int difficulty;

        Question (String a, String b, int c){
            this.text = a;
            this.answer = b;
            this.difficulty = c;
        }

        void setQuestion(String a){
            text = a;
        }

        void setAnswer(String a){
            answer = a;
        }

        void setDifficulty(int a){

            difficulty = a;
        }

        String getQuestion(){

            return text;
        }

        String getAnswer(){

            return answer;
        }

        int getDifficulty(){

            return difficulty;
        }
    }

    static class Quiz{
         ArrayList <Question> test = new ArrayList<> ();
         Scanner sc = new Scanner(System.in);

         Quiz(){

         }

         void add_question(){
             Scanner scan = new Scanner(System.in);
             System.out.println("What is the question Text?");
             String text = scan.nextLine();
             System.out.println("What is the answer?");
             String answer = scan.nextLine();
             System.out.println("How difficult (1-3)?");
             int difficulty = scan.nextInt();
             Question a = new Question(text, answer, difficulty);
             test.add(a);

         }

         void remove_question(){
             Scanner read = new Scanner(System.in);
             /*for (int i = 0; i < test.length; i ++){
                 Question display = test.get(i);
                 System.out.println((i + 1) + ") " + remove.getQuestion());
             }*/
             int i = 0;
             for(Question s1 : test){
                 i++;
                 System.out.println(i + ". " + s1.getQuestion());
             }
             System.out.println("Choose the question to remove?");
             int selection = read.nextInt();
             //int remove = test.get(selection);
             test.remove(selection - 1);
         }

         void modify_question(){
             /*for (int i = 0; i < test.length; i ++){
                 Question display = test.get(i);
                 System.out.println((i + 1) + ") " + display.getQuestion());
             }*/
             int i = 0;
             for(Question s1 : test){
                 i++;
                 System.out.println(i + ". " + s1.getQuestion());
             }
             System.out.println("Choose the question to modify?");
             int selection = sc.nextInt();
             System.out.println("What is the new question: ");
             String text = sc.nextLine();
             System.out.println("What is the new answer: ");
             String answer = sc.nextLine();
             System.out.println("What is the new difficulty: ");
             int difficulty = sc.nextInt();
             Question replacement = new Question(text, answer, difficulty);
             test.set((selection - 1), replacement);

         }

         void give_quiz(){
             Scanner sc = new Scanner (System.in);
             int i = 0;
             int correct = 0;
             for(Question s1 : test){
                 i++;
                 System.out.print(i + ". " + s1.getQuestion());
                 String input = sc.nextLine();
                 if (input.equals(s1.getAnswer())){
                     System.out.println("Correct");
                     correct++;
                 }
                 else {
                     System.out.println("Incorrect");
                 }

             }
             System.out.println("You got " + correct + " out of " + test.size());


         }
    }

    public static void main (String [] args ){
        Scanner sc = new Scanner (System.in);
        int selection = 0;
        Quiz test = new Quiz();
        while (selection != 5){
            System.out.println("What would you like to do?");
            System.out.println("1.Add a question to the quiz");
            System.out.println("2.Remove a question from the quiz");
            System.out.println("3.Modify a question in the quiz");
            System.out.println("4.Take the quiz");
            System.out.println("5.Quit");
            selection = sc.nextInt();

            if (selection == 1){
                test.add_question();
            }
            else if (selection == 2){
                test.remove_question();
            }
            else if (selection == 3){
                test.modify_question();
            }
            else if (selection == 4){
                test.give_quiz();
            }

        }

    }
}

