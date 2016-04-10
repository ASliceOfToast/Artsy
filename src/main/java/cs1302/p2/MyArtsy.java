package main.java.cs1302.p2;

import main.java.cs1302.effects.Artsy;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class MyArtsy implements Artsy {

	/*
	 * (non-Javadoc)
	 * @see main.java.cs1302.effects.Artsy#doCheckers(javafx.scene.image.Image, javafx.scene.image.Image, int)
	 */
	
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

    /*
     * (non-Javadoc)
     * @see main.java.cs1302.effects.Artsy#doHorizontalStripes(javafx.scene.image.Image, javafx.scene.image.Image, int)
     */
    @Override
    public Image doHorizontalStripes(Image src1, Image src2, int size) {
    	int width = (int) src1.getWidth();
    	int height = (int) src1.getHeight();
    	
    	WritableImage ret = new WritableImage(width, height);
    	PixelReader pr1 = src1.getPixelReader();
    	PixelReader pr2 = src2.getPixelReader();
    	PixelWriter pw = ret.getPixelWriter();
    	
    	for(int x=0;x<width;++x){
			for (int y=0;y<height;++y){
				if(((y/size))%2==0){
					pw.setArgb(x, y, pr1.getArgb(x, y));
				}else
					pw.setArgb(x, y, pr2.getArgb(x, y));
			}//for loop
		}//for loop
    	
    	/*for(int x=0;x<width;++x){
    		for(int y=0;y<height;++y){
    			if((y/height)%2==0){
    				pw.setArgb(x, y, pr1.getArgb(x, y));
    			}else
    				pw.setArgb(x, y, pr2.getArgb(x, y));
    		}
    	}*/
    	
	return ret;
    } // doHorizontalStripes

   /*
    * (non-Javadoc)
    * @see main.java.cs1302.effects.Artsy#doRotate(javafx.scene.image.Image, double)
    */
   
   @Override
   public Image doRotate(Image src, double degrees) {
	   int width = (int) src.getWidth();
	   int height = (int) src.getHeight();
	
	   WritableImage ret = new WritableImage(width, height);
	   PixelReader pr = src.getPixelReader();
	   PixelWriter pw = ret.getPixelWriter();
	
	   for(int x=0;x<width;++x){
		   for (int y=0;y<height;++y){
			   int xx = (int)((x-(width/2))*Math.cos(Math.toRadians(degrees))-(y-(height/2))*Math.sin(Math.toRadians(degrees))+(width/2));
			   int yy = (int)((y-(height/2))*Math.cos(Math.toRadians(degrees))+(x-(width/2))*Math.sin(Math.toRadians(degrees))+(height/2));
			   if(xx>0&&xx<300&&yy>0&&yy<300){
				   pw.setArgb(xx, yy, pr.getArgb(x,y));
			   }
		   }
	   }
   
	   /*
	    * The underlying code averages all the colors in the 8 directions around every empty spot and sets that pixel to the color
	    * As you would expect from averaging, after an infinite number of iterations, everything devolves into a gray mess.
	    * There isn't really anything to be done about it.
	    */
	   
	   for(int x=0;x<width;++x){
		   for(int y=0;y<height;++y){
			   if(ret.getPixelReader().getArgb(x, y)==0){
				   int counter = 0;
				   double red = 0;
				   double green = 0;
				   double blue = 0;
				   double opacity = 0;
				   
				   if(x-1>0){//left check
					   red+=ret.getPixelReader().getColor(x-1, y).getRed();
					   green+=ret.getPixelReader().getColor(x-1, y).getGreen();
					   blue+=ret.getPixelReader().getColor(x-1, y).getBlue();
					   opacity+=ret.getPixelReader().getColor(x-1, y).getOpacity();
					   counter++;
				   }//left
				   
				   if(x+1<300){//right check
					   red+=ret.getPixelReader().getColor(x+1, y).getRed();
					   green+=ret.getPixelReader().getColor(x+1, y).getGreen();
					   blue+=ret.getPixelReader().getColor(x+1, y).getBlue();
					   opacity+=ret.getPixelReader().getColor(x+1, y).getOpacity();
					   counter++;
				   }//right
				   
				   if(y-1>0){//up check
					   red+=ret.getPixelReader().getColor(x, y-1).getRed();
					   green+=ret.getPixelReader().getColor(x, y-1).getGreen();
					   blue+=ret.getPixelReader().getColor(x, y-1).getBlue();
					   opacity+=ret.getPixelReader().getColor(x, y-1).getOpacity();
					   counter++;
				   }//up
				   
				   if(y+1<300){//down check
					   red+=ret.getPixelReader().getColor(x, y+1).getRed();
					   green+=ret.getPixelReader().getColor(x, y+1).getGreen();
					   blue+=ret.getPixelReader().getColor(x, y+1).getBlue();
					   opacity+=ret.getPixelReader().getColor(x, y+1).getOpacity();
					   counter++;
				   }//down
				   
				   if(y-1>0&&x-1>0){//up and left
					   red+=ret.getPixelReader().getColor(x-1, y-1).getRed();
					   green+=ret.getPixelReader().getColor(x-1, y-1).getGreen();
					   blue+=ret.getPixelReader().getColor(x-1, y-1).getBlue();
					   opacity+=ret.getPixelReader().getColor(x-1, y-1).getOpacity();
					   counter++;
				   }//up and left
				   
				   if(y-1>0&&x+1<300){//up and right
					   red+=ret.getPixelReader().getColor(x+1, y-1).getRed();
					   green+=ret.getPixelReader().getColor(x+1, y-1).getGreen();
					   blue+=ret.getPixelReader().getColor(x+1, y-1).getBlue();
					   opacity+=ret.getPixelReader().getColor(x+1, y-1).getOpacity();
					   counter++;
				   }//up and right
				   
				   if(y+1<300&&x-1>0){//down and left
					   red+=ret.getPixelReader().getColor(x-1, y+1).getRed();
					   green+=ret.getPixelReader().getColor(x-1, y+1).getGreen();
					   blue+=ret.getPixelReader().getColor(x-1, y+1).getBlue();
					   opacity+=ret.getPixelReader().getColor(x-1, y+1).getOpacity();
					   counter++;
				   }//down and left
				   
				   if(y+1>300&&x+1>300){//down and right
					   red+=ret.getPixelReader().getColor(x+1, y+1).getRed();
					   green+=ret.getPixelReader().getColor(x+1, y+1).getGreen();
					   blue+=ret.getPixelReader().getColor(x+1, y+1).getBlue();
					   opacity+=ret.getPixelReader().getColor(x+1, y+1).getOpacity();
					   counter++;
				   }//down and right
				   
				   ret.getPixelWriter().setColor(x,y,Color.color(red/counter, green/counter, blue/counter, opacity/counter));
				   
			   }
		   }
	   }
	   
	   return ret;
   } // doRotate


    
    
    
    /*
     * (non-Javadoc)
     * @see main.java.cs1302.effects.Artsy#doVerticalStripes(javafx.scene.image.Image, javafx.scene.image.Image, int)
     */
    @Override
    public Image doVerticalStripes(Image src1, Image src2, int size) {
    	int width = (int) src1.getWidth();
    	int height = (int) src1.getHeight();
    	
    	WritableImage ret = new WritableImage(width, height);
    	PixelReader pr1 = src1.getPixelReader();
    	PixelReader pr2 = src2.getPixelReader();
    	PixelWriter pw = ret.getPixelWriter();
    	
    	for(int x=0;x<width;++x){
			for (int y=0;y<height;++y){
				if(((x/size))%2==0){
					pw.setArgb(x, y, pr1.getArgb(x, y));
				}else
					pw.setArgb(x, y, pr2.getArgb(x, y));
			}//for loop
		}//for loop
    	
    	/*for(int x=0;x<width;++x){
    		for(int y=0;y<height;++y){
    			if((x/height)%2==0){
    				pw.setArgb(x, y, pr1.getArgb(x, y));
    			}else
    				pw.setArgb(x, y, pr2.getArgb(x, y));
    		}
    	}*/
    	
	return ret;
    } // doVerticalStripes

} // MyArtsy