

class Game {
    int[][] board;
    int size;
    int boxSize;
    
    Game(int size) {
        this.size=size;
        this.boxSize=1;
        while(this.boxSize*this.boxSize<size) {
            this.boxSize++;
        }
        board=new int[size][size];
        generateSudoku();
        removeNumbers();
    }
    
    void generateSudoku() {
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                board[i][j]=(i*boxSize+i/boxSize+j)%size+1;
            }
        }
    }
    
    void removeNumbers() {
        int count=(size*size)/3;
        Random rand=new Random();
        while(count>0) {
            int row=rand.nextInt(size);
            int col=rand.nextInt(size);
            if(board[row][col]!=0) {
                board[row][col]=0;
                count--;
            }
        }
    }
    
    void display() {
        for(int i=0;i<size;i++) {
            System.out.println("-".repeat(size*4));
            for(int j=0;j<size;j++) {
                System.out.print("| ");
                if(board[i][j]==0) {
                    System.out.print("  ");
                } else {
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(size*4));
    }
    
    public static void main(String[] args) {
        int size=Integer.parseInt(args[0]);
        Game game=new Game(size);
        game.display();
    }
}