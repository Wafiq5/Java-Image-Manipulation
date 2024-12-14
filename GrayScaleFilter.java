public class GrayScaleFilter implements Filter {
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                double grayScaledValue = (data[row][col].getRed() * .3) + (data[row][col].getGreen() * .59) + (data[row][col].getBlue() * .11);
                data[row][col].setRed((int) grayScaledValue);
                data[row][col].setGreen((int) grayScaledValue);
                data[row][col].setBlue((int) grayScaledValue);

            }
        }
        pi.setData(data);
    }
}