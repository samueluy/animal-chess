import javax.swing.*;

/**
 * This class will represent either an Animal or Special object inside a JButton
 */
public class PieceIcon extends ImageIcon {
    private Animal animalPiece;
    private Special specialPiece;

    /**
     * PieceIcon as an Animal piece
     * @param animal Animal piece
     */
    PieceIcon(Animal animal) {
        super(animal.getImageURL());
        this.animalPiece = animal;
    }

    /**
     * PieceIcon as a Special piece
     * @param special Special piece
     */
    PieceIcon(Special special) {
        super(special.getImageURL());
        this.specialPiece = special;
    }
}
