package bordergame;

public class Board {
	
	//Só serve para instanciar o número de colunas e o número de linhas do tabuleiro
	private int rows;
	private int columns;
	
	//O tabuleiro é uma matriz com duas dimensões de objetos pieces (peças).
	private Piece[][] pieces;
	
	public Board(int rows, int columns){
		if(rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
		
	}
	
	//
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	//Método que retorna uma posição do tabuleiro em função da linha e da coluna
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//Aloca uma peça em determinado ponto do tabuleiro.
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position "+position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//Remove a peça do tabuleiro
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	//Verifica a existência de deterinada posição no tabuleiro
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >=0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//Verifica se há uma peça no tabuleiro
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
}
