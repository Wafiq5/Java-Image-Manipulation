public class LaplacianFilter implements Filter {
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        Pixel[][] newData = new Pixel[data.length][data[0].length];

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {

                //[ A | B | C ]
                //[ D | E | F ]
                //[ G | H | I ]


                //[ 1 | 2 | 1 ]
                //[ 2 | 4 | 2 ]
                //[ 1 | 2 | 1 ]

                Pixel A;
                if (row < data.length - 1 && col > 0) {
                    A = data[row + 1][col - 1];
                } else {
                    A = new Pixel(0, 0, 0);
                }

                Pixel B;
                if (row > 0) {
                    B = data[row - 1][col];
                } else {
                    B = new Pixel(0, 0, 0);
                }

                Pixel C;
                if (row < data.length - 1 && col < data[row].length - 1) {
                    C = data[row + 1][col + 1];
                } else {
                    C = new Pixel(0, 0, 0);
                }

                Pixel D;
                if (col > 0) {
                    D = data[row][col - 1];
                } else {
                    D = new Pixel(0, 0, 0);
                }

                Pixel E = data[row][col];

                Pixel F;
                if (col < data[row].length - 1) {
                    F = data[row][col + 1];
                } else {
                    F = new Pixel(0, 0, 0);
                }

                Pixel G;
                if (row > 0 && col > 0) {
                    G = data[row - 1][col - 1];
                } else {
                    G = new Pixel(0, 0, 0);
                }

                Pixel H;
                if (row < data.length - 1) {
                    H = data[row + 1][col];
                } else {
                    H = new Pixel(0, 0, 0);
                }

                Pixel I;
                if (row > 0 && col < data[row].length - 1) {
                    I = data[row - 1][col + 1];
                } else {
                    I = new Pixel(0, 0, 0);
                }


                int red = (A.getRed() * -1
                        + B.getRed() * -1
                        + C.getRed() * -1
                        + D.getRed() * -1
                        + E.getRed() * 8
                        + F.getRed() * -1
                        + G.getRed() * -1
                        + H.getRed() * -1
                        + I.getRed() * -1);

                int green = (A.getGreen() * -1
                        + B.getGreen() * -1
                        + C.getGreen() * -1
                        + D.getGreen() * -1
                        + E.getGreen() * 8
                        + F.getGreen() * -1
                        + G.getGreen() * -1
                        + H.getGreen() * -1
                        + I.getGreen() * -1);

                int blue = (A.getBlue() * -1
                        + B.getBlue() * -1
                        + C.getBlue() * -1
                        + D.getBlue() * -1
                        + E.getBlue() * 8
                        + F.getBlue() * -1
                        + G.getBlue() * -1
                        + H.getBlue() * -1
                        + I.getBlue() * -1);


                if(red > 255){
                    red = 255;
                } else if (red < 0) {
                    red = 0;
                }

                if(green > 255){
                    green = 255;
                } else if (green < 0) {
                    green = 0;
                }

                if(blue > 255){
                    blue = 255;
                } else if (blue < 0) {
                    blue = 0;
                }

                newData[row][col] = new Pixel(red, green, blue);
            }
        }
        pi.setData(newData);
    }
}