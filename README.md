# CSCI 1302 - Artsy Project (cs1302-artsy)

This repository contains the skeleton code for the Art project assigned
to the students in the Spring 2016 CSCI 1302 classes at the 
University of Georgia. 

**Please read the entirety of this file before beginning your project.**

## Due Date

This project is due on SUN 2016-04-10 @ 11:59 PM.

## Academic Honesty

You implicitly agree to Academic Honesty policy as outlined in the course 
syllabus and course website.

In accordance with the notice above, I must caution you **not** to fork this
repository on GitHub if you have an account. Doing so will more than likely make
your copy of the project publicly visible. Please follow the instructions 
contained in the Resources section below in order to do your development on
<code>nike</code>.

## Project Description

![Artsy](http://i.imgur.com/YciJ2sl.png)

Your goal is to implement a Java application that can stitch together multiple images in
a number of "artsy" ways. This project will make use of interfaces and JavaFX 8.
This will require you to lookup things in Javadoc and apply your knowledge of
things like inheritance, polymorphism, and lambda expressions.

Part of software development is being given a goal but not necessarily being 
given instruction on all of the details needed to accomplish that goal. For example,
even though image manipulation hasn't been covered in class, in order to complete this 
project you are going to need to lookup how to load, interact with, and save images in Java.
Also, since this is your first project with JavaFX 8, you will probably need to consult the 
Oracle tutorials and definitely the Java SE 8 JavaDoc for assistance. 

This project is also designed to help you better understand how object communicate
with each other. Since GUI containers can be nested, you need to make sure that
your components and listeners have communication access to objects the need in
order to function correctly. While you can technically write your entire JavaFX-based
GUI application entirely in the <code>start</code> method, this will
make your code messy, hard to read, and result in lots of duplicate code.
Before you write any code, you should plan out your containment heirarchy and
design classes involving inheritance and polymorphism appropriately. Then, when
you go to write the code for your GUI, use the classes you designed, changing
them as needed.

## Project Tasks

Before you submit your project, you need to perform the following tasks:

#### (40 points) Implement the <code>cs1302.effects.Artsy</code> interface in the <code>cs1302.p2.MyArtsy</code> class.

Information about the implementation details can be found in the JavaDoc comments 
for the interface as well as inferred from the images contained elsewhere in this 
document.
 
   * (10 points) The <code>doRotate</code> method is implemented correctly.
   * (10 points) The <code>doCheckers</code> method is implemented correctly.
   * (10 points) The <code>doHorizontalStripes</code> method is implemented correctly.
   * (10 points) The <code>doVerticalStripes</code> method is implemented correctly.

__Note:__ The actual grading rubric will involve testing each of the items 
above in discrete parts so that partial credit can be earned.

#### (60 points) Implement a graphical user interface in JavaFX.

Your GUI should resemble and function like the one described in the 
"User Interface" section of this document. 

   * (20 points) The menu bar works as described in this document.
   * (20 points) The tool bar works as described in this document.
   * (20 points) The image panels work as described in this document. 

__Note:__ The entry point to your program must be in <code>cs1302.p2.Driver</code> class. 
All that means is that the <code>cs1302.p2.Driver</code> class is used to run 
your program. 

__Note:__ Your program should create a single instance of your <code>MyArtsy</code> class.
You should pass around this object as an <code>Artsy</code> object (relying on 
subsumption and polymorphism) so that your code can potentially use another
developer's <code>Artsy</code> implementation.

__Note:__ Your program should not crash. Exceptions and errors should be
handled so that the user experience is not hindered. If an error or
exception cannot be handled, a user should first be notified of error,
then the program should exit.  

__Note:__ The actual grading rubric will involve testing each of the items
above in discrete parts so that partial credit can be earned.
   
#### Update the <code>README.md</code> file.

Update the <code>README.md</code> in your project directory (this file) to 
contain the following information at the top of the file (updating it with 
your own information:

```markdown
# Project Submission

Author: PARTNER NAME 1 (LAST 3 DIGITS OF 810/811 NUMBER HERE)
Author: PARTNER NAME 2 (LAST 3 DIGITS OF 810/811 NUMBER HERE)

[If you did any of the extra credit then please indicate that here.]
```
        
## Extra Credit Project Tasks

You may earn extra credit for each of the tasks listed below:

 1. (5 points extra credit) Konami Code: Make it so that when the user enters 
 <code>↑</code><code>↑</code><code>↓</code><code>↓</code><code>←</code><code>→</code><code>←</code><code>→</code><code>B</code><code>A</code> on the keyboard (with the application in focus), a dialog box appears 
 with a picture of [Grumpy Cat](http://knowyourmeme.com/memes/grumpy-cat). I 
 recommend that you keep your picture of Grumpy Cat in the <code>resources</code> 
 directory.

   __Note:__ In order to receive credit for Extra Credit 1, the grader must be
   able to enter the Konami Code *whenever* a dialog box is not present on the
   screen. It should also be possible to enter the code multiple times while
   the program is being run.

 2. (5 points extra credit) Modify your program so that a user can open files
 from both the local file system and via a URL. When a user chooses to open a 
 file using the File -> Open -> ... menu, he or she is presented an option
 that is functionally similar to the following images:

 ![Local File](http://i.imgur.com/1X06iXA.png)
 ![Remote File](http://i.imgur.com/husPD22.png)

   __Note:__ In order to receive credit for Extra Credit 2, both the visual aspect
   and functional aspect of opening local and remote files needs to be implemented. 

## Working with Images

The are a couple differen classes that you must learn about to work with images at
the pixel level:

 * The [<code>javafx.scene.image.Image</code>](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html)
   class represents graphical images
   and is used for loading images from a specified URL.
   
 * The [<code>javafx.scene.image.WritableImage</code>](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/WritableImage.html)
   class is a subclass of
   <code>Image</code> that represents a custom graphical image that is constructed
   from pixels supplied by the application, and possibly from <code>PixelReader</code>
   objects from any number of sources, including images read from a file or URL.

 * The [<code>javafx.scene.image.PixelReader</code>](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/PixelReader.html)
   interface that defines methods
   for retrieving the pixel data from an <code>Image</code> or other surface
   containing pixels.

 * The [<code>javafx.scene.image.PixelWriter</code>](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/PixelWriter.html)
   interface that defines methods
   for writing the pixel data of a <code>WritableImage</code> or other surface
   containing writable pixels.

You should familiarize yourself with the classes and interfaces mentioned above by
reading their API documention in the Oracle Javadocs.

### Copy an <code>Image</code> Pixel-by-Pixel

In order to help you get more familar with <code>PixelReader</code> and
<code>PixelWriter</code>, here is an example of a method that will return a copy
of an image. It does this by creating a new (initiall blank) <code>WritableImage</code>, using
the readers and writers appropriately in a loop, and then returning that new image.

```java
public Image copyImage(Image src) {

    int width = (int) src.getWidth();
    int height = (int) src.getHeight();

    WritableImage ret = new WritableImage(width, height);
    PixelReader pr = src.getPixelReader();
    PixelWriter pw = ret.getPixelWriter();

    for (int x = 0; x < width; ++x) {
        for (int y = 0; y < height; ++y) {
            pw.setArgb(x, y, pr.getArgb(x, y));
        } // for
    } // for
    
    return ret;
    
} // copyImage
```

### Saving an <code>Image</code>

Saving an <code>Image</code> to a file, in JavaFX, is a little tricky since it
involves using some Swing and AWT code. Here is a code snippet for saving an
image:

```java
Image image = ; // assume non-empty
File file = new File("image.png");
BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
ImageIO.write(bImage, "png", file);
```

__NOTE:__ The code above is just a simple example and will probably need to be
placed in a try-catch block.

Here are the additional classes that are involved:

 * [<code>java.io.File</code>](https://docs.oracle.com/javase/8/docs/api/java/io/File.html)
 * [<code>java.awt.image.BufferedImage</code>](https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html)
 * [<code>javafx.embed.swing.SwingFXUtils</code>](https://docs.oracle.com/javase/8/javafx/api/javafx/embed/swing/SwingFXUtils.html)
 * [<code>javax.imageio.ImageIO</code>](https://docs.oracle.com/javase/8/docs/api/javax/imageio/ImageIO.html)

### Rotation Formula

If you think of an image as a two-dimensional array of pixels (or colors), then
a rotation is simply the repeated application of taking a pixel that originates
in one location an placing it in another, according to a formula. Let <code>(x, y)</code> 
denote a particular pixel. For rotation by an angle θ clockwise about the origin, 
the new location of the pixel is <code>(xx, yy)</code> where <code>xx = x * cos(θ) + y * sin(θ)</code>
and <code>yy = -x * sin(θ) + y * cos(θ)</code>. Special care needs to be taken to
avoid out of bounds errors, since the new location of a pixel may not be within the
rectangular area of the image. It is also worth noting that rotating about the origin
is not always the desired effect.

## Artsy Interface

Here is some detailed information about what the graders expect to see
from your user interface. While your final design does not need to match
the following set of pictures exactly, you need to provide (at a minimum)
the same functionality. Here is what the program should resemble when it
first launches:

![Artsy](http://i.imgur.com/YciJ2sl.png)

There is a menu bar with a File menu. Underneath the menu bar there are
some buttons for performing the various artsy effects. There are also
placeholders for three different images. Above the first two images,
the file names of the images are present. Underneath each image there
are two buttons that perform various effects on that image.

The placeholder image is located in the <code>resources</code> directory
provided in the root of this project.

Here a closer look at the File menu:

![File Menu](http://i.imgur.com/7V90nli.png)

When the user chooses to open an image, a <code>javafx.stage.FileChooser</code> should open
up, allowing the user to browse for an image file, open it, and have that image
display in the appropriate place. When the user chooses to save the result, a
<code>FileChooser</code> should open up, allowing the user to browse for a
location to save the result image. The actual image file should be written to
the file location specified by the user. Also, when the user choose to exit, the
entire application should immediately exit.

After opening Image 1 and Image 2, the program should look something like this
(these sample images are located in the <code>samples</code> directory in the
root of this project):

![Loaded](http://i.imgur.com/JOdTmw8.jpg) 

Here is a before and after shot of clicking on the "rotate" button for Image 1:

![Before Rotate](http://i.imgur.com/ds34jlc.jpg)

As you can see, the user if prompted to enter the angle, in degrees, that the
image should be rotated. If the user cancels then no rotation should be
performed. If the user enters in an invalid input (in this case, not a number),
then a dialog box should appear letting the user know that the input was invalid
and the user should be re-prompted.

![After Rotation](http://i.imgur.com/ozslJvg.jpg)

As you can see, after a valid degree value is provided, Image 1 is rotated.
This effect should be achieved by using your <code>MyArtsy</code> class.

If, at any time, the user clicks on the "reset" button for a particular image,
that image should be reset to what it was before any modifications were made.
For the first two images, this will return them to their original state. For
the result image, this should revert the image back to the default image.

When saving, do not save changes to Image 1 and Image 2 back to their
respective files. The only image that will be saved is the Result image,
if the user chooses to do so.

Here is a before and after shot of the Artsy checkers effect:

![Before Checkers](http://i.imgur.com/sZCsHfJ.jpg)

Just like before, the user is prompted to enter a value. If the user cancels,
no effect should be applied. If the user enters in an invalid input (in this
case, not an integer), then a dialog box should appear letting the user know
that the input was invalid and the user should be re-prompted.

![After Checkers](http://i.imgur.com/CVPrsJ2.jpg)

As you can see, after a valid input is provided, the two images were combined
using the Artsy checkers effect and the result was displayed in the Result
image. This effect should be achieved by using your <code>MyArtsy</code> class.

Here are images for the horizontal stripes and vertical stripes effects:

![Before Vertical Stripes](http://i.imgur.com/OkVQ4xx.jpg)

![After Vertical Stripes](http://i.imgur.com/6OTYDdu.jpg)

![Before Horizontal Stripes](http://i.imgur.com/lbkyCDO.jpg)

![After Horizontal Stripes](http://i.imgur.com/WRAqVDv.jpg)

If a user rotates an image, the rotated version of the image should be used to
produce the Result image when an Artsy effect is applied. Here is an example:

![Rotated and Artsy](http://i.imgur.com/3OIXVY3.jpg)

That pretty much sums it up. If you have any questions, feel free to consult the
instructor or the TAs via Piazza. 

## Suggestions

I would suggest breaking up your interface into multiple classes as needed in 
order to reduce repetition and increase code reuse.
For example, you know that there are three images, each with their own "rotate" 
and "reset" buttons.
Think about creating a separate class that extends one of the existing subclasses of
<code>Pane</code> (e.g., <code>FlowPane</code>), containing
GUI components to display an image, its label, as well as those two buttons. This
class can also contain convenience methods for opening/saving a file, displaying 
the image for that panel. You can also include the action listeners for that 
panel's buttons as inner classes (named or anonymous). That way, you only write 
the code once (instead of three times) and you simply create three different objects
of that panel class to add to your GUI.

## Resources

The files for this project are hosted Github using <code>git</code>. They can be
retrieved by cloning the repository found at <code>git://github.com/mepcotterell-cs1302/cs1302-artsy.git</code>. 
For example, you can issue the following command to clone the repository:

    $ git clone git://github.com/mepcotterell-cs1302/cs1302-artsy.git LastName1-LastName2-p3

As always, I suggest developing directly on <code>nike.cs.uga.edu</code> because
this is where your project will be run and tested. Since <code>git</code> is 
already installed on <code>nike</code>, you can clone the project directly into 
your <code>nike</code> home directory using the command provided above.

If any changes are made to the project description or skeleton code, they will
be announced in class. In order to incorporate such changes into your code, you 
need only do a <code>git pull</code>.

Also, since <code>git</code> is a decentralized version control system, you will
have your own local copy of the repository. This means that you can log your 
changes using commits and even revert to a previous revision if necessary.

## Directory Structure and Packages

The <code>Artsy</code> interface is contained in the <code>cs1302.artsy</code> 
package under the <code>src/main/java/cs1302/artsy</code> directory. The other 
classes of interest for this project should be contained in the 
<code>src/main/java/cs1302/p2</code> directory. 
These classes are in the <code>cs1302.p2</code> package.

## Build System

For this project, we will be using the [Simple Build System (sbt)](http://www.scala-sbt.org/). 
If you clone the project from the GitHub repository then everything you need 
in order to compile and run your project on <code>nike</code> is already included. 
In order to compile your project, you can use the following command:

    $ ./sbt compile

To run your project, use the following command:

    $ ./sbt run

In order to clean your project (remove compiled code), use the following command:

    $ ./sbt clean

## Submission Instructions

You will still be submitting your project via Nike. Make sure your project files
are on <code>nike.cs.uga.edu</code>. Change into the parent directory of your
project directory and let <code>LastName1-LastName2-p3</code> represent the name of your
project directory in the instructions provided below. If you've followed the
instructions provided in this document, then the name of your project directory
is likely <code>LastName1-LastName2-p3</code>. While in your project parent
directory, execute the following command, depending on which section you are in:

### CRN 26245

    $ submit LastName1-LastName2-p3 cs1302a

### CRN 26311

    $ submit LastName1-LastName2-p3 cs1302b

### CRN 36424

    $ submit LastName1-LastName2-p3 cs1302c

It is also a good idea to email a copy to yourself. To do this, simply execute
the following command, replacing the email address with your email address:

    $ tar zcvf LastName1-LastName2-p3.tar.gz LastName1-LastName2-p3
    $ mutt -s "[cs1302] p3" -a LastName1-LastName2-p3.tar.gz -- your@email.com < /dev/null

## Questions

If you have any questions, please post them on Piazza.

## Frequently Asked Questions

 1. What do I do if the <code>sbt</code> command does not execute?

    You probably need to make the file executable. To do this, simply make sure 
    you are in the same directory as <code>sbt</code> and issue the following
    command:

        $ chmod +x sbt

    This command updates the permissions on the file, making it executable for the
    current user.
    

 2. I created a <code>Driver</code> class (a class with a <code>main</code> method), 
    but <code>sbt</code> won't run it when I execute <code>sbt run</code>. How do I
    fix that?

    You should be able to fix the problem by executing the following command:

        $ sbt clean

 3. When I execute the <code>sbt run</code> command on <code>nike</code>, I get 
    a <code>java.awt.HeadlessException</code> that tells me no X11 DISPLAY 
    variable was set, but this program performed an operation which requires it.
    What is going on and how do I fix it?

    This exception is thrown if you are not running an X server on your computer
    or you are not telling your SSH client how to connect to the X server on
    your computer.

    If you are connecting to <code>nike</code> using a Linux or MacOS X machine
    then you probably already have an X server installed. If that is the case
    then you need to login using the following command:

        $ ssh -X username@nike.cs.uga.edu

    If you are using MacOS X and are unable to resolve your problem simply by
    issuing the above command then follow the directions [here](http://tutorialgenius.blogspot.com/2012/03/how-to-enable-x11-forwarding-with-ssh.html).
    After following the steps on that website, try logging into nike using the 
    SSH command above.

    If you are connecting to <code>nike</code> using PuTTY on Windows then you 
    need to download and install Xming. For information about how to setup Xming
    with Putty, please follow the directions [here](http://blog.nth-design.com/2010/05/19/x11-putty-xming/).
    You may skip some of the steps on that website (e.g., the section on 
    downloading and installing PuTTY), however, please read all of the sections
    related to Xming as wells the sections related to configuring PuTTY.\

 4. None of these questions are even close to the question I have. What should I
    do?

    You should post such questions to Piazza.



