import javax.swing.*;

public class PieceIcon extends ImageIcon{
    private Animal animalPiece;
    private Special specialPiece;

    PieceIcon(Animal animal){
        super(animal.getImageURL());
        this.animalPiece = animal;
    }

    PieceIcon(Special special){
        super(special.getImageURL()) ;
        this.specialPiece = special;
    }

    public Animal getAnimalPiece() {
        return animalPiece;
    }

    public Special getSpecialPiece() {
        return specialPiece;
    }

}
