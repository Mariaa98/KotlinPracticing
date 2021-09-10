/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun calculateSteps(board:Array<IntArray>):Int
{
    val r:Int = board.size
    val c:Int = board[0].size
    val sol = Array(r) { IntArray(c) }
    sol[r-1][c-1]
    if (board[r-1][c-1]>0) {
        sol[r-1][c-1] = 1
    } else {
        sol[r-1][c-1] = 1-board[r-1][c-1]
    }
    var startingIndex:Int=r-2
    for(i in startingIndex downTo 0 step 1)
    {
        sol[i][c-1]=maxOf(sol[i+1][c-1]-board[i][c-1],1);
    }
    var startCol:Int=c-2
    for(j in startCol downTo 0 step 1)
    {
        sol[r-1][j]=maxOf(sol[r-1][j+1]-board[r-1][j],1);
    }
    for(i in startingIndex downTo 0 step 1)
    {
        for(j in startCol downTo 0 step 1)
        {
            sol[i][j]=maxOf(minOf(sol[i+1][j],sol[i][j+1])-board[i][j],1);
        }
    }
    return sol[0][0]
}

fun main()
{

    val matrix: Array<IntArray> = arrayOf(
    intArrayOf(-2, -3, 3),
    intArrayOf(-5,-10, 1),
    intArrayOf(10,30, -5)
)
val steps = calculateSteps(matrix)

print(steps)
}
