import java.util.Arrays;

public class Desk {
    Cell [][] cells = new Cell [4][4];


    public void setDeskAsc(){
        for(int i=0; i<cells.length; i++){
            for(int j=0; j<cells[i].length; j++)
                cells[i][j].setValue(i*cells.length+j);
        }
    }
    public void deskPrint(){
        for(int i=0; i<cells.length; i++){
            for(int j=0; j<cells[i].length; j++)
                cells[i][j].printCell();
            System.out.println();
        }
    }

    public void swap(int x1, int x2, int y1, int y2){
        Cell temp;
        temp=cells[x1][x2];
        cells[x1][x2]=cells[y1][y2];
        cells[y1][y2]=temp;
    }
    public void shuffle(){
        int [] r = new int [cells.length];

        for(int i=0; i<Puzzle.RANDOM_DEPTH; i++) {
            for(int j=0; j<r.length; j++)
                r[j]=(int)(Math.random()*r.length);
            this.swap(r[0], r[1], r[2], r[3]);
        }
    }
    public int[] getZeroCoord() {
        int[] coord = new int[2];
        for (int i = 0; i < cells.length; i++)
            for (int j = 0; j < cells[i].length; j++)
                if (cells[i][j].getValue() == 0) {
                    coord[0] = i;
                    coord[1] = j;
                    return coord;
                }
        coord[0]=-1;
        coord[1]=-1;
        return coord;
    }
    public void movePiece (String s){
        int coord[]=getZeroCoord();
        switch (s) {
            case "s":
                if (coord[0] == 0)
                    System.out.println("Can't move piece down");
                else
                    swap(coord[0],coord[1],coord[0]-1, coord[1]);
                break;

            case "w":
                if (coord[0] >= cells.length-1)
                    System.out.println("Can't move piece up");
                else
                    swap(coord[0],coord[1],coord[0]+1, coord[1]);
                break;

            case "d":
                if (coord[1] == 0)
                    System.out.println("Can't move right");
                else
                    swap(coord[0],coord[1],coord[0], coord[1]-1);
                break;

            case "a":
                if (coord[1] >= cells.length-1)
                    System.out.println("Can't move left");
                else
                    swap(coord[0],coord[1],coord[0], coord[1]+1);
                break;
            case"cheat":
                setDeskAsc();
            break;
            default:
                System.out.println("Wrong command");
                break;

        }
    }
   public boolean checkWinPosition(){
        int [] m = new int[cells.length*cells.length];
        int [] win1 = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int [] win2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
        for(int i=0; i<cells.length; i++)
            for(int j=0; j<cells[i].length; j++) {
                m[i*cells.length+j]=cells[i][j].getValue();
            }
        if(Arrays.equals(m,win1)||Arrays.equals(m,win2))
            return true;
        else
            return false;

    }

    Desk(){
        for(int i=0; i<cells.length; i++){
            for(int j=0; j<cells[i].length; j++)
                cells[i][j] = new Cell();
    }
}
}

