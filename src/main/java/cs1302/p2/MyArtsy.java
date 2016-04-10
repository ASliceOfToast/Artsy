package main.java.cs1302.p2;

import main.java.cs1302.effects.Artsy;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class MyArtsy implements Artsy {

    @Override
    public Image doCheckers(Image src1, Image src2, int size) {
    	int width = (int) src1.getWidth();
		int height = (int) src1.getHeight();
		
		WritableImage ret = new WritableImage(width, height);
		PixelReader pr1 = src1.getPixelReader();
		PixelReader pr2 = src2.getPixelReader();
		PixelWriter pw = ret.getPixelWriter();
		
		for(int x=0;x<width;++x){
			for (int y=0;y<height;++y){
				if(((x/size)+(y/size))%2==0){
					pw.setArgb(x, y, pr1.getArgb(x, y));
				}else
					pw.setArgb(x, y, pr2.getArgb(x, y));
			}//for loop
		}//for loop
		
	return ret;
    } // doCheckers

    @Override
    public Image doHorizontalStripes(Image src1, Image src2, int size) {
    	int width = (int) src1.getWidth();
    	int height = (int) src1.getHeight();
    	
    	WritableImage ret = new WritableImage(width, height);
    	PixelReader pr1 = src1.getPixelReader();
    	PixelReader pr2 = src2.getPixelReader();
    	PixelWriter pw = ret.getPixelWriter();
    	
    	for(int x=0;x<width;++x){
    		for(int y=0;y<height;++y){
    			if((y/height)%2==0){
    				pw.setArgb(x, y, pr1.getArgb(x, y));
    			}else
    				pw.setArgb(x, y, pr2.getArgb(x, y));
    		}
    	}
    	
	return ret;
    } // doHorizontalStripes

    @Override
    public Image doRotate(Image src, double degrees) {
			int width = (int) src.getWidth();
			int height = (int) src.getHeight();

			WritableImage ret = new WritableImage(width, height);
			PixelReader pr = src.getPixelReader();
			PixelWriter pw = ret.getPixelWriter();

			for(int x=0;x<width;++x){
				for (int y=0;y<height;++y){
					int xx = (int)(x*Math.cos(Math.toRadians(degrees))-y*Math.sin(Math.toRadians(degrees)));
					int yy = (int)(x*Math.sin(Math.toRadians(degrees))+y*Math.cos(Math.toRadians(degrees)));
					if(xx>=0&&xx<=300&&yy>=0&&yy<=300){
						pw.setArgb(xx, yy, pr.getArgb(x,y));
					}
				}
			}
			

	return ret;
    } // doRotate

    @Override
    public Image doVerticalStripes(Image src1, Image src2, int size) {
    	int width = (int) src1.getWidth();
    	int height = (int) src1.getHeight();
    	
    	WritableImage ret = new WritableImage(width, height);
    	PixelReader pr1 = src1.getPixelReader();
    	PixelReader pr2 = src2.getPixelReader();
    	PixelWriter pw = ret.getPixelWriter();
    	
    	for(int x=0;x<width;++x){
    		for(int y=0;y<height;++y){
    			if((x/height)%2==0){
    				pw.setArgb(x, y, pr1.getArgb(x, y));
    			}else
    				pw.setArgb(x, y, pr2.getArgb(x, y));
    		}
    	}
    	
	return ret;
    } // doVerticalStripes

} // MyArtsy
