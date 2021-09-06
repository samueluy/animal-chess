public class Trap {
        private String symbol;
        private boolean bBlue;
        // private boolean free = true;

        public Trap(boolean bBlue){
                this.bBlue = bBlue;
                setSymbol("+");
        }

        public void setSymbol(String symbol){
                this.symbol = symbol;
        }
}
