public class Computer {
    // Required
    private final String CPU;
    private final String RAM;

    // Optional
    private final String storage;
    private final String graphicsCard;
    private final String keyboard;
    private final String mouse;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.keyboard = builder.keyboard;
        this.mouse = builder.mouse;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage +
               ", GraphicsCard=" + graphicsCard + ", Keyboard=" + keyboard + ", Mouse=" + mouse + "]";
    }

    public static class Builder {
        private final String CPU;
        private final String RAM;

        private String storage;
        private String graphicsCard;
        private String keyboard;
        private String mouse;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder setMouse(String mouse) {
            this.mouse = mouse;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
