public class NegativeImageFilter implements Filter
{
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                Pixel inverted = new Pixel(255 - data[row][col].getRed(), 255 - data[row][col].getGreen(), 255 - data[row][col].getBlue());
                data[row][col] = inverted;
            }
        }
        pi.setData(data);
    }
}