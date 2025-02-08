package frame;

public class FrameApp {
    public static FrameSize baseDisplay() {

        // 横
        int maxScreenRow = 16;
        // 縦
        int maxScreenCol = 12;
        int tileSize = createSize();
        int screenWidth = tileSize * maxScreenRow;
        int screenHeight = tileSize * maxScreenCol;

        FrameSize size = new FrameSize(screenWidth, screenHeight);
        return size;
    }

    public static int createSize() {
        int originalTileSize = 16;
        int scale = 3;
        return originalTileSize * scale;
    }
}