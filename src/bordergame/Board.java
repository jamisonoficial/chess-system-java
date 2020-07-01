package bordergame;

public class Board {
	
	//S� serve para instanciar o n�mero de colunas e o n�mero de linhas do tabuleiro
	private int rows;
	private int columns;
	
	//O tabuleiro � uma matriz com duas dimens�es de objetos pieces (pe�as).
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
	
	//M�todo que retorna uma posi��o do tabuleiro em fun��o da linha e da coluna
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
	
	//Aloca uma pe�a em determinado ponto do tabuleiro.
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position "+position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	//Remove a pe�a do tabuleiro
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
	
	//Verifica a exist�ncia de deterinada posi��o no tabuleiro
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >=0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//Verifica se h� uma pe�a no tabuleiro
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
	
}
