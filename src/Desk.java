
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
            for(int j=0; j<cells[i].length; j++) {
                System.out.print(cells[i][j].getValue());
                if(cells[i][j].getValue()<10)
                    System.out.print("  ");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void swap(int x1, int x2, int y1, int y2){
        int temp;
        temp=cells[x1][x2].getValue();
        cells[x1][x2].setValue(cells[y1][y2].getValue());
        cells[y1][y2].setValue(temp);
    }
    public void shuffle(){
        int [] r = new int [cells.length];

        for(int i=0; i<Puzzle.RANDOM_DEPTH; i++) {
            for(int j=0; j<r.length; j++)
                r[j]=(int)(Math.random()*r.length);
            this.swap(r[0], r[1], r[2], r[3]);
        }
    }
    Desk(){
        for(int i=0; i<cells.length; i++){
            for(int j=0; j<cells[i].length; j++)
                cells[i][j] = new Cell();
    }
}
}

