package bordergame;

public abstract class Piece {
	
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}
	
	//Corresponde a uma m�todo abstrato respons�vel por preencher a matriz de possibiliades de movimentos.
	public abstract boolean[][] possibleMoves();
	
	//Apenas retorna o valor da c�lula na  matriz de possibiliades indicando se � poss�vel ou n�o mover a pe�a para este local.
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i=0; i < mat.length; i++) {
			for(int j=0; j< mat.length; j++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
}
