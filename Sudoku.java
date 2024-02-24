// sudoku Solver
// Author: Sanika Bhoir
 public class Sudoku
 {


   // isSafe function to check row col appraoch as number is present particular
   //  row and col
     
   public boolean isSafe(char [][] board,int row,int col,int number){
      //  row col
      for(int i=0;i<=board.length;i++){
         if(board[i][col]==(char)(number+'0')){
            return false;
         }
         if(board[row][i]==(char)(number+'0') ){
            return false;
      }
   }


      // grid condition for starting row and col of grid
      //formula is  (r/3)*3 ,(c/3)*3 
      int sr= (row/3) * 3;
      int sc= (col/3) *3;

//  check if number exist in cell or not
    for(int i=sr;i<sr+3;i++){
      for(int j=sc;j<sc+3;j++){
         if(board[i][j]==(char)(number + '0')){
            return false;
         }
      }
    }
    return true;
   }
    // recirusion form  of solving the Sudoku 
    // boolean for valid sudoku ---true ,invalid Sudoku ----false
    public boolean helper(char[][] board,int  row, int col) {
   //   base condition as sudoku is full with numbers
      if(row==board.length){
         return true;
         // borad is full
      }
   //   startin row and col

       int nrow=0;
       int ncol=0;
       if(col!= board.length-1){
         nrow=row;
         ncol=col+1;
       }
       else{
         nrow=row+1;
         ncol= 0;
       }
      //  if number is already present
      
      if(board[row][col]!='.'){
         if(helper(board,nrow,ncol)) 
         {
            return true;
         }
         
      }
      else{
         // then fill cell with number
         for(int i=0;i<=9;i++){
            if(isSafe(board,row,col,i)){
               // typecast integer to character----- (char)(i+'0')
               board[row][col]= (char)(i+'0');
              if(helper(board, nrow, ncol)) {
               return true;
              }
              else{
               board[row][col]='.';
              }
            }
         }
            
      }
return false;


    }
 public void solveSudoku(char[][] board){
    // starting from  cell(0,0)
 helper(board,0,0);
 
}
}