data class MinesweeperBoard(val inputBoard: List<String>) {

    fun withNumbers(): List<String> {

        return inputBoard.indices.map { y ->
            inputBoard[y].indices.map { x ->
                when (inputBoard[y][x]) {
                    ' ' -> getAdjacentMinesAtXY(y, x).let { if (it == 0) " " else "$it" }
                    else -> inputBoard[y][x]
                }
            }.joinToString("")
        }
    }

    private fun getAdjacentMinesAtXY(spaceY: Int, spaceX: Int): Int {

        return (spaceY - 1..spaceY + 1).intersect(inputBoard.indices).map { y ->
            (spaceX - 1..spaceX + 1).intersect(inputBoard[y].indices).map { x ->
                inputBoard[y][x] == '*'
            }.count { it }
        }.sum()
    }
}
