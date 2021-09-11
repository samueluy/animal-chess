public class Mouse extends Animal {
    private boolean diverMouse;
    /**
     *
     * @param isBlue for which side the Mouse is playing for
     */
    public Mouse(boolean isBlue) {
        super(isBlue);
        setRank(1);
        setSymbol("M"); // temporary

        if (isBlue)
            setImage("assets/mouse1.png");
        else
            setImage("assets/mouse2.png");
    }

    /**
     * Check if the mouse is currently dive or not
     * @return dive status of mouse
     */
    public boolean isDiverMouse(){
        return diverMouse;
    }

    /**
     * Sets the current status of the mouse if dive or not
     * @param diver value to set to the dive status of the mouse
     */
    public void setDiverMouse(boolean diver){
        this.diverMouse = diver;
    }
}
