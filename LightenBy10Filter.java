public class LightenBy10Filter implements Filter {
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                data[row][col].setRed(data[row][col].getRed()+10);
                data[row][col].setGreen(data[row][col].getGreen()+10);
                data[row][col].setBlue(data[row][col].getBlue()+10);
            }
        }
        pi.setData(data);
    }
}
