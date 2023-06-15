import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
}
 class User
{
    String username;
    String password;
    int Score=0;
    Scanner in=new Scanner(System.in);
    User()
    {
        System.out.print(ConsoleColors.BLUE_BOLD+"USERNAME:");
        this.username=in.next();
        System.out.print("PASSWORD:"+ConsoleColors.RESET);
        this.password=in.next();
    }
    public static int validation(String username,String password,User[] users,int size) {
        String usernameREGEX = "^.{1,}$";
        Pattern usernamepattern = Pattern.compile(usernameREGEX);
        String passwordREGEX1 = "^\\w*[-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/]{1}\\w*$";//we also have to check if the string lenght is
        //longer than 6 charcters or not
        Pattern passwordPattern1 = Pattern.compile(passwordREGEX1);
        Matcher matcherUsername = usernamepattern.matcher(username);
        Matcher matcherPassword = passwordPattern1.matcher(password);
        if (size == 0) {
            if ((matcherPassword.find() || password.matches("^\\w*[-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/]{1}\\w*$")) && password.length() >= 6 && (matcherUsername.find() || username.matches("^.{1,}$"))) {
                System.out.println(ConsoleColors.YELLOW_BACKGROUND+"YOU ARE SUCCESSFULLY SIGNED UP!"+ConsoleColors.RESET);
                users[size].username = username;
                users[size].password = password;
                return 1;
            }
            if ((matcherPassword.find() || password.matches("^\\w*[-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/]{1}\\w*$")) && password.length() < 6 && (matcherUsername.find() || username.matches("^.{1,}$")))
            {
                System.out.println(ConsoleColors.RED_BACKGROUND+"YOUR PASSWORD IS SHORTER THAN THE STANDARD LENGTH,PLEASE TRY AGAIN"+ConsoleColors.RESET);
                System.out.println(ConsoleColors.RED_BACKGROUND+"PS:IT SHOULD BE AT LEAST 6 CHARACTERS LONG"+ConsoleColors.RESET);
                return 0;
            }
            if ((!matcherPassword.find() || !password.matches("^\\w*[-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/]{1}\\w*$")) && password.length() < 6 && (matcherUsername.find() || username.matches("^.{1,}$"))) {
                System.out.println(ConsoleColors.RED_BACKGROUND+"YOUR PASSWORD DOESNT MATCH THE STANDARD PATTERN,PLEASE TRY AGAIN."+ConsoleColors.RESET);
                return 0;
            }
            else
            {
                System.out.println(ConsoleColors.RED_BACKGROUND+"YOUR PASSWORD DOESNT MATCH THE STANDARD PATTERN,PLEASE TRY AGAIN."+ConsoleColors.RESET);
                return 0;
            }
        } else {
            if (matcherUsername.find() || username.matches("^.{1,}$")) {
                for (int i = 0; i < size; i++) {
                    if (users[i].username.equals(username)) {
                        System.out.println(ConsoleColors.RED_BACKGROUND+"THIS USERNAME IS ALREADY TAKEN,PLEASE TRY AGAIN."+ConsoleColors.RESET);
                        return 0;
                    }
                }
                if ((matcherPassword.find() || password.matches("^\\w*[-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/]{1}\\w*$")) && password.length() >= 6) {
                    System.out.println(ConsoleColors.YELLOW_BACKGROUND+"YOU ARE SUCCESSFULLY SIGNED UP!"+ConsoleColors.RESET);
                    users[size].username = username;
                    users[size].password = password;
                    return 1;
                }
                if ((matcherPassword.find() || password.matches("^\\w*[-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/]{1}\\w*$")) && password.length() < 6) {
                    System.out.println(ConsoleColors.RED_BACKGROUND+"YOUR PASSWORD IS SHORTER THAN THE STANDARD LENGTH,PLEASE TRY AGAIN"+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.RED_BACKGROUND+"PS:IT SHOULD BE AT LEAST 6 CHARACTERS LONG"+ConsoleColors.RESET);
                    return 0;
                }
                if ((!matcherPassword.find() || !password.matches("^\\w*[-!$%^&*()_+|~=`{}\\[\\]:\";'<>?,.\\/]{1}\\w*$")) && password.length() < 6) {
                    System.out.println(ConsoleColors.RED_BACKGROUND+"YOUR PASSWORD DOESNT MATCH THE STANDARD PATTERN,PLEASE TRY AGAIN."+ConsoleColors.RESET);
                    return 0;
                } else
                {
                    System.out.println(ConsoleColors.RED_BACKGROUND+"YOUR PASSWORD DOESNT MATCH THE STANDARD PATTERN,PLEASE TRY AGAIN."+ConsoleColors.RESET);
                    return 0;
                }
            } else
            {
                System.out.println(ConsoleColors.RED_BACKGROUND+"YOUR PASSWORD DOESNT MATCH THE STANDARD PATTERN,PLEASE TRY AGAIN."+ConsoleColors.RESET);
                return 0;
            }
        }
    }
}
 class leaderboard
{
    static void inc_insertion_sort(User[]a,int size)
    {
        for(int i=1;i<size;i++)
        {
            int element=a[i].Score;
            int j=i;
            while(j>0 && a[j-1].Score<element)
            {
                a[j]=a[j-1];
                j--;
            }
            a[j].Score=element;
        }
    }
    public static void leaderbord(User[] users,int numberOfplayers)
    {
        if(numberOfplayers>0)
            inc_insertion_sort(users,numberOfplayers);
        for (int i = 0; i <=numberOfplayers ; i++)
        {
            System.out.print(ConsoleColors.PURPLE_BACKGROUND
                    +users[i].username+"............................................................");
            System.out.println(users[i].Score+ConsoleColors.RESET);
        }
    }
}
 class HangmanPerson
{
    HangmanPerson(int faults,int gamewordl)
    {
        if((faults==1 && gamewordl<=7)||((faults==1 || faults==2)&&gamewordl>7))
        {
            System.out.println();
            System.out.println(ConsoleColors.BLUE_BOLD+"----");
            System.out.print("|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    |"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD+"|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|"+ConsoleColors.RESET);
        }
        if((faults==2 && gamewordl<=7)||((faults==3 || faults==4)&&gamewordl>7))
        {
            System.out.println();
            System.out.println(ConsoleColors.BLUE_BOLD+"----");
            System.out.print("|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    |"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    o"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD+"|");
            System.out.println("|");
            System.out.println("|"+ConsoleColors.RESET);
        }
        if((faults==3 && gamewordl<=7)||((faults==5 || faults==6)&&gamewordl>7))
        {
            System.out.println();
            System.out.println(ConsoleColors.BLUE_BOLD+"----");
            System.out.print("|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    |"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    o"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"   /"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD+"|");
            System.out.println("|"+ConsoleColors.RESET);
        }
        if((faults==4 && gamewordl<=7)||((faults==7 || faults==8)&&gamewordl>7))
        {
            System.out.println();
            System.out.println(ConsoleColors.BLUE_BOLD+"----");
            System.out.print("|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    |"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    o"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.CYAN+"   /");
            System.out.println("|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD+"|");
            System.out.println("|"+ConsoleColors.RESET);
        }
        if((faults==5 && gamewordl<=7)||((faults==9 || faults==10)&&gamewordl>7))
        {
            System.out.println();
            System.out.println(ConsoleColors.BLUE_BOLD+"----");
            System.out.print("|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    |"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    o"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.CYAN+"   /");
            System.out.print("|");
            System.out.println("\\"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD+"|");
            System.out.println("|"+ConsoleColors.RESET);
        }
        if((faults==6 && gamewordl<=7)||((faults==11 || faults==12)&&gamewordl>7))
        {
            System.out.println();
            System.out.println(ConsoleColors.BLUE_BOLD+"----");
            System.out.print("|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    |"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    o"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.CYAN+"   /");
            System.out.print("|");
            System.out.println("\\"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"   /"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
        }
        if((faults==7 && gamewordl<=7)||((faults==13 || faults==14)&&gamewordl>7))
        {
            System.out.println();
            System.out.println(ConsoleColors.BLUE_BOLD+"----");
            System.out.print("|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    |"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN+"    o"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.CYAN+"   /");
            System.out.print("|");
            System.out.println("\\"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
            System.out.print(ConsoleColors.CYAN+"   /");
            System.out.println(" \\"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD+"|"+ConsoleColors.RESET);
        }
    }
}

 class Hangman
{
    String[] words={"tehran", "pizza", "banana", "new york", "advanced programming", "michael jordan",
            "lionel messi", "apple", "macaroni", "university", "intel", "kitten", "python", "java",
            "data structures", "algorithm", "assembly", "basketball", "hockey", "leader", "javascript",
            "toronto", "united states of america", "psychology", "chemistry", "breaking bad", "physics",
            "abstract classes", "linux kernel", "january", "march", "time travel", "twitter", "instagram",
            "dog breeds", "strawberry", "snow", "game of thrones", "batman", "ronaldo", "soccer",
            "hamburger", "italy", "greece", "albert einstein", "hangman", "clubhouse", "call of duty",
            "science", "theory of languages and automata"};

    static void guid(User user,String gameword,char[] c,int guid,int check)
    {
        c[check]=gameword.charAt((int)(Math.random()*gameword.length()));
        for (int i = 0; i < gameword.length(); i++)
        {
            for (int j = 0; j < check; j++)
            {
                if(c[j]==c[check])
                    c[check]=gameword.charAt((int)(Math.random()*gameword.length()));
            }
        }
        user.Score-=10;
        guid++;
    }
    static void maybelater(char[] c,int check)
    {
        Scanner in=new Scanner(System.in);
        String character;
        System.out.println("PLEASE ENTER YOUR GUESS:");
        character =in.nextLine();//VOROODI MIGIRE
        c[check]=character.charAt(0);
    }
    static void repitation(char[] c,int check)
    {
        int tekrari=0;
        while (tekrari>=0)
        {
            tekrari=0;
            Scanner in=new Scanner(System.in);
            for (int i = 0; i < check; i++)
            {
                if(c[i]==c[check])
                {
                    System.out.println("YOU HAVE ALREADY GUESSED THIS LETTER;PLEASE TRY AGAIN.");
                    System.out.println("PLEASE ENTER YOUR GUESS:");
                    String character =in.nextLine();//VOROODI MIGIRE
                    c[check]=character.charAt(0);
                    tekrari++;
                }
            }
            if(tekrari==0)
                return;
        }
    }
    Hangman(User user)
    {

        String gameword=words[(int)(Math.random()*50)];
        int lines=gameword.length();
        int guid=0;
        if(gameword.length()<=7)
        {
            while(lines>0)
            {
                System.out.print(" _ ");
                lines--;
            }
            System.out.println();
            System.out.println(ConsoleColors.BLUE_BOLD+"----");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|"+ConsoleColors.RESET);
            Scanner in=new Scanner(System.in);
            char[] c=new char[100];
            String character="";
            int check=0;
            int faults=0;
            int win;
            while (faults<7 )
            {
                if(check>0)//horoof hads zade shode ro chap mikone
                {
                    System.out.println("YOU HAVE ALREADY GUESSED THE FOLLOWING LETTERS:");
                    for (int i = 0; i <check ; i++)
                    {
                        System.out.print(c[i]+",");
                    }
                    System.out.println();
                }
                if(guid==0  && user.Score>=10)
                {
                    System.out.println("YOU CAN PAY 10 SCORES AND ONE OF THE MISSING LETTERS WILL BE REVEALED;");
                    System.out.println("1)HELP");
                    System.out.println("2)MAYBE LATER");
                    int answer=in.nextInt();
                    if(answer==1)
                    {
                        guid(user,gameword,c,guid,check);
                    }
                    else
                    {
                        maybelater(c,check);
                    }
                }
                else
                {
                    maybelater(c,check);
                }
                if(check>0)//check mikone tekrari nabashe
                {
                    repitation(c,check);
                }
                int correct=0;
                for (int i = 0; i < gameword.length(); i++)//check mikonim harfe doroste ya na
                {
                    correct=0;
                    if(gameword.charAt(i)==c[check])
                    {
                        correct=1;
                        break;
                    }
                }
                if(correct==0)
                    faults++;
                win=0;
                for (int i = 0; i < gameword.length(); i++)//bakhsh marboot be chap tike namayesh horoof
                {
                    int lettercheck=0;
                    for (char v:c)
                    {
                        if (gameword.charAt(i) == v)
                        {
                            System.out.print(v);
                            lettercheck++;
                        }
                    }
                    if(lettercheck==0)
                    {
                        System.out.print(" - ");
                        win++;
                    }
                }
                check++;
                System.out.println();
                if(faults==0)
                {
                    System.out.println("| "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                            " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+
                            " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+ " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET
                            +" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    System.out.println();
                    System.out.println(ConsoleColors.BLUE_BOLD+"----");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|"+ConsoleColors.RESET);
                }
                if(faults==1)
                {
                    System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                            " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+
                            " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+ " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET
                            +" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    new HangmanPerson(faults,gameword.length());
                }
                if(faults==2)
                {
                    System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                            " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+
                            " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+ " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET
                            +" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    new HangmanPerson(faults,gameword.length());
                }
                if(faults==3)
                {
                    System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                            " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                            +ConsoleColors.RESET+
                            " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+ " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET
                            +" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    new HangmanPerson(faults,gameword.length());
                }
                if(faults==4)
                {
                    System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                            " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                            +ConsoleColors.RESET+
                            " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+ " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET
                            +" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    new HangmanPerson(faults,gameword.length());
                }
                if(faults==5)
                {
                    System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                            " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                            +ConsoleColors.RESET+
                            " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                            +ConsoleColors.RESET+ " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET
                            +" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    new HangmanPerson(faults,gameword.length());
                }
                if(faults==6)
                {
                    System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                            " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                            +ConsoleColors.RESET+
                            " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                            +ConsoleColors.RESET+ " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET
                            +" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    new HangmanPerson(faults,gameword.length());
                }
                if(faults==7)
                {
                    System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                            " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                            +ConsoleColors.RESET+
                            " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                            +ConsoleColors.RESET+ " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET
                            +" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" |");
                    new HangmanPerson(faults,gameword.length());
                    System.out.println("YOU LOST!");
                    System.out.println("THE WORD WAS :"+gameword);
                    return;
                }
                if(win==0)
                {
                    System.out.println("YOU WON!");
                    user.Score+=5;
                    return;
                }
            }
        }
        if(gameword.length()>7)
        {
            while(lines>0)
            {
                System.out.print(" _ ");
                lines--;
            }
            System.out.println();
            System.out.println(ConsoleColors.BLUE_BOLD+"----");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|"+ConsoleColors.RESET);
            Scanner in=new Scanner(System.in);
            char[] c=new char[100];
            String character;
            int check=0;
            int faults=0;
            int win;
            while (faults<14) {
                if (check > 0)//horoof hads zade shode ro chap mikone
                {
                    System.out.println("YOU HAVE ALREADY GUESSED THE FOLLOWING LETTERS:");
                    for (int i = 0; i < check; i++) {
                        System.out.print(c[i] + ",");
                    }
                    System.out.println();
                }
                if (guid == 0 && user.Score >= 10)
                {
                    System.out.println("YOU CAN PAY 10 SCORES AND ONE OF THE MISSING LETTERS WILL BE REVEALED;");
                    System.out.println("1)HELP");
                    System.out.println("2)MAYBE LATER");
                    int answer = in.nextInt();
                    if (answer == 1)
                    {
                        guid(user,gameword,c,guid,check);
                    }
                    if (answer==2)
                    {
                        maybelater(c,check);
                    }
                }
                else
                {
                    maybelater(c,check);
                }
                if (check > 0)//check mikone tekrari nabashe
                {
                    repitation(c,check);
                }
                int correct=0;
                for (int i = 0; i < gameword.length(); i++)//check mikonim harfe doroste ya na
                {
                    correct = 0;
                    if (gameword.charAt(i) == c[check]) {
                        correct = 1;
                        break;
                    }
                }
                if (correct == 0)
                    faults++;
                win = 0;
                for (int i = 0; i < gameword.length(); i++)//bakhsh marboot be chap tike namayesh horoof
                {
                    int lettercheck=0;
                    for (char v:c)
                    {
                        if (gameword.charAt(i) == v)
                        {
                            System.out.print(v);
                            lettercheck++;
                        }
                    }
                    if(lettercheck==0)
                    {
                        System.out.print(" - ");
                        win++;
                    }
                }
                check++;
                System.out.println();
                if(faults==0)
                {
                    System.out.println("| "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                            " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+
                            " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                            +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                            +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                            +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                            " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    System.out.println();
                    System.out.println(ConsoleColors.BLUE_BOLD+"----");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|");
                    System.out.println("|"+ConsoleColors.RESET);
                }
                if (faults == 1 || faults == 2)
                {
                    if(faults==1)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    if(faults==2)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    new HangmanPerson(faults,gameword.length());
                }
                if (faults == 3 || faults == 4) {
                    if(faults==3)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    if(faults==4)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    new HangmanPerson(faults,gameword.length());
                }
                if (faults == 5 || faults == 6) {
                    if(faults==5)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    if(faults==6)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    new HangmanPerson(faults,gameword.length());
                }
                if (faults == 7 || faults == 8) {
                    if(faults==7)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    if(faults==8)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    new HangmanPerson(faults,gameword.length());
                }
                if (faults == 9 || faults == 10) {
                    if(faults==9)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    if(faults==10)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    new HangmanPerson(faults,gameword.length());
                }
                if (faults == 11 || faults == 12) {
                    if(faults==11)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    if(faults==12)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    new HangmanPerson(faults,gameword.length());
                }
                if (faults == 13 || faults == 14) {
                    if(faults==13)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.GREEN+"V"+ConsoleColors.RESET+" |");
                    }
                    if(faults==14)
                    {
                        System.out.println("| "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "
                                +ConsoleColors.RED+"X"+ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"
                                +ConsoleColors.RESET+" | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+
                                " | "+ConsoleColors.RED+"X"+ConsoleColors.RESET+" |");
                    }
                    new HangmanPerson(faults,gameword.length());
                    if(faults==14)
                    {
                        System.out.println("YOU LOST!");
                        System.out.println("THE WORD WAS :"+gameword);
                        return;
                    }
                }
                if (win == 0)
                {
                    System.out.println("YOU WON!");
                    user.Score += 5;
                    return;
                }
            }
        }
    }
}


class SignUpandLogin extends User
{
    public void login(User[] users,int numberOfplaying)
    {
        for (int i = 0; i <=numberOfplaying; i++)
        {
            if(users[i].password.equals(password) && users[i].username.equals(username))
            {
                System.out.println(ConsoleColors.CYAN+"WELCOME BACK,"+users[i].username+"!"+ConsoleColors.RESET);
                new Hangman(users[i]);
                new leaderboard().leaderbord(users,numberOfplaying);
                return;
            }
        }
        System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"THE ACCOUNT DOES NOT EXIST,PLEASE ENTER YOUR ACCOUNT " +
                "INFORMATION AGAIN OR SIGN UP."+ConsoleColors.RESET);
    }
}
class Main
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        System.out.println("MAIN MENU:");
        System.out.println("1)LOGIN OR SIGNUP");
        System.out.println("2)QUIT");
        int play=in.nextInt();
        User[] users=new User[100];
        int numberofplaying=-1;
        while(play==1)
        {
            System.out.println("WELCOME TO HANGMAN GAME");
            System.out.println("1)SIGNUP");
            System.out.println("2)LOGIN");
            int firstinput = in.nextInt();
            if (firstinput == 1)
            {
                numberofplaying++;
                users[numberofplaying]=new User();
                int result = users[numberofplaying].validation(users[numberofplaying].username, users[numberofplaying].password,users,numberofplaying);
                while(result==0)
                {
                    users[numberofplaying]=new User();
                    result = users[numberofplaying].validation(users[numberofplaying].username, users[numberofplaying].password,users,numberofplaying);
                }
                if (result == 1)
                    new Hangman(users[numberofplaying]);
                new leaderboard().leaderbord(users,numberofplaying);
            }
            if (firstinput == 2)//numberOfplaying inja nabayad taghiir kone
            {
                System.out.println("1)START GAME");
                System.out.println("2)SHOW LEADERBOARD");
                int answer=in.nextInt();
                if(answer==1)
                    new SignUpandLogin().login(users,numberofplaying);
                if(answer==2)
                    new leaderboard().leaderbord(users,numberofplaying);
            }
            System.out.println("MAIN MENU:");
            System.out.println("1)LOGIN OR SIGNUP");
            System.out.println("2)QUIT");
            play=in.nextInt();
        }
    }
}
