/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun transformToChesseBoard(board:Array<IntArray>):Int
{
    val len:Int = board.size
    /*for(i in board.indices){
        var j=0
        while(j<board[i].size){
            if((board[0][0] >0) xor (board[0][j]>0) xor (board[i][0]>0) xor (board[i][j]>0)) return -1;
        }
    }*/
    var rowSum:Int =0;
    var colSum:Int=0;
    var rowSwap:Int=0;
    var colSwap:Int  = 0;
    for(i in board.indices)
    {
        rowSum += board[i][0];
        colSum += board[0][i];
        rowSwap += if(board[i][0] == i % 2)1 else 0;
        colSwap += if(board[0][i] == i % 2)1 else 0;
    }
    if((rowSum != len/2) && (rowSum !=(len+1)/2)) return -1;
    if((colSum != len/2) && (colSum != (len + 1)/2))return -1;
    if(len % 2 == 1)
    {
        if(colSwap % 2 ==0) {colSwap = len - colSwap;}
        if(rowSwap % 2 ==0) rowSwap = len - rowSwap;
    }
    else
    {
        colSwap = minOf(colSwap, len - colSwap);
        rowSwap = minOf(rowSwap, len - rowSwap);
    }

    return (rowSwap + colSwap)/2;
}

fun main()
{

    val matrix: Array<IntArray> = arrayOf(
    intArrayOf(0, 1, 1,0),
    intArrayOf(0, 1, 1,0),
    intArrayOf(1,0,0, 1),
    intArrayOf(1,0,0, 1)
)
val steps = transformToChesseBoard(matrix)

print(steps)
}
