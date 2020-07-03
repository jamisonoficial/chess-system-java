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
	
	//Corresponde a uma método abstrato responsável por preencher a matriz de possibiliades de movimentos.
	public abstract boolean[][] possibleMoves();
	
	//Apenas retorna o valor da célula na  matriz de possibiliades indicando se é possível ou não mover a peça para este local.
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
