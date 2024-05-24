package utils;

import functions.ImageOperations;

import java.awt.image.BufferedImage;

public class RgbMaster {
    private BufferedImage image;
    private final int width;
    private final int height;
    private final boolean hastAlphaChannel;
    private final int[] pixels;
    public RgbMaster(BufferedImage image) {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
        hastAlphaChannel = image.getAlphaRaster() != null;
        pixels = new int[width * height];
        image.getRGB(0, 0, width, height, pixels, 0, width);
    }
    public BufferedImage getImage(){
        return image;
    }

    public void changeImage(ImageOperations operations) throws Exception {
        for (int i = 0; i < pixels.length; i++) {
            float[] pixel = ImageUtils.rgbIntToArray(pixels[i]);
            float[] newPixel = operations.execute(pixel);
            pixels[i] = ImageUtils.arrayToRgbInt(newPixel);

        }
        image.setRGB(0, 0, width, height, pixels, 0, width);

    }
}
