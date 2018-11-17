package minesweeper;

import java.util.Scanner;

public class MinesWeeper {

    private Patch bord;
    Scanner s;
    score Score;

    public MinesWeeper() {
        s = new Scanner(System.in);
        Score = new score();
        System.out.println(Score);
        System.out.println("If you want to edit the scores press 1 .. \nIf you want to exit editing the scores and continue the game press 0 ..");
        int choice = s.nextInt();
        if(choice==1)
        {
            do
            {
            Score.edit();
            System.out.println(Score);
                System.out.println("0 to exit\n1 to continue\n");
            choice = s.nextInt();
            }while(choice!=0);
        }
        bord = new Patch();


        
    }
    
    
    boolean TheWinner(){
       
        int counter = 0;
        for(int i= 0; i<bord.getBoardSize();i++)
        {
            for(int j=0;j<bord.getBoardSize();j++)
            {
                char ch = bord.grid[i][j].getPrint();
                
               /* if(ch!='o')
                {
                    if((ch=='p' && !b.grid[i][j].isMine) || ch!='p')
                        counter++;
                }*/
               //
                if(ch!='o' && ch!='p')
                {
                   counter++;
                }
            }
        }
        
        
        if((counter + bord.getNumberOfMines())==bord.getBoardSize()*bord.getBoardSize())
        {
            System.out.println("win!!!");
            return true;
        }
            
        return false;
        
    }

    void PlayChoices() {
        
        System.out.println("Single player press 1.. ");
        System.out.println("Multi player press 2.. ");
        System.out.println("play against the computer press 3.. ");
        
        int choice = s.nextInt();
        
        switch(choice){
            
            case 1:
                player p  = new PersonPlayer();
                do{
                    if(p.Score.getTotalScore()<=10)
                    {
                        System.out.println("\nworring: your score is low..\n" + p.Score.getTotalScore());
                    }
                    if(!p.play(bord , Score))
                    {
                        
                        System.out.println("Your score is: " + p.Score.getTotalScore());
                        System.out.println("game over..");
                        break;
                    } else if(TheWinner()){
                        System.out.println("Your score is: " + p.Score.getTotalScore());
                        System.out.println("Congrats!!..");
                        break ;
                    }

                    System.out.println(bord);
                }while(!TheWinner());
                break;
            case 2:
                PersonPlayer p1,p2;
                score ScorePlayer1= new score();
                score ScorePlayer2= new score();
                p1 = new PersonPlayer();
                p2 = new PersonPlayer();
                int i=1;
                do {   
                if(p1.Score.getTotalScore()<=10)
                    {
                        System.out.println("\nworring: player 1 score is low..\n" + p1.Score.getTotalScore());
                    }
                if(p2.Score.getTotalScore()<=10)
                    {
                        System.out.println("\nworring: player 2 score is low..\n" + p2.Score.getTotalScore());
                    }
                
                    System.out.println(bord);
                    if(i%2!=0)
                    {
                        System.out.println("First player's turn:");
                        if(!p1.play(bord,ScorePlayer1)){
                            
                            System.out.println("player 2 wins ......");
                            break;
                        }
                    
                    }
                    else
                    {
                        System.out.println("Second player's turn::");
                        if(!p2.play(bord,ScorePlayer2)){
                            
                            System.out.println("player 1 wins ......");
                            break;
                            
                        }
               
                    }
                    i++;
                    
                } while (!TheWinner());
                
                
                
                break;
            case 3:
                 player Player,computer;
                Player = new PersonPlayer();
                computer = new CpuPlayer();
                score scorePlayer= new score();
                score scoreComputer= new score();
                int j=1;
                do {
                if(Player.Score.getTotalScore()<=10)
                    {
                        System.out.println("\nworring: player 1 score is low..\n" + Player.Score.getTotalScore());
                    }
                if(computer.Score.getTotalScore()<=10)
                    {
                        System.out.println("worring:Computer score is low.." + computer.Score.getTotalScore());
                    }
                    System.out.println(bord);
                    if(j%2!=0)
                    {
                        System.out.println("player turn :");
                        if(!Player.play(bord,scorePlayer)){
                            System.out.println("\nworring: player 1 score is low..\n" + Player.Score.getTotalScore());
                            System.out.println("worring:plater 1 score is low.." + computer.Score.getTotalScore());
                            System.out.println("Computer wins......");
                            break;
                        }
                    
                    
                    }
                    else
                    {
                        System.out.println("Computer turn :");
                        if(!computer.play(bord,scoreComputer)){
                            
                            System.out.println("\nworring: player 1 score is low..\n" + Player.Score.getTotalScore());
                            System.out.println("worring:Computer score is low.." + computer.Score.getTotalScore());
                            System.out.println("Player wins ......");
                            break;
                            
                        }
               
                    }
                    j++;
                    
                } while (!TheWinner());
                
                
                break;
            default:
                break;
        
    };
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MinesWeeper game = new MinesWeeper();
        System.out.println(game.bord.printingTheBordWithMines());
        game.PlayChoices();

    }

}
