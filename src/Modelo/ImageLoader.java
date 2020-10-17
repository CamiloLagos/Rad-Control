package Modelo;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * Esta clase se encarga de cargar las imagenes en la {@code Application}.
 * 
 * @author juanchovelezpro
 *
 */
public class ImageLoader {

	/**
	 * Carga la imagen.
	 * 
	 * @param ruta La ruta donde se encuentra la imagen.
	 * @return La imagen de tipo {@code Image}.
	 */
	public static Image cargarImagen(String ruta) {

		Image image = null;

		ImageIcon icon = new ImageIcon(ImageLoader.class.getClassLoader().getResource(ruta));

		image = icon.getImage();

		return image;

	}

	/**
	 * Carga una imagen en un objeto {@code BufferedImage}.
	 * 
	 * @param ruta La ruta donde se encuentra la imagen.
	 * @return La imagen de tipo {@code BufferedImage}
	 */
	public static BufferedImage cargarSprites(String ruta) {

		Image image = null;

		ImageIcon icon = new ImageIcon(ImageLoader.class.getClassLoader().getResource(ruta));

		image = icon.getImage();

		// Create a buffered image with transparency
		BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(image, 0, 0, null);
		bGr.dispose();

		// Return the buffered image
		return bimage;

	}

	public static BufferedImage imageToBuffered(Image image) {

		// Create a buffered image with transparency
		BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(image, 0, 0, null);
		bGr.dispose();

		// Return the buffered image
		return bimage;

	}

	public static double getScaleFactor(int original, int target) {

		double scale = 1d;

		scale = (double) target / (double) original;

		return scale;

	}

	public static Image resizeToFit(BufferedImage toResize, Dimension target) {

		Image resized = null;

		double scale = 1d;

		double scaleWidth = getScaleFactor(toResize.getWidth(), (int) target.getWidth());
		double scaleHeight = getScaleFactor(toResize.getHeight(), (int) target.getHeight());

		scale = Math.min(scaleWidth, scaleHeight);

		double scaleFactor = Math.min(1d, scale);

		int scaleWidthDef = (int) Math.round(toResize.getWidth() * scaleFactor);
		int scaleHeightDef = (int) Math.round(toResize.getHeight() * scaleFactor);

		resized = toResize.getScaledInstance(scaleWidthDef, scaleHeightDef, Image.SCALE_SMOOTH);

		return resized;

	}

}
